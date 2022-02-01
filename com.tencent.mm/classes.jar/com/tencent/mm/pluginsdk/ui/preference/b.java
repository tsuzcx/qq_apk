package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.gm.b;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import junit.framework.Assert;

public final class b
{
  public String FfV;
  public boolean dNR;
  public String hDo;
  public long id;
  public String jbt;
  public String nickname;
  public String username;
  public int yPa;
  
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
      localObject3 = bu.a.aUb(paramString2);
      localObject1 = ((bu.a)localObject3).dHm;
      localObject2 = ((bu.a)localObject3).nickname;
      localObject6 = ((bu.a)localObject3).IMm;
      localObject4 = ((bu.a)localObject3).IMn;
      i = ((bu.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.FfV = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        bu.d locald = bu.d.aUe(paramString2);
        String str1 = locald.dHm;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.IMC == 1)
        {
          localObject3 = locald.IME;
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
      localb.dNR = bool;
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
      localb.hDo = paramContext.getString(2131757168);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.hDo = paramContext.getString(2131757159);
      continue;
      paramString1 = new gm();
      paramString1.dso.dsl = paramString5;
      paramString1.dso.dsm = paramString6;
      a.IbL.l(paramString1);
      localb.hDo = paramContext.getString(2131757164, new Object[] { bt.bI(paramString1.dsp.dsq, "") });
      continue;
      localb.hDo = paramContext.getString(2131757175);
      continue;
      localb.hDo = paramContext.getString(2131757169);
      continue;
      localb.jbt = bu.a.aUb(paramString2).jbt;
      localb.hDo = paramContext.getString(2131757162);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.hDo = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.hDo = paramString7;
        } else {
          localb.hDo = paramContext.getString(2131761707);
        }
      }
    }
  }
  
  public static b a(Context paramContext, dv paramdv)
  {
    AppMethodBeat.i(31843);
    ad.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramdv.field_sayhiuser + ", scene = " + paramdv.field_scene);
    b localb = new b();
    localb.id = paramdv.systemRowid;
    if (paramdv.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dNR = bool;
      localb.username = paramdv.field_sayhiuser;
      localb.yPa = paramdv.field_scene;
      if (paramdv.field_isSend != 1) {
        break;
      }
      localb.hDo = paramdv.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramdv = bu.d.aUe(paramdv.field_content);
    if ((paramdv.content != null) && (!paramdv.content.trim().equals(""))) {}
    for (localb.hDo = paramdv.content;; localb.hDo = paramContext.getString(2131757177))
    {
      localb.nickname = paramdv.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, cd paramcd)
  {
    AppMethodBeat.i(31844);
    ad.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramcd.field_talker + ", scene = " + paramcd.field_scene);
    b localb = new b();
    localb.id = paramcd.systemRowid;
    if (paramcd.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.dNR = bool;
      localb.username = paramcd.field_sayhiuser;
      localb.yPa = paramcd.field_scene;
      if (paramcd.field_isSend != 1) {
        break;
      }
      localb.hDo = paramcd.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    paramcd = bu.d.aUe(paramcd.field_content);
    if ((paramcd.content != null) && (!paramcd.content.trim().equals(""))) {}
    for (localb.hDo = paramcd.content;; localb.hDo = paramContext.getString(2131757177))
    {
      localb.nickname = paramcd.nickname;
      break;
    }
  }
  
  public static am a(bh parambh)
  {
    AppMethodBeat.i(31850);
    am localam = new am();
    if (parambh == null)
    {
      AppMethodBeat.o(31850);
      return localam;
    }
    if (parambh.field_type == 0)
    {
      parambh = aNd(parambh.field_msgContent);
      AppMethodBeat.o(31850);
      return parambh;
    }
    parambh = aNe(parambh.field_msgContent);
    AppMethodBeat.o(31850);
    return parambh;
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
      paramString = bu.a.aUb(paramString);
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
      localObject = new gm();
      ((gm)localObject).dso.dsl = paramString.IMm;
      ((gm)localObject).dso.dsm = paramString.IMn;
      a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = paramContext.getString(2131757164, new Object[] { bt.bI(((gm)localObject).dsp.dsq, "") });
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
        paramString = bu.d.aUe(paramString);
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
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfdv != null) && (paramArrayOfdv.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
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
  
  public static b[] a(Context paramContext, bh[] paramArrayOfbh)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfbh == null) || (paramArrayOfbh.length == 0) || (paramArrayOfbh[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbh[0].field_talker)
    {
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbh != null) && (paramArrayOfbh.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfbh.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfbh[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, cd[] paramArrayOfcd)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfcd == null) || (paramArrayOfcd.length == 0) || (paramArrayOfcd[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcd[0].field_sayhiuser)
    {
      ad.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcd != null) && (paramArrayOfcd.length != 0)) {
        break;
      }
      ad.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfcd.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfcd[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static am aNd(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = bu.a.aUb(paramString);
    am localam = new am();
    localam.setUsername(paramString.dHm);
    localam.sQ(paramString.ffB);
    localam.sT(paramString.getDisplayName());
    localam.sU(paramString.jeU);
    localam.sV(paramString.jeV);
    localam.kf(paramString.ePk);
    localam.tl(paramString.getProvince());
    localam.tm(paramString.getCity());
    localam.tk(paramString.signature);
    localam.kb(paramString.DKi);
    localam.tp(paramString.ePz);
    localam.ty(paramString.FfL);
    AppMethodBeat.o(31851);
    return localam;
  }
  
  private static am aNe(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = bu.d.aUe(paramString);
    am localam = new am();
    localam.setUsername(paramString.dHm);
    localam.sQ(paramString.ffB);
    localam.sT(paramString.nickname);
    localam.sU(paramString.jeU);
    localam.sV(paramString.jeV);
    localam.kf(paramString.ePk);
    localam.tk(paramString.signature);
    localam.tl(paramString.getProvince());
    localam.tm(paramString.getCity());
    AppMethodBeat.o(31852);
    return localam;
  }
  
  public static b c(Context paramContext, bh parambh)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambh.systemRowid, parambh.frm(), parambh.field_talker, parambh.field_msgContent, parambh.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void cr(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    br[] arrayOfbr = null;
    cd[] arrayOfcd;
    Object localObject1;
    bh[] arrayOfbh;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ad.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfcd = d.aMq().aUx(paramString);
      localObject1 = a(aj.getContext(), arrayOfcd);
      arrayOfbh = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        ad.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbr = d.aMp().aTY(paramString);
        localObject1 = a(aj.getContext(), arrayOfbr);
        arrayOfcd = null;
        arrayOfbh = null;
      }
      else
      {
        arrayOfbh = d.aMn().aTV(paramString);
        localObject1 = a(aj.getContext(), arrayOfbh);
        arrayOfcd = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bu localbu;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbu = new bu();
      localbu.setContent(localObject2.hDo);
      m = w.Ar(localObject2.username);
      if (arrayOfbh != null)
      {
        j = paramInt + 1;
        localbu.qA(arrayOfbh[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localbu.tN(localObject2.username);
      localbu.setType(m);
      label252:
      long l;
      if (localObject2.dNR)
      {
        localbu.setStatus(2);
        localbu.kr(1);
        ba.aBQ();
        l = c.azs().as(localbu);
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
        if (arrayOfbr != null)
        {
          j = paramInt + 1;
          localbu.qA(arrayOfbr[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfcd == null) {
          break label546;
        }
        j = paramInt + 1;
        localbu.qA(arrayOfcd[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbu.setStatus(6);
        localbu.kr(0);
        break label252;
      }
      localObject1 = new bu();
      if (arrayOfbh != null) {
        ((bu)localObject1).qA(arrayOfbh[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bu)localObject1).tN(paramString);
        ((bu)localObject1).setContent(aj.getContext().getString(2131764537));
        ((bu)localObject1).setType(10000);
        ((bu)localObject1).setStatus(6);
        ((bu)localObject1).kr(0);
        ba.aBQ();
        ad.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.azs().as((bu)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbr != null) {
          ((bu)localObject1).qA(arrayOfbr[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcd != null) {
          ((bu)localObject1).qA(arrayOfcd[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */