import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.utils.DisplayUtils;

public class aemv
  implements Runnable
{
  public aemv(MagicfaceViewController paramMagicfaceViewController) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.c.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(this.a.a.a(), 10.0F));
    this.a.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemv
 * JD-Core Version:    0.7.0.1
 */