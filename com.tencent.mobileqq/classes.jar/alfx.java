import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class alfx
{
  public int a;
  public String a;
  public String b;
  
  private alfx()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
  {
    if (paramJSONObject != null)
    {
      try
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          paramJSONObject.put(this.jdField_a_of_type_JavaLangString, this.b);
          return;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          paramJSONObject.put(this.jdField_a_of_type_JavaLangString, Integer.parseInt(this.b));
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("apollo_client_ApolloSSOConfig", 1, paramString, new Object[0]);
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        paramJSONObject.put(this.jdField_a_of_type_JavaLangString, Long.parseLong(this.b));
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        paramJSONObject.put(this.jdField_a_of_type_JavaLangString, Float.parseFloat(this.b));
        return;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        paramJSONObject.put(this.jdField_a_of_type_JavaLangString, Long.parseLong(paramAppInterface.getCurrentAccountUin()));
        return;
      }
      if (this.jdField_a_of_type_Int == 5)
      {
        paramJSONObject.put(this.jdField_a_of_type_JavaLangString, paramAppInterface.getCurrentAccountUin());
        return;
      }
      if (this.jdField_a_of_type_Int == 8)
      {
        paramJSONObject.put(this.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
        return;
      }
      if (this.jdField_a_of_type_Int == 6)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = Uri.parse(paramString).getQueryParameter(this.b);
          if (!TextUtils.isEmpty(paramString)) {
            paramJSONObject.put(this.jdField_a_of_type_JavaLangString, Long.parseLong(paramString));
          }
        }
      }
      else if ((this.jdField_a_of_type_Int == 7) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = Uri.parse(paramString).getQueryParameter(this.b);
        if (!TextUtils.isEmpty(paramString)) {
          paramJSONObject.put(this.jdField_a_of_type_JavaLangString, paramString);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mKey:").append(this.jdField_a_of_type_JavaLangString).append(" mValue:").append(this.b).append(" mType:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfx
 * JD-Core Version:    0.7.0.1
 */