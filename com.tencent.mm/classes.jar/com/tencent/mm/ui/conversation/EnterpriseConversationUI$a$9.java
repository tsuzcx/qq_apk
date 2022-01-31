package com.tencent.mm.ui.conversation;

import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.LinkedList;

final class EnterpriseConversationUI$a$9
  extends ah
{
  EnterpriseConversationUI$a$9(EnterpriseConversationUI.a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i1;
    LinkedList localLinkedList;
    int k;
    int i;
    int j;
    int m;
    Object localObject;
    String str;
    int n;
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.vSW.thisActivity() != null) && (!this.vSW.thisActivity().isFinishing()))
    {
      i1 = EnterpriseConversationUI.a.f(this.vSW).getCount();
      paramMessage = new LinkedList();
      localLinkedList = new LinkedList();
      k = 0;
      i = 0;
      j = 0;
      m = 0;
      if (m < i1)
      {
        localObject = (ak)EnterpriseConversationUI.a.f(this.vSW).getItem(m);
        if (localObject == null) {
          break label881;
        }
        str = ((as)localObject).field_username;
        if (str == null) {
          break label881;
        }
        if ((!s.hk(str)) || (!f.le(str)))
        {
          y.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
          paramMessage.add(str);
          n = j;
          j = i;
          i = n;
        }
      }
    }
    for (;;)
    {
      n = m + 1;
      m = j;
      j = i;
      i = m;
      m = n;
      break;
      ad localad = ((j)g.r(j.class)).Fw().abl(str);
      boolean bool = ((j)g.r(j.class)).FB().abD(str);
      if ((localad != null) && ((localad.field_type & 0x800) != 0))
      {
        n = 1;
        label247:
        if ((n == 0) || (bool)) {
          break label337;
        }
        ((j)g.r(j.class)).FB().abB(str);
      }
      for (;;)
      {
        if (f.ld(str)) {
          localLinkedList.add(str);
        }
        if (((as)localObject).field_unReadCount <= 0) {
          break label881;
        }
        if (!s.hZ(str)) {
          break label371;
        }
        n = k + 1;
        k = i;
        i = j;
        j = k;
        k = n;
        break;
        n = 0;
        break label247;
        label337:
        if ((n == 0) && (bool)) {
          ((j)g.r(j.class)).FB().abC(str);
        }
      }
      label371:
      n = i + 1;
      i = ((as)localObject).field_unReadCount + j;
      j = n;
      continue;
      localObject = z.MH().kD(EnterpriseConversationUI.a.c(this.vSW));
      long l1;
      if (localObject != null)
      {
        m = ((b)localObject).field_qyUin;
        if (localObject == null) {
          break label868;
        }
        l1 = ((b)localObject).field_wwCorpId;
        label429:
        if (localObject == null) {
          break label874;
        }
      }
      label868:
      label874:
      for (long l2 = ((b)localObject).field_wwUserVid;; l2 = 0L)
      {
        n = 0;
        if (!bk.bl(EnterpriseConversationUI.a.l(this.vSW))) {
          n = z.MH().kF(EnterpriseConversationUI.a.l(this.vSW));
        }
        h.nFQ.f(12892, new Object[] { EnterpriseConversationUI.a.c(this.vSW), Integer.valueOf(EnterpriseConversationUI.a.m(this.vSW)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.a.n(this.vSW)), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(EnterpriseConversationUI.a.o(this.vSW)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
        y.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.a.c(this.vSW), Integer.valueOf(EnterpriseConversationUI.a.m(this.vSW)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.a.n(this.vSW)), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(EnterpriseConversationUI.a.o(this.vSW)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
        if (paramMessage.size() > 0)
        {
          au.Hx();
          com.tencent.mm.model.c.FB().aA(paramMessage);
          EnterpriseConversationUI.a.f(this.vSW).yc();
        }
        if (z.MK().kC(EnterpriseConversationUI.a.c(this.vSW)))
        {
          z.MH();
          com.tencent.mm.ai.c.a(EnterpriseConversationUI.a.c(this.vSW), null);
        }
        z.MK().kC(EnterpriseConversationUI.a.p(this.vSW));
        if (localLinkedList.size() <= 0) {
          break label880;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          z.MK().kC((String)localLinkedList.get(i));
          i += 1;
        }
        m = 0;
        break;
        l1 = 0L;
        break label429;
      }
      label880:
      return;
      label881:
      n = i;
      i = j;
      j = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.9
 * JD-Core Version:    0.7.0.1
 */