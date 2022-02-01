import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.chat.QCircleChatBoxHelper;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class ajeu
{
  private static volatile ajew a;
  public SplashActivity a;
  
  public ajeu(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    bbox localbbox = (bbox)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localbbox != null)
    {
      int j = localbbox.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localbbox.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private bkwz a()
  {
    if (!a()) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(96);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.a();
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, int paramInt1, boolean paramBoolean1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(5);
      paramRedTypeInfo1.red_content.set(paramInt4 + "");
      paramRedTypeInfo1.red_desc.set("{'cn':'#FF0000'}");
      a(paramInt2, 0);
      return paramRedTypeInfo1;
    }
    if (paramRedTypeInfo2 != null)
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
      return paramRedTypeInfo2;
    }
    int i;
    if (paramInt1 <= 0)
    {
      i = b();
      paramInt4 = i;
      if (i <= 0)
      {
        paramInt4 = i;
        if (!paramBoolean2)
        {
          paramInt4 = i;
          if (!paramBoolean1)
          {
            paramInt4 = i;
            if (paramInt3 <= 0) {
              if (!paramBoolean3) {
                break label242;
              }
            }
          }
        }
      }
    }
    for (paramInt4 = i;; paramInt4 = 0)
    {
      paramRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramRedTypeInfo1.red_type.set(0);
      paramRedTypeInfo1.red_content.set("");
      paramRedTypeInfo1.red_desc.set("");
      a(paramInt2, paramInt4);
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot; redpointMums = " + paramInt1 + ",isReadinjoyNotifyNeedsDisplay" + paramBoolean2 + ",nearbyHasRedPoint = " + paramBoolean1 + ", allPeopleVotePointCount=" + paramInt3 + ", finalConfessShowRedDot=" + paramBoolean3);
      return paramRedTypeInfo1;
      label242:
      return paramRedTypeInfo1;
    }
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(nmq paramnmq, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsShowNewLeba=").append(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.mIsShowNewLeba);
    boolean bool5 = bbyp.a();
    Map localMap = Collections.emptyMap();
    if (bool5) {
      localMap = a();
    }
    for (;;)
    {
      int i = paramnmq.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      int k = paramnmq.a();
      if (!amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 826L, bool5, localMap))
      {
        i = 0;
        k = 0;
      }
      for (;;)
      {
        localStringBuilder.append("troop red point-->redPointNums= ").append(i).append(", redNumPointNums=").append(k).append(", isBuluoEntryShow=").append(k);
        ((axfy)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(160)).a(100510);
        paramnmq = paramnmq.a(paramnmq.a(), false);
        boolean bool1;
        int m;
        boolean bool3;
        boolean bool2;
        if (paramnmq.a != -1)
        {
          bool1 = true;
          m = paramnmq.b;
          bool3 = amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7719L, bool5, localMap);
          if (bool3) {
            break label945;
          }
          bool2 = false;
          m = 0;
        }
        for (;;)
        {
          localStringBuilder.append("nearby red point-->nearbyNum= ").append(m).append(", nearbyHasRedPoint=").append(bool2).append(", isNearbyEntryShow=").append(bool3);
          paramnmq = ((azvi)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(36)).a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, bool5, localMap);
          if ((paramnmq != null) && (paramnmq.red_type.get() == 5)) {}
          for (int n = Integer.parseInt(paramnmq.red_content.get());; n = 0)
          {
            localStringBuilder.append("business red point-->numRedTouch=").append(n);
            int i7 = a();
            localStringBuilder.append("QZone red point-->qzonMsgCount=").append(i7);
            bkwz localbkwz = a();
            int j;
            label348:
            label364:
            boolean bool4;
            if (localbkwz != null)
            {
              j = localbkwz.a();
              if ((localbkwz == null) || (!localbkwz.a())) {
                break label890;
              }
              bool1 = true;
              bool4 = amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 1130L, bool5, localMap);
              if (bool4) {
                break label932;
              }
              bool3 = false;
              j = 0;
            }
            for (;;)
            {
              localStringBuilder.append("readInJoy red point-->readInJoyNotifyCount=").append(j).append(", isReadinjoyNotifyNeedsDisplay=").append(bool3).append(", isKanDianEntryShow=").append(bool4);
              if ((paramRedDotInfo != null) && (paramRedDotInfo.uint32_appid.get() == 52) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().a) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getNowLiveManager().b())) {}
              for (int i1 = paramRedDotInfo.uint32_number.get();; i1 = 0)
              {
                int i3 = bhat.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, true);
                int i2 = bhat.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, false);
                if (!amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 770L, bool5, localMap))
                {
                  i2 = 0;
                  i3 = 0;
                }
                for (;;)
                {
                  boolean bool6 = aprw.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "redpoint_leba_show");
                  bool4 = false;
                  bool1 = false;
                  if (bool6)
                  {
                    bool4 = amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7759L, bool5, localMap);
                    if ((bool6) && (bool4)) {
                      bool1 = true;
                    }
                  }
                  else
                  {
                    label593:
                    localStringBuilder.append("confessRedPoit").append(bool1).append(",").append(bool6).append(",").append(bool4);
                    if (!amvb.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, 7720L, bool5, localMap)) {
                      break label917;
                    }
                  }
                  label917:
                  for (int i4 = avod.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);; i4 = 0)
                  {
                    localStringBuilder.append("matchChatRedNum,").append(i4);
                    paramRedDotInfo = a();
                    if (paramRedDotInfo == null) {}
                    for (int i5 = 0;; i5 = ((Integer)paramRedDotInfo.first).intValue())
                    {
                      int i6 = i;
                      if (paramRedDotInfo != null)
                      {
                        i6 = i;
                        if (((Boolean)paramRedDotInfo.second).booleanValue()) {
                          i6 = i + 1;
                        }
                      }
                      i = i5 + (i7 + n + k + j + m + i1 + i3 + i4);
                      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i + ", qz=" + i7 + ", numRedTouch=" + n + ", redNumPointNums=" + k + ", readInJoyNotifyCount=" + j + ", nearbyNum=" + m + ", storyRedNum=" + i1 + ", allPeopleVoteRedNumCount=" + i3 + localStringBuilder.toString());
                      return a(paramRedTypeInfo, i6, bool2, paramnmq, i7, bool3, i2, bool1, i);
                      bool1 = false;
                      break;
                      j = 0;
                      break label348;
                      label890:
                      bool1 = false;
                      break label364;
                      bool1 = false;
                      break label593;
                    }
                  }
                }
              }
              label932:
              bool3 = bool1;
            }
          }
          label945:
          bool2 = bool1;
        }
      }
    }
  }
  
  private Pair<Integer, Boolean> a()
  {
    if ((bbyp.b()) || (!Leba.d())) {
      return null;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null)) {
          i = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
        }
      }
      catch (Exception localException1)
      {
        Object localObject;
        long l;
        label127:
        bool1 = false;
        label154:
        bool2 = false;
        j = 0;
        int i = 0;
        QLog.e("MainAssistObserver.LebaTabRedTouch", 2, "getQQCircleRedTouchNums" + localException1.toString());
        bool3 = false;
        bool4 = bool1;
        bool5 = bool2;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject = ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).getOuterEntranceRedPointInfoByAppid("circle_entrance");
          if (localObject == null) {
            continue;
          }
          l = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
          j = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
        }
        catch (Exception localException2)
        {
          bool1 = false;
          bool2 = false;
          j = 0;
          break label304;
          bool1 = false;
          bool2 = false;
          bool3 = false;
          j = 0;
          break label154;
        }
        try
        {
          bool1 = QCircleCommonUtil.checkOperateMaskEnabled(l, 1);
          if (!bool1) {
            continue;
          }
          bool1 = true;
        }
        catch (Exception localException3)
        {
          bool1 = false;
          bool2 = false;
          break label304;
          bool1 = false;
          break;
        }
        try
        {
          bool2 = QCircleCommonUtil.checkOperateMaskEnabled(l, 6);
          if (!bool2) {
            continue;
          }
          bool2 = true;
        }
        catch (Exception localException4)
        {
          bool2 = bool1;
          bool1 = false;
          break label304;
          bool3 = bool1;
          bool1 = false;
          break label154;
          bool2 = false;
          break label127;
        }
      }
      if (i > 0) {
        break label401;
      }
      try
      {
        bool3 = QCircleCommonUtil.checkOperateMaskEnabled(l, 3);
        if (!bool3) {
          break label401;
        }
        bool4 = true;
        bool3 = bool1;
        bool1 = bool4;
        bool5 = bool3;
        bool4 = bool2;
        bool3 = bool1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getQQCircleRedTouchNums]").append("  pushUnReadNum = ").append(j).append(", chatUnReadNum = ").append(i).append(", showActiveRedDot = ").append(bool5).append(", showRecommendRedDot = ").append(bool3).append(", showPYMKRedDot = ").append(bool4);
        QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, new Object[] { localObject });
        return new Pair(Integer.valueOf(j + i), Boolean.valueOf(bool3 | bool5 | bool4));
      }
      catch (Exception localException5)
      {
        boolean bool4;
        boolean bool5;
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      QLog.d("MainAssistObserver.LebaTabRedTouch", 1, "getChatUnReadNum error activity or appInterface is null");
      i = 0;
    }
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if (!bbyp.a()) {}
    ajew localajew;
    do
    {
      return;
      localajew = new ajew(paramInt1, paramInt2, null);
    } while (localajew.equals(jdField_a_of_type_Ajew));
    jdField_a_of_type_Ajew = localajew;
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + ajew.a(localajew) + " " + ajew.a(localajew));
    if (ajew.a(localajew) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (ajew.a(localajew))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((azvi)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(36)).a().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  private int b()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    bbox localbbox = (bbox)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localbbox != null)
    {
      int j = localbbox.a(2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localbbox.a(2) + " TYPE_ZEBRA_ALBUM:" + localbbox.a(17));
        i = j;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i);
    return i;
  }
  
  public static void b()
  {
    ajew localajew = jdField_a_of_type_Ajew;
    StringBuilder localStringBuilder = new StringBuilder().append("doQZoneRedPointClickReport: ");
    if (localajew == null) {}
    for (String str = "null";; str = ajew.a(localajew) + " " + ajew.a(localajew))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 4, str);
      if ((localajew != null) && (ajew.a(localajew) <= 0) && (ajew.a(localajew))) {
        break;
      }
      LpReportInfo_pf00064.allReport(637, 22, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 21, 2);
  }
  
  public static void c()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    jdField_a_of_type_Ajew = null;
  }
  
  public Runnable a(ajex paramajex)
  {
    return new LebaTabRedTouch.1(this, paramajex);
  }
  
  public Map<Long, LebaPluginInfo> a()
  {
    Object localObject2 = Collections.emptyMap();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getLebaHelper().a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject3).isEmpty())
      {
        localObject1 = new HashMap();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LebaPluginInfo)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((Map)localObject1).put(Long.valueOf(((LebaPluginInfo)localObject3).uiResId), localObject3);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeu
 * JD-Core Version:    0.7.0.1
 */