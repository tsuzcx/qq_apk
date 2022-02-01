package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.s;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "iconFromJsApi", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "webMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/WebMultiTaskData;", "fillMultiTaskInfo", "", "getTaskId", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onCreate", "multiTaskType", "multiTaskId", "onMenuMultiTaskSelected", "enterMultiTask", "setIconFromJsApi", "icon", "setIconFromPreverify", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends c
{
  private static final String TAG;
  private static final Set<String> WHA;
  public static final a WHN;
  private static final String WHR;
  private final g WHO;
  private final ghm WHP;
  public String WHQ;
  
  static
  {
    AppMethodBeat.i(295936);
    WHN = new a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskHelper";
    WHR = "wx62d9035fd4fd2059";
    Set localSet = (Set)new HashSet();
    WHA = localSet;
    localSet.add("title");
    localSet.add("webpageTitle");
    localSet.add("hide_option_menu");
    localSet.add("translate_webview");
    localSet.add("srcUsername");
    localSet.add("srcDisplayname");
    localSet.add("mode");
    localSet.add("KTemplateId");
    localSet.add("KPublisherId");
    localSet.add("KOpenArticleSceneFromScene");
    String str = f.s.adwT;
    s.s(str, "KTmplSubScene");
    localSet.add(str);
    localSet.add("pay_channel");
    localSet.add("key_download_restrict");
    localSet.add("key_wallet_region");
    localSet.add("key_function_id");
    str = f.s.adwW;
    s.s(str, "KTmplItemShowType");
    localSet.add(str);
    localSet.add("geta8key_scene");
    str = f.s.adxe;
    s.s(str, "KAdUxInfoForJsApiPay");
    localSet.add(str);
    localSet.add("key_menu_hide_expose");
    localSet.add("webviewCurrentProcess");
    AppMethodBeat.o(295936);
  }
  
  public u(g paramg, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(295934);
    this.WHO = paramg;
    this.WHP = new ghm();
    paramg = this.LBU;
    if (paramg == null) {}
    for (paramg = null;; paramg = paramg.getIntent())
    {
      if (paramg != null)
      {
        paramg = this.LBU;
        s.checkNotNull(paramg);
        paramg = paramg.getIntent();
        s.checkNotNull(paramg);
        b.b(paramg, this.WHP);
      }
      AppMethodBeat.o(295934);
      return;
    }
  }
  
  public final void J(int paramInt, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(295938);
    super.J(paramInt, paramString);
    paramString = this.LBU;
    if (paramString == null) {
      paramString = localObject;
    }
    for (;;)
    {
      if (paramString != null) {
        this.LCE = paramString;
      }
      AppMethodBeat.o(295938);
      return;
      Intent localIntent = paramString.getIntent();
      paramString = localObject;
      if (localIntent != null) {
        paramString = (MultiTaskInfo)localIntent.getParcelableExtra("KMutilTaskInfo");
      }
    }
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(295942);
    cCe();
    paramBoolean = super.af(paramInt, paramBoolean);
    AppMethodBeat.o(295942);
    return paramBoolean;
  }
  
  public final String bQs()
  {
    MultiTaskInfo localMultiTaskInfo = this.LCE;
    if (localMultiTaskInfo == null) {
      return null;
    }
    return localMultiTaskInfo.field_id;
  }
  
  public final boolean cBZ()
  {
    AppMethodBeat.i(295943);
    boolean bool = this.WHO.dhz();
    AppMethodBeat.o(295943);
    return bool;
  }
  
  public final boolean cCa()
  {
    AppMethodBeat.i(295945);
    boolean bool = this.WHO.dhz();
    AppMethodBeat.o(295945);
    return bool;
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(295947);
    try
    {
      this.WHP.idu = this.WHO.dgY();
      this.WHP.title = this.WHO.getTitle();
      MultiTaskInfo localMultiTaskInfo = this.LCE;
      if (localMultiTaskInfo != null) {
        localMultiTaskInfo.field_data = this.WHP.toByteArray();
      }
      AppMethodBeat.o(295947);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebMultiTaskHelper", s.X("onMenuMultiTaskSelected error, ex = ", localException.getMessage()));
      AppMethodBeat.o(295947);
    }
  }
  
  public final boolean eCI()
  {
    return true;
  }
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(295939);
    cCe();
    super.ke(paramBoolean);
    AppMethodBeat.o(295939);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper$Companion;", "", "()V", "GAME_APPID", "", "getGAME_APPID", "()Ljava/lang/String;", "TAG", "getTAG", "sSavedKeysForWebPage", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */