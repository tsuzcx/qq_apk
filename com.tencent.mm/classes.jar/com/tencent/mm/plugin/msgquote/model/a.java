package com.tencent.mm.plugin.msgquote.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ly.b;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.e;
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
    com.tencent.mm.plugin.msgquote.a.b localb = ((com.tencent.mm.plugin.msgquote.a)g.ah(com.tencent.mm.plugin.msgquote.a.class)).getMsgQuoteStorage().Hk(paramMsgQuoteItem.zFI);
    if ((localb != null) && (localb.field_status == 1))
    {
      paramContext = new Pair(Boolean.FALSE, paramContext.getString(2131763202));
      AppMethodBeat.o(88796);
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, Util.nullAs(paramMsgQuoteItem.zFL, "null"), paramFloat));
    localStringBuilder.append("：");
    ca localca = new ca();
    localca.setType(paramMsgQuoteItem.type);
    localca.setContent(paramMsgQuoteItem.content);
    localca.setMsgId(paramca.field_msgId);
    localca.Cy(paramMsgQuoteItem.zFJ);
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
    AppMethodBeat.i(201796);
    if (paramca == null)
    {
      AppMethodBeat.o(201796);
      return null;
    }
    MsgQuoteItem localMsgQuoteItem = new MsgQuoteItem();
    localMsgQuoteItem.type = paramInt1;
    localMsgQuoteItem.zFI = paramca.field_msgSvrId;
    localMsgQuoteItem.zFJ = Util.nullAs(paramca.field_talker, "");
    localMsgQuoteItem.zFK = Util.nullAs(e.cT(paramca), "");
    if (Util.isNullOrNil(paramCharSequence))
    {
      paramCharSequence = "";
      localMsgQuoteItem.zFL = Util.nullAs(paramCharSequence, "");
      localMsgQuoteItem.zFM = Util.nullAs(paramca.fqK, "");
      if (!paramca.gDy()) {
        break label300;
      }
      paramCharSequence = Util.nullAs(e.cU(paramca), "");
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
        paramca = e.b(((w)g.af(w.class)).Z(paramca), paramHashMap, paramInt2);
        if (!Util.isNullOrNil(paramca)) {
          Log.d("MicroMsg.msgquote.MsgQuoteHelp", "MsgSource:%s", new Object[] { paramca });
        }
        localMsgQuoteItem.fqK = Util.nullAs(paramca, "");
        AppMethodBeat.o(201796);
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
      localMsgQuoteItem.content = Util.nullAs(e.cU(paramca), "");
    }
  }
  
  public static CharSequence a(Context paramContext, float paramFloat, ca paramca)
  {
    AppMethodBeat.i(88795);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = aH(paramca);
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
    paramca = a(paramContext, paramca, ab.Eq(paramca.field_talker));
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
      paramContext = ((Context)localObject).getString(2131763195);
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
        if (!aI(paramca))
        {
          int i = bp.Kp(paramContext);
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
        paramContext = ((Context)localObject).getString(2131763201);
        continue;
        paramContext = ((Context)localObject).getString(2131763205);
        continue;
        str = ((Context)localObject).getString(2131763198);
        paramContext = str;
        if (com.tencent.mm.br.c.aZU("location"))
        {
          ly locally = new ly();
          locally.dRv.dRq = 1;
          locally.dRv.dCM = paramca;
          EventCenter.instance.publish(locally);
          paramContext = locally.dRw.dRy;
          paramca = locally.dRw.dNk;
          if (g(paramContext, (Context)localObject))
          {
            paramContext = str + paramContext;
          }
          else
          {
            paramContext = str;
            if (aFt(locally.dRw.dNk))
            {
              paramContext = str + paramca;
              continue;
              paramContext = ((Context)localObject).getString(2131763196);
              continue;
              paramca = k.b.HD(paramca.field_content);
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
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131763197, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131763197, new Object[] { "" });
                  }
                  break;
                case 5: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131763204, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131763204, new Object[] { "" });
                  }
                  break;
                case 33: 
                case 36: 
                case 44: 
                case 48: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131763194, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131763194, new Object[] { "" });
                  }
                  break;
                case 24: 
                  paramContext = ((Context)localObject).getString(2131763200, new Object[] { e(paramca) });
                  break;
                case 3: 
                case 76: 
                  if ((paramca.title != null) && (paramca.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131763199, new Object[] { paramca.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131763199, new Object[] { "" });
                  }
                  break;
                case 4: 
                  paramContext = ((Context)localObject).getString(2131763205);
                  continue;
                  paramContext = k.b.HD(paramca.field_content);
                  if ((paramContext.title != null) && (paramContext.title.length() > 0)) {
                    paramContext = ((Context)localObject).getString(2131763199, new Object[] { paramContext.title });
                  } else {
                    paramContext = ((Context)localObject).getString(2131763199, new Object[] { "" });
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
  
  private static boolean aFt(String paramString)
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
  
  public static String aH(ca paramca)
  {
    AppMethodBeat.i(88794);
    if (paramca == null)
    {
      AppMethodBeat.o(88794);
      return "";
    }
    String str = e.cT(paramca);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (ab.Eq(paramca.field_talker))
    {
      paramca = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramca.field_talker);
      localObject1 = localObject2;
      if (paramca != null)
      {
        paramca = paramca.getDisplayName(str);
        localObject1 = localObject2;
        if (!Util.isNullOrNil(paramca)) {
          localObject1 = paramca;
        }
      }
    }
    paramca = (ca)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
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
  
  private static boolean aI(ca paramca)
  {
    return paramca.field_isSend == 1;
  }
  
  private static String e(k.b paramb)
  {
    AppMethodBeat.i(88800);
    Object localObject1 = new rc();
    ((rc)localObject1).dXF.type = 0;
    ((rc)localObject1).dXF.dXH = paramb.ixl;
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = ((rc)localObject1).dXG.dXP;
    paramb = null;
    Object localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject1).iAd.iterator();
    int i = 0;
    aml localaml;
    while (((Iterator)localObject2).hasNext())
    {
      localaml = (aml)((Iterator)localObject2).next();
      if ((!com.tencent.mm.plugin.fav.ui.l.j(localaml)) || (Util.isNullOrNil(localaml.Lwp)) || (!localaml.Lwp.equals("WeNoteHtmlFile"))) {
        switch (localaml.dataType)
        {
        default: 
          break;
        case 1: 
          if (i == 0)
          {
            String str = localaml.desc;
            if (!Util.isNullOrNil(str))
            {
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label356;
              }
              paramb = localaml.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
            localaml = paramb[i];
            if (localaml.length() > 0) {
              ((ArrayList)localObject2).add(localaml);
            }
            i += 1;
          }
        }
        if ((((ArrayList)localObject2).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject1).iAd.size() == 2)) {
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
  
  public static boolean elr()
  {
    AppMethodBeat.i(88801);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siA, 0) == 1)
    {
      AppMethodBeat.o(88801);
      return true;
    }
    AppMethodBeat.o(88801);
    return false;
  }
  
  private static boolean g(String paramString, Context paramContext)
  {
    AppMethodBeat.i(88798);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(paramContext.getResources().getString(2131763198))))
    {
      AppMethodBeat.o(88798);
      return true;
    }
    AppMethodBeat.o(88798);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.msgquote.model.a
 * JD-Core Version:    0.7.0.1
 */