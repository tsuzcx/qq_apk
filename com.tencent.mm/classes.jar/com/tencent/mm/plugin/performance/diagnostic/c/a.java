package com.tencent.mm.plugin.performance.diagnostic.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Map;

public final class a
  extends a.a
{
  private final String ATS;
  private final String ATT;
  private final String ATU;
  
  public a(com.tencent.mm.plugin.performance.diagnostic.a<? extends com.tencent.wxperf.jni.a, ? extends a.a> parama)
  {
    super(parama);
    AppMethodBeat.i(201071);
    this.ATS = (parama.eBC() + ".$hook");
    this.ATT = (parama.eBC() + ".$ignore");
    this.ATU = (parama.eBC() + ".$thread");
    AppMethodBeat.o(201071);
  }
  
  public final void aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201072);
    super.aB(paramMap);
    String str1 = (String)paramMap.get(this.ATS);
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.PthreadHookConfigStg", "ERROR(PthreadHook): hook regex is blank");
      AppMethodBeat.o(201072);
      return;
    }
    String str2 = (String)paramMap.get(this.ATT);
    paramMap = (String)paramMap.get(this.ATU);
    this.djK.encode(this.ATS, str1);
    this.djK.encode(this.ATT, str2);
    this.djK.encode(this.ATU, paramMap);
    AppMethodBeat.o(201072);
  }
  
  public final String aJV(String paramString)
  {
    AppMethodBeat.i(201074);
    paramString = this.djK.decodeString(this.ATS, paramString);
    AppMethodBeat.o(201074);
    return paramString;
  }
  
  public final String aJW(String paramString)
  {
    AppMethodBeat.i(201077);
    paramString = this.djK.decodeString(this.ATU, paramString);
    AppMethodBeat.o(201077);
    return paramString;
  }
  
  public final long eBV()
  {
    return -1L;
  }
  
  public final String eBZ()
  {
    AppMethodBeat.i(201073);
    String str = aJV("");
    AppMethodBeat.o(201073);
    return str;
  }
  
  public final String eCa()
  {
    AppMethodBeat.i(201075);
    String str = this.djK.decodeString(this.ATT, null);
    AppMethodBeat.o(201075);
    return str;
  }
  
  public final String eCm()
  {
    AppMethodBeat.i(201076);
    String str = aJW("");
    AppMethodBeat.o(201076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c.a
 * JD-Core Version:    0.7.0.1
 */