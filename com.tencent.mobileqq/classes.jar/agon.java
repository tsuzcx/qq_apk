import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agon
  implements View.OnClickListener
{
  public agon(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.a(this.a) == null)
    {
      PhotoPreviewActivity.a(this.a, bbdj.a(this.a, 0, this.a.getString(2131718415), null, this.a.getString(2131718413), this.a.getString(2131718414), new agoo(this), new agop(this)));
      PhotoPreviewActivity.a(this.a).setCanceledOnTouchOutside(false);
    }
    PhotoPreviewActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agon
 * JD-Core Version:    0.7.0.1
 */