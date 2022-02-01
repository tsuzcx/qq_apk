package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.openmaterial.g.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g.b;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.s;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/AppBrandOpenMaterialUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "()V", "initActivityCloseAnimation", "", "initActivityOpenAnimation", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseFileInfo", "Lkotlin/Pair;", "", "postLogin", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "preLogin", "", "tryShowOpenMaterial", "filePath", "fileExt", "verifyCaller", "verifyKey", "ui-appchooser_release"})
public final class AppBrandOpenMaterialUI
  extends AutoLoginActivity
{
  private static boolean bfi(String paramString)
  {
    AppMethodBeat.i(204788);
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject2 = ((e)localObject1).azQ().i(ar.a.Ojj);
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, originVerifyKeys is empty");
      AppMethodBeat.o(204788);
      return false;
    }
    localObject2 = (Iterable)n.a((CharSequence)localObject1, new String[] { "," });
    if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
    {
      localObject2 = ((Iterable)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      } while (!Util.isEqual((String)((Iterator)localObject2).next(), paramString));
    }
    for (i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, verify fail, verifyKey: " + paramString + ", originVerifyKeys: " + (String)localObject1);
      AppMethodBeat.o(204788);
      return false;
    }
    AppMethodBeat.o(204788);
    return true;
  }
  
  private static kotlin.o<String, String> bp(Intent paramIntent)
  {
    AppMethodBeat.i(204787);
    if (5 != paramIntent.getIntExtra("menuId", -1))
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, id is not match");
      AppMethodBeat.o(204787);
      return null;
    }
    paramIntent = paramIntent.getStringExtra("thirdCtx");
    Object localObject = (CharSequence)paramIntent;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, thirdContextJsonStr is empty");
      AppMethodBeat.o(204787);
      return null;
    }
    try
    {
      paramIntent = new JSONObject(paramIntent);
      if ((p.j("qb", paramIntent.getString("type")) ^ true))
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, type is illegal");
        AppMethodBeat.o(204787);
        return null;
      }
      localObject = paramIntent.getString("verify");
      p.g(localObject, "verifyKey");
      if (!bfi((String)localObject))
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, verify caller failed");
        AppMethodBeat.o(204787);
        return null;
      }
      localObject = paramIntent.getString("filePath");
      if (!new com.tencent.mm.vfs.o((String)localObject).exists())
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo filePath not exist");
        AppMethodBeat.o(204787);
        return null;
      }
      paramIntent = s.U(localObject, paramIntent.getString("fileExt"));
      AppMethodBeat.o(204787);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, fail since ".concat(String.valueOf(paramIntent)));
      AppMethodBeat.o(204787);
    }
    return null;
  }
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(204786);
    StringBuilder localStringBuilder = new StringBuilder("postLogin, loginResult: ").append(parama).append(", intent: ").append(paramIntent).append(", extras: ");
    if (paramIntent != null) {}
    for (Object localObject = paramIntent.getExtras();; localObject = null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", localObject);
      if ((parama != null) && (AutoLoginActivity.a.Kba == parama) && (paramIntent != null)) {
        break;
      }
      finish();
      AppMethodBeat.o(204786);
      return;
    }
    parama = bp(paramIntent);
    if (parama == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onCreate, fileInfo is null");
      finish();
      AppMethodBeat.o(204786);
      return;
    }
    paramIntent = (String)parama.first;
    localObject = (String)parama.second;
    parama = (i)com.tencent.mm.kernel.g.af(i.class);
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
      AppMethodBeat.o(204786);
      return;
      paramIntent = MaterialModel.eC(paramIntent, (String)localObject);
      if (paramIntent == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, materialModel is null");
        i = 0;
      }
      else
      {
        paramIntent = parama.b(paramIntent);
        p.g(paramIntent, "openMaterialService.rest…Collection(materialModel)");
        if (paramIntent.nlF.isEmpty())
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, openMaterialCollection is illegal");
          i = 0;
        }
        else
        {
          parama = parama.bQa().b(b.nlP).a((Context)this, null, paramIntent);
          p.g(parama, "openMaterialService.open…MaterialCollection, null)");
          parama.a((g.b)new a(this));
          parama.show();
          i = 1;
        }
      }
    }
  }
  
  public final boolean ab(Intent paramIntent)
  {
    return true;
  }
  
  public final void initActivityCloseAnimation()
  {
    AppMethodBeat.i(204785);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(204785);
  }
  
  public final void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(204784);
    overridePendingTransition(0, 0);
    AppMethodBeat.o(204784);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204783);
    setTheme(2131821178);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.ao.e(getWindow());
    getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    AppMethodBeat.o(204783);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onHidden"})
  static final class a
    implements g.b
  {
    a(AppBrandOpenMaterialUI paramAppBrandOpenMaterialUI) {}
    
    public final void bQd()
    {
      AppMethodBeat.i(204782);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onHidden#tryShowOpenMaterial");
      this.Ksu.finish();
      AppMethodBeat.o(204782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppBrandOpenMaterialUI
 * JD-Core Version:    0.7.0.1
 */