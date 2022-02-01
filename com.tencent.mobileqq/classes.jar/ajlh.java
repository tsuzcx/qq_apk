import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class ajlh
{
  private static ajlh jdField_a_of_type_Ajlh;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ajlh(Context paramContext)
  {
    a(paramContext);
  }
  
  public static ajlh a()
  {
    try
    {
      if (jdField_a_of_type_Ajlh == null) {
        jdField_a_of_type_Ajlh = new ajlh(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_Ajlh;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      ajli localajli = new ajli(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localajli);
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
 * Qualified Name:     ajlh
 * JD-Core Version:    0.7.0.1
 */