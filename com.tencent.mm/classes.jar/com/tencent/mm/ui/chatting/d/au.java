package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.z.a;

@com.tencent.mm.ui.chatting.d.a.a(gRF=ak.class)
public class au
  extends a
  implements i, ak
{
  private d Ptj;
  private final IListener gnH;
  
  public au()
  {
    AppMethodBeat.i(35530);
    this.gnH = new al(al.a.Pkk, null);
    this.Ptj = null;
    AppMethodBeat.o(35530);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35532);
    if (!EventCenter.instance.hadListened(this.gnH)) {
      EventCenter.instance.addListener(this.gnH);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35533);
    EventCenter.instance.removeListener(this.gnH);
    AppMethodBeat.o(35533);
  }
  
  public final void ce(ca paramca)
  {
    AppMethodBeat.i(35536);
    w localw = new w(paramca, this.dom.Pwc.getMMResources().getString(2131757506));
    this.dom.b(this.dom.Pwc.getContext(), null, this.dom.Pwc.getMMResources().getString(2131757505), new au.1(this, paramca, localw));
    bg.azz().a(localw, 0);
    AppMethodBeat.o(35536);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35531);
    bg.azz().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35534);
    bg.azz().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35535);
    super.gOK();
    EventCenter.instance.removeListener(this.gnH);
    bg.azz().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35537);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.dom.dismissDialog();
    if (this.Ptj != null)
    {
      this.Ptj.dismiss();
      this.Ptj = null;
    }
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!Util.isTopActivity(this.dom.Pwc.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.dom.Pwc.getContext();
    int i;
    if (z.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
      switch (paramq.getType())
      {
      default: 
        AppMethodBeat.o(35537);
        return;
      }
      if ((paramq instanceof w))
      {
        paramString = ((w)paramq).bfA();
        if (!Util.isNullOrNil(paramString.MHI)) {
          h.a(this.dom.Pwc.getContext(), paramString.MHI, "", this.dom.Pwc.getMMResources().getString(2131757503), new DialogInterface.OnClickListener()
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
    else if ((paramq.getType() == 594) && ((paramq instanceof w)))
    {
      paramString = ((w)paramq).bfA();
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.MSL });
      if ((paramInt2 != 0) && (!Util.isNullOrNil(paramString.MSL))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.MSL });
        this.Ptj = h.a(this.dom.Pwc.getContext(), paramString.MSL, "", this.dom.Pwc.getMMResources().getString(2131757503), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35528);
            if (au.a(au.this) != null) {
              au.a(au.this).dismiss();
            }
            AppMethodBeat.o(35528);
          }
        });
        AppMethodBeat.o(35537);
        return;
      }
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.MSL });
      this.Ptj = h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131757504), "", this.dom.Pwc.getMMResources().getString(2131757503), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35529);
          if (au.a(au.this) != null) {
            au.a(au.this).dismiss();
          }
          AppMethodBeat.o(35529);
        }
      });
    }
    AppMethodBeat.o(35537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.au
 * JD-Core Version:    0.7.0.1
 */