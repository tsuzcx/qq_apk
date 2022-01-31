import android.content.Context;
import android.graphics.Rect;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONArray;
import org.json.JSONObject;

public class alnq
  extends alnp
{
  public boolean b;
  public Rect c;
  public Rect d;
  public int e;
  public String e;
  public String f = "";
  
  public alnq()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      super.a(paramInt, paramString, paramJSONObject);
      paramString = BaseApplicationImpl.getContext();
      this.jdField_e_of_type_Int = paramJSONObject.optInt("passive_type", -1);
      this.b = paramJSONObject.optBoolean("passive_rotate", false);
      this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("start_align", this.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      this.f = paramJSONObject.optString("end_align", "");
      if (paramJSONObject.has("start_rect"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("start_rect");
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
        this.jdField_c_of_type_AndroidGraphicsRect.left = aciy.a(localJSONArray.getInt(0) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.top = aciy.a(localJSONArray.getInt(1) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.right = aciy.a(localJSONArray.getInt(2) / 2, paramString.getResources());
        this.jdField_c_of_type_AndroidGraphicsRect.bottom = aciy.a(localJSONArray.getInt(3) / 2, paramString.getResources());
        this.a = this.jdField_c_of_type_AndroidGraphicsRect;
      }
      if (paramJSONObject.has("end_rect"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("end_rect");
        this.d = new Rect();
        this.d.left = aciy.a(paramJSONObject.getInt(0) / 2, paramString.getResources());
        this.d.top = aciy.a(paramJSONObject.getInt(1) / 2, paramString.getResources());
        this.d.right = aciy.a(paramJSONObject.getInt(2) / 2, paramString.getResources());
        this.d.bottom = aciy.a(paramJSONObject.getInt(3) / 2, paramString.getResources());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alnq
 * JD-Core Version:    0.7.0.1
 */