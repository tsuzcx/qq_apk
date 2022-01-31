import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;

public class agyq
  implements View.OnClickListener
{
  public agyq(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (BlessSelectMemberActivity.a() != null) {
      BlessSelectMemberActivity.a().sendEmptyMessage(1);
    }
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyq
 * JD-Core Version:    0.7.0.1
 */