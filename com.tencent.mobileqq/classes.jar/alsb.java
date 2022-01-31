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

public class alsb
  implements aysc
{
  static int jdField_a_of_type_Int;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private aysa jdField_a_of_type_Aysa;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList<alsm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    if (!alsb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
      return;
    }
  }
  
  public alsb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    if (this.jdField_a_of_type_Aysa == null) {
      this.jdField_a_of_type_Aysa = ((aysx)paramQQAppInterface.getManager(21)).a(paramQQAppInterface, 0);
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
  
  private alsk a(String paramString)
  {
    alsk localalsk = new alsk();
    localalsk.jdField_a_of_type_Int = 0;
    if (paramString == null) {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, data is empty");
    }
    for (;;)
    {
      return localalsk;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("data");
        if (paramString == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
          return localalsk;
        }
      }
      catch (JSONException paramString)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", new Object[] { paramString.getMessage() }));
        return localalsk;
      }
      localalsk.jdField_a_of_type_Int = paramString.optInt("updateInterval", 300);
      localalsk.jdField_a_of_type_Int = Math.max(60, localalsk.jdField_a_of_type_Int);
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
              alsl localalsl;
              if (j != 0)
              {
                localalsl = new alsl();
                localalsl.jdField_a_of_type_Int = j;
                localalsl.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = null;
                localalsk.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsl);
              }
              else
              {
                localalsl = new alsl();
                localalsl.jdField_a_of_type_Int = 0;
                localalsl.jdField_a_of_type_JavaLangString = ((String)localObject2);
                localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc = new ArkAppInfo.AppDesc();
                localObject2 = ((JSONObject)localObject1).optJSONObject("config");
                if (localObject2 != null)
                {
                  localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config = ArkAppConfigMgr.convertJsonToConfig((JSONObject)localObject2);
                  localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.isTempApp = ArkAppConfigMgr.isTemplateApp(localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.config);
                }
                localalsl.b = ((JSONObject)localObject1).optInt("state", 0);
                if (localalsl.b == 0)
                {
                  ArkAppCenter.c("ArkApp.ArkAppCGI", "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                  localalsl.jdField_a_of_type_Int = -1;
                  localalsk.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsl);
                }
                else if (localalsl.b == 1)
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
                      localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.downloadUrl = str2;
                      localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.sign = ((byte[])localObject1);
                      localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.updatePeriodByMinutes = j;
                      localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.name = str1;
                      localalsl.jdField_a_of_type_ComTencentArkOpenArkAppInfo$AppDownloadInfo.desc.version = ((String)localObject2);
                    }
                  }
                }
                else
                {
                  localalsk.jdField_a_of_type_JavaUtilHashMap.put(str1, localalsl);
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
  
  private void a(alsm paramalsm, alsj arg2)
  {
    paramalsm.jdField_a_of_type_Alsj = ???;
    paramalsm.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramalsm);
      ??? = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (??? == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, app is null, return");
        return;
      }
    }
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_JavaLangString = paramalsm.jdField_a_of_type_JavaLangString;
    localayrx.e = 1;
    if (paramalsm.jdField_a_of_type_ArrayOfByte == null) {
      localayrx.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localayrx.a(paramalsm);
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localayrx.jdField_a_of_type_Aysc = this;
      localayrx.c = 30L;
      localayrx.jdField_a_of_type_JavaIoOutputStream = paramalsm.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if (paramalsm.jdField_b_of_type_JavaLangString != null) {
        localayrx.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramalsm.jdField_b_of_type_JavaLangString);
      }
      if (paramalsm.jdField_a_of_type_Long >= 0L)
      {
        Object localObject = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
        ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT"));
        localObject = ((SimpleDateFormat)localObject).format(new Date(paramalsm.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localayrx.jdField_a_of_type_JavaUtilHashMap.put("If-Modified-Since", localObject);
        }
      }
      ThreadManager.post(new ArkAppCGI.8(this, ???, paramalsm, localayrx), 5, null, true);
      return;
      localayrx.jdField_a_of_type_Int = 1;
      localayrx.jdField_a_of_type_ArrayOfByte = paramalsm.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  private void a(alsm paramalsm, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.10(this, paramalsm, paramBoolean, paramArrayOfByte));
  }
  
  private void a(also paramalso, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    alsi localalsi;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramalso.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramalso.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramalso.jdField_a_of_type_JavaUtilArrayList.get(i);
      localalsi = (alsi)paramalso.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localalsi != null) {
        if (paramArrayOfByte == null) {
          break label136;
        }
      }
    }
    label136:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localalsi.a(paramBoolean, paramArrayOfByte, paramalso.d, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramalso.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, alsi paramalsi)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        alsm localalsm = (alsm)localIterator.next();
        if ((localalsm.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (localalsm.jdField_a_of_type_Long == paramLong))
        {
          localalsm.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localalsm.jdField_b_of_type_JavaUtilArrayList.add(paramalsi);
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
  
  private void b(alsm paramalsm, alsj arg2)
  {
    paramalsm.jdField_a_of_type_Alsj = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramalsm);
      ThreadManager.post(new ArkAppCGI.9(this, paramalsm), 5, null, true);
      return;
    }
  }
  
  protected void a(alsn paramalsn, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramalsn.jdField_b_of_type_JavaUtilArrayList.size())
    {
      alsi localalsi = (alsi)paramalsn.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localalsi != null) {
        localalsi.a(paramBoolean, paramalsn.jdField_a_of_type_Long, paramArrayOfByte);
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
    ((altm)localObject).a("ArkAppReport.URLCheck", paramString, 10000, 0, new alsf(this));
  }
  
  public void a(String paramString, long paramLong, alsi paramalsi)
  {
    if (a(paramString, paramLong, null, paramalsi)) {
      return;
    }
    alsn localalsn = new alsn(null);
    localalsn.jdField_a_of_type_JavaLangString = paramString;
    localalsn.jdField_a_of_type_Long = paramLong;
    localalsn.jdField_b_of_type_JavaUtilArrayList.add(paramalsi);
    a(localalsn, new alsg(this));
  }
  
  public void a(String paramString, Object paramObject, alsi paramalsi)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      if (paramalsi != null) {
        paramalsi.a(false, null, paramString, paramObject);
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
      } while (paramalsi == null);
      paramalsi.a(false, null, paramString, paramObject);
      return;
      localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(a(str1)) });
    } while (a(str2, -1L, paramObject, paramalsi));
    also localalso = new also(null);
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = "0" + (String)localObject1) {}
    localObject1 = "o" + (String)localObject1;
    localalso.jdField_b_of_type_JavaLangString = ("p_uin=" + (String)localObject1 + "; p_skey=" + str1 + "; uin=" + (String)localObject1 + "; skey=" + (String)localObject2);
    localalso.jdField_a_of_type_JavaLangString = str2;
    localalso.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localalso.jdField_b_of_type_JavaUtilArrayList.add(paramalsi);
    localalso.d = paramString;
    localalso.c = "https://connect.qq.com";
    b(localalso, new alsd(this));
  }
  
  public void b(String paramString, long paramLong, alsi paramalsi)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramalsi == null) || (a(paramString, paramLong, null, paramalsi))) {
      return;
    }
    alsn localalsn = new alsn(null);
    localalsn.jdField_a_of_type_JavaLangString = paramString;
    localalsn.jdField_a_of_type_Long = paramLong;
    localalsn.jdField_b_of_type_JavaUtilArrayList.add(paramalsi);
    a(localalsn, new alse(this));
  }
  
  public void onResp(aysz paramaysz)
  {
    alsm localalsm = (alsm)paramaysz.jdField_a_of_type_Aysy.a();
    boolean bool;
    if (paramaysz.jdField_a_of_type_Int == 0)
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
        arrayOfByte = localalsm.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
        if (paramaysz.c == 304)
        {
          bool = true;
          paramaysz = (String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader");
          if (!TextUtils.isEmpty(paramaysz))
          {
            paramaysz = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramaysz);
            if (!paramaysz.find()) {}
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          byte[] arrayOfByte;
          paramaysz = paramaysz.group(1);
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
          localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
          localalsm.jdField_a_of_type_Long = localSimpleDateFormat.parse(paramaysz).getTime();
          a(localalsm, bool, arrayOfByte);
          return;
          bool = false;
          break;
          localOutOfMemoryError = localOutOfMemoryError;
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
          localObject = null;
          bool = false;
        }
        catch (ParseException paramaysz)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("lastModified time parse fail, url=%s", new Object[] { localalsm.jdField_a_of_type_JavaLangString }));
          continue;
        }
        continue;
      }
      label202:
      Object localObject = null;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsb
 * JD-Core Version:    0.7.0.1
 */