import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class akqh
  extends SubAccountObserver
{
  akqh(akqf paramakqf, ayav paramayav) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Akqf.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Akqf.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_Ayav.a(paramString2, paramString3, true);
    ayao.a(this.jdField_a_of_type_Akqf.a, (byte)1, paramString2);
    ayao.a(this.jdField_a_of_type_Akqf.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqh
 * JD-Core Version:    0.7.0.1
 */