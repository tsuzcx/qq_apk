import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aliz
  implements myy
{
  aliz(alix paramalix, alja paramalja, ArrayList paramArrayList, aliw paramaliw) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.jdField_a_of_type_Alja != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Aliw);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_Alja.a(true);
            this.jdField_a_of_type_Alja.a(4, true);
            this.jdField_a_of_type_Alix.a();
          }
        }
      }
    }
    label244:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                try
                {
                  paramString = new JSONObject(paramString);
                  if (!paramString.has("data")) {
                    break label244;
                  }
                  paramString = paramString.getJSONArray("data");
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.jdField_a_of_type_Alja != null))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Aliw);
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
                    {
                      this.jdField_a_of_type_Alja.a(true);
                      this.jdField_a_of_type_Alja.a(4, true);
                      this.jdField_a_of_type_Alix.a();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.jdField_a_of_type_Alja == null);
            this.jdField_a_of_type_Alja.a(false);
            this.jdField_a_of_type_Alja.a(4, false);
            this.jdField_a_of_type_Alix.a();
            return;
            paramString = this.jdField_a_of_type_Alja;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.jdField_a_of_type_Alja == null);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Aliw);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 0);
      this.jdField_a_of_type_Alja.a(true);
      this.jdField_a_of_type_Alja.a(4, true);
      this.jdField_a_of_type_Alix.a();
      return;
    } while (this.jdField_a_of_type_Alja == null);
    this.jdField_a_of_type_Alja.a(false);
    this.jdField_a_of_type_Alja.a(4, false);
    this.jdField_a_of_type_Alix.a();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.jdField_a_of_type_Alja != null) {
      this.jdField_a_of_type_Alja.a(alix.a(this.jdField_a_of_type_Alix, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */