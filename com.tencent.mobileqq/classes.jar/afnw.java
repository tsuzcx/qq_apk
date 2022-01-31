import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class afnw
  implements View.OnTouchListener
{
  public afnw(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j;
    if ((paramView == OCRRecognitionResultActivity.a(this.a)) || (paramView == OCRRecognitionResultActivity.b(this.a)))
    {
      paramView = (EditText)paramView;
      j = paramMotionEvent.getAction();
      if (j != 1) {
        break label255;
      }
      Object localObject = paramView.getText();
      int m = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      int n = paramView.getTotalPaddingLeft();
      int k = paramView.getTotalPaddingTop();
      m = m - n + paramView.getScrollX();
      n = paramView.getScrollY();
      Layout localLayout = paramView.getLayout();
      i = localLayout.getLineForVertical(i - k + n);
      float f = localLayout.getLineWidth(i);
      if (m > f) {
        break label255;
      }
      i = localLayout.getOffsetForHorizontal(i, m);
      localObject = (ClickableSpan[])((Spannable)localObject).getSpans(i, i, ClickableSpan.class);
      if ((localObject.length == 0) || (j != 1)) {
        break label255;
      }
      localObject[0].onClick(paramView);
      ReportController.b(null, "dc00898", "", "", "0X80082E3", "0X80082E3", 0, 0, "", "", "", "");
    }
    label255:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        return true;
      }
      if ((j == 1) && (!paramView.isFocused())) {
        ReportController.b(null, "dc00898", "", "", "0X80082E2", "0X80082E2", 0, 0, "", "", "", "");
      }
      return paramView.onTouchEvent(paramMotionEvent);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afnw
 * JD-Core Version:    0.7.0.1
 */