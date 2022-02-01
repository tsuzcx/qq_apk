import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class acwm
  extends SubAccountObserver
{
  acwm(acwk paramacwk, bdeh parambdeh) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Acwk.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Acwk.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_Bdeh.a(paramString2, paramString3, true);
    bddy.a(this.jdField_a_of_type_Acwk.a, (byte)1, paramString2);
    bddy.a(this.jdField_a_of_type_Acwk.a, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwm
 * JD-Core Version:    0.7.0.1
 */