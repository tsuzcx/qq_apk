import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class adok
  implements View.OnClickListener
{
  public adok(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent().getStringExtra("uin");
    if ((paramView != null) && (paramView.equals(this.a.app.getCurrentAccountUin())))
    {
      ProfileLabelEditorActivity.a(this.a);
      azqs.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "4", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adok
 * JD-Core Version:    0.7.0.1
 */