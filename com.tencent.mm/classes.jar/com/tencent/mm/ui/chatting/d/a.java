package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ad;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.c.ab;
import com.tencent.mm.ui.chatting.c.n;
import com.tencent.mm.ui.chatting.h.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static ao HZA;
  public ai AzG;
  public com.tencent.mm.ui.chatting.h.a HZB;
  public b HZC;
  public n HZD;
  public String HZE;
  public BaseChattingUIFragment HZF;
  public ad HZG;
  public ae HZH;
  public String HZI;
  public boolean HZJ;
  public boolean HZK;
  private boolean HZL;
  public ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.g.d.a> HZM;
  public boolean cqM;
  public String jjx;
  
  static
  {
    AppMethodBeat.i(35852);
    HZA = new ao();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, ad paramad, ae paramae)
  {
    AppMethodBeat.i(35817);
    this.HZB = new com.tencent.mm.ui.chatting.h.a(this);
    this.HZC = new b(this);
    this.HZD = new n();
    this.cqM = false;
    this.HZJ = true;
    this.HZK = false;
    this.HZL = false;
    this.HZM = new ConcurrentLinkedQueue();
    this.HZF = paramBaseChattingUIFragment;
    this.HZG = paramad;
    this.HZH = paramae;
    AppMethodBeat.o(35817);
  }
  
  private static List<com.tencent.mm.ui.chatting.g.d.a> a(ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.g.d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(196536);
    LinkedList localLinkedList = new LinkedList();
    com.tencent.mm.ui.chatting.g.d.a locala = null;
    Iterator localIterator = paramConcurrentLinkedQueue.iterator();
    paramConcurrentLinkedQueue = locala;
    if (localIterator.hasNext())
    {
      locala = (com.tencent.mm.ui.chatting.g.d.a)localIterator.next();
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
      AppMethodBeat.o(196536);
      return localLinkedList;
    }
  }
  
  public static ao foS()
  {
    return HZA;
  }
  
  public final void a(Intent paramIntent, int paramInt, com.tencent.mm.br.d.a parama)
  {
    AppMethodBeat.i(35830);
    this.HZC.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends ab> paramClass, ab paramab)
  {
    AppMethodBeat.i(35851);
    this.HZB.a(paramClass, paramab);
    AppMethodBeat.o(35851);
  }
  
  public final String aVg()
  {
    if (this.jjx != null) {
      return this.jjx;
    }
    return "";
  }
  
  public final void aaK(int paramInt)
  {
    AppMethodBeat.i(35841);
    ac.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.HZG.aaK(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void aaL(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.HZG.aaL(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void abg(int paramInt)
  {
    AppMethodBeat.i(35849);
    ac.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.HZG.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void an(ai paramai)
  {
    AppMethodBeat.i(35819);
    this.AzG = paramai;
    this.HZI = com.tencent.xweb.util.d.getMessageDigest((paramai.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(35837);
    ac.i("MicroMsg.ChattingContext", "[showDialog]");
    this.HZG.b(paramContext, paramString, paramOnCancelListener);
    AppMethodBeat.o(35837);
  }
  
  public final void bJU()
  {
    AppMethodBeat.i(35840);
    ac.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.HZG.bJU();
    AppMethodBeat.o(35840);
  }
  
  public final <T extends ab, V extends Class<T>> T bf(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.HZB.bf(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(35845);
    ac.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.HZG.ca(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    ac.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.HZG.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.HZF.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final void flA()
  {
    AppMethodBeat.i(196535);
    ac.i("MicroMsg.ChattingContext", "[scrollToLast]");
    this.HZG.flA();
    AppMethodBeat.o(196535);
  }
  
  public final void flB()
  {
    AppMethodBeat.i(35843);
    ac.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.HZG.flB();
    AppMethodBeat.o(35843);
  }
  
  public final String fmy()
  {
    AppMethodBeat.i(35821);
    String str = bs.bG(((com.tencent.mm.ui.chatting.c.b.d)bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmy(), this.AzG.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final String foM()
  {
    AppMethodBeat.i(35820);
    if (this.HZE == null)
    {
      this.HZE = u.axw();
      if (!ai.ww(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = ai.aNh(this.HZE);; str = this.HZE)
    {
      this.HZE = str;
      str = this.HZE;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final MMFragment foN()
  {
    return this.HZF;
  }
  
  public final boolean foO()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((ai.ww(str)) || (ai.aNb(str)) || (ai.aMZ(str)) || (w.wW(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean foP()
  {
    AppMethodBeat.i(35826);
    if ((w.sQ(getTalkerUserName())) || (w.wq(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean foQ()
  {
    AppMethodBeat.i(35827);
    if ((w.sQ(getTalkerUserName())) || (w.wq(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean foR()
  {
    AppMethodBeat.i(35828);
    if ((!this.AzG.fad()) && (!w.xn(getTalkerUserName())) && (!ai.aMZ(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.HZG.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(210138);
    Activity localActivity = this.HZF.getContext();
    AppMethodBeat.o(210138);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.HZG.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(35835);
    int i = this.HZG.getHeaderViewsCount();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.HZG.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.HZG.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(210137);
    Resources localResources = this.HZF.getMMResources();
    AppMethodBeat.o(210137);
    return localResources;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.AzG == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = bs.bG(this.AzG.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    ac.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.HZG.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void jF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    ac.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.HZG.jF(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    ac.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HZL), Boolean.valueOf(this.HZK), bs.eWi() });
    if (this.HZL)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.HZJ = paramBoolean;
    if ((paramBoolean) && (this.HZK))
    {
      this.HZK = false;
      if (this.HZG != null)
      {
        Iterator localIterator = a(this.HZM).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.chatting.g.d.a locala = (com.tencent.mm.ui.chatting.g.d.a)localIterator.next();
          ac.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.HZG.a(locala);
        }
      }
      this.HZM.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    ac.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.HZG.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    ac.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.HZG.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.HZF;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, paramIntent.aeD(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
  
  public final void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    ac.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.HZG.xg(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    ac.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.HZG.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void xp(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    ac.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi() });
    this.HZL = paramBoolean;
    AppMethodBeat.o(179936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.a
 * JD-Core Version:    0.7.0.1
 */