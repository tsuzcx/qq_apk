import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aiik
  extends aihm
{
  private Collection<String> a;
  
  public aiik(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public List<? extends aihq> a(String paramString, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    paramSessionInfo = new ArrayList();
    awyr localawyr = (awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    Object localObject = (asfk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    aiin localaiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((asfk)localObject).a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticonDataList.size : " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
        if (("isUpdate".equals(localCustomEmotionData.RomaingType)) || ("needDownload".equals(localCustomEmotionData.RomaingType)) || ("overflow".equals(localCustomEmotionData.RomaingType)) || ("overflow_downloaded".equals(localCustomEmotionData.RomaingType))) {
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localaiin.b(localCustomEmotionData.modifyWord))))
          {
            paramSessionInfo.add(new aiij(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localaiin.b(localCustomEmotionData.ocrWord))))
          {
            paramSessionInfo.add(new aiij(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localawyr.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localaiin.b(localEmoticon.name)))) {
              paramSessionInfo.add(new aiij(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (paramSessionInfo.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + bhbx.a(paramString));
      }
      return null;
    }
    return paramSessionInfo;
  }
  
  public void a()
  {
    aiin localaiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localaiin != null) {
      this.jdField_a_of_type_JavaUtilCollection = localaiin.b();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilCollection == null) {
      a();
    }
    return (this.jdField_a_of_type_JavaUtilCollection != null) && (this.jdField_a_of_type_JavaUtilCollection.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiik
 * JD-Core Version:    0.7.0.1
 */