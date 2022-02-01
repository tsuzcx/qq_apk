package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.r;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "iconFromJsApi", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "webMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/WebMultiTaskData;", "fillMultiTaskInfo", "", "getTaskId", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onCreate", "multiTaskType", "multiTaskId", "onMenuMultiTaskSelected", "enterMultiTask", "setIconFromJsApi", "icon", "setIconFromPreverify", "Companion", "plugin-webview_release"})
public final class t
  extends c
{
  private static final Set<String> PRd;
  private static final String PRt = "wx62d9035fd4fd2059";
  public static final a PRu;
  private static final String TAG = "MicroMsg.LuggageWebViewMultiTaskHelper";
  private final g PRq;
  private final fky PRr;
  public String PRs;
  
  static
  {
    AppMethodBeat.i(267918);
    PRu = new a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskHelper";
    PRt = "wx62d9035fd4fd2059";
    Set localSet = (Set)new HashSet();
    PRd = localSet;
    localSet.add("title");
    localSet.add("webpageTitle");
    localSet.add("hide_option_menu");
    localSet.add("translate_webview");
    localSet.add("srcUsername");
    localSet.add("srcDisplayname");
    localSet.add("mode");
    localSet.add("KTemplateId");
    localSet.add("KPublisherId");
    String str = f.r.VSK;
    p.j(str, "ConstantsUI.WebViewUI.KTmplScene");
    localSet.add(str);
    str = f.r.VSL;
    p.j(str, "ConstantsUI.WebViewUI.KTmplSubScene");
    localSet.add(str);
    localSet.add("pay_channel");
    localSet.add("key_download_restrict");
    localSet.add("key_wallet_region");
    localSet.add("key_function_id");
    str = f.r.VSO;
    p.j(str, "ConstantsUI.WebViewUI.KTmplItemShowType");
    localSet.add(str);
    localSet.add("geta8key_scene");
    str = f.r.VSW;
    p.j(str, "ConstantsUI.WebViewUI.KAdUxInfoForJsApiPay");
    localSet.add(str);
    localSet.add("key_menu_hide_expose");
    localSet.add("webviewCurrentProcess");
    AppMethodBeat.o(267918);
  }
  
  public t(g paramg, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(267917);
    this.PRq = paramg;
    this.PRr = new fky();
    paramg = this.FGb;
    if (paramg != null) {}
    for (paramg = paramg.getIntent();; paramg = null)
    {
      if (paramg != null)
      {
        paramg = this.FGb;
        if (paramg == null) {
          p.iCn();
        }
        paramg = paramg.getIntent();
        if (paramg == null) {
          p.iCn();
        }
        b.b(paramg, this.PRr);
      }
      AppMethodBeat.o(267917);
      return;
    }
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(267909);
    super.I(paramInt, paramString);
    paramString = this.FGb;
    if (paramString != null)
    {
      paramString = paramString.getIntent();
      if (paramString == null) {}
    }
    for (paramString = (MultiTaskInfo)paramString.getParcelableExtra("KMutilTaskInfo");; paramString = null)
    {
      if (paramString != null) {
        this.FHd = paramString;
      }
      AppMethodBeat.o(267909);
      return;
    }
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(267912);
    cbL();
    paramBoolean = super.Q(paramInt, paramBoolean);
    AppMethodBeat.o(267912);
    return paramBoolean;
  }
  
  public final String bsL()
  {
    MultiTaskInfo localMultiTaskInfo = this.FHd;
    if (localMultiTaskInfo != null) {
      return localMultiTaskInfo.field_id;
    }
    return null;
  }
  
  public final boolean cbG()
  {
    AppMethodBeat.i(267913);
    boolean bool = this.PRq.cDX();
    AppMethodBeat.o(267913);
    return bool;
  }
  
  public final boolean cbH()
  {
    AppMethodBeat.i(267915);
    boolean bool = this.PRq.cDX();
    AppMethodBeat.o(267915);
    return bool;
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(267916);
    try
    {
      this.PRr.fXu = this.PRq.cDu();
      this.PRr.title = this.PRq.getTitle();
      MultiTaskInfo localMultiTaskInfo = this.FHd;
      if (localMultiTaskInfo != null)
      {
        localMultiTaskInfo.field_data = this.PRr.toByteArray();
        AppMethodBeat.o(267916);
        return;
      }
      AppMethodBeat.o(267916);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
      AppMethodBeat.o(267916);
    }
  }
  
  public final boolean dJN()
  {
    return true;
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(267911);
    cbL();
    super.iW(paramBoolean);
    AppMethodBeat.o(267911);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper$Companion;", "", "()V", "GAME_APPID", "", "getGAME_APPID", "()Ljava/lang/String;", "TAG", "getTAG", "sSavedKeysForWebPage", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */