import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class agtx
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public static agtx a(String paramString)
  {
    agtx localagtx = new agtx();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("useRecommendedSticker")) && (paramString.has("maxMatchLength")))
      {
        localagtx.a(paramString.getBoolean("useRecommendedSticker"));
        localagtx.a(paramString.getInt("maxMatchLength"));
      }
      return localagtx;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("StickerRecConfigBean", 2, paramString.getMessage());
    }
    return localagtx;
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
 * Qualified Name:     agtx
 * JD-Core Version:    0.7.0.1
 */