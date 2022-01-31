import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class agpm
  implements DialogInterface.OnClickListener
{
  agpm(agpl paramagpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.b();
      agpl.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpm
 * JD-Core Version:    0.7.0.1
 */