package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public int index;
  public String zDW;
  public StringBuffer zDX;
  
  public a()
  {
    AppMethodBeat.i(117554);
    this.zDW = "";
    this.index = 0;
    this.zDX = new StringBuffer();
    AppMethodBeat.o(117554);
  }
  
  public static boolean a(a parama, Intent paramIntent)
  {
    AppMethodBeat.i(117559);
    if (parama == null)
    {
      AppMethodBeat.o(117559);
      return false;
    }
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", parama.index);
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", parama.zDX.toString());
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", parama.zDW);
    AppMethodBeat.o(117559);
    return true;
  }
  
  public static a aL(Intent paramIntent)
  {
    AppMethodBeat.i(117560);
    int i = paramIntent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
    if (i == -1)
    {
      AppMethodBeat.o(117560);
      return null;
    }
    a locala = new a();
    locala.index = i;
    locala.zDX = new StringBuffer(bt.by(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
    locala.zDW = bt.by(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
    AppMethodBeat.o(117560);
    return locala;
  }
  
  public static a eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(117555);
    a locala = new a();
    locala.zDW = (paramString + "," + paramInt);
    AppMethodBeat.o(117555);
    return locala;
  }
  
  private static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(117557);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ad.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      AppMethodBeat.o(117557);
      return paramVarArgs;
      localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
        i += 1;
      }
      localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    }
  }
  
  public final void ce(int paramInt, String paramString)
  {
    AppMethodBeat.i(117558);
    paramString = String.format("{%d, %s, %d, %s},", new Object[] { Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt), paramString });
    this.index += 1;
    ad.i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(paramString)));
    this.zDX.append(paramString);
    AppMethodBeat.o(117558);
  }
  
  public final void j(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117556);
    ce(paramInt, t(paramVarArgs));
    AppMethodBeat.o(117556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a
 * JD-Core Version:    0.7.0.1
 */