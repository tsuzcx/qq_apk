package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  
  public static int PZ(String paramString)
  {
    AppMethodBeat.i(28935);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new u(paramString);
      if (paramString.jKS()) {
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
  
  private boolean hAX()
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
      Log.d("MicroMsg.SpxFileOperator", "Open file:" + this.file + " forWrite:false");
      try
      {
        this.file = y.eA(this.fileName, false);
        AppMethodBeat.o(169765);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + localException.getMessage() + "]");
        this.file = null;
        AppMethodBeat.o(169765);
      }
      bool = false;
      break;
    }
    return false;
  }
  
  public final a anG(int paramInt)
  {
    AppMethodBeat.i(28938);
    a locala = new a();
    if (paramInt < 0)
    {
      locala.ret = -3;
      AppMethodBeat.o(28938);
      return locala;
    }
    if ((this.file == null) && (!hAX()))
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
      Log.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt + " readRet:" + j + " fileNow:" + this.file.getFilePointer() + " fileSize:" + l);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      locala.hxg = i;
      locala.pbK = (i + paramInt);
      locala.ret = 0;
      AppMethodBeat.o(28938);
      return locala;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt + "  failed:[" + localException.getMessage() + "] ");
      bOT();
      locala.ret = -1;
      AppMethodBeat.o(28938);
    }
    return locala;
  }
  
  public final void bOT()
  {
    AppMethodBeat.i(28936);
    if (this.file != null) {
      try
      {
        this.file.close();
        this.file = null;
        Log.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
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
    public int hxg = 0;
    public int pbK = 0;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.c
 * JD-Core Version:    0.7.0.1
 */