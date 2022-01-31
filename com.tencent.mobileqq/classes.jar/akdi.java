import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import com.tencent.open.downloadnew.MyAppApi;
import java.lang.ref.WeakReference;

public class akdi
  implements Runnable
{
  public akdi(NewUpgradeDialog paramNewUpgradeDialog, Bundle paramBundle) {}
  
  public void run()
  {
    MyAppApi.a().a((Context)this.jdField_a_of_type_ComTencentMobileqqUtilsNewUpgradeDialog.a.get(), this.jdField_a_of_type_AndroidOsBundle, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */