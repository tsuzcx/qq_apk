package com.tencent.smtt.sdk;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

public class TbsLogReport$TbsLogInfo
  implements Cloneable
{
  int a;
  private long b;
  private String c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private int j;
  private int k;
  private long l;
  private long m;
  private int n;
  private String o;
  private String p;
  private long q;
  
  private TbsLogReport$TbsLogInfo()
  {
    AppMethodBeat.i(64484);
    resetArgs();
    AppMethodBeat.o(64484);
  }
  
  protected Object clone()
  {
    AppMethodBeat.i(64485);
    try
    {
      Object localObject = super.clone();
      AppMethodBeat.o(64485);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AppMethodBeat.o(64485);
    }
    return this;
  }
  
  public int getDownFinalFlag()
  {
    return this.k;
  }
  
  public void resetArgs()
  {
    this.b = 0L;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 2;
    this.i = "unknown";
    this.j = 0;
    this.k = 2;
    this.l = 0L;
    this.m = 0L;
    this.n = 1;
    this.a = 0;
    this.o = null;
    this.p = null;
    this.q = 0L;
  }
  
  public void setApn(String paramString)
  {
    this.i = paramString;
  }
  
  public void setCheckErrorDetail(String paramString)
  {
    AppMethodBeat.i(64488);
    setErrorCode(108);
    this.o = paramString;
    AppMethodBeat.o(64488);
  }
  
  public void setDownConsumeTime(long paramLong)
  {
    this.m += paramLong;
  }
  
  public void setDownFinalFlag(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setDownloadCancel(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDownloadSize(long paramLong)
  {
    this.q += paramLong;
  }
  
  public void setDownloadUrl(String paramString)
  {
    AppMethodBeat.i(64486);
    if (this.c == null)
    {
      this.c = paramString;
      AppMethodBeat.o(64486);
      return;
    }
    this.c = (this.c + ";" + paramString);
    AppMethodBeat.o(64486);
  }
  
  public void setErrorCode(int paramInt)
  {
    AppMethodBeat.i(64487);
    if ((paramInt != 100) && (paramInt != 110) && (paramInt != 120) && (paramInt != 111) && (paramInt < 400)) {
      TbsLog.i("TbsDownload", "error occured, errorCode:".concat(String.valueOf(paramInt)), true);
    }
    if (paramInt == 111) {
      TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
    }
    this.a = paramInt;
    AppMethodBeat.o(64487);
  }
  
  public void setEventTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setFailDetail(String paramString)
  {
    AppMethodBeat.i(64489);
    if (paramString == null)
    {
      AppMethodBeat.o(64489);
      return;
    }
    String str = paramString;
    if (paramString.length() > 1024) {
      str = paramString.substring(0, 1024);
    }
    this.p = str;
    AppMethodBeat.o(64489);
  }
  
  public void setFailDetail(Throwable paramThrowable)
  {
    AppMethodBeat.i(64490);
    if (paramThrowable == null)
    {
      this.p = "";
      AppMethodBeat.o(64490);
      return;
    }
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    this.p = paramThrowable;
    AppMethodBeat.o(64490);
  }
  
  public void setHttpCode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setNetworkChange(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setNetworkType(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setPatchUpdateFlag(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setPkgSize(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void setResolveIp(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUnpkgFlag(int paramInt)
  {
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
 * JD-Core Version:    0.7.0.1
 */