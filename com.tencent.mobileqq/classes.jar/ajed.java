import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class ajed
  implements URLDrawable.URLDrawableListener
{
  ajed(ajec paramajec, ajdy paramajdy, ajdz paramajdz) {}
  
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
      if (this.jdField_a_of_type_Ajdy != null) {
        bjmf.a().a(2741, this.jdField_a_of_type_Ajdy.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Ajdz.a + " filePath = " + this.jdField_a_of_type_Ajdz.c);
      }
      this.jdField_a_of_type_Ajec.e();
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
      if ((this.jdField_a_of_type_Ajec.b != null) && (this.jdField_a_of_type_Ajec.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Ajec.b.setVisibility(0);
        this.jdField_a_of_type_Ajec.a.setImageDrawable(paramURLDrawable);
        ajec.a(this.jdField_a_of_type_Ajec, this.jdField_a_of_type_Ajdy);
        this.jdField_a_of_type_Ajec.a(this.jdField_a_of_type_Ajdy);
        return;
      }
      if (this.jdField_a_of_type_Ajec.b != null)
      {
        this.jdField_a_of_type_Ajec.b.setVisibility(8);
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
 * Qualified Name:     ajed
 * JD-Core Version:    0.7.0.1
 */