package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e.p;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "iconFromJsApi", "", "isSupportMultiTaskFBMenu", "", "()Z", "isSupportSwipeToMultiTask", "webMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/WebMultiTaskData;", "fillMultiTaskInfo", "", "getTaskId", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onCreate", "multiTaskType", "multiTaskId", "onMenuMultiTaskSelected", "enterMultiTask", "setIconFromJsApi", "icon", "setIconFromPreverify", "Companion", "plugin-webview_release"})
public final class t
  extends c
{
  private static final Set<String> IUM;
  private static final String IVd = "wx62d9035fd4fd2059";
  public static final t.a IVe;
  private static final String TAG = "MicroMsg.LuggageWebViewMultiTaskHelper";
  private final g IVa;
  private final fah IVb;
  public String IVc;
  
  static
  {
    AppMethodBeat.i(210319);
    IVe = new t.a((byte)0);
    TAG = "MicroMsg.LuggageWebViewMultiTaskHelper";
    IVd = "wx62d9035fd4fd2059";
    Set localSet = (Set)new HashSet();
    IUM = localSet;
    localSet.add("title");
    localSet.add("webpageTitle");
    localSet.add("hide_option_menu");
    localSet.add("translate_webview");
    localSet.add("srcUsername");
    localSet.add("srcDisplayname");
    localSet.add("mode");
    localSet.add("KTemplateId");
    localSet.add("KPublisherId");
    String str = e.p.Ozw;
    p.g(str, "ConstantsUI.WebViewUI.KTmplScene");
    localSet.add(str);
    str = e.p.Ozx;
    p.g(str, "ConstantsUI.WebViewUI.KTmplSubScene");
    localSet.add(str);
    localSet.add("pay_channel");
    localSet.add("key_download_restrict");
    localSet.add("key_wallet_region");
    localSet.add("key_function_id");
    str = e.p.OzA;
    p.g(str, "ConstantsUI.WebViewUI.KTmplItemShowType");
    localSet.add(str);
    localSet.add("geta8key_scene");
    localSet.add("biz_video_msg_id");
    localSet.add("biz_video_msg_index");
    localSet.add("biz_video_msg_svr_id");
    localSet.add("biz_mp_msg_info");
    str = e.p.OzI;
    p.g(str, "ConstantsUI.WebViewUI.KAdUxInfoForJsApiPay");
    localSet.add(str);
    localSet.add("key_menu_hide_expose");
    localSet.add("webviewCurrentProcess");
    AppMethodBeat.o(210319);
  }
  
  public t(g paramg, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(210318);
    this.IVa = paramg;
    this.IVb = new fah();
    paramg = this.Aak;
    if (paramg != null) {}
    for (paramg = paramg.getIntent();; paramg = null)
    {
      if (paramg != null)
      {
        paramg = this.Aak;
        if (paramg == null) {
          p.hyc();
        }
        paramg = paramg.getIntent();
        if (paramg == null) {
          p.hyc();
        }
        b.b(paramg, this.IVb);
      }
      AppMethodBeat.o(210318);
      return;
    }
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(210312);
    super.G(paramInt, paramString);
    paramString = this.Aak;
    if (paramString != null)
    {
      paramString = paramString.getIntent();
      if (paramString == null) {}
    }
    for (paramString = (MultiTaskInfo)paramString.getParcelableExtra("KMutilTaskInfo");; paramString = null)
    {
      if (paramString != null) {
        this.Abp = paramString;
      }
      AppMethodBeat.o(210312);
      return;
    }
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(210314);
    bPu();
    paramBoolean = super.O(paramInt, paramBoolean);
    AppMethodBeat.o(210314);
    return paramBoolean;
  }
  
  public final boolean bPp()
  {
    AppMethodBeat.i(210315);
    boolean bool = this.IVa.cpz();
    AppMethodBeat.o(210315);
    return bool;
  }
  
  public final boolean bPq()
  {
    AppMethodBeat.i(210316);
    boolean bool = this.IVa.cpz();
    AppMethodBeat.o(210316);
    return bool;
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(210317);
    try
    {
      this.IVb.edo = this.IVa.coX();
      this.IVb.title = this.IVa.getTitle();
      MultiTaskInfo localMultiTaskInfo = this.Abp;
      if (localMultiTaskInfo != null)
      {
        localMultiTaskInfo.field_data = this.IVb.toByteArray();
        AppMethodBeat.o(210317);
        return;
      }
      AppMethodBeat.o(210317);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + localException.getMessage());
      AppMethodBeat.o(210317);
    }
  }
  
  public final String bjl()
  {
    MultiTaskInfo localMultiTaskInfo = this.Abp;
    if (localMultiTaskInfo != null) {
      return localMultiTaskInfo.field_id;
    }
    return null;
  }
  
  public final boolean dki()
  {
    return true;
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(210313);
    bPu();
    super.ic(paramBoolean);
    AppMethodBeat.o(210313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.t
 * JD-Core Version:    0.7.0.1
 */