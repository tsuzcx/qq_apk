import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajuw
{
  public String a;
  public Pattern a;
  public boolean a;
  public String b;
  public Pattern b;
  public boolean b;
  public String c;
  public String d;
  
  public static List<ajuw> a(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      if (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        ajuw localajuw;
        if (localJSONObject != null)
        {
          localajuw = new ajuw();
          localajuw.jdField_a_of_type_JavaLangString = localJSONObject.optString("sourceURLRegular");
          localajuw.jdField_b_of_type_JavaLangString = localJSONObject.optString("interceptURLRegular");
          if (localJSONObject.optInt("shouldReport") != 1) {
            break label138;
          }
          bool = true;
          label85:
          localajuw.jdField_a_of_type_Boolean = bool;
          if (localJSONObject.optInt("shouldIntercept") != 1) {
            break label143;
          }
        }
        label138:
        label143:
        for (boolean bool = true;; bool = false)
        {
          localajuw.jdField_b_of_type_Boolean = bool;
          localajuw.c = localJSONObject.optString("jumpURL");
          localArrayList.add(localajuw);
          i += 1;
          break;
          bool = false;
          break label85;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String toString()
  {
    return "InterceptConfig [mSrcUrlRegular=" + this.jdField_a_of_type_JavaLangString + ", mInterceptUrlRegular=" + this.jdField_b_of_type_JavaLangString + ", mIsReport=" + this.jdField_a_of_type_Boolean + ", mIsIntercept=" + this.jdField_b_of_type_Boolean + ", mJumpUrl=" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuw
 * JD-Core Version:    0.7.0.1
 */