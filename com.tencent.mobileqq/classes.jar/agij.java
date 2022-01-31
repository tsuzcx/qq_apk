import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment;
import mqq.util.WeakReference;

class agij
  implements View.OnClickListener
{
  agij(agii paramagii) {}
  
  public void onClick(View paramView)
  {
    if (agii.a(this.a))
    {
      QLog.d("PhotoPreviewLogicAEPlay", 2, "need more pic.");
      agii.a(this.a, String.format(((NewPhotoPreviewActivity)this.a.a.get()).getString(2131624249), new Object[] { Integer.valueOf(agii.a(this.a).jdField_a_of_type_Int) }));
      return;
    }
    ((NewPhotoPreviewActivity)this.a.a.get()).b.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", agii.b(this.a).jdField_a_of_type_JavaUtilArrayList);
    paramView.putExtra("pic_choose_in_node_id", ((NewPhotoPreviewActivity)this.a.a.get()).getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    AETemplateInfoFragment.a((Context)this.a.a.get(), paramView);
    bhci.a().v();
    ((NewPhotoPreviewActivity)this.a.a.get()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agij
 * JD-Core Version:    0.7.0.1
 */