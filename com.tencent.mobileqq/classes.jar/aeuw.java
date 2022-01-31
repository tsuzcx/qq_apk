import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.nearby.now.utils.CommentsUtil;
import com.tencent.mobileqq.widget.QQToast;

public class aeuw
  implements InputFilter
{
  public aeuw(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = paramCharSequence;
    if (CommentsUtil.a(paramSpanned.toString()) + CommentsUtil.a(paramCharSequence.toString()) > 140)
    {
      QQToast.a(this.a.a(), 0, "最多输入140个字", 0).a();
      localObject = "";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeuw
 * JD-Core Version:    0.7.0.1
 */