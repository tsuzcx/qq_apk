package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.RevokeMsgListener;
import com.tencent.mm.ui.chatting.RevokeMsgListener.a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.component.api.as;
import com.tencent.mm.ui.widget.a.e;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=as.class)
public class be
  extends a
  implements h, as
{
  private e aewn;
  private final IListener ltN;
  
  public be()
  {
    AppMethodBeat.i(35530);
    this.ltN = new RevokeMsgListener(RevokeMsgListener.a.aelt, null);
    this.aewn = null;
    AppMethodBeat.o(35530);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35531);
    bh.aZW().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35532);
    if (!EventCenter.instance.hadListened(this.ltN)) {
      this.ltN.alive();
    }
    AppMethodBeat.o(35532);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35533);
    this.ltN.dead();
    AppMethodBeat.o(35533);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35534);
    bh.aZW().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35535);
    super.jqF();
    this.ltN.dead();
    bh.aZW().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public final void k(final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(256378);
    paramString = new x(paramcc, this.hlc.aezO.getMMResources().getString(R.l.gzs), paramString);
    com.tencent.mm.ui.chatting.d.a locala = this.hlc;
    Log.i("MicroMsg.ChattingContext", "[isShowDialog]");
    if (!locala.aezP.gPQ()) {
      this.hlc.b(this.hlc.aezO.getContext(), null, this.hlc.aezO.getMMResources().getString(R.l.gzr), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(35526);
          Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(paramcc.field_msgId) });
          bh.aZW().a(paramString);
          AppMethodBeat.o(35526);
        }
      });
    }
    bh.aZW().a(paramString, 0);
    AppMethodBeat.o(256378);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35537);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramp.getType());
    this.hlc.aDM();
    if (this.aewn != null)
    {
      this.aewn.dismiss();
      this.aewn = null;
    }
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!Util.isTopActivity(this.hlc.aezO.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.hlc.aezO.getContext();
    int i;
    if (ae.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35537);
      return;
      if (com.tencent.mm.plugin.account.ui.a.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      default: 
        AppMethodBeat.o(35537);
        return;
      }
      if ((paramp instanceof x))
      {
        paramString = ((x)paramp).bMx();
        if (!Util.isNullOrNil(paramString.abjV)) {
          k.a(this.hlc.aezO.getContext(), paramString.abjV, "", this.hlc.aezO.getMMResources().getString(R.l.gzp), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35527);
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.dismiss();
              }
              AppMethodBeat.o(35527);
            }
          });
        }
        AppMethodBeat.o(35537);
      }
    }
    else if ((paramp.getType() == 594) && ((paramp instanceof x)))
    {
      paramString = ((x)paramp).bMx();
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.abwg });
      if ((paramInt2 != 0) && (!Util.isNullOrNil(paramString.abwg))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.abwg });
        this.aewn = k.a(this.hlc.aezO.getContext(), paramString.abwg, "", this.hlc.aezO.getMMResources().getString(R.l.gzp), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35528);
            if (be.a(be.this) != null) {
              be.a(be.this).dismiss();
            }
            AppMethodBeat.o(35528);
          }
        });
        AppMethodBeat.o(35537);
        return;
      }
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.abwg });
      this.aewn = k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gzq), "", this.hlc.aezO.getMMResources().getString(R.l.gzp), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35529);
          if (be.a(be.this) != null) {
            be.a(be.this).dismiss();
          }
          AppMethodBeat.o(35529);
        }
      });
    }
    AppMethodBeat.o(35537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.be
 * JD-Core Version:    0.7.0.1
 */