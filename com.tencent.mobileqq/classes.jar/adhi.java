import android.text.TextUtils;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ABTestController.EvtType;
import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;

public class adhi
{
  public RomaExpEntity a;
  public String a;
  public String b = "";
  
  public adhi(String paramString)
  {
    this(paramString, "");
  }
  
  private adhi(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity = ABTestApi.syncGetExpByName(paramString1);
    if (this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity != null) {
      ABTestController.a("ExperimentInfo", "abtest api, load exp success:" + paramString1 + ", ass:" + this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getAssignment());
    }
    for (;;)
    {
      ABTestController.a("ExperimentInfo", "abtest api, load cost:" + (System.currentTimeMillis() - l));
      return;
      ABTestController.a("ExperimentInfo", "abtest api, load exp failure:" + paramString1);
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
    return (this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getAssignment()));
  }
  
  public boolean b()
  {
    if (a()) {
      return "treatment".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getAssignment());
    }
    return false;
  }
  
  public boolean c()
  {
    if (a()) {
      return "control".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMttAbtestsdkEntityRomaExpEntity.getAssignment());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhi
 * JD-Core Version:    0.7.0.1
 */