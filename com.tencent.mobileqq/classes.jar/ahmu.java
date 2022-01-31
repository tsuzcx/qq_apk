import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class ahmu
  implements URLDrawable.URLDrawableListener
{
  ahmu(ahmt paramahmt, ahmp paramahmp, ahmq paramahmq) {}
  
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
      if (this.jdField_a_of_type_Ahmp != null) {
        bhku.a().a(2741, this.jdField_a_of_type_Ahmp.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Ahmq.a + " filePath = " + this.jdField_a_of_type_Ahmq.c);
      }
      this.jdField_a_of_type_Ahmt.e();
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
      if ((this.jdField_a_of_type_Ahmt.b != null) && (this.jdField_a_of_type_Ahmt.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Ahmt.b.setVisibility(0);
        this.jdField_a_of_type_Ahmt.a.setImageDrawable(paramURLDrawable);
        ahmt.a(this.jdField_a_of_type_Ahmt, this.jdField_a_of_type_Ahmp);
        this.jdField_a_of_type_Ahmt.a(this.jdField_a_of_type_Ahmp);
        return;
      }
      if (this.jdField_a_of_type_Ahmt.b != null)
      {
        this.jdField_a_of_type_Ahmt.b.setVisibility(8);
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
 * Qualified Name:     ahmu
 * JD-Core Version:    0.7.0.1
 */