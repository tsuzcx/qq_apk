import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class akqg
  extends SubAccountObserver
{
  akqg(akqe paramakqe, ayax paramayax) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Akqe.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Akqe.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_Ayax.a(paramString2, paramString3, true);
    ayaq.a(this.jdField_a_of_type_Akqe.a, (byte)1, paramString2);
    ayaq.a(this.jdField_a_of_type_Akqe.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqg
 * JD-Core Version:    0.7.0.1
 */