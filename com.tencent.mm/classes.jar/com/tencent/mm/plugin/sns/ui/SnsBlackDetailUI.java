package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements f, n.b
{
  private static List<String> efm()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = d.feg();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void djU()
  {
    AppMethodBeat.i(98492);
    if (((this.AAA + " " + bu.m(this.pwz, ",")).equals(this.md5)) && (this.zyS != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (ah.dXK().E(this.zyS, this.AAA))
    {
      h.c(this, getString(2131763994, new Object[] { this.AAA }), getString(2131755906), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = efn();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.pwz.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.pwz.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      x.C((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      x.C((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void efj()
  {
    AppMethodBeat.i(98488);
    ae.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    g.ajS();
    ((l)g.ab(l.class)).azF().a(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void efk()
  {
    AppMethodBeat.i(98489);
    ae.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    g.ajS();
    if (g.ajP().aiZ())
    {
      g.ajS();
      ((l)g.ab(l.class)).azF().b(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void efl() {}
  
  protected final List<String> efn()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.zyS == 4L)
    {
      localObject = efm();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void gf(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bq localbq = ah.dXs();
    String str1 = v.aAC();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.pwz.contains(str2)) && (c.lO(localbq.BH(str2).field_type)) && (!str1.equals(str2))) {
        this.pwz.add(str2);
      }
    }
    if (this.fOK != null) {
      this.fOK.es(this.pwz);
    }
    updateTitle();
    AppMethodBeat.o(98496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98490);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    AppMethodBeat.o(98490);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98491);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.ajS();
    g.ajQ().gDv.b(290, this);
    g.ajS();
    g.ajQ().gDv.b(291, this);
    g.ajS();
    g.ajQ().gDv.b(292, this);
    g.ajS();
    g.ajQ().gDv.b(293, this);
    g.ajS();
    if (g.ajP().aiZ())
    {
      g.ajS();
      ((l)g.ab(l.class)).azF().b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98497);
    ae.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
  
  protected final void vv(String paramString)
  {
    AppMethodBeat.i(98495);
    super.vv(paramString);
    AppMethodBeat.o(98495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */