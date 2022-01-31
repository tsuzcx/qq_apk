import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class aiom
  extends aiml
{
  private final int jdField_a_of_type_Int = 1024;
  private final long jdField_a_of_type_Long = 600000L;
  
  protected aiom(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (bdar.getMediaType(paramLocalMediaInfo) == 1) {}
    for (int i = 1; (i != 0) && (paramLocalMediaInfo.mDuration > 600000L); i = 0)
    {
      QQToast.a(this.mActivity, alpo.a(2131708449) + 10L + alpo.a(2131708461), 0).a();
      return false;
    }
    Iterator localIterator = this.mPhotoCommonData.selectedPhotoList.iterator();
    for (long l = 0L; localIterator.hasNext(); l = bdcs.a((String)localIterator.next()) + l) {}
    if (bdcs.a(paramLocalMediaInfo.path) + l > 1073741824L)
    {
      QQToast.a(this.mActivity, alpo.a(2131708455) + "1.0G" + alpo.a(2131708484), 0).a();
      return false;
    }
    return true;
  }
  
  public String getExceedMaxSelectNumStr(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.mPhotoCommonData.maxSelectNum;
    if (this.jdField_a_of_type_Aimk.isSupportVideoCheckbox) {
      return ((NewPhotoListActivity)this.mActivity).getString(2131697879, new Object[] { Integer.valueOf(i) });
    }
    return ((NewPhotoListActivity)this.mActivity).getString(2131697880, new Object[] { Integer.valueOf(i) });
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
  }
  
  public void onCheckBoxClick(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (localLocalMediaInfo == null) {
      super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
    }
    while (!a(localLocalMediaInfo)) {
      return;
    }
    super.onCheckBoxClick(paramView, paramInt, paramCheckBox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiom
 * JD-Core Version:    0.7.0.1
 */