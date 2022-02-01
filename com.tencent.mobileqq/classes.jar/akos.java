import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment;

class akos
  implements View.OnClickListener
{
  akos(akor paramakor) {}
  
  public void onClick(View paramView)
  {
    bnqm.a().aI();
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", akor.a(this.a).selectedPhotoList);
    AECMShowPhotoPreviewFragment.a(this.a.mActivity, localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akos
 * JD-Core Version:    0.7.0.1
 */