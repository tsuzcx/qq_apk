package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements com.tencent.mm.al.g, n.b
{
  private static List<String> dAR()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = com.tencent.mm.model.w.arx();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void cKe()
  {
    AppMethodBeat.i(98492);
    if (((this.xFb + " " + bt.n(this.oiL, ",")).equals(this.md5)) && (this.wFP != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (af.dtA().B(this.wFP, this.xFb))
    {
      h.c(this, getString(2131763994, new Object[] { this.xFb }), getString(2131755906), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = dAS();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.oiL.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.oiL.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      com.tencent.mm.model.w.B((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      com.tencent.mm.model.w.B((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void dAO()
  {
    AppMethodBeat.i(98488);
    ad.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    com.tencent.mm.kernel.g.afC();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().a(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void dAP()
  {
    AppMethodBeat.i(98489);
    ad.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afC();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void dAQ() {}
  
  protected final List<String> dAS()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.wFP == 4L)
    {
      localObject = dAR();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void fD(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bg localbg = af.dti();
    String str1 = u.aqG();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.oiL.contains(str2)) && (com.tencent.mm.n.b.ls(localbg.aHY(str2).field_type)) && (!str1.equals(str2))) {
        this.oiL.add(str2);
      }
    }
    if (this.fpW != null) {
      this.fpW.dX(this.oiL);
    }
    updateTitle();
    AppMethodBeat.o(98496);
  }
  
  protected final void oY(String paramString)
  {
    AppMethodBeat.i(98495);
    super.oY(paramString);
    AppMethodBeat.o(98495);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(290, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(291, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(292, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(293, this);
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afC();
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().b(this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */