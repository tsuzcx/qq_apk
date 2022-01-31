import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;

public class ainl
  implements Runnable
{
  public ainl(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public void run()
  {
    int i = ShareAppLogHelper.a(this.a);
    if (i != 0)
    {
      ShareAppLogHelper.a(this.a, i);
      ShareAppLogHelper.a(this.a);
      return;
    }
    i = ShareAppLogHelper.b(this.a);
    if (i == 1)
    {
      ShareAppLogHelper.b(this.a, i);
      ShareAppLogHelper.b(this.a);
      if (!ShareAppLogHelper.a(this.a)) {
        ShareAppLogHelper.a(this.a, ShareAppLogHelper.a(this.a));
      }
    }
    for (;;)
    {
      ShareAppLogHelper.a(this.a);
      return;
      try
      {
        File localFile = new File(ShareAppLogHelper.a(this.a));
        if (!localFile.exists()) {
          continue;
        }
        localFile.delete();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      if (i == 0) {
        ShareAppLogHelper.a(this.a, ShareAppLogHelper.a(this.a));
      } else {
        ShareAppLogHelper.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainl
 * JD-Core Version:    0.7.0.1
 */