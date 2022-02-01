import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajuo
  implements View.OnClickListener
{
  ajuo(ajun paramajun, ajuq paramajuq) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Ajuq.a.getText());
    ajun.a(this.jdField_a_of_type_Ajun, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuo
 * JD-Core Version:    0.7.0.1
 */