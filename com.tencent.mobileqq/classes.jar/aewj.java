import android.os.Bundle;
import android.os.Handler;
import com.tencent.ilive_feeds.ShortVideo.UploadRsp;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aewj
  implements CsTask.Callback
{
  public aewj(VideoFeedsUploader paramVideoFeedsUploader) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int j = 0;
    Object localObject = new ShortVideo.UploadRsp();
    List localList;
    int i;
    try
    {
      ((ShortVideo.UploadRsp)localObject).mergeFrom(paramArrayOfByte);
      paramInt = ((ShortVideo.UploadRsp)localObject).retcode.get();
      if (paramInt != 0)
      {
        VideoFeedsUploader.a(this.a).a = paramInt;
        VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
        return;
      }
      VideoFeedsUploader.a(this.a, 10, 0);
      paramArrayOfByte = ((ShortVideo.UploadRsp)localObject).authkey.get().toByteArray();
      ((ShortVideo.UploadRsp)localObject).expiretime.get();
      ((ShortVideo.UploadRsp)localObject).frontid.get();
      paramBundle = ((ShortVideo.UploadRsp)localObject).frontip.get();
      localList = ((ShortVideo.UploadRsp)localObject).zoneip.get();
      localObject = new ArrayList();
      paramInt = 0;
      i = j;
      if (paramInt < paramBundle.size())
      {
        if (((Integer)paramBundle.get(paramInt)).intValue() == 0) {
          break label380;
        }
        ((List)localObject).add(VideoFeedsUploader.a(this.a, ((Integer)paramBundle.get(paramInt)).intValue()));
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      VideoFeedsUploader.a(this.a).a = -1005;
      VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
      return;
    }
    for (;;)
    {
      if (i < localList.size())
      {
        if (((Integer)localList.get(i)).intValue() != 0) {
          ((List)localObject).add(VideoFeedsUploader.a(this.a, ((Integer)localList.get(i)).intValue()));
        }
      }
      else
      {
        if (((List)localObject).size() <= 0)
        {
          VideoFeedsUploader.a(this.a).a = -1006;
          VideoFeedsUploader.a(this.a, VideoFeedsUploader.a(this.a));
          if (QLog.isColorLevel()) {
            QLog.i("VideoFeedsUploader", 2, "frontip is empty!");
          }
        }
        else
        {
          paramBundle = VideoFeedsUploader.a(this.a).c;
          VideoFeedsUploader.a(this.a).post(new aewk(this, (List)localObject, paramArrayOfByte, paramBundle));
        }
        return;
        label380:
        paramInt += 1;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewj
 * JD-Core Version:    0.7.0.1
 */