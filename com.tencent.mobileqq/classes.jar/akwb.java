import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akwb
  implements View.OnClickListener
{
  akwb(akwa paramakwa) {}
  
  public void onClick(View paramView)
  {
    if (akwa.a(this.a) == null)
    {
      akwa.a(this.a, bhlq.a(this.a.mActivity, 0, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717100), null, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717098), ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717099), new akwc(this), new akwd(this)));
      akwa.a(this.a).setCanceledOnTouchOutside(false);
    }
    akwa.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwb
 * JD-Core Version:    0.7.0.1
 */