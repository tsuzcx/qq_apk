import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajse
  implements View.OnClickListener
{
  ajse(ajsd paramajsd, ajsg paramajsg) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Ajsg.a.getText());
    ajsd.a(this.jdField_a_of_type_Ajsd, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajse
 * JD-Core Version:    0.7.0.1
 */