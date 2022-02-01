package com.tencent.mm.ui.conversation;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.d;
import com.tencent.mm.al.e;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.LinkedList;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$6
  extends MMHandler
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$6(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(234161);
    int i1;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    int j;
    int k;
    int i;
    int m;
    label106:
    String str;
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.Qfj.thisActivity() != null) && (!this.Qfj.thisActivity().isFinishing()))
    {
      i1 = EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).getCount();
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      j = 0;
      k = 0;
      i = 0;
      m = 0;
      if (m < i1)
      {
        paramMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).anT(m);
        if (paramMessage == null)
        {
          paramMessage = null;
          if (paramMessage == null) {
            break label858;
          }
          str = paramMessage.field_username;
          if (str == null) {
            break label858;
          }
          if ((ab.IS(str)) && (com.tencent.mm.al.g.Ni(str))) {
            break label178;
          }
          Log.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
          localLinkedList1.add(str);
        }
      }
    }
    label178:
    label317:
    label840:
    label846:
    label852:
    label858:
    for (;;)
    {
      m += 1;
      break;
      paramMessage = paramMessage.conversation;
      break label106;
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
      boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(str);
      int n;
      if ((localas != null) && ((localas.field_type & 0x800) != 0))
      {
        n = 1;
        label242:
        if ((n == 0) || (bool)) {
          break label317;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bke(str);
      }
      for (;;)
      {
        if (com.tencent.mm.al.g.Nh(str)) {
          localLinkedList2.add(str);
        }
        if (paramMessage.field_unReadCount <= 0) {
          break label858;
        }
        if (!ab.JJ(str)) {
          break label351;
        }
        j += 1;
        break;
        n = 0;
        break label242;
        if ((n == 0) && (bool)) {
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkf(str);
        }
      }
      label351:
      k += 1;
      i = paramMessage.field_unReadCount + i;
      continue;
      paramMessage = ag.bar().MO(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj));
      long l1;
      if (paramMessage != null)
      {
        m = paramMessage.field_qyUin;
        if (paramMessage == null) {
          break label840;
        }
        l1 = paramMessage.field_wwCorpId;
        if (paramMessage == null) {
          break label846;
        }
      }
      for (long l2 = paramMessage.field_wwUserVid;; l2 = 0L)
      {
        n = 0;
        if (!Util.isNullOrNil(EnterpriseConversationUI.EnterpriseConversationFmUI.e(this.Qfj))) {
          n = ag.bar().MQ(EnterpriseConversationUI.EnterpriseConversationFmUI.e(this.Qfj));
        }
        h.CyF.a(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.Qfj)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(this.Qfj)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(this.Qfj)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
        Log.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.Qfj)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(this.Qfj)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(this.Qfj)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
        if (localLinkedList1.size() > 0)
        {
          bg.aVF();
          c.aST().bI(localLinkedList1);
          EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).anp();
        }
        if (ag.bau().MN(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj)))
        {
          ag.bar();
          e.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj), null);
        }
        ag.bau().MN(EnterpriseConversationUI.EnterpriseConversationFmUI.i(this.Qfj));
        if (localLinkedList2.size() <= 0) {
          break label852;
        }
        i = 0;
        while (i < localLinkedList2.size())
        {
          ag.bau().MN((String)localLinkedList2.get(i));
          i += 1;
        }
        m = 0;
        break;
        l1 = 0L;
        break label401;
      }
      AppMethodBeat.o(234161);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.6
 * JD-Core Version:    0.7.0.1
 */