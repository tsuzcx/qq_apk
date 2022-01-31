import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class afjr
  implements View.OnClickListener
{
  public afjr(ArkAppView paramArkAppView, ArkViewModel paramArkViewModel) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentArkArkViewModel != null) {
      this.jdField_a_of_type_ComTencentArkArkViewModel.reinitArkContainer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjr
 * JD-Core Version:    0.7.0.1
 */