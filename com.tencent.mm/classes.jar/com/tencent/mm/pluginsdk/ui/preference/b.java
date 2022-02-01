package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.a.gn.b;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import junit.framework.Assert;

public final class b
{
  public String Fyt;
  public boolean dPh;
  public String hGg;
  public long id;
  public String jem;
  public String nickname;
  public String username;
  public int zfk;
  
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
      localObject3 = bv.a.aVC(paramString2);
      localObject1 = ((bv.a)localObject3).cUA;
      localObject2 = ((bv.a)localObject3).nickname;
      localObject6 = ((bv.a)localObject3).JgT;
      localObject4 = ((bv.a)localObject3).JgU;
      i = ((bv.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.Fyt = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        bv.d locald = bv.d.aVF(paramString2);
        String str1 = locald.cUA;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.Jhj == 1)
        {
          localObject3 = locald.Jhl;
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
      localb.dPh = bool;
      ae.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label357;
      }
      if (paramString2 != null) {
        break;
      }
      ae.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(31842);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.hGg = paramContext.getString(2131757168);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.hGg = paramContext.getString(2131757159);
      continue;
      paramString1 = new gn();
      paramString1.dtv.dtr = paramString5;
      paramString1.dtv.dtt = paramString6;
      a.IvT.l(paramString1);
      localb.hGg = paramContext.getString(2131757164, new Object[] { bu.bI(paramString1.dtw.dtx, "") });
      continue;
      localb.hGg = paramContext.getString(2131757175);
      continue;
      localb.hGg = paramContext.getString(2131757169);
      continue;
      localb.jem = bv.a.aVC(paramString2).jem;
      localb.hGg = paramContext.getString(2131757162);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.hGg = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.hGg = paramString7;
        } else {
          localb.hGg = paramContext.getString(2131761707);
        }
      }
    }
  }
  
  public static b a(Context paramContext, dv paramdv)
  {
    AppMethodBeat.i(31843);
    ae.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramdv.field_sayhiuser + ", scene = " + paramdv.field_scene);
    b localb = new b();
    localb.id = paramdv.systemRowid;
    if (paramdv.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dPh = bool;
      localb.username = paramdv.field_sayhiuser;
      localb.zfk = paramdv.field_scene;
      if (paramdv.field_isSend != 1) {
        break;
      }
      localb.hGg = paramdv.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramdv = bv.d.aVF(paramdv.field_content);
    if ((paramdv.content != null) && (!paramdv.content.trim().equals(""))) {}
    for (localb.hGg = paramdv.content;; localb.hGg = paramContext.getString(2131757177))
    {
      localb.nickname = paramdv.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, ce paramce)
  {
    AppMethodBeat.i(31844);
    ae.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramce.field_talker + ", scene = " + paramce.field_scene);
    b localb = new b();
    localb.id = paramce.systemRowid;
    if (paramce.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dPh = bool;
      localb.username = paramce.field_sayhiuser;
      localb.zfk = paramce.field_scene;
      if (paramce.field_isSend != 1) {
        break;
      }
      localb.hGg = paramce.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    paramce = bv.d.aVF(paramce.field_content);
    if ((paramce.content != null) && (!paramce.content.trim().equals(""))) {}
    for (localb.hGg = paramce.content;; localb.hGg = paramContext.getString(2131757177))
    {
      localb.nickname = paramce.nickname;
      break;
    }
  }
  
  public static an a(bi parambi)
  {
    AppMethodBeat.i(31850);
    an localan = new an();
    if (parambi == null)
    {
      AppMethodBeat.o(31850);
      return localan;
    }
    if (parambi.field_type == 0)
    {
      parambi = aOA(parambi.field_msgContent);
      AppMethodBeat.o(31850);
      return parambi;
    }
    parambi = aOB(parambi.field_msgContent);
    AppMethodBeat.o(31850);
    return parambi;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31848);
    ae.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramInt1 == 0)
    {
      if (paramString == null)
      {
        ae.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
        AppMethodBeat.o(31848);
        return null;
      }
      paramString = bv.a.aVC(paramString);
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
      localObject = new gn();
      ((gn)localObject).dtv.dtr = paramString.JgT;
      ((gn)localObject).dtv.dtt = paramString.JgU;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = paramContext.getString(2131757164, new Object[] { bu.bI(((gn)localObject).dtw.dtx, "") });
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
        paramString = bv.d.aVF(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(2131759471);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, dv[] paramArrayOfdv)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfdv == null) || (paramArrayOfdv.length == 0) || (paramArrayOfdv[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfdv[0].field_sayhiuser)
    {
      ae.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfdv != null) && (paramArrayOfdv.length != 0)) {
        break;
      }
      ae.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfdv.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfdv[i]);
      i += 1;
    }
    AppMethodBeat.o(31846);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bi[] paramArrayOfbi)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfbi == null) || (paramArrayOfbi.length == 0) || (paramArrayOfbi[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbi[0].field_talker)
    {
      ae.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbi != null) && (paramArrayOfbi.length != 0)) {
        break;
      }
      ae.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfbi.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfbi[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, ce[] paramArrayOfce)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfce == null) || (paramArrayOfce.length == 0) || (paramArrayOfce[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfce[0].field_sayhiuser)
    {
      ae.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfce != null) && (paramArrayOfce.length != 0)) {
        break;
      }
      ae.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfce.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfce[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static an aOA(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = bv.a.aVC(paramString);
    an localan = new an();
    localan.setUsername(paramString.cUA);
    localan.tl(paramString.fhy);
    localan.to(paramString.getDisplayName());
    localan.tp(paramString.jhN);
    localan.tq(paramString.jhO);
    localan.kh(paramString.eQV);
    localan.tG(paramString.getProvince());
    localan.tH(paramString.getCity());
    localan.tF(paramString.signature);
    localan.kd(paramString.Ecg);
    localan.tK(paramString.eRk);
    localan.tT(paramString.Fyj);
    AppMethodBeat.o(31851);
    return localan;
  }
  
  private static an aOB(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = bv.d.aVF(paramString);
    an localan = new an();
    localan.setUsername(paramString.cUA);
    localan.tl(paramString.fhy);
    localan.to(paramString.nickname);
    localan.tp(paramString.jhN);
    localan.tq(paramString.jhO);
    localan.kh(paramString.eQV);
    localan.tF(paramString.signature);
    localan.tG(paramString.getProvince());
    localan.tH(paramString.getCity());
    AppMethodBeat.o(31852);
    return localan;
  }
  
  public static b c(Context paramContext, bi parambi)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambi.systemRowid, parambi.fvm(), parambi.field_talker, parambi.field_msgContent, parambi.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bs[] arrayOfbs = null;
    ce[] arrayOfce;
    Object localObject1;
    bi[] arrayOfbi;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ae.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfce = d.aMO().aVY(paramString);
      localObject1 = a(ak.getContext(), arrayOfce);
      arrayOfbi = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        ae.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbs = d.aMN().aVz(paramString);
        localObject1 = a(ak.getContext(), arrayOfbs);
        arrayOfce = null;
        arrayOfbi = null;
      }
      else
      {
        arrayOfbi = d.aML().aVw(paramString);
        localObject1 = a(ak.getContext(), arrayOfbi);
        arrayOfce = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bv localbv;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbv = new bv();
      localbv.setContent(localObject2.hGg);
      m = x.Bb(localObject2.username);
      if (arrayOfbi != null)
      {
        j = paramInt + 1;
        localbv.qN(arrayOfbi[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localbv.ui(localObject2.username);
      localbv.setType(m);
      label252:
      long l;
      if (localObject2.dPh)
      {
        localbv.setStatus(2);
        localbv.kt(1);
        bc.aCg();
        l = c.azI().ar(localbv);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ae.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbs != null)
        {
          j = paramInt + 1;
          localbv.qN(arrayOfbs[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfce == null) {
          break label546;
        }
        j = paramInt + 1;
        localbv.qN(arrayOfce[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbv.setStatus(6);
        localbv.kt(0);
        break label252;
      }
      localObject1 = new bv();
      if (arrayOfbi != null) {
        ((bv)localObject1).qN(arrayOfbi[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bv)localObject1).ui(paramString);
        ((bv)localObject1).setContent(ak.getContext().getString(2131764537));
        ((bv)localObject1).setType(10000);
        ((bv)localObject1).setStatus(6);
        ((bv)localObject1).kt(0);
        bc.aCg();
        ae.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.azI().ar((bv)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbs != null) {
          ((bv)localObject1).qN(arrayOfbs[0].field_createtime * 1000L + 1L);
        } else if (arrayOfce != null) {
          ((bv)localObject1).qN(arrayOfce[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */