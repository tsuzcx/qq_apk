import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ahni
  extends ahms
{
  private Collection<String> a;
  
  public ahni(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<ahnh> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (arad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333);
    ahns localahns = ahns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((arad)localObject).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localahns.b(localCameraEmotionData.strContext)))) {
          localArrayList.add(new ahnh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + bftf.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<ahnh> a(String paramString, SessionInfo paramSessionInfo)
  {
    return a(paramString);
  }
  
  public void a()
  {
    ahns localahns = ahns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localahns != null) {
      this.jdField_a_of_type_JavaUtilCollection = localahns.a();
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
 * Qualified Name:     ahni
 * JD-Core Version:    0.7.0.1
 */