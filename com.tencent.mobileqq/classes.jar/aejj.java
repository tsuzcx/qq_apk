import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_write.AddFeedRsp;
import com.tencent.qphone.base.util.QLog;

public class aejj
  implements CsTask.Callback
{
  public aejj(VideoFeedsUploader paramVideoFeedsUploader) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ilive_feeds_write.AddFeedRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.ret.get() != 0)
      {
        VideoFeedsUploader.a(this.a).a = paramBundle.ret.get();
        VideoFeedsUploader.a(this.a).i = new String(paramBundle.err_msg.get().toByteArray());
        VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
        return;
      }
      VideoFeedsUploader.a(this.a).a = 0;
      VideoFeedsUploader.a(this.a).d = new String(paramBundle.feed_id.get().toByteArray());
      if (QLog.isColorLevel()) {
        QLog.i("VideoFeedsUploader", 2, "feedId=" + VideoFeedsUploader.a(this.a).d);
      }
      VideoFeedsUploader.d(this.a);
      VideoFeedsUploader.a(this.a, 100, 0);
      VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      VideoFeedsUploader.a(this.a).a = -1005;
      VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aejj
 * JD-Core Version:    0.7.0.1
 */