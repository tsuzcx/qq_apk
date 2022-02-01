package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/PathProvider;", "", "()V", "TAG", "", "textStatusAccPath", "getTextStatusAccPath", "()Ljava/lang/String;", "clearPath", "", "username", "getHistoryPath", "url", "getIconPath", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getLocalVideoPath", "getPath", "type", "plugin-textstatus_release"})
public final class a
{
  private static String GfT;
  public static final a GfU;
  
  static
  {
    AppMethodBeat.i(216678);
    GfU = new a();
    GfT = "";
    AppMethodBeat.o(216678);
  }
  
  public static String aTo(String paramString)
  {
    AppMethodBeat.i(216675);
    p.h(paramString, "username");
    Object localObject = fwF() + "local/video";
    if (!s.YS((String)localObject)) {
      s.boN((String)localObject);
    }
    localObject = new StringBuilder().append((String)localObject).append("/");
    paramString = paramString.getBytes(d.UTF_8);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    AppMethodBeat.o(216675);
    return paramString;
  }
  
  public static void amg(String paramString)
  {
    AppMethodBeat.i(257986);
    p.h(paramString, "username");
    boolean bool1 = s.deleteFile(lf("thumb", paramString));
    boolean bool2 = s.deleteFile(lf("image", paramString));
    boolean bool3 = s.deleteFile(lf("video", paramString));
    Log.i("MicroMsg.TxtStatus.PathProvider", "clearPath " + paramString + ' ' + bool1 + ' ' + bool2 + ' ' + bool3);
    AppMethodBeat.o(257986);
  }
  
  public static String fwF()
  {
    AppMethodBeat.i(216673);
    Object localObject = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "textstatus/";
    AppMethodBeat.o(216673);
    return localObject;
  }
  
  public static String fwG()
  {
    AppMethodBeat.i(216676);
    String str = b.aKB() + "textstatus/icon";
    if (!s.YS(str)) {
      s.boN(str);
    }
    AppMethodBeat.o(216676);
    return str;
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(216677);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("text_status");
    AppMethodBeat.o(216677);
    return localMultiProcessMMKV;
  }
  
  public static String lf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216674);
    p.h(paramString1, "type");
    p.h(paramString2, "username");
    StringBuilder localStringBuilder = new StringBuilder().append(fwF());
    switch (paramString1.hashCode())
    {
    default: 
      paramString1 = "other";
    }
    for (;;)
    {
      paramString1 = paramString1;
      if (!s.YS(paramString1)) {
        s.boN(paramString1);
      }
      paramString1 = new StringBuilder().append(paramString1).append("/");
      paramString2 = paramString2.getBytes(d.UTF_8);
      p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      paramString1 = com.tencent.mm.b.g.getMessageDigest(paramString2);
      AppMethodBeat.o(216674);
      return paramString1;
      if (!paramString1.equals("image")) {
        break;
      }
      continue;
      if (!paramString1.equals("thumb")) {
        break;
      }
      continue;
      if (!paramString1.equals("video")) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.a
 * JD-Core Version:    0.7.0.1
 */