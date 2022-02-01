import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajwm
  implements View.OnClickListener
{
  ajwm(ajwl paramajwl, ajwo paramajwo) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Ajwo.a.getText());
    ajwl.a(this.jdField_a_of_type_Ajwl, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwm
 * JD-Core Version:    0.7.0.1
 */