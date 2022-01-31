import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;

public class agcr
  implements View.OnClickListener
{
  public agcr(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.a(this.a) == null)
    {
      PhotoPreviewActivity.a(this.a, babr.a(this.a, 0, this.a.getString(2131652585), null, this.a.getString(2131652583), this.a.getString(2131652584), new agcs(this), new agct(this)));
      PhotoPreviewActivity.a(this.a).setCanceledOnTouchOutside(false);
    }
    PhotoPreviewActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcr
 * JD-Core Version:    0.7.0.1
 */