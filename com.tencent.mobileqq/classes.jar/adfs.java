import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;

public class adfs
  implements URLDrawable.DownloadListener
{
  public adfs(HotPicMainPanel paramHotPicMainPanel, ImageView paramImageView) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a.post(new adft(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adfs
 * JD-Core Version:    0.7.0.1
 */