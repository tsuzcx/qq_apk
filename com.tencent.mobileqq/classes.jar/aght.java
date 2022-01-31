import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public class aght
  extends aggm
{
  private aght(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = babr.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 230, null, ajjy.a(2131642302), ajjy.a(2131642286), null, null, new aghu(this));
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
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new aght(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt);
    if ((((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.getItemViewType(paramInt) == 0) && (!a(localLocalMediaInfo))) {
      return null;
    }
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    return ajjy.a(2131628871);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if (a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt))) {
      super.a(paramView, paramInt, paramCheckBox);
    }
  }
  
  protected void c(Intent paramIntent)
  {
    if (paramIntent != null) {
      super.c(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aght
 * JD-Core Version:    0.7.0.1
 */