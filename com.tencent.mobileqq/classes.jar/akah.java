import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.2.1;

public class akah
  implements View.OnClickListener
{
  public akah(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    if (AppSetting.c) {
      this.a.c.post(new SelectMemberActivity.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akah
 * JD-Core Version:    0.7.0.1
 */