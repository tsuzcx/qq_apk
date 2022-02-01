import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adwu
  implements View.OnClickListener
{
  public adwu(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwu
 * JD-Core Version:    0.7.0.1
 */