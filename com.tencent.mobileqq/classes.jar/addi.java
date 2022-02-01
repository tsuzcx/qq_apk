import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class addi
{
  private static addi jdField_a_of_type_Addi = new addi();
  private LruCache<String, Object> jdField_a_of_type_AndroidUtilLruCache;
  private StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static addi a()
  {
    return jdField_a_of_type_Addi;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ABTestController", 2, paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    a("ABTestController, only available in debug version.");
    if (TextUtils.isEmpty(paramString)) {}
    for (Object localObject = paramBaseApplicationImpl.getRuntime().getAccount();; localObject = paramString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
      this.jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = StatisticCollector.getInstance(paramBaseApplicationImpl);
      a("start initialize ABTestApi SDK, uinAccount:" + paramString);
      long l = System.currentTimeMillis();
      localObject = new ABTestConfig();
      ((ABTestConfig)localObject).setEnv("RELEASE");
      ((ABTestConfig)localObject).setAppId("505");
      ((ABTestConfig)localObject).setAppKey("e8c0653fea13f91bf3c48159f7c24f78");
      ((ABTestConfig)localObject).setPlatform("android");
      ((ABTestConfig)localObject).setGuid(paramString);
      ABTestApi.init(paramBaseApplicationImpl, (ABTestConfig)localObject);
      this.jdField_a_of_type_Boolean = true;
      a("ABTestController", "abtest api init cost:" + (System.currentTimeMillis() - l));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addi
 * JD-Core Version:    0.7.0.1
 */