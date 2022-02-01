package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.chatting.d.b.ah;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ah.class)
public class ar
  extends a
  implements f, ah
{
  private d Khp;
  private final c fIu;
  
  public ar()
  {
    AppMethodBeat.i(35530);
    this.fIu = new al(al.a.JYX, null);
    this.Khp = null;
    AppMethodBeat.o(35530);
  }
  
  public final void bO(final bv parambv)
  {
    AppMethodBeat.i(35536);
    final w localw = new w(parambv, this.cXJ.Kkd.getMMResources().getString(2131757292));
    this.cXJ.b(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131757291), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35526);
        ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(parambv.field_msgId) });
        bc.ajj().a(localw);
        AppMethodBeat.o(35526);
      }
    });
    bc.ajj().a(localw, 0);
    AppMethodBeat.o(35536);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35531);
    bc.ajj().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35532);
    if (!com.tencent.mm.sdk.b.a.IvT.e(this.fIu)) {
      com.tencent.mm.sdk.b.a.IvT.c(this.fIu);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35533);
    com.tencent.mm.sdk.b.a.IvT.d(this.fIu);
    AppMethodBeat.o(35533);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35534);
    bc.ajj().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35535);
    super.fGE();
    com.tencent.mm.sdk.b.a.IvT.d(this.fIu);
    bc.ajj().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35537);
    ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cXJ.dismissDialog();
    if (this.Khp != null)
    {
      this.Khp.dismiss();
      this.Khp = null;
    }
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!bu.jn(this.cXJ.Kkd.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.cXJ.Kkd.getContext();
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
      if ((paramn instanceof w))
      {
        paramString = ((w)paramn).aLx();
        if (!bu.isNullOrNil(paramString.HHz)) {
          h.a(this.cXJ.Kkd.getContext(), paramString.HHz, "", this.cXJ.Kkd.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
    else if ((paramn.getType() == 594) && ((paramn instanceof w)))
    {
      paramString = ((w)paramn).aLx();
      ae.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.HHA });
      if ((paramInt2 != 0) && (!bu.isNullOrNil(paramString.HHA))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        ae.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.HHA });
        this.Khp = h.a(this.cXJ.Kkd.getContext(), paramString.HHA, "", this.cXJ.Kkd.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
      ae.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.HHA });
      this.Khp = h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131757290), "", this.cXJ.Kkd.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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