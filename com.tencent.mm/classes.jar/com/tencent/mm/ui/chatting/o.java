package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.br.c.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.vfs.s;
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
    if ((paramas == null) || ((int)paramas.gMZ <= 0))
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
    label140:
    Object localObject3;
    if (!ab.Eq(paramas.field_username))
    {
      str = parama.Pwc.getMMResources().getString(2131765214);
      localObject1 = paramas.arI();
      bg.aVF();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.model.c.azQ().get(4, null) });
      h.CyF.a(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((z.aUl() & 0x1) != 0) {
        break label623;
      }
      Log.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label503;
      }
      localObject3 = (ca)localIterator.next();
      if (!((ca)localObject3).cWJ()) {
        break label370;
      }
      com.tencent.mm.modelvideo.o.bhj();
      ((List)localObject1).add(t.Qw(((eo)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label140;
      if (Util.isNullOrNil(paramas.field_nickname))
      {
        localObject1 = v.Ic(paramas.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = com.tencent.mm.model.aa.getDisplayName((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramas.arI())
      {
        str = String.format(parama.Pwc.getMMResources().getString(2131765215), new Object[] { str });
        break;
      }
      label370:
      if (((ca)localObject3).dOQ())
      {
        localObject3 = k.b.HD(((eo)localObject3).field_content);
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
          Object localObject4 = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx(((k.b)localObject3).dCK);
          if (localObject4 == null) {
            break label140;
          }
          localObject4 = new com.tencent.mm.vfs.o(((com.tencent.mm.pluginsdk.model.app.c)localObject4).field_fileFullPath);
          if (((com.tencent.mm.vfs.o)localObject4).exists())
          {
            ((List)localObject1).add(s.k(com.tencent.mm.vfs.aa.z(((com.tencent.mm.vfs.o)localObject4).her()), false));
            ((List)localObject2).add(((k.b)localObject3).title);
          }
          break;
        }
      }
    }
    label503:
    paramList = new QQMailHistoryExporter(parama.Pwc.getContext(), paramList, paramas).gOl();
    paramas = new Intent();
    paramas.putExtra("mail_mode", 21);
    paramas.putExtra("mail_content", paramList);
    paramas.putExtra("subject", str);
    paramas.putExtra("show_qqmail", true);
    paramas.putExtra("mail_edit_mode", true);
    paramas.putStringArrayListExtra("mail_attach_file", (ArrayList)localObject1);
    com.tencent.mm.br.c.a(parama.Pwa, "qqmail", ".ui.ComposeUI", paramas, 220, new c.a()
    {
      public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(34481);
        paramAnonymousIntent = (l)this.PgH.bh(l.class);
        if ((-1 == paramAnonymousInt2) && (paramAnonymousIntent != null) && (paramAnonymousIntent.gPB())) {
          paramAnonymousIntent.gPz();
        }
        AppMethodBeat.o(34481);
      }
    });
    AppMethodBeat.o(34483);
    return false;
    label623:
    Log.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new aj(parama.Pwc.getContext(), paramList, paramas);
    Object localObject1 = paramList.gOl();
    paramas = new Intent("android.intent.action.SEND_MULTIPLE");
    paramas.setType("message/rfc822");
    paramas.putExtra("android.intent.extra.SUBJECT", str);
    paramas.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.Pkc == null) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.PgD.size()) });
      if (paramList.Pkc != null)
      {
        paramList = paramList.Pkd;
        paramas.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        paramList = parama.Pwc;
        paramas = Intent.createChooser(paramas, parama.Pwc.getContext().getString(2131765213));
        paramas = new com.tencent.mm.hellhoundlib.b.a().bl(paramas);
        com.tencent.mm.hellhoundlib.a.a.a(paramList, paramas.axQ(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramList.startActivity((Intent)paramas.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramList, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34483);
        return true;
        bool = false;
        continue;
        Log.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.gOl();
        paramList = paramList.Pkd;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.Pwc.getContext(), 2131765216, 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */