import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.16.1;

public class aief
  extends Handler
{
  public aief(SelectMemberActivity paramSelectMemberActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.b == null) || (!this.a.b.isShowing()));
      this.a.b.dismiss();
      paramMessage = new Intent();
      paramMessage.putExtra("select_member_add_request_ok", true);
      this.a.setResult(-1, paramMessage);
      if (!TextUtils.isEmpty(this.a.g))
      {
        paramMessage = this.a.g;
        bcql.a(this.a, 2, paramMessage, 1500).b(this.a.getTitleBarHeight());
        postDelayed(new SelectMemberActivity.16.1(this), 1500L);
        return;
      }
      if (this.a.c) {}
      for (int i = 2131693679;; i = 2131693678)
      {
        paramMessage = this.a.getResources().getString(i);
        break;
      }
    } while ((this.a.b == null) || (!this.a.b.isShowing()));
    this.a.b.dismiss();
    String str = (String)paramMessage.obj;
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131693677);
    }
    bcql.a(this.a, 1, paramMessage, 1500).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aief
 * JD-Core Version:    0.7.0.1
 */