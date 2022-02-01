package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMBaseActivity;

public class GetQRCodeInfoUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog fts = null;
  private com.tencent.mm.plugin.messenger.a.g xpf;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73839);
    b.iyx.p(new Intent(), this);
    finish();
    AppMethodBeat.o(73839);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73835);
    super.onCreate(paramBundle);
    setContentView(2131493834);
    Object localObject = getIntent().getData();
    if (localObject == null)
    {
      finish();
      AppMethodBeat.o(73835);
      return;
    }
    paramBundle = bs.nullAsNil(((Uri)localObject).getHost());
    localObject = bs.nullAsNil(((Uri)localObject).getScheme());
    if ((("http".equals(localObject)) && ("weixin.qq.com".equals(paramBundle))) || (("weixin".equals(localObject)) && ("qr".equals(paramBundle))))
    {
      com.tencent.mm.kernel.g.agi().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(73831);
          if (paramAnonymouse == null)
          {
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.o(73831);
            return;
          }
          if ((com.tencent.mm.kernel.g.agM()) && (!a.afS()))
          {
            GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
            AppMethodBeat.o(73831);
            return;
          }
          b.iyx.p(new Intent(), GetQRCodeInfoUI.this);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73831);
        }
      }), 0);
      AppMethodBeat.o(73835);
      return;
    }
    finish();
    AppMethodBeat.o(73835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73837);
    super.onDestroy();
    if (this.xpf != null) {
      com.tencent.mm.kernel.g.agi().a(this.xpf);
    }
    com.tencent.mm.kernel.g.agi().b(106, this);
    AppMethodBeat.o(73837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73836);
    super.onResume();
    getString(2131755906);
    this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131755224), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(73832);
        GetQRCodeInfoUI.this.finish();
        AppMethodBeat.o(73832);
      }
    });
    AppMethodBeat.o(73836);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73838);
    ac.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.a(this, 2131762118, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73833);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73833);
        }
      });
      AppMethodBeat.o(73838);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), getString(2131755906), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(73834);
          GetQRCodeInfoUI.this.finish();
          AppMethodBeat.o(73834);
        }
      });
      AppMethodBeat.o(73838);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.g)paramn).dcj();
    paramn = z.a(paramString.EuE);
    p.aBh().h(paramn, z.a(paramString.DPX));
    Intent localIntent = new Intent();
    ((j)com.tencent.mm.kernel.g.ab(j.class)).a(localIntent, paramString, 30);
    if (bs.nullAsNil(paramn).length() > 0)
    {
      if ((paramString.Feq & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramn + ",30");
      }
      d.b(this, "profile", ".ui.ContactInfoUI", 1);
    }
    AppMethodBeat.o(73838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI
 * JD-Core Version:    0.7.0.1
 */