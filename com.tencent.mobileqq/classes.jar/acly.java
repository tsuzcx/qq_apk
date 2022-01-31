import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class acly
  implements DialogInterface.OnClickListener
{
  acly(aclw paramaclw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (aclw.a(this.a) != null))
    {
      if (aclw.a(this.a) == 1) {
        aclw.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    aclw.a(this.a, this.a.a, aclw.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acly
 * JD-Core Version:    0.7.0.1
 */