package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;

public final class aq
{
  private static HashMap<String, b> xVM;
  private static LinkedList<a> xVN;
  private static c xVO;
  
  static
  {
    AppMethodBeat.i(95951);
    xVM = new HashMap();
    xVN = new LinkedList();
    xVO = new c() {};
    AppMethodBeat.o(95951);
  }
  
  private static boolean Ly()
  {
    AppMethodBeat.i(95933);
    if (!d.aCT("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = g.ZY().getValue("TranslateSnsOff");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(95933);
      return true;
    }
    if (bs.aLy(str) != 0)
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
    if (Ly())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, 2131764042);
        AppMethodBeat.o(95934);
        return;
      }
      paramMenu.add(0, 15, 0, 2131764042);
    }
    AppMethodBeat.o(95934);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(95937);
    if ((paramb.exP & 0x2) != 0) {
      paramb.xVR = false;
    }
    for (;;)
    {
      xVM.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.exP & 0x4) != 0) {
        paramb.xVS = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.xRC != null))
    {
      String str = paramm.hkR;
      if (bs.isNullOrNil(str))
      {
        ac.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.xRC.FIZ != 0) {}
      for (long l = paramm.xRC.FIZ;; l = paramm.xRC.FJb)
      {
        localObject = l;
        paramm = jd(paramm.yyH, (String)localObject);
        if (!xVM.containsKey(paramm)) {
          break label190;
        }
        localObject = (b)xVM.get(paramm);
        if ((!((b)localObject).hqq) || (bs.isNullOrNil(((b)localObject).result))) {
          break;
        }
        ac.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        j(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).hym);
        AppMethodBeat.o(95940);
        return;
      }
      xVM.remove(paramm);
      label190:
      localObject = new wc();
      ((wc)localObject).dyW.id = paramm;
      ((wc)localObject).dyW.dyX = str;
      ((wc)localObject).dyW.type = 3;
      a.GpY.l((b)localObject);
      eA(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).xVP = str;
      ((a)localObject).type = 3;
      xVN.add(localObject);
      ac.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  public static b atX(String paramString)
  {
    AppMethodBeat.i(95948);
    if (xVM.containsKey(paramString))
    {
      paramString = (b)xVM.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (Ly())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, 2131764044);
        AppMethodBeat.o(95935);
        return;
      }
      paramMenu.add(0, 17, 0, 2131764044);
    }
    AppMethodBeat.o(95935);
  }
  
  private static void b(b paramb)
  {
    AppMethodBeat.i(95938);
    if ((paramb.exP & 0x2) != 0) {
      paramb.xVR = true;
    }
    for (;;)
    {
      xVM.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.exP & 0x4) != 0) {
        paramb.xVS = true;
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
      if (paramm.xRC.FIZ == 0) {
        break label115;
      }
    }
    label115:
    for (long l = paramm.xRC.FIZ;; l = paramm.xRC.FJb)
    {
      localObject = l;
      paramm = jd(paramm.yyH, (String)localObject);
      b(atX(paramm));
      localObject = new uo();
      ((uo)localObject).dxi.type = 2;
      ((uo)localObject).dxi.id = paramm;
      a.GpY.l((b)localObject);
      ac.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[] { paramm });
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
      if ((paramb.exP & 0x2) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static HashMap<String, b> dIB()
  {
    return xVM;
  }
  
  private static void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!xVM.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).hym = null;
      ((b)localObject).result = null;
      ((b)localObject).hqq = false;
      ((b)localObject).aEZ = false;
      ((b)localObject).xVS = true;
      ((b)localObject).xVR = true;
      xVM.put(paramString, localObject);
    }
    Object localObject = new un();
    ((un)localObject).dxh.type = paramInt;
    ((un)localObject).dxh.id = paramString;
    a.GpY.l((b)localObject);
    AppMethodBeat.o(95942);
  }
  
  public static void eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (xVM.containsKey(paramString))
    {
      b localb = (b)xVM.get(paramString);
      localb.exP |= paramInt;
      xVM.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void eC(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (xVM.containsKey(paramString))
    {
      b localb = (b)xVM.get(paramString);
      localb.exP &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.xVS = true;
      }
      xVM.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (xVM.containsKey(paramString))
    {
      if ((((b)xVM.get(paramString)).exP & paramInt) != 0)
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
    a.GpY.c(xVO);
    AppMethodBeat.o(95931);
  }
  
  private static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (xVM.containsKey(paramString1))
    {
      localObject = (b)xVM.get(paramString1);
      ((b)localObject).hym = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).hqq = true;
      ((b)localObject).aEZ = bs.isNullOrNil(paramString2);
      xVM.put(paramString1, localObject);
    }
    if (bs.isNullOrNil(paramString2)) {
      Toast.makeText(ai.getContext(), 2131764043, 1).show();
    }
    Object localObject = new ul();
    ((ul)localObject).dxe.type = paramInt;
    ((ul)localObject).dxe.id = paramString1;
    ((ul)localObject).dxe.result = paramString2;
    ((ul)localObject).dxe.dxf = paramString3;
    a.GpY.l((b)localObject);
    AppMethodBeat.o(95943);
  }
  
  public static String jd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    a.GpY.d(xVO);
    AppMethodBeat.o(95932);
  }
  
  public static void v(p paramp)
  {
    AppMethodBeat.i(95936);
    if (paramp != null)
    {
      String str = paramp.getSnsId();
      ac.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramp.field_snsId == 0L)
      {
        ac.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        xVM.remove(str);
        j(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (xVM.containsKey(str))
      {
        localObject = (b)xVM.get(str);
        if ((((b)localObject).hqq) && (!((b)localObject).aEZ))
        {
          ac.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          j(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).hym);
          AppMethodBeat.o(95936);
          return;
        }
        xVM.remove(str);
      }
      if (paramp.dLV() != null)
      {
        localObject = paramp.dLV().FQl;
        wc localwc = new wc();
        localwc.dyW.id = str;
        localwc.dyW.dyX = ((String)localObject);
        localwc.dyW.type = 2;
        a.GpY.l(localwc);
        eA(paramp.getSnsId(), 1);
        paramp = new a((byte)0);
        paramp.id = str;
        paramp.xVP = ((String)localObject);
        paramp.type = 2;
        xVN.add(paramp);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void w(p paramp)
  {
    AppMethodBeat.i(95939);
    if (paramp != null)
    {
      paramp = paramp.getSnsId();
      b(atX(paramp));
      uo localuo = new uo();
      localuo.dxi.type = 1;
      localuo.dxi.id = paramp;
      a.GpY.l(localuo);
      ac.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramp });
    }
    AppMethodBeat.o(95939);
  }
  
  static final class a
  {
    String dxf;
    String id;
    int type;
    String xVP;
    String xVQ;
    
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
    public boolean aEZ;
    public int exP;
    public boolean hqq;
    public String hym;
    public String id;
    public String result;
    public boolean xVR;
    public boolean xVS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */