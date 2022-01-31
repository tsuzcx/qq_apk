import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class aink
  implements MediaScanner.OnMediaInfoScannerListener
{
  aink(aini paramaini, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bnbf.a(this.jdField_a_of_type_Aini.mActivity, paramLocalMediaInfo))
    {
      if ((aini.a(this.jdField_a_of_type_Aini) != null) && (paramLocalMediaInfo.mDuration > aini.a(this.jdField_a_of_type_Aini).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_Aini.mActivity).cancleProgressDailog();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.a(this.jdField_a_of_type_Aini.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration).a(new ainl(this, paramLocalMediaInfo));
      yvu.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_Aini.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aink
 * JD-Core Version:    0.7.0.1
 */