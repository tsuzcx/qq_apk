import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class afbm
  implements DialogInterface.OnClickListener
{
  afbm(afbj paramafbj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (afbj.a(this.a) != null))
    {
      if (afbj.a(this.a) == 1) {
        afbj.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    afbj.a(this.a, this.a.a, afbj.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbm
 * JD-Core Version:    0.7.0.1
 */