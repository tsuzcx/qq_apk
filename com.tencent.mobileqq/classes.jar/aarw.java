import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;

public class aarw
  implements View.OnFocusChangeListener
{
  public aarw(ARBlessWordFragment paramARBlessWordFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.a.a = paramBoolean;
    TextView localTextView = ARBlessWordFragment.a(this.a);
    if (paramBoolean)
    {
      paramView = "请输入20个字以内的祝福";
      localTextView.setText(paramView);
      paramView = ARBlessWordFragment.a(this.a);
      if (!paramBoolean) {
        break label57;
      }
    }
    label57:
    for (int i = 8;; i = 0)
    {
      paramView.setVisibility(i);
      return;
      paramView = "点击重新编辑";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarw
 * JD-Core Version:    0.7.0.1
 */