package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.contact.a.k.a;
import com.tencent.mm.ui.contact.a.k.c;
import com.tencent.mm.ui.contact.a.o.b;
import com.tencent.mm.ui.contact.a.o.c;
import com.tencent.mm.ui.contact.a.o.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;

public final class z
  extends r
  implements MStorageEx.IOnStorageChange, af
{
  private int OpX;
  private int OpZ;
  private int abrd;
  private Cursor afgg;
  private Cursor afgh;
  private List<String> afgi;
  private int afgj;
  private int afgk;
  private boolean afgl;
  private int afgm;
  public boolean afgn;
  private Map<String, Integer> afgo;
  private Map<String, Integer> afgp;
  private int afgq;
  private String afgr;
  private int afgs;
  private int afgt;
  public b afgu;
  public a afgv;
  public com.tencent.mm.ui.contact.a.o afgw;
  private List<String> afgx;
  private k afgy;
  public boolean afgz;
  private Cursor pKb;
  
  public z(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(252846);
    this.afgj = -1;
    this.OpX = -1;
    this.afgm = 0;
    this.OpZ = 1;
    this.afgn = false;
    this.afgo = new HashMap();
    this.afgp = new HashMap();
    this.afgq = 0;
    this.abrd = 0;
    this.afgr = "";
    this.afgs = 0;
    this.afgt = 0;
    this.afgx = new ArrayList();
    this.afgz = false;
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.afgl = paramBoolean3;
    this.afgm = paramInt;
    aNm();
    AppMethodBeat.o(252846);
  }
  
  private void jzb()
  {
    AppMethodBeat.i(252850);
    if (this.afgg != null)
    {
      this.afgg.close();
      this.afgg = null;
    }
    if (this.afgh != null)
    {
      this.afgh.close();
      this.afgh = null;
    }
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(252850);
  }
  
  public final void Mz(boolean paramBoolean)
  {
    AppMethodBeat.i(252893);
    super.Mz(paramBoolean);
    AppMethodBeat.o(252893);
  }
  
  public final void aNm()
  {
    int j = 0;
    AppMethodBeat.i(252860);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    jzb();
    new ArrayList();
    this.afgt = 0;
    List localList;
    if (w.hasAttr(this.afgm, 4))
    {
      if (!h.jyv()) {
        break label513;
      }
      localList = h.jys();
      if (!Util.isNullOrNil(localList)) {
        this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 3, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
      }
      Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
    }
    for (;;)
    {
      this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(3, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
      int i;
      if (this.afgl)
      {
        i = 2;
        label148:
        if (this.afgi != null) {
          j = this.afgi.size();
        }
        this.afgk = j;
        if ((!Util.isNullOrNil(localList)) && (this.afgh != null)) {
          this.afgt = this.afgh.getCount();
        }
        this.afgs = this.afgg.getCount();
        if (this.afgs > 0) {
          if (this.afgt == 0)
          {
            this.OpX = (i + this.afgk);
            label234:
            this.pKb = this.afgg;
            clearCache();
            AppMethodBeat.o(252860);
            return;
            if (w.hasAttr(this.afgm, 16))
            {
              if (!h.jyv()) {
                break label508;
              }
              localList = h.jyr();
              if (!Util.isNullOrNil(localList)) {
                this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
              }
              Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
            }
          }
        }
      }
      for (;;)
      {
        this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
        break;
        if (h.jyv())
        {
          localList = h.jyt();
          if (!Util.isNullOrNil(localList)) {
            this.afgh = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(localList, 1, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
          }
          Log.i("MicroMsg.RecentConversationAdapter", "resetData: recent forward control switch on");
        }
        for (;;)
        {
          this.afgg = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(1, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
          break;
          this.OpX = (i + this.afgk + 1);
          break label234;
          this.OpX = this.afex.getContentLV().getHeaderViewsCount();
          break label234;
          i = 0;
          break label148;
          localList = null;
        }
        label508:
        localList = null;
      }
      label513:
      localList = null;
    }
  }
  
  public final int bBQ(String paramString)
  {
    AppMethodBeat.i(252899);
    if (!bBT(paramString))
    {
      AppMethodBeat.o(252899);
      return 0;
    }
    int i = ((Integer)this.afgp.get(paramString)).intValue();
    AppMethodBeat.o(252899);
    return i;
  }
  
  public final int bBR(String paramString)
  {
    AppMethodBeat.i(252905);
    if (!bBS(paramString))
    {
      AppMethodBeat.o(252905);
      return 0;
    }
    int i = ((Integer)this.afgo.get(paramString)).intValue();
    AppMethodBeat.o(252905);
    return i;
  }
  
  public final boolean bBS(String paramString)
  {
    AppMethodBeat.i(252909);
    if ((Util.isNullOrNil(paramString)) || (this.afgo == null) || (this.afgo.isEmpty()))
    {
      AppMethodBeat.o(252909);
      return false;
    }
    boolean bool = this.afgo.containsKey(paramString);
    AppMethodBeat.o(252909);
    return bool;
  }
  
  public final boolean bBT(String paramString)
  {
    AppMethodBeat.i(252913);
    if ((Util.isNullOrNil(paramString)) || (this.afgp == null) || (this.afgp.isEmpty()))
    {
      AppMethodBeat.o(252913);
      return false;
    }
    boolean bool = this.afgp.containsKey(paramString);
    AppMethodBeat.o(252913);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252884);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    jzb();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().remove(this);
    AppMethodBeat.o(252884);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(252868);
    if (this.pKb == null)
    {
      Log.e("MicroMsg.RecentConversationAdapter", "getCount: dataCursor == null ");
      AppMethodBeat.o(252868);
      return 0;
    }
    if (this.afgt != 0)
    {
      i = this.afgs;
      AppMethodBeat.o(252868);
      return i + 1 + 1;
    }
    int i = this.afgs;
    AppMethodBeat.o(252868);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(252864);
    if ((this.afgt != 0) && (paramInt < this.OpX))
    {
      Log.i("MicroMsg.RecentConversationAdapter", "getItemViewType:  return HORIZONTAL_RECENT_FORWARD_LIST Type");
      AppMethodBeat.o(252864);
      return 9;
    }
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(252864);
    return paramInt;
  }
  
  public final int jzc()
  {
    return this.afgq;
  }
  
  public final int jzd()
  {
    return this.afgt;
  }
  
  public final String jze()
  {
    return this.afgr;
  }
  
  public final int jzf()
  {
    return this.abrd;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(252889);
    aNm();
    notifyDataSetChanged();
    AppMethodBeat.o(252889);
  }
  
  protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(252880);
    Object localObject2;
    Object localObject3;
    label120:
    Object localObject1;
    Object localObject4;
    if (this.OpX > this.afgk)
    {
      if ((this.afgk != 0) && (paramInt == this.afgk)) {
        new j(paramInt).header = this.afex.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      }
    }
    else
    {
      if ((this.afgt == 0) || (paramInt != 0)) {
        break label468;
      }
      this.afgw = new com.tencent.mm.ui.contact.a.o(paramInt);
      localObject2 = this.afgw;
      localObject3 = new ArrayList();
      if ((this.afgh == null) || (this.afgh.getCount() <= 0)) {
        break label465;
      }
      paramInt = 1;
      if (!this.afgh.moveToNext()) {
        break label342;
      }
      localObject1 = this.afgh;
      localObject4 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq((String)localObject4);
      if (localObject1 != null) {
        break label1016;
      }
      Log.i("MicroMsg.RecentConversationAdapter", "parse: contact == null");
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv((String)localObject4);
    }
    label342:
    label1016:
    for (;;)
    {
      localObject1 = new ah(new ai((String)localObject4, ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).b((au)localObject1), '\000'));
      ((ArrayList)localObject3).add(localObject1);
      this.afgp.put(((ah)localObject1).afhj.afhk, Integer.valueOf(paramInt));
      paramInt += 1;
      break label120;
      if ((this.afgk == 0) || (paramInt != this.afgk + 1)) {
        break;
      }
      localObject1 = new com.tencent.mm.ui.contact.a.b(paramInt);
      localObject2 = this.afex.getActivity().getResources().getString(a.h.select_contact_official_accounts_title);
      ((com.tencent.mm.ui.contact.a.b)localObject1).eg(a.g.default_servicebrand_contact, (String)localObject2);
      break;
      for (;;)
      {
        ((com.tencent.mm.ui.contact.a.o)localObject2).pUj = ((ArrayList)localObject3);
        this.afgw.afey = gZe();
        localObject1 = this.afgw;
        localObject2 = new o.b()
        {
          public final void bBU(String paramAnonymousString)
          {
            AppMethodBeat.i(252932);
            z.b(z.this).bBU(paramAnonymousString);
            AppMethodBeat.o(252932);
          }
        };
        s.u(localObject2, "listener");
        ((com.tencent.mm.ui.contact.a.o)localObject1).afkD = ((o.b)localObject2);
        localObject1 = this.afgw;
        localObject2 = new o.d()
        {
          public final void bBV(String paramAnonymousString)
          {
            AppMethodBeat.i(252929);
            z.c(z.this);
            if (z.d(z.this).isEmpty())
            {
              z.a(z.this, paramAnonymousString);
              AppMethodBeat.o(252929);
              return;
            }
            z.a(z.this, z.d(z.this) + "｜" + paramAnonymousString);
            AppMethodBeat.o(252929);
          }
        };
        s.u(localObject2, "removeListener");
        ((com.tencent.mm.ui.contact.a.o)localObject1).afkE = ((o.d)localObject2);
        localObject1 = this.afgw;
        localObject2 = new o.c()
        {
          public final void jzg()
          {
            AppMethodBeat.i(252962);
            z.this.aNm();
            z.this.notifyDataSetChanged();
            AppMethodBeat.o(252962);
          }
        };
        s.u(localObject2, "loadDataListListener");
        ((com.tencent.mm.ui.contact.a.o)localObject1).afkF = ((o.c)localObject2);
        this.afgn = true;
        localObject1 = this.afgw;
        AppMethodBeat.o(252880);
        return localObject1;
      }
      if (paramInt == this.OpX)
      {
        localObject1 = new k(paramInt);
        localObject2 = new k.c()
        {
          public final void onClick()
          {
            AppMethodBeat.i(252935);
            if (z.a(z.this) != null) {
              z.a(z.this).onClick();
            }
            AppMethodBeat.o(252935);
          }
        };
        s.u(localObject2, "listener");
        ((k)localObject1).afkp = ((k.c)localObject2);
        this.afgy = ((k)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(252880);
        return localObject1;
        if (paramInt < this.afgk)
        {
          if ((this.afgi == null) || (paramInt < 0) || (paramInt >= this.afgi.size()))
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = new com.tencent.mm.ui.contact.a.b(paramInt);
            ((com.tencent.mm.ui.contact.a.b)localObject1).username = ((String)this.afgi.get(paramInt));
          }
        }
        else
        {
          int i;
          if (this.OpZ == 1) {
            if (this.afgt != 0) {
              i = paramInt - 2;
            }
          }
          for (;;)
          {
            if (!this.pKb.moveToPosition(i)) {
              break label970;
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
            ((com.tencent.mm.ui.contact.a.a)localObject1).afey = gZe();
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxV(((bd)localObject2).field_username))
            {
              ((com.tencent.mm.ui.contact.a.a)localObject1).afjD = true;
              if ((paramInt == this.OpX + 1) && (this.afgy != null))
              {
                this.afgz = true;
                localObject3 = this.afgy;
                i = a.d.header_view_top_place_color_background;
                localObject2 = ((k)localObject3).mContext;
                if (localObject2 != null)
                {
                  localObject3 = ((k)localObject3).jzu();
                  localObject4 = ((k.a)localObject3).afkr;
                  if (localObject4 != null) {
                    ((RelativeLayout)localObject4).setBackground(((Context)localObject2).getResources().getDrawable(i));
                  }
                  localObject3 = ((k.a)localObject3).Rry;
                  if (localObject3 != null) {
                    ((LinearLayout)localObject3).setBackground(((Context)localObject2).getResources().getDrawable(i));
                  }
                }
              }
            }
            if (paramInt == this.OpX - 1) {
              ((com.tencent.mm.ui.contact.a.a)localObject1).afjC = true;
            }
            localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxV((String)localObject2)) {
              this.afgq += 1;
            }
            this.afgo.put(localObject2, Integer.valueOf(paramInt - this.OpX));
            break;
            i = paramInt - 1;
            continue;
            Log.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[] { Integer.valueOf(paramInt) });
            i = paramInt;
          }
          localObject1 = new i(paramInt);
          Log.e("MicroMsg.RecentConversationAdapter", "wrong case: %s, %s", new Object[] { Boolean.valueOf(this.pKb.isClosed()), Integer.valueOf(i) });
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void bBU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */