import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;

public class acpu
  implements Runnable
{
  public acpu(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    UniformDownloadMgr.b(this.a, null);
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpu
 * JD-Core Version:    0.7.0.1
 */