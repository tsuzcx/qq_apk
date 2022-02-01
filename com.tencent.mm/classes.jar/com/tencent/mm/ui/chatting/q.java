package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.br.c.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.n;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public static boolean a(com.tencent.mm.ui.chatting.d.a parama, List<cc> paramList, au paramau)
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
    if ((paramau == null) || ((int)paramau.maN <= 0))
    {
      Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      AppMethodBeat.o(34482);
      return false;
    }
    boolean bool = b(parama, paramList, paramau);
    AppMethodBeat.o(34482);
    return bool;
  }
  
  private static boolean b(com.tencent.mm.ui.chatting.d.a parama, List<cc> paramList, au paramau)
  {
    AppMethodBeat.i(34483);
    String str;
    Object localObject2;
    label141:
    Object localObject3;
    if (!au.bwE(paramau.field_username))
    {
      str = parama.aezO.getMMResources().getString(R.l.gUQ);
      localObject1 = paramau.aSU();
      bh.bCz();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.ban().d(4, null) });
      h.OAn.b(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((z.bBf() & 0x1) != 0) {
        break label627;
      }
      Log.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label507;
      }
      localObject3 = (cc)localIterator.next();
      if (!((cc)localObject3).dSH()) {
        break label372;
      }
      com.tencent.mm.modelvideo.v.bOh();
      ((List)localObject1).add(com.tencent.mm.modelvideo.aa.PX(((fi)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label141;
      if (Util.isNullOrNil(paramau.field_nickname))
      {
        localObject1 = com.tencent.mm.model.v.Il(paramau.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = com.tencent.mm.model.aa.getDisplayName((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramau.aSU())
      {
        str = String.format(parama.aezO.getMMResources().getString(R.l.gUR), new Object[] { str });
        break;
      }
      label372:
      if (((cc)localObject3).fxR())
      {
        localObject3 = k.b.Hf(((fi)localObject3).field_content);
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
          Object localObject4 = as.cWJ().bpI(((k.b)localObject3).hzM);
          if (localObject4 == null) {
            break label141;
          }
          localObject4 = new u(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((u)localObject4).jKS())
          {
            ((List)localObject1).add(y.n(ah.v(((u)localObject4).jKT()), false));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label507:
    paramList = new QQMailHistoryExporter(parama.aezO.getContext(), paramList, paramau).jqb();
    paramau = new Intent();
    paramau.putExtra("mail_mode", 21);
    paramau.putExtra("mail_content", paramList);
    paramau.putExtra("subject", str);
    paramau.putExtra("show_qqmail", true);
    paramau.putExtra("mail_edit_mode", true);
    paramau.putStringArrayListExtra("mail_attach_file", (ArrayList)localObject1);
    com.tencent.mm.br.c.a(parama.aezM, "qqmail", ".ui.ComposeUI", paramau, 220, new c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (n)q.this.cm(n.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.jrJ())) {
          paramAnonymousIntent.jrH();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label627:
    Log.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new am(parama.aezO.getContext(), paramList, paramau);
    Object localObject1 = paramList.jqb();
    paramau = new Intent("android.intent.action.SEND_MULTIPLE");
    paramau.setType("message/rfc822");
    paramau.putExtra("android.intent.extra.SUBJECT", str);
    paramau.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.aelk == null) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.aehr.size()) });
      if (paramList.aelk != null)
      {
        paramList = paramList.aell;
        paramau.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.aezO;
        paramau = Intent.createChooser(paramau, parama.aezO.getContext().getString(R.l.gUP));
        paramau = new com.tencent.mm.hellhoundlib.b.a().cG(paramau);
        com.tencent.mm.hellhoundlib.a.a.b(paramList, paramau.aYi(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramau.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        Log.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.jqb();
        paramList = paramList.aell;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.aezO.getContext(), R.l.gUS, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q
 * JD-Core Version:    0.7.0.1
 */