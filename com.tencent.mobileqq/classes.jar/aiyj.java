import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class aiyj
  implements TextView.OnEditorActionListener
{
  aiyj(aiyh paramaiyh) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.a != null) {
        this.a.a.a();
      }
      aiyu.a("0X800A89F", 0, 0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyj
 * JD-Core Version:    0.7.0.1
 */