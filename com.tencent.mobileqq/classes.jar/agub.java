import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public class agub
  extends agsj
{
  private agub(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = bbdj.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 230, null, ajya.a(2131708098), ajya.a(2131708082), null, null, new aguc(this));
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
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agub(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
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
    return ajya.a(2131694533);
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
 * Qualified Name:     agub
 * JD-Core Version:    0.7.0.1
 */