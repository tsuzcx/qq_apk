package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.vfs.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, List<bv> paramList, an paraman)
  {
    AppMethodBeat.i(34482);
    if (parama == null)
    {
      ae.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paraman == null) || ((int)paraman.ght <= 0))
    {
      ae.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paraman);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.e.a parama, List<bv> paramList, an paraman)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label140:
    Object localObject3;
    if (!x.wb(paraman.field_username))
    {
      str = parama.Kkd.getMMResources().getString(2131763063);
      localObject1 = paraman.adF();
      bc.aCg();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.ajA().get(4, null) });
      g.yxI.f(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((v.aAO() & 0x1) != 0) {
        break label623;
      }
      ae.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label503;
      }
      localObject3 = (bv)localIterator.next();
      if (!((bv)localObject3).cyG()) {
        break label370;
      }
      com.tencent.mm.modelvideo.o.aNh();
      ((List)localObject1).add(t.HJ(((ei)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      ae.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label140;
      if (bu.isNullOrNil(paraman.field_nickname))
      {
        localObject1 = r.zA(paraman.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = com.tencent.mm.model.w.zP((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paraman.adF())
      {
        str = String.format(parama.Kkd.getMMResources().getString(2131763064), new Object[] { str });
        break;
      }
      label370:
      if (((bv)localObject3).cVH())
      {
        localObject3 = k.b.zb(((ei)localObject3).field_content);
        if (localObject3 == null) {
          break label140;
        }
        switch (((k.b)localObject3).type)
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          Object localObject4 = ao.bJV().aMZ(((k.b)localObject3).dlu);
          if (localObject4 == null) {
            break label140;
          }
          localObject4 = new k(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((k)localObject4).exists())
          {
            ((List)localObject1).add(com.tencent.mm.vfs.o.k(com.tencent.mm.vfs.w.B(((k)localObject4).fTh()), false));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label503:
    paramList = new QQMailHistoryExporter(parama.Kkd.getContext(), paramList, paraman).fGh();
    paraman = new Intent();
    paraman.putExtra("mail_mode", 21);
    paraman.putExtra("mail_content", paramList);
    paraman.putExtra("subject", str);
    paraman.putExtra("show_qqmail", true);
    paraman.putExtra("mail_edit_mode", true);
    paraman.putStringArrayListExtra("mail_attach_file", (ArrayList)localObject1);
    com.tencent.mm.br.d.a(parama.Kka, "qqmail", ".ui.ComposeUI", paraman, 220, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (l)this.JVv.bh(l.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.fHv())) {
          paramAnonymousIntent.fHt();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label623:
    ae.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new aj(parama.Kkd.getContext(), paramList, paraman);
    Object localObject1 = paramList.fGh();
    paraman = new Intent("android.intent.action.SEND_MULTIPLE");
    paraman.setType("message/rfc822");
    paraman.putExtra("android.intent.extra.SUBJECT", str);
    paraman.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.JYP == null) {
      bool = true;
    }
    for (;;)
    {
      ae.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.JVr.size()) });
      if (paramList.JYP != null)
      {
        paramList = paramList.JYQ;
        paraman.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.Kkd;
        paraman = Intent.createChooser(paraman, parama.Kkd.getContext().getString(2131763062));
        paraman = new com.tencent.mm.hellhoundlib.b.a().bc(paraman);
        com.tencent.mm.hellhoundlib.a.a.a(paramList, paraman.ahE(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paraman.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        ae.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.fGh();
        paramList = paramList.JYQ;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.Kkd.getContext(), 2131763065, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */