import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;

public class agyn
  implements Runnable
{
  public agyn(PtvTemplateProviderView paramPtvTemplateProviderView) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.setTab(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.e = -1;
    }
    do
    {
      return;
      if ((this.a.e > 0) && (this.a.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.a.jdField_a_of_type_Boolean))
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.setTab(this.a.e);
        this.a.jdField_a_of_type_JavaLangString = "";
        this.a.e = -1;
        return;
      }
    } while ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilList.size() <= this.a.b) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.a.b);
    this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQQSlidingTabView.a(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyn
 * JD-Core Version:    0.7.0.1
 */