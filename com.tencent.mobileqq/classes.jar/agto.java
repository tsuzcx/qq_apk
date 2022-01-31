import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.SkinColorFilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

public class agto
  implements INetEngine.INetEngineListener
{
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    Object localObject = (CaptureVideoFilterManager.SkinColorFilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    AVLog.c("CaptureVideoFilterManager", "download file call back. file = " + ((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).a);
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("CaptureVideoFilterManager", "download file faild. errcode = " + paramNetResp.b);
      return;
    }
    if (!((CaptureVideoFilterManager.SkinColorFilterDesc)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c)))
    {
      AVLog.c("CaptureVideoFilterManager", "download file faild : md5 is not match.");
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    AVLog.c("CaptureVideoFilterManager", "download file successed.");
    try
    {
      localObject = CaptureVideoFilterManager.a();
      FileUtils.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c, (String)localObject, false);
      FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      AVLog.c("CaptureVideoFilterManager", "BEAUTY_ZIP unzip file faild.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agto
 * JD-Core Version:    0.7.0.1
 */