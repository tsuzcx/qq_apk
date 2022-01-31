import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;

public abstract class agsc
  implements agmi
{
  protected static volatile agsc a;
  public agrz a;
  public agsa a;
  agsd jdField_a_of_type_Agsd = null;
  agse jdField_a_of_type_Agse = null;
  agsf jdField_a_of_type_Agsf = null;
  agsg jdField_a_of_type_Agsg = null;
  public WeakReference<NewPhotoListActivity> a;
  
  protected agsc(NewPhotoListActivity paramNewPhotoListActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramNewPhotoListActivity);
    this.jdField_a_of_type_Agrz = agrz.a(paramNewPhotoListActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramNewPhotoListActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Agrz.a();
    this.jdField_a_of_type_Agsa = new agsa();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，activity = " + paramNewPhotoListActivity + ",PhotoCommonData = " + this.jdField_a_of_type_Agrz);
    }
  }
  
  abstract String a(LocalMediaInfo paramLocalMediaInfo);
  
  protected abstract List<LocalMediaInfo> a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  protected abstract void a(Message paramMessage);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, Bundle paramBundle, int paramInt, Intent paramIntent);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  public void a(boolean paramBoolean) {}
  
  abstract void a(boolean paramBoolean, int paramInt1, int paramInt2);
  
  abstract void a(boolean paramBoolean, Intent paramIntent);
  
  protected abstract boolean a();
  
  abstract boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean);
  
  abstract boolean a(List<LocalMediaInfo> paramList);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Agrz);
    }
    this.jdField_a_of_type_Agrz.b();
    jdField_a_of_type_Agsc = null;
  }
  
  public abstract void b(Intent paramIntent);
  
  public abstract void b(View paramView);
  
  public abstract void c();
  
  abstract void c(Intent paramIntent);
  
  public abstract void c(View paramView);
  
  abstract void d();
  
  public abstract void d(Intent paramIntent);
  
  public abstract void e();
  
  public abstract void e(Intent paramIntent);
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsc
 * JD-Core Version:    0.7.0.1
 */