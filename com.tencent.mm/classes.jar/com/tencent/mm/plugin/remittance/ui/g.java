package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends p
  implements n.b
{
  private int fromScene;
  private Cursor gqa;
  int qoW;
  int qoX;
  private List<String> qoY;
  private int qoZ;
  
  public g(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList2, true, false);
    AppMethodBeat.i(44986);
    this.qoZ = 0;
    this.qoY = paramList1;
    this.fromScene = paramInt;
    ab.i("MicroMsg.RecentConversationAdapter", "create!");
    Kg();
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(this);
    AppMethodBeat.o(44986);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(44987);
    ab.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    this.qoZ = 0;
    ArrayList localArrayList = new ArrayList();
    this.qoW = -1;
    this.qoX = -1;
    Object localObject;
    int i;
    if ((this.qoY != null) && (this.qoY.size() > 0))
    {
      com.tencent.mm.kernel.g.RM();
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eF(this.qoY);
      localArrayList.add(localObject);
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        this.qoW = this.Adk.getContentLV().getHeaderViewsCount();
        this.qoZ += 1;
      }
    }
    for (;;)
    {
      localObject = this.ejc;
      if (localObject != null)
      {
        ((List)localObject).addAll(this.qoY);
        label167:
        if (this.fromScene != 1) {
          break label293;
        }
        localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(t.flc, (List)localObject, this.AdB, "");
        label204:
        if (((Cursor)localObject).getCount() <= 0) {
          break label344;
        }
        this.qoZ += 1;
        if (i <= 0) {
          break label325;
        }
        this.qoX = (i + this.qoW + 1);
      }
      for (;;)
      {
        localArrayList.add(localObject);
        this.gqa = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        AppMethodBeat.o(44987);
        return;
        this.qoW = -1;
        break;
        localObject = this.qoY;
        break label167;
        label293:
        localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YF().a(t.flh, (List)localObject, this.AdB, "");
        break label204;
        label325:
        this.qoX = this.Adk.getContentLV().getHeaderViewsCount();
        continue;
        label344:
        this.qoX = -1;
      }
      i = 0;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(44991);
    Kg();
    notifyDataSetChanged();
    AppMethodBeat.o(44991);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(44990);
    super.finish();
    ab.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    ((j)com.tencent.mm.kernel.g.E(j.class)).YF().b(this);
    AppMethodBeat.o(44990);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44989);
    int i = this.gqa.getCount();
    int j = this.qoZ;
    AppMethodBeat.o(44989);
    return i + j;
  }
  
  public final a mM(int paramInt)
  {
    AppMethodBeat.i(44988);
    Object localObject2;
    Object localObject1;
    if ((paramInt == this.qoX) || (paramInt == this.qoW))
    {
      localObject2 = new h(paramInt);
      if (paramInt == this.qoW) {
        if (this.fromScene == 1)
        {
          ((h)localObject2).mZq = this.Adk.getActivity().getResources().getString(2131296377);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(44988);
      return localObject1;
      ((h)localObject2).mZq = this.Adk.getActivity().getResources().getString(2131302609);
      localObject1 = localObject2;
      continue;
      localObject1 = localObject2;
      if (paramInt == this.qoX)
      {
        ((h)localObject2).mZq = this.Adk.getActivity().getResources().getString(2131305636);
        localObject1 = localObject2;
        continue;
        int i;
        if (this.qoZ == 2) {
          if (paramInt > this.qoX) {
            i = paramInt - 2;
          }
        }
        for (;;)
        {
          if (!this.gqa.moveToPosition(i)) {
            break label323;
          }
          localObject1 = new f(paramInt);
          localObject2 = new ak();
          ((ak)localObject2).convertFrom(this.gqa);
          com.tencent.mm.kernel.g.RM();
          ((a)localObject1).contact = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arq(((au)localObject2).field_username);
          if (((a)localObject1).contact == null)
          {
            com.tencent.mm.kernel.g.RM();
            ((a)localObject1).contact = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arv(((au)localObject2).field_username);
          }
          break;
          i = paramInt - 1;
          continue;
          if (this.qoZ == 1)
          {
            i = paramInt - 1;
          }
          else
          {
            ab.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
            i = paramInt;
          }
        }
        label323:
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.g
 * JD-Core Version:    0.7.0.1
 */