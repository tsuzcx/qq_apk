import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class amao
{
  private Map<String, String> a = new HashMap();
  
  public static amao a()
  {
    amao localamao = new amao();
    String str = a(false, "apolloConfig");
    if (!TextUtils.isEmpty(str)) {
      localamao.a.put("apolloConfig", str);
    }
    str = a(false, "apolloGame");
    if (!TextUtils.isEmpty(str)) {
      localamao.a.put("apolloGame", str);
    }
    str = a(false, "apolloPreDownload");
    if (!TextUtils.isEmpty(str)) {
      localamao.a.put("apolloPreDownload", str);
    }
    return localamao;
  }
  
  public static amao a(alzs[] paramArrayOfalzs)
  {
    Object localObject;
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "onParsed error: confFiles is empty");
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      amao localamao;
      int i;
      try
      {
        localamao = new amao();
        i = 0;
        localObject = localamao;
        if (i >= paramArrayOfalzs.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfalzs[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("apolloSwitch")) {
          localamao.a.put("apolloConfig", paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("aioGameTab")) {
          localamao.a.put("apolloGame", paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfalzs)
      {
        QLog.e("ApolloConfig_GlobalProcessor", 1, paramArrayOfalzs, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("preDownLoadRes")) {
        localamao.a.put("apolloPreDownload", paramArrayOfalzs[i].jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  private static String a(boolean paramBoolean, String paramString)
  {
    Object localObject1 = aiys.jdField_a_of_type_JavaLangString;
    Object localObject2 = localObject1;
    if (paramBoolean) {
      localObject2 = (String)localObject1 + "/test";
    }
    localObject1 = "";
    if ("apolloConfig".equals(paramString)) {
      localObject1 = "/apolloConfig.json";
    }
    for (;;)
    {
      paramString = (String)localObject2 + (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return null;
      if ("apolloGame".equals(paramString)) {
        localObject1 = "/apolloGameConfig.json";
      } else if ("apolloPreDownload".equals(paramString)) {
        localObject1 = "/apolloPreDownload.json";
      }
    }
    localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "getConfigFileContent path:", paramString });
    }
    paramString = bace.a(paramString);
    if (paramString == null) {
      return null;
    }
    return new String(paramString);
  }
  
  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    return paramString2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amao paramamao)
  {
    if ((paramQQAppInterface == null) || (paramamao == null) || (paramamao.a.size() == 0))
    {
      QLog.e("ApolloConfig_GlobalProcessor", 1, "parseApolloConfBean err params");
      if (!paramBoolean) {
        amap.c();
      }
    }
    int i;
    do
    {
      return;
      Iterator localIterator = paramamao.a.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = a(paramBoolean, str1, (String)paramamao.a.get(str1));
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloConfBean isUpdate:", paramBoolean + ",content:", str2 });
        }
        if ("apolloConfig".equals(str1))
        {
          aiyr.a(str2, paramQQAppInterface);
          if (paramBoolean) {
            aifg.b(false);
          }
          i = 1;
        }
        for (;;)
        {
          break;
          if ("apolloGame".equals(str1)) {
            aiyr.b(paramQQAppInterface, str2, paramBoolean);
          } else if ("apolloPreDownload".equals(str1)) {
            aiyr.b(paramQQAppInterface, str2);
          }
        }
      }
    } while (i == 0);
    amar.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amao
 * JD-Core Version:    0.7.0.1
 */