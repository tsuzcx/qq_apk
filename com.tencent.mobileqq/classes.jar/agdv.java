import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class agdv
  implements DialogInterface.OnClickListener
{
  agdv(agdp paramagdp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      agdp.a(this.a, agdp.a(this.a));
    }
    while (paramInt != 0) {
      return;
    }
    this.a.b();
    agdp.a(this.a).moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agdv
 * JD-Core Version:    0.7.0.1
 */