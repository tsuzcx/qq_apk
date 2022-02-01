import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

final class acqt
  extends SubAccountObserver
{
  acqt(acnk paramacnk, bdxs parambdxs) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Acnk.a() == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Acnk.a().getAccount())) {
      return;
    }
    this.jdField_a_of_type_Bdxs.a(paramString2, paramString3, true);
    bdxj.a(this.jdField_a_of_type_Acnk.a(), (byte)1, paramString2);
    bdxj.a(this.jdField_a_of_type_Acnk.a(), paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqt
 * JD-Core Version:    0.7.0.1
 */