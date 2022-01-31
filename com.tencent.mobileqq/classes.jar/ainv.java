import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class ainv
  extends aiml
{
  protected ainv(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    return ((NewPhotoListActivity)this.mActivity).getString(2131695251, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainv
 * JD-Core Version:    0.7.0.1
 */