package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.z.a;
import java.util.List;

public class bg
  extends a
  implements i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, af
{
  private static boolean Pvh;
  
  static
  {
    AppMethodBeat.i(233222);
    if (((b)g.af(b.class)).a(b.a.soH, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Pvh = bool;
      AppMethodBeat.o(233222);
      return;
    }
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35743);
    com.tencent.mm.model.bg.azz().a(137, this);
    com.tencent.mm.model.bg.aVF();
    com.tencent.mm.model.c.aSN().add(this);
    AppMethodBeat.o(35743);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35744);
    com.tencent.mm.model.bg.azz().b(137, this);
    if (com.tencent.mm.model.bg.aAc())
    {
      com.tencent.mm.model.bg.aVF();
      com.tencent.mm.model.c.aSN().remove(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35745);
    super.gOK();
    com.tencent.mm.model.bg.azz().b(137, this);
    if (com.tencent.mm.model.bg.aAc())
    {
      com.tencent.mm.model.bg.aVF();
      com.tencent.mm.model.c.aSN().remove(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange " + paramInt + ", needResetBanner = " + Pvh);
    com.tencent.mm.model.bg.aVF();
    paramMStorageEx = com.tencent.mm.model.c.aSN().Kn(this.dom.getTalkerUserName());
    if ((paramMStorageEx != null) && ((int)paramMStorageEx.gMZ != 0))
    {
      if (Util.isNullOrNil(paramMStorageEx.field_nickname)) {
        paramMStorageEx.setNickname(this.dom.GUe.field_nickname);
      }
      this.dom.aw(paramMStorageEx);
      ((aa)this.dom.bh(aa.class)).gPx();
      ((aa)this.dom.bh(aa.class)).BR(Pvh);
      this.dom.cmy();
    }
    AppMethodBeat.o(35747);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35748);
    onNotifyChange(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.dom.dismissDialog();
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!Util.isTopActivity(this.dom.Pwc.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.dom.Pwc.getContext();
    if (z.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35746);
      return;
      if (!com.tencent.mm.plugin.account.ui.a.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramq.getType())
      {
      }
    }
    label387:
    for (;;)
    {
      AppMethodBeat.o(35746);
      return;
      paramString = ((p)paramq).JVj;
      if ((paramString == null) || (paramString.contains(this.dom.GUe.field_username)))
      {
        localObject = this.dom.GUe;
        com.tencent.mm.model.bg.aVF();
        paramq = com.tencent.mm.model.c.aSN().Kn(((ax)localObject).field_username);
        if (paramq != null)
        {
          paramString = paramq;
          if ((int)paramq.gMZ != 0) {}
        }
        else
        {
          com.tencent.mm.model.bg.aVF();
          if (com.tencent.mm.model.c.aSN().ao((as)localObject)) {
            break label368;
          }
          Log.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((ax)localObject).field_username);
        }
        for (paramString = null;; paramString = com.tencent.mm.model.c.aSN().Kn(((ax)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          ab.B(paramString);
          break;
          label368:
          com.tencent.mm.model.bg.aVF();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bg
 * JD-Core Version:    0.7.0.1
 */