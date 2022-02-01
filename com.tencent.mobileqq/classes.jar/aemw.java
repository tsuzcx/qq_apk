import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class aemw
  extends LinkMovementMethod
{
  private aemy jdField_a_of_type_Aemy;
  
  private aemw(EditInfoActivity paramEditInfoActivity) {}
  
  private aemy a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (aemy[])paramSpannable.getSpans(i, i, aemy.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Aemy = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.jdField_a_of_type_Aemy != null)
      {
        this.jdField_a_of_type_Aemy.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_Aemy), paramSpannable.getSpanEnd(this.jdField_a_of_type_Aemy));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.jdField_a_of_type_Aemy == null) || (paramTextView == this.jdField_a_of_type_Aemy));
    this.jdField_a_of_type_Aemy.a(false);
    this.jdField_a_of_type_Aemy = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.jdField_a_of_type_Aemy != null)
    {
      this.jdField_a_of_type_Aemy.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.jdField_a_of_type_Aemy = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemw
 * JD-Core Version:    0.7.0.1
 */