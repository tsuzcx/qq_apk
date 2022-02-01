package com.tencent.mm.plugin.performance.diagnostic.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.c;
import com.tencent.mm.plugin.performance.diagnostic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Map;

public final class a
  extends c.a
{
  private final String GNn;
  private final String GNo;
  private final String GNp;
  
  public a(c<? extends com.tencent.matrix.hook.a, ? extends c.a> paramc)
  {
    super(paramc);
    AppMethodBeat.i(201438);
    this.GNn = (paramc.fnm() + ".$hook");
    this.GNo = (paramc.fnm() + ".$ignore");
    this.GNp = (paramc.fnm() + ".$thread");
    AppMethodBeat.o(201438);
  }
  
  public final String aUr(String paramString)
  {
    AppMethodBeat.i(201442);
    paramString = this.fbr.decodeString(this.GNn, paramString);
    AppMethodBeat.o(201442);
    return paramString;
  }
  
  public final String aUs(String paramString)
  {
    AppMethodBeat.i(201445);
    paramString = this.fbr.decodeString(this.GNp, paramString);
    AppMethodBeat.o(201445);
    return paramString;
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201440);
    super.av(paramMap);
    String str1 = (String)paramMap.get(this.GNn);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.PthreadHookConfigStg", "ERROR(PthreadHook): hook regex is blank");
      AppMethodBeat.o(201440);
      return;
    }
    String str2 = (String)paramMap.get(this.GNo);
    paramMap = (String)paramMap.get(this.GNp);
    this.fbr.encode(this.GNn, str1);
    this.fbr.encode(this.GNo, str2);
    this.fbr.encode(this.GNp, paramMap);
    AppMethodBeat.o(201440);
  }
  
  public final long fnI()
  {
    return -1L;
  }
  
  public final String fnM()
  {
    AppMethodBeat.i(201441);
    String str = aUr("");
    AppMethodBeat.o(201441);
    return str;
  }
  
  public final String fnN()
  {
    AppMethodBeat.i(201443);
    String str = this.fbr.decodeString(this.GNo, null);
    AppMethodBeat.o(201443);
    return str;
  }
  
  public final String fnW()
  {
    AppMethodBeat.i(201444);
    String str = aUs("");
    AppMethodBeat.o(201444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.a
 * JD-Core Version:    0.7.0.1
 */