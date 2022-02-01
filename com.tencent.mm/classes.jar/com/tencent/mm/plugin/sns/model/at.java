package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.xo;
import com.tencent.mm.f.a.xq;
import com.tencent.mm.f.a.xr;
import com.tencent.mm.f.a.zh;
import com.tencent.mm.f.a.zk;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class at
{
  private static HashMap<String, b> Kae;
  private static LinkedList<a> Kaf;
  private static IListener Kag;
  
  static
  {
    AppMethodBeat.i(95951);
    Kae = new HashMap();
    Kaf = new LinkedList();
    Kag = new IListener() {};
    AppMethodBeat.o(95951);
  }
  
  public static void F(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95936);
    if (paramSnsInfo != null)
    {
      String str = paramSnsInfo.getSnsId();
      Log.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramSnsInfo.field_snsId == 0L)
      {
        Log.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        Kae.remove(str);
        l(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (Kae.containsKey(str))
      {
        localObject = (b)Kae.get(str);
        if ((((b)localObject).lwF) && (!((b)localObject).lAQ))
        {
          Log.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          l(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).brand);
          AppMethodBeat.o(95936);
          return;
        }
        Kae.remove(str);
      }
      if (paramSnsInfo.getTimeLine() != null)
      {
        localObject = paramSnsInfo.getTimeLine().ContentDesc;
        zh localzh = new zh();
        localzh.fYE.id = str;
        localzh.fYE.fYF = ((String)localObject);
        localzh.fYE.type = 2;
        EventCenter.instance.publish(localzh);
        gc(paramSnsInfo.getSnsId(), 1);
        paramSnsInfo = new a((byte)0);
        paramSnsInfo.id = str;
        paramSnsInfo.Kah = ((String)localObject);
        paramSnsInfo.type = 2;
        Kaf.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void G(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95939);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = paramSnsInfo.getSnsId();
      b(bal(paramSnsInfo));
      xr localxr = new xr();
      localxr.fWB.type = 1;
      localxr.fWB.id = paramSnsInfo;
      EventCenter.instance.publish(localxr);
      Log.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramSnsInfo });
    }
    AppMethodBeat.o(95939);
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95934);
    if (abP())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, i.j.sns_translate);
        AppMethodBeat.o(95934);
        return;
      }
      paramMenu.add(0, 15, 0, i.j.sns_translate);
    }
    AppMethodBeat.o(95934);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(95937);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.Kaj = false;
    }
    for (;;)
    {
      Kae.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.Kak = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.JVu != null))
    {
      String str = paramm.lpy;
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.JVu.Uln != 0) {}
      for (long l = paramm.JVu.Uln;; l = paramm.JVu.Ulp)
      {
        localObject = l;
        paramm = kE(paramm.KCE, (String)localObject);
        if (!Kae.containsKey(paramm)) {
          break label191;
        }
        localObject = (b)Kae.get(paramm);
        if ((!((b)localObject).lwF) || (Util.isNullOrNil(((b)localObject).result))) {
          break;
        }
        Log.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        l(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).brand);
        AppMethodBeat.o(95940);
        return;
      }
      Kae.remove(paramm);
      label191:
      localObject = new zh();
      ((zh)localObject).fYE.id = paramm;
      ((zh)localObject).fYE.fYF = str;
      ((zh)localObject).fYE.type = 3;
      EventCenter.instance.publish((IEvent)localObject);
      gc(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).Kah = str;
      ((a)localObject).type = 3;
      Kaf.add(localObject);
      Log.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  private static boolean abP()
  {
    AppMethodBeat.i(95933);
    if (!c.blP("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = h.axc().getValue("TranslateSnsOff");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(95933);
      return true;
    }
    if (Util.safeParseInt(str) != 0)
    {
      AppMethodBeat.o(95933);
      return false;
    }
    AppMethodBeat.o(95933);
    return true;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (abP())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, i.j.sns_translate_original);
        AppMethodBeat.o(95935);
        return;
      }
      paramMenu.add(0, 17, 0, i.j.sns_translate_original);
    }
    AppMethodBeat.o(95935);
  }
  
  private static void b(b paramb)
  {
    AppMethodBeat.i(95938);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.Kaj = true;
    }
    for (;;)
    {
      Kae.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.Kak = true;
      }
    }
  }
  
  public static void b(m paramm)
  {
    AppMethodBeat.i(95941);
    Object localObject;
    if (paramm != null)
    {
      localObject = new StringBuilder();
      if (paramm.JVu.Uln == 0) {
        break label117;
      }
    }
    label117:
    for (long l = paramm.JVu.Uln;; l = paramm.JVu.Ulp)
    {
      localObject = l;
      paramm = kE(paramm.KCE, (String)localObject);
      b(bal(paramm));
      localObject = new xr();
      ((xr)localObject).fWB.type = 2;
      ((xr)localObject).fWB.id = paramm;
      EventCenter.instance.publish((IEvent)localObject);
      Log.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paramm });
      AppMethodBeat.o(95941);
      return;
    }
  }
  
  public static b bal(String paramString)
  {
    AppMethodBeat.i(95948);
    if (Kae.containsKey(paramString))
    {
      paramString = (b)Kae.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static boolean c(b paramb)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      bool1 = bool2;
      if ((paramb.showFlag & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, b> fPv()
  {
    return Kae;
  }
  
  private static void gc(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!Kae.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).brand = null;
      ((b)localObject).result = null;
      ((b)localObject).lwF = false;
      ((b)localObject).lAQ = false;
      ((b)localObject).Kak = true;
      ((b)localObject).Kaj = true;
      Kae.put(paramString, localObject);
    }
    Object localObject = new xq();
    ((xq)localObject).fWA.type = paramInt;
    ((xq)localObject).fWA.id = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void gd(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (Kae.containsKey(paramString))
    {
      b localb = (b)Kae.get(paramString);
      localb.showFlag |= paramInt;
      Kae.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void ge(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (Kae.containsKey(paramString))
    {
      b localb = (b)Kae.get(paramString);
      localb.showFlag &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.Kak = true;
      }
      Kae.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (Kae.containsKey(paramString))
    {
      if ((((b)Kae.get(paramString)).showFlag & paramInt) != 0)
      {
        AppMethodBeat.o(95947);
        return true;
      }
      AppMethodBeat.o(95947);
      return false;
    }
    AppMethodBeat.o(95947);
    return false;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95931);
    EventCenter.instance.addListener(Kag);
    AppMethodBeat.o(95931);
  }
  
  public static String kE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  private static void l(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (Kae.containsKey(paramString1))
    {
      localObject = (b)Kae.get(paramString1);
      ((b)localObject).brand = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).lwF = true;
      ((b)localObject).lAQ = Util.isNullOrNil(paramString2);
      Kae.put(paramString1, localObject);
    }
    if (Util.isNullOrNil(paramString2)) {
      Toast.makeText(MMApplicationContext.getContext(), i.j.sns_translate_failed, 1).show();
    }
    Object localObject = new xo();
    ((xo)localObject).fWx.type = paramInt;
    ((xo)localObject).fWx.id = paramString1;
    ((xo)localObject).fWx.result = paramString2;
    ((xo)localObject).fWx.fWy = paramString3;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    EventCenter.instance.removeListener(Kag);
    AppMethodBeat.o(95932);
  }
  
  static final class a
  {
    String Kah;
    String Kai;
    String fWy;
    String id;
    int type;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(95930);
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.id.equals(paramObject.id)) && (this.type == paramObject.type))
        {
          AppMethodBeat.o(95930);
          return true;
        }
        AppMethodBeat.o(95930);
        return false;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(95930);
      return bool;
    }
  }
  
  public static final class b
  {
    public boolean Kaj;
    public boolean Kak;
    public String brand;
    public String id;
    public boolean lAQ;
    public boolean lwF;
    public String result;
    public int showFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */