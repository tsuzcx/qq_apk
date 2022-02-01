import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akih
  implements View.OnClickListener
{
  akih(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_Long == 77313L) {
      this.a.jdField_b_of_type_Boolean = true;
    }
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akih
 * JD-Core Version:    0.7.0.1
 */