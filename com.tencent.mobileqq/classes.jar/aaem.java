import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aaem
  extends aaen
{
  aaem(aael paramaael) {}
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    super.onSuccess(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("appfriends");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("rankingID", 11001);
      JSONArray localJSONArray1 = new JSONArray();
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        Object localObject = paramJSONObject.getJSONObject(i).getString("openid");
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("openid", localObject);
        localJSONObject2.put("score", (int)Math.floor(Math.random() * 1000.0D));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("key", "test_key");
        ((JSONObject)localObject).put("value", (int)Math.floor(Math.random() * 100.0D));
        ((JSONObject)localObject).put("type", 1);
        JSONArray localJSONArray2 = new JSONArray();
        localJSONArray2.put(localObject);
        localJSONObject2.put("extraList", localJSONArray2);
        localJSONArray1.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("scoreList", localJSONArray1);
      this.a.a.jdField_a_of_type_Aabp.a("reportScore", localJSONObject1, new aaen(this.a.a.jdField_a_of_type_AndroidWidgetEditText));
      if (this.a.a.jdField_a_of_type_AndroidWidgetEditText != null) {
        new AlertDialog.Builder(this.a.a.jdField_a_of_type_AndroidWidgetEditText.getContext()).setTitle("reportScore").setMessage(localJSONObject1.toString()).setNegativeButton("知道了", null).create().show();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaem
 * JD-Core Version:    0.7.0.1
 */