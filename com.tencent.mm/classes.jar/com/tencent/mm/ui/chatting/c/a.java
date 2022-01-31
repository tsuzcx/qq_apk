package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.br.d.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.f.b;
import com.tencent.mm.ui.x;
import java.util.HashMap;

public final class a
{
  private static com.tencent.mm.sdk.platformtools.ah vtv = new com.tencent.mm.sdk.platformtools.ah();
  public boolean euf = false;
  public ad pSb;
  public ag vtA;
  public com.tencent.mm.ui.chatting.ah vtB;
  public String vtC;
  public com.tencent.mm.ui.chatting.f.a vtw = new com.tencent.mm.ui.chatting.f.a(this);
  public b vtx = new b(this);
  public String vty;
  public e vtz;
  
  public a(e parame, ag paramag, com.tencent.mm.ui.chatting.ah paramah)
  {
    this.vtz = parame;
    this.vtA = paramag;
    this.vtB = paramah;
  }
  
  public static com.tencent.mm.sdk.platformtools.ah cFG()
  {
    return vtv;
  }
  
  public final void GT(int paramInt)
  {
    y.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false) });
    this.vtA.GT(paramInt);
  }
  
  public final void GU(int paramInt)
  {
    this.vtA.GU(paramInt);
  }
  
  public final void Hg(int paramInt)
  {
    y.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.vtA.updateOptionMenuIcon(2, paramInt);
  }
  
  public final void XM()
  {
    y.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.vtA.hideVKB();
  }
  
  public final void a(Intent paramIntent, int paramInt, d.a parama)
  {
    this.vtx.a(paramIntent, paramInt, parama);
  }
  
  public final void a(Class<? extends v> paramClass, v paramv)
  {
    com.tencent.mm.ui.chatting.f.a locala = this.vtw;
    if (locala.vyt.put(paramClass, paramv) != null) {
      y.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramv instanceof w))
    {
      long l1 = System.currentTimeMillis();
      ((w)paramv).a(locala.byx);
      long l2 = System.currentTimeMillis();
      y.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramv.getClass().getName(), Long.valueOf(l2 - l1) });
    }
  }
  
  public final void ab(ad paramad)
  {
    this.pSb = paramad;
    this.vtC = com.tencent.xweb.util.c.o((paramad.field_username + System.currentTimeMillis()).getBytes());
  }
  
  public final <T extends v, V extends Class<T>> T ac(V paramV)
  {
    com.tencent.mm.ui.chatting.f.a locala = this.vtw;
    if (!paramV.isInterface()) {
      throw new RuntimeException("[get] " + paramV + " is not a interface!");
    }
    if (locala.vyt.containsKey(paramV)) {
      return (v)locala.vyt.get(paramV);
    }
    y.e("MicroMsg.ChattingComponentManager", "[get] " + paramV + " is never register! activity:%s", new Object[] { locala.byx.vtz.getContext().getClass().getSimpleName() });
    return null;
  }
  
  public final void axW()
  {
    y.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.vtA.axW();
  }
  
  public final void bE(int paramInt)
  {
    y.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.vtA.bE(paramInt);
  }
  
  public final void cCW()
  {
    y.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(true) });
    this.vtA.cCW();
  }
  
  public final String cDP()
  {
    return bk.aM(((com.tencent.mm.ui.chatting.b.b.c)ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDP(), this.pSb.field_nickname);
  }
  
  public final String cFB()
  {
    if (this.vty == null)
    {
      this.vty = q.Gj();
      if (!ad.hd(getTalkerUserName())) {
        break label42;
      }
    }
    label42:
    for (String str = ad.aaZ(this.vty);; str = this.vty)
    {
      this.vty = str;
      return this.vty;
    }
  }
  
  public final boolean cFC()
  {
    String str = getTalkerUserName();
    return (ad.hd(str)) || (ad.aaT(str)) || (ad.aaR(str)) || (s.hA(str));
  }
  
  public final boolean cFD()
  {
    return (s.fn(getTalkerUserName())) || (s.hb(getTalkerUserName()));
  }
  
  public final boolean cFE()
  {
    return (s.fn(getTalkerUserName())) || (s.hb(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.b.b.c)ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH());
  }
  
  public final boolean cFF()
  {
    if ((!this.pSb.cua()) && (!s.hR(getTalkerUserName())) && (!ad.aaR(getTalkerUserName()))) {
      return true;
    }
    return ((com.tencent.mm.ui.chatting.b.b.c)ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG();
  }
  
  public final void d(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    y.i("MicroMsg.ChattingContext", "[showDialog]");
    this.vtA.c(paramContext, paramString, paramOnCancelListener);
  }
  
  public final void dismissDialog()
  {
    y.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.vtA.dismissDialog();
  }
  
  public final View findViewById(int paramInt)
  {
    return this.vtz.findViewById(paramInt);
  }
  
  public final void fx(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(false) });
    this.vtA.fx(paramInt1, paramInt2);
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.vtA.getChildAt(paramInt);
  }
  
  public final int getFirstVisiblePosition()
  {
    return this.vtA.getFirstVisiblePosition();
  }
  
  public final int getHeaderViewsCount()
  {
    return this.vtA.getHeaderViewsCount();
  }
  
  public final int getLastVisiblePosition()
  {
    return this.vtA.getLastVisiblePosition();
  }
  
  @Deprecated
  public final ListView getListView()
  {
    return this.vtA.getListView();
  }
  
  public final String getTalkerUserName()
  {
    if (this.pSb == null) {
      return "";
    }
    return bk.aM(this.pSb.field_username, "");
  }
  
  public final void np(boolean paramBoolean)
  {
    y.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.vtA.showOptionMenu(2, paramBoolean);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    y.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vtA.setKeepScreenOn(paramBoolean);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    y.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vtA.showOptionMenu(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.vtz.startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */