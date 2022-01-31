import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aiun
{
  private SparseArray<aixd> a = new SparseArray();
  
  public aiun()
  {
    localObject = ajaf.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((aitd)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            aixd localaixd = new aixd();
            localaixd.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localaixd.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localaixd.b = ((JSONObject)localObject).optString("name", "");
            localaixd.c = ((JSONObject)localObject).optString("icon_pic", "");
            localaixd.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localaixd);
            }
            this.a.put(localaixd.jdField_a_of_type_Int, localaixd);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public aixd a(int paramInt1, int paramInt2)
  {
    paramInt2 = aiuo.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (aixd)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((aixd)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((aixd)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<aiul> a(int paramInt, biyg parambiyg)
  {
    int i = 2;
    if (parambiyg != null) {
      i = bixy.a(parambiyg.bus_type, 2);
    }
    parambiyg = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((aixd)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((aixd)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          aiul localaiul = new aiul();
          localaiul.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localaiul.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localaiul.b = localJSONObject.optInt("max_length", 0);
          parambiyg.add(localaiul);
          paramInt += 1;
        }
      }
    }
    return parambiyg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiun
 * JD-Core Version:    0.7.0.1
 */