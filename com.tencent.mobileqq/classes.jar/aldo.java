import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aldo
  implements View.OnClickListener
{
  aldo(aldh paramaldh) {}
  
  public void onClick(View paramView)
  {
    amyv localamyv = amyv.a();
    if (localamyv != null)
    {
      localamyv.a(aldh.a(this.a));
      localamyv.a();
      amyv.i();
    }
    bdla.a(aldh.a(this.a).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 10, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldo
 * JD-Core Version:    0.7.0.1
 */