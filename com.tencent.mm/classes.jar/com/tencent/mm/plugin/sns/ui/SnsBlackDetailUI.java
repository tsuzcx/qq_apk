package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements i, MStorageEx.IOnStorageChange
{
  private static List<String> fVX()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = a.hhW();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void KE(String paramString)
  {
    AppMethodBeat.i(98495);
    super.KE(paramString);
    AppMethodBeat.o(98495);
  }
  
  protected final void eNa()
  {
    AppMethodBeat.i(98492);
    if (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (aj.fOO().S(this.JWc, this.KXZ))
    {
      com.tencent.mm.ui.base.h.c(this, getString(i.j.sns_tag_exist, new Object[] { this.KXZ }), getString(i.j.app_tip), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = fVY();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.unc.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.unc.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ab.F((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ab.F((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void fVU()
  {
    AppMethodBeat.i(98488);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    com.tencent.mm.kernel.h.aHH();
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().add(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void fVV()
  {
    AppMethodBeat.i(98489);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void fVW() {}
  
  protected final List<String> fVY()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.JWc == 4L)
    {
      localObject = fVX();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void hL(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bv localbv = aj.fOw();
    String str1 = z.bcZ();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.unc.contains(str2)) && (d.rk(localbv.RG(str2).field_type)) && (!str1.equals(str2))) {
        this.unc.add(str2);
      }
    }
    if (this.iYf != null) {
      this.iYf.fO(this.unc);
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
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(290, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(291, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(293, this);
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHH();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBlackDetailUI
 * JD-Core Version:    0.7.0.1
 */