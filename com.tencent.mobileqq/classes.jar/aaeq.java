import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.2;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4;
import com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.8;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aaeq
  extends Handler
{
  public aaeq(TroopMemberApiService paramTroopMemberApiService) {}
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("ALD_CONFIG_RESULT");
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if ((str == null) || (localJSONObject == null)) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopMemberApiService", 2, "handleGetALDConfig result parse error.");
        }
        localObject = null;
      }
      paramBundle.putString("ALD_CONFIG_RESULT", Aladdin.getConfig(localObject.optInt("id")).getString(localObject.optString("key", ""), ""));
      this.a.a(154, paramBundle);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("BUNDLE_KEY_JS_OBJ");
    Object localObject1;
    Parcelable localParcelable;
    int i;
    String str2;
    JSONArray localJSONArray;
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      if ((str1 == null) || (localJSONObject == null)) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult(server) result parse error.");
        localObject1 = null;
      }
      localParcelable = paramBundle.getParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA");
      i = ((JSONObject)localObject1).optInt("biuAfterComment", 0);
      str2 = new String(Base64.decode(((JSONObject)localObject1).optString("comment"), 0));
      localJSONArray = ((JSONObject)localObject1).optJSONArray("linkList");
      if (localJSONArray == null) {
        break label284;
      }
    }
    Object localObject2 = new aaet(this).getType();
    label284:
    for (localObject2 = (List)new Gson().fromJson(localJSONArray.toString(), (Type)localObject2);; localObject2 = null)
    {
      int j = ((JSONObject)localObject1).optInt("feedsType");
      paramBundle = new aaeu(this, (JSONObject)localObject1, str2, localJSONArray, paramBundle);
      if ((localParcelable instanceof FirstCommentCreateData))
      {
        localObject1 = (FirstCommentCreateData)localParcelable;
        ((FirstCommentCreateData)localObject1).a(str2);
        ((FirstCommentCreateData)localObject1).a((List)localObject2);
        localObject2 = pgv.a;
        if (i == 1) {}
        for (bool = true;; bool = false)
        {
          ((pgv)localObject2).a((FirstCommentCreateData)localObject1, paramBundle, str1, j, false, bool);
          return;
        }
      }
      if (!(localParcelable instanceof SubCommentCreateData)) {
        break;
      }
      localObject1 = (SubCommentCreateData)localParcelable;
      ((SubCommentCreateData)localObject1).d(str2);
      ((SubCommentCreateData)localObject1).a((List)localObject2);
      localObject2 = pgv.a;
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((pgv)localObject2).a((SubCommentCreateData)localObject1, paramBundle, str1, j, false, bool);
        return;
      }
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)TroopMemberApiService.d(this.a);
    Object localObject3 = ((awyz)TroopMemberApiService.e(this.a).getManager(QQManagerFactory.CONTACT_MANAGER)).a();
    String str1 = "";
    Object localObject2 = "";
    if (localObject3 != null) {
      str1 = ((RespondQueryQQBindingStat)localObject3).mobileNo;
    }
    String str2 = ((QQAppInterface)localObject1).getCurrentNickname();
    localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getString("cur_city", null);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((String)localObject3).split("-");
      localObject1 = localObject2;
      if (localObject3.length > 0)
      {
        localObject2 = localObject3[0];
        localObject1 = localObject2;
        if (localObject3.length < 2) {}
      }
    }
    for (localObject1 = localObject3[1];; localObject1 = localObject3)
    {
      paramBundle.putString("phone", str1);
      paramBundle.putString("name", str2);
      paramBundle.putString("city", (String)localObject2);
      paramBundle.putString("area", (String)localObject1);
      return;
      localObject3 = "";
      localObject2 = localObject1;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject8 = TroopMemberApiService.c(this.a);
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if ((localObject8 instanceof QQAppInterface))
    {
      localObject5 = (anrb)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      localObject6 = (anxi)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
      localObject1 = (aoep)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    }
    if ((paramMessage == null) || (localObject8 == null) || (!(localObject8 instanceof QQAppInterface))) {}
    Object localObject7;
    do
    {
      return;
      localObject7 = paramMessage.getData();
    } while (localObject7 == null);
    ((Bundle)localObject7).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    label760:
    int i;
    int j;
    long l1;
    boolean bool;
    long l2;
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    case 5: 
    case 10: 
    case 14: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 33: 
    case 40: 
    case 43: 
    case 48: 
    case 49: 
    case 50: 
    case 57: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 68: 
    case 78: 
    case 79: 
    case 83: 
    case 89: 
    case 90: 
    case 91: 
    case 109: 
    case 112: 
    case 123: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    default: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    case 147: 
    case 34: 
    case 41: 
    case 75: 
    case 73: 
    case 70: 
    case 38: 
    case 35: 
    case 36: 
    case 120: 
    case 153: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.jdField_b_of_type_AndroidOsMessenger = paramMessage.replyTo;
        if (paramMessage.obj != null)
        {
          localObject1 = ((Bundle)paramMessage.obj).getString("processName");
          if (localObject1 != null)
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramMessage.replyTo);
            continue;
            this.a.jdField_b_of_type_AndroidOsMessenger = null;
            if (paramMessage.obj != null)
            {
              localObject1 = ((Bundle)paramMessage.obj).getString("processName");
              if (localObject1 != null)
              {
                this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
                continue;
                this.a.jdField_a_of_type_Aobq = new aobq(((AppRuntime)localObject8).getAccount());
                continue;
                localObject1 = ((Bundle)localObject7).getString("gcode");
                localObject5 = String.valueOf(8000000);
                localObject6 = nty.a().a((String)localObject1, (String)localObject5);
                if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  this.a.a((String)localObject1, (String)localObject5, ((AppRuntime)localObject8).getAccount(), (String)localObject6);
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                    continue;
                    this.a.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                    continue;
                    this.a.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                    continue;
                    localObject5 = ((Bundle)localObject7).getString("troopUin");
                    if (localObject1 != null)
                    {
                      ((aoep)localObject1).b((String)localObject5);
                      continue;
                      localObject5 = ((Bundle)localObject7).getString("troopUin");
                      localObject6 = ((Bundle)localObject7).getString("troopCode");
                      if (localObject1 != null) {
                        ((aoep)localObject1).a(true, (String)localObject5, (String)localObject6, 0);
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject6);
                        continue;
                        localObject1 = ((Bundle)localObject7).getString("path");
                        this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject7).getString("photoPath");
                        this.a.jdField_c_of_type_Int = ((Bundle)localObject7).getInt("seq", -1);
                        axqn.a((QQAppInterface)localObject8, (String)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
                        continue;
                        localObject5 = ((Bundle)localObject7).getByteArray("xmlData");
                        localObject1 = ((Bundle)localObject7).getString("friendUin");
                        i = ((Bundle)localObject7).getInt("directionFlag");
                        j = ((Bundle)localObject7).getInt("from");
                        if ((localObject8 instanceof QQAppInterface))
                        {
                          localObject6 = (QQAppInterface)localObject8;
                          if (!axno.a((AppInterface)localObject6, (String)localObject1))
                          {
                            l1 = bcrg.a();
                            localObject7 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                            localObject5 = bdof.a((byte[])localObject5, -1);
                            if (localObject5 != null)
                            {
                              ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                              localObject8 = (MessageForStructing)bcsa.a(-2011);
                              ((MessageForStructing)localObject8).init((String)localObject7, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                              ((MessageForStructing)localObject8).structingMsg = ((AbsStructMsg)localObject5);
                              ((MessageForStructing)localObject8).msgData = ((MessageForStructing)localObject8).structingMsg.getBytes();
                              ((MessageForStructing)localObject8).isread = true;
                              axno.a((AppInterface)localObject6, (String)localObject1);
                              axno.a((MessageRecord)localObject8, "isFaceScoreBubbleMsg", true);
                              axno.a((MessageRecord)localObject8, "isFaceScoreSecondMember", true);
                              axno.a.add(localObject1);
                              if (i == 1) {}
                              for (bool = true;; bool = false)
                              {
                                acnh.a((MessageRecord)localObject8, bool);
                                ((QQAppInterface)localObject6).getMessageFacade().addMessage((MessageRecord)localObject8, ((MessageForStructing)localObject8).selfuin);
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject8);
                                break;
                              }
                              localObject1 = ((Bundle)localObject7).getString("troopUin");
                              localObject5 = ((Bundle)localObject7).getString("memUin");
                              i = ((Bundle)localObject7).getInt("serviceType");
                              localObject6 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
                              if (localObject6 != null)
                              {
                                localObject7 = new ArrayList();
                                ((List)localObject7).add(Long.valueOf(Long.parseLong((String)localObject5)));
                                ((anwd)localObject6).a((QQAppInterface)localObject8, (String)localObject1, (List)localObject7, i);
                                continue;
                                l1 = ((Bundle)localObject7).getLong("dwGroupCode");
                                l2 = ((Bundle)localObject7).getLong("cGroupOption");
                                long l3 = ((Bundle)localObject7).getLong("dwGroupClass");
                                localObject5 = ((Bundle)localObject7).getString("strGroupName");
                                i = ((Bundle)localObject7).getInt("wGroupFace");
                                localObject6 = ((Bundle)localObject7).getString("strGroupMemo");
                                localObject8 = ((Bundle)localObject7).getString("strFingerMemo");
                                j = ((Bundle)localObject7).getInt("nFlag");
                                if (localObject1 != null)
                                {
                                  ((aoep)localObject1).a(l1, l2, l3, (String)localObject5, i, (String)localObject6, (String)localObject8, j);
                                  continue;
                                  localObject5 = ((Bundle)localObject7).getString("troopUin");
                                  if (localObject1 != null)
                                  {
                                    ((aoep)localObject1).n((String)localObject5);
                                    continue;
                                    localObject1 = ((Bundle)localObject7).getString("troopUin");
                                    bool = ((Bundle)localObject7).getBoolean("isChecked");
                                    if (localObject5 != null)
                                    {
                                      ((anrb)localObject5).c((String)localObject1, bool);
                                      continue;
                                      localObject1 = ((Bundle)localObject7).getString("troopUin");
                                      bool = ((Bundle)localObject7).getBoolean("isChecked");
                                      if (localObject5 != null)
                                      {
                                        ((anrb)localObject5).a((String)localObject1, bool);
                                        continue;
                                        if (localObject5 != null) {
                                          ((anrb)localObject5).b(((Bundle)localObject7).getString("troopUin"), ((Bundle)localObject7).getBoolean("isChecked"));
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
    case 122: 
      localObject1 = ((Bundle)localObject7).getString("content");
      i = ((Bundle)localObject7).getInt("seq");
      localObject5 = (ansr)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (localObject5 != null) {
        if (((ansr)localObject5).a((String)localObject1, 0).longValue() > 0L) {
          bool = true;
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isSuccess", bool);
      ((Bundle)localObject1).putInt("seq", i);
      this.a.a(122, (Bundle)localObject1);
      break label760;
      bool = false;
      continue;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      if (localObject1 != null) {
        ((aoep)localObject1).j((String)localObject5);
      }
      if (!QLog.isDevelopLevel()) {
        break label760;
      }
      QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject5 }));
      break label760;
      if (localObject6 == null) {
        break label760;
      }
      localObject1 = ((Bundle)localObject7).getString("methord_name");
      if ("getGroupInArea".equals(localObject1))
      {
        ((anxi)localObject6).a(((Bundle)localObject7).getString("areaName"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("startIndex"), ((Bundle)localObject7).getInt("count"), ((Bundle)localObject7).getInt("iFilterId"));
        break label760;
      }
      if ("getNearbyTroops".equals(localObject1))
      {
        ((anxi)localObject6).a(((Bundle)localObject7).getBoolean("isFirst"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("sortType"), ((Bundle)localObject7).getString("strGroupArea"), ((Bundle)localObject7).getInt("iFilterId"));
        break label760;
      }
      if ("getAreaList".equals(localObject1))
      {
        ((anxi)localObject6).a(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("radius"), ((Bundle)localObject7).getBoolean("isClickable"));
        break label760;
      }
      if (!"getNewNearbyTroop".equals(localObject1)) {
        break label760;
      }
      ((anxi)localObject6).a(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"));
      break label760;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject6 = ((Bundle)localObject7).getString("memberUin");
      i = ((Bundle)localObject7).getInt("titleId");
      localObject7 = (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject7 == null) || (i <= 0)) {
        break label760;
      }
      ((TroopManager)localObject7).a((String)localObject5, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      ((aoep)localObject1).notifyUI(144, true, new Object[] { localObject5, localObject6, Integer.valueOf(i) });
      break label760;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject5 = ((Bundle)localObject7).getStringArray("paths");
      if (((localObject8 instanceof QQAppInterface)) && (localObject5 != null) && (localObject5.length > 0))
      {
        localObject6 = (bbbq)((AppRuntime)localObject8).getManager(QQManagerFactory.MGR_RED_TOUCH);
        if (localObject6 != null)
        {
          localObject7 = new int[localObject5.length];
          localObject8 = new int[localObject5.length];
          i = 0;
          if (i < localObject8.length)
          {
            localObject9 = ((bbbq)localObject6).a(localObject5[i]);
            if (localObject9 != null)
            {
              localObject7[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).iNewFlag.get();
              localObject8[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).type.get();
            }
            for (;;)
            {
              i += 1;
              break;
              localObject7[i] = 0;
              localObject8[i] = -1;
            }
          }
          ((Bundle)localObject1).putIntArray("iNewFlags", (int[])localObject7);
          ((Bundle)localObject1).putIntArray("types", (int[])localObject8);
        }
      }
      this.a.a(11, (Bundle)localObject1);
      break label760;
      new Bundle().putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject1 = ((Bundle)localObject7).getString("path");
      if (!(localObject8 instanceof QQAppInterface)) {
        break label760;
      }
      localObject5 = (bbbq)((AppRuntime)localObject8).getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localObject5 == null) {
        break label760;
      }
      ((bbbq)localObject5).b((String)localObject1);
      break label760;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject6 = ((Bundle)localObject7).getString("processName");
      if (localObject1 == null) {
        break label760;
      }
      ((aoep)localObject1).c((String)localObject5, (String)localObject6);
      break label760;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("method", "changeAnonymousNick");
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      l1 = ((Bundle)localObject7).getLong("bubbleId");
      i = ((Bundle)localObject7).getInt("headId");
      localObject6 = ((Bundle)localObject7).getString("nickName");
      j = ((Bundle)localObject7).getInt("expireTime");
      localObject7 = ((Bundle)localObject7).getString("rankColor");
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
      {
        nty.a().a((String)localObject5, l1, i, (String)localObject6, j, "", (String)localObject7);
        ((Bundle)localObject1).putBoolean("result", true);
      }
      for (;;)
      {
        this.a.a(13, (Bundle)localObject1);
        break;
        ((Bundle)localObject1).putBoolean("result", false);
      }
      i = ((Bundle)localObject7).getInt("appid");
      localObject5 = ((Bundle)localObject7).getString("token");
      ((aoep)localObject1).a(i, ((Bundle)localObject7).getString("openGroupId"), (String)localObject5, ((Bundle)localObject7).getString("url"), ((Bundle)localObject7).getInt("seq"));
      break label760;
      i = ((Bundle)localObject7).getInt("seq");
      if (this.a.jdField_a_of_type_Adag == null) {
        this.a.jdField_a_of_type_Adag = new adag((AppRuntime)localObject8, this.a);
      }
      this.a.jdField_a_of_type_Adag.a(118, (Bundle)localObject7, i);
      break label760;
      i = ((Bundle)localObject7).getInt("appid");
      localObject5 = ((Bundle)localObject7).getString("token");
      ((aoep)localObject1).a(i, ((Bundle)localObject7).getString("openId"), (String)localObject5, ((Bundle)localObject7).getInt("seq"));
      break label760;
      bool = ((Bundle)localObject7).getBoolean("isTroopAppListChanged");
      localObject1 = (bgig)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_APP_MGR);
      if (localObject1 == null) {
        break label760;
      }
      ((bgig)localObject1).a(bool);
      break label760;
      bool = ((Bundle)localObject7).getBoolean("isTroopProfileAppListChanged");
      localObject1 = ((Bundle)localObject7).getString("profileAppListChangedTroopUin");
      localObject5 = (bgig)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_APP_MGR);
      if (localObject5 == null) {
        break label760;
      }
      ((bgig)localObject5).a(bool, (String)localObject1);
      break label760;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      localObject1 = ((Bundle)localObject7).getString("opn");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
        break label760;
      }
      if (((String)localObject1).equals("g_homework"))
      {
        l1 = Long.parseLong((String)localObject5);
        localObject1 = "";
        if (bgke.a((QQAppInterface)localObject8, l1)) {
          localObject1 = "role=teacher&";
        }
        localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject6).putExtra("url", "https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
        ((Intent)localObject6).setFlags(268435456);
        this.a.startActivity((Intent)localObject6);
        break label760;
      }
      if (!((String)localObject1).equals("g_troop_reward")) {
        break label760;
      }
      bglo.a((QQAppInterface)localObject8, this.a, (String)localObject5, true);
      break label760;
      ((Bundle)localObject7).putBoolean("isSuccess", true);
      ((Bundle)localObject7).putString("data", TroopBarPublishActivity.w);
      this.a.a(81, (Bundle)localObject7);
      break label760;
      this.a.a((Bundle)localObject7);
      break label760;
      if (TroopMemberApiService.a((AppRuntime)localObject8, new aaer(this, (Bundle)localObject7))) {
        break label760;
      }
      this.a.a(16, (Bundle)localObject7);
      break label760;
      l1 = ((Bundle)localObject7).getLong("uiResId");
      localObject1 = ajzy.a().a(l1);
      if ((localObject1 != null) && (((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
      {
        ((Bundle)localObject7).putString("packageName", ((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
        ((Bundle)localObject7).putString("imageUrl", ((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL);
        ((Bundle)localObject7).putString("name", ((arpq)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        if (((arpq)localObject1).jdField_a_of_type_Byte == 0)
        {
          bool = true;
          label3344:
          ((Bundle)localObject7).putBoolean("isOpen", bool);
          ((Bundle)localObject7).putInt("type", 0);
          ((Bundle)localObject7).putBoolean("has", true);
        }
      }
      for (;;)
      {
        this.a.a(18, (Bundle)localObject7);
        break;
        bool = false;
        break label3344;
        ((Bundle)localObject7).putBoolean("has", false);
      }
      ajzy.a |= 0x1;
      bool = ((Bundle)localObject7).getBoolean("isChecked");
      l1 = ((Bundle)localObject7).getLong("uiResId");
      ((Bundle)localObject7).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
      this.a.a(17, (Bundle)localObject7);
      break label760;
      localObject5 = ((Bundle)localObject7).getString("troopUin");
      Object localObject9 = ((Bundle)localObject7).getString("troopName");
      ((Bundle)localObject7).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).b((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject9);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject8).getCurrentAccountUin();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      for (;;)
      {
        String str2;
        for (;;)
        {
          localObject9 = (aoep)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if (localObject9 != null) {
            ((aoep)localObject9).j((String)localObject5);
          }
          if ((localObject6 != null) && (localObject1 != null)) {
            ((TroopManager)localObject6).e((TroopInfo)localObject1);
          }
          if (!(localObject8 instanceof QQAppInterface)) {
            break;
          }
          this.a.a(19, (Bundle)localObject7);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          l1 = ((Bundle)localObject7).getLong("troopCode");
          localObject1 = ((Bundle)localObject7).getString("filePath");
          localObject5 = ((Bundle)localObject7).getString("fileName");
          l2 = ((Bundle)localObject7).getLong("fileSize");
          i = ((Bundle)localObject7).getInt("busid");
          localObject1 = bgke.a((QQAppInterface)localObject8, l1, null, (String)localObject1, (String)localObject5, l2, i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
          if (!TextUtils.isEmpty(((Bundle)localObject7).getString("callback"))) {
            ((Bundle)localObject5).putString("callback", ((Bundle)localObject7).getString("callback"));
          }
          ((Bundle)localObject5).putString("method", "getFileInfo");
          TroopMemberApiService.a(this.a, (QQAppInterface)localObject8, l1, HWTroopFileStatusInfo.parse((bfjs)localObject1), (Bundle)localObject5);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Usb == null) {
            this.a.jdField_a_of_type_Usb = new usb(this.a, (QQAppInterface)localObject8);
          }
          if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Usb.a((Bundle)localObject7);
            break;
          }
          this.a.jdField_a_of_type_Usb.c((Bundle)localObject7);
          break;
          if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Usb == null) {
            this.a.jdField_a_of_type_Usb = new usb(this.a, (QQAppInterface)localObject8);
          }
          if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Usb.b((Bundle)localObject7);
            break;
          }
          this.a.jdField_a_of_type_Usb.d((Bundle)localObject7);
          break;
          if (this.a.jdField_a_of_type_Usb == null) {
            break;
          }
          this.a.jdField_a_of_type_Usb.a();
          break;
          this.a.d = ((Bundle)localObject7).getInt("appId");
          this.a.e = ((Bundle)localObject7).getInt("seq");
          if (this.a.d == 0) {
            break;
          }
          localObject1 = (bgig)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_APP_MGR);
          if (localObject1 == null) {
            break;
          }
          localObject5 = new ArrayList();
          if ((((bgig)localObject1).a(0)) && (!((bgig)localObject1).b(0)))
          {
            localObject6 = ((bgig)localObject1).a(false, 0);
            if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
            {
              localObject6 = ((List)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (TroopAIOAppInfo)((Iterator)localObject6).next();
                ((ArrayList)localObject5).add(Integer.valueOf(((TroopAIOAppInfo)localObject7).appid));
                if (((TroopAIOAppInfo)localObject7).appid == this.a.d)
                {
                  QQToast.a(BaseApplication.getContext(), 2, 2131719469, 0).b(this.a.getResources().getDimensionPixelSize(2131299080));
                  return;
                }
              }
            }
            ((ArrayList)localObject5).add(Integer.valueOf(this.a.d));
            localObject6 = new ArrayList();
            ((ArrayList)localObject6).add(Integer.valueOf(this.a.d));
            ((bgig)localObject1).a((ArrayList)localObject5, (ArrayList)localObject6);
            break;
          }
          this.a.jdField_a_of_type_Boolean = true;
          ((bgig)localObject1).a(true, 0);
          break;
          l1 = ((Bundle)localObject7).getLong("roomid", 0L);
          localObject1 = ((Bundle)localObject7).getString("roomname");
          localObject5 = ((Bundle)localObject7).getString("userdata");
          localObject6 = ((Bundle)localObject7).getString("vasname");
          i = ((Bundle)localObject7).getInt("fromid", 0);
          ((avwp)((QQAppInterface)localObject8).getManager(QQManagerFactory.ODPROXY_MGR)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
          break;
          localObject1 = ((Bundle)localObject7).getString("appType");
          localObject5 = ((Bundle)localObject7).getString("openType");
          localObject6 = ((Bundle)localObject7).getString("uri");
          localObject9 = ((Bundle)localObject7).getString("action");
          str2 = ((Bundle)localObject7).getString("pluginPackageName");
          localObject7 = ((Bundle)localObject7).getString("pluginParams");
          avtx.a((QQAppInterface)localObject8, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject9, str2, (String)localObject7);
          break;
          localObject1 = ((Bundle)localObject7).getString("pluginPackageName");
          localObject5 = ((Bundle)localObject7).getString("appType");
          avto.a(((QQAppInterface)localObject8).getApp(), (String)localObject1, (String)localObject5).a();
          break;
          try
          {
            l1 = ((Bundle)localObject7).getLong("troopPubAccountUin");
            localObject1 = ((Bundle)localObject7).getLongArray("troopUinList");
            if ((localObject1 == null) || (localObject1.length <= 0)) {
              break;
            }
            localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
            i = 0;
            while (i < localObject1.length)
            {
              localObject6 = ((TroopManager)localObject5).b(localObject1[i] + "");
              if (localObject6 != null) {
                ((TroopInfo)localObject6).associatePubAccount = l1;
              }
              ((TroopManager)localObject5).b((TroopInfo)localObject6);
              i += 1;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException1) {}
        }
        QLog.e("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + localException1.toString());
        break label760;
        Object localObject2 = ((Bundle)localObject7).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject5 == null) {
          break label760;
        }
        localObject2 = ((TroopManager)localObject5).b((String)localObject2);
        if (localObject2 == null) {
          break label760;
        }
        ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
        ((TroopManager)localObject5).b((TroopInfo)localObject2);
        break label760;
        localObject2 = ((Bundle)localObject7).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject5 != null)
        {
          localObject2 = ((TroopManager)localObject5).b((String)localObject2);
          if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
            bool = true;
          }
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              ((Bundle)localObject7).putBoolean("hasOrgs", bool);
              this.a.a(46, (Bundle)localObject7);
              break label760;
              bool = false;
              continue;
              localObject2 = ((Bundle)localObject7).getString("localFilePath");
              localObject5 = ((Bundle)localObject7).getString("fileDisPlayName");
              bghd.a(this.a, (String)localObject2, (String)localObject5);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              i = ((Bundle)localObject7).getInt("rewardMoney");
              localObject5 = ((Bundle)localObject7).getString("rewardContent");
              localObject6 = ((Bundle)localObject7).getString("mediaPath");
              j = ((Bundle)localObject7).getInt("rewardType");
              bglo.a = ((Bundle)localObject7).getInt("imageMaxWidthPixels", 1080);
              bglo.b = ((Bundle)localObject7).getInt("imageMaxHeightPixels", 1920);
              ((bglo)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_REWARD_MGR)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
              break label760;
              ((aoep)localObject2).a(((Bundle)localObject7).getLong("troopUin"), ((Bundle)localObject7).getInt("flag"));
              break label760;
              localObject2 = (QQAppInterface)localObject8;
              ((Bundle)localObject7).putInt("fontSize", QQAppInterface.curBrowserFontSizeIndex);
              this.a.a(52, (Bundle)localObject7);
              break label760;
              i = ((Bundle)localObject7).getInt("fontSize", 1);
              localObject2 = (QQAppInterface)localObject8;
              QQAppInterface.curBrowserFontSizeIndex = i;
              ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              localObject5 = ((Bundle)localObject7).getString("rewardId");
              localObject5 = ((bglo)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_REWARD_MGR)).a((String)localObject2, (String)localObject5);
              localObject2 = "";
              if (localObject5 != null) {
                localObject2 = ((MessageForTroopReward)localObject5).mediaPath;
              }
              ((Bundle)localObject7).putString("videoPath", (String)localObject2);
              this.a.a(55, (Bundle)localObject7);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              localObject5 = ((Bundle)localObject7).getString("largeImageFile");
              localObject6 = ((Bundle)localObject7).getString("fileName");
              l1 = ((Bundle)localObject7).getLong("progressTotal");
              i = ((Bundle)localObject7).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              localObject5 = ((Bundle)localObject7).getString("filePath");
              localObject6 = ((Bundle)localObject7).getString("fileName");
              i = ((Bundle)localObject7).getInt("size");
              j = ((Bundle)localObject7).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, j, i);
              break label760;
              localObject5 = (TroopPluginManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
              localObject6 = ((Bundle)localObject7).getString("troopUin");
              i = ((Bundle)localObject7).getInt("seq");
              localObject7 = ((Bundle)localObject7).getString("processName");
              if (localObject5 == null) {
                break label760;
              }
              ((TroopPluginManager)localObject5).a("troop_manage_plugin.apk", new aaev(this, (aoep)localObject2, (String)localObject6, i, (String)localObject7));
              break label760;
              localObject2 = ((Bundle)localObject7).getString("appid");
              localObject5 = ((Bundle)localObject7).getString("pkgname");
              this.a.a((String)localObject5, (String)localObject2);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("hashName");
              ((Bundle)localObject7).putByteArray("decryptResult", PreloadManager.a().b((String)localObject2));
              this.a.a(66, (Bundle)localObject7);
              break label760;
              ((aoep)localObject2).a(((Bundle)localObject7).getString("troopUin"), "", ((Bundle)localObject7).getInt("statOption"), ((Bundle)localObject7).getString("authKey"), null, null, null);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("groupCode");
              localObject5 = ((Bundle)localObject7).getString("groupMemberUin");
              i = ((Bundle)localObject7).getInt("seq");
              ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (TroopManager)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_MANAGER), (String)localObject2, (String)localObject5, (Bundle)localObject7, i), 8, null, true);
              break label760;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
              localObject5 = ((bhyq)((AppRuntime)localObject8).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
              localObject6 = new File(axoc.jdField_a_of_type_JavaLangString + File.separator + "nearby_heart.mp4");
              if (!((File)localObject6).exists()) {
                ((File)localObject6).mkdirs();
              }
              for (;;)
              {
                ((bhyt)localObject5).a(new bhyo("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject6), new aaew(this, (Bundle)localObject2), new Bundle());
                break;
                ((File)localObject6).delete();
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
              bool = false;
              if ((localObject8 instanceof QQAppInterface))
              {
                localObject5 = (QQAppInterface)localObject8;
                if ((!((QQAppInterface)localObject5).isVideoChatting()) || (((QQAppInterface)localObject5).getAVNotifyCenter().k())) {
                  break label5736;
                }
              }
              label5736:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
                this.a.a(84, (Bundle)localObject2);
                break;
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
              if ((localObject8 instanceof QQAppInterface))
              {
                localObject6 = (bghm)((AppRuntime)localObject8).getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
                if (localObject6 != null)
                {
                  localObject5 = ((bghm)localObject6).a();
                  localObject6 = ((bghm)localObject6).b();
                  ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject5);
                  ((Bundle)localObject2).putString("title", (String)localObject6);
                }
              }
              this.a.a(76, (Bundle)localObject2);
              break label760;
              if (!(localObject8 instanceof QQAppInterface)) {
                break label760;
              }
              bool = bdee.a((QQAppInterface)localObject8, BaseApplicationImpl.getContext());
              if (!QLog.isColorLevel()) {
                break label760;
              }
              QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
              break label760;
              ((Bundle)localObject7).putInt("currentFragment", SplashActivity.a);
              this.a.a(80, (Bundle)localObject7);
              break label760;
              localObject2 = (sqm)((AppRuntime)localObject8).getManager(QQManagerFactory.READINJOY_VIDEO_UPLOAD_MANAGER);
              ((sqm)localObject2).a(this.a);
              ((sqm)localObject2).a(((Bundle)localObject7).getString("videoPath"), (Bundle)localObject7);
              break label760;
              i = ((Bundle)localObject7).getInt("subCmd");
              localObject2 = (bfkw)((QQAppInterface)localObject8).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
              switch (i)
              {
              }
              for (;;)
              {
                this.a.a(87, (Bundle)localObject7);
                break;
                i = ((Bundle)localObject7).getInt("effectId");
                localObject6 = ((Bundle)localObject7).getIntegerArrayList("groupCodeList");
                localObject5 = ((Bundle)localObject7).getString("effectName");
                j = ((Bundle)localObject7).getInt("svipLevel");
                k = ((Bundle)localObject7).getInt("svipType");
                if (((ArrayList)localObject6).size() == 0)
                {
                  ((bfkw)localObject2).a(i, (String)localObject5, j, k);
                }
                else
                {
                  localObject6 = ((ArrayList)localObject6).iterator();
                  while (((Iterator)localObject6).hasNext()) {
                    ((bfkw)localObject2).a(((Integer)((Iterator)localObject6).next()).intValue(), i, (String)localObject5, j, k);
                  }
                  localObject5 = ((Bundle)localObject7).getStringArrayList("statusList");
                  if (localObject5 != null) {
                    ((bfkw)localObject2).a((ArrayList)localObject5);
                  }
                }
              }
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              localObject5 = ((Bundle)localObject7).getString("path");
              i = ((Bundle)localObject7).getInt("msgTailType", 0);
              localObject6 = new Intent();
              ((Intent)localObject6).putExtra("send_in_background", true);
              ((Intent)localObject6).putExtra("file_send_path", (String)localObject5);
              ((Intent)localObject6).putExtra("file_send_size", new File((String)localObject5).length());
              ((Intent)localObject6).putExtra("file_send_duration", ShortVideoUtils.getDurationOfVideo((String)localObject5));
              ((Intent)localObject6).putExtra("uin", (String)localObject2);
              ((Intent)localObject6).putExtra("uintype", 1);
              ((Intent)localObject6).putExtra("file_source", "album_flow");
              ((Intent)localObject6).putExtra("short_video_msg_tail_type", i);
              new amaf((Intent)localObject6).execute(new Void[0]);
              this.a.a(87, (Bundle)localObject7);
              break label760;
              l1 = ((Bundle)localObject7).getLong("roomId");
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("jumpType", 1);
              ((Bundle)localObject2).putString("roomid", String.valueOf(l1));
              ((avux)((AppRuntime)localObject8).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject2);
              break label760;
              ((avux)((AppRuntime)localObject8).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).b((Bundle)localObject7);
              break label760;
              if (this.a.jdField_b_of_type_Boolean) {
                break;
              }
              this.a.jdField_b_of_type_Boolean = true;
              bool = NetworkUtil.isNetworkAvailable(null);
              VideoEnvironment.LogDownLoad("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
              if (bool)
              {
                VideoEnvironment.LogDownLoad("TroopMemberApiService", anvx.a(2131715005), null);
                ShortVideoResourceManager.b((QQAppInterface)localObject8, new aaex(this, (AppRuntime)localObject8, (Bundle)localObject7));
                break label760;
              }
              ((Bundle)localObject7).putInt("result", -1);
              this.a.a(93, (Bundle)localObject7);
              break label760;
              i = ((Bundle)localObject7).getInt("isGroupCode");
              localObject2 = ((Bundle)localObject7).getString("roomId");
              localObject5 = ((Bundle)localObject7).getString("action");
              localObject6 = ((Bundle)localObject7).getString("fromId");
              localObject9 = ((Bundle)localObject7).getString("backType");
              str2 = ((Bundle)localObject7).getString("openType");
              localObject7 = ((Bundle)localObject7).getString("extra");
              ((avsv)((AppRuntime)localObject8).getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(this.a, (String)localObject2, ((QQAppInterface)localObject8).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject9, str2, (String)localObject7);
              break label760;
              ((Bundle)localObject7).getString("fromId");
              ((avsv)((AppRuntime)localObject8).getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(null, 10L);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("uin");
              i = ((Bundle)localObject7).getInt("index");
              localObject2 = oez.a().a((String)localObject2);
              if (localObject2 == null) {
                break label760;
              }
              localObject5 = (ofd)((AppRuntime)localObject8).getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
              if (localObject5 == null) {
                break label760;
              }
              ((ofd)localObject5).a((oeq)localObject2, i);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopCode");
              localObject5 = ((Bundle)localObject7).getString("uin");
              localObject6 = ((Bundle)localObject7).getString("nick");
              localObject7 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject7 == null) {
                break label760;
              }
              ((anwd)localObject7).a((String)localObject2, (String)localObject5, (String)localObject6);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopCode");
              localObject5 = ((Bundle)localObject7).getString("uin");
              localObject6 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject6 == null) {
                break label760;
              }
              ((anwd)localObject6).a((String)localObject2, (String)localObject5);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopCode");
              localObject5 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject5 == null) {
                break label760;
              }
              ((anwd)localObject5).a((String)localObject2);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopCode");
              localObject5 = ((Bundle)localObject7).getString("uin");
              localObject6 = ((Bundle)localObject7).getString("nick");
              localObject7 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject7 == null) {
                break label760;
              }
              ((anwd)localObject7).b((String)localObject2, (String)localObject5, (String)localObject6);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("troopCode");
              localObject5 = ((Bundle)localObject7).getString("uin");
              localObject6 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject6 == null) {
                break label760;
              }
              ((anwd)localObject6).b((String)localObject2, (String)localObject5);
              break label760;
              ((Bundle)localObject7).getString("troopCode");
              localObject2 = ((Bundle)localObject7).getString("rid");
              localObject5 = new aaez(this, (Bundle)localObject7);
              this.a.jdField_a_of_type_Anwt = new anwt((QQAppInterface)localObject8, (anwu)localObject5, (String)localObject2);
              this.a.jdField_a_of_type_Anwt.b(10000L);
              break label760;
              this.a.f = ((Bundle)localObject7).getInt("seq", -1);
              localObject2 = ((Bundle)localObject7).getStringArrayList("tinyIdList");
              localObject5 = (anwd)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
              if (localObject5 == null) {
                break label760;
              }
              ((anwd)localObject5).a((ArrayList)localObject2);
              break label760;
              localObject2 = ((Bundle)localObject7).getString("schoolName");
              i = ((Bundle)localObject7).getInt("isValid");
              localObject5 = (axqt)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
              if (localObject5 == null) {
                break label760;
              }
              ((axqt)localObject5).a((String)localObject2, i);
              break label760;
              localObject2 = ((Bundle)localObject7).getStringArrayList("preloadList");
              localObject5 = (oht)((AppRuntime)localObject8).getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER);
              if (localObject5 == null) {
                break label760;
              }
              ((oht)localObject5).a((ArrayList)localObject2);
              break label760;
              localObject2 = (oht)((AppRuntime)localObject8).getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER);
              if (localObject2 == null) {
                break label760;
              }
              ((oht)localObject2).a();
              break label760;
              i = ((Bundle)localObject7).getInt("topicId");
              j = ((Bundle)localObject7).getInt("followInfo");
              if (pvj.a().a(i, j)) {
                break label760;
              }
              pvj.a().d(i, j);
              break label760;
              ((Bundle)localObject7).putInt("readinjoy_to_wx_config", bmhv.o((AppRuntime)localObject8));
              this.a.a(113, (Bundle)localObject7);
              break label760;
              ((vzu)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).c(((Bundle)localObject7).getInt("reqUserSetEnableAlbumScan"));
              break label760;
              if (this.a.jdField_a_of_type_Qjy == null) {
                this.a.jdField_a_of_type_Qjy = new qjy((AppRuntime)localObject8, this.a);
              }
              this.a.jdField_a_of_type_Qjy.b((Bundle)localObject7);
              break label760;
              if (this.a.jdField_a_of_type_Qjy == null) {
                this.a.jdField_a_of_type_Qjy = new qjy((AppRuntime)localObject8, this.a);
              }
              this.a.jdField_a_of_type_Qjy.c((Bundle)localObject7);
              break label760;
              if (this.a.jdField_a_of_type_Qjy == null) {
                this.a.jdField_a_of_type_Qjy = new qjy((AppRuntime)localObject8, this.a);
              }
              this.a.jdField_a_of_type_Qjy.a((Bundle)localObject7);
              break label760;
              this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject7).getString("callback");
              this.a.g = ((Bundle)localObject7).getInt("seq");
              localObject5 = ((Bundle)localObject7).getString("troopUin");
              localObject6 = ((Bundle)localObject7).getString("chatType");
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && ("group".equals(localObject6)))
              {
                if (localObject2 == null) {
                  break label760;
                }
                ((aoep)localObject2).a((String)localObject5, false, "TroopMemberApiService111", true, true, false, false);
                break label760;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject5 + ", chatType=" + (String)localObject6);
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("isSuccess", false);
              ((Bundle)localObject2).putInt("seq", this.a.g);
              ((Bundle)localObject2).putString("callback", this.a.jdField_c_of_type_JavaLangString);
              this.a.a(112, (Bundle)localObject2);
              break label760;
              localObject2 = new Intent(((QQAppInterface)localObject8).getApp().getApplicationContext(), SplashActivity.class);
              ((Intent)localObject2).putExtras((Bundle)localObject7);
              localObject2 = AIOUtils.setOpenAIOIntent((Intent)localObject2, null);
              localObject5 = ForwardUtils.sessionFromIntent((Intent)localObject2);
              ForwardUtils.handleAppShareAction((QQAppInterface)localObject8, ((QQAppInterface)localObject8).getApp().getApplicationContext(), (SessionInfo)localObject5, (Intent)localObject2);
              break label760;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_BEACON_REPORT");
              }
              bdxf.a(((Bundle)localObject7).getBundle("reportData"));
              break label760;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_PRELOAD");
              }
              if (!(localObject8 instanceof QQAppInterface)) {
                break label760;
              }
              ((bdvz)((AppRuntime)localObject8).getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(BaseApplicationImpl.getContext());
              break label760;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
              }
              localObject2 = ((Bundle)localObject7).getString("troopUin");
              localObject5 = ((Bundle)localObject7).getString("type");
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject5)) || (bghd.a((QQAppInterface)localObject8, (String)localObject2) == 0)) {
                break label760;
              }
              bghd.a((QQAppInterface)localObject8, (String)localObject2);
              break label760;
              l1 = ((Bundle)localObject7).getLong("followUin");
              i = ((Bundle)localObject7).getInt("followInfo");
              if ((i != 2) && (i != 1)) {
                break label760;
              }
              localObject2 = pvm.a();
              if (i == 2) {}
              for (bool = true;; bool = false)
              {
                ((pvm)localObject2).b(l1, bool);
                ThreadManager.post(new TroopMemberApiService.IncomingHandler.8(this, l1, i), 8, null, true);
                break;
              }
              localObject5 = ((Bundle)localObject7).getString("url");
              i = ((Bundle)localObject7).getInt("type", -1);
              j = ((Bundle)localObject7).getInt("msgfrom", 0);
              localObject6 = ((Bundle)localObject7).getString("senderUin");
              localObject9 = ((Bundle)localObject7).getString("chatId");
              str2 = ((Bundle)localObject7).getString("source");
              k = ((Bundle)localObject7).getInt("seq");
              localObject2 = ((Bundle)localObject7).getString("processName");
              String str3 = ((Bundle)localObject7).getString("originUrl");
              String str4 = ((Bundle)localObject7).getString("ark_business_name");
              bool = ((Bundle)localObject7).getBoolean("is_page_finish", false);
              localObject7 = ((Bundle)localObject7).getStringArrayList("pre_jump_urls");
              localObject8 = (bidm)((AppRuntime)localObject8).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
              if (localObject8 != null)
              {
                ((bidm)localObject8).a((String)localObject5, i, j, (String)localObject6, (String)localObject9, str2, str3, str4, bool, (ArrayList)localObject7, new aafa(this, k, (String)localObject2));
                break label760;
              }
              localObject5 = new Bundle();
              ((Bundle)localObject5).putInt("seq", k);
              ((Bundle)localObject5).putString("processName", (String)localObject2);
              this.a.a(121, (Bundle)localObject5);
              break label760;
              try
              {
                localObject2 = (bidm)((AppRuntime)localObject8).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                if (localObject2 == null) {
                  break label8258;
                }
                ((bidm)localObject2).a((Bundle)localObject7);
              }
              catch (Throwable localThrowable)
              {
                QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
              }
            }
            break label760;
            label8258:
            if (!QLog.isColorLevel()) {
              break label760;
            }
            QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
            break label760;
            Object localObject3 = (bidm)((AppRuntime)localObject8).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
            localObject5 = ((Bundle)localObject7).getString("appid");
            localObject6 = ((Bundle)localObject7).getString("openid");
            localObject8 = ((Bundle)localObject7).getString("troopuin");
            i = ((Bundle)localObject7).getInt("seq");
            localObject7 = ((Bundle)localObject7).getString("processName");
            if (localObject3 != null)
            {
              ((bidm)localObject3).a((String)localObject5, (String)localObject6, (String)localObject8, new aaes(this, i, (String)localObject7));
              break label760;
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("seq", i);
            ((Bundle)localObject3).putString("processName", (String)localObject7);
            ((Bundle)localObject3).putInt("result", -1);
            this.a.a(146, (Bundle)localObject3);
            break label760;
            ((Bundle)localObject7).putString("nickName", ((QQAppInterface)localObject8).getCurrentNickname());
            this.a.a(128, (Bundle)localObject7);
            break label760;
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject3 = this.a.getApplicationContext())
            {
              KandianSubscribeManager.a((Context)localObject3, 3, 4);
              break;
            }
            if (((Bundle)localObject7).getBoolean("open_readinjoy_tab"))
            {
              bmhv.d(1);
              bmhv.a(true);
              bmhv.a(true);
            }
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject4 = this.a.getApplicationContext())
            {
              for (;;)
              {
                if (!bmhv.n()) {
                  break label8619;
                }
                j = 12;
                try
                {
                  localObject5 = ((Bundle)localObject7).getString("from");
                  i = j;
                  if (!TextUtils.isEmpty((CharSequence)localObject5))
                  {
                    i = j;
                    if (TextUtils.isDigitsOnly((CharSequence)localObject5)) {
                      i = Integer.valueOf((String)localObject5).intValue();
                    }
                  }
                  ((Context)localObject3).startActivity(osg.a((Context)localObject3, i));
                }
                catch (Exception localException2) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
              break;
            }
            label8619:
            localObject5 = (QQAppInterface)localObject8;
            if (bmhv.a((QQAppInterface)localObject5))
            {
              osg.a((QQAppInterface)localObject5, (Context)localObject4, 2, 0);
              break label760;
            }
            osg.a((Context)localObject4, null, -1L, 2);
            break label760;
            i = ((Bundle)localObject7).getInt("seq");
            localObject4 = (QQAppInterface)localObject8;
            localObject5 = ((anvk)((AppRuntime)localObject8).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((QQAppInterface)localObject4).getCurrentUin());
            if (localObject5 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "get user gender:" + ((Card)localObject5).shGender);
              }
              ((Bundle)localObject7).putShort("gender", ((Card)localObject5).shGender);
            }
            ((Bundle)localObject7).putString("facePath", ((QQAppInterface)localObject4).getCustomFaceFilePath(1, ((QQAppInterface)localObject4).getCurrentAccountUin(), 0));
            ((Bundle)localObject7).putInt("seq", i);
            this.a.a(126, (Bundle)localObject7);
            break label760;
            i = ((Bundle)localObject7).getInt("start");
            j = ((Bundle)localObject7).getInt("msgType");
            int k = ((Bundle)localObject7).getInt("count");
            localObject4 = besd.a(this.a.getApplicationContext(), (QQAppInterface)localObject8, i, j, k);
            if (localObject4 != null) {
              ((Bundle)localObject7).putString("sayhiinfo", ((JSONObject)localObject4).toString());
            }
            this.a.a(129, (Bundle)localObject7);
            break label760;
            i = ((Bundle)localObject7).getInt("clearType");
            j = ((Bundle)localObject7).getInt("msgType");
            localObject4 = ((Bundle)localObject7).getString("uin");
            besd.a((QQAppInterface)localObject8, (String)localObject4, i, j);
            break label760;
            i = ((Bundle)localObject7).getInt("deleteType");
            localObject4 = ((Bundle)localObject7).getString("uin");
            j = ((Bundle)localObject7).getInt("msgType");
            besd.b((QQAppInterface)localObject8, (String)localObject4, i, j);
            break label760;
            bool = ((Bundle)localObject7).getBoolean("isSuccess");
            localObject4 = ((Bundle)localObject7).getString("pkgname");
            pvm.a().a(null, 101, bool, new String[] { localObject4 });
            break label760;
            localObject4 = ulc.a(2);
            if ((localObject4 == null) || (!(localObject4 instanceof ugc))) {
              break label760;
            }
            ((ugc)localObject4).a((Bundle)localObject7);
            break label760;
            uks.a();
            break label760;
            c((Bundle)localObject7);
            this.a.a(141, (Bundle)localObject7);
            break label760;
            localObject4 = ((Bundle)localObject7).getString("uin");
            zzk.c(BaseApplicationImpl.getContext(), (String)localObject4, null);
            break label760;
            localObject5 = ((Bundle)localObject7).getString("code");
            localObject4 = new String[4];
            localObject4[0] = "0";
            localObject4[1] = "0";
            localObject4[2] = "0";
            localObject4[3] = "0";
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject5))
              {
                localObject5 = new JSONObject((String)localObject5);
                localObject4[0] = ((JSONObject)localObject5).optString("country", "0");
                localObject4[1] = ((JSONObject)localObject5).optString("province", "0");
                localObject4[2] = ((JSONObject)localObject5).optString("city", "0");
                localObject4[3] = ((JSONObject)localObject5).optString("area", "0");
              }
              if (this.a.jdField_a_of_type_Anrz == null)
              {
                this.a.jdField_a_of_type_Anrz = ((anrz)((AppRuntime)localObject8).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
                this.a.jdField_a_of_type_Anrz.a(this);
              }
              localObject5 = new Intent(BaseApplicationImpl.getContext(), LocationSelectActivity.class);
              ((Intent)localObject5).putExtra("param_is_popup", false);
              ((Intent)localObject5).putExtra("param_req_type", 2);
              ((Intent)localObject5).putExtra("param_location", (String[])localObject4);
              ((Intent)localObject5).putExtra("param_location_param", this.a.jdField_a_of_type_Anrz.b((String[])localObject4));
              BaseApplicationImpl.getContext().startActivity((Intent)localObject5);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
          if (BaseActivity.sTopActivity != null) {}
          for (localObject4 = BaseActivity.sTopActivity; localObject4 != null; localObject4 = this.a.getApplicationContext())
          {
            KandianDailyManager.a((Context)localObject4);
            break;
          }
          bool = ((Bundle)localObject7).getBoolean("isOpen");
          localObject4 = ((Bundle)localObject7).getString("troopUin");
          if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject4, Boolean.valueOf(bool) }));
          }
          ((bfwu)((AppRuntime)localObject8).getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a((String)localObject4, bool);
          break label760;
          localObject4 = ((Bundle)localObject7).getString("groupCode");
          String str1 = ((Bundle)localObject7).getString("appID");
          localObject6 = ((Bundle)localObject7).getString("url");
          localObject7 = ((Bundle)localObject7).getString("source");
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", new Object[] { localObject4, str1, localObject6, localObject7 }));
          }
          localObject7 = new SessionInfo();
          ((SessionInfo)localObject7).curFriendUin = ((String)localObject4);
          ((SessionInfo)localObject7).curType = 1;
          if (BaseActivity.sTopActivity != null)
          {
            localObject4 = BaseActivity.sTopActivity;
            label9567:
            if ((localObject4 instanceof BaseActivity)) {
              break label9835;
            }
            localObject4 = null;
          }
          label9835:
          for (;;)
          {
            bgil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), (BaseActivity)localObject4, (SessionInfo)localObject7, Long.parseLong(str1), (String)localObject6, 1, 0);
            break;
            localObject4 = this.a.getApplicationContext();
            break label9567;
            short s = ((Bundle)localObject7).getShort("tmpPushType");
            ((Bundle)localObject7).putBoolean("enable", ((awtq)((AppRuntime)localObject8).getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s));
            ((Bundle)localObject7).putInt("seq", ((Bundle)localObject7).getInt("seq"));
            this.a.a(151, (Bundle)localObject7);
            break;
            s = ((Bundle)localObject7).getShort("tmpPushType");
            bool = ((Bundle)localObject7).getBoolean("enable");
            ((awtq)((AppRuntime)localObject8).getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool, true);
            ((Bundle)localObject7).putBoolean("enable", bool);
            ((Bundle)localObject7).putBoolean("success", true);
            ((Bundle)localObject7).putInt("seq", ((Bundle)localObject7).getInt("seq"));
            this.a.a(152, (Bundle)localObject7);
            break;
            b((Bundle)localObject7);
            break;
            a((Bundle)localObject7);
            break;
            if (localObject4 == null) {
              break;
            }
            ((aoep)localObject4).a(((Bundle)localObject7).getString("troopUin", ""), ((Bundle)localObject7).getInt("opType", 0), ((Bundle)localObject7).getString("startTroopUin", ""));
            break;
          }
          bool = false;
        }
        continue;
        Object localObject4 = null;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaeq
 * JD-Core Version:    0.7.0.1
 */