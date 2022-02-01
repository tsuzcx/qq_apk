import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class akuf
  implements MediaScanner.OnMediaInfoScannerListener
{
  akuf(akue paramakue) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bqyp.a(this.a.mActivity, paramLocalMediaInfo))
    {
      akue.a(this.a, paramLocalMediaInfo);
      abbe.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */