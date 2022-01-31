import android.graphics.Rect;
import android.text.Editable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.qphone.base.util.QLog;

public class agaz
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public agaz(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public void onGlobalLayout()
  {
    int j = 0;
    int i = 0;
    Object localObject = new Rect();
    OCRRecognitionResultActivity.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
    int k = OCRRecognitionResultActivity.a(this.a).getRootView().getHeight();
    int m = k - ((Rect)localObject).bottom;
    if (QLog.isDevelopLevel()) {
      QLog.i("OCRRecognitionResultActivity", 2, "keypadHeight = " + m);
    }
    if (m > k * 0.15D)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("OCRRecognitionResultActivity", 2, "soft keyboard is opened");
      }
      QQText.LinkSpan[] arrayOfLinkSpan;
      if (OCRRecognitionResultActivity.a(this.a)) {
        try
        {
          localObject = OCRRecognitionResultActivity.a(this.a).getText();
          arrayOfLinkSpan = (QQText.LinkSpan[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), QQText.LinkSpan.class);
          if ((arrayOfLinkSpan != null) && (arrayOfLinkSpan.length > 0))
          {
            j = arrayOfLinkSpan.length;
            while (i < j)
            {
              ((Spannable)localObject).removeSpan(arrayOfLinkSpan[i]);
              i += 1;
            }
          }
          OCRRecognitionResultActivity.b(this.a).setVisibility(8);
        }
        catch (Exception localException1)
        {
          OCRRecognitionResultActivity.a(this.a).setText(OCRRecognitionResultActivity.a(this.a).getText());
        }
      }
      for (;;)
      {
        return;
        try
        {
          Editable localEditable = OCRRecognitionResultActivity.b(this.a).getText();
          arrayOfLinkSpan = (QQText.LinkSpan[])localEditable.getSpans(0, localEditable.length(), QQText.LinkSpan.class);
          if ((arrayOfLinkSpan != null) && (arrayOfLinkSpan.length > 0))
          {
            k = arrayOfLinkSpan.length;
            i = j;
            while (i < k)
            {
              localEditable.removeSpan(arrayOfLinkSpan[i]);
              i += 1;
            }
          }
        }
        catch (Exception localException2)
        {
          OCRRecognitionResultActivity.b(this.a).setText(OCRRecognitionResultActivity.b(this.a).getText());
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("OCRRecognitionResultActivity", 2, "soft keyboard is closed");
    }
    if (OCRRecognitionResultActivity.a(this.a)) {
      OCRRecognitionResultActivity.a(this.a).setText(new QQText(OCRRecognitionResultActivity.a(this.a).getText(), 8, 16));
    }
    for (;;)
    {
      if (OCRRecognitionResultActivity.a(this.a) != null) {
        OCRRecognitionResultActivity.a(this.a).clearFocus();
      }
      if (OCRRecognitionResultActivity.b(this.a) != null) {
        OCRRecognitionResultActivity.b(this.a).clearFocus();
      }
      OCRRecognitionResultActivity.b(this.a).setVisibility(0);
      return;
      OCRRecognitionResultActivity.b(this.a).setText(new QQText(OCRRecognitionResultActivity.b(this.a).getText(), 8, 16));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agaz
 * JD-Core Version:    0.7.0.1
 */