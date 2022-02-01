import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class agsf
  implements TextWatcher
{
  agsf(agse paramagse) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a.showSendWantGiftMsg.getAndSet(false);
    this.a.a.a.input.removeTextChangedListener(this);
    this.a.a.a.input.setTag(2131373800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsf
 * JD-Core Version:    0.7.0.1
 */