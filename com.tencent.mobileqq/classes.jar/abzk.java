import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import java.util.List;
import java.util.concurrent.Executor;

public class abzk
  implements URLDrawable.URLDrawableListener
{
  public abzk(EmoticonFromGroupManager paramEmoticonFromGroupManager, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    EmoticonFromGroupManager.a().execute(new abzl(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzk
 * JD-Core Version:    0.7.0.1
 */