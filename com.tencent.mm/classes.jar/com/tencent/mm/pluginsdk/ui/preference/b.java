package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.c.dj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class b
{
  public String Cix;
  public boolean dDS;
  public String gKF;
  public long id;
  public String iic;
  public String nickname;
  public String username;
  public int woZ;
  
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
      localObject3 = bl.a.aIO(paramString2);
      localObject1 = ((bl.a)localObject3).yGA;
      localObject2 = ((bl.a)localObject3).nickname;
      localObject6 = ((bl.a)localObject3).FzV;
      localObject4 = ((bl.a)localObject3).FzW;
      i = ((bl.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.Cix = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        bl.d locald = bl.d.aIR(paramString2);
        String str1 = locald.yGA;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.FAl == 1)
        {
          localObject3 = locald.FAn;
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
      localb.dDS = bool;
      ad.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label357;
      }
      if (paramString2 != null) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(31842);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.gKF = paramContext.getString(2131757168);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.gKF = paramContext.getString(2131757159);
      continue;
      paramString1 = new gi();
      paramString1.djw.djt = paramString5;
      paramString1.djw.dju = paramString6;
      a.ESL.l(paramString1);
      localb.gKF = paramContext.getString(2131757164, new Object[] { bt.by(paramString1.djx.djy, "") });
      continue;
      localb.gKF = paramContext.getString(2131757175);
      continue;
      localb.gKF = paramContext.getString(2131757169);
      continue;
      localb.iic = bl.a.aIO(paramString2).iic;
      localb.gKF = paramContext.getString(2131757162);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.gKF = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.gKF = paramString7;
        } else {
          localb.gKF = paramContext.getString(2131761707);
        }
      }
    }
  }
  
  public static b a(Context paramContext, dj paramdj)
  {
    AppMethodBeat.i(31843);
    ad.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramdj.field_sayhiuser + ", scene = " + paramdj.field_scene);
    b localb = new b();
    localb.id = paramdj.systemRowid;
    if (paramdj.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dDS = bool;
      localb.username = paramdj.field_sayhiuser;
      localb.woZ = paramdj.field_scene;
      if (paramdj.field_isSend != 1) {
        break;
      }
      localb.gKF = paramdj.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramdj = bl.d.aIR(paramdj.field_content);
    if ((paramdj.content != null) && (!paramdj.content.trim().equals(""))) {}
    for (localb.gKF = paramdj.content;; localb.gKF = paramContext.getString(2131757177))
    {
      localb.nickname = paramdj.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, bu parambu)
  {
    AppMethodBeat.i(31844);
    ad.d("MicroMsg.FMessageProvider", "build shake, talker = " + parambu.field_talker + ", scene = " + parambu.field_scene);
    b localb = new b();
    localb.id = parambu.systemRowid;
    if (parambu.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dDS = bool;
      localb.username = parambu.field_sayhiuser;
      localb.woZ = parambu.field_scene;
      if (parambu.field_isSend != 1) {
        break;
      }
      localb.gKF = parambu.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    parambu = bl.d.aIR(parambu.field_content);
    if ((parambu.content != null) && (!parambu.content.trim().equals(""))) {}
    for (localb.gKF = parambu.content;; localb.gKF = paramContext.getString(2131757177))
    {
      localb.nickname = parambu.nickname;
      break;
    }
  }
  
  public static af a(ba paramba)
  {
    AppMethodBeat.i(31850);
    af localaf = new af();
    if (paramba == null)
    {
      AppMethodBeat.o(31850);
      return localaf;
    }
    if (paramba.field_type == 0)
    {
      paramba = aCi(paramba.field_msgContent);
      AppMethodBeat.o(31850);
      return paramba;
    }
    paramba = aCj(paramba.field_msgContent);
    AppMethodBeat.o(31850);
    return paramba;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31848);
    ad.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramInt1 == 0)
    {
      if (paramString == null)
      {
        ad.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
        AppMethodBeat.o(31848);
        return null;
      }
      paramString = bl.a.aIO(paramString);
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
      localObject = new gi();
      ((gi)localObject).djw.djt = paramString.FzV;
      ((gi)localObject).djw.dju = paramString.FzW;
      a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = paramContext.getString(2131757164, new Object[] { bt.by(((gi)localObject).djx.djy, "") });
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
        paramString = bl.d.aIR(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(2131759471);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, dj[] paramArrayOfdj)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfdj == null) || (paramArrayOfdj.length == 0) || (paramArrayOfdj[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfdj[0].field_sayhiuser)
    {
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfdj != null) && (paramArrayOfdj.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfdj.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfdj[i]);
      i += 1;
    }
    AppMethodBeat.o(31846);
    return localObject;
  }
  
  public static b[] a(Context paramContext, ba[] paramArrayOfba)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfba == null) || (paramArrayOfba.length == 0) || (paramArrayOfba[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfba[0].field_talker)
    {
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfba != null) && (paramArrayOfba.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfba.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfba[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bu[] paramArrayOfbu)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfbu == null) || (paramArrayOfbu.length == 0) || (paramArrayOfbu[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbu[0].field_sayhiuser)
    {
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbu != null) && (paramArrayOfbu.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfbu.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfbu[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static af aCi(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = bl.a.aIO(paramString);
    af localaf = new af();
    localaf.setUsername(paramString.yGA);
    localaf.na(paramString.eKn);
    localaf.nd(paramString.getDisplayName());
    localaf.ne(paramString.ilE);
    localaf.nf(paramString.ilF);
    localaf.jJ(paramString.evp);
    localaf.nv(paramString.getProvince());
    localaf.nw(paramString.getCity());
    localaf.nu(paramString.signature);
    localaf.jF(paramString.AOL);
    localaf.nz(paramString.evE);
    localaf.nI(paramString.Cin);
    AppMethodBeat.o(31851);
    return localaf;
  }
  
  private static af aCj(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = bl.d.aIR(paramString);
    af localaf = new af();
    localaf.setUsername(paramString.yGA);
    localaf.na(paramString.eKn);
    localaf.nd(paramString.nickname);
    localaf.ne(paramString.ilE);
    localaf.nf(paramString.ilF);
    localaf.jJ(paramString.evp);
    localaf.nu(paramString.signature);
    localaf.nv(paramString.getProvince());
    localaf.nw(paramString.getCity());
    AppMethodBeat.o(31852);
    return localaf;
  }
  
  public static b c(Context paramContext, ba paramba)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, paramba.systemRowid, paramba.eLF(), paramba.field_talker, paramba.field_msgContent, paramba.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bi[] arrayOfbi = null;
    bu[] arrayOfbu;
    Object localObject1;
    ba[] arrayOfba;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ad.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfbu = d.aCq().aJk(paramString);
      localObject1 = a(aj.getContext(), arrayOfbu);
      arrayOfba = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        ad.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbi = d.aCp().aIL(paramString);
        localObject1 = a(aj.getContext(), arrayOfbi);
        arrayOfbu = null;
        arrayOfba = null;
      }
      else
      {
        arrayOfba = d.aCn().aII(paramString);
        localObject1 = a(aj.getContext(), arrayOfba);
        arrayOfbu = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bl localbl;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbl = new bl();
      localbl.setContent(localObject2.gKF);
      m = w.tq(localObject2.username);
      if (arrayOfba != null)
      {
        j = paramInt + 1;
        localbl.kY(arrayOfba[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localbl.nY(localObject2.username);
      localbl.setType(m);
      label252:
      long l;
      if (localObject2.dDS)
      {
        localbl.setStatus(2);
        localbl.jV(1);
        az.arV();
        l = c.apO().an(localbl);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ad.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbi != null)
        {
          j = paramInt + 1;
          localbl.kY(arrayOfbi[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbu == null) {
          break label546;
        }
        j = paramInt + 1;
        localbl.kY(arrayOfbu[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbl.setStatus(6);
        localbl.jV(0);
        break label252;
      }
      localObject1 = new bl();
      if (arrayOfba != null) {
        ((bl)localObject1).kY(arrayOfba[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bl)localObject1).nY(paramString);
        ((bl)localObject1).setContent(aj.getContext().getString(2131764537));
        ((bl)localObject1).setType(10000);
        ((bl)localObject1).setStatus(6);
        ((bl)localObject1).jV(0);
        az.arV();
        ad.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.apO().an((bl)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbi != null) {
          ((bl)localObject1).kY(arrayOfbi[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbu != null) {
          ((bl)localObject1).kY(arrayOfbu[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */