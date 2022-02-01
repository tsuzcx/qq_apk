import android.text.TextUtils;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ABTestController.EvtType;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;

public class adqg
{
  private volatile RomaExpEntity jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public adqg(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.d = ABTestController.a().a(paramString1, paramString2, paramString3);
    ABTestApi.getAllExperiments(new adqh(this, System.currentTimeMillis(), paramString1), 3000);
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity != null) {}
    for (String str1 = this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getGrayId();; str1 = "") {
      return String.format("layerName:%s, entityGrayId:%s, contrastGrayId:%s, experimentGrayId:%s \nisContrast:%s, isExperiment:%s", new Object[] { str2, str1, this.c, this.b, Boolean.valueOf(c()), Boolean.valueOf(b()) });
    }
  }
  
  public void a(ABTestController.EvtType paramEvtType, String paramString)
  {
    if (a()) {
      ABTestController.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getGrayId(), paramEvtType, paramString);
    }
  }
  
  public void a(String paramString)
  {
    if (a())
    {
      ABTestApi.reportExpExpose(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity);
      a(ABTestController.EvtType.EXPOSE, paramString);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getGrayId()));
  }
  
  public boolean b()
  {
    if (a()) {
      return this.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getGrayId());
    }
    return false;
  }
  
  public boolean c()
  {
    if (a()) {
      return this.c.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getGrayId());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqg
 * JD-Core Version:    0.7.0.1
 */