import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;

class akkj
  implements URLDrawable.URLDrawableListener
{
  akkj(akki paramakki, akke paramakke, akkf paramakkf) {}
  
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
      if (this.jdField_a_of_type_Akke != null) {
        QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_Akke.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_Akkf.a + " filePath = " + this.jdField_a_of_type_Akkf.c);
      }
      this.jdField_a_of_type_Akki.e();
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
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load success. mLayout visiable:" + this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView.getVisibility());
    try
    {
      if ((this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Akki.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView.setVisibility(0);
        akki.a(this.jdField_a_of_type_Akki, this.jdField_a_of_type_Akke);
        this.jdField_a_of_type_Akki.a(this.jdField_a_of_type_Akke);
        SetSplash.a(this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView);
        return;
      }
      if (this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Akki.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
 * Qualified Name:     akkj
 * JD-Core Version:    0.7.0.1
 */