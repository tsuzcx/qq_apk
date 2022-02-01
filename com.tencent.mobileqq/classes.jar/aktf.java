import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class aktf
  implements TextWatcher
{
  public aktf(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TransactionActivity.b(this.a).getText().length() > 4) {
      if (!TransactionActivity.b(this.a).isEnabled())
      {
        TransactionActivity.b(this.a).setEnabled(true);
        TransactionActivity.b(this.a).setClickable(true);
        this.a.a(TransactionActivity.b(this.a), 128, "transfer.qqid.enable", "", "", TransactionActivity.b(this.a), "");
      }
    }
    while (!TransactionActivity.b(this.a).isEnabled()) {
      return;
    }
    TransactionActivity.b(this.a).setClickable(false);
    TransactionActivity.b(this.a).setEnabled(false);
    this.a.a(TransactionActivity.b(this.a), 128, "transfer.qqid.disable", "", "", TransactionActivity.b(this.a), "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktf
 * JD-Core Version:    0.7.0.1
 */