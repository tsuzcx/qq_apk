import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajzx
{
  private SparseArray<akct> a = new SparseArray();
  
  public ajzx()
  {
    localObject = akgd.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((ajyg)((QQAppInterface)localObject).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            akct localakct = new akct();
            localakct.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localakct.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localakct.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
            localakct.c = ((JSONObject)localObject).optString("icon_pic", "");
            localakct.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localakct);
            }
            this.a.put(localakct.jdField_a_of_type_Int, localakct);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public akct a(int paramInt1, int paramInt2)
  {
    paramInt2 = ajzz.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (akct)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((akct)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((akct)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<ajzv> a(int paramInt, bkwf parambkwf)
  {
    int i = 2;
    if (parambkwf != null) {
      i = bkvx.a(parambkwf.bus_type, 2);
    }
    parambkwf = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((akct)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((akct)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          ajzv localajzv = new ajzv();
          localajzv.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localajzv.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localajzv.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localajzv.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          parambkwf.add(localajzv);
          paramInt += 1;
        }
      }
    }
    return parambkwf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzx
 * JD-Core Version:    0.7.0.1
 */