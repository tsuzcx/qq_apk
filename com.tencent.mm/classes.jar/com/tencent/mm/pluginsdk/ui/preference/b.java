package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.a.gx.b;
import com.tencent.mm.f.c.ef;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import junit.framework.Assert;

public final class b
{
  public int JpE;
  public String Rqg;
  public boolean gbt;
  public long id;
  public String lpM;
  public String mTO;
  public String nickname;
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
      localObject3 = ca.a.bwZ(paramString2);
      localObject1 = ((ca.a)localObject3).fcC;
      localObject2 = ((ca.a)localObject3).nickname;
      localObject6 = ((ca.a)localObject3).VGG;
      localObject4 = ((ca.a)localObject3).VGH;
      i = ((ca.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.Rqg = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        ca.d locald = ca.d.bxc(paramString2);
        String str1 = locald.fcC;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.VGW == 1)
        {
          localObject3 = locald.VGY;
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
      localb.gbt = bool;
      Log.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label363;
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
      localb.lpM = paramContext.getString(R.l.euR);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.lpM = paramContext.getString(R.l.euN);
      continue;
      paramString1 = new gx();
      paramString1.fDt.fDq = paramString5;
      paramString1.fDt.fDr = paramString6;
      EventCenter.instance.publish(paramString1);
      localb.lpM = paramContext.getString(R.l.euP, new Object[] { Util.nullAs(paramString1.fDu.fDv, "") });
      continue;
      localb.lpM = paramContext.getString(R.l.euY);
      continue;
      localb.lpM = paramContext.getString(R.l.euS);
      continue;
      localb.mTO = ca.a.bwZ(paramString2).mTO;
      localb.lpM = paramContext.getString(R.l.chatting_from_google_contact);
      continue;
      label363:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.lpM = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.lpM = paramString7;
        } else {
          localb.lpM = paramContext.getString(R.l.eNx);
        }
      }
    }
  }
  
  public static b a(Context paramContext, ef paramef)
  {
    AppMethodBeat.i(31843);
    Log.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramef.field_sayhiuser + ", scene = " + paramef.field_scene);
    b localb = new b();
    localb.id = paramef.systemRowid;
    if (paramef.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.gbt = bool;
      localb.username = paramef.field_sayhiuser;
      localb.JpE = paramef.field_scene;
      if (paramef.field_isSend != 1) {
        break;
      }
      localb.lpM = paramef.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    paramef = ca.d.bxc(paramef.field_content);
    if ((paramef.content != null) && (!paramef.content.trim().equals(""))) {}
    for (localb.lpM = paramef.content;; localb.lpM = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = paramef.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, cm paramcm)
  {
    AppMethodBeat.i(31844);
    Log.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramcm.field_talker + ", scene = " + paramcm.field_scene);
    b localb = new b();
    localb.id = paramcm.systemRowid;
    if (paramcm.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.gbt = bool;
      localb.username = paramcm.field_sayhiuser;
      localb.JpE = paramcm.field_scene;
      if (paramcm.field_isSend != 1) {
        break;
      }
      localb.lpM = paramcm.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    paramcm = ca.d.bxc(paramcm.field_content);
    if ((paramcm.content != null) && (!paramcm.content.trim().equals(""))) {}
    for (localb.lpM = paramcm.content;; localb.lpM = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = paramcm.nickname;
      break;
    }
  }
  
  public static as a(bn parambn)
  {
    AppMethodBeat.i(31850);
    as localas = new as();
    if (parambn == null)
    {
      AppMethodBeat.o(31850);
      return localas;
    }
    if (parambn.field_type == 0)
    {
      parambn = bry(parambn.field_msgContent);
      AppMethodBeat.o(31850);
      return parambn;
    }
    parambn = brz(parambn.field_msgContent);
    AppMethodBeat.o(31850);
    return parambn;
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
      paramString = ca.a.bwZ(paramString);
      switch (paramString.scene)
      {
      default: 
        localObject = paramContext.getString(R.l.euR);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31848);
      return localObject;
      localObject = paramContext.getString(R.l.euN);
      continue;
      localObject = new gx();
      ((gx)localObject).fDt.fDq = paramString.VGG;
      ((gx)localObject).fDt.fDr = paramString.VGH;
      EventCenter.instance.publish((IEvent)localObject);
      localObject = paramContext.getString(R.l.euP, new Object[] { Util.nullAs(((gx)localObject).fDu.fDv, "") });
      continue;
      localObject = paramContext.getString(R.l.euY);
      continue;
      localObject = paramContext.getString(R.l.euS);
      continue;
      localObject = paramContext.getString(R.l.chatting_from_google_contact);
      continue;
      localObject = paramString;
      if (!paramBoolean)
      {
        paramString = ca.d.bxc(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(R.l.eFl);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, ef[] paramArrayOfef)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfef == null) || (paramArrayOfef.length == 0) || (paramArrayOfef[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfef[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfef != null) && (paramArrayOfef.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfef.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfef[i]);
      i += 1;
    }
    AppMethodBeat.o(31846);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bn[] paramArrayOfbn)
  {
    AppMethodBeat.i(31845);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfbn == null) || (paramArrayOfbn.length == 0) || (paramArrayOfbn[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbn[0].field_talker)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbn != null) && (paramArrayOfbn.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(31845);
      return null;
    }
    localObject = new b[paramArrayOfbn.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfbn[i]);
      i += 1;
    }
    AppMethodBeat.o(31845);
    return localObject;
  }
  
  public static b[] a(Context paramContext, cm[] paramArrayOfcm)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfcm == null) || (paramArrayOfcm.length == 0) || (paramArrayOfcm[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcm[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcm != null) && (paramArrayOfcm.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfcm.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfcm[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static as bry(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = ca.a.bwZ(paramString);
    as localas = new as();
    localas.setUsername(paramString.fcC);
    localas.Iq(paramString.idS);
    localas.setNickname(paramString.getDisplayName());
    localas.It(paramString.mXp);
    localas.Iu(paramString.mXq);
    localas.pw(paramString.sex);
    localas.IK(paramString.getProvince());
    localas.IL(paramString.getCity());
    localas.IJ(paramString.signature);
    localas.ps(paramString.PKJ);
    localas.IO(paramString.verifyInfo);
    localas.IX(paramString.RpW);
    AppMethodBeat.o(31851);
    return localas;
  }
  
  private static as brz(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = ca.d.bxc(paramString);
    as localas = new as();
    localas.setUsername(paramString.fcC);
    localas.Iq(paramString.idS);
    localas.setNickname(paramString.nickname);
    localas.It(paramString.mXp);
    localas.Iu(paramString.mXq);
    localas.pw(paramString.sex);
    localas.IJ(paramString.signature);
    localas.IK(paramString.getProvince());
    localas.IL(paramString.getCity());
    AppMethodBeat.o(31852);
    return localas;
  }
  
  public static b c(Context paramContext, bn parambn)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambn.systemRowid, parambn.hzg(), parambn.field_talker, parambn.field_msgContent, parambn.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bx[] arrayOfbx = null;
    cm[] arrayOfcm;
    Object localObject1;
    bn[] arrayOfbn;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfcm = d.bqe().bxw(paramString);
      localObject1 = a(MMApplicationContext.getContext(), arrayOfcm);
      arrayOfbn = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbx = d.bqd().bwW(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbx);
        arrayOfcm = null;
        arrayOfbn = null;
      }
      else
      {
        arrayOfbn = d.bqb().bwT(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbn);
        arrayOfcm = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    ca localca;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localca = new ca();
      localca.setContent(localObject2.lpM);
      m = ab.QZ(localObject2.username);
      if (arrayOfbn != null)
      {
        j = paramInt + 1;
        localca.setCreateTime(arrayOfbn[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localca.Jm(localObject2.username);
      localca.setType(m);
      label252:
      long l;
      if (localObject2.gbt)
      {
        localca.setStatus(2);
        localca.pJ(1);
        bh.beI();
        l = c.bbO().aM(localca);
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
        if (arrayOfbx != null)
        {
          j = paramInt + 1;
          localca.setCreateTime(arrayOfbx[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfcm == null) {
          break label546;
        }
        j = paramInt + 1;
        localca.setCreateTime(arrayOfcm[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localca.setStatus(6);
        localca.pJ(0);
        break label252;
      }
      localObject1 = new ca();
      if (arrayOfbn != null) {
        ((ca)localObject1).setCreateTime(arrayOfbn[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((ca)localObject1).Jm(paramString);
        ((ca)localObject1).setContent(MMApplicationContext.getContext().getString(R.l.eUw));
        ((ca)localObject1).setType(10000);
        ((ca)localObject1).setStatus(6);
        ((ca)localObject1).pJ(0);
        bh.beI();
        Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.bbO().aM((ca)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbx != null) {
          ((ca)localObject1).setCreateTime(arrayOfbx[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcm != null) {
          ((ca)localObject1).setCreateTime(arrayOfcm[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */