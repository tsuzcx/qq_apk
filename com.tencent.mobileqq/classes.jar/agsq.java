import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public abstract class agsq
{
  protected static volatile agsq a;
  public agrz a;
  public agso a;
  agsr jdField_a_of_type_Agsr = null;
  public agss a;
  agst jdField_a_of_type_Agst = null;
  public WeakReference<NewPhotoPreviewActivity> a;
  
  protected agsq(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_Agss = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Agrz = agrz.a(paramNewPhotoPreviewActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramNewPhotoPreviewActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Agrz.a();
    this.jdField_a_of_type_Agso = new agso();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic new，activity = " + paramNewPhotoPreviewActivity + ",PhotoCommonData = " + this.jdField_a_of_type_Agrz);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  abstract void a(View paramView);
  
  abstract void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent);
  
  public abstract void a(CompoundButton paramCompoundButton, boolean paramBoolean);
  
  abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic close，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Agrz);
    }
    this.jdField_a_of_type_Agrz.b();
    jdField_a_of_type_Agsq = null;
  }
  
  public abstract void c();
  
  abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agsq
 * JD-Core Version:    0.7.0.1
 */