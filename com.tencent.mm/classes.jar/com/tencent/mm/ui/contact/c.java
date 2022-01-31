package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  extends o
  implements m.b
{
  private Cursor eYd;
  private int nCS = 2147483647;
  private c.a vJA;
  private int vJB = 2147483647;
  private int vJC = 2147483647;
  private int vJD = 2147483647;
  private int vJE = 2147483647;
  private int vJF = 2147483647;
  private int vJG = 2147483647;
  private HashMap<String, Integer> vJH = null;
  private SparseArray<String> vJI = null;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, c.a parama)
  {
    this(paramMMBaseSelectContactUI, paramList, true, paramBoolean, parama, false);
  }
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, c.a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    y.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.vJA = parama;; this.vJA = new c.a())
    {
      com.tencent.mm.kernel.g.DQ();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this);
      xO();
      return;
    }
  }
  
  private void bf(int paramInt, String paramString)
  {
    this.vJH.put(paramString, Integer.valueOf(paramInt));
    this.vJI.put(paramInt, paramString);
  }
  
  private static a bg(int paramInt, String paramString)
  {
    com.tencent.mm.ui.contact.a.g localg = new com.tencent.mm.ui.contact.a.g(paramInt);
    localg.kDu = paramString;
    return localg;
  }
  
  private void xO()
  {
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    this.vJB = 2147483647;
    this.nCS = 2147483647;
    this.vJC = 2147483647;
    this.vJD = 2147483647;
    this.vJE = 2147483647;
    this.vJG = 2147483647;
    label85:
    ArrayList localArrayList;
    Object localObject2;
    label205:
    Object localObject1;
    label256:
    int j;
    if (this.vJH != null)
    {
      this.vJH.clear();
      if (this.vJI == null) {
        break label436;
      }
      this.vJI.clear();
      localArrayList = new ArrayList();
      if (!this.vJA.vJN) {
        break label571;
      }
      com.tencent.mm.kernel.g.DQ();
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().i(bk.G(this.vJA.vJQ.split(",")), false);
      localArrayList.add(localObject2);
      i = ((Cursor)localObject2).getCount();
      y.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label450;
      }
      this.vJG = 0;
      bf(this.vJG, "☆");
      i = i + 1 + 0;
      if (this.vJA.vIs != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label461;
      }
      com.tencent.mm.kernel.g.DQ();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dA(bk.G(this.vJA.vJP.split(",")));
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label503;
      }
      this.vJC = i;
      i += j + 1;
      bf(this.vJC, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = bk.G(this.vJA.vJP.split(","));
      com.tencent.mm.kernel.g.DQ();
      localArrayList.add(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().i((List)localObject3, true));
      localObject1 = s.M((List)localObject3);
      localObject3 = s.L((List)localObject3);
      if ((localObject1 == null) || (localObject3 == null)) {
        break label520;
      }
      k = 0;
      j = i;
      i = k;
      while (i < localObject1.length)
      {
        k = j;
        if (i < localObject3.length)
        {
          bf(localObject3[i] + j, localObject1[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.vJH = new HashMap();
      break;
      label436:
      this.vJI = new SparseArray();
      break label85;
      label450:
      this.vJG = 2147483647;
      i = 0;
      break label205;
      label461:
      com.tencent.mm.kernel.g.DQ();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dz(bk.G(this.vJA.vJP.split(",")));
      break label256;
      label503:
      this.vJC = 2147483647;
    }
    ((Cursor)localObject2).getCount();
    label520:
    y.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", new Object[] { this.vJH.toString() });
    this.eYd = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    notifyDataSetChanged();
    return;
    label571:
    if (this.vJA.vJO)
    {
      this.vJF = 0;
      bf(this.vJF, "nonLimit");
    }
    for (int i = 1;; i = 0)
    {
      if ((this.vJA.vJR) && (this.vJA.vJS != null) && (!bk.bl(this.vJA.vJS)))
      {
        localObject1 = bk.G(this.vJA.vJS.split(";"));
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dv((List)localObject1);
        localArrayList.add(localObject1);
        j = ((Cursor)localObject1).getCount();
        if (j > 0)
        {
          this.vJB = i;
          j = i + (j + 1);
          bf(this.vJB, "↑");
          i = j;
          if (this.vJA.vJK)
          {
            if (this.vJA.vIs != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1122;
            }
            com.tencent.mm.kernel.g.DQ();
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dC(this.dru);
            label770:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1153;
            }
            this.vJC = j;
            i = j + (i + 1);
            bf(this.vJC, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this.vJA.vIs, "", this.dru);
        localArrayList.add(localObject1);
        localObject2 = s.a(this.vJA.vIs, "", "", this.dru);
        localObject3 = s.b(this.vJA.vIs, "", this.dru, "");
        j = i;
        if (localObject2 == null) {
          break label1178;
        }
        j = i;
        if (localObject3 == null) {
          break label1178;
        }
        j = 0;
        int m;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            bf(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.vJB = 2147483647;
        j = i;
        break;
        j = i;
        if (!this.vJA.vJJ) {
          break;
        }
        localObject1 = g.ek(this.dru);
        if (((List)localObject1).size() == 0) {
          com.tencent.mm.kernel.g.DQ();
        }
        for (localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().cuz();; localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dv((List)localObject1))
        {
          localArrayList.add(localObject1);
          j = ((Cursor)localObject1).getCount();
          if (j <= 0) {
            break label1111;
          }
          this.nCS = i;
          j = i + (j + 1);
          bf(this.nCS, "↑");
          break;
          com.tencent.mm.kernel.g.DQ();
        }
        label1111:
        this.nCS = 2147483647;
        j = i;
        break;
        label1122:
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().dB(this.dru);
        break label770;
        label1153:
        this.vJC = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + localObject2.length);
      label1178:
      i = j;
      if (this.vJA.vJL)
      {
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().c("@all.chatroom.contact", "", this.dru);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1375;
        }
        this.vJD = j;
        i = j + (i + 1);
        bf(this.vJD, this.vLI.getActivity().getString(a.h.address_chatroom_contact_nick));
      }
      for (;;)
      {
        if (!this.vJA.vJM) {
          break label1384;
        }
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().c("@verify.contact", "", this.dru);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1386;
        }
        this.vJE = i;
        bf(this.vJE, this.vLI.getActivity().getString(a.h.select_contact_official_accounts_title));
        break;
        label1375:
        this.vJD = 2147483647;
        i = j;
      }
      label1384:
      break;
      label1386:
      this.vJE = 2147483647;
      break;
    }
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    xO();
    notifyDataSetChanged();
  }
  
  public final int adP(String paramString)
  {
    int j = -1;
    int i;
    if (paramString.equals("↑")) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.vJH == null);
      i = j;
    } while (!this.vJH.containsKey(paramString));
    return ((Integer)this.vJH.get(paramString)).intValue() + this.vLI.getContentLV().getHeaderViewsCount();
  }
  
  protected final boolean c(a parama)
  {
    int j = parama.position + 1;
    int k = this.vJG;
    int m = this.vJB;
    int n = this.nCS;
    int i1 = this.vJC;
    int i2 = this.vJD;
    int i3 = this.vJE;
    int i = 0;
    if (i < 6) {
      if (j != new int[] { k, m, n, i1, i2, i3 }[i]) {}
    }
    while (this.vJI.indexOfKey(j) >= 0)
    {
      return true;
      i += 1;
      break;
    }
    return false;
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    com.tencent.mm.kernel.g.DQ();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this);
  }
  
  public final int getCount()
  {
    return this.eYd.getCount() + this.vJH.size();
  }
  
  protected final a jQ(int paramInt)
  {
    if (paramInt == this.vJG) {
      return bg(paramInt, this.vLI.getActivity().getString(a.h.select_contact_wechat_sport_recent_like_contact_name));
    }
    if (paramInt == this.vJB) {
      return bg(paramInt, this.vJA.vJT);
    }
    if (paramInt == this.nCS) {
      return bg(paramInt, this.vLI.getActivity().getString(a.h.select_contact_near_contact_catalog_name));
    }
    if (paramInt == this.vJC) {
      return bg(paramInt, this.vLI.getActivity().getString(a.h.select_contact_favour_contact_catalog_name));
    }
    if (paramInt == this.vJD) {
      return bg(paramInt, this.vLI.getActivity().getString(a.h.address_chatroom_contact_nick));
    }
    if (paramInt == this.vJE) {
      return bg(paramInt, this.vLI.getActivity().getString(a.h.select_contact_official_accounts_title));
    }
    if (paramInt == this.vJF) {
      return new com.tencent.mm.ui.contact.a.j(paramInt);
    }
    if (this.vJI.indexOfKey(paramInt) >= 0) {
      return bg(paramInt, (String)this.vJI.get(paramInt));
    }
    int k = paramInt;
    int i = 0;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.vJI.size()) {
        break;
      }
      j = i;
      if (this.vJI.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.eYd.moveToPosition(i))
    {
      y.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      ad localad = new ad();
      localad.d(this.eYd);
      d locald = new d(paramInt);
      locald.dnp = localad;
      locald.vLJ = bBJ();
      locald.vLK = this.vLK;
      return locald;
    }
    y.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */