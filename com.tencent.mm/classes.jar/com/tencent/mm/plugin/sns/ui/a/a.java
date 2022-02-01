package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends q
{
  private List<m> Ara;
  public View.OnClickListener Arb;
  private List<String> dataList;
  private Cursor iVJ;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.iVJ = null;
    this.Ara = null;
    this.dataList = new ArrayList();
    this.Arb = null;
    ad.i("MicroMsg.SnsChatRoomAdapter", "create!");
    Zh();
    AppMethodBeat.o(99808);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(99810);
    ad.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.Ara = ag.dUa().znp.zqO;
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    this.iVJ = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().a(w.hFk, this.fSL, this.Knh, "");
    clearCache();
    Object localObject;
    if (!bt.hj(this.Ara))
    {
      localObject = this.Ara.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((Iterator)localObject).next();
        g.ajD();
        am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(localm.name);
        if ((localam != null) && ((int)localam.gfj != 0)) {
          this.dataList.add(localm.name);
        }
      }
    }
    if (!bt.hj(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.iVJ.moveToNext())
    {
      localObject = this.iVJ.getString(this.iVJ.getColumnIndex("username"));
      if (!this.dataList.contains(localObject))
      {
        this.dataList.add(localObject);
        continue;
        this.dataList.add(0, "recent");
      }
    }
    AppMethodBeat.o(99810);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(99811);
    int i = this.dataList.size();
    AppMethodBeat.o(99811);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (bt.lQ((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).header = this.KmO.getActivity().getResources().getString(2131763876);; ((h)localObject1).header = this.KmO.getActivity().getResources().getString(2131763875))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!bt.lQ((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.ajD();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTf((String)localObject2);
    if (localObject1 == null)
    {
      g.ajD();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTk((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).Arb = this.Arb;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((am)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).KmP = dQK();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */