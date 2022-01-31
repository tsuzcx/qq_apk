import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.OnResourceDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class agtn
  implements INetEngine.INetEngineListener
{
  public agtn(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int != 0) {
      AVLog.c("CaptureVideoFilterManager", "download file failed. errorCode: " + paramNetResp.b + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
      {
        AVLog.c("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
        return;
      }
      AVLog.c("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).jdField_a_of_type_JavaLangString);
      try
      {
        localObject = CaptureVideoFilterManager.b;
        FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
        FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
        if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.a(this.a) != null))
        {
          CaptureVideoFilterManager.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        AVLog.c("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agtn
 * JD-Core Version:    0.7.0.1
 */