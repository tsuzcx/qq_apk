package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class ab
  extends q
  implements n.b
{
  private List<String> Iyp;
  private int Iyq;
  private boolean Iyr;
  private int Iys;
  private Cursor iCz;
  private int wQm;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.Iys = 0;
    ac.i("MicroMsg.RecentConversationAdapter", "create!");
    this.Iyr = paramBoolean3;
    this.Iys = paramInt;
    WN();
    ((k)g.ab(k.class)).awG().a(this);
    AppMethodBeat.o(102921);
  }
  
  public final void WN()
  {
    int j = 0;
    AppMethodBeat.i(102922);
    ac.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    if (u.hasAttr(this.Iys, 4))
    {
      this.iCz = ((k)g.ab(k.class)).awG().a(w.hmS, this.fzw, this.Iwz, "");
      if (!this.Iyr) {
        break label220;
      }
    }
    label220:
    for (int i = 2;; i = 0)
    {
      if (this.Iyp != null) {
        j = this.Iyp.size();
      }
      this.Iyq = j;
      this.wQm = (i + this.Iyq);
      clearCache();
      AppMethodBeat.o(102922);
      return;
      if (u.hasAttr(this.Iys, 16))
      {
        this.iCz = ((k)g.ab(k.class)).awG().a(w.hmU, this.fzw, this.Iwz, "");
        break;
      }
      this.iCz = ((k)g.ab(k.class)).awG().a(w.hmN, this.fzw, this.Iwz, "");
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102926);
    WN();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    ac.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    ((k)g.ab(k.class)).awG().b(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    int j = this.wQm + 1;
    int i = j;
    if (this.iCz != null) {
      i = j + this.iCz.getCount();
    }
    AppMethodBeat.o(102923);
    return i;
  }
  
  protected final a qH(int paramInt)
  {
    ap localap = null;
    AppMethodBeat.i(102924);
    Object localObject;
    if (this.wQm > this.Iyq) {
      if (paramInt == this.Iyq)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.Iwg.getActivity().getResources().getString(2131762997);
      }
    }
    for (;;)
    {
      if (paramInt == this.wQm)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.Iwg.getActivity().getResources().getString(2131762982);
      }
      for (;;)
      {
        AppMethodBeat.o(102924);
        return localObject;
        if (paramInt != this.Iyq + 1) {
          break label373;
        }
        localObject = new b(paramInt);
        String str = this.Iwg.getActivity().getResources().getString(2131762997);
        ((b)localObject).resId = 2131690037;
        ((b)localObject).bLs = str;
        break;
        if (paramInt < this.Iyq)
        {
          localObject = localap;
          if (this.Iyp != null)
          {
            localObject = localap;
            if (paramInt >= 0)
            {
              localObject = localap;
              if (paramInt < this.Iyp.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.Iyp.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.wQm) && (this.iCz.moveToPosition(paramInt - this.wQm - 1)))
        {
          localObject = new f(paramInt);
          localap = new ap();
          localap.convertFrom(this.iCz);
          g.agS();
          ((a)localObject).contact = ((k)g.ab(k.class)).awB().aNn(localap.field_username);
          if (((a)localObject).contact == null)
          {
            g.agS();
            ((a)localObject).contact = ((k)g.ab(k.class)).awB().aNs(localap.field_username);
          }
          ((a)localObject).Iwh = dFi();
        }
        else
        {
          ac.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
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