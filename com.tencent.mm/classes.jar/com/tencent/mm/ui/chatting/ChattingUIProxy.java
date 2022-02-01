package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.plugin.report.service.i.2;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private BaseChattingUIFragment Hra;
  private MMFragmentActivity mvz;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.Hra = paramBaseChattingUIFragment;
    this.mvz = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34786);
    ac.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    i locali = i.wUB;
    locali.wUH = SystemClock.uptimeMillis();
    locali.pQ(false);
    if (locali.cyD != null) {
      locali.cyD.a(locali.wUK);
    }
    this.Hra.fkx();
    this.Hra.onEnterBegin();
    this.Hra.fky();
    AppMethodBeat.o(34786);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(34787);
    ac.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.Hra.aaz(256))
    {
      this.Hra.fkz();
      this.Hra.onEnterEnd();
    }
    i locali = i.wUB;
    locali.wUH = (SystemClock.uptimeMillis() - locali.wUH);
    ac.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + locali.wUH + "ms");
    locali.wUJ[(locali.wUG % 20)] = locali.wUH;
    long[] arrayOfLong = locali.wUJ;
    arrayOfLong[20] += locali.wUH;
    locali.wUG += 1;
    if (locali.cyD == null)
    {
      AppMethodBeat.o(34787);
      return;
    }
    locali.hBR.post(new i.2(locali));
    AppMethodBeat.o(34787);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(34788);
    ac.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.Hra.fkF()) {
      this.Hra.onExitBegin();
    }
    AppMethodBeat.o(34788);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(34789);
    ac.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.Hra.fkA();
    this.Hra.fkB();
    this.Hra.fkC();
    this.Hra.onExitEnd();
    AppMethodBeat.o(34789);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34785);
    if (paramBoolean) {
      ah.flN().HQg = 4;
    }
    this.Hra.HKQ = true;
    Object localObject = this.mvz.getSupportFragmentManager().getFragments();
    label48:
    boolean bool;
    if (localObject == null)
    {
      ac.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label182;
      bool = true;
      label50:
      ac.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label249;
      }
      this.mvz.getSupportFragmentManager().beginTransaction().a(paramInt, this.Hra).commitAllowingStateLoss();
      this.mvz.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.Hra.HKQ = false;
      AppMethodBeat.o(34785);
      return;
      if (((List)localObject).size() >= 5)
      {
        ac.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label182:
        if (!((Iterator)localObject).hasNext()) {
          break label48;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        ac.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label50;
      }
      ac.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label48;
      label249:
      this.mvz.getSupportFragmentManager().beginTransaction().b(paramInt, this.Hra).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */