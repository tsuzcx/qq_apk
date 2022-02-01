import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alkd
  implements View.OnClickListener
{
  alkd(aljw paramaljw) {}
  
  public void onClick(View paramView)
  {
    andl localandl = andl.a();
    if (localandl != null)
    {
      localandl.a(aljw.a(this.a));
      localandl.a();
      andl.i();
    }
    bdll.a(aljw.a(this.a).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 10, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkd
 * JD-Core Version:    0.7.0.1
 */