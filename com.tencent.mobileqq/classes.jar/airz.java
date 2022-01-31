import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class airz
  implements MediaScanner.OnMediaInfoScannerListener
{
  airz(airx paramairx, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bnfr.a(this.jdField_a_of_type_Airx.mActivity, paramLocalMediaInfo))
    {
      if ((airx.a(this.jdField_a_of_type_Airx) != null) && (paramLocalMediaInfo.mDuration > airx.a(this.jdField_a_of_type_Airx).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_Airx.mActivity).cancleProgressDailog();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.a(this.jdField_a_of_type_Airx.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration).a(new aisa(this, paramLocalMediaInfo));
      zaj.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_Airx.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airz
 * JD-Core Version:    0.7.0.1
 */