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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "downloadImageCallback", "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1;", "imgLocalId", "", "isDownloading", "", "lastRequestSession", "getLastRequestSession", "()J", "setLastRequestSession", "(J)V", "mBackPressCancel", "mSessionId", "mSessionIdString", "mUseCdnOpt", "msgId", "type", "", "cancelDownloadImage", "", "checkCanDownloadImage", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onError", "reportAction", "action", "imagePath", "sessionId", "cgiRet", "timestamp", "showLoading", "startImageSearch", "tryDownloadImage", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSearchImageLoadingUI
  extends MMActivity
{
  private boolean PHg;
  private final String TAG;
  private String Wrl;
  private boolean Wrm;
  private boolean Wrn;
  private final a Wro;
  private long Wrp;
  private long mSessionId;
  private long msgId;
  private long mxN;
  private int type;
  
  public WebSearchImageLoadingUI()
  {
    AppMethodBeat.i(315162);
    this.TAG = "MicroMsg.WebSearch.WebSearchImageLoadingUI";
    this.Wrl = "";
    this.Wrn = true;
    this.Wro = new a(this);
    AppMethodBeat.o(315162);
  }
  
  private final void Ip(boolean paramBoolean)
  {
    AppMethodBeat.i(315170);
    if (this.msgId == 0L)
    {
      atR();
      AppMethodBeat.o(315170);
      return;
    }
    String str = ((c)com.tencent.mm.kernel.h.ax(c.class)).tM(this.msgId);
    if (y.ZC(str))
    {
      showLoading();
      long l = this.msgId;
      int i = this.type;
      s.s(str, "imagePath");
      n(l, i, str);
      ((Button)findViewById(a.d.error_btn)).setOnClickListener(new WebSearchImageLoadingUI..ExternalSyntheticLambda2(this, str));
      AppMethodBeat.o(315170);
      return;
    }
    if (paramBoolean)
    {
      xI(this.msgId);
      AppMethodBeat.o(315170);
      return;
    }
    atR();
    AppMethodBeat.o(315170);
  }
  
  private final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(315184);
    d.B((kotlin.g.a.a)new WebSearchImageLoadingUI.b(paramString1, this, paramInt1, paramString2, paramInt2, paramLong));
    AppMethodBeat.o(315184);
  }
  
  private static final void a(long paramLong, WebSearchImageLoadingUI paramWebSearchImageLoadingUI)
  {
    AppMethodBeat.i(315244);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong);
    if (localObject == null)
    {
      AppMethodBeat.o(315244);
      return;
    }
    boolean bool;
    if (localObject == null) {
      bool = false;
    }
    for (;;)
    {
      Log.i(paramWebSearchImageLoadingUI.TAG, "tryDownloadImage msgId: %s, msgSvrId: %s, talker: %s, canDownload: %b", new Object[] { Long.valueOf(paramLong), Long.valueOf(((fi)localObject).field_msgSvrId), ((fi)localObject).field_talker, Boolean.valueOf(bool) });
      if (!bool) {
        break label241;
      }
      localObject = com.tencent.mm.modelimage.r.bKa().G(((fi)localObject).field_talker, ((fi)localObject).field_msgSvrId);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(315244);
      return;
      if (((fi)localObject).field_isSend == 1)
      {
        if (((cc)localObject).isClean()) {
          bool = false;
        }
      }
      else if (((cc)localObject).isClean())
      {
        bool = false;
        continue;
      }
      bool = true;
    }
    paramWebSearchImageLoadingUI.mxN = ((com.tencent.mm.modelimage.h)localObject).localId;
    if (com.tencent.mm.modelimage.r.bKb().a(paramWebSearchImageLoadingUI.mxN, paramLong, 0, Long.valueOf(paramLong), a.c.chat_img_template, (f.a)paramWebSearchImageLoadingUI.Wro, 0, true) != 0)
    {
      paramWebSearchImageLoadingUI.atR();
      AppMethodBeat.o(315244);
      return;
    }
    paramWebSearchImageLoadingUI.PHg = true;
    com.tencent.threadpool.h.ahAA.bk(new WebSearchImageLoadingUI..ExternalSyntheticLambda6(paramWebSearchImageLoadingUI));
    label241:
    AppMethodBeat.o(315244);
  }
  
  private static final void a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI)
  {
    AppMethodBeat.i(315215);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    ((MMAnimateView)paramWebSearchImageLoadingUI.findViewById(a.d.loading_iv)).setVisibility(8);
    ((TextView)paramWebSearchImageLoadingUI.findViewById(a.d.loading_tv)).setVisibility(8);
    ((TextView)paramWebSearchImageLoadingUI.findViewById(a.d.error_tv)).setVisibility(8);
    ((Button)paramWebSearchImageLoadingUI.findViewById(a.d.error_btn)).setVisibility(8);
    ((TextView)paramWebSearchImageLoadingUI.findViewById(a.d.expire_tv)).setVisibility(0);
    ((Button)paramWebSearchImageLoadingUI.findViewById(a.d.expire_btn)).setVisibility(0);
    ((Button)paramWebSearchImageLoadingUI.findViewById(a.d.expire_btn)).setOnClickListener(new WebSearchImageLoadingUI..ExternalSyntheticLambda1(paramWebSearchImageLoadingUI));
    AppMethodBeat.o(315215);
  }
  
  private static final void a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, View paramView)
  {
    AppMethodBeat.i(315209);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    paramWebSearchImageLoadingUI.finish();
    AppMethodBeat.o(315209);
  }
  
  private static final void a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, String paramString, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf)
  {
    AppMethodBeat.i(315228);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    s.u(paramString, "$imagePath");
    s.u(paramf, "result");
    Log.i(paramWebSearchImageLoadingUI.TAG, "uploadImageForSearch callback %s filePath:%s isSucess:%b, session: %s, %s, mBackPressCancel: %s.", new Object[] { paramf.hAT, paramf.imagePath, Boolean.valueOf(paramf.success), Long.valueOf(paramLong), com.tencent.mm.plugin.fts.a.e.rr(paramLong), Boolean.valueOf(paramWebSearchImageLoadingUI.Wrm) });
    if (paramWebSearchImageLoadingUI.Wrm)
    {
      AppMethodBeat.o(315228);
      return;
    }
    paramWebSearchImageLoadingUI.Wrp = 0L;
    Object localObject1;
    if (paramf.success) {
      if (paramf.jumpType == 3)
      {
        localObject1 = new com.tencent.mm.plugin.websearch.api.ah();
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).context = ((Context)paramWebSearchImageLoadingUI);
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = 67;
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).query = paramf.OMO;
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).sessionId = paramWebSearchImageLoadingUI.Wrl;
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoJ = false;
        ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoH = true;
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((com.tencent.mm.plugin.websearch.api.ah)localObject1);
      }
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.o(new WebSearchImageLoadingUI..ExternalSyntheticLambda5(paramWebSearchImageLoadingUI), 500L);
      paramWebSearchImageLoadingUI.a(5, paramString, paramWebSearchImageLoadingUI.Wrl, paramf.errCode, System.currentTimeMillis());
      AppMethodBeat.o(315228);
      return;
      localObject1 = new com.tencent.mm.plugin.websearch.api.ah();
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).context = ((Context)paramWebSearchImageLoadingUI);
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).scene = 67;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).query = "";
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).sessionId = paramWebSearchImageLoadingUI.Wrl;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoH = true;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoI = true;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoJ = false;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoS = true;
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoL = com.tencent.mm.cd.a.w((Context)paramWebSearchImageLoadingUI, a.a.white);
      ((com.tencent.mm.plugin.websearch.api.ah)localObject1).WoM = true;
      Object localObject2 = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
      s.s(localObject2, "params.extParams");
      ((Map)localObject2).put("chatSearch", "2");
      try
      {
        localObject2 = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
        s.s(localObject2, "params.extParams");
        ((Map)localObject2).put("reqKey", com.tencent.mm.compatible.util.r.as(paramf.hAT, "utf8"));
        label398:
        localObject2 = s.X("weixin://fts/image?path=", y.n(paramf.imagePath, false));
        try
        {
          Map localMap = ((com.tencent.mm.plugin.websearch.api.ah)localObject1).hVt;
          s.s(localMap, "params.extParams");
          localMap.put("cacheImageSrc", com.tencent.mm.compatible.util.r.as((String)localObject2, "utf8"));
          label449:
          ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((com.tencent.mm.plugin.websearch.api.ah)localObject1);
          localObject1 = paramf.imagePath;
          s.s(localObject1, "result.imagePath");
          paramWebSearchImageLoadingUI.a(8, (String)localObject1, paramWebSearchImageLoadingUI.Wrl, 0, System.currentTimeMillis());
          continue;
          d.uiThread((kotlin.g.a.a)new c(paramWebSearchImageLoadingUI));
        }
        catch (Exception localException1)
        {
          break label449;
        }
      }
      catch (Exception localException2)
      {
        break label398;
      }
    }
  }
  
  private static final void a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, String paramString, View paramView)
  {
    AppMethodBeat.i(315206);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWebSearchImageLoadingUI);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWebSearchImageLoadingUI, "this$0");
    ((MMAnimateView)paramWebSearchImageLoadingUI.findViewById(a.d.loading_iv)).setVisibility(0);
    ((TextView)paramWebSearchImageLoadingUI.findViewById(a.d.loading_tv)).setVisibility(0);
    ((TextView)paramWebSearchImageLoadingUI.findViewById(a.d.error_tv)).setVisibility(8);
    ((Button)paramWebSearchImageLoadingUI.findViewById(a.d.error_btn)).setVisibility(8);
    long l = paramWebSearchImageLoadingUI.msgId;
    int i = paramWebSearchImageLoadingUI.type;
    s.s(paramString, "imagePath");
    paramWebSearchImageLoadingUI.n(l, i, paramString);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315206);
  }
  
  private static final boolean a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(315199);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    paramWebSearchImageLoadingUI.iqI();
    paramWebSearchImageLoadingUI.finish();
    paramWebSearchImageLoadingUI.a(11, "", paramWebSearchImageLoadingUI.Wrl, 0, System.currentTimeMillis());
    AppMethodBeat.o(315199);
    return false;
  }
  
  private final void atR()
  {
    AppMethodBeat.i(315177);
    com.tencent.threadpool.h.ahAA.bk(new WebSearchImageLoadingUI..ExternalSyntheticLambda7(this));
    AppMethodBeat.o(315177);
  }
  
  private static final void b(WebSearchImageLoadingUI paramWebSearchImageLoadingUI)
  {
    AppMethodBeat.i(315222);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    paramWebSearchImageLoadingUI.finish();
    AppMethodBeat.o(315222);
  }
  
  private static final void c(WebSearchImageLoadingUI paramWebSearchImageLoadingUI)
  {
    AppMethodBeat.i(315236);
    s.u(paramWebSearchImageLoadingUI, "this$0");
    paramWebSearchImageLoadingUI.showLoading();
    AppMethodBeat.o(315236);
  }
  
  private final void iqI()
  {
    AppMethodBeat.i(315193);
    Log.i(this.TAG, "cancelDownloadImage isDownloading: %b, imgLocalId: %d, msgId: %d", new Object[] { Boolean.valueOf(this.PHg), Long.valueOf(this.mxN), Long.valueOf(this.msgId) });
    if ((this.PHg) || (this.mxN != 0L)) {
      com.tencent.mm.modelimage.r.bKb().a(this.mxN, this.msgId, 0, (f.a)this.Wro);
    }
    AppMethodBeat.o(315193);
  }
  
  private final void n(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(315182);
    com.tencent.mm.plugin.scanner.api.e locale = new com.tencent.mm.plugin.scanner.api.e();
    locale.msgId = paramLong;
    locale.sessionId = this.mSessionId;
    locale.type = paramInt;
    locale.mode = 4;
    locale.OMH = new nz();
    locale.OMH.YQo = aj.asY(0);
    locale.OML = this.Wrn;
    dhb localdhb = aj.dch();
    if (localdhb != null)
    {
      locale.OMI = new nq();
      locale.OMI.longitude = localdhb.ZaG;
      locale.OMI.latitude = localdhb.ZaH;
      locale.OMI.YPF = localdhb.Zyl;
    }
    a(2, paramString, this.Wrl, 0, System.currentTimeMillis());
    this.Wrp = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(locale, new WebSearchImageLoadingUI..ExternalSyntheticLambda3(this, paramString));
    if (this.Wrp != 0L) {
      a(4, paramString, this.Wrl, 0, System.currentTimeMillis());
    }
    AppMethodBeat.o(315182);
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(315172);
    if (aw.isDarkMode())
    {
      ((MMAnimateView)findViewById(a.d.loading_iv)).setImageResource(a.f.websearch_dark_loading);
      AppMethodBeat.o(315172);
      return;
    }
    ((MMAnimateView)findViewById(a.d.loading_iv)).setImageResource(a.f.websearch_light_loading);
    AppMethodBeat.o(315172);
  }
  
  private final void xI(long paramLong)
  {
    AppMethodBeat.i(315187);
    com.tencent.threadpool.h.ahAA.bo(new WebSearchImageLoadingUI..ExternalSyntheticLambda4(paramLong, this));
    AppMethodBeat.o(315187);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.websearch_image_loading_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(315318);
    super.onBackPressed();
    iqI();
    a(11, "", this.Wrl, 0, System.currentTimeMillis());
    Log.d(this.TAG, "onBackPressed = %s", new Object[] { Boolean.valueOf(this.Wrm) });
    this.Wrm = true;
    AppMethodBeat.o(315318);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(315308);
    super.onCreate(paramBundle);
    setBackBtn(new WebSearchImageLoadingUI..ExternalSyntheticLambda0(this), a.f.actionbar_icon_dark_back);
    setMMTitle("");
    this.msgId = getIntent().getLongExtra("key_msg_id", 0L);
    this.mSessionId = getIntent().getLongExtra("key_session_id", 0L);
    this.type = getIntent().getIntExtra("key_scan_goods_request_type", 0);
    this.Wrn = getIntent().getBooleanExtra("key_upload_image_use_cdn_opt", true);
    paramBundle = com.tencent.mm.plugin.fts.a.e.rr(this.mSessionId);
    s.s(paramBundle, "getUnsignedLong(mSessionId)");
    this.Wrl = paramBundle;
    Ip(true);
    AppMethodBeat.o(315308);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(315312);
    if (this.Wrp != 0L) {
      ((c)com.tencent.mm.kernel.h.ax(c.class)).tN(this.Wrp);
    }
    super.onDestroy();
    AppMethodBeat.o(315312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/modelimage/DownloadImgService$IOnImgTaskListener;", "onImgTaskCanceled", "", "imgLocalId", "", "msgLocalId", "compressType", "", "resId", "data", "", "onImgTaskEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onImgTaskProgress", "offset", "totalLen", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.a
  {
    a(WebSearchImageLoadingUI paramWebSearchImageLoadingUI) {}
    
    public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(315183);
      Log.i(WebSearchImageLoadingUI.d(this.Wrq), "onImgTaskCanceled msgId: %d, imgLocalId: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      WebSearchImageLoadingUI.e(this.Wrq);
      AppMethodBeat.o(315183);
    }
    
    public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp)
    {
      AppMethodBeat.i(315179);
      Log.d(WebSearchImageLoadingUI.d(this.Wrq), "onImgTaskProgress msgId: %d, imgLocalId: %d, compressType: %d, offset: %d, totalLen: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(315179);
    }
    
    public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp)
    {
      AppMethodBeat.i(315173);
      Log.i(WebSearchImageLoadingUI.d(this.Wrq), "onImgTaskEnd msgId: %d, imgLocalId: %d, compressType: %d, errType %d, errCode: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      WebSearchImageLoadingUI.e(this.Wrq);
      WebSearchImageLoadingUI.f(this.Wrq);
      AppMethodBeat.o(315173);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(WebSearchImageLoadingUI paramWebSearchImageLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI
 * JD-Core Version:    0.7.0.1
 */