import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class altd
{
  public static int a;
  private static boolean a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  
  public static void a()
  {
    if (a) {}
    do
    {
      return;
      a = true;
    } while (ArkEnvironmentManager.getInstance().isHardwareAcceleration());
    a(null, "ark.lib.software.rendering", 0, 0, 0, 0, "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    axqw.b(paramQQAppInterface, "CliOper", "", "", "0X800776F", paramString1, paramInt1, 1, paramInt2, Integer.toString(paramInt3), Integer.toString(paramInt4), paramString2, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((!ArkAppMgr.isValidAppName(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.c("ArkApp.DataReport", String.format("appInsideClickReport, invalid args, app=%s, opName=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
      return;
    }
    ArkAppCenter.c("ArkApp.DataReport", String.format("appInsideClickReport, app=%s, op-name=%s, entry=%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) }));
    axpp.a(paramQQAppInterface, paramString1, "__app__", paramString2, 0L, paramInt, 0L, 0L, 0L, "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!ArkAppMgr.isValidAppName(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ArkAppCenter.c("ArkApp.DataReport", String.format("platformEventReport, invalid args, app-name=%s, op-name=%s", new Object[] { paramString1, paramString2 }));
      return;
    }
    if (!"HTTPTaskResult".equals(paramString2)) {
      ArkAppCenter.c("ArkApp.DataReport", String.format("platformEventReport, app=%s, op-name=%s, entry=%d, result=%d, r1=%d, r2=%d, r3=%s, r4=%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), paramString3, paramString4 }));
    }
    axpp.a(paramQQAppInterface, paramString1, "__platform__", paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramString3, paramString4);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    for (;;)
    {
      a(paramQQAppInterface, paramString2, paramString1, 0, paramInt3, 0L, paramInt1, paramInt2, paramString3, "");
      return;
    }
  }
  
  public static void a(String paramString)
  {
    a(null, paramString, 0, 0, 0, 0, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altd
 * JD-Core Version:    0.7.0.1
 */