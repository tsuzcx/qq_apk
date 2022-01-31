package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.a.fy;
import com.tencent.mm.h.a.fy.b;
import com.tencent.mm.h.c.cn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public boolean ceg;
  public String dTF;
  public String fds;
  public long id;
  public String nickname;
  public int ocd;
  public String sis;
  public String username;
  
  public static b a(Context paramContext, long paramLong, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2)
  {
    b localb = new b();
    localb.id = paramLong;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ceg = bool;
      y.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2) });
      if (paramInt1 != 0) {
        break label353;
      }
      if (paramString2 != null) {
        break;
      }
      y.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + paramString1);
      return null;
    }
    localb.username = paramString3;
    localb.nickname = paramString4;
    switch (paramInt2)
    {
    default: 
      localb.dTF = paramContext.getString(R.l.chatting_from_possible_friends_content);
    }
    for (;;)
    {
      return localb;
      localb.dTF = paramContext.getString(R.l.chatting_from_QQ_friends_content);
      continue;
      paramString1 = new fy();
      paramString1.bNh.bNe = paramString5;
      paramString1.bNh.bNf = paramString6;
      a.udP.m(paramString1);
      localb.dTF = paramContext.getString(R.l.chatting_from_mobile_friends_content, new Object[] { bk.aM(paramString1.bNi.bNj, "") });
      continue;
      localb.dTF = paramContext.getString(R.l.chatting_from_verify_facebook_content);
      continue;
      localb.dTF = paramContext.getString(R.l.chatting_from_sns_add_now);
      continue;
      localb.fds = bi.a.abZ(paramString2).fds;
      localb.dTF = paramContext.getString(R.l.chatting_from_google_contact);
      continue;
      label353:
      if (!paramBoolean)
      {
        localb.username = paramString1;
        localb.dTF = paramString2;
      }
      else
      {
        localb.username = paramString3;
        localb.nickname = paramString4;
        if ((paramString7 != null) && (!paramString7.trim().equals(""))) {
          localb.dTF = paramString7;
        } else {
          localb.dTF = paramContext.getString(R.l.fmessage_from_verify_digest_tip);
        }
      }
    }
  }
  
  public static b a(Context paramContext, cn paramcn)
  {
    y.d("MicroMsg.FMessageProvider", "build lbs, talker = " + paramcn.field_sayhiuser + ", scene = " + paramcn.field_scene);
    b localb = new b();
    localb.id = paramcn.ujK;
    if (paramcn.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ceg = bool;
      localb.username = paramcn.field_sayhiuser;
      localb.ocd = paramcn.field_scene;
      if (paramcn.field_isSend != 1) {
        break;
      }
      localb.dTF = paramcn.field_content;
      return localb;
    }
    paramcn = bi.d.acc(paramcn.field_content);
    if ((paramcn.content != null) && (!paramcn.content.trim().equals(""))) {}
    for (localb.dTF = paramcn.content;; localb.dTF = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = paramcn.nickname;
      return localb;
    }
  }
  
  public static b a(Context paramContext, ax paramax)
  {
    long l = paramax.ujK;
    boolean bool = paramax.cuX();
    String str6 = paramax.field_talker;
    String str7 = paramax.field_msgContent;
    int j = paramax.field_type;
    int i = 0;
    String str3;
    String str4;
    String str1;
    String str2;
    String str5;
    if (j == 0)
    {
      paramax = bi.a.abZ(str7);
      str3 = paramax.pyp;
      str4 = paramax.nickname;
      str1 = paramax.uBW;
      str2 = paramax.uBX;
      i = paramax.scene;
      paramax = null;
      str5 = null;
    }
    for (;;)
    {
      paramContext = a(paramContext, l, bool, str6, str7, j, str3, str4, str1, str2, str5, i);
      paramContext.sis = paramax;
      return paramContext;
      if (bool)
      {
        paramax = bi.d.acc(str7);
        str3 = paramax.pyp;
        str4 = paramax.nickname;
        str5 = paramax.content;
        if (paramax.uCm == 1)
        {
          paramax = paramax.uCo;
          str2 = null;
          str1 = null;
        }
        else
        {
          paramax = null;
          str2 = null;
          str1 = null;
        }
      }
      else
      {
        paramax = null;
        str5 = null;
        str2 = null;
        str1 = null;
        str4 = null;
        str3 = null;
      }
    }
  }
  
  public static b a(Context paramContext, bt parambt)
  {
    y.d("MicroMsg.FMessageProvider", "build shake, talker = " + parambt.field_talker + ", scene = " + parambt.field_scene);
    b localb = new b();
    localb.id = parambt.ujK;
    if (parambt.field_isSend == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localb.ceg = bool;
      localb.username = parambt.field_sayhiuser;
      localb.ocd = parambt.field_scene;
      if (parambt.field_isSend != 1) {
        break;
      }
      localb.dTF = parambt.field_content;
      return localb;
    }
    parambt = bi.d.acc(parambt.field_content);
    if ((parambt.content != null) && (!parambt.content.trim().equals(""))) {}
    for (localb.dTF = parambt.content;; localb.dTF = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localb.nickname = parambt.nickname;
      return localb;
    }
  }
  
  public static ad a(ax paramax)
  {
    ad localad = new ad();
    if (paramax == null) {
      return localad;
    }
    if (paramax.field_type == 0)
    {
      paramax = bi.a.abZ(paramax.field_msgContent);
      localad = new ad();
      localad.setUsername(paramax.pyp);
      localad.cZ(paramax.cMT);
      localad.dk(paramax.getDisplayName());
      localad.dl(paramax.fgZ);
      localad.dm(paramax.fha);
      localad.fm(paramax.sex);
      localad.dA(paramax.getProvince());
      localad.dB(paramax.getCity());
      localad.dz(paramax.signature);
      localad.fi(paramax.qZn);
      localad.dE(paramax.cCF);
      localad.dN(paramax.sii);
      return localad;
    }
    paramax = bi.d.acc(paramax.field_msgContent);
    localad = new ad();
    localad.setUsername(paramax.pyp);
    localad.cZ(paramax.cMT);
    localad.dk(paramax.nickname);
    localad.dl(paramax.fgZ);
    localad.dm(paramax.fha);
    localad.fm(paramax.sex);
    localad.dz(paramax.signature);
    localad.dA(paramax.getProvince());
    localad.dB(paramax.getCity());
    return localad;
  }
  
  public static b[] a(Context paramContext, cn[] paramArrayOfcn)
  {
    StringBuilder localStringBuilder = new StringBuilder("convert lbsList, talker = ");
    if ((paramArrayOfcn == null) || (paramArrayOfcn.length == 0) || (paramArrayOfcn[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfcn[0].field_sayhiuser)
    {
      y.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfcn != null) && (paramArrayOfcn.length != 0)) {
        break;
      }
      y.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
      return null;
    }
    localObject = new b[paramArrayOfcn.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOfcn[i]);
      i += 1;
    }
    return localObject;
  }
  
  public static b[] a(Context paramContext, ax[] paramArrayOfax)
  {
    StringBuilder localStringBuilder = new StringBuilder("convert fmsgList, talker = ");
    if ((paramArrayOfax == null) || (paramArrayOfax.length == 0) || (paramArrayOfax[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfax[0].field_talker)
    {
      y.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfax != null) && (paramArrayOfax.length != 0)) {
        break;
      }
      y.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
      return null;
    }
    localObject = new b[paramArrayOfax.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOfax[i]);
      i += 1;
    }
    return localObject;
  }
  
  public static b[] a(Context paramContext, bt[] paramArrayOfbt)
  {
    StringBuilder localStringBuilder = new StringBuilder("convert shakeList, talker = ");
    if ((paramArrayOfbt == null) || (paramArrayOfbt.length == 0) || (paramArrayOfbt[0] == null)) {}
    for (Object localObject = "null";; localObject = paramArrayOfbt[0].field_sayhiuser)
    {
      y.d("MicroMsg.FMessageProvider", (String)localObject);
      if ((paramArrayOfbt != null) && (paramArrayOfbt.length != 0)) {
        break;
      }
      y.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
      return null;
    }
    localObject = new b[paramArrayOfbt.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = a(paramContext, paramArrayOfbt[i]);
      i += 1;
    }
    return localObject;
  }
  
  public static void bh(String paramString, int paramInt)
  {
    bt[] arrayOfbt;
    Object localObject1;
    ax[] arrayOfax;
    bf[] arrayOfbf;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      y.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
      arrayOfbt = d.Sa().act(paramString);
      localObject1 = a(ae.getContext(), arrayOfbt);
      arrayOfax = null;
      arrayOfbf = null;
    }
    while (localObject1 == null)
    {
      return;
      if (paramInt == 18)
      {
        y.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
        arrayOfbf = d.RZ().abW(paramString);
        localObject1 = a(ae.getContext(), arrayOfbf);
        arrayOfbt = null;
        arrayOfax = null;
      }
      else
      {
        arrayOfax = d.RX().abS(paramString);
        localObject1 = a(ae.getContext(), arrayOfax);
        arrayOfbt = null;
        arrayOfbf = null;
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
      localbi.setContent(localObject2.dTF);
      m = s.hW(localObject2.username);
      if (arrayOfax != null)
      {
        j = paramInt + 1;
        localbi.bg(arrayOfax[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label549:
    for (;;)
    {
      label206:
      localbi.ec(localObject2.username);
      localbi.setType(m);
      label243:
      long l;
      if (localObject2.ceg)
      {
        localbi.setStatus(2);
        localbi.fA(1);
        au.Hx();
        l = c.Fy().T(localbi);
        if (l == -1L) {
          break label382;
        }
      }
      label382:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        y.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + l);
        i += 1;
        break;
        if (arrayOfbf != null)
        {
          j = paramInt + 1;
          localbi.bg(arrayOfbf[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label206;
        }
        if (arrayOfbt == null) {
          break label549;
        }
        j = paramInt + 1;
        localbi.bg(arrayOfbt[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label206;
        localbi.setStatus(6);
        localbi.fA(0);
        break label243;
      }
      localObject1 = new bi();
      if (arrayOfax != null) {
        ((bi)localObject1).bg(arrayOfax[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bi)localObject1).ec(paramString);
        ((bi)localObject1).setContent(ae.getContext().getString(R.l.transfer_greet_msg_tip));
        ((bi)localObject1).setType(10000);
        ((bi)localObject1).setStatus(6);
        ((bi)localObject1).fA(0);
        au.Hx();
        l = c.Fy().T((bi)localObject1);
        y.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + l);
        return;
        if (arrayOfbf != null) {
          ((bi)localObject1).bg(arrayOfbf[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbt != null) {
          ((bi)localObject1).bg(arrayOfbt[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.b
 * JD-Core Version:    0.7.0.1
 */