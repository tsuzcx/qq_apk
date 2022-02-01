import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajts
  implements View.OnClickListener
{
  ajts(ajtr paramajtr) {}
  
  public void onClick(View paramView)
  {
    if (ajtr.a(this.a) == null)
    {
      ajtr.a(this.a, bfur.a(this.a.mActivity, 0, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717337), null, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717335), ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717336), new ajtt(this), new ajtu(this)));
      ajtr.a(this.a).setCanceledOnTouchOutside(false);
    }
    ajtr.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajts
 * JD-Core Version:    0.7.0.1
 */