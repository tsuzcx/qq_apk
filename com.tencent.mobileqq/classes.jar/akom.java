import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class akom
  implements MediaScanner.OnMediaInfoScannerListener
{
  akom(akol paramakol, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_Akol.mActivity).cancleProgressDailog();
    if (bpij.a(this.jdField_a_of_type_Akol.mActivity, paramLocalMediaInfo))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.sendPhoto(this.jdField_a_of_type_Akol.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akom
 * JD-Core Version:    0.7.0.1
 */