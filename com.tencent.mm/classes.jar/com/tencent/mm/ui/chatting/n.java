package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static boolean a(com.tencent.mm.ui.chatting.d.a parama, List<bo> paramList, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(34482);
    if (parama == null)
    {
      ac.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramai == null) || ((int)paramai.fLJ <= 0))
    {
      ac.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paramai);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.d.a parama, List<bo> paramList, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label140:
    Object localObject3;
    if (!w.sQ(paramai.field_username))
    {
      str = parama.HZF.getMMResources().getString(2131763063);
      localObject1 = paramai.aaR();
      az.ayM();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.agA().get(4, null) });
      h.wUl.f(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((u.axI() & 0x1) != 0) {
        break label623;
      }
      ac.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label499;
      }
      localObject3 = (bo)localIterator.next();
      if (!((bo)localObject3).crt()) {
        break label370;
      }
      o.aJy();
      ((List)localObject1).add(t.DV(((dy)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      ac.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label140;
      if (bs.isNullOrNil(paramai.field_nickname))
      {
        localObject1 = com.tencent.mm.model.q.vZ(paramai.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = v.wk((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramai.aaR())
      {
        str = String.format(parama.HZF.getMMResources().getString(2131763064), new Object[] { str });
        break;
      }
      label370:
      if (((bo)localObject3).cKN())
      {
        localObject3 = k.b.vA(((dy)localObject3).field_content);
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
          Object localObject4 = ap.bEO().aGd(((k.b)localObject3).cZa);
          if (localObject4 == null) {
            break label140;
          }
          localObject4 = new e(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((e)localObject4).exists())
          {
            ((List)localObject1).add(com.tencent.mm.vfs.q.B(((e)localObject4).fxV()));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label499:
    paramList = new QQMailHistoryExporter(parama.HZF.getContext(), paramList, paramai).flO();
    paramai = new Intent();
    paramai.putExtra("mail_mode", 6);
    paramai.putExtra("mail_content", paramList);
    paramai.putExtra("subject", str);
    paramai.putExtra("show_qqmail", true);
    paramai.putStringArrayListExtra("mail_attach", (ArrayList)localObject1);
    paramai.putStringArrayListExtra("mail_attach_title", (ArrayList)localObject2);
    com.tencent.mm.br.d.a(parama.HZC, "qqmail", ".ui.ComposeUI", paramai, 220, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (j)this.HMO.bf(j.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.fmU())) {
          paramAnonymousIntent.fmS();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label623:
    ac.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new ai(parama.HZF.getContext(), paramList, paramai);
    Object localObject1 = paramList.flO();
    paramai = new Intent("android.intent.action.SEND_MULTIPLE");
    paramai.setType("message/rfc822");
    paramai.putExtra("android.intent.extra.SUBJECT", str);
    paramai.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.HQj == null) {
      bool = true;
    }
    for (;;)
    {
      ac.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.HMK.size()) });
      if (paramList.HQj != null)
      {
        paramList = paramList.HQk;
        paramai.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.HZF;
        paramai = Intent.createChooser(paramai, parama.HZF.getContext().getString(2131763062));
        paramai = new com.tencent.mm.hellhoundlib.b.a().ba(paramai);
        com.tencent.mm.hellhoundlib.a.a.a(paramList, paramai.aeD(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramai.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        ac.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.flO();
        paramList = paramList.HQk;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.HZF.getContext(), 2131763065, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */