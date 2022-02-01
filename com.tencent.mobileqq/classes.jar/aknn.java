import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment;

public class aknn
  extends akmj
{
  protected long a;
  
  aknn(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    bnqm.a().aG();
    super.e(paramLocalMediaInfo);
  }
  
  public void onSendBtnClick(View paramView)
  {
    bnqm.a().f(System.currentTimeMillis() - this.a);
    this.a = System.currentTimeMillis();
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
    AECMShowPhotoPreviewFragment.a(this.mActivity, paramView);
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    bnqm.a().aH();
    bnqm.a().f(System.currentTimeMillis() - this.a);
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void postInitUI()
  {
    this.a = System.currentTimeMillis();
    bnqm.a().aF();
    super.postInitUI();
    ((NewPhotoListActivity)this.mActivity).previewBtn.setVisibility(8);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    bnqm.a().f(System.currentTimeMillis() - this.a);
    super.startPhotoPreviewActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknn
 * JD-Core Version:    0.7.0.1
 */