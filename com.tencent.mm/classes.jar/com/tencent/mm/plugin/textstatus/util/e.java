package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/PathProvider;", "", "()V", "DEL_FLAG_ALL", "", "DEL_FLAG_IMG", "DEL_FLAG_THUMB", "DEL_FLAG_VIDEO", "TAG", "", "textStatusAccPath", "getTextStatusAccPath", "()Ljava/lang/String;", "clearPath", "", "username", "deleteFlag", "deleteIconPath", "getHistoryPath", "url", "getIconConfigPath", "getIconPath", "getInnerParentPath", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getLocalVideoPath", "getPath", "type", "getSnapShotPath", "getTextStatusCoverAgendaPath", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e TAU;
  private static String TAV;
  
  static
  {
    AppMethodBeat.i(290441);
    TAU = new e();
    TAV = "";
    AppMethodBeat.o(290441);
  }
  
  public static String bek(String paramString)
  {
    AppMethodBeat.i(290392);
    s.u(paramString, "username");
    Object localObject = s.X(hKl(), "local/video");
    if (!y.ZC((String)localObject)) {
      y.bDX((String)localObject);
    }
    localObject = new StringBuilder().append((String)localObject).append('/');
    paramString = paramString.getBytes(d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = g.getMessageDigest(paramString);
    AppMethodBeat.o(290392);
    return paramString;
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(290433);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("text_status");
    AppMethodBeat.o(290433);
    return localMultiProcessMMKV;
  }
  
  public static String hKl()
  {
    AppMethodBeat.i(290368);
    String str = s.X(h.baE().mCJ, "textstatus/");
    AppMethodBeat.o(290368);
    return str;
  }
  
  public static String hKm()
  {
    AppMethodBeat.i(290413);
    String str = s.X(b.bmr(), "textstatus/icon");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(290413);
    return str;
  }
  
  public static String hKn()
  {
    AppMethodBeat.i(290419);
    String str = s.X(hKp(), "/icon.cfg");
    AppMethodBeat.o(290419);
    return str;
  }
  
  public static String hKo()
  {
    AppMethodBeat.i(290423);
    String str = s.X(hKp(), "/cover.cfg");
    AppMethodBeat.o(290423);
    return str;
  }
  
  public static String hKp()
  {
    AppMethodBeat.i(290428);
    Object localObject1 = new StringBuilder().append(b.bmr()).append("textstatus/");
    Object localObject2 = a.cUx();
    s.s(localObject2, "username()");
    localObject2 = ((String)localObject2).getBytes(d.UTF_8);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2);
    if (!y.ZC((String)localObject1)) {
      y.bDX((String)localObject1);
    }
    AppMethodBeat.o(290428);
    return localObject1;
  }
  
  public static void ht(String paramString, int paramInt)
  {
    boolean bool3 = false;
    AppMethodBeat.i(290399);
    s.u(paramString, "username");
    boolean bool1;
    if ((paramInt & 0x1) > 0)
    {
      bool1 = y.deleteFile(nl("thumb", paramString));
      if ((paramInt & 0x2) <= 0) {
        break label132;
      }
    }
    label132:
    for (boolean bool2 = y.deleteFile(nl("image", paramString));; bool2 = false)
    {
      if ((paramInt & 0x4) > 0) {
        bool3 = y.deleteFile(nl("video", paramString));
      }
      Log.i("MicroMsg.TextStatus.PathProvider", "clearPath " + paramInt + ' ' + paramString + ' ' + bool1 + ' ' + bool2 + ' ' + bool3);
      AppMethodBeat.o(290399);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static String nl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290376);
    s.u(paramString1, "type");
    s.u(paramString2, "username");
    String str2 = hKl();
    String str1;
    switch (paramString1.hashCode())
    {
    default: 
      str1 = "other";
    }
    for (;;)
    {
      paramString1 = s.X(str2, str1);
      if (!y.ZC(paramString1)) {
        y.bDX(paramString1);
      }
      paramString1 = new StringBuilder().append(paramString1).append('/');
      paramString2 = paramString2.getBytes(d.UTF_8);
      s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
      paramString1 = g.getMessageDigest(paramString2);
      AppMethodBeat.o(290376);
      return paramString1;
      str1 = paramString1;
      if (!paramString1.equals("image"))
      {
        break;
        str1 = paramString1;
        if (!paramString1.equals("ptmptmb"))
        {
          break;
          str1 = paramString1;
          if (!paramString1.equals("thumb"))
          {
            if ((goto 68) || (!paramString1.equals("video"))) {
              break;
            }
            str1 = paramString1;
          }
        }
      }
    }
  }
  
  public static String nm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290384);
    s.u(paramString1, "url");
    s.u(paramString2, "username");
    StringBuilder localStringBuilder = new StringBuilder().append(hKl()).append("history/");
    paramString2 = paramString2.getBytes(d.UTF_8);
    s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
    paramString2 = g.getMessageDigest(paramString2);
    if (!y.ZC(paramString2)) {
      y.bDX(paramString2);
    }
    paramString2 = new StringBuilder().append(paramString2).append('/');
    paramString1 = paramString1.getBytes(d.UTF_8);
    s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = g.getMessageDigest(paramString1);
    AppMethodBeat.o(290384);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.e
 * JD-Core Version:    0.7.0.1
 */