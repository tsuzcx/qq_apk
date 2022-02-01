import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agbg
  implements View.OnClickListener
{
  agbg(agbd paramagbd, agba paramagba) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Agbd.a.a(this.jdField_a_of_type_Agba);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbg
 * JD-Core Version:    0.7.0.1
 */