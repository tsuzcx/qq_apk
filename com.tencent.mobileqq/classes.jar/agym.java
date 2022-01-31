import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class agym
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public static agym a(String paramString)
  {
    agym localagym = new agym();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("useRecommendedSticker")) && (paramString.has("maxMatchLength")))
      {
        localagym.a(paramString.getBoolean("useRecommendedSticker"));
        localagym.a(paramString.getInt("maxMatchLength"));
      }
      return localagym;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("StickerRecConfigBean", 2, paramString.getMessage());
    }
    return localagym;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agym
 * JD-Core Version:    0.7.0.1
 */