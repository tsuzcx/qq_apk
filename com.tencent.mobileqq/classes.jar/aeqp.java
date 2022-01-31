import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagAdapter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.IInterestTagItemViewCallback;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;

public class aeqp
  implements InterestTagItemView.IInterestTagItemViewCallback
{
  public aeqp(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    ChooseInterestTagActivity.a(this.a, 0);
    InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
    boolean bool;
    if (!TextUtils.isEmpty(ChooseInterestTagActivity.a(this.a)))
    {
      ChooseInterestTagActivity.a(this.a).a(ChooseInterestTagActivity.a(this.a), true);
      ChooseInterestTagActivity localChooseInterestTagActivity = this.a;
      if (ChooseInterestTagActivity.b(this.a) != -1)
      {
        bool = true;
        ChooseInterestTagActivity.a(localChooseInterestTagActivity, false, bool);
        ChooseInterestTagActivity.a(this.a).setText("");
        ChooseInterestTagActivity.a(this.a, "");
      }
    }
    else
    {
      if (!ChooseInterestTagActivity.a(this.a, paramInterestTagInfo)) {
        break label132;
      }
      ChooseInterestTagActivity.a(this.a).remove(paramInterestTagInfo);
      ChooseInterestTagActivity.a(this.a, paramInterestTagInfo);
    }
    label132:
    do
    {
      return;
      bool = false;
      break;
      if (ChooseInterestTagActivity.a(this.a).size() < 8) {
        break label198;
      }
    } while (ChooseInterestTagActivity.d(this.a));
    ChooseInterestTagActivity.a(this.a, "最多只能添加8个标签哦");
    ChooseInterestTagActivity.b(this.a, true);
    ChooseInterestTagActivity.a(this.a).postDelayed(new aeqq(this), 2800L);
    return;
    label198:
    ChooseInterestTagActivity.a(this.a).add(paramInterestTagInfo);
    ChooseInterestTagActivity.c(this.a, paramInterestTagInfo);
  }
  
  public boolean a(InterestTagInfo paramInterestTagInfo)
  {
    return ChooseInterestTagActivity.a(this.a, paramInterestTagInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeqp
 * JD-Core Version:    0.7.0.1
 */