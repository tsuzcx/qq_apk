package com.tencent.ttpic.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoStorageProxy
{
  private static final String COLON = ":";
  private static final String DEV_MOUNT = "dev_mount";
  private static final String READ_COMMAND = "cat /etc/vold.fstab";
  private static final String TAG;
  private static final String VOLD_FSTAB_FILE = "/etc/vold.fstab";
  
  static
  {
    AppMethodBeat.i(84228);
    TAG = VideoStorageProxy.class.getSimpleName();
    AppMethodBeat.o(84228);
  }
  
  public static ArrayList<String> getAvailableStorage(Context paramContext)
  {
    AppMethodBeat.i(84226);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = getExternalStoragePathEx(paramContext); (paramContext == null) || (paramContext.size() == 0); paramContext = readEtcFstabFile())
    {
      AppMethodBeat.o(84226);
      return null;
    }
    Iterator localIterator = paramContext.iterator();
    while (localIterator.hasNext()) {
      if (!new File((String)localIterator.next()).exists()) {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(84226);
    return paramContext;
  }
  
  private static ArrayList<String> getExternalStoragePathEx(Context paramContext)
  {
    AppMethodBeat.i(84225);
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
      AppMethodBeat.o(84225);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(84225);
    }
    return null;
  }
  
  private static ArrayList<String> readEtcFstabFile()
  {
    AppMethodBeat.i(84224);
    ArrayList localArrayList;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /etc/vold.fstab").getInputStream()));
      localArrayList = new ArrayList(5);
      for (;;)
      {
        Object localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
        if ((!((String)localObject).startsWith("#")) && (((String)localObject).contains("dev_mount")))
        {
          localObject = ((String)localObject).split("\\s+");
          if ((localObject != null) && (localObject.length >= 3)) {
            localArrayList.add(removePathColon(localObject[2]));
          }
        }
      }
      AppMethodBeat.o(84224);
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(84224);
      return null;
    }
    return localArrayList;
  }
  
  private static String removePathColon(String paramString)
  {
    AppMethodBeat.i(84227);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(84227);
      return paramString;
    }
    int i = paramString.indexOf(":");
    if (i != -1)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(84227);
      return paramString;
    }
    AppMethodBeat.o(84227);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoStorageProxy
 * JD-Core Version:    0.7.0.1
 */