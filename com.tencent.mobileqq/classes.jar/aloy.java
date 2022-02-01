import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import org.json.JSONObject;

public final class aloy
  implements acjr
{
  public aloy(View paramView, acju paramacju, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acju, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed");
  }
  
  public void onPermission(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acju, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed permission");
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("city", "");
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Acju, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, paramJSONObject, 0, "location success");
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloy
 * JD-Core Version:    0.7.0.1
 */