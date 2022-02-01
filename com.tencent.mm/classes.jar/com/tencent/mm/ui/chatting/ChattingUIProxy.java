package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.report.service.h.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private int JDy = -1;
  private BaseChattingUIFragment JeG;
  public boolean cAX = false;
  private MMFragmentActivity mWg;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.JeG = paramBaseChattingUIFragment;
    this.mWg = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    ad.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    h localh = h.yih;
    localh.yin = SystemClock.uptimeMillis();
    localh.qp(false);
    if (localh.cJy != null) {
      localh.cJy.a(localh.yiq);
    }
    this.JeG.fAM();
    this.JeG.onEnterBegin();
    this.JeG.fAN();
    if ((this.JDy != -1) && ((this.mWg instanceof MMActivity))) {
      this.JeG.getController().setStatusBarColor(this.JDy);
    }
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    ad.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.JeG.acJ(256))
    {
      this.JeG.fAO();
      this.JeG.onEnterEnd();
    }
    h localh = h.yih;
    localh.yin = (SystemClock.uptimeMillis() - localh.yin);
    ad.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + localh.yin + "ms");
    localh.yip[(localh.yim % 20)] = localh.yin;
    long[] arrayOfLong = localh.yip;
    arrayOfLong[20] += localh.yin;
    localh.yim += 1;
    if (localh.cJy == null)
    {
      AppMethodBeat.o(34787);
      return;
    }
    localh.hUx.post(new h.2(localh));
    AppMethodBeat.o(34787);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(34788);
    ad.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.JeG.fAU()) {
      this.JeG.onExitBegin();
    }
    if ((this.mWg instanceof MMActivity)) {
      this.JDy = this.JeG.getController().statusBarColor;
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    ad.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.JeG.fAP();
    this.JeG.fAQ();
    this.JeG.fAR();
    this.JeG.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ah.fCe().JDV = 4;
    }
    this.cAX = true;
    this.JeG.JyH = true;
    Object localObject = this.mWg.getSupportFragmentManager().getFragments();
    label53:
    boolean bool;
    if (localObject == null)
    {
      ad.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label187;
      bool = true;
      label55:
      ad.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label254;
      }
      this.mWg.getSupportFragmentManager().beginTransaction().a(paramInt, this.JeG).commitAllowingStateLoss();
      this.mWg.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.JeG.JyH = false;
      AppMethodBeat.o(34785);
      return;
      if (((List)localObject).size() >= 5)
      {
        ad.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label187:
        if (!((Iterator)localObject).hasNext()) {
          break label53;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        ad.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label55;
      }
      ad.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label53;
      label254:
      this.mWg.getSupportFragmentManager().beginTransaction().b(paramInt, this.JeG).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */