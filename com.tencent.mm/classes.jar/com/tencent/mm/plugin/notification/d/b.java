package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;

public final class b
{
  private static final String piW;
  
  static
  {
    AppMethodBeat.i(23128);
    piW = com.tencent.mm.compatible.util.e.eQz + "FailMsgFileCache";
    AppMethodBeat.o(23128);
  }
  
  public static b.a AT(int paramInt)
  {
    AppMethodBeat.i(23126);
    String str;
    if (paramInt == 1) {
      str = piW + File.separator + "normalMsg";
    }
    for (;;)
    {
      if (bo.isNullOrNil(str))
      {
        ab.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
        AppMethodBeat.o(23126);
        return null;
        if (paramInt == 2) {
          str = piW + File.separator + "snsMsg";
        }
      }
      else
      {
        ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[] { str });
        try
        {
          str = com.tencent.mm.a.e.cS(str);
          ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[] { str });
          b.a locala = new b.a();
          locala.Wg(str);
          AppMethodBeat.o(23126);
          return locala;
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.FailMsgFileCache", localIOException, "", new Object[0]);
          ab.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[] { localIOException.toString() });
          AppMethodBeat.o(23126);
          return null;
        }
      }
      Object localObject = null;
    }
  }
  
  public static void AU(int paramInt)
  {
    AppMethodBeat.i(23127);
    String str = null;
    if (paramInt == 1) {
      str = piW + File.separator + "normalMsg";
    }
    while (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
      AppMethodBeat.o(23127);
      return;
      if (paramInt == 2) {
        str = piW + File.separator + "snsMsg";
      }
    }
    ab.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[] { str });
    if (com.tencent.mm.a.e.cN(str)) {
      new File(str).delete();
    }
    AppMethodBeat.o(23127);
  }
  
  public static void a(int paramInt, b.a parama)
  {
    AppMethodBeat.i(23125);
    String str = null;
    if (paramInt == 1) {
      str = piW + File.separator + "normalMsg";
    }
    while (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
      AppMethodBeat.o(23125);
      return;
      if (paramInt == 2) {
        str = piW + File.separator + "snsMsg";
      }
    }
    ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[] { str });
    parama = parama.bYm();
    ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[] { parama });
    if (bo.isNullOrNil(parama))
    {
      ab.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
      AppMethodBeat.o(23125);
      return;
    }
    com.tencent.mm.a.e.b(str, parama.getBytes(), parama.length());
    AppMethodBeat.o(23125);
  }
  
  public static void init()
  {
    AppMethodBeat.i(23124);
    ab.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
    new File(piW).mkdirs();
    AppMethodBeat.o(23124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.b
 * JD-Core Version:    0.7.0.1
 */