import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class amaq
{
  private Map<String, String> a = new HashMap();
  
  public static amaq a(alzs[] paramArrayOfalzs)
  {
    Object localObject;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        amaq localamaq = new amaq();
        i = 0;
        localObject = localamaq;
        if (i >= paramArrayOfalzs.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfalzs[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localamaq.a.put("apolloGrayUrlWhite", paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localamaq.a.put("apolloTraceConfig", paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfalzs)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfalzs, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amaq paramamaq)
  {
    if ((paramQQAppInterface == null) || (paramamaq == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramamaq.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramamaq.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          aiyr.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          aiyr.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amaq
 * JD-Core Version:    0.7.0.1
 */