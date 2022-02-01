package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends r
{
  private List<com.tencent.mm.plugin.sns.j.n> Lgq;
  public View.OnClickListener Lgr;
  private List<String> dataList;
  private Cursor mNt;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.mNt = null;
    this.Lgq = null;
    this.dataList = new ArrayList();
    this.Lgr = null;
    Log.i("MicroMsg.SnsChatRoomAdapter", "create!");
    ate();
    AppMethodBeat.o(99808);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(99810);
    Log.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.Lgq = aj.fOE().KbO.Kfn;
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    this.mNt = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().a(5, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
    clearCache();
    Object localObject;
    if (!Util.isNullOrNil(this.Lgq))
    {
      localObject = this.Lgq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.sns.j.n localn = (com.tencent.mm.plugin.sns.j.n)((Iterator)localObject).next();
        h.aHH();
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localn.name);
        if ((localas != null) && ((int)localas.jxt != 0)) {
          this.dataList.add(localn.name);
        }
      }
    }
    if (!Util.isNullOrNil(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.mNt.moveToNext())
    {
      localObject = this.mNt.getString(this.mNt.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (Util.isEqual((String)localObject2, "recent_use")) {
      localObject1 = new j(paramInt);
    }
    for (((j)localObject1).header = this.XsW.getActivity().getResources().getString(i.j.sns_label_select_group_recent_use);; ((j)localObject1).header = this.XsW.getActivity().getResources().getString(i.j.sns_label_select_group_recent))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!Util.isEqual((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new j(paramInt);
    }
    h.aHH();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwc((String)localObject2);
    if (localObject1 == null)
    {
      h.aHH();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).Lgr = this.Lgr;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */