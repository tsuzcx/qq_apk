import android.app.Activity;
import android.os.Handler;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class akth
  implements ActionMode.Callback
{
  public akth(ContainerView.SelectableTextView paramSelectableTextView, ContainerView paramContainerView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131375566)
    {
      paramActionMode = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getContext();
      if ((paramActionMode != null) && ((paramActionMode instanceof TextPreviewActivity)))
      {
        paramMenuItem = (TextPreviewActivity)paramActionMode;
        CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getText().subSequence(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionStart(), this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.getSelectionEnd());
        if (localCharSequence != null) {
          TextPreviewActivity.a(localCharSequence.toString(), (Activity)paramActionMode, paramMenuItem.app, paramMenuItem.jdField_a_of_type_JavaLangString, paramMenuItem.jdField_a_of_type_Int, TextPreviewActivity.b, false);
        }
        ReportController.b(paramMenuItem.app, "CliOper", "", "", "0X8004065", "0X8004065", 0, 0, "", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131820544, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.sendEmptyMessageDelayed(100, 10L);
    }
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akth
 * JD-Core Version:    0.7.0.1
 */