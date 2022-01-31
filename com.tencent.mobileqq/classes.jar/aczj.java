import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aczj
  implements Runnable
{
  public aczj(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      if (UniformDownloadMgr.a(this.a).size() > 0)
      {
        Iterator localIterator = UniformDownloadMgr.a(this.a).entrySet().iterator();
        while (localIterator.hasNext())
        {
          aczv localaczv = (aczv)((Map.Entry)localIterator.next()).getValue();
          if ((localaczv != null) && (localaczv.a != null) && (localaczv.a.b()) && (2 == localaczv.a.g())) {
            localArrayList.add(localaczv);
          }
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext()) {
      ((aczv)((Iterator)???).next()).a.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczj
 * JD-Core Version:    0.7.0.1
 */