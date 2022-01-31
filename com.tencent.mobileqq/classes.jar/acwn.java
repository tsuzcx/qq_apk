import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class acwn
  implements DialogInterface.OnClickListener
{
  acwn(acwl paramacwl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (acwl.a(this.a) != null))
    {
      if (acwl.a(this.a) == 1) {
        acwl.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    acwl.a(this.a, this.a.a, acwl.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwn
 * JD-Core Version:    0.7.0.1
 */