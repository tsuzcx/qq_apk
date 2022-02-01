import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BaseActivityView;

public class aknl
  implements DialogInterface.OnKeyListener
{
  public aknl(BaseActivityView paramBaseActivityView) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) && (this.a.a.f()) && (bhnv.d(this.a.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknl
 * JD-Core Version:    0.7.0.1
 */