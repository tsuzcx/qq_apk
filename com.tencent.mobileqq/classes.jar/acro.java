import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class acro
  extends LinkMovementMethod
{
  private acrq jdField_a_of_type_Acrq;
  
  private acro(EditInfoActivity paramEditInfoActivity) {}
  
  private acrq a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramTextView.getTotalPaddingLeft();
    int m = paramTextView.getTotalPaddingTop();
    int n = paramTextView.getScrollX();
    int i1 = paramTextView.getScrollY();
    paramTextView = paramTextView.getLayout();
    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
    paramTextView = (acrq[])paramSpannable.getSpans(i, i, acrq.class);
    if (paramTextView.length > 0) {
      return paramTextView[0];
    }
    return null;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Acrq = a(paramTextView, paramSpannable, paramMotionEvent);
      if (this.jdField_a_of_type_Acrq != null)
      {
        this.jdField_a_of_type_Acrq.a(true);
        Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.jdField_a_of_type_Acrq), paramSpannable.getSpanEnd(this.jdField_a_of_type_Acrq));
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() != 2) {
        break;
      }
      paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
    } while ((this.jdField_a_of_type_Acrq == null) || (paramTextView == this.jdField_a_of_type_Acrq));
    this.jdField_a_of_type_Acrq.a(false);
    this.jdField_a_of_type_Acrq = null;
    Selection.removeSelection(paramSpannable);
    return true;
    if (this.jdField_a_of_type_Acrq != null)
    {
      this.jdField_a_of_type_Acrq.a(false);
      super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
    this.jdField_a_of_type_Acrq = null;
    Selection.removeSelection(paramSpannable);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acro
 * JD-Core Version:    0.7.0.1
 */