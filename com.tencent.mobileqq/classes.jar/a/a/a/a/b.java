package a.a.a.a;

import a.a.a.b.h;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
{
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1 = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = ((PackageManager)localObject1).getApplicationInfo(paramContext, 8192);
      if (paramContext != null) {
        localObject1 = paramContext.sourceDir;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      paramContext = paramString2;
      if (!paramString2.endsWith(File.separator))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString2);
        paramContext.append(File.separator);
        paramContext = paramContext.toString();
      }
      new File(paramContext).mkdirs();
      paramString2 = new StringBuilder();
      paramString2.append("lib/");
      paramString2.append(b());
      paramString2.append("/");
      paramString2 = paramString2.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lib/");
      ((StringBuilder)localObject2).append(b());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramString1);
      paramString1 = ((StringBuilder)localObject2).toString();
    }
    try
    {
      paramString1 = new e(new File((String)localObject1), paramString1);
    }
    catch (IOException paramString1)
    {
      label204:
      int i;
      break label204;
    }
    paramString1 = null;
    if (paramString1 == null) {}
    do
    {
      paramContext = null;
      break;
      localObject2 = paramString1.d;
    } while ((localObject2 == null) || (!((d)localObject2).a.contains(paramString2)) || (!((d)localObject2).a.endsWith(".so")));
    localObject1 = ((d)localObject2).a;
    i = ((String)localObject1).lastIndexOf('/');
    paramString2 = (String)localObject1;
    if (i != -1) {
      paramString2 = ((String)localObject1).substring(i + 1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(paramString2);
    paramString2 = new File(((StringBuilder)localObject1).toString());
    if (paramString2.exists()) {
      paramString2.delete();
    }
    localObject1 = new byte[4096];
    try
    {
      paramString1 = paramString1.a((d)localObject2);
      localObject2 = new FileOutputStream(paramString2);
      for (;;)
      {
        i = paramString1.read((byte[])localObject1);
        paramContext = paramString2;
        if (i <= 0) {
          break;
        }
        ((FileOutputStream)localObject2).write((byte[])localObject1, 0, i);
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext = paramString2;
      }
    }
    if (paramContext.exists())
    {
      if (paramContext.length() <= 0L) {
        return null;
      }
      return paramContext;
    }
    return null;
  }
  
  public static String a()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("armeabi"))) {
        return "armeabi";
      }
      if ((str != null) && (str.contains("arm64-v8a"))) {
        return "arm64-v8a";
      }
      if ((str != null) && (str.contains("armeabi-v7a"))) {
        return "armeabi";
      }
      return "";
    }
    finally {}
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length))
        {
          int i = paramInt1;
          int j = paramInt2;
          if (paramArrayOfByte.length - paramInt1 < paramInt2) {
            return;
          }
          while (j > 0)
          {
            paramInt1 = paramInputStream.read(paramArrayOfByte, i, j);
            if (paramInt1 >= 0)
            {
              i += paramInt1;
              j -= paramInt1;
            }
            else
            {
              throw new EOFException();
            }
          }
        }
        return;
      }
      throw new NullPointerException("dst == null");
    }
    paramInputStream = new NullPointerException("in == null");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    boolean bool2 = false;
    try
    {
      paramString = paramContext.getFilesDir().getParent();
    }
    catch (Exception paramString)
    {
      label61:
      Object localObject2;
      label143:
      boolean bool1;
      label294:
      break label61;
    }
    try
    {
      if ((paramContext instanceof ContextWrapper))
      {
        paramString = ((ContextWrapper)paramContext).getBaseContext();
      }
      else
      {
        paramString = ContextWrapper.class.getDeclaredField("mBase");
        paramString.setAccessible(true);
        paramString = paramString.get(paramContext);
      }
      localObject2 = paramString.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getDataDirFile", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      paramString = ((File)((Method)localObject2).invoke(paramString, new Object[0])).getAbsolutePath();
    }
    finally
    {
      break label143;
    }
    paramString = null;
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/.seclib/");
    localObject2 = ((StringBuilder)localObject1).toString();
    try
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append(str);
      localObject1 = new File(paramString.toString());
      if (((File)localObject1).exists())
      {
        paramString = (String)localObject1;
        if (((File)localObject1).length() != 0L) {}
      }
      else
      {
        paramString = a(paramContext, str, (String)localObject2);
      }
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.exists())
        {
          if (!h.a(paramString, null))
          {
            paramString.delete();
            bool1 = h.a(a(paramContext, str, (String)localObject2), null);
            if (!bool1)
            {
              bool1 = bool2;
              break label294;
            }
          }
          bool1 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      bool1 = bool2;
    }
    if (bool1) {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject2);
        paramContext.append(str);
        System.load(paramContext.toString());
        return true;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    try
    {
      String str = a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = a(paramContext, paramString);
      localUnsatisfiedLinkError.printStackTrace();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */