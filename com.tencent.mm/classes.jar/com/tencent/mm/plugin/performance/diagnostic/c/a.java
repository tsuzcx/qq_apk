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
  private final String MKF;
  private final String MKG;
  private final String MKH;
  
  public a(c<? extends com.tencent.matrix.hook.a, ? extends c.a> paramc)
  {
    super(paramc);
    AppMethodBeat.i(300849);
    this.MKF = (paramc.gxZ() + ".$hook");
    this.MKG = (paramc.gxZ() + ".$ignore");
    this.MKH = (paramc.gxZ() + ".$thread");
    AppMethodBeat.o(300849);
  }
  
  public final void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(300854);
    super.aL(paramMap);
    String str1 = (String)paramMap.get(this.MKF);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.PthreadHookConfigStg", "ERROR(PthreadHook): hook regex is blank");
      AppMethodBeat.o(300854);
      return;
    }
    String str2 = (String)paramMap.get(this.MKG);
    paramMap = (String)paramMap.get(this.MKH);
    this.evW.encode(this.MKF, str1);
    this.evW.encode(this.MKG, str2);
    this.evW.encode(this.MKH, paramMap);
    AppMethodBeat.o(300854);
  }
  
  public final String aRA(String paramString)
  {
    AppMethodBeat.i(300868);
    paramString = this.evW.decodeString(this.MKH, paramString);
    AppMethodBeat.o(300868);
    return paramString;
  }
  
  public final String aRz(String paramString)
  {
    AppMethodBeat.i(300859);
    paramString = this.evW.decodeString(this.MKF, paramString);
    AppMethodBeat.o(300859);
    return paramString;
  }
  
  public final String gyI()
  {
    AppMethodBeat.i(300857);
    String str = aRz("");
    AppMethodBeat.o(300857);
    return str;
  }
  
  public final String gyJ()
  {
    AppMethodBeat.i(300863);
    String str = this.evW.decodeString(this.MKG, null);
    AppMethodBeat.o(300863);
    return str;
  }
  
  public final String gyS()
  {
    AppMethodBeat.i(300865);
    String str = aRA("");
    AppMethodBeat.o(300865);
    return str;
  }
  
  public final long gyw()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.a
 * JD-Core Version:    0.7.0.1
 */