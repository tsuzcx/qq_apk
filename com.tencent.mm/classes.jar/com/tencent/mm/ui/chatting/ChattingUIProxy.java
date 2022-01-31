package com.tencent.mm.ui.chatting;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy
  implements IChattingUIProxy
{
  private MMFragmentActivity jdB;
  private BaseChattingUIFragment zee;
  
  public ChattingUIProxy(MMFragmentActivity paramMMFragmentActivity, BaseChattingUIFragment paramBaseChattingUIFragment)
  {
    this.zee = paramBaseChattingUIFragment;
    this.jdB = paramMMFragmentActivity;
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(30912);
    ab.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    this.zee.dFQ();
    this.zee.onEnterBegin();
    this.zee.dFR();
    AppMethodBeat.o(30912);
  }
  
  public void onEnterEnd()
  {
    AppMethodBeat.i(30913);
    ab.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.zee.Pi(256))
    {
      this.zee.dFS();
      this.zee.onEnterEnd();
    }
    AppMethodBeat.o(30913);
  }
  
  public void onExitBegin()
  {
    AppMethodBeat.i(30914);
    ab.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.zee.dFY()) {
      this.zee.onExitBegin();
    }
    AppMethodBeat.o(30914);
  }
  
  public void onExitEnd()
  {
    AppMethodBeat.i(30915);
    ab.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.zee.dFT();
    this.zee.dFU();
    this.zee.dFV();
    this.zee.onExitEnd();
    AppMethodBeat.o(30915);
  }
  
  public void onInit(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30911);
    if (paramBoolean) {
      ah.dGU().zBY = 4;
    }
    this.zee.zwO = true;
    Object localObject = this.jdB.getSupportFragmentManager().getFragments();
    label49:
    boolean bool;
    if (localObject == null)
    {
      ab.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label184;
      bool = true;
      label51:
      ab.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label249;
      }
      this.jdB.getSupportFragmentManager().beginTransaction().a(paramInt, this.zee).commitAllowingStateLoss();
      this.jdB.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        onExitBegin();
        onExitEnd();
      }
      this.zee.zwO = false;
      AppMethodBeat.o(30911);
      return;
      if (((List)localObject).size() >= 5)
      {
        ab.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label184:
        if (!((Iterator)localObject).hasNext()) {
          break label49;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof ChattingUIFragment)) {
          break;
        }
        ab.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label51;
      }
      ab.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label49;
      label249:
      this.jdB.getSupportFragmentManager().beginTransaction().b(paramInt, this.zee).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIProxy
 * JD-Core Version:    0.7.0.1
 */