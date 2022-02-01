package com.tencent.mm.plugin.vlog.model;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/HevcEncodeChecker;", "", "()V", "TAG", "", "cpuName", "canEncodeHevcHard", "", "canEncodeHevcSoft", "plugin-vlog_release"})
public final class o
{
  private static String Gyj;
  public static final o Gyk;
  private static final String TAG = "MicroMsg.HevcEncodeChecker";
  
  static
  {
    AppMethodBeat.i(190586);
    Gyk = new o();
    Gyj = "";
    TAG = "MicroMsg.HevcEncodeChecker";
    h.RTc.aX((Runnable)1.Gyl);
    AppMethodBeat.o(190586);
  }
  
  public static boolean fBg()
  {
    AppMethodBeat.i(190584);
    boolean bool;
    if (((b)g.af(b.class)).a(b.a.soM, 0) == 1)
    {
      bool = true;
      Log.i(TAG, "canEncodeHevcSoft, svr isEnable:" + bool + ", cpuName:" + Gyj);
      if (bool) {
        if (((CharSequence)Gyj).length() != 0) {
          break label97;
        }
      }
    }
    label97:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label102;
      }
      AppMethodBeat.o(190584);
      return false;
      bool = false;
      break;
    }
    label102:
    Object localObject = ((b)g.af(b.class)).a(b.a.soO, "");
    Log.i(TAG, "canEncodeHevcSoft, softCpuList:".concat(String.valueOf(localObject)));
    p.g(localObject, "softCpuList");
    localObject = (Iterable)n.b((CharSequence)localObject, new String[] { ";" });
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          label221:
          if ((i == 0) || (!n.e((CharSequence)Gyj, (CharSequence)str))) {
            break label265;
          }
          i = 1;
          label243:
          if (i == 0) {
            break label268;
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label275;
      }
      AppMethodBeat.o(190584);
      return true;
      i = 0;
      break label221;
      label265:
      i = 0;
      break label243;
      label268:
      break;
    }
    label275:
    AppMethodBeat.o(190584);
    return false;
  }
  
  public static boolean fBh()
  {
    AppMethodBeat.i(190585);
    boolean bool;
    if (((b)g.af(b.class)).a(b.a.soN, 0) == 1)
    {
      bool = true;
      Log.i(TAG, "canEncodeHevcHard, svr isEnable:" + bool + ", cpuName:" + Gyj);
      if (bool) {
        if (((CharSequence)Gyj).length() != 0) {
          break label97;
        }
      }
    }
    label97:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label102;
      }
      AppMethodBeat.o(190585);
      return false;
      bool = false;
      break;
    }
    label102:
    Object localObject = ((b)g.af(b.class)).a(b.a.soP, "");
    Log.i(TAG, "canEncodeHevcHard, hardCpuList:".concat(String.valueOf(localObject)));
    p.g(localObject, "hardCpuList");
    localObject = (Iterable)n.b((CharSequence)localObject, new String[] { ";" });
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          label221:
          if ((i == 0) || (!n.e((CharSequence)Gyj, (CharSequence)str))) {
            break label265;
          }
          i = 1;
          label243:
          if (i == 0) {
            break label268;
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label275;
      }
      AppMethodBeat.o(190585);
      return true;
      i = 0;
      break label221;
      label265:
      i = 0;
      break label243;
      label268:
      break;
    }
    label275:
    AppMethodBeat.o(190585);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o
 * JD-Core Version:    0.7.0.1
 */