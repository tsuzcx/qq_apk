import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class adcg
  implements adbu
{
  APMModuleConfig jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = null;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private DefaultPluginConfig a()
  {
    return (DefaultPluginConfig)APMConfig.sPluginToQapmPluginConfigMap.get(c());
  }
  
  protected APMModuleConfig a()
  {
    APMModuleConfig localAPMModuleConfig = new APMModuleConfig();
    localAPMModuleConfig.userRatio = 0.0F;
    localAPMModuleConfig.evenRatio = 0.0F;
    localAPMModuleConfig.threshold = 100;
    localAPMModuleConfig.maxReport = 0;
    return localAPMModuleConfig;
  }
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public final boolean a()
  {
    boolean bool = b();
    QLog.i("MagnifierSDK.QAPM", 1, "lifecycle " + c() + " canStart " + bool);
    if (bool)
    {
      adch.a();
      DefaultPluginConfig localDefaultPluginConfig = a();
      b();
      APMModuleConfig localAPMModuleConfig = b();
      localDefaultPluginConfig.eventSampleRatio = localAPMModuleConfig.evenRatio;
      localDefaultPluginConfig.threshold = localAPMModuleConfig.threshold;
      localDefaultPluginConfig.maxReportNum = localAPMModuleConfig.maxReport;
      localDefaultPluginConfig.stackDepth = localAPMModuleConfig.stackDepth;
      QAPM.beginScene("SCENE_ALL", localDefaultPluginConfig.mode);
      this.jdField_a_of_type_Boolean = true;
      c();
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public APMModuleConfig b()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig == null)
    {
      APMConfig localAPMConfig = MagnifierSDK.a().a();
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = localAPMConfig.getSampleConfig(c());
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig == null) {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = a();
      }
      if ((localAPMConfig.runVip) && (UnifiedMonitor.c()) && ((!QLog.isColorLevel()) || ((!"dropframe".equals(c())) && (!"leak".equals(c()))))) {
        break label137;
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig);
      QLog.i("MagnifierSDK.QAPM", 1, "getMyConfig " + c() + " " + this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig);
      return this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig;
      label137:
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.evenRatio = 1.0F;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.threshold = a().threshold;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.userRatio = 1.0F;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.maxReport = 2147483647;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.stackDepth = 6;
    }
  }
  
  protected abstract void b();
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(d());
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public abstract String c();
  
  protected void c() {}
  
  protected boolean d()
  {
    return b().canOpenPlugin();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcg
 * JD-Core Version:    0.7.0.1
 */