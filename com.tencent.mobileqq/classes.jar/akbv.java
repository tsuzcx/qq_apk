import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class akbv
  extends SubAccountObserver
{
  akbv(akbt paramakbt, axat paramaxat) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Akbt.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Akbt.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_Axat.a(paramString2, paramString3, true);
    axam.a(this.jdField_a_of_type_Akbt.a, (byte)1, paramString2);
    axam.a(this.jdField_a_of_type_Akbt.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akbv
 * JD-Core Version:    0.7.0.1
 */