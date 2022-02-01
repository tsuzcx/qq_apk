import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper.1;
import com.tencent.widget.XEditTextEx;

public class agks
  implements agin
{
  private BaseChatPie a;
  
  public agks(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if (this.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.mActivity.getIntent().getStringExtra("chat_inputBarContent");
    } while ((str == null) || (str.isEmpty()));
    this.a.input.setText(str);
    this.a.input.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.mActivity.getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.a.input, 1);
    }
    this.a.input.post(new TroopEggLottieAnimHelper.1(this, str));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agks
 * JD-Core Version:    0.7.0.1
 */