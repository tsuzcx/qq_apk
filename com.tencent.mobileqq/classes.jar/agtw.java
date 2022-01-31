import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class agtw
  extends agth
{
  private Collection<String> a;
  
  public agtw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<agtv> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333);
    agug localagug = agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((apjm)localObject).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localagug.b(localCameraEmotionData.strContext)))) {
          localArrayList.add(new agtv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + bdal.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<agtv> a(String paramString)
  {
    return b(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilCollection = agug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
 * Qualified Name:     agtw
 * JD-Core Version:    0.7.0.1
 */