package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.v.a;

@com.tencent.mm.ui.chatting.c.a.a(dJy=y.class)
public class af
  extends a
  implements f, y
{
  private final com.tencent.mm.sdk.b.c eaA;
  private com.tencent.mm.ui.widget.b.c zHp;
  
  public af()
  {
    AppMethodBeat.i(31635);
    this.eaA = new ak(ak.a.zCh, null);
    this.zHp = null;
    AppMethodBeat.o(31635);
  }
  
  public final void bk(bi parambi)
  {
    AppMethodBeat.i(31641);
    com.tencent.mm.modelsimple.v localv = new com.tencent.mm.modelsimple.v(parambi, this.caz.zJz.getMMResources().getString(2131298301));
    this.caz.c(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131298300), new af.1(this, parambi, localv));
    aw.Rc().a(localv, 0);
    AppMethodBeat.o(31641);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31636);
    aw.Rc().a(594, this);
    AppMethodBeat.o(31636);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31637);
    if (!com.tencent.mm.sdk.b.a.ymk.e(this.eaA)) {
      com.tencent.mm.sdk.b.a.ymk.c(this.eaA);
    }
    AppMethodBeat.o(31637);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31638);
    com.tencent.mm.sdk.b.a.ymk.d(this.eaA);
    AppMethodBeat.o(31638);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31639);
    aw.Rc().b(594, this);
    AppMethodBeat.o(31639);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31640);
    super.dHq();
    com.tencent.mm.sdk.b.a.ymk.d(this.eaA);
    aw.Rc().b(594, this);
    AppMethodBeat.o(31640);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(31642);
    ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.caz.dismissDialog();
    if (this.zHp != null)
    {
      this.zHp.dismiss();
      this.zHp = null;
    }
    if (!this.caz.bSe)
    {
      ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(31642);
      return;
    }
    if (!bo.cB(this.caz.zJz.getContext()))
    {
      AppMethodBeat.o(31642);
      return;
    }
    Activity localActivity = this.caz.zJz.getContext();
    int i;
    if (v.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(31642);
      return;
      if (com.tencent.mm.ui.v.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      default: 
        AppMethodBeat.o(31642);
        return;
      }
      paramString = ((com.tencent.mm.modelsimple.v)paramm).ajV();
      if (!bo.isNullOrNil(paramString.xJn))
      {
        h.a(this.caz.zJz.getContext(), paramString.xJn, "", this.caz.zJz.getMMResources().getString(2131298298), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(31632);
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            AppMethodBeat.o(31632);
          }
        });
        AppMethodBeat.o(31642);
      }
    }
    else if (paramm.getType() == 594)
    {
      paramString = ((com.tencent.mm.modelsimple.v)paramm).ajV();
      ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.xJo });
      if ((paramInt2 != 0) && (!bo.isNullOrNil(paramString.xJo))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.xJo });
        this.zHp = h.a(this.caz.zJz.getContext(), paramString.xJo, "", this.caz.zJz.getMMResources().getString(2131298298), new af.3(this));
        AppMethodBeat.o(31642);
        return;
      }
      ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.xJo });
      this.zHp = h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131298299), "", this.caz.zJz.getMMResources().getString(2131298298), new af.4(this));
    }
    AppMethodBeat.o(31642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.af
 * JD-Core Version:    0.7.0.1
 */