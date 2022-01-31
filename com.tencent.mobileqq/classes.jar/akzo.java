import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;

public class akzo
  extends BroadcastReceiver
{
  public akzo(MSFIntChkStrike paramMSFIntChkStrike, DownloadManager paramDownloadManager) {}
  
  @SuppressLint({"NewApi"})
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    String str;
    Object localObject;
    if (MSFIntChkStrike.a(this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFIntChkStrike) == l)
    {
      str = "";
      localObject = new DownloadManager.Query();
      ((DownloadManager.Query)localObject).setFilterById(new long[] { l });
      paramIntent = null;
    }
    try
    {
      Cursor localCursor = this.jdField_a_of_type_AndroidAppDownloadManager.query((DownloadManager.Query)localObject);
      localObject = str;
      if (localCursor != null)
      {
        localObject = str;
        paramIntent = localCursor;
        if (localCursor.moveToFirst())
        {
          paramIntent = localCursor;
          localObject = localCursor.getString(localCursor.getColumnIndex("local_filename"));
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramIntent = new Intent("android.intent.action.VIEW");
        paramIntent.setDataAndType(Uri.parse("file://" + (String)localObject), "application/vnd.android.package-archive");
        paramIntent.setFlags(268435456);
        paramContext.startActivity(paramIntent);
      }
      return;
    }
    finally
    {
      if (paramIntent != null) {
        paramIntent.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akzo
 * JD-Core Version:    0.7.0.1
 */