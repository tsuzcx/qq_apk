package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static boolean a(com.tencent.mm.ui.chatting.d.a parama, List<bi> paramList, ad paramad)
  {
    AppMethodBeat.i(30618);
    if (parama == null)
    {
      ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      AppMethodBeat.o(30618);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      AppMethodBeat.o(30618);
      return false;
    }
    if ((paramad == null) || ((int)paramad.euF <= 0))
    {
      ab.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(30618);
      return false;
    }
    boolean bool = b(parama, paramList, paramad);
    AppMethodBeat.o(30618);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.d.a parama, List<bi> paramList, ad paramad)
  {
    AppMethodBeat.i(30619);
    Object localObject3;
    label141:
    Object localObject4;
    if (!com.tencent.mm.model.t.lA(paramad.field_username))
    {
      localObject1 = parama.zJz.getMMResources().getString(2131303114);
      localObject2 = paramad.Oe();
      aw.aaz();
      localObject1 = String.format((String)localObject1, new Object[] { localObject2, com.tencent.mm.model.c.Ru().get(4, null) });
      h.qsU.e(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((r.Zy() & 0x1) != 0) {
        break label621;
      }
      ab.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label496;
      }
      localObject4 = (bi)localIterator.next();
      if (!((bi)localObject4).byj()) {
        break label371;
      }
      o.alE();
      ((List)localObject2).add(com.tencent.mm.modelvideo.t.vf(((dd)localObject4).field_imgPath));
      ((List)localObject3).add(null);
    }
    for (;;)
    {
      ab.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject2 + "file name = " + localObject3);
      break label141;
      if (bo.isNullOrNil(paramad.field_nickname))
      {
        localObject2 = com.tencent.mm.model.n.nt(paramad.field_username).iterator();
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + (String)localObject3 + ", ") {
          localObject3 = s.nE((String)((Iterator)localObject2).next());
        }
      }
      for (localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);; localObject1 = paramad.Oe())
      {
        localObject1 = String.format(parama.zJz.getMMResources().getString(2131303115), new Object[] { localObject1 });
        break;
      }
      label371:
      if (((bi)localObject4).bCn())
      {
        localObject4 = j.b.mY(((dd)localObject4).field_content);
        if (localObject4 == null) {
          break label141;
        }
        switch (((j.b)localObject4).type)
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          Object localObject5 = al.aUJ().alo(((j.b)localObject4).cmN);
          if (localObject5 == null) {
            break label141;
          }
          localObject5 = new File(((b)localObject5).field_fileFullPath);
          if (((File)localObject5).exists())
          {
            ((List)localObject2).add(((File)localObject5).getAbsolutePath());
            ((List)localObject3).add(((j.b)localObject4).title);
          }
          break;
        }
      }
    }
    label496:
    paramList = new QQMailHistoryExporter(parama.zJz.getContext(), paramList, paramad).dGV();
    paramad = new Intent();
    paramad.putExtra("mail_mode", 6);
    paramad.putExtra("mail_content", paramList);
    paramad.putExtra("subject", (String)localObject1);
    paramad.putExtra("show_qqmail", true);
    paramad.putStringArrayListExtra("mail_attach", (ArrayList)localObject2);
    paramad.putStringArrayListExtra("mail_attach_title", (ArrayList)localObject3);
    d.a(parama.zJx, "qqmail", ".ui.ComposeUI", paramad, 220, new n.1(parama));
    AppMethodBeat.o(30619);
    return false;
    label621:
    ab.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new ai(parama.zJz.getContext(), paramList, paramad);
    Object localObject2 = paramList.dGV();
    paramad = new Intent("android.intent.action.SEND_MULTIPLE");
    paramad.setType("message/rfc822");
    paramad.putExtra("android.intent.extra.SUBJECT", (String)localObject1);
    paramad.putExtra("android.intent.extra.TEXT", (String)localObject2);
    Object localObject1 = parama.zJz.getContext();
    boolean bool;
    if (paramList.mVj == null) {
      bool = true;
    }
    for (;;)
    {
      ab.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.zyt.size()) });
      if (paramList.mVj != null)
      {
        paramList = paramList.zCa;
        paramad.putParcelableArrayListExtra("android.intent.extra.STREAM", k.e((Context)localObject1, paramList));
      }
      try
      {
        parama.zJz.startActivity(Intent.createChooser(paramad, parama.zJz.getContext().getString(2131303113)));
        AppMethodBeat.o(30619);
        return true;
        bool = false;
        continue;
        ab.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.dGV();
        paramList = paramList.zCa;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.zJz.getContext(), 2131303116, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */