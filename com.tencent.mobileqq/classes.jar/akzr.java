import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class akzr
  implements TextWatcher
{
  public akzr(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    for (boolean bool = true;; bool = false)
    {
      try
      {
        Button localButton = TransactionActivity.a(this.a);
        if (TextUtils.isEmpty(paramEditable.toString())) {
          continue;
        }
        localButton.setEnabled(bool);
        float f = Float.parseFloat(paramEditable.toString());
        int i = TransactionActivity.a(this.a).getText().length();
        paramEditable = TransactionActivity.a(this.a, f);
        if (bhsr.a(paramEditable))
        {
          TransactionActivity.a(this.a).setVisibility(0);
          TransactionActivity.a(this.a).setVisibility(8);
          TransactionActivity.a(this.a).setVisibility(8);
        }
        while ((i > 0) && (!TransactionActivity.a(this.a).getText().toString().startsWith(".")) && (!TransactionActivity.a(this.a).getText().toString().endsWith(".")) && (TransactionActivity.a(this.a, TransactionActivity.a(this.a).getText().toString())))
        {
          if ((TransactionActivity.a(this.a) > 0) && (!TextUtils.isEmpty(TransactionActivity.a(this.a))) && (f * 100.0F >= TransactionActivity.a(this.a)) && (!TextUtils.isEmpty(TransactionActivity.a(this.a)))) {
            this.a.a(TransactionActivity.a(this.a));
          }
          if (TransactionActivity.a(this.a).isEnabled()) {
            break label406;
          }
          TransactionActivity.a(this.a).setEnabled(true);
          this.a.a(TransactionActivity.b(this.a), 128, "transfer.amount.enable", "", "", TransactionActivity.b(this.a), "");
          return;
          TransactionActivity.a(this.a).setVisibility(8);
          TransactionActivity.a(this.a).setVisibility(0);
          TransactionActivity.a(this.a).setVisibility(0);
          TransactionActivity.a(this.a).setText(paramEditable);
        }
        if (!TransactionActivity.a(this.a).isEnabled()) {
          break label406;
        }
      }
      catch (Exception paramEditable)
      {
        paramEditable.printStackTrace();
        return;
      }
      TransactionActivity.a(this.a).setEnabled(false);
      this.a.a(TransactionActivity.b(this.a), 128, "transfer.amount.disable", "", "", TransactionActivity.b(this.a), "");
      label406:
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */