import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeck
  implements View.OnClickListener
{
  public aeck(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (bhnv.d(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.l();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
      this.a.c.setText(this.a.getString(2131691989));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeck
 * JD-Core Version:    0.7.0.1
 */