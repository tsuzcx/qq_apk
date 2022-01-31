import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

class agvj
  implements DialogInterface.OnClickListener
{
  agvj(agvi paramagvi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", ((NewPhotoPreviewActivity)this.a.a.a.get()).a());
    ((NewPhotoPreviewActivity)this.a.a.a.get()).setResult(-1, paramDialogInterface);
    ((NewPhotoPreviewActivity)this.a.a.a.get()).finish();
    agvh.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvj
 * JD-Core Version:    0.7.0.1
 */