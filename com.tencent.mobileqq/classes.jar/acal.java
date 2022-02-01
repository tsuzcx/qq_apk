import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

final class acal
  extends SubAccountObserver
{
  acal(abxc paramabxc, bcqt parambcqt) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Abxc.a() == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Abxc.a().getAccount())) {
      return;
    }
    this.jdField_a_of_type_Bcqt.a(paramString2, paramString3, true);
    bcqk.a(this.jdField_a_of_type_Abxc.a(), (byte)1, paramString2);
    bcqk.a(this.jdField_a_of_type_Abxc.a(), paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acal
 * JD-Core Version:    0.7.0.1
 */