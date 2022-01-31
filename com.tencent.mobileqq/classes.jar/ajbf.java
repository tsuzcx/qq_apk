import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class ajbf
  implements QQPermissionCallback
{
  ajbf(ajba paramajba, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Ajba.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbf
 * JD-Core Version:    0.7.0.1
 */