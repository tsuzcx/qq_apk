package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import java.util.List;

public class bj
  extends a
  implements i, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, ag
{
  private static boolean WPA;
  
  static
  {
    AppMethodBeat.i(281562);
    if (((b)h.ae(b.class)).a(b.a.waj, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      WPA = bool;
      AppMethodBeat.o(281562);
      return;
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35743);
    bh.aGY().a(137, this);
    bh.beI();
    c.bbL().add(this);
    AppMethodBeat.o(35743);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35744);
    bh.aGY().b(137, this);
    if (bh.aHB())
    {
      bh.beI();
      c.bbL().remove(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35745);
    super.hNZ();
    bh.aGY().b(137, this);
    if (bh.aHB())
    {
      bh.beI();
      c.bbL().remove(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange " + paramInt + ", needResetBanner = " + WPA);
    bh.beI();
    paramMStorageEx = c.bbL().RG(this.fgR.getTalkerUserName());
    if ((paramMStorageEx != null) && ((int)paramMStorageEx.jxt != 0))
    {
      if (Util.isNullOrNil(paramMStorageEx.field_nickname)) {
        paramMStorageEx.setNickname(this.fgR.NKq.field_nickname);
      }
      this.fgR.aC(paramMStorageEx);
      ((aa)this.fgR.bC(aa.class)).hOL();
      ((aa)this.fgR.bC(aa.class)).Gm(WPA);
      this.fgR.cAe();
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
    this.fgR.dismissDialog();
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!Util.isTopActivity(this.fgR.WQv.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.fgR.WQv.getContext();
    if (ac.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
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
      paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).QVu;
      if ((paramString == null) || (paramString.contains(this.fgR.NKq.field_username)))
      {
        localObject = this.fgR.NKq;
        bh.beI();
        paramq = c.bbL().RG(((ax)localObject).field_username);
        if (paramq != null)
        {
          paramString = paramq;
          if ((int)paramq.jxt != 0) {}
        }
        else
        {
          bh.beI();
          if (c.bbL().au((as)localObject)) {
            break label368;
          }
          Log.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((ax)localObject).field_username);
        }
        for (paramString = null;; paramString = c.bbL().RG(((ax)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          ab.H(paramString);
          break;
          label368:
          bh.beI();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bj
 * JD-Core Version:    0.7.0.1
 */