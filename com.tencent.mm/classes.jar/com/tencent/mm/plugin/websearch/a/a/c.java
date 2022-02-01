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
import com.tencent.mm.f.b.a.oe;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.ui.a.c;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.ui.a.f;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;)V", "TAG", "", "dialogView", "Landroid/view/View;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "moreTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "moreTabShow", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "initContentView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSharedEnd", "onStartSearchShareCgi", "id", "share", "startMoreTab", "moreContext", "ui-websearch_release"})
public final class c
  extends androidx.appcompat.app.e
{
  private boolean PAu;
  private d PAv;
  private e PAw;
  eql PAx;
  final a PAy;
  private final String TAG;
  private s iYE;
  private View mrQ;
  
  public c(Context paramContext, eql parameql, a parama)
  {
    super(paramContext, a.g.TagSearchDialog);
    AppMethodBeat.i(198916);
    this.PAx = parameql;
    this.PAy = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchDialog";
    AppMethodBeat.o(198916);
  }
  
  public final void a(ccn paramccn, Bitmap paramBitmap, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(198909);
    p.k(paramccn, "shareContent");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSearchShare BusinessType:").append(paramccn.Tkz.CQK).append(" SubType:").append(paramccn.Tkz.TVM).append(' ').append("BrandFeed:");
    if (paramccn.TkA != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappFeed:");
      if (paramccn.TkC == null) {
        break label275;
      }
      bool1 = true;
      label100:
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappProfile:");
      if (paramccn.TkD == null) {
        break label281;
      }
      bool1 = true;
      label124:
      localStringBuilder = localStringBuilder.append(bool1).append(' ').append("BrandProfile:");
      if (paramccn.TkB == null) {
        break label287;
      }
      bool1 = true;
      label153:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderFeed:");
      if (paramccn.TkF == null) {
        break label293;
      }
      bool1 = true;
      label177:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderProfile:");
      if (paramccn.TkE == null) {
        break label299;
      }
      bool1 = true;
      label201:
      localStringBuilder = localStringBuilder.append(bool1).append(' ').append("Emoticon:");
      if (paramccn.TkG == null) {
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
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c.d(this, paramccn, paramBitmap, paramString));
      AppMethodBeat.o(198909);
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
  
  public final void a(ccn paramccn, String paramString)
  {
    long l = 2L;
    AppMethodBeat.i(198910);
    p.k(paramccn, "shareContent");
    Object localObject = this.iYE;
    if (localObject != null) {
      ((s)localObject).dismiss();
    }
    this.PAy.a(paramccn);
    dismiss();
    oe localoe = new oe();
    localoe.AC(cm.bfF());
    localoe.AB(2L);
    localoe.aod();
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localoe.EV((String)localObject);
    if (ab.Lj(this.PAx.talker)) {}
    for (;;)
    {
      localoe.AD(l);
      localoe.EW(this.PAx.talker);
      localObject = paramccn.Tkz.SessionId;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localoe.EX(paramString);
      localObject = paramccn.Tkz.Tky;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localoe.EY(paramString);
      localObject = paramccn.Tkz.Tkx;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localoe.EZ(paramString);
      localObject = paramccn.Tkz.Uhd;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localoe.Fa(paramString);
      localoe.AF(paramccn.Tkz.TVM);
      localoe.AE(paramccn.Tkz.CQK);
      localoe.bpa();
      ar.a((com.tencent.mm.plugin.report.a)localoe);
      AppMethodBeat.o(198910);
      return;
      l = 1L;
    }
  }
  
  public final void biY(String paramString)
  {
    AppMethodBeat.i(198904);
    p.k(paramString, "id");
    if (this.iYE == null) {
      this.iYE = s.a(getContext(), (CharSequence)getContext().getString(a.f.loading_tips), true, 0, (DialogInterface.OnCancelListener)new e(this));
    }
    paramString = this.iYE;
    if (paramString != null)
    {
      if (!paramString.isShowing()) {
        paramString.show();
      }
      AppMethodBeat.o(198904);
      return;
    }
    AppMethodBeat.o(198904);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198915);
    if (this.PAu)
    {
      Object localObject = this.mrQ;
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(a.c.title_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(a.f.tag_search_title);
        }
      }
      localObject = this.mrQ;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(a.c.close_btn);
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
      localObject = this.PAw;
      if (localObject != null)
      {
        int i = com.tencent.mm.ci.a.kr(((e)localObject).getActivityContext());
        ((e)localObject).PAM.animate().translationX(i).setDuration(300L).start();
      }
      this.PAu = false;
      AppMethodBeat.o(198915);
      return;
    }
    dismiss();
    AppMethodBeat.o(198915);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198900);
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
      paramBundle.setWindowAnimations(a.g.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(getContext()).inflate(a.d.tag_search_dialog, null, false);
    p.j(paramBundle, "LayoutInflater.from(cont…arch_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle.findViewById(a.c.empty_area_view).setOnTouchListener((View.OnTouchListener)new c.a(this));
    paramBundle.findViewById(a.c.close_btn).setOnClickListener((View.OnClickListener)new c.b(this));
    this.PAv = new d(this, this.PAx, this.PAy, paramBundle);
    setOnDismissListener((DialogInterface.OnDismissListener)new c(this));
    setCancelable(true);
    this.mrQ = paramBundle;
    AppMethodBeat.o(198900);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class c
    implements DialogInterface.OnDismissListener
  {
    c(c paramc) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(198320);
      paramDialogInterface = c.a(this.PAz);
      if (paramDialogInterface != null)
      {
        Log.i(paramDialogInterface.TAG, "dismiss dialog");
        paramDialogInterface.PAx.fwe = paramDialogInterface.PAG.getInEditTextQuery();
        paramDialogInterface.PAy.onDismiss();
        paramDialogInterface.PAI.destroy();
        paramDialogInterface.PAJ.removeJavascriptInterface("tagWebSearchJSApi");
        paramDialogInterface.PAJ.destroy();
      }
      paramDialogInterface = c.b(this.PAz);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.PAI.destroy();
        paramDialogInterface.PAJ.removeJavascriptInterface("tagWebSearchJSApi");
        paramDialogInterface.PAJ.destroy();
        AppMethodBeat.o(198320);
        return;
      }
      AppMethodBeat.o(198320);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(c paramc) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(198505);
      paramDialogInterface = c.a(this.PAz);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.PAI;
        if (paramDialogInterface != null) {
          paramDialogInterface.gRq();
        }
      }
      paramDialogInterface = c.b(this.PAz);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.PAI;
        if (paramDialogInterface != null)
        {
          paramDialogInterface.gRq();
          AppMethodBeat.o(198505);
          return;
        }
      }
      AppMethodBeat.o(198505);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc, eql parameql)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.c
 * JD-Core Version:    0.7.0.1
 */