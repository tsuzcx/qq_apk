import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;

public class agdc
  implements TextView.OnEditorActionListener
{
  public agdc(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      OCRTextSearchActivity.a(this.a);
      this.a.a.setSelection(this.a.a.getText().length());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdc
 * JD-Core Version:    0.7.0.1
 */