package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ad.class)
public class an
  extends a
  implements g, ad
{
  private d HXn;
  private final c foi;
  
  public an()
  {
    AppMethodBeat.i(35530);
    this.foi = new ak(ak.a.HQr, null);
    this.HXn = null;
    AppMethodBeat.o(35530);
  }
  
  public final void bJ(final bo parambo)
  {
    AppMethodBeat.i(35536);
    final v localv = new v(parambo, this.cLy.HZF.getMMResources().getString(2131757292));
    this.cLy.b(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131757291), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35526);
        ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(parambo.field_msgId) });
        az.agi().a(localv);
        AppMethodBeat.o(35526);
      }
    });
    az.agi().a(localv, 0);
    AppMethodBeat.o(35536);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35531);
    az.agi().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35532);
    if (!com.tencent.mm.sdk.b.a.GpY.e(this.foi)) {
      com.tencent.mm.sdk.b.a.GpY.c(this.foi);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35533);
    com.tencent.mm.sdk.b.a.GpY.d(this.foi);
    AppMethodBeat.o(35533);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35534);
    az.agi().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35535);
    super.fmj();
    com.tencent.mm.sdk.b.a.GpY.d(this.foi);
    az.agi().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35537);
    ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cLy.dismissDialog();
    if (this.HXn != null)
    {
      this.HXn.dismiss();
      this.HXn = null;
    }
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!bs.iX(this.cLy.HZF.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.cLy.HZF.getContext();
    int i;
    if (y.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35537);
      return;
      if (y.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      default: 
        AppMethodBeat.o(35537);
        return;
      }
      paramString = ((v)paramn).aHP();
      if (!bs.isNullOrNil(paramString.FDM))
      {
        h.a(this.cLy.HZF.getContext(), paramString.FDM, "", this.cLy.HZF.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
        AppMethodBeat.o(35537);
      }
    }
    else if (paramn.getType() == 594)
    {
      paramString = ((v)paramn).aHP();
      ac.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.FDN });
      if ((paramInt2 != 0) && (!bs.isNullOrNil(paramString.FDN))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        ac.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.FDN });
        this.HXn = h.a(this.cLy.HZF.getContext(), paramString.FDN, "", this.cLy.HZF.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35528);
            if (an.a(an.this) != null) {
              an.a(an.this).dismiss();
            }
            AppMethodBeat.o(35528);
          }
        });
        AppMethodBeat.o(35537);
        return;
      }
      ac.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.FDN });
      this.HXn = h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131757290), "", this.cLy.HZF.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35529);
          if (an.a(an.this) != null) {
            an.a(an.this).dismiss();
          }
          AppMethodBeat.o(35529);
        }
      });
    }
    AppMethodBeat.o(35537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an
 * JD-Core Version:    0.7.0.1
 */