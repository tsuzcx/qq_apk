import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class afdn
  extends akuj
{
  afdn(afdm paramafdm, String paramString, akhq paramakhq, boolean paramBoolean)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0) {
      QLog.i("ac_ft.AddContactFindTroopRTLW", 1, "getRecommendTroopList onLocationFinish, errorCode=" + paramInt);
    }
    this.jdField_a_of_type_Akhq.a(1, this.jdField_a_of_type_Afdm.b, 25, this.jdField_a_of_type_Boolean, afdm.a(this.jdField_a_of_type_Afdm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdn
 * JD-Core Version:    0.7.0.1
 */