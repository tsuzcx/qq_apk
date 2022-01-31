import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class agny
{
  private SparseArray<agqm> a = new SparseArray();
  
  public agny()
  {
    localObject = agwj.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((agmq)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
      if (localJSONArray != null) {
        break label63;
      }
      QLog.i("ConfigLogic", 2, "no pkg list...");
    }
    for (;;)
    {
      return;
      label63:
      localObject = null;
      int i = 0;
      while (i < localJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            agqm localagqm = new agqm();
            localagqm.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localagqm.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localagqm.b = ((JSONObject)localObject).optString("name", "");
            localagqm.c = ((JSONObject)localObject).optString("icon_pic", "");
            localagqm.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localagqm);
            }
            this.a.put(localagqm.jdField_a_of_type_Int, localagqm);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public agqm a(int paramInt1, int paramInt2)
  {
    paramInt2 = agnz.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (agqm)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((agqm)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((agqm)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
        QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", hint array: " + localObject);
        str = paramString;
        if (localObject != null)
        {
          str = paramString;
          if (((JSONArray)localObject).length() > 0) {
            str = ((JSONArray)localObject).optString(0, paramString);
          }
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agny
 * JD-Core Version:    0.7.0.1
 */