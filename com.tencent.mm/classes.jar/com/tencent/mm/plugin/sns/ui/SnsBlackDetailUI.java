package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements f, n.b
{
  private static List<String> ebF()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = d.fas();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void dgV()
  {
    AppMethodBeat.i(98492);
    if (((this.Ajp + " " + bt.m(this.ppT, ",")).equals(this.md5)) && (this.zid != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (ag.dUk().D(this.zid, this.Ajp))
    {
      h.c(this, getString(2131763994, new Object[] { this.Ajp }), getString(2131755906), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = ebG();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.ppT.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.ppT.iterator();
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
  
  public final void ebC()
  {
    AppMethodBeat.i(98488);
    ad.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    g.ajD();
    ((l)g.ab(l.class)).azp().a(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void ebD()
  {
    AppMethodBeat.i(98489);
    ad.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    g.ajD();
    if (g.ajA().aiK())
    {
      g.ajD();
      ((l)g.ab(l.class)).azp().b(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void ebE() {}
  
  protected final List<String> ebG()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.zid == 4L)
    {
      localObject = ebF();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void fW(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bp localbp = ag.dTS();
    String str1 = u.aAm();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.ppT.contains(str2)) && (com.tencent.mm.o.b.lM(localbp.Bf(str2).field_type)) && (!str1.equals(str2))) {
        this.ppT.add(str2);
      }
    }
    if (this.fMC != null) {
      this.fMC.eo(this.ppT);
    }
    updateTitle();
    AppMethodBeat.o(98496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98490);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    AppMethodBeat.o(98490);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98491);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.ajD();
    g.ajB().gAO.b(290, this);
    g.ajD();
    g.ajB().gAO.b(291, this);
    g.ajD();
    g.ajB().gAO.b(292, this);
    g.ajD();
    g.ajB().gAO.b(293, this);
    g.ajD();
    if (g.ajA().aiK())
    {
      g.ajD();
      ((l)g.ab(l.class)).azp().b(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98497);
    ad.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
  
  protected final void uZ(String paramString)
  {
    AppMethodBeat.i(98495);
    super.uZ(paramString);
    AppMethodBeat.o(98495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */