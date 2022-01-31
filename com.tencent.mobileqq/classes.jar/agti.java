import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class agti
{
  public int a;
  public SparseArrayCompat<ArrayList<String>> a;
  
  public agti()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  }
  
  public static agti a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    agti localagti = new agti();
    Object localObject = new JSONObject(paramString);
    localagti.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("avoid_peak_interval");
    paramString = new SparseArrayCompat();
    localObject = ((JSONObject)localObject).optJSONArray("regions");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString.put(i, agsy.a(((JSONArray)localObject).optJSONArray(i)));
        i += 1;
      }
    }
    localagti.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramString;
    return localagti;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agti
 * JD-Core Version:    0.7.0.1
 */