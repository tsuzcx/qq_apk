package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class h$11
  implements f
{
  h$11(h paramh) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(29323);
    ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.yXo.eeN != null)
    {
      this.yXo.eeN.dismiss();
      this.yXo.eeN = null;
    }
    if (paramm.getType() == 255)
    {
      aw.Rc().b(255, this.yXo.yXj);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.yXo.qh(true);
        AppMethodBeat.o(29323);
        return;
      }
      if (v.a.a(this.yXo.yXg, paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(29323);
        return;
      }
      this.yXo.qh(false);
      AppMethodBeat.o(29323);
      return;
    }
    if (paramm.getType() == 384)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aw.aaz();
        c.Ru().set(77830, ((ac)paramm).agx());
        paramString = new Intent(this.yXo.yXg, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", this.yXo.getString(2131303322));
        this.yXo.yXg.startActivity(paramString);
        AppMethodBeat.o(29323);
        return;
      }
      this.yXo.qHF = true;
      com.tencent.mm.ui.base.h.a(this.yXo.yXg, 2131303358, 2131297087, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29322);
          h.11.this.yXo.dBG();
          AppMethodBeat.o(29322);
        }
      });
    }
    AppMethodBeat.o(29323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h.11
 * JD-Core Version:    0.7.0.1
 */