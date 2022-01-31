package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static boolean a(com.tencent.mm.ui.chatting.c.a parama, List<bi> paramList, ad paramad)
  {
    if (parama == null)
    {
      y.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      return false;
    }
    if ((paramad == null) || ((int)paramad.dBe <= 0))
    {
      y.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      return false;
    }
    return b(parama, paramList, paramad);
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.c.a parama, List<bi> paramList, ad paramad)
  {
    String str;
    Object localObject2;
    label136:
    Object localObject3;
    if (!s.fn(paramad.field_username))
    {
      str = parama.vtz.getMMResources().getString(R.l.send_mail_subject);
      localObject1 = paramad.Bp();
      au.Hx();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.Dz().get(4, null) });
      h.nFQ.f(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((q.Gu() & 0x1) != 0) {
        break label611;
      }
      y.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label492;
      }
      localObject3 = (bi)localIterator.next();
      if (!((bi)localObject3).aRQ()) {
        break label367;
      }
      com.tencent.mm.modelvideo.o.Sr();
      ((List)localObject1).add(t.nS(((cs)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      y.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label136;
      if (bk.bl(paramad.field_nickname))
      {
        localObject1 = m.gK(paramad.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = r.gV((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramad.Bp())
      {
        str = String.format(parama.vtz.getMMResources().getString(R.l.send_mail_suject_room), new Object[] { str });
        break;
      }
      label367:
      if (((bi)localObject3).aVK())
      {
        localObject3 = g.a.gp(((cs)localObject3).field_content);
        if (localObject3 == null) {
          break label136;
        }
        switch (((g.a)localObject3).type)
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          Object localObject4 = ap.avh().VQ(((g.a)localObject3).bFE);
          if (localObject4 == null) {
            break label136;
          }
          localObject4 = new File(((b)localObject4).field_fileFullPath);
          if (((File)localObject4).exists())
          {
            ((List)localObject1).add(((File)localObject4).getAbsolutePath());
            ((List)localObject2).add(((g.a)localObject3).title);
          }
          break;
        }
      }
    }
    label492:
    paramList = new QQMailHistoryExporter(parama.vtz.getContext(), paramList, paramad).cDh();
    paramad = new Intent();
    paramad.putExtra("mail_mode", 6);
    paramad.putExtra("mail_content", paramList);
    paramad.putExtra("subject", str);
    paramad.putExtra("show_qqmail", true);
    paramad.putStringArrayListExtra("mail_attach", (ArrayList)localObject1);
    paramad.putStringArrayListExtra("mail_attach_title", (ArrayList)localObject2);
    d.a(parama.vtx, "qqmail", ".ui.ComposeUI", paramad, 220, new o.1(parama));
    return false;
    label611:
    y.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new al(parama.vtz.getContext(), paramList, paramad);
    Object localObject1 = paramList.cDh();
    paramad = new Intent("android.intent.action.SEND_MULTIPLE");
    paramad.setType("message/rfc822");
    paramad.putExtra("android.intent.extra.SUBJECT", str);
    paramad.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.kzt == null) {
      bool = true;
    }
    for (;;)
    {
      y.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.vju.size()) });
      if (paramList.kzt != null)
      {
        paramList = paramList.vmE;
        paramad.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        parama.vtz.startActivity(Intent.createChooser(paramad, parama.vtz.getContext().getString(R.l.send_mail_selector)));
        return true;
        bool = false;
        continue;
        y.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.cDh();
        paramList = paramList.vmE;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.vtz.getContext(), R.l.send_no_email_app, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */