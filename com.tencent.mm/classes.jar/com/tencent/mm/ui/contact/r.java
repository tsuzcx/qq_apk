package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class r
  extends n
{
  protected int AaZ;
  private int Aba;
  private List<String> AdC;
  private int AdD;
  private int AdE;
  private int AdF;
  private boolean AdG;
  private int AdH;
  private boolean AdI;
  private int AdJ;
  private List<com.tencent.mm.plugin.fts.a.a.l> AdK;
  private List<com.tencent.mm.plugin.fts.a.a.l> AdL;
  private List<Integer> AdM;
  private com.tencent.mm.plugin.fts.a.l AdN;
  protected com.tencent.mm.plugin.fts.a.l AdO;
  private int count;
  private ak handler;
  private com.tencent.mm.plugin.fts.a.a.g mRX;
  private com.tencent.mm.plugin.fts.a.a.a mSV;
  protected List<com.tencent.mm.plugin.fts.a.a.l> mVt;
  private List<com.tencent.mm.plugin.fts.a.a.l> oBz;
  protected String query;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    AppMethodBeat.i(105233);
    this.AdD = 2147483647;
    this.AdE = 2147483647;
    this.AdF = 2147483647;
    this.AdG = true;
    this.AdH = 2147483647;
    this.AaZ = 2147483647;
    this.AdI = true;
    this.AdJ = 2147483647;
    this.Aba = 2147483647;
    this.AdK = null;
    this.oBz = null;
    this.mVt = null;
    this.AdL = null;
    this.handler = new ak(Looper.getMainLooper());
    this.AdN = new r.1(this);
    this.AdO = new r.2(this);
    this.count = 0;
    this.AdC = paramList;
    this.AdM = new ArrayList();
    ab.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Kc();
    AppMethodBeat.o(105233);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(105238);
    ab.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    dMf();
    clearTask();
    clearCache();
    AppMethodBeat.o(105238);
  }
  
  private void clearTask()
  {
    AppMethodBeat.i(105236);
    if (this.mSV != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.mSV);
      this.mSV = null;
    }
    AppMethodBeat.o(105236);
  }
  
  private void dMf()
  {
    AppMethodBeat.i(105237);
    this.AdE = 2147483647;
    this.AdF = 2147483647;
    this.AdG = true;
    this.AdH = 2147483647;
    this.AaZ = 2147483647;
    this.AdI = true;
    this.AdJ = 2147483647;
    this.Aba = 2147483647;
    this.AdK = null;
    this.oBz = null;
    this.mVt = null;
    this.AdL = null;
    this.mRX = null;
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(105237);
  }
  
  private static int fx(List<? extends Object> paramList)
  {
    AppMethodBeat.i(105241);
    if (paramList == null)
    {
      AppMethodBeat.o(105241);
      return 0;
    }
    int i = paramList.size();
    AppMethodBeat.o(105241);
    return i;
  }
  
  private com.tencent.mm.ui.contact.a.a hH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105244);
    h localh = new h(paramInt2);
    localh.mZq = this.Adk.getActivity().getResources().getString(paramInt1);
    AppMethodBeat.o(105244);
    return localh;
  }
  
  private void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105240);
    int i = fx(this.AdK);
    int m = fx(this.oBz);
    int k = fx(this.mVt);
    int j = fx(this.AdL);
    if (i > 0)
    {
      this.AdE = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label315;
      }
      this.AdF = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label297;
      }
      if (!this.AdG) {
        break label273;
      }
      i += 4;
      this.AdH = i;
      i += 1;
      label112:
      if ((this.mRX.mSy.length <= 1) || (cni())) {
        break label324;
      }
      this.AdD = i;
      i += 1;
      label143:
      if (k <= 0) {
        break label375;
      }
      this.AaZ = i;
      if ((k <= 3) || (j <= 0)) {
        break label357;
      }
      if (!this.AdI) {
        break label333;
      }
      i += 4;
      this.AdJ = i;
      i += 1;
      label190:
      if (j <= 0) {
        break label384;
      }
      this.Aba = i;
      i += j + 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        cp(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      AppMethodBeat.o(105240);
      return;
      this.AdE = 2147483647;
      i = 0;
      break;
      label273:
      i += m + 1;
      this.AdH = i;
      i += 1;
      break label112;
      label297:
      this.AdH = 2147483647;
      i += m + 1;
      break label112;
      label315:
      this.AdF = 2147483647;
      break label112;
      label324:
      this.AdD = 2147483647;
      break label143;
      label333:
      i += k + 1;
      this.AdJ = i;
      i += 1;
      break label190;
      label357:
      this.AdJ = 2147483647;
      i += k + 1;
      break label190;
      label375:
      this.AaZ = 2147483647;
      break label190;
      label384:
      this.Aba = 2147483647;
    }
  }
  
  private static com.tencent.mm.ui.contact.a.a x(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(105243);
    j localj = new j(paramInt2);
    localj.resId = paramInt1;
    localj.mYy = paramBoolean;
    AppMethodBeat.o(105243);
    return localj;
  }
  
  protected com.tencent.mm.ui.contact.a.a Ff(int paramInt)
  {
    AppMethodBeat.i(146183);
    int i = paramInt - this.AaZ - 1;
    c localc = new c(paramInt);
    localc.hrL = ((com.tencent.mm.plugin.fts.a.a.l)this.mVt.get(i));
    localc.Adl = cni();
    localc.eBr = true;
    localc.mTI = (i + 1);
    localc.es(localc.hrL.type, localc.hrL.mRU);
    AppMethodBeat.o(146183);
    return localc;
  }
  
  public final boolean Qu(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(105246);
    paramInt -= this.Adk.getContentLV().getHeaderViewsCount();
    if (paramInt == this.AdH) {
      if (this.AdG)
      {
        paramInt = this.Adk.getContentLV().getSelectedItemPosition();
        this.AdG = false;
        k(this.query, true, false);
        this.Adk.getContentLV().setSelection(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105246);
      return bool;
      this.AdG = true;
      k(this.query, true, false);
      this.Adk.getContentLV().setSelection(this.AdH);
      continue;
      if (paramInt == this.AdJ)
      {
        if (this.AdI)
        {
          paramInt = this.Adk.getContentLV().getSelectedItemPosition();
          this.AdI = false;
          k(this.query, true, false);
          this.Adk.getContentLV().setSelection(paramInt);
        }
        else
        {
          this.AdI = true;
          k(this.query, true, false);
          this.Adk.getContentLV().setSelection(this.AdJ);
        }
      }
      else
      {
        com.tencent.mm.ui.contact.a.a locala = Qt(paramInt);
        if ((locala != null) && (locala.eBr) && (this.AdD != 2147483647))
        {
          if (locala.position == this.AdD)
          {
            z.Qv(1);
            bool = false;
          }
          else
          {
            z.Qv(0);
          }
        }
        else {
          bool = false;
        }
      }
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(105235);
    clearTask();
    this.query = paramString;
    this.AdM.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.AdM.add(Integer.valueOf(k));
      i += 1;
    }
    HashSet localHashSet = new HashSet();
    if (!paramBoolean) {
      localHashSet.add("filehelper");
    }
    ab.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.query });
    i locali = new i();
    locali.query = paramString;
    locali.mSP = paramArrayOfInt;
    locali.mSR = 3;
    locali.mSU = this.AdN;
    locali.handler = this.handler;
    locali.scene = 1;
    locali.mSS = localHashSet;
    this.mSV = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.fts.a.n.class)).search(1, locali);
    AppMethodBeat.o(105235);
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.AdE;
    int m = this.AdF;
    int n = this.AaZ;
    int i1 = this.Aba;
    int i = 0;
    while (i < 4)
    {
      if (j + 1 == new int[] { k, m, n, i1 }[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(105239);
    Kc();
    AppMethodBeat.o(105239);
  }
  
  public void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105234);
    if (this.Adj != null) {
      this.Adj.w(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(105234);
  }
  
  public void finish()
  {
    AppMethodBeat.i(105245);
    super.finish();
    ab.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Kc();
    AppMethodBeat.o(105245);
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  protected com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(105242);
    Object localObject = null;
    if (paramInt == this.AdD)
    {
      localObject = new com.tencent.mm.ui.contact.a.g(paramInt);
      ((com.tencent.mm.ui.contact.a.g)localObject).eBr = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).query = this.query;
        ((com.tencent.mm.ui.contact.a.a)localObject).mRX = this.mRX;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      AppMethodBeat.o(105242);
      return localObject;
      if (paramInt == this.AdE)
      {
        localObject = hH(2131300225, paramInt);
      }
      else if (paramInt == this.AdF)
      {
        localObject = hH(2131300209, paramInt);
      }
      else if (paramInt == this.AaZ)
      {
        localObject = hH(2131300208, paramInt);
      }
      else if (paramInt == this.Aba)
      {
        localObject = hH(2131300206, paramInt);
      }
      else if (paramInt == this.AdH)
      {
        localObject = x(2131300209, paramInt, this.AdG);
      }
      else if (paramInt == this.AdJ)
      {
        localObject = x(2131300208, paramInt, this.AdI);
      }
      else
      {
        int i;
        if (paramInt > this.Aba)
        {
          i = paramInt - this.Aba - 1;
          localObject = new e(paramInt);
          ((e)localObject).hrL = ((com.tencent.mm.plugin.fts.a.a.l)this.AdL.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).Adl = cni();
          ((e)localObject).eBr = true;
          ((e)localObject).mTI = (i + 1);
          ((e)localObject).es(((e)localObject).hrL.type, ((e)localObject).hrL.mRU);
        }
        else if (paramInt > this.AaZ)
        {
          localObject = Ff(paramInt);
        }
        else if (paramInt > this.AdF)
        {
          i = paramInt - this.AdF - 1;
          localObject = new e(paramInt);
          ((e)localObject).hrL = ((com.tencent.mm.plugin.fts.a.a.l)this.oBz.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).Adl = cni();
          ((e)localObject).eBr = true;
          ((e)localObject).mTI = (i + 1);
          ((e)localObject).es(((e)localObject).hrL.type, ((e)localObject).hrL.mRU);
        }
        else if (paramInt > this.AdE)
        {
          i = paramInt - this.AdE - 1;
          com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)this.AdK.get(i);
          if ((locall.type == 131072) || (locall.type == 131076) || (locall.type == 131081))
          {
            localObject = new e(paramInt);
            ((e)localObject).hrL = locall;
            ((com.tencent.mm.ui.contact.a.a)localObject).Adl = cni();
            ((e)localObject).AfS = true;
            ((e)localObject).eBr = true;
            ((e)localObject).mTI = (i + 1);
            ((e)localObject).es(((e)localObject).hrL.type, ((e)localObject).hrL.mRU);
          }
          else if (locall.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).hrL = locall;
            ((com.tencent.mm.ui.contact.a.a)localObject).Adl = cni();
            ((c)localObject).AfS = true;
            ((c)localObject).eBr = true;
            ((c)localObject).mTI = (i + 1);
            ((c)localObject).es(((c)localObject).hrL.type, ((c)localObject).hrL.mRU);
          }
          else
          {
            ab.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(locall.type) });
            localObject = null;
          }
        }
        else
        {
          ab.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */