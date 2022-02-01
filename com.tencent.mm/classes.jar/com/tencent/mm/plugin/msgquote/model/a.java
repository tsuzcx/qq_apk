package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.b;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, bu parambu, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().yh(paramMsgQuoteItem.vZc);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(2131761368));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k.b(paramContext, bt.bI(paramMsgQuoteItem.vZf, "null"), paramFloat));
    localStringBuilder.append("：");
    bu localbu = new bu();
    localbu.setType(paramMsgQuoteItem.type);
    localbu.setContent(paramMsgQuoteItem.content);
    localbu.setMsgId(parambu.field_msgId);
    localbu.tN(paramMsgQuoteItem.vZd);
    parambu = a(paramContext, localbu, false);
    if (!bt.isNullOrNil(parambu)) {
      localStringBuilder.append(k.b(paramContext, parambu, paramFloat));
    }
    if (localb == null)
    {
      ad.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
      if (bt.isNullOrNil(localStringBuilder.toString()))
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
  
  public static CharSequence a(Context paramContext, float paramFloat, bu parambu)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = ax(parambu);
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
    parambu = a(paramContext, parambu, w.vF(parambu.field_talker));
    if (!bt.isNullOrNil(parambu)) {
      localStringBuilder.append(k.b(paramContext, parambu, paramFloat));
    }
    AppMethodBeat.o(88795);
    return localStringBuilder;
  }
  
  private static String a(Context paramContext, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(88797);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = aj.getContext();
    }
    if (parambu == null)
    {
      AppMethodBeat.o(88797);
      return "";
    }
    String str = "";
    switch (parambu.getType())
    {
    default: 
      paramContext = ((Context)localObject).getString(2131761361);
    }
    for (;;)
    {
      parambu = paramContext;
      if (!bt.isNullOrNil(paramContext)) {
        parambu = paramContext.replace('\n', ' ');
      }
      AppMethodBeat.o(88797);
      return parambu;
      paramContext = parambu.field_content;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = paramContext;
        if (!ay(parambu))
        {
          int i = bj.Bh(paramContext);
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
        if (d.aIu("location"))
        {
          lh locallh = new lh();
          locallh.dyD.dyx = 1;
          locallh.dyD.dku = parambu;
          com.tencent.mm.sdk.b.a.IbL.l(locallh);
          paramContext = locallh.dyE.dyG;
          parambu = locallh.dyE.duy;
          if (e(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (aqU(locallh.dyE.duy))
            {
              paramContext = str + parambu;
              continue;
              paramContext = ((Context)localObject).getString(2131761362);
              continue;
              parambu = k.b.yr(parambu.field_content);
              paramContext = str;
              if (parambu != null) {
                switch (parambu.type)
                {
                default: 
                  paramContext = str;
                  break;
                case 1: 
                case 53: 
                case 57: 
                  paramContext = str;
                  if (parambu.title != null)
                  {
                    paramContext = str;
                    if (parambu.title.length() > 0) {
                      paramContext = parambu.title;
                    }
                  }
                  break;
                case 6: 
                  if ((parambu.title != null) && (parambu.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { parambu.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((parambu.title != null) && (parambu.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { parambu.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((parambu.title != null) && (parambu.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { parambu.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(2131761366, new Object[] { e(parambu) });
                  break;
                case 3: 
                  if ((parambu.title != null) && (parambu.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761365, new Object[] { parambu.title });
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
  
  private static boolean aqU(String paramString)
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
  
  public static String ax(bu parambu)
  {
    AppMethodBeat.i(88794);
    if (parambu == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = e.cB(parambu);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (w.vF(parambu.field_talker))
    {
      parambu = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(parambu.field_talker);
      localObject1 = localObject2;
      if (parambu != null)
      {
        parambu = parambu.zf(str);
        localObject1 = localObject2;
        if (!bt.isNullOrNil(parambu)) {
          localObject1 = parambu;
        }
      }
    }
    parambu = (bu)localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
      parambu = (bu)localObject1;
      if (localObject2 != null) {
        parambu = ((aw)localObject2).field_nickname;
      }
    }
    localObject1 = parambu;
    if (bt.isNullOrNil(parambu)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  private static boolean ay(bu parambu)
  {
    return parambu.field_isSend == 1;
  }
  
  public static boolean doz()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEB, 0) == 1)
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
    Object localObject1 = new qh();
    ((qh)localObject1).dEN.type = 0;
    ((qh)localObject1).dEN.dEP = paramb.hAs;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = ((qh)localObject1).dEO.dEY;
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).hDb.iterator();
    int i = 0;
    ajn localajn;
    while (((Iterator)localObject2).hasNext())
    {
      localajn = (ajn)((Iterator)localObject2).next();
      if ((!com.tencent.mm.plugin.fav.ui.l.j(localajn)) || (bt.isNullOrNil(localajn.GhT)) || (!localajn.GhT.equals("WeNoteHtmlFile"))) {
        switch (localajn.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localajn.desc;
            if (!bt.isNullOrNil(str))
            {
              if (bt.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label356;
              }
              paramb = localajn.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
            localajn = paramb[i];
            if (localajn.length() > 0) {
              ((ArrayList)localObject2).add(localajn);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).hDb.size() == 2)) {
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