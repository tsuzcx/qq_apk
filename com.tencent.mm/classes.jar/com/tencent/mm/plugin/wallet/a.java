package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
{
  public int index;
  public String tLS;
  public StringBuffer tLT;
  
  public a()
  {
    AppMethodBeat.i(135764);
    this.tLS = "";
    this.index = 0;
    this.tLT = new StringBuffer();
    AppMethodBeat.o(135764);
  }
  
  public static boolean a(a parama, Intent paramIntent)
  {
    AppMethodBeat.i(135769);
    if (parama == null)
    {
      AppMethodBeat.o(135769);
      return false;
    }
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", parama.index);
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", parama.tLT.toString());
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", parama.tLS);
    AppMethodBeat.o(135769);
    return true;
  }
  
  public static a as(Intent paramIntent)
  {
    AppMethodBeat.i(135770);
    int i = paramIntent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
    if (i == -1)
    {
      AppMethodBeat.o(135770);
      return null;
    }
    a locala = new a();
    locala.index = i;
    locala.tLT = new StringBuffer(bo.bf(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
    locala.tLS = bo.bf(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
    AppMethodBeat.o(135770);
    return locala;
  }
  
  public static a dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(135765);
    a locala = new a();
    locala.tLS = (paramString + "," + paramInt);
    AppMethodBeat.o(135765);
    return locala;
  }
  
  private static String t(Object... paramVarArgs)
  {
    AppMethodBeat.i(135767);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      ab.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      AppMethodBeat.o(135767);
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
  
  public final void bs(int paramInt, String paramString)
  {
    AppMethodBeat.i(135768);
    paramString = String.format("{%d, %s, %d, %s},", new Object[] { Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt), paramString });
    this.index += 1;
    ab.i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(paramString)));
    this.tLT.append(paramString);
    AppMethodBeat.o(135768);
  }
  
  public final void j(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135766);
    bs(paramInt, t(paramVarArgs));
    AppMethodBeat.o(135766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a
 * JD-Core Version:    0.7.0.1
 */