package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
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
  private int ItA;
  private int ItB;
  private int ItC;
  private int ItD;
  private int ItE;
  private int ItF;
  private HashMap<String, Integer> ItG;
  private SparseArray<String> ItH;
  private int ItI;
  private List<String> ItJ;
  private List<String> ItK;
  g ItL;
  private List<String> ItM;
  private List<x> ItN;
  private a Itx;
  private int Ity;
  private int Itz;
  private Cursor iCz;
  private int wQm;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(102809);
    this.Ity = 2147483647;
    this.wQm = 2147483647;
    this.Itz = 2147483647;
    this.ItA = 2147483647;
    this.ItB = 2147483647;
    this.ItC = 2147483647;
    this.ItD = 2147483647;
    this.ItE = 2147483647;
    this.ItF = 2147483647;
    this.ItG = null;
    this.ItH = null;
    this.ItI = 0;
    this.ItL = new g();
    this.ItM = null;
    this.ItN = null;
    ac.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.Itx = parama;; this.Itx = new a())
    {
      this.ItK = paramList1;
      this.ItJ = paramList2;
      com.tencent.mm.kernel.g.agS();
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this);
      WN();
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
  
  private void cK(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.ItG.put(paramString, Integer.valueOf(paramInt));
    this.ItH.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  private static a cL(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102816);
    return localh;
  }
  
  public final void WN()
  {
    AppMethodBeat.i(102811);
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    this.Ity = 2147483647;
    this.wQm = 2147483647;
    this.Itz = 2147483647;
    this.ItA = 2147483647;
    this.ItB = 2147483647;
    this.ItC = 2147483647;
    this.ItD = 2147483647;
    this.ItF = 2147483647;
    label102:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.ItG != null)
    {
      this.ItG.clear();
      if (this.ItH == null) {
        break label468;
      }
      this.ItH.clear();
      localArrayList = new ArrayList();
      if (!this.Itx.ItT) {
        break label639;
      }
      localObject1 = bs.lp(this.Itx.ItW, ",");
      if (((List)localObject1).isEmpty()) {
        break label493;
      }
      com.tencent.mm.kernel.g.agS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().p((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      ac.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label482;
      }
      this.ItF = 0;
      cK(this.ItF, "☆");
      i = i + 1 + 0;
      label233:
      if (this.Itx.Isk != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label504;
      }
      com.tencent.mm.kernel.g.agS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hr(bs.S(this.Itx.ItV.split(",")));
      label284:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label546;
      }
      this.ItB = i;
      i += j + 1;
      cK(this.ItB, "☆");
    }
    Object localObject2;
    String[] arrayOfString;
    int k;
    for (;;)
    {
      localObject2 = bs.S(this.Itx.ItV.split(","));
      com.tencent.mm.kernel.g.agS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().p((List)localObject2, true);
      localArrayList.add(localObject1);
      arrayOfString = w.ag((List)localObject2);
      localObject2 = w.af((List)localObject2);
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
          cK(localObject2[i] + j, arrayOfString[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.ItG = new HashMap();
      break;
      label468:
      this.ItH = new SparseArray();
      break label102;
      label482:
      this.ItF = 2147483647;
      i = 0;
      break label233;
      label493:
      this.ItF = 2147483647;
      i = 0;
      break label233;
      label504:
      com.tencent.mm.kernel.g.agS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hq(bs.S(this.Itx.ItV.split(",")));
      break label284;
      label546:
      this.ItB = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label563:
    this.iCz = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    ac.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iCz.getCount()), this.ItG.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label639:
    if (this.Itx.ItU)
    {
      this.ItE = 0;
      cK(this.ItE, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.Itx.ItX) && (this.Itx.ItY != null) && (!bs.isNullOrNil(this.Itx.ItY)))
      {
        localObject1 = bs.S(this.Itx.ItY.split(";"));
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hl((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.Ity = j;
          i = j + (i + 1);
          cK(this.Ity, "↑");
          j = i;
          if (this.Itx.ItS)
          {
            this.ItL.jdMethod_if(this.fzw);
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.ItK);
            ((List)localObject1).addAll(this.ItJ);
            this.ItL.id((List)localObject1);
            k = i;
            if (this.ItK.size() < 3)
            {
              localObject1 = this.ItL.fqZ();
              j = ((Cursor)localObject1).getCount();
              this.ItI = j;
              if (j <= 0) {
                break label1390;
              }
              localArrayList.add(localObject1);
              this.ItA = i;
              k = i + (j + 1);
              cK(this.ItA, "↑");
              ac.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label945:
            j = k;
            if (this.ItJ.size() > 0)
            {
              j = k;
              if (this.ItK.size() < 41)
              {
                localObject1 = this.ItL.fqY();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1402;
                }
                localArrayList.add(localObject1);
                this.Itz = k;
                j = k + (i + 1);
                cK(this.Itz, "↑");
                ac.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1047:
          i = j;
          if (this.Itx.ItP)
          {
            if (this.Itx.Isk != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1414;
            }
            com.tencent.mm.kernel.g.agS();
            localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ht(this.fzw);
            label1099:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1445;
            }
            this.ItB = j;
            i = j + (i + 1);
            cK(this.ItB, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(this.Itx.Isk, "", this.fzw);
        localArrayList.add(localObject1);
        arrayOfString = w.a(null, this.Itx.Isk, "", "", this.fzw);
        localObject2 = w.a(null, this.Itx.Isk, "", this.fzw, "");
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
            cK(localObject2[j] + k, arrayOfString[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.Ity = 2147483647;
        i = j;
        break;
        i = j;
        if (!this.Itx.ItO) {
          break;
        }
        localObject1 = h.ih(this.fzw);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.wQm = j;
          i = j + (i + 1);
          cK(this.wQm, "↑");
          break;
        }
        this.wQm = 2147483647;
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
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().hs(this.fzw);
        break label1099;
        label1445:
        this.ItB = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + arrayOfString.length);
      label1470:
      i = j;
      if (this.Itx.ItQ)
      {
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().d("@all.chatroom.contact", "", this.fzw);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1667;
        }
        this.ItC = j;
        i = j + (i + 1);
        cK(this.ItC, this.Iwg.getActivity().getString(2131755178));
      }
      for (;;)
      {
        if (!this.Itx.ItR) {
          break label1676;
        }
        com.tencent.mm.kernel.g.agS();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().d("@verify.contact", "", this.fzw);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1678;
        }
        this.ItD = i;
        cK(this.ItD, this.Iwg.getActivity().getString(2131762997));
        break;
        label1667:
        this.ItC = 2147483647;
        i = j;
      }
      label1676:
      break;
      label1678:
      this.ItD = 2147483647;
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102818);
    WN();
    AppMethodBeat.o(102818);
  }
  
  public final boolean aQQ(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.ItL.aQT(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int aQR(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.ItG != null)
    {
      if (this.ItG.containsKey(paramString))
      {
        int i = ((Integer)this.ItG.get(paramString)).intValue();
        int j = this.Iwg.getContentLV().getHeaderViewsCount();
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
    int k = this.ItF;
    int m = this.Ity;
    int n = this.wQm;
    int i1 = this.Itz;
    int i2 = this.ItA;
    int i3 = this.ItB;
    int i4 = this.ItC;
    int i5 = this.ItD;
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
    if (this.ItH.indexOfKey(j) >= 0)
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
    ac.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    com.tencent.mm.kernel.g.agS();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this);
    AppMethodBeat.o(102817);
  }
  
  public final int fqU()
  {
    return this.ItI;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.iCz.getCount();
    if (this.ItH == null) {}
    for (int i = 0;; i = this.ItH.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  protected final a qH(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.ItF)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131763001));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Ity)
    {
      localObject = cL(paramInt, this.Itx.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.wQm)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131762991));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Itz)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131762998));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ItA)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131762999));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ItB)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131762985));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ItC)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131755178));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ItD)
    {
      localObject = cL(paramInt, this.Iwg.getActivity().getString(2131762997));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ItE)
    {
      localObject = new com.tencent.mm.ui.contact.a.k(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.ItH.indexOfKey(paramInt) >= 0)
    {
      localObject = cL(paramInt, (String)this.ItH.get(paramInt));
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
      if (i > this.ItH.size()) {
        break;
      }
      j = i;
      if (this.ItH.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iCz.moveToPosition(i))
    {
      ac.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new ai();
      ((ai)localObject).convertFrom(this.iCz);
      e locale = new e(paramInt);
      locale.contact = ((ai)localObject);
      if (w.sQ(((av)localObject).field_username))
      {
        locale.Iwh = false;
        locale.Iwi = false;
        locale.IzA = false;
      }
      for (locale.IzP = true;; locale.IzP = false)
      {
        AppMethodBeat.o(102815);
        return locale;
        locale.Iwh = dFi();
        locale.Iwi = this.Iwi;
      }
    }
    ac.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String Isk = "@all.contact.without.chatroom";
    public boolean ItO = false;
    public boolean ItP = false;
    public boolean ItQ = false;
    public boolean ItR = false;
    public boolean ItS = false;
    public boolean ItT = false;
    public boolean ItU = false;
    public String ItV;
    public String ItW;
    public boolean ItX = false;
    public String ItY = "";
    public String customHeader = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */