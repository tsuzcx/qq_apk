package com.tencent.mm.plugin.performance.diagnostic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  extends a.a
{
  private final String ATE;
  private final String ATF;
  private final String ATG;
  private final String ATH;
  private final String ATI;
  private final String ATJ;
  private final String ATK;
  private final String ATL;
  private final String ATM;
  
  public a(com.tencent.mm.plugin.performance.diagnostic.a<? extends com.tencent.wxperf.jni.a, ? extends a.a> parama)
  {
    super(parama);
    AppMethodBeat.i(201047);
    this.ATE = (parama.eBC() + ".$hook");
    this.ATF = (parama.eBC() + ".$ignore");
    this.ATG = (parama.eBC() + ".$stack");
    this.ATH = (parama.eBC() + ".$min");
    this.ATI = (parama.eBC() + ".$max");
    this.ATJ = (parama.eBC() + ".$sampling");
    this.ATK = (parama.eBC() + ".$extreme");
    this.ATL = (parama.eBC() + ".$mmap");
    this.ATM = (parama.eBC() + ".$stacklog");
    AppMethodBeat.o(201047);
  }
  
  public final void aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201048);
    super.aB(paramMap);
    String str2 = (String)paramMap.get(this.ATE);
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.MemoryHookConfigStg", "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(201048);
      return;
    }
    String str1 = (String)paramMap.get(this.ATF);
    boolean bool1 = "1".equals(paramMap.get(this.ATG));
    int k = Util.getInt((String)paramMap.get(this.ATH), 0);
    int m = Util.getInt((String)paramMap.get(this.ATI), 0);
    double d = Util.getDouble((String)paramMap.get(this.ATJ), 1.0D);
    boolean bool2 = "1".equals(paramMap.get(this.ATK));
    boolean bool3 = "1".equals(paramMap.get(this.ATL));
    int i = Util.getInt((String)paramMap.get(this.ATM), 52428800);
    if (!bool2) {
      if (str1 == null) {
        paramMap = ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
      }
    }
    for (;;)
    {
      if (i > 524288000) {
        i = 524288000;
      }
      for (;;)
      {
        int j = i;
        if (i < 0) {
          j = 0;
        }
        this.djK.encode(this.ATE, str2);
        this.djK.encode(this.ATF, paramMap);
        this.djK.encode(this.ATG, bool1);
        this.djK.encode(this.ATH, k);
        this.djK.encode(this.ATI, m);
        this.djK.encode(this.ATJ, d);
        this.djK.encode(this.ATK, bool2);
        this.djK.encode(this.ATL, bool3);
        this.djK.encode(this.ATM, j);
        AppMethodBeat.o(201048);
        return;
        paramMap = str1;
        if (!TextUtils.isEmpty(str1))
        {
          paramMap = str1;
          if (!str1.endsWith(";")) {
            paramMap = str1 + ";";
          }
        }
        paramMap = paramMap + ".*libutils\\.so$;.*libcutils\\.so$;.*libskia\\.so$;.*libbinder.*\\.so$;.*libhwbinder\\.so$;.*libicuuc\\.so$;.*libicui18n\\.so$;.*libart.*\\.so$;.*libandroidfw\\.so$;.*libandroid_runtime\\.so$;.*libjavacore\\.so$;.*libopenjdk.*\\.so$;.*libmemfence\\.so$";
        break;
      }
      paramMap = str1;
    }
  }
  
  public final String aJV(String paramString)
  {
    AppMethodBeat.i(201050);
    paramString = this.djK.decodeString(this.ATE, paramString);
    AppMethodBeat.o(201050);
    return paramString;
  }
  
  public final String eBZ()
  {
    AppMethodBeat.i(201049);
    String str = aJV("");
    AppMethodBeat.o(201049);
    return str;
  }
  
  public final String eCa()
  {
    AppMethodBeat.i(201051);
    String str = this.djK.decodeString(this.ATF, "");
    AppMethodBeat.o(201051);
    return str;
  }
  
  public final boolean eCb()
  {
    AppMethodBeat.i(201052);
    boolean bool = this.djK.decodeBool(this.ATG, false);
    AppMethodBeat.o(201052);
    return bool;
  }
  
  public final int eCc()
  {
    AppMethodBeat.i(201053);
    int i = this.djK.decodeInt(this.ATH, 0);
    AppMethodBeat.o(201053);
    return i;
  }
  
  public final int eCd()
  {
    AppMethodBeat.i(201054);
    int i = this.djK.decodeInt(this.ATI, 0);
    AppMethodBeat.o(201054);
    return i;
  }
  
  public final double eCe()
  {
    AppMethodBeat.i(201055);
    double d = this.djK.decodeDouble(this.ATJ, 1.0D);
    AppMethodBeat.o(201055);
    return d;
  }
  
  public final boolean eCf()
  {
    AppMethodBeat.i(201056);
    boolean bool = this.djK.decodeBool(this.ATK, false);
    AppMethodBeat.o(201056);
    return bool;
  }
  
  public final boolean eCg()
  {
    AppMethodBeat.i(201057);
    boolean bool = this.djK.decodeBool(this.ATL, false);
    AppMethodBeat.o(201057);
    return bool;
  }
  
  public final int eCh()
  {
    AppMethodBeat.i(201058);
    int i = this.djK.decodeInt(this.ATM, 52428800);
    AppMethodBeat.o(201058);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.a
 * JD-Core Version:    0.7.0.1
 */