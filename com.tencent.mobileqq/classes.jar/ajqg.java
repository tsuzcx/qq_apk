import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajqg
  implements View.OnClickListener
{
  ajqg(ajqf paramajqf, ajqi paramajqi) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Ajqi.a.getText());
    ajqf.a(this.jdField_a_of_type_Ajqf, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqg
 * JD-Core Version:    0.7.0.1
 */