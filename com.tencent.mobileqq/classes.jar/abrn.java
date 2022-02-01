import android.content.Context;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.mobileqq.utils.NetworkUtil;

public class abrn
{
  public static int a(Context paramContext)
  {
    return AdNet.getType(paramContext);
  }
  
  public static boolean a(Context paramContext)
  {
    return NetworkUtil.isNetSupport(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrn
 * JD-Core Version:    0.7.0.1
 */