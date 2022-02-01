import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class abjq
  implements abkc
{
  abjq(abjp paramabjp) {}
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    this.a.f();
    if ((this.a.jdField_a_of_type_Abkb != null) && (!this.a.jdField_a_of_type_Abkb.a())) {
      this.a.jdField_a_of_type_Abkb.a();
    }
  }
  
  public void g()
  {
    if (this.a.jdField_a_of_type_Abkg.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    this.a.g();
    if ((this.a.jdField_a_of_type_Abkb != null) && (this.a.jdField_a_of_type_Abkb.a())) {
      this.a.jdField_a_of_type_Abkb.b();
    }
  }
  
  public void h()
  {
    if (this.a.jdField_a_of_type_Abkg.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_Abjo != null) {
      this.a.jdField_a_of_type_Abjo.a(4);
    }
    if ((this.a.jdField_a_of_type_Abkb != null) && (this.a.jdField_a_of_type_Abkb.a())) {
      this.a.jdField_a_of_type_Abkb.b();
    }
    this.a.h();
    this.a.jdField_a_of_type_ComTencentWidgetGallery.e();
  }
  
  public void i()
  {
    this.a.i();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gallery onExitAnimationEnd ");
      if (this.a.jdField_a_of_type_Abkg.a() != this.a) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("GalleryComponent", 2, bool);
      if (this.a.jdField_a_of_type_Abkg.a() != this.a) {
        break;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abjq
 * JD-Core Version:    0.7.0.1
 */