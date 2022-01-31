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

public class aiag
{
  private static volatile aiai a;
  public SplashActivity a;
  
  public aiag(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    ayxn localayxn = (ayxn)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localayxn != null)
    {
      int j = localayxn.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localayxn.a(1));
        i = j;
      }
    }
    return i;
  }
  
  private bjxw a()
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
    //   0: invokestatic 81	azib:b	()Z
    //   3: ifne +9 -> 12
    //   6: invokestatic 86	common/config/service/QzoneConfig:isQQCircleShowLebaEntrance	()Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: invokestatic 92	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: invokevirtual 96	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   20: bipush 36
    //   22: invokevirtual 99	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   25: checkcast 101	axho
    //   28: astore 4
    //   30: aload 4
    //   32: ldc 103
    //   34: invokevirtual 106	axho:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   37: astore 5
    //   39: aload 5
    //   41: ifnonnull +5 -> 46
    //   44: aconst_null
    //   45: areturn
    //   46: aload 4
    //   48: aconst_null
    //   49: invokevirtual 109	axho:a	(Laxhr;)I
    //   52: istore_1
    //   53: aload 5
    //   55: getfield 115	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   58: invokevirtual 120	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_1
    //   64: if_icmpne +21 -> 85
    //   67: iconst_1
    //   68: istore_3
    //   69: new 122	com/tencent/util/Pair
    //   72: dup
    //   73: iload_1
    //   74: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: iload_3
    //   78: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: invokespecial 136	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   84: areturn
    //   85: iconst_0
    //   86: istore_3
    //   87: goto -18 -> 69
    //   90: astore 4
    //   92: iconst_0
    //   93: istore_1
    //   94: ldc 138
    //   96: iconst_2
    //   97: new 43	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   104: ldc 140
    //   106: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   114: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -56 -> 69
    //   128: astore 4
    //   130: goto -36 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	aiag
    //   52	42	1	i	int
    //   61	4	2	j	int
    //   68	57	3	bool	boolean
    //   28	19	4	localaxho	axho
    //   90	20	4	localException1	java.lang.Exception
    //   128	1	4	localException2	java.lang.Exception
    //   37	17	5	localAppInfo	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo
    // Exception table:
    //   from	to	target	type
    //   30	39	90	java/lang/Exception
    //   46	53	90	java/lang/Exception
    //   53	62	128	java/lang/Exception
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((axho)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(36)).a().iterator();
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
    ayxn localayxn = (ayxn)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localayxn != null)
    {
      int j = localayxn.a(2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localayxn.a(2) + " TYPE_ZEBRA_ALBUM:" + localayxn.a(17));
        i = j;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i);
    return i;
  }
  
  public static void b()
  {
    aiai localaiai = jdField_a_of_type_Aiai;
    StringBuilder localStringBuilder = new StringBuilder().append("doQZoneRedPointClickReport: ");
    if (localaiai == null) {}
    for (String str = "null";; str = aiai.a(localaiai) + " " + aiai.a(localaiai))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 4, str);
      if ((localaiai != null) && (aiai.a(localaiai) <= 0) && (aiai.a(localaiai))) {
        break;
      }
      LpReportInfo_pf00064.allReport(637, 22, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 21, 2);
  }
  
  private static void b(int paramInt1, int paramInt2)
  {
    if (!azib.a()) {}
    aiai localaiai;
    do
    {
      return;
      localaiai = new aiai(paramInt1, paramInt2, null);
    } while (localaiai.equals(jdField_a_of_type_Aiai));
    jdField_a_of_type_Aiai = localaiai;
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + aiai.a(localaiai) + " " + aiai.a(localaiai));
    if (aiai.a(localaiai) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (aiai.a(localaiai))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  public static void c()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    jdField_a_of_type_Aiai = null;
  }
  
  public Runnable a(aiaj paramaiaj)
  {
    return new LebaTabRedTouch.1(this, paramaiaj);
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
 * Qualified Name:     aiag
 * JD-Core Version:    0.7.0.1
 */