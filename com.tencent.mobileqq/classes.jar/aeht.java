import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

final class aeht
  implements URLDrawable.URLDrawableListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  aeht(aegu paramaegu) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadCanceled URL():" + paramURLDrawable.getURL());
    }
    this.a.a(false);
    this.a.jdField_a_of_type_Aeht = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadFialed URL():" + paramURLDrawable.getURL());
    }
    bcpw.a(aegu.b(this.a), aegu.c(this.a).getString(2131695340), 0).a();
    this.a.c(true);
    this.a.a(false);
    this.a.jdField_a_of_type_Aeht = null;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadSuccessed URL():" + paramURLDrawable.getURL());
    }
    this.a.c(false);
    this.a.a(false);
    this.a.jdField_a_of_type_Aeie.b.b = paramURLDrawable.getExifOrientation();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramURLDrawable, aegu.c(this.a).getSelectedItemPosition());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
    aegu.d(this.a).e();
    this.a.jdField_a_of_type_Aeht = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeht
 * JD-Core Version:    0.7.0.1
 */