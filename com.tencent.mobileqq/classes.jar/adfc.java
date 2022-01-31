import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class adfc
  implements Runnable
{
  public adfc(HiBoomFontDrawer paramHiBoomFontDrawer) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    int i = 0;
    label13:
    HiBoomTextView localHiBoomTextView;
    if (i < this.a.a.size())
    {
      localHiBoomTextView = (HiBoomTextView)((WeakReference)this.a.a.get(i)).get();
      if ((localHiBoomTextView != null) && (localHiBoomTextView.a == this.a.b)) {
        break label89;
      }
      this.a.a.remove(i);
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label89:
      localHiBoomTextView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adfc
 * JD-Core Version:    0.7.0.1
 */