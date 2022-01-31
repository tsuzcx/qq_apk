import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.ArithResultView;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import org.json.JSONException;

public class ajgd
  implements View.OnClickListener
{
  public ajgd(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      CheckArithHWResultFragment.a(this.a, CheckArithHWResultFragment.a(this.a).a(), CheckArithHWResultFragment.a(this.a).a());
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      AssertUtils.a("QQ.Troop.homework.CheckArithHWResultFragment//onClick toJSON error:" + paramView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgd
 * JD-Core Version:    0.7.0.1
 */