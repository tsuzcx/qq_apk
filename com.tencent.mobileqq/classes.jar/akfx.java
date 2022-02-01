import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akfx
  implements View.OnClickListener
{
  akfx(akfw paramakfw, akfz paramakfz) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.jdField_a_of_type_Akfz.a.getText());
    akfw.a(this.jdField_a_of_type_Akfw, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfx
 * JD-Core Version:    0.7.0.1
 */