import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;

class aiow
  extends aimu
{
  protected aiow(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.customSendBtnText = ((NewPhotoPreviewActivity)this.mActivity).getString(2131689991);
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).titleView.setVisibility(8);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new aiox(this));
    ((NewPhotoPreviewActivity)this.mActivity).cancelTv.setVisibility(8);
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion() != -1) {
      this.a.a = ((String)this.a.paths.get(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()));
    }
    super.onMagicStickClick(paramView, 18003, paramBundle, paramInt2, EditPicActivity.a(this.mActivity, this.a.a, true, true, true, true, true, false, false, false, 2, 122, 0, false, null));
    AIOLongShotHelper.a("0X8009DED");
  }
  
  public void updateButton()
  {
    super.updateButton();
    if ((this.mPhotoCommonData.selectedPhotoList != null) && (this.mPhotoCommonData.selectedPhotoList.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && ((this.a.g) || (this.a.isSingleMode)))
      {
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setVisibility(0);
        ((NewPhotoPreviewActivity)this.mActivity).magicStickBtn.setEnabled(true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */