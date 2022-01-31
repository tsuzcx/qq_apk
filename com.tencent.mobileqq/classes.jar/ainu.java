import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.emoticonview.EmotionPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ainu
  extends aiml
{
  protected ainu(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void b()
  {
    if (this.mPhotoCommonData.selectedPhotoList != null) {}
    for (int i = this.mPhotoCommonData.selectedPhotoList.size();; i = 0)
    {
      azmj.b(null, "CliOper", "", "", "0X800A6D8", "0X800A6D8", 0, 0, String.valueOf(i), "", "", "");
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.mPhotoCommonData.selectedPhotoList);
      ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      bdar.anim(this.mActivity, false, false);
      return;
    }
  }
  
  public void enterAlbumListFragment(Intent paramIntent)
  {
    azmj.b(null, "dc00898", "", "", "0X800A6DF", "0X800A6DF", 0, 0, "", "", "", "");
    super.enterAlbumListFragment(paramIntent);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    return ((NewPhotoListActivity)this.mActivity).getString(2131695251, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.customSendBtnText = ((NewPhotoListActivity)this.mActivity).getString(2131695307);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList = this.mPhotoCommonData.selectedPhotoList;
    if ((QLog.isDevelopLevel()) && (localArrayList != null) && (localArrayList.size() != 0)) {
      QLog.d("PhotoListActivity", 4, "[NewPhotoListActivity] [onActivityResult] selectedPhotoList = " + localArrayList.size());
    }
    if ((paramInt2 == -1) && (paramInt1 == 100015))
    {
      ((NewPhotoListActivity)this.mActivity).setResult(-1, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
    }
  }
  
  public void onPreviewBtnClick(View paramView)
  {
    EmotionPreviewFragment.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getIntent(), this.mPhotoCommonData.selectedPhotoList);
    azmj.b(null, "dc00898", "", "", "0X800A6DC", "0X800A6DC", 0, 0, "", "", "", "");
  }
  
  public void onTitleBtnCancelClick(View paramView)
  {
    azmj.b(null, "dc00898", "", "", "0X800A6E0", "0X800A6E0", 0, 0, "", "", "", "");
    super.onTitleBtnCancelClick(paramView);
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    azmj.b(null, "CliOper", "", "", "0X800A6D9", "0X800A6D9", 0, 0, "", "", "", "");
    ((NewPhotoListActivity)this.mActivity).startActivityForResult(paramIntent, 100015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainu
 * JD-Core Version:    0.7.0.1
 */