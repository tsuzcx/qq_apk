import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

class aknk
  implements MediaScanner.OnMediaInfoScannerListener
{
  aknk(akni paramakni, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bpij.a(this.jdField_a_of_type_Akni.mActivity, paramLocalMediaInfo))
    {
      if ((akni.a(this.jdField_a_of_type_Akni) != null) && (paramLocalMediaInfo.mDuration > akni.a(this.jdField_a_of_type_Akni).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_Akni.mActivity).cancleProgressDailog();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.sendPhoto(this.jdField_a_of_type_Akni.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      FrameVideoHelper localFrameVideoHelper = new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration);
      localFrameVideoHelper.a(new aknl(this, paramLocalMediaInfo, localFrameVideoHelper));
      aanb.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_Akni.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknk
 * JD-Core Version:    0.7.0.1
 */