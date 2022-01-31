import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.File;
import java.util.HashMap;

public class afom
  implements Runnable
{
  public afom(OcrControl paramOcrControl, ARCloudReqFileInfo paramARCloudReqFileInfo) {}
  
  public void run()
  {
    long l1 = new File(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.a).length() / 1024L;
    long l2 = new File(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.b).length() / 1024L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocrFilesize", String.valueOf(l1));
    localHashMap.put("previewFilesize", String.valueOf(l2));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ocr_pic_size", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afom
 * JD-Core Version:    0.7.0.1
 */