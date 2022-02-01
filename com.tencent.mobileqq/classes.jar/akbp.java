import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akbp
  implements View.OnClickListener
{
  akbp(akbo paramakbo, akbr paramakbr) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Akbr.a.getText());
    akbo.a(this.jdField_a_of_type_Akbo, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbp
 * JD-Core Version:    0.7.0.1
 */