import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class aifh
  implements Runnable
{
  public aifh(TrAsyncTextureLoad paramTrAsyncTextureLoad) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    DanceLog.b("GLFrameImage", "asyncLoadBoyTexture start loading");
    GLFrameImage.h();
    long l2 = System.currentTimeMillis();
    DanceLog.b("GLFrameImage", "asyncLoadBoyTexture end loading timeCost=" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifh
 * JD-Core Version:    0.7.0.1
 */