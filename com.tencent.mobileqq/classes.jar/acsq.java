import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.views.form.GdtFormView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acsq
  implements View.OnClickListener
{
  public acsq(GdtFormView paramGdtFormView) {}
  
  public void onClick(View paramView)
  {
    if (GdtFormView.a(this.a)) {
      GdtFormView.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsq
 * JD-Core Version:    0.7.0.1
 */