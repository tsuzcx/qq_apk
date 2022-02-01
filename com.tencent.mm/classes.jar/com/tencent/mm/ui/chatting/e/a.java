package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static MMHandler PvY;
  public as GUe;
  public String PkU;
  public com.tencent.mm.ui.chatting.i.a PvZ;
  public b Pwa;
  public p Pwb;
  public BaseChattingUIFragment Pwc;
  public ae Pwd;
  public com.tencent.mm.ui.chatting.af Pwe;
  public int Pwf;
  public boolean Pwg;
  public String Pwh;
  public boolean Pwi;
  public boolean Pwj;
  private boolean Pwk;
  public boolean Pwl;
  public ConcurrentLinkedQueue<d.a> Pwm;
  public boolean cQp;
  public String kIg;
  
  static
  {
    AppMethodBeat.i(35852);
    PvY = new MMHandler();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, ae paramae, com.tencent.mm.ui.chatting.af paramaf)
  {
    AppMethodBeat.i(35817);
    this.PvZ = new com.tencent.mm.ui.chatting.i.a(this);
    this.Pwa = new b(this);
    this.Pwb = new p();
    this.cQp = false;
    this.Pwg = false;
    this.Pwi = true;
    this.Pwj = false;
    this.Pwk = false;
    this.Pwl = false;
    this.Pwm = new ConcurrentLinkedQueue();
    this.Pwc = paramBaseChattingUIFragment;
    this.Pwd = paramae;
    this.Pwe = paramaf;
    AppMethodBeat.o(35817);
  }
  
  private static List<d.a> a(ConcurrentLinkedQueue<d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(233273);
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
      AppMethodBeat.o(233273);
      return localLinkedList;
    }
  }
  
  public static MMHandler gRP()
  {
    return PvY;
  }
  
  public final void BN(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Pwd.BN(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void BW(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.Pwd.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void BX(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    Log.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    this.Pwk = paramBoolean;
    AppMethodBeat.o(179936);
  }
  
  public final void a(Intent paramIntent, int paramInt, c.a parama)
  {
    AppMethodBeat.i(35830);
    this.Pwa.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends com.tencent.mm.ui.chatting.d.af> paramClass, com.tencent.mm.ui.chatting.d.af paramaf)
  {
    AppMethodBeat.i(35851);
    this.PvZ.a(paramClass, paramaf);
    AppMethodBeat.o(35851);
  }
  
  public final void amK(int paramInt)
  {
    AppMethodBeat.i(35849);
    Log.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.Pwd.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void amm(int paramInt)
  {
    AppMethodBeat.i(35841);
    Log.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.Pwd.amm(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void amo(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.Pwd.amo(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void aw(as paramas)
  {
    AppMethodBeat.i(35819);
    this.GUe = paramas;
    this.Pwh = com.tencent.xweb.util.d.getMessageDigest((paramas.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(233272);
    Log.i("MicroMsg.ChattingContext", "[showDialog]");
    this.Pwd.b(paramContext, paramString1, paramString2, paramOnCancelListener);
    AppMethodBeat.o(233272);
  }
  
  public final <T extends com.tencent.mm.ui.chatting.d.af, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.PvZ.bh(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final String bul()
  {
    if (this.kIg != null) {
      return this.kIg;
    }
    return "";
  }
  
  public final int cda()
  {
    AppMethodBeat.i(233271);
    int i = this.Pwd.cda();
    AppMethodBeat.o(233271);
    return i;
  }
  
  public final void cmy()
  {
    AppMethodBeat.i(35840);
    Log.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.Pwd.cmy();
    AppMethodBeat.o(35840);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    Log.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.Pwd.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.Pwc.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final void gNY()
  {
    AppMethodBeat.i(35843);
    Log.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.Pwd.gNY();
    AppMethodBeat.o(35843);
  }
  
  public final String gOZ()
  {
    AppMethodBeat.i(35821);
    String str = Util.nullAs(((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOZ(), this.GUe.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final String gRI()
  {
    AppMethodBeat.i(35820);
    if (this.PkU == null)
    {
      this.PkU = z.aTY();
      if (!as.IG(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = as.bjz(this.PkU);; str = this.PkU)
    {
      this.PkU = str;
      str = this.PkU;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final MMFragment gRJ()
  {
    return this.Pwc;
  }
  
  public final boolean gRK()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((as.IG(str)) || (as.bjo(str)) || (as.bjm(str)) || (ab.Ji(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean gRL()
  {
    AppMethodBeat.i(35826);
    if ((ab.Eq(getTalkerUserName())) || (ab.Iy(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean gRM()
  {
    AppMethodBeat.i(35827);
    if ((ab.Eq(getTalkerUserName())) || (ab.Iy(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean gRN()
  {
    AppMethodBeat.i(35828);
    if ((!this.GUe.gBM()) && (!ab.Jz(getTalkerUserName())) && (!as.bjm(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final boolean gRO()
  {
    AppMethodBeat.i(258284);
    boolean bool = as.HF(getTalkerUserName());
    AppMethodBeat.o(258284);
    return bool;
  }
  
  public final com.tencent.mm.ui.chatting.af gRQ()
  {
    return this.Pwe;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.Pwd.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(258283);
    Activity localActivity = this.Pwc.getContext();
    AppMethodBeat.o(258283);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.Pwd.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getHeaderViewsCount()
  {
    AppMethodBeat.i(35835);
    int i = this.Pwd.getHeaderViewsCount();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.Pwd.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.Pwd.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(258282);
    Resources localResources = this.Pwc.getMMResources();
    AppMethodBeat.o(258282);
    return localResources;
  }
  
  public final as getTalker()
  {
    return this.GUe;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.GUe == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = Util.nullAs(this.GUe.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    Log.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.Pwd.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void lf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    Log.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.Pwd.lf(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(35845);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.Pwd.scrollToPosition(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    Log.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Pwk), Boolean.valueOf(this.Pwj), Util.getStack() });
    if (this.Pwk)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.Pwi = paramBoolean;
    if ((paramBoolean) && (this.Pwj))
    {
      this.Pwj = false;
      if (this.Pwd != null)
      {
        Iterator localIterator = a(this.Pwm).iterator();
        while (localIterator.hasNext())
        {
          d.a locala = (d.a)localIterator.next();
          Log.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.Pwd.a(locala);
        }
      }
      this.Pwm.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    Log.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Pwd.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Pwd.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.Pwc;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, paramIntent.axQ(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a
 * JD-Core Version:    0.7.0.1
 */