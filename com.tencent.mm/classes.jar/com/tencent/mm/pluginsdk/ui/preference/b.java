package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.gq.b;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import junit.framework.Assert;

public final class b
{
  public int Dkc;
  public String Kpp;
  public boolean ehd;
  public String iAq;
  public long id;
  public String kcp;
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
      localObject3 = ca.a.bkA(paramString2);
      localObject1 = ((ca.a)localObject3).dkU;
      localObject2 = ((ca.a)localObject3).nickname;
      localObject6 = ((ca.a)localObject3).OqK;
      localObject4 = ((ca.a)localObject3).OqL;
      i = ((ca.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.Kpp = ((String)localObject3);
      AppMethodBeat.o(31841);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        ca.d locald = ca.d.bkD(paramString2);
        String str1 = locald.dkU;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.Ora == 1)
        {
          localObject3 = locald.Orc;
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
      localb.ehd = bool;
      Log.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label357;
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
      localb.iAq = paramContext.getString(2131757372);
    }
    for (;;)
    {
      AppMethodBeat.o(31842);
      return localb;
      localb.iAq = paramContext.getString(2131757363);
      continue;
      paramString1 = new gq();
      paramString1.dKE.dKB = paramString5;
      paramString1.dKE.dKC = paramString6;
      EventCenter.instance.publish(paramString1);
      localb.iAq = paramContext.getString(2131757368, new Object[] { Util.nullAs(paramString1.dKF.dKG, "") });
      continue;
      localb.iAq = paramContext.getString(2131757379);
      continue;
      localb.iAq = paramContext.getString(2131757373);
      continue;
      localb.kcp = ca.a.bkA(paramString2).kcp;
      localb.iAq = paramContext.getString(2131757366);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.iAq = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.iAq = paramString7;
        } else {
          localb.iAq = paramContext.getString(2131763675);
        }
      }
    }
  }
  
  public static b a(Context paramContext, eb parameb)
  {
    AppMethodBeat.i(31843);
    Log.d("MicroMsg.FMessageProvider", "build lbs, talker = " + parameb.field_sayhiuser + ", scene = " + parameb.field_scene);
    b localb = new b();
    localb.id = parameb.systemRowid;
    if (parameb.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ehd = bool;
      localb.username = parameb.field_sayhiuser;
      localb.Dkc = parameb.field_scene;
      if (parameb.field_isSend != 1) {
        break;
      }
      localb.iAq = parameb.field_content;
      AppMethodBeat.o(31843);
      return localb;
    }
    parameb = ca.d.bkD(parameb.field_content);
    if ((parameb.content != null) && (!parameb.content.trim().equals(""))) {}
    for (localb.iAq = parameb.content;; localb.iAq = paramContext.getString(2131757381))
    {
      localb.nickname = parameb.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, cl paramcl)
  {
    AppMethodBeat.i(31844);
    Log.d("MicroMsg.FMessageProvider", "build shake, talker = " + paramcl.field_talker + ", scene = " + paramcl.field_scene);
    b localb = new b();
    localb.id = paramcl.systemRowid;
    if (paramcl.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ehd = bool;
      localb.username = paramcl.field_sayhiuser;
      localb.Dkc = paramcl.field_scene;
      if (paramcl.field_isSend != 1) {
        break;
      }
      localb.iAq = paramcl.field_content;
      AppMethodBeat.o(31844);
      return localb;
    }
    paramcl = ca.d.bkD(paramcl.field_content);
    if ((paramcl.content != null) && (!paramcl.content.trim().equals(""))) {}
    for (localb.iAq = paramcl.content;; localb.iAq = paramContext.getString(2131757381))
    {
      localb.nickname = paramcl.nickname;
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
      parambn = bfc(parambn.field_msgContent);
      AppMethodBeat.o(31850);
      return parambn;
    }
    parambn = bfd(parambn.field_msgContent);
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
      paramString = ca.a.bkA(paramString);
      switch (paramString.scene)
      {
      default: 
        localObject = paramContext.getString(2131757372);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31848);
      return localObject;
      localObject = paramContext.getString(2131757363);
      continue;
      localObject = new gq();
      ((gq)localObject).dKE.dKB = paramString.OqK;
      ((gq)localObject).dKE.dKC = paramString.OqL;
      EventCenter.instance.publish((IEvent)localObject);
      localObject = paramContext.getString(2131757368, new Object[] { Util.nullAs(((gq)localObject).dKF.dKG, "") });
      continue;
      localObject = paramContext.getString(2131757379);
      continue;
      localObject = paramContext.getString(2131757373);
      continue;
      localObject = paramContext.getString(2131757366);
      continue;
      localObject = paramString;
      if (!paramBoolean)
      {
        paramString = ca.d.bkD(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(2131760786);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, eb[] paramArrayOfeb)
  {
    AppMethodBeat.i(31846);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfeb == null) || (paramArrayOfeb.length == 0) || (paramArrayOfeb[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfeb[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfeb != null) && (paramArrayOfeb.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(31846);
      return null;
    }
    localObject = new b[paramArrayOfeb.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfeb[i]);
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
  
  public static b[] a(Context paramContext, cl[] paramArrayOfcl)
  {
    AppMethodBeat.i(31847);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfcl == null) || (paramArrayOfcl.length == 0) || (paramArrayOfcl[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcl[0].field_sayhiuser)
    {
      Log.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcl != null) && (paramArrayOfcl.length != 0)) {
        break;
      }
      Log.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(31847);
      return null;
    }
    localObject = new b[paramArrayOfcl.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfcl[i]);
      i += 1;
    }
    AppMethodBeat.o(31847);
    return localObject;
  }
  
  private static as bfc(String paramString)
  {
    AppMethodBeat.i(31851);
    paramString = ca.a.bkA(paramString);
    as localas = new as();
    localas.setUsername(paramString.dkU);
    localas.BC(paramString.fMb);
    localas.setNickname(paramString.getDisplayName());
    localas.BF(paramString.kfQ);
    localas.BG(paramString.kfR);
    localas.nj(paramString.fuA);
    localas.BW(paramString.getProvince());
    localas.BX(paramString.getCity());
    localas.BV(paramString.signature);
    localas.nf(paramString.IOs);
    localas.Ca(paramString.fuN);
    localas.Cj(paramString.Kpf);
    AppMethodBeat.o(31851);
    return localas;
  }
  
  private static as bfd(String paramString)
  {
    AppMethodBeat.i(31852);
    paramString = ca.d.bkD(paramString);
    as localas = new as();
    localas.setUsername(paramString.dkU);
    localas.BC(paramString.fMb);
    localas.setNickname(paramString.nickname);
    localas.BF(paramString.kfQ);
    localas.BG(paramString.kfR);
    localas.nj(paramString.fuA);
    localas.BV(paramString.signature);
    localas.BW(paramString.getProvince());
    localas.BX(paramString.getCity());
    AppMethodBeat.o(31852);
    return localas;
  }
  
  public static b c(Context paramContext, bn parambn)
  {
    AppMethodBeat.i(31840);
    paramContext = a(paramContext, parambn.systemRowid, parambn.gCT(), parambn.field_talker, parambn.field_msgContent, parambn.field_type);
    AppMethodBeat.o(31840);
    return paramContext;
  }
  
  public static void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(31849);
    bx[] arrayOfbx = null;
    cl[] arrayOfcl;
    Object localObject1;
    bn[] arrayOfbn;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfcl = d.bgP().bkW(paramString);
      localObject1 = a(MMApplicationContext.getContext(), arrayOfcl);
      arrayOfbn = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(31849);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbx = d.bgO().bkx(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbx);
        arrayOfcl = null;
        arrayOfbn = null;
      }
      else
      {
        arrayOfbn = d.bgM().bku(paramString);
        localObject1 = a(MMApplicationContext.getContext(), arrayOfbn);
        arrayOfcl = null;
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
      localca.setContent(localObject2.iAq);
      m = ab.JG(localObject2.username);
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
      localca.Cy(localObject2.username);
      localca.setType(m);
      label252:
      long l;
      if (localObject2.ehd)
      {
        localca.setStatus(2);
        localca.nv(1);
        bg.aVF();
        l = c.aSQ().aC(localca);
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
        if (arrayOfcl == null) {
          break label546;
        }
        j = paramInt + 1;
        localca.setCreateTime(arrayOfcl[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localca.setStatus(6);
        localca.nv(0);
        break label252;
      }
      localObject1 = new ca();
      if (arrayOfbn != null) {
        ((ca)localObject1).setCreateTime(arrayOfbn[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((ca)localObject1).Cy(paramString);
        ((ca)localObject1).setContent(MMApplicationContext.getContext().getString(2131766882));
        ((ca)localObject1).setType(10000);
        ((ca)localObject1).setStatus(6);
        ((ca)localObject1).nv(0);
        bg.aVF();
        Log.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.aSQ().aC((ca)localObject1))));
        AppMethodBeat.o(31849);
        return;
        if (arrayOfbx != null) {
          ((ca)localObject1).setCreateTime(arrayOfbx[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcl != null) {
          ((ca)localObject1).setCreateTime(arrayOfcl[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */