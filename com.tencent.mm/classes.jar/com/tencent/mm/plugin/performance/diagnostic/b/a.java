package com.tencent.mm.plugin.performance.diagnostic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.c;
import com.tencent.mm.plugin.performance.diagnostic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  extends c.a
{
  private final String MKr;
  private final String MKs;
  private final String MKt;
  private final String MKu;
  private final String MKv;
  private final String MKw;
  private final String MKx;
  private final String MKy;
  private final String MKz;
  
  public a(c<? extends com.tencent.matrix.hook.a, ? extends c.a> paramc)
  {
    super(paramc);
    AppMethodBeat.i(300871);
    this.MKr = (paramc.gxZ() + ".$hook");
    this.MKs = (paramc.gxZ() + ".$ignore");
    this.MKt = (paramc.gxZ() + ".$stack");
    this.MKu = (paramc.gxZ() + ".$min");
    this.MKv = (paramc.gxZ() + ".$max");
    this.MKw = (paramc.gxZ() + ".$sampling");
    this.MKx = (paramc.gxZ() + ".$extreme");
    this.MKy = (paramc.gxZ() + ".$mmap");
    this.MKz = (paramc.gxZ() + ".$stacklog");
    AppMethodBeat.o(300871);
  }
  
  public final void aL(Map<String, String> paramMap)
  {
    AppMethodBeat.i(300887);
    super.aL(paramMap);
    String str2 = (String)paramMap.get(this.MKr);
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.MemoryHookConfigStg", "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(300887);
      return;
    }
    String str1 = (String)paramMap.get(this.MKs);
    boolean bool1 = "1".equals(paramMap.get(this.MKt));
    int k = Util.getInt((String)paramMap.get(this.MKu), 0);
    int m = Util.getInt((String)paramMap.get(this.MKv), 0);
    double d = Util.getDouble((String)paramMap.get(this.MKw), 1.0D);
    boolean bool2 = "1".equals(paramMap.get(this.MKx));
    boolean bool3 = "1".equals(paramMap.get(this.MKy));
    int i = Util.getInt((String)paramMap.get(this.MKz), 52428800);
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
        this.evW.encode(this.MKr, str2);
        this.evW.encode(this.MKs, paramMap);
        this.evW.encode(this.MKt, bool1);
        this.evW.encode(this.MKu, k);
        this.evW.encode(this.MKv, m);
        this.evW.encode(this.MKw, d);
        this.evW.encode(this.MKx, bool2);
        this.evW.encode(this.MKy, bool3);
        this.evW.encode(this.MKz, j);
        AppMethodBeat.o(300887);
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
  
  public final String aRz(String paramString)
  {
    AppMethodBeat.i(300906);
    paramString = this.evW.decodeString(this.MKr, paramString);
    AppMethodBeat.o(300906);
    return paramString;
  }
  
  public final String gyI()
  {
    AppMethodBeat.i(300892);
    String str = aRz("");
    AppMethodBeat.o(300892);
    return str;
  }
  
  public final String gyJ()
  {
    AppMethodBeat.i(300911);
    String str = this.evW.decodeString(this.MKs, "");
    AppMethodBeat.o(300911);
    return str;
  }
  
  public final boolean gyK()
  {
    AppMethodBeat.i(300920);
    boolean bool = this.evW.decodeBool(this.MKt, false);
    AppMethodBeat.o(300920);
    return bool;
  }
  
  public final int gyL()
  {
    AppMethodBeat.i(300924);
    int i = this.evW.decodeInt(this.MKu, 0);
    AppMethodBeat.o(300924);
    return i;
  }
  
  public final int gyM()
  {
    AppMethodBeat.i(300928);
    int i = this.evW.decodeInt(this.MKv, 0);
    AppMethodBeat.o(300928);
    return i;
  }
  
  public final double gyN()
  {
    AppMethodBeat.i(300932);
    double d = this.evW.decodeDouble(this.MKw, 1.0D);
    AppMethodBeat.o(300932);
    return d;
  }
  
  public final boolean gyO()
  {
    AppMethodBeat.i(300939);
    boolean bool = this.evW.decodeBool(this.MKx, false);
    AppMethodBeat.o(300939);
    return bool;
  }
  
  public final boolean gyP()
  {
    AppMethodBeat.i(300944);
    boolean bool = this.evW.decodeBool(this.MKy, false);
    AppMethodBeat.o(300944);
    return bool;
  }
  
  public final int gyQ()
  {
    AppMethodBeat.i(300955);
    int i = this.evW.decodeInt(this.MKz, 52428800);
    AppMethodBeat.o(300955);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.a
 * JD-Core Version:    0.7.0.1
 */