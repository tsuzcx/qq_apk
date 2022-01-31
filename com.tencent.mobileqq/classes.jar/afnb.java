import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.qphone.base.util.QLog;

public class afnb
  implements Runnable
{
  public afnb(NowEnterManager paramNowEnterManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowEnterManager", 2, "start preload image~");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a, this.jdField_a_of_type_JavaLangString);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable.getDrawable(this.b, localURLDrawableOptions).downloadImediatly();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("NowEnterManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afnb
 * JD-Core Version:    0.7.0.1
 */