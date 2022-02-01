import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class almr
  implements URLDrawable.URLDrawableListener
{
  almr(almq paramalmq, almm paramalmm, almn paramalmn) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load failed.");
    paramURLDrawable = null;
    if (paramThrowable != null) {
      paramURLDrawable = paramThrowable.getMessage();
    }
    try
    {
      if (this.jdField_a_of_type_Almm != null) {
        bnfx.a().a(2741, this.jdField_a_of_type_Almm.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Almn.a + " filePath = " + this.jdField_a_of_type_Almn.c);
      }
      this.jdField_a_of_type_Almq.e();
      return;
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadFailed Exception");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load success. mLayout visiable:" + this.jdField_a_of_type_Almq.jdField_a_of_type_AndroidViewView.getVisibility());
    try
    {
      if ((this.jdField_a_of_type_Almq.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Almq.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Almq.jdField_a_of_type_AndroidViewView.setVisibility(0);
        almq.a(this.jdField_a_of_type_Almq, this.jdField_a_of_type_Almm);
        this.jdField_a_of_type_Almq.a(this.jdField_a_of_type_Almm);
        return;
      }
      if (this.jdField_a_of_type_Almq.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Almq.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadSuccessed Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almr
 * JD-Core Version:    0.7.0.1
 */