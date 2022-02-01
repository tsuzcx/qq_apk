package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, bl parambl, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ad(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().rv(paramMsgQuoteItem.tNr);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(2131761368));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, bt.by(paramMsgQuoteItem.tNu, "null"), paramFloat));
    localStringBuilder.append("：");
    bl localbl = new bl();
    localbl.setType(paramMsgQuoteItem.type);
    localbl.setContent(paramMsgQuoteItem.content);
    localbl.setMsgId(parambl.field_msgId);
    localbl.nY(paramMsgQuoteItem.tNs);
    parambl = a(paramContext, localbl, false);
    if (!bt.isNullOrNil(parambl)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parambl, paramFloat));
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
  
  public static CharSequence a(Context paramContext, float paramFloat, bl parambl)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = as(parambl);
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
    parambl = a(paramContext, parambl, com.tencent.mm.model.w.pF(parambl.field_talker));
    if (!bt.isNullOrNil(parambl)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, parambl, paramFloat));
    }
    AppMethodBeat.o(88795);
    return localStringBuilder;
  }
  
  private static String a(Context paramContext, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(88797);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = com.tencent.mm.sdk.platformtools.aj.getContext();
    }
    if (parambl == null)
    {
      AppMethodBeat.o(88797);
      return "";
    }
    String str = "";
    switch (parambl.getType())
    {
    default: 
      paramContext = ((Context)localObject).getString(2131761361);
    }
    for (;;)
    {
      AppMethodBeat.o(88797);
      return paramContext;
      paramContext = parambl.field_content;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = paramContext;
        if (!at(parambl))
        {
          int i = bi.uc(paramContext);
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
        if (com.tencent.mm.bs.d.axB("location"))
        {
          kp localkp = new kp();
          localkp.dpf.doZ = 1;
          localkp.dpf.dbD = parambl;
          com.tencent.mm.sdk.b.a.ESL.l(localkp);
          paramContext = localkp.dpg.dpi;
          parambl = localkp.dpg.dld;
          if (e(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (ahk(localkp.dpg.dld))
            {
              paramContext = str + parambl;
              continue;
              paramContext = ((Context)localObject).getString(2131761362);
              continue;
              parambl = k.b.rx(parambl.field_content);
              paramContext = str;
              if (parambl != null) {
                switch (parambl.type)
                {
                default: 
                  paramContext = str;
                  break;
                case 1: 
                case 53: 
                case 57: 
                  paramContext = str;
                  if (parambl.title != null)
                  {
                    paramContext = str;
                    if (parambl.title.length() > 0) {
                      paramContext = parambl.title;
                    }
                  }
                  break;
                case 6: 
                  if ((parambl.title != null) && (parambl.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { parambl.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761363, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((parambl.title != null) && (parambl.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { parambl.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761370, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((parambl.title != null) && (parambl.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { parambl.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131761360, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(2131761366, new Object[] { e(parambl) });
                  break;
                case 3: 
                  if ((parambl.title != null) && (parambl.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131761365, new Object[] { parambl.title });
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
  
  private static boolean ahk(String paramString)
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
  
  public static String as(bl parambl)
  {
    AppMethodBeat.i(88794);
    if (parambl == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = com.tencent.mm.util.d.cs(parambl);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (com.tencent.mm.model.w.pF(parambl.field_talker))
    {
      parambl = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(parambl.field_talker);
      localObject1 = localObject2;
      if (parambl != null)
      {
        parambl = parambl.sh(str);
        localObject1 = localObject2;
        if (!bt.isNullOrNil(parambl)) {
          localObject1 = parambl;
        }
      }
    }
    parambl = (bl)localObject1;
    if (bt.isNullOrNil((String)localObject1))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      parambl = (bl)localObject1;
      if (localObject2 != null) {
        parambl = ((au)localObject2).field_nickname;
      }
    }
    localObject1 = parambl;
    if (bt.isNullOrNil(parambl)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  private static boolean at(bl parambl)
  {
    return parambl.field_isSend == 1;
  }
  
  public static boolean cRr()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvb, 0) == 1)
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
    Object localObject1 = new pn();
    ((pn)localObject1).dvb.type = 0;
    ((pn)localObject1).dvb.dvd = paramb.gHI;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = ((pn)localObject1).dvc.dvl;
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).gKs.iterator();
    int i = 0;
    afy localafy;
    while (((Iterator)localObject2).hasNext())
    {
      localafy = (afy)((Iterator)localObject2).next();
      if ((!l.j(localafy)) || (bt.isNullOrNil(localafy.Dhb)) || (!localafy.Dhb.equals("WeNoteHtmlFile"))) {
        switch (localafy.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localafy.desc;
            if (!bt.isNullOrNil(str))
            {
              if (bt.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label356;
              }
              paramb = localafy.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
            localafy = paramb[i];
            if (localafy.length() > 0) {
              ((ArrayList)localObject2).add(localafy);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).gKs.size() == 2)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.a
 * JD-Core Version:    0.7.0.1
 */