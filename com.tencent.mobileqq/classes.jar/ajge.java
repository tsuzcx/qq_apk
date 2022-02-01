import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ajge
  extends apck
{
  ajge(ajgd paramajgd, String paramString, aoip paramaoip, boolean paramBoolean)
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
    this.jdField_a_of_type_Aoip.a(1, this.jdField_a_of_type_Ajgd.b, 25, this.jdField_a_of_type_Boolean, ajgd.a(this.jdField_a_of_type_Ajgd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajge
 * JD-Core Version:    0.7.0.1
 */