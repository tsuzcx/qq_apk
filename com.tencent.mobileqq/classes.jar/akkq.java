import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akkq
  implements View.OnClickListener
{
  akkq(akkp paramakkp) {}
  
  public void onClick(View paramView)
  {
    if (akkp.a(this.a) == null)
    {
      akkp.a(this.a, bglp.a(this.a.mActivity, 0, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131716984), null, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131716982), ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131716983), new akkr(this), new akks(this)));
      akkp.a(this.a).setCanceledOnTouchOutside(false);
    }
    akkp.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkq
 * JD-Core Version:    0.7.0.1
 */