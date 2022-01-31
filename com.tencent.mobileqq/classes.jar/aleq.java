import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import java.util.ArrayList;
import java.util.Iterator;

public class aleq
  implements INetEventHandler
{
  public aleq(DownloadCenterImpl paramDownloadCenterImpl) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.a();
    Iterator localIterator = DownloadCenterImpl.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IDownloadCallback)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aleq
 * JD-Core Version:    0.7.0.1
 */