import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class aesr
  extends akfx
{
  aesr(aesq paramaesq, String paramString, ajtg paramajtg, boolean paramBoolean)
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
    this.jdField_a_of_type_Ajtg.a(1, this.jdField_a_of_type_Aesq.b, 25, this.jdField_a_of_type_Boolean, aesq.a(this.jdField_a_of_type_Aesq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesr
 * JD-Core Version:    0.7.0.1
 */