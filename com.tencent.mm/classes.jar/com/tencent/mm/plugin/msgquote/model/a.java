package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.b;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, bv parambv, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().yB(paramMsgQuoteItem.wlg);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(2131761368));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k.b(paramContext, bu.bI(paramMsgQuoteItem.wlj, "null"), paramFloat));
    localStringBuilder.append("：");
    bv localbv = new bv();
    localbv.setType(paramMsgQuoteItem.type);
    localbv.setContent(paramMsgQuoteItem.content);
    localbv.setMsgId(parambv.field_msgId);
    localbv.ui(paramMsgQuoteItem.wlh);
    parambv = a(paramContext, localbv, false);
    if (!bu.isNullOrNil(parambv)) {
      localStringBuilder.append(k.b(paramContext, parambv, paramFloat));
    }
    if (localb == null)
    {
      ae.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
      if (bu.isNullOrNil(localStringBuilder.toString()))
      {
        paramContext = new Pair(Boolean.FALSE, "");
        AppMethodBeat.o(88796);
        return paramContext;
      }
    }
    paramContext = new Pair(Boolean.TRUE, localStringBuilder);
    AppMethodBeat.o(88796);
    return paramContext;
  }
  
  public static CharSequence a(Context paramContext, float paramFloat, bv parambv)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = aw(parambv);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {}
    }
    else
    {
      str1 = "null";
    }
    localStringBuilder.append(k.b(paramContext, str1, paramFloat));
    localStringBuilder.append("：");
    parambv = a(paramContext, parambv, x.wb(parambv.field_talker));
    if (!bu.isNullOrNil(parambv)) {
      localStringBuilder.append(k.b(paramContext, parambv, paramFloat));
    }
    AppMethodBeat.o(88795);
    return localStringBuilder;
  }
  
  private static String a(Context paramContext, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(88797);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = ak.getContext();
    }
    if (parambv == null)
    {
      AppMethodBeat.o(88797);
      return "";
    }
    String str = "";
    switch (parambv.getType())
    {
    default: 
      paramContext = ((Context)localObject).getString(2131761361);
    }
    for (;;)
    {
      parambv = paramContext;
      if (!bu.isNullOrNil(paramContext)) {
        parambv = paramContext.replace('\n', ' ');
      }
      AppMethodBeat.o(88797);
      return parambv;
      paramContext = parambv.field_content;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = paramContext;
        if (!ax(parambv))
        {
          int i = bl.BJ(paramContext);
          localObject = paramContext;
          if (i != -1) {
            localObject = paramContext.substring(i + 1);
          }
        }
      }
      paramContext = (Context)localObject;
      if (localObject != null)
      {
        paramContext = ((String)localObject).trim();
        continue;
        paramContext = ((Context)localObject).getString(2131761367);
        continue;
        paramContext = ((Context)localObject).getString(2131761371);
        continue;
        str = ((Context)localObject).getString(2131761364);
        paramContext = str;
        if (d.aJN("location"))
        {
          li localli = new li();
          localli.dzI.dzC = 1;
          localli.dzI.dlw = parambv;
          com.tencent.mm.sdk.b.a.IvT.l(localli);
          paramContext = localli.dzJ.dzL;
          parambv = localli.dzJ.dvD;
          if (e(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (arZ(localli.dzJ.dvD))
            {
              paramContext = str + parambv;
              continue;
              paramContext = ((Context)localObject).getString(2131761362);
              continue;
              parambv = k.b.zb(parambv.field_content);
              paramContext = str;
              if (parambv != null) {
                switch (parambv.type)
                {
                default: 
                  paramContext = str;
                  break;
                case 1: 
                case 53: 
                case 57: 
                  paramContext = str;
                  if (parambv.title != null)
                  {
                    paramContext = str;
                    if (parambv.title.length() > 0) {
                      paramContext = parambv.title;
                    }
                  }
                  break;
                case 6: 
                  if ((parambv.title != null) && (parambv.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { parambv.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((parambv.title != null) && (parambv.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { parambv.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((parambv.title != null) && (parambv.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { parambv.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(2131761366, new Object[] { e(parambv) });
                  break;
                case 3: 
                  if ((parambv.title != null) && (parambv.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761365, new Object[] { parambv.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761365, new Object[] { "" });
                  }
                  break;
                case 4: 
                  paramContext = ((Context)localObject).getString(2131761371);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean arZ(String paramString)
  {
    AppMethodBeat.i(88799);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals("err_not_started")))
    {
      AppMethodBeat.o(88799);
      return true;
    }
    AppMethodBeat.o(88799);
    return false;
  }
  
  public static String aw(bv parambv)
  {
    AppMethodBeat.i(88794);
    if (parambv == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = e.cA(parambv);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (x.wb(parambv.field_talker))
    {
      parambv = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(parambv.field_talker);
      localObject1 = localObject2;
      if (parambv != null)
      {
        parambv = parambv.zP(str);
        localObject1 = localObject2;
        if (!bu.isNullOrNil(parambv)) {
          localObject1 = parambv;
        }
      }
    }
    parambv = (bv)localObject1;
    if (bu.isNullOrNil((String)localObject1))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
      parambv = (bv)localObject1;
      if (localObject2 != null) {
        parambv = ((aw)localObject2).field_nickname;
      }
    }
    localObject1 = parambv;
    if (bu.isNullOrNil(parambv)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  private static boolean ax(bv parambv)
  {
    return parambv.field_isSend == 1;
  }
  
  public static boolean drx()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMh, 0) == 1)
    {
      AppMethodBeat.o(88801);
      return true;
    }
    AppMethodBeat.o(88801);
    return false;
  }
  
  private static String e(k.b paramb)
  {
    AppMethodBeat.i(88800);
    Object localObject1 = new qi();
    ((qi)localObject1).dFS.type = 0;
    ((qi)localObject1).dFS.dFU = paramb.hDg;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = ((qi)localObject1).dFT.dGd;
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).hFT.iterator();
    int i = 0;
    ajx localajx;
    while (((Iterator)localObject2).hasNext())
    {
      localajx = (ajx)((Iterator)localObject2).next();
      if ((!com.tencent.mm.plugin.fav.ui.l.j(localajx)) || (bu.isNullOrNil(localajx.GAC)) || (!localajx.GAC.equals("WeNoteHtmlFile"))) {
        switch (localajx.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localajx.desc;
            if (!bu.isNullOrNil(str))
            {
              if (bu.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label356;
              }
              paramb = localajx.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
          break;
        }
      }
    }
    label356:
    for (;;)
    {
      i = 1;
      break;
      if (paramb != null)
      {
        paramb = paramb.split("\n", 2);
        localObject2 = new ArrayList();
        if (paramb.length > 0)
        {
          int j = paramb.length;
          i = 0;
          while (i < j)
          {
            localajx = paramb[i];
            if (localajx.length() > 0) {
              ((ArrayList)localObject2).add(localajx);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).hFT.size() == 2)) {
          paramb = "";
        }
      }
      for (paramb = paramb.trim();; paramb = "")
      {
        localObject1 = paramb;
        if (paramb != null) {
          localObject1 = paramb.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        AppMethodBeat.o(88800);
        return localObject1;
        paramb = (String)((ArrayList)localObject2).get(0);
        break;
      }
    }
  }
  
  private static boolean e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(88798);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(paramContext.getResources().getString(2131761364))))
    {
      AppMethodBeat.o(88798);
      return true;
    }
    AppMethodBeat.o(88798);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.a
 * JD-Core Version:    0.7.0.1
 */