package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.mm.h.c.as;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.b;
import com.tencent.mm.ui.contact.a.e;
import java.util.List;

public final class x
  extends o
  implements m.b
{
  private Cursor eYd;
  private int nCS;
  private List<String> vNe;
  private int vNf;
  private boolean vNg;
  private int vNh = 0;
  
  public x(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList)
  {
    this(paramMMBaseSelectContactUI, paramList, true, false, false, 0);
  }
  
  public x(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    y.i("MicroMsg.RecentConversationAdapter", "create!");
    this.vNg = paramBoolean3;
    this.vNh = paramInt;
    xO();
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(this);
  }
  
  private void xO()
  {
    int j = 0;
    y.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    if (s.fA(this.vNh, 4))
    {
      this.eYd = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(com.tencent.mm.model.s.dUY, this.dru, this.vLZ, "");
      if (!this.vNg) {
        break label210;
      }
    }
    label210:
    for (int i = 2;; i = 0)
    {
      if (this.vNe != null) {
        j = this.vNe.size();
      }
      this.vNf = j;
      this.nCS = (i + this.vNf);
      clearCache();
      return;
      if (s.fA(this.vNh, 16))
      {
        this.eYd = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(com.tencent.mm.model.s.dVa, this.dru, this.vLZ, "");
        break;
      }
      this.eYd = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(com.tencent.mm.model.s.dUT, this.dru, this.vLZ, "");
      break;
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
    int j = this.nCS + 1;
    int i = j;
    if (this.eYd != null) {
      i = j + this.eYd.getCount();
    }
    return i;
  }
  
  protected final a jQ(int paramInt)
  {
    ak localak = null;
    Object localObject;
    if (this.nCS > this.vNf) {
      if (paramInt == this.vNf)
      {
        localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
        ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      }
    }
    for (;;)
    {
      if (paramInt == this.nCS)
      {
        localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
        ((com.tencent.mm.ui.contact.a.g)localObject).kDu = this.vLI.getActivity().getResources().getString(a.h.select_contact_conversation_cur);
      }
      do
      {
        do
        {
          do
          {
            return localObject;
            if (paramInt != this.vNf + 1) {
              break label364;
            }
            localObject = new b(paramInt);
            String str = this.vLI.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
            ((b)localObject).kCB = a.g.default_servicebrand_contact;
            ((b)localObject).aVr = str;
            break;
            if (paramInt >= this.vNf) {
              break label214;
            }
            localObject = localak;
          } while (this.vNe == null);
          localObject = localak;
        } while (paramInt < 0);
        localObject = localak;
      } while (paramInt >= this.vNe.size());
      localObject = new b(paramInt);
      ((b)localObject).username = ((String)this.vNe.get(paramInt));
      return localObject;
      label214:
      if ((paramInt > this.nCS) && (this.eYd.moveToPosition(paramInt - this.nCS - 1)))
      {
        localObject = new e(paramInt);
        localak = new ak();
        localak.d(this.eYd);
        com.tencent.mm.kernel.g.DQ();
        ((a)localObject).dnp = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abf(localak.field_username);
        if (((a)localObject).dnp == null)
        {
          com.tencent.mm.kernel.g.DQ();
          ((a)localObject).dnp = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abk(localak.field_username);
        }
        ((a)localObject).vLJ = bBJ();
        return localObject;
      }
      y.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      return localObject;
      label364:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.x
 * JD-Core Version:    0.7.0.1
 */