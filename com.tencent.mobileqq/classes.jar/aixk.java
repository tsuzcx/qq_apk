import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.mediaCodec.VideoMergeHelper;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.qphone.base.util.QLog;

public class aixk
  implements Runnable
{
  public aixk(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      CodecParam.r = 2000000;
      localObject1 = this.b + ".doodle.mp4";
      localObject2 = this.b + ".tmp.mp4";
      Object localObject3 = new MergeEditVideo.EditParam(CodecParam.r, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      ((MergeEditVideo.EditParam)localObject3).b(2);
      int i = new MergeEditVideo().a(this.b, (String)localObject1, (MergeEditVideo.EditParam)localObject3);
      if (i != 0)
      {
        if (i == -1) {
          FileUtils.c(this.b, (String)localObject1);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("tribe_publish_TroopBarPublishActivity", 1, "onCompositeFinish step 1 timeCost:" + (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) + "ms bitrate:" + CodecParam.r);
        }
        localObject3 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject3).setDataSource((String)localObject1);
        Bitmap localBitmap = ((MediaMetadataRetriever)localObject3).getFrameAtTime();
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.b = localBitmap.getWidth();
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.c = localBitmap.getHeight();
        ((MediaMetadataRetriever)localObject3).release();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd != 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd - this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isMuteRecordVoice) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath))) {
          break label401;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a((String)localObject1, this.jdField_a_of_type_Long);
        return;
      }
      QLog.i("tribe_publish_TroopBarPublishActivity", 1, "getVideoMeta failed. merge file path:" + this.b + " merge result:" + i);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(null, this.jdField_a_of_type_Long);
      return;
      label401:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd == 0) {}
        for (i = VideoMergeHelper.a((String)localObject1, (String)localObject3, (String)localObject2, 0);; i = VideoMergeHelper.a((String)localObject1, (String)localObject3, (String)localObject2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd))
        {
          FileUtils.f((String)localObject1);
          if (i != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a((String)localObject2, this.jdField_a_of_type_Long);
          return;
        }
        QLog.i("tribe_publish_TroopBarPublishActivity", 1, "merge voice failed. merge file path:" + (String)localObject1 + " merge result:" + i);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(null, this.jdField_a_of_type_Long);
        return;
      }
      new VideoCompositeHelper().a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, (String)localObject1, (String)localObject2, true, new aixl(this, (String)localObject1, (String)localObject2));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = true;
    Object localObject1 = new VideoCompositeHelper();
    Object localObject2 = new aixm(this);
    ((VideoCompositeHelper)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b + ".tmp.mp4", false, true, (VideoCompositeHelper.VideoCompositeCallBack)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixk
 * JD-Core Version:    0.7.0.1
 */