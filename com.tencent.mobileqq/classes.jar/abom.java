import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class abom
  implements View.OnClickListener
{
  public abom(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    boolean bool = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db"), new File(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getExternalCacheDir(), this.jdField_a_of_type_JavaLangString + System.currentTimeMillis() + ".db"));
    QLog.e(DBFixConfigActivity.jdField_a_of_type_JavaLangString, 2, "copy " + bool + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abom
 * JD-Core Version:    0.7.0.1
 */