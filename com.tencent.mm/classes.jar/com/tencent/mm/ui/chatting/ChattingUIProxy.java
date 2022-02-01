package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.plugin.report.service.i.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.t;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private MMFragmentActivity Dpx;
  private BaseChattingUIFragment OJN;
  private int PjA = -1;
  public boolean isInit = false;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.OJN = paramBaseChattingUIFragment;
    this.Dpx = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    i locali = i.CyW;
    locali.Czc = SystemClock.uptimeMillis();
    locali.tN(false);
    if (locali.daF != null) {
      locali.daF.a(locali.Czf);
    }
    this.OJN.gMW();
    this.OJN.onEnterBegin();
    this.OJN.gMX();
    if ((this.PjA != -1) && ((this.Dpx instanceof MMActivity))) {
      this.OJN.getController().setStatusBarColor(this.PjA);
    }
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.OJN.amb(256))
    {
      this.OJN.gMY();
      this.OJN.onEnterEnd();
    }
    i locali = i.CyW;
    locali.Czc = (SystemClock.uptimeMillis() - locali.Czc);
    Log.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + locali.Czc + "ms");
    locali.Cze[(locali.Czb % 20)] = locali.Czc;
    long[] arrayOfLong = locali.Cze;
    arrayOfLong[20] += locali.Czc;
    locali.Czb += 1;
    if (locali.daF == null)
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
    if (!this.OJN.gNe()) {
      this.OJN.onExitBegin();
    }
    if ((this.Dpx instanceof MMActivity)) {
      this.PjA = this.OJN.getController().statusBarColor;
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    Log.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.OJN.gMZ();
    this.OJN.gNa();
    this.OJN.gNb();
    this.OJN.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ai.gOk().PjZ = 4;
    }
    this.isInit = true;
    this.OJN.PeC = true;
    Object localObject = this.Dpx.getSupportFragmentManager().getFragments();
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
      this.Dpx.getSupportFragmentManager().beginTransaction().a(paramInt, this.OJN).commitAllowingStateLoss();
      this.Dpx.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.OJN.PeC = false;
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
      this.Dpx.getSupportFragmentManager().beginTransaction().b(paramInt, this.OJN).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */