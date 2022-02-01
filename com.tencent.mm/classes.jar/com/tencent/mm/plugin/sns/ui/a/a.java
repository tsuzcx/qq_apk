package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
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
  private List<String> dataList;
  private Cursor icq;
  private List<m> xMv;
  public View.OnClickListener xMw;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.icq = null;
    this.xMv = null;
    this.dataList = new ArrayList();
    this.xMw = null;
    ad.i("MicroMsg.SnsChatRoomAdapter", "create!");
    VP();
    AppMethodBeat.o(99808);
  }
  
  public final void VP()
  {
    AppMethodBeat.i(99810);
    ad.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.xMv = com.tencent.mm.plugin.sns.model.af.dtq().wKK.wOl;
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    this.icq = ((k)g.ab(k.class)).apR().a(w.gMu, this.fvP, this.GWl, "");
    clearCache();
    Object localObject;
    if (!bt.gL(this.xMv))
    {
      localObject = this.xMv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((Iterator)localObject).next();
        g.afC();
        com.tencent.mm.storage.af localaf = ((k)g.ab(k.class)).apM().aHY(localm.name);
        if ((localaf != null) && ((int)localaf.fId != 0)) {
          this.dataList.add(localm.name);
        }
      }
    }
    if (!bt.gL(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.icq.moveToNext())
    {
      localObject = this.icq.getString(this.icq.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (bt.kU((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).header = this.GVS.getActivity().getResources().getString(2131763876);; ((h)localObject1).header = this.GVS.getActivity().getResources().getString(2131763875))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!bt.kU((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.afC();
    Object localObject1 = ((k)g.ab(k.class)).apM().aHS((String)localObject2);
    if (localObject1 == null)
    {
      g.afC();
      localObject1 = ((k)g.ab(k.class)).apM().aHX((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).xMw = this.xMw;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((com.tencent.mm.storage.af)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).GVT = dqZ();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */