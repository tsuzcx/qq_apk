package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.b;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.plugin.report.service.i.2;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private MMFragmentActivity PIA;
  private BaseChattingUIFragment adIL;
  private int aeky = -1;
  public boolean isInit = false;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.adIL = paramBaseChattingUIFragment;
    this.PIA = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    i locali = i.OAE;
    locali.OAK = SystemClock.uptimeMillis();
    locali.BK(false);
    if (locali.fdr != null) {
      locali.fdr.a(locali.OAN);
    }
    this.adIL.joH();
    this.adIL.onEnterBegin();
    this.adIL.joI();
    if ((this.aeky != -1) && ((this.PIA instanceof MMActivity))) {
      this.adIL.getController().setStatusBarColor(this.aeky);
    }
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    Log.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.adIL.aBD(256))
    {
      this.adIL.joJ();
      this.adIL.onEnterEnd();
    }
    i locali = i.OAE;
    locali.OAK = (SystemClock.uptimeMillis() - locali.OAK);
    Log.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + locali.OAK + "ms");
    locali.OAM[(locali.OAJ % 20)] = locali.OAK;
    long[] arrayOfLong = locali.OAM;
    arrayOfLong[20] += locali.OAK;
    locali.OAJ += 1;
    if (locali.fdr == null)
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
    if (!this.adIL.joQ()) {
      this.adIL.onExitBegin();
    }
    if ((this.PIA instanceof MMActivity)) {
      this.aeky = this.adIL.getController().WoL;
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    Log.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.adIL.joK();
    this.adIL.joL();
    this.adIL.joM();
    this.adIL.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      al.jqa().aelh = 4;
    }
    this.isInit = true;
    this.adIL.aefq = true;
    Object localObject = this.PIA.getSupportFragmentManager().getFragments();
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
      this.PIA.getSupportFragmentManager().beginTransaction().a(paramInt, this.adIL).FX();
      this.PIA.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.adIL.aefq = false;
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
      this.PIA.getSupportFragmentManager().beginTransaction().b(paramInt, this.adIL).FX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */