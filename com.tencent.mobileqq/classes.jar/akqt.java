import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class akqt
{
  private SparseArray<aktl> a = new SparseArray();
  
  public akqt()
  {
    localObject = akww.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((akpd)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            aktl localaktl = new aktl();
            localaktl.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localaktl.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localaktl.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
            localaktl.c = ((JSONObject)localObject).optString("icon_pic", "");
            localaktl.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localaktl);
            }
            this.a.put(localaktl.jdField_a_of_type_Int, localaktl);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public aktl a(int paramInt1, int paramInt2)
  {
    paramInt2 = akqv.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (aktl)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((aktl)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((aktl)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<akqr> a(int paramInt, blqw paramblqw)
  {
    int i = 2;
    if (paramblqw != null) {
      i = blqo.a(paramblqw.bus_type, 2);
    }
    paramblqw = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((aktl)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((aktl)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          akqr localakqr = new akqr();
          localakqr.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localakqr.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localakqr.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localakqr.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          paramblqw.add(localakqr);
          paramInt += 1;
        }
      }
    }
    return paramblqw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqt
 * JD-Core Version:    0.7.0.1
 */