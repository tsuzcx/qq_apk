import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class amaz
{
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramString2);
    localIntent.putExtra("key_callback_id", paramInt);
    localIntent.setData(Uri.parse(paramString1));
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */