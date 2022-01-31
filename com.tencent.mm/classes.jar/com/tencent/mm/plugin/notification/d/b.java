package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class b
{
  private static final String mIH = com.tencent.mm.compatible.util.e.bkH + "FailMsgFileCache";
  
  public static void a(int paramInt, b.a parama)
  {
    String str = null;
    if (paramInt == 1) {
      str = mIH + File.separator + "normalMsg";
    }
    while (bk.bl(str))
    {
      y.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
      return;
      if (paramInt == 2) {
        str = mIH + File.separator + "snsMsg";
      }
    }
    y.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[] { str });
    parama = parama.bpG();
    y.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[] { parama });
    if (bk.bl(parama))
    {
      y.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
      return;
    }
    com.tencent.mm.a.e.b(str, parama.getBytes(), parama.length());
  }
  
  public static void init()
  {
    y.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
    new File(mIH).mkdirs();
  }
  
  public static b.a vv(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = mIH + File.separator + "normalMsg";
    }
    for (;;)
    {
      if (bk.bl(str))
      {
        y.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
        return null;
        if (paramInt == 2) {
          str = mIH + File.separator + "snsMsg";
        }
      }
      else
      {
        y.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[] { str });
        try
        {
          str = com.tencent.mm.a.e.bP(str);
          y.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[] { str });
          b.a locala = new b.a();
          locala.Kh(str);
          return locala;
        }
        catch (IOException localIOException)
        {
          y.printErrStackTrace("MicroMsg.FailMsgFileCache", localIOException, "", new Object[0]);
          y.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[] { localIOException.toString() });
          return null;
        }
      }
      Object localObject = null;
    }
  }
  
  public static void vw(int paramInt)
  {
    String str = null;
    if (paramInt == 1) {}
    do
    {
      str = mIH + File.separator + "normalMsg";
      while (bk.bl(str))
      {
        y.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
        return;
        if (paramInt == 2) {
          str = mIH + File.separator + "snsMsg";
        }
      }
      y.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[] { str });
    } while (!com.tencent.mm.a.e.bK(str));
    new File(str).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.b
 * JD-Core Version:    0.7.0.1
 */