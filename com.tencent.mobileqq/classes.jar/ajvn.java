import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ajvn
{
  private static volatile ajvp a;
  public SplashActivity a;
  
  public ajvn(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    bccv localbccv = (bccv)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localbccv != null)
    {
      int j = localbccv.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localbccv.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private bmqn a()
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
  
  /* Error */
  private com.tencent.util.Pair<java.lang.Integer, java.lang.Boolean> a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 81	bcnj:b	()Z
    //   5: ifne +9 -> 14
    //   8: invokestatic 86	common/config/service/QzoneConfig:isQQCircleShowLebaEntrance	()Z
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   22: sipush 376
    //   25: invokevirtual 99	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   28: checkcast 101	vqu
    //   31: astore 5
    //   33: aload 5
    //   35: ldc 103
    //   37: invokevirtual 106	vqu:b	(Ljava/lang/String;)Lqqcircle/QQCircleCounter$RedPointInfo;
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +215 -> 259
    //   47: aload 6
    //   49: getfield 112	qqcircle/QQCircleCounter$RedPointInfo:redTotalNum	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   55: istore_1
    //   56: aload 5
    //   58: ldc 103
    //   60: invokevirtual 119	vqu:a	(Ljava/lang/String;)Lqqcircle/QQCircleCounter$RedPointInfo;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +186 -> 253
    //   70: aload 5
    //   72: getfield 123	qqcircle/QQCircleCounter$RedPointInfo:rptRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   75: invokevirtual 128	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   78: astore 5
    //   80: aload 5
    //   82: ifnull +171 -> 253
    //   85: aload 5
    //   87: invokeinterface 133 1 0
    //   92: istore_3
    //   93: iload_3
    //   94: ifle +159 -> 253
    //   97: iconst_1
    //   98: istore 4
    //   100: aload_0
    //   101: getfield 14	ajvn:jdField_a_of_type_ComTencentMobileqqActivitySplashActivity	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   104: ifnull +84 -> 188
    //   107: aload_0
    //   108: getfield 14	ajvn:jdField_a_of_type_ComTencentMobileqqActivitySplashActivity	Lcom/tencent/mobileqq/activity/SplashActivity;
    //   111: getfield 22	com/tencent/mobileqq/activity/SplashActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: ifnull +74 -> 188
    //   117: invokestatic 139	com/tencent/biz/qqcircle/list/bizblocks/QCircleChatBoxHelper:getInstance	()Lcom/tencent/biz/qqcircle/list/bizblocks/QCircleChatBoxHelper;
    //   120: invokevirtual 142	com/tencent/biz/qqcircle/list/bizblocks/QCircleChatBoxHelper:getUnReadInfo	()Lcom/tencent/util/Pair;
    //   123: getfield 148	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   126: checkcast 150	java/lang/Integer
    //   129: invokevirtual 153	java/lang/Integer:intValue	()I
    //   132: istore_3
    //   133: iload_3
    //   134: istore_2
    //   135: ldc 155
    //   137: iconst_1
    //   138: new 43	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   145: ldc 157
    //   147: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 159
    //   156: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_2
    //   160: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: new 144	com/tencent/util/Pair
    //   172: dup
    //   173: iload_1
    //   174: iload_2
    //   175: iadd
    //   176: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: iload 4
    //   181: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   184: invokespecial 171	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   187: areturn
    //   188: ldc 155
    //   190: iconst_1
    //   191: ldc 173
    //   193: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: iconst_0
    //   197: istore_2
    //   198: goto -63 -> 135
    //   201: astore 5
    //   203: iconst_0
    //   204: istore_1
    //   205: iconst_0
    //   206: istore 4
    //   208: ldc 155
    //   210: iconst_2
    //   211: new 43	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   218: ldc 175
    //   220: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 5
    //   225: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   228: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: goto -102 -> 135
    //   240: astore 5
    //   242: iconst_0
    //   243: istore 4
    //   245: goto -37 -> 208
    //   248: astore 5
    //   250: goto -42 -> 208
    //   253: iconst_0
    //   254: istore 4
    //   256: goto -156 -> 100
    //   259: iconst_0
    //   260: istore_1
    //   261: goto -205 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	ajvn
    //   55	206	1	i	int
    //   1	197	2	j	int
    //   92	42	3	k	int
    //   98	157	4	bool	boolean
    //   31	55	5	localObject	Object
    //   201	23	5	localException1	java.lang.Exception
    //   240	1	5	localException2	java.lang.Exception
    //   248	1	5	localException3	java.lang.Exception
    //   40	8	6	localRedPointInfo	qqcircle.QQCircleCounter.RedPointInfo
    // Exception table:
    //   from	to	target	type
    //   16	42	201	java/lang/Exception
    //   47	56	201	java/lang/Exception
    //   56	65	240	java/lang/Exception
    //   70	80	240	java/lang/Exception
    //   85	93	240	java/lang/Exception
    //   100	133	248	java/lang/Exception
    //   188	196	248	java/lang/Exception
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((baif)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(36)).a().iterator();
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
    bccv localbccv = (bccv)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localbccv != null)
    {
      int j = localbccv.a(2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localbccv.a(2) + " TYPE_ZEBRA_ALBUM:" + localbccv.a(17));
        i = j;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i);
    return i;
  }
  
  public static void b()
  {
    ajvp localajvp = jdField_a_of_type_Ajvp;
    StringBuilder localStringBuilder = new StringBuilder().append("doQZoneRedPointClickReport: ");
    if (localajvp == null) {}
    for (String str = "null";; str = ajvp.a(localajvp) + " " + ajvp.a(localajvp))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 4, str);
      if ((localajvp != null) && (ajvp.a(localajvp) <= 0) && (ajvp.a(localajvp))) {
        break;
      }
      LpReportInfo_pf00064.allReport(637, 22, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 21, 2);
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if (!bcnj.a()) {}
    ajvp localajvp;
    do
    {
      return;
      localajvp = new ajvp(paramInt1, paramInt2, null);
    } while (localajvp.equals(jdField_a_of_type_Ajvp));
    jdField_a_of_type_Ajvp = localajvp;
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + ajvp.a(localajvp) + " " + ajvp.a(localajvp));
    if (ajvp.a(localajvp) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (ajvp.a(localajvp))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  public static void c()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    jdField_a_of_type_Ajvp = null;
  }
  
  public Runnable a(ajvq paramajvq)
  {
    return new LebaTabRedTouch.1(this, paramajvq);
  }
  
  public Map<Long, LebaPluginInfo> a()
  {
    Object localObject2 = Collections.emptyMap();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().a();
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
 * Qualified Name:     ajvn
 * JD-Core Version:    0.7.0.1
 */