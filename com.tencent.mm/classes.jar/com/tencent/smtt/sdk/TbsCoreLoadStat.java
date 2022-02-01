package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d = null;
  public static volatile int mLoadErrorCode = -1;
  private TbsCoreLoadStat.TbsSequenceQueue a = null;
  private boolean b = false;
  private final int c = 3;
  
  public static TbsCoreLoadStat getInstance()
  {
    AppMethodBeat.i(55023);
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    TbsCoreLoadStat localTbsCoreLoadStat = d;
    AppMethodBeat.o(55023);
    return localTbsCoreLoadStat;
  }
  
  void a()
  {
    AppMethodBeat.i(55024);
    TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--clearErrorCodeQueue");
    if (this.a != null) {
      this.a.clear();
    }
    this.b = false;
    AppMethodBeat.o(55024);
  }
  
  public void setLoadErrorCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55025);
    setLoadErrorCode(paramContext, paramInt, null);
    TbsLog.e("loaderror", String.valueOf(paramInt));
    AppMethodBeat.o(55025);
  }
  
  public void setLoadErrorCode(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55026);
        if (mLoadErrorCode == -1)
        {
          mLoadErrorCode = paramInt;
          TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorCode=".concat(String.valueOf(paramInt)));
          TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorDetail=".concat(String.valueOf(paramThrowable)));
          TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
          if (paramThrowable != null)
          {
            TbsLogReport.getInstance(paramContext).setLoadErrorCode(paramInt, paramThrowable);
            AppMethodBeat.o(55026);
          }
        }
        else
        {
          paramContext = new StringBuilder("setLoadErrorCode :: error(");
          paramContext.append(mLoadErrorCode);
          paramContext.append(") was already reported; ");
          paramContext.append(paramInt);
          paramContext.append(" is duplicated. Try to remove it!");
          TbsLog.w("TbsCoreLoadStat", paramContext.toString());
          AppMethodBeat.o(55026);
          continue;
        }
        TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + paramInt + "; Check & correct it!");
      }
      finally {}
      AppMethodBeat.o(55026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */