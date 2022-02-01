import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afcx
  implements View.OnClickListener
{
  public afcx(SelectedAndSearchBar paramSelectedAndSearchBar, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afcx
 * JD-Core Version:    0.7.0.1
 */