import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class alsq
  implements INetEngine.INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (alst)paramNetResp.mReq.getUserData();
    lbd.f("VideoFilterTools", "download file call back. file = " + ((alst)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      lbd.f("VideoFilterTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((alst)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      lbd.f("VideoFilterTools", "download file faild : md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    lbd.f("VideoFilterTools", "download file successed.");
    try
    {
      localObject = also.a();
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      lbd.f("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsq
 * JD-Core Version:    0.7.0.1
 */