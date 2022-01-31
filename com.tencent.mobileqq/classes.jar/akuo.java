import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class akuo
  implements moc
{
  akuo(akum paramakum, akup paramakup, ArrayList paramArrayList, akul paramakul) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.jdField_a_of_type_Akup != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Akul);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_Akup.a(true);
            this.jdField_a_of_type_Akup.a(4, true);
            this.jdField_a_of_type_Akum.a();
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
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.jdField_a_of_type_Akup != null))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Akul);
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
                    {
                      this.jdField_a_of_type_Akup.a(true);
                      this.jdField_a_of_type_Akup.a(4, true);
                      this.jdField_a_of_type_Akum.a();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.jdField_a_of_type_Akup == null);
            this.jdField_a_of_type_Akup.a(false);
            this.jdField_a_of_type_Akup.a(4, false);
            this.jdField_a_of_type_Akum.a();
            return;
            paramString = this.jdField_a_of_type_Akup;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.jdField_a_of_type_Akup == null);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Akul);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 0);
      this.jdField_a_of_type_Akup.a(true);
      this.jdField_a_of_type_Akup.a(4, true);
      this.jdField_a_of_type_Akum.a();
      return;
    } while (this.jdField_a_of_type_Akup == null);
    this.jdField_a_of_type_Akup.a(false);
    this.jdField_a_of_type_Akup.a(4, false);
    this.jdField_a_of_type_Akum.a();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.jdField_a_of_type_Akup != null) {
      this.jdField_a_of_type_Akup.a(akum.a(this.jdField_a_of_type_Akum, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akuo
 * JD-Core Version:    0.7.0.1
 */