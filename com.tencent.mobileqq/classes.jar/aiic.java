import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aiic
  extends aihm
{
  private Collection<String> a;
  
  public aiic(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<aiib> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (asen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    aiin localaiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((asen)localObject).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localaiin.b(localCameraEmotionData.strContext)))) {
          localArrayList.add(new aiib(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + bhbx.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<aiib> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString);
  }
  
  public void a()
  {
    aiin localaiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localaiin != null) {
      this.jdField_a_of_type_JavaUtilCollection = localaiin.a();
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
 * Qualified Name:     aiic
 * JD-Core Version:    0.7.0.1
 */