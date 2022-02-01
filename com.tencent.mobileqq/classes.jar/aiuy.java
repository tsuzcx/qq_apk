import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiuy
  implements View.OnClickListener
{
  aiuy(aiux paramaiux, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aiux.a != null) {
      this.jdField_a_of_type_Aiux.a.a(paramView, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuy
 * JD-Core Version:    0.7.0.1
 */