import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class aedr
  implements TextWatcher
{
  aedr(aedq paramaedq) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131372749, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedr
 * JD-Core Version:    0.7.0.1
 */