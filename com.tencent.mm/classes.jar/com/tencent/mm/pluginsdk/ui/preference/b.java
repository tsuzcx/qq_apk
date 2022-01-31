package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gb.b;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import junit.framework.Assert;

public final class b
{
  public boolean cMU;
  public String fjL;
  public String gvd;
  public long id;
  public String nickname;
  public int qQk;
  public String username;
  public String waR;
  
  private static b a(Context paramContext, long paramLong, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(28054);
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
      localObject3 = bi.a.asj(paramString2);
      localObject1 = ((bi.a)localObject3).tac;
      localObject2 = ((bi.a)localObject3).nickname;
      localObject6 = ((bi.a)localObject3).yOi;
      localObject4 = ((bi.a)localObject3).yOj;
      i = ((bi.a)localObject3).scene;
      localObject3 = localObject7;
    }
    for (;;)
    {
      paramContext = a(paramContext, paramLong, paramBoolean, paramString1, paramString2, paramInt, (String)localObject1, (String)localObject2, (String)localObject6, (String)localObject4, (String)localObject5, i);
      paramContext.waR = ((String)localObject3);
      AppMethodBeat.o(28054);
      return paramContext;
      localObject3 = localObject7;
      localObject6 = localObject8;
      localObject4 = localObject9;
      i = j;
      if (paramBoolean)
      {
        bi.d locald = bi.d.asm(paramString2);
        String str1 = locald.tac;
        String str2 = locald.nickname;
        String str3 = locald.content;
        localObject3 = localObject7;
        localObject1 = str1;
        localObject2 = str2;
        localObject6 = localObject8;
        localObject4 = localObject9;
        localObject5 = str3;
        i = j;
        if (locald.yOy == 1)
        {
          localObject3 = locald.yOA;
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
    AppMethodBeat.i(28055);
    b localb = new b();
    localb.id = paramLong;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localb.cMU = bool;
      ab.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label357;
      }
      if (paramString2 != null) {
        break;
      }
      ab.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(28055);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.fjL = paramContext.getString(2131298179);
    }
    for (;;)
    {
      AppMethodBeat.o(28055);
      return localb;
      localb.fjL = paramContext.getString(2131298170);
      continue;
      paramString1 = new gb();
      paramString1.cuz.cuw = paramString5;
      paramString1.cuz.cux = paramString6;
      a.ymk.l(paramString1);
      localb.fjL = paramContext.getString(2131298175, new Object[] { bo.bf(paramString1.cuA.cuB, "") });
      continue;
      localb.fjL = paramContext.getString(2131298186);
      continue;
      localb.fjL = paramContext.getString(2131298180);
      continue;
      localb.gvd = bi.a.asj(paramString2).gvd;
      localb.fjL = paramContext.getString(2131298173);
      continue;
      label357:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.fjL = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.fjL = paramString7;
        } else {
          localb.fjL = paramContext.getString(2131301945);
        }
      }
    }
  }
  
  public static b a(Context paramContext, cu paramcu)
  {
    AppMethodBeat.i(28056);
    ab.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramcu.field_sayhiuser + ", scene = " + paramcu.field_scene);
    b localb = new b();
    localb.id = paramcu.systemRowid;
    if (paramcu.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.cMU = bool;
      localb.username = paramcu.field_sayhiuser;
      localb.qQk = paramcu.field_scene;
      if (paramcu.field_isSend != 1) {
        break;
      }
      localb.fjL = paramcu.field_content;
      AppMethodBeat.o(28056);
      return localb;
    }
    paramcu = bi.d.asm(paramcu.field_content);
    if ((paramcu.content != null) && (!paramcu.content.trim().equals(""))) {}
    for (localb.fjL = paramcu.content;; localb.fjL = paramContext.getString(2131298188))
    {
      localb.nickname = paramcu.nickname;
      break;
    }
  }
  
  public static b a(Context paramContext, bt parambt)
  {
    AppMethodBeat.i(28057);
    ab.d("MicroMsg.FMessageProvider", "build shake, talker = " + parambt.field_talker + ", scene = " + parambt.field_scene);
    b localb = new b();
    localb.id = parambt.systemRowid;
    if (parambt.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.cMU = bool;
      localb.username = parambt.field_sayhiuser;
      localb.qQk = parambt.field_scene;
      if (parambt.field_isSend != 1) {
        break;
      }
      localb.fjL = parambt.field_content;
      AppMethodBeat.o(28057);
      return localb;
    }
    parambt = bi.d.asm(parambt.field_content);
    if ((parambt.content != null) && (!parambt.content.trim().equals(""))) {}
    for (localb.fjL = parambt.content;; localb.fjL = paramContext.getString(2131298188))
    {
      localb.nickname = parambt.nickname;
      break;
    }
  }
  
  public static ad a(ax paramax)
  {
    AppMethodBeat.i(28063);
    ad localad = new ad();
    if (paramax == null)
    {
      AppMethodBeat.o(28063);
      return localad;
    }
    if (paramax.field_type == 0)
    {
      paramax = amv(paramax.field_msgContent);
      AppMethodBeat.o(28063);
      return paramax;
    }
    paramax = amw(paramax.field_msgContent);
    AppMethodBeat.o(28063);
    return paramax;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(28061);
    ab.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (paramInt1 == 0)
    {
      if (paramString == null)
      {
        ab.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
        AppMethodBeat.o(28061);
        return null;
      }
      paramString = bi.a.asj(paramString);
      switch (paramString.scene)
      {
      default: 
        localObject = paramContext.getString(2131298179);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28061);
      return localObject;
      localObject = paramContext.getString(2131298170);
      continue;
      localObject = new gb();
      ((gb)localObject).cuz.cuw = paramString.yOi;
      ((gb)localObject).cuz.cux = paramString.yOj;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = paramContext.getString(2131298175, new Object[] { bo.bf(((gb)localObject).cuA.cuB, "") });
      continue;
      localObject = paramContext.getString(2131298186);
      continue;
      localObject = paramContext.getString(2131298180);
      continue;
      localObject = paramContext.getString(2131298173);
      continue;
      localObject = paramString;
      if (!paramBoolean)
      {
        paramString = bi.d.asm(paramString);
        if ((paramString.content != null) && (!paramString.content.trim().equals(""))) {
          localObject = paramString.content;
        } else {
          localObject = paramContext.getString(2131300005);
        }
      }
    }
  }
  
  public static b[] a(Context paramContext, cu[] paramArrayOfcu)
  {
    AppMethodBeat.i(28059);
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfcu == null) || (paramArrayOfcu.length == 0) || (paramArrayOfcu[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcu[0].field_sayhiuser)
    {
      ab.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcu != null) && (paramArrayOfcu.length != 0)) {
        break;
      }
      ab.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      AppMethodBeat.o(28059);
      return null;
    }
    localObject = new b[paramArrayOfcu.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfcu[i]);
      i += 1;
    }
    AppMethodBeat.o(28059);
    return localObject;
  }
  
  public static b[] a(Context paramContext, ax[] paramArrayOfax)
  {
    AppMethodBeat.i(28058);
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfax == null) || (paramArrayOfax.length == 0) || (paramArrayOfax[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfax[0].field_talker)
    {
      ab.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfax != null) && (paramArrayOfax.length != 0)) {
        break;
      }
      ab.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      AppMethodBeat.o(28058);
      return null;
    }
    localObject = new b[paramArrayOfax.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = c(paramContext, paramArrayOfax[i]);
      i += 1;
    }
    AppMethodBeat.o(28058);
    return localObject;
  }
  
  public static b[] a(Context paramContext, bt[] paramArrayOfbt)
  {
    AppMethodBeat.i(28060);
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfbt == null) || (paramArrayOfbt.length == 0) || (paramArrayOfbt[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbt[0].field_sayhiuser)
    {
      ab.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbt != null) && (paramArrayOfbt.length != 0)) {
        break;
      }
      ab.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      AppMethodBeat.o(28060);
      return null;
    }
    localObject = new b[paramArrayOfbt.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[(localObject.length - i - 1)] = a(paramContext, paramArrayOfbt[i]);
      i += 1;
    }
    AppMethodBeat.o(28060);
    return localObject;
  }
  
  private static ad amv(String paramString)
  {
    AppMethodBeat.i(28064);
    paramString = bi.a.asj(paramString);
    ad localad = new ad();
    localad.setUsername(paramString.tac);
    localad.jm(paramString.dCJ);
    localad.jp(paramString.getDisplayName());
    localad.jq(paramString.gyH);
    localad.jr(paramString.gyI);
    localad.hy(paramString.dqC);
    localad.jG(paramString.getProvince());
    localad.jH(paramString.getCity());
    localad.jF(paramString.signature);
    localad.hu(paramString.uOT);
    localad.jK(paramString.dqP);
    localad.jT(paramString.waH);
    AppMethodBeat.o(28064);
    return localad;
  }
  
  private static ad amw(String paramString)
  {
    AppMethodBeat.i(28065);
    paramString = bi.d.asm(paramString);
    ad localad = new ad();
    localad.setUsername(paramString.tac);
    localad.jm(paramString.dCJ);
    localad.jp(paramString.nickname);
    localad.jq(paramString.gyH);
    localad.jr(paramString.gyI);
    localad.hy(paramString.dqC);
    localad.jF(paramString.signature);
    localad.jG(paramString.getProvince());
    localad.jH(paramString.getCity());
    AppMethodBeat.o(28065);
    return localad;
  }
  
  public static void bI(String paramString, int paramInt)
  {
    AppMethodBeat.i(28062);
    bf[] arrayOfbf = null;
    bt[] arrayOfbt;
    Object localObject1;
    ax[] arrayOfax;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ab.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfbt = d.alk().asF(paramString);
      localObject1 = a(ah.getContext(), arrayOfbt);
      arrayOfax = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(28062);
      return;
      if (paramInt == 18)
      {
        ab.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbf = d.alj().asg(paramString);
        localObject1 = a(ah.getContext(), arrayOfbf);
        arrayOfbt = null;
        arrayOfax = null;
      }
      else
      {
        arrayOfax = d.alh().asc(paramString);
        localObject1 = a(ah.getContext(), arrayOfax);
        arrayOfbt = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bi localbi;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbi = new bi();
      localbi.setContent(localObject2.fjL);
      m = t.oF(localObject2.username);
      if (arrayOfax != null)
      {
        j = paramInt + 1;
        localbi.fQ(arrayOfax[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label546:
    for (;;)
    {
      label215:
      localbi.kj(localObject2.username);
      localbi.setType(m);
      label252:
      long l;
      if (localObject2.cMU)
      {
        localbi.setStatus(2);
        localbi.hL(1);
        aw.aaz();
        l = c.YC().Z(localbi);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ab.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbf != null)
        {
          j = paramInt + 1;
          localbi.fQ(arrayOfbf[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbt == null) {
          break label546;
        }
        j = paramInt + 1;
        localbi.fQ(arrayOfbt[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbi.setStatus(6);
        localbi.hL(0);
        break label252;
      }
      localObject1 = new bi();
      if (arrayOfax != null) {
        ((bi)localObject1).fQ(arrayOfax[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bi)localObject1).kj(paramString);
        ((bi)localObject1).setContent(ah.getContext().getString(2131304395));
        ((bi)localObject1).setType(10000);
        ((bi)localObject1).setStatus(6);
        ((bi)localObject1).hL(0);
        aw.aaz();
        ab.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = ".concat(String.valueOf(c.YC().Z((bi)localObject1))));
        AppMethodBeat.o(28062);
        return;
        if (arrayOfbf != null) {
          ((bi)localObject1).fQ(arrayOfbf[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbt != null) {
          ((bi)localObject1).fQ(arrayOfbt[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public static b c(Context paramContext, ax paramax)
  {
    AppMethodBeat.i(28053);
    paramContext = a(paramContext, paramax.systemRowid, paramax.dxA(), paramax.field_talker, paramax.field_msgContent, paramax.field_type);
    AppMethodBeat.o(28053);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */