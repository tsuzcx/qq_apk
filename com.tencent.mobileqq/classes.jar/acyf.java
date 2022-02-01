import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.config.APMConfig;
import com.tencent.mfsdk.config.APMModuleConfig;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public abstract class acyf
  implements acxu
{
  APMModuleConfig jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = null;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public APMModuleConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig == null)
    {
      APMConfig localAPMConfig = MagnifierSDK.a().a();
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = localAPMConfig.getSampleConfig(a());
      if (this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig == null) {
        this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig = b();
      }
      if ((localAPMConfig.runVip) && (UnifiedMonitor.c()) && ((!QLog.isColorLevel()) || ((!"dropframe".equals(a())) && (!"leak".equals(a()))))) {
        break label137;
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig);
      QLog.i("MagnifierSDK.QAPM", 1, "getMyConfig " + a() + " " + this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig);
      return this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig;
      label137:
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.evenRatio = 1.0F;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.threshold = a().threshold;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.userRatio = 1.0F;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.maxReport = 2147483647;
      this.jdField_a_of_type_ComTencentMfsdkConfigAPMModuleConfig.stackDepth = 6;
    }
  }
  
  public DefaultPluginConfig a()
  {
    return (DefaultPluginConfig)APMConfig.sPluginToQapmPluginConfigMap.get(a());
  }
  
  public abstract String a();
  
  protected void a(APMModuleConfig paramAPMModuleConfig) {}
  
  public final boolean a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this.jdField_a_of_type_Boolean;
  }
  
  protected APMModuleConfig b()
  {
    APMModuleConfig localAPMModuleConfig = new APMModuleConfig();
    localAPMModuleConfig.userRatio = 0.0F;
    localAPMModuleConfig.evenRatio = 0.0F;
    localAPMModuleConfig.threshold = 100;
    localAPMModuleConfig.maxReport = 0;
    return localAPMModuleConfig;
  }
  
  public void b() {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(d());
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  protected boolean d()
  {
    return a().canOpenPlugin();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyf
 * JD-Core Version:    0.7.0.1
 */