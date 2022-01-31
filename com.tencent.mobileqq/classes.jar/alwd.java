import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

class alwd
  implements URLDrawable.URLDrawableListener
{
  alwd(alwb paramalwb, RoundImageView paramRoundImageView, ampw paramampw, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentDanmakuRender", 2, "onLoadCanceled : " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentDanmakuRender", 2, "onLoadFailed : " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_Ampw.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alwd
 * JD-Core Version:    0.7.0.1
 */