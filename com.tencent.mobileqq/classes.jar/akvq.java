import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class akvq
{
  private SparseArray<akym> a = new SparseArray();
  
  public akvq()
  {
    localObject = albw.a();
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localJSONArray = ((aktz)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).a("redPackPanel", new String[] { "panelRedPkgList" });
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
            akym localakym = new akym();
            localakym.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id", "");
            localakym.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
            localakym.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", "");
            localakym.c = ((JSONObject)localObject).optString("icon_pic", "");
            localakym.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject).optJSONObject("params");
            if (QLog.isColorLevel()) {
              QLog.i("ConfigLogic", 2, "panelData = " + localakym);
            }
            this.a.put(localakym.jdField_a_of_type_Int, localakym);
          }
        }
        if (localObject != null) {
          break label104;
        }
        i += 1;
      }
    }
  }
  
  public akym a(int paramInt1, int paramInt2)
  {
    paramInt2 = akvs.a(paramInt1, paramInt2);
    QLog.i("ConfigLogic", 2, "channel: " + paramInt1 + ", type = " + paramInt2);
    return (akym)this.a.get(paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = a(paramInt1, paramInt2);
    String str = paramString;
    if (localObject != null)
    {
      str = paramString;
      if (((akym)localObject).jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = ((akym)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("hint");
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
  
  public ArrayList<akvo> a(int paramInt, bmho parambmho)
  {
    int i = 2;
    if (parambmho != null) {
      i = bmhg.a(parambmho.bus_type, 2);
    }
    parambmho = new ArrayList();
    Object localObject = a(paramInt, i);
    if ((localObject != null) && (((akym)localObject).jdField_a_of_type_OrgJsonJSONObject != null))
    {
      localObject = ((akym)localObject).jdField_a_of_type_OrgJsonJSONObject.optJSONArray("labels");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(paramInt);
          akvo localakvo = new akvo();
          localakvo.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localakvo.jdField_a_of_type_Int = localJSONObject.optInt("sub_channel");
          localakvo.jdField_b_of_type_Int = localJSONObject.optInt("max_length", 0);
          localakvo.jdField_b_of_type_JavaLangString = localJSONObject.optString("hint");
          parambmho.add(localakvo);
          paramInt += 1;
        }
      }
    }
    return parambmho;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvq
 * JD-Core Version:    0.7.0.1
 */