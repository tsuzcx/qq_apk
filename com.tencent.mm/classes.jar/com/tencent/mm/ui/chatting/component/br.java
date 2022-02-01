package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ad;
import java.util.List;

public class br
  extends a
  implements h, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange, aj
{
  public final void jjh()
  {
    AppMethodBeat.i(35743);
    bh.aZW().a(137, this);
    bh.bCz();
    c.bzA().add(this);
    AppMethodBeat.o(35743);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35744);
    bh.aZW().b(137, this);
    if (bh.baz())
    {
      bh.bCz();
      c.bzA().remove(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35745);
    super.jqF();
    bh.aZW().b(137, this);
    if (bh.baz())
    {
      bh.bCz();
      c.bzA().remove(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    bh.bCz();
    paramMStorageEx = c.bzA().JE(this.hlc.getTalkerUserName());
    if ((paramMStorageEx != null) && ((int)paramMStorageEx.maN != 0))
    {
      if (Util.isNullOrNil(paramMStorageEx.field_nickname)) {
        paramMStorageEx.setNickname(this.hlc.Uxa.field_nickname);
      }
      this.hlc.aI(paramMStorageEx);
      ((ad)this.hlc.cm(ad.class)).jrB();
      ((ad)this.hlc.cm(ad.class)).LZ(false);
      this.hlc.dcZ();
    }
    AppMethodBeat.o(35747);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(35748);
    onNotifyChange(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramp.getType());
    this.hlc.aDM();
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!Util.isTopActivity(this.hlc.aezO.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.hlc.aezO.getContext();
    if (ae.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35746);
      return;
      if (!com.tencent.mm.plugin.account.ui.a.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramp.getType())
      {
      }
    }
    label387:
    for (;;)
    {
      AppMethodBeat.o(35746);
      return;
      paramString = ((v)paramp).XRr;
      if ((paramString == null) || (paramString.contains(this.hlc.Uxa.field_username)))
      {
        localObject = this.hlc.Uxa;
        bh.bCz();
        paramp = c.bzA().JE(((az)localObject).field_username);
        if (paramp != null)
        {
          paramString = paramp;
          if ((int)paramp.maN != 0) {}
        }
        else
        {
          bh.bCz();
          if (c.bzA().aA((au)localObject)) {
            break label368;
          }
          Log.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((az)localObject).field_username);
        }
        for (paramString = null;; paramString = c.bzA().JE(((az)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          ab.I(paramString);
          break;
          label368:
          bh.bCz();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.br
 * JD-Core Version:    0.7.0.1
 */