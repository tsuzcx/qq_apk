package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class y
  extends p
  implements n.b
{
  private List<String> AeH;
  private int AeI;
  private boolean AeJ;
  private int AeK;
  private Cursor gqa;
  private int qoX;
  
  public y(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public y(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(105257);
    this.AeK = 0;
    ab.i("MicroMsg.RecentConversationAdapter", "create!");
    this.AeJ = paramBoolean3;
    this.AeK = paramInt;
    Kg();
    ((j)g.E(j.class)).YF().a(this);
    AppMethodBeat.o(105257);
  }
  
  private void Kg()
  {
    int j = 0;
    AppMethodBeat.i(105258);
    ab.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    if (t.hI(this.AeK, 4))
    {
      this.gqa = ((j)g.E(j.class)).YF().a(com.tencent.mm.model.t.flh, this.ejc, this.AdB, "");
      if (!this.AeJ) {
        break label220;
      }
    }
    label220:
    for (int i = 2;; i = 0)
    {
      if (this.AeH != null) {
        j = this.AeH.size();
      }
      this.AeI = j;
      this.qoX = (i + this.AeI);
      clearCache();
      AppMethodBeat.o(105258);
      return;
      if (t.hI(this.AeK, 16))
      {
        this.gqa = ((j)g.E(j.class)).YF().a(com.tencent.mm.model.t.flj, this.ejc, this.AdB, "");
        break;
      }
      this.gqa = ((j)g.E(j.class)).YF().a(com.tencent.mm.model.t.flc, this.ejc, this.AdB, "");
      break;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(105262);
    Kg();
    notifyDataSetChanged();
    AppMethodBeat.o(105262);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105261);
    super.finish();
    ab.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    ((j)g.E(j.class)).YF().b(this);
    AppMethodBeat.o(105261);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105259);
    int j = this.qoX + 1;
    int i = j;
    if (this.gqa != null) {
      i = j + this.gqa.getCount();
    }
    AppMethodBeat.o(105259);
    return i;
  }
  
  protected final a mM(int paramInt)
  {
    ak localak = null;
    AppMethodBeat.i(105260);
    Object localObject;
    if (this.qoX > this.AeI) {
      if (paramInt == this.AeI)
      {
        localObject = new h(paramInt);
        ((h)localObject).mZq = this.Adk.getActivity().getResources().getString(2131303053);
      }
    }
    for (;;)
    {
      if (paramInt == this.qoX)
      {
        localObject = new h(paramInt);
        ((h)localObject).mZq = this.Adk.getActivity().getResources().getString(2131303038);
      }
      for (;;)
      {
        AppMethodBeat.o(105260);
        return localObject;
        if (paramInt != this.AeI + 1) {
          break label373;
        }
        localObject = new b(paramInt);
        String str = this.Adk.getActivity().getResources().getString(2131303053);
        ((b)localObject).resId = 2131231231;
        ((b)localObject).blZ = str;
        break;
        if (paramInt < this.AeI)
        {
          localObject = localak;
          if (this.AeH != null)
          {
            localObject = localak;
            if (paramInt >= 0)
            {
              localObject = localak;
              if (paramInt < this.AeH.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.AeH.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.qoX) && (this.gqa.moveToPosition(paramInt - this.qoX - 1)))
        {
          localObject = new f(paramInt);
          localak = new ak();
          localak.convertFrom(this.gqa);
          g.RM();
          ((a)localObject).contact = ((j)g.E(j.class)).YA().arq(localak.field_username);
          if (((a)localObject).contact == null)
          {
            g.RM();
            ((a)localObject).contact = ((j)g.E(j.class)).YA().arv(localak.field_username);
          }
          ((a)localObject).Adl = cni();
        }
        else
        {
          ab.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label373:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.y
 * JD-Core Version:    0.7.0.1
 */