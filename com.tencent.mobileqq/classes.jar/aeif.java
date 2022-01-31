import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.now.send.uploader.WordsCheck.OnResultListener;

public class aeif
  implements WordsCheck.OnResultListener
{
  public aeif(ImageFeedsUploader paramImageFeedsUploader) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.a();
      return;
    }
    b(paramInt);
  }
  
  public void b(int paramInt)
  {
    VideoFeedsUploader.UploadResult localUploadResult = new VideoFeedsUploader.UploadResult();
    localUploadResult.i = "文字包含敏感词！";
    localUploadResult.a = paramInt;
    ImageFeedsUploader.a(this.a, localUploadResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeif
 * JD-Core Version:    0.7.0.1
 */