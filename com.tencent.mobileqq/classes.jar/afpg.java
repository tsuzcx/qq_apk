import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afpg
  implements View.OnClickListener
{
  public afpg(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onAddAccountClick.onClick:add account");
    }
    Object localObject = (bdxc)this.a.app.getManager(61);
    if (localObject != null) {}
    for (int i = ((bdxc)localObject).a();; i = 0)
    {
      if (i < 2)
      {
        localObject = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.a.b);
        this.a.startActivity((Intent)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bdwt.a(this.a.app, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpg
 * JD-Core Version:    0.7.0.1
 */