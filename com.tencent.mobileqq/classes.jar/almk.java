import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class almk
  implements Runnable
{
  public almk(DownloadCenterImpl paramDownloadCenterImpl, ArrayList paramArrayList) {}
  
  public void run()
  {
    LogUtility.a("DownloadCenterImpl", "getQueryDownloadAction enter");
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (DownloadInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (DownloadManager.a().a((DownloadInfo)localObject)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = DownloadCenterImpl.a(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadDownloadCenterImpl).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IDownloadCallback)((Iterator)localObject).next()).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     almk
 * JD-Core Version:    0.7.0.1
 */