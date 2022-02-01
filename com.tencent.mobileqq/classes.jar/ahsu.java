import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ahsu
  implements TextView.OnEditorActionListener
{
  ahsu(ahss paramahss) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a.a != null) {
        this.a.a.a();
      }
      ahtf.a("0X800A89F", 0, 0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsu
 * JD-Core Version:    0.7.0.1
 */