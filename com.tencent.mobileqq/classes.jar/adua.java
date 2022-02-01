import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adua
  implements View.OnClickListener
{
  public adua(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("param_wzry_data", AddRequestActivity.a(this.a));
    ajlk.a(this.a.app, this.a, this.a.jdField_a_of_type_JavaLangString, AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Int, AddRequestActivity.a(this.a), localIntent);
    if (AddRequestActivity.a(this.a) != null) {
      bdll.b(this.a.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
    }
    bdll.b(this.a.app, "CliOper", "", "", "0X800AA42", "0X800AA42", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adua
 * JD-Core Version:    0.7.0.1
 */