package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends r
  implements MStorageEx.IOnStorageChange
{
  private int Isp;
  private a Xqf;
  private int Xqg;
  private int Xqh;
  private int Xqi;
  private int Xqj;
  private int Xqk;
  private int Xql;
  private int Xqm;
  private int Xqn;
  private HashMap<String, Integer> Xqo;
  private SparseArray<String> Xqp;
  private int Xqq;
  private List<String> Xqr;
  private List<String> Xqs;
  g Xqt;
  private List<String> Xqu;
  private List<ah> Xqv;
  private Cursor mNt;
  public boolean xUe;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList1, List<String> paramList2, List<String> paramList3, boolean paramBoolean1, boolean paramBoolean2, a parama, boolean paramBoolean3, boolean paramBoolean4)
  {
    super(paramMMBaseSelectContactUI, paramList3, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(187397);
    this.Xqg = 2147483647;
    this.Isp = 2147483647;
    this.Xqh = 2147483647;
    this.Xqi = 2147483647;
    this.Xqj = 2147483647;
    this.Xqk = 2147483647;
    this.Xql = 2147483647;
    this.Xqm = 2147483647;
    this.Xqn = 2147483647;
    this.Xqo = null;
    this.Xqp = null;
    this.Xqq = 0;
    this.xUe = false;
    this.Xqt = new g();
    this.Xqu = null;
    this.Xqv = null;
    this.xUe = paramBoolean4;
    Log.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.Xqf = parama;; this.Xqf = new a())
    {
      this.Xqs = paramList1;
      this.Xqr = paramList2;
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
      ate();
      AppMethodBeat.o(187397);
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
  
  private void dl(int paramInt, String paramString)
  {
    AppMethodBeat.i(102812);
    this.Xqo.put(paramString, Integer.valueOf(paramInt));
    this.Xqp.put(paramInt, paramString);
    AppMethodBeat.o(102812);
  }
  
  private a dm(int paramInt, String paramString)
  {
    AppMethodBeat.i(102816);
    j localj = new j(paramInt);
    localj.header = paramString;
    localj.xUe = this.xUe;
    AppMethodBeat.o(102816);
    return localj;
  }
  
  public final void ate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(102811);
    Log.i("MicroMsg.AlphabetContactAdapter", "resetData");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    this.Xqg = 2147483647;
    this.Isp = 2147483647;
    this.Xqh = 2147483647;
    this.Xqi = 2147483647;
    this.Xqj = 2147483647;
    this.Xqk = 2147483647;
    this.Xql = 2147483647;
    this.Xqn = 2147483647;
    label112:
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (this.Xqo != null)
    {
      this.Xqo.clear();
      if (this.Xqp == null) {
        break label478;
      }
      this.Xqp.clear();
      localArrayList = new ArrayList();
      if (!this.Xqf.XqB) {
        break label649;
      }
      localObject1 = Util.stringToList(this.Xqf.XqF, ",");
      if (((List)localObject1).isEmpty()) {
        break label503;
      }
      com.tencent.mm.kernel.h.aHH();
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().z((List)localObject1, false);
      localArrayList.add(localObject1);
      i = ((Cursor)localObject1).getCount();
      Log.d("MicroMsg.AlphabetContactAdapter", "sport recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label492;
      }
      this.Xqn = 0;
      dl(this.Xqn, "☆");
      i = i + 1 + 0;
      label243:
      if (this.Xqf.XoS != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label514;
      }
      com.tencent.mm.kernel.h.aHH();
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jJ(Util.stringsToList(this.Xqf.XqE.split(",")));
      label294:
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label556;
      }
      this.Xqj = i;
      i += j + 1;
      dl(this.Xqj, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = Util.stringsToList(this.Xqf.XqE.split(","));
      com.tencent.mm.kernel.h.aHH();
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().z((List)localObject3, true);
      localArrayList.add(localObject1);
      localObject2 = ab.ao((List)localObject3);
      localObject3 = ab.an((List)localObject3);
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
          dl(localObject3[i] + j, localObject2[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.Xqo = new HashMap();
      break;
      label478:
      this.Xqp = new SparseArray();
      break label112;
      label492:
      this.Xqn = 2147483647;
      i = 0;
      break label243;
      label503:
      this.Xqn = 2147483647;
      i = 0;
      break label243;
      label514:
      com.tencent.mm.kernel.h.aHH();
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jI(Util.stringsToList(this.Xqf.XqE.split(",")));
      break label294;
      label556:
      this.Xqj = 2147483647;
    }
    ((Cursor)localObject1).getCount();
    label573:
    this.mNt = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    Log.i("MicroMsg.AlphabetContactAdapter", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.mNt.getCount()), this.Xqo.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(102811);
    return;
    label649:
    if (this.Xqf.XqC)
    {
      this.Xqm = 0;
      dl(this.Xqm, "nonLimit");
    }
    for (int j = 1;; j = 0)
    {
      if ((this.Xqf.XqG) && (this.Xqf.XqH != null) && (!Util.isNullOrNil(this.Xqf.XqH)))
      {
        localObject1 = Util.stringsToList(this.Xqf.XqH.split(";"));
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jD((List)localObject1);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i > 0)
        {
          this.Xqg = j;
          i = j + (i + 1);
          dl(this.Xqg, "↑");
          j = i;
          if (this.Xqf.XqA)
          {
            this.Xqt.kz(csq());
            localObject1 = new LinkedList();
            ((List)localObject1).addAll(this.Xqs);
            ((List)localObject1).addAll(this.Xqr);
            this.Xqt.kx((List)localObject1);
            k = i;
            if (this.Xqs.size() < 3)
            {
              localObject1 = this.Xqt.hUr();
              j = ((Cursor)localObject1).getCount();
              this.Xqq = j;
              if (j <= 0) {
                break label1482;
              }
              localArrayList.add(localObject1);
              this.Xqi = i;
              k = i + (j + 1);
              dl(this.Xqi, "↑");
              Log.i("MicroMsg.AlphabetContactAdapter", "add recommend group cursor %s", new Object[] { Integer.valueOf(j) });
            }
            label955:
            j = k;
            if (this.Xqr.size() > 0)
            {
              j = k;
              if (this.Xqs.size() < 41)
              {
                localObject1 = this.Xqt.hUq();
                i = ((Cursor)localObject1).getCount();
                if (i <= 0) {
                  break label1494;
                }
                localArrayList.add(localObject1);
                this.Xqh = k;
                j = k + (i + 1);
                dl(this.Xqh, "↑");
                Log.i("MicroMsg.AlphabetContactAdapter", "add recommend contact cursor %s", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          label1057:
          i = j;
          if (this.Xqf.Xqx)
          {
            Log.i("MicroMsg.AlphabetContactAdapter", "option.filterType = " + this.Xqf.XoS);
            if (this.Xqf.XoS != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1506;
            }
            Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursorWithoutOpenIM");
            com.tencent.mm.kernel.h.aHH();
            localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jL(csq());
            label1145:
            localArrayList.add(localObject1);
            long l = System.currentTimeMillis();
            Log.i("MicroMsg.AlphabetContactAdapter", "before favContactCursor.getCount");
            i = ((Cursor)localObject1).getCount();
            Log.i("MicroMsg.AlphabetContactAdapter", "favContactCursor.getCount duration = " + (System.currentTimeMillis() - l));
            if (i <= 0) {
              break label1545;
            }
            this.Xqj = j;
            i = j + (i + 1);
            dl(this.Xqj, "☆");
          }
        }
      }
      label1228:
      int m;
      for (;;)
      {
        if (this.Xqf.XqD)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(this.Xqf.XqI)) {
            localObject1 = Util.stringToList(this.Xqf.XqI, ",");
          }
          if (!Util.isNullOrNil((List)localObject1))
          {
            com.tencent.mm.kernel.h.aHH();
            localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().z((List)localObject1, true);
            localArrayList.add(localObject2);
            localObject3 = ab.ao((List)localObject1);
            localObject1 = ab.an((List)localObject1);
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
                      dl(localObject1[j] + k, localObject3[j]);
                      m = k + 1;
                    }
                    j += 1;
                    k = m;
                    continue;
                    this.Xqg = 2147483647;
                    i = j;
                    break;
                    i = j;
                    if (!this.Xqf.Xqw) {
                      break;
                    }
                    localObject1 = h.kB(csq());
                    localArrayList.add(localObject1);
                    i = ((Cursor)localObject1).getCount();
                    if (i > 0)
                    {
                      this.Isp = j;
                      i = j + (i + 1);
                      dl(this.Isp, "↑");
                      break;
                    }
                    this.Isp = 2147483647;
                    i = j;
                    break;
                    label1482:
                    ((Cursor)localObject1).close();
                    k = i;
                    break label955;
                    label1494:
                    ((Cursor)localObject1).close();
                    j = k;
                    break label1057;
                    label1506:
                    Log.i("MicroMsg.AlphabetContactAdapter", "getFavCursor");
                    com.tencent.mm.kernel.h.aHH();
                    localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jK(csq());
                    break label1145;
                    label1545:
                    this.Xqj = 2147483647;
                    i = j;
                    break label1228;
                  }
                }
                j = i + (((Cursor)localObject2).getCount() + localObject3.length);
              }
            }
            label1570:
            i = j;
            if (this.Xqf.Xqy)
            {
              com.tencent.mm.kernel.h.aHH();
              localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().e("@all.chatroom.contact", "", csq());
              localArrayList.add(localObject1);
              i = ((Cursor)localObject1).getCount();
              if (i <= 0) {
                break label1979;
              }
              this.Xqk = j;
              i = j + (i + 1);
              dl(this.Xqk, this.XsW.getActivity().getString(a.h.address_chatroom_contact_nick));
            }
          }
        }
      }
      for (;;)
      {
        if (!this.Xqf.Xqz) {
          break label1988;
        }
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().e("@verify.contact", "", csq());
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1990;
        }
        this.Xql = i;
        dl(this.Xql, this.XsW.getActivity().getString(a.h.select_contact_official_accounts_title));
        break;
        localArrayList.add(new com.tencent.mm.storagebase.d());
        j = i;
        break label1570;
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL();
        localObject2 = this.Xqf.XoS;
        localObject3 = csq();
        hVe();
        localObject1 = ((bv)localObject1).d((String)localObject2, "", (List)localObject3);
        localArrayList.add(localObject1);
        localObject2 = ab.a(null, this.Xqf.XoS, "", "", csq());
        localObject3 = ab.a(null, this.Xqf.XoS, "", csq(), "");
        j = i;
        if (localObject2 == null) {
          break label1570;
        }
        j = i;
        if (localObject3 == null) {
          break label1570;
        }
        j = 0;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            dl(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        j = i + (((Cursor)localObject1).getCount() + localObject2.length);
        break label1570;
        label1979:
        this.Xqk = 2147483647;
        i = j;
      }
      label1988:
      break;
      label1990:
      this.Xql = 2147483647;
      break;
    }
  }
  
  public final boolean bzQ(String paramString)
  {
    AppMethodBeat.i(102810);
    boolean bool = this.Xqt.bzT(paramString);
    AppMethodBeat.o(102810);
    return bool;
  }
  
  public final int bzR(String paramString)
  {
    AppMethodBeat.i(102813);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(102813);
      return 0;
    }
    if (this.Xqo != null)
    {
      if (this.Xqo.containsKey(paramString))
      {
        int i = ((Integer)this.Xqo.get(paramString)).intValue();
        int j = this.XsW.getContentLV().getHeaderViewsCount();
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
    int k = this.Xqn;
    int m = this.Xqg;
    int n = this.Isp;
    int i1 = this.Xqh;
    int i2 = this.Xqi;
    int i3 = this.Xqj;
    int i4 = this.Xqk;
    int i5 = this.Xql;
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
    if (this.Xqp.indexOfKey(j) >= 0)
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
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    com.tencent.mm.kernel.h.aHH();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    AppMethodBeat.o(102817);
  }
  
  public final int getContactCount()
  {
    AppMethodBeat.i(187418);
    if (this.mNt != null)
    {
      int i = this.mNt.getCount();
      AppMethodBeat.o(187418);
      return i;
    }
    AppMethodBeat.o(187418);
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102814);
    int j = this.mNt.getCount();
    if (this.Xqp == null) {}
    for (int i = 0;; i = this.Xqp.size())
    {
      AppMethodBeat.o(102814);
      return i + j;
    }
  }
  
  public final int hUm()
  {
    return this.Xqq;
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
      com.tencent.mm.kernel.h.aHH();
      paramMStorageEx = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwc(paramObject.toString());
      if ((paramMStorageEx != null) && (com.tencent.mm.contact.d.rk(paramMStorageEx.field_type))) {
        ate();
      }
    }
    AppMethodBeat.o(102818);
  }
  
  protected final a ye(int paramInt)
  {
    AppMethodBeat.i(102815);
    Object localObject;
    if (paramInt == this.Xqn)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_wechat_sport_recent_like_contact_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqg)
    {
      localObject = dm(paramInt, this.Xqf.customHeader);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Isp)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_near_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqh)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_recommend_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqi)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_recommend_group_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqj)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_favour_contact_catalog_name));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqk)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.address_chatroom_contact_nick));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xql)
    {
      localObject = dm(paramInt, this.XsW.getActivity().getString(a.h.select_contact_official_accounts_title));
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (paramInt == this.Xqm)
    {
      localObject = new m(paramInt);
      AppMethodBeat.o(102815);
      return localObject;
    }
    if (this.Xqp.indexOfKey(paramInt) >= 0)
    {
      localObject = dm(paramInt, (String)this.Xqp.get(paramInt));
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
      if (i > this.Xqp.size()) {
        break;
      }
      j = i;
      if (this.Xqp.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.mNt.moveToPosition(i))
    {
      Log.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new as();
      ((as)localObject).convertFrom(this.mNt);
      f localf = new f(paramInt);
      localf.contact = ((as)localObject);
      if (!Util.isNullOrNil(this.Xqf.fxT)) {
        localf.fxT = this.Xqf.fxT;
      }
      if (ab.Lj(((ax)localObject).field_username))
      {
        localf.XsX = false;
        localf.XsY = false;
        localf.Xxs = false;
      }
      for (localf.XxM = true;; localf.XxM = false)
      {
        localf.xUe = this.xUe;
        AppMethodBeat.o(102815);
        return localf;
        localf.XsX = fJk();
        localf.XsY = hUO();
      }
    }
    Log.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(102815);
    return null;
  }
  
  public static final class a
  {
    public String XoS = "@all.contact.without.chatroom";
    public boolean XqA = false;
    public boolean XqB = false;
    public boolean XqC = false;
    public boolean XqD = false;
    public String XqE;
    public String XqF;
    public boolean XqG = false;
    public String XqH = "";
    public String XqI = "";
    public boolean Xqw = false;
    public boolean Xqx = false;
    public boolean Xqy = false;
    public boolean Xqz = false;
    public String customHeader = "";
    public String fxT = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */