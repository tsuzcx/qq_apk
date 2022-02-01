package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ah.class)
public class ar
  extends a
  implements f, ah
{
  private d JMt;
  private final c fGq;
  
  public ar()
  {
    AppMethodBeat.i(35530);
    this.fGq = new ak(ak.a.JEg, null);
    this.JMt = null;
    AppMethodBeat.o(35530);
  }
  
  public final void bP(final bu parambu)
  {
    AppMethodBeat.i(35536);
    final v localv = new v(parambu, this.cWM.JOR.getMMResources().getString(2131757292));
    this.cWM.b(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131757291), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35526);
        ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(parambu.field_msgId) });
        ba.aiU().a(localv);
        AppMethodBeat.o(35526);
      }
    });
    ba.aiU().a(localv, 0);
    AppMethodBeat.o(35536);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35535);
    super.fCC();
    com.tencent.mm.sdk.b.a.IbL.d(this.fGq);
    ba.aiU().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35531);
    ba.aiU().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35532);
    if (!com.tencent.mm.sdk.b.a.IbL.e(this.fGq)) {
      com.tencent.mm.sdk.b.a.IbL.c(this.fGq);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35533);
    com.tencent.mm.sdk.b.a.IbL.d(this.fGq);
    AppMethodBeat.o(35533);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35534);
    ba.aiU().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35537);
    ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cWM.dismissDialog();
    if (this.JMt != null)
    {
      this.JMt.dismiss();
      this.JMt = null;
    }
    if (!this.cWM.cBJ)
    {
      ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!bt.jh(this.cWM.JOR.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.cWM.JOR.getContext();
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
      if ((paramn instanceof v))
      {
        paramString = ((v)paramn).aLa();
        if (!bt.isNullOrNil(paramString.HnZ)) {
          h.a(this.cWM.JOR.getContext(), paramString.HnZ, "", this.cWM.JOR.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
    else if ((paramn.getType() == 594) && ((paramn instanceof v)))
    {
      paramString = ((v)paramn).aLa();
      ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.Hoa });
      if ((paramInt2 != 0) && (!bt.isNullOrNil(paramString.Hoa))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.Hoa });
        this.JMt = h.a(this.cWM.JOR.getContext(), paramString.Hoa, "", this.cWM.JOR.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35528);
            if (ar.a(ar.this) != null) {
              ar.a(ar.this).dismiss();
            }
            AppMethodBeat.o(35528);
          }
        });
        AppMethodBeat.o(35537);
        return;
      }
      ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.Hoa });
      this.JMt = h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131757290), "", this.cWM.JOR.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35529);
          if (ar.a(ar.this) != null) {
            ar.a(ar.this).dismiss();
          }
          AppMethodBeat.o(35529);
        }
      });
    }
    AppMethodBeat.o(35537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ar
 * JD-Core Version:    0.7.0.1
 */