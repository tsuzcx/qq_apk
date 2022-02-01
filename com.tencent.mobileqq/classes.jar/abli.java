import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abli
  implements View.OnClickListener
{
  abli(ablf paramablf) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Ablp.a(this.a.jdField_a_of_type_AndroidAppActivity, paramView, this.a.a(paramView), ablf.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abli
 * JD-Core Version:    0.7.0.1
 */