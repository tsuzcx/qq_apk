import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class aesc
{
  private static aesc jdField_a_of_type_Aesc;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private aesc(Context paramContext)
  {
    a(paramContext);
  }
  
  public static aesc a()
  {
    try
    {
      if (jdField_a_of_type_Aesc == null) {
        jdField_a_of_type_Aesc = new aesc(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_Aesc;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      aesd localaesd = new aesd(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localaesd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */