package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.c.v;
import com.tencent.mm.ui.chatting.g.b;

public final class a
{
  private static ak zJv;
  public boolean bSe;
  public com.tencent.mm.storage.ad txj;
  public com.tencent.mm.ui.chatting.ad zJA;
  public ae zJB;
  public String zJC;
  public String zJD;
  public com.tencent.mm.ui.chatting.g.a zJw;
  public b zJx;
  public String zJy;
  public BaseChattingUIFragment zJz;
  
  static
  {
    AppMethodBeat.i(31947);
    zJv = new ak();
    AppMethodBeat.o(31947);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, com.tencent.mm.ui.chatting.ad paramad, ae paramae)
  {
    AppMethodBeat.i(31911);
    this.zJw = new com.tencent.mm.ui.chatting.g.a(this);
    this.zJx = new b(this);
    this.bSe = false;
    this.zJz = paramBaseChattingUIFragment;
    this.zJA = paramad;
    this.zJB = paramae;
    AppMethodBeat.o(31911);
  }
  
  public static ak dJI()
  {
    return zJv;
  }
  
  public final void PN(int paramInt)
  {
    AppMethodBeat.i(31944);
    ab.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.zJA.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(31944);
  }
  
  public final void Pu(int paramInt)
  {
    AppMethodBeat.i(31935);
    ab.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.zJA.Pu(paramInt);
    AppMethodBeat.o(31935);
  }
  
  public final void Pv(int paramInt)
  {
    AppMethodBeat.i(31925);
    this.zJA.Pv(paramInt);
    AppMethodBeat.o(31925);
  }
  
  public final void a(Intent paramIntent, int paramInt, d.a parama)
  {
    AppMethodBeat.i(31923);
    this.zJx.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(31923);
  }
  
  public final void a(Class<? extends v> paramClass, v paramv)
  {
    AppMethodBeat.i(31946);
    this.zJw.a(paramClass, paramv);
    AppMethodBeat.o(31946);
  }
  
  public final void aWN()
  {
    AppMethodBeat.i(31934);
    ab.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.zJA.aWN();
    AppMethodBeat.o(31934);
  }
  
  public final void ae(com.tencent.mm.storage.ad paramad)
  {
    AppMethodBeat.i(31913);
    this.txj = paramad;
    this.zJC = com.tencent.xweb.util.d.w((paramad.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(31913);
  }
  
  public final <T extends v, V extends Class<T>> T ay(V paramV)
  {
    AppMethodBeat.i(31945);
    paramV = this.zJw.ay(paramV);
    AppMethodBeat.o(31945);
    return paramV;
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(31940);
    ab.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.zJA.bJ(paramInt);
    AppMethodBeat.o(31940);
  }
  
  public final void c(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(31930);
    ab.i("MicroMsg.ChattingContext", "[showDialog]");
    this.zJA.c(paramContext, paramString, paramOnCancelListener);
    AppMethodBeat.o(31930);
  }
  
  public final void dGJ()
  {
    AppMethodBeat.i(31937);
    ab.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.zJA.dGJ();
    AppMethodBeat.o(31937);
  }
  
  public final String dHF()
  {
    AppMethodBeat.i(31915);
    String str = bo.bf(((com.tencent.mm.ui.chatting.c.b.d)ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHF(), this.txj.field_nickname);
    AppMethodBeat.o(31915);
    return str;
  }
  
  public final String dJC()
  {
    if (this.zJD != null) {
      return this.zJD;
    }
    return "";
  }
  
  public final String dJD()
  {
    AppMethodBeat.i(31914);
    if (this.zJy == null)
    {
      this.zJy = r.Zn();
      if (!com.tencent.mm.storage.ad.nM(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = com.tencent.mm.storage.ad.ark(this.zJy);; str = this.zJy)
    {
      this.zJy = str;
      str = this.zJy;
      AppMethodBeat.o(31914);
      return str;
    }
  }
  
  public final boolean dJE()
  {
    AppMethodBeat.i(31918);
    String str = getTalkerUserName();
    if ((com.tencent.mm.storage.ad.nM(str)) || (com.tencent.mm.storage.ad.are(str)) || (com.tencent.mm.storage.ad.arc(str)) || (t.oj(str)))
    {
      AppMethodBeat.o(31918);
      return true;
    }
    AppMethodBeat.o(31918);
    return false;
  }
  
  public final boolean dJF()
  {
    AppMethodBeat.i(31919);
    if ((t.lA(getTalkerUserName())) || (t.nK(getTalkerUserName())))
    {
      AppMethodBeat.o(31919);
      return true;
    }
    AppMethodBeat.o(31919);
    return false;
  }
  
  public final boolean dJG()
  {
    AppMethodBeat.i(31920);
    if ((t.lA(getTalkerUserName())) || (t.nK(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw()))
    {
      AppMethodBeat.o(31920);
      return true;
    }
    AppMethodBeat.o(31920);
    return false;
  }
  
  public final boolean dJH()
  {
    AppMethodBeat.i(31921);
    if ((!this.txj.dwz()) && (!t.oA(getTalkerUserName())) && (!com.tencent.mm.storage.ad.arc(getTalkerUserName())))
    {
      AppMethodBeat.o(31921);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv())
    {
      AppMethodBeat.o(31921);
      return true;
    }
    AppMethodBeat.o(31921);
    return false;
  }
  
  public final void dJJ()
  {
    AppMethodBeat.i(31939);
    ab.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.TRUE });
    this.zJA.ak(true, true);
    AppMethodBeat.o(31939);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(31931);
    ab.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.zJA.dismissDialog();
    AppMethodBeat.o(31931);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(31916);
    View localView = this.zJz.findViewById(paramInt);
    AppMethodBeat.o(31916);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(31929);
    View localView = this.zJA.getChildAt(paramInt);
    AppMethodBeat.o(31929);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(156907);
    Activity localActivity = this.zJz.getContext();
    AppMethodBeat.o(156907);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(31926);
    int i = this.zJA.getFirstVisiblePosition();
    AppMethodBeat.o(31926);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(31928);
    int i = this.zJA.getHeaderViewsCount();
    AppMethodBeat.o(31928);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(31927);
    int i = this.zJA.getLastVisiblePosition();
    AppMethodBeat.o(31927);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(31924);
    ListView localListView = this.zJA.getListView();
    AppMethodBeat.o(31924);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(156906);
    Resources localResources = this.zJz.getMMResources();
    AppMethodBeat.o(156906);
    return localResources;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(31912);
    if (this.txj == null)
    {
      AppMethodBeat.o(31912);
      return "";
    }
    String str = bo.bf(this.txj.field_username, "");
    AppMethodBeat.o(31912);
    return str;
  }
  
  public final void hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31936);
    ab.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.zJA.hF(paramInt1, paramInt2);
    AppMethodBeat.o(31936);
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(31932);
    ab.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.zJA.hideVKB();
    AppMethodBeat.o(31932);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(31938);
    ab.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zJA.qT(paramBoolean);
    AppMethodBeat.o(31938);
  }
  
  public final void qZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31942);
    ab.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.zJA.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(31942);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(31941);
    ab.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zJA.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(31941);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(31943);
    ab.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zJA.showOptionMenu(paramBoolean);
    AppMethodBeat.o(31943);
  }
  
  public final void showVKB()
  {
    AppMethodBeat.i(31933);
    ab.i("MicroMsg.ChattingContext", "[showVKB]");
    this.zJA.showVKB();
    AppMethodBeat.o(31933);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(31922);
    this.zJz.startActivity(paramIntent);
    AppMethodBeat.o(31922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.a
 * JD-Core Version:    0.7.0.1
 */