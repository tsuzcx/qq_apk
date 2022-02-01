import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajok
  implements View.OnClickListener
{
  ajok(ajoi paramajoi, ajoo paramajoo) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajoi.a != null)
    {
      int i = this.jdField_a_of_type_Ajoo.getAdapterPosition();
      this.jdField_a_of_type_Ajoi.a.a(paramView, this.jdField_a_of_type_Ajoo, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajok
 * JD-Core Version:    0.7.0.1
 */