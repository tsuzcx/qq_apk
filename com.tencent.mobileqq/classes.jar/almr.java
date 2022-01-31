import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi;
import com.tencent.open.appcommon.now.download.local.DownloadTaskInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class almr
  implements Runnable
{
  public almr(DownloadCallbackNativeImpl paramDownloadCallbackNativeImpl, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2)) {
      localIterator = DownloadCallbackNativeImpl.a(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl).values().iterator();
    }
    while (localIterator.hasNext())
    {
      DownloadTaskInfo localDownloadTaskInfo = (DownloadTaskInfo)localIterator.next();
      DownloadInfo localDownloadInfo = DownloadCenterImpl.a().a(localDownloadTaskInfo.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localDownloadTaskInfo.b) {
            DownloadNativeApi.a().a(localDownloadTaskInfo.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localDownloadTaskInfo.b) && (!localDownloadTaskInfo.c))
        {
          DownloadNativeApi.a().a(null, localDownloadTaskInfo);
          continue;
          if (this.jdField_a_of_type_Int == 1)
          {
            localIterator = DownloadCallbackNativeImpl.a(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl).values().iterator();
            while (localIterator.hasNext())
            {
              localDownloadTaskInfo = (DownloadTaskInfo)localIterator.next();
              localDownloadInfo = DownloadCenterImpl.a().a(localDownloadTaskInfo.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localDownloadTaskInfo.c)) {
                DownloadNativeApi.a().a(null, localDownloadTaskInfo);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     almr
 * JD-Core Version:    0.7.0.1
 */