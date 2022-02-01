import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adhd
  implements View.OnClickListener
{
  public adhd(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("param_wzry_data", AddRequestActivity.a(this.a));
    ajas.a(this.a.app, this.a, this.a.jdField_a_of_type_JavaLangString, AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Int, AddRequestActivity.a(this.a), localIntent);
    if (AddRequestActivity.a(this.a) != null) {
      bdla.b(this.a.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
    }
    bdla.b(this.a.app, "CliOper", "", "", "0X800AA42", "0X800AA42", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhd
 * JD-Core Version:    0.7.0.1
 */