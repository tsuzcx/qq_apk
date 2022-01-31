import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahfv
{
  public int a;
  public SparseArrayCompat<ArrayList<String>> a;
  
  public ahfv()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  }
  
  public static ahfv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ahfv localahfv = new ahfv();
    Object localObject = new JSONObject(paramString);
    localahfv.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("avoid_peak_interval");
    paramString = new SparseArrayCompat();
    localObject = ((JSONObject)localObject).optJSONArray("regions");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString.put(i, ahfl.a(((JSONArray)localObject).optJSONArray(i)));
        i += 1;
      }
    }
    localahfv.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramString;
    return localahfv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */