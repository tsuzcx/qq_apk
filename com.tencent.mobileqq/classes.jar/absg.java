import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class absg
  implements Runnable
{
  public absg(EmoticonFromGroupManager paramEmoticonFromGroupManager, List paramList) {}
  
  public void run()
  {
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).getManager(148);
    FavroamingManager localFavroamingManager = (FavroamingManager)EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).getManager(102);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getFavEmoticonList from onUploadPic.");
    }
    Object localObject1 = localFavroamingDBManager.a();
    ArrayList localArrayList = new ArrayList(30);
    if (localObject1 != null)
    {
      int k = 0;
      for (i = 1;; i = j)
      {
        j = i;
        if (k >= ((List)localObject1).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject1).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
      }
    }
    int j = 1;
    int i = this.jdField_a_of_type_JavaUtilList.size();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject1 = new CustomEmotionData();
      ((CustomEmotionData)localObject1).uin = EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).c();
      j += 1;
      ((CustomEmotionData)localObject1).emoId = j;
      localArrayList.add(localObject1);
    }
    j = localArrayList.size();
    i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject1 = (CustomEmotionData)localArrayList.get(i);
      localObject2 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((EmoticonFromGroupEntity)localObject2, 1, -1, null);
      if (1 != ((URLDrawable)localObject2).getStatus())
      {
        EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager).jdField_a_of_type_JavaUtilList.add(localObject2);
        ((URLDrawable)localObject2).setURLDrawableListener(new absh(this, (URLDrawable)localObject2, (CustomEmotionData)localObject1, localFavroamingManager, localFavroamingDBManager));
        ((URLDrawable)localObject2).startDownload();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      String str1 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(((URLDrawable)localObject2).getURL().toString());
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(str1)) {
        return;
      }
      String str2 = EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager, str1);
      if (!"".equals(str2))
      {
        ((CustomEmotionData)localObject1).emoPath = str2;
        ((CustomEmotionData)localObject1).md5 = str1;
        if (!"".equals(str2)) {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 4, "normal upload emo " + str1);
            }
            ((URLDrawable)localObject2).saveTo(str2);
            localFavroamingManager.a((CustomEmotionData)localObject1);
            localFavroamingDBManager.c((CustomEmotionData)localObject1);
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            QLog.d("EmoticonFromGroup_Manager", 1, localIOException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absg
 * JD-Core Version:    0.7.0.1
 */