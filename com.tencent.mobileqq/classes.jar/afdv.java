import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afdv
  implements View.OnClickListener
{
  public afdv(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getIntent().getStringExtra("uin");
    if ((str != null) && (str.equals(this.a.app.getCurrentAccountUin())))
    {
      ProfileLabelEditorActivity.a(this.a);
      bdll.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdv
 * JD-Core Version:    0.7.0.1
 */