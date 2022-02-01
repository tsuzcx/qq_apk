package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements n.b
{
  private a Kkd;
  private int Kke;
  private int Kkf;
  private int Kkg;
  private int Kkh;
  private int Kki;
  private int Kkj;
  private int Kkk;
  private int Kkl;
  private HashMap<String, Integer> Kkm;
  private SparseArray<String> Kkn;
  private int Kko;
  private List<String> Kkp;
  private List<String> Kkq;
  g Kkr;
  private List<String> Kks;
  private List<ab> Kkt;
  private Cursor iVJ;
  private int ydU;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(102809);
    this.Kke = 2147483647;
    this.ydU = 2147483647;
    this.Kkf = 2147483647;
    this.Kkg = 2147483647;
    this.Kkh = 2147483647;
    this.Kki = 2147483647;
    this.Kkj = 2147483647;
    this.Kkk = 2147483647;
    this.Kkl = 2147483647;
    this.Kkm = null;
    this.Kkn = null;
    this.Kko = 0;
    this.Kkr = new g();
    this.Kks = null;
    this.Kkt = null;
    ad.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.Kkd = parama;; this.Kkd = new a())
    {
      this.Kkq = paramList1;
      this.Kkp = paramList2;
      com.tencent.mm.kernel.g.ajD();
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this);
      Zh();
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
  
  private void cR(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.Kkm.put(paramString, Integer.valueOf(paramInt));
    this.Kkn.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  private static a cS(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102816);
    return localh;
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(102811);
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    this.Kke = 2147483647;
    this.ydU = 2147483647;
    this.Kkf = 2147483647;
    this.Kkg = 2147483647;
    this.Kkh = 2147483647;
    this.Kki = 2147483647;
    this.Kkj = 2147483647;
    this.Kkl = 2147483647;
    label102:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.Kkm != null)
    {
      this.Kkm.clear();
      if (this.Kkn == null) {
        break label468;
      }
      this.Kkn.clear();
      localArrayList = new ArrayList();
      if (!this.Kkd.Kkz) {
        break label639;
      }
      localObject1 = bt.lO(this.Kkd.KkC, ",");
      if (((List)localObject1).isEmpty()) {
        break label493;
      }
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().r((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      ad.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label482;
      }
      this.Kkl = 0;
      cR(this.Kkl, "☆");
      i = i + 1 + 0;
      label233:
      if (this.Kkd.KiP != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label504;
      }
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hD(bt.U(this.Kkd.KkB.split(",")));
      label284:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label546;
      }
      this.Kkh = i;
      i += j + 1;
      cR(this.Kkh, "☆");
    }
    Object localObject2;
    String[] arrayOfString;
    int k;
    for (;;)
    {
      localObject2 = bt.U(this.Kkd.KkB.split(","));
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().r((List)localObject2, true);
      localArrayList.add(localObject1);
      arrayOfString = w.ah((List)localObject2);
      localObject2 = w.ag((List)localObject2);
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
          cR(localObject2[i] + j, arrayOfString[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.Kkm = new HashMap();
      break;
      label468:
      this.Kkn = new SparseArray();
      break label102;
      label482:
      this.Kkl = 2147483647;
      i = 0;
      break label233;
      label493:
      this.Kkl = 2147483647;
      i = 0;
      break label233;
      label504:
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hC(bt.U(this.Kkd.KkB.split(",")));
      break label284;
      label546:
      this.Kkh = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label563:
    this.iVJ = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    ad.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iVJ.getCount()), this.Kkm.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label639:
    if (this.Kkd.KkA)
    {
      this.Kkk = 0;
      cR(this.Kkk, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.Kkd.KkD) && (this.Kkd.KkE != null) && (!bt.isNullOrNil(this.Kkd.KkE)))
      {
        localObject1 = bt.U(this.Kkd.KkE.split(";"));
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hx((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.Kke = j;
          i = j + (i + 1);
          cR(this.Kke, "↑");
          j = i;
          if (this.Kkd.Kky)
          {
            this.Kkr.ir(this.fSL);
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.Kkq);
            ((List)localObject1).addAll(this.Kkp);
            this.Kkr.ip((List)localObject1);
            k = i;
            if (this.Kkq.size() < 3)
            {
              localObject1 = this.Kkr.fHM();
              j = ((Cursor)localObject1).getCount();
              this.Kko = j;
              if (j <= 0) {
                break label1390;
              }
              localArrayList.add(localObject1);
              this.Kkg = i;
              k = i + (j + 1);
              cR(this.Kkg, "↑");
              ad.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label945:
            j = k;
            if (this.Kkp.size() > 0)
            {
              j = k;
              if (this.Kkq.size() < 41)
              {
                localObject1 = this.Kkr.fHL();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1402;
                }
                localArrayList.add(localObject1);
                this.Kkf = k;
                j = k + (i + 1);
                cR(this.Kkf, "↑");
                ad.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1047:
          i = j;
          if (this.Kkd.Kkv)
          {
            if (this.Kkd.KiP != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1414;
            }
            com.tencent.mm.kernel.g.ajD();
            localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hF(this.fSL);
            label1099:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1445;
            }
            this.Kkh = j;
            i = j + (i + 1);
            cR(this.Kkh, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(this.Kkd.KiP, "", this.fSL);
        localArrayList.add(localObject1);
        arrayOfString = w.a(null, this.Kkd.KiP, "", "", this.fSL);
        localObject2 = w.a(null, this.Kkd.KiP, "", this.fSL, "");
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
            cR(localObject2[j] + k, arrayOfString[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.Kke = 2147483647;
        i = j;
        break;
        i = j;
        if (!this.Kkd.Kku) {
          break;
        }
        localObject1 = h.it(this.fSL);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.ydU = j;
          i = j + (i + 1);
          cR(this.ydU, "↑");
          break;
        }
        this.ydU = 2147483647;
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
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().hE(this.fSL);
        break label1099;
        label1445:
        this.Kkh = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + arrayOfString.length);
      label1470:
      i = j;
      if (this.Kkd.Kkw)
      {
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().d("@all.chatroom.contact", "", this.fSL);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1667;
        }
        this.Kki = j;
        i = j + (i + 1);
        cR(this.Kki, this.KmO.getActivity().getString(2131755178));
      }
      for (;;)
      {
        if (!this.Kkd.Kkx) {
          break label1676;
        }
        com.tencent.mm.kernel.g.ajD();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().d("@verify.contact", "", this.fSL);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1678;
        }
        this.Kkj = i;
        cR(this.Kkj, this.KmO.getActivity().getString(2131762997));
        break;
        label1667:
        this.Kki = 2147483647;
        i = j;
      }
      label1676:
      break;
      label1678:
      this.Kkj = 2147483647;
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102818);
    Zh();
    AppMethodBeat.o(102818);
  }
  
  public final boolean aWL(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.Kkr.aWO(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int aWM(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.Kkm != null)
    {
      if (this.Kkm.containsKey(paramString))
      {
        int i = ((Integer)this.Kkm.get(paramString)).intValue();
        int j = this.KmO.getContentLV().getHeaderViewsCount();
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
    int k = this.Kkl;
    int m = this.Kke;
    int n = this.ydU;
    int i1 = this.Kkf;
    int i2 = this.Kkg;
    int i3 = this.Kkh;
    int i4 = this.Kki;
    int i5 = this.Kkj;
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
    if (this.Kkn.indexOfKey(j) >= 0)
    {
      AppMethodBeat.o(102819);
      return true;
    }
    AppMethodBeat.o(102819);
    return false;
  }
  
  public final int fHH()
  {
    return this.Kko;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102817);
    super.finish();
    ad.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    com.tencent.mm.kernel.g.ajD();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this);
    AppMethodBeat.o(102817);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.iVJ.getCount();
    if (this.Kkn == null) {}
    for (int i = 0;; i = this.Kkn.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  protected final a rh(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.Kkl)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131763001));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kke)
    {
      localObject = cS(paramInt, this.Kkd.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ydU)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131762991));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kkf)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131762998));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kkg)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131762999));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kkh)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131762985));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kki)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131755178));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kkj)
    {
      localObject = cS(paramInt, this.KmO.getActivity().getString(2131762997));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Kkk)
    {
      localObject = new k(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.Kkn.indexOfKey(paramInt) >= 0)
    {
      localObject = cS(paramInt, (String)this.Kkn.get(paramInt));
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
      if (i > this.Kkn.size()) {
        break;
      }
      j = i;
      if (this.Kkn.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iVJ.moveToPosition(i))
    {
      ad.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new am();
      ((am)localObject).convertFrom(this.iVJ);
      e locale = new e(paramInt);
      locale.contact = ((am)localObject);
      if (w.vF(((aw)localObject).field_username))
      {
        locale.KmP = false;
        locale.KmQ = false;
        locale.KqG = false;
      }
      for (locale.KqV = true;; locale.KqV = false)
      {
        AppMethodBeat.o(102815);
        return locale;
        locale.KmP = dQK();
        locale.KmQ = this.KmQ;
      }
    }
    ad.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String KiP = "@all.contact.without.chatroom";
    public boolean KkA = false;
    public String KkB;
    public String KkC;
    public boolean KkD = false;
    public String KkE = "";
    public boolean Kku = false;
    public boolean Kkv = false;
    public boolean Kkw = false;
    public boolean Kkx = false;
    public boolean Kky = false;
    public boolean Kkz = false;
    public String customHeader = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */