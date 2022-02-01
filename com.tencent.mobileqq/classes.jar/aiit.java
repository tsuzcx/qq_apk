import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiit
  implements View.OnClickListener
{
  aiit(aiir paramaiir, aiix paramaiix) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aiir.a != null)
    {
      int i = this.jdField_a_of_type_Aiix.getAdapterPosition();
      this.jdField_a_of_type_Aiir.a.a(paramView, this.jdField_a_of_type_Aiix, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiit
 * JD-Core Version:    0.7.0.1
 */