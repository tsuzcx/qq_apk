import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class abjo
  implements AdCanvasDownloadListenerAdapter
{
  private List<IAdDownloader.Callback> a = new CopyOnWriteArrayList();
  
  public IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if (((localCallback instanceof abjn)) && (((abjn)localCallback).a() == paramAdAppDownloadManager)) {
          return localCallback;
        }
      }
    }
    return null;
  }
  
  public void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a == null) || (paramAdAppDownloadManager == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        IAdDownloader.Callback localCallback = (IAdDownloader.Callback)localIterator.next();
        if ((localCallback instanceof abjn))
        {
          AdAppDownloadManager localAdAppDownloadManager = ((abjn)localCallback).a();
          if ((localAdAppDownloadManager != null) && (localAdAppDownloadManager == paramAdAppDownloadManager)) {
            this.a.remove(localCallback);
          }
        }
      }
    }
  }
  
  public void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if ((this.a != null) && (paramAdAppDownloadManager != null))
    {
      abjn localabjn = new abjn();
      localabjn.a(paramAdAppDownloadManager);
      this.a.add(localabjn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjo
 * JD-Core Version:    0.7.0.1
 */