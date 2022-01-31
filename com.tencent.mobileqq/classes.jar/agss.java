import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public abstract class agss
{
  protected static volatile agss a;
  public agsb a;
  public agsq a;
  agst jdField_a_of_type_Agst = null;
  public agsu a;
  agsv jdField_a_of_type_Agsv = null;
  public WeakReference<NewPhotoPreviewActivity> a;
  
  protected agss(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_Agsu = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Agsb = agsb.a(paramNewPhotoPreviewActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramNewPhotoPreviewActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Agsb.a();
    this.jdField_a_of_type_Agsq = new agsq();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic new，activity = " + paramNewPhotoPreviewActivity + ",PhotoCommonData = " + this.jdField_a_of_type_Agsb);
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
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic close，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Agsb);
    }
    this.jdField_a_of_type_Agsb.b();
    jdField_a_of_type_Agss = null;
  }
  
  public abstract void c();
  
  abstract void d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agss
 * JD-Core Version:    0.7.0.1
 */