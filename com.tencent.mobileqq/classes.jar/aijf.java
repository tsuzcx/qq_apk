import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aijf
  implements TextWatcher
{
  public aijf(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(this.a.a.b)) && (paramInt1 > 0) && (paramInt1 < this.a.a.b.length() + this.a.a.c.length() + this.a.a.a.length() + this.a.K.length()) && (paramInt2 > paramInt3))
    {
      this.a.e(false);
      return;
    }
    TroopBarPublishActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aijf
 * JD-Core Version:    0.7.0.1
 */