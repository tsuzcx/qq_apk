import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArNativeSoManager.1;
import com.tencent.mobileqq.ar.ArNativeSoManager.3;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;>;
import mqq.os.MqqHandler;

public class aknp
{
  aktx jdField_a_of_type_Aktx;
  private WeakReference<akuc> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<akuc> b;
  private WeakReference<akuc> c;
  private WeakReference<akuc> d;
  
  public aknp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aktx = new aktx(paramQQAppInterface);
  }
  
  private akuc a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString.equalsIgnoreCase("arsdk2"))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        localObject1 = (akuc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
    }
    do
    {
      akqt localakqt;
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject1;
              if (!paramString.equalsIgnoreCase("arcloud")) {
                break;
              }
              localObject1 = localObject2;
            } while (this.b == null);
            return (akuc)this.b.get();
            if (!paramString.equalsIgnoreCase("arfeature")) {
              break;
            }
            localObject1 = localObject2;
          } while (this.d == null);
          return (akuc)this.d.get();
          localakqt = akqp.a();
          localObject1 = localObject2;
        } while (localakqt == null);
        localObject1 = localObject2;
      } while (!paramString.equalsIgnoreCase(localakqt.a()));
      localObject1 = localObject2;
    } while (this.c == null);
    return (akuc)this.c.get();
  }
  
  private String a(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return "v7.9.5.1";
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return "v7.9.5.1";
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return "v8.0.0";
    }
    akqt localakqt = akqp.a();
    if ((localakqt != null) && (paramString.equalsIgnoreCase(localakqt.a()))) {
      return localakqt.b();
    }
    return "";
  }
  
  private void a(ARCommonConfigInfo.NativeSoRes paramNativeSoRes, akud paramakud)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes. fileName = " + paramakud.c + ", url = " + paramakud.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aktx == null) {
      return;
    }
    this.jdField_a_of_type_Aktx.a(paramakud, new aknr(this, paramNativeSoRes));
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private void a(String paramString, akuc paramakuc)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakuc);
    }
    akqt localakqt;
    do
    {
      return;
      if (paramString.equalsIgnoreCase("arcloud"))
      {
        this.b = new WeakReference(paramakuc);
        return;
      }
      if (paramString.equalsIgnoreCase("arfeature"))
      {
        this.d = new WeakReference(paramakuc);
        return;
      }
      localakqt = akqp.a();
    } while ((localakqt == null) || (!paramString.equalsIgnoreCase(localakqt.a())));
    this.c = new WeakReference(paramakuc);
  }
  
  private boolean a(String paramString)
  {
    if (paramString.equalsIgnoreCase("arsdk2")) {
      return aknx.a();
    }
    if (paramString.equalsIgnoreCase("arcloud")) {
      return akna.a();
    }
    if (paramString.equalsIgnoreCase("arfeature")) {
      return aknm.a();
    }
    akqt localakqt = akqp.a();
    if ((localakqt != null) && (paramString.equalsIgnoreCase(localakqt.a()))) {
      return akqp.b(localakqt);
    }
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    int i = 0;
    QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. dir = " + paramString1 + ", excludeSubDirOrFile = " + paramString2);
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    if (i < paramString1.length)
    {
      Object localObject = paramString1[i];
      if (!localObject.getAbsolutePath().equalsIgnoreCase(paramString2)) {
        if (localObject.isDirectory())
        {
          bool = a(localObject.getAbsolutePath(), paramString2);
          if (bool)
          {
            QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
            bool = true;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. delete dir or file = " + localObject.getAbsolutePath());
        localObject.delete();
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = " + localObject.getAbsolutePath());
        bool = true;
      }
    }
    return bool;
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, akuc paramakuc)
  {
    boolean bool = false;
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadArNativeSo. resName = " + paramString);
    String str = a(paramString);
    a(paramString, paramakuc);
    Object localObject1 = new ARCommonConfigInfo.NativeSoRes();
    int i = 0;
    Object localObject2;
    if (i < paramArrayList.size())
    {
      localObject2 = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
      if ((((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject2).b.equalsIgnoreCase(str)))
      {
        paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject2;
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Aktx != null))
      {
        localObject1 = akno.a(paramArrayList.jdField_a_of_type_JavaLangString, paramArrayList.b, paramArrayList.d) + File.separator + paramArrayList.d + ".zip";
        if (!b((String)localObject1, paramArrayList.d))
        {
          a((String)localObject1);
          if ((!TextUtils.isEmpty(paramArrayList.c)) && (!TextUtils.isEmpty(paramArrayList.d)))
          {
            localObject2 = new akud();
            ((akud)localObject2).jdField_a_of_type_Int = 5;
            ((akud)localObject2).jdField_a_of_type_JavaLangString = paramArrayList.c;
            ((akud)localObject2).b = paramArrayList.d;
            ((akud)localObject2).d = paramArrayList.jdField_a_of_type_JavaLangString;
            ((akud)localObject2).c = ((String)localObject1);
            ((akud)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Aktx.a((akud)localObject2, new aknq(this, paramString, paramakuc));
          }
        }
      }
      label370:
      while (paramakuc == null)
      {
        do
        {
          do
          {
            do
            {
              return;
              i += 1;
              break;
              QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + (String)localObject1);
            } while (paramakuc == null);
            paramakuc.a(false, null);
            return;
            if (a(paramString)) {
              break label370;
            }
            i = a(paramString, (String)localObject1, paramArrayList.d);
          } while (paramakuc == null);
          if (i == 0) {
            bool = true;
          }
          paramakuc.a(bool, null);
          return;
        } while (paramakuc == null);
        paramakuc.a(true, null);
        return;
      }
      paramakuc.a(false, null);
      return;
      i = 0;
      paramArrayList = (ArrayList<ARCommonConfigInfo.NativeSoRes>)localObject1;
    }
  }
  
  private void b(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. resName = " + paramString);
    String str1 = a(paramString);
    int i = 0;
    if (i < paramArrayList2.size())
    {
      ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList2.get(i);
      String str2;
      if (localNativeSoRes.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
        if (localNativeSoRes.b.equalsIgnoreCase(str1))
        {
          str2 = akno.a(localNativeSoRes.jdField_a_of_type_JavaLangString, localNativeSoRes.b, localNativeSoRes.d) + File.separator + localNativeSoRes.d + ".zip";
          if (!b(str2, localNativeSoRes.d))
          {
            a(str2);
            if ((!TextUtils.isEmpty(localNativeSoRes.c)) && (!TextUtils.isEmpty(localNativeSoRes.d)))
            {
              int j = 0;
              while (j < paramArrayList1.size())
              {
                localObject = (ARCommonConfigInfo.NativeSoRes)paramArrayList1.get(j);
                if ((((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) && (((ARCommonConfigInfo.NativeSoRes)localObject).b.equalsIgnoreCase(str1))) {
                  a(akno.a(((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString), akno.a(((ARCommonConfigInfo.NativeSoRes)localObject).jdField_a_of_type_JavaLangString, ((ARCommonConfigInfo.NativeSoRes)localObject).b, ((ARCommonConfigInfo.NativeSoRes)localObject).d));
                }
                j += 1;
              }
              Object localObject = new akud();
              ((akud)localObject).jdField_a_of_type_Int = 5;
              ((akud)localObject).jdField_a_of_type_JavaLangString = localNativeSoRes.c;
              ((akud)localObject).b = localNativeSoRes.d;
              ((akud)localObject).d = localNativeSoRes.jdField_a_of_type_JavaLangString;
              ((akud)localObject).c = str2;
              ((akud)localObject).jdField_a_of_type_Boolean = true;
              a(localNativeSoRes, (akud)localObject);
            }
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. TextUtils.isEmpty(nativeSoRes.url) || TextUtils.isEmpty(nativeSoRes.md5), not need to download. soZipFilename = " + str2);
        continue;
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soRes exists, not need to download. soZipFilename = " + str2);
        if (a(paramString, str2, localNativeSoRes.d) == 0)
        {
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResVersion is not need to download. soResName = " + localNativeSoRes.jdField_a_of_type_JavaLangString + ", soResVersionFromConfig = " + localNativeSoRes.b + ", soResVersionFromLocal = " + str1);
          continue;
          QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoResIfNeed. soResName is not need to download. soResName = " + localNativeSoRes.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(attn.a(paramString1)))
      {
        QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. check md5 failed. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.i("AREngine_ArNativeSoManager", 1, "checkFileValid failed. file is not exist. filename = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  /* Error */
  public int a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 29
    //   5: invokevirtual 35	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   8: ifeq +15 -> 23
    //   11: aload_2
    //   12: aload_3
    //   13: invokestatic 270	aknx:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: istore 4
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: aload_1
    //   24: ldc 47
    //   26: invokevirtual 35	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   29: ifeq +13 -> 42
    //   32: aload_2
    //   33: aload_3
    //   34: invokestatic 271	akna:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: istore 4
    //   39: goto -21 -> 18
    //   42: aload_1
    //   43: ldc 51
    //   45: invokevirtual 35	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   48: ifeq +13 -> 61
    //   51: aload_2
    //   52: aload_3
    //   53: invokestatic 272	aknm:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: istore 4
    //   58: goto -40 -> 18
    //   61: invokestatic 58	akqp:a	()Lakqt;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +29 -> 97
    //   71: aload_1
    //   72: aload 5
    //   74: invokeinterface 63 1 0
    //   79: invokevirtual 35	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +15 -> 97
    //   85: aload 5
    //   87: aload_2
    //   88: aload_3
    //   89: invokestatic 275	akqp:a	(Lakqt;Ljava/lang/String;Ljava/lang/String;)I
    //   92: istore 4
    //   94: goto -76 -> 18
    //   97: iconst_m1
    //   98: istore 4
    //   100: goto -82 -> 18
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	aknp
    //   0	108	1	paramString1	String
    //   0	108	2	paramString2	String
    //   0	108	3	paramString3	String
    //   16	83	4	i	int
    //   64	22	5	localakqt	akqt
    // Exception table:
    //   from	to	target	type
    //   2	18	103	finally
    //   23	39	103	finally
    //   42	58	103	finally
    //   61	66	103	finally
    //   71	94	103	finally
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString, akuc paramakuc)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.1(this, paramArrayList, paramString, paramakuc));
  }
  
  public void a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList1, ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList2, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new ArNativeSoManager.3(this, paramArrayList1, paramArrayList2, paramString));
  }
  
  public boolean a(ArrayList<ARCommonConfigInfo.NativeSoRes> paramArrayList, String paramString)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "isArNativeSoDownload. resName = " + paramString);
    String str = a(paramString);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        ARCommonConfigInfo.NativeSoRes localNativeSoRes = (ARCommonConfigInfo.NativeSoRes)paramArrayList.get(i);
        if ((!localNativeSoRes.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) || (!localNativeSoRes.b.equalsIgnoreCase(str))) {
          break label155;
        }
        paramArrayList = akno.a(localNativeSoRes.jdField_a_of_type_JavaLangString, localNativeSoRes.b, localNativeSoRes.d) + File.separator + localNativeSoRes.d + ".zip";
        if (!b(paramArrayList, localNativeSoRes.d)) {
          a(paramArrayList);
        }
      }
      else
      {
        return false;
      }
      return a(paramString);
      label155:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aknp
 * JD-Core Version:    0.7.0.1
 */