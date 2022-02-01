package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.yp;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "lastRequestSession", "", "getLastRequestSession", "()J", "setLastRequestSession", "(J)V", "mBackPressCancel", "", "mScene", "", "mSessionId", "mSessionIdString", "mSource", "mUseCdnOpt", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "snsId", "snsImageDownloadListener", "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1", "getSnsImageDownloadListener", "()Lcom/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1;", "snsImageDownloadListener$delegate", "Lkotlin/Lazy;", "snsImagePath", "snsUsername", "type", "getLayoutId", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onError", "reportAction", "action", "imagePath", "sessionId", "cgiRet", "timestamp", "showLoading", "startImageSearch", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSearchSnsImageLoadingUI
  extends MMActivity
{
  private dmz Qsr;
  private final String TAG;
  private String WnO;
  private String Wrl;
  private boolean Wrm;
  private boolean Wrn;
  private long Wrp;
  private final j Wrs;
  private String hET;
  private String hQX;
  private int mScene;
  private long mSessionId;
  private int type;
  private int xOq;
  
  public WebSearchSnsImageLoadingUI()
  {
    AppMethodBeat.i(315143);
    this.TAG = "MicroMsg.WebSearch.WebSearchSnsImageLoadingUI";
    this.Wrl = "";
    this.Wrn = true;
    this.hQX = "";
    this.WnO = "";
    this.hET = "";
    this.Wrs = k.cm((kotlin.g.a.a)new WebSearchSnsImageLoadingUI.b(this));
    AppMethodBeat.o(315143);
  }
  
  private final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(315156);
    d.B((kotlin.g.a.a)new WebSearchSnsImageLoadingUI.a(this, paramInt1, paramString2, paramString1, paramInt2, paramLong));
    AppMethodBeat.o(315156);
  }
  
  private static final void a(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI)
  {
    AppMethodBeat.i(315169);
    s.u(paramWebSearchSnsImageLoadingUI, "this$0");
    paramWebSearchSnsImageLoadingUI.finish();
    AppMethodBeat.o(315169);
  }
  
  private static final void a(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI, View paramView)
  {
    AppMethodBeat.i(315159);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWebSearchSnsImageLoadingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWebSearchSnsImageLoadingUI, "this$0");
    ((MMAnimateView)paramWebSearchSnsImageLoadingUI.findViewById(a.d.loading_iv)).setVisibility(0);
    ((TextView)paramWebSearchSnsImageLoadingUI.findViewById(a.d.loading_tv)).setVisibility(0);
    ((TextView)paramWebSearchSnsImageLoadingUI.findViewById(a.d.error_tv)).setVisibility(8);
    ((Button)paramWebSearchSnsImageLoadingUI.findViewById(a.d.error_btn)).setVisibility(8);
    paramWebSearchSnsImageLoadingUI.biH(paramWebSearchSnsImageLoadingUI.hET);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315159);
  }
  
  private static final void a(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI, String paramString, long paramLong, f paramf)
  {
    AppMethodBeat.i(315180);
    s.u(paramWebSearchSnsImageLoadingUI, "this$0");
    s.u(paramString, "$imagePath");
    s.u(paramf, "result");
    Log.i(paramWebSearchSnsImageLoadingUI.TAG, "uploadImageForSearch callback %s filePath:%s isSuccess:%b, session: %s, mBackPressCancel: %s, mScene: %s, useCdnOpt: %s.", new Object[] { paramf.hAT, paramf.imagePath, Boolean.valueOf(paramf.success), Long.valueOf(paramLong), Boolean.valueOf(paramWebSearchSnsImageLoadingUI.Wrm), Integer.valueOf(paramWebSearchSnsImageLoadingUI.mScene), Boolean.valueOf(paramWebSearchSnsImageLoadingUI.Wrn) });
    if (paramWebSearchSnsImageLoadingUI.Wrm)
    {
      AppMethodBeat.o(315180);
      return;
    }
    paramWebSearchSnsImageLoadingUI.Wrp = 0L;
    Object localObject1;
    boolean bool;
    if (paramf.success)
    {
      localObject1 = new com.tencent.mm.plugin.websearch.api.ah();
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).context = ((Context)paramWebSearchSnsImageLoadingUI);
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).sessionId = paramWebSearchSnsImageLoadingUI.Wrl;
      if (((paramWebSearchSnsImageLoadingUI.mScene != 83) || (paramWebSearchSnsImageLoadingUI.mScene != 100)) && ((paramWebSearchSnsImageLoadingUI.xOq == 15) || (paramWebSearchSnsImageLoadingUI.xOq == 16)))
      {
        bool = true;
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoR = bool;
        if (paramWebSearchSnsImageLoadingUI.xOq == 17) {
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoR = true;
        }
        if ((paramWebSearchSnsImageLoadingUI.xOq != 12) && (paramWebSearchSnsImageLoadingUI.xOq != 11) && (paramWebSearchSnsImageLoadingUI.xOq != 13) && (paramWebSearchSnsImageLoadingUI.xOq != 14)) {
          break label351;
        }
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = 83;
        label260:
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoH = true;
        if (paramf.jumpType != 3) {
          break label458;
        }
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).query = paramf.OMO;
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((com.tencent.mm.plugin.websearch.api.ah)localObject1);
      }
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.o(new WebSearchSnsImageLoadingUI..ExternalSyntheticLambda4(paramWebSearchSnsImageLoadingUI), 500L);
      paramWebSearchSnsImageLoadingUI.a(5, paramString, paramWebSearchSnsImageLoadingUI.Wrl, paramf.errCode, System.currentTimeMillis());
      AppMethodBeat.o(315180);
      return;
      bool = false;
      break;
      label351:
      if ((paramWebSearchSnsImageLoadingUI.xOq == 18) || (paramWebSearchSnsImageLoadingUI.xOq == 19) || (paramWebSearchSnsImageLoadingUI.xOq == 20) || (paramWebSearchSnsImageLoadingUI.xOq == 21))
      {
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = 100;
        break label260;
      }
      if ((paramWebSearchSnsImageLoadingUI.xOq == 15) || (paramWebSearchSnsImageLoadingUI.xOq == 16))
      {
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = paramWebSearchSnsImageLoadingUI.mScene;
        break label260;
      }
      if (paramWebSearchSnsImageLoadingUI.xOq == 17)
      {
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = paramWebSearchSnsImageLoadingUI.mScene;
        break label260;
      }
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = 81;
      break label260;
      label458:
      Object localObject2 = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
      s.s(localObject2, "params.extParams");
      ((Map)localObject2).put("chatSearch", "2");
      try
      {
        localObject2 = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
        s.s(localObject2, "params.extParams");
        ((Map)localObject2).put("reqKey", r.as(paramf.hAT, "utf8"));
        label524:
        localObject2 = s.X("weixin://fts/image?path=", y.n(paramf.imagePath, false));
        try
        {
          Map localMap = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
          s.s(localMap, "params.extParams");
          localMap.put("cacheImageSrc", r.as((String)localObject2, "utf8"));
          label575:
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoI = true;
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoJ = false;
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoS = true;
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoL = com.tencent.mm.cd.a.w((Context)paramWebSearchSnsImageLoadingUI, a.a.white);
          ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoM = true;
          ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((com.tencent.mm.plugin.websearch.api.ah)localObject1);
          localObject1 = paramf.imagePath;
          s.s(localObject1, "result.imagePath");
          paramWebSearchSnsImageLoadingUI.a(8, (String)localObject1, paramWebSearchSnsImageLoadingUI.Wrl, 0, System.currentTimeMillis());
          continue;
          d.uiThread((kotlin.g.a.a)new c(paramWebSearchSnsImageLoadingUI));
        }
        catch (Exception localException1)
        {
          break label575;
        }
      }
      catch (Exception localException2)
      {
        break label524;
      }
    }
  }
  
  private static final boolean a(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(315157);
    s.u(paramWebSearchSnsImageLoadingUI, "this$0");
    paramWebSearchSnsImageLoadingUI.finish();
    paramWebSearchSnsImageLoadingUI.a(11, "", paramWebSearchSnsImageLoadingUI.Wrl, 0, System.currentTimeMillis());
    AppMethodBeat.o(315157);
    return false;
  }
  
  private final void atR()
  {
    AppMethodBeat.i(315154);
    ((MMAnimateView)findViewById(a.d.loading_iv)).setVisibility(8);
    ((TextView)findViewById(a.d.loading_tv)).setVisibility(8);
    ((TextView)findViewById(a.d.error_tv)).setVisibility(8);
    ((Button)findViewById(a.d.error_btn)).setVisibility(8);
    ((TextView)findViewById(a.d.expire_tv)).setVisibility(0);
    ((Button)findViewById(a.d.expire_btn)).setVisibility(0);
    ((Button)findViewById(a.d.expire_btn)).setOnClickListener(new WebSearchSnsImageLoadingUI..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(315154);
  }
  
  private static final void b(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI, View paramView)
  {
    AppMethodBeat.i(315164);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWebSearchSnsImageLoadingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWebSearchSnsImageLoadingUI, "this$0");
    paramWebSearchSnsImageLoadingUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315164);
  }
  
  private final WebSearchSnsImageLoadingUI.snsImageDownloadListener.2.1 iqJ()
  {
    AppMethodBeat.i(315146);
    WebSearchSnsImageLoadingUI.snsImageDownloadListener.2.1 local1 = (WebSearchSnsImageLoadingUI.snsImageDownloadListener.2.1)this.Wrs.getValue();
    AppMethodBeat.o(315146);
    return local1;
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(315150);
    if (aw.isDarkMode())
    {
      ((MMAnimateView)findViewById(a.d.loading_iv)).setImageResource(a.f.websearch_dark_loading);
      AppMethodBeat.o(315150);
      return;
    }
    ((MMAnimateView)findViewById(a.d.loading_iv)).setImageResource(a.f.websearch_light_loading);
    AppMethodBeat.o(315150);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void biH(String paramString)
  {
    AppMethodBeat.i(315241);
    s.u(paramString, "imagePath");
    com.tencent.mm.plugin.scanner.api.e locale = new com.tencent.mm.plugin.scanner.api.e();
    locale.type = this.type;
    locale.imagePath = paramString;
    locale.mode = 4;
    locale.OMH = new nz();
    locale.OMH.YQo = aj.asY(0);
    locale.OML = this.Wrn;
    Object localObject = aj.dch();
    if (localObject != null)
    {
      locale.OMI = new nq();
      locale.OMI.longitude = ((dhb)localObject).ZaG;
      locale.OMI.latitude = ((dhb)localObject).ZaH;
      locale.OMI.YPF = ((dhb)localObject).Zyl;
      locale.sessionId = this.mSessionId;
    }
    localObject = this.Qsr;
    if (localObject != null) {}
    try
    {
      locale.OMx.putByteArray("key_sns_media_data", ((dmz)localObject).toByteArray());
      a(2, paramString, this.Wrl, 0, System.currentTimeMillis());
      this.Wrp = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(locale, new WebSearchSnsImageLoadingUI..ExternalSyntheticLambda3(this, paramString));
      if (this.Wrp != 0L) {
        a(4, paramString, this.Wrl, 0, System.currentTimeMillis());
      }
      AppMethodBeat.o(315241);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localException, "alvinluo startImageSearch mediaObj toByteArray exception", new Object[0]);
      }
    }
  }
  
  public final int getLayoutId()
  {
    return a.e.websearch_image_loading_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(315253);
    super.onBackPressed();
    a(11, "", this.Wrl, 0, System.currentTimeMillis());
    Log.d(this.TAG, "onBackPressed = %s", new Object[] { Boolean.valueOf(this.Wrm) });
    this.Wrm = true;
    AppMethodBeat.o(315253);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(315227);
    super.onCreate(paramBundle);
    this.mSessionId = getIntent().getLongExtra("key_session_id", 0L);
    Object localObject = getIntent().getStringExtra("key_sns_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.hQX = paramBundle;
    localObject = getIntent().getStringExtra("key_sns_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.WnO = paramBundle;
    localObject = getIntent().getStringExtra("key_sns_image_path");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.hET = paramBundle;
    this.type = getIntent().getIntExtra("key_scan_goods_request_type", 0);
    this.mScene = getIntent().getIntExtra("key_scene", 0);
    paramBundle = com.tencent.mm.plugin.fts.a.e.rr(this.mSessionId);
    s.s(paramBundle, "getUnsignedLong(mSessionId)");
    this.Wrl = paramBundle;
    this.xOq = getIntent().getIntExtra("key_source", 0);
    this.Wrn = getIntent().getBooleanExtra("key_upload_image_use_cdn_opt", true);
    int i;
    if (this.mScene != 0) {
      i = this.mScene;
    }
    for (;;)
    {
      this.mScene = i;
      localObject = getIntent().getByteArrayExtra("key_sns_media");
      if (localObject != null) {
        paramBundle = new dmz();
      }
      try
      {
        paramBundle.parseFrom((byte[])localObject);
        label227:
        localObject = kotlin.ah.aiuX;
        this.Qsr = paramBundle;
        setBackBtn(new WebSearchSnsImageLoadingUI..ExternalSyntheticLambda0(this), a.f.actionbar_icon_dark_back);
        setMMTitle("");
        if (!com.tencent.mm.kernel.h.baz())
        {
          Log.e(this.TAG, "startImageSearch account not ready");
          atR();
          AppMethodBeat.o(315227);
          return;
          i = 83;
          continue;
        }
        if (y.ZC(this.hET))
        {
          showLoading();
          biH(this.hET);
          ((Button)findViewById(a.d.error_btn)).setOnClickListener(new WebSearchSnsImageLoadingUI..ExternalSyntheticLambda1(this));
          AppMethodBeat.o(315227);
          return;
        }
        paramBundle = this.Qsr;
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = Boolean.valueOf(((yp)localObject).publish()))
        {
          if (paramBundle == null) {
            ((WebSearchSnsImageLoadingUI)this).atR();
          }
          AppMethodBeat.o(315227);
          return;
          iqJ().alive();
          showLoading();
          localObject = new yp();
          ((yp)localObject).ibS.ibT = paramBundle;
          ((yp)localObject).ibS.mediaId = paramBundle.Id;
          ((yp)localObject).ibS.hAf = 4;
        }
      }
      catch (Exception localException)
      {
        break label227;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(315245);
    iqJ().dead();
    if (this.Wrp != 0L) {
      ((c)com.tencent.mm.kernel.h.ax(c.class)).tN(this.Wrp);
    }
    super.onDestroy();
    AppMethodBeat.o(315245);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(WebSearchSnsImageLoadingUI paramWebSearchSnsImageLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI
 * JD-Core Version:    0.7.0.1
 */