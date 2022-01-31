import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class aalz
  implements DialogInterface.OnClickListener
{
  public aalz(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", ajms.Y);
    this.a.a.startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalz
 * JD-Core Version:    0.7.0.1
 */