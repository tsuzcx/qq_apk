package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.ad.class)
public class an
  extends a
  implements g, com.tencent.mm.ui.chatting.c.b.ad
{
  private d Gxw;
  private final c fkO;
  
  public an()
  {
    AppMethodBeat.i(35530);
    this.fkO = new ak(ak.a.Gqz, null);
    this.Gxw = null;
    AppMethodBeat.o(35530);
  }
  
  public final void bH(final bl parambl)
  {
    AppMethodBeat.i(35536);
    final v localv = new v(parambl, this.cOd.GzJ.getMMResources().getString(2131757292));
    this.cOd.b(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131757291), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35526);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(parambl.field_msgId) });
        az.aeS().a(localv);
        AppMethodBeat.o(35526);
      }
    });
    az.aeS().a(localv, 0);
    AppMethodBeat.o(35536);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35531);
    az.aeS().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35532);
    if (!com.tencent.mm.sdk.b.a.ESL.e(this.fkO)) {
      com.tencent.mm.sdk.b.a.ESL.c(this.fkO);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35533);
    com.tencent.mm.sdk.b.a.ESL.d(this.fkO);
    AppMethodBeat.o(35533);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35534);
    az.aeS().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35535);
    super.eWx();
    com.tencent.mm.sdk.b.a.ESL.d(this.fkO);
    az.aeS().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35537);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cOd.dismissDialog();
    if (this.Gxw != null)
    {
      this.Gxw.dismiss();
      this.Gxw = null;
    }
    if (!this.cOd.ctF)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!bt.iM(this.cOd.GzJ.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.cOd.GzJ.getContext();
    int i;
    if (x.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35537);
      return;
      if (x.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      paramString = ((v)paramn).aAZ();
      if (!bt.isNullOrNil(paramString.EgN))
      {
        h.a(this.cOd.GzJ.getContext(), paramString.EgN, "", this.cOd.GzJ.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
      paramString = ((v)paramn).aAZ();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.EgO });
      if ((paramInt2 != 0) && (!bt.isNullOrNil(paramString.EgO))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.EgO });
        this.Gxw = h.a(this.cOd.GzJ.getContext(), paramString.EgO, "", this.cOd.GzJ.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.EgO });
      this.Gxw = h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131757290), "", this.cOd.GzJ.getMMResources().getString(2131757289), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.an
 * JD-Core Version:    0.7.0.1
 */