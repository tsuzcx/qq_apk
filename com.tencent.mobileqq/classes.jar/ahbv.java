import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahbv
  implements View.OnClickListener
{
  ahbv(ahbt paramahbt) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (!TextUtils.isEmpty(str)) {
      ahbt.a(this.a, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbv
 * JD-Core Version:    0.7.0.1
 */