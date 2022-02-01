package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.pluginsdk.platformtools.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI
  extends SnsTagDetailUI
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange
{
  private static List<String> hol()
  {
    AppMethodBeat.i(98493);
    new LinkedList();
    List localList = a.iIX();
    AppMethodBeat.o(98493);
    return localList;
  }
  
  protected final void Dk(String paramString)
  {
    AppMethodBeat.i(98495);
    super.Dk(paramString);
    AppMethodBeat.o(98495);
  }
  
  protected final void fVt()
  {
    AppMethodBeat.i(98492);
    if (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
    {
      finish();
      AppMethodBeat.o(98492);
      return;
    }
    if (al.hgI().ah(this.Qtd, this.Rya))
    {
      k.c(this, getString(b.j.sns_tag_exist, new Object[] { this.Rya }), getString(b.j.app_tip), true);
      AppMethodBeat.o(98492);
      return;
    }
    Object localObject2 = hom();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new LinkedList();
    Iterator localIterator = ((List)localObject2).iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!this.xtu.contains(str)) {
        localLinkedList.add(str);
      }
    }
    localIterator = this.xtu.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!((List)localObject2).contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject2 = localLinkedList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ab.J((String)((Iterator)localObject2).next(), false);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ab.J((String)((Iterator)localObject1).next(), true);
    }
    finish();
    AppMethodBeat.o(98492);
  }
  
  public final void hoi()
  {
    AppMethodBeat.i(98488);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
    com.tencent.mm.kernel.h.baF();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(this);
    AppMethodBeat.o(98488);
  }
  
  protected final void hoj()
  {
    AppMethodBeat.i(98489);
    Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this);
    }
    AppMethodBeat.o(98489);
  }
  
  protected final void hok() {}
  
  protected final List<String> hom()
  {
    AppMethodBeat.i(98494);
    Object localObject = new LinkedList();
    if (this.Qtd == 4L)
    {
      localObject = hol();
      AppMethodBeat.o(98494);
      return localObject;
    }
    AppMethodBeat.o(98494);
    return localObject;
  }
  
  protected final void kM(List<String> paramList)
  {
    AppMethodBeat.i(98496);
    bx localbx = al.hgp();
    String str1 = z.bAM();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      if ((!this.xtu.contains(str2)) && (d.rs(localbx.JE(str2).field_type)) && (!str1.equals(str2))) {
        this.xtu.add(str2);
      }
    }
    if (this.lzX != null) {
      this.lzX.iM(this.xtu);
    }
    aMl();
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(290, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(293, this);
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baF();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(98491);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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