import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;

class akkr
  implements DialogInterface.OnClickListener
{
  akkr(akkq paramakkq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("PhotoConst.readinjoy_delete_pic_position", ((NewPhotoPreviewActivity)this.a.a.mActivity).getCurrentSelectedPostion());
    ((NewPhotoPreviewActivity)this.a.a.mActivity).setResult(-1, paramDialogInterface);
    ((NewPhotoPreviewActivity)this.a.a.mActivity).finish();
    akkp.a(this.a.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkr
 * JD-Core Version:    0.7.0.1
 */