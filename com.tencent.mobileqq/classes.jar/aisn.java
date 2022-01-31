import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class aisn
  extends aira
{
  aisn(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = bdgm.a(this.mActivity, 230, null, alud.a(2131708482), alud.a(2131708466), null, null, new aiso(this));
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
  
  public Intent caseNoSingModeImage(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if ((((NewPhotoListActivity)this.mActivity).photoListAdapter.getItemViewType(paramInt) == 0) && (!a(localLocalMediaInfo))) {
      return null;
    }
    return super.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    return alud.a(2131694691);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisn
 * JD-Core Version:    0.7.0.1
 */