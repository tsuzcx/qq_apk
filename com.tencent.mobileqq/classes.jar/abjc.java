import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.HotChatAnnounceActivity;

public class abjc
  implements TextWatcher
{
  public abjc(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    int i = 0;
    if (!TextUtils.isEmpty(paramEditable)) {
      i = paramEditable.getBytes().length / 3;
    }
    if (i <= 40) {
      this.a.a.setTextColor(this.a.getResources().getColor(2131166928));
    }
    for (;;)
    {
      this.a.a.setText("" + (40 - i));
      return;
      this.a.a.setTextColor(-65536);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abjc
 * JD-Core Version:    0.7.0.1
 */