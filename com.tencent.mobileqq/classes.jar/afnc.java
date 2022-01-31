import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowEnterManager.DownloadListener;
import com.tencent.mobileqq.transfile.HttpNetReq;
import java.lang.ref.WeakReference;

public class afnc
  implements Runnable
{
  public afnc(NowEnterManager paramNowEnterManager, boolean paramBoolean, HttpNetReq paramHttpNetReq) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a != null)
    {
      NowEnterManager.DownloadListener localDownloadListener = (NowEnterManager.DownloadListener)this.jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a.get();
      if (localDownloadListener != null) {
        localDownloadListener.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afnc
 * JD-Core Version:    0.7.0.1
 */