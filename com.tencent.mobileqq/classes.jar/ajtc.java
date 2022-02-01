import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

class ajtc
  implements View.OnClickListener
{
  ajtc(ajtb paramajtb) {}
  
  public void onClick(View paramView)
  {
    if (ajtb.a(this.a))
    {
      QLog.d("PhotoPreviewLogicAEPlay", 2, "need more pic.");
      ajtb.a(this.a, String.format(((NewPhotoPreviewActivity)this.a.mActivity).getString(2131689741), new Object[] { Integer.valueOf(ajtb.a(this.a).maxSelectNum) }));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", ajtb.b(this.a).selectedPhotoList);
      localIntent.putExtra("pic_choose_in_node_id", ((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      localIntent.putExtra("pic_result_back_type", 0);
      AETemplateInfoFragment.sendPickedPhotosToMe(this.a.mActivity, localIntent);
      bmbc.a().W();
      ((NewPhotoPreviewActivity)this.a.mActivity).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtc
 * JD-Core Version:    0.7.0.1
 */