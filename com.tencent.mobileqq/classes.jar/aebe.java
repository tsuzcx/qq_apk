import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.leba.view.LebaFeedsArkView;
import com.tencent.qphone.base.util.QLog;

public class aebe
  implements ArkAppView.Callback
{
  public aebe(LebaFeedsArkView paramLebaFeedsArkView) {}
  
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams;
    StringBuilder localStringBuilder;
    if (this.a.a != null)
    {
      localLayoutParams = this.a.a.getLayoutParams();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("ark view loadSucc, lp.height=");
        if (localLayoutParams == null) {
          break label90;
        }
        localObject = Integer.valueOf(localLayoutParams.height);
        localStringBuilder = localStringBuilder.append(localObject).append(", lp.width=");
        if (localLayoutParams == null) {
          break label96;
        }
      }
    }
    label90:
    label96:
    for (Object localObject = Integer.valueOf(localLayoutParams.width);; localObject = "null")
    {
      QLog.i("LebaFeedsArkView", 2, localObject);
      return;
      localObject = "null";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebe
 * JD-Core Version:    0.7.0.1
 */