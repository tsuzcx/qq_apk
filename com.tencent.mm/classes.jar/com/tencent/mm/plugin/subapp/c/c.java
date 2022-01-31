package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c
{
  private RandomAccessFile aZl = null;
  private String fileName = "";
  
  public c(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean adP(String paramString)
  {
    AppMethodBeat.i(25258);
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.aZl != null) {
        break label121;
      }
      bool = true;
      label31:
      Assert.assertTrue(bool);
      if ((!paramString.equals("r")) && (!paramString.equals("rw"))) {
        break label126;
      }
    }
    label121:
    label126:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.d("MicroMsg.SpxFileOperator", "Open file:" + this.aZl + " mode:" + paramString);
      try
      {
        this.aZl = new RandomAccessFile(this.fileName, paramString);
        AppMethodBeat.o(25258);
        return true;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + paramString.getMessage() + "]");
        this.aZl = null;
        AppMethodBeat.o(25258);
      }
      bool = false;
      break;
      bool = false;
      break label31;
    }
    return false;
  }
  
  public static int vh(String paramString)
  {
    AppMethodBeat.i(25256);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(25256);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(25256);
      return 0;
    }
    AppMethodBeat.o(25256);
    return i;
  }
  
  public final c.a Gl(int paramInt)
  {
    AppMethodBeat.i(25259);
    c.a locala = new c.a();
    if (paramInt < 0)
    {
      locala.ret = -3;
      AppMethodBeat.o(25259);
      return locala;
    }
    if ((this.aZl == null) && (!adP("r")))
    {
      locala.ret = -2;
      AppMethodBeat.o(25259);
      return locala;
    }
    locala.buf = new byte[6000];
    try
    {
      long l = this.aZl.length();
      this.aZl.seek(paramInt);
      int j = this.aZl.read(locala.buf, 0, 6000);
      ab.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt + " readRet:" + j + " fileNow:" + this.aZl.getFilePointer() + " fileSize:" + l);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      locala.ckj = i;
      locala.fXX = (i + paramInt);
      locala.ret = 0;
      AppMethodBeat.o(25259);
      return locala;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt + "  failed:[" + localException.getMessage() + "] ");
      amh();
      locala.ret = -1;
      AppMethodBeat.o(25259);
    }
    return locala;
  }
  
  public final void amh()
  {
    AppMethodBeat.i(25257);
    if (this.aZl != null) {
      try
      {
        this.aZl.close();
        this.aZl = null;
        ab.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
        AppMethodBeat.o(25257);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(25257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.c
 * JD-Core Version:    0.7.0.1
 */