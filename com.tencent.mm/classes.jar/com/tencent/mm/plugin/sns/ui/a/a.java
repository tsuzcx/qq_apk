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
import com.tencent.mm.plugin.sns.i.l;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
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
  private Cursor iCz;
  private List<m> yZk;
  public View.OnClickListener yZl;
  
  public a(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    this(paramMMBaseSelectContactUI, (byte)0);
  }
  
  private a(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    super(paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(99808);
    this.iCz = null;
    this.yZk = null;
    this.dataList = new ArrayList();
    this.yZl = null;
    ac.i("MicroMsg.SnsChatRoomAdapter", "create!");
    WN();
    AppMethodBeat.o(99808);
  }
  
  public final void WN()
  {
    AppMethodBeat.i(99810);
    ac.i("MicroMsg.SnsChatRoomAdapter", "resetData");
    this.yZk = af.dHN().xXq.yaS;
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    this.iCz = ((k)g.ab(k.class)).awG().a(w.hmU, this.fzw, this.Iwz, "");
    clearCache();
    Object localObject;
    if (!bs.gY(this.yZk))
    {
      localObject = this.yZk.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((Iterator)localObject).next();
        g.agS();
        ai localai = ((k)g.ab(k.class)).awB().aNt(localm.name);
        if ((localai != null) && ((int)localai.fLJ != 0)) {
          this.dataList.add(localm.name);
        }
      }
    }
    if (!bs.gY(this.dataList))
    {
      this.dataList.add(0, "recent_use");
      this.dataList.add("recent");
    }
    while (this.iCz.moveToNext())
    {
      localObject = this.iCz.getString(this.iCz.getColumnIndex("username"));
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
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(99809);
    Object localObject2 = (String)this.dataList.get(paramInt);
    if (bs.lr((String)localObject2, "recent_use")) {
      localObject1 = new h(paramInt);
    }
    for (((h)localObject1).header = this.Iwg.getActivity().getResources().getString(2131763876);; ((h)localObject1).header = this.Iwg.getActivity().getResources().getString(2131763875))
    {
      AppMethodBeat.o(99809);
      return localObject1;
      if (!bs.lr((String)localObject2, "recent")) {
        break;
      }
      localObject1 = new h(paramInt);
    }
    g.agS();
    Object localObject1 = ((k)g.ab(k.class)).awB().aNn((String)localObject2);
    if (localObject1 == null)
    {
      g.agS();
      localObject1 = ((k)g.ab(k.class)).awB().aNs((String)localObject2);
    }
    for (;;)
    {
      localObject2 = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
      ((com.tencent.mm.plugin.sns.ui.a.a.a)localObject2).yZl = this.yZl;
      ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((ai)localObject1);
      ((com.tencent.mm.ui.contact.a.a)localObject2).Iwh = dFi();
      localObject1 = localObject2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a
 * JD-Core Version:    0.7.0.1
 */