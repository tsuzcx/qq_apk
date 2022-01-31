import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aizc
{
  private SparseArray<ajbs> a = new SparseArray();
  
  public aizc()
  {
    localObject = ajeu.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((aixs)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            ajbs localajbs = new ajbs();
            localajbs.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localajbs.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localajbs.b = ((JSONObject)localObject).optString("name", "");
            localajbs.c = ((JSONObject)localObject).optString("icon_pic", "");
            localajbs.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localajbs);
            }
            this.a.put(localajbs.jdField_a_of_type_Int, localajbs);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public ajbs a(int paramInt1, int paramInt2)
  {
    paramInt2 = aizd.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (ajbs)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((ajbs)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((ajbs)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<aiza> a(int paramInt, bjcn parambjcn)
  {
    int i = 2;
    if (parambjcn != null) {
      i = bjcf.a(parambjcn.bus_type, 2);
    }
    parambjcn = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((ajbs)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((ajbs)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          aiza localaiza = new aiza();
          localaiza.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localaiza.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localaiza.b = localJSONObject.optInt("max_length", 0);
          parambjcn.add(localaiza);
          paramInt += 1;
        }
      }
    }
    return parambjcn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizc
 * JD-Core Version:    0.7.0.1
 */