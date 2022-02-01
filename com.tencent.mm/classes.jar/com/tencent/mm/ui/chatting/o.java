package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.by.c.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class o
{
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, List<ca> paramList, as paramas)
  {
    AppMethodBeat.i(34482);
    if (parama == null)
    {
      Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      AppMethodBeat.o(34482);
      return false;
    }
    if ((paramas == null) || ((int)paramas.jxt <= 0))
    {
      Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paramas);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.e.a parama, List<ca> paramList, as paramas)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label141:
    Object localObject3;
    if (!ab.Lj(paramas.field_username))
    {
      str = parama.WQv.getMMResources().getString(R.l.eSg);
      localObject1 = paramas.ayr();
      bh.beI();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.aHp().b(4, null) });
      h.IzE.a(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((z.bdn() & 0x1) != 0) {
        break label624;
      }
      Log.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label504;
      }
      localObject3 = (ca)localIterator.next();
      if (!((ca)localObject3).dlR()) {
        break label372;
      }
      s.bqB();
      ((List)localObject1).add(x.XT(((et)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label141;
      if (Util.isNullOrNil(paramas.field_nickname))
      {
        localObject1 = v.Ps(paramas.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = aa.PJ((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramas.ayr())
      {
        str = String.format(parama.WQv.getMMResources().getString(R.l.eSh), new Object[] { str });
        break;
      }
      label372:
      if (((ca)localObject3).erk())
      {
        localObject3 = k.b.OQ(((et)localObject3).field_content);
        if (localObject3 == null) {
          break label141;
        }
        switch (((k.b)localObject3).type)
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          Object localObject4 = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(((k.b)localObject3).fvr);
          if (localObject4 == null) {
            break label141;
          }
          localObject4 = new q(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((q)localObject4).ifE())
          {
            ((List)localObject1).add(u.n(((q)localObject4).bOF(), false));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label504:
    paramList = new QQMailHistoryExporter(parama.WQv.getContext(), paramList, paramas).hNv();
    paramas = new Intent();
    paramas.putExtra("mail_mode", 21);
    paramas.putExtra("mail_content", paramList);
    paramas.putExtra("subject", str);
    paramas.putExtra("show_qqmail", true);
    paramas.putExtra("mail_edit_mode", true);
    paramas.putStringArrayListExtra("mail_attach_file", (ArrayList)localObject1);
    com.tencent.mm.by.c.a(parama.WQt, "qqmail", ".ui.ComposeUI", paramas, 220, new c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (l)this.WAa.bC(l.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.hOT())) {
          paramAnonymousIntent.hOR();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label624:
    Log.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new aj(parama.WQv.getContext(), paramList, paramas);
    Object localObject1 = paramList.hNv();
    paramas = new Intent("android.intent.action.SEND_MULTIPLE");
    paramas.setType("message/rfc822");
    paramas.putExtra("android.intent.extra.SUBJECT", str);
    paramas.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.WDK == null) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.WzW.size()) });
      if (paramList.WDK != null)
      {
        paramList = paramList.WDL;
        paramas.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.WQv;
        paramas = Intent.createChooser(paramas, parama.WQv.getContext().getString(R.l.eSf));
        paramas = new com.tencent.mm.hellhoundlib.b.a().bm(paramas);
        com.tencent.mm.hellhoundlib.a.a.b(paramList, paramas.aFh(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramas.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        Log.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.hNv();
        paramList = paramList.WDL;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.WQv.getContext(), R.l.eSi, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */