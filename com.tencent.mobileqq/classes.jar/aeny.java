import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;

class aeny
  implements DialogInterface.OnClickListener
{
  aeny(aenv paramaenv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.a.a)) && (aenv.a(this.a) != null))
    {
      if (aenv.a(this.a) == 1) {
        aenv.b(this.a, this.a.a);
      }
    }
    else {
      return;
    }
    aenv.a(this.a, this.a.a, aenv.a(this.a).maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeny
 * JD-Core Version:    0.7.0.1
 */