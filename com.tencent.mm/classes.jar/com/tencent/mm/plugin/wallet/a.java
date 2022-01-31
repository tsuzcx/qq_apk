package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public int index = 0;
  public String qff = "";
  public StringBuffer qfg = new StringBuffer();
  
  public static a Y(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
    if (i == -1) {
      return null;
    }
    a locala = new a();
    locala.index = i;
    locala.qfg = new StringBuffer(bk.aM(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
    locala.qff = bk.aM(paramIntent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
    return locala;
  }
  
  public static boolean a(a parama, Intent paramIntent)
  {
    if (parama == null) {
      return false;
    }
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", parama.index);
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", parama.qfg.toString());
    paramIntent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", parama.qff);
    return true;
  }
  
  public static a cE(String paramString, int paramInt)
  {
    a locala = new a();
    locala.qff = (paramString + "," + paramInt);
    return locala;
  }
  
  public final void aO(int paramInt, String paramString)
  {
    paramString = String.format("{%d, %s, %d, %s},", new Object[] { Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt), paramString });
    this.index += 1;
    y.i("MicroMsg.PayLogReport", "test for log " + paramString);
    this.qfg.append(paramString);
  }
  
  public final void i(int paramInt, Object... paramVarArgs)
  {
    if (paramVarArgs.length <= 0) {
      y.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
    }
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      aO(paramInt, paramVarArgs);
      return;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a
 * JD-Core Version:    0.7.0.1
 */