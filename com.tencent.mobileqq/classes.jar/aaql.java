import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class aaql
  extends LbsManagerService.OnLocationChangeListener
{
  aaql(aaqk paramaaqk, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LocationPlugin", 2, "onLocationFinish errCode = " + paramInt);
    }
    aaqj.a(this.a.jdField_a_of_type_Aaqj, paramSosoLbsInfo, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaql
 * JD-Core Version:    0.7.0.1
 */