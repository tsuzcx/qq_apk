import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader.OnResultListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aewm
  implements ImageUploader.OnResultListener
{
  public aewm(VideoFeedsUploader paramVideoFeedsUploader) {}
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if ((paramInt != 0) || (TextUtils.isEmpty(paramString)))
    {
      VideoFeedsUploader.a(this.a).a = paramInt;
      VideoFeedsUploader.a(this.a).d = paramInt;
      VideoFeedsUploader.a(this.a).a = paramInt;
      VideoFeedsUploader.a(this.a).d = paramInt;
      VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, String.format("upload logo image: result=%d, url=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    VideoFeedsUploader.a(this.a).e = paramString;
    try
    {
      long l = new File(VideoFeedsUploader.a(this.a).e).length();
      i = (int)l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("VideoFeedsUploader", 1, paramString, new Object[0]);
      }
    }
    VideoFeedsUploader.a(this.a, 85, i);
    VideoFeedsUploader.a(this.a).d = paramInt;
    VideoFeedsUploader.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewm
 * JD-Core Version:    0.7.0.1
 */