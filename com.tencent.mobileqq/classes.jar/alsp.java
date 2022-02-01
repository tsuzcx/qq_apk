import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class alsp
  implements INetEngine.INetEngineListener
{
  alsp(also paramalso) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0) {
      lbd.f("VideoFilterTools", "download file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        lbd.f("VideoFilterTools", "download file failed: md5 is not match.");
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        return;
      }
      lbd.f("VideoFilterTools", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = also.b;
        FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        if ((also.a(this.a).decrementAndGet() == 0) && (also.a(this.a) != null))
        {
          also.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        lbd.f("VideoFilterTools", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsp
 * JD-Core Version:    0.7.0.1
 */