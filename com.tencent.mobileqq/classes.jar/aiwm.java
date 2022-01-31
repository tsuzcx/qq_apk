import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class aiwm
  implements DialogInterface.OnClickListener
{
  public aiwm(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("hb_id", SendHbActivity.a(this.a));
    paramDialogInterface.putExtra("send_uin", SendHbActivity.b(this.a));
    paramDialogInterface.putExtra("hb_type", "1");
    paramDialogInterface.putExtra("forward_text", this.a.getString(2131697494));
    if (SendHbActivity.a(this.a)) {
      paramDialogInterface.putExtra("item", 1);
    }
    paramDialogInterface.putExtra("forward_type", 17);
    paramDialogInterface.putExtra("invoke_from", "qwallet");
    aryv.a(this.a, paramDialogInterface);
    this.a.a(SendHbActivity.b(this.a), this.a.a(), "hongbao.wrapped.send", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwm
 * JD-Core Version:    0.7.0.1
 */