package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.av.r.a;
import com.tencent.mm.g.b.a.li;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;)V", "TAG", "", "dialogView", "Landroid/view/View;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "moreTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "moreTabShow", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "initContentView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSharedEnd", "onStartSearchShareCgi", "id", "share", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class c
  extends android.support.v7.app.e
{
  private boolean IGd;
  private d IGe;
  private e IGf;
  egj IGg;
  final a IGh;
  private final String TAG;
  private com.tencent.mm.ui.base.q gut;
  private View jBV;
  
  public c(Context paramContext, egj paramegj, a parama)
  {
    super(paramContext, 2131821351);
    AppMethodBeat.i(197968);
    this.IGg = paramegj;
    this.IGh = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchDialog";
    AppMethodBeat.o(197968);
  }
  
  public final void a(final buv parambuv, final Bitmap paramBitmap, final String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(197965);
    p.h(parambuv, "shareContent");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSearchShare BusinessType:").append(parambuv.Mbc.xMB).append(" SubType:").append(parambuv.Mbc.MJT).append(' ').append("BrandFeed:");
    if (parambuv.Mbd != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappFeed:");
      if (parambuv.Mbf == null) {
        break label275;
      }
      bool1 = true;
      label100:
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappProfile:");
      if (parambuv.Mbg == null) {
        break label281;
      }
      bool1 = true;
      label124:
      localStringBuilder = localStringBuilder.append(bool1).append(' ').append("BrandProfile:");
      if (parambuv.Mbe == null) {
        break label287;
      }
      bool1 = true;
      label153:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderFeed:");
      if (parambuv.Mbi == null) {
        break label293;
      }
      bool1 = true;
      label177:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderProfile:");
      if (parambuv.Mbh == null) {
        break label299;
      }
      bool1 = true;
      label201:
      localStringBuilder = localStringBuilder.append(bool1).append(' ').append("Emoticon:");
      if (parambuv.Mbj == null) {
        break label305;
      }
    }
    label275:
    label281:
    label287:
    label293:
    label299:
    label305:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i(str, bool1);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, parambuv, paramBitmap, paramString));
      AppMethodBeat.o(197965);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label100;
      bool1 = false;
      break label124;
      bool1 = false;
      break label153;
      bool1 = false;
      break label177;
      bool1 = false;
      break label201;
    }
  }
  
  public final void a(buv parambuv, String paramString)
  {
    long l = 2L;
    AppMethodBeat.i(197966);
    p.h(parambuv, "shareContent");
    Object localObject = this.gut;
    if (localObject != null) {
      ((com.tencent.mm.ui.base.q)localObject).dismiss();
    }
    this.IGh.a(parambuv);
    dismiss();
    li localli = new li();
    localli.uN(cl.aWB());
    localli.uM(2L);
    localli.aiA();
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localli.yx((String)localObject);
    if (ab.Eq(this.IGg.talker)) {}
    for (;;)
    {
      localli.uO(l);
      localli.yy(this.IGg.talker);
      localObject = parambuv.Mbc.SessionId;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localli.yz(paramString);
      localObject = parambuv.Mbc.Mbb;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localli.yA(paramString);
      localObject = parambuv.Mbc.Mba;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localli.yB(paramString);
      localObject = parambuv.Mbc.MUT;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localli.yC(paramString);
      localli.uQ(parambuv.Mbc.MJT);
      localli.uP(parambuv.Mbc.xMB);
      localli.bfK();
      ar.a((com.tencent.mm.plugin.report.a)localli);
      AppMethodBeat.o(197966);
      return;
      l = 1L;
    }
  }
  
  public final void aXn(String paramString)
  {
    AppMethodBeat.i(197964);
    p.h(paramString, "id");
    if (this.gut == null) {
      this.gut = com.tencent.mm.ui.base.q.a(getContext(), (CharSequence)getContext().getString(2131762446), true, 0, (DialogInterface.OnCancelListener)new e(this));
    }
    paramString = this.gut;
    if (paramString != null)
    {
      if (!paramString.isShowing()) {
        paramString.show();
      }
      AppMethodBeat.o(197964);
      return;
    }
    AppMethodBeat.o(197964);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(197967);
    if (this.IGd)
    {
      Object localObject = this.jBV;
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131309249);
        if (localObject != null) {
          ((TextView)localObject).setText(2131766605);
        }
      }
      localObject = this.jBV;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131298770);
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).rotation(90.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
      localObject = this.IGf;
      if (localObject != null)
      {
        int i = com.tencent.mm.cb.a.jn(((e)localObject).getActivityContext());
        ((e)localObject).IGv.animate().translationX(i).setDuration(300L).start();
      }
      this.IGd = false;
      AppMethodBeat.o(197967);
      return;
    }
    dismiss();
    AppMethodBeat.o(197967);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197963);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -1);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(2131820793);
    }
    paramBundle = LayoutInflater.from(getContext()).inflate(2131496644, null, false);
    p.g(paramBundle, "LayoutInflater.from(cont…arch_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle.findViewById(2131300079).setOnTouchListener((View.OnTouchListener)new c.a(this));
    paramBundle.findViewById(2131298770).setOnClickListener((View.OnClickListener)new c.b(this));
    this.IGe = new d(this, this.IGg, this.IGh, paramBundle);
    setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
    setCancelable(true);
    this.jBV = paramBundle;
    AppMethodBeat.o(197963);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(197958);
      paramDialogInterface = c.a(this.IGi);
      if (paramDialogInterface != null)
      {
        Log.i(paramDialogInterface.TAG, "dismiss dialog");
        paramDialogInterface.IGg.dDv = paramDialogInterface.IGp.getInEditTextQuery();
        paramDialogInterface.IGh.onDismiss();
        paramDialogInterface.IGr.destroy();
        paramDialogInterface.IGs.removeJavascriptInterface("tagWebSearchJSApi");
        paramDialogInterface.IGs.destroy();
      }
      paramDialogInterface = c.b(this.IGi);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.IGr.destroy();
        paramDialogInterface.IGs.removeJavascriptInterface("tagWebSearchJSApi");
        paramDialogInterface.IGs.destroy();
        AppMethodBeat.o(197958);
        return;
      }
      AppMethodBeat.o(197958);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(c paramc, buv parambuv, Bitmap paramBitmap, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(c paramc) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(197960);
      paramDialogInterface = c.a(this.IGi);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.IGr;
        if (paramDialogInterface != null) {
          paramDialogInterface.fYF();
        }
      }
      paramDialogInterface = c.b(this.IGi);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.IGr;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.fYF();
          AppMethodBeat.o(197960);
          return;
        }
      }
      AppMethodBeat.o(197960);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class f
    implements r.a
  {
    f(c paramc, k.b paramb, dsu paramdsu, buv parambuv, String paramString) {}
    
    public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(197961);
      paramString1 = BitmapUtil.Bitmap2Bytes(paramBitmap);
      w.a.aSz().a(this.IGl, this.IGm.hik, "", this.IGi.IGg.talker, "", paramString1);
      this.IGi.a(this.IGj, this.IFW);
      AppMethodBeat.o(197961);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(c paramc, egj paramegj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.c
 * JD-Core Version:    0.7.0.1
 */