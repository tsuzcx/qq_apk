package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.hi;
import com.tencent.mm.autogen.a.hi.b;
import com.tencent.mm.autogen.b.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelverify.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import junit.framework.Assert;

public final class b
{
  public int PCB;
  public String Ymx;
  public long id;
  public boolean ihD;
  public String nUO;
  public String nickname;
  public String pQw;
  public String username;
  
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
      localObject3 = cc.a.bys(paramString2);
      localObject1 = ((cc.a)localObject3).hgk;
      localObject2 = ((cc.a)localObject3).nickname;
      localObject6 = ((cc.a)localObject3).adkz;
      localObject4 = ((cc.a)localObject3).adkA;
      i = ((cc.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.Ymx = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        cc.f localf = cc.f.byv(paramString2);
        String str1 = localf.hgk;
        String str2 = localf.nickname;
        String str3 = localf.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (localf.adkR == 1)
        {
          localObject3 = localf.adkT;
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
      localb.ihD = bool;
      Log.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label360;
      }
      if (paramString2 != null) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(31842);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.nUO = paramContext.getString(R.l.gxr);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.nUO = paramContext.getString(R.l.gxn);
      continue;
      paramString1 = new hi();
      paramString1.hIj.hIg = paramString5;
      paramString1.hIj.hIh = paramString6;
      paramString1.publish();
      localb.nUO = paramContext.getString(R.l.gxp, new Object[] { Util.nullAs(paramString1.hIk.hIl, "") });
      continue;
      localb.nUO = paramContext.getString(R.l.gxy);
      continue;
      localb.nUO = paramContext.getString(R.l.gxs);
      continue;
      localb.pQw = cc.a.bys(paramString2).pQw;
      localb.nUO = paramContext.getString(R.l.chatting_from_google_contact);
      continue;
      label360:
      if (!paramBoolean)
      {
        if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3))
        {
          paramContext = cc.f.byv(paramString2);
          if (paramContext != null)
          {
            Log.i("MicroMsg.FMessageProvider", "fmsgTalker = " + paramString1 + ", verifygetusernmae = " + paramContext.hgk + ", fmsgType = " + paramInt1 + ", fmsgContent = " + paramString2);
            localb.nickname = paramContext.nickname;
            if ((paramContext.content != null) && (!Util.isNullOrNil(paramContext.content.trim()))) {
              localb.nUO = paramContext.content;
            }
          }
          for (;;)
          {
            localb.username = paramString1;
            break;
            localb.nUO = "";
            Log.e("MicroMsg.FMessageProvider", "fmsgContent = %s", new Object[] { paramString2 });
            continue;
            localb.nUO = paramString2;
          }
        }
        localb.username = paramString1;
        localb.nUO = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.nUO = paramString7;
        } else {
          localb.nUO = paramContext.getString(R.l.gPK);
        }
      }
    }
  }
  
  public static b a(Context paramContext, et paramet)
  {
    AppMethodBeat.i(31843);
    Log.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramet.field_sayhiuser + ", scene = " + paramet.field_scene);
    b localb = new b();
    localb.id = paramet.systemRowid;
    if (paramet.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ihD = bool;
      localb.username = paramet.field_sayhiuser;
      localb.PCB = paramet.field_scene;
      if (paramet.field_isSend != 1) {
        break;
      }
      localb.nUO = paramet.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramet = cc.f.byv(paramet.field_content);
    if ((paramet.content != null) && (!paramet.content.trim().equals(""))) {}
    for (localb.nUO = paramet.content;; localb.nUO = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = paramet.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, cp paramcp)
  {
    AppMethodBeat.i(31844);
    Log.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramcp.field_talker + ", scene = " + paramcp.field_scene);
    b localb = new b();
    localb.id = paramcp.systemRowid;
    if (paramcp.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ihD = bool;
      localb.username = paramcp.field_sayhiuser;
      localb.PCB = paramcp.field_scene;
      if (paramcp.field_isSend != 1) {
        break;
      }
      localb.nUO = paramcp.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    paramcp = cc.f.byv(paramcp.field_content);
    if ((paramcp.content != null) && (!paramcp.content.trim().equals(""))) {}
    for (localb.nUO = paramcp.content;; localb.nUO = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = paramcp.nickname;
      break;
    }
  }
  
  public static au a(bp parambp)
  {
    AppMethodBeat.i(31850);
    au localau = new au();
    if (parambp == null)
    {
      AppMethodBeat.o(31850);
      return localau;
    }
    if (parambp.field_type == 0)
    {
      parambp = brm(parambp.field_msgContent);
      AppMethodBeat.o(31850);
      return parambp;
    }
    parambp = brn(parambp.field_msgContent);
    AppMethodBeat.o(31850);
    return parambp;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31848);
    Log.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramInt1 == 0)
    {
      if (paramString == null)
      {
        Log.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
        AppMethodBeat.o(31848);
        return null;
      }
      paramString = cc.a.bys(paramString);
      switch (paramString.scene)
      {
      default: 
        localObject = paramContext.getString(R.l.gxr);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31848);
      return localObject;
      localObject = paramContext.getString(R.l.gxn);
      continue;
      localObject = new hi();
      ((hi)localObject).hIj.hIg = paramString.adkz;
      ((hi)localObject).hIj.hIh = paramString.adkA;
      ((hi)localObject).publish();
      localObject = paramContext.getString(R.l.gxp, new Object[] { Util.nullAs(((hi)localObject).hIk.hIl, "") });
      continue;
      localObject = paramContext.getString(R.l.gxy);
      continue;
      localObject = paramContext.getString(R.l.gxs);
      continue;
      localObject = paramContext.getString(R.l.chatting_from_google_contact);
      continue;
      localObject = paramString;
      if (!paramBoolean)
      {
        paramString = cc.f.byv(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(R.l.gIf);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, et[] paramArrayOfet)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfet == null) || (paramArrayOfet.length == 0) || (paramArrayOfet[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfet[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfet != null) && (paramArrayOfet.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfet.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfet[i]);
      i += 1;
    }
    AppMethodBeat.o(31846);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bp[] paramArrayOfbp)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfbp == null) || (paramArrayOfbp.length == 0) || (paramArrayOfbp[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbp[0].field_talker)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbp != null) && (paramArrayOfbp.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfbp.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfbp[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, cp[] paramArrayOfcp)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfcp == null) || (paramArrayOfcp.length == 0) || (paramArrayOfcp[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcp[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcp != null) && (paramArrayOfcp.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfcp.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfcp[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static au brm(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = cc.a.bys(paramString);
    au localau = new au();
    localau.setUsername(paramString.hgk);
    localau.AV(paramString.kDc);
    localau.setNickname(paramString.getDisplayName());
    localau.AY(paramString.pTX);
    localau.AZ(paramString.pTY);
    localau.pv(paramString.sex);
    localau.Bp(paramString.getProvince());
    localau.Bq(paramString.getCity());
    localau.Bo(paramString.signature);
    localau.pr(paramString.WAW);
    localau.Bt(paramString.verifyInfo);
    localau.BC(paramString.Ymm);
    AppMethodBeat.o(31851);
    return localau;
  }
  
  private static au brn(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = cc.f.byv(paramString);
    au localau = new au();
    localau.setUsername(paramString.hgk);
    localau.AV(paramString.kDc);
    localau.setNickname(paramString.nickname);
    localau.AY(paramString.pTX);
    localau.AZ(paramString.pTY);
    localau.pv(paramString.sex);
    localau.Bo(paramString.signature);
    localau.Bp(paramString.getProvince());
    localau.Bq(paramString.getCity());
    AppMethodBeat.o(31852);
    return localau;
  }
  
  public static b c(Context paramContext, bp parambp)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambp.systemRowid, parambp.jbg(), parambp.field_talker, parambp.field_msgContent, parambp.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bz[] arrayOfbz = null;
    cp[] arrayOfcp;
    Object localObject1;
    bp[] arrayOfbp;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfcp = d.bNK().byO(paramString);
      localObject1 = a(MMApplicationContext.getContext(), arrayOfcp);
      arrayOfbp = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbz = d.bNJ().byp(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbz);
        arrayOfcp = null;
        arrayOfbp = null;
      }
      else
      {
        arrayOfbp = d.bNH().bym(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbp);
        arrayOfcp = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    cc localcc;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localcc = new cc();
      localcc.setContent(localObject2.nUO);
      m = ab.IX(localObject2.username);
      if (arrayOfbp != null)
      {
        j = paramInt + 1;
        localcc.setCreateTime(arrayOfbp[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localcc.BS(localObject2.username);
      localcc.setType(m);
      label252:
      long l;
      if (localObject2.ihD)
      {
        localcc.setStatus(2);
        localcc.pI(1);
        bh.bCz();
        l = c.bzD().ba(localcc);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbz != null)
        {
          j = paramInt + 1;
          localcc.setCreateTime(arrayOfbz[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfcp == null) {
          break label546;
        }
        j = paramInt + 1;
        localcc.setCreateTime(arrayOfcp[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localcc.setStatus(6);
        localcc.pI(0);
        break label252;
      }
      localObject1 = new cc();
      if (arrayOfbp != null) {
        ((cc)localObject1).setCreateTime(arrayOfbp[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((cc)localObject1).BS(paramString);
        ((cc)localObject1).setContent(MMApplicationContext.getContext().getString(R.l.gXv));
        ((cc)localObject1).setType(10000);
        ((cc)localObject1).setStatus(6);
        ((cc)localObject1).pI(0);
        bh.bCz();
        Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.bzD().ba((cc)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbz != null) {
          ((cc)localObject1).setCreateTime(arrayOfbz[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcp != null) {
          ((cc)localObject1).setCreateTime(arrayOfcp[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */