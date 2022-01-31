import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class afio
  implements DialogInterface.OnClickListener
{
  afio(afim paramafim) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      baoz.a(afim.a(this.a), afim.a(this.a), "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", afim.a(this.a).getApp().getString(2131654075), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afio
 * JD-Core Version:    0.7.0.1
 */