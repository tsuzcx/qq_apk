import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajdb
  implements View.OnClickListener
{
  ajdb(ajcz paramajcz, ajdf paramajdf) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajcz.a != null)
    {
      int i = this.jdField_a_of_type_Ajdf.getAdapterPosition();
      this.jdField_a_of_type_Ajcz.a.a(paramView, this.jdField_a_of_type_Ajdf, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdb
 * JD-Core Version:    0.7.0.1
 */