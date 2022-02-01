import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajds
  implements View.OnClickListener
{
  ajds(ajdq paramajdq, ajdw paramajdw) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajdq.a != null)
    {
      int i = this.jdField_a_of_type_Ajdw.getAdapterPosition();
      this.jdField_a_of_type_Ajdq.a.a(paramView, this.jdField_a_of_type_Ajdw, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */