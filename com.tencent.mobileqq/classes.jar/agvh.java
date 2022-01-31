import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

class agvh
  implements DialogInterface.OnClickListener
{
  agvh(agvg paramagvg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", ((NewPhotoPreviewActivity)this.a.a.a.get()).a());
    ((NewPhotoPreviewActivity)this.a.a.a.get()).setResult(-1, paramDialogInterface);
    ((NewPhotoPreviewActivity)this.a.a.a.get()).finish();
    agvf.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvh
 * JD-Core Version:    0.7.0.1
 */