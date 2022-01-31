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
    AppMethodBeat.i(64298);
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    TbsCoreLoadStat localTbsCoreLoadStat = d;
    AppMethodBeat.o(64298);
    return localTbsCoreLoadStat;
  }
  
  void a()
  {
    AppMethodBeat.i(64299);
    if (this.a != null) {
      this.a.clear();
    }
    this.b = false;
    AppMethodBeat.o(64299);
  }
  
  void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(64300);
    a(paramContext, paramInt, null);
    TbsLog.e("loaderror", String.valueOf(paramInt));
    AppMethodBeat.o(64300);
  }
  
  void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64301);
        if (mLoadErrorCode == -1)
        {
          mLoadErrorCode = paramInt;
          TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
          if (paramThrowable != null)
          {
            TbsLogReport.getInstance(paramContext).setLoadErrorCode(paramInt, paramThrowable);
            AppMethodBeat.o(64301);
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
          AppMethodBeat.o(64301);
          continue;
        }
        TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + paramInt + "; Check & correct it!");
      }
      finally {}
      AppMethodBeat.o(64301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */