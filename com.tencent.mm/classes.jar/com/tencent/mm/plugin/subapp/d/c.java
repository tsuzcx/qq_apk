package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c
{
  private RandomAccessFile file = null;
  private String fileName = "";
  
  public c(String paramString)
  {
    this.fileName = paramString;
  }
  
  public static int Hj(String paramString)
  {
    AppMethodBeat.i(28935);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new e(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(28935);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(28935);
      return 0;
    }
    AppMethodBeat.o(28935);
    return i;
  }
  
  private boolean emX()
  {
    AppMethodBeat.i(169765);
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.file != null) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ad.d("MicroMsg.SpxFileOperator", "Open file:" + this.file + " forWrite:false");
      try
      {
        this.file = i.dd(this.fileName, false);
        AppMethodBeat.o(169765);
        return true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.file = null;
        AppMethodBeat.o(169765);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final a SH(int paramInt)
  {
    AppMethodBeat.i(28938);
    a locala = new a();
    if (paramInt < 0)
    {
      locala.ret = -3;
      AppMethodBeat.o(28938);
      return locala;
    }
    if ((this.file == null) && (!emX()))
    {
      locala.ret = -2;
      AppMethodBeat.o(28938);
      return locala;
    }
    locala.buf = new byte[6000];
    try
    {
      long l = this.file.length();
      this.file.seek(paramInt);
      int j = this.file.read(locala.buf, 0, 6000);
      ad.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt + " readRet:" + j + " fileNow:" + this.file.getFilePointer() + " fileSize:" + l);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      locala.dhO = i;
      locala.iuI = (i + paramInt);
      locala.ret = 0;
      AppMethodBeat.o(28938);
      return locala;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt + "  failed:[" + localException.getMessage() + "] ");
      aNm();
      locala.ret = -1;
      AppMethodBeat.o(28938);
    }
    return locala;
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(28936);
    if (this.file != null) {
      try
      {
        this.file.close();
        this.file = null;
        ad.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(28936);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(28936);
  }
  
  public static final class a
  {
    public byte[] buf = null;
    public int dhO = 0;
    public int iuI = 0;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.c
 * JD-Core Version:    0.7.0.1
 */