import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public class agud
  extends agsl
{
  private agud(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.mediaWidth < 320) || (paramLocalMediaInfo.mediaHeight < 320))
    {
      paramLocalMediaInfo = bbcv.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), 230, null, ajyc.a(2131708087), ajyc.a(2131708071), null, null, new ague(this));
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
  
  public static agse b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agse = new agud(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agse;
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
    return ajyc.a(2131694532);
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
 * Qualified Name:     agud
 * JD-Core Version:    0.7.0.1
 */