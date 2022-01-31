import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;

class agpx
  implements Runnable
{
  agpx(agpw paramagpw) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.a.a);
      if (localObject1 != null)
      {
        PicPreDownloader localPicPreDownloader = ((QQAppInterface)localObject1).a();
        localObject1 = (ShortVideoPreDownloader)((QQAppInterface)localObject1).getManager(94);
        if (localPicPreDownloader != null)
        {
          localPicPreDownloader.f();
          localPicPreDownloader.e();
        }
        if (localObject1 != null) {
          ((ShortVideoPreDownloader)localObject1).d();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpx
 * JD-Core Version:    0.7.0.1
 */