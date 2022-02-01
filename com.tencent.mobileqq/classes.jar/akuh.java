import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class akuh
  implements abbj
{
  akuh(akug paramakug, LocalMediaInfo paramLocalMediaInfo, FrameVideoHelper paramFrameVideoHelper) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_Akug.a.mActivity).cancleProgressDailog();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
    localBundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
    localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
    ((NewPhotoListActivity)this.jdField_a_of_type_Akug.a.mActivity).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    akue.a(this.jdField_a_of_type_Akug.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
    this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuh
 * JD-Core Version:    0.7.0.1
 */