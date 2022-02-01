import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajkv
  implements View.OnClickListener
{
  ajkv(ajkt paramajkt) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a(this.a.a);
    bdla.b(ajkt.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkv
 * JD-Core Version:    0.7.0.1
 */