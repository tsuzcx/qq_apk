import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class afsy
  implements DialogInterface.OnClickListener
{
  afsy(afsv paramafsv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (afsv.a(this.a) != null))
    {
      if (afsv.a(this.a) == 1) {
        afsv.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    afsv.a(this.a, this.a.a, afsv.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsy
 * JD-Core Version:    0.7.0.1
 */