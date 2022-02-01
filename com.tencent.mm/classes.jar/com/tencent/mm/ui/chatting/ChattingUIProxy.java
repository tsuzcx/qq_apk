package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.plugin.report.service.i.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private BaseChattingUIFragment FRm;
  private MMFragmentActivity lTx;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.FRm = paramBaseChattingUIFragment;
    this.lTx = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    ad.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    i locali = i.vKx;
    locali.vKD = SystemClock.uptimeMillis();
    locali.oS(false);
    if (locali.cBu != null) {
      locali.cBu.a(locali.vKG);
    }
    this.FRm.eUL();
    this.FRm.onEnterBegin();
    this.FRm.eUM();
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    ad.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.FRm.Yo(256))
    {
      this.FRm.eUN();
      this.FRm.onEnterEnd();
    }
    i locali = i.vKx;
    locali.vKD = (SystemClock.uptimeMillis() - locali.vKD);
    ad.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + locali.vKD + "ms");
    locali.vKF[(locali.vKC % 20)] = locali.vKD;
    long[] arrayOfLong = locali.vKF;
    arrayOfLong[20] += locali.vKD;
    locali.vKC += 1;
    if (locali.cBu == null)
    {
      AppMethodBeat.o(34787);
      return;
    }
    locali.hbq.post(new i.2(locali));
    AppMethodBeat.o(34787);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(34788);
    ad.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.FRm.eUT()) {
      this.FRm.onExitBegin();
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    ad.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.FRm.eUO();
    this.FRm.eUP();
    this.FRm.eUQ();
    this.FRm.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ah.eWb().Gqo = 4;
    }
    this.FRm.Glb = true;
    Object localObject = this.lTx.getSupportFragmentManager().getFragments();
    label48:
    boolean bool;
    if (localObject == null)
    {
      ad.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label182;
      bool = true;
      label50:
      ad.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label249;
      }
      this.lTx.getSupportFragmentManager().beginTransaction().a(paramInt, this.FRm).commitAllowingStateLoss();
      this.lTx.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.FRm.Glb = false;
      AppMethodBeat.o(34785);
      return;
      if (((List)localObject).size() >= 5)
      {
        ad.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label182:
        if (!((Iterator)localObject).hasNext()) {
          break label48;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        ad.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label50;
      }
      ad.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label48;
      label249:
      this.lTx.getSupportFragmentManager().beginTransaction().b(paramInt, this.FRm).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */