package com.tencent.ttpic.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoStorageProxy
{
  private static final String COLON = ":";
  private static final String DEV_MOUNT = "dev_mount";
  private static final String READ_COMMAND = "cat /etc/vold.fstab";
  private static final String TAG = VideoStorageProxy.class.getSimpleName();
  private static final String VOLD_FSTAB_FILE = "/etc/vold.fstab";
  
  public static ArrayList<String> getAvailableStorage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = getExternalStoragePathEx(paramContext); (paramContext == null) || (paramContext.size() == 0); paramContext = readEtcFstabFile()) {
      return null;
    }
    Iterator localIterator = paramContext.iterator();
    while (localIterator.hasNext()) {
      if (!new File((String)localIterator.next()).exists()) {
        localIterator.remove();
      }
    }
    return paramContext;
  }
  
  private static ArrayList<String> getExternalStoragePathEx(Context paramContext)
  {
    Object localObject = (StorageManager)paramContext.getSystemService("storage");
    Class localClass = localObject.getClass();
    paramContext = new ArrayList(5);
    try
    {
      localObject = (String[])localClass.getMethod("getVolumePaths", null).invoke(localObject, null);
      new StringBuilder("paths.size = ").append(localObject.length);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramContext.add(removePathColon(localObject[i]));
        i += 1;
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  private static ArrayList<String> readEtcFstabFile()
  {
    // Byte code:
    //   0: new 136	java/io/BufferedReader
    //   3: dup
    //   4: new 138	java/io/InputStreamReader
    //   7: dup
    //   8: invokestatic 144	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: ldc 14
    //   13: invokevirtual 148	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   16: invokevirtual 154	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   19: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: new 45	java/util/ArrayList
    //   29: dup
    //   30: iconst_5
    //   31: invokespecial 101	java/util/ArrayList:<init>	(I)V
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_3
    //   43: ifnull +55 -> 98
    //   46: aload_3
    //   47: ldc 165
    //   49: invokevirtual 169	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifne -17 -> 35
    //   55: aload_3
    //   56: ldc 11
    //   58: invokevirtual 173	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifeq -26 -> 35
    //   64: aload_3
    //   65: ldc 175
    //   67: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -37 -> 35
    //   75: aload_0
    //   76: arraylength
    //   77: iconst_3
    //   78: if_icmplt -43 -> 35
    //   81: aload_1
    //   82: aload_0
    //   83: iconst_2
    //   84: aaload
    //   85: invokestatic 128	com/tencent/ttpic/util/VideoStorageProxy:removePathColon	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -57 -> 35
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	42	0	localObject	Object
    //   95	1	0	localIOException	java.io.IOException
    //   97	2	0	localArrayList	ArrayList<String>
    //   34	48	1	localArrayList1	ArrayList
    //   25	11	2	localBufferedReader	java.io.BufferedReader
    //   39	26	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	35	95	java/io/IOException
    //   35	40	95	java/io/IOException
    //   46	71	95	java/io/IOException
    //   75	92	95	java/io/IOException
  }
  
  private static String removePathColon(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf(":");
    } while (i == -1);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoStorageProxy
 * JD-Core Version:    0.7.0.1
 */