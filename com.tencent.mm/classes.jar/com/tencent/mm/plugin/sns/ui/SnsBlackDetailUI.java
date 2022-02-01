package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.g.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements com.tencent.mm.ak.g, n.b
{
  private static List<String> dPo()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = j.fdk();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void cXJ()
  {
    AppMethodBeat.i(98492);
    if (((this.yRP + " " + bs.n(this.oMl, ",")).equals(this.md5)) && (this.xSj != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (af.dHX().z(this.xSj, this.yRP))
    {
      h.c(this, getString(2131763994, new Object[] { this.yRP }), getString(2131755906), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = dPp();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.oMl.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.oMl.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      com.tencent.mm.model.w.C((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      com.tencent.mm.model.w.C((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void dPl()
  {
    AppMethodBeat.i(98488);
    ac.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    com.tencent.mm.kernel.g.agS();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().a(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void dPm()
  {
    AppMethodBeat.i(98489);
    ac.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agS();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void dPn() {}
  
  protected final List<String> dPp()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.xSj == 4L)
    {
      localObject = dPo();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void fL(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bj localbj = af.dHF();
    String str1 = u.axw();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.oMl.contains(str2)) && (com.tencent.mm.n.b.ln(localbj.aNt(str2).field_type)) && (!str1.equals(str2))) {
        this.oMl.add(str2);
      }
    }
    if (this.ftA != null) {
      this.ftA.eb(this.oMl);
    }
    updateTitle();
    AppMethodBeat.o(98496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98490);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    AppMethodBeat.o(98490);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98491);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(290, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(291, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(293, this);
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agS();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98497);
    ac.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(98497);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void sk(String paramString)
  {
    AppMethodBeat.i(98495);
    super.sk(paramString);
    AppMethodBeat.o(98495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */