package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class ab
  extends q
  implements n.b
{
  private List<String> KoX;
  private int KoY;
  private boolean KoZ;
  private int Kpa;
  private Cursor iVJ;
  private int ydU;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.Kpa = 0;
    ad.i("MicroMsg.RecentConversationAdapter", "create!");
    this.KoZ = paramBoolean3;
    this.Kpa = paramInt;
    Zh();
    ((l)g.ab(l.class)).azv().a(this);
    AppMethodBeat.o(102921);
  }
  
  public final void Zh()
  {
    int j = 0;
    AppMethodBeat.i(102922);
    ad.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    if (u.hasAttr(this.Kpa, 4))
    {
      this.iVJ = ((l)g.ab(l.class)).azv().a(w.hFi, this.fSL, this.Knh, "");
      if (!this.KoZ) {
        break label220;
      }
    }
    label220:
    for (int i = 2;; i = 0)
    {
      if (this.KoX != null) {
        j = this.KoX.size();
      }
      this.KoY = j;
      this.ydU = (i + this.KoY);
      clearCache();
      AppMethodBeat.o(102922);
      return;
      if (u.hasAttr(this.Kpa, 16))
      {
        this.iVJ = ((l)g.ab(l.class)).azv().a(w.hFk, this.fSL, this.Knh, "");
        break;
      }
      this.iVJ = ((l)g.ab(l.class)).azv().a(w.hFd, this.fSL, this.Knh, "");
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102926);
    Zh();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    ad.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    ((l)g.ab(l.class)).azv().b(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    int j = this.ydU + 1;
    int i = j;
    if (this.iVJ != null) {
      i = j + this.iVJ.getCount();
    }
    AppMethodBeat.o(102923);
    return i;
  }
  
  protected final a rh(int paramInt)
  {
    at localat = null;
    AppMethodBeat.i(102924);
    Object localObject;
    if (this.ydU > this.KoY) {
      if (paramInt == this.KoY)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.KmO.getActivity().getResources().getString(2131762997);
      }
    }
    for (;;)
    {
      if (paramInt == this.ydU)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.KmO.getActivity().getResources().getString(2131762982);
      }
      for (;;)
      {
        AppMethodBeat.o(102924);
        return localObject;
        if (paramInt != this.KoY + 1) {
          break label373;
        }
        localObject = new b(paramInt);
        String str = this.KmO.getActivity().getResources().getString(2131762997);
        ((b)localObject).resId = 2131690037;
        ((b)localObject).bVF = str;
        break;
        if (paramInt < this.KoY)
        {
          localObject = localat;
          if (this.KoX != null)
          {
            localObject = localat;
            if (paramInt >= 0)
            {
              localObject = localat;
              if (paramInt < this.KoX.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.KoX.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.ydU) && (this.iVJ.moveToPosition(paramInt - this.ydU - 1)))
        {
          localObject = new f(paramInt);
          localat = new at();
          localat.convertFrom(this.iVJ);
          g.ajD();
          ((a)localObject).contact = ((l)g.ab(l.class)).azp().aTf(localat.field_username);
          if (((a)localObject).contact == null)
          {
            g.ajD();
            ((a)localObject).contact = ((l)g.ab(l.class)).azp().aTk(localat.field_username);
          }
          ((a)localObject).KmP = dQK();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */