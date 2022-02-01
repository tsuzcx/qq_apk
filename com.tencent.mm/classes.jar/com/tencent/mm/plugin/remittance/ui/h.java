package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends r
  implements MStorageEx.IOnStorageChange
{
  int OpW;
  int OpX;
  private List<String> OpY;
  private int OpZ;
  private int fromScene;
  private Cursor pKb;
  
  public h(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList2, true, false);
    AppMethodBeat.i(68115);
    this.OpZ = 0;
    this.OpY = paramList1;
    this.fromScene = paramInt;
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    aNm();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().add(this);
    AppMethodBeat.o(68115);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(68116);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    this.OpZ = 0;
    ArrayList localArrayList = new ArrayList();
    this.OpW = -1;
    this.OpX = -1;
    Object localObject;
    int i;
    if ((this.OpY != null) && (this.OpY.size() > 0))
    {
      com.tencent.mm.kernel.h.baF();
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().mR(this.OpY);
      localArrayList.add(localObject);
      i = ((Cursor)localObject).getCount();
      if (i > 0)
      {
        this.OpW = this.afex.getContentLV().getHeaderViewsCount();
        this.OpZ += 1;
      }
    }
    for (;;)
    {
      localObject = cVa();
      if (localObject != null)
      {
        ((List)localObject).addAll(this.OpY);
        label167:
        if ((this.fromScene != 1) && (this.fromScene != 3)) {
          break label302;
        }
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(1, (List)localObject, com.tencent.mm.l.a.maX, jyS(), "");
        label213:
        if (((Cursor)localObject).getCount() <= 0) {
          break label354;
        }
        this.OpZ += 1;
        if (i <= 0) {
          break label335;
        }
        this.OpX = (this.OpW + i + 1);
      }
      for (;;)
      {
        localArrayList.add(localObject);
        this.pKb = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
        AppMethodBeat.o(68116);
        return;
        this.OpW = -1;
        break;
        localObject = this.OpY;
        break label167;
        label302:
        localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(3, (List)localObject, com.tencent.mm.l.a.maX, jyS(), "");
        break label213;
        label335:
        this.OpX = this.afex.getContentLV().getHeaderViewsCount();
        continue;
        label354:
        this.OpX = -1;
      }
      i = 0;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(68119);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().remove(this);
    AppMethodBeat.o(68119);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68118);
    int i = this.pKb.getCount();
    int j = this.OpZ;
    AppMethodBeat.o(68118);
    return i + j;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(68120);
    aNm();
    notifyDataSetChanged();
    AppMethodBeat.o(68120);
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(68117);
    Object localObject2;
    Object localObject1;
    if ((paramInt == this.OpX) || (paramInt == this.OpW))
    {
      localObject2 = new j(paramInt);
      if (paramInt == this.OpW) {
        if (this.fromScene == 1)
        {
          ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.i.aa_recent_group);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68117);
      return localObject1;
      if (this.fromScene == 3)
      {
        ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.i.launch_aa_about_conversation);
        localObject1 = localObject2;
      }
      else
      {
        ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.i.remittance_recent_friends);
        localObject1 = localObject2;
        continue;
        localObject1 = localObject2;
        if (paramInt == this.OpX)
        {
          ((j)localObject2).header = this.afex.getActivity().getResources().getString(a.i.wallet_select_conversation_cur);
          localObject1 = localObject2;
          continue;
          int i;
          if (this.OpZ == 2) {
            if (paramInt > this.OpX) {
              i = paramInt - 2;
            }
          }
          for (;;)
          {
            if (!this.pKb.moveToPosition(i)) {
              break label364;
            }
            localObject1 = new g(paramInt);
            localObject2 = new bb();
            ((bb)localObject2).convertFrom(this.pKb);
            com.tencent.mm.kernel.h.baF();
            ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq(((bd)localObject2).field_username);
            if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
            {
              com.tencent.mm.kernel.h.baF();
              ((com.tencent.mm.ui.contact.a.a)localObject1).contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(((bd)localObject2).field_username);
            }
            break;
            i = paramInt - 1;
            continue;
            if (this.OpZ == 1)
            {
              i = paramInt - 1;
            }
            else
            {
              Log.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
              i = paramInt;
            }
          }
          label364:
          Log.e("MicroMsg.RecentConversationAdapter", "wrong case: %s, %s", new Object[] { Boolean.valueOf(this.pKb.isClosed()), Integer.valueOf(i) });
          localObject1 = new h.a(this, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.h
 * JD-Core Version:    0.7.0.1
 */