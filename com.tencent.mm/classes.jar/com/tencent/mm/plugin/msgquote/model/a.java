package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, bo parambo, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().vY(paramMsgQuoteItem.uVU);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(2131761368));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, bs.bG(paramMsgQuoteItem.uVX, "null"), paramFloat));
    localStringBuilder.append("：");
    bo localbo = new bo();
    localbo.setType(paramMsgQuoteItem.type);
    localbo.setContent(paramMsgQuoteItem.content);
    localbo.setMsgId(parambo.field_msgId);
    localbo.re(paramMsgQuoteItem.uVV);
    parambo = a(paramContext, localbo, false);
    if (!bs.isNullOrNil(parambo)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parambo, paramFloat));
    }
    if (localb == null)
    {
      ac.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
      if (bs.isNullOrNil(localStringBuilder.toString()))
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
  
  public static CharSequence a(Context paramContext, float paramFloat, bo parambo)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = au(parambo);
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
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str1, paramFloat));
    localStringBuilder.append("：");
    parambo = a(paramContext, parambo, w.sQ(parambo.field_talker));
    if (!bs.isNullOrNil(parambo)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parambo, paramFloat));
    }
    AppMethodBeat.o(88795);
    return localStringBuilder;
  }
  
  private static String a(Context paramContext, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(88797);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = ai.getContext();
    }
    if (parambo == null)
    {
      AppMethodBeat.o(88797);
      return "";
    }
    String str = "";
    switch (parambo.getType())
    {
    default: 
      paramContext = ((Context)localObject).getString(2131761361);
    }
    for (;;)
    {
      AppMethodBeat.o(88797);
      return paramContext;
      paramContext = parambo.field_content;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = paramContext;
        if (!av(parambo))
        {
          int i = bi.yi(paramContext);
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
        if (com.tencent.mm.br.d.aCT("location"))
        {
          ky localky = new ky();
          localky.dmP.dmJ = 1;
          localky.dmP.cZc = parambo;
          com.tencent.mm.sdk.b.a.GpY.l(localky);
          paramContext = localky.dmQ.dmS;
          parambo = localky.dmQ.diM;
          if (e(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (amf(localky.dmQ.diM))
            {
              paramContext = str + parambo;
              continue;
              paramContext = ((Context)localObject).getString(2131761362);
              continue;
              parambo = k.b.vA(parambo.field_content);
              paramContext = str;
              if (parambo != null) {
                switch (parambo.type)
                {
                default: 
                  paramContext = str;
                  break;
                case 1: 
                case 53: 
                case 57: 
                  paramContext = str;
                  if (parambo.title != null)
                  {
                    paramContext = str;
                    if (parambo.title.length() > 0) {
                      paramContext = parambo.title;
                    }
                  }
                  break;
                case 6: 
                  if ((parambo.title != null) && (parambo.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { parambo.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((parambo.title != null) && (parambo.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { parambo.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((parambo.title != null) && (parambo.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { parambo.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(2131761366, new Object[] { e(parambo) });
                  break;
                case 3: 
                  if ((parambo.title != null) && (parambo.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761365, new Object[] { parambo.title });
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
  
  private static boolean amf(String paramString)
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
  
  public static String au(bo parambo)
  {
    AppMethodBeat.i(88794);
    if (parambo == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = com.tencent.mm.util.d.cv(parambo);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (w.sQ(parambo.field_talker))
    {
      parambo = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(parambo.field_talker);
      localObject1 = localObject2;
      if (parambo != null)
      {
        parambo = parambo.wk(str);
        localObject1 = localObject2;
        if (!bs.isNullOrNil(parambo)) {
          localObject1 = parambo;
        }
      }
    }
    parambo = (bo)localObject1;
    if (bs.isNullOrNil((String)localObject1))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      parambo = (bo)localObject1;
      if (localObject2 != null) {
        parambo = ((av)localObject2).field_nickname;
      }
    }
    localObject1 = parambo;
    if (bs.isNullOrNil(parambo)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  private static boolean av(bo parambo)
  {
    return parambo.field_isSend == 1;
  }
  
  public static boolean dfb()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZp, 0) == 1)
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
    Object localObject1 = new pw();
    ((pw)localObject1).dsN.type = 0;
    ((pw)localObject1).dsN.dsP = paramb.hij;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = ((pw)localObject1).dsO.dsX;
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).hkS.iterator();
    int i = 0;
    agx localagx;
    while (((Iterator)localObject2).hasNext())
    {
      localagx = (agx)((Iterator)localObject2).next();
      if ((!l.j(localagx)) || (bs.isNullOrNil(localagx.EAh)) || (!localagx.EAh.equals("WeNoteHtmlFile"))) {
        switch (localagx.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localagx.desc;
            if (!bs.isNullOrNil(str))
            {
              if (bs.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label356;
              }
              paramb = localagx.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
            localagx = paramb[i];
            if (localagx.length() > 0) {
              ((ArrayList)localObject2).add(localagx);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).hkS.size() == 2)) {
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