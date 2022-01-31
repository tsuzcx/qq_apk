import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class ajtx
{
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", amip.c().a(paramString2, paramString1));
    localIntent.putExtra("hide_operation_bar", true);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtx
 * JD-Core Version:    0.7.0.1
 */