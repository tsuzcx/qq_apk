import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class ahmw
  implements URLDrawable.URLDrawableListener
{
  ahmw(ahmv paramahmv, ahmr paramahmr, ahms paramahms) {}
  
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
      if (this.jdField_a_of_type_Ahmr != null) {
        bhkd.a().a(2741, this.jdField_a_of_type_Ahmr.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Ahms.a + " filePath = " + this.jdField_a_of_type_Ahms.c);
      }
      this.jdField_a_of_type_Ahmv.e();
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
      if ((this.jdField_a_of_type_Ahmv.b != null) && (this.jdField_a_of_type_Ahmv.a != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Ahmv.b.setVisibility(0);
        this.jdField_a_of_type_Ahmv.a.setImageDrawable(paramURLDrawable);
        ahmv.a(this.jdField_a_of_type_Ahmv, this.jdField_a_of_type_Ahmr);
        this.jdField_a_of_type_Ahmv.a(this.jdField_a_of_type_Ahmr);
        return;
      }
      if (this.jdField_a_of_type_Ahmv.b != null)
      {
        this.jdField_a_of_type_Ahmv.b.setVisibility(8);
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
 * Qualified Name:     ahmw
 * JD-Core Version:    0.7.0.1
 */