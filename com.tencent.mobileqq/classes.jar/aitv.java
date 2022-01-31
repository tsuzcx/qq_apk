import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;

class aitv
  implements DialogInterface.OnClickListener
{
  aitv(aitu paramaitu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", ((NewPhotoPreviewActivity)this.a.a.mActivity).getCurrentSelectedPostion());
    ((NewPhotoPreviewActivity)this.a.a.mActivity).setResult(-1, paramDialogInterface);
    ((NewPhotoPreviewActivity)this.a.a.mActivity).finish();
    aitt.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitv
 * JD-Core Version:    0.7.0.1
 */