package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.ListView;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q
  extends m
{
  private String bVk;
  private int count = 0;
  private ah handler = new ah(Looper.getMainLooper());
  private com.tencent.mm.plugin.fts.a.a.g kwi;
  private com.tencent.mm.plugin.fts.a.a.a kxg;
  private List<com.tencent.mm.plugin.fts.a.a.l> kzD = null;
  private List<com.tencent.mm.plugin.fts.a.a.l> maY = null;
  private int vJD = 2147483647;
  private int vJE = 2147483647;
  private List<String> vMa;
  private int vMb = 2147483647;
  private int vMc = 2147483647;
  private int vMd = 2147483647;
  private boolean vMe = true;
  private int vMf = 2147483647;
  private boolean vMg = true;
  private int vMh = 2147483647;
  private List<com.tencent.mm.plugin.fts.a.a.l> vMi = null;
  private List<com.tencent.mm.plugin.fts.a.a.l> vMj = null;
  private List<Integer> vMk;
  private com.tencent.mm.plugin.fts.a.l vMl = new q.1(this);
  protected com.tencent.mm.plugin.fts.a.l vMm = new q.2(this);
  
  public q(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    super(paramMMBaseSelectContactUI, paramBoolean, paramInt);
    this.vMa = paramList;
    this.vMk = new ArrayList();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSearchContactAdapter", "Create!");
    xK();
  }
  
  private void cHN()
  {
    this.vMc = 2147483647;
    this.vMd = 2147483647;
    this.vMe = true;
    this.vMf = 2147483647;
    this.vJD = 2147483647;
    this.vMg = true;
    this.vMh = 2147483647;
    this.vJE = 2147483647;
    this.vMi = null;
    this.maY = null;
    this.kzD = null;
    this.vMj = null;
    this.kwi = null;
    clearCache();
    notifyDataSetChanged();
  }
  
  private void clearTask()
  {
    if (this.kxg != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.kxg);
      this.kxg = null;
    }
  }
  
  private static int el(List<? extends Object> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
  
  private com.tencent.mm.ui.contact.a.a fz(int paramInt1, int paramInt2)
  {
    com.tencent.mm.ui.contact.a.g localg = new com.tencent.mm.ui.contact.a.g(paramInt2);
    localg.kDu = this.vLI.getActivity().getResources().getString(paramInt1);
    return localg;
  }
  
  private void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = el(this.vMi);
    int m = el(this.maY);
    int k = el(this.kzD);
    int j = el(this.vMj);
    if (i > 0)
    {
      this.vMc = 0;
      i = i + 1 + 0;
      if (m <= 0) {
        break label303;
      }
      this.vMd = i;
      if ((m <= 3) || ((k <= 0) && (j <= 0))) {
        break label285;
      }
      if (!this.vMe) {
        break label261;
      }
      i += 4;
      this.vMf = i;
      i += 1;
      label106:
      if ((this.kwi.kwI.length <= 1) || (bBJ())) {
        break label312;
      }
      this.vMb = i;
      i += 1;
      label137:
      if (k <= 0) {
        break label363;
      }
      this.vJD = i;
      if ((k <= 3) || (j <= 0)) {
        break label345;
      }
      if (!this.vMg) {
        break label321;
      }
      i += 4;
      this.vMh = i;
      i += 1;
      label184:
      if (j <= 0) {
        break label372;
      }
      this.vJE = i;
      i += j + 1;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[] { Integer.valueOf(i) });
      this.count = i;
      if (paramBoolean2) {
        bN(paramString, paramBoolean1);
      }
      clearCache();
      notifyDataSetChanged();
      return;
      this.vMc = 2147483647;
      i = 0;
      break;
      label261:
      i += m + 1;
      this.vMf = i;
      i += 1;
      break label106;
      label285:
      this.vMf = 2147483647;
      i += m + 1;
      break label106;
      label303:
      this.vMd = 2147483647;
      break label106;
      label312:
      this.vMb = 2147483647;
      break label137;
      label321:
      i += k + 1;
      this.vMh = i;
      i += 1;
      break label184;
      label345:
      this.vMh = 2147483647;
      i += k + 1;
      break label184;
      label363:
      this.vJD = 2147483647;
      break label184;
      label372:
      this.vJE = 2147483647;
    }
  }
  
  private static com.tencent.mm.ui.contact.a.a u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    com.tencent.mm.ui.contact.a.i locali = new com.tencent.mm.ui.contact.a.i(paramInt2);
    locali.kCB = paramInt1;
    locali.kCC = paramBoolean;
    return locali;
  }
  
  private void xK()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.bVk = null;
    cHN();
    clearTask();
    clearCache();
  }
  
  public final boolean HL(int paramInt)
  {
    paramInt -= this.vLI.getContentLV().getHeaderViewsCount();
    if (paramInt == this.vMf)
    {
      if (this.vMe)
      {
        paramInt = this.vLI.getContentLV().getSelectedItemPosition();
        this.vMe = false;
        g(this.bVk, true, false);
        this.vLI.getContentLV().setSelection(paramInt);
        return true;
      }
      this.vMe = true;
      g(this.bVk, true, false);
      this.vLI.getContentLV().setSelection(this.vMf);
      return true;
    }
    if (paramInt == this.vMh)
    {
      if (this.vMg)
      {
        paramInt = this.vLI.getContentLV().getSelectedItemPosition();
        this.vMg = false;
        g(this.bVk, true, false);
        this.vLI.getContentLV().setSelection(paramInt);
        return true;
      }
      this.vMg = true;
      g(this.bVk, true, false);
      this.vLI.getContentLV().setSelection(this.vMh);
      return true;
    }
    com.tencent.mm.ui.contact.a.a locala = HK(paramInt);
    if ((locala != null) && (locala.dDQ) && (this.vMb != 2147483647))
    {
      if (locala.position == this.vMb)
      {
        y.HM(1);
        return false;
      }
      y.HM(0);
    }
    return false;
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    clearTask();
    this.bVk = paramString;
    this.vMk.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.vMk.add(Integer.valueOf(k));
      i += 1;
    }
    HashSet localHashSet = new HashSet();
    if (!paramBoolean) {
      localHashSet.add("filehelper");
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[] { this.bVk });
    com.tencent.mm.plugin.fts.a.a.i locali = new com.tencent.mm.plugin.fts.a.a.i();
    locali.bVk = paramString;
    locali.kxa = paramArrayOfInt;
    locali.kxc = 3;
    locali.kxf = this.vMl;
    locali.handler = this.handler;
    locali.scene = 1;
    locali.kxd = localHashSet;
    this.kxg = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).search(1, locali);
  }
  
  public final void adg()
  {
    xK();
  }
  
  public void bN(String paramString, boolean paramBoolean)
  {
    if (this.vLH != null) {
      this.vLH.t(paramString, getCount(), paramBoolean);
    }
  }
  
  protected boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    int j = parama.position;
    int k = this.vMc;
    int m = this.vMd;
    int n = this.vJD;
    int i1 = this.vJE;
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
  
  public void finish()
  {
    super.finish();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMSearchContactAdapter", "finish!");
    xK();
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    Object localObject;
    if (paramInt == this.vMb)
    {
      localObject = new f(paramInt);
      ((f)localObject).dDQ = true;
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((com.tencent.mm.ui.contact.a.a)localObject).bVk = this.bVk;
        ((com.tencent.mm.ui.contact.a.a)localObject).kwi = this.kwi;
        ((com.tencent.mm.ui.contact.a.a)localObject).scene = this.scene;
      }
      return localObject;
      if (paramInt == this.vMc)
      {
        localObject = fz(a.h.fts_header_top_hits, paramInt);
      }
      else if (paramInt == this.vMd)
      {
        localObject = fz(a.h.fts_header_contact, paramInt);
      }
      else if (paramInt == this.vJD)
      {
        localObject = fz(a.h.fts_header_chatroom, paramInt);
      }
      else if (paramInt == this.vJE)
      {
        localObject = fz(a.h.fts_header_biz, paramInt);
      }
      else if (paramInt == this.vMf)
      {
        localObject = u(a.h.fts_header_contact, paramInt, this.vMe);
      }
      else if (paramInt == this.vMh)
      {
        localObject = u(a.h.fts_header_chatroom, paramInt, this.vMg);
      }
      else
      {
        int i;
        if (paramInt > this.vJE)
        {
          i = paramInt - this.vJE - 1;
          localObject = new d(paramInt);
          ((d)localObject).fYx = ((com.tencent.mm.plugin.fts.a.a.l)this.vMj.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
          ((d)localObject).dDQ = true;
          ((d)localObject).kxV = (i + 1);
          ((d)localObject).cU(((d)localObject).fYx.type, ((d)localObject).fYx.kwf);
        }
        else if (paramInt > this.vJD)
        {
          i = paramInt - this.vJD - 1;
          localObject = new c(paramInt);
          ((c)localObject).fYx = ((com.tencent.mm.plugin.fts.a.a.l)this.kzD.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
          ((c)localObject).dDQ = true;
          ((c)localObject).kxV = (i + 1);
          ((c)localObject).cU(((c)localObject).fYx.type, ((c)localObject).fYx.kwf);
        }
        else if (paramInt > this.vMd)
        {
          i = paramInt - this.vMd - 1;
          localObject = new d(paramInt);
          ((d)localObject).fYx = ((com.tencent.mm.plugin.fts.a.a.l)this.maY.get(i));
          ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
          ((d)localObject).dDQ = true;
          ((d)localObject).kxV = (i + 1);
          ((d)localObject).cU(((d)localObject).fYx.type, ((d)localObject).fYx.kwf);
        }
        else if (paramInt > this.vMc)
        {
          i = paramInt - this.vMc - 1;
          com.tencent.mm.plugin.fts.a.a.l locall = (com.tencent.mm.plugin.fts.a.a.l)this.vMi.get(i);
          if ((locall.type == 131072) || (locall.type == 131076) || (locall.type == 131081))
          {
            localObject = new d(paramInt);
            ((d)localObject).fYx = locall;
            ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
            ((d)localObject).vOk = true;
            ((d)localObject).dDQ = true;
            ((d)localObject).kxV = (i + 1);
            ((d)localObject).cU(((d)localObject).fYx.type, ((d)localObject).fYx.kwf);
          }
          else if (locall.type == 131075)
          {
            localObject = new c(paramInt);
            ((c)localObject).fYx = locall;
            ((com.tencent.mm.ui.contact.a.a)localObject).vLJ = bBJ();
            ((c)localObject).vOk = true;
            ((c)localObject).dDQ = true;
            ((c)localObject).kxV = (i + 1);
            ((c)localObject).cU(((c)localObject).fYx.type, ((c)localObject).fYx.kwf);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[] { Integer.valueOf(locall.type) });
            localObject = null;
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[] { Integer.valueOf(paramInt) });
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q
 * JD-Core Version:    0.7.0.1
 */