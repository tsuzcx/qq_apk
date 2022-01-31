import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader.OnResultListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aewn
  implements ImageUploader.OnResultListener
{
  public aewn(VideoFeedsUploader paramVideoFeedsUploader) {}
  
  public void a(int paramInt, String paramString)
  {
    i = 0;
    if ((paramInt != 0) || (TextUtils.isEmpty(paramString)))
    {
      VideoFeedsUploader.a(this.a).a = paramInt;
      VideoFeedsUploader.a(this.a).a = paramInt;
      VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
      return;
    }
    VideoFeedsUploader.a(this.a).f = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("VideoFeedsUploader", 2, String.format("upload doodle image: result=%d, url=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    try
    {
      long l = new File(VideoFeedsUploader.a(this.a).f).length();
      paramInt = (int)l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("VideoFeedsUploader", 1, paramString, new Object[0]);
        paramInt = i;
      }
    }
    VideoFeedsUploader.a(this.a, 90, paramInt);
    VideoFeedsUploader.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewn
 * JD-Core Version:    0.7.0.1
 */