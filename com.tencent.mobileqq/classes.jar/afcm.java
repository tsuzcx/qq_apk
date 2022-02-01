import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.PoiMapActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class afcm
{
  private static int jdField_a_of_type_Int = -1;
  private static andd jdField_a_of_type_Andd;
  public static String a;
  public static String b;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int a(SessionInfo paramSessionInfo)
  {
    if (AlbumUtil.isVideoUinType(paramSessionInfo.curType)) {}
    for (int i = 5;; i = 6)
    {
      if (nmy.a().a(paramSessionInfo.curFriendUin)) {
        i = 1;
      }
      return i;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent1, Intent paramIntent2)
  {
    int i = -1;
    Object localObject;
    if ((paramIntent1 == null) || (!paramIntent1.hasExtra("showFlashPic")))
    {
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      paramIntent2.putExtra("showFlashPic", amrp.a(paramSessionInfo.curType, (HotChatManager)localObject, paramSessionInfo.troopUin));
    }
    paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    int j;
    boolean bool2;
    boolean bool1;
    if ((!(paramActivity instanceof SplashActivity)) && (!(paramActivity instanceof ChatActivity)) && (!(paramActivity instanceof LiteActivity)))
    {
      paramIntent2.putExtras(paramActivity.getIntent());
      paramIntent2.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      if (paramIntent1 == null) {
        break label1122;
      }
      i = paramIntent1.getIntExtra("peakconstant.request_code", -1);
      paramIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent1.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      j = paramIntent1.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent1.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent1.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int k = paramIntent1.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (k == 1039) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (k == 1040) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      paramIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", paramIntent1.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.copyReportInfo(paramIntent1, paramIntent2);
      paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", paramIntent1.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false));
      paramIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", paramIntent1.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false));
      paramIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent1.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      paramIntent2.putExtra("fromPhotoListPanel", paramIntent1.getBooleanExtra("fromPhotoListPanel", false));
      paramIntent2.putExtra("KEY_IS_ANONYMOUS", paramIntent1.getBooleanExtra("KEY_IS_ANONYMOUS", false));
      paramIntent2.putExtra("PhotoConst.SEND_NO_PRESEND", paramIntent1.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false));
    }
    for (;;)
    {
      if ((paramSessionInfo.curType == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.curFriendUin))) {
        paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
      }
      if (paramSessionInfo.curType == 9501) {
        paramIntent2.putExtra("isdevicesupportmultiupload", true);
      }
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      paramIntent2.putExtra("filter_photolist_troopalbum_toolbar", bool1);
      paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      paramIntent2.putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      paramIntent2.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramIntent2.putExtra("album_enter_directly", true);
      paramIntent2.putExtra("ALBUM_ID", AlbumUtil.getLastAlbumId(paramActivity));
      paramIntent2.putExtra("ALBUM_NAME", AlbumUtil.getLastAlbumName(paramActivity));
      paramIntent2.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramIntent2.putExtra("uin", paramSessionInfo.curFriendUin);
      paramIntent2.putExtra("uintype", paramSessionInfo.curType);
      paramIntent2.putExtra("troop_uin", paramSessionInfo.troopUin);
      paramIntent2.putExtra("uinname", paramSessionInfo.curFriendNick);
      paramIntent2.putExtra("entrance", paramSessionInfo.entrance);
      paramIntent2.putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        paramIntent2.putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().isBack2Root);
      }
      paramIntent2.putExtra("is_anonymous", nmy.a().a(paramSessionInfo.curFriendUin));
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      paramIntent2.getExtras().remove("forward_type");
      if ((paramIntent1 != null) && (paramIntent1.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
      {
        paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        paramIntent2.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        paramIntent2.putExtra("session_info", paramSessionInfo);
        paramIntent2.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(azux.b(paramQQAppInterface), j));
      }
      paramIntent2.putExtra("session_info", paramSessionInfo);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        paramIntent2.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + paramIntent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + j);
      }
      return i;
      paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localObject = paramIntent2;
      if ((paramActivity instanceof SplashActivity)) {
        localObject = AIOUtils.setOpenAIOIntent(paramIntent2, null);
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
      if (paramSessionInfo.curType == 9501)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        ((Intent)localObject).putExtra(bftk.h, 80);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        paramIntent2 = (aara)paramQQAppInterface.getBusinessHandler(51);
        long l1;
        if ((paramIntent2 != null) && (paramIntent2.a())) {
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(paramSessionInfo.curFriendUin);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (paramIntent2.a(l1, 1)) {
          ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        }
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2 = (Intent)localObject;
        break;
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("key_confess_topicid", paramSessionInfo.topicId);
      }
      label1122:
      bool1 = false;
      bool2 = false;
      j = 20;
    }
  }
  
  private static afcv a(akct paramakct)
  {
    int i;
    String str;
    if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramakct.jdField_a_of_type_Int)) == null)
    {
      i = 1;
      str = String.valueOf(2);
      switch (paramakct.jdField_a_of_type_Int)
      {
      case 4: 
      case 5: 
      default: 
        paramakct = "";
      }
    }
    for (;;)
    {
      afcv localafcv = new afcv(null);
      localafcv.jdField_a_of_type_JavaLangString = str;
      localafcv.jdField_a_of_type_Int = i;
      localafcv.jdField_b_of_type_JavaLangString = paramakct;
      return localafcv;
      i = ((Integer)RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramakct.jdField_a_of_type_Int))).intValue();
      break;
      str = String.valueOf(1);
      paramakct = "13140";
      continue;
      str = String.valueOf(2);
      paramakct = "13141";
      continue;
      paramakct = "13142";
      continue;
      paramakct = "13146";
      continue;
      paramakct = "13147";
      continue;
      paramakct = "";
      i = 1;
    }
  }
  
  private static afcw a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = 1;
    int j = 1;
    Object localObject2 = "";
    Object localObject1 = (ajul)paramQQAppInterface.getManager(125);
    if (localObject1 != null) {}
    for (localObject1 = ((ajul)localObject1).a();; localObject1 = "")
    {
      if (paramSessionInfo.curType == 0)
      {
        i = 1;
        paramQQAppInterface = "entrance.click.c2c";
        paramSessionInfo = (SessionInfo)localObject2;
      }
      for (;;)
      {
        localObject2 = new afcw(null);
        ((afcw)localObject2).jdField_b_of_type_JavaLangString = paramQQAppInterface;
        ((afcw)localObject2).jdField_a_of_type_Int = j;
        ((afcw)localObject2).jdField_b_of_type_Int = i;
        ((afcw)localObject2).jdField_a_of_type_JavaLangString = paramSessionInfo;
        ((afcw)localObject2).c = ((String)localObject1);
        return localObject2;
        if (paramSessionInfo.curType == 3000)
        {
          j = ((amrb)paramQQAppInterface.getManager(53)).a(paramSessionInfo.curFriendUin);
          paramQQAppInterface = "entrance.click.group";
          i = 2;
          paramSessionInfo = (SessionInfo)localObject2;
        }
        else
        {
          if (paramSessionInfo.curType == 1)
          {
            Object localObject3 = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramSessionInfo.curFriendUin);
            j = i;
            if (localObject3 != null)
            {
              j = ((TroopInfo)localObject3).wMemberNum;
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanelUtils", 2, "troop uin：" + paramSessionInfo.curFriendUin + " people_num：" + j);
              }
            }
            if (QWalletHelper.isNeedUpdateTroopMemberNum(paramSessionInfo.curFriendUin)) {}
            try
            {
              long l = Long.parseLong(paramSessionInfo.curFriendUin);
              localObject3 = (anca)paramQQAppInterface.getBusinessHandler(20);
              if (jdField_a_of_type_Andd == null) {
                jdField_a_of_type_Andd = new afco(paramSessionInfo);
              }
              paramQQAppInterface.addObserver(jdField_a_of_type_Andd);
              ((anca)localObject3).b(l, 32, 0);
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("angelzhuang", 2, "群uin：" + paramSessionInfo.curFriendUin + " 解析失败");
                  continue;
                  i = 3;
                }
              }
            }
            localObject3 = (HotChatManager)paramQQAppInterface.getManager(60);
            if ((localObject3 != null) && (((HotChatManager)localObject3).b(paramSessionInfo.curFriendUin)))
            {
              bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
              i = 6;
              paramQQAppInterface = "entrance.click.chatgroup";
              paramSessionInfo = (SessionInfo)localObject2;
              continue;
            }
          }
          if (paramSessionInfo.curType == 1000)
          {
            i = 4;
            paramQQAppInterface = "entrance.click.c2c";
            paramSessionInfo = paramSessionInfo.troopUin;
          }
          else if (paramSessionInfo.curType == 1004)
          {
            i = 5;
            paramQQAppInterface = "entrance.click.c2c";
            paramSessionInfo = paramSessionInfo.troopUin;
          }
          else
          {
            if ((paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002) || (paramSessionInfo.curType == 10004))
            {
              if (paramSessionInfo.curType == 10004)
              {
                paramSessionInfo = paramQQAppInterface.getMsgCache().m(paramSessionInfo.curFriendUin);
                label506:
                if (paramSessionInfo == null) {
                  break label574;
                }
              }
              label574:
              for (paramSessionInfo = bfuc.encodeToString(paramSessionInfo, 2);; paramSessionInfo = "")
              {
                bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
                paramQQAppInterface = "entrance.click.c2c";
                i = 7;
                break;
                paramSessionInfo = paramQQAppInterface.getMsgCache().n(paramSessionInfo.curFriendUin);
                break label506;
              }
            }
            paramQQAppInterface = "";
            i = 0;
            paramSessionInfo = (SessionInfo)localObject2;
          }
        }
      }
    }
  }
  
  private static Intent a(akct paramakct)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    localIntent.putExtra("isFromPanel", true);
    if ((paramakct != null) && (paramakct.jdField_a_of_type_Int == 3)) {
      if (paramakct.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label96;
      }
    }
    label96:
    for (paramakct = paramakct.jdField_a_of_type_OrgJsonJSONObject.optString("theme_id", "");; paramakct = "")
    {
      localIntent.putExtra("theme_type", paramakct);
      localIntent.putExtra("theme", true);
      return localIntent;
    }
  }
  
  public static String a()
  {
    return a(AppConstants.SDCARD_IMG_CAMERA);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(((Calendar)localObject).get(1));
    int j = ((Calendar)localObject).get(2) + 1;
    if (j < 10)
    {
      paramString = "0" + j;
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(5);
      if (j >= 10) {
        break label322;
      }
      paramString = "0" + j;
      label115:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(11);
      if (j >= 10) {
        break label330;
      }
      paramString = "0" + j;
      label157:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(12);
      if (j >= 10) {
        break label338;
      }
      paramString = "0" + j;
      label199:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(13);
      if (j >= 10) {
        break label346;
      }
      paramString = "0" + j;
      label241:
      localStringBuilder.append(paramString);
      if (!paramBoolean) {
        break label354;
      }
    }
    label322:
    label330:
    label338:
    label346:
    label354:
    for (paramString = ".mp4";; paramString = ".jpg")
    {
      if (new File(localStringBuilder.toString() + paramString).exists()) {
        break label361;
      }
      return localStringBuilder.toString() + paramString;
      paramString = Integer.valueOf(j);
      break;
      paramString = Integer.valueOf(j);
      break label115;
      paramString = Integer.valueOf(j);
      break label157;
      paramString = Integer.valueOf(j);
      break label199;
      paramString = Integer.valueOf(j);
      break label241;
    }
    label361:
    localObject = new StringBuilder(localStringBuilder);
    j = localStringBuilder.length();
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(paramString);
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("enter_from", 1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = AIOUtils.setOpenAIOIntent(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra("fromPhotoListPanel", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20 - paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    localIntent.putExtra("ALBUM_ID", AlbumUtil.getLastAlbumId(paramActivity));
    localIntent.putExtra("ALBUM_NAME", AlbumUtil.getLastAlbumName(paramActivity));
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("input_full_screen_mode", true);
    paramActivity.startActivityForResult(localIntent, 100017);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, afcw paramafcw, afcv paramafcv, SessionInfo paramSessionInfo)
  {
    paramIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + paramafcw.jdField_b_of_type_Int, 0, null));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recv_type", paramafcw.jdField_b_of_type_Int);
      localJSONObject.put("recv_uin", paramSessionInfo.curFriendUin);
      localJSONObject.put("channel", paramafcv.jdField_a_of_type_Int);
      localJSONObject.put("bus_type", paramafcv.jdField_a_of_type_JavaLangString);
      if (paramafcw.jdField_a_of_type_Int > 0) {
        localJSONObject.put("people_num", paramafcw.jdField_a_of_type_Int);
      }
      if (!TextUtils.isEmpty(paramafcw.jdField_a_of_type_JavaLangString)) {
        localJSONObject.put("session_token", paramafcw.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramafcw.c)) {
        localJSONObject.put("placeholder", paramafcw.c);
      }
    }
    catch (JSONException paramafcw)
    {
      for (;;)
      {
        paramafcw.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "click HongBao:params=" + localJSONObject.toString());
    }
    paramIntent.putExtra("extra_data", localJSONObject.toString());
    paramActivity.startActivity(paramIntent);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = paramString.indexOf(':');
        } while (i == -1);
        localObject = paramString.substring(0, i);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = ((String)localObject).toLowerCase();
    } while ((((String)localObject).compareTo("http") != 0) && (((String)localObject).compareTo("https") != 0));
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.isLBSFriendNewClient(paramSessionInfo.curFriendUin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new ayeh(paramSessionInfo.curType, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramQQAppInterface.getAccount(), paramSessionInfo.topicId).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).isVideoChatting())) {}
    for (;;)
    {
      return;
      if (!bftf.a())
      {
        QQToast.a(paramActivity, paramActivity.getResources().getString(2131717955), 0).a();
        return;
      }
      paramAppInterface = AppConstants.SDCARD_IMG_CAMERA;
      boolean bool;
      label56:
      Object localObject;
      if (paramInt2 == 1)
      {
        bool = true;
        paramAppInterface = a(paramAppInterface, bool);
        localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
        localObject = new Intent();
        if (paramInt2 != 0) {
          break label202;
        }
        FileProvider7Helper.setSystemCapture(paramActivity, new File(paramAppInterface), (Intent)localObject);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_camera");
        ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
        ((Intent)localObject).setFlags(536870912);
      }
      try
      {
        paramActivity.startActivityForResult((Intent)localObject, paramInt1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PlusPanelUtils", 2, "enter sys camera");
        return;
        bool = false;
        break label56;
        label202:
        ((Intent)localObject).setAction("android.media.action.VIDEO_CAPTURE");
        ((Intent)localObject).putExtra("output", Uri.fromFile(new File(paramAppInterface)));
        ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface.printStackTrace();
          QQToast.a(paramActivity, 2131690618, 0).a();
        }
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    a(paramBaseActivity.app, paramBaseActivity, paramSessionInfo, null, null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SessionInfo paramSessionInfo, afcw paramafcw, afcv paramafcv)
  {
    if (paramInt == 0)
    {
      agwt.a(paramQQAppInterface, "0X8005CAF", paramSessionInfo.curType);
      if (jdField_a_of_type_Int != 0) {
        break label104;
      }
      paramafcw.jdField_b_of_type_JavaLangString += ".plus";
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramafcw.jdField_b_of_type_JavaLangString, 0, 0, paramafcv.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      if (paramInt != 1) {
        break;
      }
      agwt.a(paramQQAppInterface, "0X8005FC9", paramSessionInfo.curType);
      break;
      label104:
      if (jdField_a_of_type_Int == 1) {
        paramafcw.jdField_b_of_type_JavaLangString += ".quick";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      BaseChatPie localBaseChatPie = ((FragmentActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.createQQMapActivityProxy();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      localIntent.putExtra("sessionType", localBaseChatPie.sessionInfo.curType);
      boolean bool = ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, true, null);
      localIntent.putExtra("int_unread_msgs_num", paramQQAppInterface.getMessageFacade().getUnreadMsgsNum());
      localIntent.putExtra("boolean_is_default_theme", bool);
      paramActivity.startActivityForResult(localIntent, 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("enterQQMap", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    localIntent = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface = (aara)paramQQAppInterface.getBusinessHandler(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localIntent.putExtra("from_aio", true);
        localIntent.addFlags(536870912);
        localIntent.putExtra("selectMode", true);
        localIntent.putExtra("peerType", paramSessionInfo.curType);
        localIntent.putExtra("targetUin", paramSessionInfo.curFriendUin);
        if (paramSessionInfo.curType == 1000) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.troopUin);
        }
        for (;;)
        {
          if (paramSessionInfo.curType != 0) {
            break label358;
          }
          localIntent.putExtra("qfile_entrance_type_key", 1);
          break;
          if (paramSessionInfo.curType == 1006) {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.phoneNum);
          } else {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.realTroopUin);
          }
        }
        if (paramSessionInfo.curType == 3000) {
          localIntent.putExtra("qfile_entrance_type_key", 5);
        } else if (paramSessionInfo.curType == 1) {
          localIntent.putExtra("qfile_entrance_type_key", 3);
        }
      }
    }
    if ((paramSessionInfo.curType == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.curFriendUin);
      localIntent.putExtra("peerType", paramSessionInfo.curType);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.a(l1));
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800L);
      }
      if ((paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 3000) || (paramSessionInfo.curType == 1)) {
        localIntent.putExtra("select_file_support_send_docs_file", aqky.a().a());
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771979, 2130771980);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    bkvx.a(paramQQAppInterface, "tenpay.com", new afcp(paramInt1, paramSessionInfo, paramQQAppInterface, paramInt2, paramString, paramActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (aara)paramQQAppInterface.getBusinessHandler(51);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        localException.printStackTrace();
        continue;
        int i = paramQQAppInterface.a(l1);
      }
    }
    if (paramBoolean)
    {
      i = 2;
      localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.curFriendUin);
      localIntent.putExtra("peerType", paramSessionInfo.curType);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", i);
      localIntent.putExtra("smart_device_switch_tab_flag", paramInt);
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800);
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771979, 2130771980);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, akct paramakct, List<akct> paramList, int paramInt)
  {
    if (paramakct == null) {
      return;
    }
    a(paramList);
    paramList = a(paramQQAppInterface, paramSessionInfo);
    if (a(paramQQAppInterface, paramActivity, paramakct, paramSessionInfo, paramList))
    {
      QLog.i("PlusPanelUtils", 2, "---doSendHbJumpNoEnterSendHbActivity---");
      return;
    }
    afcv localafcv = a(paramakct);
    a(paramActivity, a(paramakct), paramList, localafcv, paramSessionInfo);
    a(paramQQAppInterface, paramInt, paramSessionInfo, paramList, localafcv);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    bcef.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.curFriendUin, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.curType)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.putExtra("url", "https://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.curFriendUin + "&uintype=" + paramSessionInfo.curType + "&_wv=1&entry=aio&_bid=203");
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("hide_left_button", true);
      paramQQAppInterface.putExtra("show_right_close_button", true);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramActivity.startActivity(paramQQAppInterface);
      paramActivity.overridePendingTransition(2130771979, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.curFriendUin).replace("$CurType$", String.valueOf(paramSessionInfo.curType)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramIntent.putExtra("PhotoConst.MY_UIN", paramSessionInfo.uinName);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
      paramIntent.putExtra("KEY_IS_ANONYMOUS", nmy.a().a(paramSessionInfo.curFriendUin));
      localIntent.putExtra("enter_from", 1);
      int i = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, localIntent);
      if (i == -1) {
        paramActivity.startActivity(localIntent);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        AlbumUtil.anim(paramActivity, false, true);
        if (bkkh.a != null) {
          bkkh.a.b();
        }
        return;
        paramQQAppInterface = ajpc.a(paramHashMap);
        if (paramQQAppInterface != null) {
          localIntent.putExtra("PhotoConst.editPathMap", paramQQAppInterface);
        }
        paramActivity.startActivityForResult(localIntent, i);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new afcr(paramSessionInfo, paramQQAppInterface, paramContext, bfvo.b(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (mup.a()) {
      return;
    }
    mup localmup = mup.a(paramContext);
    int[] arrayOfInt = new int[5];
    localmup.a(2131689514);
    if (((paramSessionInfo.curType == 1025) || (paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 1000) || (paramSessionInfo.curType == 1004)) && (((bily)paramQQAppInterface.getManager(165)).d(paramSessionInfo.curFriendUin)))
    {
      arrayOfInt[0] = 5;
      localmup.b(2131697704);
    }
    for (int i = 1;; i = 0)
    {
      arrayOfInt[i] = 1;
      localmup.b(2131719031);
      i += 1;
      arrayOfInt[i] = 2;
      localmup.b(2131719045);
      localmup.c(2131690620);
      localmup.a(new afcn(paramQQAppInterface));
      localmup.a(new afcq(localmup, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
      localmup.show();
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("enterVideo, onlyAudio[").append(paramBoolean).append("], type[");
      if (paramSessionInfo == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append("], uin[");
        if (paramSessionInfo != null) {
          break label139;
        }
        localObject1 = null;
        label60:
        QLog.i("PlusPanelUtils", 2, (String)localObject1 + "], from[" + paramString + "]");
      }
    }
    else
    {
      if (!paramBoolean) {
        break label148;
      }
    }
    label139:
    label148:
    for (int i = 1;; i = 2)
    {
      if ((paramSessionInfo == null) || (!paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.curType, paramSessionInfo.curFriendUin))) {
        break label154;
      }
      return;
      localObject1 = Integer.valueOf(paramSessionInfo.curType);
      break;
      localObject1 = paramSessionInfo.curFriendUin;
      break label60;
    }
    label154:
    if (paramBoolean)
    {
      localObject2 = "0X80049C5";
      switch (paramSessionInfo.curType)
      {
      default: 
        localObject1 = "0";
      }
    }
    for (;;)
    {
      bcef.b(paramQQAppInterface, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, (String)localObject1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      localObject2 = "0X80049C7";
      break;
      localObject1 = "0";
      continue;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "6";
      continue;
      localObject1 = "7";
      continue;
      localObject1 = "30";
      continue;
      localObject1 = "4";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter Camera");
    }
    if (AudioHelper.b(0))
    {
      bfur.a(paramContext, 230, paramContext.getString(2131697886), paramContext.getString(2131697887), new afcs(), null).show();
      return;
    }
    if (AudioHelper.a(0))
    {
      bfur.a(paramContext, 230, paramContext.getString(2131697886), paramContext.getString(2131697888), new afct(), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      bfur.a(paramContext, 230, paramContext.getString(2131697886), amtj.a(2131707417), new afcu(), null).show();
      return;
    }
    if (paramInt2 == 0) {}
    for (int i = 1;; i = 17000)
    {
      a(paramQQAppInterface, paramBaseActivity, i, paramInt2);
      aktv.k();
      paramBaseActivity.setCanLock(false);
      if (paramSessionInfo.curType != 9501) {
        break;
      }
      abdm.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.curFriendUin), "Usr_AIO_SendMsg", 2, 0, paramInt1);
      return;
    }
  }
  
  private static void a(List<akct> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      RedPacketManager.CURRENT_PANEL_DATA.clear();
      RedPacketManager.CURRENT_PANEL_DATA.addAll(paramList);
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      bool1 = bool2;
      if (bool2)
      {
        long l = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
          }
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
          bool1 = false;
        }
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
        }
        bool1 = false;
      }
      if (paramSessionInfo.curType != 1001)
      {
        bool2 = bool1;
        if (paramSessionInfo.curType != 10002) {}
      }
      else
      {
        bool2 = bool1;
        if (!paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
          }
          bool2 = true;
        }
      }
      if (paramSessionInfo.curType != 9500)
      {
        paramBoolean = bool2;
        if (paramSessionInfo.curType != 9501) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
        }
        paramBoolean = true;
      }
      paramSessionInfo = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
      bool1 = paramBoolean;
      if (!paramBoolean)
      {
        bool1 = paramBoolean;
        if (paramSessionInfo != null)
        {
          bool1 = paramBoolean;
          if (paramSessionInfo.length() > 0)
          {
            paramSessionInfo = paramSessionInfo.split("\\|");
            bool1 = paramBoolean;
            if (paramSessionInfo.length >= 4)
            {
              bool2 = paramSessionInfo[0].equals("1");
              bool5 = paramSessionInfo[1].equals("1");
              bool6 = paramSessionInfo[2].equals("1");
              bool7 = paramSessionInfo[3].equals("1");
              i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (i)
      {
      default: 
        label392:
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + i + ",enablePreCompress_WIFI:" + bool2 + ", enablePreCompress_2G = " + bool5 + ", enablePreCompress_3G = " + bool6 + ", enablePreCompress_4G = " + bool7 + ", presendOFF  = " + paramBoolean);
          bool1 = paramBoolean;
        }
        if ((bool4) || (bool1)) {
          break;
        }
      }
    }
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + bool4 + ", presendOFF = " + bool1 + ", result  = " + paramBoolean);
      }
      return paramBoolean;
      i = 0;
      break;
      if (!bool2)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool5)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool6)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool7)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, akct paramakct, SessionInfo paramSessionInfo, afcw paramafcw)
  {
    switch (paramakct.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 5: 
      long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
      paramakct = new Intent(paramActivity, QrcodeHbGuiderActivity.class);
      paramakct.putExtra("appInfo", "");
      paramakct.putExtra("vacreport_key_seq", l);
      paramActivity.startActivity(paramakct);
      bcef.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
      return true;
    case 4: 
      if (paramakct.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = paramakct.jdField_a_of_type_OrgJsonJSONObject.optString("url", "");
        QLog.i("PlusPanelUtils", 2, (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return true;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        if (paramakct.jdField_a_of_type_OrgJsonJSONObject.optInt("subtype", 0) == 1) {
          if (((String)localObject).indexOf("?") != -1) {
            break label262;
          }
        }
      }
      for (paramQQAppInterface = (String)localObject + "?recv_uin=" + paramSessionInfo.curFriendUin + "&recv_type=" + paramafcw.jdField_b_of_type_Int;; paramQQAppInterface = (String)localObject + "&recv_uin=" + paramSessionInfo.curFriendUin + "&recv_type=" + paramafcw.jdField_b_of_type_Int)
      {
        a(paramActivity, paramQQAppInterface);
        return true;
      }
    case 12: 
      label262:
      paramakct = paramakct.jdField_a_of_type_OrgJsonJSONObject.optString("schema");
      QLog.i("PlusPanelUtils", 2, paramakct);
      if (TextUtils.isEmpty(paramakct)) {
        return true;
      }
      a(paramQQAppInterface, paramActivity, paramSessionInfo, paramafcw.jdField_b_of_type_Int, paramafcw.jdField_a_of_type_Int, paramakct);
      return true;
    }
    paramakct = paramakct.jdField_a_of_type_OrgJsonJSONObject.optString("schema", "");
    QLog.i("PlusPanelUtils", 2, paramakct);
    if (TextUtils.isEmpty(paramakct)) {
      return true;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("recv_group_type", paramafcw.jdField_b_of_type_Int + "");
    ((Map)localObject).put("recv_group_id", paramSessionInfo.curFriendUin);
    ((Map)localObject).put("send_uin", paramQQAppInterface.getCurrentUin());
    paramQQAppInterface = bkvx.a(paramakct, (Map)localObject, true);
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "[go to miniapp] finalSchame: " + paramQQAppInterface);
    }
    akgc.a(paramActivity, paramQQAppInterface);
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    bkox.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    bkpf.b(paramQQAppInterface, 3, paramSessionInfo.curType);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject = (avsy)paramQQAppInterface.getManager(11);
    String str;
    if (paramSessionInfo.curType == 1006) {
      str = ((avsy)localObject).a(paramSessionInfo.curFriendUin);
    }
    for (localObject = paramSessionInfo.curFriendUin; paramString == null; localObject = ((avsy)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.curType, str, paramSessionInfo.curFriendNick, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.curFriendUin;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.curType, str, paramSessionInfo.curFriendNick, (String)localObject, paramBoolean, paramSessionInfo.troopUin, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("category", 15);
    paramQQAppInterface.putExtra("busiType", 5);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.curType);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.curFriendUin);
    paramQQAppInterface.putExtra("STRING_Show_Music_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Video_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Apk_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Pic_Category", false);
    paramQQAppInterface.putExtra("STRING_SingleSelect", false);
    paramQQAppInterface.putExtra("max_select_count", 5);
    paramQQAppInterface.putExtra(bftk.h, 84);
    paramQQAppInterface.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(paramQQAppInterface, 84);
    AlbumUtil.anim(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcm
 * JD-Core Version:    0.7.0.1
 */