package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements n.b
{
  g GTA;
  private List<String> GTB;
  private List<com.tencent.mm.storage.w> GTC;
  private a GTm;
  private int GTn;
  private int GTo;
  private int GTp;
  private int GTq;
  private int GTr;
  private int GTs;
  private int GTt;
  private int GTu;
  private HashMap<String, Integer> GTv;
  private SparseArray<String> GTw;
  private int GTx;
  private List<String> GTy;
  private List<String> GTz;
  private Cursor icq;
  private int vGh;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(102809);
    this.GTn = 2147483647;
    this.vGh = 2147483647;
    this.GTo = 2147483647;
    this.GTp = 2147483647;
    this.GTq = 2147483647;
    this.GTr = 2147483647;
    this.GTs = 2147483647;
    this.GTt = 2147483647;
    this.GTu = 2147483647;
    this.GTv = null;
    this.GTw = null;
    this.GTx = 0;
    this.GTA = new g();
    this.GTB = null;
    this.GTC = null;
    ad.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.GTm = parama;; this.GTm = new a())
    {
      this.GTz = paramList1;
      this.GTy = paramList2;
      com.tencent.mm.kernel.g.afC();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this);
      VP();
      AppMethodBeat.o(102809);
      return;
    }
  }
  
  private c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, a parama)
  {
    this(paramMMBaseSelectContactUI, null, null, paramList, true, paramBoolean, parama, false);
  }
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, a parama, byte paramByte)
  {
    this(paramMMBaseSelectContactUI, paramList, paramBoolean, parama);
  }
  
  private void cH(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.GTv.put(paramString, Integer.valueOf(paramInt));
    this.GTw.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  private static a cI(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102816);
    return localh;
  }
  
  public final void VP()
  {
    AppMethodBeat.i(102811);
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    this.GTn = 2147483647;
    this.vGh = 2147483647;
    this.GTo = 2147483647;
    this.GTp = 2147483647;
    this.GTq = 2147483647;
    this.GTr = 2147483647;
    this.GTs = 2147483647;
    this.GTu = 2147483647;
    label102:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.GTv != null)
    {
      this.GTv.clear();
      if (this.GTw == null) {
        break label468;
      }
      this.GTw.clear();
      localArrayList = new ArrayList();
      if (!this.GTm.GTI) {
        break label639;
      }
      localObject1 = bt.kS(this.GTm.GTL, ",");
      if (((List)localObject1).isEmpty()) {
        break label493;
      }
      com.tencent.mm.kernel.g.afC();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().o((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      ad.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label482;
      }
      this.GTu = 0;
      cH(this.GTu, "☆");
      i = i + 1 + 0;
      label233:
      if (this.GTm.GRX != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label504;
      }
      com.tencent.mm.kernel.g.afC();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().he(bt.S(this.GTm.GTK.split(",")));
      label284:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label546;
      }
      this.GTq = i;
      i += j + 1;
      cH(this.GTq, "☆");
    }
    Object localObject2;
    String[] arrayOfString;
    int k;
    for (;;)
    {
      localObject2 = bt.S(this.GTm.GTK.split(","));
      com.tencent.mm.kernel.g.afC();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().o((List)localObject2, true);
      localArrayList.add(localObject1);
      arrayOfString = com.tencent.mm.model.w.aj((List)localObject2);
      localObject2 = com.tencent.mm.model.w.ai((List)localObject2);
      if ((arrayOfString == null) || (localObject2 == null)) {
        break label563;
      }
      k = 0;
      j = i;
      i = k;
      while (i < arrayOfString.length)
      {
        k = j;
        if (i < localObject2.length)
        {
          cH(localObject2[i] + j, arrayOfString[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.GTv = new HashMap();
      break;
      label468:
      this.GTw = new SparseArray();
      break label102;
      label482:
      this.GTu = 2147483647;
      i = 0;
      break label233;
      label493:
      this.GTu = 2147483647;
      i = 0;
      break label233;
      label504:
      com.tencent.mm.kernel.g.afC();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hd(bt.S(this.GTm.GTK.split(",")));
      break label284;
      label546:
      this.GTq = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label563:
    this.icq = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    ad.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.icq.getCount()), this.GTv.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label639:
    if (this.GTm.GTJ)
    {
      this.GTt = 0;
      cH(this.GTt, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.GTm.GTM) && (this.GTm.GTN != null) && (!bt.isNullOrNil(this.GTm.GTN)))
      {
        localObject1 = bt.S(this.GTm.GTN.split(";"));
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().gY((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.GTn = j;
          i = j + (i + 1);
          cH(this.GTn, "↑");
          j = i;
          if (this.GTm.GTH)
          {
            this.GTA.hS(this.fvP);
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.GTz);
            ((List)localObject1).addAll(this.GTy);
            this.GTA.hQ((List)localObject1);
            k = i;
            if (this.GTz.size() < 3)
            {
              localObject1 = this.GTA.fbi();
              j = ((Cursor)localObject1).getCount();
              this.GTx = j;
              if (j <= 0) {
                break label1390;
              }
              localArrayList.add(localObject1);
              this.GTp = i;
              k = i + (j + 1);
              cH(this.GTp, "↑");
              ad.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label945:
            j = k;
            if (this.GTy.size() > 0)
            {
              j = k;
              if (this.GTz.size() < 41)
              {
                localObject1 = this.GTA.fbh();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1402;
                }
                localArrayList.add(localObject1);
                this.GTo = k;
                j = k + (i + 1);
                cH(this.GTo, "↑");
                ad.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1047:
          i = j;
          if (this.GTm.GTE)
          {
            if (this.GTm.GRX != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1414;
            }
            com.tencent.mm.kernel.g.afC();
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hg(this.fvP);
            label1099:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1445;
            }
            this.GTq = j;
            i = j + (i + 1);
            cH(this.GTq, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(this.GTm.GRX, "", this.fvP);
        localArrayList.add(localObject1);
        arrayOfString = com.tencent.mm.model.w.a(null, this.GTm.GRX, "", "", this.fvP);
        localObject2 = com.tencent.mm.model.w.a(null, this.GTm.GRX, "", this.fvP, "");
        j = i;
        if (arrayOfString == null) {
          break label1470;
        }
        j = i;
        if (localObject2 == null) {
          break label1470;
        }
        j = 0;
        int m;
        for (k = i; j < arrayOfString.length; k = m)
        {
          m = k;
          if (j < localObject2.length)
          {
            cH(localObject2[j] + k, arrayOfString[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.GTn = 2147483647;
        i = j;
        break;
        i = j;
        if (!this.GTm.GTD) {
          break;
        }
        localObject1 = h.hU(this.fvP);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.vGh = j;
          i = j + (i + 1);
          cH(this.vGh, "↑");
          break;
        }
        this.vGh = 2147483647;
        i = j;
        break;
        label1390:
        ((Cursor)localObject1).close();
        k = i;
        break label945;
        label1402:
        ((Cursor)localObject1).close();
        j = k;
        break label1047;
        label1414:
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().hf(this.fvP);
        break label1099;
        label1445:
        this.GTq = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + arrayOfString.length);
      label1470:
      i = j;
      if (this.GTm.GTF)
      {
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().d("@all.chatroom.contact", "", this.fvP);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1667;
        }
        this.GTr = j;
        i = j + (i + 1);
        cH(this.GTr, this.GVS.getActivity().getString(2131755178));
      }
      for (;;)
      {
        if (!this.GTm.GTG) {
          break label1676;
        }
        com.tencent.mm.kernel.g.afC();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().d("@verify.contact", "", this.fvP);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1678;
        }
        this.GTs = i;
        cH(this.GTs, this.GVS.getActivity().getString(2131762997));
        break;
        label1667:
        this.GTr = 2147483647;
        i = j;
      }
      label1676:
      break;
      label1678:
      this.GTs = 2147483647;
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102818);
    VP();
    AppMethodBeat.o(102818);
  }
  
  public final boolean aLm(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.GTA.aLp(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int aLn(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.GTv != null)
    {
      if (this.GTv.containsKey(paramString))
      {
        int i = ((Integer)this.GTv.get(paramString)).intValue();
        int j = this.GVS.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(102813);
        return i + j;
      }
      AppMethodBeat.o(102813);
      return -1;
    }
    AppMethodBeat.o(102813);
    return -1;
  }
  
  protected final boolean c(a parama)
  {
    AppMethodBeat.i(102819);
    int j = parama.position + 1;
    int k = this.GTu;
    int m = this.GTn;
    int n = this.vGh;
    int i1 = this.GTo;
    int i2 = this.GTp;
    int i3 = this.GTq;
    int i4 = this.GTr;
    int i5 = this.GTs;
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
    if (this.GTw.indexOfKey(j) >= 0)
    {
      AppMethodBeat.o(102819);
      return true;
    }
    AppMethodBeat.o(102819);
    return false;
  }
  
  public final int fbd()
  {
    return this.GTx;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102817);
    super.finish();
    ad.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    com.tencent.mm.kernel.g.afC();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this);
    AppMethodBeat.o(102817);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.icq.getCount();
    if (this.GTw == null) {}
    for (int i = 0;; i = this.GTw.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  protected final a pU(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.GTu)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131763001));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTn)
    {
      localObject = cI(paramInt, this.GTm.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.vGh)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131762991));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTo)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131762998));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTp)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131762999));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTq)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131762985));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTr)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131755178));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTs)
    {
      localObject = cI(paramInt, this.GVS.getActivity().getString(2131762997));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.GTt)
    {
      localObject = new com.tencent.mm.ui.contact.a.k(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.GTw.indexOfKey(paramInt) >= 0)
    {
      localObject = cI(paramInt, (String)this.GTw.get(paramInt));
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
      if (i > this.GTw.size()) {
        break;
      }
      j = i;
      if (this.GTw.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.icq.moveToPosition(i))
    {
      ad.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new af();
      ((af)localObject).convertFrom(this.icq);
      e locale = new e(paramInt);
      locale.contact = ((af)localObject);
      if (com.tencent.mm.model.w.pF(((au)localObject).field_username))
      {
        locale.GVT = false;
        locale.GVU = false;
        locale.GZk = false;
      }
      for (locale.GZx = true;; locale.GZx = false)
      {
        AppMethodBeat.o(102815);
        return locale;
        locale.GVT = dqZ();
        locale.GVU = this.GVU;
      }
    }
    ad.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String GRX = "@all.contact.without.chatroom";
    public boolean GTD = false;
    public boolean GTE = false;
    public boolean GTF = false;
    public boolean GTG = false;
    public boolean GTH = false;
    public boolean GTI = false;
    public boolean GTJ = false;
    public String GTK;
    public String GTL;
    public boolean GTM = false;
    public String GTN = "";
    public String customHeader = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */