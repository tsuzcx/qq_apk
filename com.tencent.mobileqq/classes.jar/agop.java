import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agop
  implements View.OnClickListener
{
  public agop(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.a(this.a) == null)
    {
      PhotoPreviewActivity.a(this.a, bbcv.a(this.a, 0, this.a.getString(2131718404), null, this.a.getString(2131718402), this.a.getString(2131718403), new agoq(this), new agor(this)));
      PhotoPreviewActivity.a(this.a).setCanceledOnTouchOutside(false);
    }
    PhotoPreviewActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agop
 * JD-Core Version:    0.7.0.1
 */