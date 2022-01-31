import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class ajis
  implements URLDrawable.URLDrawableListener
{
  ajis(ajir paramajir, ajin paramajin, ajio paramajio) {}
  
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
      if (this.jdField_a_of_type_Ajin != null) {
        bjqm.a().a(2741, this.jdField_a_of_type_Ajin.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Ajio.a + " filePath = " + this.jdField_a_of_type_Ajio.c);
      }
      this.jdField_a_of_type_Ajir.e();
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
      if ((this.jdField_a_of_type_Ajir.b != null) && (this.jdField_a_of_type_Ajir.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Ajir.b.setVisibility(0);
        this.jdField_a_of_type_Ajir.a.setImageDrawable(paramURLDrawable);
        ajir.a(this.jdField_a_of_type_Ajir, this.jdField_a_of_type_Ajin);
        this.jdField_a_of_type_Ajir.a(this.jdField_a_of_type_Ajin);
        return;
      }
      if (this.jdField_a_of_type_Ajir.b != null)
      {
        this.jdField_a_of_type_Ajir.b.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajis
 * JD-Core Version:    0.7.0.1
 */