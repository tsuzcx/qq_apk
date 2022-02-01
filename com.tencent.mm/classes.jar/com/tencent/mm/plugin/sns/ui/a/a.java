package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  private List<m> AIo;
  public View.OnClickListener AIp;
  private List<String> dataList;
  private Cursor iYC;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.iYC = null;
    this.AIo = null;
    this.dataList = new ArrayList();
    this.AIp = null;
    ae.i("MicroMsg.SnsChatRoomAdapter", "create!");
    Zq();
    AppMethodBeat.o(99808);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(99810);
    ae.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.AIo = ah.dXA().zEE.zId;
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    this.iYC = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().a(x.hIc, this.fUR, this.KJB, "");
    clearCache();
    Object localObject;
    if (!bu.ht(this.AIo))
    {
      localObject = this.AIo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((Iterator)localObject).next();
        g.ajS();
        an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localm.name);
        if ((localan != null) && ((int)localan.ght != 0)) {
          this.dataList.add(localm.name);
        }
      }
    }
    if (!bu.ht(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.iYC.moveToNext())
    {
      localObject = this.iYC.getString(this.iYC.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (bu.lX((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).header = this.KJi.getActivity().getResources().getString(2131763876);; ((h)localObject1).header = this.KJi.getActivity().getResources().getString(2131763875))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!bu.lX((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.ajS();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUG((String)localObject2);
    if (localObject1 == null)
    {
      g.ajS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUL((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).AIp = this.AIp;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((an)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).KJj = dUh();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */