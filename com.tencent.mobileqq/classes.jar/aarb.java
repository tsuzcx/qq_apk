import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class aarb
  extends LinkMovementMethod
{
  private aard jdField_a_of_type_Aard;
  
  private aarb(EditInfoActivity paramEditInfoActivity) {}
  
  private aard a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (aard[])paramSpannable.getSpans(i, i, aard.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Aard = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.jdField_a_of_type_Aard != null)
      {
        this.jdField_a_of_type_Aard.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_Aard), paramSpannable.getSpanEnd(this.jdField_a_of_type_Aard));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.jdField_a_of_type_Aard == null) || (paramTextView == this.jdField_a_of_type_Aard));
    this.jdField_a_of_type_Aard.a(false);
    this.jdField_a_of_type_Aard = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.jdField_a_of_type_Aard != null)
    {
      this.jdField_a_of_type_Aard.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.jdField_a_of_type_Aard = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarb
 * JD-Core Version:    0.7.0.1
 */