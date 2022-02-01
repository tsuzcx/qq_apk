package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class ab
  extends q
  implements n.b
{
  private List<String> GXZ;
  private int GYa;
  private boolean GYb;
  private int GYc;
  private Cursor icq;
  private int vGh;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.GYc = 0;
    ad.i("MicroMsg.RecentConversationAdapter", "create!");
    this.GYb = paramBoolean3;
    this.GYc = paramInt;
    VP();
    ((k)g.ab(k.class)).apR().a(this);
    AppMethodBeat.o(102921);
  }
  
  public final void VP()
  {
    int j = 0;
    AppMethodBeat.i(102922);
    ad.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    if (u.hasAttr(this.GYc, 4))
    {
      this.icq = ((k)g.ab(k.class)).apR().a(w.gMs, this.fvP, this.GWl, "");
      if (!this.GYb) {
        break label220;
      }
    }
    label220:
    for (int i = 2;; i = 0)
    {
      if (this.GXZ != null) {
        j = this.GXZ.size();
      }
      this.GYa = j;
      this.vGh = (i + this.GYa);
      clearCache();
      AppMethodBeat.o(102922);
      return;
      if (u.hasAttr(this.GYc, 16))
      {
        this.icq = ((k)g.ab(k.class)).apR().a(w.gMu, this.fvP, this.GWl, "");
        break;
      }
      this.icq = ((k)g.ab(k.class)).apR().a(w.gMn, this.fvP, this.GWl, "");
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102926);
    VP();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    ad.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    ((k)g.ab(k.class)).apR().b(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    int j = this.vGh + 1;
    int i = j;
    if (this.icq != null) {
      i = j + this.icq.getCount();
    }
    AppMethodBeat.o(102923);
    return i;
  }
  
  protected final a pU(int paramInt)
  {
    am localam = null;
    AppMethodBeat.i(102924);
    Object localObject;
    if (this.vGh > this.GYa) {
      if (paramInt == this.GYa)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.GVS.getActivity().getResources().getString(2131762997);
      }
    }
    for (;;)
    {
      if (paramInt == this.vGh)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.GVS.getActivity().getResources().getString(2131762982);
      }
      for (;;)
      {
        AppMethodBeat.o(102924);
        return localObject;
        if (paramInt != this.GYa + 1) {
          break label373;
        }
        localObject = new b(paramInt);
        String str = this.GVS.getActivity().getResources().getString(2131762997);
        ((b)localObject).resId = 2131690037;
        ((b)localObject).bNK = str;
        break;
        if (paramInt < this.GYa)
        {
          localObject = localam;
          if (this.GXZ != null)
          {
            localObject = localam;
            if (paramInt >= 0)
            {
              localObject = localam;
              if (paramInt < this.GXZ.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.GXZ.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.vGh) && (this.icq.moveToPosition(paramInt - this.vGh - 1)))
        {
          localObject = new f(paramInt);
          localam = new am();
          localam.convertFrom(this.icq);
          g.afC();
          ((a)localObject).contact = ((k)g.ab(k.class)).apM().aHS(localam.field_username);
          if (((a)localObject).contact == null)
          {
            g.afC();
            ((a)localObject).contact = ((k)g.ab(k.class)).apM().aHX(localam.field_username);
          }
          ((a)localObject).GVT = dqZ();
        }
        else
        {
          ad.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label373:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */