package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements i, MStorageEx.IOnStorageChange
{
  private static List<String> fhK()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = com.tencent.mm.pluginsdk.i.a.gnq();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void DM(String paramString)
  {
    AppMethodBeat.i(98495);
    super.DM(paramString);
    AppMethodBeat.o(98495);
  }
  
  protected final void edF()
  {
    AppMethodBeat.i(98492);
    if (((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5)) && (this.DJc != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (aj.faU().K(this.DJc, this.EJW))
    {
      h.c(this, getString(2131766232, new Object[] { this.EJW }), getString(2131755998), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = fhL();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.qLQ.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.qLQ.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ab.D((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ab.D((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void fhH()
  {
    AppMethodBeat.i(98488);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    g.aAi();
    ((l)g.af(l.class)).aSN().add(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void fhI()
  {
    AppMethodBeat.i(98489);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    g.aAi();
    if (g.aAf().azp())
    {
      g.aAi();
      ((l)g.af(l.class)).aSN().remove(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void fhJ() {}
  
  protected final List<String> fhL()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.DJc == 4L)
    {
      localObject = fhK();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void hc(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bv localbv = aj.faC();
    String str1 = z.aTY();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.qLQ.contains(str2)) && (c.oR(localbv.Kn(str2).field_type)) && (!str1.equals(str2))) {
        this.qLQ.add(str2);
      }
    }
    if (this.gtU != null) {
      this.gtU.fm(this.qLQ);
    }
    updateTitle();
    AppMethodBeat.o(98496);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98490);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    AppMethodBeat.o(98490);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98491);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    g.aAi();
    g.aAg().hqi.b(290, this);
    g.aAi();
    g.aAg().hqi.b(291, this);
    g.aAi();
    g.aAg().hqi.b(292, this);
    g.aAi();
    g.aAg().hqi.b(293, this);
    g.aAi();
    if (g.aAf().azp())
    {
      g.aAi();
      ((l)g.af(l.class)).aSN().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(98497);
    Log.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */