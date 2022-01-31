import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

public class agim
  implements DialogInterface.OnKeyListener
{
  public agim(BaseActivityView paramBaseActivityView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (this.a.a.e()) && (bbfj.d(this.a.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agim
 * JD-Core Version:    0.7.0.1
 */