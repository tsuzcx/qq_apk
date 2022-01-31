package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c
{
  private RandomAccessFile aRL = null;
  private String fileName = "";
  
  public c(String paramString)
  {
    this.fileName = paramString;
  }
  
  private boolean Pz(String paramString)
  {
    if (this.fileName.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.aRL != null) {
        break label109;
      }
      bool = true;
      label25:
      Assert.assertTrue(bool);
      if ((!paramString.equals("r")) && (!paramString.equals("rw"))) {
        break label114;
      }
    }
    label109:
    label114:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      y.d("MicroMsg.SpxFileOperator", "Open file:" + this.aRL + " mode:" + paramString);
      try
      {
        this.aRL = new RandomAccessFile(this.fileName, paramString);
        return true;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + paramString.getMessage() + "]");
        this.aRL = null;
      }
      bool = false;
      break;
      bool = false;
      break label25;
    }
    return false;
  }
  
  public static int nU(String paramString)
  {
    boolean bool;
    if (paramString.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break label36;
      }
    }
    label36:
    int i;
    do
    {
      return 0;
      bool = false;
      break;
      i = (int)paramString.length();
    } while (i <= 0);
    return i;
  }
  
  public final void SW()
  {
    if (this.aRL != null) {}
    try
    {
      this.aRL.close();
      this.aRL = null;
      y.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final c.a zm(int paramInt)
  {
    c.a locala = new c.a();
    if (paramInt < 0)
    {
      locala.ret = -3;
      return locala;
    }
    if ((this.aRL == null) && (!Pz("r")))
    {
      locala.ret = -2;
      return locala;
    }
    locala.buf = new byte[6000];
    try
    {
      long l = this.aRL.length();
      this.aRL.seek(paramInt);
      int j = this.aRL.read(locala.buf, 0, 6000);
      y.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + paramInt + " readRet:" + j + " fileNow:" + this.aRL.getFilePointer() + " fileSize:" + l);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      locala.bDu = i;
      locala.eIh = (i + paramInt);
      locala.ret = 0;
      return locala;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + paramInt + "  failed:[" + localException.getMessage() + "] ");
      SW();
      locala.ret = -1;
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.c
 * JD-Core Version:    0.7.0.1
 */