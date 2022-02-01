package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends q
{
  private List<com.tencent.mm.plugin.sns.j.n> ESn;
  public View.OnClickListener ESo;
  private List<String> dataList;
  private Cursor jWh;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.jWh = null;
    this.ESn = null;
    this.dataList = new ArrayList();
    this.ESo = null;
    Log.i("MicroMsg.SnsChatRoomAdapter", "create!");
    and();
    AppMethodBeat.o(99808);
  }
  
  public final void and()
  {
    AppMethodBeat.i(99810);
    Log.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.ESn = aj.faK().DOH.DSf;
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    this.jWh = ((l)g.af(l.class)).aST().b(ab.iCM, this.gzY, com.tencent.mm.o.a.gNj, this.PWC, "");
    clearCache();
    Object localObject;
    if (!Util.isNullOrNil(this.ESn))
    {
      localObject = this.ESn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.sns.j.n localn = (com.tencent.mm.plugin.sns.j.n)((Iterator)localObject).next();
        g.aAi();
        as localas = ((l)g.af(l.class)).aSN().Kn(localn.name);
        if ((localas != null) && ((int)localas.gMZ != 0)) {
          this.dataList.add(localn.name);
        }
      }
    }
    if (!Util.isNullOrNil(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.jWh.moveToNext())
    {
      localObject = this.jWh.getString(this.jWh.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (Util.isEqual((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).header = this.PWg.getActivity().getResources().getString(2131766103);; ((h)localObject1).header = this.PWg.getActivity().getResources().getString(2131766102))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!Util.isEqual((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.aAi();
    Object localObject1 = ((l)g.af(l.class)).aSN().bjF((String)localObject2);
    if (localObject1 == null)
    {
      g.aAi();
      localObject1 = ((l)g.af(l.class)).aSN().bjK((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).ESo = this.ESo;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).PWh = eWh();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */