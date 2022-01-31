import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ahfx
{
  public int a;
  public SparseArrayCompat<ArrayList<String>> a;
  
  public ahfx()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  }
  
  public static ahfx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ahfx localahfx = new ahfx();
    Object localObject = new JSONObject(paramString);
    localahfx.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("avoid_peak_interval");
    paramString = new SparseArrayCompat();
    localObject = ((JSONObject)localObject).optJSONArray("regions");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString.put(i, ahfn.a(((JSONArray)localObject).optJSONArray(i)));
        i += 1;
      }
    }
    localahfx.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = paramString;
    return localahfx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfx
 * JD-Core Version:    0.7.0.1
 */