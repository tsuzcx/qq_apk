import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class allv
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public allv(int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allv
 * JD-Core Version:    0.7.0.1
 */