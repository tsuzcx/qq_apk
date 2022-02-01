import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class albb
  implements URLDrawable.URLDrawableListener
{
  albb(alba paramalba, alaw paramalaw, alax paramalax) {}
  
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
      if (this.jdField_a_of_type_Alaw != null) {
        bmev.a().a(2741, this.jdField_a_of_type_Alaw.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Alax.a + " filePath = " + this.jdField_a_of_type_Alax.c);
      }
      this.jdField_a_of_type_Alba.e();
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
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load success.");
    try
    {
      if ((this.jdField_a_of_type_Alba.b != null) && (this.jdField_a_of_type_Alba.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Alba.b.setVisibility(0);
        this.jdField_a_of_type_Alba.a.setImageDrawable(paramURLDrawable);
        alba.a(this.jdField_a_of_type_Alba, this.jdField_a_of_type_Alaw);
        this.jdField_a_of_type_Alba.a(this.jdField_a_of_type_Alaw);
        return;
      }
      if (this.jdField_a_of_type_Alba.b != null)
      {
        this.jdField_a_of_type_Alba.b.setVisibility(8);
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
 * Qualified Name:     albb
 * JD-Core Version:    0.7.0.1
 */