import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ahsb
  implements DialogInterface.OnClickListener
{
  ahsb(ahrz paramahrz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      bdqe.a(ahrz.a(this.a), ahrz.a(this.a), "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", ahrz.a(this.a).getApp().getString(2131720510), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsb
 * JD-Core Version:    0.7.0.1
 */