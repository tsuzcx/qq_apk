import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;
import com.tencent.qphone.base.util.QLog;

public class aaea
  implements TextWatcher
{
  public aaea(ARBlessWordFragment paramARBlessWordFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    String str = paramEditable.toString();
    if (str.endsWith(" "))
    {
      paramEditable = str.substring(0, str.length() - 1);
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ARBlessWordFragment.a(this.a).setText(paramEditable);
        ARBlessWordFragment.a(this.a).setSelection(ARBlessWordFragment.a(this.a).getText().length());
      }
      return;
      if (ARBlessWordFragment.a(this.a).getLineCount() > 4)
      {
        i = ARBlessWordFragment.a(this.a).getSelectionStart();
        if ((i == ARBlessWordFragment.a(this.a).getSelectionEnd()) && (i < str.length()) && (i >= 1)) {}
        for (paramEditable = str.substring(0, i - 1) + str.substring(i);; paramEditable = str.substring(0, paramEditable.length() - 1))
        {
          i = 1;
          break;
        }
      }
      paramEditable = str;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ARBlessWordFragment.a(this.a).getLineCount();
    if (QLog.isColorLevel()) {
      QLog.d("ARBlessWordFragment", 2, "mEditText beforeTextChanged  lines=" + paramInt1);
    }
    ARBlessWordFragment.a(this.a, paramInt1);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      ARBlessWordFragment.a(this.a).setGravity(51);
    }
    for (;;)
    {
      paramInt1 = ARBlessWordFragment.a(this.a).getLineCount();
      if (ARBlessWordFragment.a(this.a) == paramInt1)
      {
        paramInt2 = paramInt1;
        if (paramCharSequence.length() != 0) {}
      }
      else
      {
        if (paramCharSequence.length() == 0) {
          paramInt1 = 2;
        }
        ARBlessWordFragment.a(this.a, paramInt1);
        paramInt2 = paramInt1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARBlessWordFragment", 2, "mEditText onTextChanged  lines=" + paramInt2);
      }
      ARBlessWordFragment.a(this.a, -1);
      return;
      ARBlessWordFragment.a(this.a).setGravity(49);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaea
 * JD-Core Version:    0.7.0.1
 */