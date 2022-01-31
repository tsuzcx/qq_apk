import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import java.util.ArrayList;

class agno
  implements xhg
{
  agno(agnn paramagnn, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_Agnn.a.a.f();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
    localBundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
    localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
    this.jdField_a_of_type_Agnn.a.a.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    PhotoListActivity.a(this.jdField_a_of_type_Agnn.a.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agno
 * JD-Core Version:    0.7.0.1
 */