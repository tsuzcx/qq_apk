package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.al.class)
public class ax
  extends a
  implements i, com.tencent.mm.ui.chatting.d.b.al
{
  private d WNN;
  private final IListener iRQ;
  
  public ax()
  {
    AppMethodBeat.i(35530);
    this.iRQ = new com.tencent.mm.ui.chatting.al(al.a.WDT, null);
    this.WNN = null;
    AppMethodBeat.o(35530);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35531);
    bh.aGY().a(594, this);
    AppMethodBeat.o(35531);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35532);
    if (!EventCenter.instance.hadListened(this.iRQ)) {
      EventCenter.instance.addListener(this.iRQ);
    }
    AppMethodBeat.o(35532);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35533);
    EventCenter.instance.removeListener(this.iRQ);
    AppMethodBeat.o(35533);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35534);
    bh.aGY().b(594, this);
    AppMethodBeat.o(35534);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35535);
    super.hNZ();
    EventCenter.instance.removeListener(this.iRQ);
    bh.aGY().b(594, this);
    AppMethodBeat.o(35535);
  }
  
  public final void k(final ca paramca, final String paramString)
  {
    AppMethodBeat.i(219288);
    paramString = new w(paramca, this.fgR.WQv.getMMResources().getString(R.l.ewP), paramString);
    com.tencent.mm.ui.chatting.e.a locala = this.fgR;
    Log.i("MicroMsg.ChattingContext", "[isShowDialog]");
    if (!locala.WQw.isShowingDialog()) {
      this.fgR.b(this.fgR.WQv.getContext(), null, this.fgR.WQv.getMMResources().getString(R.l.ewO), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(35526);
          Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", new Object[] { Long.valueOf(paramca.field_msgId) });
          bh.aGY().a(paramString);
          AppMethodBeat.o(35526);
        }
      });
    }
    bh.aGY().a(paramString, 0);
    AppMethodBeat.o(219288);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35537);
    Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.fgR.dismissDialog();
    if (this.WNN != null)
    {
      this.WNN.dismiss();
      this.WNN = null;
    }
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35537);
      return;
    }
    if (!Util.isTopActivity(this.fgR.WQv.getContext()))
    {
      AppMethodBeat.o(35537);
      return;
    }
    Activity localActivity = this.fgR.WQv.getContext();
    int i;
    if (ac.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
        paramString = ((w)paramq).boQ();
        if (!Util.isNullOrNil(paramString.TTw)) {
          h.a(this.fgR.WQv.getContext(), paramString.TTw, "", this.fgR.WQv.getMMResources().getString(R.l.ewM), new DialogInterface.OnClickListener()
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
      paramString = ((w)paramq).boQ();
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.UeT });
      if ((paramInt2 != 0) && (!Util.isNullOrNil(paramString.UeT))) {}
      for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
      {
        Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.UeT });
        this.WNN = h.a(this.fgR.WQv.getContext(), paramString.UeT, "", this.fgR.WQv.getMMResources().getString(R.l.ewM), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35528);
            if (ax.a(ax.this) != null) {
              ax.a(ax.this).dismiss();
            }
            AppMethodBeat.o(35528);
          }
        });
        AppMethodBeat.o(35537);
        return;
      }
      Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.UeT });
      this.WNN = h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.ewN), "", this.fgR.WQv.getMMResources().getString(R.l.ewM), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35529);
          if (ax.a(ax.this) != null) {
            ax.a(ax.this).dismiss();
          }
          AppMethodBeat.o(35529);
        }
      });
    }
    AppMethodBeat.o(35537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ax
 * JD-Core Version:    0.7.0.1
 */