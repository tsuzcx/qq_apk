package com.tencent.mm.ui.chatting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.h.a;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class AppAttachNewDownloadUI$b
  implements k
{
  private final i QdV;
  private final WeakReference<AppAttachNewDownloadUI> Rxt;
  private final MaterialModel qng;
  
  public AppAttachNewDownloadUI$b(AppAttachNewDownloadUI paramAppAttachNewDownloadUI, MaterialModel paramMaterialModel, i parami)
  {
    AppMethodBeat.i(290970);
    this.Rxt = new WeakReference(paramAppAttachNewDownloadUI);
    this.qng = paramMaterialModel;
    this.QdV = parami;
    AppMethodBeat.o(290970);
  }
  
  public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(290971);
    Log.d("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
    AppAttachNewDownloadUI localAppAttachNewDownloadUI = (AppAttachNewDownloadUI)this.Rxt.get();
    if (localAppAttachNewDownloadUI == null)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
      AppMethodBeat.o(290971);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
      AppMethodBeat.o(290971);
      return;
    }
    AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.qng.qnl);
    AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, paramAppBrandOpenMaterialCollection);
    if (!AppAttachNewDownloadUI.d(localAppAttachNewDownloadUI))
    {
      Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, download not finish");
      AppMethodBeat.o(290971);
      return;
    }
    if (this.QdV.ccL().a(paramAppBrandOpenMaterialCollection))
    {
      if (AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI) != null) {
        AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI).dead();
      }
      AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.QdV.ccL().b(b.qns).a(localAppAttachNewDownloadUI, AppAttachNewDownloadUI.w(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.x(localAppAttachNewDownloadUI), null, null));
      Log.d("MicroMsg.AppAttachNewDownloadUI", "show moreOpenWaysArea");
      AppAttachNewDownloadUI.y(localAppAttachNewDownloadUI).setVisibility(0);
    }
    while (AppAttachNewDownloadUI.w(localAppAttachNewDownloadUI) != null) {
      if (this.QdV.a(AppAttachNewDownloadUI.w(localAppAttachNewDownloadUI), paramAppBrandOpenMaterialCollection))
      {
        if (AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI) != null) {
          AppAttachNewDownloadUI.z(localAppAttachNewDownloadUI).dead();
        }
        AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI, this.QdV.a(b.qns, localAppAttachNewDownloadUI, AppAttachNewDownloadUI.w(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.x(localAppAttachNewDownloadUI), AppAttachNewDownloadUI.a(localAppAttachNewDownloadUI), null));
        AppMethodBeat.o(290971);
        return;
        Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, can not create");
      }
      else
      {
        Log.i("MicroMsg.AppAttachNewDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
      }
    }
    AppMethodBeat.o(290971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.b
 * JD-Core Version:    0.7.0.1
 */