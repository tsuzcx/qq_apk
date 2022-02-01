package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.component.aj;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.s;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.g.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static MMHandler aezK;
  public au Uxa;
  public String aemd;
  public com.tencent.mm.ui.chatting.g.a aezL;
  public b aezM;
  public s aezN;
  public BaseChattingUIFragment aezO;
  public ah aezP;
  public ai aezQ;
  public int aezR;
  public boolean aezS;
  public String aezT;
  public boolean aezU;
  public boolean aezV;
  private boolean aezW;
  public boolean aezX;
  public ConcurrentLinkedQueue<d.a> aezY;
  public boolean ffv;
  public String qBl;
  
  static
  {
    AppMethodBeat.i(35852);
    aezK = new MMHandler();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, ah paramah, ai paramai)
  {
    AppMethodBeat.i(35817);
    this.aezL = new com.tencent.mm.ui.chatting.g.a(this);
    this.aezM = new b(this);
    this.aezN = new s();
    this.ffv = false;
    this.aezS = false;
    this.aezU = true;
    this.aezV = false;
    this.aezW = false;
    this.aezX = false;
    this.aezY = new ConcurrentLinkedQueue();
    this.aezO = paramBaseChattingUIFragment;
    this.aezP = paramah;
    this.aezQ = paramai;
    AppMethodBeat.o(35817);
  }
  
  private static List<d.a> a(ConcurrentLinkedQueue<d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(253958);
    LinkedList localLinkedList = new LinkedList();
    d.a locala = null;
    Iterator localIterator = paramConcurrentLinkedQueue.iterator();
    paramConcurrentLinkedQueue = locala;
    if (localIterator.hasNext())
    {
      locala = (d.a)localIterator.next();
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
      AppMethodBeat.o(253958);
      return localLinkedList;
    }
  }
  
  public static MMHandler juI()
  {
    return aezK;
  }
  
  public final void Mf(boolean paramBoolean)
  {
    AppMethodBeat.i(254036);
    Log.i("MicroMsg.ChattingContext", "[scrollToLastImmediately]");
    if (Looper.getMainLooper() != Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      r(paramBoolean, bool, false);
      AppMethodBeat.o(254036);
      return;
    }
  }
  
  public final void Mg(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.aezP.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void Mh(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    Log.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    this.aezW = paramBoolean;
    AppMethodBeat.o(179936);
  }
  
  public final void a(Intent paramIntent, int paramInt, c.a parama)
  {
    AppMethodBeat.i(35830);
    this.aezM.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends aj> paramClass, aj paramaj)
  {
    AppMethodBeat.i(35851);
    this.aezL.a(paramClass, paramaj);
    AppMethodBeat.o(35851);
  }
  
  public final void aBQ(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.aezP.aBQ(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void aCr(int paramInt)
  {
    AppMethodBeat.i(35849);
    Log.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.aezP.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void aDM()
  {
    AppMethodBeat.i(35838);
    Log.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.aezP.aDM();
    AppMethodBeat.o(35838);
  }
  
  public final void aE(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    Log.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aezW), Boolean.valueOf(this.aezV) });
    if (this.aezW)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.aezU = paramBoolean;
    if ((paramBoolean) && (this.aezV))
    {
      this.aezV = false;
      if (this.aezP != null)
      {
        Iterator localIterator = a(this.aezY).iterator();
        while (localIterator.hasNext())
        {
          d.a locala = (d.a)localIterator.next();
          Log.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.aezP.a(locala);
        }
      }
      this.aezY.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void aI(au paramau)
  {
    AppMethodBeat.i(35819);
    this.Uxa = paramau;
    this.aezT = g.getMessageDigest((paramau.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(254029);
    Log.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s isIdleVisible:%s topOffset:%s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt2) });
    this.aezP.b(paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    AppMethodBeat.o(254029);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(254016);
    Log.i("MicroMsg.ChattingContext", "[showDialog]");
    this.aezP.b(paramContext, paramString1, paramString2, paramOnCancelListener);
    AppMethodBeat.o(254016);
  }
  
  public final int cST()
  {
    AppMethodBeat.i(254007);
    int i = this.aezP.cST();
    AppMethodBeat.o(254007);
    return i;
  }
  
  public final String cez()
  {
    if (this.qBl != null) {
      return this.qBl;
    }
    return "";
  }
  
  public final <T extends aj, V extends Class<T>> T cm(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.aezL.cm(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(35840);
    Log.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.aezP.dcZ();
    AppMethodBeat.o(35840);
  }
  
  public final void ev(View paramView)
  {
    AppMethodBeat.i(254010);
    this.aezP.ev(paramView);
    AppMethodBeat.o(254010);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.aezO.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.aezP.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(369645);
    Activity localActivity = this.aezO.getContext();
    AppMethodBeat.o(369645);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.aezP.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.aezP.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.aezP.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(369644);
    Resources localResources = this.aezO.getMMResources();
    AppMethodBeat.o(369644);
    return localResources;
  }
  
  public final String getSelfUserName()
  {
    AppMethodBeat.i(35820);
    if (this.aemd == null)
    {
      this.aemd = z.bAM();
      if (!au.bwS(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = au.bxd(this.aemd);; str = this.aemd)
    {
      this.aemd = str;
      str = this.aemd;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.Uxa == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = Util.nullAs(this.Uxa.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(254031);
    Log.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s isIdleVisible:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.aezP.h(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(254031);
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    Log.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.aezP.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final int joT()
  {
    AppMethodBeat.i(35835);
    int i = this.aezP.joT();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final void jpK()
  {
    AppMethodBeat.i(254040);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast]1 force:%b", new Object[] { Boolean.TRUE });
    this.aezP.jpK();
    AppMethodBeat.o(254040);
  }
  
  public final void jpL()
  {
    AppMethodBeat.i(35843);
    Log.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.aezP.jpL();
    AppMethodBeat.o(35843);
  }
  
  public final void jpQ()
  {
    AppMethodBeat.i(253998);
    this.aezP.jpQ();
    AppMethodBeat.o(253998);
  }
  
  public final String jrh()
  {
    AppMethodBeat.i(35821);
    String str = Util.nullAs(((e)cm(e.class)).jrh(), this.Uxa.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final boolean juE()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((au.bwS(str)) || (au.bwN(str)) || (au.bwL(str)) || (au.bwf(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean juF()
  {
    AppMethodBeat.i(35826);
    if ((au.bwE(getTalkerUserName())) || (au.bwF(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean juG()
  {
    AppMethodBeat.i(35827);
    if ((au.bwE(getTalkerUserName())) || (au.bwF(getTalkerUserName())) || (((e)cm(e.class)).jqW()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean juH()
  {
    AppMethodBeat.i(35828);
    if ((!this.Uxa.iZC()) && (!au.bww(getTalkerUserName())) && (!au.bwL(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((e)cm(e.class)).jqV())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final boolean juJ()
  {
    AppMethodBeat.i(254049);
    ScrollControlListView.a locala = ScrollControlListView.Yub;
    boolean bool = ScrollControlListView.a.c(this.aezP.getListView());
    AppMethodBeat.o(254049);
    return bool;
  }
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(254044);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast]3 force:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
    this.aezP.r(paramBoolean1, paramBoolean2, paramBoolean3);
    AppMethodBeat.o(254044);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(35845);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.aezP.scrollToPosition(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    Log.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.aezP.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.aezP.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.aezO;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localBaseChattingUIFragment, paramIntent.aYi(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.a
 * JD-Core Version:    0.7.0.1
 */