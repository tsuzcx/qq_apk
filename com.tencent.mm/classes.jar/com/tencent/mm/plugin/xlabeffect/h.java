package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/WeVisModelResMgr;", "", "()V", "TAG", "", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "checkModelConfig", "", "destroy", "", "init", "unzipModelRes", "subType", "", "path", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final String TAG;
  public static final h XKm;
  public static final IListener<cd> oDs;
  
  static
  {
    AppMethodBeat.i(261652);
    XKm = new h();
    TAG = "MicroMsg.WeVisModelResMgr";
    oDs = (IListener)new WeVisModelResMgr.checkResUpdateCacheFileEventListener.1(f.hfK);
    AppMethodBeat.o(261652);
  }
  
  public static void dS(int paramInt, String paramString)
  {
    e locale = null;
    AppMethodBeat.i(261645);
    if (paramString == null)
    {
      Log.w(TAG, "unzipModelRes: " + paramInt + "; path is null");
      AppMethodBeat.o(261645);
      return;
    }
    Object localObject1 = d.XJR;
    localObject1 = d.iFK();
    y.ew((String)localObject1, true);
    y.bDX((String)localObject1);
    int i = y.aA(paramString, (String)localObject1);
    if (i != 0)
    {
      Log.w(TAG, s.X("unzipModelRes: unzip failed ", Integer.valueOf(i)));
      AppMethodBeat.o(261645);
      return;
    }
    paramString = d.XJR;
    Object localObject2 = ((Iterable)d.iFP().XKl).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      paramString = ((Iterator)localObject2).next();
      if (((e)paramString).subType == paramInt)
      {
        i = 1;
        label150:
        if (i == 0) {
          break label205;
        }
        label154:
        localObject2 = (e)paramString;
        if (localObject2 != null) {
          break label212;
        }
        paramString = null;
        label167:
        if (paramString != null) {
          break label585;
        }
        paramString = y.eB((String)localObject1, false);
        if (paramString != null) {
          break label221;
        }
        paramString = locale;
      }
    }
    label580:
    label585:
    for (;;)
    {
      if (paramString == null)
      {
        Log.w(TAG, "unzipModelRes: no config file name");
        AppMethodBeat.o(261645);
        return;
        i = 0;
        break label150;
        label205:
        break;
        paramString = null;
        break label154;
        label212:
        paramString = ((e)localObject2).getConfigFileName();
        break label167;
        label221:
        localObject3 = paramString.iterator();
        String str;
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          paramString = ((Iterator)localObject3).next();
          str = ((j)paramString).name;
          s.s(str, "it.name");
        } while (!kotlin.n.n.rs(str, ".xml"));
        for (;;)
        {
          localObject3 = (j)paramString;
          paramString = locale;
          if (localObject3 == null) {
            break;
          }
          paramString = ((j)localObject3).name;
          break;
          paramString = null;
        }
      }
      locale = new e();
      Object localObject3 = a.mhz;
      a.a.a((String)localObject1 + '/' + paramString, (a)locale);
      if (((CharSequence)locale.key).length() == 0) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.w(TAG, "unzipModelRes: key is empty");
        AppMethodBeat.o(261645);
        return;
      }
      if (Util.isEqual(com.tencent.mm.b.n.W(y.bi((String)localObject1 + '/' + locale.name, 0, -1)), locale.obF)) {
        if (localObject2 != null) {
          if (((CharSequence)((e)localObject2).name).length() <= 0) {
            break label580;
          }
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          paramString = new StringBuilder();
          localObject3 = d.XJR;
          y.deleteFile(d.iFJ() + '/' + ((e)localObject2).name);
        }
        paramString = d.XJR;
        y.qo((String)localObject1, d.iFJ());
        if (localObject2 != null)
        {
          s.u(localObject2, "other");
          ((e)localObject2).key = locale.key;
          ((e)localObject2).subType = locale.subType;
          ((e)localObject2).obC = locale.obC;
          ((e)localObject2).name = locale.name;
          ((e)localObject2).obF = locale.obF;
        }
        y.ew((String)localObject1, true);
        AppMethodBeat.o(261645);
        return;
      }
    }
  }
  
  public static boolean iFX()
  {
    AppMethodBeat.i(261635);
    Object localObject1 = d.XJR;
    Object localObject2 = d.iFP();
    if (!((g)localObject2).isValid())
    {
      Log.w(TAG, "checkModelConfig: list is invalid");
      AppMethodBeat.o(261635);
      return false;
    }
    localObject1 = new LinkedList();
    localObject2 = ((Iterable)((g)localObject2).XKl).iterator();
    boolean bool = true;
    e locale;
    if (((Iterator)localObject2).hasNext())
    {
      locale = (e)((Iterator)localObject2).next();
      if (locale.isValid()) {
        break label195;
      }
      bool = false;
    }
    label153:
    label195:
    for (;;)
    {
      if (((CharSequence)locale.obF).length() == 0)
      {
        i = 1;
        label109:
        if ((i == 0) && (s.p(locale.obF, locale.XKj))) {
          break label153;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((LinkedList)localObject1).add(locale.key);
        }
        break;
        i = 0;
        break label109;
      }
      if (((LinkedList)localObject1).size() > 0)
      {
        Log.i(TAG, s.X("checkModelConfig: check update ", localObject1));
        b.iJf();
        b.avS(101);
      }
      AppMethodBeat.o(261635);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.h
 * JD-Core Version:    0.7.0.1
 */