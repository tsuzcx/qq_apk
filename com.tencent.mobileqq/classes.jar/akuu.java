import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;

public class akuu
  extends aktf
{
  akuu(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = bhlq.a(this.mActivity, 230, null, anzj.a(2131706968), anzj.a(2131706952), null, null, new akuv(this));
      try
      {
        paramLocalMediaInfo.show();
        return false;
      }
      catch (Exception paramLocalMediaInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListLogicNearby", 2, "showLocationFailDialog fail!", paramLocalMediaInfo);
          }
        }
      }
    }
    return true;
  }
  
  public Intent caseNoSingModeImage(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemViewType(paramInt) == 0) && (!a(localLocalMediaInfo))) {
      return null;
    }
    return super.caseNoSingModeImage(paramView, paramInt);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    return anzj.a(2131693930);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (a(((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt))) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
  }
  
  public void startPhotoPreviewActivity(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.startPhotoPreviewActivity(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuu
 * JD-Core Version:    0.7.0.1
 */