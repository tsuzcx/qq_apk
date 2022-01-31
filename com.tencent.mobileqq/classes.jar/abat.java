import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class abat
  extends LinkMovementMethod
{
  private abav jdField_a_of_type_Abav;
  
  private abat(EditInfoActivity paramEditInfoActivity) {}
  
  private abav a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (abav[])paramSpannable.getSpans(i, i, abav.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Abav = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.jdField_a_of_type_Abav != null)
      {
        this.jdField_a_of_type_Abav.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_Abav), paramSpannable.getSpanEnd(this.jdField_a_of_type_Abav));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.jdField_a_of_type_Abav == null) || (paramTextView == this.jdField_a_of_type_Abav));
    this.jdField_a_of_type_Abav.a(false);
    this.jdField_a_of_type_Abav = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.jdField_a_of_type_Abav != null)
    {
      this.jdField_a_of_type_Abav.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.jdField_a_of_type_Abav = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abat
 * JD-Core Version:    0.7.0.1
 */