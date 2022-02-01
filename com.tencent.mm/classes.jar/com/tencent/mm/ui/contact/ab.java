package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.h;
import java.util.List;

public final class ab
  extends q
  implements MStorageEx.IOnStorageChange
{
  private int CuC;
  private List<String> PYs;
  private int PYt;
  private boolean PYu;
  private int PYv;
  private Cursor jWh;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(102921);
    this.PYv = 0;
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.PYu = paramBoolean3;
    this.PYv = paramInt;
    and();
    ((l)g.af(l.class)).aST().add(this);
    AppMethodBeat.o(102921);
  }
  
  public final void and()
  {
    int j = 0;
    AppMethodBeat.i(102922);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    if (u.hasAttr(this.PYv, 4))
    {
      this.jWh = ((l)g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCK, this.gzY, com.tencent.mm.o.a.gNj, this.PWC, "");
      if (!this.PYu) {
        break label229;
      }
    }
    label229:
    for (int i = 2;; i = 0)
    {
      if (this.PYs != null) {
        j = this.PYs.size();
      }
      this.PYt = j;
      this.CuC = (i + this.PYt);
      clearCache();
      AppMethodBeat.o(102922);
      return;
      if (u.hasAttr(this.PYv, 16))
      {
        this.jWh = ((l)g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCM, this.gzY, com.tencent.mm.o.a.gNj, this.PWC, "");
        break;
      }
      this.jWh = ((l)g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCF, this.gzY, com.tencent.mm.o.a.gNj, this.PWC, "");
      break;
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102925);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    ((l)g.af(l.class)).aST().remove(this);
    AppMethodBeat.o(102925);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102923);
    int j = this.CuC + 1;
    int i = j;
    if (this.jWh != null) {
      i = j + this.jWh.getCount();
    }
    AppMethodBeat.o(102923);
    return i;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102926);
    and();
    notifyDataSetChanged();
    AppMethodBeat.o(102926);
  }
  
  protected final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    az localaz = null;
    AppMethodBeat.i(102924);
    Object localObject;
    if (this.CuC > this.PYt) {
      if (paramInt == this.PYt)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.PWg.getActivity().getResources().getString(2131765134);
      }
    }
    for (;;)
    {
      if (paramInt == this.CuC)
      {
        localObject = new h(paramInt);
        ((h)localObject).header = this.PWg.getActivity().getResources().getString(2131765119);
      }
      for (;;)
      {
        AppMethodBeat.o(102924);
        return localObject;
        if (paramInt != this.PYt + 1) {
          break label374;
        }
        localObject = new b(paramInt);
        String str = this.PWg.getActivity().getResources().getString(2131765134);
        ((b)localObject).resId = 2131690067;
        ((b)localObject).nickName = str;
        break;
        if (paramInt < this.PYt)
        {
          localObject = localaz;
          if (this.PYs != null)
          {
            localObject = localaz;
            if (paramInt >= 0)
            {
              localObject = localaz;
              if (paramInt < this.PYs.size())
              {
                localObject = new b(paramInt);
                ((b)localObject).username = ((String)this.PYs.get(paramInt));
              }
            }
          }
        }
        else if ((paramInt > this.CuC) && (this.jWh.moveToPosition(paramInt - this.CuC - 1)))
        {
          localObject = new f(paramInt);
          localaz = new az();
          localaz.convertFrom(this.jWh);
          g.aAi();
          ((com.tencent.mm.ui.contact.a.a)localObject).contact = ((l)g.af(l.class)).aSN().bjF(localaz.field_username);
          if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
          {
            g.aAi();
            ((com.tencent.mm.ui.contact.a.a)localObject).contact = ((l)g.af(l.class)).aSN().bjK(localaz.field_username);
          }
          ((com.tencent.mm.ui.contact.a.a)localObject).PWh = eWh();
        }
        else
        {
          Log.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label374:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */