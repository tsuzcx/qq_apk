package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.tools.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static com.tencent.mm.ui.base.p zya = null;
  private static m.a zyv;
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(30616);
    Activity localActivity = parama.zJz.getContext();
    if ((!ah.isNullOrNil(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(2131297087);
      zya = h.b(localActivity, localActivity.getString(2131303124), false, null);
      com.tencent.mm.ui.chatting.c.j.zEQ.e(new m.b(parama, localActivity, paramString, paramLong, zyv));
    }
    ((i)parama.ay(i.class)).dHU();
    AppMethodBeat.o(30616);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, List<bi> paramList, boolean paramBoolean, com.tencent.mm.ui.chatting.c.j paramj, ad paramad)
  {
    AppMethodBeat.i(30612);
    if (parama == null)
    {
      ab.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      AppMethodBeat.o(30612);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      AppMethodBeat.o(30612);
      return;
    }
    Object localObject = new m.a((byte)0);
    zyv = (m.a)localObject;
    ((m.a)localObject).zyt = new LinkedList(paramList);
    zyv.zvB = paramBoolean;
    zyv.cEG = paramad.field_username;
    zyv.zyC = true;
    Activity localActivity = parama.zJz.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(30612);
      return;
    }
    l locall = new l(localActivity);
    locall.AvY = new m.1();
    locall.AvZ = new m.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.p.u(localActivity, "com.tencent.wework")) {}
    for (localObject = j.dGl();; localObject = j.dGk())
    {
      locall.sao = new m.3((List)localObject);
      locall.sap = new m.4(paramList, localActivity, parama, paramad, paramj);
      locall.cwt();
      AppMethodBeat.o(30612);
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(30614);
    Object localObject = f.rS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(30614);
      return;
    }
    if (((com.tencent.mm.aj.d)localObject).aei())
    {
      localObject = new Intent(parama.zJz.getContext(), BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", zyv.zyC);
      parama.a((Intent)localObject, 225, new m.6(parama));
      AppMethodBeat.o(30614);
      return;
    }
    if (((com.tencent.mm.aj.d)localObject).aeg())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.bq.d.a(parama.zJz, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    AppMethodBeat.o(30614);
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.d.a parama, List<bi> paramList)
  {
    AppMethodBeat.i(30613);
    Activity localActivity = parama.zJz.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(30613);
      return;
    }
    Object localObject = f.rS(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(30613);
      return;
    }
    boolean bool1 = ((com.tencent.mm.aj.d)localObject).aei();
    boolean bool2;
    int i;
    if (zyv.zyC)
    {
      bool2 = j.eX(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          zyv.zyt = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label268;
          }
          paramList = localActivity.getString(2131299314);
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        h.a(localActivity, paramList, "", new m.5(paramString, parama), null);
        AppMethodBeat.o(30613);
        return;
        localObject = paramList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bi localbi = (bi)((Iterator)localObject).next();
            if ((!localbi.isText()) && (!localbi.dvW()) && (!localbi.dvX()) && (!localbi.bCp()) && (!j.aE(localbi)))
            {
              i = 1;
              break;
            }
          }
        }
        i = 0;
        break;
        if (!bool2) {
          break label268;
        }
        paramList = localActivity.getString(2131299315);
        continue;
      }
      a(paramString, parama);
      AppMethodBeat.o(30613);
      return;
      label268:
      paramList = null;
    }
  }
  
  public static oa bQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(30615);
    oa localoa = new oa();
    localoa.cEz.type = 6;
    localoa.cEz.cEF = zyv.zyt;
    localoa.cEz.toUser = paramString;
    localoa.cEz.cEG = zyv.cEG;
    localoa.cEz.context = paramContext;
    com.tencent.mm.sdk.b.a.ymk.l(localoa);
    zyv.cDZ = localoa.cEA.cDZ;
    zyv.zyu = localoa.cEA.cEI;
    AppMethodBeat.o(30615);
    return localoa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */