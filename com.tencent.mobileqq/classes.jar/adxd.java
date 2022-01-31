import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import java.net.URL;

public class adxd
  implements Runnable
{
  public adxd(UniteGrayTipItemBuilder paramUniteGrayTipItemBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = AbsDownloader.a(URLDrawableHelper.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      new Handler(Looper.getMainLooper()).post(new adxe(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxd
 * JD-Core Version:    0.7.0.1
 */