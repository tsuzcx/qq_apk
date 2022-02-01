package com.tencent.mm.plugin.sns.model;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abb;
import com.tencent.mm.autogen.a.zh;
import com.tencent.mm.autogen.a.zj;
import com.tencent.mm.autogen.a.zk;
import com.tencent.mm.br.c;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class av
{
  private static HashMap<String, b> Qxn;
  private static LinkedList<a> Qxo;
  private static IListener Qxp;
  
  static
  {
    AppMethodBeat.i(95951);
    Qxn = new HashMap();
    Qxo = new LinkedList();
    Qxp = new SnsTranslateManager.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(95951);
  }
  
  public static void G(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95936);
    if (paramSnsInfo != null)
    {
      String str = paramSnsInfo.getSnsId();
      Log.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[] { str });
      if (paramSnsInfo.field_snsId == 0L)
      {
        Log.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
        Qxn.remove(str);
        j(str, 1, null, null);
        AppMethodBeat.o(95936);
        return;
      }
      Object localObject;
      if (Qxn.containsKey(str))
      {
        localObject = (b)Qxn.get(str);
        if ((((b)localObject).ooe) && (!((b)localObject).oss))
        {
          Log.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[] { str });
          j(((b)localObject).id, 1, ((b)localObject).result, ((b)localObject).brand);
          AppMethodBeat.o(95936);
          return;
        }
        Qxn.remove(str);
      }
      if (paramSnsInfo.getTimeLine() != null)
      {
        localObject = paramSnsInfo.getTimeLine().ContentDesc;
        abb localabb = new abb();
        localabb.ieG.id = str;
        localabb.ieG.ieH = ((String)localObject);
        localabb.ieG.type = 2;
        localabb.publish();
        gV(paramSnsInfo.getSnsId(), 1);
        paramSnsInfo = new a((byte)0);
        paramSnsInfo.id = str;
        paramSnsInfo.Qxq = ((String)localObject);
        paramSnsInfo.type = 2;
        Qxo.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(95936);
  }
  
  public static void H(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95939);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = paramSnsInfo.getSnsId();
      b(aYE(paramSnsInfo));
      zk localzk = new zk();
      localzk.icA.type = 1;
      localzk.icA.id = paramSnsInfo;
      localzk.publish();
      Log.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[] { paramSnsInfo });
    }
    AppMethodBeat.o(95939);
  }
  
  public static void a(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95934);
    if (aDO())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 14, 0, b.j.sns_translate);
        AppMethodBeat.o(95934);
        return;
      }
      paramMenu.add(0, 15, 0, b.j.sns_translate);
    }
    AppMethodBeat.o(95934);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(95937);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.Qxs = false;
    }
    for (;;)
    {
      Qxn.put(paramb.id, paramb);
      AppMethodBeat.o(95937);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.Qxt = false;
      }
    }
  }
  
  public static void a(m paramm)
  {
    AppMethodBeat.i(95940);
    if ((paramm != null) && (paramm.Qsv != null))
    {
      String str = paramm.nUB;
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.SnsTranslateManager", "commentContent is empty, quit translate");
        AppMethodBeat.o(95940);
        return;
      }
      Object localObject = new StringBuilder();
      if (paramm.Qsv.abDh != 0) {}
      for (long l = paramm.Qsv.abDh;; l = paramm.Qsv.abDj)
      {
        localObject = l;
        paramm = mj(paramm.Rcm, (String)localObject);
        if (!Qxn.containsKey(paramm)) {
          break label191;
        }
        localObject = (b)Qxn.get(paramm);
        if ((!((b)localObject).ooe) || (Util.isNullOrNil(((b)localObject).result))) {
          break;
        }
        Log.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[] { paramm });
        j(((b)localObject).id, 2, ((b)localObject).result, ((b)localObject).brand);
        AppMethodBeat.o(95940);
        return;
      }
      Qxn.remove(paramm);
      label191:
      localObject = new abb();
      ((abb)localObject).ieG.id = paramm;
      ((abb)localObject).ieG.ieH = str;
      ((abb)localObject).ieG.type = 3;
      ((abb)localObject).publish();
      gV(paramm, 2);
      localObject = new a((byte)0);
      ((a)localObject).id = paramm;
      ((a)localObject).Qxq = str;
      ((a)localObject).type = 3;
      Qxo.add(localObject);
      Log.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[] { ((a)localObject).id });
    }
    AppMethodBeat.o(95940);
  }
  
  private static boolean aDO()
  {
    AppMethodBeat.i(95933);
    if (!c.blq("translate"))
    {
      AppMethodBeat.o(95933);
      return false;
    }
    String str = i.aRC().getValue("TranslateSnsOff");
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
  
  public static b aYE(String paramString)
  {
    AppMethodBeat.i(95948);
    if (Qxn.containsKey(paramString))
    {
      paramString = (b)Qxn.get(paramString);
      AppMethodBeat.o(95948);
      return paramString;
    }
    AppMethodBeat.o(95948);
    return null;
  }
  
  public static void b(Menu paramMenu, boolean paramBoolean)
  {
    AppMethodBeat.i(95935);
    if (aDO())
    {
      if (paramBoolean)
      {
        paramMenu.add(0, 16, 0, b.j.sns_translate_original);
        AppMethodBeat.o(95935);
        return;
      }
      paramMenu.add(0, 17, 0, b.j.sns_translate_original);
    }
    AppMethodBeat.o(95935);
  }
  
  private static void b(b paramb)
  {
    AppMethodBeat.i(95938);
    if ((paramb.showFlag & 0x2) != 0) {
      paramb.Qxs = true;
    }
    for (;;)
    {
      Qxn.put(paramb.id, paramb);
      AppMethodBeat.o(95938);
      return;
      if ((paramb.showFlag & 0x4) != 0) {
        paramb.Qxt = true;
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
      if (paramm.Qsv.abDh == 0) {
        break label114;
      }
    }
    label114:
    for (long l = paramm.Qsv.abDh;; l = paramm.Qsv.abDj)
    {
      localObject = l;
      paramm = mj(paramm.Rcm, (String)localObject);
      b(aYE(paramm));
      localObject = new zk();
      ((zk)localObject).icA.type = 2;
      ((zk)localObject).icA.id = paramm;
      ((zk)localObject).publish();
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
  
  private static void gV(String paramString, int paramInt)
  {
    AppMethodBeat.i(95942);
    if (!Qxn.containsKey(paramString))
    {
      localObject = new b();
      ((b)localObject).id = paramString;
      ((b)localObject).brand = null;
      ((b)localObject).result = null;
      ((b)localObject).ooe = false;
      ((b)localObject).oss = false;
      ((b)localObject).Qxt = true;
      ((b)localObject).Qxs = true;
      Qxn.put(paramString, localObject);
    }
    Object localObject = new zj();
    ((zj)localObject).icz.type = paramInt;
    ((zj)localObject).icz.id = paramString;
    ((zj)localObject).publish();
    AppMethodBeat.o(95942);
  }
  
  public static void gW(String paramString, int paramInt)
  {
    AppMethodBeat.i(95945);
    if (Qxn.containsKey(paramString))
    {
      b localb = (b)Qxn.get(paramString);
      localb.showFlag |= paramInt;
      Qxn.put(paramString, localb);
    }
    AppMethodBeat.o(95945);
  }
  
  public static void gX(String paramString, int paramInt)
  {
    AppMethodBeat.i(95946);
    if (Qxn.containsKey(paramString))
    {
      b localb = (b)Qxn.get(paramString);
      localb.showFlag &= (paramInt ^ 0xFFFFFFFF);
      if ((paramInt != 2) && (paramInt == 4)) {
        localb.Qxt = true;
      }
      Qxn.put(paramString, localb);
    }
    AppMethodBeat.o(95946);
  }
  
  public static boolean gY(String paramString, int paramInt)
  {
    AppMethodBeat.i(95947);
    if (Qxn.containsKey(paramString))
    {
      if ((((b)Qxn.get(paramString)).showFlag & paramInt) != 0)
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
  
  public static HashMap<String, b> hho()
  {
    return Qxn;
  }
  
  public static void init()
  {
    AppMethodBeat.i(95931);
    Qxp.alive();
    AppMethodBeat.o(95931);
  }
  
  private static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95943);
    if (Qxn.containsKey(paramString1))
    {
      localObject = (b)Qxn.get(paramString1);
      ((b)localObject).brand = paramString3;
      ((b)localObject).result = paramString2;
      ((b)localObject).ooe = true;
      ((b)localObject).oss = Util.isNullOrNil(paramString2);
      Qxn.put(paramString1, localObject);
    }
    if (Util.isNullOrNil(paramString2)) {
      Toast.makeText(MMApplicationContext.getContext(), b.j.sns_translate_failed, 1).show();
    }
    Object localObject = new zh();
    ((zh)localObject).icw.type = paramInt;
    ((zh)localObject).icw.id = paramString1;
    ((zh)localObject).icw.result = paramString2;
    ((zh)localObject).icw.icx = paramString3;
    ((zh)localObject).publish();
    AppMethodBeat.o(95943);
  }
  
  public static String mj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95944);
    paramString1 = paramString1 + ";" + paramString2;
    AppMethodBeat.o(95944);
    return paramString1;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(95932);
    Qxp.dead();
    AppMethodBeat.o(95932);
  }
  
  static final class a
  {
    String Qxq;
    String Qxr;
    String icx;
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
    public boolean Qxs;
    public boolean Qxt;
    public String brand;
    public String id;
    public boolean ooe;
    public boolean oss;
    public String result;
    public int showFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */