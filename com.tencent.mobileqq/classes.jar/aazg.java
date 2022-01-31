import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

class aazg
  implements Runnable
{
  aazg(aayw paramaayw, String paramString, aazm paramaazm, aazk paramaazk) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)aayw.a(this.jdField_a_of_type_Aayw).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new aazh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazg
 * JD-Core Version:    0.7.0.1
 */