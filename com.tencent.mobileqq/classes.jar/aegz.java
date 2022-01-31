import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

public class aegz
  implements DialogInterface.OnClickListener
{
  public aegz(PublishManager paramPublishManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new NowVideoReporter().h("video_public").i("clk_cancelbox").e("2");
    if (this.a.b) {}
    for (paramInt = 2;; paramInt = 1)
    {
      paramDialogInterface.a(paramInt).d(PublishManager.b(this.a)).b(this.a.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aegz
 * JD-Core Version:    0.7.0.1
 */