import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.send.EditVideoUi;
import com.tencent.mobileqq.nearby.now.send.PublishManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

public class aeue
  implements DialogInterface.OnClickListener
{
  public aeue(PublishManager paramPublishManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new NowVideoReporter().h("video_public").i("clk_cancelbox").e("1");
    if (this.a.b) {}
    for (paramInt = 2;; paramInt = 1)
    {
      paramDialogInterface.a(paramInt).d(PublishManager.b(this.a)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowSendEditVideoUi.a(0, null, 0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeue
 * JD-Core Version:    0.7.0.1
 */