import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class akrl
  implements DialogInterface.OnClickListener
{
  akrl(akrf paramakrf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      akrf.a(this.a, akrf.a(this.a));
    }
    while (paramInt != 0) {
      return;
    }
    this.a.b();
    akrf.a(this.a).moveTaskToBack(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrl
 * JD-Core Version:    0.7.0.1
 */