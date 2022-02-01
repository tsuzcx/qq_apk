package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class ab
  extends q
  implements n.b
{
  private List<String> KLr;
  private int KLs;
  private boolean KLt;
  private int KLu;
  private Cursor iYC;
  private int ytL;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.KLu = 0;
    ae.i("MicroMsg.RecentConversationAdapter", "create!");
    this.KLt = paramBoolean3;
    this.KLu = paramInt;
    Zq();
    ((l)g.ab(l.class)).azL().a(this);
    AppMethodBeat.o(102921);
  }
  
  public final void Zq()
  {
    int j = 0;
    AppMethodBeat.i(102922);
    ae.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    if (u.hasAttr(this.KLu, 4))
    {
      this.iYC = ((l)g.ab(l.class)).azL().a(x.hIa, this.fUR, this.KJB, "");
      if (!this.KLt) {
        break label220;
      }
    }
    label220:
    for (int i = 2;; i = 0)
    {
      if (this.KLr != null) {
        j = this.KLr.size();
      }
      this.KLs = j;
      this.ytL = (i + this.KLs);
      clearCache();
      AppMethodBeat.o(102922);
      return;
      if (u.hasAttr(this.KLu, 16))
      {
        this.iYC = ((l)g.ab(l.class)).azL().a(x.hIc, this.fUR, this.KJB, "");
        break;
      }
      this.iYC = ((l)g.ab(l.class)).azL().a(x.hHV, this.fUR, this.KJB, "");
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102926);
    Zq();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    ae.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    ((l)g.ab(l.class)).azL().b(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    int j = this.ytL + 1;
    int i = j;
    if (this.iYC != null) {
      i = j + this.iYC.getCount();
    }
    AppMethodBeat.o(102923);
    return i;
  }
  
  protected final a rk(int paramInt)
  {
    au localau = null;
    AppMethodBeat.i(102924);
    Object localObject;
    if (this.ytL > this.KLs) {
      if (paramInt == this.KLs)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.KJi.getActivity().getResources().getString(2131762997);
      }
    }
    for (;;)
    {
      if (paramInt == this.ytL)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.KJi.getActivity().getResources().getString(2131762982);
      }
      for (;;)
      {
        AppMethodBeat.o(102924);
        return localObject;
        if (paramInt != this.KLs + 1) {
          break label373;
        }
        localObject = new b(paramInt);
        String str = this.KJi.getActivity().getResources().getString(2131762997);
        ((b)localObject).resId = 2131690037;
        ((b)localObject).bVF = str;
        break;
        if (paramInt < this.KLs)
        {
          localObject = localau;
          if (this.KLr != null)
          {
            localObject = localau;
            if (paramInt >= 0)
            {
              localObject = localau;
              if (paramInt < this.KLr.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.KLr.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.ytL) && (this.iYC.moveToPosition(paramInt - this.ytL - 1)))
        {
          localObject = new f(paramInt);
          localau = new au();
          localau.convertFrom(this.iYC);
          g.ajS();
          ((a)localObject).contact = ((l)g.ab(l.class)).azF().aUG(localau.field_username);
          if (((a)localObject).contact == null)
          {
            g.ajS();
            ((a)localObject).contact = ((l)g.ab(l.class)).azF().aUL(localau.field_username);
          }
          ((a)localObject).KJj = dUh();
        }
        else
        {
          ae.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label373:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */