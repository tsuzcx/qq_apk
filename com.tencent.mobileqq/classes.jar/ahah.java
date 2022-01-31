import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class ahah
  implements URLDrawable.URLDrawableListener
{
  ahah(ahag paramahag, ahac paramahac, ahad paramahad) {}
  
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
      if (this.jdField_a_of_type_Ahac != null) {
        bgbr.a().a(2741, this.jdField_a_of_type_Ahac.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Ahad.a + " filePath = " + this.jdField_a_of_type_Ahad.c);
      }
      this.jdField_a_of_type_Ahag.e();
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
      if ((this.jdField_a_of_type_Ahag.b != null) && (this.jdField_a_of_type_Ahag.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Ahag.b.setVisibility(0);
        this.jdField_a_of_type_Ahag.a.setImageDrawable(paramURLDrawable);
        ahag.a(this.jdField_a_of_type_Ahag, this.jdField_a_of_type_Ahac);
        this.jdField_a_of_type_Ahag.a(this.jdField_a_of_type_Ahac);
        return;
      }
      if (this.jdField_a_of_type_Ahag.b != null)
      {
        this.jdField_a_of_type_Ahag.b.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahah
 * JD-Core Version:    0.7.0.1
 */