package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sns.h.k;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends p
{
  private List<String> dataList;
  private Cursor gqa;
  private List<k> sdp;
  public View.OnClickListener sdq;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(145676);
    this.gqa = null;
    this.sdp = null;
    this.dataList = new ArrayList();
    this.sdq = null;
    ab.i("MicroMsg.SnsChatRoomAdapter", "create!");
    Kg();
    AppMethodBeat.o(145676);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(145678);
    ab.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.sdp = ag.cpb().riU.rma;
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    this.gqa = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().a(t.flj, this.ejc, this.AdB, "");
    clearCache();
    Object localObject;
    if (!bo.es(this.sdp))
    {
      localObject = this.sdp.iterator();
      while (((Iterator)localObject).hasNext())
      {
        k localk = (k)((Iterator)localObject).next();
        this.dataList.add(localk.name);
      }
    }
    if (!bo.es(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.gqa.moveToNext())
    {
      localObject = this.gqa.getString(this.gqa.getColumnIndex("username"));
      if (!this.dataList.contains(localObject))
      {
        this.dataList.add(localObject);
        continue;
        this.dataList.add(0, "recent");
      }
    }
    AppMethodBeat.o(145678);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(145679);
    int i = this.dataList.size();
    AppMethodBeat.o(145679);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(145677);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (bo.isEqual((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).mZq = this.Adk.getActivity().getResources().getString(2131303867);; ((h)localObject1).mZq = this.Adk.getActivity().getResources().getString(2131303866))
    {
      AppMethodBeat.o(145677);
      return localObject1;
      if (!bo.isEqual((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.RM();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arq((String)localObject2);
    if (localObject1 == null)
    {
      g.RM();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).sdq = this.sdq;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((ad)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).Adl = cni();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */