import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class ahab
{
  private static ahab jdField_a_of_type_Ahab;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ahab(Context paramContext)
  {
    a(paramContext);
  }
  
  public static ahab a()
  {
    try
    {
      if (jdField_a_of_type_Ahab == null) {
        jdField_a_of_type_Ahab = new ahab(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_Ahab;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      ahac localahac = new ahac(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localahac);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public int a(int paramInt)
  {
    return a(paramInt, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      return paramInt2;
    }
    return localInteger.intValue();
  }
  
  public boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    return (paramInt == 3) || (paramInt == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahab
 * JD-Core Version:    0.7.0.1
 */