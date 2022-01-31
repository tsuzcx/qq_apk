import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

class agoo
  implements DialogInterface.OnClickListener
{
  agoo(agon paramagon) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", this.a.a.t);
    this.a.a.setResult(-1, paramDialogInterface);
    this.a.a.finish();
    PhotoPreviewActivity.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agoo
 * JD-Core Version:    0.7.0.1
 */