import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class agpr
  implements DialogInterface.OnClickListener
{
  agpr(agpl paramagpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      agpl.a(this.a, agpl.a(this.a));
    }
    while (paramInt != 0) {
      return;
    }
    this.a.b();
    agpl.a(this.a).moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpr
 * JD-Core Version:    0.7.0.1
 */