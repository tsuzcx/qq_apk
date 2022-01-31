import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.AppDesc;
import com.tencent.ark.open.ArkAppInfo.AppDownloadInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI.10;
import com.tencent.mobileqq.ark.ArkAppCGI.8;
import com.tencent.mobileqq.ark.ArkAppCGI.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class alsc
  implements aysa
{
  static int jdField_a_of_type_Int;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private ayry jdField_a_of_type_Ayry;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<alsn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    if (!alsc.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public alsc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (this.jdField_a_of_type_Ayry == null) {
      this.jdField_a_of_type_Ayry = ((aysv)paramQQAppInterface.getManager(21)).a(paramQQAppInterface, 0);
    }
  }
  
  private int a(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  private alsl a(String paramString)
  {
    alsl localalsl = new alsl();
    localalsl.jdField_a_of_type_Int = 0;
    if (paramString == null) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localalsl;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localalsl;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localalsl;
      }
      localalsl.jdField_a_of_type_Int = paramString.optInt("updateInterval", 300);
      localalsl.jdField_a_of_type_Int = Math.max(60, localalsl.jdField_a_of_type_Int);
      paramString = paramString.optJSONArray("apps");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject1 = paramString.optJSONObject(i);
          if (localObject1 != null)
          {
            String str1 = ((JSONObject)localObject1).optString("app");
            if (TextUtils.isEmpty(str1))
            {
              ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
            }
            else
            {
              int j = ((JSONObject)localObject1).optInt("ret", -1);
              Object localObject2 = ((JSONObject)localObject1).optString("msg", "");
              alsm localalsm;
              if (j != 0)
              {
                localalsm = new alsm();
                localalsm.jdField_a_of_type_Int = j;
                localalsm.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = null;
                localalsl.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsm);
              }
              else
              {
                localalsm = new alsm();
                localalsm.jdField_a_of_type_Int = 0;
                localalsm.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config);
                }
                localalsm.b = ((JSONObject)localObject1).optInt("state", 0);
                if (localalsm.b == 0)
                {
                  ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localalsm.jdField_a_of_type_Int = -1;
                  localalsl.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsm);
                }
                else if (localalsm.b == 1)
                {
                  localObject2 = ((JSONObject)localObject1).optString("ver", null);
                  String str2 = ((JSONObject)localObject1).optString("url", null);
                  String str3 = ((JSONObject)localObject1).optString("sign", null);
                  j = ((JSONObject)localObject1).optInt("updatePeriod", 0);
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                  {
                    ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", new Object[] { str1 }));
                  }
                  else
                  {
                    localObject1 = Base64.decode(str3, 0);
                    if ((localObject1 == null) || (localObject1.length == 0))
                    {
                      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", new Object[] { str1 }));
                    }
                    else
                    {
                      localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.downloadUrl = str2;
                      localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.sign = ((byte[])localObject1);
                      localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.updatePeriodByMinutes = j;
                      localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.name = str1;
                      localalsm.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localalsl.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsm);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      str = paramArrayOfByte.getString("retcode");
      if (!str.equalsIgnoreCase("0"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, reply fail, ret=" + str);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = paramArrayOfByte.getJSONObject("result");
      paramArrayOfByte = ((JSONObject)localObject).getString("retcode");
      String str = ((JSONObject)localObject).getString("msg");
      localObject = ((JSONObject)localObject).getString("apk_name");
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + paramArrayOfByte + str);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryPackageNameByAppID, Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    return localObject;
  }
  
  private void a(alsn paramalsn, alsk arg2)
  {
    paramalsn.jdField_a_of_type_Alsk = ???;
    paramalsn.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramalsn);
      ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (??? == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_JavaLangString = paramalsn.jdField_a_of_type_JavaLangString;
    localayrv.e = 1;
    if (paramalsn.jdField_a_of_type_ArrayOfByte == null) {
      localayrv.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localayrv.a(paramalsn);
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localayrv.jdField_a_of_type_Aysa = this;
      localayrv.c = 30L;
      localayrv.jdField_a_of_type_JavaIoOutputStream = paramalsn.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if (paramalsn.jdField_b_of_type_JavaLangString != null) {
        localayrv.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramalsn.jdField_b_of_type_JavaLangString);
      }
      if (paramalsn.jdField_a_of_type_Long >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(paramalsn.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localayrv.jdField_a_of_type_JavaUtilHashMap.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new ArkAppCGI.8(this, ???, paramalsn, localayrv), 5, null, true);
      return;
      localayrv.jdField_a_of_type_Int = 1;
      localayrv.jdField_a_of_type_ArrayOfByte = paramalsn.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  private void a(alsn paramalsn, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.10(this, paramalsn, paramBoolean, paramArrayOfByte));
  }
  
  private void a(alsp paramalsp, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    alsj localalsj;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramalsp.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramalsp.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramalsp.jdField_a_of_type_JavaUtilArrayList.get(i);
      localalsj = (alsj)paramalsp.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localalsj != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localalsj.a(paramBoolean, paramArrayOfByte, paramalsp.d, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramalsp.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, alsj paramalsj)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alsn localalsn = (alsn)localIterator.next();
        if ((localalsn.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (localalsn.jdField_a_of_type_Long == paramLong))
        {
          localalsn.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localalsn.jdField_b_of_type_JavaUtilArrayList.add(paramalsj);
          return true;
        }
      }
      return false;
    }
  }
  
  private static String b()
  {
    try
    {
      String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
      new File(str).mkdirs();
      long l = System.currentTimeMillis();
      int i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      str = String.format("%s/%s", new Object[] { str, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(alsn paramalsn, alsk arg2)
  {
    paramalsn.jdField_a_of_type_Alsk = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramalsn);
      ThreadManager.post(new ArkAppCGI.9(this, paramalsn), 5, null, true);
      return;
    }
  }
  
  protected void a(also paramalso, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramalso.jdField_b_of_type_JavaUtilArrayList.size())
    {
      alsj localalsj = (alsj)paramalso.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localalsj != null) {
        localalsj.a(paramBoolean, paramalso.jdField_a_of_type_Long, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=null");
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      } while (localObject == null);
      localObject = ((ArkAppCenter)localObject).a();
    } while (localObject == null);
    ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkSafe,doReport=" + paramString);
    ((altn)localObject).a("ArkAppReport.URLCheck", paramString, 10000, 0, new alsg(this));
  }
  
  public void a(String paramString, long paramLong, alsj paramalsj)
  {
    if (a(paramString, paramLong, null, paramalsj)) {
      return;
    }
    also localalso = new also(null);
    localalso.jdField_a_of_type_JavaLangString = paramString;
    localalso.jdField_a_of_type_Long = paramLong;
    localalso.jdField_b_of_type_JavaUtilArrayList.add(paramalsj);
    a(localalso, new alsh(this));
  }
  
  public void a(String paramString, Object paramObject, alsj paramalsj)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      if (paramalsj != null) {
        paramalsj.a(false, null, paramString, paramObject);
      }
    }
    Object localObject2;
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject1 == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, app is null, return");
          return;
        }
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        str1 = ((TicketManager)localObject2).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), "connect.qq.com");
        if ((str1 != null) && (str1.length() > 0)) {
          break;
        }
        ArkAppCenter.c("ArkApp.ArkAppCGI", "queryPackageNameByAppID, pskey is null, return");
      } while (paramalsj == null);
      paramalsj.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(a(str1)) });
    } while (a(str2, -1L, paramObject, paramalsj));
    alsp localalsp = new alsp(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localalsp.jdField_b_of_type_JavaLangString = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localalsp.jdField_a_of_type_JavaLangString = str2;
    localalsp.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localalsp.jdField_b_of_type_JavaUtilArrayList.add(paramalsj);
    localalsp.d = paramString;
    localalsp.c = "https://connect.qq.com";
    b(localalsp, new alse(this));
  }
  
  public void b(String paramString, long paramLong, alsj paramalsj)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramalsj == null) || (a(paramString, paramLong, null, paramalsj))) {
      return;
    }
    also localalso = new also(null);
    localalso.jdField_a_of_type_JavaLangString = paramString;
    localalso.jdField_a_of_type_Long = paramLong;
    localalso.jdField_b_of_type_JavaUtilArrayList.add(paramalsj);
    a(localalso, new alsf(this));
  }
  
  public void onResp(aysx paramaysx)
  {
    alsn localalsn = (alsn)paramaysx.jdField_a_of_type_Aysw.a();
    boolean bool;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      bool = true;
      if (!bool) {
        break label202;
      }
    }
    for (;;)
    {
      try
      {
        arrayOfByte = localalsn.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
        if (paramaysx.c == 304)
        {
          bool = true;
          paramaysx = (String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader");
          if (!TextUtils.isEmpty(paramaysx))
          {
            paramaysx = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaysx);
            if (!paramaysx.find()) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          byte[] arrayOfByte;
          paramaysx = paramaysx.group(1);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          localalsn.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramaysx).getTime();
          a(localalsn, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException paramaysx)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { localalsn.jdField_a_of_type_JavaLangString }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsc
 * JD-Core Version:    0.7.0.1
 */