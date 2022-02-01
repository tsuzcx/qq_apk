import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class afyz
  implements DialogInterface.OnClickListener
{
  afyz(afyw paramafyw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (afyw.a(this.a) != null))
    {
      if (afyw.a(this.a) == 1) {
        afyw.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    afyw.a(this.a, this.a.a, afyw.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyz
 * JD-Core Version:    0.7.0.1
 */