import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import org.json.JSONObject;

public final class aith
  implements aabm
{
  public aith(View paramView, aabp paramaabp, long paramLong, int paramInt, String paramString) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aabp, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login failed," + paramString);
  }
  
  public void onPermission(int paramInt)
  {
    ApolloRender.locationEnd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aabp, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login permision code");
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    ApolloRender.getLocationDoLocation(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Aabp, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aith
 * JD-Core Version:    0.7.0.1
 */