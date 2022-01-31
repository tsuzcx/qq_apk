import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import mqq.util.WeakReference;

public abstract class aggt
{
  protected static volatile aggt a;
  public aggf a;
  public aggs a;
  aggu a;
  public aggv a;
  public aggw a;
  public WeakReference<NewPhotoPreviewActivity> a;
  
  protected aggt(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_Aggw = null;
    this.jdField_a_of_type_Aggu = null;
    this.jdField_a_of_type_Aggv = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramNewPhotoPreviewActivity);
    this.jdField_a_of_type_Aggf = aggf.a(paramNewPhotoPreviewActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    paramNewPhotoPreviewActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_Aggf.a();
    this.jdField_a_of_type_Aggs = new aggs();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic new，activity = " + paramNewPhotoPreviewActivity + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "PhotoPreviewLogic close，activity = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_Aggf);
    }
    this.jdField_a_of_type_Aggf.b();
    jdField_a_of_type_Aggt = null;
  }
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  abstract void a(View paramView);
  
  abstract void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent);
  
  public abstract void a(TextView paramTextView);
  
  abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract void c();
  
  abstract boolean c();
  
  abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggt
 * JD-Core Version:    0.7.0.1
 */