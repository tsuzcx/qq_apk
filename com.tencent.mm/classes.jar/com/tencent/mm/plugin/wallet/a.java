package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public String Oky;
  public StringBuffer Okz;
  public int index;
  
  public a()
  {
    AppMethodBeat.i(117554);
    this.Oky = "";
    this.index = 0;
    this.Okz = new StringBuffer();
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
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", parama.Okz.toString());
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", parama.Oky);
    AppMethodBeat.o(117559);
    return true;
  }
  
  public static a be(Intent paramIntent)
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
    locala.Okz = new StringBuffer(Util.nullAs(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
    locala.Oky = Util.nullAs(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
    AppMethodBeat.o(117560);
    return locala;
  }
  
  public static a gE(String paramString, int paramInt)
  {
    AppMethodBeat.i(117555);
    a locala = new a();
    locala.Oky = (paramString + "," + paramInt);
    AppMethodBeat.o(117555);
    return locala;
  }
  
  private static String u(Object... paramVarArgs)
  {
    AppMethodBeat.i(117557);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      Log.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
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
  
  public final void cH(int paramInt, String paramString)
  {
    AppMethodBeat.i(117558);
    paramString = String.format("{%d, %s, %d, %s},", new Object[] { Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt), paramString });
    this.index += 1;
    Log.i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(paramString)));
    this.Okz.append(paramString);
    AppMethodBeat.o(117558);
  }
  
  public final void j(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117556);
    cH(paramInt, u(paramVarArgs));
    AppMethodBeat.o(117556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a
 * JD-Core Version:    0.7.0.1
 */