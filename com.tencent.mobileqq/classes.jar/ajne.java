import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ajne
  implements DialogInterface.OnClickListener
{
  ajne(ajnc paramajnc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (paramInt == 1) {
      bgzo.a(ajnc.a(this.a), ajnc.a(this.a), "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", ajnc.a(this.a).getApp().getString(2131718361), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajne
 * JD-Core Version:    0.7.0.1
 */