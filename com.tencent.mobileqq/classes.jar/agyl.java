import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class agyl
  extends agxw
{
  private Collection<String> a;
  
  public agyl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<agyk> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = (apnv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333);
    agyv localagyv = agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = ((apnv)localObject).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject).next();
        if (("normal".equals(localCameraEmotionData.RomaingType)) && (paramString.equals(localagyv.b(localCameraEmotionData.strContext)))) {
          localArrayList.add(new agyk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localCameraEmotionData));
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + bdeu.a(paramString));
      }
      return null;
    }
    return localArrayList;
  }
  
  public List<agyk> a(String paramString)
  {
    return b(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilCollection = agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
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
 * Qualified Name:     agyl
 * JD-Core Version:    0.7.0.1
 */