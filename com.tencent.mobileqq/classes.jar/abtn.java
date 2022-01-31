import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class abtn
  extends SubAccountObserver
{
  abtn(abtl paramabtl, badd parambadd) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Abtl.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Abtl.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_Badd.a(paramString2, paramString3, true);
    bacu.a(this.jdField_a_of_type_Abtl.a, (byte)1, paramString2);
    bacu.a(this.jdField_a_of_type_Abtl.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtn
 * JD-Core Version:    0.7.0.1
 */