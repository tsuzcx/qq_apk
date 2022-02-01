package com.tencent.mm.sdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFile
{
  private static final String TAG = "MicroMsg.ReadConfig";
  private String filePath;
  private Properties propertie;
  
  public ConfigFile(String paramString)
  {
    AppMethodBeat.i(158052);
    this.propertie = null;
    this.filePath = null;
    this.propertie = new Properties();
    this.filePath = paramString;
    try
    {
      InputStream localInputStream = u.Tf(paramString);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      this.propertie.load(localInputStream);
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
          AppMethodBeat.o(158052);
          return;
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException1.getLocalizedMessage() });
          AppMethodBeat.o(158052);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localIOException1;
      Log.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      if (localIOException1 != null) {
        try
        {
          localIOException1.close();
          AppMethodBeat.o(158052);
          return;
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException2.getLocalizedMessage() });
          AppMethodBeat.o(158052);
          return;
        }
      }
    }
    finally
    {
      if (localObject3 != null) {}
      try
      {
        localObject3.close();
        AppMethodBeat.o(158052);
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException3.getLocalizedMessage() });
        }
      }
      AppMethodBeat.o(158052);
    }
  }
  
  public static int getIntValue(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186332);
    paramString1 = new ConfigFile(paramString1).getIntegerValue(paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(186332);
      return paramInt;
    }
    paramInt = paramString1.intValue();
    AppMethodBeat.o(186332);
    return paramInt;
  }
  
  public static Integer getIntegerValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186328);
    paramString1 = new ConfigFile(paramString1).getIntegerValue(paramString2);
    AppMethodBeat.o(186328);
    return paramString1;
  }
  
  public static long getLongValue(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(186329);
    paramString1 = new ConfigFile(paramString1).getLongValue(paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(186329);
      return paramLong;
    }
    paramLong = paramString1.longValue();
    AppMethodBeat.o(186329);
    return paramLong;
  }
  
  public static Long getLongValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158060);
    paramString1 = new ConfigFile(paramString1).getLongValue(paramString2);
    AppMethodBeat.o(158060);
    return paramString1;
  }
  
  public static String getValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158059);
    paramString1 = new ConfigFile(paramString1).getValue(paramString2);
    AppMethodBeat.o(158059);
    return paramString1;
  }
  
  public static boolean saveValue(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186334);
    boolean bool = new ConfigFile(paramString1).saveValue(paramString2, paramInt);
    AppMethodBeat.o(186334);
    return bool;
  }
  
  public static boolean saveValue(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(158062);
    boolean bool = new ConfigFile(paramString1).saveValue(paramString2, paramLong);
    AppMethodBeat.o(158062);
    return bool;
  }
  
  public static boolean saveValue(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(158061);
    boolean bool = new ConfigFile(paramString1).saveValue(paramString2, paramString3);
    AppMethodBeat.o(158061);
    return bool;
  }
  
  public Integer getIntegerValue(String paramString)
  {
    AppMethodBeat.i(158058);
    paramString = getValue(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158058);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(158058);
      return Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      AppMethodBeat.o(158058);
    }
    return null;
  }
  
  public Long getLongValue(String paramString)
  {
    AppMethodBeat.i(158057);
    paramString = getValue(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(158057);
      return null;
    }
    try
    {
      long l = Long.parseLong(paramString);
      AppMethodBeat.o(158057);
      return Long.valueOf(l);
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      AppMethodBeat.o(158057);
    }
    return null;
  }
  
  public String getValue(String paramString)
  {
    AppMethodBeat.i(158056);
    if ((this.propertie != null) && (this.propertie.containsKey(paramString)))
    {
      paramString = this.propertie.getProperty(paramString);
      AppMethodBeat.o(158056);
      return paramString;
    }
    AppMethodBeat.o(158056);
    return null;
  }
  
  public boolean saveValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(158055);
    boolean bool = saveValue(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(158055);
    return bool;
  }
  
  public boolean saveValue(String paramString, long paramLong)
  {
    AppMethodBeat.i(158054);
    boolean bool = saveValue(paramString, String.valueOf(paramLong));
    AppMethodBeat.o(158054);
    return bool;
  }
  
  public boolean saveValue(String paramString1, String paramString2)
  {
    bool2 = true;
    AppMethodBeat.i(158053);
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localOutputStream = u.Te(this.filePath);
        localObject1 = localOutputStream;
        localObject2 = localOutputStream;
        this.propertie.setProperty(paramString1, paramString2);
        localObject1 = localOutputStream;
        localObject2 = localOutputStream;
        this.propertie.store(localOutputStream, "");
        bool1 = bool2;
        if (localOutputStream == null) {}
      }
      catch (Exception paramString1)
      {
        OutputStream localOutputStream;
        localObject2 = localObject1;
        Log.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.close();
          bool1 = false;
        }
        catch (IOException paramString1)
        {
          Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
          bool1 = false;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          localObject2.close();
          AppMethodBeat.o(158053);
          throw paramString1;
        }
        catch (IOException paramString2)
        {
          Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString2.getLocalizedMessage() });
          continue;
        }
        boolean bool1 = false;
        continue;
      }
      try
      {
        localOutputStream.close();
        bool1 = bool2;
      }
      catch (IOException paramString1)
      {
        Log.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(158053);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.ConfigFile
 * JD-Core Version:    0.7.0.1
 */