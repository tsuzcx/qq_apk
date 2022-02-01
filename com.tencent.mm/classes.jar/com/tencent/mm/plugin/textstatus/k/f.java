package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/PathProvider;", "", "()V", "DEL_FLAG_ALL", "", "DEL_FLAG_IMG", "DEL_FLAG_THUMB", "DEL_FLAG_VIDEO", "TAG", "", "textStatusAccPath", "getTextStatusAccPath", "()Ljava/lang/String;", "clearPath", "", "username", "deleteFlag", "getHistoryPath", "url", "getIconConfigPath", "getIconPath", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getLocalVideoPath", "getPath", "type", "plugin-textstatus_release"})
public final class f
{
  private static String MOv;
  public static final f MOw;
  
  static
  {
    AppMethodBeat.i(232162);
    MOw = new f();
    MOv = "";
    AppMethodBeat.o(232162);
  }
  
  public static String beK(String paramString)
  {
    AppMethodBeat.i(232149);
    p.k(paramString, "username");
    Object localObject = gnC() + "local/video";
    if (!u.agG((String)localObject)) {
      u.bBD((String)localObject);
    }
    localObject = new StringBuilder().append((String)localObject).append("/");
    paramString = paramString.getBytes(d.UTF_8);
    p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = g.getMessageDigest(paramString);
    AppMethodBeat.o(232149);
    return paramString;
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(232160);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("text_status");
    AppMethodBeat.o(232160);
    return localMultiProcessMMKV;
  }
  
  public static String gnC()
  {
    AppMethodBeat.i(232139);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "textstatus/";
    AppMethodBeat.o(232139);
    return localObject;
  }
  
  public static String gnD()
  {
    AppMethodBeat.i(232156);
    String str = b.aSD() + "textstatus/icon";
    if (!u.agG(str)) {
      u.bBD(str);
    }
    AppMethodBeat.o(232156);
    return str;
  }
  
  public static String gnE()
  {
    AppMethodBeat.i(232158);
    Object localObject1 = new StringBuilder().append(b.aSD()).append("textstatus/");
    Object localObject2 = a.crN();
    p.j(localObject2, "Account.username()");
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(232158);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2);
    if (!u.agG((String)localObject1)) {
      u.bBD((String)localObject1);
    }
    localObject1 = (String)localObject1 + "/icon.cfg";
    AppMethodBeat.o(232158);
    return localObject1;
  }
  
  public static void gw(String paramString, int paramInt)
  {
    boolean bool3 = false;
    AppMethodBeat.i(232151);
    p.k(paramString, "username");
    boolean bool1;
    if ((paramInt & 0x1) > 0)
    {
      bool1 = u.deleteFile(lD("thumb", paramString));
      if ((paramInt & 0x2) <= 0) {
        break label132;
      }
    }
    label132:
    for (boolean bool2 = u.deleteFile(lD("image", paramString));; bool2 = false)
    {
      if ((paramInt & 0x4) > 0) {
        bool3 = u.deleteFile(lD("video", paramString));
      }
      Log.i("MicroMsg.TextStatus.PathProvider", "clearPath " + paramInt + ' ' + paramString + ' ' + bool1 + ' ' + bool2 + ' ' + bool3);
      AppMethodBeat.o(232151);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static String lD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232142);
    p.k(paramString1, "type");
    p.k(paramString2, "username");
    StringBuilder localStringBuilder = new StringBuilder().append(gnC());
    switch (paramString1.hashCode())
    {
    default: 
      paramString1 = "other";
    }
    for (;;)
    {
      paramString1 = paramString1;
      if (!u.agG(paramString1)) {
        u.bBD(paramString1);
      }
      paramString1 = new StringBuilder().append(paramString1).append("/");
      paramString2 = paramString2.getBytes(d.UTF_8);
      p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
      paramString1 = g.getMessageDigest(paramString2);
      AppMethodBeat.o(232142);
      return paramString1;
      if (!paramString1.equals("image")) {
        break;
      }
      continue;
      if (!paramString1.equals("ptmptmb")) {
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
  
  public static String lE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232144);
    p.k(paramString1, "url");
    p.k(paramString2, "username");
    StringBuilder localStringBuilder = new StringBuilder().append(gnC()).append("history/");
    paramString2 = paramString2.getBytes(d.UTF_8);
    p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
    paramString2 = g.getMessageDigest(paramString2);
    if (!u.agG(paramString2)) {
      u.bBD(paramString2);
    }
    paramString2 = new StringBuilder().append(paramString2).append("/");
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = g.getMessageDigest(paramString1);
    AppMethodBeat.o(232144);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.f
 * JD-Core Version:    0.7.0.1
 */