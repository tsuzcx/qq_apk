import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public final class aiac
  implements Runnable
{
  public void run()
  {
    try
    {
      SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "GIFEngine");
      ShortVideoUtils.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      ShortVideoUtils.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiac
 * JD-Core Version:    0.7.0.1
 */