import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ahwq
  implements DialogInterface.OnClickListener
{
  ahwq(ahwo paramahwo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      bdun.a(ahwo.a(this.a), ahwo.a(this.a), "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", ahwo.a(this.a).getApp().getString(2131720522), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwq
 * JD-Core Version:    0.7.0.1
 */