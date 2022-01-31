import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class adit
  implements ActionSheet.OnButtonClickListener
{
  public adit(QfileEditBottomBar paramQfileEditBottomBar, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ThreadManager.executeOnFileThread(new adiu(this));
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adit
 * JD-Core Version:    0.7.0.1
 */