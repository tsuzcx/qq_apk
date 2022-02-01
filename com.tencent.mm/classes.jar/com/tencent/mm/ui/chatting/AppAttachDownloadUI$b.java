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

final class AppAttachDownloadUI$b
  implements k
{
  private final i QdV;
  private final WeakReference<AppAttachDownloadUI> Rxt;
  private final MaterialModel qng;
  
  public AppAttachDownloadUI$b(AppAttachDownloadUI paramAppAttachDownloadUI, MaterialModel paramMaterialModel, i parami)
  {
    AppMethodBeat.i(274413);
    this.Rxt = new WeakReference(paramAppAttachDownloadUI);
    this.qng = paramMaterialModel;
    this.QdV = parami;
    AppMethodBeat.o(274413);
  }
  
  public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(274416);
    Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
    AppAttachDownloadUI localAppAttachDownloadUI = (AppAttachDownloadUI)this.Rxt.get();
    if (localAppAttachDownloadUI == null)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
      AppMethodBeat.o(274416);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
      AppMethodBeat.o(274416);
      return;
    }
    AppAttachDownloadUI.a(localAppAttachDownloadUI, this.qng.qnl);
    AppAttachDownloadUI.a(localAppAttachDownloadUI, paramAppBrandOpenMaterialCollection);
    if (!AppAttachDownloadUI.d(localAppAttachDownloadUI))
    {
      Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, download not finish");
      AppMethodBeat.o(274416);
      return;
    }
    if (this.QdV.ccL().a(paramAppBrandOpenMaterialCollection))
    {
      if (AppAttachDownloadUI.a(localAppAttachDownloadUI) != null) {
        AppAttachDownloadUI.a(localAppAttachDownloadUI).dead();
      }
      AppAttachDownloadUI.a(localAppAttachDownloadUI, this.QdV.ccL().b(b.qns).a(localAppAttachDownloadUI, AppAttachDownloadUI.w(localAppAttachDownloadUI), AppAttachDownloadUI.x(localAppAttachDownloadUI), null, null));
      Log.d("MicroMsg.AppAttachDownloadUI", "show moreOpenWaysArea");
      AppAttachDownloadUI.y(localAppAttachDownloadUI).setVisibility(0);
    }
    while (AppAttachDownloadUI.w(localAppAttachDownloadUI) != null) {
      if (this.QdV.a(AppAttachDownloadUI.w(localAppAttachDownloadUI), paramAppBrandOpenMaterialCollection))
      {
        if (AppAttachDownloadUI.z(localAppAttachDownloadUI) != null) {
          AppAttachDownloadUI.z(localAppAttachDownloadUI).dead();
        }
        AppAttachDownloadUI.a(localAppAttachDownloadUI, this.QdV.a(b.qns, localAppAttachDownloadUI, AppAttachDownloadUI.w(localAppAttachDownloadUI), AppAttachDownloadUI.x(localAppAttachDownloadUI), AppAttachDownloadUI.a(localAppAttachDownloadUI), null));
        AppMethodBeat.o(274416);
        return;
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, can not create");
      }
      else
      {
        Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
      }
    }
    AppMethodBeat.o(274416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.b
 * JD-Core Version:    0.7.0.1
 */