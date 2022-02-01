package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.k.m;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
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
  private List<com.tencent.mm.plugin.sns.k.n> RGA;
  public View.OnClickListener RGB;
  private List<String> dataList;
  private Cursor pKb;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.pKb = null;
    this.RGA = null;
    this.dataList = new ArrayList();
    this.RGB = null;
    Log.i("MicroMsg.SnsChatRoomAdapter", "create!");
    aNm();
    AppMethodBeat.o(99808);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(99810);
    Log.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.RGA = al.hgx().Qzf.QCU;
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    this.pKb = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().a(5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
    clearCache();
    Object localObject;
    if (!Util.isNullOrNil(this.RGA))
    {
      localObject = this.RGA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.sns.k.n localn = (com.tencent.mm.plugin.sns.k.n)((Iterator)localObject).next();
        h.baF();
        au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localn.name);
        if ((localau != null) && ((int)localau.maN != 0)) {
          this.dataList.add(localn.name);
        }
      }
    }
    if (!Util.isNullOrNil(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.pKb.moveToNext())
    {
      localObject = this.pKb.getString(this.pKb.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (Util.isEqual((String)localObject2, "recent_use")) {
      localObject1 = new j(paramInt);
    }
    for (((j)localObject1).header = this.afex.getActivity().getResources().getString(b.j.sns_label_select_group_recent_use);; ((j)localObject1).header = this.afex.getActivity().getResources().getString(b.j.sns_label_select_group_recent))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!Util.isEqual((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new j(paramInt);
    }
    h.baF();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxq((String)localObject2);
    if (localObject1 == null)
    {
      h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxv((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).RGB = this.RGB;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */