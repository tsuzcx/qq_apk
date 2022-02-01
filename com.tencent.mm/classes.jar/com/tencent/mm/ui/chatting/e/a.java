package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.ad;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.chatting.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static aq KjY;
  public an Cqh;
  public com.tencent.mm.ui.chatting.i.a KjZ;
  public b Kka;
  public p Kkb;
  public String Kkc;
  public BaseChattingUIFragment Kkd;
  public com.tencent.mm.ui.chatting.ae Kke;
  public af Kkf;
  public int Kkg;
  public boolean Kkh;
  public String Kki;
  public boolean Kkj;
  public boolean Kkk;
  private boolean Kkl;
  public boolean Kkm;
  public ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.h.d.a> Kkn;
  public boolean cCq;
  public String jGj;
  
  static
  {
    AppMethodBeat.i(35852);
    KjY = new aq();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, com.tencent.mm.ui.chatting.ae paramae, af paramaf)
  {
    AppMethodBeat.i(35817);
    this.KjZ = new com.tencent.mm.ui.chatting.i.a(this);
    this.Kka = new b(this);
    this.Kkb = new p();
    this.cCq = false;
    this.Kkh = false;
    this.Kkj = true;
    this.Kkk = false;
    this.Kkl = false;
    this.Kkm = false;
    this.Kkn = new ConcurrentLinkedQueue();
    this.Kkd = paramBaseChattingUIFragment;
    this.Kke = paramae;
    this.Kkf = paramaf;
    AppMethodBeat.o(35817);
  }
  
  private static List<com.tencent.mm.ui.chatting.h.d.a> a(ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.h.d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(187466);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.ui.chatting.h.d.a locala = null;
    Iterator localIterator = paramConcurrentLinkedQueue.iterator();
    paramConcurrentLinkedQueue = locala;
    if (localIterator.hasNext())
    {
      locala = (com.tencent.mm.ui.chatting.h.d.a)localIterator.next();
      if (locala == paramConcurrentLinkedQueue) {
        break label64;
      }
      localLinkedList.add(locala);
      paramConcurrentLinkedQueue = locala;
    }
    label64:
    for (;;)
    {
      break;
      AppMethodBeat.o(187466);
      return localLinkedList;
    }
  }
  
  public static aq fJE()
  {
    return KjY;
  }
  
  public final void a(Intent paramIntent, int paramInt, com.tencent.mm.br.d.a parama)
  {
    AppMethodBeat.i(35830);
    this.Kka.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends ad> paramClass, ad paramad)
  {
    AppMethodBeat.i(35851);
    this.KjZ.a(paramClass, paramad);
    AppMethodBeat.o(35851);
  }
  
  public final String aYW()
  {
    if (this.jGj != null) {
      return this.jGj;
    }
    return "";
  }
  
  public final void adC(int paramInt)
  {
    AppMethodBeat.i(35841);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.Kke.adC(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void adE(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.Kke.adE(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void adZ(int paramInt)
  {
    AppMethodBeat.i(35849);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.Kke.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void au(an paraman)
  {
    AppMethodBeat.i(35819);
    this.Cqh = paraman;
    this.Kki = com.tencent.xweb.util.d.getMessageDigest((paraman.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(35837);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[showDialog]");
    this.Kke.b(paramContext, paramString, paramOnCancelListener);
    AppMethodBeat.o(35837);
  }
  
  public final int bGB()
  {
    AppMethodBeat.i(187465);
    int i = this.Kke.bGB();
    AppMethodBeat.o(187465);
    return i;
  }
  
  public final void bPl()
  {
    AppMethodBeat.i(35840);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.Kke.bPl();
    AppMethodBeat.o(35840);
  }
  
  public final <T extends ad, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.KjZ.bh(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(35845);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.Kke.ca(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.Kke.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final void fFT()
  {
    AppMethodBeat.i(35843);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.Kke.fFT();
    AppMethodBeat.o(35843);
  }
  
  public final String fGT()
  {
    AppMethodBeat.i(35821);
    String str = bu.bI(((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGT(), this.Cqh.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final boolean fJA()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((an.Ac(str)) || (an.aUp(str)) || (an.aUn(str)) || (x.AD(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean fJB()
  {
    AppMethodBeat.i(35826);
    if ((x.wb(getTalkerUserName())) || (x.zV(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean fJC()
  {
    AppMethodBeat.i(35827);
    if ((x.wb(getTalkerUserName())) || (x.zV(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean fJD()
  {
    AppMethodBeat.i(35828);
    if ((!this.Cqh.fug()) && (!x.AU(getTalkerUserName())) && (!an.aUn(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final String fJy()
  {
    AppMethodBeat.i(35820);
    if (this.Kkc == null)
    {
      this.Kkc = v.aAC();
      if (!an.Ac(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = an.aUA(this.Kkc);; str = this.Kkc)
    {
      this.Kkc = str;
      str = this.Kkc;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final MMFragment fJz()
  {
    return this.Kkd;
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.Kkd.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.Kke.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(224193);
    Activity localActivity = this.Kkd.getContext();
    AppMethodBeat.o(224193);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.Kke.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(35835);
    int i = this.Kke.getHeaderViewsCount();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.Kke.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.Kke.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(224192);
    Resources localResources = this.Kkd.getMMResources();
    AppMethodBeat.o(224192);
    return localResources;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.Cqh == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = bu.bI(this.Cqh.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.Kke.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.Kke.jV(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Kkl), Boolean.valueOf(this.Kkk), bu.fpN() });
    if (this.Kkl)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.Kkj = paramBoolean;
    if ((paramBoolean) && (this.Kkk))
    {
      this.Kkk = false;
      if (this.Kke != null)
      {
        Iterator localIterator = a(this.Kkn).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.chatting.h.d.a locala = (com.tencent.mm.ui.chatting.h.d.a)localIterator.next();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.Kke.a(locala);
        }
      }
      this.Kkn.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Kke.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Kke.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.Kkd;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, paramIntent.ahE(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
  
  public final void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Kke.xY(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void yh(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.Kke.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void yi(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), bu.fpN() });
    this.Kkl = paramBoolean;
    AppMethodBeat.o(179936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a
 * JD-Core Version:    0.7.0.1
 */