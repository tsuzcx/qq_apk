import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aakk
  implements View.OnClickListener
{
  public aakk(CustomMenuBar paramCustomMenuBar, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakk
 * JD-Core Version:    0.7.0.1
 */