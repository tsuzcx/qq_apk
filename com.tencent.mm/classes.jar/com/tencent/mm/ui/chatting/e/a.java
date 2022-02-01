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
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.chatting.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static ap JOM;
  public am BYG;
  public com.tencent.mm.ui.chatting.i.a JON;
  public b JOO;
  public p JOP;
  public String JOQ;
  public BaseChattingUIFragment JOR;
  public com.tencent.mm.ui.chatting.ad JOS;
  public ae JOT;
  public int JOU;
  public boolean JOV;
  public String JOW;
  public boolean JOX;
  public boolean JOY;
  private boolean JOZ;
  public boolean JPa;
  public ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.h.d.a> JPb;
  public boolean cBJ;
  public String jDl;
  
  static
  {
    AppMethodBeat.i(35852);
    JOM = new ap();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, com.tencent.mm.ui.chatting.ad paramad, ae paramae)
  {
    AppMethodBeat.i(35817);
    this.JON = new com.tencent.mm.ui.chatting.i.a(this);
    this.JOO = new b(this);
    this.JOP = new p();
    this.cBJ = false;
    this.JOV = false;
    this.JOX = true;
    this.JOY = false;
    this.JOZ = false;
    this.JPa = false;
    this.JPb = new ConcurrentLinkedQueue();
    this.JOR = paramBaseChattingUIFragment;
    this.JOS = paramad;
    this.JOT = paramae;
    AppMethodBeat.o(35817);
  }
  
  private static List<com.tencent.mm.ui.chatting.h.d.a> a(ConcurrentLinkedQueue<com.tencent.mm.ui.chatting.h.d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(194129);
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
      AppMethodBeat.o(194129);
      return localLinkedList;
    }
  }
  
  public static ap fFx()
  {
    return JOM;
  }
  
  public final void a(Intent paramIntent, int paramInt, com.tencent.mm.bs.d.a parama)
  {
    AppMethodBeat.i(35830);
    this.JOO.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends com.tencent.mm.ui.chatting.d.ad> paramClass, com.tencent.mm.ui.chatting.d.ad paramad)
  {
    AppMethodBeat.i(35851);
    this.JON.a(paramClass, paramad);
    AppMethodBeat.o(35851);
  }
  
  public final String aYA()
  {
    if (this.jDl != null) {
      return this.jDl;
    }
    return "";
  }
  
  public final void acU(int paramInt)
  {
    AppMethodBeat.i(35841);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.JOS.acU(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void acW(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.JOS.acW(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void ads(int paramInt)
  {
    AppMethodBeat.i(35849);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.JOS.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void an(am paramam)
  {
    AppMethodBeat.i(35819);
    this.BYG = paramam;
    this.JOW = com.tencent.xweb.util.d.getMessageDigest((paramam.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(35837);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showDialog]");
    this.JOS.b(paramContext, paramString, paramOnCancelListener);
    AppMethodBeat.o(35837);
  }
  
  public final int bFG()
  {
    AppMethodBeat.i(194128);
    int i = this.JOS.bFG();
    AppMethodBeat.o(194128);
    return i;
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(35840);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.JOS.bOo();
    AppMethodBeat.o(35840);
  }
  
  public final <T extends com.tencent.mm.ui.chatting.d.ad, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.JON.bh(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(35845);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.JOS.ca(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.JOS.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final void fBR()
  {
    AppMethodBeat.i(35843);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.JOS.fBR();
    AppMethodBeat.o(35843);
  }
  
  public final String fCR()
  {
    AppMethodBeat.i(35821);
    String str = bt.bI(((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCR(), this.BYG.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final String fFr()
  {
    AppMethodBeat.i(35820);
    if (this.JOQ == null)
    {
      this.JOQ = u.aAm();
      if (!am.zs(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = am.aSZ(this.JOQ);; str = this.JOQ)
    {
      this.JOQ = str;
      str = this.JOQ;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final MMFragment fFs()
  {
    return this.JOR;
  }
  
  public final boolean fFt()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((am.zs(str)) || (am.aSP(str)) || (am.aSN(str)) || (w.zT(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean fFu()
  {
    AppMethodBeat.i(35826);
    if ((w.vF(getTalkerUserName())) || (w.zl(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean fFv()
  {
    AppMethodBeat.i(35827);
    if ((w.vF(getTalkerUserName())) || (w.zl(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean fFw()
  {
    AppMethodBeat.i(35828);
    if ((!this.BYG.fqg()) && (!w.Ak(getTalkerUserName())) && (!am.aSN(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH())
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
    View localView = this.JOR.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.JOS.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(221405);
    Activity localActivity = this.JOR.getContext();
    AppMethodBeat.o(221405);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.JOS.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(35835);
    int i = this.JOS.getHeaderViewsCount();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.JOS.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.JOS.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(221404);
    Resources localResources = this.JOR.getMMResources();
    AppMethodBeat.o(221404);
    return localResources;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.BYG == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = bt.bI(this.BYG.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.JOS.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void jR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.JOS.jR(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JOZ), Boolean.valueOf(this.JOY), bt.flS() });
    if (this.JOZ)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.JOX = paramBoolean;
    if ((paramBoolean) && (this.JOY))
    {
      this.JOY = false;
      if (this.JOS != null)
      {
        Iterator localIterator = a(this.JPb).iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.chatting.h.d.a locala = (com.tencent.mm.ui.chatting.h.d.a)localIterator.next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.JOS.a(locala);
        }
      }
      this.JPb.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.JOS.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.JOS.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.JOR;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, paramIntent.ahp(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
  
  public final void xR(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.JOS.xR(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void ya(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.JOS.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void yb(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), bt.flS() });
    this.JOZ = paramBoolean;
    AppMethodBeat.o(179936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a
 * JD-Core Version:    0.7.0.1
 */