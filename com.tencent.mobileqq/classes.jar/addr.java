import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

final class addr
  extends SubAccountObserver
{
  addr(adan paramadan, bdxc parambdxc) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_Adan.a() == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Adan.a().getAccount())) {
      return;
    }
    this.jdField_a_of_type_Bdxc.a(paramString2, paramString3, true);
    bdwt.a(this.jdField_a_of_type_Adan.a(), (byte)1, paramString2);
    bdwt.a(this.jdField_a_of_type_Adan.a(), paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addr
 * JD-Core Version:    0.7.0.1
 */