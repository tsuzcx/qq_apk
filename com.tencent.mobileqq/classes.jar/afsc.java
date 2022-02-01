import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afsc
  implements View.OnClickListener
{
  afsc(afrz paramafrz, afrw paramafrw) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Afrz.a.a(this.jdField_a_of_type_Afrw);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsc
 * JD-Core Version:    0.7.0.1
 */