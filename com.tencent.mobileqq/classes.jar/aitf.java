import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

class aitf
  implements View.OnClickListener
{
  aitf(aite paramaite) {}
  
  public void onClick(View paramView)
  {
    if (aite.a(this.a))
    {
      QLog.d("PhotoPreviewLogicAEPlay", 2, "need more pic.");
      aite.a(this.a, String.format(((NewPhotoPreviewActivity)this.a.mActivity).getString(2131689821), new Object[] { Integer.valueOf(aite.a(this.a).maxSelectNum) }));
      return;
    }
    ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", aite.b(this.a).selectedPhotoList);
    paramView.putExtra("pic_choose_in_node_id", ((NewPhotoPreviewActivity)this.a.mActivity).getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    AETemplateInfoFragment.a(this.a.mActivity, paramView);
    bliu.a().D();
    ((NewPhotoPreviewActivity)this.a.mActivity).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitf
 * JD-Core Version:    0.7.0.1
 */