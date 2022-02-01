import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aclh
  implements View.OnClickListener
{
  aclh(aclf paramaclf) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    aclf.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclh
 * JD-Core Version:    0.7.0.1
 */