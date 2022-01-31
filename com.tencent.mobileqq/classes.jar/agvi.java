import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

class agvi
  implements View.OnClickListener
{
  agvi(agvh paramagvh) {}
  
  public void onClick(View paramView)
  {
    if (agvh.a(this.a) == null)
    {
      agvh.a(this.a, bbcv.a((Context)this.a.a.get(), 0, ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718404), null, ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718402), ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718403), new agvj(this), new agvk(this)));
      agvh.a(this.a).setCanceledOnTouchOutside(false);
    }
    agvh.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvi
 * JD-Core Version:    0.7.0.1
 */