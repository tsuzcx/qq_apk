import android.util.Xml;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class alci
{
  public static int a(String paramString)
  {
    try
    {
      int i = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2"), paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = -5;
    Object localObject;
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        albz.a("arsdk2", a(), "arsdk2", paramString2);
        try
        {
          albv.a(paramString1, albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")));
          paramString2 = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + "md5_config.xml";
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            break label842;
          }
          new HashMap();
        }
        catch (IOException paramString2)
        {
          File localFile;
          String str;
          i = -6;
          bbdx.a(albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")), false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        paramString2 = a(bbdx.b((File)localObject));
        if (paramString2.size() <= 0) {
          break label812;
        }
        paramString2 = paramString2.entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label883;
        }
        localObject = (Map.Entry)paramString2.next();
        paramString1 = "";
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libAlphaAR")) {
          break label583;
        }
        paramString1 = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
        albz.a("arsdk2", a(), "libAlphaAR", (String)((Map.Entry)localObject).getValue());
      }
      catch (IOException paramString2)
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libYTCommon")) {
          break label677;
        }
        paramString1 = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
        albz.a("arsdk2", a(), "libYTCommon", (String)((Map.Entry)localObject).getValue());
        continue;
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("AlphaAR_mqq_license")) {
          continue;
        }
        paramString1 = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".dat";
        albz.a("arsdk2", a(), "AlphaAR_mqq_license", (String)((Map.Entry)localObject).getValue());
        continue;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + paramString1);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      localFile = new File(paramString1);
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + paramString1);
      if (localFile.exists())
      {
        str = aurn.a(paramString1);
        localObject = (String)((Map.Entry)localObject).getValue();
        if (((String)localObject).equalsIgnoreCase(str)) {
          continue;
        }
        localFile.delete();
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + paramString1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject);
        i = -3;
      }
    }
    for (;;)
    {
      return i;
      label583:
      label842:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + paramString2);
      label677:
      label812:
      i = -2;
      continue;
      label883:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
  }
  
  public static String a()
  {
    if (AppSetting.b) {
      return "v8.2.0.1_for_arm64";
    }
    return "v8.2.0.1";
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException)
      {
        XmlPullParser localXmlPullParser;
        QLog.e("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      break label204;
      str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("libAlphaAR"))
      {
        localHashMap.put("libAlphaAR", localXmlPullParser.nextText());
      }
      else if (str.equalsIgnoreCase("libYTCommon"))
      {
        localHashMap.put("libYTCommon", localException.nextText());
      }
      else if (str.equalsIgnoreCase("AlphaAR_mqq_license"))
      {
        localHashMap.put("AlphaAR_mqq_license", localException.nextText());
        label204:
        while (i == 1)
        {
          String str;
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static boolean a()
  {
    File localFile1 = new File(albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + "libYTCommon" + ".so");
    File localFile2 = new File(albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + "libAlphaAR" + ".so");
    File localFile3 = new File(albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + "AlphaAR_mqq_license" + ".dat");
    if (!localFile1.exists()) {}
    while ((!localFile2.exists()) || (!localFile3.exists())) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        String str = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + paramString + ".so";
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist soFile=" + str + ", exist=" + ((File)localObject).exists());
        }
        if (((File)localObject).exists())
        {
          paramString = albz.b("arsdk2", a(), paramString);
          localObject = aurn.a(str);
          boolean bool2 = paramString.equalsIgnoreCase((String)localObject);
          if (bool2)
          {
            bool1 = true;
            return bool1;
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str + ", md5FromConfig = " + paramString + ", md5FromCalc = " + (String)localObject);
          continue;
        }
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str);
      }
      finally {}
    }
  }
  
  public static String b()
  {
    String str = albz.a("arsdk2", a(), albz.b("arsdk2", a(), "arsdk2")) + File.separator + "AlphaAR_mqq_license" + ".dat";
    QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "getLicense. license = " + str);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alci
 * JD-Core Version:    0.7.0.1
 */