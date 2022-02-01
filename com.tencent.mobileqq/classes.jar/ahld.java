import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class ahld
  implements TextWatcher
{
  ahld(ahlc paramahlc) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a.showSendWantGiftMsg.getAndSet(false);
    this.a.a.a.input.removeTextChangedListener(this);
    this.a.a.a.input.setTag(2131374018, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */