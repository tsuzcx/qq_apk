import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class aalc
  implements Runnable
{
  aalc(aalb paramaalb) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)aalb.a(this.a).get();
    if (localObject == null)
    {
      ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, qq app is NULL, return");
      return;
    }
    localObject = aalb.a((QQAppInterface)localObject);
    String str1 = aalb.a((JSONObject)localObject);
    JSONObject localJSONObject = aalb.a();
    String str2 = aalb.a(localJSONObject);
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
    {
      if (str2.equals(str1))
      {
        ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, local id is equal to remote id, check file integrity, id=%s", new Object[] { str2 }));
        aalb.a(this.a, (JSONObject)localObject);
        return;
      }
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, local id is diff from remote id, start updating, id=%s->%s", new Object[] { str2, str1 }));
      aalb.a(this.a, localJSONObject, (JSONObject)localObject);
      return;
    }
    if (!TextUtils.isEmpty(str2))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("updateLocalDict, remote id not exist, check local files, id=%s", new Object[] { str2 }));
      aalb.a(this.a, localJSONObject);
      return;
    }
    if (!TextUtils.isEmpty(str1))
    {
      ArkAppCenter.b("ArkApp.Dict.Update", String.format("remoteLocalDict, remote id exist, update, id=%s", new Object[] { str1 }));
      aalb.a(this.a, null, (JSONObject)localObject);
      return;
    }
    ArkAppCenter.b("ArkApp.Dict.Update", "updateLocalDict, local and remote id are both empty, do nothing");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalc
 * JD-Core Version:    0.7.0.1
 */