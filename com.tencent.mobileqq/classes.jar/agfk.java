import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.widget.QQToast;

public class agfk
  implements TextWatcher
{
  public agfk(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 3400;
    if (paramEditable.toString().length() == 0)
    {
      OCRRecognitionResultActivity.a(this.a);
      return;
    }
    int j;
    if (paramEditable.length() > 3400)
    {
      j = OCRRecognitionResultActivity.b(this.a).getSelectionStart();
      OCRRecognitionResultActivity.b(this.a).setText(paramEditable.subSequence(0, 3400));
      if (j <= 3400) {
        break label128;
      }
    }
    for (;;)
    {
      OCRRecognitionResultActivity.b(this.a).setSelection(i);
      if (OCRRecognitionResultActivity.b(this.a)) {
        QQToast.a(this.a, 1, "字数超过上限", 0).a();
      }
      for (;;)
      {
        OCRRecognitionResultActivity.b(this.a);
        return;
        OCRRecognitionResultActivity.a(this.a, true);
      }
      label128:
      i = j;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfk
 * JD-Core Version:    0.7.0.1
 */