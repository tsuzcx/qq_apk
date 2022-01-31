import com.dataline.util.file.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.jsp.QQComicJsPlugin;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class altt
  implements Runnable
{
  public altt(QQComicJsPlugin paramQQComicJsPlugin) {}
  
  public void run()
  {
    Object localObject = QQComicJsPlugin.a();
    if (localObject != null)
    {
      long l1 = System.currentTimeMillis();
      FileUtil.a(new File((String)localObject));
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQComicJsPlugin", 2, "clean cache cost " + (l2 - l1) + " ms");
      }
    }
    QQComicJsPlugin.a().set(false);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("size", this.a.a());
      ((JSONObject)localObject).put("data", localJSONObject);
      label137:
      this.a.callJs(QQComicJsPlugin.b(), new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altt
 * JD-Core Version:    0.7.0.1
 */