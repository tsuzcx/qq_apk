package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static boolean a(com.tencent.mm.ui.chatting.d.a parama, List<bl> paramList, af paramaf)
  {
    AppMethodBeat.i(34482);
    if (parama == null)
    {
      ad.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramaf == null) || ((int)paramaf.fId <= 0))
    {
      ad.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paramaf);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.d.a parama, List<bl> paramList, af paramaf)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label140:
    Object localObject3;
    if (!w.pF(paramaf.field_username))
    {
      str = parama.GzJ.getMMResources().getString(2131763063);
      localObject1 = paramaf.ZW();
      az.arV();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.afk().get(4, null) });
      h.vKh.f(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((u.aqS() & 0x1) != 0) {
        break label623;
      }
      ad.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label499;
      }
      localObject3 = (bl)localIterator.next();
      if (!((bl)localObject3).cjM()) {
        break label370;
      }
      o.aCI();
      ((List)localObject1).add(t.zQ(((du)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label140;
      if (bt.isNullOrNil(paramaf.field_nickname))
      {
        localObject1 = com.tencent.mm.model.q.rW(paramaf.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = v.sh((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramaf.ZW())
      {
        str = String.format(parama.GzJ.getMMResources().getString(2131763064), new Object[] { str });
        break;
      }
      label370:
      if (((bl)localObject3).cxB())
      {
        localObject3 = k.b.rx(((du)localObject3).field_content);
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
          Object localObject4 = ap.bxS().aAL(((k.b)localObject3).dbA);
          if (localObject4 == null) {
            break label140;
          }
          localObject4 = new e(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((e)localObject4).exists())
          {
            ((List)localObject1).add(com.tencent.mm.vfs.q.B(((e)localObject4).fhU()));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label499:
    paramList = new QQMailHistoryExporter(parama.GzJ.getContext(), paramList, paramaf).eWc();
    paramaf = new Intent();
    paramaf.putExtra("mail_mode", 6);
    paramaf.putExtra("mail_content", paramList);
    paramaf.putExtra("subject", str);
    paramaf.putExtra("show_qqmail", true);
    paramaf.putStringArrayListExtra("mail_attach", (ArrayList)localObject1);
    paramaf.putStringArrayListExtra("mail_attach_title", (ArrayList)localObject2);
    com.tencent.mm.bs.d.a(parama.GzG, "qqmail", ".ui.ComposeUI", paramaf, 220, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (j)this.GmY.be(j.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.eXi())) {
          paramAnonymousIntent.eXg();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label623:
    ad.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new ai(parama.GzJ.getContext(), paramList, paramaf);
    Object localObject1 = paramList.eWc();
    paramaf = new Intent("android.intent.action.SEND_MULTIPLE");
    paramaf.setType("message/rfc822");
    paramaf.putExtra("android.intent.extra.SUBJECT", str);
    paramaf.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.Gqr == null) {
      bool = true;
    }
    for (;;)
    {
      ad.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.GmU.size()) });
      if (paramList.Gqr != null)
      {
        paramList = paramList.Gqs;
        paramaf.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.GzJ;
        paramaf = Intent.createChooser(paramaf, parama.GzJ.getContext().getString(2131763062));
        paramaf = new com.tencent.mm.hellhoundlib.b.a().bd(paramaf);
        com.tencent.mm.hellhoundlib.a.a.a(paramList, paramaf.adn(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramaf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        ad.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.eWc();
        paramList = paramList.Gqs;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.GzJ.getContext(), 2131763065, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */