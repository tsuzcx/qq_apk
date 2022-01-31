import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class acwr
  implements DialogInterface.OnClickListener
{
  acwr(acwp paramacwp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (acwp.a(this.a) != null))
    {
      if (acwp.a(this.a) == 1) {
        acwp.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    acwp.a(this.a, this.a.a, acwp.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwr
 * JD-Core Version:    0.7.0.1
 */