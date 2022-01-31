import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class acwd
  extends LinkMovementMethod
{
  private acwf jdField_a_of_type_Acwf;
  
  private acwd(EditInfoActivity paramEditInfoActivity) {}
  
  private acwf a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (acwf[])paramSpannable.getSpans(i, i, acwf.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Acwf = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.jdField_a_of_type_Acwf != null)
      {
        this.jdField_a_of_type_Acwf.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_Acwf), paramSpannable.getSpanEnd(this.jdField_a_of_type_Acwf));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.jdField_a_of_type_Acwf == null) || (paramTextView == this.jdField_a_of_type_Acwf));
    this.jdField_a_of_type_Acwf.a(false);
    this.jdField_a_of_type_Acwf = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.jdField_a_of_type_Acwf != null)
    {
      this.jdField_a_of_type_Acwf.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.jdField_a_of_type_Acwf = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwd
 * JD-Core Version:    0.7.0.1
 */