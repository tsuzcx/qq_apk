package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.h.2;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private int JYp = -1;
  private BaseChattingUIFragment Jzr;
  public boolean cBE = false;
  private MMFragmentActivity nbm;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.Jzr = paramBaseChattingUIFragment;
    this.nbm = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    ae.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    h localh = h.yxY;
    localh.yye = SystemClock.uptimeMillis();
    localh.qw(false);
    if (localh.cKh != null) {
      localh.cKh.a(localh.yyh);
    }
    this.Jzr.fEO();
    this.Jzr.onEnterBegin();
    this.Jzr.fEP();
    if ((this.JYp != -1) && ((this.nbm instanceof MMActivity))) {
      this.Jzr.getController().setStatusBarColor(this.JYp);
    }
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    ae.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.Jzr.adr(256))
    {
      this.Jzr.fEQ();
      this.Jzr.onEnterEnd();
    }
    h localh = h.yxY;
    localh.yye = (SystemClock.uptimeMillis() - localh.yye);
    ae.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + localh.yye + "ms");
    localh.yyg[(localh.yyd % 20)] = localh.yye;
    long[] arrayOfLong = localh.yyg;
    arrayOfLong[20] += localh.yye;
    localh.yyd += 1;
    if (localh.cKh == null)
    {
      AppMethodBeat.o(34787);
      return;
    }
    localh.hXp.post(new h.2(localh));
    AppMethodBeat.o(34787);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(34788);
    ae.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.Jzr.fEW()) {
      this.Jzr.onExitBegin();
    }
    if ((this.nbm instanceof MMActivity)) {
      this.JYp = this.Jzr.getController().statusBarColor;
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    ae.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.Jzr.fER();
    this.Jzr.fES();
    this.Jzr.fET();
    this.Jzr.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ai.fGg().JYM = 4;
    }
    this.cBE = true;
    this.Jzr.JTx = true;
    Object localObject = this.nbm.getSupportFragmentManager().getFragments();
    label53:
    boolean bool;
    if (localObject == null)
    {
      ae.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label187;
      bool = true;
      label55:
      ae.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label254;
      }
      this.nbm.getSupportFragmentManager().beginTransaction().a(paramInt, this.Jzr).commitAllowingStateLoss();
      this.nbm.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.Jzr.JTx = false;
      AppMethodBeat.o(34785);
      return;
      if (((List)localObject).size() >= 5)
      {
        ae.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label187:
        if (!((Iterator)localObject).hasNext()) {
          break label53;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        ae.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label55;
      }
      ae.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label53;
      label254:
      this.nbm.getSupportFragmentManager().beginTransaction().b(paramInt, this.Jzr).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */