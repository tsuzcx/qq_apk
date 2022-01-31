import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagAdapter;
import java.util.List;

public class aezg
  extends Handler
{
  public aezg(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4097: 
      ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.c(this.a), 30, 0, 0);
      return;
    case 4098: 
      ChooseInterestTagActivity.a(this.a).setVisibility(8);
      paramMessage = (List)paramMessage.obj;
      if (paramMessage != null) {
        ChooseInterestTagActivity.a(this.a, paramMessage);
      }
      if (ChooseInterestTagActivity.a(this.a) == null)
      {
        ChooseInterestTagActivity.a(this.a, new InterestTagAdapter(this.a, ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a), ChooseInterestTagActivity.a(this.a)));
        ChooseInterestTagActivity.a(this.a).setAdapter(ChooseInterestTagActivity.a(this.a));
        paramMessage = this.a;
        if (ChooseInterestTagActivity.b(this.a) == -1) {
          break label219;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ChooseInterestTagActivity.a(paramMessage, false, bool);
        return;
        ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), true);
        break;
      }
    case 4100: 
      label219:
      ChooseInterestTagActivity.a(this.a, false);
      return;
    }
    ChooseInterestTagActivity.a(this.a, "当前网络不可用，请检查网络设置。");
    ChooseInterestTagActivity.a(this.a).setText("");
    ChooseInterestTagActivity.a(this.a).setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezg
 * JD-Core Version:    0.7.0.1
 */