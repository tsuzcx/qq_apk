package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.widget.ListView;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends o
  implements m.b
{
  private Cursor eYd;
  private int fromScene;
  int nCR;
  int nCS;
  private List<String> nCT;
  private int nCU = 0;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList2, true, false);
    this.nCT = paramList1;
    this.fromScene = paramInt;
    y.i("MicroMsg.RecentConversationAdapter", "create!");
    xO();
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(this);
  }
  
  private void xO()
  {
    y.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    this.nCU = 0;
    ArrayList localArrayList = new ArrayList();
    this.nCR = -1;
    this.nCS = -1;
    Object localObject;
    int i;
    if ((this.nCT != null) && (this.nCT.size() > 0))
    {
      com.tencent.mm.kernel.g.DQ();
      localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().dw(this.nCT);
      localArrayList.add(localObject);
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        this.nCR = this.vLI.getContentLV().getHeaderViewsCount();
        this.nCU += 1;
      }
    }
    for (;;)
    {
      localObject = this.dru;
      if (localObject != null)
      {
        ((List)localObject).addAll(this.nCT);
        label162:
        if (this.fromScene != 1) {
          break label283;
        }
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(s.dUU, (List)localObject, this.vLZ, "");
        label199:
        if (((Cursor)localObject).getCount() <= 0) {
          break label334;
        }
        this.nCU += 1;
        if (i <= 0) {
          break label315;
        }
        this.nCS = (i + this.nCR + 1);
      }
      for (;;)
      {
        localArrayList.add(localObject);
        this.eYd = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        return;
        this.nCR = -1;
        break;
        localObject = this.nCT;
        break label162;
        label283:
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(s.dUY, (List)localObject, this.vLZ, "");
        break label199;
        label315:
        this.nCS = this.vLI.getContentLV().getHeaderViewsCount();
        continue;
        label334:
        this.nCS = -1;
      }
      i = 0;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    xO();
    notifyDataSetChanged();
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().b(this);
  }
  
  public final int getCount()
  {
    return this.eYd.getCount() + this.nCU;
  }
  
  protected final a jQ(int paramInt)
  {
    Object localObject;
    if ((paramInt == this.nCS) || (paramInt == this.nCR))
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      if (paramInt == this.nCR) {
        if (this.fromScene == 1) {
          ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getResources().getString(a.i.aa_recent_group);
        }
      }
      while (paramInt != this.nCS)
      {
        return localObject;
        ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getResources().getString(a.i.remittance_recent_friends);
        return localObject;
      }
      ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getResources().getString(a.i.wallet_select_conversation_cur);
      return localObject;
    }
    int i;
    if (this.nCU == 2) {
      if (paramInt > this.nCS) {
        i = paramInt - 2;
      }
    }
    while (this.eYd.moveToPosition(i))
    {
      localObject = new e(paramInt);
      ak localak = new ak();
      localak.d(this.eYd);
      com.tencent.mm.kernel.g.DQ();
      ((a)localObject).dnp = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abf(localak.field_username);
      if (((a)localObject).dnp == null)
      {
        com.tencent.mm.kernel.g.DQ();
        ((a)localObject).dnp = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abk(localak.field_username);
      }
      return localObject;
      i = paramInt - 1;
      continue;
      if (this.nCU == 1)
      {
        i = paramInt - 1;
      }
      else
      {
        y.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
        i = paramInt;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.d
 * JD-Core Version:    0.7.0.1
 */