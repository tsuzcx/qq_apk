import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.wholepeople.WholePeoplePlugin;
import com.tencent.qphone.base.util.QLog;

public class aksk
  implements View.OnClickListener
{
  public aksk(WholePeoplePlugin paramWholePeoplePlugin, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeoplePlugin", 2, "onClick " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeoplePlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksk
 * JD-Core Version:    0.7.0.1
 */