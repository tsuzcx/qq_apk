import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wholepeople.WholePeoplePlugin;
import com.tencent.qphone.base.util.QLog;

public class aked
  implements View.OnClickListener
{
  public aked(WholePeoplePlugin paramWholePeoplePlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeoplePlugin", 2, "onClick " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeoplePlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aked
 * JD-Core Version:    0.7.0.1
 */