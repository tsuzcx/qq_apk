import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

public class aawh
{
  private static int a = 3600;
  
  public static void a(int paramInt)
  {
    if ((paramInt >= 0) && (a != paramInt)) {
      a = paramInt;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ("doOnReconnect".equals(paramString2))
    {
      if (a > 0)
      {
        long l1 = PatchSharedPreUtil.getLastTimePullPatchReconnect(BaseApplicationImpl.sApplication);
        long l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) > a * 1000L)
        {
          aozj.a(paramQQAppInterface, paramString1, paramInt, paramString2);
          PatchSharedPreUtil.updateLastTimePullPatchReconnect(BaseApplicationImpl.sApplication, l2);
        }
      }
      return;
    }
    aozj.a(paramQQAppInterface, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aawh
 * JD-Core Version:    0.7.0.1
 */