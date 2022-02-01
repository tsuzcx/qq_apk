import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;

class akuu
  implements INetEngine.INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (akux)paramNetResp.mReq.getUserData();
    lba.f("VideoFilterTools", "download file call back. file = " + ((akux)localObject).a);
    if (paramNetResp.mResult != 0)
    {
      lba.f("VideoFilterTools", "download file faild. errcode = " + paramNetResp.mErrCode);
      return;
    }
    if (!((akux)localObject).b.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
    {
      lba.f("VideoFilterTools", "download file faild : md5 is not match.");
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    lba.f("VideoFilterTools", "download file successed.");
    try
    {
      localObject = akus.a();
      FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      return;
    }
    catch (IOException paramNetResp)
    {
      paramNetResp.printStackTrace();
      lba.f("VideoFilterTools", "BEAUTY_ZIP unzip file faild.");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuu
 * JD-Core Version:    0.7.0.1
 */