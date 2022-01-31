import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class afop
  implements Runnable
{
  afop(afon paramafon, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.a;
    String str2 = new File(str1).getParent();
    if (OcrImageUtil.a.equals(str2))
    {
      FileUtils.d(str1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "delete pic path:" + str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afop
 * JD-Core Version:    0.7.0.1
 */