package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements f, m.b
{
  public final void bIt()
  {
    y.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    g.DQ();
    ((j)g.r(j.class)).Fw().a(this);
  }
  
  protected final void bIu()
  {
    y.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    g.DQ();
    if (g.DN().Dc())
    {
      g.DQ();
      ((j)g.r(j.class)).Fw().b(this);
    }
  }
  
  protected final void bIv() {}
  
  protected final List<String> bIw()
  {
    Object localObject = new LinkedList();
    if (this.oqH == 4L)
    {
      new LinkedList();
      localObject = s.Ha();
    }
    return localObject;
  }
  
  protected final void beJ()
  {
    if (((this.pdN + " " + bk.c(this.iSZ, ",")).equals(this.bIW)) && (this.oqH != 0L))
    {
      finish();
      return;
    }
    if (af.bDL().u(this.oqH, this.pdN))
    {
      h.b(this, getString(i.j.sns_tag_exist, new Object[] { this.pdN }), getString(i.j.app_tip), true);
      return;
    }
    Object localObject2 = bIw();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.iSZ.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.iSZ.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      s.s((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      s.s((String)((Iterator)localObject1).next(), true);
    }
    com.tencent.mm.plugin.sns.c.a.eUS.tk();
    finish();
  }
  
  protected final void cG(List<String> paramList)
  {
    bd localbd = af.bDt();
    String str1 = q.Gj();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.iSZ.contains(str2)) && (com.tencent.mm.n.a.gR(localbd.abl(str2).field_type)) && (!str1.equals(str2))) {
        this.iSZ.add(str2);
      }
    }
    if (this.dnv != null) {
      this.dnv.bJ(this.iSZ);
    }
    updateTitle();
  }
  
  protected final void eR(String paramString)
  {
    super.eR(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
  }
  
  public void onDestroy()
  {
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.DQ();
    g.DO().dJT.b(290, this);
    g.DQ();
    g.DO().dJT.b(291, this);
    g.DQ();
    g.DO().dJT.b(292, this);
    g.DQ();
    g.DO().dJT.b(293, this);
    g.DQ();
    if (g.DN().Dc())
    {
      g.DQ();
      ((j)g.r(j.class)).Fw().b(this);
    }
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */