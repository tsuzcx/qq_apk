import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ocr.OCRRecognitionResultActivity;
import com.tencent.qphone.base.util.QLog;

public class agfl
  implements View.OnTouchListener
{
  public agfl(OCRRecognitionResultActivity paramOCRRecognitionResultActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      switch (paramMotionEvent.getAction())
      {
      case 0: 
        paramView.setAlpha(0.5F);
        return false;
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      QLog.i("OCRRecognitionResultActivity", 1, "mAlphaChangeTouchListener error:" + paramView.getMessage());
      return false;
    }
    paramView.setAlpha(1.0F);
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfl
 * JD-Core Version:    0.7.0.1
 */