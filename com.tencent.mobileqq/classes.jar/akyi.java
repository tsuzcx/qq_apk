import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public class akyi
  implements View.OnClickListener
{
  public akyi(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    this.a.findViewById(2131302997).setAlpha(1.0F);
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.a.jdField_a_of_type_AndroidContentContext;
    String str = this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(localScanTorchActivity.a)) {}
    for (paramView = localScanTorchActivity.a;; paramView = str)
    {
      Intent localIntent = new Intent(localScanTorchActivity, QRDisplayActivity.class);
      localIntent.putExtra("from", "ScannerActivity");
      localIntent.putExtra("title", localScanTorchActivity.getString(2131651449));
      localIntent.putExtra("nick", paramView);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("type", 1);
      localScanTorchActivity.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyi
 * JD-Core Version:    0.7.0.1
 */