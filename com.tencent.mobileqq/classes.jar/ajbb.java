import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajbb
  implements View.OnClickListener
{
  public ajbb(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (BlessSelectMemberActivity.a() != null) {
      BlessSelectMemberActivity.a().sendEmptyMessage(1);
    }
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbb
 * JD-Core Version:    0.7.0.1
 */