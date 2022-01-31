import android.text.TextUtils;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class achv
  extends EmoticonPackageDownloadListener
{
  public achv(FavroamingManager paramFavroamingManager) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.a(paramEmoticonPackage, paramInt);
    EmojiListenerManager.a().b(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    Object localObject = (FavroamingDBManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148);
    EmoticonManager localEmoticonManager = (EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    List localList = ((FavroamingDBManager)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localEmoticonManager.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((FavroamingDBManager)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        FavroamingManager localFavroamingManager = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localFavroamingManager.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (FavEmoRoamingHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((FavEmoRoamingHandler)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achv
 * JD-Core Version:    0.7.0.1
 */