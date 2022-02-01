import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

class akug
  implements MediaScanner.OnMediaInfoScannerListener
{
  akug(akue paramakue, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bqyp.a(this.jdField_a_of_type_Akue.mActivity, paramLocalMediaInfo))
    {
      if ((akue.a(this.jdField_a_of_type_Akue) != null) && (paramLocalMediaInfo.mDuration > akue.a(this.jdField_a_of_type_Akue).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_Akue.mActivity).cancleProgressDailog();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.a(this.jdField_a_of_type_Akue.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      FrameVideoHelper localFrameVideoHelper = new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration);
      localFrameVideoHelper.a(new akuh(this, paramLocalMediaInfo, localFrameVideoHelper));
      abbe.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_Akue.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akug
 * JD-Core Version:    0.7.0.1
 */