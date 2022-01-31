import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ahal
{
  private SparseArray<ahcz> a = new SparseArray();
  
  public ahal()
  {
    localObject = ahiw.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((agzd)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            ahcz localahcz = new ahcz();
            localahcz.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localahcz.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localahcz.b = ((JSONObject)localObject).optString("name", "");
            localahcz.c = ((JSONObject)localObject).optString("icon_pic", "");
            localahcz.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localahcz);
            }
            this.a.put(localahcz.jdField_a_of_type_Int, localahcz);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public ahcz a(int paramInt1, int paramInt2)
  {
    paramInt2 = aham.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (ahcz)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((ahcz)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((ahcz)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
 * Qualified Name:     ahal
 * JD-Core Version:    0.7.0.1
 */