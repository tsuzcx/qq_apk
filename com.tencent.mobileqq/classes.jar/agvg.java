import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

class agvg
  implements View.OnClickListener
{
  agvg(agvf paramagvf) {}
  
  public void onClick(View paramView)
  {
    if (agvf.a(this.a) == null)
    {
      agvf.a(this.a, bbdj.a((Context)this.a.a.get(), 0, ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718415), null, ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718413), ((NewPhotoPreviewActivity)this.a.a.get()).getString(2131718414), new agvh(this), new agvi(this)));
      agvf.a(this.a).setCanceledOnTouchOutside(false);
    }
    agvf.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvg
 * JD-Core Version:    0.7.0.1
 */