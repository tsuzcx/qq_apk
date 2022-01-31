package com.tencent.mm.ui.chatting;

import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.n;
import java.util.Iterator;
import java.util.List;

public final class aa
  implements n
{
  private MMFragmentActivity ohK;
  private e uPR;
  
  public aa(MMFragmentActivity paramMMFragmentActivity, e parame)
  {
    this.uPR = parame;
    this.ohK = paramMMFragmentActivity;
  }
  
  public final void ao(int paramInt, boolean paramBoolean)
  {
    this.uPR.vhU = true;
    Object localObject = this.ohK.getSupportFragmentManager().getFragments();
    label32:
    boolean bool;
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "fragments is null");
      break label161;
      bool = true;
      label34:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label226;
      }
      this.ohK.getSupportFragmentManager().bP().a(paramInt, this.uPR).commitAllowingStateLoss();
      this.ohK.getSupportFragmentManager().executePendingTransactions();
    }
    for (;;)
    {
      if (paramBoolean)
      {
        cyV();
        cyW();
      }
      this.uPR.vhU = false;
      return;
      if (((List)localObject).size() >= 5)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        label161:
        if (!((Iterator)localObject).hasNext()) {
          break label32;
        }
        if (!((Fragment)((Iterator)localObject).next() instanceof y)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
        bool = false;
        break label34;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      break label32;
      label226:
      this.ohK.getSupportFragmentManager().bP().b(paramInt, this.uPR).commitAllowingStateLoss();
    }
  }
  
  public final void cyT()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
    this.uPR.cCe();
    this.uPR.cyT();
    this.uPR.cCf();
  }
  
  public final void cyU()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
    if (this.uPR.GJ(256))
    {
      this.uPR.cCg();
      this.uPR.cyU();
    }
  }
  
  public final void cyV()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
    if (!this.uPR.cCl()) {
      this.uPR.cyV();
    }
  }
  
  public final void cyW()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
    this.uPR.cCh();
    this.uPR.cCi();
    this.uPR.cCj();
    this.uPR.cyW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa
 * JD-Core Version:    0.7.0.1
 */