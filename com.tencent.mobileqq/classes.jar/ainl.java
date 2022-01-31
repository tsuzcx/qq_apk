import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class ainl
  implements yvz
{
  ainl(aink paramaink, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_Aink.a.mActivity).cancleProgressDailog();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
    localBundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
    localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
    ((NewPhotoListActivity)this.jdField_a_of_type_Aink.a.mActivity).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    aini.a(this.jdField_a_of_type_Aink.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainl
 * JD-Core Version:    0.7.0.1
 */