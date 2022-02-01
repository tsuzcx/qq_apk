import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alce
{
  private SparseArray<alfa> a = new SparseArray();
  
  public alce()
  {
    localObject = alil.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((alao)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            alfa localalfa = new alfa();
            localalfa.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localalfa.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localalfa.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
            localalfa.c = ((JSONObject)localObject).optString("icon_pic", "");
            localalfa.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localalfa);
            }
            this.a.put(localalfa.jdField_a_of_type_Int, localalfa);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public alfa a(int paramInt1, int paramInt2)
  {
    paramInt2 = alcg.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (alfa)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((alfa)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((alfa)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<alcc> a(int paramInt, bmry parambmry)
  {
    int i = 2;
    if (parambmry != null) {
      i = bmrq.a(parambmry.bus_type, 2);
    }
    parambmry = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((alfa)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((alfa)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          alcc localalcc = new alcc();
          localalcc.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localalcc.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localalcc.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localalcc.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          parambmry.add(localalcc);
          paramInt += 1;
        }
      }
    }
    return parambmry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */