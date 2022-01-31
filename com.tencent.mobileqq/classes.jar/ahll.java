import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class ahll
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  private String a;
  
  public ahll(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.a(this.a, "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    VideoEnvironment.a(this.a, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void y_()
  {
    VideoEnvironment.a(this.a, "onNetWorkNone...", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */