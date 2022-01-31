import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import mqq.util.WeakReference;

public class alvq
  extends agta
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private alvq(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new alvq(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_ark_app_res_path");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_should_compress", false);
    this.b = paramIntent.getStringExtra("key_ark_app_engine_res_dir");
  }
  
  public void a(boolean paramBoolean)
  {
    if ("FROM_PHOTO_LIST".equals(this.jdField_a_of_type_Agsp.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      localIntent.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      localIntent.putExtra("key_ark_app_res_path", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_should_compress", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_ark_app_engine_res_dir", this.b);
      localIntent.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
      localIntent.putExtra("enter_from", 3);
    }
    super.a(paramBoolean);
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setOnClickListener(new alvr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvq
 * JD-Core Version:    0.7.0.1
 */