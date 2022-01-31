import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.widget.ActionSheet;

public class acwz
  implements DialogInterface.OnKeyListener
{
  public acwz(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.a.a != null)
      {
        this.a.a.dismiss();
        this.a.a = null;
      }
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwz
 * JD-Core Version:    0.7.0.1
 */