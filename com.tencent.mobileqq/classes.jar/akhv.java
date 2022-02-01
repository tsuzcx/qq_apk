import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akhv
  implements View.OnClickListener
{
  akhv(akho paramakho) {}
  
  public void onClick(View paramView)
  {
    alyf localalyf = alyf.a();
    if (localalyf != null)
    {
      localalyf.a(akho.a(this.a));
      localalyf.a();
      alyf.i();
    }
    bcef.a(akho.a(this.a).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 10, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhv
 * JD-Core Version:    0.7.0.1
 */