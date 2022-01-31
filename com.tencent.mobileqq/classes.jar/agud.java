import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class agud
  extends agth
{
  private Collection<String> a;
  
  public agud(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public List<? extends agtk> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    aube localaube = (aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    Object localObject = (apke)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    agug localagug = agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((apke)localObject).a();
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
          if ((!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) && (paramString.equals(localagug.b(localCustomEmotionData.modifyWord))))
          {
            localArrayList.add(new aguc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if ((!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) && (paramString.equals(localagug.b(localCustomEmotionData.ocrWord))))
          {
            localArrayList.add(new aguc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            Emoticon localEmoticon = localaube.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
            if ((localEmoticon != null) && (!TextUtils.isEmpty(localEmoticon.name)) && (paramString.equals(localagug.b(localEmoticon.name)))) {
              localArrayList.add(new aguc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCustomEmotionData));
            }
          }
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + bdal.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilCollection = agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
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
 * Qualified Name:     agud
 * JD-Core Version:    0.7.0.1
 */