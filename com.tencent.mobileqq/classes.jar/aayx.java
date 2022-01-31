import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class aayx
  implements Runnable
{
  aayx(aayw paramaayw) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)aayw.a(this.a).get();
    if (localObject == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
      return;
    }
    localObject = aayw.a((QQAppInterface)localObject);
    String str1 = aayw.a((JSONObject)localObject);
    JSONObject localJSONObject = aayw.a();
    String str2 = aayw.a(localJSONObject);
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
    {
      if (str2.equals(str1))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, local id is equal to remote id, check file integrity, id=%s", new Object[] { str2 }));
        aayw.a(this.a, (JSONObject)localObject);
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, local id is diff from remote id, start updating, id=%s->%s", new Object[] { str2, str1 }));
      aayw.a(this.a, localJSONObject, (JSONObject)localObject);
      return;
    }
    if (!TextUtils.isEmpty(str2))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, remote id not exist, check local files, id=%s", new Object[] { str2 }));
      aayw.a(this.a, localJSONObject);
      return;
    }
    if (!TextUtils.isEmpty(str1))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("remoteLocalDict, remote id exist, update, id=%s", new Object[] { str1 }));
      aayw.a(this.a, null, (JSONObject)localObject);
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, local and remote id are both empty, do nothing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayx
 * JD-Core Version:    0.7.0.1
 */