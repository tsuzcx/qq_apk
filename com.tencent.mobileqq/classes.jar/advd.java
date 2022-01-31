import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;
import mqq.os.MqqHandler;

public class advd
  extends alox
{
  public advd(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  void a(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new SubAccountBindActivity.5.1(this, paramString, paramInt));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountBindActivity.a(this.a) != null) {
        i = SubAccountBindActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountBindActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.a(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.a(this.a).get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountBindActivity.a(this.a) != null) {
        i = SubAccountBindActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountBindActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountBindActivity.a(this.a).get(j) != null) && (paramString.equals(((SimpleAccount)SubAccountBindActivity.a(this.a).get(j)).getUin())))
        {
          TextView localTextView1 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131370958);
          TextView localTextView2 = (TextView)SubAccountBindActivity.a(this.a).getChildAt(j).findViewById(2131361822);
          localTextView1.setText(bdbt.h(this.a.app, paramString));
          localTextView2.setText(paramString);
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advd
 * JD-Core Version:    0.7.0.1
 */