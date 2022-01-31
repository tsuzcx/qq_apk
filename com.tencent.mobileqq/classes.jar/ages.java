import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class ages
  implements TextWatcher
{
  ages(ager paramager) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373133, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ages
 * JD-Core Version:    0.7.0.1
 */