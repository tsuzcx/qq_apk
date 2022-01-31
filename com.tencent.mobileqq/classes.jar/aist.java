import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloPushManager.2;
import com.tencent.mobileqq.apollo.ApolloPushManager.3;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4;

public class aist
  implements Manager
{
  public aisv a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<aisv> jdField_a_of_type_MqqUtilWeakReference;
  private WeakReference<aisw> b;
  
  public aist(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aisv = new aisu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if ((airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (localairz != null) && (1 == localairz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
      return true;
    }
    QLog.i("ApolloPushManager", 1, "isNeedPushBySwitch false");
    return false;
  }
  
  public void a(int paramInt, apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[onRecvActionPush], aioType:" + paramInt);
    }
    if (paramSTPushMsgElem == null) {
      return;
    }
    try
    {
      int i = paramSTPushMsgElem.showPlace.get();
      int j = paramSTPushMsgElem.type.get();
      if ((1 != j) || (1 != i))
      {
        QLog.i("ApolloPushManager", 1, "[onRecvActionPush], It doesn't meet show conditions, type:" + j + ",showPlace:" + i);
        return;
      }
    }
    catch (Exception paramSTPushMsgElem)
    {
      paramSTPushMsgElem.printStackTrace();
      QLog.e("ApolloPushManager", 1, "errInfo->" + paramSTPushMsgElem.getMessage());
      return;
    }
    Object localObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)paramSTPushMsgElem.pm1.get();
    paramSTPushMsgElem = new ApolloActionPush();
    paramSTPushMsgElem.mId = NetConnInfoCenter.getServerTimeMillis();
    paramSTPushMsgElem.mActionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionId.get();
    paramSTPushMsgElem.mActionType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionType.get();
    paramSTPushMsgElem.mAioType = ApolloUtil.c(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).aioType.get());
    paramSTPushMsgElem.mContent = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).diyWords.get();
    paramSTPushMsgElem.mRcvUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).rcvUin.get();
    paramSTPushMsgElem.mSendUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sendUin.get();
    if (!ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.w("ApolloPushManager", 1, "NOT apollo user, return.");
      return;
    }
    paramSTPushMsgElem.mWordShowType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).wordType.get();
    String str;
    if (paramInt == 0)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str)) && (str.equals(Long.toString(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get())))) {
        if ((str.equals(Long.toString(paramSTPushMsgElem.mRcvUin))) || (0L == paramSTPushMsgElem.mRcvUin)) {
          paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mSendUin;
        }
      }
    }
    for (;;)
    {
      paramSTPushMsgElem.print();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      ((ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramSTPushMsgElem);
      ThreadManager.post(new ApolloPushManager.2(this, paramInt, paramSTPushMsgElem), 5, null, true);
      if (paramInt == 0) {
        break;
      }
      localObject = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      localObject = String.valueOf(paramSTPushMsgElem.mSendUin);
      paramSTPushMsgElem = String.valueOf(paramSTPushMsgElem.mRcvUin);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str)) && (!str.equals(localObject))) {
        airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, "apllo_redPack_action");
      }
      if ((TextUtils.isEmpty(str)) || (str.equals(paramSTPushMsgElem))) {
        break;
      }
      airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSTPushMsgElem, "apllo_redPack_action");
      return;
      paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mRcvUin;
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
    }
  }
  
  public void a(aisv paramaisv)
  {
    if (paramaisv == null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaisv);
  }
  
  public void a(aisw paramaisw)
  {
    if (paramaisw == null)
    {
      this.b = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[setOnPushObserver]");
    }
    this.b = new WeakReference(paramaisw);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(ApolloActionPush paramApolloActionPush)
  {
    boolean bool = false;
    if (paramApolloActionPush == null)
    {
      QLog.e("ApolloPushManager", 1, "[tiggerAction] pushData is null,return.");
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramApolloActionPush.mActionId;
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = paramApolloActionPush.mAioType;
    localSpriteTaskParam.g = 4;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    localSpriteTaskParam.e = paramApolloActionPush.mActionType;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloActionPush.mContent;
    Object localObject1;
    Object localObject2;
    if (paramApolloActionPush.mWordShowType == 1)
    {
      localSpriteTaskParam.jdField_b_of_type_Boolean = true;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mSendUin);
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mRcvUin);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramApolloActionPush.mSendUin))) {
          bool = true;
        }
        localSpriteTaskParam.jdField_a_of_type_Boolean = bool;
        localObject1 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localObject2 = ((ajmw)localObject1).a(localSpriteTaskParam.f);
        if (localObject2 == null) {
          break label253;
        }
        if (TextUtils.isEmpty(localSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
          localSpriteTaskParam.jdField_c_of_type_JavaLangString = ajkk.a(((ApolloActionData)localObject2).bubbleText);
        }
      }
    }
    for (;;)
    {
      localObject1 = ajfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject1 != null) {
        ((ajfg)localObject1).a().a(localSpriteTaskParam);
      }
      ThreadManager.post(new ApolloPushManager.3(this, paramApolloActionPush, localSpriteTaskParam), 5, null, true);
      return;
      localSpriteTaskParam.jdField_b_of_type_Boolean = false;
      break;
      label253:
      localObject2 = Collections.synchronizedList(new ArrayList());
      ApolloActionData localApolloActionData = new ApolloActionData();
      localApolloActionData.actionId = localSpriteTaskParam.f;
      ((List)localObject2).add(localApolloActionData);
      ((ajmw)localObject1).a((List)localObject2);
    }
  }
  
  public void a(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (!paramSTPushMsgElem.pm4.has()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPushManager", 1, "[onReceiveApolloPush] msg null or pms none");
    }
    int j;
    do
    {
      do
      {
        return;
        paramSTPushMsgElem = paramSTPushMsgElem.pm4.get();
      } while (paramSTPushMsgElem == null);
      j = 0;
    } while (j >= paramSTPushMsgElem.size());
    Object localObject1 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)paramSTPushMsgElem.get(j);
    int k;
    int m;
    if (localObject1 != null)
    {
      k = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).appid.get();
      m = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).newVer.get();
      localObject1 = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).name.get();
      QLog.i("ApolloPushManager", 1, "appId:" + k + " newVersion:" + m + " name:" + (String)localObject1);
      switch (k)
      {
      case 204: 
      default: 
        QLog.e("ApolloPushManager", 1, "onReceiveApolloPush unRecognition appId:" + k);
      }
    }
    int i;
    label276:
    boolean bool;
    label369:
    Object localObject2;
    label417:
    label432:
    label606:
    label618:
    long l;
    label817:
    do
    {
      do
      {
        for (;;)
        {
          j += 1;
          break;
          if ((a()) && ("tab_list_android_json_v665".equals(localObject1)))
          {
            i = ApolloUtil.a(1);
            if (m > i)
            {
              ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(true, "onLinePush", 1);
              if (!QLog.isColorLevel()) {
                continue;
              }
              localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" jsonVersion:").append(i).append(" update:");
              if (m <= i) {
                break label369;
              }
            }
            for (bool = true;; bool = false)
            {
              QLog.d("ApolloPushManager", 2, bool);
              break;
              QLog.e("ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
              break label276;
            }
            if ((a()) && (akvj.a().equals(localObject1)))
            {
              i = 0;
              localObject1 = new File(ajmu.av);
              if (!((File)localObject1).exists())
              {
                i = 1;
                int n = (int)akvj.b();
                if (m <= n) {
                  break label606;
                }
                i = 1;
                localObject1 = ajmu.av + "base.zip";
                if (i != 0)
                {
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putLong("version", m);
                  ajhw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, ajmu.at, (Bundle)localObject2, new akvl());
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" localVersion:").append(n).append(" update:");
                if (m <= n) {
                  break label618;
                }
              }
              for (bool = true;; bool = false)
              {
                QLog.d("ApolloPushManager", 2, bool);
                break;
                if ((((File)localObject1).list() != null) && (((File)localObject1).list().length != 0)) {
                  break label417;
                }
                i = 1;
                break label417;
                QLog.e("ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
                break label432;
              }
              if ("apollo_thunder_json_v670".equals(localObject1)) {
                ajjt.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, false);
              }
            }
          }
        }
      } while (!a());
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)localObject1);
          l = ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(1, i) / 1000L;
          if (l != m) {
            ajhw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, i, null, -1, -1, true);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" roleLocalVersion:").append(l).append(" update:");
          if (m <= l) {
            break label817;
          }
          bool = true;
          QLog.d("ApolloPushManager", 2, bool);
        }
        catch (Exception localException1)
        {
          QLog.e("ApolloPushManager", 1, localException1, new Object[0]);
        }
        break;
        bool = false;
      }
    } while (!a());
    for (;;)
    {
      try
      {
        localObject2 = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((!airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) || (localObject2 == null) || (1 != ((airz)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
          break;
        }
        i = Integer.parseInt(localException1);
        l = ((airz)localObject2).a(2, i) / 1000L;
        if (l != m) {
          ajhw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, -1, new int[] { i }, -1, -1, true);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject2 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" localVersion:").append(l).append(" update:");
        if (m <= l) {
          break label1052;
        }
        bool = true;
        QLog.d("ApolloPushManager", 2, bool);
      }
      catch (Exception localException2)
      {
        QLog.e("ApolloPushManager", 2, "apollo dress real time update id:" + localException1, localException2);
      }
      break;
      label1052:
      bool = false;
    }
  }
  
  public void b(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (!paramSTPushMsgElem.pm3.has()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] msg null or pms none");
      return;
    }
    Object localObject2 = paramSTPushMsgElem.pm3.get();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      paramSTPushMsgElem = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      int i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3 localSTPushMsgElem0x3 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)((Iterator)localObject2).next();
        Object localObject3;
        if (localSTPushMsgElem0x3.dotId.get() != 1003)
        {
          localObject3 = new ApolloGameRedDot();
          ((ApolloGameRedDot)localObject3).mDotId = localSTPushMsgElem0x3.dotId.get();
          ((ApolloGameRedDot)localObject3).mStartTime = localSTPushMsgElem0x3.begTs.get();
          ((ApolloGameRedDot)localObject3).mEndTime = localSTPushMsgElem0x3.endTs.get();
          ((ApolloGameRedDot)localObject3).mTipsWording = localSTPushMsgElem0x3.wording.get();
          ((ApolloGameRedDot)localObject3).mGameId = localSTPushMsgElem0x3.busId.get();
          ((ApolloGameRedDot)localObject3).mUrl = localSTPushMsgElem0x3.url.get();
          ((ApolloGameRedDot)localObject3).mActId = localSTPushMsgElem0x3.actId.get();
          ((ApolloGameRedDot)localObject3).mPriority = localSTPushMsgElem0x3.priority.get();
          ((ApolloGameRedDot)localObject3).mSpRegion = localSTPushMsgElem0x3.spRegion.get();
          ((aukn)localObject1).b((aukm)localObject3);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "get_notice", ((ApolloGameRedDot)localObject3).mDotId, 1, new String[] { String.valueOf(((ApolloGameRedDot)localObject3).mGameId), "", ((ApolloGameRedDot)localObject3).mActId });
          ApolloGameUtil.a((aukn)localObject1);
        }
        for (;;)
        {
          break;
          localObject3 = new AioPushData();
          ((AioPushData)localObject3).begTs = localSTPushMsgElem0x3.begTs.get();
          ((AioPushData)localObject3).busId = localSTPushMsgElem0x3.busId.get();
          ((AioPushData)localObject3).busType = localSTPushMsgElem0x3.busType.get();
          ((AioPushData)localObject3).dotId = localSTPushMsgElem0x3.dotId.get();
          ((AioPushData)localObject3).endTs = localSTPushMsgElem0x3.endTs.get();
          ((AioPushData)localObject3).priority = localSTPushMsgElem0x3.priority.get();
          ((AioPushData)localObject3).them = localSTPushMsgElem0x3.theme.get();
          ((AioPushData)localObject3).wording = localSTPushMsgElem0x3.wording.get();
          ((AioPushData)localObject3).url = localSTPushMsgElem0x3.url.get();
          ((AioPushData)localObject3).actId = localSTPushMsgElem0x3.actId.get();
          ((AioPushData)localObject3).spRegion = localSTPushMsgElem0x3.spRegion.get();
          ((AioPushData)localObject3).folderIconUrl = localSTPushMsgElem0x3.folderIconUrl.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPushManager", 2, "[onReceiveAioPush] receive " + localObject3);
          }
          int j = i;
          if (this.b != null)
          {
            j = i;
            if (this.b.get() != null)
            {
              j = i;
              if (((AioPushData)localObject3).isShow)
              {
                j = 2;
                ((aisw)this.b.get()).a(1, localObject3);
              }
            }
          }
          i = j;
        }
      }
      localObject1 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localObject1 != null) {
        ((ajmw)localObject1).a(paramSTPushMsgElem, i);
      }
      for (;;)
      {
        ((ajyf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(NetConnInfoCenter.getServerTimeMillis());
        return;
        QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] dao manager is null ");
      }
    }
    QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] pb list is null or empty");
  }
  
  public void c(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    label70:
    apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2 localSTPushMsgElem0x2;
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            int i = paramSTPushMsgElem.showPlace.get();
            if ((2 == paramSTPushMsgElem.type.get()) && (3 == i)) {
              break label70;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ApolloPushManager", 2, "onReceiveDrawerHirePush incompatible type");
              return;
            }
          }
          catch (Exception paramSTPushMsgElem) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloPushManager", 2, "onReceiveDrawerHirePush error:", paramSTPushMsgElem);
      return;
      localSTPushMsgElem0x2 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2)paramSTPushMsgElem.pm2.get();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putLong("hire_for", localSTPushMsgElem0x2.toUin.get()).putInt("hire_action", localSTPushMsgElem0x2.actionId.get()).putLong("hire_end", localSTPushMsgElem0x2.endTs.get()).putString("hire_word", localSTPushMsgElem0x2.diyWords.get()).putInt("hire_priority", paramSTPushMsgElem.priority.get()).putBoolean("hire_bubble_click", false).commit();
    } while (!QLog.isColorLevel());
    QLog.i("ApolloPushManager", 2, "receive drawerHirePush:" + localSTPushMsgElem0x2.actionId.get() + "," + localSTPushMsgElem0x2.endTs.get() + "," + localSTPushMsgElem0x2.diyWords.get() + "," + paramSTPushMsgElem.priority.get());
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[onDestroy]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aist
 * JD-Core Version:    0.7.0.1
 */