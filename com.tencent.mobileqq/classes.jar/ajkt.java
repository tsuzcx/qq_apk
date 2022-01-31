import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Xml;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.MD5;
import org.xmlpull.v1.XmlPullParser;

public class ajkt
  implements Manager
{
  static boolean jdField_a_of_type_Boolean = true;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  Comparator<ajkx> jdField_a_of_type_JavaUtilComparator = null;
  HashMap<String, ajky> jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
  List<WeakReference<ajkw>> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  
  public ajkt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  @TargetApi(11)
  private void a(Set<String> paramSet)
  {
    try
    {
      localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
      if (Build.VERSION.SDK_INT < 11) {
        break label73;
      }
      localEditor.putStringSet("hotchat_scene_config", paramSet);
      localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SharedPreferences.Editor localEditor;
        label73:
        Iterator localIterator;
        int i;
        localThrowable.printStackTrace();
        continue;
        paramSet = Integer.valueOf(paramSet.size());
      }
    }
    if (QLog.isColorLevel())
    {
      if (paramSet == null)
      {
        paramSet = "null";
        asfl.a("HotchatSCMng", new Object[] { "saveConfigs", paramSet });
      }
    }
    else
    {
      return;
      localEditor.putInt("hotchat_scene_config_count", paramSet.size());
      localIterator = paramSet.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString("hotchat_scene_config_" + i, str);
        i += 1;
      }
    }
  }
  
  @TargetApi(11)
  private String[] a()
  {
    label126:
    do
    {
      try
      {
        localObject4 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        if (Build.VERSION.SDK_INT < 11) {
          break label126;
        }
        localObject1 = ((SharedPreferences)localObject4).getStringSet("hotchat_scene_config", new HashSet());
        if ((localObject1 == null) || (((Set)localObject1).size() <= 0)) {
          break label237;
        }
        localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            Object localObject2;
            int j;
            int i;
            localObject2[i] = ((SharedPreferences)localObject4).getString("hotchat_scene_config_" + i, "");
            i += 1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject4;
            localObject1 = localObject3;
            Object localObject3 = localThrowable2;
            continue;
          }
          localThrowable1 = localThrowable1;
          Object localObject1 = null;
          localThrowable1.printStackTrace();
          continue;
          localObject3 = Integer.valueOf(localObject1.length);
          continue;
          localObject4 = "";
          continue;
          localObject1 = null;
        }
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label208;
        }
        localObject2 = "null";
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label218;
        }
        localObject4 = localObject1[0];
        asfl.a("HotchatSCMng", new Object[] { "getConfigs", localObject2, localObject4 });
      }
      return localObject1;
      j = ((SharedPreferences)localObject4).getInt("hotchat_scene_config_count", 0);
      if (j <= 0) {
        break label237;
      }
      localObject2 = new String[j];
      i = 0;
      localObject1 = localObject2;
    } while (i >= j);
  }
  
  public ajkx a(String paramString, int paramInt, long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        asfl.a("HotchatSCMng", "getHotchatNote", new Object[] { "id is null or empty" });
        localObject2 = localObject1;
      }
    }
    ajky localajky;
    label267:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject2;
              localajky = (ajky)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
              localObject2 = localObject1;
            } while (localajky == null);
            localObject2 = localObject1;
          } while (localajky.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
          if (localajky.jdField_a_of_type_Int < 0)
          {
            if (this.jdField_a_of_type_JavaUtilComparator == null) {
              this.jdField_a_of_type_JavaUtilComparator = new ajku(this);
            }
            Collections.sort(localajky.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
            if (QLog.isDevelopLevel()) {
              asfl.a("HotchatSCMng", "sort start", new Object[] { paramString });
            }
            i = 0;
            if (i < localajky.jdField_a_of_type_JavaUtilArrayList.size())
            {
              localObject2 = (ajkx)localajky.jdField_a_of_type_JavaUtilArrayList.get(i);
              if (localObject2 == null) {}
              for (;;)
              {
                i += 1;
                break;
                if ((localajky.jdField_a_of_type_Int < 0) && (paramLong <= ((ajkx)localObject2).jdField_b_of_type_Long)) {}
                for (localajky.jdField_a_of_type_Int = i;; localajky.jdField_a_of_type_Int = i) {
                  do
                  {
                    if (!QLog.isDevelopLevel()) {
                      break label267;
                    }
                    asfl.a("HotchatSCMng", String.valueOf(i), new Object[] { localObject2 });
                    break;
                  } while ((paramLong > ((ajkx)localObject2).jdField_b_of_type_Long) || (!((ajkx)localObject2).jdField_a_of_type_Boolean));
                }
              }
            }
            if (localajky.jdField_a_of_type_Int < 0) {
              localajky.jdField_a_of_type_Int = localajky.jdField_a_of_type_JavaUtilArrayList.size();
            }
            if (QLog.isDevelopLevel()) {
              asfl.a("HotchatSCMng", "sort end", new Object[] { paramString });
            }
            if (QLog.isDevelopLevel()) {
              asfl.a("HotchatSCMng", "getHotchatNote", new Object[] { Integer.valueOf(localajky.jdField_a_of_type_Int) });
            }
          }
          localObject2 = localObject1;
        } while (localajky.jdField_a_of_type_Int < 0);
        localObject2 = localObject1;
      } while (localajky.jdField_a_of_type_Int >= localajky.jdField_a_of_type_JavaUtilArrayList.size());
      switch (paramInt)
      {
      default: 
        localObject1 = localObject3;
        localObject2 = localObject1;
      }
    } while (!QLog.isDevelopLevel());
    asfl.a("HotchatSCMng", "getHotchatNote", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localajky.jdField_a_of_type_Int), localObject1 });
    return localObject1;
    int i = localajky.jdField_a_of_type_Int;
    if (i < localajky.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (ajkx)localajky.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localObject1 == null) {}
      while ((((ajkx)localObject1).jdField_a_of_type_Boolean) || (paramLong < ((ajkx)localObject1).jdField_a_of_type_Long) || (paramLong > ((ajkx)localObject1).jdField_b_of_type_Long) || (!a((ajkx)localObject1)))
      {
        i += 1;
        break;
      }
      localajky.jdField_a_of_type_Int = i;
    }
    for (;;)
    {
      break;
      localObject2 = (ajkx)localajky.jdField_a_of_type_JavaUtilArrayList.get(localajky.jdField_a_of_type_Int);
      localObject1 = localObject3;
      if (paramLong < ((ajkx)localObject2).jdField_a_of_type_Long) {
        break;
      }
      localObject1 = localObject3;
      if (paramLong > ((ajkx)localObject2).jdField_b_of_type_Long) {
        break;
      }
      localObject1 = localObject3;
      if (!a((ajkx)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      break;
      i = localajky.jdField_a_of_type_Int;
      localObject1 = localObject3;
      if (i >= localajky.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      localObject1 = (ajkx)localajky.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localObject1 == null) {}
      while (((ajkx)localObject1).jdField_a_of_type_Boolean)
      {
        i += 1;
        break;
      }
      break;
      localObject1 = null;
    }
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 42	ajkt:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull -10 -> 13
    //   26: aload_0
    //   27: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: ifnull +13 -> 43
    //   33: aload_0
    //   34: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 251	java/lang/String:length	()I
    //   40: ifgt +105 -> 145
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 257	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 262	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: ldc_w 264
    //   61: invokevirtual 268	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   64: ifne +30 -> 94
    //   67: aload_0
    //   68: new 129	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 264
    //   85: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: putfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_0
    //   95: new 129	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 74
    //   111: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: putfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: getstatic 21	ajkt:jdField_a_of_type_Boolean	Z
    //   123: ifeq +22 -> 145
    //   126: ldc 93
    //   128: ldc_w 270
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 202	asfl:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 248	ajkt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: astore_1
    //   150: goto -137 -> 13
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	ajkt
    //   1	149	1	str	String
    //   153	4	1	localObject1	Object
    //   8	37	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	153	finally
    //   17	22	153	finally
    //   26	43	153	finally
    //   43	94	153	finally
    //   94	145	153	finally
    //   145	150	153	finally
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (this.b) {
        return;
      }
    }
    String[] arrayOfString = a();
    if (QLog.isColorLevel()) {
      if (arrayOfString != null) {
        break label103;
      }
    }
    label103:
    for (Object localObject2 = "null";; localObject2 = Integer.valueOf(arrayOfString.length))
    {
      asfl.a("HotchatSCMng", new Object[] { "initCache", localObject2 });
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label365;
      }
      localObject2 = a();
      if (localObject2 != null) {
        break;
      }
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.length() > 0))
        {
          ajkv localajkv = ajkv.a(str);
          if (localajkv != null)
          {
            for (;;)
            {
              try
              {
                if (new File((String)localObject2 + "/" + localajkv.c).exists()) {
                  break label290;
                }
                bool = a(localajkv, (String)localObject2);
                if (!bool) {
                  break;
                }
                a((String)localObject2 + "/" + localajkv.c);
              }
              catch (Exception localException)
              {
                if (!QLog.isColorLevel()) {
                  break label408;
                }
              }
              asfl.a("HotchatSCMng", new Object[] { "initCache", "parse config xml fail", localException.toString() });
              break label408;
              label290:
              boolean bool = true;
            }
            if (QLog.isColorLevel()) {
              asfl.a("HotchatSCMng", new Object[] { "initCache", "download config xml fail", localajkv });
            }
          }
          else if (QLog.isColorLevel())
          {
            asfl.a("HotchatSCMng", new Object[] { "initCache", "parse ConfigData fail", localException });
          }
        }
      }
      else
      {
        label365:
        this.b = true;
        if (QLog.isColorLevel()) {
          asfl.a("HotchatSCMng", new Object[] { "initCache", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashMap.size()) });
        }
        return;
      }
      label408:
      i += 1;
    }
  }
  
  public void a(ajkw paramajkw)
  {
    if (paramajkw == null) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break label105;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() != paramajkw)) {
            continue;
          }
          i = 1;
          if (i == 0)
          {
            paramajkw = new WeakReference(paramajkw);
            this.jdField_a_of_type_JavaUtilList.add(paramajkw);
          }
        }
        return;
      }
      label105:
      int i = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      asfl.a("HotchatSCMng", "parse", new Object[] { paramString });
    }
    BufferedInputStream localBufferedInputStream;
    String str2;
    for (;;)
    {
      XmlPullParser localXmlPullParser;
      try
      {
        paramString = new FileInputStream(paramString);
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        Object localObject1;
        paramString = null;
      }
      for (;;)
      {
        try
        {
          localBufferedInputStream = new BufferedInputStream(paramString);
          str2 = paramString;
          if (localBufferedInputStream == null) {
            continue;
          }
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          Object localObject2;
          boolean bool;
          Object localObject6;
          Object localObject5;
          continue;
          continue;
          if (i == 1) {
            continue;
          }
          switch (i)
          {
          }
          String str1 = paramString;
          paramString = localFileNotFoundException2;
          Object localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = paramString;
          paramString = localObject3;
          localObject3 = str1;
          break;
          str1 = "not null";
          continue;
        }
        try
        {
          localXmlPullParser = Xml.newPullParser();
          localXmlPullParser.setInput(localBufferedInputStream, "UTF-8");
          i = localXmlPullParser.getEventType();
          localObject1 = null;
          paramString = null;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          asfl.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        }
      }
      i = localXmlPullParser.next();
      Object localObject4 = paramString;
      paramString = localObject1;
      localObject1 = localObject4;
      break label913;
      localFileNotFoundException1.printStackTrace();
      localBufferedInputStream = null;
      str2 = paramString;
      continue;
      localObject4 = paramString;
      paramString = localFileNotFoundException1;
      localObject2 = localObject4;
      continue;
      localObject4 = localXmlPullParser.getName();
      if ("activity".equals(localObject4))
      {
        if (paramString == null)
        {
          localObject4 = new ajky();
          paramString = (String)localObject2;
          localObject2 = localObject4;
        }
        else
        {
          paramString.a();
          localObject4 = paramString;
          paramString = (String)localObject2;
          localObject2 = localObject4;
        }
      }
      else if ("note".equals(localObject4))
      {
        localObject4 = new ajkx();
        localObject2 = paramString;
        paramString = (String)localObject4;
      }
      else if ("activityid".equals(localObject4))
      {
        if (paramString == null) {
          break label948;
        }
        paramString.jdField_a_of_type_JavaLangString = localXmlPullParser.nextText();
        localObject4 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject4;
      }
      else if ("stime".equals(localObject4))
      {
        localObject4 = localXmlPullParser.nextText();
        if (localObject2 == null) {
          break label948;
        }
        ((ajkx)localObject2).jdField_a_of_type_Long = ajkx.a((String)localObject4);
        localObject4 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject4;
      }
      else
      {
        bool = "content".equals(localObject4);
        if (bool)
        {
          try
          {
            localObject6 = localXmlPullParser.nextText();
            localObject4 = localObject6;
            if (localObject6 != null) {
              localObject4 = ((String)localObject6).trim();
            }
            if (localObject2 != null) {
              ((ajkx)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject4);
            }
            localObject4 = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject4;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            if (!QLog.isColorLevel()) {
              break label961;
            }
          }
          asfl.a("HotchatSCMng", new Object[] { "parseNotice exception", localException1.toString() });
          break label961;
        }
        else if ("endtime".equals(localException1))
        {
          localObject5 = localXmlPullParser.nextText();
          if (localObject2 == null) {
            break label948;
          }
          ((ajkx)localObject2).jdField_b_of_type_Long = ajkx.a((String)localObject5);
          localObject5 = paramString;
          paramString = (String)localObject2;
          localObject2 = localObject5;
        }
        else
        {
          bool = "url".equals(localObject5);
          if (!bool) {
            break label948;
          }
          try
          {
            localObject6 = localXmlPullParser.nextText();
            localObject5 = localObject6;
            if (localObject6 != null) {
              localObject5 = ((String)localObject6).trim();
            }
            if ((localObject5 == null) || (((String)localObject5).startsWith("http://")) || (((String)localObject5).contains("&"))) {
              break label910;
            }
            localObject5 = new String(Base64.decode(((String)localObject5).getBytes(), 0));
            if (localObject2 != null) {
              ((ajkx)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject5);
            }
            localObject5 = paramString;
            paramString = (String)localObject2;
            localObject2 = localObject5;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            if (!QLog.isColorLevel()) {
              break label974;
            }
          }
          asfl.a("HotchatSCMng", new Object[] { "parseNotice exception", localException2.toString() });
          break label974;
          if ("activity".equals(localXmlPullParser.getName()))
          {
            if ((paramString == null) || (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))) {
              break label948;
            }
            localObject6 = (ajky)this.jdField_a_of_type_JavaUtilHashMap.get(paramString.jdField_a_of_type_JavaLangString);
            if (jdField_a_of_type_Boolean)
            {
              if (localObject6 != null) {
                break label1000;
              }
              str1 = "null";
              asfl.a("HotchatSCMng", "parse", new Object[] { str1, paramString });
            }
            if (localObject6 == null)
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(paramString.jdField_a_of_type_JavaLangString, paramString);
              paramString = null;
              break label987;
            }
            ((ajky)localObject6).jdField_a_of_type_Int = -1;
            ((ajky)localObject6).jdField_a_of_type_JavaUtilArrayList.addAll(paramString.jdField_a_of_type_JavaUtilArrayList);
            paramString.a();
            break label987;
          }
          if ((!"note".equals(localXmlPullParser.getName())) || (localObject2 == null) || (paramString == null)) {
            break label948;
          }
          paramString.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          localObject2 = paramString;
          paramString = null;
        }
      }
    }
    if (localBufferedInputStream != null) {}
    try
    {
      localBufferedInputStream.close();
      if (str2 == null) {}
    }
    catch (Exception paramString)
    {
      try
      {
        do
        {
          str2.close();
          return;
          paramString = paramString;
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        asfl.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
        } while (!QLog.isColorLevel());
        asfl.a("HotchatSCMng", new Object[] { "parseNotice exception", paramString.toString() });
        return;
      }
    }
  }
  
  public boolean a(ajkv paramajkv, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramajkv != null)
    {
      if (TextUtils.isEmpty(paramajkv.jdField_a_of_type_JavaLangString)) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    if (QLog.isColorLevel()) {
      asfl.a("HotchatSCMng", new Object[] { "download", paramajkv });
    }
    paramString = new File(paramString + "/" + paramajkv.c);
    String str;
    if (paramString.exists()) {
      if (!TextUtils.isEmpty(paramajkv.jdField_b_of_type_JavaLangString))
      {
        str = MD5.getFileMD5(paramString);
        bool2 = paramajkv.jdField_b_of_type_JavaLangString.equals(str);
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            asfl.a("download", new Object[] { "cache md5 confilict", str, paramajkv.jdField_b_of_type_JavaLangString });
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      label167:
      if (!bool1)
      {
        bool2 = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramajkv.jdField_a_of_type_JavaLangString, paramString);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramajkv.jdField_b_of_type_JavaLangString))
          {
            str = MD5.getFileMD5(paramString);
            bool2 = paramajkv.jdField_b_of_type_JavaLangString.equals(str);
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                asfl.a("download", new Object[] { "md5 conflict", paramajkv.jdField_b_of_type_JavaLangString, str });
                bool1 = bool2;
              }
            }
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          bool2 = bool1;
          try
          {
            if (!paramString.exists()) {
              break;
            }
            paramString.delete();
            return bool1;
          }
          catch (Exception paramajkv)
          {
            paramajkv.printStackTrace();
            return bool1;
          }
        }
        bool1 = true;
        break label167;
      }
      bool1 = false;
    }
  }
  
  public boolean a(ajkx paramajkx)
  {
    boolean bool;
    if ((paramajkx == null) || (TextUtils.isEmpty(paramajkx.jdField_b_of_type_JavaLangString))) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        asfl.a("HotchatSCMng", new Object[] { "checkHasGrabHbTask", paramajkx, Boolean.valueOf(bool) });
      }
      return bool;
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
      if ((localPortalManager != null) && (localPortalManager.b())) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean a(ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null) {
      return false;
    }
    String str1;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      str1 = a();
      if (str1 == null) {
        return false;
      }
    }
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject3 = new File(str1);
        if (((File)localObject3).exists())
        {
          localObject4 = ((File)localObject3).list();
          if ((localObject4 != null) && (localObject4.length > 0)) {
            localObject3 = new ArrayList(localObject4.length);
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject3;
        Object localObject4;
        int j;
        int i;
        String str2;
        ajkv localajkv;
        boolean bool3;
        Object localObject2;
        continue;
        if (bool2) {
          continue;
        }
        boolean bool1 = false;
        continue;
        boolean bool2 = false;
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        j = localObject4.length;
        i = 0;
        localObject1 = localObject3;
        if (i < j)
        {
          localObject1 = localObject4[i];
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
            ((List)localObject3).add(localObject1);
          }
          i += 1;
          continue;
          localObject1 = null;
        }
        localObject3 = new HashSet();
        if (!paramConfig.content_list.has()) {
          continue;
        }
        localObject4 = paramConfig.content_list.get();
        if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
          continue;
        }
        bool1 = true;
        i = 0;
      }
      catch (Exception localException3)
      {
        localObject2 = localObject3;
        localObject3 = localException3;
        continue;
        i += 1;
        continue;
      }
      bool2 = bool1;
      if (i >= ((List)localObject4).size()) {
        continue;
      }
      str2 = (String)((List)localObject4).get(i);
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content: " + str2 + ",version: " + paramConfig.version.get());
      }
      if (str2 == null) {
        continue;
      }
      if (str2.length() != 0) {
        continue;
      }
      continue;
      ((Exception)localObject3).printStackTrace();
    }
    localajkv = ajkv.a(str2);
    if (localajkv != null)
    {
      ((Set)localObject3).add(str2);
      bool3 = a(localajkv, str1);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        ((List)localObject1).remove(localajkv.c);
      }
      bool2 = bool3;
      if (this.b)
      {
        a(str1 + "/" + localajkv.c);
        bool2 = bool3;
        break label619;
        if (!QLog.isColorLevel()) {
          break label636;
        }
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 49,content_list is empty ,version: " + paramConfig.version.get());
        break label636;
        a((Set)localObject3);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          paramConfig = ((List)localObject1).iterator();
          while (paramConfig.hasNext())
          {
            localObject1 = (String)paramConfig.next();
            try
            {
              new File(str1 + "/" + (String)localObject1).delete();
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          asfl.a("HotchatSCMng", "updateHotChatSceneConfig", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(this.b) });
        }
        return bool2;
      }
    }
  }
  
  public void b(ajkw paramajkw)
  {
    if (paramajkw == null) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localWeakReference == null) || (localWeakReference.get() != paramajkw)) {
              break label91;
            }
            this.jdField_a_of_type_JavaUtilList.remove(i);
            break label91;
          }
        }
        return;
      }
      label91:
      i -= 1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajkt
 * JD-Core Version:    0.7.0.1
 */