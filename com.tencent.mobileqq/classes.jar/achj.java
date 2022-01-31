import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.List;

class achj
  implements URLDrawable.URLDrawableListener
{
  achj(achi paramachi, URLDrawable paramURLDrawable, CustomEmotionData paramCustomEmotionData, FavroamingManager paramFavroamingManager, FavroamingDBManager paramFavroamingDBManager) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_Achi.a).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_Achi.a).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_Achi.a).a.remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    paramURLDrawable = this.jdField_a_of_type_Achi.a.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    if (this.jdField_a_of_type_Achi.a.a(paramURLDrawable)) {}
    String str;
    do
    {
      do
      {
        return;
        str = EmoticonFromGroupManager.a(this.jdField_a_of_type_Achi.a, paramURLDrawable);
      } while ("".equals(str));
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath = str;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = paramURLDrawable;
    } while ("".equals(str));
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 4, "onLoadSuccessed upload emo " + paramURLDrawable);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achj
 * JD-Core Version:    0.7.0.1
 */