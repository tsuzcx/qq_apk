package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class au
{
  private static HashMap<String, b> DNc;
  private static LinkedList<a> DNd;
  private static IListener DNe;
  
  static
  {
    AppMethodBeat.i(95951);
    DNc = new HashMap();
    DNd = new LinkedList();
    DNe = new IListener() {};
    AppMethodBeat.o(95951);
  }
  
  public static void E(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95936);
    if (paramSnsInfo != null)
    {
      String str = paramSnsInfo.getSnsId();
      Log.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramSnsInfo.field_snsId == 0L)
      {
        Log.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        DNc.remove(str);
        j(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (DNc.containsKey(str))
      {
        localObject = (b)DNc.get(str);
        if ((((b)localObject).iGD) && (!((b)localObject).aGI))
        {
          Log.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          j(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).brand);
          AppMethodBeat.o(95936);
          return;
        }
        DNc.remove(str);
      }
      if (paramSnsInfo.getTimeLine() != null)
      {
        localObject = paramSnsInfo.getTimeLine().ContentDesc;
        ya localya = new ya();
        localya.eep.id = str;
        localya.eep.eeq = ((String)localObject);
        localya.eep.type = 2;
        EventCenter.instance.publish(localya);
        fz(paramSnsInfo.getSnsId(), 1);
        paramSnsInfo = new a((byte)0);
        paramSnsInfo.id = str;
        paramSnsInfo.DNf = ((String)localObject);
        paramSnsInfo.type = 2;
        DNd.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void F(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95939);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = paramSnsInfo.getSnsId();
      b(aPp(paramSnsInfo));
      wl localwl = new wl();
      localwl.ecx.type = 1;
      localwl.ecx.id = paramSnsInfo;
      EventCenter.instance.publish(localwl);
      Log.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramSnsInfo });
    }
    AppMethodBeat.o(95939);
  }
  
  private static boolean Xn()
  {
    AppMethodBeat.i(95933);
    if (!c.aZU("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = h.aqJ().getValue("TranslateSnsOff");
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
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95934);
    if (Xn())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, 2131766281);
        AppMethodBeat.o(95934);
        return;
      }
      paramMenu.add(0, 15, 0, 2131766281);
    }
    AppMethodBeat.o(95934);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(95937);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.DNh = false;
    }
    for (;;)
    {
      DNc.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.DNi = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.DIu != null))
    {
      String str = paramm.iAc;
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.DIu.MYT != 0) {}
      for (long l = paramm.DIu.MYT;; l = paramm.DIu.MYV)
      {
        localObject = l;
        paramm = kj(paramm.Epv, (String)localObject);
        if (!DNc.containsKey(paramm)) {
          break label192;
        }
        localObject = (b)DNc.get(paramm);
        if ((!((b)localObject).iGD) || (Util.isNullOrNil(((b)localObject).result))) {
          break;
        }
        Log.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        j(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).brand);
        AppMethodBeat.o(95940);
        return;
      }
      DNc.remove(paramm);
      label192:
      localObject = new ya();
      ((ya)localObject).eep.id = paramm;
      ((ya)localObject).eep.eeq = str;
      ((ya)localObject).eep.type = 3;
      EventCenter.instance.publish((IEvent)localObject);
      fz(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).DNf = str;
      ((a)localObject).type = 3;
      DNd.add(localObject);
      Log.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  public static b aPp(String paramString)
  {
    AppMethodBeat.i(95948);
    if (DNc.containsKey(paramString))
    {
      paramString = (b)DNc.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (Xn())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, 2131766283);
        AppMethodBeat.o(95935);
        return;
      }
      paramMenu.add(0, 17, 0, 2131766283);
    }
    AppMethodBeat.o(95935);
  }
  
  private static void b(b paramb)
  {
    AppMethodBeat.i(95938);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.DNh = true;
    }
    for (;;)
    {
      DNc.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.DNi = true;
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
      if (paramm.DIu.MYT == 0) {
        break label117;
      }
    }
    label117:
    for (long l = paramm.DIu.MYT;; l = paramm.DIu.MYV)
    {
      localObject = l;
      paramm = kj(paramm.Epv, (String)localObject);
      b(aPp(paramm));
      localObject = new wl();
      ((wl)localObject).ecx.type = 2;
      ((wl)localObject).ecx.id = paramm;
      EventCenter.instance.publish((IEvent)localObject);
      Log.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paramm });
      AppMethodBeat.o(95941);
      return;
    }
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
  
  public static void fA(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (DNc.containsKey(paramString))
    {
      b localb = (b)DNc.get(paramString);
      localb.showFlag |= paramInt;
      DNc.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void fB(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (DNc.containsKey(paramString))
    {
      b localb = (b)DNc.get(paramString);
      localb.showFlag &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.DNi = true;
      }
      DNc.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean fC(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (DNc.containsKey(paramString))
    {
      if ((((b)DNc.get(paramString)).showFlag & paramInt) != 0)
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
  
  public static HashMap<String, b> fbC()
  {
    return DNc;
  }
  
  private static void fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!DNc.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).brand = null;
      ((b)localObject).result = null;
      ((b)localObject).iGD = false;
      ((b)localObject).aGI = false;
      ((b)localObject).DNi = true;
      ((b)localObject).DNh = true;
      DNc.put(paramString, localObject);
    }
    Object localObject = new wk();
    ((wk)localObject).ecw.type = paramInt;
    ((wk)localObject).ecw.id = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void init()
  {
    AppMethodBeat.i(95931);
    EventCenter.instance.addListener(DNe);
    AppMethodBeat.o(95931);
  }
  
  private static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (DNc.containsKey(paramString1))
    {
      localObject = (b)DNc.get(paramString1);
      ((b)localObject).brand = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).iGD = true;
      ((b)localObject).aGI = Util.isNullOrNil(paramString2);
      DNc.put(paramString1, localObject);
    }
    if (Util.isNullOrNil(paramString2)) {
      Toast.makeText(MMApplicationContext.getContext(), 2131766282, 1).show();
    }
    Object localObject = new wi();
    ((wi)localObject).ect.type = paramInt;
    ((wi)localObject).ect.id = paramString1;
    ((wi)localObject).ect.result = paramString2;
    ((wi)localObject).ect.ecu = paramString3;
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static String kj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    EventCenter.instance.removeListener(DNe);
    AppMethodBeat.o(95932);
  }
  
  static final class a
  {
    String DNf;
    String DNg;
    String ecu;
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
    public boolean DNh;
    public boolean DNi;
    public boolean aGI;
    public String brand;
    public boolean iGD;
    public String id;
    public String result;
    public int showFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */