import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aemf
  extends aelj
{
  private Collection<String> a;
  
  public aemf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public List<? extends aelm> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    arnz localarnz = (arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject = (ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    aemi localaemi = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((ancg)localObject).a();
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
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localaemi.b(localCustomEmotionData.modifyWord))))
          {
            localArrayList.add(new aeme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localaemi.b(localCustomEmotionData.ocrWord))))
          {
            localArrayList.add(new aeme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localarnz.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localaemi.b(localEmoticon.name)))) {
              localArrayList.add(new aeme(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + azzz.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilCollection = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilCollection == null) {
      a();
    }
    return (this.jdField_a_of_type_JavaUtilCollection != null) && (this.jdField_a_of_type_JavaUtilCollection.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemf
 * JD-Core Version:    0.7.0.1
 */