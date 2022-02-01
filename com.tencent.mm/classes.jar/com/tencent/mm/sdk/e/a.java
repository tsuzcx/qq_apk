package com.tencent.mm.sdk.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class a
{
  private Properties cLB;
  private String filePath;
  
  public a(String paramString)
  {
    AppMethodBeat.i(158052);
    this.cLB = null;
    this.filePath = null;
    this.cLB = new Properties();
    this.filePath = paramString;
    try
    {
      InputStream localInputStream = i.openRead(paramString);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      this.cLB.load(localInputStream);
      if (localInputStream != null) {
        try
        {
          localInputStream.close();
          AppMethodBeat.o(158052);
          return;
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException1.getLocalizedMessage() });
          AppMethodBeat.o(158052);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localIOException1;
      ad.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      if (localIOException1 != null) {
        try
        {
          localIOException1.close();
          AppMethodBeat.o(158052);
          return;
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException2.getLocalizedMessage() });
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
          ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { paramString, localIOException3.getLocalizedMessage() });
        }
      }
      AppMethodBeat.o(158052);
    }
  }
  
  public static boolean A(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(158062);
    boolean bool = new a(paramString1).bS(paramString2, paramLong);
    AppMethodBeat.o(158062);
    return bool;
  }
  
  public static boolean aS(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(158061);
    boolean bool = new a(paramString1).L(paramString2, paramString3);
    AppMethodBeat.o(158061);
    return bool;
  }
  
  public static String getValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158059);
    paramString1 = new a(paramString1).getValue(paramString2);
    AppMethodBeat.o(158059);
    return paramString1;
  }
  
  public static Long kV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158060);
    paramString1 = new a(paramString1).aGB(paramString2);
    AppMethodBeat.o(158060);
    return paramString1;
  }
  
  public static boolean kW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(158063);
    boolean bool = new a(paramString1).fI(paramString2, 0);
    AppMethodBeat.o(158063);
    return bool;
  }
  
  public final boolean L(String paramString1, String paramString2)
  {
    bool2 = true;
    AppMethodBeat.i(158053);
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localOutputStream = i.cM(this.filePath, false);
        localObject1 = localOutputStream;
        localObject2 = localOutputStream;
        this.cLB.setProperty(paramString1, paramString2);
        localObject1 = localOutputStream;
        localObject2 = localOutputStream;
        this.cLB.store(localOutputStream, "");
        bool1 = bool2;
        if (localOutputStream == null) {}
      }
      catch (Exception paramString1)
      {
        OutputStream localOutputStream;
        localObject2 = localObject1;
        ad.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
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
          ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
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
          ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString2.getLocalizedMessage() });
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
        ad.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", new Object[] { this.filePath, paramString1.getLocalizedMessage() });
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(158053);
    return bool1;
  }
  
  public final Long aGB(String paramString)
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
      ad.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      AppMethodBeat.o(158057);
    }
    return null;
  }
  
  public final Integer aGC(String paramString)
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
      ad.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", new Object[] { paramString, localException.getLocalizedMessage() });
      AppMethodBeat.o(158058);
    }
    return null;
  }
  
  public final boolean bS(String paramString, long paramLong)
  {
    AppMethodBeat.i(158054);
    boolean bool = L(paramString, String.valueOf(paramLong));
    AppMethodBeat.o(158054);
    return bool;
  }
  
  public final boolean fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(158055);
    boolean bool = L(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(158055);
    return bool;
  }
  
  public final String getValue(String paramString)
  {
    AppMethodBeat.i(158056);
    if ((this.cLB != null) && (this.cLB.containsKey(paramString)))
    {
      paramString = this.cLB.getProperty(paramString);
      AppMethodBeat.o(158056);
      return paramString;
    }
    AppMethodBeat.o(158056);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */