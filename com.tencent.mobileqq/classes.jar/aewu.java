import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil;

public final class aewu
  implements URLDrawable.URLDrawableListener
{
  public aewu(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.c("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    SLog.c("ShortVideoShareUtil", "onLoadProgressed --" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ShortVideoShareUtil.a(paramURLDrawable);
    ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewu
 * JD-Core Version:    0.7.0.1
 */