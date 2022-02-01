package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.i.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private MMFragmentActivity Jvc;
  private int WDc = -1;
  private BaseChattingUIFragment Wdi;
  public boolean isInit = false;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.Wdi = paramBaseChattingUIFragment;
    this.Jvc = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.IzV;
    locali.IAb = SystemClock.uptimeMillis();
    locali.xj(false);
    if (locali.deH != null) {
      locali.deH.a(locali.IAe);
    }
    this.Wdi.hMf();
    this.Wdi.onEnterBegin();
    this.Wdi.hMg();
    if ((this.WDc != -1) && ((this.Jvc instanceof MMActivity))) {
      this.Wdi.getController().setStatusBarColor(this.WDc);
    }
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.Wdi.avb(256))
    {
      this.Wdi.hMh();
      this.Wdi.onEnterEnd();
    }
    com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.IzV;
    locali.IAb = (SystemClock.uptimeMillis() - locali.IAb);
    Log.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + locali.IAb + "ms");
    locali.IAd[(locali.IAa % 20)] = locali.IAb;
    long[] arrayOfLong = locali.IAd;
    arrayOfLong[20] += locali.IAb;
    locali.IAa += 1;
    if (locali.deH == null)
    {
      AppMethodBeat.o(34787);
      return;
    }
    locali.mainHandler.post(new i.2(locali));
    AppMethodBeat.o(34787);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(34788);
    Log.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.Wdi.hMn()) {
      this.Wdi.onExitBegin();
    }
    if ((this.Jvc instanceof MMActivity)) {
      this.WDc = this.Wdi.getController().PyE;
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    Log.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.Wdi.hMi();
    this.Wdi.hMj();
    this.Wdi.hMk();
    this.Wdi.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ai.hNu().WDH = 4;
    }
    this.isInit = true;
    this.Wdi.WxU = true;
    Object localObject = this.Jvc.getSupportFragmentManager().getFragments();
    label53:
    boolean bool;
    if (localObject == null)
    {
      Log.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label187;
      bool = true;
      label55:
      Log.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label254;
      }
      this.Jvc.getSupportFragmentManager().beginTransaction().a(paramInt, this.Wdi).ip();
      this.Jvc.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.Wdi.WxU = false;
      AppMethodBeat.o(34785);
      return;
      if (((List)localObject).size() >= 5)
      {
        Log.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label187:
        if (!((Iterator)localObject).hasNext()) {
          break label53;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        Log.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label55;
      }
      Log.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label53;
      label254:
      this.Jvc.getSupportFragmentManager().beginTransaction().b(paramInt, this.Wdi).ip();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */