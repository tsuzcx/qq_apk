import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import org.json.JSONException;
import org.json.JSONObject;

public class abzs
  extends abzv
{
  public abzs(TestAppFragment paramTestAppFragment, EditText paramEditText, JSONObject paramJSONObject)
  {
    super(paramEditText);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    super.onSuccess(paramJSONObject);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("rankingID", 11002);
      this.jdField_a_of_type_OrgJsonJSONObject.put("topCount", 11);
      this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_Abwx.a("getRankingList", this.jdField_a_of_type_OrgJsonJSONObject, new abzv(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_AndroidWidgetEditText));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzs
 * JD-Core Version:    0.7.0.1
 */