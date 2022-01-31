import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;

public abstract class aggh
  implements agam, vhm
{
  protected static volatile aggh a;
  public aggf a;
  public aggg a;
  aggi jdField_a_of_type_Aggi = null;
  aggj jdField_a_of_type_Aggj = null;
  aggk jdField_a_of_type_Aggk = null;
  aggl jdField_a_of_type_Aggl = null;
  public WeakReference<NewPhotoListActivity> a;
  
  protected aggh(NewPhotoListActivity paramNewPhotoListActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramNewPhotoListActivity);
    this.jdField_a_of_type_Aggf = aggf.a(paramNewPhotoListActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramNewPhotoListActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Aggf.a();
    this.jdField_a_of_type_Aggg = new aggg();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，activity = " + paramNewPhotoListActivity + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
  }
  
  abstract String a(LocalMediaInfo paramLocalMediaInfo);
  
  protected abstract List<LocalMediaInfo> a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  protected abstract void a(Intent paramIntent, boolean paramBoolean);
  
  protected abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  protected abstract void a(LocalMediaInfo paramLocalMediaInfo);
  
  abstract void a(LocalMediaInfo paramLocalMediaInfo, int paramInt);
  
  public void a(boolean paramBoolean) {}
  
  abstract void a(boolean paramBoolean, Intent paramIntent);
  
  protected abstract boolean a();
  
  abstract boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
    this.jdField_a_of_type_Aggf.b();
    jdField_a_of_type_Aggh = null;
  }
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract void c();
  
  abstract void c(Intent paramIntent);
  
  public abstract void c(View paramView);
  
  public abstract void d();
  
  public abstract void d(Intent paramIntent);
  
  public abstract void d(View paramView);
  
  protected abstract void e();
  
  public abstract void e(Intent paramIntent);
  
  protected abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggh
 * JD-Core Version:    0.7.0.1
 */