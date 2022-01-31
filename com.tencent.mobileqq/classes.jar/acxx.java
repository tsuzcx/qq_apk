import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

public final class acxx
  implements ValueCallback
{
  public acxx(WeakReference paramWeakReference, Activity paramActivity) {}
  
  public void a(String paramString)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localActivity != null) && (paramString != null) && (paramString.startsWith("http")))
    {
      if (UniformDownloadMgr.a().a() == null)
      {
        paramString = new Bundle();
        paramString.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131435091));
        Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
        localIntent.putExtra("param", paramString);
        localIntent.putExtra("url", "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10386");
        localActivity.sendBroadcast(localIntent);
      }
    }
    else {
      return;
    }
    FileManagerUtil.d(localActivity, "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10386");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acxx
 * JD-Core Version:    0.7.0.1
 */