package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  implements f
{
  private int cpE;
  private int cpF;
  private ProgressDialog eeN = null;
  private Activity gQx;
  i.a qCN = null;
  private f.a qCO = null;
  boolean qCt = false;
  int qCu = -1;
  private Bundle qCv;
  private String qur;
  boolean qus = false;
  private int qwn;
  private i.b qzg;
  String typeName;
  
  public i() {}
  
  public i(i.b paramb, i.a parama)
  {
    this.qzg = paramb;
    this.qCN = parama;
  }
  
  private void cjv()
  {
    AppMethodBeat.i(151695);
    com.tencent.mm.kernel.g.Rc().a(1061, this);
    AppMethodBeat.o(151695);
  }
  
  public final void a(Activity paramActivity, String paramString1, boolean paramBoolean1, int paramInt1, int paramInt2, String paramString2, f.a parama, Bundle paramBundle, int paramInt3, boolean paramBoolean2, int paramInt4)
  {
    AppMethodBeat.i(156521);
    boolean bool;
    if (parama == null)
    {
      bool = true;
      ab.i("MicroMsg.ScanBarCodeHelper", "alvinluo handleBarCode dealQBarStringCallback == null: %b, processOfflineScan: %b, selectFromAlbum: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      this.gQx = paramActivity;
      this.qus = paramBoolean1;
      this.qur = paramString1;
      this.cpE = paramInt1;
      this.cpF = paramInt2;
      this.typeName = paramString2;
      this.qCv = paramBundle;
      this.qCO = parama;
      this.qwn = paramInt3;
      this.qCt = paramBoolean2;
      this.qCu = paramInt4;
      if (com.tencent.mm.kernel.g.Rc().adt() != 0) {
        break label318;
      }
      paramBoolean2 = at.isConnected(paramActivity);
      if (!paramBoolean2) {
        break label260;
      }
      paramInt4 = 2;
      label133:
      ab.i("MicroMsg.ScanBarCodeHelper", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (this.qCt) {
        break label282;
      }
      parama = c.qCh;
      if (!c.CL(paramInt3)) {
        break label282;
      }
      parama = c.qCh;
      paramString1 = new OfflineScanContext(this.qzg.getContext(), paramInt4, paramString1, paramInt1, paramInt2, paramString2, paramBoolean1, paramBundle);
      if (!paramBoolean2) {
        break label266;
      }
      paramActivity = paramActivity.getString(2131302921);
      label218:
      c.a(paramString1, paramActivity, false);
      paramActivity = j.qut;
      if (!this.qus) {
        break label276;
      }
    }
    label260:
    label266:
    label276:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      j.l(paramString2, paramInt1, paramInt4, 0);
      AppMethodBeat.o(156521);
      return;
      bool = false;
      break;
      paramInt4 = 1;
      break label133;
      paramActivity = paramActivity.getString(2131302922);
      break label218;
    }
    label282:
    if (this.qCt)
    {
      paramString2 = c.qCh;
      if (c.CL(paramInt3))
      {
        paramString2 = c.qCh;
        c.a(paramActivity, paramActivity.getString(2131302920), null);
      }
    }
    for (;;)
    {
      label318:
      cjv();
      paramActivity = paramString1.split(",", 2);
      if (paramActivity.length >= 2) {
        break;
      }
      ab.e("MicroMsg.ScanBarCodeHelper", "wrong zbar format");
      if (this.qCN != null) {
        this.qCN.onError();
      }
      if (this.qzg != null) {
        this.qzg.kA(false);
      }
      AppMethodBeat.o(156521);
      return;
      Toast.makeText(paramActivity, paramActivity.getString(2131300044), 0).show();
    }
    paramActivity = new com.tencent.mm.plugin.scanner.model.g(t.YP(paramActivity[0]), paramActivity[1], paramInt1, paramInt2);
    paramActivity.qup = paramBoolean1;
    com.tencent.mm.kernel.g.Rc().a(paramActivity, 0);
    if (this.qzg != null)
    {
      this.qzg.ciy();
      kA(true);
    }
    paramString1 = this.gQx;
    this.gQx.getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(paramString1, this.gQx.getString(2131302251), true, new i.1(this, paramActivity));
    AppMethodBeat.o(156521);
  }
  
  public final boolean c(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156522);
    if (paramContext == null)
    {
      AppMethodBeat.o(156522);
      return false;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(156522);
      return false;
    case 1: 
      if (com.tencent.mm.kernel.g.Rc().adu())
      {
        com.tencent.mm.kernel.g.Rc().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(156522);
        return true;
        if (ac.cm(paramContext)) {
          com.tencent.mm.pluginsdk.ui.tools.h.fY(paramContext);
        } else {
          Toast.makeText(paramContext, this.gQx.getString(2131300043, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
    }
    Toast.makeText(paramContext, this.gQx.getString(2131300044), 1).show();
    AppMethodBeat.o(156522);
    return true;
  }
  
  final void cjw()
  {
    AppMethodBeat.i(151699);
    if (this.qCN != null) {
      this.qCN.ciY();
    }
    AppMethodBeat.o(151699);
  }
  
  final void kA(boolean paramBoolean)
  {
    AppMethodBeat.i(151698);
    if (this.qzg != null) {
      this.qzg.kA(paramBoolean);
    }
    AppMethodBeat.o(151698);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(151696);
    ab.i("MicroMsg.ScanBarCodeHelper", "alvinluo onSceneEnd errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.kernel.g.Rc().b(1061, this);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramm == null) || (this.gQx == null))
    {
      if (paramm == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.ScanBarCodeHelper", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.qCN != null) {
          this.qCN.onError();
        }
        AppMethodBeat.o(151696);
        return;
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.gQx, 2131302246, 2131297087, new i.2(this));
      AppMethodBeat.o(151696);
      return;
    }
    paramString = c.qCh;
    if (c.CL(this.qwn))
    {
      paramString = c.qCh;
      if (c.b(paramInt1, paramm))
      {
        if (!this.qCt)
        {
          ab.i("MicroMsg.ScanBarCodeHelper", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = c.qCh;
          c.a(new OfflineScanContext(this.gQx, 2, this.qur, this.cpE, this.cpF, this.typeName, this.qus, this.qCv), this.gQx.getString(2131302921), true);
          paramString = j.qut;
          paramString = this.typeName;
          if (this.qus) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            j.l(paramString, paramInt1, 2, 0);
            AppMethodBeat.o(151696);
            return;
          }
        }
        paramString = c.qCh;
        c.a(this.gQx, this.gQx.getString(2131302920), null);
        AppMethodBeat.o(151696);
        return;
      }
    }
    if (c(this.gQx, paramInt1, paramInt2))
    {
      kA(true);
      AppMethodBeat.o(151696);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.h(this.gQx, 2131302239, 2131297087);
      cjw();
      AppMethodBeat.o(151696);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.gQx, this.gQx.getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      cjw();
      AppMethodBeat.o(151696);
      return;
    }
    paramString = c.qCh;
    if ((c.n(paramm)) && (!this.qCt))
    {
      paramString = j.qut;
      paramString = this.typeName;
      if (!this.qus) {
        break label539;
      }
    }
    label539:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      j.l(paramString, paramInt1, 4, 0);
      if (paramm.getType() != 1061) {
        break label681;
      }
      paramString = ((com.tencent.mm.plugin.scanner.model.g)paramm).cif();
      if (paramString != null) {
        break;
      }
      ab.e("MicroMsg.ScanBarCodeHelper", "onSceneEnd(), getResp() == null");
      cjw();
      AppMethodBeat.o(151696);
      return;
    }
    ab.d("MicroMsg.ScanBarCodeHelper", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.jKs) });
    if (bo.isNullOrNil(paramString.wyR))
    {
      cjw();
      AppMethodBeat.o(151696);
      return;
    }
    switch (q.a(paramString.jKs, paramString.wyR, this.gQx, this.qzg, 4, this.qCO, ((com.tencent.mm.plugin.scanner.model.g)paramm).cpE, ((com.tencent.mm.plugin.scanner.model.g)paramm).cpF, this.qwn, ((com.tencent.mm.plugin.scanner.model.g)paramm).qup, this.qCt, this.typeName, this.qCu))
    {
    }
    for (;;)
    {
      kA(false);
      label681:
      AppMethodBeat.o(151696);
      return;
      if (!this.qCt)
      {
        this.gQx.finish();
        this.gQx.overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(151696);
      return;
      ab.d("MicroMsg.ScanBarCodeHelper", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
      continue;
      ab.e("MicroMsg.ScanBarCodeHelper", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
      if (this.qzg != null) {
        this.qzg.lg(0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */