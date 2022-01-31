import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class afgh
  implements TextWatcher
{
  public afgh(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    NearbyUtils.a(this.a.a, 30);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgh
 * JD-Core Version:    0.7.0.1
 */