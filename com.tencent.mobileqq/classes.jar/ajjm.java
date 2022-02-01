import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@SuppressLint({"UseSparseArrays"})
public class ajjm
{
  private static ajjm jdField_a_of_type_Ajjm;
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ajjm(Context paramContext)
  {
    a(paramContext);
  }
  
  public static ajjm a()
  {
    try
    {
      if (jdField_a_of_type_Ajjm == null) {
        jdField_a_of_type_Ajjm = new ajjm(BaseApplicationImpl.getContext());
      }
      return jdField_a_of_type_Ajjm;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    try
    {
      SAXParser localSAXParser = SAXParserFactory.newInstance().newSAXParser();
      ajjn localajjn = new ajjn(this);
      localSAXParser.parse(paramContext.getAssets().open("online_status_icon_config.xml"), localajjn);
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
 * Qualified Name:     ajjm
 * JD-Core Version:    0.7.0.1
 */