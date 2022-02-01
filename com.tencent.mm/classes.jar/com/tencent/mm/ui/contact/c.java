package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private int KGA;
  private int KGB;
  private int KGC;
  private int KGD;
  private int KGE;
  private int KGF;
  private HashMap<String, Integer> KGG;
  private SparseArray<String> KGH;
  private int KGI;
  private List<String> KGJ;
  private List<String> KGK;
  g KGL;
  private List<String> KGM;
  private List<ac> KGN;
  private a KGx;
  private int KGy;
  private int KGz;
  private Cursor iYC;
  private int ytL;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(102809);
    this.KGy = 2147483647;
    this.ytL = 2147483647;
    this.KGz = 2147483647;
    this.KGA = 2147483647;
    this.KGB = 2147483647;
    this.KGC = 2147483647;
    this.KGD = 2147483647;
    this.KGE = 2147483647;
    this.KGF = 2147483647;
    this.KGG = null;
    this.KGH = null;
    this.KGI = 0;
    this.KGL = new g();
    this.KGM = null;
    this.KGN = null;
    ae.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.KGx = parama;; this.KGx = new a())
    {
      this.KGK = paramList1;
      this.KGJ = paramList2;
      com.tencent.mm.kernel.g.ajS();
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this);
      Zq();
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
    this.KGG.put(paramString, Integer.valueOf(paramInt));
    this.KGH.put(paramInt, paramString);
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
  
  public final void Zq()
  {
    AppMethodBeat.i(102811);
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    this.KGy = 2147483647;
    this.ytL = 2147483647;
    this.KGz = 2147483647;
    this.KGA = 2147483647;
    this.KGB = 2147483647;
    this.KGC = 2147483647;
    this.KGD = 2147483647;
    this.KGF = 2147483647;
    label102:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.KGG != null)
    {
      this.KGG.clear();
      if (this.KGH == null) {
        break label468;
      }
      this.KGH.clear();
      localArrayList = new ArrayList();
      if (!this.KGx.KGT) {
        break label639;
      }
      localObject1 = bu.lV(this.KGx.KGW, ",");
      if (((List)localObject1).isEmpty()) {
        break label493;
      }
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().r((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      ae.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label482;
      }
      this.KGF = 0;
      cR(this.KGF, "☆");
      i = i + 1 + 0;
      label233:
      if (this.KGx.KFj != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label504;
      }
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hN(bu.U(this.KGx.KGV.split(",")));
      label284:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label546;
      }
      this.KGB = i;
      i += j + 1;
      cR(this.KGB, "☆");
    }
    Object localObject2;
    String[] arrayOfString;
    int k;
    for (;;)
    {
      localObject2 = bu.U(this.KGx.KGV.split(","));
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().r((List)localObject2, true);
      localArrayList.add(localObject1);
      arrayOfString = x.ah((List)localObject2);
      localObject2 = x.ag((List)localObject2);
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
      this.KGG = new HashMap();
      break;
      label468:
      this.KGH = new SparseArray();
      break label102;
      label482:
      this.KGF = 2147483647;
      i = 0;
      break label233;
      label493:
      this.KGF = 2147483647;
      i = 0;
      break label233;
      label504:
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hM(bu.U(this.KGx.KGV.split(",")));
      break label284;
      label546:
      this.KGB = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label563:
    this.iYC = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    ae.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.iYC.getCount()), this.KGG.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label639:
    if (this.KGx.KGU)
    {
      this.KGE = 0;
      cR(this.KGE, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.KGx.KGX) && (this.KGx.KGY != null) && (!bu.isNullOrNil(this.KGx.KGY)))
      {
        localObject1 = bu.U(this.KGx.KGY.split(";"));
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hH((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.KGy = j;
          i = j + (i + 1);
          cR(this.KGy, "↑");
          j = i;
          if (this.KGx.KGS)
          {
            this.KGL.iB(this.fUR);
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.KGK);
            ((List)localObject1).addAll(this.KGJ);
            this.KGL.iz((List)localObject1);
            k = i;
            if (this.KGK.size() < 3)
            {
              localObject1 = this.KGL.fMe();
              j = ((Cursor)localObject1).getCount();
              this.KGI = j;
              if (j <= 0) {
                break label1390;
              }
              localArrayList.add(localObject1);
              this.KGA = i;
              k = i + (j + 1);
              cR(this.KGA, "↑");
              ae.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label945:
            j = k;
            if (this.KGJ.size() > 0)
            {
              j = k;
              if (this.KGK.size() < 41)
              {
                localObject1 = this.KGL.fMd();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1402;
                }
                localArrayList.add(localObject1);
                this.KGz = k;
                j = k + (i + 1);
                cR(this.KGz, "↑");
                ae.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1047:
          i = j;
          if (this.KGx.KGP)
          {
            if (this.KGx.KFj != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1414;
            }
            com.tencent.mm.kernel.g.ajS();
            localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hP(this.fUR);
            label1099:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1445;
            }
            this.KGB = j;
            i = j + (i + 1);
            cR(this.KGB, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().c(this.KGx.KFj, "", this.fUR);
        localArrayList.add(localObject1);
        arrayOfString = x.a(null, this.KGx.KFj, "", "", this.fUR);
        localObject2 = x.a(null, this.KGx.KFj, "", this.fUR, "");
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
        this.KGy = 2147483647;
        i = j;
        break;
        i = j;
        if (!this.KGx.KGO) {
          break;
        }
        localObject1 = h.iD(this.fUR);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.ytL = j;
          i = j + (i + 1);
          cR(this.ytL, "↑");
          break;
        }
        this.ytL = 2147483647;
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
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().hO(this.fUR);
        break label1099;
        label1445:
        this.KGB = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + arrayOfString.length);
      label1470:
      i = j;
      if (this.KGx.KGQ)
      {
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().d("@all.chatroom.contact", "", this.fUR);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1667;
        }
        this.KGC = j;
        i = j + (i + 1);
        cR(this.KGC, this.KJi.getActivity().getString(2131755178));
      }
      for (;;)
      {
        if (!this.KGx.KGR) {
          break label1676;
        }
        com.tencent.mm.kernel.g.ajS();
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().d("@verify.contact", "", this.fUR);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1678;
        }
        this.KGD = i;
        cR(this.KGD, this.KJi.getActivity().getString(2131762997));
        break;
        label1667:
        this.KGC = 2147483647;
        i = j;
      }
      label1676:
      break;
      label1678:
      this.KGD = 2147483647;
      break;
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(102818);
    Zq();
    AppMethodBeat.o(102818);
  }
  
  public final boolean aYm(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.KGL.aYp(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int aYn(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.KGG != null)
    {
      if (this.KGG.containsKey(paramString))
      {
        int i = ((Integer)this.KGG.get(paramString)).intValue();
        int j = this.KJi.getContentLV().getHeaderViewsCount();
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
    int k = this.KGF;
    int m = this.KGy;
    int n = this.ytL;
    int i1 = this.KGz;
    int i2 = this.KGA;
    int i3 = this.KGB;
    int i4 = this.KGC;
    int i5 = this.KGD;
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
    if (this.KGH.indexOfKey(j) >= 0)
    {
      AppMethodBeat.o(102819);
      return true;
    }
    AppMethodBeat.o(102819);
    return false;
  }
  
  public final int fLZ()
  {
    return this.KGI;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102817);
    super.finish();
    ae.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    com.tencent.mm.kernel.g.ajS();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this);
    AppMethodBeat.o(102817);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.iYC.getCount();
    if (this.KGH == null) {}
    for (int i = 0;; i = this.KGH.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  protected final a rk(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.KGF)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131763001));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGy)
    {
      localObject = cS(paramInt, this.KGx.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.ytL)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131762991));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGz)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131762998));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGA)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131762999));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGB)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131762985));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGC)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131755178));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGD)
    {
      localObject = cS(paramInt, this.KJi.getActivity().getString(2131762997));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.KGE)
    {
      localObject = new k(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.KGH.indexOfKey(paramInt) >= 0)
    {
      localObject = cS(paramInt, (String)this.KGH.get(paramInt));
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
      if (i > this.KGH.size()) {
        break;
      }
      j = i;
      if (this.KGH.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.iYC.moveToPosition(i))
    {
      ae.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new an();
      ((an)localObject).convertFrom(this.iYC);
      e locale = new e(paramInt);
      locale.contact = ((an)localObject);
      if (x.wb(((aw)localObject).field_username))
      {
        locale.KJj = false;
        locale.KJk = false;
        locale.KNa = false;
      }
      for (locale.KNp = true;; locale.KNp = false)
      {
        AppMethodBeat.o(102815);
        return locale;
        locale.KJj = dUh();
        locale.KJk = this.KJk;
      }
    }
    ae.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String KFj = "@all.contact.without.chatroom";
    public boolean KGO = false;
    public boolean KGP = false;
    public boolean KGQ = false;
    public boolean KGR = false;
    public boolean KGS = false;
    public boolean KGT = false;
    public boolean KGU = false;
    public String KGV;
    public String KGW;
    public boolean KGX = false;
    public String KGY = "";
    public String customHeader = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */