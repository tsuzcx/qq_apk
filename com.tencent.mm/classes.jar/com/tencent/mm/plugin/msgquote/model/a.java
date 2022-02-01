package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.mp.b;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static Pair<Boolean, CharSequence> a(Context paramContext, float paramFloat, ca paramca, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(88796);
    if (paramMsgQuoteItem == null)
    {
      paramContext = new Pair(Boolean.FALSE, "");
      AppMethodBeat.o(88796);
      return paramContext;
    }
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)h.ag(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().Oz(paramMsgQuoteItem.FkS);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(com.tencent.mm.plugin.msgquote.b.a.FkP));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, Util.nullAs(paramMsgQuoteItem.FkV, "null"), paramFloat));
    localStringBuilder.append("：");
    ca localca = new ca();
    localca.setType(paramMsgQuoteItem.type);
    localca.setContent(paramMsgQuoteItem.content);
    localca.setMsgId(paramca.field_msgId);
    localca.Jm(paramMsgQuoteItem.FkT);
    paramca = a(paramContext, localca, false);
    if (!Util.isNullOrNil(paramca)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramca, paramFloat));
    }
    if (localb == null)
    {
      Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getShowSummary() msgQute is null");
      if (Util.isNullOrNil(localStringBuilder.toString()))
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
  
  public static MsgQuoteItem a(ca paramca, int paramInt1, CharSequence paramCharSequence, int paramInt2, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(194901);
    if (paramca == null)
    {
      AppMethodBeat.o(194901);
      return null;
    }
    MsgQuoteItem localMsgQuoteItem = new MsgQuoteItem();
    localMsgQuoteItem.type = paramInt1;
    localMsgQuoteItem.FkS = paramca.field_msgSvrId;
    localMsgQuoteItem.FkT = Util.nullAs(paramca.field_talker, "");
    localMsgQuoteItem.FkU = Util.nullAs(g.dn(paramca), "");
    if (Util.isNullOrNil(paramCharSequence))
    {
      paramCharSequence = "";
      localMsgQuoteItem.FkV = Util.nullAs(paramCharSequence, "");
      localMsgQuoteItem.FkW = Util.nullAs(paramca.hxy, "");
      if (!paramca.hzN()) {
        break label300;
      }
      paramCharSequence = Util.nullAs(g.jdMethod_do(paramca), "");
    }
    for (;;)
    {
      try
      {
        paramInt1 = paramCharSequence.indexOf("<refermsg>", 0);
        int i = paramCharSequence.lastIndexOf("</refermsg>");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCharSequence.substring(0, paramInt1));
        localStringBuilder.append("<refermsg>");
        localStringBuilder.append(paramCharSequence.substring(i));
        localMsgQuoteItem.content = localStringBuilder.toString();
        paramca = g.c(((aa)h.ae(aa.class)).af(paramca), paramHashMap, paramInt2);
        if (!Util.isNullOrNil(paramca)) {
          Log.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", new Object[] { paramca });
        }
        localMsgQuoteItem.hxy = Util.nullAs(paramca, "");
        AppMethodBeat.o(194901);
        return localMsgQuoteItem;
        paramCharSequence = paramCharSequence.toString();
      }
      catch (Exception localException)
      {
        localMsgQuoteItem.content = paramCharSequence;
        Log.e("MicroMsg.msgquote.MsgQuoteHelp", "getMsgQuoteItem Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        continue;
      }
      label300:
      localMsgQuoteItem.content = Util.nullAs(g.jdMethod_do(paramca), "");
    }
  }
  
  public static CharSequence a(Context paramContext, float paramFloat, ca paramca)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = aR(paramca);
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
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, str1, paramFloat));
    localStringBuilder.append("：");
    paramca = a(paramContext, paramca, ab.Lj(paramca.field_talker));
    if (!Util.isNullOrNil(paramca)) {
      localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramca, paramFloat));
    }
    AppMethodBeat.o(88795);
    return localStringBuilder;
  }
  
  private static String a(Context paramContext, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(88797);
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = MMApplicationContext.getContext();
    }
    if (paramca == null)
    {
      AppMethodBeat.o(88797);
      return "";
    }
    String str = "";
    switch (paramca.getType())
    {
    default: 
      paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkI);
    }
    for (;;)
    {
      paramca = paramContext;
      if (!Util.isNullOrNil(paramContext)) {
        paramca = paramContext.replace('\n', ' ');
      }
      AppMethodBeat.o(88797);
      return paramca;
      paramContext = paramca.field_content;
      localObject = paramContext;
      if (paramBoolean)
      {
        localObject = paramContext;
        if (!aS(paramca))
        {
          int i = bq.RI(paramContext);
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
        paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkO);
        continue;
        paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkR);
        continue;
        str = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkL);
        paramContext = str;
        if (com.tencent.mm.by.c.blP("location"))
        {
          mp localmp = new mp();
          localmp.fKL.fKG = 1;
          localmp.fKL.fvt = paramca;
          EventCenter.instance.publish(localmp);
          paramContext = localmp.fKM.fKO;
          paramca = localmp.fKM.fGw;
          if (i(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (aPD(localmp.fKM.fGw))
            {
              paramContext = str + paramca;
              continue;
              paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkJ);
              continue;
              paramca = k.b.OQ(paramca.field_content);
              paramContext = str;
              if (paramca != null) {
                switch (paramca.type)
                {
                default: 
                  paramContext = str;
                  break;
                case 1: 
                case 53: 
                case 57: 
                  paramContext = str;
                  if (paramca.title != null)
                  {
                    paramContext = str;
                    if (paramca.title.length() > 0) {
                      paramContext = paramca.title;
                    }
                  }
                  break;
                case 6: 
                case 74: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkK, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkK, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkQ, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkQ, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkH, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkH, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkN, new Object[] { e(paramca) });
                  break;
                case 3: 
                case 76: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkM, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkM, new Object[] { "" });
                  }
                  break;
                case 4: 
                  paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkR);
                  continue;
                  paramContext = k.b.OQ(paramca.field_content);
                  if ((paramContext.title != null) && (paramContext.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkM, new Object[] { paramContext.title });
                  } else {
                    paramContext = ((Context)localObject).getString(com.tencent.mm.plugin.msgquote.b.a.FkM, new Object[] { "" });
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean aPD(String paramString)
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
  
  public static String aR(ca paramca)
  {
    AppMethodBeat.i(88794);
    if (paramca == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = g.dn(paramca);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (ab.Lj(paramca.field_talker))
    {
      paramca = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(paramca.field_talker);
      localObject1 = localObject2;
      if (paramca != null)
      {
        paramca = paramca.PJ(str);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramca)) {
          localObject1 = paramca;
        }
      }
    }
    paramca = (ca)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = ((n)h.ae(n.class)).bbL().RG(str);
      paramca = (ca)localObject1;
      if (localObject2 != null) {
        paramca = ((ax)localObject2).field_nickname;
      }
    }
    localObject1 = paramca;
    if (Util.isNullOrNil(paramca)) {
      localObject1 = str;
    }
    AppMethodBeat.o(88794);
    return localObject1;
  }
  
  private static boolean aS(ca paramca)
  {
    return paramca.field_isSend == 1;
  }
  
  private static String e(k.b paramb)
  {
    AppMethodBeat.i(88800);
    Object localObject1 = new sc();
    ((sc)localObject1).fRw.type = 0;
    ((sc)localObject1).fRw.fRy = paramb.lmA;
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = ((sc)localObject1).fRx.fRG;
    if (localObject1 == null)
    {
      AppMethodBeat.o(88800);
      return "";
    }
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).lpz.iterator();
    int i = 0;
    anm localanm;
    while (((Iterator)localObject2).hasNext())
    {
      localanm = (anm)((Iterator)localObject2).next();
      if ((!com.tencent.mm.plugin.fav.ui.l.j(localanm)) || (Util.isNullOrNil(localanm.SyO)) || (!localanm.SyO.equals("WeNoteHtmlFile"))) {
        switch (localanm.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localanm.desc;
            if (!Util.isNullOrNil(str))
            {
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label368;
              }
              paramb = localanm.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
          break;
        }
      }
    }
    label368:
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
            localanm = paramb[i];
            if (localanm.length() > 0) {
              ((ArrayList)localObject2).add(localanm);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).lpz.size() == 2)) {
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
  
  public static boolean eVa()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vSy, 0) == 1)
    {
      AppMethodBeat.o(88801);
      return true;
    }
    AppMethodBeat.o(88801);
    return false;
  }
  
  private static boolean i(String paramString, Context paramContext)
  {
    AppMethodBeat.i(88798);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(paramContext.getResources().getString(com.tencent.mm.plugin.msgquote.b.a.FkL))))
    {
      AppMethodBeat.o(88798);
      return true;
    }
    AppMethodBeat.o(88798);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.a
 * JD-Core Version:    0.7.0.1
 */