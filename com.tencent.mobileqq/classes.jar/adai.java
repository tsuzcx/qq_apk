import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import cooperation.weiyun.TransmissionHelper;
import cooperation.weiyun.utils.SoHelper.SoListener;

public class adai
  implements SoHelper.SoListener
{
  public adai(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(long paramLong, float paramFloat) {}
  
  public void a(String paramString)
  {
    WeiYunLogicCenter.b(this.a, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    WeiYunLogicCenter.a(this.a, true);
    WeiYunLogicCenter.b(this.a, false);
    TransmissionHelper.a(WeiYunLogicCenter.a(this.a).getApplication(), true);
    WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adai
 * JD-Core Version:    0.7.0.1
 */