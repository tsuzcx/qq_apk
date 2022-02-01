package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
{
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, List<bu> paramList, am paramam)
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
    if ((paramam == null) || ((int)paramam.gfj <= 0))
    {
      ad.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paramam);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.e.a parama, List<bu> paramList, am paramam)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label140:
    Object localObject3;
    if (!w.vF(paramam.field_username))
    {
      str = parama.JOR.getMMResources().getString(2131763063);
      localObject1 = paramam.adu();
      ba.aBQ();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.ajl().get(4, null) });
      g.yhR.f(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((u.aAy() & 0x1) != 0) {
        break label623;
      }
      ad.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label503;
      }
      localObject3 = (bu)localIterator.next();
      if (!((bu)localObject3).cxf()) {
        break label370;
      }
      o.aMJ();
      ((List)localObject1).add(t.Hh(((ei)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label140;
      if (bt.isNullOrNil(paramam.field_nickname))
      {
        localObject1 = com.tencent.mm.model.q.yQ(paramam.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = v.zf((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramam.adu())
      {
        str = String.format(parama.JOR.getMMResources().getString(2131763064), new Object[] { str });
        break;
      }
      label370:
      if (((bu)localObject3).cTc())
      {
        localObject3 = k.b.yr(((ei)localObject3).field_content);
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
          Object localObject4 = ao.bIX().aLD(((k.b)localObject3).dks);
          if (localObject4 == null) {
            break label140;
          }
          localObject4 = new e(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((e)localObject4).exists())
          {
            ((List)localObject1).add(i.k(com.tencent.mm.vfs.q.B(((e)localObject4).fOK()), false));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label503:
    paramList = new QQMailHistoryExporter(parama.JOR.getContext(), paramList, paramam).fCf();
    paramam = new Intent();
    paramam.putExtra("mail_mode", 21);
    paramam.putExtra("mail_content", paramList);
    paramam.putExtra("subject", str);
    paramam.putExtra("show_qqmail", true);
    paramam.putExtra("mail_edit_mode", true);
    paramam.putStringArrayListExtra("mail_attach", (ArrayList)localObject1);
    com.tencent.mm.bs.d.a(parama.JOO, "qqmail", ".ui.ComposeUI", paramam, 220, new d.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (l)this.JAE.bh(l.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.fDs())) {
          paramAnonymousIntent.fDq();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label623:
    ad.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new ai(parama.JOR.getContext(), paramList, paramam);
    Object localObject1 = paramList.fCf();
    paramam = new Intent("android.intent.action.SEND_MULTIPLE");
    paramam.setType("message/rfc822");
    paramam.putExtra("android.intent.extra.SUBJECT", str);
    paramam.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.JDY == null) {
      bool = true;
    }
    for (;;)
    {
      ad.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.JAA.size()) });
      if (paramList.JDY != null)
      {
        paramList = paramList.JDZ;
        paramam.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.JOR;
        paramam = Intent.createChooser(paramam, parama.JOR.getContext().getString(2131763062));
        paramam = new com.tencent.mm.hellhoundlib.b.a().bc(paramam);
        com.tencent.mm.hellhoundlib.a.a.a(paramList, paramam.ahp(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramam.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        ad.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.fCf();
        paramList = paramList.JDZ;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.JOR.getContext(), 2131763065, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */