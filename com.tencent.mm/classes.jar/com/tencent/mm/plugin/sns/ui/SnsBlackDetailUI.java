package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements f, n.b
{
  private static List<String> cuQ()
  {
    AppMethodBeat.i(38744);
    new LinkedList();
    List localList = t.aac();
    AppMethodBeat.o(38744);
    return localList;
  }
  
  protected final void bMd()
  {
    AppMethodBeat.i(38743);
    if (((this.rWA + " " + bo.d(this.lbK, ",")).equals(this.cqq)) && (this.rfr != 0L))
    {
      finish();
      AppMethodBeat.o(38743);
      return;
    }
    if (ag.cpl().v(this.rfr, this.rWA))
    {
      h.b(this, getString(2131303977, new Object[] { this.rWA }), getString(2131297087), true);
      AppMethodBeat.o(38743);
      return;
    }
    Object localObject2 = cuR();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.lbK.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.lbK.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      t.w((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      t.w((String)((Iterator)localObject1).next(), true);
    }
    com.tencent.mm.plugin.sns.c.a.gmP.BO();
    finish();
    AppMethodBeat.o(38743);
  }
  
  public final void cuN()
  {
    AppMethodBeat.i(38739);
    ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    g.RM();
    ((j)g.E(j.class)).YA().a(this);
    AppMethodBeat.o(38739);
  }
  
  protected final void cuO()
  {
    AppMethodBeat.i(38740);
    ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    g.RM();
    if (g.RJ().QU())
    {
      g.RM();
      ((j)g.E(j.class)).YA().b(this);
    }
    AppMethodBeat.o(38740);
  }
  
  protected final void cuP() {}
  
  protected final List<String> cuR()
  {
    AppMethodBeat.i(38745);
    Object localObject = new LinkedList();
    if (this.rfr == 4L)
    {
      localObject = cuQ();
      AppMethodBeat.o(38745);
      return localObject;
    }
    AppMethodBeat.o(38745);
    return localObject;
  }
  
  protected final void dm(List<String> paramList)
  {
    AppMethodBeat.i(38747);
    bd localbd = ag.coT();
    String str1 = r.Zn();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.lbK.contains(str2)) && (com.tencent.mm.n.a.je(localbd.arw(str2).field_type)) && (!str1.equals(str2))) {
        this.lbK.add(str2);
      }
    }
    if (this.eeU != null) {
      this.eeU.cg(this.lbK);
    }
    updateTitle();
    AppMethodBeat.o(38747);
  }
  
  protected final void lc(String paramString)
  {
    AppMethodBeat.i(38746);
    super.lc(paramString);
    AppMethodBeat.o(38746);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38741);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    AppMethodBeat.o(38741);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38742);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.RM();
    g.RK().eHt.b(290, this);
    g.RM();
    g.RK().eHt.b(291, this);
    g.RM();
    g.RK().eHt.b(292, this);
    g.RM();
    g.RK().eHt.b(293, this);
    g.RM();
    if (g.RJ().QU())
    {
      g.RM();
      ((j)g.E(j.class)).YA().b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(38742);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(38748);
    ab.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(38748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */