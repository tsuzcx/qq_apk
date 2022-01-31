import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ImageUtil.ScalingLogic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aijh
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  public aijh(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 0)
    {
      new VideoFeedsUploader.UploadResult().a = -1010;
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarPublishActivity", 2, "compositeVideo: errorCode = " + paramInt);
      }
      this.a.b(null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.b = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
    this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight;
    this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a = ((int)this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(paramString2);
      Bitmap localBitmap = paramString1.getFrameAtTime();
      paramInt = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.b = paramInt;
      this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = i;
      this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.a = (this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart);
      paramString1.release();
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) {
        try
        {
          ImageUtil.a(ImageUtil.a(ImageUtil.a(this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, null), paramInt, i, ImageUtil.ScalingLogic.SCALE_CROP), new File(this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath));
          FFmpegUtils.a(this.a, paramString2, this.a.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramString2 + ".doodle.mp4", new aiji(this, paramString2));
          return;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBarPublishActivity", 2, "compositeVideo: " + QLog.getStackTraceString(paramString1));
          }
          this.a.b(null);
          return;
        }
        catch (OutOfMemoryError paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBarPublishActivity", 2, "compositeVideo: " + QLog.getStackTraceString(paramString1));
          }
          this.a.b(null);
          return;
        }
      }
      this.a.b(paramString2);
      return;
    }
    this.a.b(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */