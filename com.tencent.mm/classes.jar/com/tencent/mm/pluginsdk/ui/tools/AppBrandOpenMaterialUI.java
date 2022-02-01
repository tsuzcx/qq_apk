package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.d.a.g;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/AppBrandOpenMaterialUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "()V", "initActivityCloseAnimation", "", "initActivityOpenAnimation", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseFileInfo", "Lkotlin/Pair;", "", "postLogin", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "preLogin", "", "tryShowOpenMaterial", "filePath", "fileExt", "verifyCaller", "verifyKey", "ui-appchooser_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandOpenMaterialUI
  extends AutoLoginActivity
{
  private static final void a(AppBrandOpenMaterialUI paramAppBrandOpenMaterialUI)
  {
    AppMethodBeat.i(245782);
    s.u(paramAppBrandOpenMaterialUI, "this$0");
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onHidden#tryShowOpenMaterial");
    paramAppBrandOpenMaterialUI.finish();
    AppMethodBeat.o(245782);
  }
  
  private static r<String, String> bS(Intent paramIntent)
  {
    AppMethodBeat.i(245775);
    if (5 != paramIntent.getIntExtra("menuId", -1))
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, id is not match");
      AppMethodBeat.o(245775);
      return null;
    }
    paramIntent = paramIntent.getStringExtra("thirdCtx");
    Object localObject = (CharSequence)paramIntent;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, thirdContextJsonStr is empty");
      AppMethodBeat.o(245775);
      return null;
    }
    try
    {
      paramIntent = new JSONObject(paramIntent);
      if (!s.p("qb", paramIntent.getString("type")))
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, type is illegal");
        AppMethodBeat.o(245775);
        return null;
      }
      localObject = paramIntent.getString("verify");
      s.s(localObject, "verifyKey");
      if (!brs((String)localObject))
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, verify caller failed");
        AppMethodBeat.o(245775);
        return null;
      }
      localObject = paramIntent.getString("filePath");
      if (!new u((String)localObject).jKS())
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo filePath not exist");
        AppMethodBeat.o(245775);
        return null;
      }
      paramIntent = v.Y(localObject, paramIntent.getString("fileExt"));
      AppMethodBeat.o(245775);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", s.X("parseFileInfo, fail since ", paramIntent));
      AppMethodBeat.o(245775);
    }
    return null;
  }
  
  private static boolean brs(String paramString)
  {
    String str = null;
    AppMethodBeat.i(245779);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZm, null);
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, originVerifyKeys is empty");
      AppMethodBeat.o(245779);
      return false;
    }
    localObject = (Iterable)n.a((CharSequence)str, new String[] { "," });
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!Util.isEqual((String)((Iterator)localObject).next(), paramString));
    }
    for (i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, verify fail, verifyKey: " + paramString + ", originVerifyKeys: " + str);
      AppMethodBeat.o(245779);
      return false;
    }
    AppMethodBeat.o(245779);
    return true;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(245801);
    StringBuilder localStringBuilder = new StringBuilder("postLogin, loginResult: ").append(parama).append(", intent: ").append(paramIntent).append(", extras: ");
    if (paramIntent == null) {}
    for (Object localObject = null;; localObject = paramIntent.getExtras())
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", localObject);
      if ((parama != null) && (AutoLoginActivity.a.XXL == parama) && (paramIntent != null)) {
        break;
      }
      finish();
      AppMethodBeat.o(245801);
      return;
    }
    parama = bS(paramIntent);
    if (parama == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onCreate, fileInfo is null");
      finish();
      AppMethodBeat.o(245801);
      return;
    }
    paramIntent = (String)parama.bsC;
    localObject = (String)parama.bsD;
    parama = (j)com.tencent.mm.kernel.h.ax(j.class);
    int i;
    if (parama == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, openMaterialService is null");
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onCreate, try show open material fail");
        finish();
      }
      AppMethodBeat.o(245801);
      return;
      localObject = MaterialModel.fh(paramIntent, (String)localObject);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, materialModel is null");
        i = 0;
      }
      else
      {
        paramIntent = parama.b((MaterialModel)localObject);
        s.s(paramIntent, "openMaterialService.rest…Collection(materialModel)");
        if (!parama.cDh().a(paramIntent))
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, can not create");
          i = 0;
        }
        else
        {
          localObject = parama.a(b.trZ, (MaterialModel)localObject, paramIntent, true);
          s.s(localObject, "openMaterialService.rest…MaterialCollection, true)");
          parama = parama.cDh().b(b.trZ).a((Context)this, null, paramIntent, null, (com.tencent.mm.plugin.appbrand.openmaterial.h)localObject);
          s.s(parama, "openMaterialService.open…    openMaterialReporter)");
          parama.a(new AppBrandOpenMaterialUI..ExternalSyntheticLambda0(this));
          parama.show();
          i = 1;
        }
      }
    }
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(245792);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(245792);
  }
  
  public final void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(245790);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(245790);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245789);
    setTheme(a.g.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    aw.g(getWindow());
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    AppMethodBeat.o(245789);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppBrandOpenMaterialUI
 * JD-Core Version:    0.7.0.1
 */