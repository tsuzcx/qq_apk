package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.ag;
import com.tencent.mm.ui.chatting.d.q;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static MMHandler WQr;
  public as NKq;
  public String WEE;
  public String WQA;
  public boolean WQB;
  public boolean WQC;
  private boolean WQD;
  public boolean WQE;
  public ConcurrentLinkedQueue<d.a> WQF;
  public com.tencent.mm.ui.chatting.i.a WQs;
  public b WQt;
  public q WQu;
  public BaseChattingUIFragment WQv;
  public ae WQw;
  public af WQx;
  public int WQy;
  public boolean WQz;
  public boolean dgo;
  public String nBW;
  
  static
  {
    AppMethodBeat.i(35852);
    WQr = new MMHandler();
    AppMethodBeat.o(35852);
  }
  
  public a(BaseChattingUIFragment paramBaseChattingUIFragment, ae paramae, af paramaf)
  {
    AppMethodBeat.i(35817);
    this.WQs = new com.tencent.mm.ui.chatting.i.a(this);
    this.WQt = new b(this);
    this.WQu = new q();
    this.dgo = false;
    this.WQz = false;
    this.WQB = true;
    this.WQC = false;
    this.WQD = false;
    this.WQE = false;
    this.WQF = new ConcurrentLinkedQueue();
    this.WQv = paramBaseChattingUIFragment;
    this.WQw = paramae;
    this.WQx = paramaf;
    AppMethodBeat.o(35817);
  }
  
  private static List<d.a> a(ConcurrentLinkedQueue<d.a> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(271262);
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
      AppMethodBeat.o(271262);
      return localLinkedList;
    }
  }
  
  public static MMHandler hRl()
  {
    return WQr;
  }
  
  public final void Gi(boolean paramBoolean)
  {
    AppMethodBeat.i(35844);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.WQw.Gi(paramBoolean);
    AppMethodBeat.o(35844);
  }
  
  public final void Gr(boolean paramBoolean)
  {
    AppMethodBeat.i(35847);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", new Object[] { Integer.valueOf(2), Boolean.valueOf(paramBoolean) });
    this.WQw.showOptionMenu(2, paramBoolean);
    AppMethodBeat.o(35847);
  }
  
  public final void Gs(boolean paramBoolean)
  {
    AppMethodBeat.i(179936);
    Log.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    this.WQD = paramBoolean;
    AppMethodBeat.o(179936);
  }
  
  public final void Y(boolean paramBoolean)
  {
    AppMethodBeat.i(179934);
    Log.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.WQD), Boolean.valueOf(this.WQC), Util.getStack() });
    if (this.WQD)
    {
      AppMethodBeat.o(179934);
      return;
    }
    this.WQB = paramBoolean;
    if ((paramBoolean) && (this.WQC))
    {
      this.WQC = false;
      if (this.WQw != null)
      {
        Iterator localIterator = a(this.WQF).iterator();
        while (localIterator.hasNext())
        {
          d.a locala = (d.a)localIterator.next();
          Log.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", new Object[] { locala });
          this.WQw.a(locala);
        }
      }
      this.WQF.clear();
    }
    AppMethodBeat.o(179934);
  }
  
  public final void a(Intent paramIntent, int paramInt, c.a parama)
  {
    AppMethodBeat.i(35830);
    this.WQt.a(paramIntent, paramInt, parama);
    AppMethodBeat.o(35830);
  }
  
  public final void a(Class<? extends ag> paramClass, ag paramag)
  {
    AppMethodBeat.i(35851);
    this.WQs.a(paramClass, paramag);
    AppMethodBeat.o(35851);
  }
  
  public final void aC(as paramas)
  {
    AppMethodBeat.i(35819);
    this.NKq = paramas;
    this.WQA = com.tencent.xweb.util.d.getMessageDigest((paramas.field_username + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(35819);
  }
  
  public final void avL(int paramInt)
  {
    AppMethodBeat.i(35849);
    Log.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt) });
    this.WQw.updateOptionMenuIcon(2, paramInt);
    AppMethodBeat.o(35849);
  }
  
  public final void avn(int paramInt)
  {
    AppMethodBeat.i(35841);
    Log.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    this.WQw.avn(paramInt);
    AppMethodBeat.o(35841);
  }
  
  public final void avp(int paramInt)
  {
    AppMethodBeat.i(35832);
    this.WQw.avp(paramInt);
    AppMethodBeat.o(35832);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(271258);
    Log.i("MicroMsg.ChattingContext", "[showDialog]");
    this.WQw.b(paramContext, paramString1, paramString2, paramOnCancelListener);
    AppMethodBeat.o(271258);
  }
  
  public final <T extends ag, V extends Class<T>> T bC(V paramV)
  {
    AppMethodBeat.i(35850);
    paramV = this.WQs.bC(paramV);
    AppMethodBeat.o(35850);
    return paramV;
  }
  
  public final String bFl()
  {
    if (this.nBW != null) {
      return this.nBW;
    }
    return "";
  }
  
  public final void cAe()
  {
    AppMethodBeat.i(35840);
    Log.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
    this.WQw.cAe();
    AppMethodBeat.o(35840);
  }
  
  public final int cqm()
  {
    AppMethodBeat.i(271256);
    int i = this.WQw.cqm();
    AppMethodBeat.o(271256);
    return i;
  }
  
  public final void dI(View paramView)
  {
    AppMethodBeat.i(271257);
    this.WQw.dI(paramView);
    AppMethodBeat.o(271257);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(35838);
    Log.i("MicroMsg.ChattingContext", "[dismissDialog]");
    this.WQw.dismissDialog();
    AppMethodBeat.o(35838);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(35823);
    View localView = this.WQv.findViewById(paramInt);
    AppMethodBeat.o(35823);
    return localView;
  }
  
  public final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(35836);
    View localView = this.WQw.getChildAt(paramInt);
    AppMethodBeat.o(35836);
    return localView;
  }
  
  public final Activity getContext()
  {
    AppMethodBeat.i(293259);
    Activity localActivity = this.WQv.getContext();
    AppMethodBeat.o(293259);
    return localActivity;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(35833);
    int i = this.WQw.getFirstVisiblePosition();
    AppMethodBeat.o(35833);
    return i;
  }
  
  public final int getLastVisiblePosition()
  {
    AppMethodBeat.i(35834);
    int i = this.WQw.getLastVisiblePosition();
    AppMethodBeat.o(35834);
    return i;
  }
  
  @Deprecated
  public final ListView getListView()
  {
    AppMethodBeat.i(35831);
    ListView localListView = this.WQw.getListView();
    AppMethodBeat.o(35831);
    return localListView;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(293258);
    Resources localResources = this.WQv.getMMResources();
    AppMethodBeat.o(293258);
    return localResources;
  }
  
  public final String getSelfUserName()
  {
    AppMethodBeat.i(35820);
    if (this.WEE == null)
    {
      this.WEE = z.bcZ();
      if (!as.PY(getTalkerUserName())) {
        break label56;
      }
    }
    label56:
    for (String str = as.bvW(this.WEE);; str = this.WEE)
    {
      this.WEE = str;
      str = this.WEE;
      AppMethodBeat.o(35820);
      return str;
    }
  }
  
  public final as getTalker()
  {
    return this.NKq;
  }
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(35818);
    if (this.NKq == null)
    {
      AppMethodBeat.o(35818);
      return "";
    }
    String str = Util.nullAs(this.NKq.field_username, "");
    AppMethodBeat.o(35818);
    return str;
  }
  
  public final int hMq()
  {
    AppMethodBeat.i(35835);
    int i = this.WQw.hMq();
    AppMethodBeat.o(35835);
    return i;
  }
  
  public final void hNh()
  {
    AppMethodBeat.i(35843);
    Log.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.WQw.hNh();
    AppMethodBeat.o(35843);
  }
  
  public final String hOp()
  {
    AppMethodBeat.i(35821);
    String str = Util.nullAs(((com.tencent.mm.ui.chatting.d.b.d)bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOp(), this.NKq.field_nickname);
    AppMethodBeat.o(35821);
    return str;
  }
  
  public final MMFragment hRf()
  {
    return this.WQv;
  }
  
  public final boolean hRg()
  {
    AppMethodBeat.i(35825);
    String str = getTalkerUserName();
    if ((as.PY(str)) || (as.bvJ(str)) || (as.bvH(str)) || (ab.QB(str)))
    {
      AppMethodBeat.o(35825);
      return true;
    }
    AppMethodBeat.o(35825);
    return false;
  }
  
  public final boolean hRh()
  {
    AppMethodBeat.i(35826);
    if ((ab.Lj(getTalkerUserName())) || (ab.PQ(getTalkerUserName())))
    {
      AppMethodBeat.o(35826);
      return true;
    }
    AppMethodBeat.o(35826);
    return false;
  }
  
  public final boolean hRi()
  {
    AppMethodBeat.i(35827);
    if ((ab.Lj(getTalkerUserName())) || (ab.PQ(getTalkerUserName())) || (((com.tencent.mm.ui.chatting.d.b.d)bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf()))
    {
      AppMethodBeat.o(35827);
      return true;
    }
    AppMethodBeat.o(35827);
    return false;
  }
  
  public final boolean hRj()
  {
    AppMethodBeat.i(35828);
    if ((!this.NKq.hxX()) && (!ab.QS(getTalkerUserName())) && (!as.bvH(getTalkerUserName())))
    {
      AppMethodBeat.o(35828);
      return true;
    }
    if (((com.tencent.mm.ui.chatting.d.b.d)bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe())
    {
      AppMethodBeat.o(35828);
      return true;
    }
    AppMethodBeat.o(35828);
    return false;
  }
  
  public final boolean hRk()
  {
    AppMethodBeat.i(293260);
    boolean bool = as.OS(getTalkerUserName());
    AppMethodBeat.o(293260);
    return bool;
  }
  
  public final af hRm()
  {
    return this.WQx;
  }
  
  public final void hideVKB()
  {
    AppMethodBeat.i(35839);
    Log.i("MicroMsg.ChattingContext", "[hideVKB]");
    this.WQw.hideVKB();
    AppMethodBeat.o(35839);
  }
  
  public final void my(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35842);
    Log.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    this.WQw.my(paramInt1, paramInt2);
    AppMethodBeat.o(35842);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(35845);
    Log.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", new Object[] { Integer.valueOf(paramInt) });
    this.WQw.scrollToPosition(paramInt);
    AppMethodBeat.o(35845);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(35846);
    Log.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.WQw.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(35846);
  }
  
  public final void showOptionMenu(boolean paramBoolean)
  {
    AppMethodBeat.i(35848);
    Log.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.WQw.showOptionMenu(paramBoolean);
    AppMethodBeat.o(35848);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(35829);
    BaseChattingUIFragment localBaseChattingUIFragment = this.WQv;
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localBaseChattingUIFragment, paramIntent.aFh(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localBaseChattingUIFragment.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localBaseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.a
 * JD-Core Version:    0.7.0.1
 */