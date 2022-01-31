import android.content.Intent;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import java.util.ArrayList;
import mqq.util.WeakReference;

class agvc
  extends agta
{
  protected agvc(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public static agsq b(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsq == null) || (jdField_a_of_type_Agsq.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoPreviewActivity)) {
        jdField_a_of_type_Agsq = new agvc(paramNewPhotoPreviewActivity);
      }
      return jdField_a_of_type_Agsq;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Agsp.b = ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131695149);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Agrz.a != null) && (!this.jdField_a_of_type_Agrz.a.isEmpty());
  }
  
  protected void c()
  {
    super.c();
    ((NewPhotoPreviewActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setOnClickListener(new agvd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvc
 * JD-Core Version:    0.7.0.1
 */