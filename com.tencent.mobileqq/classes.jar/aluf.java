import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;

public class aluf
  implements DialogInterface.OnClickListener
{
  public aluf(ColorNoteSmallScreenPermissionDialogFragment paramColorNoteSmallScreenPermissionDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = babr.a(this.a.getActivity(), 230).setMessage(2131625301).setNegativeButton(2131625300, new alug(this));
    paramDialogInterface.setOnDismissListener(new aluh(this));
    paramDialogInterface.setCancelable(false);
    paramDialogInterface.setCanceledOnTouchOutside(false);
    paramDialogInterface.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aluf
 * JD-Core Version:    0.7.0.1
 */