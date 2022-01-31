import android.app.Activity;
import com.tencent.biz.widgets.ShareResultDialog.IShareResultCallback;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;

public class adbf
  implements ShareResultDialog.IShareResultCallback
{
  public adbf(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void a(boolean paramBoolean)
  {
    if (ForwardRecentActivity.class.isInstance(this.a.a)) {
      if (!this.a.a.isFinishing())
      {
        if (!paramBoolean) {
          break label75;
        }
        this.a.a(0, "", "");
      }
    }
    for (;;)
    {
      if (this.a.i) {
        ForwardSdkBaseOption.a(this.a.a, true, "shareToQQ", this.a.b);
      }
      return;
      label75:
      this.a.a(-1, "未知错误!", "未知错误!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbf
 * JD-Core Version:    0.7.0.1
 */