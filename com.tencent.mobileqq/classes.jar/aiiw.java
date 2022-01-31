import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class aiiw
  implements IMiniMsgUnreadCallback
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public aiiw(View paramView, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public void hide()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void hideUnread()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean show(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    updateUnreadCount(paramInt, false);
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str = String.valueOf(paramInt);
    if (paramInt > 99) {
      str = "99+";
    }
    localTextView.setText(str);
    if (!paramBoolean)
    {
      if (paramInt <= 0) {
        localTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiw
 * JD-Core Version:    0.7.0.1
 */