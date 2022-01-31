import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Looper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.1;
import com.tencent.mobileqq.activity.photo.MediaScanner.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class agmi
{
  private static agmi jdField_a_of_type_Agmi;
  public static AtomicBoolean a;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private aglw jdField_a_of_type_Aglw;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<FileObserver> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  private HashSet<String> c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private agmi() {}
  
  private agmi(Context paramContext)
  {
    this.jdField_a_of_type_Aglw = aglw.a(paramContext);
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangString = paramContext.getAbsolutePath();
    }
    if (this.jdField_a_of_type_Aglw != null) {
      this.c = this.jdField_a_of_type_Aglw.a();
    }
  }
  
  public static agmi a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Agmi == null) {
        jdField_a_of_type_Agmi = new agmi(paramContext);
      }
      paramContext = jdField_a_of_type_Agmi;
      return paramContext;
    }
    finally {}
  }
  
  @TargetApi(10)
  private agmn a(MediaMetadataRetriever paramMediaMetadataRetriever, String paramString1, String paramString2)
  {
    paramMediaMetadataRetriever = new File(paramString2);
    if (paramMediaMetadataRetriever.exists()) {
      try
      {
        agmn localagmn = new agmn();
        localagmn.jdField_c_of_type_Long = 0L;
        localagmn.jdField_b_of_type_Long = (paramMediaMetadataRetriever.lastModified() / 1000L);
        localagmn.jdField_a_of_type_Long = paramMediaMetadataRetriever.length();
        localagmn.jdField_a_of_type_JavaLangString = paramString2.substring(paramString2.lastIndexOf("/") + 1);
        localagmn.jdField_c_of_type_JavaLangString = paramString2;
        localagmn.jdField_b_of_type_JavaLangString = paramString1;
        localagmn.d = "video/mp4";
        localagmn.e = String.valueOf(localagmn.jdField_a_of_type_Long);
        return localagmn;
      }
      catch (Exception paramMediaMetadataRetriever)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaScanner", 2, "createMediaScannerInfo() error=" + paramMediaMetadataRetriever.getMessage());
        }
      }
    }
    return null;
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
    String str = localMediaMetadataRetriever.extractMetadata(9);
    label285:
    label417:
    label424:
    for (;;)
    {
      char[] arrayOfChar;
      int m;
      int i;
      int k;
      char c1;
      try
      {
        paramLocalMediaInfo.mDuration = Long.parseLong(str);
        if (Build.VERSION.SDK_INT >= 17) {
          str = localMediaMetadataRetriever.extractMetadata(24);
        }
        try
        {
          paramLocalMediaInfo.rotation = Integer.parseInt(str);
          Object localObject;
          if (Build.VERSION.SDK_INT >= 14)
          {
            str = localMediaMetadataRetriever.extractMetadata(18);
            localObject = localMediaMetadataRetriever.extractMetadata(19);
          }
          try
          {
            paramLocalMediaInfo.mediaWidth = Integer.parseInt(str);
            paramLocalMediaInfo.mediaHeight = Integer.parseInt((String)localObject);
            StringBuilder localStringBuilder;
            if (Build.VERSION.SDK_INT >= 15)
            {
              str = localMediaMetadataRetriever.extractMetadata(23);
              if (str != null)
              {
                label221:
                try
                {
                  localObject = new ArrayList(3);
                  localStringBuilder = new StringBuilder();
                  arrayOfChar = str.toCharArray();
                  m = arrayOfChar.length;
                  i = 0;
                  k = 0;
                }
                catch (NumberFormatException paramLocalMediaInfo) {}
                int j = i;
                if (localStringBuilder.length() > 0)
                {
                  ((ArrayList)localObject).add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder.toString()) * 1000000.0D)));
                  localStringBuilder.setLength(0);
                  j = i + 1;
                }
                localStringBuilder.append(c1);
                i = j;
                break label417;
                if ((!Character.isDigit(c1)) && (c1 != '.')) {
                  continue;
                }
                localStringBuilder.append(c1);
                break label417;
              }
            }
            localMediaMetadataRetriever.release();
            return;
            QLog.e("MediaScanner", 2, "Can not under stand the location string: " + str + " !");
            break label417;
            if (localStringBuilder.length() > 0) {
              ((ArrayList)localObject).add(Integer.valueOf((int)(Double.parseDouble(localStringBuilder.toString()) * 1000000.0D)));
            }
            if (((ArrayList)localObject).size() < 2) {
              continue;
            }
            paramLocalMediaInfo.latitude = ((Integer)((ArrayList)localObject).get(0)).intValue();
            paramLocalMediaInfo.longitude = ((Integer)((ArrayList)localObject).get(1)).intValue();
            continue;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            continue;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        continue;
      }
      for (;;)
      {
        if (k >= m) {
          break label424;
        }
        c1 = arrayOfChar[k];
        if (i >= 2) {
          break label285;
        }
        if ((c1 == '+') || (c1 == '-') || (c1 == '\n')) {
          break;
        }
        if (c1 != 0) {
          break label221;
        }
        break;
        k += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists())) {}
    while (this.jdField_b_of_type_JavaUtilHashSet.contains(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashSet.add(paramString);
    paramString = new agml(jdField_a_of_type_Agmi, paramString);
    paramString.startWatching();
    this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
  }
  
  @TargetApi(10)
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "doScanFolder() folderPath=" + paramString);
    }
    if (localObject == null) {}
    label47:
    label332:
    do
    {
      do
      {
        do
        {
          break label47;
          do
          {
            return;
          } while (this.jdField_a_of_type_Aglw == null);
          if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
            break label332;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MediaScanner", 2, "doScanFolder() videoFolder.exists()=true");
          }
          if ((!paramBoolean) || (a(paramString))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaScanner", 2, "doScanFolder() isNomediaFileExisit()=false, return");
        return;
      } while (b(paramString) != true);
      localObject = ((File)localObject).listFiles();
      HashSet localHashSet = this.jdField_a_of_type_Aglw.a(paramString);
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          agmn localagmn = localObject[i];
          String str;
          if (localagmn.getName().endsWith(".mp4"))
          {
            str = paramString + "/" + localagmn.getName();
            if ((localHashSet.contains(str)) || (this.c == null) || (this.c.contains(String.valueOf(localagmn.length())))) {
              break label297;
            }
            localagmn = a(null, paramString, str);
            if (localagmn != null)
            {
              localArrayList.add(localagmn);
              this.c.add(String.valueOf(localagmn.jdField_a_of_type_Long));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localHashSet.remove(str);
          }
        }
      }
      this.jdField_a_of_type_Aglw.b(localHashSet);
      this.jdField_a_of_type_Aglw.a(localArrayList);
      b(paramString);
      return;
    } while (!QLog.isColorLevel());
    label297:
    QLog.d("MediaScanner", 2, "doScanFolder() videoFolder.exists() = false");
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "isNomediaFileExisit() folderpath=" + paramString + ", mExternalStorageDirectoryPath=" + this.jdField_a_of_type_JavaLangString);
    }
    if (new File(this.jdField_a_of_type_JavaLangString).equals(new File(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "isNomediaFileExisit() root folder, return false");
      }
      bool = false;
    }
    File localFile;
    do
    {
      return bool;
      localFile = new File(paramString + "/.nomedia");
      if (localFile.exists() != true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MediaScanner", 2, "isNomediaFileExisit() nomediaFile=" + localFile + " exist, return true");
    return true;
    return a(new File(paramString).getParent());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aglw == null) {}
    HashSet localHashSet;
    Iterator localIterator;
    do
    {
      return;
      localHashSet = this.jdField_a_of_type_Aglw.b();
      localIterator = localHashSet.iterator();
    } while ((localHashSet == null) || (localIterator == null));
    while (localIterator.hasNext())
    {
      File localFile = new File((String)localIterator.next());
      if ((localFile != null) && (localFile.exists())) {
        localIterator.remove();
      }
    }
    this.jdField_a_of_type_Aglw.a(localHashSet);
  }
  
  private void b(String paramString)
  {
    Object localObject = new File(paramString);
    if (localObject == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
          l = ((File)localObject).lastModified();
          localObject = this.jdField_a_of_type_Aglw.a(paramString);
          if (localObject == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MediaScanner", 2, "needScanFolder() lastModified=" + l + ", info.modifiedDate=" + ((agmm)localObject).jdField_a_of_type_Long);
          }
        } while (l <= ((agmm)localObject).jdField_a_of_type_Long);
        ((agmm)localObject).jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Aglw.a((agmm)localObject);
      } while (!QLog.isColorLevel());
      QLog.d("MediaScanner", 2, "needScanFolder() lastModified > info.modifiedDate , run updateMediaScnnerFolderInfo()");
      return;
      localObject = new agmm();
      ((agmm)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((agmm)localObject).jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Aglw.b((agmm)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("MediaScanner", 2, "updateScanFolderInfo() run insertMediaScnnerFolderInfo()");
  }
  
  private boolean b(String paramString)
  {
    long l = new File(paramString).lastModified();
    paramString = this.jdField_a_of_type_Aglw.a(paramString);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "needScanFolder() lastModified=" + l + ", info.modifiedDate=" + paramString.jdField_a_of_type_Long);
      }
      if (l == paramString.jdField_a_of_type_Long) {
        return false;
      }
    }
    return true;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Aglw == null)) {}
    for (;;)
    {
      return;
      String str = this.jdField_a_of_type_JavaLangString + "/tencent/MicroMsg";
      File[] arrayOfFile = new File(str).listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfFile[i];
          if ((((File)localObject).isDirectory()) && (((File)localObject).getName().length() == 32))
          {
            localObject = str + "/" + ((File)localObject).getName() + "/video";
            a((String)localObject, true);
            a((String)localObject);
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 44	agmi:jdField_a_of_type_Aglw	Laglw;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: ldc_w 399
    //   20: invokestatic 402	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   23: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq -13 -> 13
    //   29: aload_0
    //   30: getfield 44	agmi:jdField_a_of_type_Aglw	Laglw;
    //   33: invokevirtual 405	aglw:a	()I
    //   36: istore_1
    //   37: goto -24 -> 13
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	agmi
    //   1	36	1	i	int
    //   8	2	2	localaglw	aglw
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	40	finally
    //   17	37	40	finally
  }
  
  /* Error */
  public ArrayList<agmn> a(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 44	agmi:jdField_a_of_type_Aglw	Laglw;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +7 -> 22
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: ldc_w 399
    //   25: invokestatic 402	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   28: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq -13 -> 18
    //   34: aload 4
    //   36: astore_3
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpeq +8 -> 47
    //   42: iload_2
    //   43: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   46: astore_3
    //   47: iload_1
    //   48: ifne +15 -> 63
    //   51: aload_0
    //   52: getfield 44	agmi:jdField_a_of_type_Aglw	Laglw;
    //   55: aload_3
    //   56: invokevirtual 411	aglw:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   59: astore_3
    //   60: goto -42 -> 18
    //   63: aload_0
    //   64: getfield 44	agmi:jdField_a_of_type_Aglw	Laglw;
    //   67: aload_3
    //   68: invokevirtual 413	aglw:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   71: astore_3
    //   72: goto -54 -> 18
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	agmi
    //   0	80	1	paramBoolean	boolean
    //   0	80	2	paramInt	int
    //   4	68	3	localObject1	Object
    //   75	4	3	localObject2	Object
    //   1	34	4	localObject3	Object
    //   11	3	5	localaglw	aglw
    // Exception table:
    //   from	to	target	type
    //   7	13	75	finally
    //   22	34	75	finally
    //   42	47	75	finally
    //   51	60	75	finally
    //   63	72	75	finally
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        if (!bool) {
          return;
        }
        if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() == true) || (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          continue;
        }
        jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        if (QLog.isColorLevel()) {
          QLog.d("MediaScanner", 2, "doScan() start");
        }
      }
      finally {}
      try
      {
        b();
        c();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        continue;
      }
      finally
      {
        jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "doScan() finish");
      }
    }
  }
  
  @TargetApi(10)
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaScanner", 2, "handleFileObserverEvent() is called event=" + paramInt);
    }
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        do
        {
          File localFile;
          do
          {
            return;
            switch (paramInt)
            {
            default: 
              return;
            case 8: 
            case 128: 
              paramString2 = paramString1 + "/" + paramString2;
              localFile = new File(paramString2);
              if ((this.c == null) && (this.jdField_a_of_type_Aglw != null)) {
                this.c = this.jdField_a_of_type_Aglw.a();
              }
              break;
            }
          } while ((this.c == null) || (this.jdField_a_of_type_Aglw == null));
          if (!localFile.exists()) {
            break;
          }
          paramString1 = a(null, paramString1, paramString2);
          if ((paramString1 != null) && (!this.c.contains(paramString1.e)))
          {
            this.c.add(paramString1.e);
            this.jdField_a_of_type_Aglw.a(paramString1);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaScanner", 2, "handleFileObserverEvent() info=null");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("MediaScanner", 2, "handleFileObserverEvent() mMd5Set.contains( md5 ) = true");
      return;
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new File(paramString1);
    } while ((paramString2 == null) || (paramString2.exists() == true) || (this.jdField_a_of_type_Aglw == null));
    paramString2 = new HashSet();
    paramString2.add(paramString1);
    this.jdField_a_of_type_Aglw.b(paramString2);
  }
  
  @TargetApi(10)
  public void a(agmj paramagmj, LocalMediaInfo paramLocalMediaInfo)
  {
    paramagmj = new WeakReference(paramagmj);
    paramagmj = new MediaScanner.2(this, new WeakReference(paramLocalMediaInfo), paramagmj);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(paramagmj, 64, null, true);
      return;
    }
    paramagmj.run();
  }
  
  @TargetApi(10)
  public void a(agmk paramagmk, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    paramagmk = new WeakReference(paramagmk);
    ThreadManager.post(new MediaScanner.1(this, new WeakReference(paramLocalMediaInfo), paramagmk, paramInt), 5, null, true);
  }
  
  public void b(LocalMediaInfo paramLocalMediaInfo)
  {
    a(paramLocalMediaInfo);
    this.jdField_a_of_type_Aglw.a(paramLocalMediaInfo.path, paramLocalMediaInfo.mDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmi
 * JD-Core Version:    0.7.0.1
 */