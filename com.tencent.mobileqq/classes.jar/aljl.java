import android.os.Bundle;
import com.tencent.open.model.AccountManage;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class aljl
  implements Runnable
{
  public aljl(AccountManage paramAccountManage, WeakReference paramWeakReference, String paramString1, String paramString2, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    SSOAccountObserver localSSOAccountObserver = (SSOAccountObserver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSSOAccountObserver != null) {
      localSSOAccountObserver.onGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, this.b.getBytes(), this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljl
 * JD-Core Version:    0.7.0.1
 */