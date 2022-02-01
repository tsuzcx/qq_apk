import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akrm
  implements DialogInterface.OnClickListener
{
  akrm(akrf paramakrf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.b();
      akrf.a(this.a).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrm
 * JD-Core Version:    0.7.0.1
 */