import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class ainj
  implements MediaScanner.OnMediaInfoScannerListener
{
  ainj(aini paramaini) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bnbf.a(this.a.mActivity, paramLocalMediaInfo))
    {
      aini.a(this.a, paramLocalMediaInfo);
      yvu.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainj
 * JD-Core Version:    0.7.0.1
 */