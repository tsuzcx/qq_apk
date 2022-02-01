import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aitf
  extends aisj
{
  private Collection<String> a;
  
  public aitf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public List<? extends aism> a(String paramString, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    paramSessionInfo = new ArrayList();
    axfj localaxfj = (axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject = (ashc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    aiti localaiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((ashc)localObject).a();
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
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localaiti.b(localCustomEmotionData.modifyWord))))
          {
            paramSessionInfo.add(new aite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localaiti.b(localCustomEmotionData.ocrWord))))
          {
            paramSessionInfo.add(new aite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localaxfj.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localaiti.b(localEmoticon.name)))) {
              paramSessionInfo.add(new aite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (paramSessionInfo.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + bhjx.a(paramString));
      }
      return null;
    }
    return paramSessionInfo;
  }
  
  public void a()
  {
    aiti localaiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localaiti != null) {
      this.jdField_a_of_type_JavaUtilCollection = localaiti.b();
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
 * Qualified Name:     aitf
 * JD-Core Version:    0.7.0.1
 */