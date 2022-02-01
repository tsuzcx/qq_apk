package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
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
  private static ap GzE;
  public com.tencent.mm.ui.chatting.h.a GzF;
  public b GzG;
  public n GzH;
  public String GzI;
  public BaseChattingUIFragment GzJ;
  public com.tencent.mm.ui.chatting.ad GzK;
  public ae GzL;
  public String GzM;
  public String GzN;
  public boolean GzO;
  public boolean GzP;
  private boolean GzQ;
  public ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.g.d.a> GzR;
  public boolean ctF;
  public af zgX;
  
  static
  {
    AppMethodBeat.i(35852);
    GzE = new ap();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, com.tencent.mm.ui.chatting.ad paramad, ae paramae)
  {
    AppMethodBeat.i(35817);
    this.GzF = new com.tencent.mm.ui.chatting.h.a(this);
    this.GzG = new b(this);
    this.GzH = new n();
    this.ctF = false;
    this.GzO = true;
    this.GzP = false;
    this.GzQ = false;
    this.GzR = new ConcurrentLinkedQueue();
    this.GzJ = paramBaseChattingUIFragment;
    this.GzK = paramad;
    this.GzL = paramae;
    AppMethodBeat.o(35817);
  }
  
  private static List<com.tencent.mm.ui.chatting.g.d.a> a(ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.g.d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(191543);
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
      AppMethodBeat.o(191543);
      return localLinkedList;
    }
  }
  
  public static ap eZd()
  {
    return GzE;
  }
  
  public final void YA(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.GzK.YA(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void YU(int paramInt)
  {
    AppMethodBeat.i(35849);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.GzK.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void Yz(int paramInt)
  {
    AppMethodBeat.i(35841);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.GzK.Yz(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void a(Intent paramIntent, int paramInt, com.tencent.mm.bs.d.a parama)
  {
    AppMethodBeat.i(35830);
    this.GzG.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends ab> paramClass, ab paramab)
  {
    AppMethodBeat.i(35851);
    this.GzF.a(paramClass, paramab);
    AppMethodBeat.o(35851);
  }
  
  public final void am(af paramaf)
  {
    AppMethodBeat.i(35819);
    this.zgX = paramaf;
    this.GzM = com.tencent.xweb.util.d.getMessageDigest((paramaf.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(35837);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showDialog]");
    this.GzK.b(paramContext, paramString, paramOnCancelListener);
    AppMethodBeat.o(35837);
  }
  
  public final void bCM()
  {
    AppMethodBeat.i(35840);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.GzK.bCM();
    AppMethodBeat.o(35840);
  }
  
  public final <T extends ab, V extends Class<T>> T be(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.GzF.be(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(35845);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.GzK.ca(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.GzK.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final void eVO()
  {
    AppMethodBeat.i(191542);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast]");
    this.GzK.eVO();
    AppMethodBeat.o(191542);
  }
  
  public final void eVP()
  {
    AppMethodBeat.i(35843);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.GzK.eVP();
    AppMethodBeat.o(35843);
  }
  
  public final String eWM()
  {
    AppMethodBeat.i(35821);
    String str = bt.by(((com.tencent.mm.ui.chatting.c.b.d)be(com.tencent.mm.ui.chatting.c.b.d.class)).eWM(), this.zgX.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final String eYW()
  {
    if (this.GzN != null) {
      return this.GzN;
    }
    return "";
  }
  
  public final String eYX()
  {
    AppMethodBeat.i(35820);
    if (this.GzI == null)
    {
      this.GzI = u.aqG();
      if (!af.st(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = af.aHM(this.GzI);; str = this.GzI)
    {
      this.GzI = str;
      str = this.GzI;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final MMFragment eYY()
  {
    return this.GzJ;
  }
  
  public final boolean eYZ()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((af.st(str)) || (af.aHG(str)) || (af.aHE(str)) || (w.sT(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean eZa()
  {
    AppMethodBeat.i(35826);
    if ((w.pF(getTalkerUserName())) || (w.sn(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean eZb()
  {
    AppMethodBeat.i(35827);
    if ((w.pF(getTalkerUserName())) || (w.sn(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.c.b.d)be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean eZc()
  {
    AppMethodBeat.i(35828);
    if ((!this.zgX.eKB()) && (!w.tk(getTalkerUserName())) && (!af.aHE(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.c.b.d)be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.GzJ.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.GzK.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(204970);
    Activity localActivity = this.GzJ.getContext();
    AppMethodBeat.o(204970);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.GzK.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(35835);
    int i = this.GzK.getHeaderViewsCount();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.GzK.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.GzK.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(204969);
    Resources localResources = this.GzJ.getMMResources();
    AppMethodBeat.o(204969);
    return localResources;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.zgX == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = bt.by(this.zgX.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.GzK.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void jt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.GzK.jt(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.GzQ), Boolean.valueOf(this.GzP), bt.eGN() });
    if (this.GzQ)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.GzO = paramBoolean;
    if ((paramBoolean) && (this.GzP))
    {
      this.GzP = false;
      if (this.GzK != null)
      {
        Iterator localIterator = a(this.GzR).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.chatting.g.d.a locala = (com.tencent.mm.ui.chatting.g.d.a)localIterator.next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.GzK.a(locala);
        }
      }
      this.GzR.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GzK.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GzK.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.GzJ;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, paramIntent.adn(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
  
  public final void wc(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GzK.wc(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void wk(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.GzK.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void wl(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN() });
    this.GzQ = paramBoolean;
    AppMethodBeat.o(179936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.a
 * JD-Core Version:    0.7.0.1
 */