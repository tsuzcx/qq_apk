import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akpk
  implements View.OnClickListener
{
  akpk(akpj paramakpj) {}
  
  public void onClick(View paramView)
  {
    if (akpj.a(this.a) == null)
    {
      akpj.a(this.a, bhdj.a(this.a.mActivity, 0, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717703), null, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717701), ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131717702), new akpl(this), new akpm(this)));
      akpj.a(this.a).setCanceledOnTouchOutside(false);
    }
    akpj.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpk
 * JD-Core Version:    0.7.0.1
 */