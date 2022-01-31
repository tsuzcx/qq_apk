package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  extends p
  implements n.b
{
  private c.a AaW;
  private int AaX;
  private int AaY;
  private int AaZ;
  private int Aba;
  private int Abb;
  private int Abc;
  private HashMap<String, Integer> Abd;
  private SparseArray<String> Abe;
  private Cursor gqa;
  private int qoX;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, c.a parama)
  {
    this(paramMMBaseSelectContactUI, paramList, true, paramBoolean, parama, false);
  }
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, c.a parama, boolean paramBoolean3)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.i(105190);
    this.AaX = 2147483647;
    this.qoX = 2147483647;
    this.AaY = 2147483647;
    this.AaZ = 2147483647;
    this.Aba = 2147483647;
    this.Abb = 2147483647;
    this.Abc = 2147483647;
    this.Abd = null;
    this.Abe = null;
    ab.i("MicroMsg.AlphabetContactAdapter", "create!");
    if (parama != null) {}
    for (this.AaW = parama;; this.AaW = new c.a())
    {
      com.tencent.mm.kernel.g.RM();
      ((j)com.tencent.mm.kernel.g.E(j.class)).YA().a(this);
      Kg();
      AppMethodBeat.o(105190);
      return;
    }
  }
  
  private void Kg()
  {
    AppMethodBeat.i(105191);
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    this.AaX = 2147483647;
    this.qoX = 2147483647;
    this.AaY = 2147483647;
    this.AaZ = 2147483647;
    this.Aba = 2147483647;
    this.Abc = 2147483647;
    label90:
    ArrayList localArrayList;
    Object localObject2;
    label210:
    Object localObject1;
    label261:
    int j;
    if (this.Abd != null)
    {
      this.Abd.clear();
      if (this.Abe == null) {
        break label441;
      }
      this.Abe.clear();
      localArrayList = new ArrayList();
      if (!this.AaW.Abj) {
        break label581;
      }
      com.tencent.mm.kernel.g.RM();
      localObject2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().m(bo.P(this.AaW.Abm.split(",")), false);
      localArrayList.add(localObject2);
      i = ((Cursor)localObject2).getCount();
      ab.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label455;
      }
      this.Abc = 0;
      bL(this.Abc, "☆");
      i = i + 1 + 0;
      if (this.AaW.zZK != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
        break label466;
      }
      com.tencent.mm.kernel.g.RM();
      localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eJ(bo.P(this.AaW.Abl.split(",")));
      localArrayList.add(localObject1);
      j = ((Cursor)localObject1).getCount();
      if (j <= 0) {
        break label508;
      }
      this.AaY = i;
      i += j + 1;
      bL(this.AaY, "☆");
    }
    Object localObject3;
    int k;
    for (;;)
    {
      localObject3 = bo.P(this.AaW.Abl.split(","));
      com.tencent.mm.kernel.g.RM();
      localArrayList.add(((j)com.tencent.mm.kernel.g.E(j.class)).YA().m((List)localObject3, true));
      localObject1 = t.T((List)localObject3);
      localObject3 = t.S((List)localObject3);
      if ((localObject1 == null) || (localObject3 == null)) {
        break label525;
      }
      k = 0;
      j = i;
      i = k;
      while (i < localObject1.length)
      {
        k = j;
        if (i < localObject3.length)
        {
          bL(localObject3[i] + j, localObject1[i]);
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      this.Abd = new HashMap();
      break;
      label441:
      this.Abe = new SparseArray();
      break label90;
      label455:
      this.Abc = 2147483647;
      i = 0;
      break label210;
      label466:
      com.tencent.mm.kernel.g.RM();
      localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eI(bo.P(this.AaW.Abl.split(",")));
      break label261;
      label508:
      this.AaY = 2147483647;
    }
    ((Cursor)localObject2).getCount();
    label525:
    ab.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", new Object[] { this.Abd.toString() });
    this.gqa = new MergeCursor((Cursor[])localArrayList.toArray(new Cursor[0]));
    notifyDataSetChanged();
    AppMethodBeat.o(105191);
    return;
    label581:
    if (this.AaW.Abk)
    {
      this.Abb = 0;
      bL(this.Abb, "nonLimit");
    }
    for (int i = 1;; i = 0)
    {
      if ((this.AaW.Abn) && (this.AaW.Abo != null) && (!bo.isNullOrNil(this.AaW.Abo)))
      {
        localObject1 = bo.P(this.AaW.Abo.split(";"));
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eE((List)localObject1);
        localArrayList.add(localObject1);
        j = ((Cursor)localObject1).getCount();
        if (j > 0)
        {
          this.AaX = i;
          j = i + (j + 1);
          bL(this.AaX, "↑");
          i = j;
          if (this.AaW.Abg)
          {
            if (this.AaW.zZK != "@all.contact.without.chatroom.without.openim.without.openimfavour") {
              break label1067;
            }
            com.tencent.mm.kernel.g.RM();
            localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eL(this.ejc);
            label779:
            localArrayList.add(localObject1);
            i = ((Cursor)localObject1).getCount();
            if (i <= 0) {
              break label1098;
            }
            this.AaY = j;
            i = j + (i + 1);
            bL(this.AaY, "☆");
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().c(this.AaW.zZK, "", this.ejc);
        localArrayList.add(localObject1);
        localObject2 = t.a(this.AaW.zZK, "", "", this.ejc);
        localObject3 = t.a(this.AaW.zZK, "", this.ejc, "");
        j = i;
        if (localObject2 == null) {
          break label1123;
        }
        j = i;
        if (localObject3 == null) {
          break label1123;
        }
        j = 0;
        int m;
        for (k = i; j < localObject2.length; k = m)
        {
          m = k;
          if (j < localObject3.length)
          {
            bL(localObject3[j] + k, localObject2[j]);
            m = k + 1;
          }
          j += 1;
        }
        this.AaX = 2147483647;
        j = i;
        break;
        j = i;
        if (!this.AaW.Abf) {
          break;
        }
        localObject1 = g.fu(this.ejc);
        localArrayList.add(localObject1);
        j = ((Cursor)localObject1).getCount();
        if (j > 0)
        {
          this.qoX = i;
          j = i + (j + 1);
          bL(this.qoX, "↑");
          break;
        }
        this.qoX = 2147483647;
        j = i;
        break;
        label1067:
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().eK(this.ejc);
        break label779;
        label1098:
        this.AaY = 2147483647;
        i = j;
      }
      j = i + (((Cursor)localObject1).getCount() + localObject2.length);
      label1123:
      i = j;
      if (this.AaW.Abh)
      {
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().d("@all.chatroom.contact", "", this.ejc);
        localArrayList.add(localObject1);
        i = ((Cursor)localObject1).getCount();
        if (i <= 0) {
          break label1320;
        }
        this.AaZ = j;
        i = j + (i + 1);
        bL(this.AaZ, this.Adk.getActivity().getString(2131296450));
      }
      for (;;)
      {
        if (!this.AaW.Abi) {
          break label1329;
        }
        com.tencent.mm.kernel.g.RM();
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().d("@verify.contact", "", this.ejc);
        localArrayList.add(localObject1);
        if (((Cursor)localObject1).getCount() <= 0) {
          break label1331;
        }
        this.Aba = i;
        bL(this.Aba, this.Adk.getActivity().getString(2131303053));
        break;
        label1320:
        this.AaZ = 2147483647;
        i = j;
      }
      label1329:
      break;
      label1331:
      this.Aba = 2147483647;
      break;
    }
  }
  
  private void bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(105192);
    this.Abd.put(paramString, Integer.valueOf(paramInt));
    this.Abe.put(paramInt, paramString);
    AppMethodBeat.o(105192);
  }
  
  private static a bM(int paramInt, String paramString)
  {
    AppMethodBeat.i(105196);
    h localh = new h(paramInt);
    localh.mZq = paramString;
    AppMethodBeat.o(105196);
    return localh;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(105198);
    Kg();
    notifyDataSetChanged();
    AppMethodBeat.o(105198);
  }
  
  public final int aux(String paramString)
  {
    AppMethodBeat.i(105193);
    if (paramString.equals("↑"))
    {
      AppMethodBeat.o(105193);
      return 0;
    }
    if (this.Abd != null)
    {
      if (this.Abd.containsKey(paramString))
      {
        int i = ((Integer)this.Abd.get(paramString)).intValue();
        int j = this.Adk.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(105193);
        return i + j;
      }
      AppMethodBeat.o(105193);
      return -1;
    }
    AppMethodBeat.o(105193);
    return -1;
  }
  
  protected final boolean c(a parama)
  {
    AppMethodBeat.i(105199);
    int j = parama.position + 1;
    int k = this.Abc;
    int m = this.AaX;
    int n = this.qoX;
    int i1 = this.AaY;
    int i2 = this.AaZ;
    int i3 = this.Aba;
    int i = 0;
    while (i < 6)
    {
      if (j == new int[] { k, m, n, i1, i2, i3 }[i])
      {
        AppMethodBeat.o(105199);
        return true;
      }
      i += 1;
    }
    if (this.Abe.indexOfKey(j) >= 0)
    {
      AppMethodBeat.o(105199);
      return true;
    }
    AppMethodBeat.o(105199);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105197);
    super.finish();
    ab.i("MicroMsg.AlphabetContactAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    com.tencent.mm.kernel.g.RM();
    ((j)com.tencent.mm.kernel.g.E(j.class)).YA().b(this);
    AppMethodBeat.o(105197);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105194);
    int j = this.gqa.getCount();
    if (this.Abd == null) {}
    for (int i = 0;; i = this.Abd.size())
    {
      AppMethodBeat.o(105194);
      return i + j;
    }
  }
  
  protected final a mM(int paramInt)
  {
    AppMethodBeat.i(105195);
    Object localObject;
    if (paramInt == this.Abc)
    {
      localObject = bM(paramInt, this.Adk.getActivity().getString(2131303055));
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.AaX)
    {
      localObject = bM(paramInt, this.AaW.Abp);
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.qoX)
    {
      localObject = bM(paramInt, this.Adk.getActivity().getString(2131303047));
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.AaY)
    {
      localObject = bM(paramInt, this.Adk.getActivity().getString(2131303041));
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.AaZ)
    {
      localObject = bM(paramInt, this.Adk.getActivity().getString(2131296450));
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.Aba)
    {
      localObject = bM(paramInt, this.Adk.getActivity().getString(2131303053));
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (paramInt == this.Abb)
    {
      localObject = new k(paramInt);
      AppMethodBeat.o(105195);
      return localObject;
    }
    if (this.Abe.indexOfKey(paramInt) >= 0)
    {
      localObject = bM(paramInt, (String)this.Abe.get(paramInt));
      AppMethodBeat.o(105195);
      return localObject;
    }
    int k = paramInt;
    int i = 0;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.Abe.size()) {
        break;
      }
      j = i;
      if (this.Abe.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.gqa.moveToPosition(i))
    {
      ab.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new ad();
      ((ad)localObject).convertFrom(this.gqa);
      e locale = new e(paramInt);
      locale.contact = ((ad)localObject);
      locale.Adl = cni();
      locale.Adm = this.Adm;
      AppMethodBeat.o(105195);
      return locale;
    }
    ab.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(105195);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.c
 * JD-Core Version:    0.7.0.1
 */