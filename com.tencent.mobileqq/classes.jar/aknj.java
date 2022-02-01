import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class aknj
  implements MediaScanner.OnMediaInfoScannerListener
{
  aknj(akni paramakni) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bpij.a(this.a.mActivity, paramLocalMediaInfo))
    {
      akni.a(this.a, paramLocalMediaInfo);
      aanb.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknj
 * JD-Core Version:    0.7.0.1
 */