package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements MStorageEx.IOnStorageChange
{
  private int CuC;
  private int PTA;
  private int PTB;
  private int PTC;
  private HashMap<String, Integer> PTD;
  private SparseArray<String> PTE;
  private int PTF;
  private List<String> PTG;
  private List<String> PTH;
  g PTI;
  private List<String> PTJ;
  private List<ah> PTK;
  private a PTu;
  private int PTv;
  private int PTw;
  private int PTx;
  private int PTy;
  private int PTz;
  private Cursor jWh;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(102809);
    this.PTv = 2147483647;
    this.CuC = 2147483647;
    this.PTw = 2147483647;
    this.PTx = 2147483647;
    this.PTy = 2147483647;
    this.PTz = 2147483647;
    this.PTA = 2147483647;
    this.PTB = 2147483647;
    this.PTC = 2147483647;
    this.PTD = null;
    this.PTE = null;
    this.PTF = 0;
    this.PTI = new g();
    this.PTJ = null;
    this.PTK = null;
    Log.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.PTu = parama;; this.PTu = new a())
    {
      this.PTH = paramList1;
      this.PTG = paramList2;
      com.tencent.mm.kernel.g.aAi();
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().add(this);
      and();
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
  
  private void dm(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.PTD.put(paramString, Integer.valueOf(paramInt));
    this.PTE.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  private static a dn(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    com.tencent.mm.ui.contact.a.h localh = new com.tencent.mm.ui.contact.a.h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(102816);
    return localh;
  }
  
  public final void and()
  {
    Object localObject2 = null;
    AppMethodBeat.i(102811);
    Log.i("MicroMsg.AlphabetContactAdapter", "resetData");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    this.PTv = 2147483647;
    this.CuC = 2147483647;
    this.PTw = 2147483647;
    this.PTx = 2147483647;
    this.PTy = 2147483647;
    this.PTz = 2147483647;
    this.PTA = 2147483647;
    this.PTC = 2147483647;
    label112:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.PTD != null)
    {
      this.PTD.clear();
      if (this.PTE == null) {
        break label478;
      }
      this.PTE.clear();
      localArrayList = new ArrayList();
      if (!this.PTu.PTQ) {
        break label649;
      }
      localObject1 = Util.stringToList(this.PTu.PTU, ",");
      if (((List)localObject1).isEmpty()) {
        break label503;
      }
      com.tencent.mm.kernel.g.aAi();
      localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().x((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      Log.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label492;
      }
      this.PTC = 0;
      dm(this.PTC, "☆");
      i = i + 1 + 0;
      label243:
      if (this.PTu.PSf != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label514;
      }
      com.tencent.mm.kernel.g.aAi();
      localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().iR(Util.stringsToList(this.PTu.PTT.split(",")));
      label294:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label556;
      }
      this.PTy = i;
      i += j + 1;
      dm(this.PTy, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = Util.stringsToList(this.PTu.PTT.split(","));
      com.tencent.mm.kernel.g.aAi();
      localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().x((List)localObject3, true);
      localArrayList.add(localObject1);
      localObject2 = ab.aq((List)localObject3);
      localObject3 = ab.ap((List)localObject3);
      if ((localObject2 == null) || (localObject3 == null)) {
        break label573;
      }
      k = 0;
      j = i;
      i = k;
      while (i < localObject2.length)
      {
        k = j;
        if (i < localObject3.length)
        {
          dm(localObject3[i] + j, localObject2[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.PTD = new HashMap();
      break;
      label478:
      this.PTE = new SparseArray();
      break label112;
      label492:
      this.PTC = 2147483647;
      i = 0;
      break label243;
      label503:
      this.PTC = 2147483647;
      i = 0;
      break label243;
      label514:
      com.tencent.mm.kernel.g.aAi();
      localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().iQ(Util.stringsToList(this.PTu.PTT.split(",")));
      break label294;
      label556:
      this.PTy = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label573:
    this.jWh = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    Log.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.jWh.getCount()), this.PTD.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label649:
    if (this.PTu.PTR)
    {
      this.PTB = 0;
      dm(this.PTB, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.PTu.PTV) && (this.PTu.PTW != null) && (!Util.isNullOrNil(this.PTu.PTW)))
      {
        localObject1 = Util.stringsToList(this.PTu.PTW.split(";"));
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().iL((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.PTv = j;
          i = j + (i + 1);
          dm(this.PTv, "↑");
          j = i;
          if (this.PTu.PTP)
          {
            this.PTI.jE(this.gzY);
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.PTH);
            ((List)localObject1).addAll(this.PTG);
            this.PTI.jC((List)localObject1);
            k = i;
            if (this.PTH.size() < 3)
            {
              localObject1 = this.PTI.gUy();
              j = ((Cursor)localObject1).getCount();
              this.PTF = j;
              if (j <= 0) {
                break label1474;
              }
              localArrayList.add(localObject1);
              this.PTx = i;
              k = i + (j + 1);
              dm(this.PTx, "↑");
              Log.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label955:
            j = k;
            if (this.PTG.size() > 0)
            {
              j = k;
              if (this.PTH.size() < 41)
              {
                localObject1 = this.PTI.gUx();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1486;
                }
                localArrayList.add(localObject1);
                this.PTw = k;
                j = k + (i + 1);
                dm(this.PTw, "↑");
                Log.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1057:
          i = j;
          if (this.PTu.PTM)
          {
            Log.i("MicroMsg.AlphabetContactAdapter", "option.filterType = " + this.PTu.PSf);
            if (this.PTu.PSf != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1498;
            }
            Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursorWithoutOpenIM");
            com.tencent.mm.kernel.g.aAi();
            localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().iT(this.gzY);
            label1145:
            localArrayList.add(localObject1);
            long l = System.currentTimeMillis();
            Log.i("MicroMsg.AlphabetContactAdapter", "before favContactCursor.getCount");
            i = ((Cursor)localObject1).getCount();
            Log.i("MicroMsg.AlphabetContactAdapter", "favContactCursor.getCount duration = " + (System.currentTimeMillis() - l));
            if (i <= 0) {
              break label1537;
            }
            this.PTy = j;
            i = j + (i + 1);
            dm(this.PTy, "☆");
          }
        }
      }
      label1228:
      int m;
      for (;;)
      {
        if (this.PTu.PTS)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(this.PTu.PTX)) {
            localObject1 = Util.stringToList(this.PTu.PTX, ",");
          }
          com.tencent.mm.kernel.g.aAi();
          localObject2 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().x((List)localObject1, true);
          localArrayList.add(localObject2);
          localObject3 = ab.aq((List)localObject1);
          localObject1 = ab.ap((List)localObject1);
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
                    dm(localObject1[j] + k, localObject3[j]);
                    m = k + 1;
                  }
                  j += 1;
                  k = m;
                  continue;
                  this.PTv = 2147483647;
                  i = j;
                  break;
                  i = j;
                  if (!this.PTu.PTL) {
                    break;
                  }
                  localObject1 = h.jG(this.gzY);
                  localArrayList.add(localObject1);
                  i = ((Cursor)localObject1).getCount();
                  if (i > 0)
                  {
                    this.CuC = j;
                    i = j + (i + 1);
                    dm(this.CuC, "↑");
                    break;
                  }
                  this.CuC = 2147483647;
                  i = j;
                  break;
                  label1474:
                  ((Cursor)localObject1).close();
                  k = i;
                  break label955;
                  label1486:
                  ((Cursor)localObject1).close();
                  j = k;
                  break label1057;
                  label1498:
                  Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursor");
                  com.tencent.mm.kernel.g.aAi();
                  localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().iS(this.gzY);
                  break label1145;
                  label1537:
                  this.PTy = 2147483647;
                  i = j;
                  break label1228;
                }
              }
              j = i + (((Cursor)localObject2).getCount() + localObject3.length);
            }
          }
          label1562:
          i = j;
          if (this.PTu.PTN)
          {
            com.tencent.mm.kernel.g.aAi();
            localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().d("@all.chatroom.contact", "", this.gzY);
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1934;
            }
            this.PTz = j;
            i = j + (i + 1);
            dm(this.PTz, this.PWg.getActivity().getString(2131755196));
          }
        }
      }
      for (;;)
      {
        if (!this.PTu.PTO) {
          break label1943;
        }
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().d("@verify.contact", "", this.gzY);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1945;
        }
        this.PTA = i;
        dm(this.PTA, this.PWg.getActivity().getString(2131765134));
        break;
        com.tencent.mm.kernel.g.aAi();
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(this.PTu.PSf, "", this.gzY);
        localArrayList.add(localObject1);
        localObject2 = ab.a(null, this.PTu.PSf, "", "", this.gzY);
        localObject3 = ab.a(null, this.PTu.PSf, "", this.gzY, "");
        j = i;
        if (localObject2 == null) {
          break label1562;
        }
        j = i;
        if (localObject3 == null) {
          break label1562;
        }
        j = 0;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            dm(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        j = i + (((Cursor)localObject1).getCount() + localObject2.length);
        break label1562;
        label1934:
        this.PTz = 2147483647;
        i = j;
      }
      label1943:
      break;
      label1945:
      this.PTA = 2147483647;
      break;
    }
  }
  
  public final boolean bnq(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.PTI.bnt(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int bnr(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.PTD != null)
    {
      if (this.PTD.containsKey(paramString))
      {
        int i = ((Integer)this.PTD.get(paramString)).intValue();
        int j = this.PWg.getContentLV().getHeaderViewsCount();
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
    int k = this.PTC;
    int m = this.PTv;
    int n = this.CuC;
    int i1 = this.PTw;
    int i2 = this.PTx;
    int i3 = this.PTy;
    int i4 = this.PTz;
    int i5 = this.PTA;
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
    if (this.PTE.indexOfKey(j) >= 0)
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
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    com.tencent.mm.kernel.g.aAi();
    ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().remove(this);
    AppMethodBeat.o(102817);
  }
  
  public final int gUt()
  {
    return this.PTF;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.jWh.getCount();
    if (this.PTE == null) {}
    for (int i = 0;; i = this.PTE.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
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
      com.tencent.mm.kernel.g.aAi();
      paramMStorageEx = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjF(paramObject.toString());
      if ((paramMStorageEx != null) && (com.tencent.mm.contact.c.oR(paramMStorageEx.field_type))) {
        and();
      }
    }
    AppMethodBeat.o(102818);
  }
  
  protected final a va(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.PTC)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765138));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTv)
    {
      localObject = dn(paramInt, this.PTu.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.CuC)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765128));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTw)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765135));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTx)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765136));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTy)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765122));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTz)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131755196));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTA)
    {
      localObject = dn(paramInt, this.PWg.getActivity().getString(2131765134));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.PTB)
    {
      localObject = new k(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.PTE.indexOfKey(paramInt) >= 0)
    {
      localObject = dn(paramInt, (String)this.PTE.get(paramInt));
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
      if (i > this.PTE.size()) {
        break;
      }
      j = i;
      if (this.PTE.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.jWh.moveToPosition(i))
    {
      Log.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new as();
      ((as)localObject).convertFrom(this.jWh);
      e locale = new e(paramInt);
      locale.contact = ((as)localObject);
      if (!Util.isNullOrNil(this.PTu.dFl)) {
        locale.dFl = this.PTu.dFl;
      }
      if (ab.Eq(((ax)localObject).field_username))
      {
        locale.PWh = false;
        locale.PWi = false;
        locale.Qaa = false;
      }
      for (locale.Qap = true;; locale.Qap = false)
      {
        AppMethodBeat.o(102815);
        return locale;
        locale.PWh = eWh();
        locale.PWi = this.PWi;
      }
    }
    Log.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String PSf = "@all.contact.without.chatroom";
    public boolean PTL = false;
    public boolean PTM = false;
    public boolean PTN = false;
    public boolean PTO = false;
    public boolean PTP = false;
    public boolean PTQ = false;
    public boolean PTR = false;
    public boolean PTS = false;
    public String PTT;
    public String PTU;
    public boolean PTV = false;
    public String PTW = "";
    public String PTX = "";
    public String customHeader = "";
    public String dFl = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */