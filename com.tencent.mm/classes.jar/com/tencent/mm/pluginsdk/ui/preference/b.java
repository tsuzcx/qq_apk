package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.gj.b;
import com.tencent.mm.g.c.dl;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import junit.framework.Assert;

public final class b
{
  public String DAO;
  public boolean dBE;
  public String hlf;
  public String iIk;
  public long id;
  public String nickname;
  public String username;
  public int xAq;
  
  private static b a(Context paramContext, long paramLong, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(31841);
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject5 = null;
    Object localObject7 = null;
    int j = 0;
    Object localObject3;
    Object localObject6;
    Object localObject4;
    int i;
    if (paramInt == 0)
    {
      localObject3 = bo.a.aOk(paramString2);
      localObject1 = ((bo.a)localObject3).zTO;
      localObject2 = ((bo.a)localObject3).nickname;
      localObject6 = ((bo.a)localObject3).GYX;
      localObject4 = ((bo.a)localObject3).GYY;
      i = ((bo.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.DAO = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        bo.d locald = bo.d.aOn(paramString2);
        String str1 = locald.zTO;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.GZn == 1)
        {
          localObject3 = locald.GZp;
          localObject1 = str1;
          localObject2 = str2;
          localObject6 = localObject8;
          localObject4 = localObject9;
          localObject5 = str3;
          i = j;
        }
      }
    }
  }
  
  public static b a(Context paramContext, long paramLong, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2)
  {
    AppMethodBeat.i(31842);
    b localb = new b();
    localb.id = paramLong;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dBE = bool;
      ac.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label357;
      }
      if (paramString2 != null) {
        break;
      }
      ac.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(31842);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.hlf = paramContext.getString(2131757168);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.hlf = paramContext.getString(2131757159);
      continue;
      paramString1 = new gj();
      paramString1.dgR.dgO = paramString5;
      paramString1.dgR.dgP = paramString6;
      a.GpY.l(paramString1);
      localb.hlf = paramContext.getString(2131757164, new Object[] { bs.bG(paramString1.dgS.dgT, "") });
      continue;
      localb.hlf = paramContext.getString(2131757175);
      continue;
      localb.hlf = paramContext.getString(2131757169);
      continue;
      localb.iIk = bo.a.aOk(paramString2).iIk;
      localb.hlf = paramContext.getString(2131757162);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.hlf = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.hlf = paramString7;
        } else {
          localb.hlf = paramContext.getString(2131761707);
        }
      }
    }
  }
  
  public static b a(Context paramContext, dl paramdl)
  {
    AppMethodBeat.i(31843);
    ac.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramdl.field_sayhiuser + ", scene = " + paramdl.field_scene);
    b localb = new b();
    localb.id = paramdl.systemRowid;
    if (paramdl.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dBE = bool;
      localb.username = paramdl.field_sayhiuser;
      localb.xAq = paramdl.field_scene;
      if (paramdl.field_isSend != 1) {
        break;
      }
      localb.hlf = paramdl.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramdl = bo.d.aOn(paramdl.field_content);
    if ((paramdl.content != null) && (!paramdl.content.trim().equals(""))) {}
    for (localb.hlf = paramdl.content;; localb.hlf = paramContext.getString(2131757177))
    {
      localb.nickname = paramdl.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, bx parambx)
  {
    AppMethodBeat.i(31844);
    ac.d("MicroMsg.FMessageProvider", "build shake, talker = " + parambx.field_talker + ", scene = " + parambx.field_scene);
    b localb = new b();
    localb.id = parambx.systemRowid;
    if (parambx.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dBE = bool;
      localb.username = parambx.field_sayhiuser;
      localb.xAq = parambx.field_scene;
      if (parambx.field_isSend != 1) {
        break;
      }
      localb.hlf = parambx.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    parambx = bo.d.aOn(parambx.field_content);
    if ((parambx.content != null) && (!parambx.content.trim().equals(""))) {}
    for (localb.hlf = parambx.content;; localb.hlf = paramContext.getString(2131757177))
    {
      localb.nickname = parambx.nickname;
      break;
    }
  }
  
  public static com.tencent.mm.storage.ai a(bd parambd)
  {
    AppMethodBeat.i(31850);
    com.tencent.mm.storage.ai localai = new com.tencent.mm.storage.ai();
    if (parambd == null)
    {
      AppMethodBeat.o(31850);
      return localai;
    }
    if (parambd.field_type == 0)
    {
      parambd = aHA(parambd.field_msgContent);
      AppMethodBeat.o(31850);
      return parambd;
    }
    parambd = aHB(parambd.field_msgContent);
    AppMethodBeat.o(31850);
    return parambd;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31848);
    ac.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramInt1 == 0)
    {
      if (paramString == null)
      {
        ac.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
        AppMethodBeat.o(31848);
        return null;
      }
      paramString = bo.a.aOk(paramString);
      switch (paramString.scene)
      {
      default: 
        localObject = paramContext.getString(2131757168);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31848);
      return localObject;
      localObject = paramContext.getString(2131757159);
      continue;
      localObject = new gj();
      ((gj)localObject).dgR.dgO = paramString.GYX;
      ((gj)localObject).dgR.dgP = paramString.GYY;
      a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = paramContext.getString(2131757164, new Object[] { bs.bG(((gj)localObject).dgS.dgT, "") });
      continue;
      localObject = paramContext.getString(2131757175);
      continue;
      localObject = paramContext.getString(2131757169);
      continue;
      localObject = paramContext.getString(2131757162);
      continue;
      localObject = paramString;
      if (!paramBoolean)
      {
        paramString = bo.d.aOn(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(2131759471);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, dl[] paramArrayOfdl)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfdl == null) || (paramArrayOfdl.length == 0) || (paramArrayOfdl[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfdl[0].field_sayhiuser)
    {
      ac.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfdl != null) && (paramArrayOfdl.length != 0)) {
        break;
      }
      ac.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfdl.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfdl[i]);
      i += 1;
    }
    AppMethodBeat.o(31846);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bd[] paramArrayOfbd)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfbd == null) || (paramArrayOfbd.length == 0) || (paramArrayOfbd[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbd[0].field_talker)
    {
      ac.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbd != null) && (paramArrayOfbd.length != 0)) {
        break;
      }
      ac.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfbd.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfbd[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bx[] paramArrayOfbx)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfbx == null) || (paramArrayOfbx.length == 0) || (paramArrayOfbx[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbx[0].field_sayhiuser)
    {
      ac.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbx != null) && (paramArrayOfbx.length != 0)) {
        break;
      }
      ac.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfbx.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfbx[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static com.tencent.mm.storage.ai aHA(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = bo.a.aOk(paramString);
    com.tencent.mm.storage.ai localai = new com.tencent.mm.storage.ai();
    localai.setUsername(paramString.zTO);
    localai.qg(paramString.eNf);
    localai.qj(paramString.getDisplayName());
    localai.qk(paramString.iLL);
    localai.ql(paramString.iLM);
    localai.jH(paramString.exL);
    localai.qB(paramString.getProvince());
    localai.qC(paramString.getCity());
    localai.qA(paramString.signature);
    localai.jD(paramString.Chb);
    localai.qF(paramString.eya);
    localai.qO(paramString.DAE);
    AppMethodBeat.o(31851);
    return localai;
  }
  
  private static com.tencent.mm.storage.ai aHB(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = bo.d.aOn(paramString);
    com.tencent.mm.storage.ai localai = new com.tencent.mm.storage.ai();
    localai.setUsername(paramString.zTO);
    localai.qg(paramString.eNf);
    localai.qj(paramString.nickname);
    localai.qk(paramString.iLL);
    localai.ql(paramString.iLM);
    localai.jH(paramString.exL);
    localai.qA(paramString.signature);
    localai.qB(paramString.getProvince());
    localai.qC(paramString.getCity());
    AppMethodBeat.o(31852);
    return localai;
  }
  
  public static b c(Context paramContext, bd parambd)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambd.systemRowid, parambd.fbj(), parambd.field_talker, parambd.field_msgContent, parambd.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void co(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bl[] arrayOfbl = null;
    bx[] arrayOfbx;
    Object localObject1;
    bd[] arrayOfbd;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ac.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfbx = d.aJg().aOG(paramString);
      localObject1 = a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbx);
      arrayOfbd = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        ac.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbl = d.aJf().aOh(paramString);
        localObject1 = a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbl);
        arrayOfbx = null;
        arrayOfbd = null;
      }
      else
      {
        arrayOfbd = d.aJd().aOe(paramString);
        localObject1 = a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbd);
        arrayOfbx = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bo localbo;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbo = new bo();
      localbo.setContent(localObject2.hlf);
      m = w.xt(localObject2.username);
      if (arrayOfbd != null)
      {
        j = paramInt + 1;
        localbo.oA(arrayOfbd[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localbo.re(localObject2.username);
      localbo.setType(m);
      label252:
      long l;
      if (localObject2.dBE)
      {
        localbo.setStatus(2);
        localbo.jT(1);
        az.ayM();
        l = c.awD().ap(localbo);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ac.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbl != null)
        {
          j = paramInt + 1;
          localbo.oA(arrayOfbl[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbx == null) {
          break label546;
        }
        j = paramInt + 1;
        localbo.oA(arrayOfbx[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbo.setStatus(6);
        localbo.jT(0);
        break label252;
      }
      localObject1 = new bo();
      if (arrayOfbd != null) {
        ((bo)localObject1).oA(arrayOfbd[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bo)localObject1).re(paramString);
        ((bo)localObject1).setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764537));
        ((bo)localObject1).setType(10000);
        ((bo)localObject1).setStatus(6);
        ((bo)localObject1).jT(0);
        az.ayM();
        ac.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.awD().ap((bo)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbl != null) {
          ((bo)localObject1).oA(arrayOfbl[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbx != null) {
          ((bo)localObject1).oA(arrayOfbx[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */