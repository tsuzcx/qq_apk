package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends r
  implements MStorageEx.IOnStorageChange
{
  public boolean Bva;
  private HashMap<String, Integer> JUK;
  private SparseArray<String> JUL;
  private int OpX;
  private a afbI;
  private int afbJ;
  private int afbK;
  private int afbL;
  private int afbM;
  private int afbN;
  private int afbO;
  private int afbP;
  private int afbQ;
  private int afbR;
  private List<String> afbS;
  private List<String> afbT;
  g afbU;
  private List<String> afbV;
  private List<aj> afbW;
  private Cursor pKb;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3, boolean paramBoolean4)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(252841);
    this.afbJ = 2147483647;
    this.OpX = 2147483647;
    this.afbK = 2147483647;
    this.afbL = 2147483647;
    this.afbM = 2147483647;
    this.afbN = 2147483647;
    this.afbO = 2147483647;
    this.afbP = 2147483647;
    this.afbQ = 2147483647;
    this.JUK = null;
    this.JUL = null;
    this.afbR = 0;
    this.Bva = false;
    this.afbU = new g();
    this.afbV = null;
    this.afbW = null;
    this.Bva = paramBoolean4;
    Log.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.afbI = parama;; this.afbI = new a())
    {
      this.afbT = paramList1;
      this.afbS = paramList2;
      com.tencent.mm.kernel.h.baF();
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add(this);
      aNm();
      AppMethodBeat.o(252841);
      return;
    }
  }
  
  private c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, a parama)
  {
    this(paramMMBaseSelectContactUI, null, null, paramList, true, paramBoolean, parama, false, false);
  }
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, a parama, byte paramByte)
  {
    this(paramMMBaseSelectContactUI, paramList, paramBoolean, parama);
  }
  
  private a cf(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    j localj = new j(paramInt);
    localj.header = paramString;
    localj.Bva = this.Bva;
    AppMethodBeat.o(102816);
    return localj;
  }
  
  private void ee(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.JUK.put(paramString, Integer.valueOf(paramInt));
    this.JUL.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  public final int aJM(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.JUK != null)
    {
      if (this.JUK.containsKey(paramString))
      {
        int i = ((Integer)this.JUK.get(paramString)).intValue();
        int j = this.afex.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(102813);
        return i + j;
      }
      AppMethodBeat.o(102813);
      return -1;
    }
    AppMethodBeat.o(102813);
    return -1;
  }
  
  public final void aNm()
  {
    Object localObject2 = null;
    AppMethodBeat.i(102811);
    Log.i("MicroMsg.AlphabetContactAdapter", "resetData");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    this.afbJ = 2147483647;
    this.OpX = 2147483647;
    this.afbK = 2147483647;
    this.afbL = 2147483647;
    this.afbM = 2147483647;
    this.afbN = 2147483647;
    this.afbO = 2147483647;
    this.afbQ = 2147483647;
    label112:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.JUK != null)
    {
      this.JUK.clear();
      if (this.JUL == null) {
        break label482;
      }
      this.JUL.clear();
      localArrayList = new ArrayList();
      if (!this.afbI.afcc) {
        break label653;
      }
      localObject1 = Util.stringToList(this.afbI.afcg, ",");
      if (((List)localObject1).isEmpty()) {
        break label507;
      }
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().O((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      Log.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label496;
      }
      this.afbQ = 0;
      ee(this.afbQ, "☆");
      i = i + 1 + 0;
      label245:
      if (this.afbI.afau != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label518;
      }
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mW(Util.stringsToList(this.afbI.afcf.split(",")));
      label297:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label560;
      }
      this.afbM = i;
      i += j + 1;
      ee(this.afbM, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = Util.stringsToList(this.afbI.afcf.split(","));
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().O((List)localObject3, true);
      localArrayList.add(localObject1);
      localObject2 = ab.bT((List)localObject3);
      localObject3 = ab.bS((List)localObject3);
      if ((localObject2 == null) || (localObject3 == null)) {
        break label577;
      }
      k = 0;
      j = i;
      i = k;
      while (i < localObject2.length)
      {
        k = j;
        if (i < localObject3.length)
        {
          ee(localObject3[i] + j, localObject2[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.JUK = new HashMap();
      break;
      label482:
      this.JUL = new SparseArray();
      break label112;
      label496:
      this.afbQ = 2147483647;
      i = 0;
      break label245;
      label507:
      this.afbQ = 2147483647;
      i = 0;
      break label245;
      label518:
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mV(Util.stringsToList(this.afbI.afcf.split(",")));
      break label297;
      label560:
      this.afbM = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label577:
    this.pKb = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    Log.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.pKb.getCount()), this.JUK.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label653:
    if (this.afbI.afcd)
    {
      this.afbP = 0;
      ee(this.afbP, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.afbI.afch) && (this.afbI.afci != null) && (!Util.isNullOrNil(this.afbI.afci)))
      {
        localObject1 = Util.stringsToList(this.afbI.afci.split(";"));
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mQ((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.afbJ = j;
          i = j + (i + 1);
          ee(this.afbJ, "↑");
          j = i;
          if (this.afbI.afcb)
          {
            this.afbU.nP(cVa());
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.afbT);
            ((List)localObject1).addAll(this.afbS);
            this.afbU.nN((List)localObject1);
            k = i;
            if (this.afbT.size() < 3)
            {
              localObject1 = this.afbU.jyh();
              j = ((Cursor)localObject1).getCount();
              this.afbR = j;
              if (j <= 0) {
                break label1484;
              }
              localArrayList.add(localObject1);
              this.afbL = i;
              k = i + (j + 1);
              ee(this.afbL, "↑");
              Log.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label957:
            j = k;
            if (this.afbS.size() > 0)
            {
              j = k;
              if (this.afbT.size() < 41)
              {
                localObject1 = this.afbU.jyg();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1496;
                }
                localArrayList.add(localObject1);
                this.afbK = k;
                j = k + (i + 1);
                ee(this.afbK, "↑");
                Log.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1058:
          i = j;
          if (this.afbI.afbY)
          {
            Log.i("MicroMsg.AlphabetContactAdapter", "option.filterType = " + this.afbI.afau);
            if (this.afbI.afau != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1508;
            }
            Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursorWithoutOpenIM");
            com.tencent.mm.kernel.h.baF();
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mY(cVa());
            label1147:
            localArrayList.add(localObject1);
            long l = System.currentTimeMillis();
            Log.i("MicroMsg.AlphabetContactAdapter", "before favContactCursor.getCount");
            i = ((Cursor)localObject1).getCount();
            Log.i("MicroMsg.AlphabetContactAdapter", "favContactCursor.getCount duration = " + (System.currentTimeMillis() - l));
            if (i <= 0) {
              break label1547;
            }
            this.afbM = j;
            i = j + (i + 1);
            ee(this.afbM, "☆");
          }
        }
      }
      label1231:
      int m;
      for (;;)
      {
        if (this.afbI.afce)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(this.afbI.afcj)) {
            localObject1 = Util.stringToList(this.afbI.afcj, ",");
          }
          if (!Util.isNullOrNil((List)localObject1))
          {
            com.tencent.mm.kernel.h.baF();
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().O((List)localObject1, true);
            localArrayList.add(localObject2);
            localObject3 = ab.bT((List)localObject1);
            localObject1 = ab.bS((List)localObject1);
            j = i;
            if (localObject3 != null)
            {
              j = i;
              if (localObject1 != null)
              {
                j = 0;
                k = i;
                for (;;)
                {
                  if (j < localObject3.length)
                  {
                    m = k;
                    if (j < localObject1.length)
                    {
                      ee(localObject1[j] + k, localObject3[j]);
                      m = k + 1;
                    }
                    j += 1;
                    k = m;
                    continue;
                    this.afbJ = 2147483647;
                    i = j;
                    break;
                    i = j;
                    if (!this.afbI.afbX) {
                      break;
                    }
                    localObject1 = h.nR(cVa());
                    localArrayList.add(localObject1);
                    i = ((Cursor)localObject1).getCount();
                    if (i > 0)
                    {
                      this.OpX = j;
                      i = j + (i + 1);
                      ee(this.OpX, "↑");
                      break;
                    }
                    this.OpX = 2147483647;
                    i = j;
                    break;
                    label1484:
                    ((Cursor)localObject1).close();
                    k = i;
                    break label957;
                    label1496:
                    ((Cursor)localObject1).close();
                    j = k;
                    break label1058;
                    label1508:
                    Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursor");
                    com.tencent.mm.kernel.h.baF();
                    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().mX(cVa());
                    break label1147;
                    label1547:
                    this.afbM = 2147483647;
                    i = j;
                    break label1231;
                  }
                }
                j = i + (((Cursor)localObject2).getCount() + localObject3.length);
              }
            }
            label1572:
            i = j;
            if (this.afbI.afbZ)
            {
              com.tencent.mm.kernel.h.baF();
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().g("@all.chatroom.contact", "", cVa());
              localArrayList.add(localObject1);
              i = ((Cursor)localObject1).getCount();
              if (i <= 0) {
                break label1981;
              }
              this.afbN = j;
              i = j + (i + 1);
              ee(this.afbN, this.afex.getActivity().getString(a.h.address_chatroom_contact_nick));
            }
          }
        }
      }
      for (;;)
      {
        if (!this.afbI.afca) {
          break label1990;
        }
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().g("@verify.contact", "", cVa());
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1992;
        }
        this.afbO = i;
        ee(this.afbO, this.afex.getActivity().getString(a.h.select_contact_official_accounts_title));
        break;
        localArrayList.add(new com.tencent.mm.storagebase.d());
        j = i;
        break label1572;
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
        localObject2 = this.afbI.afau;
        localObject3 = cVa();
        jyS();
        localObject1 = ((bx)localObject1).f((String)localObject2, "", (List)localObject3);
        localArrayList.add(localObject1);
        localObject2 = ab.a(null, this.afbI.afau, "", "", cVa());
        localObject3 = ab.a(null, this.afbI.afau, "", cVa(), "");
        j = i;
        if (localObject2 == null) {
          break label1572;
        }
        j = i;
        if (localObject3 == null) {
          break label1572;
        }
        j = 0;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            ee(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        j = i + (((Cursor)localObject1).getCount() + localObject2.length);
        break label1572;
        label1981:
        this.afbN = 2147483647;
        i = j;
      }
      label1990:
      break;
      label1992:
      this.afbO = 2147483647;
      break;
    }
  }
  
  public final boolean bBH(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.afbU.bBJ(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  protected final boolean d(a parama)
  {
    AppMethodBeat.i(102819);
    int j = parama.position + 1;
    int k = this.afbQ;
    int m = this.afbJ;
    int n = this.OpX;
    int i1 = this.afbK;
    int i2 = this.afbL;
    int i3 = this.afbM;
    int i4 = this.afbN;
    int i5 = this.afbO;
    int i = 0;
    while (i < 8)
    {
      if (j == new int[] { k, m, n, i1, i2, i3, i4, i5 }[i])
      {
        AppMethodBeat.o(102819);
        return true;
      }
      i += 1;
    }
    if (this.JUL.indexOfKey(j) >= 0)
    {
      AppMethodBeat.o(102819);
      return true;
    }
    AppMethodBeat.o(102819);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102817);
    super.finish();
    Log.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    com.tencent.mm.kernel.h.baF();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove(this);
    AppMethodBeat.o(102817);
  }
  
  public final int getContactCount()
  {
    AppMethodBeat.i(252895);
    if (this.pKb != null)
    {
      int i = this.pKb.getCount();
      AppMethodBeat.o(252895);
      return i;
    }
    AppMethodBeat.o(252895);
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.pKb.getCount();
    if (this.JUL == null) {}
    for (int i = 0;; i = this.JUL.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  public final int jyc()
  {
    return this.afbR;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(102818);
    Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange evnet = ".concat(String.valueOf(paramInt)));
    if (paramMStorageEx != null) {
      Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange stg = " + paramMStorageEx.toString());
    }
    if (paramObject != null) {
      Log.i("MicroMsg.AlphabetContactAdapter", "onNotifyChange obj = " + paramObject.toString());
    }
    if (paramObject != null)
    {
      com.tencent.mm.kernel.h.baF();
      paramMStorageEx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq(paramObject.toString());
      if ((paramMStorageEx != null) && (com.tencent.mm.contact.d.rs(paramMStorageEx.field_type))) {
        aNm();
      }
    }
    AppMethodBeat.o(102818);
  }
  
  protected final a yk(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.afbQ)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_wechat_sport_recent_like_contact_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbJ)
    {
      localObject = cf(paramInt, this.afbI.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.OpX)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_near_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbK)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_recommend_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbL)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_recommend_group_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbM)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_favour_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbN)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.address_chatroom_contact_nick));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbO)
    {
      localObject = cf(paramInt, this.afex.getActivity().getString(a.h.select_contact_official_accounts_title));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.afbP)
    {
      localObject = new com.tencent.mm.ui.contact.a.n(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.JUL.indexOfKey(paramInt) >= 0)
    {
      localObject = cf(paramInt, (String)this.JUL.get(paramInt));
      AppMethodBeat.o(102815);
      return localObject;
    }
    int k = paramInt;
    int i = 0;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.JUL.size()) {
        break;
      }
      j = i;
      if (this.JUL.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.pKb.moveToPosition(i))
    {
      Log.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new au();
      ((au)localObject).convertFrom(this.pKb);
      f localf = new f(paramInt);
      localf.contact = ((au)localObject);
      if (!Util.isNullOrNil(this.afbI.hCy)) {
        localf.hCy = this.afbI.hCy;
      }
      if (au.bwE(((az)localObject).field_username))
      {
        localf.afey = false;
        localf.afez = false;
        localf.afjA = false;
      }
      for (localf.afjT = true;; localf.afjT = false)
      {
        localf.Bva = this.Bva;
        AppMethodBeat.o(102815);
        return localf;
        localf.afey = gZe();
        localf.afez = jyD();
      }
    }
    Log.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String afau = "@all.contact.without.chatroom";
    public boolean afbX = false;
    public boolean afbY = false;
    public boolean afbZ = false;
    public boolean afca = false;
    public boolean afcb = false;
    public boolean afcc = false;
    public boolean afcd = false;
    public boolean afce = false;
    public String afcf;
    public String afcg;
    public boolean afch = false;
    public String afci = "";
    public String afcj = "";
    public String customHeader = "";
    public String hCy = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */