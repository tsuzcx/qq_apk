import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class admp
  implements View.OnClickListener
{
  public admp(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = HongbaoShowerActivity.a(this.a).isChecked();
    CheckBox localCheckBox = HongbaoShowerActivity.a(this.a);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admp
 * JD-Core Version:    0.7.0.1
 */