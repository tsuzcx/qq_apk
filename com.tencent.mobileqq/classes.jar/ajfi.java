import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.SetUserInfoResp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PrivilegeInfo;
import QQService.PushVoteIncreaseInfo;
import QQService.RespAddFace;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespVote;
import QQService.TagInfo;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespSummaryCard;
import SummaryCard.RespVoiceManage;
import SummaryCard.TMedalWallInfo;
import SummaryCard.UserLocaleInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler.1;
import com.tencent.mobileqq.app.CardHandler.2;
import com.tencent.mobileqq.app.CardHandler.4;
import com.tencent.mobileqq.app.CardHandler.5;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.service.lbs.BusinessBuff;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.CommonReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountRsp;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListReq;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListRsp;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareReq;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareRsp;
import com.tencent.pb.profilecard.VaProfileGate.OidbFlagInfo;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoReq;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoRsp;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeInfo;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateReq;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateRsp;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoReq;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.ilive.photo.NowLiveGallary.ReqBody;
import tencent.im.medal.common.MedalInfo;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspPansocialInfo;
import tencent.im.oidb.cmd0x7a8.ReqBody;
import tencent.im.oidb.cmd0x7a8.RspBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.PraiseInfo;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.ReqBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.RspBody;
import tencent.im.oidb.cmd0x922.cmd0x922.PushInfo;
import tencent.im.oidb.cmd0x922.cmd0x922.ReqBody;
import tencent.im.oidb.cmd0x922.cmd0x922.RspBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.ReqBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RspBody;
import tencent.im.oidb.cmd0xac6.MedalReport;
import tencent.im.oidb.cmd0xac6.ReqBody;
import tencent.im.oidb.cmd0xac6.RspBody;
import tencent.im.oidb.cmd0xac6.operate_result;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataRsp;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.ReqBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.RspBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.SetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.SetDataRsp;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.EduHis;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.ReqBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.RspBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.SchoolInfo;
import tencent.im.oidb.cmd0xd8a.ClientInfo;
import tencent.im.oidb.cmd0xd8a.ReqBody;
import tencent.im.oidb.oidb_0xc33.ReqBody;
import tencent.im.oidb.oidb_0xc33.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.storage.wording_storage.WordingCfg;

public class ajfi
  extends ajfb
{
  public static final String a;
  public static final Vector<Integer> a;
  public static final Vector<Integer> b;
  private axvo jdField_a_of_type_Axvo;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  short jdField_a_of_type_Short = 9;
  protected String b;
  short b;
  private String jdField_c_of_type_JavaLangString;
  short jdField_c_of_type_Short = -25007;
  short d = -23461;
  short e = -25008;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public ajfi(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = -25044;
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetKPLInfo success=" + bool1);
      }
      bool4 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + bool1);
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = new oidb_0xa28.RspBody();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = KplCard.parseProto(paramFromServiceMsg, this.jdField_c_of_type_JavaLangString);
        bool2 = bool1;
        bool3 = bool1;
        ((ajjj)this.app.getManager(51)).a(paramToServiceMsg);
        bool2 = bool1;
        bool3 = bool1;
        notifyUI(90, bool1, paramToServiceMsg);
        bool4 = bool1;
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool3 = bool2;
        QLog.d("CardHandler", 2, "handleGetKPLInfo ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + bool3);
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool2 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        bool3 = bool1;
        QLog.d("CardHandler", 2, "handleGetKPLInfo failed:" + paramToServiceMsg.uint32_result.get());
        bool4 = bool1;
      }
    }
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch success=" + bool1);
      }
      bool4 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + bool1);
        }
        if (!bool1) {
          break label1395;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label1395;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label1395;
        }
        bool2 = bool1;
        bool3 = bool1;
        Object localObject = new cmd0x922.RspBody();
        bool2 = bool1;
        bool3 = bool1;
        ((cmd0x922.RspBody)localObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        i = ((cmd0x922.RspBody)localObject).uint32_need_update_flag.get();
        bool2 = bool1;
        bool3 = bool1;
        l1 = ((cmd0x922.RspBody)localObject).uint64_timestamp.get();
        bool2 = bool1;
        bool3 = bool1;
        long l2 = ((cmd0x922.RspBody)localObject).uint32_next_req_time.get();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = this.app.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putLong(this.app.c() + "sign_in_next_get_time", l2 * 1000L).commit();
        bool2 = bool1;
        bool3 = bool1;
        int j = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_type.get();
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch testtype=" + j + ",needUpdate = " + i);
        }
        if (i != 1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_type.get();
        bool2 = bool1;
        bool3 = bool1;
        j = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_red_point.get();
        bool2 = bool1;
        bool3 = bool1;
        int k = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_day.get();
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_prompt.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        paramObject = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_url.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        String str = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_icon_url.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        int m = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_lst_checkin_time.get();
        bool2 = bool1;
        bool3 = bool1;
        int n = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_open_func.get();
        bool2 = bool1;
        bool3 = bool1;
        localObject = new JSONObject();
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("type", i);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("redpoint", j);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("day", k);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("wording", paramToServiceMsg);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("url", paramObject);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("iconUrl", str);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("lastTime", m);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("openfunc", n);
        bool2 = bool1;
        bool3 = bool1;
        localObject = ((JSONObject)localObject).toString();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putString(this.app.c() + "sign_in_info", (String)localObject).putLong("sign_in_time_stamp", l1).commit();
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("DailySignIn", 2, "handleGetSigninRedTouch type=" + i + " redpoint=" + j + " day=" + k + " wording=" + paramToServiceMsg + " url=" + paramObject + " iconUrl=" + str + " lastTime=" + m + " openfunc=" + n);
        }
        bool2 = bool1;
        bool3 = bool1;
        notifyUI(84, bool1, null);
        bool4 = bool1;
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        long l1;
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool3 = bool2;
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch ex", paramToServiceMsg);
        return;
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = new JSONObject(paramToServiceMsg);
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + bool3);
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      if (i == 2)
      {
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = paramFromServiceMsg.getString(this.app.c() + "sign_in_info", "");
        bool2 = bool1;
        bool3 = bool1;
        if (TextUtils.isEmpty(paramToServiceMsg))
        {
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg = new JSONObject();
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg.put("redpoint", 0);
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg.put("openfunc", 0);
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg = paramToServiceMsg.toString();
          bool2 = bool1;
          bool3 = bool1;
          paramFromServiceMsg.edit().putString(this.app.c() + this.app.c() + "sign_in_info", paramToServiceMsg).putLong("sign_in_time_stamp", l1).commit();
        }
        else
        {
          label1395:
          bool4 = bool1;
          bool2 = bool1;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            bool3 = bool1;
            QLog.d("DailySignIn", 2, "handleGetSigninRedTouch failed:" + paramToServiceMsg.uint32_result.get());
            bool4 = bool1;
          }
        }
      }
    }
  }
  
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    short[] arrayOfShort = paramToServiceMsg.extraData.getShortArray("switch_id_array");
    boolean bool1 = false;
    int i1 = -1;
    Object localObject3 = null;
    Object localObject2 = null;
    ByteBuffer localByteBuffer = null;
    paramToServiceMsg = localByteBuffer;
    int k = i1;
    Object localObject1 = localObject3;
    int m = i1;
    int n = i1;
    for (;;)
    {
      boolean bool2;
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = localByteBuffer;
          k = i1;
          if (paramObject != null)
          {
            localObject1 = localObject3;
            m = i1;
            n = i1;
            paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
            localObject1 = localObject3;
            m = i1;
            n = i1;
            k = paramToServiceMsg.uint32_result.get();
          }
        }
        if ((k != 0) || (arrayOfShort == null)) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer.getInt();
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer.get();
        localObject1 = localObject3;
        m = k;
        n = k;
        i = localByteBuffer.getShort();
        i1 = 0;
        paramToServiceMsg = localObject2;
        localObject1 = paramToServiceMsg;
        m = k;
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
      }
      catch (Exception paramObject)
      {
        int i;
        k = m;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          n = k;
          QLog.d("CommonSwitchTag", 2, "handleGetCommonSwitchFromDetailInfo ex", paramObject);
        }
        if (!QLog.isColorLevel()) {
          break label979;
        }
        paramFromServiceMsg = Locale.getDefault();
        if (arrayOfShort != null)
        {
          m = arrayOfShort.length;
          if (paramToServiceMsg != null)
          {
            n = paramToServiceMsg.size();
            QLog.d("CommonSwitchTag", 2, String.format(paramFromServiceMsg, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
            paramFromServiceMsg = paramToServiceMsg;
            bool2 = bool1;
          }
        }
        else
        {
          m = 0;
          continue;
        }
        n = 0;
        continue;
      }
      finally
      {
        paramFromServiceMsg = null;
        if (QLog.isColorLevel())
        {
          paramObject = Locale.getDefault();
          if (arrayOfShort == null) {
            break label956;
          }
          k = arrayOfShort.length;
          if (paramFromServiceMsg == null) {
            break label962;
          }
          m = paramFromServiceMsg.size();
          QLog.d("CommonSwitchTag", 2, String.format(paramObject, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m) }));
        }
      }
      try
      {
        if (localByteBuffer.hasRemaining())
        {
          int i2 = i1 + 1;
          if (i1 < i)
          {
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            short s = localByteBuffer.getShort();
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            int j = localByteBuffer.getShort();
            int i3 = 0;
            i1 = 0;
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            if (i1 < arrayOfShort.length)
            {
              if (s != arrayOfShort[i1]) {
                break label996;
              }
              i3 = 1;
              break label996;
            }
            if ((i3 != 0) && (j == 2))
            {
              localObject1 = paramToServiceMsg;
              m = k;
              paramFromServiceMsg = paramToServiceMsg;
              n = k;
              j = localByteBuffer.getShort();
              paramObject = paramToServiceMsg;
              if (paramToServiceMsg == null)
              {
                localObject1 = paramToServiceMsg;
                m = k;
                paramFromServiceMsg = paramToServiceMsg;
                n = k;
                paramObject = new HashMap();
              }
              localObject1 = paramObject;
              m = k;
              paramFromServiceMsg = paramObject;
              n = k;
              paramObject.put(Short.valueOf(s), Short.valueOf(j));
              i1 = i2;
              paramToServiceMsg = paramObject;
              continue;
            }
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            if (QLog.isColorLevel())
            {
              localObject1 = paramToServiceMsg;
              m = k;
              paramFromServiceMsg = paramToServiceMsg;
              n = k;
              QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleGetCommonSwitchFromDetailInfo unexpected [%d, %d]", new Object[] { Short.valueOf(s), Short.valueOf(j) }));
            }
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            localByteBuffer.position(localByteBuffer.position() + j);
            i1 = i2;
            continue;
          }
        }
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
      }
      finally
      {
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          n = k;
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleGetCommonSwitchFromDetailInfo tlvCount: %d", new Object[] { Short.valueOf(i) }));
        }
        bool1 = true;
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = Locale.getDefault();
          if (arrayOfShort == null) {
            continue;
          }
          m = arrayOfShort.length;
          if (paramToServiceMsg == null) {
            continue;
          }
          n = paramToServiceMsg.size();
          QLog.d("CommonSwitchTag", 2, String.format(paramFromServiceMsg, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
          bool2 = bool1;
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      catch (Exception paramObject)
      {
        bool1 = true;
        continue;
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        continue;
      }
      notifyUI(85, bool2, new Object[] { arrayOfShort, paramFromServiceMsg });
      return;
      m = 0;
      continue;
      n = 0;
      continue;
      label956:
      k = 0;
      continue;
      label962:
      m = 0;
      continue;
      label979:
      label988:
      paramToServiceMsg = null;
      bool1 = false;
      continue;
      label996:
      i1 += 1;
    }
  }
  
  private void D()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        notifyUI(71, false, new Object[] { "" });
        return;
      }
      String str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        notifyUI(71, false, new Object[] { "" });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall filePath:" + str2);
    }
    ??? = new PhotoWallUploadTask(str2);
    ((PhotoWallUploadTask)???).flowId = ((int)System.currentTimeMillis() / 1000);
    ((PhotoWallUploadTask)???).sRefer = "mqq";
    ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.app.getCurrentAccountUin());
    ((PhotoWallUploadTask)???).vLoginData = atzd.a(this.app);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new ajfj(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = atzd.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    ajfk localajfk = new ajfk(this, Long.parseLong(this.app.getCurrentAccountUin()));
    bfsq localbfsq = new bfsq();
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      UploadServiceBuilder.getInstance().init(this.app.getApp().getApplicationContext(), localajfk, null, null, localbfsq, localbfsq);
    }
    UploadServiceBuilder.getInstance().upload((AbstractUploadTask)???);
  }
  
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    short s1 = paramToServiceMsg.extraData.getShort("switch_id");
    short s2 = paramToServiceMsg.extraData.getShort("switch_value");
    boolean bool2 = false;
    int j = -1;
    int k = j;
    int i = j;
    int m = j;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        k = j;
        if (paramObject == null) {
          continue;
        }
        i = j;
        m = j;
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = j;
        m = j;
        j = paramToServiceMsg.uint32_result.get();
        k = j;
        if (j != 0) {
          continue;
        }
        k = j;
        i = j;
        m = j;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        k = j;
        i = j;
        m = j;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        i = j;
        m = j;
        n = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (n >= 0) {
          continue;
        }
        l = n + 4294967296L;
        i = j;
        m = j;
        bool1 = String.valueOf(l).equals(this.app.getCurrentAccountUin());
        if (!bool1) {
          continue;
        }
        bool1 = true;
        i = j;
        if (!QLog.isColorLevel()) {
          break label651;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(s2) }));
        j = i;
      }
      catch (Exception paramToServiceMsg)
      {
        int n;
        long l;
        m = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        m = i;
        QLog.d("CommonSwitchTag", 2, "handleSetCommonSwitchFromDetailInfo ex", paramToServiceMsg);
        j = i;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(s2) }));
        j = i;
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(s2) }));
      }
      if (s1 == -23204)
      {
        ((afgd)this.mApp.getManager(295)).b(s2);
        ((ajls)this.app.getManager(159)).b();
        notifyUI(112, bool1, new Object[] { Integer.valueOf(j), Integer.valueOf(s2) });
        return;
        l = n;
        continue;
        k = j;
        i = j;
        m = j;
        if (QLog.isColorLevel())
        {
          i = j;
          m = j;
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo invalidate account info [dwUin: %d, lUin: %d, account: %s]", new Object[] { Integer.valueOf(n), Long.valueOf(l), this.app.getCurrentAccountUin() }));
          k = j;
        }
        i = k;
        bool1 = false;
      }
      else
      {
        notifyUI(86, bool1, new Object[] { Short.valueOf(s1), Short.valueOf(s2) });
        return;
        label651:
        j = i;
      }
    }
  }
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = true;
    boolean bool3 = true;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label515;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label515:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool1;
        bool5 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool4 = bool1;
        bool5 = bool1;
        if (QLog.isColorLevel())
        {
          bool4 = bool1;
          bool5 = bool1;
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool1);
        }
        bool2 = bool1;
        if (!bool1) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool8;
        bool4 = bool1;
        bool5 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
        {
          bool4 = bool1;
          bool5 = bool1;
          int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_notify_on_like_ranking_list_flag.get();
          bool1 = bool7;
          if (i == 0) {
            bool1 = true;
          }
          bool2 = true;
          bool3 = bool1;
        }
        bool1 = bool3;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool2);
          bool5 = bool2;
          bool1 = bool3;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList ex", paramToServiceMsg);
          }
          bool1 = bool6;
          bool5 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool4);
          bool1 = bool6;
          bool5 = bool4;
          continue;
        }
        finally
        {
          bool5 = bool4;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool5);
      }
      notifyUI(79, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  /* Error */
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +419 -> 426
    //   10: aload_3
    //   11: ifnull +415 -> 426
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 607
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 609
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 51
    //   57: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 167	ajjj
    //   63: astore_1
    //   64: aload_1
    //   65: aload_0
    //   66: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   75: astore_2
    //   76: iload 6
    //   78: istore 9
    //   80: iload 6
    //   82: ifeq +636 -> 718
    //   85: iload 6
    //   87: istore 7
    //   89: iload 6
    //   91: istore 8
    //   93: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 110	[B
    //   104: checkcast 110	[B
    //   107: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +317 -> 432
    //   118: iload 6
    //   120: istore 7
    //   122: iload 6
    //   124: istore 8
    //   126: aload_3
    //   127: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +299 -> 432
    //   136: iconst_1
    //   137: istore 6
    //   139: iload 6
    //   141: istore 7
    //   143: iload 6
    //   145: istore 8
    //   147: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +39 -> 189
    //   153: iload 6
    //   155: istore 7
    //   157: iload 6
    //   159: istore 8
    //   161: ldc_w 607
    //   164: iconst_2
    //   165: new 20	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 614
    //   175: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 6
    //   180: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload 6
    //   191: istore 9
    //   193: iload 6
    //   195: ifeq +523 -> 718
    //   198: iload 6
    //   200: istore 7
    //   202: iload 6
    //   204: istore 8
    //   206: iload 6
    //   208: istore 9
    //   210: aload_3
    //   211: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   217: ifeq +501 -> 718
    //   220: iload 6
    //   222: istore 7
    //   224: iload 6
    //   226: istore 8
    //   228: iload 6
    //   230: istore 9
    //   232: aload_3
    //   233: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +479 -> 718
    //   242: iload 6
    //   244: istore 7
    //   246: iload 6
    //   248: istore 8
    //   250: aload_3
    //   251: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: astore_3
    //   264: iload 6
    //   266: istore 7
    //   268: iload 6
    //   270: istore 8
    //   272: aload_3
    //   273: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   276: pop
    //   277: iload 6
    //   279: istore 7
    //   281: iload 6
    //   283: istore 8
    //   285: aload_3
    //   286: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   289: pop
    //   290: iload 6
    //   292: istore 7
    //   294: iload 6
    //   296: istore 8
    //   298: iload 6
    //   300: istore 9
    //   302: aload_3
    //   303: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 617	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +405 -> 718
    //   316: iload 6
    //   318: istore 7
    //   320: iload 6
    //   322: istore 8
    //   324: aload_3
    //   325: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   328: istore 4
    //   330: iload 6
    //   332: istore 7
    //   334: iload 6
    //   336: istore 8
    //   338: aload_0
    //   339: getfield 60	ajfi:jdField_b_of_type_Short	S
    //   342: istore 5
    //   344: iload 4
    //   346: iload 5
    //   348: if_icmpeq +90 -> 438
    //   351: iload 10
    //   353: istore 7
    //   355: iload 7
    //   357: istore 8
    //   359: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 607
    //   368: iconst_2
    //   369: new 20	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 614
    //   379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 7
    //   384: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 619
    //   390: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   397: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 7
    //   408: istore 8
    //   410: aload_0
    //   411: bipush 44
    //   413: iload 8
    //   415: aload_2
    //   416: getfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   419: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   422: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   425: return
    //   426: iconst_0
    //   427: istore 6
    //   429: goto -412 -> 17
    //   432: iconst_0
    //   433: istore 6
    //   435: goto -296 -> 139
    //   438: iload 6
    //   440: istore 7
    //   442: iload 6
    //   444: istore 8
    //   446: aload_3
    //   447: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   450: istore 4
    //   452: iload 10
    //   454: istore 7
    //   456: iload 4
    //   458: iconst_2
    //   459: if_icmpne -104 -> 355
    //   462: iload 6
    //   464: istore 7
    //   466: iload 6
    //   468: istore 8
    //   470: iload 4
    //   472: newarray byte
    //   474: astore 11
    //   476: iload 6
    //   478: istore 7
    //   480: iload 6
    //   482: istore 8
    //   484: aload_3
    //   485: aload 11
    //   487: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   490: pop
    //   491: iload 6
    //   493: istore 7
    //   495: iload 6
    //   497: istore 8
    //   499: aload 11
    //   501: iconst_0
    //   502: invokestatic 631	azzz:a	([BI)S
    //   505: ifne +55 -> 560
    //   508: iconst_0
    //   509: istore 9
    //   511: iload 6
    //   513: istore 7
    //   515: iload 6
    //   517: istore 8
    //   519: aload_2
    //   520: iload 9
    //   522: putfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   525: iload 6
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: aload_3
    //   534: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   537: istore 4
    //   539: iload 10
    //   541: istore 7
    //   543: iload 4
    //   545: ifne -190 -> 355
    //   548: aload_1
    //   549: aload_2
    //   550: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   553: pop
    //   554: iconst_1
    //   555: istore 7
    //   557: goto -202 -> 355
    //   560: iconst_1
    //   561: istore 9
    //   563: goto -52 -> 511
    //   566: astore_1
    //   567: iload 7
    //   569: istore 6
    //   571: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +14 -> 588
    //   577: ldc_w 607
    //   580: iconst_2
    //   581: ldc_w 636
    //   584: aload_1
    //   585: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 6
    //   590: istore 8
    //   592: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq -185 -> 410
    //   598: ldc_w 607
    //   601: iconst_2
    //   602: new 20	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 614
    //   612: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: iload 6
    //   617: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   620: ldc_w 619
    //   623: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: getfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   630: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   633: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: iload 6
    //   641: istore 8
    //   643: goto -233 -> 410
    //   646: astore_1
    //   647: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +44 -> 694
    //   653: ldc_w 607
    //   656: iconst_2
    //   657: new 20	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 614
    //   667: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload 8
    //   672: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: ldc_w 619
    //   678: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: getfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   685: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload_1
    //   695: athrow
    //   696: astore_1
    //   697: iconst_1
    //   698: istore 8
    //   700: goto -53 -> 647
    //   703: astore_1
    //   704: iload 6
    //   706: istore 8
    //   708: goto -61 -> 647
    //   711: astore_1
    //   712: iconst_1
    //   713: istore 6
    //   715: goto -144 -> 571
    //   718: iload 9
    //   720: istore 7
    //   722: goto -367 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	ajfi
    //   0	725	1	paramToServiceMsg	ToServiceMsg
    //   0	725	2	paramFromServiceMsg	FromServiceMsg
    //   0	725	3	paramObject	Object
    //   328	216	4	i	int
    //   342	7	5	j	int
    //   15	699	6	bool1	boolean
    //   87	634	7	bool2	boolean
    //   91	616	8	bool3	boolean
    //   78	641	9	bool4	boolean
    //   1	539	10	bool5	boolean
    //   474	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	114	566	java/lang/Exception
    //   126	136	566	java/lang/Exception
    //   147	153	566	java/lang/Exception
    //   161	189	566	java/lang/Exception
    //   210	220	566	java/lang/Exception
    //   232	242	566	java/lang/Exception
    //   250	264	566	java/lang/Exception
    //   272	277	566	java/lang/Exception
    //   285	290	566	java/lang/Exception
    //   302	316	566	java/lang/Exception
    //   324	330	566	java/lang/Exception
    //   338	344	566	java/lang/Exception
    //   446	452	566	java/lang/Exception
    //   470	476	566	java/lang/Exception
    //   484	491	566	java/lang/Exception
    //   499	508	566	java/lang/Exception
    //   519	525	566	java/lang/Exception
    //   533	539	566	java/lang/Exception
    //   93	114	646	finally
    //   126	136	646	finally
    //   147	153	646	finally
    //   161	189	646	finally
    //   210	220	646	finally
    //   232	242	646	finally
    //   250	264	646	finally
    //   272	277	646	finally
    //   285	290	646	finally
    //   302	316	646	finally
    //   324	330	646	finally
    //   338	344	646	finally
    //   446	452	646	finally
    //   470	476	646	finally
    //   484	491	646	finally
    //   499	508	646	finally
    //   519	525	646	finally
    //   533	539	646	finally
    //   548	554	696	finally
    //   571	588	703	finally
    //   548	554	711	java/lang/Exception
  }
  
  /* Error */
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +524 -> 528
    //   7: aload_3
    //   8: ifnull +520 -> 528
    //   11: iconst_1
    //   12: istore 6
    //   14: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 607
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 639
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 6
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: bipush 51
    //   62: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   65: checkcast 167	ajjj
    //   68: astore 10
    //   70: aload 10
    //   72: aload_1
    //   73: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   76: astore_2
    //   77: iload 6
    //   79: istore 9
    //   81: iload 6
    //   83: ifeq +800 -> 883
    //   86: iload 6
    //   88: istore 7
    //   90: iload 6
    //   92: istore 8
    //   94: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 110	[B
    //   105: checkcast 110	[B
    //   108: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +418 -> 534
    //   119: iload 6
    //   121: istore 7
    //   123: iload 6
    //   125: istore 8
    //   127: aload_1
    //   128: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +400 -> 534
    //   137: iconst_1
    //   138: istore 6
    //   140: iload 6
    //   142: istore 7
    //   144: iload 6
    //   146: istore 8
    //   148: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 6
    //   156: istore 7
    //   158: iload 6
    //   160: istore 8
    //   162: ldc_w 607
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 641
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 6
    //   181: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 6
    //   192: istore 9
    //   194: iload 6
    //   196: ifeq +687 -> 883
    //   199: iload 6
    //   201: istore 7
    //   203: iload 6
    //   205: istore 8
    //   207: iload 6
    //   209: istore 9
    //   211: aload_1
    //   212: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +665 -> 883
    //   221: iload 6
    //   223: istore 7
    //   225: iload 6
    //   227: istore 8
    //   229: iload 6
    //   231: istore 9
    //   233: aload_1
    //   234: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +643 -> 883
    //   243: iload 6
    //   245: istore 7
    //   247: iload 6
    //   249: istore 8
    //   251: aload_1
    //   252: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_1
    //   265: iload 6
    //   267: istore 7
    //   269: iload 6
    //   271: istore 8
    //   273: aload_1
    //   274: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 6
    //   280: istore 7
    //   282: iload 6
    //   284: istore 8
    //   286: aload_1
    //   287: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 6
    //   293: istore 7
    //   295: iload 6
    //   297: istore 8
    //   299: iload 6
    //   301: istore 9
    //   303: aload_1
    //   304: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 617	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +569 -> 883
    //   317: iload 6
    //   319: istore 7
    //   321: iload 6
    //   323: istore 8
    //   325: aload_1
    //   326: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 6
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: aload_0
    //   340: getfield 62	ajfi:jdField_c_of_type_Short	S
    //   343: istore 5
    //   345: iload 4
    //   347: iload 5
    //   349: if_icmpeq +191 -> 540
    //   352: iconst_0
    //   353: istore 6
    //   355: iload 6
    //   357: istore 7
    //   359: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 607
    //   368: iconst_2
    //   369: new 20	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 641
    //   379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 6
    //   384: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 619
    //   390: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   397: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 6
    //   408: istore 7
    //   410: aload_2
    //   411: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   414: ifeq +438 -> 852
    //   417: aload 10
    //   419: iconst_1
    //   420: putfield 647	ajjj:q	I
    //   423: aload_0
    //   424: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 519	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   430: aload_0
    //   431: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   434: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   437: iconst_0
    //   438: invokevirtual 651	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   441: invokeinterface 218 1 0
    //   446: ldc_w 653
    //   449: aload 10
    //   451: getfield 647	ajjj:q	I
    //   454: invokeinterface 657 3 0
    //   459: invokeinterface 233 1 0
    //   464: pop
    //   465: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +44 -> 512
    //   471: ldc_w 659
    //   474: iconst_2
    //   475: new 20	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 641
    //   485: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload 7
    //   490: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   493: ldc_w 661
    //   496: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_2
    //   500: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   503: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: bipush 72
    //   515: iload 7
    //   517: aload_2
    //   518: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   521: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   524: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   527: return
    //   528: iconst_0
    //   529: istore 6
    //   531: goto -517 -> 14
    //   534: iconst_0
    //   535: istore 6
    //   537: goto -397 -> 140
    //   540: iload 6
    //   542: istore 7
    //   544: iload 6
    //   546: istore 8
    //   548: aload_1
    //   549: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   552: istore 4
    //   554: iload 4
    //   556: iconst_2
    //   557: if_icmpne +159 -> 716
    //   560: iload 6
    //   562: istore 7
    //   564: iload 6
    //   566: istore 8
    //   568: iload 4
    //   570: newarray byte
    //   572: astore_3
    //   573: iload 6
    //   575: istore 7
    //   577: iload 6
    //   579: istore 8
    //   581: aload_1
    //   582: aload_3
    //   583: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   586: pop
    //   587: iload 6
    //   589: istore 7
    //   591: iload 6
    //   593: istore 8
    //   595: aload_3
    //   596: iconst_0
    //   597: invokestatic 631	azzz:a	([BI)S
    //   600: ifne +97 -> 697
    //   603: iconst_0
    //   604: istore 9
    //   606: iload 6
    //   608: istore 7
    //   610: iload 6
    //   612: istore 8
    //   614: aload_2
    //   615: iload 9
    //   617: putfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   620: iload 6
    //   622: istore 7
    //   624: iload 6
    //   626: istore 8
    //   628: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: ifeq +41 -> 672
    //   634: iload 6
    //   636: istore 7
    //   638: iload 6
    //   640: istore 8
    //   642: ldc_w 659
    //   645: iconst_2
    //   646: new 20	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 663
    //   656: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_2
    //   660: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   663: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   666: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: iload 6
    //   674: istore 7
    //   676: iload 6
    //   678: istore 8
    //   680: aload_1
    //   681: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   684: istore 4
    //   686: iload 4
    //   688: ifeq +15 -> 703
    //   691: iconst_0
    //   692: istore 6
    //   694: goto -339 -> 355
    //   697: iconst_1
    //   698: istore 9
    //   700: goto -94 -> 606
    //   703: aload 10
    //   705: aload_2
    //   706: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   709: pop
    //   710: iconst_1
    //   711: istore 6
    //   713: goto -358 -> 355
    //   716: iconst_0
    //   717: istore 6
    //   719: goto -364 -> 355
    //   722: astore_1
    //   723: iload 7
    //   725: istore 6
    //   727: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +14 -> 744
    //   733: ldc_w 607
    //   736: iconst_2
    //   737: ldc_w 665
    //   740: aload_1
    //   741: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: iload 6
    //   746: istore 7
    //   748: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq -341 -> 410
    //   754: ldc_w 607
    //   757: iconst_2
    //   758: new 20	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 641
    //   768: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: iload 6
    //   773: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   776: ldc_w 619
    //   779: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload_2
    //   783: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   786: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   789: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: iload 6
    //   797: istore 7
    //   799: goto -389 -> 410
    //   802: astore_1
    //   803: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +44 -> 850
    //   809: ldc_w 607
    //   812: iconst_2
    //   813: new 20	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 641
    //   823: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: iload 8
    //   828: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   831: ldc_w 619
    //   834: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload_2
    //   838: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   841: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   844: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload_1
    //   851: athrow
    //   852: aload 10
    //   854: iconst_0
    //   855: putfield 647	ajjj:q	I
    //   858: goto -435 -> 423
    //   861: astore_1
    //   862: iconst_1
    //   863: istore 8
    //   865: goto -62 -> 803
    //   868: astore_1
    //   869: iload 6
    //   871: istore 8
    //   873: goto -70 -> 803
    //   876: astore_1
    //   877: iconst_1
    //   878: istore 6
    //   880: goto -153 -> 727
    //   883: iload 9
    //   885: istore 6
    //   887: goto -532 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	ajfi
    //   0	890	1	paramToServiceMsg	ToServiceMsg
    //   0	890	2	paramFromServiceMsg	FromServiceMsg
    //   0	890	3	paramObject	Object
    //   329	358	4	i	int
    //   343	7	5	j	int
    //   12	874	6	bool1	boolean
    //   88	710	7	bool2	boolean
    //   92	780	8	bool3	boolean
    //   79	805	9	bool4	boolean
    //   68	785	10	localajjj	ajjj
    // Exception table:
    //   from	to	target	type
    //   94	115	722	java/lang/Exception
    //   127	137	722	java/lang/Exception
    //   148	154	722	java/lang/Exception
    //   162	190	722	java/lang/Exception
    //   211	221	722	java/lang/Exception
    //   233	243	722	java/lang/Exception
    //   251	265	722	java/lang/Exception
    //   273	278	722	java/lang/Exception
    //   286	291	722	java/lang/Exception
    //   303	317	722	java/lang/Exception
    //   325	331	722	java/lang/Exception
    //   339	345	722	java/lang/Exception
    //   548	554	722	java/lang/Exception
    //   568	573	722	java/lang/Exception
    //   581	587	722	java/lang/Exception
    //   595	603	722	java/lang/Exception
    //   614	620	722	java/lang/Exception
    //   628	634	722	java/lang/Exception
    //   642	672	722	java/lang/Exception
    //   680	686	722	java/lang/Exception
    //   94	115	802	finally
    //   127	137	802	finally
    //   148	154	802	finally
    //   162	190	802	finally
    //   211	221	802	finally
    //   233	243	802	finally
    //   251	265	802	finally
    //   273	278	802	finally
    //   286	291	802	finally
    //   303	317	802	finally
    //   325	331	802	finally
    //   339	345	802	finally
    //   548	554	802	finally
    //   568	573	802	finally
    //   581	587	802	finally
    //   595	603	802	finally
    //   614	620	802	finally
    //   628	634	802	finally
    //   642	672	802	finally
    //   680	686	802	finally
    //   703	710	861	finally
    //   727	744	868	finally
    //   703	710	876	java/lang/Exception
  }
  
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label607;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i >= 0) {
          continue;
        }
        l = i + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (ajjj)this.app.getManager(51);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
        bool2 = bool1;
        bool3 = bool1;
        paramObject.allowPeopleSee = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i;
          long l;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      notifyUI(45, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label607:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +607 -> 620
    //   16: aload_3
    //   17: ifnull +603 -> 620
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 607
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 680
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 5
    //   59: istore 8
    //   61: iload 5
    //   63: ifeq +757 -> 820
    //   66: iload 5
    //   68: istore 6
    //   70: iload 5
    //   72: istore 7
    //   74: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 110	[B
    //   85: checkcast 110	[B
    //   88: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +530 -> 626
    //   99: iload 5
    //   101: istore 6
    //   103: iload 5
    //   105: istore 7
    //   107: aload_2
    //   108: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +512 -> 626
    //   117: iconst_1
    //   118: istore 5
    //   120: iload 5
    //   122: istore 6
    //   124: iload 5
    //   126: istore 7
    //   128: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +39 -> 170
    //   134: iload 5
    //   136: istore 6
    //   138: iload 5
    //   140: istore 7
    //   142: ldc_w 607
    //   145: iconst_2
    //   146: new 20	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 682
    //   156: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 5
    //   161: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 5
    //   172: istore 8
    //   174: iload 5
    //   176: ifeq +644 -> 820
    //   179: iload 5
    //   181: istore 6
    //   183: iload 5
    //   185: istore 7
    //   187: iload 5
    //   189: istore 8
    //   191: aload_2
    //   192: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   198: ifeq +622 -> 820
    //   201: iload 5
    //   203: istore 6
    //   205: iload 5
    //   207: istore 7
    //   209: iload 5
    //   211: istore 8
    //   213: aload_2
    //   214: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +600 -> 820
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: ifge +381 -> 632
    //   254: iload 4
    //   256: i2l
    //   257: ldc2_w 541
    //   260: ladd
    //   261: lstore 12
    //   263: iload 5
    //   265: istore 6
    //   267: iload 5
    //   269: istore 7
    //   271: aload_0
    //   272: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   278: lload 12
    //   280: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +460 -> 746
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_0
    //   298: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: bipush 51
    //   303: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   306: checkcast 167	ajjj
    //   309: astore_2
    //   310: iload 5
    //   312: istore 6
    //   314: iload 5
    //   316: istore 7
    //   318: aload_2
    //   319: aload_0
    //   320: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   326: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   329: astore_3
    //   330: iload 5
    //   332: istore 6
    //   334: iload 5
    //   336: istore 7
    //   338: aload_3
    //   339: aload_1
    //   340: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   343: ldc_w 672
    //   346: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   349: putfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   352: iload 5
    //   354: istore 6
    //   356: iload 5
    //   358: istore 7
    //   360: aload_2
    //   361: aload_3
    //   362: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   365: pop
    //   366: iload 11
    //   368: istore 6
    //   370: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +37 -> 410
    //   376: iload 11
    //   378: istore 6
    //   380: ldc_w 659
    //   383: iconst_2
    //   384: new 20	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 684
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_3
    //   398: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   401: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: iload 11
    //   412: istore 6
    //   414: aload_3
    //   415: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   418: ifeq +222 -> 640
    //   421: iload 11
    //   423: istore 6
    //   425: aload_2
    //   426: iconst_1
    //   427: putfield 647	ajjj:q	I
    //   430: iload 11
    //   432: istore 6
    //   434: aload_0
    //   435: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 519	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   441: aload_0
    //   442: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   448: iconst_0
    //   449: invokevirtual 651	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   452: invokeinterface 218 1 0
    //   457: ldc_w 653
    //   460: aload_2
    //   461: getfield 647	ajjj:q	I
    //   464: invokeinterface 657 3 0
    //   469: invokeinterface 233 1 0
    //   474: pop
    //   475: iload 9
    //   477: istore 5
    //   479: iload 5
    //   481: istore 6
    //   483: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +54 -> 540
    //   489: ldc_w 607
    //   492: iconst_2
    //   493: new 20	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   500: ldc_w 682
    //   503: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: iload 5
    //   508: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   511: ldc_w 619
    //   514: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_1
    //   518: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   521: ldc_w 672
    //   524: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   527: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: iload 5
    //   538: istore 6
    //   540: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +67 -> 610
    //   546: aload_0
    //   547: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   550: bipush 51
    //   552: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   555: checkcast 167	ajjj
    //   558: aload_0
    //   559: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   562: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   565: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   568: astore_1
    //   569: ldc_w 659
    //   572: iconst_2
    //   573: new 20	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 684
    //   583: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_1
    //   587: getfield 644	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   590: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc_w 686
    //   596: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 6
    //   601: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload_0
    //   611: bipush 73
    //   613: iload 6
    //   615: aconst_null
    //   616: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   619: return
    //   620: iconst_0
    //   621: istore 5
    //   623: goto -600 -> 23
    //   626: iconst_0
    //   627: istore 5
    //   629: goto -509 -> 120
    //   632: iload 4
    //   634: i2l
    //   635: lstore 12
    //   637: goto -374 -> 263
    //   640: iload 11
    //   642: istore 6
    //   644: aload_2
    //   645: iconst_0
    //   646: putfield 647	ajjj:q	I
    //   649: goto -219 -> 430
    //   652: astore_2
    //   653: iload 10
    //   655: istore 5
    //   657: iload 5
    //   659: istore 6
    //   661: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   664: ifeq +18 -> 682
    //   667: iload 5
    //   669: istore 6
    //   671: ldc_w 607
    //   674: iconst_2
    //   675: ldc_w 688
    //   678: aload_2
    //   679: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   682: iload 5
    //   684: istore 6
    //   686: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   689: ifeq -149 -> 540
    //   692: ldc_w 607
    //   695: iconst_2
    //   696: new 20	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 682
    //   706: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload 5
    //   711: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   714: ldc_w 619
    //   717: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_1
    //   721: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   724: ldc_w 672
    //   727: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   730: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   733: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: iload 5
    //   741: istore 6
    //   743: goto -203 -> 540
    //   746: iconst_0
    //   747: istore 5
    //   749: goto -270 -> 479
    //   752: astore_2
    //   753: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   756: ifeq +50 -> 806
    //   759: ldc_w 607
    //   762: iconst_2
    //   763: new 20	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   770: ldc_w 682
    //   773: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload 6
    //   778: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   781: ldc_w 619
    //   784: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_1
    //   788: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   791: ldc_w 672
    //   794: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   797: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   800: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: aload_2
    //   807: athrow
    //   808: astore_2
    //   809: goto -56 -> 753
    //   812: astore_2
    //   813: iload 7
    //   815: istore 5
    //   817: goto -160 -> 657
    //   820: iload 8
    //   822: istore 5
    //   824: goto -345 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	827	0	this	ajfi
    //   0	827	1	paramToServiceMsg	ToServiceMsg
    //   0	827	2	paramFromServiceMsg	FromServiceMsg
    //   0	827	3	paramObject	Object
    //   247	386	4	i	int
    //   21	802	5	bool1	boolean
    //   68	709	6	bool2	boolean
    //   72	742	7	bool3	boolean
    //   59	762	8	bool4	boolean
    //   7	469	9	bool5	boolean
    //   1	653	10	bool6	boolean
    //   4	637	11	bool7	boolean
    //   261	375	12	l	long
    // Exception table:
    //   from	to	target	type
    //   370	376	652	java/lang/Exception
    //   380	410	652	java/lang/Exception
    //   414	421	652	java/lang/Exception
    //   425	430	652	java/lang/Exception
    //   434	475	652	java/lang/Exception
    //   644	649	652	java/lang/Exception
    //   74	95	752	finally
    //   107	117	752	finally
    //   128	134	752	finally
    //   142	170	752	finally
    //   191	201	752	finally
    //   213	223	752	finally
    //   231	249	752	finally
    //   271	289	752	finally
    //   297	310	752	finally
    //   318	330	752	finally
    //   338	352	752	finally
    //   360	366	752	finally
    //   370	376	808	finally
    //   380	410	808	finally
    //   414	421	808	finally
    //   425	430	808	finally
    //   434	475	808	finally
    //   644	649	808	finally
    //   661	667	808	finally
    //   671	682	808	finally
    //   74	95	812	java/lang/Exception
    //   107	117	812	java/lang/Exception
    //   128	134	812	java/lang/Exception
    //   142	170	812	java/lang/Exception
    //   191	201	812	java/lang/Exception
    //   213	223	812	java/lang/Exception
    //   231	249	812	java/lang/Exception
    //   271	289	812	java/lang/Exception
    //   297	310	812	java/lang/Exception
    //   318	330	812	java/lang/Exception
    //   338	352	812	java/lang/Exception
    //   360	366	812	java/lang/Exception
  }
  
  /* Error */
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +679 -> 692
    //   16: aload_3
    //   17: ifnull +675 -> 692
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 607
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 690
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 5
    //   59: istore 8
    //   61: iload 5
    //   63: ifeq +821 -> 884
    //   66: iload 5
    //   68: istore 6
    //   70: iload 5
    //   72: istore 7
    //   74: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 110	[B
    //   85: checkcast 110	[B
    //   88: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: iload 5
    //   97: istore 6
    //   99: iload 5
    //   101: istore 7
    //   103: aload_2
    //   104: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: ifne +588 -> 698
    //   113: iconst_1
    //   114: istore 5
    //   116: iload 5
    //   118: istore 6
    //   120: iload 5
    //   122: istore 7
    //   124: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +39 -> 166
    //   130: iload 5
    //   132: istore 6
    //   134: iload 5
    //   136: istore 7
    //   138: ldc_w 607
    //   141: iconst_2
    //   142: new 20	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 692
    //   152: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload 5
    //   157: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   160: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: iload 5
    //   168: istore 8
    //   170: iload 5
    //   172: ifeq +712 -> 884
    //   175: iload 5
    //   177: istore 6
    //   179: iload 5
    //   181: istore 7
    //   183: iload 5
    //   185: istore 8
    //   187: aload_2
    //   188: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   194: ifeq +690 -> 884
    //   197: iload 5
    //   199: istore 6
    //   201: iload 5
    //   203: istore 7
    //   205: iload 5
    //   207: istore 8
    //   209: aload_2
    //   210: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: ifnull +668 -> 884
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: aload_2
    //   228: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   237: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   240: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   243: istore 4
    //   245: iload 4
    //   247: ifge +457 -> 704
    //   250: iload 4
    //   252: i2l
    //   253: ldc2_w 541
    //   256: ladd
    //   257: lstore 13
    //   259: iload 5
    //   261: istore 6
    //   263: iload 5
    //   265: istore 7
    //   267: aload_0
    //   268: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 13
    //   276: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +430 -> 712
    //   285: iload 5
    //   287: istore 6
    //   289: iload 5
    //   291: istore 7
    //   293: aload_0
    //   294: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   297: invokestatic 697	atbe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   300: istore 8
    //   302: iload 5
    //   304: istore 6
    //   306: iload 5
    //   308: istore 7
    //   310: aload_0
    //   311: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: bipush 51
    //   316: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   319: checkcast 167	ajjj
    //   322: astore_3
    //   323: iload 5
    //   325: istore 6
    //   327: iload 5
    //   329: istore 7
    //   331: aload_3
    //   332: aload_0
    //   333: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   336: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   339: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   342: astore_2
    //   343: iload 5
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: aload_2
    //   352: aload_1
    //   353: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   356: ldc_w 672
    //   359: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   362: putfield 700	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   365: iload 5
    //   367: istore 6
    //   369: iload 5
    //   371: istore 7
    //   373: aload_3
    //   374: aload_2
    //   375: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   378: pop
    //   379: iload 5
    //   381: istore 6
    //   383: iload 5
    //   385: istore 7
    //   387: invokestatic 706	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   390: new 20	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 708
    //   400: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: lload 13
    //   405: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: iconst_4
    //   412: invokevirtual 712	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   415: invokeinterface 218 1 0
    //   420: astore_3
    //   421: iload 5
    //   423: istore 6
    //   425: iload 5
    //   427: istore 7
    //   429: aload_3
    //   430: ldc_w 714
    //   433: aload_2
    //   434: getfield 700	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   437: invokeinterface 718 3 0
    //   442: pop
    //   443: iload 5
    //   445: istore 6
    //   447: iload 5
    //   449: istore 7
    //   451: aload_3
    //   452: invokeinterface 233 1 0
    //   457: pop
    //   458: iload 5
    //   460: istore 6
    //   462: iload 5
    //   464: istore 7
    //   466: aload_0
    //   467: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: invokestatic 697	atbe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   473: istore 12
    //   475: iload 8
    //   477: iload 12
    //   479: if_icmpeq +20 -> 499
    //   482: iload 5
    //   484: istore 6
    //   486: iload 5
    //   488: istore 7
    //   490: aload_0
    //   491: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: iload 12
    //   496: invokestatic 721	atbe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   499: iload 9
    //   501: istore 5
    //   503: iload 11
    //   505: istore 6
    //   507: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +41 -> 551
    //   513: iload 11
    //   515: istore 6
    //   517: ldc_w 607
    //   520: iconst_2
    //   521: new 20	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 723
    //   531: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: getfield 700	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   538: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   541: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: iload 9
    //   549: istore 5
    //   551: iload 5
    //   553: istore 6
    //   555: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +54 -> 612
    //   561: ldc_w 607
    //   564: iconst_2
    //   565: new 20	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 692
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 5
    //   580: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   583: ldc_w 725
    //   586: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_1
    //   590: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   593: ldc_w 672
    //   596: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   599: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   602: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: iload 5
    //   610: istore 6
    //   612: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +67 -> 682
    //   618: aload_0
    //   619: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: bipush 51
    //   624: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   627: checkcast 167	ajjj
    //   630: aload_0
    //   631: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   634: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   637: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   640: astore_1
    //   641: ldc_w 607
    //   644: iconst_2
    //   645: new 20	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 727
    //   655: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_1
    //   659: getfield 700	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   662: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 686
    //   668: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: iload 6
    //   673: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   676: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload_0
    //   683: bipush 76
    //   685: iload 6
    //   687: aconst_null
    //   688: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   691: return
    //   692: iconst_0
    //   693: istore 5
    //   695: goto -672 -> 23
    //   698: iconst_0
    //   699: istore 5
    //   701: goto -585 -> 116
    //   704: iload 4
    //   706: i2l
    //   707: lstore 13
    //   709: goto -450 -> 259
    //   712: iconst_0
    //   713: istore 5
    //   715: goto -164 -> 551
    //   718: astore_2
    //   719: iload 6
    //   721: istore 5
    //   723: iload 5
    //   725: istore 6
    //   727: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +18 -> 748
    //   733: iload 5
    //   735: istore 6
    //   737: ldc_w 607
    //   740: iconst_2
    //   741: ldc_w 729
    //   744: aload_2
    //   745: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   748: iload 5
    //   750: istore 6
    //   752: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   755: ifeq -143 -> 612
    //   758: ldc_w 607
    //   761: iconst_2
    //   762: new 20	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   769: ldc_w 692
    //   772: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: iload 5
    //   777: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   780: ldc_w 725
    //   783: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload_1
    //   787: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   790: ldc_w 672
    //   793: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   796: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   799: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: iload 5
    //   807: istore 6
    //   809: goto -197 -> 612
    //   812: astore_2
    //   813: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +50 -> 866
    //   819: ldc_w 607
    //   822: iconst_2
    //   823: new 20	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 692
    //   833: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 7
    //   838: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   841: ldc_w 725
    //   844: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_1
    //   848: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   851: ldc_w 672
    //   854: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   857: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   860: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_2
    //   867: athrow
    //   868: astore_2
    //   869: iload 6
    //   871: istore 7
    //   873: goto -60 -> 813
    //   876: astore_2
    //   877: iload 10
    //   879: istore 5
    //   881: goto -158 -> 723
    //   884: iload 8
    //   886: istore 5
    //   888: goto -337 -> 551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	ajfi
    //   0	891	1	paramToServiceMsg	ToServiceMsg
    //   0	891	2	paramFromServiceMsg	FromServiceMsg
    //   0	891	3	paramObject	Object
    //   243	462	4	i	int
    //   21	866	5	bool1	boolean
    //   68	802	6	bool2	boolean
    //   72	800	7	bool3	boolean
    //   59	826	8	bool4	boolean
    //   7	541	9	bool5	boolean
    //   1	877	10	bool6	boolean
    //   4	510	11	bool7	boolean
    //   473	22	12	bool8	boolean
    //   257	451	13	l	long
    // Exception table:
    //   from	to	target	type
    //   74	95	718	java/lang/Exception
    //   103	113	718	java/lang/Exception
    //   124	130	718	java/lang/Exception
    //   138	166	718	java/lang/Exception
    //   187	197	718	java/lang/Exception
    //   209	219	718	java/lang/Exception
    //   227	245	718	java/lang/Exception
    //   267	285	718	java/lang/Exception
    //   293	302	718	java/lang/Exception
    //   310	323	718	java/lang/Exception
    //   331	343	718	java/lang/Exception
    //   351	365	718	java/lang/Exception
    //   373	379	718	java/lang/Exception
    //   387	421	718	java/lang/Exception
    //   429	443	718	java/lang/Exception
    //   451	458	718	java/lang/Exception
    //   466	475	718	java/lang/Exception
    //   490	499	718	java/lang/Exception
    //   74	95	812	finally
    //   103	113	812	finally
    //   124	130	812	finally
    //   138	166	812	finally
    //   187	197	812	finally
    //   209	219	812	finally
    //   227	245	812	finally
    //   267	285	812	finally
    //   293	302	812	finally
    //   310	323	812	finally
    //   331	343	812	finally
    //   351	365	812	finally
    //   373	379	812	finally
    //   387	421	812	finally
    //   429	443	812	finally
    //   451	458	812	finally
    //   466	475	812	finally
    //   490	499	812	finally
    //   507	513	868	finally
    //   517	547	868	finally
    //   727	733	868	finally
    //   737	748	868	finally
    //   507	513	876	java/lang/Exception
    //   517	547	876	java/lang/Exception
  }
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    ajjj localajjj;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch success=" + bool1);
      }
      paramFromServiceMsg = this.app.c();
      localajjj = (ajjj)this.app.getManager(51);
      paramToServiceMsg = localajjj.c(paramFromServiceMsg);
      bool3 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool4 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool1);
        }
        bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          bool2 = bool1;
          bool4 = bool1;
          if (paramObject.bytes_bodybuffer.has())
          {
            bool3 = bool1;
            bool2 = bool1;
            bool4 = bool1;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              bool2 = bool1;
              bool4 = bool1;
              oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
              bool2 = bool1;
              bool4 = bool1;
              localRspBody.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool2 = bool1;
              bool4 = bool1;
              if (localRspBody.rpt_msg_uin_data.has())
              {
                bool3 = bool1;
                bool2 = bool1;
                bool4 = bool1;
                if (localRspBody.rpt_msg_uin_data.get().size() > 0)
                {
                  bool2 = bool1;
                  bool4 = bool1;
                  boolean bool6 = atbe.a(this.app);
                  bool2 = bool1;
                  bool4 = bool1;
                  if (((oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0)).uint32_req_medalwall_flag.get() == 0) {
                    continue;
                  }
                  bool3 = bool5;
                  bool2 = bool1;
                  bool4 = bool1;
                  paramToServiceMsg.medalSwitchDisable = bool3;
                  bool2 = bool1;
                  bool4 = bool1;
                  localajjj.a(paramToServiceMsg);
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramFromServiceMsg, 4).edit();
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg.putBoolean("medal_switch_disable", paramToServiceMsg.medalSwitchDisable);
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg.commit();
                  bool2 = bool1;
                  bool4 = bool1;
                  bool5 = atbe.a(this.app);
                  bool3 = bool1;
                  if (bool6 != bool5)
                  {
                    bool2 = bool1;
                    bool4 = bool1;
                    atbe.a(this.app, bool5);
                    bool3 = bool1;
                  }
                }
              }
            }
          }
        }
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool3 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
          bool1 = bool3;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch ex", paramFromServiceMsg);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool2 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool4 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool1 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
      }
      notifyUI(77, bool1, Boolean.valueOf(paramToServiceMsg.medalSwitchDisable));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool3 = false;
    }
  }
  
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleGetConnectionsSwitch ");
    }
    paramToServiceMsg = new oidb_0x5eb.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int j = -1;
    if (k == 0)
    {
      int i = j;
      if (paramToServiceMsg.rpt_msg_uin_data.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();
        i = j;
        if (paramToServiceMsg != null)
        {
          i = j;
          if (paramToServiceMsg.size() > 0)
          {
            i = ((oidb_0x5eb.UdcUinData)paramToServiceMsg.get(0)).uint32_rsp_connections_switch_id.get();
            ((afgd)this.mApp.getManager(295)).b(i);
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "handleGetConnectionsSwitch " + i);
            }
          }
        }
      }
      notifyUI(111, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetConnectionsSwitch failed result:" + k);
    }
    notifyUI(111, false, new Object[] { Integer.valueOf(k), Integer.valueOf(-1) });
  }
  
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::handleSendGlobalRingIdRequestResp success=" + bool1);
      }
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool2;
        paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSendGlobalRingIdRequestResp result=" + bool1 + " error=" + paramFromServiceMsg);
        }
        if ((bool1) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.get().size() > 0) && (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.has()))
          {
            int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, new Object[] { "handleSendGlobalRingIdRequestResp: invoked. ", " ringId: ", Integer.valueOf(i) });
            }
            if (i > 0) {
              alrm.a(this.app).b(i);
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg = paramToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSendGlobalRingIdRequestResp ex", paramToServiceMsg);
        return;
      }
      finally {}
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  /* Error */
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +629 -> 636
    //   10: aload_3
    //   11: ifnull +625 -> 636
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 607
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 802
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iload 6
    //   53: istore 9
    //   55: iload 6
    //   57: ifeq +569 -> 626
    //   60: iload 6
    //   62: istore 7
    //   64: iload 6
    //   66: istore 8
    //   68: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   71: dup
    //   72: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   75: aload_3
    //   76: checkcast 110	[B
    //   79: checkcast 110	[B
    //   82: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: astore_1
    //   89: iload 6
    //   91: istore 7
    //   93: iload 6
    //   95: istore 8
    //   97: aload_1
    //   98: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   104: ifne +538 -> 642
    //   107: iconst_1
    //   108: istore 6
    //   110: iload 6
    //   112: istore 7
    //   114: iload 6
    //   116: istore 8
    //   118: aload_1
    //   119: getfield 772	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: astore_2
    //   126: iload 6
    //   128: istore 7
    //   130: iload 6
    //   132: istore 8
    //   134: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +49 -> 186
    //   140: iload 6
    //   142: istore 7
    //   144: iload 6
    //   146: istore 8
    //   148: ldc_w 607
    //   151: iconst_2
    //   152: new 20	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 804
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload 6
    //   167: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 780
    //   173: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 6
    //   188: istore 9
    //   190: iload 6
    //   192: ifeq +434 -> 626
    //   195: iload 6
    //   197: istore 9
    //   199: iload 6
    //   201: istore 7
    //   203: iload 6
    //   205: istore 8
    //   207: aload_1
    //   208: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +412 -> 626
    //   217: iload 6
    //   219: istore 9
    //   221: iload 6
    //   223: istore 7
    //   225: iload 6
    //   227: istore 8
    //   229: aload_1
    //   230: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +390 -> 626
    //   239: iload 6
    //   241: istore 7
    //   243: iload 6
    //   245: istore 8
    //   247: new 585	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   250: dup
    //   251: invokespecial 586	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   254: astore_2
    //   255: iload 6
    //   257: istore 7
    //   259: iload 6
    //   261: istore 8
    //   263: aload_2
    //   264: aload_1
    //   265: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   268: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   271: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   274: invokevirtual 587	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   277: pop
    //   278: iload 6
    //   280: istore 9
    //   282: iload 6
    //   284: istore 7
    //   286: iload 6
    //   288: istore 8
    //   290: aload_2
    //   291: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   294: invokevirtual 735	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   297: ifeq +329 -> 626
    //   300: iload 6
    //   302: istore 9
    //   304: iload 6
    //   306: istore 7
    //   308: iload 6
    //   310: istore 8
    //   312: aload_2
    //   313: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   316: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   319: invokeinterface 741 1 0
    //   324: ifle +302 -> 626
    //   327: iload 6
    //   329: istore 9
    //   331: iload 6
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: aload_2
    //   340: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   343: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   346: iconst_0
    //   347: invokeinterface 743 2 0
    //   352: checkcast 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   355: getfield 807	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   358: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   361: ifeq +265 -> 626
    //   364: iload 6
    //   366: istore 7
    //   368: iload 6
    //   370: istore 8
    //   372: aload_2
    //   373: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   376: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   379: iconst_0
    //   380: invokeinterface 743 2 0
    //   385: checkcast 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   388: getfield 807	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   391: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   394: istore 4
    //   396: iload 6
    //   398: istore 7
    //   400: iload 6
    //   402: istore 8
    //   404: aload_2
    //   405: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   408: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   411: iconst_0
    //   412: invokeinterface 743 2 0
    //   417: checkcast 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   420: getfield 810	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_video_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   423: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   426: istore 5
    //   428: iload 6
    //   430: istore 7
    //   432: iload 6
    //   434: istore 8
    //   436: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +50 -> 489
    //   442: iload 6
    //   444: istore 7
    //   446: iload 6
    //   448: istore 8
    //   450: ldc_w 607
    //   453: iconst_2
    //   454: new 20	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 812
    //   464: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: iload 4
    //   469: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: ldc_w 814
    //   475: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload 5
    //   480: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: iload 4
    //   491: iflt +62 -> 553
    //   494: iload 6
    //   496: istore 7
    //   498: iload 6
    //   500: istore 8
    //   502: aload_0
    //   503: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   506: invokevirtual 815	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   509: astore_1
    //   510: iload 6
    //   512: istore 7
    //   514: iload 6
    //   516: istore 8
    //   518: aload_0
    //   519: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   522: invokevirtual 818	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   525: invokevirtual 821	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   528: astore_2
    //   529: iload 4
    //   531: iconst_1
    //   532: if_icmpeq +116 -> 648
    //   535: iconst_1
    //   536: istore 9
    //   538: iload 6
    //   540: istore 7
    //   542: iload 6
    //   544: istore 8
    //   546: aload_1
    //   547: aload_2
    //   548: iload 9
    //   550: invokestatic 826	ajyy:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   553: iload 6
    //   555: istore 9
    //   557: iload 5
    //   559: iflt +67 -> 626
    //   562: iload 6
    //   564: istore 7
    //   566: iload 6
    //   568: istore 8
    //   570: aload_0
    //   571: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   574: invokevirtual 815	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   577: astore_1
    //   578: iload 6
    //   580: istore 7
    //   582: iload 6
    //   584: istore 8
    //   586: aload_0
    //   587: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   590: invokevirtual 818	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   593: invokevirtual 821	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   596: astore_2
    //   597: iload 5
    //   599: iconst_1
    //   600: if_icmpeq +54 -> 654
    //   603: iload 10
    //   605: istore 9
    //   607: iload 6
    //   609: istore 7
    //   611: iload 6
    //   613: istore 8
    //   615: aload_1
    //   616: aload_2
    //   617: iload 9
    //   619: invokestatic 828	ajyy:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   622: iload 6
    //   624: istore 9
    //   626: aload_0
    //   627: bipush 107
    //   629: iload 9
    //   631: aconst_null
    //   632: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   635: return
    //   636: iconst_0
    //   637: istore 6
    //   639: goto -622 -> 17
    //   642: iconst_0
    //   643: istore 6
    //   645: goto -535 -> 110
    //   648: iconst_0
    //   649: istore 9
    //   651: goto -113 -> 538
    //   654: iconst_0
    //   655: istore 9
    //   657: goto -50 -> 607
    //   660: astore_1
    //   661: iload 7
    //   663: istore 8
    //   665: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +18 -> 686
    //   671: iload 7
    //   673: istore 8
    //   675: ldc_w 607
    //   678: iconst_2
    //   679: ldc_w 830
    //   682: aload_1
    //   683: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload_0
    //   687: bipush 107
    //   689: iload 7
    //   691: aconst_null
    //   692: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   695: return
    //   696: astore_1
    //   697: aload_0
    //   698: bipush 107
    //   700: iload 8
    //   702: aconst_null
    //   703: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   706: aload_1
    //   707: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	ajfi
    //   0	708	1	paramToServiceMsg	ToServiceMsg
    //   0	708	2	paramFromServiceMsg	FromServiceMsg
    //   0	708	3	paramObject	Object
    //   394	139	4	i	int
    //   426	175	5	j	int
    //   15	629	6	bool1	boolean
    //   62	628	7	bool2	boolean
    //   66	635	8	bool3	boolean
    //   53	603	9	bool4	boolean
    //   1	603	10	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   68	89	660	java/lang/Exception
    //   97	107	660	java/lang/Exception
    //   118	126	660	java/lang/Exception
    //   134	140	660	java/lang/Exception
    //   148	186	660	java/lang/Exception
    //   207	217	660	java/lang/Exception
    //   229	239	660	java/lang/Exception
    //   247	255	660	java/lang/Exception
    //   263	278	660	java/lang/Exception
    //   290	300	660	java/lang/Exception
    //   312	327	660	java/lang/Exception
    //   339	364	660	java/lang/Exception
    //   372	396	660	java/lang/Exception
    //   404	428	660	java/lang/Exception
    //   436	442	660	java/lang/Exception
    //   450	489	660	java/lang/Exception
    //   502	510	660	java/lang/Exception
    //   518	529	660	java/lang/Exception
    //   546	553	660	java/lang/Exception
    //   570	578	660	java/lang/Exception
    //   586	597	660	java/lang/Exception
    //   615	622	660	java/lang/Exception
    //   68	89	696	finally
    //   97	107	696	finally
    //   118	126	696	finally
    //   134	140	696	finally
    //   148	186	696	finally
    //   207	217	696	finally
    //   229	239	696	finally
    //   247	255	696	finally
    //   263	278	696	finally
    //   290	300	696	finally
    //   312	327	696	finally
    //   339	364	696	finally
    //   372	396	696	finally
    //   404	428	696	finally
    //   436	442	696	finally
    //   450	489	696	finally
    //   502	510	696	finally
    //   518	529	696	finally
    //   546	553	696	finally
    //   570	578	696	finally
    //   586	597	696	finally
    //   615	622	696	finally
    //   665	671	696	finally
    //   675	686	696	finally
  }
  
  /* Error */
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +493 -> 497
    //   7: aload_3
    //   8: ifnull +489 -> 497
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 607
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 833
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 835
    //   55: ldc_w 327
    //   58: invokevirtual 836	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_1
    //   62: iload 5
    //   64: istore 8
    //   66: iload 5
    //   68: ifeq +406 -> 474
    //   71: iload 5
    //   73: istore 6
    //   75: iload 5
    //   77: istore 7
    //   79: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: aload_3
    //   87: checkcast 110	[B
    //   90: checkcast 110	[B
    //   93: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   96: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   99: astore_2
    //   100: iload 5
    //   102: istore 6
    //   104: iload 5
    //   106: istore 7
    //   108: aload_2
    //   109: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: ifne +388 -> 503
    //   118: iconst_1
    //   119: istore 5
    //   121: iload 5
    //   123: istore 6
    //   125: iload 5
    //   127: istore 7
    //   129: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +39 -> 171
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: ldc_w 607
    //   146: iconst_2
    //   147: new 20	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 838
    //   157: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 5
    //   162: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: iload 5
    //   173: istore 8
    //   175: iload 5
    //   177: ifeq +297 -> 474
    //   180: iload 5
    //   182: istore 8
    //   184: iload 5
    //   186: istore 6
    //   188: iload 5
    //   190: istore 7
    //   192: aload_2
    //   193: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   196: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   199: ifeq +275 -> 474
    //   202: iload 5
    //   204: istore 8
    //   206: iload 5
    //   208: istore 6
    //   210: iload 5
    //   212: istore 7
    //   214: aload_2
    //   215: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   221: ifnull +253 -> 474
    //   224: iload 5
    //   226: istore 6
    //   228: iload 5
    //   230: istore 7
    //   232: new 585	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   235: dup
    //   236: invokespecial 586	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   239: astore_3
    //   240: iload 5
    //   242: istore 6
    //   244: iload 5
    //   246: istore 7
    //   248: aload_3
    //   249: aload_2
    //   250: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokevirtual 587	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   262: pop
    //   263: iload 5
    //   265: istore 8
    //   267: iload 5
    //   269: istore 6
    //   271: iload 5
    //   273: istore 7
    //   275: aload_3
    //   276: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   279: invokevirtual 735	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   282: ifeq +192 -> 474
    //   285: iload 5
    //   287: istore 8
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_3
    //   298: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   301: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   304: invokeinterface 741 1 0
    //   309: ifle +165 -> 474
    //   312: iload 5
    //   314: istore 8
    //   316: iload 5
    //   318: istore 6
    //   320: iload 5
    //   322: istore 7
    //   324: aload_3
    //   325: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   328: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   331: iconst_0
    //   332: invokeinterface 743 2 0
    //   337: checkcast 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   340: getfield 841	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   343: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   346: ifeq +128 -> 474
    //   349: iload 5
    //   351: istore 6
    //   353: iload 5
    //   355: istore 7
    //   357: aload_3
    //   358: getfield 591	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   361: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   364: iconst_0
    //   365: invokeinterface 743 2 0
    //   370: checkcast 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   373: getfield 841	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   376: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   379: istore 4
    //   381: iload 5
    //   383: istore 6
    //   385: iload 5
    //   387: istore 7
    //   389: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +39 -> 431
    //   395: iload 5
    //   397: istore 6
    //   399: iload 5
    //   401: istore 7
    //   403: ldc_w 607
    //   406: iconst_2
    //   407: new 20	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 843
    //   417: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: iload 4
    //   422: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: iload 5
    //   433: istore 8
    //   435: iload 4
    //   437: iflt +37 -> 474
    //   440: iload 5
    //   442: istore 6
    //   444: iload 5
    //   446: istore 7
    //   448: aload_0
    //   449: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   452: invokevirtual 818	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   455: invokevirtual 821	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   458: aconst_null
    //   459: ldc_w 845
    //   462: ldc_w 847
    //   465: iload 4
    //   467: invokestatic 853	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   470: iload 5
    //   472: istore 8
    //   474: aload_0
    //   475: bipush 98
    //   477: iload 8
    //   479: iconst_2
    //   480: anewarray 254	java/lang/String
    //   483: dup
    //   484: iconst_0
    //   485: ldc_w 327
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: aload_1
    //   492: aastore
    //   493: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   496: return
    //   497: iconst_0
    //   498: istore 5
    //   500: goto -486 -> 14
    //   503: iconst_0
    //   504: istore 5
    //   506: goto -385 -> 121
    //   509: astore_2
    //   510: iload 6
    //   512: istore 7
    //   514: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +18 -> 535
    //   520: iload 6
    //   522: istore 7
    //   524: ldc_w 607
    //   527: iconst_2
    //   528: ldc_w 855
    //   531: aload_2
    //   532: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_0
    //   536: bipush 98
    //   538: iload 6
    //   540: iconst_2
    //   541: anewarray 254	java/lang/String
    //   544: dup
    //   545: iconst_0
    //   546: ldc_w 327
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_1
    //   553: aastore
    //   554: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   557: return
    //   558: astore_2
    //   559: aload_0
    //   560: bipush 98
    //   562: iload 7
    //   564: iconst_2
    //   565: anewarray 254	java/lang/String
    //   568: dup
    //   569: iconst_0
    //   570: ldc_w 327
    //   573: aastore
    //   574: dup
    //   575: iconst_1
    //   576: aload_1
    //   577: aastore
    //   578: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   581: aload_2
    //   582: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	ajfi
    //   0	583	1	paramToServiceMsg	ToServiceMsg
    //   0	583	2	paramFromServiceMsg	FromServiceMsg
    //   0	583	3	paramObject	Object
    //   379	87	4	i	int
    //   12	493	5	bool1	boolean
    //   73	466	6	bool2	boolean
    //   77	486	7	bool3	boolean
    //   64	414	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   79	100	509	java/lang/Exception
    //   108	118	509	java/lang/Exception
    //   129	135	509	java/lang/Exception
    //   143	171	509	java/lang/Exception
    //   192	202	509	java/lang/Exception
    //   214	224	509	java/lang/Exception
    //   232	240	509	java/lang/Exception
    //   248	263	509	java/lang/Exception
    //   275	285	509	java/lang/Exception
    //   297	312	509	java/lang/Exception
    //   324	349	509	java/lang/Exception
    //   357	381	509	java/lang/Exception
    //   389	395	509	java/lang/Exception
    //   403	431	509	java/lang/Exception
    //   448	470	509	java/lang/Exception
    //   79	100	558	finally
    //   108	118	558	finally
    //   129	135	558	finally
    //   143	171	558	finally
    //   192	202	558	finally
    //   214	224	558	finally
    //   232	240	558	finally
    //   248	263	558	finally
    //   275	285	558	finally
    //   297	312	558	finally
    //   324	349	558	finally
    //   357	381	558	finally
    //   389	395	558	finally
    //   403	431	558	finally
    //   448	470	558	finally
    //   514	520	558	finally
    //   524	535	558	finally
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("reqUin", "");
      paramFromServiceMsg = this.app.c();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting success=" + bool1 + " reqUin:" + paramToServiceMsg + "  uin:" + paramFromServiceMsg);
      }
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramFromServiceMsg, paramToServiceMsg))
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.uint32_result.get() != 0) {
            break label412;
          }
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting result=" + bool1);
          }
          if ((bool1) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.get().size() > 0) && (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_allow.has()))
            {
              int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_allow.get();
              notifyUI(106, bool1, Integer.valueOf(i));
              if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting settingValue=" + i);
              }
              if (i != 101) {
                d(i);
              }
            }
          }
          else
          {
            notifyUI(106, false, Integer.valueOf(a()));
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(106, false, Integer.valueOf(a()));
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting ex", paramToServiceMsg);
        }
      }
      return;
      bool1 = false;
      break;
      label412:
      bool1 = false;
    }
  }
  
  /* Error */
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +409 -> 422
    //   16: aload_3
    //   17: ifnull +405 -> 422
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 607
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 881
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: bipush 85
    //   63: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   66: checkcast 883	ajvm
    //   69: astore_1
    //   70: aload_1
    //   71: iconst_0
    //   72: invokevirtual 886	ajvm:a	(Z)Z
    //   75: istore 6
    //   77: iload 5
    //   79: istore 9
    //   81: iload 5
    //   83: ifeq +608 -> 691
    //   86: iload 5
    //   88: istore 7
    //   90: iload 5
    //   92: istore 8
    //   94: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 110	[B
    //   105: checkcast 110	[B
    //   108: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +312 -> 428
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_2
    //   128: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +294 -> 428
    //   137: iconst_1
    //   138: istore 5
    //   140: iload 5
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: ldc_w 607
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 888
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 9
    //   194: iload 5
    //   196: ifeq +495 -> 691
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: iload 5
    //   209: istore 9
    //   211: aload_2
    //   212: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +473 -> 691
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: iload 5
    //   231: istore 9
    //   233: aload_2
    //   234: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +451 -> 691
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_2
    //   252: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_2
    //   265: iload 5
    //   267: istore 7
    //   269: iload 5
    //   271: istore 8
    //   273: aload_2
    //   274: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 5
    //   280: istore 7
    //   282: iload 5
    //   284: istore 8
    //   286: aload_2
    //   287: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 5
    //   293: istore 7
    //   295: iload 5
    //   297: istore 8
    //   299: iload 5
    //   301: istore 9
    //   303: aload_2
    //   304: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 617	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +377 -> 691
    //   317: iload 5
    //   319: istore 7
    //   321: iload 5
    //   323: istore 8
    //   325: aload_2
    //   326: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 4
    //   333: sipush -25031
    //   336: if_icmpeq +98 -> 434
    //   339: iload 6
    //   341: istore 5
    //   343: iload 11
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: iload 6
    //   353: istore 8
    //   355: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +50 -> 408
    //   361: ldc_w 607
    //   364: iconst_2
    //   365: new 20	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 888
    //   375: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 6
    //   380: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 619
    //   386: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 5
    //   391: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iload 6
    //   402: istore 8
    //   404: iload 5
    //   406: istore 7
    //   408: aload_0
    //   409: bipush 58
    //   411: iload 8
    //   413: iload 7
    //   415: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -402 -> 23
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -291 -> 140
    //   434: iload 5
    //   436: istore 7
    //   438: iload 5
    //   440: istore 8
    //   442: aload_2
    //   443: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 4
    //   450: iconst_2
    //   451: if_icmpne +80 -> 531
    //   454: iload 5
    //   456: istore 7
    //   458: iload 5
    //   460: istore 8
    //   462: iload 4
    //   464: newarray byte
    //   466: astore_3
    //   467: iload 5
    //   469: istore 7
    //   471: iload 5
    //   473: istore 8
    //   475: aload_2
    //   476: aload_3
    //   477: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   480: pop
    //   481: iload 5
    //   483: istore 7
    //   485: iload 5
    //   487: istore 8
    //   489: aload_3
    //   490: iconst_0
    //   491: invokestatic 631	azzz:a	([BI)S
    //   494: istore 4
    //   496: iload 4
    //   498: ifne +215 -> 713
    //   501: iconst_1
    //   502: istore 6
    //   504: aload_2
    //   505: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   508: ifeq +10 -> 518
    //   511: iload 12
    //   513: istore 7
    //   515: goto +187 -> 702
    //   518: aload_1
    //   519: iload 6
    //   521: iconst_0
    //   522: invokevirtual 891	ajvm:a	(ZZ)V
    //   525: iconst_1
    //   526: istore 7
    //   528: goto +174 -> 702
    //   531: iload 6
    //   533: istore 5
    //   535: iload 11
    //   537: istore 6
    //   539: goto -192 -> 347
    //   542: astore_1
    //   543: iload 7
    //   545: istore 5
    //   547: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +14 -> 564
    //   553: ldc_w 607
    //   556: iconst_2
    //   557: ldc_w 893
    //   560: aload_1
    //   561: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: iload 6
    //   566: istore 7
    //   568: iload 10
    //   570: istore 8
    //   572: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq -167 -> 408
    //   578: ldc_w 607
    //   581: iconst_2
    //   582: new 20	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 888
    //   592: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iconst_0
    //   596: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: ldc_w 619
    //   602: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: iload 6
    //   607: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   610: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iload 6
    //   618: istore 7
    //   620: iload 10
    //   622: istore 8
    //   624: goto -216 -> 408
    //   627: astore_1
    //   628: iload 8
    //   630: istore 5
    //   632: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +42 -> 677
    //   638: ldc_w 607
    //   641: iconst_2
    //   642: new 20	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 888
    //   652: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 5
    //   657: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 619
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_1
    //   678: athrow
    //   679: astore_1
    //   680: goto -48 -> 632
    //   683: astore_1
    //   684: goto -52 -> 632
    //   687: astore_1
    //   688: goto -141 -> 547
    //   691: iload 6
    //   693: istore 5
    //   695: iload 9
    //   697: istore 6
    //   699: goto -352 -> 347
    //   702: iload 6
    //   704: istore 5
    //   706: iload 7
    //   708: istore 6
    //   710: goto -363 -> 347
    //   713: iconst_0
    //   714: istore 6
    //   716: goto -212 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	ajfi
    //   0	719	1	paramToServiceMsg	ToServiceMsg
    //   0	719	2	paramFromServiceMsg	FromServiceMsg
    //   0	719	3	paramObject	Object
    //   329	168	4	i	int
    //   21	684	5	bool1	boolean
    //   75	640	6	bool2	boolean
    //   88	619	7	bool3	boolean
    //   92	537	8	bool4	boolean
    //   79	617	9	bool5	boolean
    //   1	620	10	bool6	boolean
    //   7	529	11	bool7	boolean
    //   4	508	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   94	115	542	java/lang/Exception
    //   127	137	542	java/lang/Exception
    //   148	154	542	java/lang/Exception
    //   162	190	542	java/lang/Exception
    //   211	221	542	java/lang/Exception
    //   233	243	542	java/lang/Exception
    //   251	265	542	java/lang/Exception
    //   273	278	542	java/lang/Exception
    //   286	291	542	java/lang/Exception
    //   303	317	542	java/lang/Exception
    //   325	331	542	java/lang/Exception
    //   442	448	542	java/lang/Exception
    //   462	467	542	java/lang/Exception
    //   475	481	542	java/lang/Exception
    //   489	496	542	java/lang/Exception
    //   94	115	627	finally
    //   127	137	627	finally
    //   148	154	627	finally
    //   162	190	627	finally
    //   211	221	627	finally
    //   233	243	627	finally
    //   251	265	627	finally
    //   273	278	627	finally
    //   286	291	627	finally
    //   303	317	627	finally
    //   325	331	627	finally
    //   442	448	627	finally
    //   462	467	627	finally
    //   475	481	627	finally
    //   489	496	627	finally
    //   504	511	679	finally
    //   518	525	679	finally
    //   547	564	683	finally
    //   504	511	687	java/lang/Exception
    //   518	525	687	java/lang/Exception
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch success=" + bool1);
      }
      paramFromServiceMsg = (ajvm)this.app.getManager(85);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label661;
      }
      bool4 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          bool4 = bool1;
          bool3 = bool1;
          if (paramObject.uint32_result.get() == 0)
          {
            bool1 = true;
            bool4 = bool1;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              bool4 = bool1;
              bool3 = bool1;
              QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1);
            }
            bool5 = bool1;
            if (!bool1) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            l = azzz.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = paramToServiceMsg.extraData.getBoolean("switch");
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        bool1 = bool4;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch ex", paramFromServiceMsg);
        }
        bool3 = bool2;
        bool1 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + false + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
        bool1 = bool6;
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        }
      }
      try
      {
        paramFromServiceMsg.a(bool5, false);
        bool2 = bool5;
        bool1 = bool7;
        if (!QLog.isColorLevel()) {
          break label654;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool5;
        continue;
        bool3 = bool2;
        continue;
      }
      notifyUI(57, bool1, Boolean.valueOf(bool3));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool4 = bool1;
        bool3 = bool1;
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.app.getCurrentAccountUin() + " dwUin:" + l);
      }
      bool1 = false;
      continue;
      label654:
      label661:
      bool1 = bool5;
    }
  }
  
  /* Error */
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +415 -> 422
    //   10: aload_3
    //   11: ifnull +411 -> 422
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 607
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 909
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 51
    //   57: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 167	ajjj
    //   63: astore_1
    //   64: aload_1
    //   65: getstatic 912	ajed:aB	Ljava/lang/String;
    //   68: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   71: astore_2
    //   72: iload 6
    //   74: istore 9
    //   76: iload 6
    //   78: ifeq +636 -> 714
    //   81: iload 6
    //   83: istore 7
    //   85: iload 6
    //   87: istore 8
    //   89: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   92: dup
    //   93: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   96: aload_3
    //   97: checkcast 110	[B
    //   100: checkcast 110	[B
    //   103: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +317 -> 428
    //   114: iload 6
    //   116: istore 7
    //   118: iload 6
    //   120: istore 8
    //   122: aload_3
    //   123: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +299 -> 428
    //   132: iconst_1
    //   133: istore 6
    //   135: iload 6
    //   137: istore 7
    //   139: iload 6
    //   141: istore 8
    //   143: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +39 -> 185
    //   149: iload 6
    //   151: istore 7
    //   153: iload 6
    //   155: istore 8
    //   157: ldc_w 607
    //   160: iconst_2
    //   161: new 20	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 914
    //   171: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload 6
    //   176: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   179: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iload 6
    //   187: istore 9
    //   189: iload 6
    //   191: ifeq +523 -> 714
    //   194: iload 6
    //   196: istore 7
    //   198: iload 6
    //   200: istore 8
    //   202: iload 6
    //   204: istore 9
    //   206: aload_3
    //   207: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   213: ifeq +501 -> 714
    //   216: iload 6
    //   218: istore 7
    //   220: iload 6
    //   222: istore 8
    //   224: iload 6
    //   226: istore 9
    //   228: aload_3
    //   229: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: ifnull +479 -> 714
    //   238: iload 6
    //   240: istore 7
    //   242: iload 6
    //   244: istore 8
    //   246: aload_3
    //   247: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   253: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   256: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   259: astore_3
    //   260: iload 6
    //   262: istore 7
    //   264: iload 6
    //   266: istore 8
    //   268: aload_3
    //   269: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   272: pop
    //   273: iload 6
    //   275: istore 7
    //   277: iload 6
    //   279: istore 8
    //   281: aload_3
    //   282: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   285: pop
    //   286: iload 6
    //   288: istore 7
    //   290: iload 6
    //   292: istore 8
    //   294: iload 6
    //   296: istore 9
    //   298: aload_3
    //   299: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   302: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   305: invokevirtual 617	java/lang/Short:shortValue	()S
    //   308: iconst_1
    //   309: if_icmpne +405 -> 714
    //   312: iload 6
    //   314: istore 7
    //   316: iload 6
    //   318: istore 8
    //   320: aload_3
    //   321: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   324: istore 4
    //   326: iload 6
    //   328: istore 7
    //   330: iload 6
    //   332: istore 8
    //   334: aload_0
    //   335: getfield 66	ajfi:e	S
    //   338: istore 5
    //   340: iload 4
    //   342: iload 5
    //   344: if_icmpeq +90 -> 434
    //   347: iload 10
    //   349: istore 7
    //   351: iload 7
    //   353: istore 8
    //   355: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +48 -> 406
    //   361: ldc_w 607
    //   364: iconst_2
    //   365: new 20	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 914
    //   375: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 7
    //   380: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 916
    //   386: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_2
    //   390: getfield 919	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   393: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   396: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: iload 7
    //   404: istore 8
    //   406: aload_0
    //   407: bipush 75
    //   409: iload 8
    //   411: aload_2
    //   412: getfield 919	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   415: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 6
    //   425: goto -408 -> 17
    //   428: iconst_0
    //   429: istore 6
    //   431: goto -296 -> 135
    //   434: iload 6
    //   436: istore 7
    //   438: iload 6
    //   440: istore 8
    //   442: aload_3
    //   443: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 10
    //   450: istore 7
    //   452: iload 4
    //   454: iconst_2
    //   455: if_icmpne -104 -> 351
    //   458: iload 6
    //   460: istore 7
    //   462: iload 6
    //   464: istore 8
    //   466: iload 4
    //   468: newarray byte
    //   470: astore 11
    //   472: iload 6
    //   474: istore 7
    //   476: iload 6
    //   478: istore 8
    //   480: aload_3
    //   481: aload 11
    //   483: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   486: pop
    //   487: iload 6
    //   489: istore 7
    //   491: iload 6
    //   493: istore 8
    //   495: aload 11
    //   497: iconst_0
    //   498: invokestatic 631	azzz:a	([BI)S
    //   501: ifne +55 -> 556
    //   504: iconst_1
    //   505: istore 9
    //   507: iload 6
    //   509: istore 7
    //   511: iload 6
    //   513: istore 8
    //   515: aload_2
    //   516: iload 9
    //   518: putfield 919	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   521: iload 6
    //   523: istore 7
    //   525: iload 6
    //   527: istore 8
    //   529: aload_3
    //   530: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   533: istore 4
    //   535: iload 10
    //   537: istore 7
    //   539: iload 4
    //   541: ifne -190 -> 351
    //   544: aload_1
    //   545: aload_2
    //   546: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   549: pop
    //   550: iconst_1
    //   551: istore 7
    //   553: goto -202 -> 351
    //   556: iconst_0
    //   557: istore 9
    //   559: goto -52 -> 507
    //   562: astore_1
    //   563: iload 7
    //   565: istore 6
    //   567: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +14 -> 584
    //   573: ldc_w 607
    //   576: iconst_2
    //   577: ldc_w 921
    //   580: aload_1
    //   581: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   584: iload 6
    //   586: istore 8
    //   588: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq -185 -> 406
    //   594: ldc_w 607
    //   597: iconst_2
    //   598: new 20	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 914
    //   608: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: iload 6
    //   613: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   616: ldc_w 916
    //   619: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_2
    //   623: getfield 919	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   626: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: iload 6
    //   637: istore 8
    //   639: goto -233 -> 406
    //   642: astore_1
    //   643: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +44 -> 690
    //   649: ldc_w 607
    //   652: iconst_2
    //   653: new 20	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 914
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 8
    //   668: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: ldc_w 916
    //   674: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_2
    //   678: getfield 919	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   681: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   684: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_1
    //   691: athrow
    //   692: astore_1
    //   693: iconst_1
    //   694: istore 8
    //   696: goto -53 -> 643
    //   699: astore_1
    //   700: iload 6
    //   702: istore 8
    //   704: goto -61 -> 643
    //   707: astore_1
    //   708: iconst_1
    //   709: istore 6
    //   711: goto -144 -> 567
    //   714: iload 9
    //   716: istore 7
    //   718: goto -367 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	ajfi
    //   0	721	1	paramToServiceMsg	ToServiceMsg
    //   0	721	2	paramFromServiceMsg	FromServiceMsg
    //   0	721	3	paramObject	Object
    //   324	216	4	i	int
    //   338	7	5	j	int
    //   15	695	6	bool1	boolean
    //   83	634	7	bool2	boolean
    //   87	616	8	bool3	boolean
    //   74	641	9	bool4	boolean
    //   1	535	10	bool5	boolean
    //   470	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   89	110	562	java/lang/Exception
    //   122	132	562	java/lang/Exception
    //   143	149	562	java/lang/Exception
    //   157	185	562	java/lang/Exception
    //   206	216	562	java/lang/Exception
    //   228	238	562	java/lang/Exception
    //   246	260	562	java/lang/Exception
    //   268	273	562	java/lang/Exception
    //   281	286	562	java/lang/Exception
    //   298	312	562	java/lang/Exception
    //   320	326	562	java/lang/Exception
    //   334	340	562	java/lang/Exception
    //   442	448	562	java/lang/Exception
    //   466	472	562	java/lang/Exception
    //   480	487	562	java/lang/Exception
    //   495	504	562	java/lang/Exception
    //   515	521	562	java/lang/Exception
    //   529	535	562	java/lang/Exception
    //   89	110	642	finally
    //   122	132	642	finally
    //   143	149	642	finally
    //   157	185	642	finally
    //   206	216	642	finally
    //   228	238	642	finally
    //   246	260	642	finally
    //   268	273	642	finally
    //   281	286	642	finally
    //   298	312	642	finally
    //   320	326	642	finally
    //   334	340	642	finally
    //   442	448	642	finally
    //   466	472	642	finally
    //   480	487	642	finally
    //   495	504	642	finally
    //   515	521	642	finally
    //   529	535	642	finally
    //   544	550	692	finally
    //   567	584	699	finally
    //   544	550	707	java/lang/Exception
  }
  
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label615;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label615;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label615;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label615;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i >= 0) {
          continue;
        }
        l = i + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (ajjj)this.app.getManager(51);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.c(ajed.aB);
        bool2 = bool1;
        bool3 = bool1;
        paramObject.babyQSwitch = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i;
          long l;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      notifyUI(74, bool3, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("switch")));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label615:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_2
    //   4: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +397 -> 404
    //   10: aload_3
    //   11: ifnull +393 -> 404
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 607
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 931
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 933
    //   61: invokevirtual 936	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: istore 8
    //   77: iload 5
    //   79: ifeq +566 -> 645
    //   82: iload 5
    //   84: istore 6
    //   86: iload 5
    //   88: istore 7
    //   90: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: dup
    //   94: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   97: aload_3
    //   98: checkcast 110	[B
    //   101: checkcast 110	[B
    //   104: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +298 -> 410
    //   115: iload 5
    //   117: istore 6
    //   119: iload 5
    //   121: istore 7
    //   123: aload_2
    //   124: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: ifne +280 -> 410
    //   133: iconst_1
    //   134: istore 5
    //   136: iload 5
    //   138: istore 6
    //   140: iload 5
    //   142: istore 7
    //   144: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +39 -> 186
    //   150: iload 5
    //   152: istore 6
    //   154: iload 5
    //   156: istore 7
    //   158: ldc_w 607
    //   161: iconst_2
    //   162: new 20	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 938
    //   172: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 5
    //   177: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 5
    //   188: istore 8
    //   190: iload 5
    //   192: ifeq +453 -> 645
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: aload_2
    //   208: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +431 -> 645
    //   217: iload 5
    //   219: istore 6
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: aload_2
    //   230: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +409 -> 645
    //   239: iload 5
    //   241: istore 6
    //   243: iload 5
    //   245: istore 7
    //   247: aload_2
    //   248: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   263: istore 4
    //   265: iload 4
    //   267: i2l
    //   268: lstore 10
    //   270: iload 4
    //   272: ifge +16 -> 288
    //   275: iload 4
    //   277: ldc_w 939
    //   280: iand
    //   281: i2l
    //   282: ldc2_w 940
    //   285: lor
    //   286: lstore 10
    //   288: iload 5
    //   290: istore 6
    //   292: iload 5
    //   294: istore 7
    //   296: aload_0
    //   297: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   300: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   303: lload 10
    //   305: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: istore 5
    //   313: iload 5
    //   315: ifeq +101 -> 416
    //   318: aload_1
    //   319: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   322: ldc_w 943
    //   325: invokevirtual 538	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 51
    //   336: invokevirtual 946	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   339: checkcast 948	xrh
    //   342: iload 4
    //   344: invokevirtual 949	xrh:b	(I)V
    //   347: iconst_1
    //   348: istore 5
    //   350: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +50 -> 403
    //   356: ldc_w 607
    //   359: iconst_2
    //   360: new 20	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 938
    //   370: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 5
    //   375: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc_w 619
    //   381: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   388: ldc_w 943
    //   391: invokevirtual 538	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   394: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: return
    //   404: iconst_0
    //   405: istore 5
    //   407: goto -390 -> 17
    //   410: iconst_0
    //   411: istore 5
    //   413: goto -277 -> 136
    //   416: iload 9
    //   418: istore 5
    //   420: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq -73 -> 350
    //   426: ldc_w 607
    //   429: iconst_2
    //   430: new 20	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 951
    //   440: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 10
    //   445: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: ldc_w 953
    //   451: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   461: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iload 9
    //   472: istore 5
    //   474: goto -124 -> 350
    //   477: astore_2
    //   478: iconst_0
    //   479: istore 5
    //   481: iload 5
    //   483: istore 6
    //   485: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +18 -> 506
    //   491: iload 5
    //   493: istore 6
    //   495: ldc_w 607
    //   498: iconst_2
    //   499: ldc_w 955
    //   502: aload_2
    //   503: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -106 -> 403
    //   512: ldc_w 607
    //   515: iconst_2
    //   516: new 20	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 938
    //   526: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload 5
    //   531: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   534: ldc_w 619
    //   537: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   544: ldc_w 943
    //   547: invokevirtual 538	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   550: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: return
    //   560: astore_2
    //   561: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +50 -> 614
    //   567: ldc_w 607
    //   570: iconst_2
    //   571: new 20	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 938
    //   581: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 6
    //   586: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   589: ldc_w 619
    //   592: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   599: ldc_w 943
    //   602: invokevirtual 538	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   605: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_2
    //   615: athrow
    //   616: astore_2
    //   617: iconst_1
    //   618: istore 6
    //   620: goto -59 -> 561
    //   623: astore_2
    //   624: iconst_0
    //   625: istore 6
    //   627: goto -66 -> 561
    //   630: astore_2
    //   631: iload 7
    //   633: istore 5
    //   635: goto -154 -> 481
    //   638: astore_2
    //   639: iconst_1
    //   640: istore 5
    //   642: goto -161 -> 481
    //   645: iload 8
    //   647: istore 5
    //   649: goto -299 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	ajfi
    //   0	652	1	paramToServiceMsg	ToServiceMsg
    //   0	652	2	paramFromServiceMsg	FromServiceMsg
    //   0	652	3	paramObject	Object
    //   263	80	4	i	int
    //   15	633	5	bool1	boolean
    //   84	542	6	bool2	boolean
    //   88	544	7	bool3	boolean
    //   75	571	8	bool4	boolean
    //   1	470	9	bool5	boolean
    //   268	176	10	l	long
    // Exception table:
    //   from	to	target	type
    //   420	470	477	java/lang/Exception
    //   90	111	560	finally
    //   123	133	560	finally
    //   144	150	560	finally
    //   158	186	560	finally
    //   207	217	560	finally
    //   229	239	560	finally
    //   247	265	560	finally
    //   296	313	560	finally
    //   485	491	560	finally
    //   495	506	560	finally
    //   318	347	616	finally
    //   420	470	623	finally
    //   90	111	630	java/lang/Exception
    //   123	133	630	java/lang/Exception
    //   144	150	630	java/lang/Exception
    //   158	186	630	java/lang/Exception
    //   207	217	630	java/lang/Exception
    //   229	239	630	java/lang/Exception
    //   247	265	630	java/lang/Exception
    //   296	313	630	java/lang/Exception
    //   318	347	638	java/lang/Exception
  }
  
  /* Error */
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +372 -> 379
    //   10: aload_3
    //   11: ifnull +368 -> 379
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 607
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 958
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 933
    //   61: invokevirtual 936	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: ifeq +465 -> 540
    //   78: iload 5
    //   80: istore 6
    //   82: iload 5
    //   84: istore 7
    //   86: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: aload_3
    //   94: checkcast 110	[B
    //   97: checkcast 110	[B
    //   100: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +277 -> 385
    //   111: iload 5
    //   113: istore 6
    //   115: iload 5
    //   117: istore 7
    //   119: aload_2
    //   120: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: ifne +259 -> 385
    //   129: iconst_1
    //   130: istore 5
    //   132: iload 5
    //   134: istore 6
    //   136: iload 5
    //   138: istore 7
    //   140: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +39 -> 182
    //   146: iload 5
    //   148: istore 6
    //   150: iload 5
    //   152: istore 7
    //   154: ldc_w 607
    //   157: iconst_2
    //   158: new 20	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 960
    //   168: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 5
    //   173: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iload 5
    //   184: ifeq +426 -> 610
    //   187: iload 5
    //   189: istore 6
    //   191: iload 5
    //   193: istore 7
    //   195: aload_2
    //   196: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +408 -> 610
    //   205: iload 5
    //   207: istore 6
    //   209: iload 5
    //   211: istore 7
    //   213: aload_2
    //   214: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +390 -> 610
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: i2l
    //   252: lstore 10
    //   254: iload 4
    //   256: ifge +16 -> 272
    //   259: iload 4
    //   261: ldc_w 939
    //   264: iand
    //   265: i2l
    //   266: ldc2_w 940
    //   269: lor
    //   270: lstore 10
    //   272: iload 5
    //   274: istore 6
    //   276: iload 5
    //   278: istore 7
    //   280: aload_1
    //   281: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   284: ldc_w 672
    //   287: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: istore 9
    //   292: iload 5
    //   294: istore 6
    //   296: iload 5
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   307: lload 10
    //   309: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore 5
    //   317: iload 5
    //   319: ifeq +72 -> 391
    //   322: iconst_1
    //   323: istore 5
    //   325: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +50 -> 378
    //   331: ldc_w 607
    //   334: iconst_2
    //   335: new 20	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 960
    //   345: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 5
    //   350: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: ldc_w 619
    //   356: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   363: ldc_w 672
    //   366: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   369: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: iconst_0
    //   380: istore 5
    //   382: goto -365 -> 17
    //   385: iconst_0
    //   386: istore 5
    //   388: goto -256 -> 132
    //   391: iload 9
    //   393: ifne +3 -> 396
    //   396: iload 8
    //   398: istore 5
    //   400: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -78 -> 325
    //   406: ldc_w 607
    //   409: iconst_2
    //   410: new 20	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 962
    //   420: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 10
    //   425: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 953
    //   431: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iload 8
    //   452: istore 5
    //   454: goto -129 -> 325
    //   457: astore_2
    //   458: iconst_0
    //   459: istore 7
    //   461: iload 7
    //   463: istore 6
    //   465: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +18 -> 486
    //   471: iload 7
    //   473: istore 6
    //   475: ldc_w 607
    //   478: iconst_2
    //   479: ldc_w 964
    //   482: aload_2
    //   483: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -111 -> 378
    //   492: ldc_w 607
    //   495: iconst_2
    //   496: new 20	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 960
    //   506: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload 7
    //   511: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 619
    //   517: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   524: ldc_w 672
    //   527: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: goto -215 -> 325
    //   543: astore_2
    //   544: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc_w 607
    //   553: iconst_2
    //   554: new 20	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 960
    //   564: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 6
    //   569: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 619
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 672
    //   585: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   588: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   591: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_2
    //   598: athrow
    //   599: astore_2
    //   600: iconst_0
    //   601: istore 6
    //   603: goto -59 -> 544
    //   606: astore_2
    //   607: goto -146 -> 461
    //   610: goto -285 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	ajfi
    //   0	613	1	paramToServiceMsg	ToServiceMsg
    //   0	613	2	paramFromServiceMsg	FromServiceMsg
    //   0	613	3	paramObject	Object
    //   247	18	4	i	int
    //   15	438	5	bool1	boolean
    //   80	522	6	bool2	boolean
    //   84	426	7	bool3	boolean
    //   1	450	8	bool4	boolean
    //   290	102	9	bool5	boolean
    //   252	172	10	l	long
    // Exception table:
    //   from	to	target	type
    //   400	450	457	java/lang/Exception
    //   86	107	543	finally
    //   119	129	543	finally
    //   140	146	543	finally
    //   154	182	543	finally
    //   195	205	543	finally
    //   213	223	543	finally
    //   231	249	543	finally
    //   280	292	543	finally
    //   300	317	543	finally
    //   465	471	543	finally
    //   475	486	543	finally
    //   400	450	599	finally
    //   86	107	606	java/lang/Exception
    //   119	129	606	java/lang/Exception
    //   140	146	606	java/lang/Exception
    //   154	182	606	java/lang/Exception
    //   195	205	606	java/lang/Exception
    //   213	223	606	java/lang/Exception
    //   231	249	606	java/lang/Exception
    //   280	292	606	java/lang/Exception
    //   300	317	606	java/lang/Exception
  }
  
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt success=" + bool1);
      }
      localObject2 = null;
      localObject3 = null;
      localObject1 = null;
      paramFromServiceMsg = null;
      if (!bool1) {
        break label497;
      }
    }
    int j;
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            j = paramObject.uint32_result.get();
            if (j == 0) {
              bool1 = true;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          long l;
          label300:
          paramObject = localObject1;
          continue;
          bool2 = bool1;
          continue;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt result=" + bool1);
          }
          if ((!bool1) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null)) {
            continue;
          }
          paramObject = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
          l = azzz.a(paramObject.getInt());
          paramObject.get();
          if (Short.valueOf(paramObject.getShort()).shortValue() != 1) {
            continue;
          }
          j = paramObject.getShort();
          if (j != -25126)
          {
            paramToServiceMsg = paramFromServiceMsg;
            notifyUI(68, bool2, paramToServiceMsg);
            return;
            bool1 = false;
            break;
            bool1 = false;
            continue;
          }
          j = paramObject.getShort();
          if (j == 2)
          {
            paramFromServiceMsg = new byte[j];
            paramObject.get(paramFromServiceMsg);
            j = azzz.a(paramFromServiceMsg, 0);
            if (paramObject.getShort() == 0) {
              break label567;
            }
            paramToServiceMsg = null;
            bool2 = bool3;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramObject = localObject1;
        }
      }
      bool2 = paramToServiceMsg.extraData.getBoolean("isQidianSimple", false);
      paramToServiceMsg = new BmqqAccountType(String.valueOf(Long.valueOf(l)), i);
      try
      {
        paramFromServiceMsg = (bcpn)this.mApp.getManager(165);
        paramFromServiceMsg.a(paramToServiceMsg);
        if ((i == 1) && (bool2)) {
          paramFromServiceMsg.a(this.mApp.getApp().getBaseContext(), paramToServiceMsg);
        } else {
          paramFromServiceMsg.b(this.mApp.getApp().getBaseContext(), paramToServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramObject = paramToServiceMsg;
      }
      paramFromServiceMsg.printStackTrace();
      bool2 = bool1;
      paramToServiceMsg = paramObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt exception: " + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramToServiceMsg = paramObject;
        continue;
        paramToServiceMsg = localObject2;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt uint32_result false");
          paramToServiceMsg = localObject2;
          bool2 = bool1;
          continue;
          label497:
          bool2 = bool1;
          paramToServiceMsg = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt isSuccess: " + bool1);
            bool2 = bool1;
            paramToServiceMsg = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramToServiceMsg;
      break;
      label567:
      if (j == 0) {
        break label300;
      }
      i = 1;
      break label300;
      bool2 = true;
    }
  }
  
  private void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster success=" + bool);
      }
      if (!bool) {}
    }
    label548:
    label584:
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
        break label684;
      }
      bool = true;
      label91:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster result=" + bool);
      }
      if ((!bool) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
        break label620;
      }
      paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = Long.valueOf(azzz.a(paramToServiceMsg.getInt()));
      paramToServiceMsg.get();
      paramObject = Short.valueOf(paramToServiceMsg.getShort());
      if (paramObject.shortValue() != 1) {
        break label584;
      }
      if (paramToServiceMsg.getShort() != -25176) {
        break label548;
      }
      i = paramToServiceMsg.getShort();
      if (i != 2) {
        break label511;
      }
      paramObject = new byte[i];
      paramToServiceMsg.get(paramObject);
      int j = azzz.a(paramObject, 0);
      i = paramToServiceMsg.getShort();
      if (i != 0) {
        break label474;
      }
      i = 4;
      if (j != 0) {
        i = 6;
      }
      paramToServiceMsg = new BmqqAccountType(String.valueOf(paramFromServiceMsg), i);
      try
      {
        paramObject = (bcpn)this.mApp.getManager(165);
        paramObject.a(paramToServiceMsg);
        if (j != 0)
        {
          QLog.i("Q.profilecard.", 1, MsfSdkUtils.getShortUin(String.valueOf(paramFromServiceMsg)) + " handleGetIsQidianMaster is qidianmaster");
          QidianExternalInfo localQidianExternalInfo = paramObject.a(String.valueOf(paramFromServiceMsg));
          paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg));
          if ((localQidianExternalInfo == null) || (paramFromServiceMsg == null)) {
            paramObject.b(this.app.getApp().getBaseContext(), paramToServiceMsg);
          }
        }
        for (;;)
        {
          notifyUI(89, true, paramToServiceMsg);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster sFieldValue: " + j);
          }
        }
        paramObject.printStackTrace();
      }
      catch (Exception paramObject) {}
    }
    catch (Exception paramObject)
    {
      label474:
      label620:
      for (;;)
      {
        int i;
        label511:
        paramToServiceMsg = null;
      }
    }
    paramFromServiceMsg = paramToServiceMsg;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster exception: " + paramObject.getMessage());
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      notifyUI(89, false, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLeft: " + i);
        break label690;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLen: " + i);
          break label690;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wTlvCount: " + paramObject);
            break label690;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wTlvCount: " + paramObject);
              break label690;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster uint32_result false");
                break label690;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster isSuccess: " + bool);
                }
                paramFromServiceMsg = null;
                continue;
                bool = false;
                break;
                label684:
                bool = false;
                break label91;
              }
            }
          }
        }
      }
      label690:
      paramFromServiceMsg = null;
    }
  }
  
  private void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("from");
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", new Object[] { paramToServiceMsg }));
    }
    if ("getSelfNewObtainedMedalWall".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
  }
  
  private void Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder(300);
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("medal_wall_list");
      ((StringBuilder)localObject2).append("report list: [");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        while (paramToServiceMsg.hasNext())
        {
          MedalID localMedalID = (MedalID)paramToServiceMsg.next();
          if (localMedalID != null) {
            ((StringBuilder)localObject2).append("(").append(localMedalID.jdField_a_of_type_Int).append(",").append(localMedalID.jdField_b_of_type_Int).append("), ");
          }
        }
      }
      ((StringBuilder)localObject2).append("]");
    }
    for (paramToServiceMsg = (ToServiceMsg)localObject2;; paramToServiceMsg = null)
    {
      localObject2 = new cmd0xac6.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
      paramFromServiceMsg = localObject1;
      if (i == 0)
      {
        if ((QLog.isDevelopLevel()) && (paramToServiceMsg != null))
        {
          paramFromServiceMsg = ((cmd0xac6.RspBody)localObject2).rpt_results.get();
          paramToServiceMsg.append(", result list [");
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = paramFromServiceMsg.iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (cmd0xac6.operate_result)paramFromServiceMsg.next();
              if (paramObject != null) {
                paramToServiceMsg.append("(").append(paramObject.uint32_id.get()).append(",").append(paramObject.int32_result.get()).append(",").append(paramObject.str_errmsg.get()).append("), ");
              }
            }
          }
          paramToServiceMsg.append("]");
        }
        paramFromServiceMsg = new TMedalWallInfo(-2147483648, ((cmd0xac6.RspBody)localObject2).uint32_metal_count.get(), ((cmd0xac6.RspBody)localObject2).int32_new_count.get(), ((cmd0xac6.RspBody)localObject2).int32_upgrade_count.get(), ((cmd0xac6.RspBody)localObject2).str_prompt_params.get());
      }
      if (QLog.isDevelopLevel())
      {
        paramObject = Locale.getDefault();
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = "null";
          QLog.i("MedalWallMng", 4, String.format(paramObject, "handleReportMedalWall result: %s  msg: %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
        }
      }
      else
      {
        paramToServiceMsg = ((MedalWallMng)this.app.getManager(250)).a(paramFromServiceMsg, false);
        if (i != 0) {
          break label433;
        }
      }
      label433:
      for (boolean bool = true;; bool = false)
      {
        notifyUI(51, bool, paramToServiceMsg);
        return;
        paramToServiceMsg = paramToServiceMsg.toString();
        break;
      }
    }
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.widthPixels;
    int j = paramContext.heightPixels;
    if (i > j) {
      return i;
    }
    return j;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List<FaceInfo> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(bach.a(((FaceInfo)paramList.get(i)).vFaceID));
        i += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList<String> a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        if ((paramString[i] != null) && (!"".equals(paramString[i]))) {
          localLinkedList.add(paramString[i]);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, "_TEMP_COVER_FILEKEY", paramString2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramString3 == null) || ("".equals(paramString3))) {
      paramContext.remove(paramString1 + paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + paramString2, paramString3);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new cmd0x7a8.RspBody();
    int n = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramObject = null;
    paramFromServiceMsg = null;
    Iterator localIterator = null;
    MedalWallMng localMedalWallMng = (MedalWallMng)this.app.getManager(250);
    int i1;
    MedalInfo localMedalInfo;
    int j;
    int m;
    int k;
    int i;
    if (n == 0)
    {
      paramObject = new TMedalWallInfo();
      paramObject.iOpenFlag = -2147483648;
      paramObject.iMedalCount = ((cmd0x7a8.RspBody)localObject1).uint32_metal_count.get();
      paramObject.iNewCount = ((cmd0x7a8.RspBody)localObject1).int32_new_count.get();
      paramObject.iUpgradeCount = ((cmd0x7a8.RspBody)localObject1).int32_upgrade_count.get();
      paramObject.strPromptParams = ((cmd0x7a8.RspBody)localObject1).str_prompt_params.get();
      Object localObject2 = ((cmd0x7a8.RspBody)localObject1).rpt_msg_medal.get();
      localObject1 = new ArrayList();
      paramFromServiceMsg = localIterator;
      if (localObject2 != null)
      {
        paramFromServiceMsg = localIterator;
        if (((List)localObject2).size() > 0)
        {
          paramFromServiceMsg = new SparseArray(((List)localObject2).size());
          localIterator = ((List)localObject2).iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject2 = (common.MedalInfo)localIterator.next();
              if (localObject2 != null)
              {
                i1 = ((common.MedalInfo)localObject2).uint32_level.get();
                if (i1 == 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal medal[%d] get level[%d]", new Object[] { Integer.valueOf(((common.MedalInfo)localObject2).uint32_id.get()), Integer.valueOf(i1) }));
                  }
                }
                else
                {
                  localMedalInfo = localMedalWallMng.a(((common.MedalInfo)localObject2).uint32_id.get());
                  localMedalInfo.strName = ((common.MedalInfo)localObject2).str_name.get();
                  localMedalInfo.iType = ((common.MedalInfo)localObject2).uint32_type.get();
                  localMedalInfo.iNoProgress = ((common.MedalInfo)localObject2).uint32_no_progress.get();
                  localMedalInfo.strResJson = ((common.MedalInfo)localObject2).str_resource.get();
                  localMedalInfo.iLevelCount = ((common.MedalInfo)localObject2).uint32_level_count.get();
                  localMedalInfo.lSeqLevel1 = ((common.MedalInfo)localObject2).uint32_seq.get();
                  localMedalInfo.lObtainTimeLevel1 = ((common.MedalInfo)localObject2).uint64_time.get();
                  localMedalInfo.strDescLevel1 = ((common.MedalInfo)localObject2).str_desc.get();
                  localMedalInfo.iPointLevel1 = ((common.MedalInfo)localObject2).uint32_point.get();
                  localMedalInfo.strDetailUrlLevel1 = ((common.MedalInfo)localObject2).str_detail_url.get();
                  localMedalInfo.strTaskDescLevel1 = ((common.MedalInfo)localObject2).str_task_desc.get();
                  localMedalInfo.lSeqLevel2 = ((common.MedalInfo)localObject2).uint32_seq_level2.get();
                  localMedalInfo.lObtainTimeLevel2 = ((common.MedalInfo)localObject2).uint64_time_level2.get();
                  localMedalInfo.strDescLevel2 = ((common.MedalInfo)localObject2).str_desc_level2.get();
                  localMedalInfo.iPointLevel2 = ((common.MedalInfo)localObject2).uint32_point_level2.get();
                  localMedalInfo.strDetailUrlLevel2 = ((common.MedalInfo)localObject2).str_detail_url_2.get();
                  localMedalInfo.strTaskDescLevel2 = ((common.MedalInfo)localObject2).str_task_desc_2.get();
                  localMedalInfo.lSeqLevel3 = ((common.MedalInfo)localObject2).uint32_seq_level3.get();
                  localMedalInfo.lObtainTimeLevel3 = ((common.MedalInfo)localObject2).uint64_time_level3.get();
                  localMedalInfo.strDescLevel3 = ((common.MedalInfo)localObject2).str_desc_level3.get();
                  localMedalInfo.iPointLevel3 = ((common.MedalInfo)localObject2).uint32_point_level3.get();
                  localMedalInfo.strDetailUrlLevel3 = ((common.MedalInfo)localObject2).str_detail_url_3.get();
                  localMedalInfo.strTaskDescLevel3 = ((common.MedalInfo)localObject2).str_task_desc_3.get();
                  j = ((common.MedalInfo)localObject2).uint32_unread.get();
                  m = ((common.MedalInfo)localObject2).uint32_unread_2.get();
                  k = ((common.MedalInfo)localObject2).uint32_unread_3.get();
                  if (i1 == 255)
                  {
                    if ((localMedalInfo.iLevel != i1) || (localMedalInfo.iUnreadLevel1 != 2) || (j != 1)) {
                      break label1044;
                    }
                    ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 255));
                    j = 2;
                    i = k;
                    k = m;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localMedalInfo.iLevel = i1;
      localMedalInfo.iUnreadLevel1 = j;
      localMedalInfo.iUnreadLevel2 = k;
      localMedalInfo.iUnreadLevel3 = i;
      paramFromServiceMsg.put(localMedalInfo.iId, localMedalInfo);
      break;
      if (localMedalInfo.iLevelCount > 1)
      {
        if ((localMedalInfo.iLevel >= 1) && (localMedalInfo.iUnreadLevel1 == 2) && (j == 1)) {
          ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 1));
        }
        for (i = localMedalInfo.iUnreadLevel1;; i = j)
        {
          if ((localMedalInfo.iLevel >= 2) && (localMedalInfo.iUnreadLevel2 == 2) && (m == 1)) {
            ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 2));
          }
          for (j = localMedalInfo.iUnreadLevel2;; j = m)
          {
            if ((localMedalInfo.iLevel >= 3) && (localMedalInfo.iUnreadLevel3 == 2) && (k == 1))
            {
              ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 3));
              m = localMedalInfo.iUnreadLevel3;
              k = j;
              j = i;
              i = m;
              break;
              if (((ArrayList)localObject1).size() > 0) {
                b((ArrayList)localObject1);
              }
              if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal result: %d", new Object[] { Integer.valueOf(n) }));
              }
              boolean bool;
              if (n == 0)
              {
                bool = true;
                localMedalWallMng.a(bool, paramObject, paramFromServiceMsg);
                if (n != 0) {
                  break label1009;
                }
              }
              label1009:
              for (paramFromServiceMsg = ((ajjj)this.mApp.getManager(51)).a(this.mApp.getCurrentAccountUin(), true);; paramFromServiceMsg = null)
              {
                if (n == 0) {}
                for (bool = true;; bool = false)
                {
                  notifyUI(51, bool, paramFromServiceMsg);
                  return;
                  bool = false;
                  break;
                }
              }
            }
            m = j;
            j = i;
            i = k;
            k = m;
            break;
          }
        }
      }
      label1044:
      i = k;
      k = m;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = (RespVote)paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
    paramBundle.putString("targetUin", paramFromServiceMsg);
    paramBundle.putString("selfUin", paramToServiceMsg);
    if ((paramObject != null) && (((RespVote)paramObject).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramToServiceMsg = (ajjj)this.app.getManager(51);
        paramFromServiceMsg = paramToServiceMsg.b(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      notifyUI(5, bool, paramBundle);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean, byte paramByte2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",comeFromType = ").append(paramInt1).append(",destUin = ").append(paramString2).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte1).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean);
        QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      ((ToServiceMsg)localObject1).extraData.putLong("selfUin", l1);
      ((ToServiceMsg)localObject1).extraData.putLong("targetUin", l2);
      ((ToServiceMsg)localObject1).extraData.putInt("comeFromType", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      ((ToServiceMsg)localObject1).extraData.putByte("isFriend", paramByte1);
      ((ToServiceMsg)localObject1).extraData.putLong("troopCode", paramLong2);
      ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong3);
      ((ToServiceMsg)localObject1).extraData.putByteArray("vSeed", paramArrayOfByte1);
      ((ToServiceMsg)localObject1).extraData.putString("strSearchName", paramString3);
      ((ToServiceMsg)localObject1).extraData.putLong("lGetControl", paramLong4);
      ((ToServiceMsg)localObject1).extraData.putInt("EAddFriendSource", paramInt2);
      ((ToServiceMsg)localObject1).extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      ((ToServiceMsg)localObject1).extraData.putLong("tinyId", paramLong5);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isNearbyPeopleCard", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putByte("bReqMedalWallInfo", paramByte2);
      ((ToServiceMsg)localObject1).extraData.putByte("bReqExtendCard", (byte)1);
      if (this.app != null)
      {
        paramString1 = (TicketManager)this.app.getManager(2);
        if (paramString1 != null)
        {
          paramString1 = paramString1.getA2(String.valueOf(l1));
          ((ToServiceMsg)localObject1).extraData.putString("msg_login_sig", paramString1);
        }
      }
      paramArrayOfByte1 = amjk.a();
      paramString1 = new ArrayList();
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.a()))
      {
        paramArrayOfByte1 = new SummaryCardBusiEntry.CommonReq();
        paramString3 = new SummaryCardBusiEntry.VisitorCountReq();
        paramString3.operuin.set((int)l1);
        paramString3.requireuin.set((int)l2);
        paramString3.mod.set(0);
        paramString3.reportFlag.set(1);
        paramArrayOfByte1.vcReq.set(paramString3);
        paramArrayOfByte1.serviceCmd.set("profileVisitor.getVisitorCnt");
        paramString1.add(new BusinessBuff(15, paramArrayOfByte1.toByteArray()));
      }
      paramArrayOfByte1 = new VaProfileGate.VaProfileGateReq();
      paramString3 = new VaProfileGate.PrivilegeBaseInfoReq();
      paramArrayOfByte2 = new VaProfileGate.GetGiftListReq();
      Object localObject2 = new VaProfileGate.OidbFlagInfo();
      ArrayList localArrayList = new ArrayList();
      ((VaProfileGate.OidbFlagInfo)localObject2).uint32_fieled.set(42334);
      localArrayList.add(localObject2);
      localObject2 = new VaProfileGate.OidbFlagInfo();
      ((VaProfileGate.OidbFlagInfo)localObject2).uint32_fieled.set(42340);
      localArrayList.add(localObject2);
      localObject2 = new VaProfileGate.GetVipCareReq();
      ((VaProfileGate.GetVipCareReq)localObject2).uint64_uin.set(l2);
      VaProfileGate.CommTaskInfo localCommTaskInfo = new VaProfileGate.CommTaskInfo();
      VipMusicBox.GetProfileMusicBoxInfoReq localGetProfileMusicBoxInfoReq = new VipMusicBox.GetProfileMusicBoxInfoReq();
      localGetProfileMusicBoxInfoReq.uin.set(l2);
      localCommTaskInfo.uint32_appid.set(4);
      localCommTaskInfo.bytes_task_data.set(ByteStringMicro.copyFrom(localGetProfileMusicBoxInfoReq.toByteArray()));
      paramArrayOfByte1.uCmd.set(3);
      paramString3.uReqUin.set(l2);
      paramArrayOfByte2.uin.set((int)l2);
      paramArrayOfByte1.stPrivilegeReq.set(paramString3);
      paramArrayOfByte1.stGiftReq.set(paramArrayOfByte2);
      paramArrayOfByte1.rpt_oidb_flag.set(localArrayList);
      paramArrayOfByte1.st_vip_care.set((MessageMicro)localObject2);
      paramArrayOfByte1.rpt_task_item.add(localCommTaskInfo);
      paramString1.add(new BusinessBuff(16, paramArrayOfByte1.toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.CardHandler", 1, "profile card request VASPROFILEGATE_SERVICE");
      }
      if (paramString1.size() > 0) {
        ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("busiList", paramString1);
      }
      paramArrayOfByte1 = SosoInterface.a();
      if (paramArrayOfByte1 != null)
      {
        paramString1 = paramArrayOfByte1;
        if (paramArrayOfByte1.a != null) {}
      }
      else
      {
        paramString1 = SosoInterface.a();
      }
      if ((paramString1 != null) && (paramString1.a != null))
      {
        paramArrayOfByte1 = new UserLocaleInfo();
        paramArrayOfByte1.lLatitude = ((int)(paramString1.a.a * 1000000.0D));
        paramArrayOfByte1.lLongitude = ((int)(paramString1.a.b * 1000000.0D));
        ((ToServiceMsg)localObject1).extraData.putSerializable("stLocaleInfo", paramArrayOfByte1);
      }
      paramString1 = new ArrayList();
      if ((this.app != null) && (this.app.getCurrentAccountUin().equals(paramString2))) {
        paramString1.add(Integer.valueOf(42104));
      }
      paramString1.add(Integer.valueOf(27225));
      paramString1.add(Integer.valueOf(27224));
      paramString1.add(Integer.valueOf(42122));
      paramString1.add(Integer.valueOf(42121));
      paramString1.add(Integer.valueOf(27236));
      paramString1.add(Integer.valueOf(27238));
      paramString1.add(Integer.valueOf(42167));
      paramString1.add(Integer.valueOf(42172));
      paramString1.add(Integer.valueOf(40324));
      paramString1.add(Integer.valueOf(42284));
      paramString1.add(Integer.valueOf(42326));
      paramString1.add(Integer.valueOf(42325));
      ((ToServiceMsg)localObject1).extraData.putIntegerArrayList("req0x5ebFieldIdList", paramString1);
      send((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSummayCard", paramString1);
    }
  }
  
  public static void a(String paramString, List<Visitor> paramList) {}
  
  private void a(List<Short> paramList, Bundle paramBundle, String paramString)
  {
    a(paramList, paramBundle, paramString, 9);
  }
  
  private void a(List<Short> paramList, Bundle paramBundle, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getDetailCardInfo");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() * 2 + 7);
    localByteBuffer.putInt((int)Long.parseLong(paramString));
    localByteBuffer.put((byte)0);
    localByteBuffer.putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putShort(((Short)paramList.next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = createToServiceMsg("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    sendPbReq(paramList);
  }
  
  private boolean a(Card paramCard, SparseArray<awai> paramSparseArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    Object localObject1 = (awai)paramSparseArray.get(17);
    if ((localObject1 != null) && (((awai)localObject1).a != null))
    {
      if (paramLong1 == paramLong2)
      {
        paramSparseArray = new INTERFACE.StGetUserAppListRsp();
        try
        {
          paramSparseArray.mergeFrom(((awai)localObject1).a);
          if (paramSparseArray != null)
          {
            Object localObject2 = paramSparseArray.userAppList.get();
            if ((localObject2 == null) || (((List)localObject2).size() < 1))
            {
              paramCard.isShowMiniPlaying = false;
              return true;
            }
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add(MiniAppInfo.from((INTERFACE.StUserAppInfo)((Iterator)localObject2).next()));
            }
          }
          paramCard.isShowMiniPlaying = true;
        }
        catch (Exception paramSparseArray)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "onResponse fail." + paramSparseArray);
          }
        }
      }
      for (;;)
      {
        return true;
        paramCard.miniAppInfoArrayList = ((ArrayList)localObject1);
        if ((paramSparseArray.extInfo != null) && (paramSparseArray.extInfo.mapInfo != null))
        {
          while (i < paramSparseArray.extInfo.mapInfo.size())
          {
            localObject1 = (COMM.Entry)paramSparseArray.extInfo.mapInfo.get(i);
            if ("jumpUrl".equals(((COMM.Entry)localObject1).key.get())) {
              paramCard.tabJumpUrl = ((COMM.Entry)localObject1).value.get();
            }
            i += 1;
          }
          continue;
          paramSparseArray = new MISC.StGetFriendPlayListV2Rsp();
          try
          {
            paramSparseArray.mergeFrom(((awai)localObject1).a);
            if (paramSparseArray == null) {
              continue;
            }
            paramCard.appPlayingInfos = paramSparseArray.appPlayingInfos.get();
            if ((paramCard.appPlayingInfos != null) && (paramCard.appPlayingInfos.size() >= 1)) {
              break label339;
            }
            paramCard.isShowMiniPlaying = false;
            return true;
          }
          catch (InvalidProtocolBufferMicroException paramSparseArray)
          {
            paramSparseArray.printStackTrace();
          }
          continue;
          label339:
          paramCard.guestJumpUrl = paramSparseArray.moreJumpLink.get();
          paramCard.guestAppTotal = paramSparseArray.total.get();
        }
      }
    }
    paramCard.isShowMiniPlaying = false;
    return true;
  }
  
  private void aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 300;
    boolean bool3 = false;
    boolean bool2 = false;
    oidb_0xc33.RspBody localRspBody = new oidb_0xc33.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1;
    int j;
    if (k == 0) {
      if (localRspBody.uint32_result.get() == 1)
      {
        bool1 = true;
        j = localRspBody.uint32_next_gap.get();
        if (localRspBody.uint32_new_user.get() > 0) {
          bool2 = true;
        }
        if (j > 0) {
          break label210;
        }
        label78:
        if ((paramToServiceMsg != null) && (TextUtils.equals(this.app.c(), paramToServiceMsg.getUin()))) {
          ((afgd)this.app.getManager(295)).a(bool1, i, bool2);
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("CardHandler", 4, "handleGetBindPhoneSwitchInfo needShow:" + bool1 + " net_gap:" + i + " isNewUser:" + bool2 + " uin:" + this.app.c() + "  result:" + k);
      }
      return;
      bool1 = false;
      break;
      label210:
      i = j;
      break label78;
      i = 300;
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xcd5.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    bool2 = false;
    i = 0;
    bool1 = true;
    if (m == 0)
    {
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_cmd0xcd5.GetDataRsp)paramToServiceMsg.getdata_rsp.get();
          if ((paramToServiceMsg == null) || (!paramToServiceMsg.pb_data.has())) {
            continue;
          }
          paramToServiceMsg = paramToServiceMsg.pb_data.get().toByteArray();
          paramObject = new wording_storage.WordingCfg();
          paramObject.mergeFrom(paramToServiceMsg);
          if (paramObject.select_id.has()) {
            i = paramObject.select_id.get();
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int k;
          bool1 = true;
          i = 0;
          paramToServiceMsg.printStackTrace();
          QLog.e("CardHandler", 1, "handleGetAutoReplyList exception: " + paramToServiceMsg.getMessage());
          bool2 = false;
          continue;
          int j = 2147483647;
          continue;
          bool1 = true;
          i = 0;
          bool2 = false;
          continue;
        }
        try
        {
          j = paramObject.auto_reply_flag.get();
          if (j == 0) {
            bool1 = false;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          bool1 = true;
          continue;
        }
        try
        {
          paramToServiceMsg = paramObject.wording_list.get();
          j = 0;
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg = paramToServiceMsg.iterator();
          if (!paramToServiceMsg.hasNext()) {
            continue;
          }
          paramObject = ((im_msg_body.RichText)paramToServiceMsg.next()).elems.get();
          if ((paramObject == null) || (paramObject.size() <= 0)) {
            continue;
          }
          paramObject = new awbd().a(paramObject);
          if (TextUtils.isEmpty(paramObject)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetAutoReplyList, parse richText: " + paramObject + ", id: " + j);
          }
          k = j + 1;
          paramFromServiceMsg.add(new AutoReplyText(paramObject, j));
          j = k;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
          continue;
        }
        i = 0;
        continue;
        bool1 = true;
      }
      bool2 = true;
    }
    paramFromServiceMsg.add(new AutoReplyText(ajjy.a(2131635656), 2147483647));
    k = paramFromServiceMsg.size();
    if ((bool1) && (k > 1))
    {
      if (i >= 0)
      {
        j = i;
        if (i < k) {}
      }
      else
      {
        QLog.d("CardHandler", 1, "handleGetAutoReplyList, error select id: " + i);
        j = 0;
      }
      if (bool2) {
        ((atkz)this.app.getManager(319)).a(paramFromServiceMsg, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetAutoReplyList result: %s, isSuccess: %s, enableAutoReply: %s, replyList size: %s, selectId: %s", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      notifyUI(97, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(j) });
      return;
    }
  }
  
  private void ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xcd5.RspBody localRspBody = new oidb_cmd0xcd5.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool2 = false;
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("needNotify");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (localRspBody.setdata_rsp.has())
      {
        paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("replyMsgList");
        int j = paramToServiceMsg.extraData.getInt("selectId");
        ((atkz)this.app.getManager(319)).a(paramFromServiceMsg, j);
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleSetAutoReplyList, result = " + i);
    }
    if (bool3) {
      notifyUI(99, bool1, null);
    }
  }
  
  private void ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch success=" + bool1);
      }
      if (bool1) {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          label91:
          int i;
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            bool1 = bool2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch result=" + bool1);
            }
            if ((!bool1) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
              break label428;
            }
            i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
            if (i >= 0) {
              break label402;
            }
          }
          label402:
          for (long l = i + 4294967296L;; l = i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch uin=" + this.app.getCurrentAccountUin() + "  lUin:" + String.valueOf(l));
            }
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              break label428;
            }
            paramFromServiceMsg = (ajjj)this.app.getManager(51);
            paramObject = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
            bool1 = paramObject.strangerInviteMeGroupOpen;
            paramObject.strangerInviteMeGroupOpen = paramToServiceMsg.extraData.getBoolean("switch");
            paramFromServiceMsg.a(paramObject);
            bool2 = paramObject.strangerInviteMeGroupOpen;
            if (bool1 != bool2) {
              notifyUI(95, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch newConfigOn=" + bool2 + "  oldConfigOn:" + bool1);
            }
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label91;
          }
          notifyUI(95, false, null);
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch ex", paramToServiceMsg);
          }
        }
      }
    }
    label428:
  }
  
  /* Error */
  private void ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 9
    //   9: iconst_1
    //   10: istore 10
    //   12: iconst_1
    //   13: istore 11
    //   15: aload_2
    //   16: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +110 -> 129
    //   22: aload_3
    //   23: ifnull +106 -> 129
    //   26: iconst_1
    //   27: istore 7
    //   29: ldc_w 2026
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 2028
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 7
    //   48: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: istore 4
    //   60: iload 7
    //   62: ifne +79 -> 141
    //   65: iload 4
    //   67: istore 5
    //   69: ldc_w 2026
    //   72: iconst_2
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 2030
    //   83: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   90: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_1
    //   100: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc_w 2035
    //   106: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   109: ifne +26 -> 135
    //   112: iload 11
    //   114: istore 7
    //   116: aload_0
    //   117: bipush 105
    //   119: iconst_0
    //   120: iload 7
    //   122: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   128: return
    //   129: iconst_0
    //   130: istore 7
    //   132: goto -103 -> 29
    //   135: iconst_0
    //   136: istore 7
    //   138: goto -22 -> 116
    //   141: iload 4
    //   143: istore 5
    //   145: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   148: dup
    //   149: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   152: aload_3
    //   153: checkcast 110	[B
    //   156: checkcast 110	[B
    //   159: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   162: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   165: astore_2
    //   166: iload 4
    //   168: istore 5
    //   170: iload 4
    //   172: istore 6
    //   174: aload_2
    //   175: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   178: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   181: ifne +100 -> 281
    //   184: iconst_1
    //   185: istore 5
    //   187: iload 5
    //   189: ifne +104 -> 293
    //   192: iload 4
    //   194: istore 5
    //   196: iload 4
    //   198: istore 6
    //   200: aload_2
    //   201: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   204: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   207: ifeq +86 -> 293
    //   210: iload 4
    //   212: istore 5
    //   214: iload 4
    //   216: istore 6
    //   218: ldc_w 2026
    //   221: iconst_2
    //   222: new 20	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 2037
    //   232: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   239: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   242: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 2035
    //   258: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   261: ifne +26 -> 287
    //   264: iload 12
    //   266: istore 7
    //   268: aload_0
    //   269: bipush 105
    //   271: iconst_0
    //   272: iload 7
    //   274: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   280: return
    //   281: iconst_0
    //   282: istore 5
    //   284: goto -97 -> 187
    //   287: iconst_0
    //   288: istore 7
    //   290: goto -22 -> 268
    //   293: iload 4
    //   295: istore 5
    //   297: iload 4
    //   299: istore 6
    //   301: new 2039	tencent/im/oidb/cmd0xd8a$RspBody
    //   304: dup
    //   305: invokespecial 2040	tencent/im/oidb/cmd0xd8a$RspBody:<init>	()V
    //   308: astore_3
    //   309: iload 4
    //   311: istore 5
    //   313: iload 4
    //   315: istore 6
    //   317: aload_3
    //   318: aload_2
    //   319: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   328: invokevirtual 2041	tencent/im/oidb/cmd0xd8a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   331: pop
    //   332: iload 4
    //   334: istore 5
    //   336: iload 4
    //   338: istore 6
    //   340: aload_3
    //   341: getfield 2044	tencent/im/oidb/cmd0xd8a$RspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   344: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   347: istore 4
    //   349: iload 4
    //   351: istore 5
    //   353: iload 4
    //   355: istore 6
    //   357: aload_3
    //   358: getfield 2047	tencent/im/oidb/cmd0xd8a$RspBody:str_res	Lcom/tencent/mobileqq/pb/PBStringField;
    //   361: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   364: astore_2
    //   365: iload 4
    //   367: istore 5
    //   369: iload 4
    //   371: istore 6
    //   373: ldc_w 2026
    //   376: iconst_1
    //   377: new 20	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 2049
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 2051
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc_w 2035
    //   418: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   421: istore 7
    //   423: iload 4
    //   425: ifne +12 -> 437
    //   428: aload_0
    //   429: bipush 105
    //   431: iconst_1
    //   432: aconst_null
    //   433: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   436: return
    //   437: iload 7
    //   439: ifne +20 -> 459
    //   442: iload 8
    //   444: istore 7
    //   446: aload_0
    //   447: bipush 105
    //   449: iconst_0
    //   450: iload 7
    //   452: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   458: return
    //   459: iconst_0
    //   460: istore 7
    //   462: goto -16 -> 446
    //   465: astore_2
    //   466: iconst_0
    //   467: istore 5
    //   469: iload 5
    //   471: ifeq +60 -> 531
    //   474: iload 4
    //   476: istore 5
    //   478: ldc_w 2026
    //   481: iconst_1
    //   482: new 20	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 2053
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_2
    //   496: invokevirtual 1039	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_1
    //   506: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   509: ldc_w 2035
    //   512: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   515: istore 7
    //   517: iload 4
    //   519: ifne +74 -> 593
    //   522: aload_0
    //   523: bipush 105
    //   525: iconst_1
    //   526: aconst_null
    //   527: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   530: return
    //   531: iload 4
    //   533: istore 5
    //   535: ldc_w 2026
    //   538: iconst_1
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 2055
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_2
    //   553: invokevirtual 1039	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -57 -> 505
    //   565: astore_2
    //   566: aload_1
    //   567: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   570: ldc_w 2035
    //   573: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   576: istore 7
    //   578: iload 5
    //   580: ifne +41 -> 621
    //   583: aload_0
    //   584: bipush 105
    //   586: iconst_1
    //   587: aconst_null
    //   588: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   591: aload_2
    //   592: athrow
    //   593: iload 7
    //   595: ifne +20 -> 615
    //   598: iload 9
    //   600: istore 7
    //   602: aload_0
    //   603: bipush 105
    //   605: iconst_0
    //   606: iload 7
    //   608: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   611: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   614: return
    //   615: iconst_0
    //   616: istore 7
    //   618: goto -16 -> 602
    //   621: iload 7
    //   623: ifne +22 -> 645
    //   626: iload 10
    //   628: istore 7
    //   630: aload_0
    //   631: bipush 105
    //   633: iconst_0
    //   634: iload 7
    //   636: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   639: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   642: goto -51 -> 591
    //   645: iconst_0
    //   646: istore 7
    //   648: goto -18 -> 630
    //   651: astore_2
    //   652: iconst_1
    //   653: istore 5
    //   655: iload 6
    //   657: istore 4
    //   659: goto -190 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	ajfi
    //   0	662	1	paramToServiceMsg	ToServiceMsg
    //   0	662	2	paramFromServiceMsg	FromServiceMsg
    //   0	662	3	paramObject	Object
    //   58	600	4	i	int
    //   67	587	5	j	int
    //   172	484	6	k	int
    //   27	620	7	bool1	boolean
    //   4	439	8	bool2	boolean
    //   7	592	9	bool3	boolean
    //   10	617	10	bool4	boolean
    //   13	100	11	bool5	boolean
    //   1	264	12	bool6	boolean
    // Exception table:
    //   from	to	target	type
    //   69	99	465	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	166	465	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   69	99	565	finally
    //   145	166	565	finally
    //   174	184	565	finally
    //   200	210	565	finally
    //   218	251	565	finally
    //   301	309	565	finally
    //   317	332	565	finally
    //   340	349	565	finally
    //   357	365	565	finally
    //   373	411	565	finally
    //   478	505	565	finally
    //   535	562	565	finally
    //   174	184	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   200	210	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   218	251	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	309	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   317	332	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   340	349	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   357	365	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   373	411	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: aload_2
    //   7: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   10: ifeq +384 -> 394
    //   13: aload_3
    //   14: ifnull +380 -> 394
    //   17: iconst_1
    //   18: istore 4
    //   20: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +30 -> 53
    //   26: ldc 97
    //   28: iconst_2
    //   29: new 20	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 2058
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iload 4
    //   55: istore 8
    //   57: iload 10
    //   59: istore 6
    //   61: iload 4
    //   63: ifeq +266 -> 329
    //   66: iload 4
    //   68: istore 7
    //   70: iload 4
    //   72: istore 5
    //   74: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 110	[B
    //   85: checkcast 110	[B
    //   88: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: iload 4
    //   97: istore 7
    //   99: iload 4
    //   101: istore 5
    //   103: aload_2
    //   104: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: ifne +290 -> 400
    //   113: iconst_1
    //   114: istore 4
    //   116: iload 4
    //   118: istore 7
    //   120: iload 4
    //   122: istore 5
    //   124: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +38 -> 165
    //   130: iload 4
    //   132: istore 7
    //   134: iload 4
    //   136: istore 5
    //   138: ldc 97
    //   140: iconst_2
    //   141: new 20	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 2060
    //   151: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload 4
    //   156: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload 4
    //   167: istore 8
    //   169: iload 10
    //   171: istore 6
    //   173: iload 4
    //   175: ifeq +154 -> 329
    //   178: iload 4
    //   180: istore 8
    //   182: iload 10
    //   184: istore 6
    //   186: iload 4
    //   188: istore 7
    //   190: iload 4
    //   192: istore 5
    //   194: aload_2
    //   195: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   201: ifeq +128 -> 329
    //   204: iload 4
    //   206: istore 8
    //   208: iload 10
    //   210: istore 6
    //   212: iload 4
    //   214: istore 7
    //   216: iload 4
    //   218: istore 5
    //   220: aload_2
    //   221: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +102 -> 329
    //   230: iload 4
    //   232: istore 7
    //   234: iload 4
    //   236: istore 5
    //   238: aload_2
    //   239: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   254: invokestatic 901	azzz:a	(I)J
    //   257: lstore 11
    //   259: iload 4
    //   261: istore 7
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 11
    //   276: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +124 -> 406
    //   285: iload 4
    //   287: istore 7
    //   289: iload 4
    //   291: istore 5
    //   293: aload_1
    //   294: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   297: ldc_w 2062
    //   300: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   303: istore 6
    //   305: iload 6
    //   307: istore 5
    //   309: aload_0
    //   310: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   313: invokestatic 2067	aemi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laemi;
    //   316: iload 5
    //   318: invokevirtual 2070	aemi:a	(Z)V
    //   321: iload 5
    //   323: istore 6
    //   325: iload 4
    //   327: istore 8
    //   329: iload 6
    //   331: istore 4
    //   333: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +45 -> 381
    //   339: ldc 97
    //   341: iconst_2
    //   342: new 20	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 2060
    //   352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 8
    //   357: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   360: ldc_w 2072
    //   363: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: iload 6
    //   368: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   371: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 6
    //   379: istore 4
    //   381: aload_0
    //   382: bipush 104
    //   384: iconst_1
    //   385: iload 4
    //   387: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   390: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   393: return
    //   394: iconst_0
    //   395: istore 4
    //   397: goto -377 -> 20
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -287 -> 116
    //   406: iload 4
    //   408: istore 8
    //   410: iload 10
    //   412: istore 6
    //   414: iload 4
    //   416: istore 7
    //   418: iload 4
    //   420: istore 5
    //   422: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -96 -> 329
    //   428: iload 4
    //   430: istore 7
    //   432: iload 4
    //   434: istore 5
    //   436: ldc 97
    //   438: iconst_2
    //   439: new 20	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 2074
    //   449: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   459: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 905
    //   465: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: lload 11
    //   470: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: iload 4
    //   481: istore 8
    //   483: iload 10
    //   485: istore 6
    //   487: goto -158 -> 329
    //   490: astore_1
    //   491: iload 7
    //   493: istore 5
    //   495: iconst_0
    //   496: istore 4
    //   498: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +13 -> 514
    //   504: ldc 97
    //   506: iconst_1
    //   507: ldc_w 2076
    //   510: aload_1
    //   511: invokestatic 2078	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   514: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +134 -> 651
    //   520: ldc 97
    //   522: iconst_2
    //   523: new 20	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 2060
    //   533: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: iconst_0
    //   537: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc_w 2072
    //   543: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 4
    //   548: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   551: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -176 -> 381
    //   560: astore_1
    //   561: iload 9
    //   563: istore 6
    //   565: iload 5
    //   567: istore 4
    //   569: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +41 -> 613
    //   575: ldc 97
    //   577: iconst_2
    //   578: new 20	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 2060
    //   588: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: ldc_w 2072
    //   599: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 6
    //   604: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   607: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_1
    //   614: athrow
    //   615: astore_1
    //   616: iload 5
    //   618: istore 6
    //   620: goto -51 -> 569
    //   623: astore_1
    //   624: iload 4
    //   626: istore 6
    //   628: iload 5
    //   630: istore 4
    //   632: goto -63 -> 569
    //   635: astore_1
    //   636: iload 4
    //   638: istore 6
    //   640: iload 5
    //   642: istore 4
    //   644: iload 6
    //   646: istore 5
    //   648: goto -150 -> 498
    //   651: goto -270 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	ajfi
    //   0	654	1	paramToServiceMsg	ToServiceMsg
    //   0	654	2	paramFromServiceMsg	FromServiceMsg
    //   0	654	3	paramObject	Object
    //   18	625	4	bool1	boolean
    //   72	575	5	bool2	boolean
    //   59	586	6	bool3	boolean
    //   68	424	7	bool4	boolean
    //   55	427	8	bool5	boolean
    //   1	561	9	bool6	boolean
    //   4	480	10	bool7	boolean
    //   257	212	11	l	long
    // Exception table:
    //   from	to	target	type
    //   74	95	490	java/lang/Exception
    //   103	113	490	java/lang/Exception
    //   124	130	490	java/lang/Exception
    //   138	165	490	java/lang/Exception
    //   194	204	490	java/lang/Exception
    //   220	230	490	java/lang/Exception
    //   238	259	490	java/lang/Exception
    //   267	285	490	java/lang/Exception
    //   293	305	490	java/lang/Exception
    //   422	428	490	java/lang/Exception
    //   436	479	490	java/lang/Exception
    //   74	95	560	finally
    //   103	113	560	finally
    //   124	130	560	finally
    //   138	165	560	finally
    //   194	204	560	finally
    //   220	230	560	finally
    //   238	259	560	finally
    //   267	285	560	finally
    //   293	305	560	finally
    //   422	428	560	finally
    //   436	479	560	finally
    //   309	321	615	finally
    //   498	514	623	finally
    //   309	321	635	java/lang/Exception
  }
  
  /* Error */
  private void ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 12
    //   12: aload_2
    //   13: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +414 -> 430
    //   19: aload_3
    //   20: ifnull +410 -> 430
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 607
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 2081
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 6
    //   64: iload 12
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +285 -> 355
    //   73: iload 5
    //   75: istore 10
    //   77: iload 5
    //   79: istore 7
    //   81: iload 14
    //   83: istore 9
    //   85: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 110	[B
    //   96: checkcast 110	[B
    //   99: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +329 -> 436
    //   110: iload 5
    //   112: istore 10
    //   114: iload 5
    //   116: istore 7
    //   118: iload 14
    //   120: istore 9
    //   122: aload_2
    //   123: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +307 -> 436
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 6
    //   139: iload 12
    //   141: istore 8
    //   143: iload 5
    //   145: ifeq +210 -> 355
    //   148: iload 5
    //   150: istore 6
    //   152: iload 12
    //   154: istore 8
    //   156: iload 5
    //   158: istore 10
    //   160: iload 5
    //   162: istore 7
    //   164: iload 14
    //   166: istore 9
    //   168: aload_2
    //   169: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   172: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   175: ifeq +180 -> 355
    //   178: iload 5
    //   180: istore 6
    //   182: iload 12
    //   184: istore 8
    //   186: iload 5
    //   188: istore 10
    //   190: iload 5
    //   192: istore 7
    //   194: iload 14
    //   196: istore 9
    //   198: aload_2
    //   199: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   205: ifnull +150 -> 355
    //   208: iload 5
    //   210: istore 10
    //   212: iload 5
    //   214: istore 7
    //   216: iload 14
    //   218: istore 9
    //   220: aload_2
    //   221: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   230: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   233: astore_2
    //   234: iload 5
    //   236: istore 10
    //   238: iload 5
    //   240: istore 7
    //   242: iload 14
    //   244: istore 9
    //   246: aload_2
    //   247: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   250: istore 4
    //   252: iload 4
    //   254: i2l
    //   255: lstore 15
    //   257: iload 4
    //   259: ifge +12 -> 271
    //   262: iload 4
    //   264: ldc_w 939
    //   267: iand
    //   268: i2l
    //   269: lstore 15
    //   271: iload 5
    //   273: istore 10
    //   275: iload 5
    //   277: istore 7
    //   279: iload 14
    //   281: istore 9
    //   283: aload_2
    //   284: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   287: pop
    //   288: iload 5
    //   290: istore 6
    //   292: iload 12
    //   294: istore 8
    //   296: iload 5
    //   298: istore 10
    //   300: iload 5
    //   302: istore 7
    //   304: iload 14
    //   306: istore 9
    //   308: aload_2
    //   309: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   312: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   315: invokevirtual 617	java/lang/Short:shortValue	()S
    //   318: iconst_1
    //   319: if_icmpne +36 -> 355
    //   322: iload 5
    //   324: istore 10
    //   326: iload 5
    //   328: istore 7
    //   330: iload 14
    //   332: istore 9
    //   334: aload_2
    //   335: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   338: istore 4
    //   340: iload 4
    //   342: sipush -23234
    //   345: if_icmpeq +97 -> 442
    //   348: iconst_0
    //   349: istore 6
    //   351: iload 12
    //   353: istore 8
    //   355: iload 6
    //   357: istore 7
    //   359: iload 8
    //   361: istore 9
    //   363: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +50 -> 416
    //   369: ldc_w 607
    //   372: iconst_2
    //   373: new 20	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 2083
    //   383: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload 6
    //   388: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   391: ldc_w 2085
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: iload 8
    //   399: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   402: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 8
    //   410: istore 9
    //   412: iload 6
    //   414: istore 7
    //   416: aload_0
    //   417: bipush 103
    //   419: iload 7
    //   421: iload 9
    //   423: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   426: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   429: return
    //   430: iconst_0
    //   431: istore 5
    //   433: goto -407 -> 26
    //   436: iconst_0
    //   437: istore 5
    //   439: goto -304 -> 135
    //   442: iload 5
    //   444: istore 10
    //   446: iload 5
    //   448: istore 7
    //   450: iload 14
    //   452: istore 9
    //   454: aload_2
    //   455: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   458: istore 4
    //   460: iload 4
    //   462: iconst_2
    //   463: if_icmpne +180 -> 643
    //   466: iload 5
    //   468: istore 10
    //   470: iload 5
    //   472: istore 7
    //   474: iload 14
    //   476: istore 9
    //   478: iload 4
    //   480: newarray byte
    //   482: astore_3
    //   483: iload 5
    //   485: istore 10
    //   487: iload 5
    //   489: istore 7
    //   491: iload 14
    //   493: istore 9
    //   495: aload_2
    //   496: aload_3
    //   497: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   500: pop
    //   501: iload 5
    //   503: istore 10
    //   505: iload 5
    //   507: istore 7
    //   509: iload 14
    //   511: istore 9
    //   513: aload_3
    //   514: iconst_0
    //   515: invokestatic 631	azzz:a	([BI)S
    //   518: istore 4
    //   520: iload 4
    //   522: ifne +32 -> 554
    //   525: iconst_1
    //   526: istore 6
    //   528: aload_2
    //   529: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   532: istore 4
    //   534: iload 4
    //   536: ifeq +24 -> 560
    //   539: iload 11
    //   541: istore 5
    //   543: iload 6
    //   545: istore 8
    //   547: iload 5
    //   549: istore 6
    //   551: goto -196 -> 355
    //   554: iconst_0
    //   555: istore 6
    //   557: goto -29 -> 528
    //   560: getstatic 2089	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   563: aload_0
    //   564: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   570: aconst_null
    //   571: ldc_w 2091
    //   574: invokestatic 2095	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isContainValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   577: istore 5
    //   579: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +30 -> 612
    //   585: ldc 97
    //   587: iconst_2
    //   588: new 20	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 2097
    //   598: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 5
    //   603: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_0
    //   613: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   616: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   619: aload_1
    //   620: invokevirtual 1905	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   623: aconst_null
    //   624: ldc_w 2091
    //   627: iload 6
    //   629: invokestatic 2101	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   632: iload 6
    //   634: invokestatic 2104	befx:a	(Z)V
    //   637: iconst_1
    //   638: istore 5
    //   640: goto -97 -> 543
    //   643: iconst_0
    //   644: istore 6
    //   646: iload 12
    //   648: istore 8
    //   650: goto -295 -> 355
    //   653: astore_1
    //   654: iload 13
    //   656: istore 6
    //   658: iload 10
    //   660: istore 5
    //   662: iload 5
    //   664: istore 7
    //   666: iload 6
    //   668: istore 9
    //   670: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +22 -> 695
    //   676: iload 5
    //   678: istore 7
    //   680: iload 6
    //   682: istore 9
    //   684: ldc_w 607
    //   687: iconst_2
    //   688: ldc_w 2106
    //   691: aload_1
    //   692: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: iload 5
    //   697: istore 7
    //   699: iload 6
    //   701: istore 9
    //   703: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -290 -> 416
    //   709: ldc_w 607
    //   712: iconst_2
    //   713: new 20	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 2083
    //   723: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: iload 5
    //   728: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: ldc_w 2085
    //   734: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 6
    //   739: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   742: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: iload 5
    //   750: istore 7
    //   752: iload 6
    //   754: istore 9
    //   756: goto -340 -> 416
    //   759: astore_1
    //   760: iload 7
    //   762: istore 5
    //   764: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   767: ifeq +42 -> 809
    //   770: ldc_w 607
    //   773: iconst_2
    //   774: new 20	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 2083
    //   784: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: iload 5
    //   789: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: ldc_w 2085
    //   795: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: iload 9
    //   800: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   803: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: aload_1
    //   810: athrow
    //   811: astore_1
    //   812: iload 6
    //   814: istore 9
    //   816: goto -52 -> 764
    //   819: astore_1
    //   820: iconst_1
    //   821: istore 5
    //   823: iload 6
    //   825: istore 9
    //   827: goto -63 -> 764
    //   830: astore_1
    //   831: goto -169 -> 662
    //   834: astore_1
    //   835: iconst_1
    //   836: istore 5
    //   838: goto -176 -> 662
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	ajfi
    //   0	841	1	paramToServiceMsg	ToServiceMsg
    //   0	841	2	paramFromServiceMsg	FromServiceMsg
    //   0	841	3	paramObject	Object
    //   250	285	4	i	int
    //   24	813	5	bool1	boolean
    //   62	762	6	bool2	boolean
    //   79	682	7	bool3	boolean
    //   66	583	8	bool4	boolean
    //   83	743	9	bool5	boolean
    //   75	584	10	bool6	boolean
    //   1	539	11	bool7	boolean
    //   10	637	12	bool8	boolean
    //   4	651	13	bool9	boolean
    //   7	503	14	bool10	boolean
    //   255	15	15	l	long
    // Exception table:
    //   from	to	target	type
    //   85	106	653	java/lang/Exception
    //   122	132	653	java/lang/Exception
    //   168	178	653	java/lang/Exception
    //   198	208	653	java/lang/Exception
    //   220	234	653	java/lang/Exception
    //   246	252	653	java/lang/Exception
    //   283	288	653	java/lang/Exception
    //   308	322	653	java/lang/Exception
    //   334	340	653	java/lang/Exception
    //   454	460	653	java/lang/Exception
    //   478	483	653	java/lang/Exception
    //   495	501	653	java/lang/Exception
    //   513	520	653	java/lang/Exception
    //   85	106	759	finally
    //   122	132	759	finally
    //   168	178	759	finally
    //   198	208	759	finally
    //   220	234	759	finally
    //   246	252	759	finally
    //   283	288	759	finally
    //   308	322	759	finally
    //   334	340	759	finally
    //   454	460	759	finally
    //   478	483	759	finally
    //   495	501	759	finally
    //   513	520	759	finally
    //   670	676	759	finally
    //   684	695	759	finally
    //   528	534	811	finally
    //   560	612	819	finally
    //   612	637	819	finally
    //   528	534	830	java/lang/Exception
    //   560	612	834	java/lang/Exception
    //   612	637	834	java/lang/Exception
  }
  
  private void ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleGetEducationList " + l);
    }
    Object localObject = new oidb_cmd0xd2d.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (i == 0)
    {
      paramToServiceMsg = new ArrayList(5);
      if (((oidb_cmd0xd2d.RspBody)localObject).msg_edu_his.has())
      {
        paramFromServiceMsg = (oidb_cmd0xd2d.EduHis)((oidb_cmd0xd2d.RspBody)localObject).msg_edu_his.get();
        if (paramFromServiceMsg.rpt_msg_school.has())
        {
          paramFromServiceMsg = paramFromServiceMsg.rpt_msg_school.get().iterator();
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (oidb_cmd0xd2d.SchoolInfo)paramFromServiceMsg.next();
            localObject = new atxp();
            ((atxp)localObject).jdField_a_of_type_Int = paramObject.uint32_idx.get();
            ((atxp)localObject).jdField_c_of_type_JavaLangString = paramObject.str_department_id.get();
            ((atxp)localObject).jdField_d_of_type_JavaLangString = paramObject.str_department_name.get();
            ((atxp)localObject).jdField_a_of_type_JavaLangString = paramObject.str_school_id.get();
            ((atxp)localObject).jdField_b_of_type_JavaLangString = paramObject.str_school_name.get();
            ((atxp)localObject).jdField_b_of_type_Int = paramObject.uint32_category.get();
            ((atxp)localObject).jdField_c_of_type_Int = paramObject.uint32_degree.get();
            ((atxp)localObject).jdField_a_of_type_Long = paramObject.uint32_enrollment_year.get();
            ((atxp)localObject).jdField_b_of_type_Long = paramObject.uint32_graduation_year.get();
            ((atxp)localObject).jdField_d_of_type_Int = paramObject.uint32_allow_recommend.get();
            paramToServiceMsg.add(localObject);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetEducationList " + paramToServiceMsg.toString());
      }
      ((alov)this.app.getManager(112)).a(paramToServiceMsg);
      notifyUI(101, true, new Object[] { Long.valueOf(l), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetEducationList failed result:" + i);
    }
    notifyUI(101, false, new Object[] { Long.valueOf(l), null });
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i < j - 1) {
        localStringBuffer.append(";");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    paramObject = paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    paramBundle.putInt("favoriteSource", i);
    paramBundle.putInt("iCount", j);
    paramBundle.putInt("from", k);
    if ((paramObject != null) && ((paramObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramFromServiceMsg.put("param_FailCode", "0");
      }
      for (;;)
      {
        awrn.a(this.app.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramFromServiceMsg, "", false);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, String.format("handleFavorite result=%s targetUin=%s iCount=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j) }));
        }
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = (Card)this.app.getEntityManagerFactory().createEntityManager().a(Card.class, l1);
          if (paramToServiceMsg != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.", 2, String.format("handleFavorite card in db: lVoteCount=%s bVoted=%s bAvailVoteCnt=%s", new Object[] { Long.valueOf(paramToServiceMsg.lVoteCount), Byte.valueOf(paramToServiceMsg.bVoted), Short.valueOf(paramToServiceMsg.bAvailVoteCnt) }));
            }
            paramToServiceMsg.lVoteCount += j;
            paramToServiceMsg.bVoted = 1;
            paramToServiceMsg.bAvailVoteCnt = ((short)(paramToServiceMsg.bAvailVoteCnt - j));
            if (paramToServiceMsg.bAvailVoteCnt < 0) {
              paramToServiceMsg.bAvailVoteCnt = 0;
            }
            ((ajjj)this.app.getManager(51)).a(paramToServiceMsg);
          }
          baaa.a(this.app, l1, j);
        }
        notifyUI(32, bool1, paramBundle);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramFromServiceMsg.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (paramObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label571:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (paramObject == null) {
        break label647;
      }
    }
    label647:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      awrn.a(this.app.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label571;
    }
  }
  
  private boolean b(Card paramCard, SparseArray<awai> paramSparseArray)
  {
    Object localObject1 = (awai)paramSparseArray.get(16);
    if ((localObject1 != null) && (((awai)localObject1).a != null)) {
      paramSparseArray = new VaProfileGate.VaProfileGateRsp();
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        paramSparseArray.mergeFrom(((awai)localObject1).a);
        if (paramSparseArray.iRetCode.get() != 0) {
          break label997;
        }
        localObject1 = paramSparseArray.stPrivilegeRsp;
        localObject2 = paramSparseArray.stGiftRsp;
        i = 0;
        if (i < paramSparseArray.rpt_task_item.size())
        {
          localObject3 = (VaProfileGate.CommTaskInfo)paramSparseArray.rpt_task_item.get(i);
          if (4 != ((VaProfileGate.CommTaskInfo)localObject3).uint32_appid.get()) {
            break label1065;
          }
          atyz.a((VaProfileGate.CommTaskInfo)localObject3, paramCard);
          break label1065;
        }
        paramCard.presentDesc = ((VaProfileGate.GetGiftListRsp)localObject2).desc.get();
        paramCard.presentCustourl = ((VaProfileGate.GetGiftListRsp)localObject2).custom_url.get();
        paramCard.presentSwitch = ((VaProfileGate.GetGiftListRsp)localObject2).is_on.get();
        paramCard.presentUrl = ((VaProfileGate.GetGiftListRsp)localObject2).gift_url.get();
        if (((VaProfileGate.GetGiftListRsp)localObject2).is_on.get())
        {
          awqx.b(this.app, "", "", "", "0X800A1CA", "0X800A1CA", 0, 0, "", "", "", "");
          if (paramCard.presentUrl.size() > 0)
          {
            paramCard.showPresent = true;
            if ((!paramSparseArray.stPrivilegeRsp.has()) || (((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).uIsGrayUsr.get() == 0)) {
              break label690;
            }
            paramCard.privilegePromptStr = ((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).strMsg.get().toStringUtf8();
            paramCard.privilegeJumpUrl = ((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).strJumpUrl.get().toStringUtf8();
            localObject2 = new ArrayList();
            i = 0;
            if (i >= ((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).vOpenPriv.size()) {
              break label489;
            }
            localObject3 = (VaProfileGate.PrivilegeInfo)((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).vOpenPriv.get(i);
            ((ArrayList)localObject2).add(new PrivilegeInfo(((VaProfileGate.PrivilegeInfo)localObject3).iType.get(), ((VaProfileGate.PrivilegeInfo)localObject3).iSort.get(), ((VaProfileGate.PrivilegeInfo)localObject3).iFeeType.get(), ((VaProfileGate.PrivilegeInfo)localObject3).iLevel.get(), ((VaProfileGate.PrivilegeInfo)localObject3).iFlag.get(), ((VaProfileGate.PrivilegeInfo)localObject3).strIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject3).strDeluxeIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject3).strJumpUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject3).iIsBig.get()));
            i += 1;
            continue;
          }
        }
        else
        {
          awqx.b(this.app, "", "", "", "0X800A1CB", "0X800A1CB", 0, 0, "", "", "", "");
          continue;
        }
        paramCard.showPresent = false;
      }
      catch (InvalidProtocolBufferMicroException paramCard)
      {
        QLog.e("DIYProfileTemplate.CardHandler", 1, "rsp VASPROFILEGATE_SERVICE decode error:" + paramCard);
        return false;
      }
      continue;
      label489:
      Object localObject3 = new ArrayList();
      int i = 0;
      while (i < ((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).vClosePriv.size())
      {
        VaProfileGate.PrivilegeInfo localPrivilegeInfo = (VaProfileGate.PrivilegeInfo)((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).vClosePriv.get(i);
        ((ArrayList)localObject3).add(new PrivilegeInfo(localPrivilegeInfo.iType.get(), localPrivilegeInfo.iSort.get(), localPrivilegeInfo.iFeeType.get(), localPrivilegeInfo.iLevel.get(), localPrivilegeInfo.iFlag.get(), localPrivilegeInfo.strIconUrl.get().toStringUtf8(), localPrivilegeInfo.strDeluxeIconUrl.get().toStringUtf8(), localPrivilegeInfo.strJumpUrl.get().toStringUtf8(), localPrivilegeInfo.iIsBig.get()));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.CardHandler", 1, "save privilege open list=" + ((ArrayList)localObject2).size() + " close list=" + ((ArrayList)localObject3).size());
      }
      paramCard.savePrivilegeOpenedInfo((List)localObject2);
      paramCard.savePrivilegeClosedInfo((List)localObject3);
      label690:
      if (paramSparseArray.rpt_oidb_flag.has())
      {
        localObject2 = paramSparseArray.rpt_oidb_flag.get();
        i = 0;
        if (i < ((List)localObject2).size())
        {
          localObject3 = (VaProfileGate.OidbFlagInfo)((List)localObject2).get(i);
          if (((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get() == 42334) {
            localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
          }
          for (;;)
          {
            try
            {
              paramCard.mQQLevelType = Integer.parseInt((String)localObject3);
              i += 1;
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.e("DIYProfileTemplate.CardHandler", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error , valStr:" + (String)localObject3);
              continue;
            }
            if (((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get() == 42340)
            {
              localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
              try
              {
                paramCard.switch_musicbox = Short.parseShort((String)localObject3);
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                QLog.e("DIYProfileTemplate.CardHandler", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_MUSICBOX_SWITCH flag content error , valStr:" + (String)localObject3);
              }
            }
          }
        }
      }
      if (paramSparseArray.st_vip_care.has())
      {
        paramCard = (VaProfileGate.GetVipCareRsp)paramSparseArray.st_vip_care.get();
        i = paramCard.uint32_buss.get();
        int j = paramCard.uint32_notice.get();
        if ((i != 0) && (j != 0)) {
          ((baov)this.app.getManager(235)).a(i << 4 | j);
        }
      }
      if (!paramSparseArray.stPrivilegeRsp.has())
      {
        QLog.e("DIYProfileTemplate.CardHandler", 1, "rsp VASPROFILEGATE_SERVICE decode priv rsp is null!");
        return false;
      }
      if (((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).uIsGrayUsr.get() == 0)
      {
        QLog.e("DIYProfileTemplate.CardHandler", 1, "rsp VASPROFILEGATE_SERVICE current user is not gray user.");
        return false;
        label997:
        QLog.e("DIYProfileTemplate.CardHandler", 1, "rsp VASPROFILEGATE_SERVICE failed:" + paramSparseArray.iRetCode.get() + " msg=" + paramSparseArray.sRetMsg.get().toStringUtf8());
        return false;
      }
      return true;
      QLog.e("DIYProfileTemplate.CardHandler", 1, "rsp VASPROFILEGATE_SERVICE is null!");
      return false;
      label1065:
      i += 1;
    }
  }
  
  public static int c(Context paramContext)
  {
    int i = a(paramContext);
    if (i <= 240) {
      return 60;
    }
    if (i <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void c()
  {
    int k = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!((File)localObject).exists()) {}
    try
    {
      bool1 = ((File)localObject).mkdirs();
      if (bool1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("background");
        ((ArrayList)localObject).add("temp");
        ((ArrayList)localObject).add("HDAvatar");
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= jdField_a_of_type_JavaUtilVector.size()) {
            break;
          }
          ((ArrayList)localObject).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i)).intValue()));
          i += 1;
        }
        if (j < ((ArrayList)localObject).size())
        {
          localFile = new File(jdField_a_of_type_JavaLangString + "/" + (String)((ArrayList)localObject).get(j));
          if (localFile.exists()) {}
        }
      }
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          int j;
          File localFile;
          localFile.mkdir();
          label183:
          j += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        break label183;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    RespGetFavoriteList localRespGetFavoriteList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin());
      localRespGetFavoriteList = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      if (!QLog.isColorLevel()) {
        break label559;
      }
      paramFromServiceMsg = new StringBuilder(1024);
      paramFromServiceMsg.append("handleReqFavoriteList log [ ");
    }
    for (;;)
    {
      switch (localRespGetFavoriteList.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(3, 7);
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.append(" ]");
          QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      Iterator localIterator = localRespGetFavoriteList.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      int i = 0;
      label232:
      if (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 3;
        localArrayList.add(localCardProfile);
        if ((!QLog.isColorLevel()) || (paramFromServiceMsg == null)) {
          break label556;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label556:
      for (;;)
      {
        break label232;
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        if (paramToServiceMsg.extraData.getLong("nextMid", -1L) == 0L) {
          a(3);
        }
        b(paramToServiceMsg.getUin(), localArrayList);
        new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
        notifyUI(42, true, new Object[] { paramObject, paramBundle, localArrayList });
        break;
        paramToServiceMsg = ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
        return;
      }
      label559:
      paramFromServiceMsg = null;
    }
  }
  
  private void c(String paramString, List<CardProfile> paramList)
  {
    b(paramString, paramList);
  }
  
  private boolean c()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    long l1 = localSharedPreferences.getLong(this.app.c() + "sign_in_last_get_time", 0L);
    long l2 = localSharedPreferences.getLong(this.app.c() + "sign_in_next_get_time", 0L);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "shouldGetSignInInfo, last=" + l1 + ", next=" + l2 + ", now=" + l3);
    }
    if (Math.abs(l3 - l1) <= 600000L) {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "shouldGetSignInInfo, <10min");
      }
    }
    while (l3 < l2) {
      return false;
    }
    localSharedPreferences.edit().putLong(this.app.c() + "sign_in_last_get_time", l3).commit();
    return true;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqVoterList] resultCode = " + paramFromServiceMsg.getResultCode());
    }
    RespGetVoterList localRespGetVoterList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin());
      localRespGetVoterList = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqVoterList] replyCode = " + localRespGetVoterList.stHeader.iReplyCode);
      }
      if (!QLog.isColorLevel()) {
        break label799;
      }
      paramFromServiceMsg = new StringBuilder(1024);
      paramFromServiceMsg.append("handleReqVoterList log [ ");
    }
    for (;;)
    {
      switch (localRespGetVoterList.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(2, 7);
        paramBundle.putLong("respTime", localRespGetVoterList.RespTime);
        paramBundle.putLong("nextMid", localRespGetVoterList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetVoterList.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.append(" ]");
          QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      Object localObject1 = localRespGetVoterList.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      int i = 0;
      label308:
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom((UserProfile)localObject2);
        localCardProfile.type = 2;
        localArrayList.add(localCardProfile);
        if ((!QLog.isColorLevel()) || (paramFromServiceMsg == null)) {
          break label796;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label796:
      for (;;)
      {
        break label308;
        paramBundle.putLong("respTime", localRespGetVoterList.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", localRespGetVoterList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetVoterList.stUserData.strCookie);
        long l = paramToServiceMsg.extraData.getLong("nextMid", -1L);
        if (l == 0L) {
          a(2);
        }
        c(paramToServiceMsg.getUin(), localArrayList);
        localObject1 = new ArrayList(0);
        if (l == 0L)
        {
          if (localRespGetVoterList.vTodayFavoriteInfos != null)
          {
            localObject2 = localRespGetVoterList.vTodayFavoriteInfos.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add(Long.valueOf(((UserProfile)((Iterator)localObject2).next()).lEctID));
            }
          }
          b((List)localObject1);
        }
        i = localRespGetVoterList.iMaxFriendFavoriteCount;
        int j = localRespGetVoterList.iMaxStrangerFavoriteCount;
        int k = localRespGetVoterList.iTodayVoteCount;
        int m = localRespGetVoterList.iTodayVoteRank;
        int n = localRespGetVoterList.iTotalVoteCount;
        new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
        notifyUI(6, true, new Object[] { paramObject, paramBundle, localArrayList, localObject1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
        break;
        paramToServiceMsg = ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
        return;
      }
      label799:
      paramFromServiceMsg = null;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    int i = paramToServiceMsg.extraData.getInt("type");
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] resultCode = " + paramFromServiceMsg.getResultCode() + "targetUin:" + l2 + " type:" + i);
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = (RespDeleteVisitorRecord)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] replyCode = " + paramToServiceMsg.stHeader.iReplyCode);
      }
      switch (paramToServiceMsg.stHeader.iReplyCode)
      {
      default: 
        notifyUI(93, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
        return;
      }
      notifyUI(93, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
      return;
    }
    notifyUI(93, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramToServiceMsg = new oidb_0x7ba.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqLikeRankingList] result=" + i);
    }
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_info;
      paramObject = new ArrayList();
      i = 0;
      while (i < paramFromServiceMsg.size())
      {
        LikeRankingInfo localLikeRankingInfo = new LikeRankingInfo();
        oidb_0x7ba.PraiseInfo localPraiseInfo = (oidb_0x7ba.PraiseInfo)paramFromServiceMsg.get(i);
        localLikeRankingInfo.uin = localPraiseInfo.uint64_ddwuin.get();
        localLikeRankingInfo.likeCountOfToday = localPraiseInfo.uint32_praise_today_count.get();
        localLikeRankingInfo.totalLikeCount = localPraiseInfo.uint32_praise_total_count.get();
        localLikeRankingInfo.rankingNum = localPraiseInfo.uint32_rank_number.get();
        paramObject.add(localLikeRankingInfo);
        i += 1;
      }
      i = paramToServiceMsg.uint32_next_index.get();
      if (paramToServiceMsg.uint32_complete.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        notifyUI(78, true, new Object[] { paramObject, Integer.valueOf(i), Boolean.valueOf(bool), paramBundle.getString("uin") });
        return;
      }
    }
    notifyUI(78, false, paramBundle.getString("uin"));
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespAddFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramObject = paramToServiceMsg.extraData.getByteArray("filekey");
        ajjj localajjj = (ajjj)this.app.getManager(51);
        Card localCard = localajjj.c(paramToServiceMsg.getUin());
        localCard.uin = paramToServiceMsg.getUin();
        if (paramFromServiceMsg.uFaceTimeStamp > localCard.uFaceTimeStamp)
        {
          localCard.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
          localCard.addHeadPortrait(paramObject);
        }
        localCard.iFaceNum += 1;
        localajjj.a(localCard);
        azyk.a(paramObject);
        notifyUI(11, true, new Object[] { localCard, paramBundle });
        return;
      }
      paramBundle.putInt("retCode", paramFromServiceMsg.stHeader.iReplyCode);
      notifyUI(11, false, paramBundle);
      return;
    }
    notifyUI(11, false, paramBundle);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("timestamp");
    paramToServiceMsg = ((ajjj)this.app.getManager(51)).c(String.valueOf(Long.valueOf(l)));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespFaceInfo)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        if ((i != 0) && (paramFromServiceMsg.uFaceTimeStamp == paramToServiceMsg.uFaceTimeStamp)) {
          break label177;
        }
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.iFaceNum;
        paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
        paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.app.getEntityManagerFactory().createEntityManager().a(paramToServiceMsg);
      notifyUI(10, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      notifyUI(10, false, paramToServiceMsg);
      return;
      notifyUI(10, false, paramToServiceMsg);
      return;
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespGetCardSwitch)paramObject;
      long l1 = paramObject.uCloseNeighborVote;
      long l2 = paramObject.uCloseTimeGateVote;
      if (l1 == 0L)
      {
        bool1 = true;
        paramObject = (ascu)this.app.getManager(161);
        if (l1 != 0L) {
          break label241;
        }
        bool2 = true;
        label61:
        paramObject.b(bool2);
        paramObject = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).edit();
        String str = this.app.getApplication().getString(2131629597) + this.app.getCurrentAccountUin();
        if (l2 != 0L) {
          break label247;
        }
        bool2 = true;
        label131:
        paramObject.putBoolean(str, bool2).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        notifyUI(33, true, paramBundle);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetCardSwitches succuss " + paramFromServiceMsg.isSuccess() + " curSwitch:" + bool1);
      }
      return;
      bool1 = false;
      break;
      label241:
      bool2 = false;
      break label61;
      label247:
      bool2 = false;
      break label131;
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      notifyUI(33, false, paramBundle);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    boolean bool1;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool2) {
        if (paramObject.uCloseNeighborVote == 0L)
        {
          bool1 = true;
          ((ascu)this.app.getManager(161)).b(bool1);
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          notifyUI(34, true, paramBundle);
        }
      }
    }
    for (;;)
    {
      if (bool2) {
        awrn.a(BaseApplicationImpl.getContext()).a(this.app.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleSetCardSwitch succuss " + paramFromServiceMsg.isSuccess() + " forNearPeople:" + bool2 + " curSwitch:" + bool1);
      }
      return;
      bool1 = false;
      break;
      if (paramObject.uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        localSharedPreferences.edit().putBoolean(this.app.getApplication().getString(2131629597) + this.app.getCurrentAccountUin(), bool1).commit();
        break;
      }
      long l = paramToServiceMsg.extraData.getLong("target_value");
      paramObject = this.app;
      if (l == 0L)
      {
        bool1 = true;
        label315:
        if (paramObject.a(bool2, bool1)) {
          break label438;
        }
        if (!bool2) {
          break label389;
        }
      }
      label389:
      for (bool1 = ((ascu)this.app.getManager(161)).b();; bool1 = localSharedPreferences.getBoolean(this.app.getApplication().getString(2131629597) + this.app.getCurrentAccountUin(), false))
      {
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        paramBundle.putBoolean("current_switch", bool1);
        notifyUI(34, false, paramBundle);
        break;
        bool1 = false;
        break label315;
      }
      label438:
      bool1 = false;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    paramBundle.putInt("eSubCmd", i);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    switch (i)
    {
    default: 
      i = 3;
      if (26 == i) {
        a(this.app.getApp(), this.app.getCurrentAccountUin(), null);
      }
      paramBundle = (ajjj)this.app.getManager(51);
      if (paramFromServiceMsg.isSuccess()) {
        if (26 == i)
        {
          paramObject = paramBundle.b(paramToServiceMsg.getUin());
          paramFromServiceMsg = paramObject;
          if (paramObject != null)
          {
            paramObject.vBackground = paramToServiceMsg.extraData.getByteArray("vBackground");
            paramBundle.a(paramObject);
            paramFromServiceMsg = paramObject;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 41) {
        notifyUI(i, true, paramFromServiceMsg);
      }
      return;
      i = 24;
      break;
      i = 25;
      break;
      i = 26;
      break;
      i = 41;
      break;
      if (i == 24)
      {
        paramFromServiceMsg = (ajjj)this.app.getManager(51);
        paramFromServiceMsg.a(this.app.getCurrentAccountUin(), paramToServiceMsg.extraData.getByte("bIsSingle"));
        paramFromServiceMsg = paramFromServiceMsg.b(this.app.getCurrentAccountUin());
      }
      else
      {
        if (i == 41)
        {
          boolean bool;
          if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespSetCard)))
          {
            bool = true;
            label330:
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard success : " + bool + ", data : " + paramObject);
            }
            if ((paramObject == null) || (!bool)) {
              break label1194;
            }
            paramToServiceMsg = (RespSetCard)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard RespSetCard : " + paramToServiceMsg.toString());
            }
            if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
              break label1194;
            }
            paramObject = (SSummaryCardRsp)decodePacket(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
            if (paramObject == null) {
              break label1194;
            }
            if (QLog.isColorLevel()) {
              QLog.d("DIYProfileTemplate.ProfileCard.setcard", 2, "CardHandler->handleSetCard cardRsp(cardRsp.strDrawerCard = " + paramObject.strDrawerCard + " ) res : " + paramObject.res);
            }
            if (paramObject.res != 0) {
              break label992;
            }
            paramToServiceMsg = paramBundle.b(this.app.getCurrentAccountUin());
            if (paramToServiceMsg == null) {
              break label1189;
            }
            paramToServiceMsg.lCurrentStyleId = paramObject.styleid;
            paramToServiceMsg.backgroundUrl = paramObject.bgurl;
            paramToServiceMsg.lCurrentBgId = paramObject.bgid;
            paramToServiceMsg.backgroundColor = paramObject.color;
            paramToServiceMsg.dynamicCardFlag = paramObject.dynamicCardFlag;
            paramToServiceMsg.strZipUrl = paramObject.strZipUrl;
            paramToServiceMsg.strActiveUrl = paramObject.strActiveCardUrl;
            paramToServiceMsg.strDrawerCardUrl = paramObject.strDrawerCard;
            paramToServiceMsg.strWzryHeroUrl = paramObject.strWzryHeroUrl;
            paramToServiceMsg.strExtInfo = paramObject.extInfo;
            paramToServiceMsg.cardType = paramObject.cardType;
            paramToServiceMsg.diyDefaultText = paramObject.strDiyDefaultText;
            if (paramObject.stDiyComplicated != null) {
              break label967;
            }
            paramFromServiceMsg = "";
            paramToServiceMsg.diyComplicatedInfo = paramFromServiceMsg;
            paramToServiceMsg.cardId = paramObject.cardid;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "handleSetCard activeUrl = " + paramToServiceMsg.strActiveUrl);
            }
            paramFromServiceMsg = paramObject.bgtype;
            if (paramFromServiceMsg != null) {
              paramToServiceMsg.setBgType(paramFromServiceMsg);
            }
            if ((paramObject.wzryInfo != null) && (!paramObject.wzryInfo.isEmpty())) {
              paramToServiceMsg.setWzryHonorInfo(paramObject.wzryInfo);
            }
            paramToServiceMsg.templateRet = 0;
            if (paramObject.stDiyText != null)
            {
              paramToServiceMsg.diyTextFontId = paramObject.stDiyText.iFontId;
              paramToServiceMsg.diyText = paramObject.stDiyText.strText;
              paramToServiceMsg.diyTextScale = paramObject.stDiyText.fScaling;
              paramToServiceMsg.diyTextDegree = paramObject.stDiyText.fRotationAngle;
              paramToServiceMsg.diyTextTransparency = paramObject.stDiyText.fTransparency;
              if (!TextUtils.isEmpty(paramObject.stDiyText.strPoint))
              {
                paramFromServiceMsg = paramObject.stDiyText.strPoint.split("_");
                if (paramFromServiceMsg.length != 2) {}
              }
            }
          }
          for (;;)
          {
            try
            {
              paramToServiceMsg.diyTextLocX = Float.parseFloat(paramFromServiceMsg[0]);
              paramToServiceMsg.diyTextLocY = Float.parseFloat(paramFromServiceMsg[1]);
              paramBundle.a(paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.setcard", 1, "save template card to db style id = " + paramToServiceMsg.lCurrentStyleId);
              }
              paramFromServiceMsg = this.app.getPreferences();
              if (paramFromServiceMsg != null) {
                paramFromServiceMsg.edit().putBoolean("svip_profile_use_guide_shown_flag", false).commit();
              }
              paramFromServiceMsg = null;
              if (paramToServiceMsg != null) {
                paramFromServiceMsg = paramToServiceMsg;
              }
              notifyUI(i, true, paramFromServiceMsg);
              paramFromServiceMsg = paramToServiceMsg;
              break;
              bool = false;
              break label330;
              label967:
              paramFromServiceMsg = paramObject.stDiyComplicated.detail;
            }
            catch (Exception paramFromServiceMsg)
            {
              QLog.e("CardHandler", 1, "set card with diy text response:", paramFromServiceMsg);
              continue;
            }
            label992:
            paramToServiceMsg = "";
            if (!TextUtils.isEmpty(paramObject.emsg)) {
              paramToServiceMsg = paramObject.emsg;
            }
            QLog.e("QVipProfileCard.CardHandler", 1, "set friend profile card failed code=" + paramObject.res + " msg：" + paramToServiceMsg);
            paramFromServiceMsg = new android.util.Pair(Integer.valueOf(paramObject.res), paramObject);
            paramToServiceMsg = null;
            continue;
            notifyUI(i, false, paramBundle.c(this.app.getCurrentAccountUin()));
            if (QLog.isColorLevel()) {
              QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
            }
            bcad.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, ajjy.a(2131635655), true);
            return;
            label1189:
            paramFromServiceMsg = null;
            continue;
            label1194:
            paramFromServiceMsg = null;
            paramToServiceMsg = null;
          }
        }
        paramFromServiceMsg = null;
      }
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.app.a(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      if (!bool2) {
        bool1 = this.app.b(false);
      }
      notifyUI(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (ajjj)this.app.getManager(51);
        paramBundle = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
        paramBundle.setLabelList(paramToServiceMsg.likes.label);
        paramFromServiceMsg.a(paramBundle);
      }
      notifyUI(52, true, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    notifyUI(52, false, paramObject);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bcad.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, ajjy.a(2131635658), true);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
      if (!bool1) {
        break label148;
      }
    }
    label148:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.app.a(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.app.b(false);
        notifyUI(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (ajjj)this.app.getManager(51);
      localCard = paramBundle.c(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label254;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        localCard.setLabelList(paramToServiceMsg.likes.label);
        paramBundle.a(localCard);
      }
      notifyUI(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    notifyUI(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bcad.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, ajjy.a(2131635657), true);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i;
    Object localObject;
    boolean bool3;
    long l;
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i = -1000;
      localObject = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      l = paramToServiceMsg.extraData.getLong("fieldFlag", 0L);
      if (bool1) {
        j = i;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1361;
        }
        j = i;
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label1361;
        }
        j = i;
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {
          break label1355;
        }
        bool1 = true;
        StringBuilder localStringBuilder;
        String[] arrayOfString;
        boolean bool2;
        bool1 = false;
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + i + ", isNearbyPeopleCard = " + bool3);
            if ((i == 0) && (!bool3))
            {
              j = i;
              paramObject = (ajjj)this.app.getManager(51);
              j = i;
              paramFromServiceMsg = paramObject.c(this.app.getCurrentAccountUin());
              try
              {
                if (paramToServiceMsg.extraData.containsKey("nick"))
                {
                  paramFromServiceMsg.strNick = paramToServiceMsg.extraData.getString("nick");
                  paramObject.a(this.app.getCurrentAccountUin(), paramFromServiceMsg.strNick);
                  if ((this.app.getCurrentAccountUin() != null) && (this.app.getCurrentAccountUin().equals(paramToServiceMsg.getUin())))
                  {
                    localObject = Constants.PropertiesKey.nickName.toString() + paramToServiceMsg.getUin();
                    this.app.getApplication().setProperty((String)localObject, paramFromServiceMsg.strNick);
                    if (QLog.isColorLevel())
                    {
                      localStringBuilder = new StringBuilder("handleSetDetailInfo set properties");
                      localStringBuilder.append("uin = ").append((String)localObject);
                      localStringBuilder.append("nickname = ").append(paramFromServiceMsg.strNick);
                      localStringBuilder.append("\n");
                      QLog.d("CardHandler", 2, localStringBuilder.toString());
                    }
                  }
                  this.app.a(1).notifyUI(3, true, this.app.getCurrentAccountUin());
                }
                if (paramToServiceMsg.extraData.containsKey("sex"))
                {
                  paramFromServiceMsg.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
                  localObject = (ascz)this.app.getManager(106);
                  if (localObject != null) {
                    ((ascz)localObject).b(paramFromServiceMsg.shGender);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("birthday"))
                {
                  paramFromServiceMsg.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
                  paramFromServiceMsg.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
                  paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
                  localObject = (ascz)this.app.getManager(106);
                  if (localObject != null) {
                    ((ascz)localObject).a(paramFromServiceMsg.age);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("profession")) {
                  paramFromServiceMsg.iProfession = paramToServiceMsg.extraData.getInt("profession");
                }
                if (paramToServiceMsg.extraData.containsKey("company")) {
                  paramFromServiceMsg.strCompany = paramToServiceMsg.extraData.getString("company");
                }
                if (paramToServiceMsg.extraData.containsKey("college")) {
                  paramFromServiceMsg.strSchool = paramToServiceMsg.extraData.getString("college");
                }
                try
                {
                  asfc.a(this.app.getAccount(), "self_school_name", paramFromServiceMsg.strSchool);
                  if (!paramToServiceMsg.extraData.containsKey("location")) {
                    continue;
                  }
                  localObject = paramToServiceMsg.extraData.getStringArray("location");
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(localObject[0]).append("-").append(localObject[1]).append("-").append(localObject[2]).append("-").append(localObject[3]);
                  paramFromServiceMsg.strLocationCodes = localStringBuilder.toString();
                  paramFromServiceMsg.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
                  localObject = paramToServiceMsg.extraData.getStringArray("location_name");
                  if ((localObject == null) || (localObject.length != 4)) {
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localStringBuilder = new StringBuilder("nameArray: ");
                  j = 0;
                  if (j >= 4) {
                    continue;
                  }
                  localStringBuilder.append(localObject[j]).append(" ");
                  j += 1;
                  continue;
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                  continue;
                }
                bool1 = false;
              }
              catch (Exception paramObject)
              {
                paramToServiceMsg = paramFromServiceMsg;
                paramFromServiceMsg = paramObject;
              }
              if (QLog.isColorLevel()) {
                QLog.d("CardHandler", 2, "handleGetDetailInfo", paramFromServiceMsg);
              }
              if (!bool3) {
                notifyUI(31, bool1, new Object[] { Integer.valueOf(i), paramToServiceMsg });
              }
              if ((!bool1) || (i != 0))
              {
                paramFromServiceMsg = new HashMap();
                paramFromServiceMsg.put("retCode", String.valueOf(i));
                paramFromServiceMsg.put("fieldFlag", String.valueOf(l));
                if (bool3)
                {
                  paramToServiceMsg = "1";
                  paramFromServiceMsg.put("isNearbyPeopleCard", paramToServiceMsg);
                  awrn.a(BaseApplicationImpl.getContext()).a("", "profile_set_user_info_result", bool1, 0L, 0L, paramFromServiceMsg, "", false);
                }
              }
              else
              {
                return;
                QLog.d("CardHandler", 2, localStringBuilder.toString());
                paramFromServiceMsg.strCountry = localException[0];
                paramFromServiceMsg.strProvince = localException[1];
                paramFromServiceMsg.strCity = localException[2];
                if (paramToServiceMsg.extraData.containsKey("hometown"))
                {
                  arrayOfString = paramToServiceMsg.extraData.getStringArray("hometown");
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(arrayOfString[0]).append("-").append(arrayOfString[1]).append("-").append(arrayOfString[2]).append("-").append(arrayOfString[3]);
                  paramFromServiceMsg.strHometownCodes = localStringBuilder.toString();
                  paramFromServiceMsg.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
                }
                if (paramToServiceMsg.extraData.containsKey("email")) {
                  paramFromServiceMsg.strEmail = paramToServiceMsg.extraData.getString("email");
                }
                if (paramToServiceMsg.extraData.containsKey("personalNote")) {
                  paramFromServiceMsg.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
                }
                if (paramToServiceMsg.extraData.containsKey("key_personality_label_switch")) {
                  paramFromServiceMsg.switch_disable_personality_label = paramToServiceMsg.extraData.getShort("key_personality_label_switch");
                }
                if (paramToServiceMsg.extraData.containsKey("key_extend_friend_switch"))
                {
                  if (paramToServiceMsg.extraData.getShort("key_extend_friend_switch") == 0)
                  {
                    bool2 = true;
                    paramFromServiceMsg.isShowCard = bool2;
                  }
                }
                else
                {
                  paramObject.a(paramFromServiceMsg);
                  paramToServiceMsg = paramFromServiceMsg;
                  continue;
                }
                bool2 = false;
                continue;
                if (QLog.isColorLevel())
                {
                  paramToServiceMsg = new StringBuilder().append("setDetailInfo fail : ");
                  if (paramFromServiceMsg != null)
                  {
                    i = paramFromServiceMsg.getResultCode();
                    QLog.w("CardHandler", 2, i);
                  }
                }
                else
                {
                  i = -1000;
                  paramToServiceMsg = arrayOfString;
                  continue;
                }
                i = -1;
                continue;
              }
              paramToServiceMsg = "0";
              continue;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              i = j;
              continue;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
          continue;
          paramToServiceMsg = null;
          continue;
          continue;
        }
      }
      break;
      label1355:
      bool1 = false;
      continue;
      label1361:
      bool1 = false;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (ajjj)this.app.getManager(51);
        paramBundle = paramToServiceMsg.c(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.strNick = paramFromServiceMsg.stMakeFriendsCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stMakeFriendsCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stMakeFriendsCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stMakeFriendsCard.nFaceID;
        paramBundle.strCertificationInfo = paramFromServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramBundle.shType = paramFromServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramBundle.vContent = paramFromServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramBundle.vQQFaceID = paramFromServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.nSameFriendsNum = paramFromServiceMsg.nSameFriendsNum;
        paramBundle.strCompanySame = paramFromServiceMsg.strCompany;
        paramBundle.strSchoolSame = paramFromServiceMsg.strSchool;
        paramBundle.bSingle = paramFromServiceMsg.stMakeFriendsCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stMakeFriendsCard.lVisitCount;
        if ((i == 0) || (paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        if (paramFromServiceMsg.stMakeFriendsCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stMakeFriendsCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stMakeFriendsCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramBundle.iQQLevel = paramFromServiceMsg.stMakeFriendsCard.iQQLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.b(paramBundle.uin, paramBundle.strNick);
        notifyUI(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        notifyUI(2, true, paramBundle);
        return;
      }
      notifyUI(1, false, paramBundle);
      return;
    }
    notifyUI(1, false, paramBundle);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i4;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject2;
    Object localObject6;
    int m;
    int n;
    int i3;
    int i1;
    int i2;
    int i6;
    label264:
    int i7;
    label360:
    int i5;
    Object localObject12;
    label721:
    Object localObject13;
    Object localObject11;
    label3071:
    boolean bool3;
    label3214:
    label3356:
    label3668:
    int i9;
    label4027:
    Object localObject9;
    label4148:
    label5826:
    label6374:
    label6518:
    short s;
    label4480:
    label5931:
    label6061:
    label6999:
    label7128:
    label7663:
    Object localObject14;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            break label10689;
          }
          localLong = Long.valueOf(azzz.a(localByteBuffer.getInt()));
          localByteBuffer.get();
          int i8 = localByteBuffer.getShort();
          if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "handleGetDetailInfo request success. TLVCount=" + i8);
          }
          i4 = 0;
          localajjj = (ajjj)this.app.getManager(51);
          localCard = localajjj.c(this.app.getCurrentAccountUin());
          paramFromServiceMsg = "0";
          localObject1 = "0";
          paramObject = "0";
          localObject4 = "0";
          localObject3 = "0";
          localObject5 = "0";
          localObject2 = "0";
          localObject6 = "0";
          m = 0;
          n = 0;
          try
          {
            localaifg = (aifg)this.app.getManager(153);
            localApolloBaseInfo = localaifg.b(this.app.getCurrentAccountUin());
            k = 0;
            i3 = -1;
            i1 = -1;
            i2 = 0;
            i6 = localByteBuffer.position();
            if ((!localByteBuffer.hasRemaining()) || (i4 >= i8)) {
              break label10292;
            }
            localByteBuffer.position(i6);
            i = localByteBuffer.getShort();
            j = localByteBuffer.getShort();
            i7 = localByteBuffer.position() + j;
            if (!QLog.isColorLevel()) {
              break label11011;
            }
            QLog.d("CardHandler", 2, String.format("handleGetDetailInfo K=%s, L=%s, nextTLVPosition=%s", new Object[] { Short.valueOf(i), Short.valueOf(j), Integer.valueOf(i7) }));
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = localCard;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "invalid type: " + i);
          }
          localByteBuffer.position(localByteBuffer.position() + j);
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            ByteBuffer localByteBuffer;
            Long localLong;
            ajjj localajjj;
            Card localCard;
            aifg localaifg;
            ApolloBaseInfo localApolloBaseInfo;
            int i;
            int j;
            Object localObject7;
            Object localObject10;
            label6695:
            label7490:
            label7506:
            label8021:
            label9694:
            paramFromServiceMsg = null;
            label7308:
            label8990:
            label9167:
            continue;
            label8456:
            label9421:
            int k = -1111;
            label9513:
            label9536:
            continue;
            bool2 = bool3;
          }
        }
        localObject7 = new byte[j];
        localByteBuffer.get((byte[])localObject7);
        localCard.strNick = new String((byte[])localObject7);
        if (!QLog.isColorLevel()) {
          break label11587;
        }
        QLog.d("CardHandler", 2, "strNick = " + localCard.strNick);
        i6 = i1;
        localObject7 = localObject6;
        i5 = m;
        localObject6 = localObject1;
        localObject12 = paramObject;
        localObject10 = paramFromServiceMsg;
        i1 = i2;
        i2 = i6;
        m = n;
        n = i5;
        paramFromServiceMsg = (FromServiceMsg)localObject7;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject12;
        localObject5 = localObject6;
        localObject6 = localObject10;
        break label11659;
        i5 = localByteBuffer.get();
        if (i5 == 1) {
          localCard.shGender = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "shGender = " + localCard.shGender);
          i6 = i1;
          localObject7 = localObject6;
          i5 = m;
          localObject6 = localObject1;
          localObject12 = paramObject;
          localObject10 = paramFromServiceMsg;
          i1 = i2;
          i2 = i6;
          m = n;
          n = i5;
          paramFromServiceMsg = (FromServiceMsg)localObject7;
          paramObject = localObject2;
          localObject1 = localObject5;
          localObject2 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject12;
          localObject5 = localObject6;
          localObject6 = localObject10;
          break label11659;
          if (i5 == 2)
          {
            localCard.shGender = 1;
            continue;
            bool2 = false;
            paramToServiceMsg = paramFromServiceMsg;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
              bool1 = bool2;
              paramToServiceMsg = paramFromServiceMsg;
            }
            notifyUI(20, bool1, paramToServiceMsg);
          }
          else
          {
            localCard.shGender = -1;
            continue;
            i5 = localByteBuffer.getInt();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "profession = " + i5);
            }
            if (azyf.a(i5))
            {
              localCard.iProfession = i5;
              i6 = i1;
              localObject7 = localObject6;
              i5 = m;
              localObject6 = localObject1;
              localObject12 = paramObject;
              localObject10 = paramFromServiceMsg;
              i1 = i2;
              i2 = i6;
              m = n;
              n = i5;
              paramFromServiceMsg = (FromServiceMsg)localObject7;
              paramObject = localObject2;
              localObject1 = localObject5;
              localObject2 = localObject3;
              localObject3 = localObject4;
              localObject4 = localObject12;
              localObject5 = localObject6;
              localObject6 = localObject10;
              break label11659;
            }
            localCard.iProfession = -1;
            i6 = i1;
            localObject7 = localObject6;
            i5 = m;
            localObject6 = localObject1;
            localObject12 = paramObject;
            localObject10 = paramFromServiceMsg;
            i1 = i2;
            i2 = i6;
            m = n;
            n = i5;
            paramFromServiceMsg = (FromServiceMsg)localObject7;
            paramObject = localObject2;
            localObject1 = localObject5;
            localObject2 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject12;
            localObject5 = localObject6;
            localObject6 = localObject10;
            break label11659;
            localCard.lBirthday = localByteBuffer.getInt();
            if (localCard.lBirthday == 0L) {
              localCard.constellation = 0;
            }
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "birth = " + localCard.lBirthday + ", constellation = " + localCard.constellation);
                i6 = i1;
                localObject7 = localObject6;
                i5 = m;
                localObject6 = localObject1;
                localObject12 = paramObject;
                localObject10 = paramFromServiceMsg;
                i1 = i2;
                i2 = i6;
                m = n;
                n = i5;
                paramFromServiceMsg = (FromServiceMsg)localObject7;
                paramObject = localObject2;
                localObject1 = localObject5;
                localObject2 = localObject3;
                localObject3 = localObject4;
                localObject4 = localObject12;
                localObject5 = localObject6;
                localObject6 = localObject10;
                break label11659;
                localCard.constellation = azzz.a((int)((localCard.lBirthday & 0xFF00) >> 8), (int)(localCard.lBirthday & 0xFF));
                continue;
                localObject7 = new byte[j];
                localByteBuffer.get((byte[])localObject7);
                localObject7 = new String((byte[])localObject7);
                localCard.strCompany = ((String)localObject7);
                if (QLog.isColorLevel())
                {
                  QLog.d("CardHandler", 2, "company = " + (String)localObject7);
                  i6 = i1;
                  localObject7 = localObject6;
                  i5 = m;
                  localObject6 = localObject1;
                  localObject12 = paramObject;
                  localObject10 = paramFromServiceMsg;
                  i1 = i2;
                  i2 = i6;
                  m = n;
                  n = i5;
                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                  paramObject = localObject2;
                  localObject1 = localObject5;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  localObject5 = localObject6;
                  localObject6 = localObject10;
                  break label11659;
                  n = localByteBuffer.getInt();
                  i5 = localByteBuffer.getInt();
                  i6 = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "hometown, countryId " + n + ", provinceId " + i5 + ", cityId " + i6);
                  }
                  localObject7 = ajfw.a(n);
                  paramFromServiceMsg = ajfw.a(i5);
                  localObject10 = ajfw.a(i6);
                  localObject1 = localObject5;
                  localObject5 = paramFromServiceMsg;
                  i5 = 1;
                  n = m;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  paramObject = localObject2;
                  localObject6 = localObject10;
                  m = i1;
                  i1 = i2;
                  i2 = m;
                  m = i5;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject6;
                  localObject6 = localObject7;
                  break label11659;
                  n = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "hometown, districtId " + n);
                  }
                  localObject4 = ajfw.a(n);
                  i5 = 1;
                  localObject10 = localObject6;
                  localObject6 = localObject5;
                  localObject5 = localObject1;
                  n = m;
                  m = i1;
                  localObject7 = paramFromServiceMsg;
                  localObject12 = paramObject;
                  i1 = i2;
                  i2 = m;
                  m = i5;
                  paramFromServiceMsg = (FromServiceMsg)localObject10;
                  paramObject = localObject2;
                  localObject1 = localObject6;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  localObject6 = localObject7;
                  break label11659;
                  m = localByteBuffer.getInt();
                  i5 = localByteBuffer.getInt();
                  i6 = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "location, countryId " + m + ", provinceId " + i5 + ", cityId " + i6);
                  }
                  localObject2 = ajfw.a(m);
                  localObject12 = ajfw.a(i5);
                  localObject13 = ajfw.a(i6);
                  localObject5 = paramObject;
                  localObject7 = localObject1;
                  localObject10 = paramFromServiceMsg;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  localObject3 = localObject4;
                  m = i1;
                  paramObject = localObject13;
                  i1 = i2;
                  i5 = 1;
                  localObject1 = localObject12;
                  i2 = m;
                  m = n;
                  n = i5;
                  localObject4 = localObject5;
                  localObject5 = localObject7;
                  localObject6 = localObject10;
                  break label11659;
                  m = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "location, districtId " + m);
                  }
                  localObject7 = ajfw.a(m);
                  m = n;
                  n = i1;
                  localObject10 = localObject5;
                  localObject6 = paramFromServiceMsg;
                  localObject5 = localObject1;
                  localObject12 = paramObject;
                  i1 = i2;
                  i5 = 1;
                  i2 = n;
                  n = i5;
                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                  paramObject = localObject2;
                  localObject1 = localObject10;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  break label11659;
                  localObject7 = new byte[j];
                  localByteBuffer.get((byte[])localObject7);
                  localObject7 = new String((byte[])localObject7);
                  localCard.strEmail = ((String)localObject7);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("CardHandler", 2, "email = " + (String)localObject7);
                    i6 = i1;
                    localObject7 = localObject6;
                    i5 = m;
                    localObject6 = localObject1;
                    localObject12 = paramObject;
                    localObject10 = paramFromServiceMsg;
                    i1 = i2;
                    i2 = i6;
                    m = n;
                    n = i5;
                    paramFromServiceMsg = (FromServiceMsg)localObject7;
                    paramObject = localObject2;
                    localObject1 = localObject5;
                    localObject2 = localObject3;
                    localObject3 = localObject4;
                    localObject4 = localObject12;
                    localObject5 = localObject6;
                    localObject6 = localObject10;
                    break label11659;
                    localObject7 = new byte[j];
                    localByteBuffer.get((byte[])localObject7);
                    localObject7 = new String((byte[])localObject7);
                    localCard.strPersonalNote = ((String)localObject7);
                    if (QLog.isColorLevel())
                    {
                      QLog.d("CardHandler", 2, "personal note = " + (String)localObject7);
                      i6 = i1;
                      localObject7 = localObject6;
                      i5 = m;
                      localObject6 = localObject1;
                      localObject12 = paramObject;
                      localObject10 = paramFromServiceMsg;
                      i1 = i2;
                      i2 = i6;
                      m = n;
                      n = i5;
                      paramFromServiceMsg = (FromServiceMsg)localObject7;
                      paramObject = localObject2;
                      localObject1 = localObject5;
                      localObject2 = localObject3;
                      localObject3 = localObject4;
                      localObject4 = localObject12;
                      localObject5 = localObject6;
                      localObject6 = localObject10;
                      break label11659;
                      localObject7 = new byte[j];
                      localByteBuffer.get((byte[])localObject7);
                      localObject7 = new String((byte[])localObject7);
                      localCard.strSchool = ((String)localObject7);
                      try
                      {
                        asfc.a(this.app.getAccount(), "self_school_name", localObject7);
                        if (!QLog.isColorLevel()) {
                          break label11587;
                        }
                        QLog.d("CardHandler", 2, "school = " + (String)localObject7);
                        i6 = i1;
                        localObject7 = localObject6;
                        i5 = m;
                        localObject6 = localObject1;
                        localObject12 = paramObject;
                        localObject10 = paramFromServiceMsg;
                        i1 = i2;
                        i2 = i6;
                        m = n;
                        n = i5;
                        paramFromServiceMsg = (FromServiceMsg)localObject7;
                        paramObject = localObject2;
                        localObject1 = localObject5;
                        localObject2 = localObject3;
                        localObject3 = localObject4;
                        localObject4 = localObject12;
                        localObject5 = localObject6;
                        localObject6 = localObject10;
                      }
                      catch (Exception localException2)
                      {
                        for (;;)
                        {
                          localException2.printStackTrace();
                        }
                      }
                      localCard.age = localByteBuffer.get();
                      localCard.shAge = ((short)localCard.age);
                      if (QLog.isColorLevel())
                      {
                        QLog.d("CardHandler", 2, "age = " + localCard.age);
                        i6 = i1;
                        localObject7 = localObject6;
                        i5 = m;
                        localObject6 = localObject1;
                        localObject12 = paramObject;
                        localObject11 = paramFromServiceMsg;
                        i1 = i2;
                        i2 = i6;
                        m = n;
                        n = i5;
                        paramFromServiceMsg = (FromServiceMsg)localObject7;
                        paramObject = localObject2;
                        localObject1 = localObject5;
                        localObject2 = localObject3;
                        localObject3 = localObject4;
                        localObject4 = localObject12;
                        localObject5 = localObject6;
                        localObject6 = localObject11;
                        break label11659;
                        localCard.constellation = localByteBuffer.get();
                        if (QLog.isColorLevel())
                        {
                          QLog.d("CardHandler", 2, "constellation = " + localCard.constellation);
                          i6 = i1;
                          localObject7 = localObject6;
                          i5 = m;
                          localObject6 = localObject1;
                          localObject12 = paramObject;
                          localObject11 = paramFromServiceMsg;
                          i1 = i2;
                          i2 = i6;
                          m = n;
                          n = i5;
                          paramFromServiceMsg = (FromServiceMsg)localObject7;
                          paramObject = localObject2;
                          localObject1 = localObject5;
                          localObject2 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject12;
                          localObject5 = localObject6;
                          localObject6 = localObject11;
                          break label11659;
                          i5 = localByteBuffer.getShort();
                          i6 = this.app.getPreferences().getInt("nearby_people_profile_ok_new", -1);
                          if (QLog.isColorLevel()) {
                            QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyprofile local is :" + i6 + " server is: " + i5);
                          }
                          if ((i6 != i5) && (i6 != 1))
                          {
                            this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", i5).commit();
                            i6 = i1;
                            localObject7 = localObject6;
                            i5 = m;
                            localObject6 = localObject1;
                            localObject12 = paramObject;
                            localObject11 = paramFromServiceMsg;
                            i1 = i2;
                            i2 = i6;
                            m = n;
                            n = i5;
                            paramFromServiceMsg = (FromServiceMsg)localObject7;
                            paramObject = localObject2;
                            localObject1 = localObject5;
                            localObject2 = localObject3;
                            localObject3 = localObject4;
                            localObject4 = localObject12;
                            localObject5 = localObject6;
                            localObject6 = localObject11;
                            break label11659;
                            i5 = localByteBuffer.getShort();
                            i6 = ((Integer)asfc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
                            if (QLog.isColorLevel()) {
                              QLog.i("CardHandler", 2, "handleGetDetalInfo hasNearbyAvatarFlag local is :" + i6 + " server is: " + i5);
                            }
                            if ((i6 != i5) && (i6 != 1))
                            {
                              asfc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(i5));
                              i6 = i1;
                              localObject7 = localObject6;
                              i5 = m;
                              localObject6 = localObject1;
                              localObject12 = paramObject;
                              localObject11 = paramFromServiceMsg;
                              i1 = i2;
                              i2 = i6;
                              m = n;
                              n = i5;
                              paramFromServiceMsg = (FromServiceMsg)localObject7;
                              paramObject = localObject2;
                              localObject1 = localObject5;
                              localObject2 = localObject3;
                              localObject3 = localObject4;
                              localObject4 = localObject12;
                              localObject5 = localObject6;
                              localObject6 = localObject11;
                              break label11659;
                              i6 = localByteBuffer.getShort();
                              i1 = ((Integer)asfc.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
                              if (QLog.isColorLevel()) {
                                QLog.i("CardHandler", 2, "handleGetDetailInfo qq avatar type local is: " + i1 + " server is: " + i6);
                              }
                              if (i1 != i6)
                              {
                                asfc.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(i6));
                                i1 = i2;
                                i5 = m;
                                localObject7 = paramObject;
                                localObject11 = localObject1;
                                localObject12 = paramFromServiceMsg;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject7;
                                localObject5 = localObject11;
                                localObject6 = localObject12;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetialInfo is showNearbyGuide: " + i5);
                                }
                                localObject7 = this.app.getAccount();
                                if (i5 != 1) {
                                  break label11746;
                                }
                                bool2 = true;
                                asfc.a((String)localObject7, "nearby_need_show_guide", Boolean.valueOf(bool2));
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetialInfo isNovice: " + i5);
                                }
                                localObject7 = this.app.getAccount();
                                if (i5 != 1) {
                                  break label11752;
                                }
                                bool2 = true;
                                asfc.a((String)localObject7, "is_nearby_novice", Boolean.valueOf(bool2));
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                bool3 = false;
                                boolean bool4;
                                if (2 == j)
                                {
                                  bool4 = SettingCloneUtil.readValue(this.app.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", false);
                                  localObject7 = new byte[j];
                                  localByteBuffer.get((byte[])localObject7);
                                  if (azzz.a((byte[])localObject7, 0) != 0) {
                                    break label11758;
                                  }
                                  bool2 = false;
                                  bool3 = bool2;
                                  if (bool4 != bool2)
                                  {
                                    SettingCloneUtil.writeValue(this.app.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", bool2);
                                    localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                                    ((Intent)localObject7).putExtra("pcActive", bool2);
                                    ((Intent)localObject7).putExtra("uin", localLong.toString());
                                    this.app.getApp().sendBroadcast((Intent)localObject7);
                                    bool3 = bool2;
                                  }
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11587;
                                }
                                QLog.d("PCActiveState", 2, "Get PCActiveState=" + bool3);
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                bool3 = false;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "isHelloLiveMessageEnable length=" + j);
                                }
                                if (2 == j)
                                {
                                  bool4 = SettingCloneUtil.readValue(this.app.getApplication(), localLong.toString(), null, "qqsetting_hello_live_message", false);
                                  localObject7 = new byte[j];
                                  localByteBuffer.get((byte[])localObject7);
                                  i5 = azzz.a((byte[])localObject7, 0);
                                  if (!QLog.isColorLevel()) {
                                    break label11764;
                                  }
                                  QLog.i("CardHandler", 2, "isHelloLiveMessageEnable sFieldValue=" + i5);
                                  break label11764;
                                  bool3 = bool2;
                                  if (bool4 != bool2)
                                  {
                                    SettingCloneUtil.writeValue(this.app.getApplication(), localLong.toString(), null, "qqsetting_hello_live_message", bool2);
                                    localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
                                    ((Intent)localObject7).putExtra("isHelloLiveMessageEnable", bool2);
                                    ((Intent)localObject7).putExtra("uin", localLong.toString());
                                    this.app.getApp().sendBroadcast((Intent)localObject7);
                                    bool3 = bool2;
                                  }
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11587;
                                }
                                QLog.i("CardHandler", 2, "Get HELLO_LIVE_MESSAGE=" + bool3);
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server dating symbol is :" + i5);
                                }
                                if (i5 != 1) {
                                  break label11587;
                                }
                                this.app.a().b();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label11781;
                                }
                                QLog.i("CardHandler", 2, "handleGetDetalInfo server calltab visible is :" + i5);
                                break label11781;
                                i6 = this.app.a(4);
                                i9 = this.app.a(0);
                                if (i9 != 0) {
                                  break label11798;
                                }
                                localObject7 = new Integer[7];
                                localObject7[3] = Integer.valueOf(i5);
                                this.app.a((Integer[])localObject7);
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                b(bool2, false);
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_musicbox = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_miniapp = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_disable_personality_label = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                if (localByteBuffer.getShort() != 0) {
                                  break label11828;
                                }
                                bool2 = true;
                                localCard.isShowCard = bool2;
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_interest = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_music = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localCard.switch_present = localByteBuffer.getShort();
                                i6 = i1;
                                localObject7 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                QLog.i("smartdevice", 1, "got device bind flag:" + i5);
                                try
                                {
                                  ((xrh)this.app.a(51)).a(i5);
                                  i6 = i1;
                                  localObject7 = localObject6;
                                  i5 = m;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  i1 = i2;
                                  i2 = i6;
                                  m = n;
                                  n = i5;
                                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                catch (Error localError)
                                {
                                  i6 = i1;
                                  Object localObject8 = localObject6;
                                  i5 = m;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  i1 = i2;
                                  i2 = i6;
                                  m = n;
                                  n = i5;
                                  paramFromServiceMsg = localObject8;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                catch (Exception localException1)
                                {
                                  i6 = i1;
                                  localObject9 = localObject6;
                                  i5 = m;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  i1 = i2;
                                  i2 = i6;
                                  m = n;
                                  n = i5;
                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                i5 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server has antilost bind symbol is :" + i5);
                                }
                                ((xrh)this.app.a(51)).b(i5);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                localObject9 = (ajmp)this.app.getManager(92);
                                if (localObject9 != null) {
                                  ((ajmp)localObject9).d(i5);
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11587;
                                }
                                QLog.i("CardHandler", 2, "handleGetDetalInfo authMode is :" + i5);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("LocalRedTouchManager", 2, "handleGetDetalInfo unreadFlag is :" + i);
                                }
                                localObject9 = (atax)this.app.getManager(160);
                                if (localObject9 == null) {
                                  break label11587;
                                }
                                ((atax)localObject9).a(i);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getInt();
                                if (!String.valueOf(localLong).equals(this.app.getCurrentAccountUin())) {
                                  break label11587;
                                }
                                ((ajrm)this.app.a(13)).a(i5, false);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                localObject9 = new byte[j];
                                localByteBuffer.get((byte[])localObject9);
                                localObject9 = new String((byte[])localObject9);
                                if ((TextUtils.isEmpty((CharSequence)localObject9)) || (!String.valueOf(localLong).equals(this.app.getCurrentAccountUin()))) {
                                  break label11587;
                                }
                                localajjj.a(this.app.getCurrentAccountUin(), (String)localObject9, (byte)-1);
                                if (!QLog.isColorLevel()) {
                                  break label11587;
                                }
                                QLog.d("CardHandler", 2, "handleGetDetalInfo saveDateNickByUin: " + (String)localObject9);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyAuthFlag:" + i5);
                                }
                                localObject9 = (HotChatManager)this.app.getManager(60);
                                localObject9 = this.app;
                                if (i5 <= 0) {
                                  break label11834;
                                }
                                bool2 = true;
                                HotChatManager.a((AppInterface)localObject9, bool2);
                                i6 = i1;
                                localObject9 = localObject6;
                                i5 = m;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                i1 = i2;
                                i2 = i6;
                                m = n;
                                n = i5;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11659;
                                i5 = localByteBuffer.getShort();
                                if (i5 != localApolloBaseInfo.apolloVipFlag)
                                {
                                  localApolloBaseInfo.apolloVipFlag = i5;
                                  k = 1;
                                  QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip flag: " + i5);
                                  i5 = i1;
                                  localObject9 = localObject6;
                                  localObject11 = localObject5;
                                  localObject5 = paramObject;
                                  i1 = i2;
                                  localObject6 = localObject1;
                                  i6 = m;
                                  localObject12 = paramFromServiceMsg;
                                  i2 = i5;
                                  m = n;
                                  n = i6;
                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                  paramObject = localObject2;
                                  localObject1 = localObject11;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject5;
                                  localObject5 = localObject6;
                                  localObject6 = localObject12;
                                  break label11659;
                                  i5 = localByteBuffer.getShort();
                                  if (i5 != localApolloBaseInfo.apolloVipLevel)
                                  {
                                    localApolloBaseInfo.apolloVipLevel = i5;
                                    k = 1;
                                    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip level: " + i5);
                                    i5 = i1;
                                    localObject9 = localObject6;
                                    localObject11 = localObject5;
                                    localObject5 = paramObject;
                                    i1 = i2;
                                    localObject6 = localObject1;
                                    i6 = m;
                                    localObject12 = paramFromServiceMsg;
                                    i2 = i5;
                                    m = n;
                                    n = i6;
                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                    paramObject = localObject2;
                                    localObject1 = localObject11;
                                    localObject2 = localObject3;
                                    localObject3 = localObject4;
                                    localObject4 = localObject5;
                                    localObject5 = localObject6;
                                    localObject6 = localObject12;
                                    break label11659;
                                    i6 = localByteBuffer.getShort();
                                    if (i6 != localApolloBaseInfo.apolloStatus)
                                    {
                                      localApolloBaseInfo.apolloStatus = i6;
                                      i5 = 1;
                                      localObject9 = (baot)this.app.a(71);
                                      k = i5;
                                      if (localObject9 != null)
                                      {
                                        ((baot)localObject9).notifyUI(3, true, new com.tencent.util.Pair(localApolloBaseInfo.uin, Integer.valueOf(i6)));
                                        k = i5;
                                      }
                                    }
                                    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo status flag: " + i6);
                                    i5 = i1;
                                    localObject9 = localObject6;
                                    localObject11 = localObject5;
                                    localObject5 = paramObject;
                                    i1 = i2;
                                    localObject6 = localObject1;
                                    i6 = m;
                                    localObject12 = paramFromServiceMsg;
                                    i2 = i5;
                                    m = n;
                                    n = i6;
                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                    paramObject = localObject2;
                                    localObject1 = localObject11;
                                    localObject2 = localObject3;
                                    localObject3 = localObject4;
                                    localObject4 = localObject5;
                                    localObject5 = localObject6;
                                    localObject6 = localObject12;
                                    break label11659;
                                    long l1 = localByteBuffer.getInt();
                                    if (l1 != localApolloBaseInfo.apolloServerTS)
                                    {
                                      localApolloBaseInfo.apolloServerTS = l1;
                                      k = 1;
                                      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo svr TS: " + l1 + ",local TS: " + localApolloBaseInfo.apolloServerTS);
                                      i5 = i1;
                                      localObject9 = localObject6;
                                      localObject11 = localObject5;
                                      localObject5 = paramObject;
                                      i1 = i2;
                                      localObject6 = localObject1;
                                      i6 = m;
                                      localObject12 = paramFromServiceMsg;
                                      i2 = i5;
                                      m = n;
                                      n = i6;
                                      paramFromServiceMsg = (FromServiceMsg)localObject9;
                                      paramObject = localObject2;
                                      localObject1 = localObject11;
                                      localObject2 = localObject3;
                                      localObject3 = localObject4;
                                      localObject4 = localObject5;
                                      localObject5 = localObject6;
                                      localObject6 = localObject12;
                                      break label11659;
                                      i = localByteBuffer.getShort();
                                      if (i != localApolloBaseInfo.cmshow3dFlag)
                                      {
                                        localApolloBaseInfo.cmshow3dFlag = i;
                                        k = 1;
                                        QLog.d("ApolloManager", 1, new Object[] { "handleGetDetalInfo apollo svr cmshow3dFlag: ", Short.valueOf(i), ", local cmshow3dFlag: ", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
                                        i5 = i1;
                                        localObject9 = localObject6;
                                        localObject11 = localObject5;
                                        localObject5 = paramObject;
                                        i1 = i2;
                                        localObject6 = localObject1;
                                        i6 = m;
                                        localObject12 = paramFromServiceMsg;
                                        i2 = i5;
                                        m = n;
                                        n = i6;
                                        paramFromServiceMsg = (FromServiceMsg)localObject9;
                                        paramObject = localObject2;
                                        localObject1 = localObject11;
                                        localObject2 = localObject3;
                                        localObject3 = localObject4;
                                        localObject4 = localObject5;
                                        localObject5 = localObject6;
                                        localObject6 = localObject12;
                                        break label11659;
                                        l1 = localByteBuffer.getInt();
                                        long l2 = NetConnInfoCenter.getServerTime();
                                        if ((l1 < l2) && (localApolloBaseInfo.apolloSignValidTS != l1))
                                        {
                                          localApolloBaseInfo.apolloLocalSignTs = localApolloBaseInfo.apolloSignValidTS;
                                          localApolloBaseInfo.apolloSignValidTS = l1;
                                          localApolloBaseInfo.apolloSignStr = "";
                                          k = 1;
                                          QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo Sign TS: " + l1 + ", currTS: " + l2);
                                          i5 = i1;
                                          localObject9 = localObject6;
                                          localObject11 = localObject5;
                                          localObject5 = paramObject;
                                          i1 = i2;
                                          localObject6 = localObject1;
                                          i6 = m;
                                          localObject12 = paramFromServiceMsg;
                                          i2 = i5;
                                          m = n;
                                          n = i6;
                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                          paramObject = localObject2;
                                          localObject1 = localObject11;
                                          localObject2 = localObject3;
                                          localObject3 = localObject4;
                                          localObject4 = localObject5;
                                          localObject5 = localObject6;
                                          localObject6 = localObject12;
                                          break label11659;
                                          i5 = localByteBuffer.getShort();
                                          if (i5 != aifg.a(this.app)) {
                                            localaifg.b(i5);
                                          }
                                          QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo white list: " + i5);
                                          i6 = i1;
                                          localObject9 = localObject6;
                                          i5 = m;
                                          localObject6 = localObject1;
                                          localObject12 = paramObject;
                                          localObject11 = paramFromServiceMsg;
                                          i1 = i2;
                                          i2 = i6;
                                          m = n;
                                          n = i5;
                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                          paramObject = localObject2;
                                          localObject1 = localObject5;
                                          localObject2 = localObject3;
                                          localObject3 = localObject4;
                                          localObject4 = localObject12;
                                          localObject5 = localObject6;
                                          localObject6 = localObject11;
                                          break label11659;
                                          i5 = localByteBuffer.getInt();
                                          if ((this.app != null) && (String.valueOf(localLong).equals(this.app.c()))) {
                                            localaifg.a(i5, 1);
                                          }
                                          if ((localaifg != null) && (localApolloBaseInfo.apolloAISwitch != i5))
                                          {
                                            localApolloBaseInfo.apolloAISwitch = i5;
                                            k = 1;
                                            localaifg.n = true;
                                            QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo AIFlag: " + i5);
                                            i5 = i1;
                                            localObject9 = localObject6;
                                            localObject11 = localObject5;
                                            localObject5 = paramObject;
                                            i1 = i2;
                                            localObject6 = localObject1;
                                            i6 = m;
                                            localObject12 = paramFromServiceMsg;
                                            i2 = i5;
                                            m = n;
                                            n = i6;
                                            paramFromServiceMsg = (FromServiceMsg)localObject9;
                                            paramObject = localObject2;
                                            localObject1 = localObject11;
                                            localObject2 = localObject3;
                                            localObject3 = localObject4;
                                            localObject4 = localObject5;
                                            localObject5 = localObject6;
                                            localObject6 = localObject12;
                                            break label11659;
                                            bool3 = atbe.a(this.app);
                                            if (localByteBuffer.getShort() == 0) {
                                              break label11840;
                                            }
                                            bool2 = true;
                                            localCard.medalSwitchDisable = bool2;
                                            localObject9 = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + localLong, 4).edit();
                                            ((SharedPreferences.Editor)localObject9).putBoolean("medal_switch_disable", localCard.medalSwitchDisable);
                                            ((SharedPreferences.Editor)localObject9).commit();
                                            bool2 = atbe.a(this.app);
                                            if (bool3 == bool2) {
                                              break label11587;
                                            }
                                            atbe.a(this.app, bool2);
                                            i6 = i1;
                                            localObject9 = localObject6;
                                            i5 = m;
                                            localObject6 = localObject1;
                                            localObject12 = paramObject;
                                            localObject11 = paramFromServiceMsg;
                                            i1 = i2;
                                            i2 = i6;
                                            m = n;
                                            n = i5;
                                            paramFromServiceMsg = (FromServiceMsg)localObject9;
                                            paramObject = localObject2;
                                            localObject1 = localObject5;
                                            localObject2 = localObject3;
                                            localObject3 = localObject4;
                                            localObject4 = localObject12;
                                            localObject5 = localObject6;
                                            localObject6 = localObject11;
                                            break label11659;
                                            bool3 = localCard.strangerInviteMeGroupOpen;
                                            if (localByteBuffer.getShort() != 0) {
                                              break label11846;
                                            }
                                            bool2 = true;
                                            localCard.strangerInviteMeGroupOpen = bool2;
                                            bool2 = localCard.strangerInviteMeGroupOpen;
                                            if (QLog.isColorLevel()) {
                                              QLog.i("CardHandler", 2, "handleGetDetalInfo strangerInviteMeGroupOpen newConfigOn:" + bool2 + " oldConfigOn:" + bool3);
                                            }
                                            if (bool3 == bool2) {
                                              break label11587;
                                            }
                                            notifyUI(95, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
                                            i6 = i1;
                                            localObject9 = localObject6;
                                            i5 = m;
                                            localObject6 = localObject1;
                                            localObject12 = paramObject;
                                            localObject11 = paramFromServiceMsg;
                                            i1 = i2;
                                            i2 = i6;
                                            m = n;
                                            n = i5;
                                            paramFromServiceMsg = (FromServiceMsg)localObject9;
                                            paramObject = localObject2;
                                            localObject1 = localObject5;
                                            localObject2 = localObject3;
                                            localObject3 = localObject4;
                                            localObject4 = localObject12;
                                            localObject5 = localObject6;
                                            localObject6 = localObject11;
                                            break label11659;
                                            if (this.app != null)
                                            {
                                              bool2 = asca.a(this.app.c());
                                              i5 = localByteBuffer.getShort();
                                              if (i5 != 1) {
                                                break label11852;
                                              }
                                              bool3 = true;
                                              QLog.i("CardHandler", 1, "handleGetDetalInfo friendIntimateOpen newConfigOn:" + bool3 + " oldConfigOn:" + bool2 + " serverRet:" + i5);
                                              if ((bool2 == bool3) || (this.app == null)) {
                                                break label11587;
                                              }
                                              asca.a(this.app.c(), bool3);
                                              i6 = i1;
                                              localObject9 = localObject6;
                                              i5 = m;
                                              localObject6 = localObject1;
                                              localObject12 = paramObject;
                                              localObject11 = paramFromServiceMsg;
                                              i1 = i2;
                                              i2 = i6;
                                              m = n;
                                              n = i5;
                                              paramFromServiceMsg = (FromServiceMsg)localObject9;
                                              paramObject = localObject2;
                                              localObject1 = localObject5;
                                              localObject2 = localObject3;
                                              localObject3 = localObject4;
                                              localObject4 = localObject12;
                                              localObject5 = localObject6;
                                              localObject6 = localObject11;
                                              break label11659;
                                              if (localByteBuffer.getShort() != 0) {
                                                break label11858;
                                              }
                                              bool2 = true;
                                              axam.a(this.app, bool2);
                                              i6 = i1;
                                              localObject9 = localObject6;
                                              i5 = m;
                                              localObject6 = localObject1;
                                              localObject12 = paramObject;
                                              localObject11 = paramFromServiceMsg;
                                              i1 = i2;
                                              i2 = i6;
                                              m = n;
                                              n = i5;
                                              paramFromServiceMsg = (FromServiceMsg)localObject9;
                                              paramObject = localObject2;
                                              localObject1 = localObject5;
                                              localObject2 = localObject3;
                                              localObject3 = localObject4;
                                              localObject4 = localObject12;
                                              localObject5 = localObject6;
                                              localObject6 = localObject11;
                                              break label11659;
                                              i6 = localByteBuffer.getShort();
                                              if (QLog.isColorLevel())
                                              {
                                                QLog.i("CardHandler", 2, "handleGetDetalInfo qq18Switch = " + i6);
                                                i2 = i1;
                                                i5 = m;
                                                localObject11 = localObject6;
                                                localObject6 = localObject1;
                                                localObject9 = paramFromServiceMsg;
                                                localObject12 = paramObject;
                                                i1 = i6;
                                                m = n;
                                                n = i5;
                                                paramFromServiceMsg = (FromServiceMsg)localObject11;
                                                paramObject = localObject2;
                                                localObject1 = localObject5;
                                                localObject2 = localObject3;
                                                localObject3 = localObject4;
                                                localObject4 = localObject12;
                                                localObject5 = localObject6;
                                                localObject6 = localObject9;
                                                break label11659;
                                                i5 = localByteBuffer.getShort();
                                                if (QLog.isColorLevel())
                                                {
                                                  QLog.d("CardHandler", 2, "handleGetDetalInfo systemId = " + i5);
                                                  i3 = i1;
                                                  localObject9 = localObject6;
                                                  i1 = i2;
                                                  localObject6 = localObject5;
                                                  i6 = m;
                                                  localObject5 = localObject1;
                                                  localObject11 = paramObject;
                                                  localObject12 = paramFromServiceMsg;
                                                  i2 = i3;
                                                  i3 = i5;
                                                  m = n;
                                                  n = i6;
                                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                  paramObject = localObject2;
                                                  localObject1 = localObject6;
                                                  localObject2 = localObject3;
                                                  localObject3 = localObject4;
                                                  localObject4 = localObject11;
                                                  localObject6 = localObject12;
                                                  break label11659;
                                                  i5 = localByteBuffer.getShort();
                                                  localObject9 = this.app.a().a;
                                                  if (localObject9 == null)
                                                  {
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("WholePeopleLebaEntryChecker", 2, "handleGetDetalInfo GET_WHOLE_PEOPLE_VOTE cheker is null");
                                                    }
                                                    localObject9 = new bbfv(this.app);
                                                    break label11864;
                                                    bool3 = ((bbfv)localObject9).jdField_a_of_type_Boolean;
                                                    if (bool2 == bool3) {
                                                      break label11587;
                                                    }
                                                    ((bbfv)localObject9).a(this.app, bool2);
                                                    notifyUI(91, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    if (i5 <= 0) {
                                                      break label11587;
                                                    }
                                                    awhg.a().a(i5, String.valueOf(localLong));
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    s = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("CardHandler", 2, "handleGetDetalInfo FIELD_EXTEND_FRIEND_ADD_FRIEND=" + s);
                                                    }
                                                    localCard.extendFriendEntryAddFriend = s;
                                                    baig.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_add_friend", s).apply();
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    s = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("CardHandler", 2, "handleGetDetalInfo FIELD_EXTEND_FRIEND_QUESTION=" + s);
                                                    }
                                                    localCard.extendFriendQuestion = s;
                                                    localObject9 = this.app.getCurrentAccountUin();
                                                    if (s != 1) {
                                                      break label11882;
                                                    }
                                                    bool2 = true;
                                                    anoe.a((String)localObject9, bool2);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("CardHandler", 2, "handleGetDetailInfo FIELD_ADD_FRIEND_PAGE_INVITATION_FRIEND_ENTRY= " + i5);
                                                    }
                                                    BaseApplicationImpl.getContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putInt("invitation_friend_entry", i5).apply();
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("CardHandler", 2, "handleGetDetailInfo FIELD_CONTACTS_INVITE_FRD_FLAG= " + i5);
                                                    }
                                                    BaseApplicationImpl.getContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putInt("contacts_invite_friend_entry", i5).apply();
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    s = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.i("CardHandler", 2, "handleGetDetalInfo FIELD_EXTEND_FRIEND_CONTACT_CARD=" + s);
                                                    }
                                                    localCard.extendFriendEntryContact = s;
                                                    baig.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_contact", s).apply();
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    if (i5 != 0) {
                                                      break label11888;
                                                    }
                                                    bool2 = true;
                                                    localObject9 = this.app.c();
                                                    SettingCloneUtil.writeValue(this.app.getApp(), (String)localObject9, null, "qqsetting_show_push_message", bool2);
                                                    if (!QLog.isColorLevel()) {
                                                      break label11587;
                                                    }
                                                    QLog.d("PushNotise", 2, "handleGetDetailInfo open" + i5 + ", uin = " + localLong);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("CardHandler", 2, "SimpleUIUtil.onGetSimpleUISwitch");
                                                    }
                                                    localObject9 = localLong.toString();
                                                    if (localByteBuffer.getShort() != 1) {
                                                      break label11894;
                                                    }
                                                    bool2 = true;
                                                    awnu.a((String)localObject9, bool2, 1);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("CardHandler", 2, "SimpleUIUtil.onGetSimpleUIPref");
                                                    }
                                                    awnu.a(localLong.toString(), localByteBuffer.getShort(), 1);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("CardHandler", 2, "handleGetDetailInfo FIELD_TENCENT_DOC_FLAG tencentDoc = " + i5 + ", uin = " + localLong);
                                                    }
                                                    localObject9 = this.app.getApp();
                                                    localObject11 = localLong.toString();
                                                    if (i5 == 0) {
                                                      break label11900;
                                                    }
                                                    bool2 = true;
                                                    amxh.b((Context)localObject9, (String)localObject11, bool2);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    if (localByteBuffer.getShort() != 1) {
                                                      break label11906;
                                                    }
                                                    i5 = 1;
                                                    localObject9 = (ariq)this.app.getManager(303);
                                                    if (i5 != 0) {
                                                      break label11912;
                                                    }
                                                    bool2 = true;
                                                    ((ariq)localObject9).a(s, bool2, false);
                                                    i6 = i1;
                                                    localObject9 = localObject6;
                                                    i5 = m;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    i1 = i2;
                                                    i2 = i6;
                                                    m = n;
                                                    n = i5;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11659;
                                                    i5 = localByteBuffer.getShort();
                                                    localObject9 = localajjj.e(Long.toString(localLong.longValue()));
                                                    if (localObject9 == null) {
                                                      break label11918;
                                                    }
                                                    ((Friends)localObject9).isHideBigClub = i5;
                                                    localajjj.a((Friends)localObject9);
                                                    this.app.a(1).notifyUI(3, true, Long.toString(localLong.longValue()));
                                                    break label11918;
                                                    if (localByteBuffer.getShort() != 1) {
                                                      break label11989;
                                                    }
                                                    bool2 = true;
                                                    baeh.a(this.app);
                                                    localObject9 = amir.c();
                                                    bool4 = bajr.b(this.app);
                                                    bool3 = bool2;
                                                    if (((amiq)localObject9).jdField_a_of_type_Int > 1)
                                                    {
                                                      bool3 = bool2;
                                                      if (bool2)
                                                      {
                                                        bool3 = bool2;
                                                        if (!bool4)
                                                        {
                                                          QLog.e("vip_ptt.CardHandler", 1, "get ptt auto to txt online switch is ture but user is not svip!!");
                                                          bool3 = false;
                                                        }
                                                      }
                                                    }
                                                    if (bool3)
                                                    {
                                                      localObject11 = (amdz)alzw.a().a(442);
                                                      if ((localObject11 != null) && (!((amdz)localObject11).a()))
                                                      {
                                                        QLog.e("vip_ptt.CardHandler", 1, "get ptt auto to txt online switch is ture but config is close!!");
                                                        bool2 = false;
                                                        l1 = NetConnInfoCenter.getServerTime();
                                                        localObject11 = "businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin();
                                                        localObject12 = "businessinfo_ptt_auto_change_time_" + this.app.getCurrentAccountUin();
                                                        localObject13 = "businessinfo_ptt_auto_change_guide_has_show_" + this.app.getCurrentAccountUin();
                                                        localObject14 = this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
                                                        bool3 = adlw.d;
                                                        l2 = adlw.jdField_a_of_type_Long;
                                                        if (bool2)
                                                        {
                                                          if (!bool3)
                                                          {
                                                            ((SharedPreferences.Editor)localObject14).putLong((String)localObject12, l1);
                                                            adlw.jdField_a_of_type_Long = l1;
                                                          }
                                                          ((SharedPreferences.Editor)localObject14).putBoolean((String)localObject13, true);
                                                          adlw.e = true;
                                                        }
                                                        for (;;)
                                                        {
                                                          ((SharedPreferences.Editor)localObject14).putBoolean((String)localObject11, bool2);
                                                          ((SharedPreferences.Editor)localObject14).apply();
                                                          adlw.d = bool2;
                                                          QLog.e("vip_ptt.CardHandler", 2, "handleGetDetailInfo autoToText onLine:" + bool2 + ", oldSwitch: " + bool3 + ", time:" + l1 + ", oldTime:" + l2 + " conf.stage:" + ((amiq)localObject9).jdField_a_of_type_Int);
                                                          i6 = i1;
                                                          localObject9 = localObject6;
                                                          i5 = m;
                                                          localObject6 = localObject1;
                                                          localObject12 = paramObject;
                                                          localObject11 = paramFromServiceMsg;
                                                          i1 = i2;
                                                          i2 = i6;
                                                          m = n;
                                                          n = i5;
                                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                          paramObject = localObject2;
                                                          localObject1 = localObject5;
                                                          localObject2 = localObject3;
                                                          localObject3 = localObject4;
                                                          localObject4 = localObject12;
                                                          localObject5 = localObject6;
                                                          localObject6 = localObject11;
                                                          break;
                                                          ((SharedPreferences.Editor)localObject14).putLong((String)localObject12, 9223372036854775807L);
                                                        }
                                                        if (localByteBuffer.getShort() != 0) {
                                                          break label11995;
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label10292:
    label10689:
    label11587:
    label11846:
    label11852:
    label11858:
    label11864:
    label11995:
    for (boolean bool2 = true;; bool2 = false)
    {
      aemi.a(this.app).a(bool2);
      notifyUI(104, bool1, Boolean.valueOf(bool2));
      if (QLog.isColorLevel())
      {
        QLog.i("CardHandler", 2, "handleGetDetailInfo emotionRec onLine:" + bool2);
        i6 = i1;
        localObject9 = localObject6;
        i5 = m;
        localObject6 = localObject1;
        localObject12 = paramObject;
        localObject11 = paramFromServiceMsg;
        i1 = i2;
        i2 = i6;
        m = n;
        n = i5;
        paramFromServiceMsg = (FromServiceMsg)localObject9;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject12;
        localObject5 = localObject6;
        localObject6 = localObject11;
        break label11659;
        localObject9 = (akhf)this.app.getManager(199);
        if ((localObject9 != null) && (((akhf)localObject9).a())) {
          ((akhf)localObject9).a(i3, i1, i2);
        }
        if (k != 0) {
          localaifg.a(localApolloBaseInfo);
        }
        if (((aifg.a(this.app.getApp())) && (localApolloBaseInfo.isApolloStatusOpen()) && (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS)) || ((aifg.a(this.app) == 2) && (localApolloBaseInfo.getApolloDress3D() == null)))
        {
          localObject9 = new ArrayList(1);
          ((ArrayList)localObject9).add(Long.valueOf(localApolloBaseInfo.uin));
          localObject11 = (baot)this.app.a(71);
          if (localObject11 != null)
          {
            ((baot)localObject11).a((ArrayList)localObject9, "card");
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "handleGetDetailInfo update apollo user apolloDress uin: " + localApolloBaseInfo.uin);
            }
          }
        }
        if (m != 0)
        {
          localObject9 = new StringBuilder();
          ((StringBuilder)localObject9).append((String)localObject3).append("-");
          ((StringBuilder)localObject9).append((String)localObject5).append("-");
          ((StringBuilder)localObject9).append((String)localObject2).append("-");
          ((StringBuilder)localObject9).append((String)localObject6);
          localCard.strLocationCodes = ((StringBuilder)localObject9).toString();
        }
        if (n != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramFromServiceMsg).append("-");
          ((StringBuilder)localObject2).append((String)localObject1).append("-");
          ((StringBuilder)localObject2).append(paramObject).append("-");
          ((StringBuilder)localObject2).append((String)localObject4);
          localCard.strHometownCodes = ((StringBuilder)localObject2).toString();
        }
        localajjj.a(localCard);
        if (((m != 0) || (n != 0)) && (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))) {
          ((ajfw)this.app.getManager(59)).a(localCard);
        }
        paramToServiceMsg = localCard;
        break label721;
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          k = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "request error, ret " + k);
          }
          paramToServiceMsg = null;
          bool1 = false;
          break label721;
        }
        break label11864;
        i3 = i1;
        localObject9 = localObject6;
        i1 = i2;
        localObject6 = localObject5;
        i6 = m;
        localObject5 = localObject1;
        localObject11 = paramObject;
        localObject12 = paramFromServiceMsg;
        i2 = i3;
        i3 = i5;
        m = n;
        n = i6;
        paramFromServiceMsg = (FromServiceMsg)localObject9;
        paramObject = localObject2;
        localObject1 = localObject6;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject11;
        localObject6 = localObject12;
        break label11659;
        i2 = i1;
        i5 = m;
        localObject11 = localObject6;
        localObject6 = localObject1;
        localObject9 = paramFromServiceMsg;
        localObject12 = paramObject;
        i1 = i6;
        m = n;
        n = i5;
        paramFromServiceMsg = (FromServiceMsg)localObject11;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject12;
        localObject5 = localObject6;
        localObject6 = localObject9;
        break label11659;
        bool2 = false;
        break label7490;
        break label6999;
        break label6695;
        break label6518;
        break label6374;
        break label6061;
        break label5931;
        i1 = i2;
        i5 = m;
        localObject9 = paramObject;
        localObject11 = localObject1;
        localObject12 = paramFromServiceMsg;
        i2 = i6;
        m = n;
        n = i5;
        paramFromServiceMsg = (FromServiceMsg)localObject6;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject9;
        localObject5 = localObject11;
        localObject6 = localObject12;
        break label11659;
        paramToServiceMsg = null;
        break label721;
        switch (s)
        {
        }
        break label360;
      }
      i5 = i2;
      i2 = n;
      localObject9 = localObject6;
      localObject11 = localObject5;
      localObject13 = localObject4;
      localObject14 = localObject3;
      localObject12 = localObject2;
      localObject6 = paramFromServiceMsg;
      localObject5 = localObject1;
      localObject4 = paramObject;
      localObject3 = localObject13;
      localObject2 = localObject14;
      localObject1 = localObject11;
      paramObject = localObject12;
      paramFromServiceMsg = (FromServiceMsg)localObject9;
      n = m;
      m = i2;
      i2 = i1;
      i1 = i5;
      for (;;)
      {
        localObject9 = localObject3;
        localObject11 = localObject4;
        localObject12 = localObject5;
        localObject13 = localObject6;
        localObject3 = localObject2;
        i5 = n;
        n = i1;
        i1 = i2;
        i6 = i7;
        i4 += 1;
        i2 = n;
        n = m;
        m = i5;
        localObject6 = paramFromServiceMsg;
        localObject2 = paramObject;
        localObject5 = localObject1;
        localObject4 = localObject9;
        paramObject = localObject11;
        localObject1 = localObject12;
        paramFromServiceMsg = (FromServiceMsg)localObject13;
        break label264;
        bool1 = false;
        break;
        label11746:
        bool2 = false;
        break label3071;
        label11752:
        bool2 = false;
        break label3214;
        label11758:
        bool2 = true;
        break label3356;
        label11764:
        if (i5 == 0)
        {
          bool2 = false;
          break label3668;
        }
        bool2 = true;
        break label3668;
        if (i5 == 0)
        {
          i5 = 1;
          break label4027;
        }
        i5 = 0;
        break label4027;
        if ((i9 != 1) || (i5 == i6)) {
          break label11587;
        }
        if (i6 == 0)
        {
          bool2 = false;
          break label4148;
        }
        bool2 = true;
        break label4148;
        bool2 = false;
        break label4480;
        bool2 = false;
        break label5826;
        bool2 = false;
        break label7128;
        bool2 = false;
        break label7308;
        bool3 = false;
        break label7506;
        bool2 = false;
        break label7663;
        if (i5 == 1)
        {
          bool2 = true;
          break label8021;
        }
        bool2 = false;
        break label8021;
        label11882:
        bool2 = false;
        break label8456;
        label11888:
        bool2 = false;
        break label8990;
        label11894:
        bool2 = false;
        break label9167;
        label11900:
        bool2 = false;
        break label9421;
        i5 = 0;
        break label9513;
        bool2 = false;
        break label9536;
        i6 = i1;
        localObject9 = localObject6;
        i5 = m;
        localObject6 = localObject1;
        localObject12 = paramObject;
        localObject11 = paramFromServiceMsg;
        i1 = i2;
        i2 = i6;
        m = n;
        n = i5;
        paramFromServiceMsg = (FromServiceMsg)localObject9;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject12;
        localObject5 = localObject6;
        localObject6 = localObject11;
      }
      bool2 = false;
      break label9694;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    long l = paramToServiceMsg.extraData.getLong("pttcenter_targetuin");
    int j = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    int i = 9006;
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    boolean bool1;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespVoiceManage)))
    {
      bool1 = true;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localRespHead = (SummaryCard.RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("handleVoiceManager() respHead.iResult = ");
          if (localRespHead == null) {
            break label501;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label507;
        }
        bool1 = false;
        i = 9045;
        localStringBuilder1.append("|wupbuf: ").append(bach.a(paramFromServiceMsg.getWupBuffer()));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          SummaryCard.RespHead localRespHead;
          label209:
          short s;
          label377:
          boolean bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramBundle.toString());
          }
          bool1 = false;
          i = 9045;
          localStringBuilder1.append("|exception: ").append(paramBundle.toString()).append("|wufbuf: ").append(bach.a(paramFromServiceMsg.getWupBuffer()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() lUin = " + l + ", eOptype = " + j + ", success = " + bool1);
      }
      if (!bool1) {
        break label741;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l > 0L)
      {
        paramFromServiceMsg = (ajjj)this.app.getManager(51);
        paramObject = paramFromServiceMsg.c(String.valueOf(l));
        if (paramBundle.eOpType != 1) {
          break label650;
        }
        paramBundle = paramToServiceMsg.extraData.getString("pttcenter_filekey");
        s = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
        paramObject.strVoiceFilekey = paramBundle;
        paramObject.shDuration = s;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "上传成功");
        }
        bool2 = paramFromServiceMsg.a(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "更新结果  bRet = " + bool2);
        }
        notifyUI(35, true, new Object[] { String.valueOf(l), Integer.valueOf(j), paramObject });
      }
    }
    for (;;)
    {
      if (j == 1) {
        azyk.a(String.valueOf(l), 0, bool1, paramToServiceMsg.extraData.getString("pttcenter_filekey"), "0", azyk.a(), 0, i, 0L, localStringBuilder1.toString(), "");
      }
      return;
      bool1 = false;
      break;
      label501:
      paramBundle = null;
      break label160;
      label507:
      if (localRespHead.iResult != 0)
      {
        localStringBuilder1.append("|iResult: ").append(localRespHead.iResult);
        bool1 = false;
        i = 9007;
        break label209;
      }
      bool1 = true;
      break label209;
      i = 9311;
      localStringBuilder1.append("|resultcode: ").append(paramFromServiceMsg.getResultCode()).append("|reason: ").append(MessageHandler.a(paramFromServiceMsg));
      break label209;
      label650:
      if (paramBundle.eOpType == 2)
      {
        paramObject.strVoiceFilekey = "";
        paramObject.shDuration = 0;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, "删除成功");
        break label377;
      }
      if (paramBundle.eOpType != 3) {
        break label377;
      }
      if (paramObject.bRead != 1) {
        paramObject.bRead = 1;
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Q.profilecard.SummaryCard", 2, "已读标识设置成功");
      break label377;
      label741:
      notifyUI(35, false, new Object[] { String.valueOf(l), Integer.valueOf(j), null });
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    atmp localatmp;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localatmp = this.app.getEntityManagerFactory().createEntityManager();
      paramObject = (QZoneCover)localatmp.a(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localatmp.a(paramToServiceMsg);
        localatmp.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localatmp.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 1506
    //   9: iconst_2
    //   10: new 20	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3924
    //   20: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 1051	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +8517 -> 8556
    //   42: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   45: lstore 15
    //   47: aconst_null
    //   48: astore 26
    //   50: aload_2
    //   51: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   54: ifeq +388 -> 442
    //   57: aload_3
    //   58: instanceof 3926
    //   61: ifeq +381 -> 442
    //   64: iconst_1
    //   65: istore 6
    //   67: iload 6
    //   69: ifeq +8481 -> 8550
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 3833	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   77: ldc_w 3835
    //   80: new 3837	SummaryCard/RespHead
    //   83: dup
    //   84: invokespecial 3838	SummaryCard/RespHead:<init>	()V
    //   87: invokevirtual 2813	ajfi:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 3837	SummaryCard/RespHead
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +351 -> 448
    //   100: aload 4
    //   102: getfield 3843	SummaryCard/RespHead:iResult	I
    //   105: ifne +343 -> 448
    //   108: iconst_1
    //   109: istore 6
    //   111: new 20	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 3928
    //   121: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: astore 27
    //   126: aload 4
    //   128: ifnonnull +326 -> 454
    //   131: ldc_w 3930
    //   134: astore 26
    //   136: ldc_w 1506
    //   139: iconst_2
    //   140: aload 27
    //   142: aload 26
    //   144: invokevirtual 1039	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_1
    //   154: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   157: ldc_w 1449
    //   160: invokevirtual 2202	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   163: lstore 19
    //   165: aload_1
    //   166: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   169: ldc_w 1540
    //   172: invokevirtual 1048	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 26
    //   177: aload_1
    //   178: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   181: ldc_w 1518
    //   184: invokevirtual 2003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   187: istore 14
    //   189: aload_1
    //   190: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   193: ldc_w 1451
    //   196: invokevirtual 2202	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   199: lstore 21
    //   201: iload 6
    //   203: ifeq +8111 -> 8314
    //   206: aload_0
    //   207: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   210: bipush 51
    //   212: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   215: checkcast 167	ajjj
    //   218: astore 27
    //   220: aload_0
    //   221: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: bipush 52
    //   226: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   229: checkcast 3932	com/tencent/mobileqq/app/TroopManager
    //   232: astore 30
    //   234: aload_3
    //   235: checkcast 3926	SummaryCard/RespSummaryCard
    //   238: astore 28
    //   240: aload 28
    //   242: getfield 3935	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   245: invokestatic 3938	com/tencent/mobileqq/service/lbs/BusinessBuff:a	(Ljava/util/ArrayList;)Landroid/util/SparseArray;
    //   248: astore 31
    //   250: lload 19
    //   252: lconst_0
    //   253: lcmp
    //   254: ifgt +267 -> 521
    //   257: iload 14
    //   259: bipush 41
    //   261: if_icmpeq +260 -> 521
    //   264: iload 14
    //   266: bipush 6
    //   268: if_icmpeq +253 -> 521
    //   271: iload 14
    //   273: bipush 45
    //   275: if_icmpeq +246 -> 521
    //   278: aload 27
    //   280: aload 26
    //   282: invokevirtual 3941	ajjj:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   285: astore_1
    //   286: aload_1
    //   287: aload 28
    //   289: getfield 3944	SummaryCard/RespSummaryCard:bAge	B
    //   292: putfield 3947	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   295: aload_1
    //   296: aload 28
    //   298: getfield 3950	SummaryCard/RespSummaryCard:bSex	B
    //   301: putfield 3951	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   304: aload_1
    //   305: aload 28
    //   307: getfield 3952	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   310: putfield 3954	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   313: aload_1
    //   314: aload 28
    //   316: getfield 3955	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   319: putfield 3956	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   322: aload_1
    //   323: aload 28
    //   325: getfield 3957	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   328: putfield 3958	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   331: aload_1
    //   332: aload 28
    //   334: getfield 3959	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   337: putfield 3960	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   340: aload_1
    //   341: aload 28
    //   343: getfield 3963	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   346: putfield 3964	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   349: aload 28
    //   351: getfield 3967	SummaryCard/RespSummaryCard:iContactNotBindQQ	I
    //   354: iconst_1
    //   355: if_icmpeq +150 -> 505
    //   358: iconst_1
    //   359: istore 25
    //   361: aload_1
    //   362: iload 25
    //   364: putfield 3970	com/tencent/mobileqq/data/ContactCard:bindQQ	Z
    //   367: aload 28
    //   369: getfield 3973	SummaryCard/RespSummaryCard:lUIN	J
    //   372: lconst_0
    //   373: lcmp
    //   374: ifle +137 -> 511
    //   377: aload_1
    //   378: aload 28
    //   380: getfield 3973	SummaryCard/RespSummaryCard:lUIN	J
    //   383: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   386: putfield 3974	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   389: aload 27
    //   391: aload_1
    //   392: invokevirtual 3977	ajjj:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   395: pop
    //   396: aload_0
    //   397: iconst_1
    //   398: iconst_1
    //   399: aload_1
    //   400: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   403: invokestatic 1051	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   406: ifeq +35 -> 441
    //   409: ldc_w 1506
    //   412: iconst_4
    //   413: new 20	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   420: ldc_w 3979
    //   423: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   429: lload 15
    //   431: lsub
    //   432: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   435: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: return
    //   442: iconst_0
    //   443: istore 6
    //   445: goto -378 -> 67
    //   448: iconst_0
    //   449: istore 6
    //   451: goto -340 -> 111
    //   454: aload 4
    //   456: getfield 3843	SummaryCard/RespHead:iResult	I
    //   459: istore 7
    //   461: iload 7
    //   463: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: astore 26
    //   468: goto -332 -> 136
    //   471: astore 27
    //   473: aload 26
    //   475: astore 4
    //   477: aload 27
    //   479: astore 26
    //   481: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +15 -> 499
    //   487: ldc_w 1506
    //   490: iconst_2
    //   491: aload 26
    //   493: invokevirtual 3882	java/lang/Exception:toString	()Ljava/lang/String;
    //   496: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: iconst_0
    //   500: istore 6
    //   502: goto -349 -> 153
    //   505: iconst_0
    //   506: istore 25
    //   508: goto -147 -> 361
    //   511: aload_1
    //   512: ldc_w 327
    //   515: putfield 3974	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   518: goto -129 -> 389
    //   521: aload_1
    //   522: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   525: ldc_w 1550
    //   528: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   531: iconst_1
    //   532: if_icmpeq -91 -> 441
    //   535: lload 19
    //   537: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   540: astore 29
    //   542: aload 27
    //   544: aload 29
    //   546: invokevirtual 612	ajjj:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   549: astore 26
    //   551: aload 26
    //   553: aload 28
    //   555: getfield 3980	SummaryCard/RespSummaryCard:iLevel	I
    //   558: putfield 3317	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   561: aload 26
    //   563: aload 28
    //   565: getfield 3952	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   568: putfield 3086	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   571: aload 26
    //   573: aload 28
    //   575: getfield 3950	SummaryCard/RespSummaryCard:bSex	B
    //   578: i2s
    //   579: putfield 3112	com/tencent/mobileqq/data/Card:shGender	S
    //   582: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +46 -> 631
    //   588: ldc_w 3982
    //   591: aload 29
    //   593: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   596: ifeq +35 -> 631
    //   599: ldc 97
    //   601: iconst_2
    //   602: ldc_w 3984
    //   605: iconst_2
    //   606: anewarray 403	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: aload 29
    //   613: aastore
    //   614: dup
    //   615: iconst_1
    //   616: aload 28
    //   618: getfield 3950	SummaryCard/RespSummaryCard:bSex	B
    //   621: invokestatic 2250	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   624: aastore
    //   625: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   628: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: aload 26
    //   633: aload 28
    //   635: getfield 3987	SummaryCard/RespSummaryCard:uCurMulType	J
    //   638: putfield 3988	com/tencent/mobileqq/data/Card:uCurMulType	J
    //   641: invokestatic 3991	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   644: ifne +9 -> 653
    //   647: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +33 -> 683
    //   653: ldc 97
    //   655: iconst_1
    //   656: new 20	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 3993
    //   666: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 26
    //   671: getfield 3988	com/tencent/mobileqq/data/Card:uCurMulType	J
    //   674: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   677: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload 26
    //   685: aload 28
    //   687: getfield 3944	SummaryCard/RespSummaryCard:bAge	B
    //   690: i2s
    //   691: putfield 3244	com/tencent/mobileqq/data/Card:shAge	S
    //   694: aload 26
    //   696: aload 28
    //   698: getfield 3944	SummaryCard/RespSummaryCard:bAge	B
    //   701: putfield 3124	com/tencent/mobileqq/data/Card:age	B
    //   704: aload 26
    //   706: aload 28
    //   708: getfield 3996	SummaryCard/RespSummaryCard:iFace	I
    //   711: putfield 3248	com/tencent/mobileqq/data/Card:nFaceID	I
    //   714: aload 26
    //   716: aload 28
    //   718: getfield 3999	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   721: putfield 4000	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   724: aload 26
    //   726: aload 28
    //   728: getfield 3959	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   731: putfield 3191	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   734: aload 26
    //   736: aload 28
    //   738: getfield 3955	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   741: putfield 3188	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   744: aload 26
    //   746: aload 28
    //   748: getfield 3957	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   751: putfield 3185	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   754: aload 26
    //   756: aload 28
    //   758: getfield 4003	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   761: putfield 4006	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   764: aload 26
    //   766: aload 28
    //   768: getfield 4009	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   771: putfield 2689	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   774: aload 26
    //   776: aload 28
    //   778: getfield 4012	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   781: putfield 4015	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   784: aload 26
    //   786: aload 28
    //   788: getfield 4018	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   791: putfield 4021	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   794: aload 26
    //   796: aload 28
    //   798: getfield 4024	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   801: putfield 4025	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   804: aload 26
    //   806: aload 28
    //   808: getfield 3963	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   811: putfield 4026	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   814: aload 26
    //   816: aload 28
    //   818: getfield 4029	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   821: putfield 4030	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   824: aload 26
    //   826: aload 28
    //   828: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   831: putfield 4034	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   834: aload 26
    //   836: aload 28
    //   838: getfield 4036	SummaryCard/RespSummaryCard:vSeed	[B
    //   841: putfield 4037	com/tencent/mobileqq/data/Card:vSeed	[B
    //   844: aload 26
    //   846: aload 28
    //   848: getfield 4040	SummaryCard/RespSummaryCard:iVoteCount	I
    //   851: i2l
    //   852: putfield 3298	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   855: aload 26
    //   857: aload 28
    //   859: getfield 4043	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   862: putfield 4046	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   865: aload 26
    //   867: iload 14
    //   869: putfield 4048	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   872: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   875: ifeq +61 -> 936
    //   878: ldc 97
    //   880: iconst_2
    //   881: new 20	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   888: ldc_w 4050
    //   891: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 28
    //   896: getfield 4053	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   899: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: ldc_w 4055
    //   905: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload 28
    //   910: getfield 4058	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   913: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: ldc_w 4060
    //   919: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 28
    //   924: getfield 4061	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   927: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   930: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   936: aload 28
    //   938: getfield 4065	SummaryCard/RespSummaryCard:stQCallInfo	LSummaryCard/QCallInfo;
    //   941: astore_2
    //   942: aload_2
    //   943: ifnull +2090 -> 3033
    //   946: aload_2
    //   947: getfield 4070	SummaryCard/QCallInfo:bStatus	I
    //   950: iconst_1
    //   951: if_icmpne +2061 -> 3012
    //   954: aload 26
    //   956: iconst_1
    //   957: putfield 4073	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   960: aload 26
    //   962: aload_2
    //   963: getfield 4074	SummaryCard/QCallInfo:strNick	Ljava/lang/String;
    //   966: putfield 4077	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   969: aload 26
    //   971: aload_2
    //   972: getfield 4080	SummaryCard/QCallInfo:uQCallId	J
    //   975: invokestatic 4083	baip:a	(J)Ljava/lang/String;
    //   978: putfield 4086	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   981: invokestatic 1051	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   984: ifeq +75 -> 1059
    //   987: ldc_w 4088
    //   990: iconst_4
    //   991: new 20	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   998: ldc_w 4090
    //   1001: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 26
    //   1006: getfield 4073	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   1009: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1012: ldc_w 4092
    //   1015: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: aload 26
    //   1020: getfield 4077	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   1023: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: ldc_w 4094
    //   1029: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_2
    //   1033: getfield 4070	SummaryCard/QCallInfo:bStatus	I
    //   1036: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1039: ldc_w 4096
    //   1042: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 26
    //   1047: getfield 4086	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   1050: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1056: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1059: aload 29
    //   1061: aload_0
    //   1062: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1065: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1068: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1071: ifeq +38 -> 1109
    //   1074: aload_0
    //   1075: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1078: bipush 106
    //   1080: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1083: checkcast 3114	ascz
    //   1086: astore_2
    //   1087: aload_2
    //   1088: ifnull +21 -> 1109
    //   1091: aload_2
    //   1092: aload 28
    //   1094: getfield 3950	SummaryCard/RespSummaryCard:bSex	B
    //   1097: invokevirtual 3115	ascz:b	(I)V
    //   1100: aload_2
    //   1101: aload 28
    //   1103: getfield 3944	SummaryCard/RespSummaryCard:bAge	B
    //   1106: invokevirtual 3130	ascz:a	(I)V
    //   1109: aload_1
    //   1110: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1113: ldc_w 1518
    //   1116: invokevirtual 2003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1119: bipush 37
    //   1121: if_icmpne +18 -> 1139
    //   1124: aload 26
    //   1126: aload_1
    //   1127: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1130: ldc_w 1540
    //   1133: invokevirtual 1048	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: putfield 4099	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   1139: aload 4
    //   1141: ifnull +13 -> 1154
    //   1144: aload 26
    //   1146: aload 4
    //   1148: getfield 4102	SummaryCard/RespHead:vCookies	[B
    //   1151: putfield 4103	com/tencent/mobileqq/data/Card:vCookies	[B
    //   1154: aload 26
    //   1156: getfield 4104	com/tencent/mobileqq/data/Card:bHaveVotedCnt	S
    //   1159: ifle +1893 -> 3052
    //   1162: aload 26
    //   1164: iconst_1
    //   1165: putfield 1471	com/tencent/mobileqq/data/Card:bVoted	B
    //   1168: aload 26
    //   1170: aload 28
    //   1172: getfield 4107	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1175: l2i
    //   1176: putfield 4109	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   1179: aload 28
    //   1181: getfield 4112	SummaryCard/RespSummaryCard:i0x6d4Success	I
    //   1184: ifeq +30 -> 1214
    //   1187: ldc 97
    //   1189: iconst_1
    //   1190: ldc_w 4114
    //   1193: iconst_1
    //   1194: anewarray 403	java/lang/Object
    //   1197: dup
    //   1198: iconst_0
    //   1199: aload 28
    //   1201: getfield 4112	SummaryCard/RespSummaryCard:i0x6d4Success	I
    //   1204: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1211: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: aload_0
    //   1215: aload 26
    //   1217: aload 31
    //   1219: invokevirtual 4116	ajfi:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)Z
    //   1222: ifne +1839 -> 3061
    //   1225: aload 28
    //   1227: getfield 4112	SummaryCard/RespSummaryCard:i0x6d4Success	I
    //   1230: ifne +24 -> 1254
    //   1233: aload 26
    //   1235: aload 28
    //   1237: getfield 4040	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1240: i2l
    //   1241: putfield 1468	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1244: aload 26
    //   1246: aload 28
    //   1248: getfield 4119	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1251: putfield 4122	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1254: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1257: ifeq +41 -> 1298
    //   1260: ldc 97
    //   1262: iconst_2
    //   1263: ldc_w 4124
    //   1266: iconst_2
    //   1267: anewarray 403	java/lang/Object
    //   1270: dup
    //   1271: iconst_0
    //   1272: aload 26
    //   1274: getfield 1468	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1277: invokestatic 576	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1280: aastore
    //   1281: dup
    //   1282: iconst_1
    //   1283: aload 26
    //   1285: getfield 4122	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1288: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1291: aastore
    //   1292: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1295: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1298: aload 28
    //   1300: getfield 4112	SummaryCard/RespSummaryCard:i0x6d4Success	I
    //   1303: ifne +178 -> 1481
    //   1306: aload 26
    //   1308: aload 28
    //   1310: getfield 4053	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1313: putfield 4125	com/tencent/mobileqq/data/Card:strVoteLimitedNotice	Ljava/lang/String;
    //   1316: aload 26
    //   1318: aload 28
    //   1320: getfield 4058	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1323: putfield 4104	com/tencent/mobileqq/data/Card:bHaveVotedCnt	S
    //   1326: aload 26
    //   1328: aload 28
    //   1330: getfield 4061	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1333: putfield 2253	com/tencent/mobileqq/data/Card:bAvailVoteCnt	S
    //   1336: aload 29
    //   1338: aload_0
    //   1339: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1342: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1345: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1348: ifeq +133 -> 1481
    //   1351: aload 26
    //   1353: aload 28
    //   1355: getfield 4128	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   1358: invokevirtual 4131	com/tencent/mobileqq/data/Card:setLastPraiseInfoList	(Ljava/util/ArrayList;)V
    //   1361: aload_0
    //   1362: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1365: invokevirtual 3148	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1368: aload 26
    //   1370: getfield 1468	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1373: aload 26
    //   1375: getfield 4122	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1378: invokestatic 4134	asfc:a	(Ljava/lang/String;JI)Z
    //   1381: pop
    //   1382: aload_0
    //   1383: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1386: invokevirtual 2232	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   1389: invokevirtual 2238	atmq:createEntityManager	()Latmp;
    //   1392: astore 4
    //   1394: aload 4
    //   1396: ldc_w 4136
    //   1399: ldc_w 4138
    //   1402: iconst_1
    //   1403: anewarray 254	java/lang/String
    //   1406: dup
    //   1407: iconst_0
    //   1408: aload 29
    //   1410: aastore
    //   1411: invokevirtual 4141	atmp:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Latmo;
    //   1414: checkcast 4136	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1417: astore_3
    //   1418: aload_3
    //   1419: astore_2
    //   1420: aload_3
    //   1421: ifnonnull +11 -> 1432
    //   1424: new 4136	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1427: dup
    //   1428: invokespecial 4142	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1431: astore_2
    //   1432: aload_2
    //   1433: aload 26
    //   1435: getfield 1468	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1438: l2i
    //   1439: putfield 4145	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1442: aload_2
    //   1443: aload 26
    //   1445: getfield 4122	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1448: putfield 4148	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1451: aload_2
    //   1452: aload 28
    //   1454: getfield 4128	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   1457: putfield 4151	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   1460: aload_2
    //   1461: invokevirtual 4152	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1464: sipush 1000
    //   1467: if_icmpne +1612 -> 3079
    //   1470: aload 4
    //   1472: aload_2
    //   1473: invokevirtual 4154	atmp:b	(Latmo;)V
    //   1476: aload 4
    //   1478: invokevirtual 3922	atmp:a	()V
    //   1481: aload 28
    //   1483: getfield 4107	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1486: lconst_1
    //   1487: land
    //   1488: lconst_0
    //   1489: lcmp
    //   1490: ifne +1619 -> 3109
    //   1493: iconst_0
    //   1494: istore 25
    //   1496: aload 26
    //   1498: iload 25
    //   1500: invokevirtual 4157	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   1503: aload 28
    //   1505: getfield 4107	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1508: ldc2_w 4158
    //   1511: land
    //   1512: lconst_0
    //   1513: lcmp
    //   1514: ifne +1601 -> 3115
    //   1517: iconst_0
    //   1518: istore 25
    //   1520: aload 26
    //   1522: iload 25
    //   1524: invokevirtual 4162	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   1527: aload 28
    //   1529: getfield 4165	SummaryCard/RespSummaryCard:lCacheControl	J
    //   1532: lconst_0
    //   1533: lcmp
    //   1534: ifne +1587 -> 3121
    //   1537: iconst_0
    //   1538: istore 25
    //   1540: aload 26
    //   1542: iload 25
    //   1544: invokevirtual 4168	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   1547: aload 28
    //   1549: getfield 4107	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1552: ldc2_w 4169
    //   1555: land
    //   1556: lconst_0
    //   1557: lcmp
    //   1558: ifne +1569 -> 3127
    //   1561: iconst_0
    //   1562: istore 25
    //   1564: aload 26
    //   1566: iload 25
    //   1568: invokevirtual 4173	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   1571: aload 26
    //   1573: aload 28
    //   1575: getfield 4176	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   1578: putfield 4177	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   1581: aload 26
    //   1583: aload 28
    //   1585: getfield 4180	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   1588: putfield 4181	com/tencent/mobileqq/data/Card:strSpaceName	Ljava/lang/String;
    //   1591: aload 26
    //   1593: aload 28
    //   1595: getfield 4184	SummaryCard/RespSummaryCard:strQzoneHeader	Ljava/lang/String;
    //   1598: putfield 4185	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1601: aload 28
    //   1603: getfield 4188	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1606: ifnull +211 -> 1817
    //   1609: aload 28
    //   1611: getfield 4188	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1614: ldc_w 4190
    //   1617: invokeinterface 4193 2 0
    //   1622: checkcast 4195	java/lang/CharSequence
    //   1625: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1628: ifne +114 -> 1742
    //   1631: aload 28
    //   1633: getfield 4188	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1636: ldc_w 4190
    //   1639: invokeinterface 4193 2 0
    //   1644: checkcast 254	java/lang/String
    //   1647: astore_3
    //   1648: aload_3
    //   1649: astore_2
    //   1650: aload 26
    //   1652: getfield 4185	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1655: ifnull +60 -> 1715
    //   1658: aload_3
    //   1659: astore_2
    //   1660: aload 26
    //   1662: getfield 4185	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1665: invokevirtual 4198	java/lang/String:length	()I
    //   1668: bipush 10
    //   1670: if_icmple +45 -> 1715
    //   1673: aload_3
    //   1674: astore_2
    //   1675: aload_3
    //   1676: ifnull +39 -> 1715
    //   1679: aload_3
    //   1680: astore_2
    //   1681: aload_3
    //   1682: invokevirtual 4198	java/lang/String:length	()I
    //   1685: iconst_5
    //   1686: if_icmple +29 -> 1715
    //   1689: new 20	java/lang/StringBuilder
    //   1692: dup
    //   1693: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1696: aload_3
    //   1697: iconst_0
    //   1698: iconst_5
    //   1699: invokevirtual 4202	java/lang/String:substring	(II)Ljava/lang/String;
    //   1702: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: ldc_w 4204
    //   1708: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1714: astore_2
    //   1715: aload 26
    //   1717: new 20	java/lang/StringBuilder
    //   1720: dup
    //   1721: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1724: aload_2
    //   1725: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: aload 26
    //   1730: getfield 4185	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1733: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: putfield 4185	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1742: aload 28
    //   1744: getfield 4188	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1747: ldc_w 4206
    //   1750: invokeinterface 4193 2 0
    //   1755: checkcast 254	java/lang/String
    //   1758: astore_2
    //   1759: aload_2
    //   1760: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1763: ifne +1384 -> 3147
    //   1766: aload 26
    //   1768: aload_2
    //   1769: invokestatic 2417	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1772: putfield 4209	com/tencent/mobileqq/data/Card:enlargeQzonePic	I
    //   1775: aload 28
    //   1777: getfield 4188	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1780: ldc_w 4211
    //   1783: invokeinterface 4193 2 0
    //   1788: checkcast 254	java/lang/String
    //   1791: astore_2
    //   1792: aload_2
    //   1793: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1796: ifne +1386 -> 3182
    //   1799: aload_2
    //   1800: invokestatic 2417	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1803: iconst_1
    //   1804: if_icmpne +1352 -> 3156
    //   1807: iconst_1
    //   1808: istore 25
    //   1810: aload 26
    //   1812: iload 25
    //   1814: putfield 4214	com/tencent/mobileqq/data/Card:showPublishButton	Z
    //   1817: aload 26
    //   1819: aload 28
    //   1821: getfield 4217	SummaryCard/RespSummaryCard:vQzoneCoverInfo	[B
    //   1824: putfield 4218	com/tencent/mobileqq/data/Card:vQzoneCoverInfo	[B
    //   1827: aload 26
    //   1829: invokevirtual 4221	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   1832: ifne +34 -> 1866
    //   1835: aload 26
    //   1837: getfield 4224	com/tencent/mobileqq/data/Card:qzonePhotoList	Ljava/util/ArrayList;
    //   1840: invokevirtual 4225	java/util/ArrayList:clear	()V
    //   1843: aload 28
    //   1845: getfield 4229	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1848: astore_2
    //   1849: aload_2
    //   1850: ifnull +16 -> 1866
    //   1853: aload_2
    //   1854: getfield 4234	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1857: ifnull +9 -> 1866
    //   1860: aload 26
    //   1862: aload_2
    //   1863: invokevirtual 4238	com/tencent/mobileqq/data/Card:addQzonePhotoList	(LSummaryCard/AlbumInfo;)V
    //   1866: aload 26
    //   1868: aload 28
    //   1870: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   1873: invokevirtual 4246	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   1876: aload_1
    //   1877: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1880: ldc_w 1542
    //   1883: invokevirtual 2202	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1886: lstore 17
    //   1888: lconst_1
    //   1889: lload 17
    //   1891: land
    //   1892: lconst_0
    //   1893: lcmp
    //   1894: ifeq +71 -> 1965
    //   1897: aload 26
    //   1899: aload 28
    //   1901: getfield 4249	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1904: putfield 4250	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1907: aload 26
    //   1909: getfield 4250	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1912: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1915: ifeq +10 -> 1925
    //   1918: aload 26
    //   1920: aload 29
    //   1922: putfield 4250	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1925: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1928: ifeq +37 -> 1965
    //   1931: ldc_w 1506
    //   1934: iconst_2
    //   1935: new 20	java/lang/StringBuilder
    //   1938: dup
    //   1939: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1942: ldc_w 4252
    //   1945: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: aload 28
    //   1950: getfield 4249	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1953: invokestatic 4254	azzz:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1956: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1962: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1965: ldc2_w 4255
    //   1968: lload 17
    //   1970: land
    //   1971: lconst_0
    //   1972: lcmp
    //   1973: ifeq +13 -> 1986
    //   1976: aload 26
    //   1978: aload 28
    //   1980: getfield 4259	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   1983: putfield 4260	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   1986: ldc2_w 4261
    //   1989: lload 17
    //   1991: land
    //   1992: lconst_0
    //   1993: lcmp
    //   1994: ifeq +23 -> 2017
    //   1997: aload 26
    //   1999: aload 28
    //   2001: getfield 4265	SummaryCard/RespSummaryCard:vRichSign	[B
    //   2004: putfield 4266	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   2007: aload 26
    //   2009: aload 28
    //   2011: getfield 4269	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   2014: putfield 4272	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   2017: ldc2_w 4273
    //   2020: lload 17
    //   2022: land
    //   2023: lconst_0
    //   2024: lcmp
    //   2025: ifeq +13 -> 2038
    //   2028: aload 26
    //   2030: aload 28
    //   2032: getfield 4277	SummaryCard/RespSummaryCard:vLongNickTopicInfo	[B
    //   2035: putfield 4278	com/tencent/mobileqq/data/Card:vLongNickTopicInfo	[B
    //   2038: aload 28
    //   2040: getfield 4281	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   2043: ifnull +30 -> 2073
    //   2046: aload 26
    //   2048: aload_0
    //   2049: aload 28
    //   2051: getfield 4281	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   2054: ldc_w 4283
    //   2057: new 4285	GameCenter/RespLastGameInfo
    //   2060: dup
    //   2061: invokespecial 4286	GameCenter/RespLastGameInfo:<init>	()V
    //   2064: invokevirtual 2813	ajfi:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2067: checkcast 4285	GameCenter/RespLastGameInfo
    //   2070: invokevirtual 4290	com/tencent/mobileqq/data/Card:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   2073: ldc_w 1701
    //   2076: iconst_1
    //   2077: new 20	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2084: ldc_w 4292
    //   2087: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: lload 17
    //   2092: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2095: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2101: ldc2_w 4293
    //   2104: lload 17
    //   2106: land
    //   2107: lconst_0
    //   2108: lcmp
    //   2109: ifeq +241 -> 2350
    //   2112: new 380	java/util/HashMap
    //   2115: dup
    //   2116: invokespecial 381	java/util/HashMap:<init>	()V
    //   2119: astore_2
    //   2120: aload 28
    //   2122: getfield 4297	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   2125: ifnull +1066 -> 3191
    //   2128: aload_0
    //   2129: aload 28
    //   2131: getfield 4297	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   2134: ldc_w 2806
    //   2137: new 2808	SummaryCardTaf/SSummaryCardRsp
    //   2140: dup
    //   2141: invokespecial 2809	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   2144: invokevirtual 2813	ajfi:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2147: checkcast 2808	SummaryCardTaf/SSummaryCardRsp
    //   2150: astore_3
    //   2151: aload 26
    //   2153: aload_0
    //   2154: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2157: aload 29
    //   2159: aload_3
    //   2160: invokevirtual 4301	com/tencent/mobileqq/data/Card:updateCardTemplate	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;LSummaryCardTaf/SSummaryCardRsp;)V
    //   2163: aload_3
    //   2164: ifnull +68 -> 2232
    //   2167: aload_3
    //   2168: getfield 4304	SummaryCardTaf/SSummaryCardRsp:urlprefix	Ljava/lang/String;
    //   2171: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2174: ifne +58 -> 2232
    //   2177: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2180: ifeq +45 -> 2225
    //   2183: ldc 97
    //   2185: iconst_2
    //   2186: new 20	java/lang/StringBuilder
    //   2189: dup
    //   2190: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2193: ldc_w 4306
    //   2196: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: aload_3
    //   2200: getfield 4304	SummaryCardTaf/SSummaryCardRsp:urlprefix	Ljava/lang/String;
    //   2203: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: ldc_w 4308
    //   2209: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2212: aload_3
    //   2213: getfield 4311	SummaryCardTaf/SSummaryCardRsp:profileid	I
    //   2216: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2219: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2225: aload_3
    //   2226: getfield 4304	SummaryCardTaf/SSummaryCardRsp:urlprefix	Ljava/lang/String;
    //   2229: putstatic 4314	atwy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2232: aload_3
    //   2233: ifnull +117 -> 2350
    //   2236: aload_3
    //   2237: getfield 4318	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   2240: ifnull +110 -> 2350
    //   2243: aload_3
    //   2244: getfield 4318	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   2247: getfield 4323	SummaryCardTaf/STRecommendInfo:iRecomCard	J
    //   2250: lstore 23
    //   2252: new 20	java/lang/StringBuilder
    //   2255: dup
    //   2256: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2259: getstatic 4314	atwy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2262: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: aload_3
    //   2266: getfield 4318	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   2269: getfield 4326	SummaryCardTaf/STRecommendInfo:strRecomUrl	Ljava/lang/String;
    //   2272: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2275: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2278: astore_2
    //   2279: aload_3
    //   2280: getfield 4318	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   2283: getfield 4329	SummaryCardTaf/STRecommendInfo:strDesc	Ljava/lang/String;
    //   2286: astore_3
    //   2287: aload_2
    //   2288: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2291: ifne +59 -> 2350
    //   2294: aload_3
    //   2295: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2298: ifne +52 -> 2350
    //   2301: invokestatic 706	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2304: ldc_w 4331
    //   2307: iconst_0
    //   2308: invokevirtual 712	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2311: invokeinterface 218 1 0
    //   2316: ldc_w 4333
    //   2319: lload 23
    //   2321: invokeinterface 230 4 0
    //   2326: ldc_w 4335
    //   2329: aload_2
    //   2330: invokeinterface 305 3 0
    //   2335: ldc_w 4337
    //   2338: aload_3
    //   2339: invokeinterface 305 3 0
    //   2344: invokeinterface 233 1 0
    //   2349: pop
    //   2350: ldc2_w 4338
    //   2353: lload 17
    //   2355: land
    //   2356: lconst_0
    //   2357: lcmp
    //   2358: ifeq +50 -> 2408
    //   2361: aload 26
    //   2363: aload 28
    //   2365: getfield 4342	SummaryCard/RespSummaryCard:lUserFlag	J
    //   2368: putfield 4343	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2371: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2374: ifeq +34 -> 2408
    //   2377: ldc_w 1506
    //   2380: iconst_2
    //   2381: new 20	java/lang/StringBuilder
    //   2384: dup
    //   2385: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2388: ldc_w 4345
    //   2391: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2394: aload 26
    //   2396: getfield 4343	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2399: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2402: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2405: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2408: ldc2_w 4169
    //   2411: lload 17
    //   2413: land
    //   2414: lconst_0
    //   2415: lcmp
    //   2416: ifeq +74 -> 2490
    //   2419: aload 26
    //   2421: aload 28
    //   2423: getfield 4348	SummaryCard/RespSummaryCard:uLoginDays	J
    //   2426: putfield 4351	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2429: aload 26
    //   2431: aload 28
    //   2433: getfield 4354	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   2436: putfield 4357	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2439: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2442: ifeq +48 -> 2490
    //   2445: ldc_w 1506
    //   2448: iconst_2
    //   2449: new 20	java/lang/StringBuilder
    //   2452: dup
    //   2453: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2456: ldc_w 4359
    //   2459: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: aload 26
    //   2464: getfield 4351	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2467: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2470: ldc_w 4361
    //   2473: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2476: aload 26
    //   2478: getfield 4357	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2481: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2487: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2490: aload 28
    //   2492: getfield 4365	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2495: ifnull +89 -> 2584
    //   2498: aload 26
    //   2500: aload 28
    //   2502: getfield 4365	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2505: getfield 4369	SummaryCard/TNowBroadcastInfo:iFlag	I
    //   2508: putfield 4372	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   2511: aload 26
    //   2513: aload 28
    //   2515: getfield 4365	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2518: getfield 4375	SummaryCard/TNowBroadcastInfo:strIconURL	Ljava/lang/String;
    //   2521: putfield 4378	com/tencent/mobileqq/data/Card:mNowShowIconUrl	Ljava/lang/String;
    //   2524: aload 26
    //   2526: aload 28
    //   2528: getfield 4365	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2531: getfield 4381	SummaryCard/TNowBroadcastInfo:strHrefURL	Ljava/lang/String;
    //   2534: putfield 4384	com/tencent/mobileqq/data/Card:mNowShowJumpUrl	Ljava/lang/String;
    //   2537: aload 26
    //   2539: getfield 4372	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   2542: iconst_1
    //   2543: if_icmpne +41 -> 2584
    //   2546: aload_0
    //   2547: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2550: ldc_w 4386
    //   2553: ldc_w 4388
    //   2556: ldc_w 327
    //   2559: ldc_w 4390
    //   2562: ldc_w 4392
    //   2565: iconst_0
    //   2566: iconst_0
    //   2567: aload 26
    //   2569: getfield 2679	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   2572: ldc_w 327
    //   2575: ldc_w 327
    //   2578: ldc_w 327
    //   2581: invokestatic 2336	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2584: aload 28
    //   2586: getfield 4396	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   2589: ifnull +88 -> 2677
    //   2592: aload 26
    //   2594: aload 28
    //   2596: getfield 4396	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   2599: getfield 4401	SummaryCard/TCoverInfo:vTagInfo	[B
    //   2602: invokevirtual 4404	com/tencent/mobileqq/data/Card:updateCoverData	([B)V
    //   2605: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2608: ifeq +69 -> 2677
    //   2611: ldc 97
    //   2613: iconst_2
    //   2614: new 20	java/lang/StringBuilder
    //   2617: dup
    //   2618: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2621: ldc_w 4406
    //   2624: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2627: aload 26
    //   2629: getfield 4409	com/tencent/mobileqq/data/Card:vCoverInfo	[B
    //   2632: arraylength
    //   2633: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2636: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2639: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2642: aload 26
    //   2644: iconst_0
    //   2645: invokevirtual 4413	com/tencent/mobileqq/data/Card:getCoverData	(I)[Ljava/lang/Object;
    //   2648: astore_2
    //   2649: ldc 97
    //   2651: iconst_2
    //   2652: new 20	java/lang/StringBuilder
    //   2655: dup
    //   2656: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   2659: ldc_w 4415
    //   2662: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: aload_2
    //   2666: iconst_0
    //   2667: aaload
    //   2668: invokevirtual 1039	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2671: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2674: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2677: aload 28
    //   2679: getfield 4418	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2682: ifnull +172 -> 2854
    //   2685: aload 28
    //   2687: getfield 4418	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2690: invokevirtual 4424	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   2693: astore_2
    //   2694: aload_2
    //   2695: ifnull +159 -> 2854
    //   2698: aload_2
    //   2699: bipush 101
    //   2701: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2704: invokeinterface 4193 2 0
    //   2709: checkcast 4426	QQService/VipOpenInfo
    //   2712: astore_3
    //   2713: aload_3
    //   2714: getfield 4429	QQService/VipOpenInfo:bOpen	Z
    //   2717: ifeq +24 -> 2741
    //   2720: aload 26
    //   2722: iconst_1
    //   2723: putfield 4432	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   2726: aload_3
    //   2727: getfield 4435	QQService/VipOpenInfo:iVipFlag	I
    //   2730: iconst_1
    //   2731: iand
    //   2732: ifle +9 -> 2741
    //   2735: aload 26
    //   2737: iconst_1
    //   2738: putfield 4438	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   2741: aload 26
    //   2743: aload_3
    //   2744: getfield 4441	QQService/VipOpenInfo:iVipLevel	I
    //   2747: putfield 4444	com/tencent/mobileqq/data/Card:redLevel	I
    //   2750: aload_2
    //   2751: bipush 102
    //   2753: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2756: invokeinterface 4193 2 0
    //   2761: checkcast 4426	QQService/VipOpenInfo
    //   2764: astore_3
    //   2765: aload_3
    //   2766: getfield 4429	QQService/VipOpenInfo:bOpen	Z
    //   2769: ifeq +24 -> 2793
    //   2772: aload 26
    //   2774: iconst_1
    //   2775: putfield 4447	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   2778: aload_3
    //   2779: getfield 4435	QQService/VipOpenInfo:iVipFlag	I
    //   2782: iconst_1
    //   2783: iand
    //   2784: ifle +9 -> 2793
    //   2787: aload 26
    //   2789: iconst_1
    //   2790: putfield 4450	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   2793: aload 26
    //   2795: aload_3
    //   2796: getfield 4441	QQService/VipOpenInfo:iVipLevel	I
    //   2799: putfield 4453	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   2802: aload_2
    //   2803: bipush 103
    //   2805: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2808: invokeinterface 4193 2 0
    //   2813: checkcast 4426	QQService/VipOpenInfo
    //   2816: astore_2
    //   2817: aload_2
    //   2818: getfield 4429	QQService/VipOpenInfo:bOpen	Z
    //   2821: ifeq +24 -> 2845
    //   2824: aload 26
    //   2826: iconst_1
    //   2827: putfield 4456	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   2830: aload_2
    //   2831: getfield 4435	QQService/VipOpenInfo:iVipFlag	I
    //   2834: iconst_1
    //   2835: iand
    //   2836: ifle +9 -> 2845
    //   2839: aload 26
    //   2841: iconst_1
    //   2842: putfield 4459	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   2845: aload 26
    //   2847: aload_2
    //   2848: getfield 4441	QQService/VipOpenInfo:iVipLevel	I
    //   2851: putfield 4462	com/tencent/mobileqq/data/Card:greenLevel	I
    //   2854: aload_0
    //   2855: aload 26
    //   2857: aload 31
    //   2859: invokespecial 4464	ajfi:b	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)Z
    //   2862: ifne +57 -> 2919
    //   2865: aload 28
    //   2867: getfield 4468	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2870: ifnull +49 -> 2919
    //   2873: aload 28
    //   2875: getfield 4468	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2878: astore_2
    //   2879: aload_2
    //   2880: ifnull +39 -> 2919
    //   2883: aload 26
    //   2885: aload_2
    //   2886: getfield 4472	QQService/PrivilegeBaseInfo:strMsg	Ljava/lang/String;
    //   2889: putfield 2354	com/tencent/mobileqq/data/Card:privilegePromptStr	Ljava/lang/String;
    //   2892: aload 26
    //   2894: aload_2
    //   2895: getfield 4474	QQService/PrivilegeBaseInfo:strJumpUrl	Ljava/lang/String;
    //   2898: putfield 2360	com/tencent/mobileqq/data/Card:privilegeJumpUrl	Ljava/lang/String;
    //   2901: aload 26
    //   2903: aload_2
    //   2904: getfield 4476	QQService/PrivilegeBaseInfo:vOpenPriv	Ljava/util/ArrayList;
    //   2907: invokevirtual 2407	com/tencent/mobileqq/data/Card:savePrivilegeOpenedInfo	(Ljava/util/List;)V
    //   2910: aload 26
    //   2912: aload_2
    //   2913: getfield 4478	QQService/PrivilegeBaseInfo:vClosePriv	Ljava/util/ArrayList;
    //   2916: invokevirtual 2410	com/tencent/mobileqq/data/Card:savePrivilegeClosedInfo	(Ljava/util/List;)V
    //   2919: aload_0
    //   2920: aload 26
    //   2922: aload 31
    //   2924: lload 19
    //   2926: lload 21
    //   2928: invokespecial 4480	ajfi:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;JJ)Z
    //   2931: pop
    //   2932: new 53	java/util/ArrayList
    //   2935: dup
    //   2936: invokespecial 54	java/util/ArrayList:<init>	()V
    //   2939: astore_2
    //   2940: aload 28
    //   2942: getfield 4483	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2945: ifnull +1010 -> 3955
    //   2948: aload 28
    //   2950: getfield 4483	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2953: invokevirtual 422	java/util/ArrayList:size	()I
    //   2956: ifle +999 -> 3955
    //   2959: iconst_0
    //   2960: istore 6
    //   2962: iload 6
    //   2964: aload 28
    //   2966: getfield 4483	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2969: invokevirtual 422	java/util/ArrayList:size	()I
    //   2972: if_icmpge +983 -> 3955
    //   2975: aload 28
    //   2977: getfield 4483	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2980: iload 6
    //   2982: invokevirtual 2485	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2985: checkcast 110	[B
    //   2988: astore_3
    //   2989: aload_3
    //   2990: ifnonnull +241 -> 3231
    //   2993: iconst_0
    //   2994: istore 7
    //   2996: iload 7
    //   2998: bipush 10
    //   3000: if_icmpgt +238 -> 3238
    //   3003: iload 6
    //   3005: iconst_1
    //   3006: iadd
    //   3007: istore 6
    //   3009: goto -47 -> 2962
    //   3012: aload 26
    //   3014: iconst_0
    //   3015: putfield 4073	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   3018: aload 26
    //   3020: aconst_null
    //   3021: putfield 4077	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   3024: aload 26
    //   3026: aconst_null
    //   3027: putfield 4086	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   3030: goto -2049 -> 981
    //   3033: invokestatic 1051	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3036: ifeq -1977 -> 1059
    //   3039: ldc_w 4088
    //   3042: iconst_4
    //   3043: ldc_w 4485
    //   3046: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3049: goto -1990 -> 1059
    //   3052: aload 26
    //   3054: iconst_0
    //   3055: putfield 1471	com/tencent/mobileqq/data/Card:bVoted	B
    //   3058: goto -1890 -> 1168
    //   3061: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3064: ifeq -1810 -> 1254
    //   3067: ldc 97
    //   3069: iconst_2
    //   3070: ldc_w 4487
    //   3073: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3076: goto -1822 -> 1254
    //   3079: aload_2
    //   3080: invokevirtual 4152	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3083: sipush 1001
    //   3086: if_icmpeq +13 -> 3099
    //   3089: aload_2
    //   3090: invokevirtual 4152	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3093: sipush 1002
    //   3096: if_icmpne -1620 -> 1476
    //   3099: aload 4
    //   3101: aload_2
    //   3102: invokevirtual 2711	atmp:a	(Latmo;)Z
    //   3105: pop
    //   3106: goto -1630 -> 1476
    //   3109: iconst_1
    //   3110: istore 25
    //   3112: goto -1616 -> 1496
    //   3115: iconst_1
    //   3116: istore 25
    //   3118: goto -1598 -> 1520
    //   3121: iconst_1
    //   3122: istore 25
    //   3124: goto -1584 -> 1540
    //   3127: iconst_1
    //   3128: istore 25
    //   3130: goto -1566 -> 1564
    //   3133: astore_2
    //   3134: ldc 97
    //   3136: iconst_1
    //   3137: ldc_w 4489
    //   3140: aload_2
    //   3141: invokestatic 4491	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3144: goto -1369 -> 1775
    //   3147: aload 26
    //   3149: iconst_0
    //   3150: putfield 4209	com/tencent/mobileqq/data/Card:enlargeQzonePic	I
    //   3153: goto -1378 -> 1775
    //   3156: iconst_0
    //   3157: istore 25
    //   3159: goto -1349 -> 1810
    //   3162: astore_2
    //   3163: ldc 97
    //   3165: iconst_1
    //   3166: ldc_w 4493
    //   3169: aload_2
    //   3170: invokestatic 4491	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3173: aload 26
    //   3175: iconst_0
    //   3176: putfield 4214	com/tencent/mobileqq/data/Card:showPublishButton	Z
    //   3179: goto -1362 -> 1817
    //   3182: aload 26
    //   3184: iconst_0
    //   3185: putfield 4214	com/tencent/mobileqq/data/Card:showPublishButton	Z
    //   3188: goto -1371 -> 1817
    //   3191: aload_2
    //   3192: ldc_w 2213
    //   3195: ldc_w 4495
    //   3198: invokevirtual 2216	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3201: pop
    //   3202: aload_0
    //   3203: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3206: invokevirtual 519	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3209: invokestatic 2221	awrn:a	(Landroid/content/Context;)Lawrn;
    //   3212: aload 29
    //   3214: ldc_w 4497
    //   3217: iconst_0
    //   3218: lconst_0
    //   3219: lconst_0
    //   3220: aconst_null
    //   3221: ldc_w 327
    //   3224: iconst_0
    //   3225: invokevirtual 2226	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   3228: goto -878 -> 2350
    //   3231: aload_3
    //   3232: arraylength
    //   3233: istore 7
    //   3235: goto -239 -> 2996
    //   3238: aload_3
    //   3239: iconst_1
    //   3240: invokestatic 4502	bakz:a	([BI)J
    //   3243: l2i
    //   3244: istore 8
    //   3246: aload_3
    //   3247: iconst_5
    //   3248: invokestatic 4502	bakz:a	([BI)J
    //   3251: l2i
    //   3252: istore 9
    //   3254: iload 8
    //   3256: ifle -253 -> 3003
    //   3259: iload 8
    //   3261: bipush 9
    //   3263: iadd
    //   3264: iload 7
    //   3266: if_icmpge -263 -> 3003
    //   3269: iload 8
    //   3271: newarray byte
    //   3273: astore 4
    //   3275: aload 4
    //   3277: iconst_0
    //   3278: aload_3
    //   3279: bipush 9
    //   3281: iload 8
    //   3283: invokestatic 4505	bakz:a	([BI[BII)V
    //   3286: new 4507	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   3289: dup
    //   3290: invokespecial 4508	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   3293: astore_3
    //   3294: aload_3
    //   3295: aload 4
    //   3297: invokevirtual 4509	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3300: pop
    //   3301: aload_3
    //   3302: getfield 4511	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3305: invokevirtual 1116	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3308: istore 7
    //   3310: new 4513	atxm
    //   3313: dup
    //   3314: invokespecial 4514	atxm:<init>	()V
    //   3317: astore 4
    //   3319: iload 7
    //   3321: ifne +575 -> 3896
    //   3324: aload 4
    //   3326: aload_3
    //   3327: getfield 4518	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   3330: getfield 4522	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3333: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3336: putfield 4523	atxm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3339: aload 4
    //   3341: aload_3
    //   3342: getfield 4518	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   3345: getfield 4526	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3348: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3351: putfield 4527	atxm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3354: aload 4
    //   3356: aload_3
    //   3357: getfield 4530	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3360: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3363: putfield 4531	atxm:jdField_a_of_type_Int	I
    //   3366: new 53	java/util/ArrayList
    //   3369: dup
    //   3370: invokespecial 54	java/util/ArrayList:<init>	()V
    //   3373: astore 31
    //   3375: iconst_0
    //   3376: istore 7
    //   3378: iload 7
    //   3380: aload_3
    //   3381: getfield 4518	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   3384: getfield 4534	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3387: invokevirtual 594	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3390: if_icmpge +499 -> 3889
    //   3393: aload_3
    //   3394: getfield 4518	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   3397: getfield 4534	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3400: iload 7
    //   3402: invokevirtual 597	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3405: checkcast 4536	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   3408: astore 32
    //   3410: new 4538	atxn
    //   3413: dup
    //   3414: invokespecial 4539	atxn:<init>	()V
    //   3417: astore 33
    //   3419: aload 33
    //   3421: aload 32
    //   3423: getfield 4542	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3426: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3429: putfield 4543	atxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3432: aload 33
    //   3434: aload 32
    //   3436: getfield 4546	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3439: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3442: putfield 4547	atxn:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3445: aload 33
    //   3447: aload 32
    //   3449: getfield 4550	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3452: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3455: putfield 4551	atxn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3458: aload 33
    //   3460: aload 32
    //   3462: getfield 4554	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3465: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3468: putfield 4555	atxn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3471: aload 33
    //   3473: aload 32
    //   3475: getfield 4557	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3478: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3481: putfield 4559	atxn:e	Ljava/lang/String;
    //   3484: aload 33
    //   3486: aload 32
    //   3488: getfield 4562	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3491: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3494: putfield 4564	atxn:f	Ljava/lang/String;
    //   3497: aload 33
    //   3499: aload 32
    //   3501: getfield 4567	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3504: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3507: putfield 4568	atxn:jdField_a_of_type_Long	J
    //   3510: aload 33
    //   3512: aload 4
    //   3514: getfield 4531	atxm:jdField_a_of_type_Int	I
    //   3517: putfield 4569	atxn:jdField_a_of_type_Int	I
    //   3520: iload 6
    //   3522: ifne +14 -> 3536
    //   3525: iload 7
    //   3527: ifne +264 -> 3791
    //   3530: aload 33
    //   3532: iconst_0
    //   3533: putfield 4570	atxn:jdField_b_of_type_Int	I
    //   3536: aload 32
    //   3538: getfield 4573	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3541: invokevirtual 594	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3544: ifle +284 -> 3828
    //   3547: new 53	java/util/ArrayList
    //   3550: dup
    //   3551: invokespecial 54	java/util/ArrayList:<init>	()V
    //   3554: astore 34
    //   3556: iconst_0
    //   3557: istore 8
    //   3559: iload 8
    //   3561: aload 32
    //   3563: getfield 4573	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3566: invokevirtual 594	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3569: if_icmpge +252 -> 3821
    //   3572: aload 32
    //   3574: getfield 4573	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3577: iload 8
    //   3579: invokevirtual 597	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3582: checkcast 4575	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   3585: astore 35
    //   3587: new 4577	atxl
    //   3590: dup
    //   3591: invokespecial 4578	atxl:<init>	()V
    //   3594: astore 36
    //   3596: aload 36
    //   3598: aload 35
    //   3600: getfield 4581	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3603: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3606: invokevirtual 2351	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3609: putfield 4582	atxl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3612: aload 36
    //   3614: aload 35
    //   3616: getfield 4585	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3619: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3622: i2l
    //   3623: putfield 4586	atxl:jdField_a_of_type_Long	J
    //   3626: aload 36
    //   3628: aload 35
    //   3630: getfield 4589	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3633: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3636: i2l
    //   3637: putfield 4590	atxl:jdField_b_of_type_Long	J
    //   3640: new 4592	atxj
    //   3643: dup
    //   3644: invokespecial 4593	atxj:<init>	()V
    //   3647: astore 37
    //   3649: aload 37
    //   3651: aload 35
    //   3653: getfield 4597	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3656: getfield 4602	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3659: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3662: i2l
    //   3663: putfield 4603	atxj:jdField_a_of_type_Long	J
    //   3666: aload 37
    //   3668: aload 35
    //   3670: getfield 4597	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3673: getfield 4606	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3676: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3679: i2l
    //   3680: putfield 4607	atxj:jdField_b_of_type_Long	J
    //   3683: aload 37
    //   3685: aload 35
    //   3687: getfield 4597	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3690: getfield 4610	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3693: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3696: i2l
    //   3697: putfield 4612	atxj:c	J
    //   3700: aload 36
    //   3702: aload 37
    //   3704: putfield 4615	atxl:jdField_b_of_type_Atxj	Latxj;
    //   3707: new 4592	atxj
    //   3710: dup
    //   3711: invokespecial 4593	atxj:<init>	()V
    //   3714: astore 37
    //   3716: aload 37
    //   3718: aload 35
    //   3720: getfield 4618	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3723: getfield 4602	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3726: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3729: i2l
    //   3730: putfield 4603	atxj:jdField_a_of_type_Long	J
    //   3733: aload 37
    //   3735: aload 35
    //   3737: getfield 4618	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3740: getfield 4606	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3743: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3746: i2l
    //   3747: putfield 4607	atxj:jdField_b_of_type_Long	J
    //   3750: aload 37
    //   3752: aload 35
    //   3754: getfield 4618	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3757: getfield 4610	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3760: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3763: i2l
    //   3764: putfield 4612	atxj:c	J
    //   3767: aload 36
    //   3769: aload 37
    //   3771: putfield 4620	atxl:jdField_a_of_type_Atxj	Latxj;
    //   3774: aload 34
    //   3776: aload 36
    //   3778: invokevirtual 1418	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3781: pop
    //   3782: iload 8
    //   3784: iconst_1
    //   3785: iadd
    //   3786: istore 8
    //   3788: goto -229 -> 3559
    //   3791: aload 33
    //   3793: iconst_1
    //   3794: putfield 4570	atxn:jdField_b_of_type_Int	I
    //   3797: goto -261 -> 3536
    //   3800: astore_3
    //   3801: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3804: ifeq -801 -> 3003
    //   3807: ldc_w 1506
    //   3810: iconst_2
    //   3811: aload_3
    //   3812: invokevirtual 3882	java/lang/Exception:toString	()Ljava/lang/String;
    //   3815: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3818: goto -815 -> 3003
    //   3821: aload 33
    //   3823: aload 34
    //   3825: putfield 4621	atxn:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3828: aload 31
    //   3830: aload 33
    //   3832: invokevirtual 1418	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3835: pop
    //   3836: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3839: ifeq +4723 -> 8562
    //   3842: ldc_w 1506
    //   3845: iconst_2
    //   3846: ldc_w 4623
    //   3849: iconst_3
    //   3850: anewarray 403	java/lang/Object
    //   3853: dup
    //   3854: iconst_0
    //   3855: aload 33
    //   3857: getfield 4543	atxn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3860: aastore
    //   3861: dup
    //   3862: iconst_1
    //   3863: aload 33
    //   3865: getfield 4569	atxn:jdField_a_of_type_Int	I
    //   3868: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3871: aastore
    //   3872: dup
    //   3873: iconst_2
    //   3874: aload 33
    //   3876: getfield 4551	atxn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3879: aastore
    //   3880: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3883: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3886: goto +4676 -> 8562
    //   3889: aload 4
    //   3891: aload 31
    //   3893: putfield 4624	atxm:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3896: aload_2
    //   3897: aload 4
    //   3899: invokeinterface 1965 2 0
    //   3904: pop
    //   3905: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3908: ifeq -905 -> 3003
    //   3911: ldc_w 1506
    //   3914: iconst_2
    //   3915: ldc_w 4626
    //   3918: iconst_3
    //   3919: anewarray 403	java/lang/Object
    //   3922: dup
    //   3923: iconst_0
    //   3924: aload 4
    //   3926: getfield 4523	atxm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3929: aastore
    //   3930: dup
    //   3931: iconst_1
    //   3932: aload 4
    //   3934: getfield 4627	atxm:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3937: aastore
    //   3938: dup
    //   3939: iconst_2
    //   3940: aload 4
    //   3942: getfield 4527	atxm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3945: aastore
    //   3946: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3949: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3952: goto -949 -> 3003
    //   3955: aload 26
    //   3957: aload_2
    //   3958: invokevirtual 4630	com/tencent/mobileqq/data/Card:saveBigOrderEntrys	(Ljava/util/List;)V
    //   3961: new 599	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   3964: dup
    //   3965: invokespecial 4631	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:<init>	()V
    //   3968: astore_2
    //   3969: aload 28
    //   3971: getfield 4634	SummaryCard/RespSummaryCard:vResp0x5ebInfo	[B
    //   3974: ifnull +1104 -> 5078
    //   3977: aload_2
    //   3978: aload 28
    //   3980: getfield 4634	SummaryCard/RespSummaryCard:vResp0x5ebInfo	[B
    //   3983: invokevirtual 4635	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3986: pop
    //   3987: aload 29
    //   3989: aload_0
    //   3990: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3993: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3996: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3999: ifeq +72 -> 4071
    //   4002: aload_2
    //   4003: getfield 4638	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:int32_history_num_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4006: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4009: ifeq +62 -> 4071
    //   4012: aload_2
    //   4013: getfield 4638	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:int32_history_num_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4016: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4019: istore 6
    //   4021: aload_0
    //   4022: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   4025: invokevirtual 818	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   4028: aload_0
    //   4029: invokevirtual 4639	ajfi:getCurrentAccountUin	()Ljava/lang/String;
    //   4032: iload 6
    //   4034: invokestatic 4642	baig:E	(Landroid/content/Context;Ljava/lang/String;I)V
    //   4037: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4040: ifeq +31 -> 4071
    //   4043: ldc_w 1506
    //   4046: iconst_2
    //   4047: new 20	java/lang/StringBuilder
    //   4050: dup
    //   4051: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4054: ldc_w 4644
    //   4057: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4060: iload 6
    //   4062: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4065: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4068: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4071: aload 27
    //   4073: aload 29
    //   4075: invokevirtual 4646	ajjj:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   4078: astore_3
    //   4079: aload_2
    //   4080: getfield 4649	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4083: invokevirtual 4650	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4086: ifeq +59 -> 4145
    //   4089: aload_2
    //   4090: getfield 4649	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4093: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4096: lstore 19
    //   4098: aload 26
    //   4100: lload 19
    //   4102: putfield 4653	com/tencent/mobileqq/data/Card:namePlateOfKingGameId	J
    //   4105: aload_3
    //   4106: lload 19
    //   4108: putfield 4654	com/tencent/mobileqq/data/Friends:namePlateOfKingGameId	J
    //   4111: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4114: ifeq +31 -> 4145
    //   4117: ldc_w 1506
    //   4120: iconst_2
    //   4121: new 20	java/lang/StringBuilder
    //   4124: dup
    //   4125: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4128: ldc_w 4656
    //   4131: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4134: lload 19
    //   4136: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4139: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4142: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4145: aload_2
    //   4146: getfield 4659	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_last_login_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4149: invokevirtual 4650	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4152: ifeq +59 -> 4211
    //   4155: aload_2
    //   4156: getfield 4659	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_last_login_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4159: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4162: lstore 19
    //   4164: aload 26
    //   4166: lload 19
    //   4168: putfield 4662	com/tencent/mobileqq/data/Card:namePlateOfKingLoginTime	J
    //   4171: aload_3
    //   4172: lload 19
    //   4174: putfield 4663	com/tencent/mobileqq/data/Friends:namePlateOfKingLoginTime	J
    //   4177: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4180: ifeq +31 -> 4211
    //   4183: ldc_w 1506
    //   4186: iconst_2
    //   4187: new 20	java/lang/StringBuilder
    //   4190: dup
    //   4191: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4194: ldc_w 4665
    //   4197: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4200: lload 19
    //   4202: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4205: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4208: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4211: aload_2
    //   4212: getfield 4668	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4215: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4218: ifeq +59 -> 4277
    //   4221: aload_2
    //   4222: getfield 4668	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4225: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4228: istore 6
    //   4230: aload 26
    //   4232: iload 6
    //   4234: putfield 4671	com/tencent/mobileqq/data/Card:namePlateOfKingDan	I
    //   4237: aload_3
    //   4238: iload 6
    //   4240: putfield 4672	com/tencent/mobileqq/data/Friends:namePlateOfKingDan	I
    //   4243: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4246: ifeq +31 -> 4277
    //   4249: ldc_w 1506
    //   4252: iconst_2
    //   4253: new 20	java/lang/StringBuilder
    //   4256: dup
    //   4257: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4260: ldc_w 4674
    //   4263: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4266: iload 6
    //   4268: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4271: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4274: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4277: aload_2
    //   4278: getfield 4677	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan_display_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4281: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4284: ifeq +159 -> 4443
    //   4287: aload_2
    //   4288: getfield 4677	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan_display_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4291: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4294: istore 6
    //   4296: iload 6
    //   4298: iconst_1
    //   4299: if_icmpne +1442 -> 5741
    //   4302: iconst_1
    //   4303: istore 25
    //   4305: aload 26
    //   4307: iload 25
    //   4309: putfield 4680	com/tencent/mobileqq/data/Card:namePlateOfKingDanDisplatSwitch	Z
    //   4312: iload 6
    //   4314: iconst_1
    //   4315: if_icmpne +1432 -> 5747
    //   4318: iconst_1
    //   4319: istore 25
    //   4321: aload_3
    //   4322: iload 25
    //   4324: putfield 4681	com/tencent/mobileqq/data/Friends:namePlateOfKingDanDisplatSwitch	Z
    //   4327: aload 29
    //   4329: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4332: ifne +77 -> 4409
    //   4335: aload_0
    //   4336: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4339: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4342: aload 29
    //   4344: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4347: ifeq +62 -> 4409
    //   4350: aload_0
    //   4351: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4354: invokevirtual 519	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4357: ldc_w 4683
    //   4360: iconst_0
    //   4361: invokevirtual 651	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4364: invokeinterface 218 1 0
    //   4369: new 20	java/lang/StringBuilder
    //   4372: dup
    //   4373: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4376: ldc_w 4685
    //   4379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4382: aload_0
    //   4383: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4386: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4389: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4392: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4395: aload_3
    //   4396: getfield 4681	com/tencent/mobileqq/data/Friends:namePlateOfKingDanDisplatSwitch	Z
    //   4399: invokeinterface 718 3 0
    //   4404: invokeinterface 3655 1 0
    //   4409: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4412: ifeq +31 -> 4443
    //   4415: ldc_w 1506
    //   4418: iconst_2
    //   4419: new 20	java/lang/StringBuilder
    //   4422: dup
    //   4423: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4426: ldc_w 4687
    //   4429: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4432: iload 6
    //   4434: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4437: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4440: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4443: aload_2
    //   4444: getfield 4690	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_suspend_effect_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4447: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4450: ifeq +81 -> 4531
    //   4453: aload_2
    //   4454: getfield 4690	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_suspend_effect_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4457: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4460: istore 6
    //   4462: iload 6
    //   4464: iflt +22 -> 4486
    //   4467: aload_0
    //   4468: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4471: bipush 13
    //   4473: invokevirtual 946	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   4476: checkcast 3505	ajrm
    //   4479: aload 29
    //   4481: iload 6
    //   4483: invokevirtual 4692	ajrm:a	(Ljava/lang/String;I)V
    //   4486: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4489: ifeq +42 -> 4531
    //   4492: ldc_w 1506
    //   4495: iconst_2
    //   4496: new 20	java/lang/StringBuilder
    //   4499: dup
    //   4500: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4503: ldc_w 4694
    //   4506: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4509: aload 29
    //   4511: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4514: ldc_w 4696
    //   4517: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4520: iload 6
    //   4522: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4525: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4528: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4531: aload_2
    //   4532: getfield 4699	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_vas_face_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4535: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4538: ifeq +35 -> 4573
    //   4541: aload_2
    //   4542: getfield 4699	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_vas_face_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4545: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4548: istore 6
    //   4550: aload_0
    //   4551: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4554: sipush 235
    //   4557: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4560: checkcast 2445	baov
    //   4563: getfield 4702	baov:a	Lcom/tencent/mobileqq/vas/avatar/VasFaceManager;
    //   4566: aload 29
    //   4568: iload 6
    //   4570: invokevirtual 4706	com/tencent/mobileqq/vas/avatar/VasFaceManager:b	(Ljava/lang/String;I)V
    //   4573: aload_2
    //   4574: getfield 4709	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4577: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4580: ifeq +97 -> 4677
    //   4583: aload_2
    //   4584: getfield 4709	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4587: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4590: istore 6
    //   4592: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4595: ifeq +42 -> 4637
    //   4598: ldc_w 1506
    //   4601: iconst_2
    //   4602: new 20	java/lang/StringBuilder
    //   4605: dup
    //   4606: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4609: ldc_w 4694
    //   4612: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: aload 29
    //   4617: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4620: ldc_w 4711
    //   4623: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: iload 6
    //   4628: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4631: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4634: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4637: aload 26
    //   4639: iload 6
    //   4641: putfield 4714	com/tencent/mobileqq/data/Card:extendFriendFlag	I
    //   4644: aload_0
    //   4645: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4648: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4651: ldc_w 3645
    //   4654: invokestatic 3650	baig:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   4657: invokeinterface 218 1 0
    //   4662: ldc_w 4716
    //   4665: iload 6
    //   4667: invokeinterface 657 3 0
    //   4672: invokeinterface 3655 1 0
    //   4677: aload_2
    //   4678: getfield 4719	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_card_shown	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4681: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4684: ifeq +67 -> 4751
    //   4687: aload_2
    //   4688: getfield 4719	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_card_shown	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4691: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4694: istore 6
    //   4696: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4699: ifeq +3872 -> 8571
    //   4702: ldc_w 1506
    //   4705: iconst_2
    //   4706: new 20	java/lang/StringBuilder
    //   4709: dup
    //   4710: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4713: ldc_w 4694
    //   4716: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4719: aload 29
    //   4721: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4724: ldc_w 4721
    //   4727: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4730: iload 6
    //   4732: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4735: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4738: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4741: goto +3830 -> 8571
    //   4744: aload 26
    //   4746: iload 25
    //   4748: putfield 3221	com/tencent/mobileqq/data/Card:isShowCard	Z
    //   4751: aload_2
    //   4752: getfield 4724	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_stranger_vote_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4755: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4758: ifeq +103 -> 4861
    //   4761: aload_2
    //   4762: getfield 4724	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_stranger_vote_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4765: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4768: istore 6
    //   4770: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4773: ifeq +3809 -> 8582
    //   4776: ldc_w 1506
    //   4779: iconst_2
    //   4780: new 20	java/lang/StringBuilder
    //   4783: dup
    //   4784: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4787: ldc_w 4694
    //   4790: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4793: aload 29
    //   4795: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4798: ldc_w 4726
    //   4801: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4804: iload 6
    //   4806: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4809: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4812: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4815: goto +3767 -> 8582
    //   4818: aload 26
    //   4820: iload 25
    //   4822: putfield 4729	com/tencent/mobileqq/data/Card:strangerVoteOpen	Z
    //   4825: aload 29
    //   4827: aload_0
    //   4828: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4831: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4834: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4837: ifeq +24 -> 4861
    //   4840: aload_0
    //   4841: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4844: sipush 161
    //   4847: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4850: checkcast 2721	ascu
    //   4853: aload 26
    //   4855: getfield 4729	com/tencent/mobileqq/data/Card:strangerVoteOpen	Z
    //   4858: invokevirtual 2723	ascu:b	(Z)V
    //   4861: aload_2
    //   4862: getfield 4732	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_school_status_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4865: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4868: ifeq +64 -> 4932
    //   4871: aload_2
    //   4872: getfield 4732	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_school_status_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4875: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4878: istore 6
    //   4880: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4883: ifeq +42 -> 4925
    //   4886: ldc_w 1506
    //   4889: iconst_2
    //   4890: new 20	java/lang/StringBuilder
    //   4893: dup
    //   4894: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4897: ldc_w 4694
    //   4900: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4903: aload 29
    //   4905: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4908: ldc_w 4734
    //   4911: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4914: iload 6
    //   4916: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4919: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4922: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4925: aload 26
    //   4927: iload 6
    //   4929: putfield 4737	com/tencent/mobileqq/data/Card:newSchoolStatusFlagForGuide	I
    //   4932: aload_2
    //   4933: getfield 4740	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_flag_is_pretty_group_owner	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4936: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4939: ifeq +66 -> 5005
    //   4942: aload_2
    //   4943: getfield 4740	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_flag_is_pretty_group_owner	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4946: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4949: iconst_1
    //   4950: if_icmpne +815 -> 5765
    //   4953: iconst_1
    //   4954: istore 25
    //   4956: aload 26
    //   4958: iload 25
    //   4960: putfield 4743	com/tencent/mobileqq/data/Card:isPrettyGroupOwner	Z
    //   4963: ldc_w 4745
    //   4966: iconst_1
    //   4967: new 20	java/lang/StringBuilder
    //   4970: dup
    //   4971: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   4974: ldc_w 4694
    //   4977: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4980: aload 29
    //   4982: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4985: ldc_w 4747
    //   4988: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4991: aload 26
    //   4993: getfield 4743	com/tencent/mobileqq/data/Card:isPrettyGroupOwner	Z
    //   4996: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4999: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5002: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5005: aload_2
    //   5006: getfield 4750	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_flag_hide_pretty_group_owner_identity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5009: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   5012: ifeq +66 -> 5078
    //   5015: aload_2
    //   5016: getfield 4750	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_flag_hide_pretty_group_owner_identity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5019: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5022: iconst_1
    //   5023: if_icmpne +748 -> 5771
    //   5026: iconst_1
    //   5027: istore 25
    //   5029: aload 26
    //   5031: iload 25
    //   5033: putfield 4753	com/tencent/mobileqq/data/Card:isHidePrettyGroutIdentity	Z
    //   5036: ldc_w 4745
    //   5039: iconst_1
    //   5040: new 20	java/lang/StringBuilder
    //   5043: dup
    //   5044: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   5047: ldc_w 4694
    //   5050: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5053: aload 29
    //   5055: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5058: ldc_w 4755
    //   5061: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5064: aload 26
    //   5066: getfield 4753	com/tencent/mobileqq/data/Card:isHidePrettyGroutIdentity	Z
    //   5069: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5072: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5075: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5078: aload 26
    //   5080: getfield 4343	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   5083: ldc2_w 4338
    //   5086: land
    //   5087: lconst_0
    //   5088: lcmp
    //   5089: ifeq +709 -> 5798
    //   5092: aload 26
    //   5094: iconst_1
    //   5095: putfield 4758	com/tencent/mobileqq/data/Card:allowClick	Z
    //   5098: aload 29
    //   5100: aload_0
    //   5101: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5104: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5107: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5110: ifne +23 -> 5133
    //   5113: aload 26
    //   5115: getfield 4343	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   5118: ldc2_w 4169
    //   5121: land
    //   5122: lconst_0
    //   5123: lcmp
    //   5124: ifeq +683 -> 5807
    //   5127: aload 26
    //   5129: iconst_1
    //   5130: putfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   5133: aload 28
    //   5135: getfield 4762	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   5138: ifnull +230 -> 5368
    //   5141: aload 28
    //   5143: getfield 4762	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   5146: getfield 4767	SummaryCard/TVideoHeadInfo:iBasicFlag	I
    //   5149: iconst_1
    //   5150: if_icmpne +666 -> 5816
    //   5153: iconst_1
    //   5154: istore 25
    //   5156: aload 26
    //   5158: iload 25
    //   5160: putfield 4770	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   5163: new 4772	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody
    //   5166: dup
    //   5167: invokespecial 4773	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:<init>	()V
    //   5170: astore_2
    //   5171: aload 26
    //   5173: getfield 4770	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   5176: ifeq +27 -> 5203
    //   5179: aload 28
    //   5181: getfield 4762	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   5184: getfield 4776	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   5187: ifnull +16 -> 5203
    //   5190: aload_2
    //   5191: aload 28
    //   5193: getfield 4762	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   5196: getfield 4776	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   5199: invokevirtual 4777	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5202: pop
    //   5203: aload_2
    //   5204: getfield 4780	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5207: invokevirtual 735	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5210: ifeq +158 -> 5368
    //   5213: aload_2
    //   5214: getfield 4780	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5217: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5220: astore_2
    //   5221: aload_2
    //   5222: ifnull +146 -> 5368
    //   5225: aload_2
    //   5226: invokeinterface 741 1 0
    //   5231: ifle +137 -> 5368
    //   5234: aload_2
    //   5235: iconst_0
    //   5236: invokeinterface 743 2 0
    //   5241: checkcast 4782	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo
    //   5244: astore_2
    //   5245: aload_2
    //   5246: getfield 4785	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5249: invokevirtual 735	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5252: ifeq +116 -> 5368
    //   5255: aload_2
    //   5256: getfield 4785	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5259: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5262: astore_2
    //   5263: aload_2
    //   5264: ifnull +104 -> 5368
    //   5267: aload_2
    //   5268: invokeinterface 1104 1 0
    //   5273: astore_2
    //   5274: aload_2
    //   5275: invokeinterface 1079 1 0
    //   5280: ifeq +88 -> 5368
    //   5283: aload_2
    //   5284: invokeinterface 1083 1 0
    //   5289: checkcast 4787	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo
    //   5292: astore_3
    //   5293: aload_3
    //   5294: getfield 4788	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5297: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5300: bipush 17
    //   5302: if_icmpne -28 -> 5274
    //   5305: aload_3
    //   5306: getfield 4791	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:rpt_videoheadlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5309: invokevirtual 738	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5312: astore_2
    //   5313: aload_2
    //   5314: ifnull +54 -> 5368
    //   5317: aload_2
    //   5318: invokeinterface 1104 1 0
    //   5323: astore_2
    //   5324: aload_2
    //   5325: invokeinterface 1079 1 0
    //   5330: ifeq +38 -> 5368
    //   5333: aload_2
    //   5334: invokeinterface 1083 1 0
    //   5339: checkcast 4793	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo
    //   5342: astore_3
    //   5343: aload_3
    //   5344: getfield 4796	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:uint32_video_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5347: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5350: sipush 640
    //   5353: if_icmpne -29 -> 5324
    //   5356: aload 26
    //   5358: aload_3
    //   5359: getfield 4799	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:str_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5362: invokevirtual 776	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5365: putfield 4802	com/tencent/mobileqq/data/Card:videoHeadUrl	Ljava/lang/String;
    //   5368: aload 28
    //   5370: getfield 4806	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   5373: ifnull +457 -> 5830
    //   5376: aload 28
    //   5378: getfield 4806	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   5381: getfield 4811	SummaryCard/OlympicInfo:iTorch	I
    //   5384: ifle +446 -> 5830
    //   5387: aload 26
    //   5389: iconst_1
    //   5390: putfield 4814	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   5393: aload 28
    //   5395: getfield 4817	SummaryCard/RespSummaryCard:vRespCustomLabelInfo	[B
    //   5398: ifnull +44 -> 5442
    //   5401: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5404: ifeq +12 -> 5416
    //   5407: ldc 97
    //   5409: iconst_2
    //   5410: ldc_w 4819
    //   5413: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5416: aload 28
    //   5418: getfield 4817	SummaryCard/RespSummaryCard:vRespCustomLabelInfo	[B
    //   5421: invokestatic 4825	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel:convertFromPbBytes	([B)Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;
    //   5424: astore_2
    //   5425: aload_2
    //   5426: invokestatic 4829	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel:convertToBytes	(Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;)[B
    //   5429: astore_3
    //   5430: aload 26
    //   5432: aload_2
    //   5433: putfield 4833	com/tencent/mobileqq/data/Card:personalityLabel	Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;
    //   5436: aload 26
    //   5438: aload_3
    //   5439: putfield 4836	com/tencent/mobileqq/data/Card:vPersonalityLabelV2	[B
    //   5442: aload 28
    //   5444: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5447: ifnull +527 -> 5974
    //   5450: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5453: ifeq +45 -> 5498
    //   5456: new 20	java/lang/StringBuilder
    //   5459: dup
    //   5460: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   5463: astore_2
    //   5464: aload 28
    //   5466: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5469: aload_2
    //   5470: iconst_0
    //   5471: invokevirtual 4844	SummaryCard/TMedalWallInfo:display	(Ljava/lang/StringBuilder;I)V
    //   5474: ldc_w 1053
    //   5477: iconst_2
    //   5478: iconst_2
    //   5479: anewarray 403	java/lang/Object
    //   5482: dup
    //   5483: iconst_0
    //   5484: ldc_w 4846
    //   5487: aastore
    //   5488: dup
    //   5489: iconst_1
    //   5490: aload_2
    //   5491: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5494: aastore
    //   5495: invokestatic 791	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5498: aload 26
    //   5500: aload 28
    //   5502: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5505: getfield 1229	SummaryCard/TMedalWallInfo:iMedalCount	I
    //   5508: putfield 4847	com/tencent/mobileqq/data/Card:iMedalCount	I
    //   5511: aload 28
    //   5513: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5516: getfield 1225	SummaryCard/TMedalWallInfo:iOpenFlag	I
    //   5519: iconst_1
    //   5520: if_icmpne +319 -> 5839
    //   5523: iconst_1
    //   5524: istore 25
    //   5526: aload 26
    //   5528: iload 25
    //   5530: putfield 700	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   5533: aload 28
    //   5535: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5538: getfield 1233	SummaryCard/TMedalWallInfo:iNewCount	I
    //   5541: istore 10
    //   5543: aload 28
    //   5545: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5548: getfield 1237	SummaryCard/TMedalWallInfo:iUpgradeCount	I
    //   5551: istore 11
    //   5553: aload 28
    //   5555: getfield 4840	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5558: getfield 1241	SummaryCard/TMedalWallInfo:strPromptParams	Ljava/lang/String;
    //   5561: astore_2
    //   5562: iload 10
    //   5564: ifgt +8 -> 5572
    //   5567: iload 11
    //   5569: ifle +2970 -> 8539
    //   5572: aload_2
    //   5573: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5576: ifne +2963 -> 8539
    //   5579: aload 26
    //   5581: getfield 2679	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   5584: aload_0
    //   5585: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5588: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5591: invokestatic 4850	azzz:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   5594: ifeq +2945 -> 8539
    //   5597: iconst_0
    //   5598: istore 12
    //   5600: iconst_0
    //   5601: istore 6
    //   5603: iconst_0
    //   5604: istore 13
    //   5606: iconst_0
    //   5607: istore 7
    //   5609: aload_0
    //   5610: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5613: sipush 250
    //   5616: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5619: checkcast 1143	com/tencent/mobileqq/medalwall/MedalWallMng
    //   5622: aload_2
    //   5623: invokevirtual 4852	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   5626: astore_3
    //   5627: iload 13
    //   5629: istore 8
    //   5631: iload 12
    //   5633: istore 9
    //   5635: aload_3
    //   5636: ifnull +244 -> 5880
    //   5639: iload 13
    //   5641: istore 8
    //   5643: iload 12
    //   5645: istore 9
    //   5647: aload_3
    //   5648: invokevirtual 422	java/util/ArrayList:size	()I
    //   5651: ifle +229 -> 5880
    //   5654: aload_3
    //   5655: invokevirtual 1074	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5658: astore_3
    //   5659: iload 7
    //   5661: istore 8
    //   5663: iload 6
    //   5665: istore 9
    //   5667: aload_3
    //   5668: invokeinterface 1079 1 0
    //   5673: ifeq +207 -> 5880
    //   5676: aload_3
    //   5677: invokeinterface 1083 1 0
    //   5682: checkcast 1085	com/tencent/mobileqq/medalwall/MedalID
    //   5685: astore 4
    //   5687: aload 4
    //   5689: ifnull -30 -> 5659
    //   5692: aload 4
    //   5694: getfield 1091	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5697: iconst_1
    //   5698: if_icmpeq +14 -> 5712
    //   5701: aload 4
    //   5703: getfield 1091	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5706: sipush 255
    //   5709: if_icmpne +136 -> 5845
    //   5712: iload 7
    //   5714: istore 8
    //   5716: iload 6
    //   5718: iconst_1
    //   5719: iadd
    //   5720: istore 7
    //   5722: iload 8
    //   5724: istore 6
    //   5726: iload 7
    //   5728: istore 8
    //   5730: iload 6
    //   5732: istore 7
    //   5734: iload 8
    //   5736: istore 6
    //   5738: goto -79 -> 5659
    //   5741: iconst_0
    //   5742: istore 25
    //   5744: goto -1439 -> 4305
    //   5747: iconst_0
    //   5748: istore 25
    //   5750: goto -1429 -> 4321
    //   5753: iconst_0
    //   5754: istore 25
    //   5756: goto -1012 -> 4744
    //   5759: iconst_0
    //   5760: istore 25
    //   5762: goto -944 -> 4818
    //   5765: iconst_0
    //   5766: istore 25
    //   5768: goto -812 -> 4956
    //   5771: iconst_0
    //   5772: istore 25
    //   5774: goto -745 -> 5029
    //   5777: astore_2
    //   5778: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5781: ifeq -703 -> 5078
    //   5784: ldc_w 1506
    //   5787: iconst_2
    //   5788: aload_2
    //   5789: invokevirtual 3882	java/lang/Exception:toString	()Ljava/lang/String;
    //   5792: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5795: goto -717 -> 5078
    //   5798: aload 26
    //   5800: iconst_0
    //   5801: putfield 4758	com/tencent/mobileqq/data/Card:allowClick	Z
    //   5804: goto -706 -> 5098
    //   5807: aload 26
    //   5809: iconst_0
    //   5810: putfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   5813: goto -680 -> 5133
    //   5816: iconst_0
    //   5817: istore 25
    //   5819: goto -663 -> 5156
    //   5822: astore_3
    //   5823: aload_3
    //   5824: invokevirtual 1878	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   5827: goto -624 -> 5203
    //   5830: aload 26
    //   5832: iconst_0
    //   5833: putfield 4814	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   5836: goto -443 -> 5393
    //   5839: iconst_0
    //   5840: istore 25
    //   5842: goto -316 -> 5526
    //   5845: aload 4
    //   5847: getfield 1091	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5850: iconst_2
    //   5851: if_icmpeq +12 -> 5863
    //   5854: aload 4
    //   5856: getfield 1091	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5859: iconst_3
    //   5860: if_icmpne +2664 -> 8524
    //   5863: iload 7
    //   5865: iconst_1
    //   5866: iadd
    //   5867: istore 8
    //   5869: iload 6
    //   5871: istore 7
    //   5873: iload 8
    //   5875: istore 6
    //   5877: goto -151 -> 5726
    //   5880: iload 8
    //   5882: istore 6
    //   5884: iload 9
    //   5886: istore 7
    //   5888: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5891: ifeq +63 -> 5954
    //   5894: ldc_w 1053
    //   5897: iconst_2
    //   5898: invokestatic 399	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   5901: ldc_w 4854
    //   5904: iconst_4
    //   5905: anewarray 403	java/lang/Object
    //   5908: dup
    //   5909: iconst_0
    //   5910: iload 10
    //   5912: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5915: aastore
    //   5916: dup
    //   5917: iconst_1
    //   5918: iload 11
    //   5920: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5923: aastore
    //   5924: dup
    //   5925: iconst_2
    //   5926: iload 9
    //   5928: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5931: aastore
    //   5932: dup
    //   5933: iconst_3
    //   5934: iload 8
    //   5936: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5939: aastore
    //   5940: invokestatic 407	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5943: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5946: iload 9
    //   5948: istore 7
    //   5950: iload 8
    //   5952: istore 6
    //   5954: aload 26
    //   5956: iload 7
    //   5958: putfield 4855	com/tencent/mobileqq/data/Card:iNewCount	I
    //   5961: aload 26
    //   5963: iload 6
    //   5965: putfield 4856	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   5968: aload 26
    //   5970: aload_2
    //   5971: putfield 4857	com/tencent/mobileqq/data/Card:strPromptParams	Ljava/lang/String;
    //   5974: aload 27
    //   5976: aload 26
    //   5978: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5981: pop
    //   5982: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5985: ifeq +94 -> 6079
    //   5988: new 20	java/lang/StringBuilder
    //   5991: dup
    //   5992: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   5995: astore_2
    //   5996: aload_2
    //   5997: ldc_w 4359
    //   6000: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6003: aload 26
    //   6005: getfield 4351	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   6008: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6011: ldc_w 4859
    //   6014: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6017: aload 26
    //   6019: getfield 4357	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   6022: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6025: ldc_w 4861
    //   6028: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6031: aload 26
    //   6033: getfield 4758	com/tencent/mobileqq/data/Card:allowClick	Z
    //   6036: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6039: ldc_w 4863
    //   6042: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6045: aload 26
    //   6047: getfield 624	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   6050: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6053: ldc_w 4865
    //   6056: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6059: aload 26
    //   6061: getfield 4109	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   6064: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6067: pop
    //   6068: ldc_w 1506
    //   6071: iconst_2
    //   6072: aload_2
    //   6073: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6076: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6079: aload 27
    //   6081: aload 29
    //   6083: invokevirtual 4868	ajjj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   6086: astore_2
    //   6087: aload_2
    //   6088: ifnonnull +2433 -> 8521
    //   6091: new 4870	com/tencent/mobileqq/data/ExtensionInfo
    //   6094: dup
    //   6095: invokespecial 4871	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   6098: astore_2
    //   6099: aload_2
    //   6100: aload 29
    //   6102: putfield 4872	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   6105: aload_2
    //   6106: aload 28
    //   6108: getfield 4875	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   6111: putfield 4878	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   6114: aload_2
    //   6115: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   6118: putfield 4880	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   6121: aload_0
    //   6122: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6125: sipush 153
    //   6128: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6131: checkcast 3326	aifg
    //   6134: astore_3
    //   6135: aload 28
    //   6137: getfield 4884	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   6140: ifnull +1901 -> 8041
    //   6143: aload_3
    //   6144: aload 29
    //   6146: invokevirtual 3329	aifg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   6149: astore 4
    //   6151: aload 4
    //   6153: aload 28
    //   6155: getfield 4884	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   6158: getfield 4889	SummaryCard/QQApolloInfo:uVipFlag	J
    //   6161: l2i
    //   6162: putfield 3525	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   6165: aload 4
    //   6167: aload 28
    //   6169: getfield 4884	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   6172: getfield 4892	SummaryCard/QQApolloInfo:uVipLevel	J
    //   6175: l2i
    //   6176: putfield 3532	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   6179: aload 4
    //   6181: aload 28
    //   6183: getfield 4884	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   6186: getfield 4895	SummaryCard/QQApolloInfo:uUserFlag	J
    //   6189: l2i
    //   6190: putfield 3537	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   6193: aload 4
    //   6195: aload 28
    //   6197: getfield 4884	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   6200: getfield 4898	SummaryCard/QQApolloInfo:uTimestamp	J
    //   6203: putfield 3549	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   6206: aload_3
    //   6207: aload 4
    //   6209: invokevirtual 3789	aifg:a	(Lcom/tencent/mobileqq/data/ApolloBaseInfo;)V
    //   6212: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6215: ifeq +100 -> 6315
    //   6218: ldc 97
    //   6220: iconst_2
    //   6221: new 20	java/lang/StringBuilder
    //   6224: dup
    //   6225: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   6228: ldc_w 4900
    //   6231: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6234: aload 29
    //   6236: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6239: ldc_w 4902
    //   6242: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6245: aload 4
    //   6247: getfield 3525	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   6250: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6253: ldc_w 4904
    //   6256: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6259: aload 4
    //   6261: getfield 3532	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   6264: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6267: ldc_w 4906
    //   6270: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6273: aload 4
    //   6275: getfield 3537	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   6278: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6281: ldc_w 4908
    //   6284: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6287: aload 4
    //   6289: getfield 3549	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   6292: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6295: ldc_w 4910
    //   6298: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6301: aload 4
    //   6303: getfield 3798	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   6306: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6309: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6312: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6315: aload 4
    //   6317: getfield 3549	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   6320: aload 4
    //   6322: getfield 3798	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   6325: lcmp
    //   6326: ifeq +91 -> 6417
    //   6329: aload_0
    //   6330: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6333: bipush 71
    //   6335: invokevirtual 946	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   6338: checkcast 3539	baot
    //   6341: astore_3
    //   6342: aload_3
    //   6343: ifnull +74 -> 6417
    //   6346: new 53	java/util/ArrayList
    //   6349: dup
    //   6350: iconst_1
    //   6351: invokespecial 2120	java/util/ArrayList:<init>	(I)V
    //   6354: astore 4
    //   6356: aload 4
    //   6358: aload 29
    //   6360: invokestatic 456	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   6363: invokestatic 576	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6366: invokevirtual 1418	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6369: pop
    //   6370: aload_3
    //   6371: aload 4
    //   6373: ldc_w 4912
    //   6376: invokevirtual 3813	baot:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   6379: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6382: ifeq +35 -> 6417
    //   6385: ldc 97
    //   6387: iconst_2
    //   6388: new 20	java/lang/StringBuilder
    //   6391: dup
    //   6392: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   6395: ldc_w 4914
    //   6398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6401: aload 29
    //   6403: iconst_0
    //   6404: iconst_4
    //   6405: invokevirtual 4202	java/lang/String:substring	(II)Ljava/lang/String;
    //   6408: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6411: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6414: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6417: aload 27
    //   6419: aload 29
    //   6421: invokevirtual 4646	ajjj:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   6424: astore 4
    //   6426: aload 4
    //   6428: aload 26
    //   6430: getfield 3086	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   6433: putfield 4917	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   6436: aload 4
    //   6438: aload 26
    //   6440: getfield 4006	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   6443: putfield 4920	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   6446: lconst_1
    //   6447: lload 17
    //   6449: land
    //   6450: lconst_0
    //   6451: lcmp
    //   6452: ifeq +1607 -> 8059
    //   6455: aload 26
    //   6457: getfield 4250	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   6460: astore_3
    //   6461: aload 4
    //   6463: aload_3
    //   6464: putfield 4923	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   6467: aload 26
    //   6469: getfield 3112	com/tencent/mobileqq/data/Card:shGender	S
    //   6472: ifne +1596 -> 8068
    //   6475: iconst_1
    //   6476: istore 5
    //   6478: aload 4
    //   6480: iload 5
    //   6482: putfield 4926	com/tencent/mobileqq/data/Friends:gender	B
    //   6485: aload 4
    //   6487: aload 26
    //   6489: getfield 3124	com/tencent/mobileqq/data/Card:age	B
    //   6492: putfield 4928	com/tencent/mobileqq/data/Friends:age	I
    //   6495: ldc2_w 4261
    //   6498: lload 17
    //   6500: land
    //   6501: lconst_0
    //   6502: lcmp
    //   6503: ifeq +99 -> 6602
    //   6506: aload_2
    //   6507: getfield 4931	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   6510: aload 28
    //   6512: getfield 4269	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   6515: lcmp
    //   6516: ifeq +86 -> 6602
    //   6519: aload_2
    //   6520: aload 28
    //   6522: getfield 4265	SummaryCard/RespSummaryCard:vRichSign	[B
    //   6525: aload 28
    //   6527: getfield 4269	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   6530: invokevirtual 4935	com/tencent/mobileqq/data/ExtensionInfo:setRichBuffer	([BJ)V
    //   6533: aload_0
    //   6534: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6537: iconst_1
    //   6538: invokevirtual 946	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   6541: checkcast 4937	com/tencent/mobileqq/app/FriendListHandler
    //   6544: iconst_1
    //   6545: anewarray 254	java/lang/String
    //   6548: dup
    //   6549: iconst_0
    //   6550: aload 29
    //   6552: aastore
    //   6553: invokevirtual 4940	com/tencent/mobileqq/app/FriendListHandler:b	([Ljava/lang/String;)V
    //   6556: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6559: ifeq +43 -> 6602
    //   6562: ldc 97
    //   6564: iconst_2
    //   6565: new 20	java/lang/StringBuilder
    //   6568: dup
    //   6569: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   6572: ldc_w 4942
    //   6575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6578: aload 29
    //   6580: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6583: ldc_w 4944
    //   6586: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6589: aload_2
    //   6590: getfield 4947	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   6593: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6596: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6599: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6602: aload 27
    //   6604: aload_2
    //   6605: invokevirtual 4950	ajjj:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   6608: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6611: ifeq +43 -> 6654
    //   6614: ldc 97
    //   6616: iconst_2
    //   6617: new 20	java/lang/StringBuilder
    //   6620: dup
    //   6621: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   6624: ldc_w 4952
    //   6627: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6630: aload 29
    //   6632: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6635: ldc_w 4954
    //   6638: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6641: aload_2
    //   6642: getfield 4878	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   6645: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6648: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6651: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6654: aload 28
    //   6656: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6659: ifnull +242 -> 6901
    //   6662: aload 4
    //   6664: aload 28
    //   6666: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6669: getstatic 4960	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   6672: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6675: aload 4
    //   6677: getfield 4965	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   6680: invokestatic 4968	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6683: putfield 4965	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   6686: aload 4
    //   6688: aload 28
    //   6690: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6693: getstatic 4971	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   6696: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6699: aload 4
    //   6701: getfield 4974	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   6704: invokestatic 4968	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6707: putfield 4974	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   6710: aload 4
    //   6712: aload 28
    //   6714: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6717: getstatic 4977	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   6720: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6723: aload 4
    //   6725: getfield 4980	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   6728: invokestatic 4968	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6731: putfield 4980	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   6734: aload 4
    //   6736: aload 28
    //   6738: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6741: getstatic 4983	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   6744: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6747: aload 4
    //   6749: getfield 4986	com/tencent/mobileqq/data/Friends:bigClubInfo	I
    //   6752: invokestatic 4968	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6755: putfield 4986	com/tencent/mobileqq/data/Friends:bigClubInfo	I
    //   6758: aload 4
    //   6760: aload 28
    //   6762: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6765: getstatic 4989	QQService/EVIPSPEC:E_SP_QQVIDEO_HOLLYWOOD	LQQService/EVIPSPEC;
    //   6768: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6771: aload 4
    //   6773: getfield 4992	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   6776: invokestatic 4968	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6779: putfield 4992	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   6782: aload 28
    //   6784: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6787: ifnull +114 -> 6901
    //   6790: aload 28
    //   6792: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6795: getfield 4995	QQService/VipBaseInfo:mOpenInfo	Ljava/util/Map;
    //   6798: ifnull +103 -> 6901
    //   6801: aload 28
    //   6803: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6806: getfield 4995	QQService/VipBaseInfo:mOpenInfo	Ljava/util/Map;
    //   6809: getstatic 4977	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   6812: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6815: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6818: invokeinterface 4193 2 0
    //   6823: checkcast 4426	QQService/VipOpenInfo
    //   6826: astore_2
    //   6827: aload_2
    //   6828: ifnull +23 -> 6851
    //   6831: aload 4
    //   6833: aload_2
    //   6834: getfield 4998	QQService/VipOpenInfo:lNameplateId	J
    //   6837: l2i
    //   6838: putfield 5001	com/tencent/mobileqq/data/Friends:superVipTemplateId	I
    //   6841: aload 4
    //   6843: aload_2
    //   6844: getfield 4998	QQService/VipOpenInfo:lNameplateId	J
    //   6847: l2i
    //   6848: putfield 5004	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   6851: aload 28
    //   6853: getfield 4242	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6856: getfield 4995	QQService/VipBaseInfo:mOpenInfo	Ljava/util/Map;
    //   6859: getstatic 4983	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   6862: invokevirtual 4962	QQService/EVIPSPEC:value	()I
    //   6865: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6868: invokeinterface 4193 2 0
    //   6873: checkcast 4426	QQService/VipOpenInfo
    //   6876: astore_2
    //   6877: aload_2
    //   6878: ifnull +23 -> 6901
    //   6881: aload 4
    //   6883: aload_2
    //   6884: getfield 4998	QQService/VipOpenInfo:lNameplateId	J
    //   6887: l2i
    //   6888: putfield 5001	com/tencent/mobileqq/data/Friends:superVipTemplateId	I
    //   6891: aload 4
    //   6893: aload_2
    //   6894: getfield 4998	QQService/VipOpenInfo:lNameplateId	J
    //   6897: l2i
    //   6898: putfield 5004	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   6901: ldc2_w 4338
    //   6904: lload 17
    //   6906: land
    //   6907: lconst_0
    //   6908: lcmp
    //   6909: ifeq +78 -> 6987
    //   6912: aload 26
    //   6914: getfield 4343	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   6917: lconst_1
    //   6918: land
    //   6919: lconst_0
    //   6920: lcmp
    //   6921: ifeq +1168 -> 8089
    //   6924: aload 4
    //   6926: aload 4
    //   6928: getfield 5007	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   6931: iconst_1
    //   6932: ior
    //   6933: i2b
    //   6934: putfield 5007	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   6937: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6940: ifeq +47 -> 6987
    //   6943: ldc 97
    //   6945: iconst_2
    //   6946: new 20	java/lang/StringBuilder
    //   6949: dup
    //   6950: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   6953: ldc_w 5009
    //   6956: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6959: aload 4
    //   6961: getfield 5010	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   6964: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6967: ldc_w 5012
    //   6970: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6973: aload 4
    //   6975: getfield 5007	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   6978: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6981: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6984: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6987: aload 27
    //   6989: aload 4
    //   6991: invokevirtual 3721	ajjj:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   6994: aload_0
    //   6995: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6998: bipush 11
    //   7000: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7003: checkcast 5014	aroh
    //   7006: astore_2
    //   7007: aload_2
    //   7008: ifnull +23 -> 7031
    //   7011: aload_2
    //   7012: aload 4
    //   7014: getfield 5010	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   7017: invokeinterface 5017 2 0
    //   7022: ifnull +9 -> 7031
    //   7025: aload_2
    //   7026: invokeinterface 5019 1 0
    //   7031: aload_1
    //   7032: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   7035: ldc_w 1530
    //   7038: lconst_0
    //   7039: invokevirtual 2546	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   7042: lstore 17
    //   7044: lload 17
    //   7046: lconst_0
    //   7047: lcmp
    //   7048: ifle +148 -> 7196
    //   7051: iload 14
    //   7053: iconst_2
    //   7054: if_icmpeq +16 -> 7070
    //   7057: iload 14
    //   7059: iconst_5
    //   7060: if_icmpeq +10 -> 7070
    //   7063: iload 14
    //   7065: bipush 7
    //   7067: if_icmpne +1065 -> 8132
    //   7070: aload 30
    //   7072: lload 17
    //   7074: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7077: invokevirtual 5022	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   7080: astore_1
    //   7081: aload_1
    //   7082: ifnull +114 -> 7196
    //   7085: aload_1
    //   7086: getfield 5027	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   7089: ifnull +1017 -> 8106
    //   7092: aload_1
    //   7093: getfield 5027	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   7096: aload 28
    //   7098: getfield 4012	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   7101: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7104: ifne +18 -> 7122
    //   7107: aload_1
    //   7108: aload 28
    //   7110: getfield 4012	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   7113: putfield 5027	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   7116: aload 30
    //   7118: aload_1
    //   7119: invokevirtual 5030	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   7122: aload 28
    //   7124: getfield 4018	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   7127: invokevirtual 5033	java/lang/String:getBytes	()[B
    //   7130: invokestatic 5036	bami:a	([B)Ljava/lang/String;
    //   7133: astore_2
    //   7134: aload_2
    //   7135: astore_1
    //   7136: aload_2
    //   7137: ifnonnull +9 -> 7146
    //   7140: aload 28
    //   7142: getfield 4018	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   7145: astore_1
    //   7146: aload_0
    //   7147: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7150: bipush 52
    //   7152: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7155: checkcast 3932	com/tencent/mobileqq/app/TroopManager
    //   7158: lload 17
    //   7160: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7163: aload 28
    //   7165: getfield 3973	SummaryCard/RespSummaryCard:lUIN	J
    //   7168: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7171: aload_1
    //   7172: bipush 156
    //   7174: aload 28
    //   7176: getfield 3952	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   7179: aconst_null
    //   7180: bipush 156
    //   7182: bipush 156
    //   7184: bipush 156
    //   7186: ldc2_w 5037
    //   7189: ldc2_w 5037
    //   7192: invokevirtual 5041	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   7195: pop
    //   7196: aload 28
    //   7198: getfield 5045	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   7201: ifnull +42 -> 7243
    //   7204: aload 26
    //   7206: aload 28
    //   7208: getfield 5045	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   7211: getfield 5050	SummaryCard/AddFrdSrcInfo:strSrcName	Ljava/lang/String;
    //   7214: putfield 5053	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   7217: aload 26
    //   7219: aload 28
    //   7221: getfield 5045	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   7224: getfield 5056	SummaryCard/AddFrdSrcInfo:uSrcId	J
    //   7227: putfield 5059	com/tencent/mobileqq/data/Card:addSrcId	J
    //   7230: aload 26
    //   7232: aload 28
    //   7234: getfield 5045	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   7237: getfield 5062	SummaryCard/AddFrdSrcInfo:uSubSrcId	J
    //   7240: putfield 5065	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   7243: aload 28
    //   7245: getfield 5069	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   7248: ifnull +16 -> 7264
    //   7251: aload 26
    //   7253: aload 28
    //   7255: getfield 5069	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   7258: getfield 5072	SummaryCard/BindPhoneInfo:strName	Ljava/lang/String;
    //   7261: putfield 5075	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   7264: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7267: ifeq +76 -> 7343
    //   7270: ldc_w 5077
    //   7273: iconst_2
    //   7274: new 20	java/lang/StringBuilder
    //   7277: dup
    //   7278: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   7281: ldc_w 5079
    //   7284: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7287: aload 26
    //   7289: getfield 5053	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   7292: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7295: ldc_w 5081
    //   7298: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7301: aload 26
    //   7303: getfield 5059	com/tencent/mobileqq/data/Card:addSrcId	J
    //   7306: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7309: ldc_w 5083
    //   7312: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7315: aload 26
    //   7317: getfield 5065	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   7320: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7323: ldc_w 5085
    //   7326: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7329: aload 26
    //   7331: getfield 5075	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   7334: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7337: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7340: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7343: aload 28
    //   7345: getfield 5088	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   7348: ifnull +88 -> 7436
    //   7351: aload 26
    //   7353: aload 28
    //   7355: getfield 5088	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   7358: putfield 5091	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   7361: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7364: ifeq +72 -> 7436
    //   7367: new 5093	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   7370: dup
    //   7371: invokespecial 5094	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   7374: astore_2
    //   7375: new 5096	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   7378: dup
    //   7379: invokespecial 5097	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   7382: astore_1
    //   7383: aload 26
    //   7385: getfield 5091	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   7388: ifnull +872 -> 8260
    //   7391: aload_2
    //   7392: aload 26
    //   7394: getfield 5091	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   7397: invokevirtual 5098	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7400: pop
    //   7401: aload_1
    //   7402: aload_2
    //   7403: invokestatic 5103	alox:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   7406: ldc_w 5077
    //   7409: iconst_2
    //   7410: new 20	java/lang/StringBuilder
    //   7413: dup
    //   7414: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   7417: ldc_w 5105
    //   7420: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7423: aload_1
    //   7424: invokevirtual 5106	com/tencent/mobileqq/businessCard/data/BusinessCard:toString	()Ljava/lang/String;
    //   7427: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7430: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7433: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7436: aload 28
    //   7438: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7441: ifnull +288 -> 7729
    //   7444: aload 26
    //   7446: aload 28
    //   7448: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7451: getfield 5115	SummaryCard/DateCard:bConstellation	B
    //   7454: putfield 3129	com/tencent/mobileqq/data/Card:constellation	I
    //   7457: aload 26
    //   7459: aload 28
    //   7461: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7464: getfield 5116	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   7467: putfield 3140	com/tencent/mobileqq/data/Card:strCompany	Ljava/lang/String;
    //   7470: aload 26
    //   7472: aload 28
    //   7474: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7477: getfield 5119	SummaryCard/DateCard:uProfession	J
    //   7480: l2i
    //   7481: putfield 3135	com/tencent/mobileqq/data/Card:iProfession	I
    //   7484: aload 26
    //   7486: aload 28
    //   7488: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7491: getfield 5120	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   7494: putfield 3145	com/tencent/mobileqq/data/Card:strSchool	Ljava/lang/String;
    //   7497: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7500: ifeq +34 -> 7534
    //   7503: ldc_w 1506
    //   7506: iconst_2
    //   7507: new 20	java/lang/StringBuilder
    //   7510: dup
    //   7511: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   7514: ldc_w 5122
    //   7517: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7520: aload 26
    //   7522: getfield 3145	com/tencent/mobileqq/data/Card:strSchool	Ljava/lang/String;
    //   7525: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7528: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7531: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7534: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7537: ifeq +49 -> 7586
    //   7540: ldc_w 3982
    //   7543: aload 29
    //   7545: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7548: ifeq +38 -> 7586
    //   7551: ldc 97
    //   7553: iconst_2
    //   7554: ldc_w 5124
    //   7557: iconst_2
    //   7558: anewarray 403	java/lang/Object
    //   7561: dup
    //   7562: iconst_0
    //   7563: aload 29
    //   7565: aastore
    //   7566: dup
    //   7567: iconst_1
    //   7568: aload 28
    //   7570: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7573: getfield 5115	SummaryCard/DateCard:bConstellation	B
    //   7576: invokestatic 2250	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   7579: aastore
    //   7580: invokestatic 1982	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7583: invokestatic 765	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   7586: aload 28
    //   7588: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7591: getfield 5127	SummaryCard/DateCard:uHomeCountry	J
    //   7594: invokestatic 3367	ajfw:a	(J)Ljava/lang/String;
    //   7597: astore_1
    //   7598: aload 28
    //   7600: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7603: getfield 5130	SummaryCard/DateCard:uHomeProvince	J
    //   7606: invokestatic 3367	ajfw:a	(J)Ljava/lang/String;
    //   7609: astore_2
    //   7610: aload 28
    //   7612: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7615: getfield 5133	SummaryCard/DateCard:uHomeCity	J
    //   7618: invokestatic 3367	ajfw:a	(J)Ljava/lang/String;
    //   7621: astore_3
    //   7622: aload 28
    //   7624: getfield 5110	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7627: getfield 5136	SummaryCard/DateCard:uHomeZone	J
    //   7630: invokestatic 3367	ajfw:a	(J)Ljava/lang/String;
    //   7633: astore 4
    //   7635: new 20	java/lang/StringBuilder
    //   7638: dup
    //   7639: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   7642: astore 29
    //   7644: aload 29
    //   7646: aload_1
    //   7647: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7650: ldc_w 3162
    //   7653: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7656: pop
    //   7657: aload 29
    //   7659: aload_2
    //   7660: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7663: ldc_w 3162
    //   7666: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7669: pop
    //   7670: aload 29
    //   7672: aload_3
    //   7673: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7676: ldc_w 3162
    //   7679: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7682: pop
    //   7683: aload 29
    //   7685: aload 4
    //   7687: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7690: pop
    //   7691: aload 26
    //   7693: aload 29
    //   7695: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7698: putfield 3196	com/tencent/mobileqq/data/Card:strHometownCodes	Ljava/lang/String;
    //   7701: aload 26
    //   7703: getfield 3196	com/tencent/mobileqq/data/Card:strHometownCodes	Ljava/lang/String;
    //   7706: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7709: ifne +20 -> 7729
    //   7712: aload_0
    //   7713: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7716: bipush 59
    //   7718: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7721: checkcast 3365	ajfw
    //   7724: aload 26
    //   7726: invokevirtual 3820	ajfw:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   7729: aload 28
    //   7731: getfield 5139	SummaryCard/RespSummaryCard:vExtendCard	[B
    //   7734: ifnull +249 -> 7983
    //   7737: new 5141	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody
    //   7740: dup
    //   7741: invokespecial 5142	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:<init>	()V
    //   7744: astore_3
    //   7745: aload_3
    //   7746: aload 28
    //   7748: getfield 5139	SummaryCard/RespSummaryCard:vExtendCard	[B
    //   7751: invokevirtual 5143	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7754: pop
    //   7755: aload_3
    //   7756: getfield 5144	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7759: invokevirtual 4650	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   7762: ifeq +511 -> 8273
    //   7765: aload_3
    //   7766: getfield 5144	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7769: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7772: invokestatic 576	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7775: astore_1
    //   7776: aload_1
    //   7777: invokestatic 979	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7780: pop
    //   7781: aload_3
    //   7782: getfield 5147	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7785: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   7788: ifeq +490 -> 8278
    //   7791: aload_3
    //   7792: getfield 5147	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7795: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7798: invokevirtual 2351	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7801: astore_1
    //   7802: aload_3
    //   7803: getfield 5150	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7806: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   7809: ifeq +474 -> 8283
    //   7812: aload_3
    //   7813: getfield 5150	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7816: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7819: invokevirtual 2351	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7822: astore_2
    //   7823: aload_3
    //   7824: getfield 5153	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7827: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   7830: ifeq +458 -> 8288
    //   7833: aload_3
    //   7834: getfield 5153	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7837: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7840: istore 6
    //   7842: aload_3
    //   7843: getfield 5156	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7846: invokevirtual 4650	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   7849: ifeq +445 -> 8294
    //   7852: aload_3
    //   7853: getfield 5156	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7856: invokevirtual 205	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7859: lstore 17
    //   7861: aload_3
    //   7862: getfield 5159	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7865: invokevirtual 784	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   7868: ifeq +432 -> 8300
    //   7871: aload_3
    //   7872: getfield 5159	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7875: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7878: istore 7
    //   7880: aload 26
    //   7882: aload_1
    //   7883: putfield 5162	com/tencent/mobileqq/data/Card:declaration	Ljava/lang/String;
    //   7886: aload 26
    //   7888: iload 6
    //   7890: putfield 5165	com/tencent/mobileqq/data/Card:popularity	I
    //   7893: aload 26
    //   7895: aload_2
    //   7896: putfield 5168	com/tencent/mobileqq/data/Card:voiceUrl	Ljava/lang/String;
    //   7899: aload 26
    //   7901: lload 17
    //   7903: putfield 5171	com/tencent/mobileqq/data/Card:updateTime	J
    //   7906: aload 26
    //   7908: iload 7
    //   7910: putfield 5174	com/tencent/mobileqq/data/Card:extendFriendVoiceDuration	I
    //   7913: ldc_w 5077
    //   7916: iconst_1
    //   7917: new 20	java/lang/StringBuilder
    //   7920: dup
    //   7921: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   7924: ldc_w 5176
    //   7927: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7930: iload 6
    //   7932: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7935: ldc_w 5178
    //   7938: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7941: aload_1
    //   7942: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7945: ldc_w 5180
    //   7948: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7951: aload_2
    //   7952: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7955: ldc_w 5182
    //   7958: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7961: lload 17
    //   7963: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7966: ldc_w 5184
    //   7969: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7972: iload 7
    //   7974: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7977: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7980: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7983: aload 27
    //   7985: aload 26
    //   7987: invokevirtual 634	ajjj:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   7990: pop
    //   7991: aload_0
    //   7992: iconst_1
    //   7993: iconst_1
    //   7994: aload 26
    //   7996: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   7999: goto -7596 -> 403
    //   8002: astore_3
    //   8003: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8006: ifeq -1589 -> 6417
    //   8009: ldc 97
    //   8011: iconst_2
    //   8012: new 20	java/lang/StringBuilder
    //   8015: dup
    //   8016: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   8019: ldc_w 4914
    //   8022: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8025: aload_3
    //   8026: invokevirtual 1004	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   8029: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8032: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8035: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8038: goto -1621 -> 6417
    //   8041: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8044: ifeq -1627 -> 6417
    //   8047: ldc 97
    //   8049: iconst_2
    //   8050: ldc_w 5186
    //   8053: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8056: goto -1639 -> 6417
    //   8059: aload 4
    //   8061: getfield 4923	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   8064: astore_3
    //   8065: goto -1604 -> 6461
    //   8068: aload 26
    //   8070: getfield 3112	com/tencent/mobileqq/data/Card:shGender	S
    //   8073: iconst_1
    //   8074: if_icmpne +9 -> 8083
    //   8077: iconst_2
    //   8078: istore 5
    //   8080: goto -1602 -> 6478
    //   8083: iconst_0
    //   8084: istore 5
    //   8086: goto -1608 -> 6478
    //   8089: aload 4
    //   8091: aload 4
    //   8093: getfield 5007	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   8096: bipush 254
    //   8098: iand
    //   8099: i2b
    //   8100: putfield 5007	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   8103: goto -1166 -> 6937
    //   8106: aload 28
    //   8108: getfield 4012	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   8111: ifnull -989 -> 7122
    //   8114: aload_1
    //   8115: aload 28
    //   8117: getfield 4012	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   8120: putfield 5027	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   8123: aload 30
    //   8125: aload_1
    //   8126: invokevirtual 5030	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   8129: goto -1007 -> 7122
    //   8132: iload 14
    //   8134: iconst_4
    //   8135: if_icmpne -939 -> 7196
    //   8138: aload_0
    //   8139: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8142: bipush 53
    //   8144: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8147: checkcast 5188	ajhh
    //   8150: astore_1
    //   8151: aload_1
    //   8152: lload 17
    //   8154: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8157: aload 29
    //   8159: invokevirtual 5191	ajhh:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   8162: astore_2
    //   8163: aload_2
    //   8164: ifnull -968 -> 7196
    //   8167: aload_2
    //   8168: aload 28
    //   8170: getfield 3952	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   8173: putfield 5196	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   8176: aload 28
    //   8178: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   8181: ifnull +61 -> 8242
    //   8184: aload 28
    //   8186: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   8189: invokevirtual 4198	java/lang/String:length	()I
    //   8192: ifle +50 -> 8242
    //   8195: aload 28
    //   8197: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   8200: aload_2
    //   8201: getfield 5199	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   8204: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8207: ifne +35 -> 8242
    //   8210: aload_2
    //   8211: aload 28
    //   8213: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   8216: putfield 5199	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   8219: aload 28
    //   8221: getfield 4033	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   8224: aload 28
    //   8226: getfield 3952	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   8229: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8232: ifeq +18 -> 8250
    //   8235: aload_2
    //   8236: ldc2_w 5200
    //   8239: putfield 5204	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   8242: aload_1
    //   8243: aload_2
    //   8244: invokevirtual 5207	ajhh:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   8247: goto -1051 -> 7196
    //   8250: aload_2
    //   8251: ldc2_w 5208
    //   8254: putfield 5204	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   8257: goto -15 -> 8242
    //   8260: ldc_w 5077
    //   8263: iconst_2
    //   8264: ldc_w 5211
    //   8267: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8270: goto -834 -> 7436
    //   8273: aconst_null
    //   8274: astore_1
    //   8275: goto -499 -> 7776
    //   8278: aconst_null
    //   8279: astore_1
    //   8280: goto -478 -> 7802
    //   8283: aconst_null
    //   8284: astore_2
    //   8285: goto -462 -> 7823
    //   8288: iconst_0
    //   8289: istore 6
    //   8291: goto -449 -> 7842
    //   8294: lconst_0
    //   8295: lstore 17
    //   8297: goto -436 -> 7861
    //   8300: iconst_0
    //   8301: istore 7
    //   8303: goto -423 -> 7880
    //   8306: astore_1
    //   8307: aload_1
    //   8308: invokevirtual 1878	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   8311: goto -328 -> 7983
    //   8314: invokestatic 3991	com/tencent/qphone/base/util/QLog:isDebugVersion	()Z
    //   8317: ifne +9 -> 8326
    //   8320: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8323: ifeq +45 -> 8368
    //   8326: ldc 97
    //   8328: iconst_1
    //   8329: new 20	java/lang/StringBuilder
    //   8332: dup
    //   8333: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   8336: ldc_w 5213
    //   8339: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8342: aload_2
    //   8343: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   8346: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8349: ldc_w 5215
    //   8352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8355: aload_2
    //   8356: invokevirtual 5218	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   8359: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8362: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8365: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8368: aload_0
    //   8369: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8372: ldc_w 5220
    //   8375: ldc_w 5222
    //   8378: new 20	java/lang/StringBuilder
    //   8381: dup
    //   8382: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   8385: ldc_w 5224
    //   8388: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8391: aload_2
    //   8392: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   8395: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8398: ldc_w 5215
    //   8401: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8404: aload_2
    //   8405: invokevirtual 5218	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   8408: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8411: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8414: aconst_null
    //   8415: fconst_0
    //   8416: invokestatic 5229	bapf:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   8419: ldc_w 5220
    //   8422: new 20	java/lang/StringBuilder
    //   8425: dup
    //   8426: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   8429: ldc_w 5231
    //   8432: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8435: aload_2
    //   8436: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   8439: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8442: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8445: invokestatic 5235	bape:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   8448: aload_1
    //   8449: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   8452: ldc_w 1550
    //   8455: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   8458: iconst_1
    //   8459: if_icmpne +24 -> 8483
    //   8462: aload_0
    //   8463: bipush 51
    //   8465: iconst_0
    //   8466: aconst_null
    //   8467: aload_1
    //   8468: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   8471: ldc_w 5237
    //   8474: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   8477: invokevirtual 5240	ajfi:notifyUI	(IZLjava/lang/Object;Z)V
    //   8480: goto -8077 -> 403
    //   8483: lload 19
    //   8485: lconst_0
    //   8486: lcmp
    //   8487: ifgt +16 -> 8503
    //   8490: aload 26
    //   8492: astore_1
    //   8493: aload_0
    //   8494: iconst_1
    //   8495: iconst_0
    //   8496: aload_1
    //   8497: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   8500: goto -8097 -> 403
    //   8503: lload 19
    //   8505: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   8508: astore_1
    //   8509: goto -16 -> 8493
    //   8512: astore_2
    //   8513: goto -1107 -> 7406
    //   8516: astore 26
    //   8518: goto -8037 -> 481
    //   8521: goto -2416 -> 6105
    //   8524: iload 6
    //   8526: istore 8
    //   8528: iload 7
    //   8530: istore 6
    //   8532: iload 8
    //   8534: istore 7
    //   8536: goto -2810 -> 5726
    //   8539: iload 11
    //   8541: istore 6
    //   8543: iload 10
    //   8545: istore 7
    //   8547: goto -2593 -> 5954
    //   8550: aconst_null
    //   8551: astore 4
    //   8553: goto -8400 -> 153
    //   8556: lconst_0
    //   8557: lstore 15
    //   8559: goto -8512 -> 47
    //   8562: iload 7
    //   8564: iconst_1
    //   8565: iadd
    //   8566: istore 7
    //   8568: goto -5190 -> 3378
    //   8571: iload 6
    //   8573: ifne -2820 -> 5753
    //   8576: iconst_1
    //   8577: istore 25
    //   8579: goto -3835 -> 4744
    //   8582: iload 6
    //   8584: ifne -2825 -> 5759
    //   8587: iconst_1
    //   8588: istore 25
    //   8590: goto -3772 -> 4818
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8593	0	this	ajfi
    //   0	8593	1	paramToServiceMsg	ToServiceMsg
    //   0	8593	2	paramFromServiceMsg	FromServiceMsg
    //   0	8593	3	paramObject	Object
    //   0	8593	4	paramBundle	Bundle
    //   6476	1609	5	b1	byte
    //   65	8518	6	i	int
    //   459	8108	7	j	int
    //   3244	5289	8	k	int
    //   3252	2695	9	m	int
    //   5541	3003	10	n	int
    //   5551	2989	11	i1	int
    //   5598	46	12	i2	int
    //   5604	36	13	i3	int
    //   187	7949	14	i4	int
    //   45	8513	15	l1	long
    //   1886	6410	17	l2	long
    //   163	8341	19	l3	long
    //   199	2728	21	l4	long
    //   2250	70	23	l5	long
    //   359	8230	25	bool	boolean
    //   48	8443	26	localObject1	Object
    //   8516	1	26	localException1	Exception
    //   124	266	27	localObject2	Object
    //   471	7513	27	localException2	Exception
    //   238	7987	28	localRespSummaryCard	RespSummaryCard
    //   540	7618	29	localObject3	Object
    //   232	7892	30	localTroopManager	com.tencent.mobileqq.app.TroopManager
    //   248	3644	31	localObject4	Object
    //   3408	165	32	localui_info	com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info
    //   3417	458	33	localatxn	atxn
    //   3554	270	34	localArrayList	ArrayList
    //   3585	168	35	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   3594	183	36	localatxl	atxl
    //   3647	123	37	localatxj	atxj
    // Exception table:
    //   from	to	target	type
    //   72	95	471	java/lang/Exception
    //   1766	1775	3133	java/lang/NumberFormatException
    //   1799	1807	3162	java/lang/NumberFormatException
    //   1810	1817	3162	java/lang/NumberFormatException
    //   3294	3319	3800	java/lang/Exception
    //   3324	3375	3800	java/lang/Exception
    //   3378	3520	3800	java/lang/Exception
    //   3530	3536	3800	java/lang/Exception
    //   3536	3556	3800	java/lang/Exception
    //   3559	3782	3800	java/lang/Exception
    //   3791	3797	3800	java/lang/Exception
    //   3821	3828	3800	java/lang/Exception
    //   3828	3886	3800	java/lang/Exception
    //   3889	3896	3800	java/lang/Exception
    //   3896	3952	3800	java/lang/Exception
    //   3977	4071	5777	java/lang/Exception
    //   4071	4145	5777	java/lang/Exception
    //   4145	4211	5777	java/lang/Exception
    //   4211	4277	5777	java/lang/Exception
    //   4277	4296	5777	java/lang/Exception
    //   4305	4312	5777	java/lang/Exception
    //   4321	4409	5777	java/lang/Exception
    //   4409	4443	5777	java/lang/Exception
    //   4443	4462	5777	java/lang/Exception
    //   4467	4486	5777	java/lang/Exception
    //   4486	4531	5777	java/lang/Exception
    //   4531	4573	5777	java/lang/Exception
    //   4573	4637	5777	java/lang/Exception
    //   4637	4677	5777	java/lang/Exception
    //   4677	4741	5777	java/lang/Exception
    //   4744	4751	5777	java/lang/Exception
    //   4751	4815	5777	java/lang/Exception
    //   4818	4861	5777	java/lang/Exception
    //   4861	4925	5777	java/lang/Exception
    //   4925	4932	5777	java/lang/Exception
    //   4932	4953	5777	java/lang/Exception
    //   4956	5005	5777	java/lang/Exception
    //   5005	5026	5777	java/lang/Exception
    //   5029	5078	5777	java/lang/Exception
    //   5190	5203	5822	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6346	6417	8002	java/lang/Exception
    //   7745	7776	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7776	7802	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7802	7823	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7823	7842	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7842	7861	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7861	7880	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7880	7983	8306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7391	7406	8512	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	108	8516	java/lang/Exception
    //   111	126	8516	java/lang/Exception
    //   136	153	8516	java/lang/Exception
    //   454	461	8516	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    String str2 = (String)paramToServiceMsg.getAttribute("attachInfo");
    atmp localatmp;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_photo_wall_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_photo_wall_rsp)paramObject;
      localatmp = this.app.getEntityManagerFactory().createEntityManager();
      paramObject = (QZonePhotoWall)localatmp.a(QZonePhotoWall.class, str1);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZonePhotoWall();
        paramToServiceMsg.uin = str1;
      }
      paramToServiceMsg.updateQzonePhotoWall(str2, paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localatmp.a(paramToServiceMsg);
        localatmp.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "handleGetPhotoWall isSuc:" + bool);
      }
      notifyUI(69, bool, new Object[] { str2, paramToServiceMsg, str1 });
      return;
      localatmp.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleGetSimpleSummaryCard() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    int i;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof RespSummaryCard))) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (i != 0) {}
      try
      {
        paramFromServiceMsg = (SummaryCard.RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.iResult == 0))
        {
          i = k;
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder().append("handleGetSummaryCard() , SummaryCard.RespHead.iResult = ");
            if (paramFromServiceMsg != null) {
              break label297;
            }
            paramFromServiceMsg = "respHead is null ";
            QLog.d("Q.profilecard.SummaryCard", 2, paramFromServiceMsg);
          }
          j = i;
          l = paramToServiceMsg.extraData.getLong("targetUin");
          if (j != 0)
          {
            paramToServiceMsg = (RespSummaryCard)paramObject;
            paramFromServiceMsg = new oidb_0x5eb.UdcUinData();
            if (paramToServiceMsg.vResp0x5ebInfo == null) {}
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          for (;;)
          {
            long l;
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.vResp0x5ebInfo);
            if ((String.valueOf(l).equals(this.app.getCurrentAccountUin())) && (paramFromServiceMsg.int32_history_num_flag.has()))
            {
              i = paramFromServiceMsg.int32_history_num_flag.get();
              baig.E(this.mApp.getApplication(), getCurrentAccountUin(), i);
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.SummaryCard", 2, "handleGetSimpleSummaryCard, history_num_flag= " + i);
              }
            }
            return;
            i = 0;
            break;
            i = 0;
            continue;
            label297:
            j = paramFromServiceMsg.iResult;
            paramFromServiceMsg = Integer.valueOf(j);
          }
          paramFromServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramFromServiceMsg.toString());
          }
          j = 0;
        }
        catch (Exception paramToServiceMsg)
        {
          while (!QLog.isColorLevel()) {}
          QLog.i("Q.profilecard.SummaryCard", 2, paramToServiceMsg.toString());
        }
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "handleDelPhotoWall isSuc:" + bool + " photoid:" + paramToServiceMsg);
    }
    notifyUI(70, bool, new Object[] { paramFromServiceMsg });
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      this.app.getEntityManagerFactory(paramToServiceMsg.getUin());
      ajjj localajjj = (ajjj)this.app.getManager(51);
      paramObject = localajjj.b(paramToServiceMsg.getUin());
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      switch (localRespDelFace.stHeader.iReplyCode)
      {
      }
      for (;;)
      {
        localajjj.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        notifyUI(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        notifyUI(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        notifyUI(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    notifyUI(12, false, new Object[] { paramBundle, ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin()) });
  }
  
  /* Error */
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 12
    //   12: aload_2
    //   13: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +472 -> 488
    //   19: aload_3
    //   20: ifnull +468 -> 488
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 607
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5282
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 6
    //   64: iload 12
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +343 -> 413
    //   73: iload 5
    //   75: istore 10
    //   77: iload 5
    //   79: istore 7
    //   81: iload 14
    //   83: istore 9
    //   85: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 110	[B
    //   96: checkcast 110	[B
    //   99: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +387 -> 494
    //   110: iload 5
    //   112: istore 10
    //   114: iload 5
    //   116: istore 7
    //   118: iload 14
    //   120: istore 9
    //   122: aload_2
    //   123: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +365 -> 494
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 10
    //   139: iload 5
    //   141: istore 7
    //   143: iload 14
    //   145: istore 9
    //   147: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +43 -> 193
    //   153: iload 5
    //   155: istore 10
    //   157: iload 5
    //   159: istore 7
    //   161: iload 14
    //   163: istore 9
    //   165: ldc_w 607
    //   168: iconst_2
    //   169: new 20	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 5284
    //   179: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 5
    //   195: istore 6
    //   197: iload 12
    //   199: istore 8
    //   201: iload 5
    //   203: ifeq +210 -> 413
    //   206: iload 5
    //   208: istore 6
    //   210: iload 12
    //   212: istore 8
    //   214: iload 5
    //   216: istore 10
    //   218: iload 5
    //   220: istore 7
    //   222: iload 14
    //   224: istore 9
    //   226: aload_2
    //   227: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +180 -> 413
    //   236: iload 5
    //   238: istore 6
    //   240: iload 12
    //   242: istore 8
    //   244: iload 5
    //   246: istore 10
    //   248: iload 5
    //   250: istore 7
    //   252: iload 14
    //   254: istore 9
    //   256: aload_2
    //   257: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   260: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   263: ifnull +150 -> 413
    //   266: iload 5
    //   268: istore 10
    //   270: iload 5
    //   272: istore 7
    //   274: iload 14
    //   276: istore 9
    //   278: aload_2
    //   279: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   288: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   291: astore_2
    //   292: iload 5
    //   294: istore 10
    //   296: iload 5
    //   298: istore 7
    //   300: iload 14
    //   302: istore 9
    //   304: aload_2
    //   305: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 15
    //   315: iload 4
    //   317: ifge +12 -> 329
    //   320: iload 4
    //   322: ldc_w 939
    //   325: iand
    //   326: i2l
    //   327: lstore 15
    //   329: iload 5
    //   331: istore 10
    //   333: iload 5
    //   335: istore 7
    //   337: iload 14
    //   339: istore 9
    //   341: aload_2
    //   342: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   345: pop
    //   346: iload 5
    //   348: istore 6
    //   350: iload 12
    //   352: istore 8
    //   354: iload 5
    //   356: istore 10
    //   358: iload 5
    //   360: istore 7
    //   362: iload 14
    //   364: istore 9
    //   366: aload_2
    //   367: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   370: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   373: invokevirtual 617	java/lang/Short:shortValue	()S
    //   376: iconst_1
    //   377: if_icmpne +36 -> 413
    //   380: iload 5
    //   382: istore 10
    //   384: iload 5
    //   386: istore 7
    //   388: iload 14
    //   390: istore 9
    //   392: aload_2
    //   393: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   396: istore 4
    //   398: iload 4
    //   400: sipush -25042
    //   403: if_icmpeq +97 -> 500
    //   406: iconst_0
    //   407: istore 6
    //   409: iload 12
    //   411: istore 8
    //   413: iload 6
    //   415: istore 7
    //   417: iload 8
    //   419: istore 9
    //   421: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +50 -> 474
    //   427: ldc_w 607
    //   430: iconst_2
    //   431: new 20	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 5284
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 619
    //   452: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 8
    //   457: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iload 8
    //   468: istore 9
    //   470: iload 6
    //   472: istore 7
    //   474: aload_0
    //   475: bipush 54
    //   477: iload 7
    //   479: iload 9
    //   481: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   487: return
    //   488: iconst_0
    //   489: istore 5
    //   491: goto -465 -> 26
    //   494: iconst_0
    //   495: istore 5
    //   497: goto -362 -> 135
    //   500: iload 5
    //   502: istore 10
    //   504: iload 5
    //   506: istore 7
    //   508: iload 14
    //   510: istore 9
    //   512: aload_2
    //   513: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   516: istore 4
    //   518: iload 4
    //   520: iconst_2
    //   521: if_icmpne +123 -> 644
    //   524: iload 5
    //   526: istore 10
    //   528: iload 5
    //   530: istore 7
    //   532: iload 14
    //   534: istore 9
    //   536: iload 4
    //   538: newarray byte
    //   540: astore_3
    //   541: iload 5
    //   543: istore 10
    //   545: iload 5
    //   547: istore 7
    //   549: iload 14
    //   551: istore 9
    //   553: aload_2
    //   554: aload_3
    //   555: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   558: pop
    //   559: iload 5
    //   561: istore 10
    //   563: iload 5
    //   565: istore 7
    //   567: iload 14
    //   569: istore 9
    //   571: aload_3
    //   572: iconst_0
    //   573: invokestatic 631	azzz:a	([BI)S
    //   576: istore 4
    //   578: iload 4
    //   580: ifne +32 -> 612
    //   583: iconst_0
    //   584: istore 6
    //   586: aload_2
    //   587: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   590: istore 4
    //   592: iload 4
    //   594: ifeq +24 -> 618
    //   597: iload 11
    //   599: istore 5
    //   601: iload 6
    //   603: istore 8
    //   605: iload 5
    //   607: istore 6
    //   609: goto -196 -> 413
    //   612: iconst_1
    //   613: istore 6
    //   615: goto -29 -> 586
    //   618: aload_0
    //   619: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   625: aload_1
    //   626: invokevirtual 1905	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   629: aconst_null
    //   630: ldc_w 3414
    //   633: iload 6
    //   635: invokestatic 2101	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   638: iconst_1
    //   639: istore 5
    //   641: goto -40 -> 601
    //   644: iconst_0
    //   645: istore 6
    //   647: iload 12
    //   649: istore 8
    //   651: goto -238 -> 413
    //   654: astore_1
    //   655: iload 13
    //   657: istore 6
    //   659: iload 10
    //   661: istore 5
    //   663: iload 5
    //   665: istore 7
    //   667: iload 6
    //   669: istore 9
    //   671: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +22 -> 696
    //   677: iload 5
    //   679: istore 7
    //   681: iload 6
    //   683: istore 9
    //   685: ldc_w 607
    //   688: iconst_2
    //   689: ldc_w 5286
    //   692: aload_1
    //   693: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iload 5
    //   698: istore 7
    //   700: iload 6
    //   702: istore 9
    //   704: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -233 -> 474
    //   710: ldc_w 607
    //   713: iconst_2
    //   714: new 20	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 5284
    //   724: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 5
    //   729: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 619
    //   735: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: iload 6
    //   740: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   743: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: iload 5
    //   751: istore 7
    //   753: iload 6
    //   755: istore 9
    //   757: goto -283 -> 474
    //   760: astore_1
    //   761: iload 7
    //   763: istore 5
    //   765: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +42 -> 810
    //   771: ldc_w 607
    //   774: iconst_2
    //   775: new 20	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 5284
    //   785: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 5
    //   790: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 619
    //   796: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload 9
    //   801: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload_1
    //   811: athrow
    //   812: astore_1
    //   813: iload 6
    //   815: istore 9
    //   817: goto -52 -> 765
    //   820: astore_1
    //   821: iconst_1
    //   822: istore 5
    //   824: iload 6
    //   826: istore 9
    //   828: goto -63 -> 765
    //   831: astore_1
    //   832: goto -169 -> 663
    //   835: astore_1
    //   836: iconst_1
    //   837: istore 5
    //   839: goto -176 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	ajfi
    //   0	842	1	paramToServiceMsg	ToServiceMsg
    //   0	842	2	paramFromServiceMsg	FromServiceMsg
    //   0	842	3	paramObject	Object
    //   308	285	4	i	int
    //   24	814	5	bool1	boolean
    //   62	763	6	bool2	boolean
    //   79	683	7	bool3	boolean
    //   66	584	8	bool4	boolean
    //   83	744	9	bool5	boolean
    //   75	585	10	bool6	boolean
    //   1	597	11	bool7	boolean
    //   10	638	12	bool8	boolean
    //   4	652	13	bool9	boolean
    //   7	561	14	bool10	boolean
    //   313	15	15	l	long
    // Exception table:
    //   from	to	target	type
    //   85	106	654	java/lang/Exception
    //   122	132	654	java/lang/Exception
    //   147	153	654	java/lang/Exception
    //   165	193	654	java/lang/Exception
    //   226	236	654	java/lang/Exception
    //   256	266	654	java/lang/Exception
    //   278	292	654	java/lang/Exception
    //   304	310	654	java/lang/Exception
    //   341	346	654	java/lang/Exception
    //   366	380	654	java/lang/Exception
    //   392	398	654	java/lang/Exception
    //   512	518	654	java/lang/Exception
    //   536	541	654	java/lang/Exception
    //   553	559	654	java/lang/Exception
    //   571	578	654	java/lang/Exception
    //   85	106	760	finally
    //   122	132	760	finally
    //   147	153	760	finally
    //   165	193	760	finally
    //   226	236	760	finally
    //   256	266	760	finally
    //   278	292	760	finally
    //   304	310	760	finally
    //   341	346	760	finally
    //   366	380	760	finally
    //   392	398	760	finally
    //   512	518	760	finally
    //   536	541	760	finally
    //   553	559	760	finally
    //   571	578	760	finally
    //   671	677	760	finally
    //   685	696	760	finally
    //   586	592	812	finally
    //   618	638	820	finally
    //   586	592	831	java/lang/Exception
    //   618	638	835	java/lang/Exception
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int j = 0;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespGetFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        long l = paramToServiceMsg.extraData.getLong("lNextMid");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("lUin");
        paramBundle.putString("lUin", paramToServiceMsg);
        paramBundle.putLong("nextMid", l);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramObject = paramFromServiceMsg.vFaceInfo;
        paramFromServiceMsg = new ArrayList();
        int i = 0;
        while (i < paramObject.size())
        {
          paramFromServiceMsg.add(bach.a(((FaceInfo)paramObject.get(i)).vFaceID));
          i += 1;
        }
        paramBundle.putStringArrayList("hexFaceInfo", paramFromServiceMsg);
        paramObject = (ajjj)this.app.getManager(51);
        paramToServiceMsg = paramObject.b(paramToServiceMsg);
        if (paramToServiceMsg == null) {}
        for (i = j;; i = paramToServiceMsg.getLocalPicKeysCount())
        {
          if ((paramToServiceMsg != null) && (l == i) && (i < paramToServiceMsg.getPicCountInAlbum()))
          {
            paramToServiceMsg.appendPortrait(paramFromServiceMsg);
            paramObject.a(paramToServiceMsg);
          }
          notifyUI(27, true, paramBundle);
          return;
        }
      }
      paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
      paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
      paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
      paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
      notifyUI(27, false, paramBundle);
      return;
    }
    paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
    paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
    paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
    paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
    notifyUI(27, false, paramBundle);
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState success=" + bool1);
      }
      paramFromServiceMsg = this.app.getApplication().getString(2131629297);
      str = this.app.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label610;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", paramObject);
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      notifyUI(55, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    paramBundle = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|resp.getResultCode = " + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetUserInfoResp)))
    {
      paramObject = (SetUserInfoResp)paramObject;
      paramFromServiceMsg = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|setUserInfoResp.result = " + paramObject.result);
      }
    }
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      paramObject = (ajjj)this.app.getManager(51);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        String str = paramToServiceMsg.getUin();
        paramFromServiceMsg = paramObject.b(paramToServiceMsg.getUin());
        Friends localFriends = paramObject.e(str);
        if (localObject != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.strNick = ((String)localObject);
          }
          if (localFriends != null)
          {
            localFriends.name = ((String)localObject);
            paramObject.a(localFriends);
          }
          if (azzz.a(this.app.getCurrentAccountUin(), str)) {
            this.app.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, (String)localObject);
          }
        }
        if (paramBundle != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.shGender = ((short)paramBundle.byteValue());
          }
          if (azzz.a(this.app.getCurrentAccountUin(), str))
          {
            localObject = (ascz)this.app.getManager(106);
            if (localObject != null) {
              ((ascz)localObject).b(paramBundle.byteValue());
            }
          }
        }
        if ((localInteger != null) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.lBirthday = localInteger.intValue();
          paramFromServiceMsg.shAge = ((short)awbr.a(localInteger.intValue()));
          paramFromServiceMsg.age = ((byte)paramFromServiceMsg.shAge);
          if (azzz.a(this.app.getCurrentAccountUin(), str))
          {
            paramBundle = (ascz)this.app.getManager(106);
            if (paramBundle != null) {
              paramBundle.a(paramFromServiceMsg.age);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + paramFromServiceMsg.age);
          }
        }
        if (paramFromServiceMsg != null) {
          paramObject.a(paramFromServiceMsg);
        }
        notifyUI(paramToServiceMsg, 31, true, paramFromServiceMsg);
        return;
      }
      notifyUI(paramToServiceMsg, 31, false, paramObject.c(paramToServiceMsg.getUin()));
      return;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5;
    short s;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState success=" + bool2);
      }
      bool5 = paramToServiceMsg.extraData.getBoolean("switch");
      paramFromServiceMsg = this.app.getApplication().getString(2131629297);
      s = paramToServiceMsg.extraData.getShort("type");
      bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        bool4 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool3 = bool2;
        bool4 = bool2;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool4 = bool2;
          QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool2);
        }
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          bool3 = bool2;
          bool4 = bool2;
          if (paramObject.bytes_bodybuffer.has())
          {
            bool1 = bool2;
            bool3 = bool2;
            bool4 = bool2;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              bool3 = bool2;
              bool4 = bool2;
              int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
              long l = i;
              if (i < 0) {
                l = i & 0x7FFFFFFF | 0x80000000;
              }
              bool3 = bool2;
              bool4 = bool2;
              bool1 = this.app.getCurrentAccountUin().equals(String.valueOf(l));
              if (!bool1) {
                continue;
              }
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool2 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool3;
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState ex", paramObject);
        bool2 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool2 = bool3;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      ((ariq)this.app.getManager(303)).a(s, bool2, paramFromServiceMsg, bool5);
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetHelloLiveMessageState success=" + bool1);
      }
      paramFromServiceMsg = this.app.getApplication().getString(2131629297);
      str = this.app.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label610;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetHelloLiveMessageState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", paramObject);
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      notifyUI(87, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  /* Error */
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: iconst_0
    //   7: istore 12
    //   9: iconst_0
    //   10: istore 9
    //   12: aload_2
    //   13: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +404 -> 420
    //   19: aload_3
    //   20: ifnull +400 -> 420
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 607
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5360
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 8
    //   64: iload 5
    //   66: ifeq +706 -> 772
    //   69: iload 5
    //   71: istore 7
    //   73: iload 5
    //   75: istore 6
    //   77: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   80: dup
    //   81: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   84: aload_3
    //   85: checkcast 110	[B
    //   88: checkcast 110	[B
    //   91: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +327 -> 426
    //   102: iload 5
    //   104: istore 7
    //   106: iload 5
    //   108: istore 6
    //   110: aload_2
    //   111: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: ifne +309 -> 426
    //   120: iconst_1
    //   121: istore 5
    //   123: iload 5
    //   125: istore 7
    //   127: iload 5
    //   129: istore 6
    //   131: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +39 -> 173
    //   137: iload 5
    //   139: istore 7
    //   141: iload 5
    //   143: istore 6
    //   145: ldc_w 607
    //   148: iconst_2
    //   149: new 20	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 5362
    //   159: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 5
    //   164: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: iload 5
    //   175: istore 8
    //   177: iload 5
    //   179: ifeq +593 -> 772
    //   182: iload 5
    //   184: istore 7
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 8
    //   194: aload_2
    //   195: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   201: ifeq +571 -> 772
    //   204: iload 5
    //   206: istore 7
    //   208: iload 5
    //   210: istore 6
    //   212: iload 5
    //   214: istore 8
    //   216: aload_2
    //   217: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: ifnull +549 -> 772
    //   226: iload 5
    //   228: istore 7
    //   230: iload 5
    //   232: istore 6
    //   234: aload_2
    //   235: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   244: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   247: astore_2
    //   248: iload 5
    //   250: istore 7
    //   252: iload 5
    //   254: istore 6
    //   256: aload_2
    //   257: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   260: istore 4
    //   262: iload 4
    //   264: i2l
    //   265: lstore 13
    //   267: iload 4
    //   269: ifge +12 -> 281
    //   272: iload 4
    //   274: ldc_w 939
    //   277: iand
    //   278: i2l
    //   279: lstore 13
    //   281: iload 5
    //   283: istore 7
    //   285: iload 5
    //   287: istore 6
    //   289: aload_2
    //   290: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   293: pop
    //   294: iload 5
    //   296: istore 7
    //   298: iload 5
    //   300: istore 6
    //   302: aload_2
    //   303: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 617	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +249 -> 562
    //   316: iload 5
    //   318: istore 7
    //   320: iload 5
    //   322: istore 6
    //   324: aload_2
    //   325: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   328: istore 4
    //   330: iload 4
    //   332: sipush -25181
    //   335: if_icmpeq +97 -> 432
    //   338: iconst_0
    //   339: istore 5
    //   341: iload 9
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: iload 6
    //   351: istore 8
    //   353: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +50 -> 406
    //   359: ldc_w 607
    //   362: iconst_2
    //   363: new 20	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 5362
    //   373: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 5
    //   378: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 619
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 6
    //   389: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: iload 6
    //   400: istore 8
    //   402: iload 5
    //   404: istore 7
    //   406: aload_0
    //   407: bipush 88
    //   409: iload 7
    //   411: iload 8
    //   413: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   416: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   419: return
    //   420: iconst_0
    //   421: istore 5
    //   423: goto -397 -> 26
    //   426: iconst_0
    //   427: istore 5
    //   429: goto -306 -> 123
    //   432: iload 5
    //   434: istore 7
    //   436: iload 5
    //   438: istore 6
    //   440: aload_2
    //   441: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   444: istore 4
    //   446: iload 4
    //   448: iconst_2
    //   449: if_icmpne +103 -> 552
    //   452: iload 5
    //   454: istore 7
    //   456: iload 5
    //   458: istore 6
    //   460: iload 4
    //   462: newarray byte
    //   464: astore_3
    //   465: iload 5
    //   467: istore 7
    //   469: iload 5
    //   471: istore 6
    //   473: aload_2
    //   474: aload_3
    //   475: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   478: pop
    //   479: iload 5
    //   481: istore 7
    //   483: iload 5
    //   485: istore 6
    //   487: aload_3
    //   488: iconst_0
    //   489: invokestatic 631	azzz:a	([BI)S
    //   492: istore 4
    //   494: iload 4
    //   496: ifne +24 -> 520
    //   499: iconst_1
    //   500: istore 6
    //   502: aload_2
    //   503: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   506: istore 4
    //   508: iload 4
    //   510: ifeq +16 -> 526
    //   513: iload 10
    //   515: istore 5
    //   517: goto -172 -> 345
    //   520: iconst_0
    //   521: istore 6
    //   523: goto -21 -> 502
    //   526: aload_0
    //   527: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   530: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   533: aload_1
    //   534: invokevirtual 1905	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   537: aconst_null
    //   538: ldc_w 3444
    //   541: iload 6
    //   543: invokestatic 2101	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   546: iconst_1
    //   547: istore 5
    //   549: goto -32 -> 517
    //   552: iconst_0
    //   553: istore 5
    //   555: iload 9
    //   557: istore 6
    //   559: goto -214 -> 345
    //   562: iconst_0
    //   563: istore 5
    //   565: iload 9
    //   567: istore 6
    //   569: goto -224 -> 345
    //   572: astore_1
    //   573: iload 7
    //   575: istore 6
    //   577: iload 11
    //   579: istore 5
    //   581: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq +14 -> 598
    //   587: ldc_w 607
    //   590: iconst_2
    //   591: ldc_w 5364
    //   594: aload_1
    //   595: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   598: iload 6
    //   600: istore 7
    //   602: iload 5
    //   604: istore 8
    //   606: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq -203 -> 406
    //   612: ldc_w 607
    //   615: iconst_2
    //   616: new 20	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 5362
    //   626: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload 6
    //   631: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   634: ldc_w 619
    //   637: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload 5
    //   642: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: iload 6
    //   653: istore 7
    //   655: iload 5
    //   657: istore 8
    //   659: goto -253 -> 406
    //   662: astore_1
    //   663: iload 12
    //   665: istore 5
    //   667: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +42 -> 712
    //   673: ldc_w 607
    //   676: iconst_2
    //   677: new 20	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 5362
    //   687: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: iload 6
    //   692: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   695: ldc_w 619
    //   698: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iload 5
    //   703: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   706: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_1
    //   713: athrow
    //   714: astore_1
    //   715: iload 6
    //   717: istore 7
    //   719: iload 5
    //   721: istore 6
    //   723: iload 7
    //   725: istore 5
    //   727: goto -60 -> 667
    //   730: astore_1
    //   731: iload 6
    //   733: istore 5
    //   735: iconst_1
    //   736: istore 6
    //   738: goto -71 -> 667
    //   741: astore_1
    //   742: goto -75 -> 667
    //   745: astore_1
    //   746: iload 6
    //   748: istore 7
    //   750: iload 5
    //   752: istore 6
    //   754: iload 7
    //   756: istore 5
    //   758: goto -177 -> 581
    //   761: astore_1
    //   762: iload 6
    //   764: istore 5
    //   766: iconst_1
    //   767: istore 6
    //   769: goto -188 -> 581
    //   772: iload 8
    //   774: istore 5
    //   776: iload 9
    //   778: istore 6
    //   780: goto -435 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	this	ajfi
    //   0	783	1	paramToServiceMsg	ToServiceMsg
    //   0	783	2	paramFromServiceMsg	FromServiceMsg
    //   0	783	3	paramObject	Object
    //   260	249	4	i	int
    //   24	751	5	bool1	boolean
    //   75	704	6	bool2	boolean
    //   71	684	7	bool3	boolean
    //   62	711	8	bool4	boolean
    //   10	767	9	bool5	boolean
    //   1	513	10	bool6	boolean
    //   4	574	11	bool7	boolean
    //   7	657	12	bool8	boolean
    //   265	15	13	l	long
    // Exception table:
    //   from	to	target	type
    //   77	98	572	java/lang/Exception
    //   110	120	572	java/lang/Exception
    //   131	137	572	java/lang/Exception
    //   145	173	572	java/lang/Exception
    //   194	204	572	java/lang/Exception
    //   216	226	572	java/lang/Exception
    //   234	248	572	java/lang/Exception
    //   256	262	572	java/lang/Exception
    //   289	294	572	java/lang/Exception
    //   302	316	572	java/lang/Exception
    //   324	330	572	java/lang/Exception
    //   440	446	572	java/lang/Exception
    //   460	465	572	java/lang/Exception
    //   473	479	572	java/lang/Exception
    //   487	494	572	java/lang/Exception
    //   77	98	662	finally
    //   110	120	662	finally
    //   131	137	662	finally
    //   145	173	662	finally
    //   194	204	662	finally
    //   216	226	662	finally
    //   234	248	662	finally
    //   256	262	662	finally
    //   289	294	662	finally
    //   302	316	662	finally
    //   324	330	662	finally
    //   440	446	662	finally
    //   460	465	662	finally
    //   473	479	662	finally
    //   487	494	662	finally
    //   502	508	714	finally
    //   526	546	730	finally
    //   581	598	741	finally
    //   502	508	745	java/lang/Exception
    //   526	546	761	java/lang/Exception
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool4 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label464;
      }
      bool3 = bool1;
    }
    label464:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool1 = true;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool3 = bool1;
            QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice result=" + bool1);
          }
          bool2 = bool1;
          if (!bool1) {
            break label464;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
            break label464;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
            break label464;
          }
          bool3 = bool1;
          i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
          if (i >= 0) {
            continue;
          }
          l = i + 4294967296L;
          bool2 = bool6;
          bool3 = bool1;
          if (this.app.getCurrentAccountUin().equals(String.valueOf(l)))
          {
            bool3 = bool1;
            bool1 = paramToServiceMsg.extraData.getBoolean("switch");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        long l;
        bool1 = bool3;
        bool4 = bool5;
        QLog.e("Q.profilecard.", 2, paramToServiceMsg, new Object[0]);
        bool2 = bool1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice show=" + bool1);
        }
        QLog.d("PushNotise", 2, "handleSetShowPushNotice show=" + bool1);
        bool2 = true;
        bool4 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice show=" + bool4 + "isSuccess=" + bool2);
        }
        notifyUI(92, bool2, Boolean.valueOf(bool4));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool2 = true;
        bool4 = bool1;
        bool1 = bool2;
        continue;
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = false;
    boolean bool5 = true;
    boolean bool1;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag success=" + paramFromServiceMsg.getResultCode());
      bool3 = bool1;
      if (!bool1) {
        break label446;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool4 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool1);
        bool3 = bool1;
        if (!bool1) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool2 = bool1;
        bool4 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() <= 0) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_hide_pretty_group_owner_identity.get();
        bool2 = bool6;
        if (i == 0) {
          bool2 = true;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        bool4 = bool2;
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag ex", paramToServiceMsg);
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool2);
        bool1 = bool2;
        bool2 = bool5;
        continue;
      }
      finally
      {
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool4);
      }
      notifyUI(110, bool1, Boolean.valueOf(bool2));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = true;
      continue;
      label446:
      bool2 = true;
      bool1 = bool3;
    }
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = true;
    boolean bool3 = true;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label515;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label515:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool1;
        bool5 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool4 = bool1;
        bool5 = bool1;
        if (QLog.isColorLevel())
        {
          bool4 = bool1;
          bool5 = bool1;
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool1);
        }
        bool2 = bool1;
        if (!bool1) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool8;
        bool4 = bool1;
        bool5 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
        {
          bool4 = bool1;
          bool5 = bool1;
          int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_notify_partake_like_ranking_list_flag.get();
          bool1 = bool7;
          if (i == 0) {
            bool1 = true;
          }
          bool2 = true;
          bool3 = bool1;
        }
        bool1 = bool3;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool2);
          bool5 = bool2;
          bool1 = bool3;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handlePartekeLikeRankingList ex", paramToServiceMsg);
          }
          bool1 = bool6;
          bool5 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool4);
          bool1 = bool6;
          bool5 = bool4;
          continue;
        }
        finally
        {
          bool5 = bool4;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool5);
      }
      notifyUI(83, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void A()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23221));
    a(localArrayList, null);
  }
  
  public void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getBindPhoneCardExtInfo uin:" + this.app.c(), new Object[0]));
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xc33_42220", 3123, 0, new oidb_0xc33.ReqBody().toByteArray()));
  }
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getAutoReplyList");
    }
    Object localObject = new oidb_cmd0xcd5.ReqBody();
    oidb_cmd0xcd5.GetDataReq localGetDataReq = new oidb_cmd0xcd5.GetDataReq();
    localGetDataReq.query_type.set(1);
    ((oidb_cmd0xcd5.ReqBody)localObject).getdata_req.set(localGetDataReq);
    ((oidb_cmd0xcd5.ReqBody)localObject).service_type.set(1);
    localObject = makeOIDBPkg("OidbSvc.0xcd5", 3285, 0, ((oidb_cmd0xcd5.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetList", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public int a()
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getSelfAddFriendSettingValue  settingValue:" + i);
    }
    return i;
  }
  
  public ajfl a(QQAppInterface paramQQAppInterface, ajfm paramajfm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("addCoverTransCallback app=%s callBack=%s", new Object[] { paramQQAppInterface, paramajfm }));
    }
    if (this.jdField_a_of_type_Axvo == null) {
      this.jdField_a_of_type_Axvo = paramQQAppInterface.a();
    }
    paramQQAppInterface = new ajfl(paramajfm);
    paramQQAppInterface.addFilter(new Class[] { axsm.class });
    this.jdField_a_of_type_Axvo.a(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public ArrayList<CardProfile> a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = this.app.getEntityManagerFactory().createEntityManager();; localObject1 = null)
    {
      label152:
      try
      {
        localObject2 = (ArrayList)((atmp)localObject1).a(CardProfile.class, true, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, "lTime desc", String.valueOf(paramInt2));
        ((atmp)localObject1).a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          ((atmp)localObject1).a();
          if (0 != 0) {
            break;
          }
          localObject1 = new ArrayList(0);
        }
      }
      finally
      {
        ((atmp)localObject1).a();
        if (0 != 0) {
          break label152;
        }
        new ArrayList(0);
      }
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < ((ArrayList)localObject1).size())
        {
          localObject2 = (CardProfile)((ArrayList)localObject1).get(paramInt1);
          ((CardProfile)localObject2).updateTime(((CardProfile)localObject2).lTime);
          paramInt1 += 1;
        }
        else
        {
          return localObject1;
        }
      }
    }
  }
  
  public void a()
  {
    send(createToServiceMsg("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void a(int paramInt)
  {
    atmp localatmp = this.app.getEntityManagerFactory().createEntityManager();
    localatmp.a().a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from ");
      localStringBuilder.append(((CardProfile)CardProfile.class.newInstance()).getTableName());
      localStringBuilder.append(" where ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(";");
      localatmp.b(localStringBuilder.toString());
      localatmp.a().c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, localException.getMessage(), localException);
      }
      return;
    }
    finally
    {
      localatmp.a().b();
      localatmp.a();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingCardInfo begins, seqNo:" + paramInt + ",shoppingUin:" + paramString1 + ",uin:" + paramString2);
    }
    Object localObject;
    if (rtr.a(this.app, paramString2 + "") != -4) {
      localObject = new oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest();
    }
    try
    {
      ((oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest)localObject).luin.set(Long.parseLong(paramString1));
      label105:
      ((oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest)localObject).seqno.set(paramInt);
      ((oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest)localObject).version.set(1);
      ((oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest)localObject).versionInfo.set("8.2.6,3,4370");
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(3320);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(1);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0xcf8");
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("uin", paramString2);
      ((ToServiceMsg)localObject).addAttribute("type", Integer.valueOf(1));
      sendPbReq((ToServiceMsg)localObject);
      return;
      localObject = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).versionInfo.set("8.2.6,3,4370");
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).version.set(1);
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(paramInt);
      try
      {
        ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).luin.set(Long.parseLong(paramString1));
        label281:
        paramString1 = createToServiceMsg("PubAccountSvc.get_detail_info");
        paramString1.putWupBuffer(((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).toByteArray());
        paramString1.addAttribute("uin", paramString2);
        paramString1.addAttribute("type", "0");
        sendPbReq(paramString1);
        return;
      }
      catch (NumberFormatException paramString1)
      {
        break label281;
      }
    }
    catch (NumberFormatException paramString1)
    {
      break label105;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getEducationList " + paramLong);
    }
    Object localObject = new oidb_cmd0xd2d.ReqBody();
    ((oidb_cmd0xd2d.ReqBody)localObject).uint64_req_uin.set(paramLong);
    ((oidb_cmd0xd2d.ReqBody)localObject).uint32_req_category.set(0);
    localObject = makeOIDBPkg("OidbSvc.0xd2d", 3373, 1, ((oidb_cmd0xd2d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("reqFavorite|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, ajfn paramajfn)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    mmj.a(this.app, paramajfn, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = awbi.a(-1000);
    localMessageRecord.frienduin = ajed.E;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    ThreadManager.post(new CardHandler.1(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList), 8, null, false);
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131627088), new Object[] { localObject2 });
        this.app.a().a(localMessageRecord, paramString1);
        this.app.a(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        notifyUI(28, true, new Object[] { ((ajjj)this.app.getManager(51)).c(this.app.getCurrentAccountUin()), localObject1 });
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("accost", 2, "last voter's name. unsupported encoding.");
        }
        String str = "";
        continue;
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131627087), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(ajfl paramajfl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("removeCoverTransCallback transHandler=%s", new Object[] { paramajfl }));
    }
    if (this.jdField_a_of_type_Axvo != null) {
      this.jdField_a_of_type_Axvo.b(paramajfl);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("CardHandler", 1, "setDetailUserInfo");
    this.app.a(new CardHandler.2(this, paramBundle));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (;;)
    {
      if (i != 0) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo, NOT success.");
      return;
      i = 0;
    }
    label92:
    paramToServiceMsg = new qqshop.SQQSHPClientRsp();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.retcode.get();
        if (i != 0) {
          break label367;
        }
        paramToServiceMsg = paramToServiceMsg.bindlist.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label401;
        }
        l1 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).puin.get();
        l2 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).binduin.get();
        paramFromServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.app, Long.toString(l2));
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null)
        {
          paramToServiceMsg = new ProfileShoppingPhotoInfo();
          paramToServiceMsg.seqNo = 0;
          paramToServiceMsg.uin = Long.toString(l2);
          paramToServiceMsg.setStatus(1000);
        }
        paramToServiceMsg.bindShoppingNo = Long.toString(l1);
        ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.app);
        notifyUI(67, true, new Object[] { Integer.valueOf(paramToServiceMsg.seqNo), Long.valueOf(l1), Long.valueOf(l2) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, pUin:" + l1 + ",bindUin:" + l2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, errInfo:" + paramToServiceMsg.getMessage());
      return;
      label367:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, retCode:" + i);
      return;
      label401:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingIsBind begins, curUin:" + this.app.getCurrentAccountUin());
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
      localSQQSHPClientReq.cuinlist.set(localArrayList);
      paramString = createToServiceMsg("SQQShopFolderSvc.GetAcctBindPuin");
      paramString.putWupBuffer(localSQQSHPClientReq.toByteArray());
      sendPbReq(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "func getShoppingIsBind ends");
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CardHandler", 2, "func getShoppingIsBind ends,errInfo:" + paramString.getMessage());
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    send(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, byte paramByte, ArrayList<TagInfo> paramArrayList1, byte[] paramArrayOfByte1, ArrayList<TagInfo> paramArrayList2, ArrayList<TagInfo> paramArrayList3, byte[] paramArrayOfByte2)
  {
    paramString = createToServiceMsg("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByte("bIsSingle", paramByte);
    paramString.extraData.putByteArray("vBackground", paramArrayOfByte1);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte2);
    try
    {
      paramArrayOfByte1 = new ByteArrayOutputStream();
      paramArrayOfByte2 = new ObjectOutputStream(paramArrayOfByte1);
      paramArrayOfByte2.writeObject(paramArrayList1);
      paramArrayOfByte2.flush();
      paramString.extraData.putByteArray("vTagsID", paramArrayOfByte1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList2);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vDelTags", paramArrayList1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList3);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vAddTags", paramArrayList1.toByteArray());
      send(paramString);
      return;
    }
    catch (IOException paramArrayList1)
    {
      for (;;)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    oidb_0x7ba.ReqBody localReqBody = new oidb_0x7ba.ReqBody();
    localReqBody.uint64_uin.set(Long.parseLong(paramString));
    localReqBody.uint32_start_index.set(paramInt1);
    localReqBody.uint32_want_num.set(paramInt2);
    sendPbReq(makeOIDBPkg("OidbSvc.0x7ba", 1978, 0, localReqBody.toByteArray()));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "getFriendMedalNews " + paramString + " " + paramLong);
    }
    long l1;
    if (paramLong <= 0L) {
      l1 = 1L;
    }
    try
    {
      for (;;)
      {
        l2 = Long.parseLong(paramString);
        if (l2 != 0L) {
          break;
        }
        return;
        l1 = paramLong;
      }
    }
    catch (Exception localException)
    {
      long l2;
      for (;;)
      {
        localException.printStackTrace();
        l2 = 0L;
      }
      Object localObject = new cmd0x7a8.ReqBody();
      ((cmd0x7a8.ReqBody)localObject).uint64_req_uin.set(l2);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_obtained.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_sort_type.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_start_timestamp.set((int)l1);
      localObject = makeOIDBPkg("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("from", "getFriendMedalNews");
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putLong("ts", paramLong);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, String.format("reqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString), "VisitorSvc.ReqDeleteVisitorRecord");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString));
    localToServiceMsg.extraData.putLong("targetUin", paramLong);
    localToServiceMsg.extraData.putInt("type", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.app.getCurrentAccountUin()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    this.app.sendToService(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "getQzonePhotoWall uin:" + paramString1);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.getPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("attachInfo", paramString2);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    send(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramByte1, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, 0L, false, paramByte2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ArrayList<Integer> paramArrayList)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSimpleSummayCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt);
      paramString1.extraData.putBoolean("simpleinfo_pull", true);
      paramString1.extraData.putIntegerArrayList("req0x5ebFieldIdList", paramArrayList);
      send(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSimpleSummayCard", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "delQzonePhotoWall");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.delPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("photo_id", paramString2);
    localToServiceMsg.addAttribute("photo_time", Long.valueOf(paramLong));
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    send(localToServiceMsg);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianExt");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25126));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isQidianExt", true);
      localBundle.putBoolean("isQidianSimple", paramBoolean);
      a(localArrayList, localBundle, paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQidianExt ex", paramString);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall size:" + paramArrayList.size());
    }
    this.app.a(new CardHandler.4(this));
  }
  
  public void a(ArrayList<AutoReplyText> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (((paramInt1 < 0) || (paramInt1 >= paramArrayList.size())) && (paramInt1 != 2147483647)))
    {
      QLog.d("CardHandler", 1, String.format("setAutoReplyList param error, replyList: %s, lastSelectId: %s", new Object[] { paramArrayList, Integer.valueOf(paramInt1) }));
      notifyUI(99, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format("setAutoReplyList, selectIndex: %s, replyMsgList: %s, lastSelectId: %s, needNotify: %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (AutoReplyText)((Iterator)localObject2).next();
      if (((AutoReplyText)localObject3).getTextId() == 2147483647)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "setAutoReplyList, filter TEXT_NONE");
        }
      }
      else
      {
        localObject3 = awbg.a(((AutoReplyText)localObject3).getRawText(), null);
        if (localObject3 != null) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    localObject2 = new wording_storage.WordingCfg();
    if (paramInt1 == 2147483647)
    {
      ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(0);
      ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt2);
    }
    for (;;)
    {
      ((wording_storage.WordingCfg)localObject2).wording_list.set((List)localObject1);
      localObject1 = new oidb_cmd0xcd5.SetDataReq();
      ((oidb_cmd0xcd5.SetDataReq)localObject1).pb_data.set(ByteStringMicro.copyFrom(((wording_storage.WordingCfg)localObject2).toByteArray()));
      localObject2 = new oidb_cmd0xcd5.ReqBody();
      ((oidb_cmd0xcd5.ReqBody)localObject2).service_type.set(2);
      ((oidb_cmd0xcd5.ReqBody)localObject2).setdata_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xcd5", 3285, 0, ((oidb_cmd0xcd5.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("replyMsgList", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putInt("selectId", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putBoolean("needNotify", paramBoolean);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(1);
      ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt1);
    }
  }
  
  public void a(List<ProfileLabelInfo> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = createToServiceMsg("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      send(paramList);
    }
  }
  
  public void a(List<Short> paramList, Bundle paramBundle)
  {
    a(paramList, paramBundle, this.app.getCurrentAccountUin());
  }
  
  public void a(Oidb_0x66b.ReqBody paramReqBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getSimpleNearbyMyTabCard");
    }
    paramReqBody = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, paramReqBody.toByteArray());
    paramReqBody.extraData.putBoolean("req_pb_protocol_flag", true);
    paramReqBody.extraData.putBoolean("simpleMytabCard", true);
    send(paramReqBody);
  }
  
  public void a(short paramShort1, short paramShort2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "setCommonSwitchFromDetailInfo [%d, %d]", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      ((ByteBuffer)localObject).putInt(azzz.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort(paramShort1).putShort((short)2).putShort(paramShort2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putShort("switch_id", paramShort1);
      ((ToServiceMsg)localObject).extraData.putShort("switch_value", paramShort2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetCommonSwitchFromDetailInfo", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CommonSwitchTag", 2, "setCommonSwitchFromDetailInfo ex", localException);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setTempConversationBlocState type=" + paramShort + " Block=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort(paramShort).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putShort("type", paramShort);
          ((ToServiceMsg)localObject).extraData.putBoolean("tempConversationBlocState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setTempConversationBlocState ex", localException);
      }
      s = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i = 0;
    }
    ((ByteBuffer)localObject).put((byte)i);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "sendHiddenSessionRequest open=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)paramInt).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
          ((ToServiceMsg)localObject).extraData.putInt("hidden_session_switch", s);
          ((ToServiceMsg)localObject).extraData.putBoolean("from_send_hidden_session", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "sendHiddenSessionRequest ex", localException);
      }
      s = 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = azyk.b();
    azyk.a(null);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.app.getEntityManagerFactory().createEntityManager();
      localObject1 = (Setting)((atmp)localObject2).a(Setting.class, paramString);
      if (localObject1 != null) {
        break label399;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((atmp)localObject2).a((atmo)localObject1);
    }
    for (;;)
    {
      ((atmp)localObject2).a();
      this.app.a((Setting)localObject1);
      localObject1 = (ajjj)this.app.getManager(51);
      localObject2 = ((baov)this.app.getManager(235)).a;
      Object localObject3 = this.app.a(paramString, true);
      ((ExtensionInfo)localObject3).faceId = 0;
      ((ExtensionInfo)localObject3).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      ((ExtensionInfo)localObject3).setStatus(1000);
      ((ajjj)localObject1).a((ExtensionInfo)localObject3);
      ((VasFaceManager)localObject2).a((ExtensionInfo)localObject3);
      localObject1 = this.app.a(false, this.app.getCurrentAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        bace.d((String)localObject1);
      }
      localObject2 = azyk.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        bace.d((String)localObject2);
      }
      localObject3 = azyk.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        bace.d((String)localObject3);
      }
      azyk.a(this.app, paramString);
      this.app.a(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        bacm.a(null, str, (String)localObject1, 140, 140);
        bace.d(str, (String)localObject2);
        this.app.b(1, paramString, 0, (String)localObject1);
      }
      if (!TextUtils.isEmpty(str)) {
        bace.d(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      notifyUI(8, paramBoolean, localObject1);
      return;
      label399:
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((atmp)localObject2).a((atmo)localObject1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l = 0L;; l = 1L)
    {
      localBundle.putLong("target_value", l);
      send(localToServiceMsg);
      return;
    }
  }
  
  public void a(short[] paramArrayOfShort)
  {
    int j = 0;
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0)) {}
    do
    {
      return;
      Object localObject;
      int k;
      int i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(200);
        ((StringBuilder)localObject).append("getCommonSwitchFromDetailInfo size: ").append(paramArrayOfShort.length);
        ((StringBuilder)localObject).append("[");
        k = paramArrayOfShort.length;
        i = 0;
        while (i < k)
        {
          ((StringBuilder)localObject).append(paramArrayOfShort[i]).append(",");
          i += 1;
        }
        ((StringBuilder)localObject).append("]");
        QLog.d("CommonSwitchTag", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = new ArrayList();
        k = paramArrayOfShort.length;
        i = j;
        while (i < k)
        {
          ((List)localObject).add(Short.valueOf(paramArrayOfShort[i]));
          i += 1;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isGetCommonSwitchFromDetailInfo", true);
        localBundle.putShortArray("switch_id_array", paramArrayOfShort);
        a((List)localObject, localBundle);
        return;
      }
      catch (Exception paramArrayOfShort) {}
    } while (!QLog.isColorLevel());
    QLog.d("CommonSwitchTag", 2, "getCommonSwitchFromDetailInfo ex", paramArrayOfShort);
  }
  
  public boolean a()
  {
    Object localObject = this.app.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("sign_in_time_stamp", 0L);
    localObject = ((SharedPreferences)localObject).getString(this.app.c() + "sign_in_info", "");
    try
    {
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).optInt("type");
      int j = ((JSONObject)localObject).optInt("redpoint");
      if (((JSONObject)localObject).optInt("openfunc") != 0)
      {
        long l2 = awao.a();
        if ((l2 - l1 <= 86400L) && (i != 4) && (j == 1)) {
          return true;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(Card paramCard, SparseArray<awai> paramSparseArray)
  {
    Object localObject = amjk.a();
    if ((localObject != null) && (((amjj)localObject).a()) && (!((amjj)localObject).b()))
    {
      localObject = (awai)paramSparseArray.get(15);
      if ((localObject != null) && (((awai)localObject).a != null))
      {
        paramSparseArray = new SummaryCardBusiEntry.VisitorCountRsp();
        try
        {
          paramSparseArray.mergeFrom(((awai)localObject).a);
          if (paramSparseArray.hotValue.get() > 0)
          {
            paramCard.lVoteCount = paramSparseArray.hotValue.get();
            paramCard.iVoteIncrement = paramSparseArray.redValue.get();
            return true;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getSigninRedTouchShell");
    }
    if (c())
    {
      c(paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSignRedTouchShell time kill");
    }
    notifyUI(84, true, null);
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "sendNotDisturbTime time=" + paramInt + " lastTime=" + paramString1 + " source_from" + paramString2);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(15);
      ((ByteBuffer)localObject).putInt(azzz.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)27240).putShort((short)4).putInt(paramInt);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putInt("no_disturb_time", paramInt);
      ((ToServiceMsg)localObject).extraData.putString("no_disturb_last_time", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("source_from", paramString2);
      ((ToServiceMsg)localObject).extraData.putBoolean("from_send_no_disturb", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "sendNotDisturbTime ex", paramString1);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo, NOT success.");
      return;
    }
    label92:
    paramFromServiceMsg = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
    String str2;
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)paramToServiceMsg.getAttribute("type", "0"));
        localObject = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
        if (i != 0) {
          break label296;
        }
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        bool = true;
        if (!bool) {
          break label634;
        }
        i = ((mobileqq_mp.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
        if ((i != 0) || (!paramFromServiceMsg.name.has()) || (!paramFromServiceMsg.unified_account_descrpition.has())) {
          break label594;
        }
        paramObject = paramFromServiceMsg.name.get();
        str2 = paramFromServiceMsg.unified_account_descrpition.get();
        if ((!TextUtils.isEmpty(paramObject)) && (!TextUtils.isEmpty(str2))) {
          break label314;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, data is nullll.");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errInfo:" + paramToServiceMsg.getMessage() + ",response.unified_account_descrpition.has():" + paramFromServiceMsg.unified_account_descrpition.has());
      return;
      label296:
      boolean bool = rtr.a((byte[])paramObject, (oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse)localObject, paramFromServiceMsg);
    }
    label314:
    i = paramFromServiceMsg.certified_grade.get();
    int j = paramFromServiceMsg.account_flag.get();
    int k = paramFromServiceMsg.follow_type.get();
    Object localObject = ProfileShoppingPhotoInfo.parseShoppingPhotoJson(str2);
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo, ready to notify UI. shopName:" + paramObject + ",certifiedGrade:" + i + ",uin:" + str1 + ",accountFlag:" + j + "followType:" + k + ",picJson:" + str2 + ",picList.size:" + ((List)localObject).size());
    }
    notifyUI(66, true, new Object[] { paramObject, localObject, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
    paramToServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.app, str1);
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = new ProfileShoppingPhotoInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.setStatus(1000);
    }
    for (;;)
    {
      paramToServiceMsg.certifiedGrade = i;
      paramToServiceMsg.accountFlag = j;
      paramToServiceMsg.followType = k;
      paramToServiceMsg.seqNo = paramFromServiceMsg.seqno.get();
      paramToServiceMsg.shopName = paramObject;
      paramToServiceMsg.picByteData = ProfileShoppingPhotoInfo.converPhoto2RawData((List)localObject);
      ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.app);
      return;
      label594:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errCode:" + i + ",no data is obtained.");
      return;
      label634:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, isConvertSuccess: false");
      return;
    }
  }
  
  public void b(String paramString)
  {
    axvt localaxvt = new axvt();
    localaxvt.i = paramString;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_c_of_type_JavaLangString = this.mApp.getCurrentAccountUin();
    localaxvt.jdField_a_of_type_Long = 0L;
    localaxvt.jdField_b_of_type_Int = 35;
    localaxvt.jdField_a_of_type_JavaLangString = "actProfileCoverPicUpload";
    if (this.jdField_a_of_type_Axvo != null) {
      this.jdField_a_of_type_Axvo.a(localaxvt);
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    send(localToServiceMsg);
  }
  
  /* Error */
  protected void b(String paramString, List<CardProfile> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 741 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 2232	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   20: invokevirtual 2238	atmq:createEntityManager	()Latmp;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 5480	atmp:a	()Latmr;
    //   32: invokevirtual 5483	atmr:a	()V
    //   35: aload_2
    //   36: invokeinterface 1104 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 1079 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 1083 1 0
    //   58: checkcast 2529	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 4154	atmp:b	(Latmo;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 999	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 5480	atmp:a	()Latmr;
    //   76: invokevirtual 5500	atmr:b	()V
    //   79: aload_1
    //   80: invokevirtual 3922	atmp:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 5480	atmp:a	()Latmr;
    //   88: invokevirtual 5499	atmr:c	()V
    //   91: aload_1
    //   92: invokevirtual 5480	atmp:a	()Latmr;
    //   95: invokevirtual 5500	atmr:b	()V
    //   98: aload_1
    //   99: invokevirtual 3922	atmp:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 5480	atmp:a	()Latmr;
    //   108: invokevirtual 5500	atmr:b	()V
    //   111: aload_1
    //   112: invokevirtual 3922	atmp:a	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ajfi
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List<CardProfile>
    // Exception table:
    //   from	to	target	type
    //   28	42	67	java/lang/Exception
    //   42	64	67	java/lang/Exception
    //   84	91	67	java/lang/Exception
    //   28	42	103	finally
    //   42	64	103	finally
    //   68	72	103	finally
    //   84	91	103	finally
  }
  
  public void b(ArrayList<MedalID> paramArrayList)
  {
    Iterator localIterator;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("reportMedalWallRead, ");
      if (paramArrayList != null)
      {
        localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          MedalWallMng.a((MedalID)localIterator.next(), (StringBuilder)localObject);
        }
      }
      QLog.i("MedalWallMng", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    do
    {
      return;
      localObject = new cmd0xac6.ReqBody();
      localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        MedalID localMedalID = (MedalID)localIterator.next();
        if (localMedalID != null)
        {
          cmd0xac6.MedalReport localMedalReport = new cmd0xac6.MedalReport();
          localMedalReport.uint32_id.set(localMedalID.jdField_a_of_type_Int);
          localMedalReport.uint32_level.set(localMedalID.jdField_b_of_type_Int);
          ((cmd0xac6.ReqBody)localObject).rpt_medals.add(localMedalReport);
        }
      }
    } while (((cmd0xac6.ReqBody)localObject).rpt_medals.isEmpty());
    Object localObject = makeOIDBPkg("OidbSvc.0xac6", 2758, 2, ((cmd0xac6.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("medal_wall_list", paramArrayList);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(List<Long> paramList)
  {
    bace.a(this.app.c() + "_todayVoters", paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setPCActiveState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPCActiveState ex", localException);
      }
      s = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCallTabState open=" + paramBoolean1);
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.app.a().a();
        int j = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(19);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean1 == true)
        {
          s = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(azzz.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
          if (j >= 2) {
            continue;
          }
          localByteBuffer.putShort((short)i);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean1);
          ((ToServiceMsg)localObject2).extraData.putBoolean("calltabstate", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        short s;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCallTabState ex", localException);
      }
      s = 1;
      continue;
      i = 1;
    }
  }
  
  public boolean b()
  {
    return this.app.getApp().getSharedPreferences("task_entry_config" + this.app.getCurrentAccountUin(), 0).getBoolean("open", false);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSigninRedTouch svrType=" + paramInt);
    }
    cmd0x922.ReqBody localReqBody = new cmd0x922.ReqBody();
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    localReqBody.uint64_timestamp.set(localSharedPreferences.getLong("sign_in_time_stamp", 0L));
    sendPbReq(makeOIDBPkg("OidbSvc.0x922", 2338, paramInt, localReqBody.toByteArray()));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetSimpleNearbyMyTab, result=" + i);
    }
    if (i == 0)
    {
      if (paramToServiceMsg.stPansocialInfo.has())
      {
        i = ((Oidb_0x66b.RspPansocialInfo)paramToServiceMsg.stPansocialInfo.get()).uint32_charmlevel.get();
        ((HotChatManager)this.app.getManager(60)).a(i);
      }
      return;
    }
    notifyUI(65, false, null);
  }
  
  public void c(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "retry upload size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " path:" + this.jdField_b_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_b_of_type_JavaLangString);
      }
      this.app.a(new CardHandler.5(this));
      return;
    }
  }
  
  public void c(List<Long> paramList)
  {
    Object localObject = bace.a(this.app.c() + "_todayVoters");
    if ((localObject != null) && ((localObject instanceof ArrayList)))
    {
      localObject = (List)localObject;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        paramList.addAll((Collection)localObject);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "setCareBarEnable: invoked.  enable: " + paramBoolean);
    }
    notifyUI(102, true, Boolean.valueOf(paramBoolean));
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23234).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("CardHandler", 2, "setCareBarEnable: failed. ", localException);
      }
      s = 1;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getSimpleCardInfoForLogin");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)-25217));
    localArrayList.add(Short.valueOf((short)-23754));
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23723));
    localArrayList.add(Short.valueOf((short)27055));
    localArrayList.add(Short.valueOf((short)-23776));
    localArrayList.add(Short.valueOf((short)-23488));
    localArrayList.add(Short.valueOf((short)27034));
    localArrayList.add(Short.valueOf((short)-23753));
    localArrayList.add(Short.valueOf((short)-25200));
    localArrayList.add(Short.valueOf((short)-23533));
    localArrayList.add(Short.valueOf((short)-23537));
    localArrayList.add(Short.valueOf((short)-22556));
    localArrayList.add(Short.valueOf((short)27059));
    localArrayList.add(Short.valueOf((short)-25019));
    localArrayList.add(Short.valueOf((short)-23306));
    localArrayList.add(Short.valueOf((short)27206));
    localArrayList.add(Short.valueOf((short)27210));
    localArrayList.add(Short.valueOf((short)-23543));
    if (this.app.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      localArrayList.add(Short.valueOf((short)-25040));
    }
    if (((Integer)asfc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
      localArrayList.add(Short.valueOf((short)-23549));
    }
    localArrayList.add(Short.valueOf((short)-23538));
    localArrayList.add(Short.valueOf((short)-25042));
    localArrayList.add(Short.valueOf((short)-25181));
    localArrayList.add(Short.valueOf((short)-23502));
    localArrayList.add(Short.valueOf((short)-23461));
    localArrayList.add(Short.valueOf((short)-25188));
    localArrayList.add(Short.valueOf((short)-23282));
    localArrayList.add(Short.valueOf((short)-25155));
    localArrayList.add(Short.valueOf((short)-23456));
    localArrayList.add(Short.valueOf((short)-23366));
    localArrayList.add(Short.valueOf((short)-23365));
    localArrayList.add(Short.valueOf((short)-23364));
    localArrayList.add(Short.valueOf((short)-23322));
    localArrayList.add(Short.valueOf((short)-23326));
    localArrayList.add(Short.valueOf((short)-23325));
    akhf localakhf = (akhf)this.app.getManager(199);
    if ((localakhf != null) && (localakhf.a()))
    {
      localArrayList.add(Short.valueOf((short)-23437));
      localArrayList.add(Short.valueOf((short)20015));
    }
    localArrayList.add(Short.valueOf((short)27245));
    localArrayList.add(Short.valueOf((short)-23332));
    localArrayList.add(Short.valueOf((short)-23251));
    localArrayList.add(Short.valueOf((short)-23238));
    localArrayList.add(Short.valueOf((short)-23308));
    localArrayList.add(Short.valueOf((short)-23309));
    localArrayList.add(Short.valueOf((short)-23310));
    localArrayList.add(Short.valueOf((short)-23311));
    localArrayList.add(Short.valueOf((short)-23312));
    localArrayList.add(Short.valueOf((short)-23261));
    localArrayList.add(Short.valueOf((short)-23249));
    localArrayList.add(Short.valueOf((short)-23221));
    a(localArrayList, null);
  }
  
  public void d(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting settingValue=" + paramInt + "  oldValue:" + i);
    }
    if (i != paramInt)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("e_add_friend_setting", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  /* Error */
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +419 -> 432
    //   16: aload_3
    //   17: ifnull +415 -> 432
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 97
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 6332
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +538 -> 608
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 110	[B
    //   92: checkcast 110	[B
    //   95: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +335 -> 438
    //   106: iload 5
    //   108: istore 6
    //   110: iload 5
    //   112: istore 7
    //   114: aload_2
    //   115: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: ifne +317 -> 438
    //   124: iconst_1
    //   125: istore 5
    //   127: iload 5
    //   129: istore 6
    //   131: iload 5
    //   133: istore 7
    //   135: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +55 -> 193
    //   141: iload 5
    //   143: istore 6
    //   145: iload 5
    //   147: istore 7
    //   149: ldc_w 607
    //   152: iconst_2
    //   153: new 20	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 6334
    //   163: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: ldc_w 6336
    //   174: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_2
    //   178: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 5
    //   195: istore 8
    //   197: iload 5
    //   199: ifeq +409 -> 608
    //   202: iload 5
    //   204: istore 6
    //   206: iload 5
    //   208: istore 7
    //   210: iload 5
    //   212: istore 8
    //   214: aload_2
    //   215: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   221: ifeq +387 -> 608
    //   224: iload 5
    //   226: istore 6
    //   228: iload 5
    //   230: istore 7
    //   232: iload 5
    //   234: istore 8
    //   236: aload_2
    //   237: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   243: ifnull +365 -> 608
    //   246: iload 5
    //   248: istore 6
    //   250: iload 5
    //   252: istore 7
    //   254: aload_2
    //   255: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   261: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   264: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   267: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   270: istore 4
    //   272: iload 4
    //   274: i2l
    //   275: lstore 12
    //   277: iload 4
    //   279: ifge +16 -> 295
    //   282: iload 4
    //   284: ldc_w 939
    //   287: iand
    //   288: i2l
    //   289: ldc2_w 940
    //   292: lor
    //   293: lstore 12
    //   295: iload 5
    //   297: istore 6
    //   299: iload 5
    //   301: istore 7
    //   303: aload_0
    //   304: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   307: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   310: lload 12
    //   312: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   315: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +126 -> 444
    //   321: iload 5
    //   323: istore 6
    //   325: iload 5
    //   327: istore 7
    //   329: aload_1
    //   330: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   333: ldc_w 672
    //   336: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   339: istore 5
    //   341: iload 5
    //   343: istore 6
    //   345: iload 10
    //   347: istore 5
    //   349: iload 5
    //   351: istore 7
    //   353: iload 6
    //   355: istore 8
    //   357: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +58 -> 418
    //   363: ldc_w 607
    //   366: iconst_2
    //   367: new 20	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 6334
    //   377: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload 5
    //   382: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   385: ldc_w 619
    //   388: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   395: ldc_w 672
    //   398: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   401: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: iload 6
    //   412: istore 8
    //   414: iload 5
    //   416: istore 7
    //   418: aload_0
    //   419: bipush 82
    //   421: iload 7
    //   423: iload 8
    //   425: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   428: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   431: return
    //   432: iconst_0
    //   433: istore 5
    //   435: goto -412 -> 23
    //   438: iconst_0
    //   439: istore 5
    //   441: goto -314 -> 127
    //   444: iconst_0
    //   445: istore 5
    //   447: iload 11
    //   449: istore 6
    //   451: goto -102 -> 349
    //   454: astore_2
    //   455: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +14 -> 472
    //   461: ldc_w 607
    //   464: iconst_2
    //   465: ldc_w 6338
    //   468: aload_2
    //   469: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   472: iload 6
    //   474: istore 7
    //   476: iload 9
    //   478: istore 8
    //   480: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq -65 -> 418
    //   486: ldc_w 607
    //   489: iconst_2
    //   490: new 20	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 6334
    //   500: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: iload 6
    //   505: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   508: ldc_w 619
    //   511: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_1
    //   515: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   518: ldc_w 672
    //   521: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   524: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: iload 6
    //   535: istore 7
    //   537: iload 9
    //   539: istore 8
    //   541: goto -123 -> 418
    //   544: astore_2
    //   545: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +50 -> 598
    //   551: ldc_w 607
    //   554: iconst_2
    //   555: new 20	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 6334
    //   565: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload 7
    //   570: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   573: ldc_w 619
    //   576: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   583: ldc_w 672
    //   586: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   589: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   592: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: aload_2
    //   599: athrow
    //   600: astore_2
    //   601: iload 6
    //   603: istore 7
    //   605: goto -60 -> 545
    //   608: iload 8
    //   610: istore 5
    //   612: iload 11
    //   614: istore 6
    //   616: goto -267 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	ajfi
    //   0	619	1	paramToServiceMsg	ToServiceMsg
    //   0	619	2	paramFromServiceMsg	FromServiceMsg
    //   0	619	3	paramObject	Object
    //   270	18	4	i	int
    //   21	590	5	bool1	boolean
    //   75	540	6	bool2	boolean
    //   79	525	7	bool3	boolean
    //   66	543	8	bool4	boolean
    //   4	534	9	bool5	boolean
    //   1	345	10	bool6	boolean
    //   7	606	11	bool7	boolean
    //   275	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	454	java/lang/Exception
    //   114	124	454	java/lang/Exception
    //   135	141	454	java/lang/Exception
    //   149	193	454	java/lang/Exception
    //   214	224	454	java/lang/Exception
    //   236	246	454	java/lang/Exception
    //   254	272	454	java/lang/Exception
    //   303	321	454	java/lang/Exception
    //   329	341	454	java/lang/Exception
    //   81	102	544	finally
    //   114	124	544	finally
    //   135	141	544	finally
    //   149	193	544	finally
    //   214	224	544	finally
    //   236	246	544	finally
    //   254	272	544	finally
    //   303	321	544	finally
    //   329	341	544	finally
    //   455	472	600	finally
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    oidb_0xa28.ReqBody localReqBody = new oidb_0xa28.ReqBody();
    localReqBody.uint64_request_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.uint32_sourceID.set(0);
    localReqBody.uint32_sourceSubID.set(0);
    sendPbReq(makeOIDBPkg("OidbSvc.0xa28", 2600, 0, localReqBody.toByteArray()));
  }
  
  public void d(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setHelloLiveMessageState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("helloLiveMessage", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setHelloLiveMessageState ex", localException);
      }
      s = 1;
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23437));
    localArrayList.add(Short.valueOf((short)20015));
    a(localArrayList, null);
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool6 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag success=" + bool2);
      }
      this.app.getCurrentAccountUin();
      bool1 = bool2;
      bool4 = bool7;
      if (bool2)
      {
        bool3 = bool2;
        bool5 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool3 = bool2;
        bool5 = bool2;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool5 = bool2;
          QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool2 + "resultCode=" + paramFromServiceMsg.uint32_result.get());
        }
        bool1 = bool2;
        bool4 = bool7;
        if (bool2)
        {
          bool1 = bool2;
          bool4 = bool7;
          bool3 = bool2;
          bool5 = bool2;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool1 = bool2;
            bool4 = bool7;
            bool3 = bool2;
            bool5 = bool2;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool2;
              bool5 = bool2;
              int i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
              long l = i;
              if (i < 0) {
                l = i & 0x7FFFFFFF | 0x80000000;
              }
              bool3 = bool2;
              bool5 = bool2;
              if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
                continue;
              }
              bool3 = bool2;
              bool5 = bool2;
              bool4 = paramToServiceMsg.extraData.getBoolean("switch");
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        bool5 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool5 = bool4;
          bool2 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool5 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag ex", paramFromServiceMsg);
        bool2 = bool3;
        bool5 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool2 = bool3;
        bool5 = bool6;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool5 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      notifyUI(109, bool2, Boolean.valueOf(bool5));
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool1 = false;
      bool4 = bool7;
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianMaster");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25176));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isQidianMaster", true);
      a(localArrayList, localBundle, paramString, 160);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQidianMaster ex", paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setShowPushNotice open=" + paramBoolean);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
      Object localObject = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      if (paramBoolean) {
        s = 0;
      }
      ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23332).putShort((short)2).putShort(s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("uint32_req_push_notice_flag", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotise", 2, "type -23332open :" + s);
      }
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("Q.profilecard.", 2, localException, new Object[0]);
    }
  }
  
  public void f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)-23408));
    localArrayList.add(Short.valueOf((short)-23213));
    localArrayList.add(Short.valueOf((short)-23196));
    localArrayList.add(Short.valueOf((short)-23364));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +403 -> 416
    //   16: aload_3
    //   17: ifnull +399 -> 416
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 97
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 6379
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +522 -> 592
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 110	[B
    //   92: checkcast 110	[B
    //   95: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +319 -> 422
    //   106: iload 5
    //   108: istore 6
    //   110: iload 5
    //   112: istore 7
    //   114: aload_2
    //   115: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: ifne +301 -> 422
    //   124: iconst_1
    //   125: istore 5
    //   127: iload 5
    //   129: istore 6
    //   131: iload 5
    //   133: istore 7
    //   135: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +39 -> 177
    //   141: iload 5
    //   143: istore 6
    //   145: iload 5
    //   147: istore 7
    //   149: ldc_w 607
    //   152: iconst_2
    //   153: new 20	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 6381
    //   163: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: iload 5
    //   179: istore 8
    //   181: iload 5
    //   183: ifeq +409 -> 592
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 7
    //   194: iload 5
    //   196: istore 8
    //   198: aload_2
    //   199: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   205: ifeq +387 -> 592
    //   208: iload 5
    //   210: istore 6
    //   212: iload 5
    //   214: istore 7
    //   216: iload 5
    //   218: istore 8
    //   220: aload_2
    //   221: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +365 -> 592
    //   230: iload 5
    //   232: istore 6
    //   234: iload 5
    //   236: istore 7
    //   238: aload_2
    //   239: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   254: istore 4
    //   256: iload 4
    //   258: i2l
    //   259: lstore 12
    //   261: iload 4
    //   263: ifge +16 -> 279
    //   266: iload 4
    //   268: ldc_w 939
    //   271: iand
    //   272: i2l
    //   273: ldc2_w 940
    //   276: lor
    //   277: lstore 12
    //   279: iload 5
    //   281: istore 6
    //   283: iload 5
    //   285: istore 7
    //   287: aload_0
    //   288: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   294: lload 12
    //   296: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +126 -> 428
    //   305: iload 5
    //   307: istore 6
    //   309: iload 5
    //   311: istore 7
    //   313: aload_1
    //   314: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   317: ldc_w 672
    //   320: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   323: istore 5
    //   325: iload 5
    //   327: istore 6
    //   329: iload 10
    //   331: istore 5
    //   333: iload 5
    //   335: istore 7
    //   337: iload 6
    //   339: istore 8
    //   341: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +58 -> 402
    //   347: ldc_w 607
    //   350: iconst_2
    //   351: new 20	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 6381
    //   361: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 5
    //   366: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   369: ldc_w 619
    //   372: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   379: ldc_w 672
    //   382: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   385: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   388: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 6
    //   396: istore 8
    //   398: iload 5
    //   400: istore 7
    //   402: aload_0
    //   403: bipush 80
    //   405: iload 7
    //   407: iload 8
    //   409: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   412: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   415: return
    //   416: iconst_0
    //   417: istore 5
    //   419: goto -396 -> 23
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -298 -> 127
    //   428: iconst_0
    //   429: istore 5
    //   431: iload 11
    //   433: istore 6
    //   435: goto -102 -> 333
    //   438: astore_2
    //   439: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +14 -> 456
    //   445: ldc_w 607
    //   448: iconst_2
    //   449: ldc_w 6383
    //   452: aload_2
    //   453: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: iload 6
    //   458: istore 7
    //   460: iload 9
    //   462: istore 8
    //   464: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq -65 -> 402
    //   470: ldc_w 607
    //   473: iconst_2
    //   474: new 20	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 6381
    //   484: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload 6
    //   489: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: ldc_w 619
    //   495: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   502: ldc_w 672
    //   505: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   508: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   511: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: iload 6
    //   519: istore 7
    //   521: iload 9
    //   523: istore 8
    //   525: goto -123 -> 402
    //   528: astore_2
    //   529: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +50 -> 582
    //   535: ldc_w 607
    //   538: iconst_2
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 6381
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 7
    //   554: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: ldc_w 619
    //   560: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   567: ldc_w 672
    //   570: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   573: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_2
    //   583: athrow
    //   584: astore_2
    //   585: iload 6
    //   587: istore 7
    //   589: goto -60 -> 529
    //   592: iload 8
    //   594: istore 5
    //   596: iload 11
    //   598: istore 6
    //   600: goto -267 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	ajfi
    //   0	603	1	paramToServiceMsg	ToServiceMsg
    //   0	603	2	paramFromServiceMsg	FromServiceMsg
    //   0	603	3	paramObject	Object
    //   254	18	4	i	int
    //   21	574	5	bool1	boolean
    //   75	524	6	bool2	boolean
    //   79	509	7	bool3	boolean
    //   66	527	8	bool4	boolean
    //   4	518	9	bool5	boolean
    //   1	329	10	bool6	boolean
    //   7	590	11	bool7	boolean
    //   259	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	438	java/lang/Exception
    //   114	124	438	java/lang/Exception
    //   135	141	438	java/lang/Exception
    //   149	177	438	java/lang/Exception
    //   198	208	438	java/lang/Exception
    //   220	230	438	java/lang/Exception
    //   238	256	438	java/lang/Exception
    //   287	305	438	java/lang/Exception
    //   313	325	438	java/lang/Exception
    //   81	102	528	finally
    //   114	124	528	finally
    //   135	141	528	finally
    //   149	177	528	finally
    //   198	208	528	finally
    //   220	230	528	finally
    //   238	256	528	finally
    //   287	305	528	finally
    //   313	325	528	finally
    //   439	456	584	finally
  }
  
  public void f(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setPartakeLikeRankingList OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetPartakeLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPartakeLikeRankingList ex", localException);
      }
      s = 1;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getProfileSwitches");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(39);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)16);
    ((ByteBuffer)localObject).putShort((short)-25223);
    ((ByteBuffer)localObject).putShort((short)-25222);
    ((ByteBuffer)localObject).putShort((short)-23247);
    ((ByteBuffer)localObject).putShort((short)-23364);
    ((ByteBuffer)localObject).putShort((short)-23408);
    ((ByteBuffer)localObject).putShort((short)-23213);
    ((ByteBuffer)localObject).putShort((short)-23196);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = true;
    boolean bool5 = false;
    boolean bool1;
    int i;
    int j;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i = paramToServiceMsg.extraData.getInt("hidden_session_switch", 0);
      j = paramToServiceMsg.extraData.getInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes success=" + bool1 + " type=" + j + " open=" + i);
      }
      bool2 = bool1;
      if (!bool1) {
        break label817;
      }
      bool3 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        long l;
        if (paramToServiceMsg != null)
        {
          bool3 = bool1;
          bool4 = bool1;
          if (paramToServiceMsg.uint32_result.get() == 0)
          {
            bool1 = true;
            bool3 = bool1;
            bool4 = bool1;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              bool4 = bool1;
              QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + bool1);
            }
            bool2 = bool1;
            if (!bool1) {
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (!paramToServiceMsg.bytes_bodybuffer.has()) {
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            l = azzz.a(ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
            bool3 = bool1;
            bool4 = bool1;
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool2 = bool1;
            if (i < 0) {
              break label817;
            }
            if (j != 42318) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool1;
            paramToServiceMsg = this.app.c();
            bool3 = bool1;
            bool4 = bool1;
            paramFromServiceMsg = this.app.getApp().getApplicationContext();
            if (i == 1) {
              continue;
            }
            bool2 = bool6;
            bool3 = bool1;
            bool4 = bool1;
            ajyy.a(paramToServiceMsg, paramFromServiceMsg, bool2);
            bool2 = bool1;
            return;
            bool1 = false;
            break;
          }
        }
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = bool1;
        if (j == 42319)
        {
          bool3 = bool1;
          bool4 = bool1;
          paramToServiceMsg = this.app.c();
          bool3 = bool1;
          bool4 = bool1;
          paramFromServiceMsg = this.app.getApp().getApplicationContext();
          if (i != 1)
          {
            bool2 = bool7;
            bool3 = bool1;
            bool4 = bool1;
            ajyy.b(paramToServiceMsg, paramFromServiceMsg, bool2);
            bool2 = bool1;
            continue;
            bool2 = bool5;
            bool3 = bool1;
            bool4 = bool1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool1;
            QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes cur:" + this.app.getCurrentAccountUin() + " dwUin:" + l);
            bool2 = bool5;
          }
        }
        else
        {
          continue;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool4 = bool3;
        if (QLog.isColorLevel())
        {
          bool4 = bool3;
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes ex", paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + false + ";open=" + i + " type=" + j);
        }
        notifyUI(108, false, Integer.valueOf(j));
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + bool4 + ";open=" + i + " type=" + j);
        }
        notifyUI(108, bool4, Integer.valueOf(j));
      }
      label817:
      bool2 = false;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    short s = 0;
    QLog.e("vip_pretty.CardHandler", 1, "setPrettyTroopOwnerFlag OPEN=" + paramBoolean);
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        localOIDBSSOPkg.str_client_version.set(AppSetting.f());
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23211).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("setPrettyTroopOwnerFlag", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPrettyTroopOwnerFlag ex", localException);
      }
      s = 1;
    }
  }
  
  public void h()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  /* Error */
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +435 -> 439
    //   7: aload_3
    //   8: ifnull +431 -> 439
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 607
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 6421
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 6113
    //   55: ldc_w 327
    //   58: invokevirtual 836	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_2
    //   62: aload_1
    //   63: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   66: ldc_w 835
    //   69: ldc_w 327
    //   72: invokevirtual 836	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 11
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: ifeq +281 -> 364
    //   86: iload 5
    //   88: istore 7
    //   90: iload 5
    //   92: istore 8
    //   94: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 110	[B
    //   105: checkcast 110	[B
    //   108: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_3
    //   115: aload_3
    //   116: ifnull +329 -> 445
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_3
    //   128: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +311 -> 445
    //   137: iconst_1
    //   138: istore 5
    //   140: iload 5
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: ldc_w 607
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 6423
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 6
    //   194: iload 5
    //   196: ifeq +168 -> 364
    //   199: iload 5
    //   201: istore 6
    //   203: iload 5
    //   205: istore 7
    //   207: iload 5
    //   209: istore 8
    //   211: aload_3
    //   212: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +146 -> 364
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: iload 5
    //   231: istore 8
    //   233: aload_3
    //   234: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +124 -> 364
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_3
    //   252: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   267: invokestatic 901	azzz:a	(I)J
    //   270: lstore 9
    //   272: iload 5
    //   274: istore 7
    //   276: iload 5
    //   278: istore 8
    //   280: aload_0
    //   281: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   284: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   287: lload 9
    //   289: invokestatic 545	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   292: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +156 -> 451
    //   298: iload 5
    //   300: istore 7
    //   302: iload 5
    //   304: istore 8
    //   306: aload_1
    //   307: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   310: ldc_w 6111
    //   313: ldc_w 939
    //   316: invokevirtual 6392	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   319: istore 4
    //   321: iload 5
    //   323: istore 6
    //   325: iload 4
    //   327: iflt +37 -> 364
    //   330: iload 5
    //   332: istore 7
    //   334: iload 5
    //   336: istore 8
    //   338: aload_0
    //   339: getfield 559	ajfi:mApp	Lcom/tencent/common/app/AppInterface;
    //   342: invokevirtual 818	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   345: invokevirtual 821	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   348: aconst_null
    //   349: ldc_w 845
    //   352: ldc_w 847
    //   355: iload 4
    //   357: invokestatic 853	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   360: iload 5
    //   362: istore 6
    //   364: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +50 -> 417
    //   370: ldc_w 607
    //   373: iconst_2
    //   374: new 20	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 6423
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 6
    //   389: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc_w 619
    //   395: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   402: ldc_w 672
    //   405: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   408: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   411: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: bipush 96
    //   420: iload 6
    //   422: iconst_2
    //   423: anewarray 254	java/lang/String
    //   426: dup
    //   427: iconst_0
    //   428: aload_2
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: aload 11
    //   434: aastore
    //   435: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   438: return
    //   439: iconst_0
    //   440: istore 5
    //   442: goto -428 -> 14
    //   445: iconst_0
    //   446: istore 5
    //   448: goto -308 -> 140
    //   451: iload 5
    //   453: istore 7
    //   455: iload 5
    //   457: istore 8
    //   459: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +55 -> 517
    //   465: iload 5
    //   467: istore 7
    //   469: iload 5
    //   471: istore 8
    //   473: ldc_w 607
    //   476: iconst_2
    //   477: new 20	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 6425
    //   487: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: invokevirtual 450	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   497: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: ldc_w 905
    //   503: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 9
    //   508: invokevirtual 711	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: iconst_0
    //   518: istore 6
    //   520: goto -156 -> 364
    //   523: astore_3
    //   524: iload 7
    //   526: istore 8
    //   528: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +18 -> 549
    //   534: iload 7
    //   536: istore 8
    //   538: ldc_w 607
    //   541: iconst_2
    //   542: ldc_w 6427
    //   545: aload_3
    //   546: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +49 -> 601
    //   555: ldc_w 607
    //   558: iconst_2
    //   559: new 20	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 6423
    //   569: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: iconst_0
    //   573: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: ldc_w 619
    //   579: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_1
    //   583: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   586: ldc_w 672
    //   589: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   592: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   595: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_0
    //   602: bipush 96
    //   604: iconst_0
    //   605: iconst_2
    //   606: anewarray 254	java/lang/String
    //   609: dup
    //   610: iconst_0
    //   611: aload_2
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload 11
    //   617: aastore
    //   618: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   621: return
    //   622: astore_3
    //   623: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +50 -> 676
    //   629: ldc_w 607
    //   632: iconst_2
    //   633: new 20	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 6423
    //   643: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload 8
    //   648: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   651: ldc_w 619
    //   654: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_1
    //   658: getfield 351	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   661: ldc_w 672
    //   664: invokevirtual 676	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   667: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: aload_0
    //   677: bipush 96
    //   679: iload 8
    //   681: iconst_2
    //   682: anewarray 254	java/lang/String
    //   685: dup
    //   686: iconst_0
    //   687: aload_2
    //   688: aastore
    //   689: dup
    //   690: iconst_1
    //   691: aload 11
    //   693: aastore
    //   694: invokevirtual 174	ajfi:notifyUI	(IZLjava/lang/Object;)V
    //   697: aload_3
    //   698: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	ajfi
    //   0	699	1	paramToServiceMsg	ToServiceMsg
    //   0	699	2	paramFromServiceMsg	FromServiceMsg
    //   0	699	3	paramObject	Object
    //   319	37	4	i	int
    //   12	458	5	bool1	boolean
    //   79	440	6	bool2	boolean
    //   88	447	7	bool3	boolean
    //   92	588	8	bool4	boolean
    //   270	237	9	l	long
    //   75	617	11	str	String
    // Exception table:
    //   from	to	target	type
    //   94	115	523	java/lang/Exception
    //   127	137	523	java/lang/Exception
    //   148	154	523	java/lang/Exception
    //   162	190	523	java/lang/Exception
    //   211	221	523	java/lang/Exception
    //   233	243	523	java/lang/Exception
    //   251	272	523	java/lang/Exception
    //   280	298	523	java/lang/Exception
    //   306	321	523	java/lang/Exception
    //   338	360	523	java/lang/Exception
    //   459	465	523	java/lang/Exception
    //   473	517	523	java/lang/Exception
    //   94	115	622	finally
    //   127	137	622	finally
    //   148	154	622	finally
    //   162	190	622	finally
    //   211	221	622	finally
    //   233	243	622	finally
    //   251	272	622	finally
    //   280	298	622	finally
    //   306	321	622	finally
    //   338	360	622	finally
    //   459	465	622	finally
    //   473	517	622	finally
    //   528	534	622	finally
    //   538	549	622	finally
  }
  
  public void h(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setNotifyOnLikeRankingList OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetNotifyOnLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setNotifyOnLikeRankingList ex", localException);
      }
      s = 1;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getPCActiveState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25042));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("pcActiveState", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getPCActiveState ex", localException);
    }
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleSetDisplayThirdQQSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label550;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool1 + ",pkg.uint32_result.get() = " + paramFromServiceMsg.uint32_result.get());
        }
        bool4 = bool1;
        if (!bool1) {
          break label550;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label550;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label550;
        }
        bool2 = bool1;
        bool3 = bool1;
        int i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool1 = this.app.getCurrentAccountUin().equals(String.valueOf(l));
        if (!bool1) {
          continue;
        }
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      notifyUI(81, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label550:
      bool1 = bool4;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setLoginDaysSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getCareBarEnable");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-23234));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("setCareBarEnable", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CardHandler", 2, "getCareBarEnable: failed. ", localException);
    }
  }
  
  /* Error */
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: ifnull +413 -> 417
    //   7: aload_2
    //   8: invokevirtual 2033	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   11: sipush 1000
    //   14: if_icmpne +403 -> 417
    //   17: iconst_1
    //   18: istore 7
    //   20: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +27 -> 50
    //   26: ldc 97
    //   28: iconst_2
    //   29: iconst_2
    //   30: anewarray 403	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 6459
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: iload 7
    //   43: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: invokestatic 791	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   50: iconst_m1
    //   51: istore 4
    //   53: iload 7
    //   55: istore 8
    //   57: iload 7
    //   59: ifeq +526 -> 585
    //   62: iload 7
    //   64: istore 9
    //   66: iload 7
    //   68: istore 8
    //   70: iload 4
    //   72: istore 5
    //   74: new 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 108	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 110	[B
    //   85: checkcast 110	[B
    //   88: invokevirtual 114	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +327 -> 423
    //   99: iload 7
    //   101: istore 9
    //   103: iload 7
    //   105: istore 8
    //   107: iload 4
    //   109: istore 5
    //   111: aload_1
    //   112: getfield 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 123	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: ifne +305 -> 423
    //   121: iconst_1
    //   122: istore 7
    //   124: iload 7
    //   126: istore 9
    //   128: iload 7
    //   130: istore 8
    //   132: iload 4
    //   134: istore 5
    //   136: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +39 -> 178
    //   142: iload 7
    //   144: istore 9
    //   146: iload 7
    //   148: istore 8
    //   150: iload 4
    //   152: istore 5
    //   154: ldc 97
    //   156: iconst_2
    //   157: iconst_2
    //   158: anewarray 403	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: ldc_w 6461
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: iload 7
    //   171: invokestatic 555	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   174: aastore
    //   175: invokestatic 791	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   178: iload 7
    //   180: ifeq +380 -> 560
    //   183: iload 7
    //   185: istore 9
    //   187: iload 7
    //   189: istore 8
    //   191: iload 4
    //   193: istore 5
    //   195: aload_1
    //   196: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 134	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +358 -> 560
    //   205: iload 7
    //   207: istore 9
    //   209: iload 7
    //   211: istore 8
    //   213: iload 4
    //   215: istore 5
    //   217: aload_1
    //   218: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   221: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   224: ifnull +336 -> 560
    //   227: iload 7
    //   229: istore 9
    //   231: iload 7
    //   233: istore 8
    //   235: iload 4
    //   237: istore 5
    //   239: aload_1
    //   240: getfield 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   246: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   249: invokestatic 365	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   252: astore_1
    //   253: iload 7
    //   255: istore 9
    //   257: iload 7
    //   259: istore 8
    //   261: iload 4
    //   263: istore 5
    //   265: aload_1
    //   266: invokevirtual 368	java/nio/ByteBuffer:getInt	()I
    //   269: pop
    //   270: iload 7
    //   272: istore 9
    //   274: iload 7
    //   276: istore 8
    //   278: iload 4
    //   280: istore 5
    //   282: aload_1
    //   283: invokevirtual 371	java/nio/ByteBuffer:get	()B
    //   286: pop
    //   287: iload 7
    //   289: istore 9
    //   291: iload 7
    //   293: istore 8
    //   295: iload 4
    //   297: istore 5
    //   299: aload_1
    //   300: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   303: invokestatic 386	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   306: invokevirtual 617	java/lang/Short:shortValue	()S
    //   309: iconst_1
    //   310: if_icmpne +240 -> 550
    //   313: iload 7
    //   315: istore 9
    //   317: iload 7
    //   319: istore 8
    //   321: iload 4
    //   323: istore 5
    //   325: aload_1
    //   326: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   329: istore 6
    //   331: iload 6
    //   333: sipush -23449
    //   336: if_icmpeq +93 -> 429
    //   339: iconst_m1
    //   340: istore 4
    //   342: iload 10
    //   344: istore 7
    //   346: iload 4
    //   348: istore 5
    //   350: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +45 -> 398
    //   356: ldc 97
    //   358: iconst_2
    //   359: new 20	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 6461
    //   369: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload 7
    //   374: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   377: ldc_w 6463
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 4
    //   385: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 4
    //   396: istore 5
    //   398: aload_0
    //   399: getfield 159	ajfi:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: sipush 218
    //   405: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   408: checkcast 6465	acjd
    //   411: iload 5
    //   413: invokevirtual 6466	acjd:a	(I)V
    //   416: return
    //   417: iconst_0
    //   418: istore 7
    //   420: goto -400 -> 20
    //   423: iconst_0
    //   424: istore 7
    //   426: goto -302 -> 124
    //   429: iload 7
    //   431: istore 9
    //   433: iload 7
    //   435: istore 8
    //   437: iload 4
    //   439: istore 5
    //   441: aload_1
    //   442: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   445: istore 6
    //   447: iload 6
    //   449: iconst_2
    //   450: if_icmpne +90 -> 540
    //   453: iload 7
    //   455: istore 9
    //   457: iload 7
    //   459: istore 8
    //   461: iload 4
    //   463: istore 5
    //   465: iload 6
    //   467: newarray byte
    //   469: astore_2
    //   470: iload 7
    //   472: istore 9
    //   474: iload 7
    //   476: istore 8
    //   478: iload 4
    //   480: istore 5
    //   482: aload_1
    //   483: aload_2
    //   484: invokevirtual 626	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   487: pop
    //   488: iload 7
    //   490: istore 9
    //   492: iload 7
    //   494: istore 8
    //   496: iload 4
    //   498: istore 5
    //   500: aload_2
    //   501: iconst_0
    //   502: invokestatic 631	azzz:a	([BI)S
    //   505: istore 6
    //   507: iload 6
    //   509: istore 5
    //   511: aload_1
    //   512: invokevirtual 375	java/nio/ByteBuffer:getShort	()S
    //   515: istore 6
    //   517: iload 5
    //   519: istore 4
    //   521: iload 10
    //   523: istore 7
    //   525: iload 6
    //   527: ifne -181 -> 346
    //   530: iconst_1
    //   531: istore 7
    //   533: iload 5
    //   535: istore 4
    //   537: goto -191 -> 346
    //   540: iconst_m1
    //   541: istore 4
    //   543: iload 10
    //   545: istore 7
    //   547: goto -201 -> 346
    //   550: iconst_m1
    //   551: istore 4
    //   553: iload 10
    //   555: istore 7
    //   557: goto -211 -> 346
    //   560: iload 7
    //   562: istore 9
    //   564: iload 7
    //   566: istore 8
    //   568: iload 4
    //   570: istore 5
    //   572: ldc 97
    //   574: iconst_1
    //   575: ldc_w 6468
    //   578: invokestatic 1986	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: iload 7
    //   583: istore 8
    //   585: iload 8
    //   587: istore 7
    //   589: goto -243 -> 346
    //   592: astore_1
    //   593: iload 9
    //   595: istore 7
    //   597: iload 7
    //   599: istore 8
    //   601: iload 4
    //   603: istore 5
    //   605: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +34 -> 642
    //   611: iload 7
    //   613: istore 8
    //   615: iload 4
    //   617: istore 5
    //   619: ldc 97
    //   621: iconst_2
    //   622: iconst_2
    //   623: anewarray 403	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: ldc_w 6470
    //   631: aastore
    //   632: dup
    //   633: iconst_1
    //   634: aload_1
    //   635: invokevirtual 1004	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 791	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   642: iload 4
    //   644: istore 5
    //   646: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq -251 -> 398
    //   652: ldc 97
    //   654: iconst_2
    //   655: new 20	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 6461
    //   665: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: iload 7
    //   670: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 6463
    //   676: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: iload 4
    //   681: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: iload 4
    //   692: istore 5
    //   694: goto -296 -> 398
    //   697: astore_1
    //   698: iload 8
    //   700: istore 7
    //   702: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +41 -> 746
    //   708: ldc 97
    //   710: iconst_2
    //   711: new 20	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 6461
    //   721: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: iload 7
    //   726: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   729: ldc_w 6463
    //   732: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: iload 5
    //   737: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_1
    //   747: athrow
    //   748: astore_1
    //   749: goto -47 -> 702
    //   752: astore_1
    //   753: iload 5
    //   755: istore 4
    //   757: goto -160 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	ajfi
    //   0	760	1	paramToServiceMsg	ToServiceMsg
    //   0	760	2	paramFromServiceMsg	FromServiceMsg
    //   0	760	3	paramObject	Object
    //   51	705	4	i	int
    //   72	682	5	j	int
    //   329	197	6	k	int
    //   18	707	7	bool1	boolean
    //   55	644	8	bool2	boolean
    //   64	530	9	bool3	boolean
    //   1	553	10	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   74	95	592	java/lang/Exception
    //   111	121	592	java/lang/Exception
    //   136	142	592	java/lang/Exception
    //   154	178	592	java/lang/Exception
    //   195	205	592	java/lang/Exception
    //   217	227	592	java/lang/Exception
    //   239	253	592	java/lang/Exception
    //   265	270	592	java/lang/Exception
    //   282	287	592	java/lang/Exception
    //   299	313	592	java/lang/Exception
    //   325	331	592	java/lang/Exception
    //   441	447	592	java/lang/Exception
    //   465	470	592	java/lang/Exception
    //   482	488	592	java/lang/Exception
    //   500	507	592	java/lang/Exception
    //   572	581	592	java/lang/Exception
    //   74	95	697	finally
    //   111	121	697	finally
    //   136	142	697	finally
    //   154	178	697	finally
    //   195	205	697	finally
    //   217	227	697	finally
    //   239	253	697	finally
    //   265	270	697	finally
    //   282	287	697	finally
    //   299	313	697	finally
    //   325	331	697	finally
    //   441	447	697	finally
    //   465	470	697	finally
    //   482	488	697	finally
    //   500	507	697	finally
    //   572	581	697	finally
    //   605	611	697	finally
    //   619	642	697	finally
    //   511	517	748	finally
    //   511	517	752	java/lang/Exception
  }
  
  public void j(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_c_of_type_Short).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetCalReactiveDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getHelloLiveMessageState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25181));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("helloLiveMessage", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getHelloLiveMessageState ex", localException);
    }
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    long l3;
    MedalWallMng localMedalWallMng;
    long l2;
    label245:
    do
    {
      do
      {
        return;
        str = paramToServiceMsg.extraData.getString("uin", "");
        l3 = paramToServiceMsg.extraData.getLong("ts", 0L);
        paramToServiceMsg = new cmd0x7a8.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "handleGetFriendMedalNews " + i + "|" + str + "|" + l3);
        }
        localMedalWallMng = (MedalWallMng)this.app.getManager(250);
      } while (i != 0);
      if (paramToServiceMsg.uint32_now.has()) {
        l1 = paramToServiceMsg.uint32_now.get();
      }
      if (!paramToServiceMsg.rpt_msg_medal.has()) {
        break;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_medal.get();
      localObject = (ajjj)this.app.getManager(51);
      paramObject = ((ajjj)localObject).a(str);
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new ExtensionInfo();
        paramFromServiceMsg.uin = str;
      }
      if ((l1 > l3) && (paramToServiceMsg != null) && (paramToServiceMsg.size() != 0)) {
        break label346;
      }
      if (l1 <= l3) {
        break label328;
      }
      l2 = l1;
      paramFromServiceMsg.medalUpdateTimestamp = l2;
      ((ajjj)localObject).a(paramFromServiceMsg);
    } while (!QLog.isColorLevel());
    paramFromServiceMsg = new StringBuilder().append("handleGetFriendMedalNews no update lastTs:").append(l3).append(" nowTs:").append(l1).append(" size:");
    if (paramToServiceMsg == null) {}
    for (int i = 0;; i = paramToServiceMsg.size())
    {
      QLog.i("MedalWallMng", 2, i);
      return;
      paramToServiceMsg = null;
      break;
      label328:
      l2 = l3;
      break label245;
    }
    label346:
    paramFromServiceMsg.lastMedalTimestamp = l1;
    paramFromServiceMsg.medalUpdateTimestamp = l1;
    ((ajjj)localObject).a(paramFromServiceMsg);
    paramObject = (common.MedalInfo)paramToServiceMsg.get(paramToServiceMsg.size() - 1);
    i = paramObject.uint32_fromuin_level.get();
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetFriendMedalNews my level " + i);
    }
    Object localObject = new JSONObject();
    int j;
    for (;;)
    {
      try
      {
        j = paramObject.uint32_level.get();
        if (j <= 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CardHandler", 2, "handleGetFriendMedalNews level not right" + j);
          return;
        }
      }
      catch (JSONException paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CardHandler", 2, "handleGetFriendMedalNews", paramToServiceMsg);
        return;
        ((JSONObject)localObject).put("name", paramObject.str_name.get());
        ((JSONObject)localObject).put("level", j);
        ((JSONObject)localObject).put("myLevel", i);
        paramToServiceMsg = new JSONArray(paramObject.str_resource.get());
        if (j <= 3) {
          break label621;
        }
        i = 1;
        paramFromServiceMsg = ((JSONObject)paramToServiceMsg.get(i)).optString("owned3d", "");
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          break label628;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CardHandler", 2, "handleGetFriendMedalNews iconUrl is null");
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CardHandler", 2, "handleGetFriendMedalNews", paramToServiceMsg);
      return;
      label621:
      i = j;
    }
    label628:
    paramToServiceMsg = paramFromServiceMsg;
    if (!paramFromServiceMsg.startsWith("http:")) {
      paramToServiceMsg = "http://" + paramFromServiceMsg;
    }
    ((JSONObject)localObject).put("icon", paramToServiceMsg);
    switch (j)
    {
    }
    for (;;)
    {
      paramToServiceMsg = paramObject.str_desc.get();
      l2 = paramObject.uint64_time.get();
      l1 = paramObject.uint32_seq.get();
      for (;;)
      {
        ((JSONObject)localObject).put("ts", l2);
        ((JSONObject)localObject).put("desc", paramToServiceMsg);
        ((JSONObject)localObject).put("seq", l1);
        ((JSONObject)localObject).put("id", paramObject.uint32_id.get());
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleGetFriendMedalNews insert gray msg");
        }
        localMedalWallMng.a(((JSONObject)localObject).toString(), str, l2);
        return;
        paramToServiceMsg = paramObject.str_desc.get();
        l2 = paramObject.uint64_time.get();
        l1 = paramObject.uint32_seq.get();
        continue;
        paramToServiceMsg = paramObject.str_desc_level2.get();
        l2 = paramObject.uint64_time_level2.get();
        l1 = paramObject.uint32_seq_level2.get();
        continue;
        paramToServiceMsg = paramObject.str_desc_level3.get();
        l2 = paramObject.uint64_time_level3.get();
        l1 = paramObject.uint32_seq_level3.get();
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setMedalSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort(this.d).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("uint32_req_medalwall_flag", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setMedalSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void l()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_flag_hide_pretty_group_owner_identity.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42326", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getPartekeLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_partake_like_ranking_list_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_40350", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
    }
  }
  
  public void m(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setBabyQSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort(this.e).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetBabyQSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          if (paramBoolean) {
            this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setBabyQSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("SummaryCard.ReqSummaryCard");
      this.allowCmdSet.add("SummaryCard.ReqVoiceManage");
      this.allowCmdSet.add("MCardSvc.ReqHYMakeFriendsCard");
      this.allowCmdSet.add("MCardSvc.ReqSetCard");
      this.allowCmdSet.add("SummaryCard.SetLabel");
      this.allowCmdSet.add("SummaryCard.LikeIt");
      this.allowCmdSet.add("MCardSvc.ReqGetCardSwitch");
      this.allowCmdSet.add("MCardSvc.ReqSetCardSwitch");
      this.allowCmdSet.add("VisitorSvc.ReqVote");
      this.allowCmdSet.add("VisitorSvc.ReqDeleteVisitorRecord");
      this.allowCmdSet.add("VisitorSvc.ReqFavorite");
      this.allowCmdSet.add("VisitorSvc.ReqGetVoterList");
      this.allowCmdSet.add("VisitorSvc.ReqGetFavoriteList");
      this.allowCmdSet.add("MCardSvc.ReqFaceInfo");
      this.allowCmdSet.add("MCardSvc.ReqAddFace");
      this.allowCmdSet.add("MCardSvc.ReqUpdateIntro");
      this.allowCmdSet.add("MCardSvc.ReqDelFace");
      this.allowCmdSet.add("ProfileService.getGroupInfoReq");
      this.allowCmdSet.add("ProfileService.GetSglUsrFullInfo");
      this.allowCmdSet.add("ProfileService.SetUserInfoReq");
      this.allowCmdSet.add("AccostSvc.ClientMsg");
      this.allowCmdSet.add("AccostSvc.SvrMsg");
      this.allowCmdSet.add("MobileQQ.SendPortraitDownloadVerifyCode");
      this.allowCmdSet.add("MCardSvc.ReqPicSafetyCheck");
      this.allowCmdSet.add("MCardSvc.ReqGetFace");
      this.allowCmdSet.add("PttCenterSvr.ReqBody");
      this.allowCmdSet.add("OidbSvc.0x490_100");
      this.allowCmdSet.add("OidbSvc.0x491_100");
      this.allowCmdSet.add("SQQzoneSvc.getCover");
      this.allowCmdSet.add("SQQzoneSvc.getPhotoWall");
      this.allowCmdSet.add("SQQzoneSvc.delPhotoWall");
      this.allowCmdSet.add("OidbSvc.0x480_9");
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x5ea_2");
      this.allowCmdSet.add("OidbSvc.0x5ea_3");
      this.allowCmdSet.add("OidbSvc.0x5ea_4");
      this.allowCmdSet.add("PubAccountSvc.get_detail_info");
      this.allowCmdSet.add("OidbSvc.0xcf8");
      this.allowCmdSet.add("SQQShopFolderSvc.GetAcctBindPuin");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("OidbSvc.0x5eb_22");
      this.allowCmdSet.add("OidbSvc.0x5eb_15");
      this.allowCmdSet.add("OidbSvc.0x7ba");
      this.allowCmdSet.add("OidbSvc.0x5eb_42092");
      this.allowCmdSet.add("OidbSvc.0x5eb_40350");
      this.allowCmdSet.add("OidbSvc.0x922");
      this.allowCmdSet.add("OidbSvc.0x923");
      this.allowCmdSet.add("OidbSvc.0xa28");
      this.allowCmdSet.add("OidbSvc.0xac6");
      this.allowCmdSet.add("OidbSvc.0x7a8");
      this.allowCmdSet.add("OidbSvc.0xc33_42220");
      this.allowCmdSet.add("OidbSvc.0xcd5");
      this.allowCmdSet.add("OidbSvc.0xd8a");
      this.allowCmdSet.add("OidbSvc.0xd2d");
      this.allowCmdSet.add("OidbSvc.0x4ff_42315");
      this.allowCmdSet.add("OidbSvc.0x5eb_42326");
      this.allowCmdSet.add("OidbSvc.0x5eb_15(2)");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotifyOnLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_on_like_ranking_list_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42092", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_42092 error", localException);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setDisplayThirdQQSwitch OPEN=" + paramBoolean);
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      if (paramBoolean == true) {
        s = 0;
      }
      Object localObject = new byte[13];
      bakz.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      bakz.a((byte[])localObject, 5, (short)1);
      bakz.a((byte[])localObject, 7, 40348);
      bakz.a((byte[])localObject, 9, (short)2);
      bakz.a((byte[])localObject, 11, s);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetDisplayThirdQQSwitch", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(81, false, null);
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetLoginDays", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
    }
  }
  
  public void o(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setAllowStrangerInviteToGroupSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23282).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("StrangerInviteToGroup", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setAllowStrangerInviteToGroupSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return ajfo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        localObject2 = new Bundle();
                        ((Bundle)localObject2).putString("uin", (String)localObject1);
                        if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          if (paramToServiceMsg.extraData.getBoolean("simpleinfo_pull", false))
                          {
                            q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          k(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          j(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("VisitorSvc.ReqDeleteVisitorRecord".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          e(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          h(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          g(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
                          {
                            if (((RespUpdateIntro)paramObject).stHeader.iReplyCode == 0)
                            {
                              notifyUI(9, true, ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin()));
                              return;
                            }
                            notifyUI(9, false, localObject2);
                            return;
                          }
                          notifyUI(9, false, localObject2);
                          return;
                        }
                        if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          if (paramFromServiceMsg.getResultCode() == 1000)
                          {
                            notifyUI(17, true, ((ajjj)this.app.getManager(51)).c(paramToServiceMsg.getUin()));
                            return;
                          }
                          notifyUI(17, false, localObject2);
                          return;
                        }
                        if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                        {
                          t(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                          return;
                        }
                        if (!"AccostSvc.ClientMsg".equals(paramFromServiceMsg.getServiceCmd())) {
                          break;
                        }
                      } while (paramFromServiceMsg.getResultCode() != 1000);
                      paramToServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
                    } while ((paramToServiceMsg == null) || (1 != paramToServiceMsg.stMsg.eAccostType));
                    notifyUI(22, true, localObject2);
                    return;
                    if ("AccostSvc.SvrMsg".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      if (paramFromServiceMsg.getResultCode() == 1000) {}
                      for (boolean bool = true;; bool = false)
                      {
                        notifyUI(29, bool, localObject2);
                        return;
                      }
                    }
                    if ("MobileQQ.SendPortraitDownloadVerifyCode".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      paramToServiceMsg = paramFromServiceMsg.extraData.getString("filekey");
                      ((Bundle)localObject2).putString("filekey", paramToServiceMsg);
                      if ((paramToServiceMsg != null) && (!"".equals(paramToServiceMsg)))
                      {
                        notifyUI(21, true, localObject2);
                        return;
                      }
                      notifyUI(21, false, localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      ((Bundle)localObject2).putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
                      if (paramFromServiceMsg.getResultCode() == 1000)
                      {
                        notifyUI(23, true, localObject2);
                        return;
                      }
                      notifyUI(23, false, localObject2);
                      return;
                    }
                    if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                      return;
                    }
                  } while ("PttCenterSvr.ReqBody".equals(paramFromServiceMsg.getServiceCmd()));
                  if ("OidbSvc.0x490_100".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("OidbSvc.0x491_100".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    m(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("SQQzoneSvc.getPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if ("SQQzoneSvc.delPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
                  {
                    r(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (!"OidbSvc.0x480_9".equals(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
                if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false))
                {
                  F(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
                {
                  s(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
                {
                  w(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isGetActivateFriend", false))
                {
                  Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isQidianExt", false))
                {
                  W(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isGetCalReactive", false))
                {
                  G(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isGetBabyQSwitch", false))
                {
                  S(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isQidianMaster", false))
                {
                  X(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isGetCommonSwitchFromDetailInfo", false))
                {
                  C(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isOfficeUserFlag", false))
                {
                  j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("setCareBarEnable", false))
                {
                  ag(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                o(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
                if (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
                  break;
                }
              } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
              if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
              {
                H(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
              {
                t(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
              {
                v(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
              {
                R(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("from_send_no_disturb", false))
              {
                h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("from_send_hidden_session", false))
              {
                g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("calltabstate", false))
              {
                V(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
              {
                U(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
              {
                I(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetBabyQSwitch"))
              {
                T(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
              {
                J(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("StrangerInviteToGroup", false))
              {
                ad(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetNotifyOnLikeRankingList", false))
              {
                f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetDisplayThirdQQSwitch", false))
              {
                i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetPartakeLikeRankingList", false))
              {
                d(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("isSetCommonSwitchFromDetailInfo", false))
              {
                D(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("uint32_req_push_notice_flag", false))
              {
                x(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("tempConversationBlocState", false))
              {
                u(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if (paramToServiceMsg.extraData.getBoolean("setPrettyTroopOwnerFlag", false))
              {
                e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              n(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            } while ("OidbSvc.0x5ea_2".equals(paramFromServiceMsg.getServiceCmd()));
            if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
            {
              c(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (("PubAccountSvc.get_detail_info".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0xcf8".equals(paramFromServiceMsg.getServiceCmd())))
            {
              b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("SQQShopFolderSvc.GetAcctBindPuin".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x5eb_22".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
            {
              K(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramToServiceMsg.extraData.getBoolean("uint32_req_allow", false))
            {
              P(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("uint32_do_not_disturb_mode_time", false));
          O(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          if ("OidbSvc.0x5eb_15".equals(paramFromServiceMsg.getServiceCmd()))
          {
            if (paramToServiceMsg.extraData.getBoolean("sendGlobalRingIdRequest", false))
            {
              M(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            N(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7ba".equals(paramFromServiceMsg.getServiceCmd()))
          {
            f(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
            return;
          }
          if ("OidbSvc.0x5eb_42092".equals(paramFromServiceMsg.getServiceCmd()))
          {
            E(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x5eb_42326".equals(paramFromServiceMsg.getServiceCmd()))
          {
            y(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x5eb_40350".equals(paramFromServiceMsg.getServiceCmd()))
          {
            z(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x922".equals(paramFromServiceMsg.getServiceCmd()))
          {
            B(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while ("OidbSvc.0x923".equals(paramFromServiceMsg.getServiceCmd()));
        if ("OidbSvc.0xa28".equals(paramFromServiceMsg.getServiceCmd()))
        {
          A(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"OidbSvc.0x7a8".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        localObject1 = paramToServiceMsg.extraData.getString("from", "");
        if (((String)localObject1).equalsIgnoreCase("getSelfNewObtainedMedalWall"))
        {
          Y(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (!((String)localObject1).equalsIgnoreCase("getFriendMedalNews"));
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("OidbSvc.0xac6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        Z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc33_42220".equals(paramFromServiceMsg.getServiceCmd()))
      {
        aa(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcd5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("isGetList", false))
        {
          ab(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        ac(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd8a".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ae(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd2d".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ah(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42315".equals(paramFromServiceMsg.getServiceCmd()))
      {
        af(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5eb_15(2)".equals(paramFromServiceMsg.getServiceCmd()));
    L(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_c_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetCalReactive", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch ex", localException);
    }
  }
  
  public void p(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip_ptt.CardHandler", 2, "setPttAuToTextOffLineSwitch:" + vms.a(30));
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(3466);
        localOIDBSSOPkg.uint32_service_type.set(21);
        localOIDBSSOPkg.uint32_result.set(0);
        Object localObject1 = new cmd0xd8a.ReqBody();
        ((cmd0xd8a.ReqBody)localObject1).uint64_uin.set(l);
        Object localObject2 = ((cmd0xd8a.ReqBody)localObject1).uint32_cmd;
        if (paramBoolean)
        {
          i = 101;
          ((PBUInt32Field)localObject2).set(i);
          localObject2 = new cmd0xd8a.ClientInfo();
          ((cmd0xd8a.ClientInfo)localObject2).uint32_implat.set(109);
          ((cmd0xd8a.ClientInfo)localObject2).string_clientver.set(AppSetting.f());
          ((cmd0xd8a.ReqBody)localObject1).client_info.set((MessageMicro)localObject2);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xd8a.ReqBody)localObject1).toByteArray()));
          localObject1 = createToServiceMsg("OidbSvc.0xd8a");
          ((ToServiceMsg)localObject1).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject1).setTimeout(30000L);
          ((ToServiceMsg)localObject1).extraData.putBoolean("uint32_auto_to_text_flag", paramBoolean);
          sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_ptt.CardHandler", 1, "setMedalSwitch ex", localException);
      }
      i = 102;
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getConnectionsSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
      localReqBody.uint32_req_connections_switch_id.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_15(2)", 1515, 15, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getConnectionsSwitch ex", localException);
    }
  }
  
  public void q(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setEmotionRecommendSwitch!");
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(azzz.a(l)).put((byte)0).putShort((short)1).putShort((short)-23221).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_42315");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("uint32_emotion_recommend_flag", paramBoolean);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 1, "setEmotionRecommendSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getHiddenSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      localReqBody.uint32_req_hidden_session_switch.set(1);
      localReqBody.uint32_req_hidden_session_video_switch.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getHiddenSwitch ex", localException);
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::sendGlobalRingIdRequest");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_global_ring_id.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("sendGlobalRingIdRequest", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "sendGlobalRingIdRequest ex ", localException);
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotDisturb");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_do_not_disturb_mode_time.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("source_from", "not_disturb_from_cardhandler");
      localBundle.putBoolean("uint32_do_not_disturb_mode_time", true);
      ((ToServiceMsg)localObject).extraData.putAll(localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getNotDisturb ex", localException);
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getSelfAddFriendSetting");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_allow.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("uint32_req_allow", true);
      localBundle.putString("reqUin", this.app.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putAll(localBundle);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getSelfAddFriendSetting ex", localException);
    }
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25031));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetActivateFriend", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch ex", localException);
    }
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getBabyQSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.e));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetBabyQSwitch", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getBabyQSwitch ex", localException);
    }
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getOfficeUserFlag");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-23449));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isOfficeUserFlag", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQimOldUserFlag ex", localException);
    }
  }
  
  public void y()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
    }
    try
    {
      l = Long.parseLong(this.app.getCurrentAccountUin());
      if (l == 0L) {
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      Object localObject = new cmd0x7a8.ReqBody();
      ((cmd0x7a8.ReqBody)localObject).uint64_req_uin.set(l);
      ((cmd0x7a8.ReqBody)localObject).uint32_sort_type.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_obtained.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_new.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("from", "getSelfNewObtainedMedalWall");
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23370));
    a(localArrayList, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajfi
 * JD-Core Version:    0.7.0.1
 */