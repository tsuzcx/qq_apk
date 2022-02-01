import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afql
  implements View.OnClickListener
{
  public afql(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((str == null) || (str.length() == 0)) {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131691774), 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (str != null)
      {
        this.a.a(str);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        VerifyCodeActivity.b(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afql
 * JD-Core Version:    0.7.0.1
 */