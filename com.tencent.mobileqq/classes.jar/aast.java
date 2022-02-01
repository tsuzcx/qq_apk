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
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class aast
  extends Handler
{
  public aast(TroopMemberApiService paramTroopMemberApiService) {}
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramBundle.getString("BUNDLE_KEY_JS_OBJ");
    Object localObject1;
    Object localObject2;
    int j;
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      if ((str == null) || (localJSONObject == null)) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Parcelable localParcelable;
      int i;
      do
      {
        for (;;)
        {
          QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult(server) result parse error.");
          localObject1 = null;
        }
        localParcelable = paramBundle.getParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA");
        i = ((JSONObject)localObject1).optInt("biuAfterComment", 0);
        localObject2 = new String(Base64.decode(((JSONObject)localObject1).optString("comment"), 0));
        j = ((JSONObject)localObject1).optInt("feedsType");
        paramBundle = new aasw(this, (JSONObject)localObject1, (String)localObject2, paramBundle);
        if ((localParcelable instanceof FirstCommentCreateData))
        {
          localObject1 = (FirstCommentCreateData)localParcelable;
          ((FirstCommentCreateData)localObject1).a((String)localObject2);
          localObject2 = owr.a;
          if (i == 1) {}
          for (;;)
          {
            ((owr)localObject2).a((FirstCommentCreateData)localObject1, paramBundle, str, j, false, bool1);
            return;
            bool1 = false;
          }
        }
      } while (!(localParcelable instanceof SubCommentCreateData));
      localObject1 = (SubCommentCreateData)localParcelable;
      ((SubCommentCreateData)localObject1).d((String)localObject2);
      localObject2 = owr.a;
      if (i != 1) {}
    }
    for (bool1 = bool2;; bool1 = false)
    {
      ((owr)localObject2).a((SubCommentCreateData)localObject1, paramBundle, str, j, false, bool1);
      return;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)TroopMemberApiService.d(this.a);
    Object localObject3 = ((axfr)TroopMemberApiService.e(this.a).getManager(11)).a();
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
    Object localObject7 = TroopMemberApiService.c(this.a);
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    if ((localObject7 instanceof QQAppInterface))
    {
      localObject5 = (antz)((QQAppInterface)localObject7).a(22);
      localObject6 = (aoat)((QQAppInterface)localObject7).a(3);
      localObject1 = (aoip)((QQAppInterface)localObject7).a(20);
    }
    if ((paramMessage == null) || (localObject7 == null) || (!(localObject7 instanceof QQAppInterface))) {}
    Object localObject8;
    do
    {
      return;
      localObject8 = paramMessage.getData();
    } while (localObject8 == null);
    ((Bundle)localObject8).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    label748:
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
                this.a.jdField_a_of_type_Aofl = new aofl(((AppRuntime)localObject7).getAccount());
                continue;
                localObject1 = ((Bundle)localObject8).getString("gcode");
                localObject5 = String.valueOf(8000000);
                localObject6 = nlj.a().a((String)localObject1, (String)localObject5);
                if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                {
                  this.a.a((String)localObject1, (String)localObject5, ((AppRuntime)localObject7).getAccount(), (String)localObject6);
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                    continue;
                    this.a.a().a((AppRuntime)localObject7, (Bundle)localObject8);
                    continue;
                    this.a.a().a((AppRuntime)localObject7, (Bundle)localObject8);
                    continue;
                    localObject5 = ((Bundle)localObject8).getString("troopUin");
                    if (localObject1 != null)
                    {
                      ((aoip)localObject1).b((String)localObject5);
                      continue;
                      localObject5 = ((Bundle)localObject8).getString("troopUin");
                      localObject6 = ((Bundle)localObject8).getString("troopCode");
                      if (localObject1 != null) {
                        ((aoip)localObject1).a(true, (String)localObject5, (String)localObject6, 0);
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject6);
                        continue;
                        localObject1 = ((Bundle)localObject8).getString("path");
                        this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject8).getString("photoPath");
                        this.a.jdField_c_of_type_Int = ((Bundle)localObject8).getInt("seq", -1);
                        axxd.a((QQAppInterface)localObject7, (String)localObject1, this.a.jdField_a_of_type_Beyf);
                        continue;
                        localObject5 = ((Bundle)localObject8).getByteArray("xmlData");
                        localObject1 = ((Bundle)localObject8).getString("friendUin");
                        i = ((Bundle)localObject8).getInt("directionFlag");
                        j = ((Bundle)localObject8).getInt("from");
                        if ((localObject7 instanceof QQAppInterface))
                        {
                          localObject6 = (QQAppInterface)localObject7;
                          if (!axuf.a((AppInterface)localObject6, (String)localObject1))
                          {
                            l1 = bcrg.a();
                            localObject7 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                            localObject5 = bdow.a((byte[])localObject5, -1);
                            if (localObject5 != null)
                            {
                              ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                              localObject8 = (MessageForStructing)bcry.a(-2011);
                              ((MessageForStructing)localObject8).init((String)localObject7, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                              ((MessageForStructing)localObject8).structingMsg = ((AbsStructMsg)localObject5);
                              ((MessageForStructing)localObject8).msgData = ((MessageForStructing)localObject8).structingMsg.getBytes();
                              ((MessageForStructing)localObject8).isread = true;
                              axuf.a((AppInterface)localObject6, (String)localObject1);
                              axuf.a((MessageRecord)localObject8, "isFaceScoreBubbleMsg", true);
                              axuf.a((MessageRecord)localObject8, "isFaceScoreSecondMember", true);
                              axuf.a.add(localObject1);
                              if (i == 1) {}
                              for (bool = true;; bool = false)
                              {
                                adak.a((MessageRecord)localObject8, bool);
                                ((QQAppInterface)localObject6).a().a((MessageRecord)localObject8, ((MessageForStructing)localObject8).selfuin);
                                if (!QLog.isColorLevel()) {
                                  break;
                                }
                                QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject8);
                                break;
                              }
                              localObject1 = ((Bundle)localObject8).getString("troopUin");
                              localObject5 = ((Bundle)localObject8).getString("memUin");
                              i = ((Bundle)localObject8).getInt("serviceType");
                              localObject6 = (anzp)((QQAppInterface)localObject7).a(35);
                              if (localObject6 != null)
                              {
                                localObject8 = new ArrayList();
                                ((List)localObject8).add(Long.valueOf(Long.parseLong((String)localObject5)));
                                ((anzp)localObject6).a((QQAppInterface)localObject7, (String)localObject1, (List)localObject8, i);
                                continue;
                                l1 = ((Bundle)localObject8).getLong("dwGroupCode");
                                l2 = ((Bundle)localObject8).getLong("cGroupOption");
                                long l3 = ((Bundle)localObject8).getLong("dwGroupClass");
                                localObject5 = ((Bundle)localObject8).getString("strGroupName");
                                i = ((Bundle)localObject8).getInt("wGroupFace");
                                localObject6 = ((Bundle)localObject8).getString("strGroupMemo");
                                localObject7 = ((Bundle)localObject8).getString("strFingerMemo");
                                j = ((Bundle)localObject8).getInt("nFlag");
                                if (localObject1 != null)
                                {
                                  ((aoip)localObject1).a(l1, l2, l3, (String)localObject5, i, (String)localObject6, (String)localObject7, j);
                                  continue;
                                  localObject5 = ((Bundle)localObject8).getString("troopUin");
                                  if (localObject1 != null)
                                  {
                                    ((aoip)localObject1).n((String)localObject5);
                                    continue;
                                    localObject1 = ((Bundle)localObject8).getString("troopUin");
                                    bool = ((Bundle)localObject8).getBoolean("isChecked");
                                    if (localObject5 != null)
                                    {
                                      ((antz)localObject5).c((String)localObject1, bool);
                                      continue;
                                      localObject1 = ((Bundle)localObject8).getString("troopUin");
                                      bool = ((Bundle)localObject8).getBoolean("isChecked");
                                      if (localObject5 != null)
                                      {
                                        ((antz)localObject5).a((String)localObject1, bool);
                                        continue;
                                        if (localObject5 != null) {
                                          ((antz)localObject5).b(((Bundle)localObject8).getString("troopUin"), ((Bundle)localObject8).getBoolean("isChecked"));
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
      localObject1 = ((Bundle)localObject8).getString("content");
      i = ((Bundle)localObject8).getInt("seq");
      localObject5 = (anvu)((QQAppInterface)localObject7).a(8);
      if (localObject5 != null) {
        if (((anvu)localObject5).a((String)localObject1, 0).longValue() > 0L) {
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
      break label748;
      bool = false;
      continue;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      if (localObject1 != null) {
        ((aoip)localObject1).j((String)localObject5);
      }
      if (!QLog.isDevelopLevel()) {
        break label748;
      }
      QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject5 }));
      break label748;
      if (localObject6 == null) {
        break label748;
      }
      localObject1 = ((Bundle)localObject8).getString("methord_name");
      if ("getGroupInArea".equals(localObject1))
      {
        ((aoat)localObject6).a(((Bundle)localObject8).getString("areaName"), ((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("startIndex"), ((Bundle)localObject8).getInt("count"), ((Bundle)localObject8).getInt("iFilterId"));
        break label748;
      }
      if ("getNearbyTroops".equals(localObject1))
      {
        ((aoat)localObject6).a(((Bundle)localObject8).getBoolean("isFirst"), ((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("sortType"), ((Bundle)localObject8).getString("strGroupArea"), ((Bundle)localObject8).getInt("iFilterId"));
        break label748;
      }
      if ("getAreaList".equals(localObject1))
      {
        ((aoat)localObject6).a(((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"), ((Bundle)localObject8).getInt("radius"), ((Bundle)localObject8).getBoolean("isClickable"));
        break label748;
      }
      if (!"getNewNearbyTroop".equals(localObject1)) {
        break label748;
      }
      ((aoat)localObject6).a(((Bundle)localObject8).getInt("lat"), ((Bundle)localObject8).getInt("lon"));
      break label748;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject6 = ((Bundle)localObject8).getString("memberUin");
      i = ((Bundle)localObject8).getInt("titleId");
      localObject7 = (TroopManager)((AppRuntime)localObject7).getManager(52);
      if ((localObject7 == null) || (i <= 0)) {
        break label748;
      }
      ((TroopManager)localObject7).a((String)localObject5, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
      ((aoip)localObject1).notifyUI(144, true, new Object[] { localObject5, localObject6, Integer.valueOf(i) });
      break label748;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject5 = ((Bundle)localObject8).getStringArray("paths");
      if (((localObject7 instanceof QQAppInterface)) && (localObject5 != null) && (localObject5.length > 0))
      {
        localObject6 = (bbav)((AppRuntime)localObject7).getManager(36);
        if (localObject6 != null)
        {
          localObject7 = new int[localObject5.length];
          localObject8 = new int[localObject5.length];
          i = 0;
          if (i < localObject8.length)
          {
            localObject9 = ((bbav)localObject6).a(localObject5[i]);
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
      break label748;
      new Bundle().putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject1 = ((Bundle)localObject8).getString("path");
      if (!(localObject7 instanceof QQAppInterface)) {
        break label748;
      }
      localObject5 = (bbav)((AppRuntime)localObject7).getManager(36);
      if (localObject5 == null) {
        break label748;
      }
      ((bbav)localObject5).b((String)localObject1);
      break label748;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject6 = ((Bundle)localObject8).getString("processName");
      if (localObject1 == null) {
        break label748;
      }
      ((aoip)localObject1).b((String)localObject5, (String)localObject6);
      break label748;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("method", "changeAnonymousNick");
      ((Bundle)localObject1).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      l1 = ((Bundle)localObject8).getLong("bubbleId");
      i = ((Bundle)localObject8).getInt("headId");
      localObject6 = ((Bundle)localObject8).getString("nickName");
      j = ((Bundle)localObject8).getInt("expireTime");
      localObject7 = ((Bundle)localObject8).getString("rankColor");
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
      {
        nlj.a().a((String)localObject5, l1, i, (String)localObject6, j, "", (String)localObject7);
        ((Bundle)localObject1).putBoolean("result", true);
      }
      for (;;)
      {
        this.a.a(13, (Bundle)localObject1);
        break;
        ((Bundle)localObject1).putBoolean("result", false);
      }
      i = ((Bundle)localObject8).getInt("appid");
      localObject5 = ((Bundle)localObject8).getString("token");
      ((aoip)localObject1).a(i, ((Bundle)localObject8).getString("openGroupId"), (String)localObject5, ((Bundle)localObject8).getString("url"), ((Bundle)localObject8).getInt("seq"));
      break label748;
      i = ((Bundle)localObject8).getInt("seq");
      if (this.a.jdField_a_of_type_Adne == null) {
        this.a.jdField_a_of_type_Adne = new adne((AppRuntime)localObject7, this.a);
      }
      this.a.jdField_a_of_type_Adne.a(118, (Bundle)localObject8, i);
      break label748;
      i = ((Bundle)localObject8).getInt("appid");
      localObject5 = ((Bundle)localObject8).getString("token");
      ((aoip)localObject1).a(i, ((Bundle)localObject8).getString("openId"), (String)localObject5, ((Bundle)localObject8).getInt("seq"));
      break label748;
      bool = ((Bundle)localObject8).getBoolean("isTroopAppListChanged");
      localObject1 = (bgqm)((AppRuntime)localObject7).getManager(109);
      if (localObject1 == null) {
        break label748;
      }
      ((bgqm)localObject1).a(bool);
      break label748;
      bool = ((Bundle)localObject8).getBoolean("isTroopProfileAppListChanged");
      localObject1 = ((Bundle)localObject8).getString("profileAppListChangedTroopUin");
      localObject5 = (bgqm)((AppRuntime)localObject7).getManager(109);
      if (localObject5 == null) {
        break label748;
      }
      ((bgqm)localObject5).a(bool, (String)localObject1);
      break label748;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      localObject1 = ((Bundle)localObject8).getString("opn");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
        break label748;
      }
      if (((String)localObject1).equals("g_homework"))
      {
        l1 = Long.parseLong((String)localObject5);
        localObject1 = "";
        if (bgsk.a((QQAppInterface)localObject7, l1)) {
          localObject1 = "role=teacher&";
        }
        localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject6).putExtra("url", "https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
        ((Intent)localObject6).setFlags(268435456);
        this.a.startActivity((Intent)localObject6);
        break label748;
      }
      if (!((String)localObject1).equals("g_troop_reward")) {
        break label748;
      }
      bgtu.a((QQAppInterface)localObject7, this.a, (String)localObject5, true);
      break label748;
      ((Bundle)localObject8).putBoolean("isSuccess", true);
      ((Bundle)localObject8).putString("data", TroopBarPublishActivity.w);
      this.a.a(81, (Bundle)localObject8);
      break label748;
      this.a.a((Bundle)localObject8);
      break label748;
      if (TroopMemberApiService.a((AppRuntime)localObject7, new aasu(this, (Bundle)localObject8))) {
        break label748;
      }
      this.a.a(16, (Bundle)localObject8);
      break label748;
      l1 = ((Bundle)localObject8).getLong("uiResId");
      localObject1 = akgr.a().a(l1);
      if ((localObject1 != null) && (((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
      {
        ((Bundle)localObject8).putString("packageName", ((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
        ((Bundle)localObject8).putString("imageUrl", ((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL);
        ((Bundle)localObject8).putString("name", ((arsh)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        if (((arsh)localObject1).jdField_a_of_type_Byte == 0)
        {
          bool = true;
          label3320:
          ((Bundle)localObject8).putBoolean("isOpen", bool);
          ((Bundle)localObject8).putInt("type", 0);
          ((Bundle)localObject8).putBoolean("has", true);
        }
      }
      for (;;)
      {
        this.a.a(18, (Bundle)localObject8);
        break;
        bool = false;
        break label3320;
        ((Bundle)localObject8).putBoolean("has", false);
      }
      akgr.jdField_a_of_type_Int |= 0x1;
      bool = ((Bundle)localObject8).getBoolean("isChecked");
      l1 = ((Bundle)localObject8).getLong("uiResId");
      ((Bundle)localObject8).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
      this.a.a(17, (Bundle)localObject8);
      break label748;
      localObject5 = ((Bundle)localObject8).getString("troopUin");
      Object localObject9 = ((Bundle)localObject8).getString("troopName");
      ((Bundle)localObject8).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject7).getManager(52);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).b((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject9);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject7).getCurrentAccountUin();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      for (;;)
      {
        String str2;
        for (;;)
        {
          localObject9 = (aoip)((QQAppInterface)localObject7).a(20);
          if (localObject9 != null) {
            ((aoip)localObject9).j((String)localObject5);
          }
          if ((localObject6 != null) && (localObject1 != null)) {
            ((TroopManager)localObject6).e((TroopInfo)localObject1);
          }
          if (!(localObject7 instanceof QQAppInterface)) {
            break;
          }
          this.a.a(19, (Bundle)localObject8);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          l1 = ((Bundle)localObject8).getLong("troopCode");
          localObject1 = ((Bundle)localObject8).getString("filePath");
          localObject5 = ((Bundle)localObject8).getString("fileName");
          l2 = ((Bundle)localObject8).getLong("fileSize");
          i = ((Bundle)localObject8).getInt("busid");
          localObject1 = bgsk.a((QQAppInterface)localObject7, l1, null, (String)localObject1, (String)localObject5, l2, i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
          if (!TextUtils.isEmpty(((Bundle)localObject8).getString("callback"))) {
            ((Bundle)localObject5).putString("callback", ((Bundle)localObject8).getString("callback"));
          }
          ((Bundle)localObject5).putString("method", "getFileInfo");
          TroopMemberApiService.a(this.a, (QQAppInterface)localObject7, l1, HWTroopFileStatusInfo.parse((bftf)localObject1), (Bundle)localObject5);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Txp == null) {
            this.a.jdField_a_of_type_Txp = new txp(this.a, (QQAppInterface)localObject7);
          }
          if (((Bundle)localObject8).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Txp.a((Bundle)localObject8);
            break;
          }
          this.a.jdField_a_of_type_Txp.c((Bundle)localObject8);
          break;
          if ((!(localObject7 instanceof QQAppInterface)) || (localObject8 == null)) {
            break;
          }
          if (this.a.jdField_a_of_type_Txp == null) {
            this.a.jdField_a_of_type_Txp = new txp(this.a, (QQAppInterface)localObject7);
          }
          if (((Bundle)localObject8).getBoolean("is_pic_or_voice"))
          {
            this.a.jdField_a_of_type_Txp.b((Bundle)localObject8);
            break;
          }
          this.a.jdField_a_of_type_Txp.d((Bundle)localObject8);
          break;
          if (this.a.jdField_a_of_type_Txp == null) {
            break;
          }
          this.a.jdField_a_of_type_Txp.a();
          break;
          this.a.d = ((Bundle)localObject8).getInt("appId");
          this.a.e = ((Bundle)localObject8).getInt("seq");
          if (this.a.d == 0) {
            break;
          }
          localObject1 = (bgqm)((AppRuntime)localObject7).getManager(109);
          if (localObject1 == null) {
            break;
          }
          localObject5 = new ArrayList();
          if ((((bgqm)localObject1).a(0)) && (!((bgqm)localObject1).b(0)))
          {
            localObject6 = ((bgqm)localObject1).a(false, 0);
            if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
            {
              localObject6 = ((List)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (TroopAIOAppInfo)((Iterator)localObject6).next();
                ((ArrayList)localObject5).add(Integer.valueOf(((TroopAIOAppInfo)localObject7).appid));
                if (((TroopAIOAppInfo)localObject7).appid == this.a.d)
                {
                  QQToast.a(BaseApplication.getContext(), 2, 2131718815, 0).b(this.a.getResources().getDimensionPixelSize(2131299011));
                  return;
                }
              }
            }
            ((ArrayList)localObject5).add(Integer.valueOf(this.a.d));
            localObject6 = new ArrayList();
            ((ArrayList)localObject6).add(Integer.valueOf(this.a.d));
            ((bgqm)localObject1).a((ArrayList)localObject5, (ArrayList)localObject6);
            break;
          }
          this.a.jdField_a_of_type_Boolean = true;
          ((bgqm)localObject1).a(true, 0);
          break;
          l1 = ((Bundle)localObject8).getLong("roomid", 0L);
          localObject1 = ((Bundle)localObject8).getString("roomname");
          localObject5 = ((Bundle)localObject8).getString("userdata");
          localObject6 = ((Bundle)localObject8).getString("vasname");
          i = ((Bundle)localObject8).getInt("fromid", 0);
          ((awdu)((QQAppInterface)localObject7).getManager(108)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
          break;
          localObject1 = ((Bundle)localObject8).getString("appType");
          localObject5 = ((Bundle)localObject8).getString("openType");
          localObject6 = ((Bundle)localObject8).getString("uri");
          localObject9 = ((Bundle)localObject8).getString("action");
          str2 = ((Bundle)localObject8).getString("pluginPackageName");
          localObject8 = ((Bundle)localObject8).getString("pluginParams");
          awbc.a((QQAppInterface)localObject7, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject9, str2, (String)localObject8);
          break;
          localObject1 = ((Bundle)localObject8).getString("pluginPackageName");
          localObject5 = ((Bundle)localObject8).getString("appType");
          awat.a(((QQAppInterface)localObject7).getApp(), (String)localObject1, (String)localObject5).a();
          break;
          try
          {
            l1 = ((Bundle)localObject8).getLong("troopPubAccountUin");
            localObject1 = ((Bundle)localObject8).getLongArray("troopUinList");
            if ((localObject1 == null) || (localObject1.length <= 0)) {
              break;
            }
            localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
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
        break label748;
        Object localObject2 = ((Bundle)localObject8).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
        if (localObject5 == null) {
          break label748;
        }
        localObject2 = ((TroopManager)localObject5).b((String)localObject2);
        if (localObject2 == null) {
          break label748;
        }
        ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
        ((TroopManager)localObject5).b((TroopInfo)localObject2);
        break label748;
        localObject2 = ((Bundle)localObject8).getString("troopUin");
        localObject5 = (TroopManager)((AppRuntime)localObject7).getManager(52);
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
              ((Bundle)localObject8).putBoolean("hasOrgs", bool);
              this.a.a(46, (Bundle)localObject8);
              break label748;
              bool = false;
              continue;
              localObject2 = ((Bundle)localObject8).getString("localFilePath");
              localObject5 = ((Bundle)localObject8).getString("fileDisPlayName");
              bgpk.a(this.a, (String)localObject2, (String)localObject5);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              i = ((Bundle)localObject8).getInt("rewardMoney");
              localObject5 = ((Bundle)localObject8).getString("rewardContent");
              localObject6 = ((Bundle)localObject8).getString("mediaPath");
              j = ((Bundle)localObject8).getInt("rewardType");
              bgtu.jdField_a_of_type_Int = ((Bundle)localObject8).getInt("imageMaxWidthPixels", 1080);
              bgtu.b = ((Bundle)localObject8).getInt("imageMaxHeightPixels", 1920);
              ((bgtu)((AppRuntime)localObject7).getManager(152)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
              break label748;
              ((aoip)localObject2).a(((Bundle)localObject8).getLong("troopUin"), ((Bundle)localObject8).getInt("flag"));
              break label748;
              localObject2 = (QQAppInterface)localObject7;
              ((Bundle)localObject8).putInt("fontSize", QQAppInterface.b);
              this.a.a(52, (Bundle)localObject8);
              break label748;
              i = ((Bundle)localObject8).getInt("fontSize", 1);
              localObject2 = (QQAppInterface)localObject7;
              QQAppInterface.b = i;
              ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("rewardId");
              localObject5 = ((bgtu)((AppRuntime)localObject7).getManager(152)).a((String)localObject2, (String)localObject5);
              localObject2 = "";
              if (localObject5 != null) {
                localObject2 = ((MessageForTroopReward)localObject5).mediaPath;
              }
              ((Bundle)localObject8).putString("videoPath", (String)localObject2);
              this.a.a(55, (Bundle)localObject8);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("largeImageFile");
              localObject6 = ((Bundle)localObject8).getString("fileName");
              l1 = ((Bundle)localObject8).getLong("progressTotal");
              i = ((Bundle)localObject8).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject7, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("filePath");
              localObject6 = ((Bundle)localObject8).getString("fileName");
              i = ((Bundle)localObject8).getInt("size");
              j = ((Bundle)localObject8).getInt("busId");
              TroopFileTransferManager.a((QQAppInterface)localObject7, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, j, i);
              break label748;
              localObject5 = (TroopPluginManager)((AppRuntime)localObject7).getManager(119);
              localObject6 = ((Bundle)localObject8).getString("troopUin");
              i = ((Bundle)localObject8).getInt("seq");
              localObject7 = ((Bundle)localObject8).getString("processName");
              if (localObject5 == null) {
                break label748;
              }
              ((TroopPluginManager)localObject5).a("troop_manage_plugin.apk", new aasx(this, (aoip)localObject2, (String)localObject6, i, (String)localObject7));
              break label748;
              localObject2 = ((Bundle)localObject8).getString("appid");
              localObject5 = ((Bundle)localObject8).getString("pkgname");
              this.a.a((String)localObject5, (String)localObject2);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("hashName");
              ((Bundle)localObject8).putByteArray("decryptResult", PreloadManager.a().b((String)localObject2));
              this.a.a(66, (Bundle)localObject8);
              break label748;
              ((aoip)localObject2).a(((Bundle)localObject8).getString("troopUin"), "", ((Bundle)localObject8).getInt("statOption"), ((Bundle)localObject8).getString("authKey"), null, null, null);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("groupCode");
              localObject5 = ((Bundle)localObject8).getString("groupMemberUin");
              i = ((Bundle)localObject8).getInt("seq");
              ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (TroopManager)((AppRuntime)localObject7).getManager(52), (String)localObject2, (String)localObject5, (Bundle)localObject8, i), 8, null, true);
              break label748;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              localObject5 = ((bihw)((AppRuntime)localObject7).getManager(47)).a(1);
              localObject6 = new File(axut.jdField_a_of_type_JavaLangString + File.separator + "nearby_heart.mp4");
              if (!((File)localObject6).exists()) {
                ((File)localObject6).mkdirs();
              }
              for (;;)
              {
                ((bihz)localObject5).a(new bihu("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject6), new aasy(this, (Bundle)localObject2), new Bundle());
                break;
                ((File)localObject6).delete();
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              bool = false;
              if ((localObject7 instanceof QQAppInterface))
              {
                localObject5 = (QQAppInterface)localObject7;
                if ((!((QQAppInterface)localObject5).d()) || (((QQAppInterface)localObject5).a().k())) {
                  break label5701;
                }
              }
              label5701:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
                this.a.a(84, (Bundle)localObject2);
                break;
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("seq", ((Bundle)localObject8).getInt("seq", -1));
              if ((localObject7 instanceof QQAppInterface))
              {
                localObject6 = (bgpt)((AppRuntime)localObject7).getManager(224);
                if (localObject6 != null)
                {
                  localObject5 = ((bgpt)localObject6).a();
                  localObject6 = ((bgpt)localObject6).b();
                  ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject5);
                  ((Bundle)localObject2).putString("title", (String)localObject6);
                }
              }
              this.a.a(76, (Bundle)localObject2);
              break label748;
              if (!(localObject7 instanceof QQAppInterface)) {
                break label748;
              }
              bool = bdek.a((QQAppInterface)localObject7, BaseApplicationImpl.getContext());
              if (!QLog.isColorLevel()) {
                break label748;
              }
              QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
              break label748;
              ((Bundle)localObject8).putInt("currentFragment", SplashActivity.jdField_a_of_type_Int);
              this.a.a(80, (Bundle)localObject8);
              break label748;
              localObject2 = (rxd)((AppRuntime)localObject7).getManager(226);
              ((rxd)localObject2).a(this.a);
              ((rxd)localObject2).a(((Bundle)localObject8).getString("videoPath"), (Bundle)localObject8);
              break label748;
              i = ((Bundle)localObject8).getInt("subCmd");
              localObject2 = (bfui)((QQAppInterface)localObject7).getManager(231);
              switch (i)
              {
              }
              for (;;)
              {
                this.a.a(87, (Bundle)localObject8);
                break;
                ((bfui)localObject2).a(((Bundle)localObject8).getInt("effectId"), ((Bundle)localObject8).getString("effectName"), ((Bundle)localObject8).getInt("svipLevel"), ((Bundle)localObject8).getInt("svipType"));
                continue;
                localObject5 = ((Bundle)localObject8).getStringArrayList("statusList");
                if (localObject5 != null) {
                  ((bfui)localObject2).a((ArrayList)localObject5);
                }
              }
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("path");
              i = ((Bundle)localObject8).getInt("msgTailType", 0);
              localObject6 = new Intent();
              ((Intent)localObject6).putExtra("send_in_background", true);
              ((Intent)localObject6).putExtra("file_send_path", (String)localObject5);
              ((Intent)localObject6).putExtra("file_send_size", new File((String)localObject5).length());
              ((Intent)localObject6).putExtra("file_send_duration", ShortVideoUtils.b((String)localObject5));
              ((Intent)localObject6).putExtra("uin", (String)localObject2);
              ((Intent)localObject6).putExtra("uintype", 1);
              ((Intent)localObject6).putExtra("file_source", "album_flow");
              ((Intent)localObject6).putExtra("short_video_msg_tail_type", i);
              new amhm((Intent)localObject6).execute(new Void[0]);
              this.a.a(87, (Bundle)localObject8);
              break label748;
              l1 = ((Bundle)localObject8).getLong("roomId");
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("jumpType", 1);
              ((Bundle)localObject2).putString("roomid", String.valueOf(l1));
              ((awcc)((AppRuntime)localObject7).getManager(306)).a((Bundle)localObject2);
              break label748;
              ((awcc)((AppRuntime)localObject7).getManager(306)).a();
              break label748;
              if (this.a.jdField_b_of_type_Boolean) {
                break;
              }
              this.a.jdField_b_of_type_Boolean = true;
              bool = bhnv.g(null);
              VideoEnvironment.a("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
              if (bool)
              {
                VideoEnvironment.a("TroopMemberApiService", anzj.a(2131714426), null);
                ShortVideoResourceManager.b((QQAppInterface)localObject7, new aasz(this, (AppRuntime)localObject7, (Bundle)localObject8));
                break label748;
              }
              ((Bundle)localObject8).putInt("result", -1);
              this.a.a(93, (Bundle)localObject8);
              break label748;
              i = ((Bundle)localObject8).getInt("isGroupCode");
              localObject2 = ((Bundle)localObject8).getString("roomId");
              localObject5 = ((Bundle)localObject8).getString("action");
              localObject6 = ((Bundle)localObject8).getString("fromId");
              localObject9 = ((Bundle)localObject8).getString("backType");
              str2 = ((Bundle)localObject8).getString("openType");
              localObject8 = ((Bundle)localObject8).getString("extra");
              ((awaa)((AppRuntime)localObject7).getManager(236)).a(this.a, (String)localObject2, ((QQAppInterface)localObject7).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject9, str2, (String)localObject8);
              break label748;
              ((Bundle)localObject8).getString("fromId");
              ((awaa)((AppRuntime)localObject7).getManager(236)).a(null, 10L);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("uin");
              i = ((Bundle)localObject8).getInt("index");
              localObject2 = nwo.a().a((String)localObject2);
              if (localObject2 == null) {
                break label748;
              }
              localObject5 = (nws)((AppRuntime)localObject7).getManager(238);
              if (localObject5 == null) {
                break label748;
              }
              ((nws)localObject5).a((nwf)localObject2, i);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = ((Bundle)localObject8).getString("nick");
              localObject7 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject7 == null) {
                break label748;
              }
              ((anzp)localObject7).a((String)localObject2, (String)localObject5, (String)localObject6);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject6 == null) {
                break label748;
              }
              ((anzp)localObject6).a((String)localObject2, (String)localObject5);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject5 == null) {
                break label748;
              }
              ((anzp)localObject5).a((String)localObject2);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = ((Bundle)localObject8).getString("nick");
              localObject7 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject7 == null) {
                break label748;
              }
              ((anzp)localObject7).b((String)localObject2, (String)localObject5, (String)localObject6);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("troopCode");
              localObject5 = ((Bundle)localObject8).getString("uin");
              localObject6 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject6 == null) {
                break label748;
              }
              ((anzp)localObject6).b((String)localObject2, (String)localObject5);
              break label748;
              ((Bundle)localObject8).getString("troopCode");
              localObject2 = ((Bundle)localObject8).getString("rid");
              localObject5 = new aatb(this, (Bundle)localObject8);
              this.a.jdField_a_of_type_Aoaf = new aoaf((QQAppInterface)localObject7, (aoag)localObject5, (String)localObject2);
              this.a.jdField_a_of_type_Aoaf.b(10000L);
              break label748;
              this.a.f = ((Bundle)localObject8).getInt("seq", -1);
              localObject2 = ((Bundle)localObject8).getStringArrayList("tinyIdList");
              localObject5 = (anzp)((QQAppInterface)localObject7).a(35);
              if (localObject5 == null) {
                break label748;
              }
              ((anzp)localObject5).a((ArrayList)localObject2);
              break label748;
              localObject2 = ((Bundle)localObject8).getString("schoolName");
              i = ((Bundle)localObject8).getInt("isValid");
              localObject5 = (axxj)((QQAppInterface)localObject7).a(60);
              if (localObject5 == null) {
                break label748;
              }
              ((axxj)localObject5).a((String)localObject2, i);
              break label748;
              localObject2 = ((Bundle)localObject8).getStringArrayList("preloadList");
              localObject5 = (nzi)((AppRuntime)localObject7).getManager(248);
              if (localObject5 == null) {
                break label748;
              }
              ((nzi)localObject5).a((ArrayList)localObject2);
              break label748;
              localObject2 = (nzi)((AppRuntime)localObject7).getManager(248);
              if (localObject2 == null) {
                break label748;
              }
              ((nzi)localObject2).a();
              break label748;
              i = ((Bundle)localObject8).getInt("topicId");
              j = ((Bundle)localObject8).getInt("followInfo");
              if (pfa.a().a(i, j)) {
                break label748;
              }
              pfa.a().d(i, j);
              break label748;
              ((Bundle)localObject8).putInt("readinjoy_to_wx_config", bnrf.r((AppRuntime)localObject7));
              this.a.a(113, (Bundle)localObject8);
              break label748;
              ((wja)((QQAppInterface)localObject7).a(98)).c(((Bundle)localObject8).getInt("reqUserSetEnableAlbumScan"));
              break label748;
              if (this.a.jdField_a_of_type_Psb == null) {
                this.a.jdField_a_of_type_Psb = new psb((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Psb.b((Bundle)localObject8);
              break label748;
              if (this.a.jdField_a_of_type_Psb == null) {
                this.a.jdField_a_of_type_Psb = new psb((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Psb.c((Bundle)localObject8);
              break label748;
              if (this.a.jdField_a_of_type_Psb == null) {
                this.a.jdField_a_of_type_Psb = new psb((AppRuntime)localObject7, this.a);
              }
              this.a.jdField_a_of_type_Psb.a((Bundle)localObject8);
              break label748;
              this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject8).getString("callback");
              this.a.g = ((Bundle)localObject8).getInt("seq");
              localObject5 = ((Bundle)localObject8).getString("troopUin");
              localObject6 = ((Bundle)localObject8).getString("chatType");
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && ("group".equals(localObject6)))
              {
                if (localObject2 == null) {
                  break label748;
                }
                ((aoip)localObject2).a((String)localObject5, false, "TroopMemberApiService111", true, true, false, false);
                break label748;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject5 + ", chatType=" + (String)localObject6);
              }
              localObject2 = new Bundle();
              ((Bundle)localObject2).putBoolean("isSuccess", false);
              ((Bundle)localObject2).putInt("seq", this.a.g);
              ((Bundle)localObject2).putString("callback", this.a.jdField_c_of_type_JavaLangString);
              this.a.a(112, (Bundle)localObject2);
              break label748;
              localObject2 = new Intent(((QQAppInterface)localObject7).getApp().getApplicationContext(), SplashActivity.class);
              ((Intent)localObject2).putExtras((Bundle)localObject8);
              localObject2 = agej.a((Intent)localObject2, null);
              localObject5 = ForwardUtils.a((Intent)localObject2);
              ForwardUtils.a((QQAppInterface)localObject7, ((QQAppInterface)localObject7).getApp().getApplicationContext(), (SessionInfo)localObject5, (Intent)localObject2);
              break label748;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_BEACON_REPORT");
              }
              bdwp.a(((Bundle)localObject8).getBundle("reportData"));
              break label748;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_PRELOAD");
              }
              if (!(localObject7 instanceof QQAppInterface)) {
                break label748;
              }
              ((bdvj)((AppRuntime)localObject7).getManager(362)).a(BaseApplicationImpl.getContext());
              break label748;
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
              }
              localObject2 = ((Bundle)localObject8).getString("troopUin");
              localObject5 = ((Bundle)localObject8).getString("type");
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject5)) || (bgpk.a((QQAppInterface)localObject7, (String)localObject2) == 0)) {
                break label748;
              }
              bgpk.a((QQAppInterface)localObject7, (String)localObject2);
              break label748;
              l1 = ((Bundle)localObject8).getLong("followUin");
              i = ((Bundle)localObject8).getInt("followInfo");
              if ((i != 2) && (i != 1)) {
                break label748;
              }
              localObject2 = pfd.a();
              if (i == 2) {}
              for (bool = true;; bool = false)
              {
                ((pfd)localObject2).b(l1, bool);
                ThreadManager.post(new TroopMemberApiService.IncomingHandler.8(this, l1, i), 8, null, true);
                break;
              }
              localObject5 = ((Bundle)localObject8).getString("url");
              i = ((Bundle)localObject8).getInt("type", -1);
              j = ((Bundle)localObject8).getInt("msgfrom", 0);
              localObject6 = ((Bundle)localObject8).getString("senderUin");
              localObject9 = ((Bundle)localObject8).getString("chatId");
              str2 = ((Bundle)localObject8).getString("source");
              k = ((Bundle)localObject8).getInt("seq");
              localObject2 = ((Bundle)localObject8).getString("processName");
              localObject8 = ((Bundle)localObject8).getString("originUrl");
              localObject7 = (bimo)((AppRuntime)localObject7).getManager(290);
              if (localObject7 != null)
              {
                ((bimo)localObject7).a((String)localObject5, i, j, (String)localObject6, (String)localObject9, str2, (String)localObject8, new aatc(this, k, (String)localObject2));
                break label748;
              }
              localObject5 = new Bundle();
              ((Bundle)localObject5).putInt("seq", k);
              ((Bundle)localObject5).putString("processName", (String)localObject2);
              this.a.a(121, (Bundle)localObject5);
              break label748;
              try
              {
                localObject2 = (bimo)((AppRuntime)localObject7).getManager(290);
                if (localObject2 == null) {
                  break label8095;
                }
                ((bimo)localObject2).a((Bundle)localObject8);
              }
              catch (Throwable localThrowable)
              {
                QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
              }
            }
            break label748;
            label8095:
            if (!QLog.isColorLevel()) {
              break label748;
            }
            QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
            break label748;
            Object localObject3 = (bimo)((AppRuntime)localObject7).getManager(290);
            localObject5 = ((Bundle)localObject8).getString("appid");
            localObject6 = ((Bundle)localObject8).getString("openid");
            localObject7 = ((Bundle)localObject8).getString("troopuin");
            i = ((Bundle)localObject8).getInt("seq");
            localObject8 = ((Bundle)localObject8).getString("processName");
            if (localObject3 != null)
            {
              ((bimo)localObject3).a((String)localObject5, (String)localObject6, (String)localObject7, new aasv(this, i, (String)localObject8));
              break label748;
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("seq", i);
            ((Bundle)localObject3).putString("processName", (String)localObject8);
            ((Bundle)localObject3).putInt("result", -1);
            this.a.a(146, (Bundle)localObject3);
            break label748;
            ((Bundle)localObject8).putString("nickName", ((QQAppInterface)localObject7).getCurrentNickname());
            this.a.a(128, (Bundle)localObject8);
            break label748;
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject3 = this.a.getApplicationContext())
            {
              KandianSubscribeManager.a((Context)localObject3, 3, 4);
              break;
            }
            if (((Bundle)localObject8).getBoolean("open_readinjoy_tab"))
            {
              bnrf.d(1);
              bnrf.a(true);
              bnrf.a(true);
            }
            if (BaseActivity.sTopActivity != null) {}
            for (localObject3 = BaseActivity.sTopActivity;; localObject4 = this.a.getApplicationContext())
            {
              for (;;)
              {
                if (!bnrf.j()) {
                  break label8454;
                }
                j = 12;
                try
                {
                  localObject5 = ((Bundle)localObject8).getString("from");
                  i = j;
                  if (!TextUtils.isEmpty((CharSequence)localObject5))
                  {
                    i = j;
                    if (TextUtils.isDigitsOnly((CharSequence)localObject5)) {
                      i = Integer.valueOf((String)localObject5).intValue();
                    }
                  }
                  ((Context)localObject3).startActivity(oix.a((Context)localObject3, i));
                }
                catch (Exception localException2) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
              break;
            }
            label8454:
            localObject5 = (QQAppInterface)localObject7;
            if (bnrf.a((QQAppInterface)localObject5))
            {
              oix.a((QQAppInterface)localObject5, (Context)localObject4, 2, 0);
              break label748;
            }
            oix.a((Context)localObject4, null, -1L, 2);
            break label748;
            i = ((Bundle)localObject8).getInt("seq");
            localObject4 = (QQAppInterface)localObject7;
            localObject5 = ((anyw)((AppRuntime)localObject7).getManager(51)).b(((QQAppInterface)localObject4).c());
            if (localObject5 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, "get user gender:" + ((Card)localObject5).shGender);
              }
              ((Bundle)localObject8).putShort("gender", ((Card)localObject5).shGender);
            }
            ((Bundle)localObject8).putString("facePath", ((QQAppInterface)localObject4).a(1, ((QQAppInterface)localObject4).getCurrentAccountUin(), 0));
            ((Bundle)localObject8).putInt("seq", i);
            this.a.a(126, (Bundle)localObject8);
            break label748;
            i = ((Bundle)localObject8).getInt("start");
            j = ((Bundle)localObject8).getInt("msgType");
            int k = ((Bundle)localObject8).getInt("count");
            localObject4 = bfcm.a(this.a.getApplicationContext(), (QQAppInterface)localObject7, i, j, k);
            if (localObject4 != null) {
              ((Bundle)localObject8).putString("sayhiinfo", ((JSONObject)localObject4).toString());
            }
            this.a.a(129, (Bundle)localObject8);
            break label748;
            i = ((Bundle)localObject8).getInt("clearType");
            j = ((Bundle)localObject8).getInt("msgType");
            localObject4 = ((Bundle)localObject8).getString("uin");
            bfcm.a((QQAppInterface)localObject7, (String)localObject4, i, j);
            break label748;
            i = ((Bundle)localObject8).getInt("deleteType");
            localObject4 = ((Bundle)localObject8).getString("uin");
            j = ((Bundle)localObject8).getInt("msgType");
            bfcm.b((QQAppInterface)localObject7, (String)localObject4, i, j);
            break label748;
            bool = ((Bundle)localObject8).getBoolean("isSuccess");
            localObject4 = ((Bundle)localObject8).getString("pkgname");
            pfd.a().a(null, 101, bool, new String[] { localObject4 });
            break label748;
            localObject4 = tqr.a(2);
            if ((localObject4 == null) || (!(localObject4 instanceof tmb))) {
              break label748;
            }
            ((tmb)localObject4).a((Bundle)localObject8);
            break label748;
            tqa.a();
            break label748;
            b((Bundle)localObject8);
            this.a.a(141, (Bundle)localObject8);
            break label748;
            localObject4 = ((Bundle)localObject8).getString("uin");
            aank.c(BaseApplicationImpl.getContext(), (String)localObject4, null);
            break label748;
            localObject5 = ((Bundle)localObject8).getString("code");
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
              if (this.a.jdField_a_of_type_Anve == null)
              {
                this.a.jdField_a_of_type_Anve = ((anve)((AppRuntime)localObject7).getManager(59));
                this.a.jdField_a_of_type_Anve.a(this);
              }
              localObject5 = new Intent(BaseApplicationImpl.getContext(), LocationSelectActivity.class);
              ((Intent)localObject5).putExtra("param_is_popup", false);
              ((Intent)localObject5).putExtra("param_req_type", 2);
              ((Intent)localObject5).putExtra("param_location", (String[])localObject4);
              ((Intent)localObject5).putExtra("param_location_param", this.a.jdField_a_of_type_Anve.b((String[])localObject4));
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
          bool = ((Bundle)localObject8).getBoolean("isOpen");
          localObject4 = ((Bundle)localObject8).getString("troopUin");
          if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject4, Boolean.valueOf(bool) }));
          }
          ((bggj)((AppRuntime)localObject7).getManager(346)).a((String)localObject4, bool);
          break label748;
          localObject4 = ((Bundle)localObject8).getString("groupCode");
          String str1 = ((Bundle)localObject8).getString("appID");
          localObject6 = ((Bundle)localObject8).getString("url");
          localObject7 = ((Bundle)localObject8).getString("source");
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", new Object[] { localObject4, str1, localObject6, localObject7 }));
          }
          localObject7 = new SessionInfo();
          ((SessionInfo)localObject7).jdField_a_of_type_JavaLangString = ((String)localObject4);
          ((SessionInfo)localObject7).jdField_a_of_type_Int = 1;
          if (BaseActivity.sTopActivity != null)
          {
            localObject4 = BaseActivity.sTopActivity;
            label9400:
            if ((localObject4 instanceof BaseActivity)) {
              break label9616;
            }
            localObject4 = null;
          }
          label9616:
          for (;;)
          {
            bgqr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), (BaseActivity)localObject4, (SessionInfo)localObject7, Long.parseLong(str1), (String)localObject6, 1, 0);
            break;
            localObject4 = this.a.getApplicationContext();
            break label9400;
            short s = ((Bundle)localObject8).getShort("tmpPushType");
            ((Bundle)localObject8).putBoolean("enable", ((axae)((AppRuntime)localObject7).getManager(303)).a(s));
            ((Bundle)localObject8).putInt("seq", ((Bundle)localObject8).getInt("seq"));
            this.a.a(151, (Bundle)localObject8);
            break;
            s = ((Bundle)localObject8).getShort("tmpPushType");
            bool = ((Bundle)localObject8).getBoolean("enable");
            ((axae)((AppRuntime)localObject7).getManager(303)).a(s, bool, true);
            ((Bundle)localObject8).putBoolean("enable", bool);
            ((Bundle)localObject8).putBoolean("success", true);
            ((Bundle)localObject8).putInt("seq", ((Bundle)localObject8).getInt("seq"));
            this.a.a(152, (Bundle)localObject8);
            break;
            a((Bundle)localObject8);
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
 * Qualified Name:     aast
 * JD-Core Version:    0.7.0.1
 */