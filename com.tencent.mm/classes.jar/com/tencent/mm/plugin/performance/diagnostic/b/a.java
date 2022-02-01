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
  private final String GMZ;
  private final String GNa;
  private final String GNb;
  private final String GNc;
  private final String GNd;
  private final String GNe;
  private final String GNf;
  private final String GNg;
  private final String GNh;
  
  public a(c<? extends com.tencent.matrix.hook.a, ? extends c.a> paramc)
  {
    super(paramc);
    AppMethodBeat.i(201404);
    this.GMZ = (paramc.fnm() + ".$hook");
    this.GNa = (paramc.fnm() + ".$ignore");
    this.GNb = (paramc.fnm() + ".$stack");
    this.GNc = (paramc.fnm() + ".$min");
    this.GNd = (paramc.fnm() + ".$max");
    this.GNe = (paramc.fnm() + ".$sampling");
    this.GNf = (paramc.fnm() + ".$extreme");
    this.GNg = (paramc.fnm() + ".$mmap");
    this.GNh = (paramc.fnm() + ".$stacklog");
    AppMethodBeat.o(201404);
  }
  
  public final String aUr(String paramString)
  {
    AppMethodBeat.i(201419);
    paramString = this.fbr.decodeString(this.GMZ, paramString);
    AppMethodBeat.o(201419);
    return paramString;
  }
  
  public final void av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201415);
    super.av(paramMap);
    String str2 = (String)paramMap.get(this.GMZ);
    if (TextUtils.isEmpty(str2))
    {
      Log.e("MicroMsg.MemoryHookConfigStg", "ERROR(MemoryHook): hook regex is blank");
      AppMethodBeat.o(201415);
      return;
    }
    String str1 = (String)paramMap.get(this.GNa);
    boolean bool1 = "1".equals(paramMap.get(this.GNb));
    int k = Util.getInt((String)paramMap.get(this.GNc), 0);
    int m = Util.getInt((String)paramMap.get(this.GNd), 0);
    double d = Util.getDouble((String)paramMap.get(this.GNe), 1.0D);
    boolean bool2 = "1".equals(paramMap.get(this.GNf));
    boolean bool3 = "1".equals(paramMap.get(this.GNg));
    int i = Util.getInt((String)paramMap.get(this.GNh), 52428800);
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
        this.fbr.encode(this.GMZ, str2);
        this.fbr.encode(this.GNa, paramMap);
        this.fbr.encode(this.GNb, bool1);
        this.fbr.encode(this.GNc, k);
        this.fbr.encode(this.GNd, m);
        this.fbr.encode(this.GNe, d);
        this.fbr.encode(this.GNf, bool2);
        this.fbr.encode(this.GNg, bool3);
        this.fbr.encode(this.GNh, j);
        AppMethodBeat.o(201415);
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
  
  public final String fnM()
  {
    AppMethodBeat.i(201417);
    String str = aUr("");
    AppMethodBeat.o(201417);
    return str;
  }
  
  public final String fnN()
  {
    AppMethodBeat.i(201420);
    String str = this.fbr.decodeString(this.GNa, "");
    AppMethodBeat.o(201420);
    return str;
  }
  
  public final boolean fnO()
  {
    AppMethodBeat.i(201421);
    boolean bool = this.fbr.decodeBool(this.GNb, false);
    AppMethodBeat.o(201421);
    return bool;
  }
  
  public final int fnP()
  {
    AppMethodBeat.i(201422);
    int i = this.fbr.decodeInt(this.GNc, 0);
    AppMethodBeat.o(201422);
    return i;
  }
  
  public final int fnQ()
  {
    AppMethodBeat.i(201425);
    int i = this.fbr.decodeInt(this.GNd, 0);
    AppMethodBeat.o(201425);
    return i;
  }
  
  public final double fnR()
  {
    AppMethodBeat.i(201426);
    double d = this.fbr.decodeDouble(this.GNe, 1.0D);
    AppMethodBeat.o(201426);
    return d;
  }
  
  public final boolean fnS()
  {
    AppMethodBeat.i(201427);
    boolean bool = this.fbr.decodeBool(this.GNf, false);
    AppMethodBeat.o(201427);
    return bool;
  }
  
  public final boolean fnT()
  {
    AppMethodBeat.i(201428);
    boolean bool = this.fbr.decodeBool(this.GNg, false);
    AppMethodBeat.o(201428);
    return bool;
  }
  
  public final int fnU()
  {
    AppMethodBeat.i(201429);
    int i = this.fbr.decodeInt(this.GNh, 52428800);
    AppMethodBeat.o(201429);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b.a
 * JD-Core Version:    0.7.0.1
 */