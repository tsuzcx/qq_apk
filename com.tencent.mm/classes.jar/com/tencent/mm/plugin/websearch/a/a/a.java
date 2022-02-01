package com.tencent.mm.plugin.websearch.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.ui.a.e;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.ui.a.h;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.search.FTSEditTextView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;)V", "TAG", "", "dialogView", "Landroid/view/View;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/EmojiSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "mainTab", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchMainTab;", "moreTab", "Lcom/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchMoreTab;", "moreTabShow", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismiss", "", "initContentView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "query", "onSharedEnd", "onStartSearchShareCgi", "id", "share", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  private final String TAG;
  amr WqC;
  final com.tencent.mm.emojisearch.ui.b WqD;
  private boolean WqE;
  private b WqF;
  private c WqG;
  private View plv;
  w psR;
  
  public a(Context paramContext, amr paramamr, com.tencent.mm.emojisearch.ui.b paramb)
  {
    super(paramContext, a.h.EmojiSearchDialog);
    AppMethodBeat.i(315045);
    this.WqC = paramamr;
    this.WqD = paramb;
    this.TAG = "MicroMsg.WebSearch.EmojiSearchDialog";
    AppMethodBeat.o(315045);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(315075);
    s.u(parama, "this$0");
    paramDialogInterface = parama.WqF;
    if (paramDialogInterface != null)
    {
      Log.i(paramDialogInterface.TAG, "dismiss dialog");
      paramDialogInterface.WqC.hAB = paramDialogInterface.FWg.getInEditTextQuery();
      paramDialogInterface.FWg.dzv.clearFocus();
      paramDialogInterface.FWg.hideVKB();
      paramDialogInterface.WqD.onDismiss();
      paramDialogInterface.WqM.destroy();
      paramDialogInterface.WqN.removeJavascriptInterface("emojiWebSearchJSApi");
      paramDialogInterface.WqN.destroy();
    }
    parama = parama.WqG;
    if (parama != null)
    {
      parama.WqM.destroy();
      parama.WqN.removeJavascriptInterface("emojiWebSearchJSApi");
      parama.WqN.destroy();
    }
    AppMethodBeat.o(315075);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(315058);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315058);
  }
  
  private static final boolean a(a parama, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(315052);
    s.u(parama, "this$0");
    parama.dismiss();
    AppMethodBeat.o(315052);
    return true;
  }
  
  private static final void b(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(315080);
    s.u(parama, "this$0");
    paramDialogInterface = parama.WqF;
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.WqM;
      if (paramDialogInterface != null) {
        paramDialogInterface.iqA();
      }
    }
    parama = parama.WqG;
    if (parama != null)
    {
      parama = parama.WqM;
      if (parama != null) {
        parama.iqA();
      }
    }
    AppMethodBeat.o(315080);
  }
  
  private static final void x(View paramView1, View paramView2)
  {
    AppMethodBeat.i(315068);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$view");
    paramView2 = (FTSEditTextView)paramView1.findViewById(a.d.fts_edittext);
    if (paramView2 != null) {
      paramView2.aWT();
    }
    paramView1 = (FTSEditTextView)paramView1.findViewById(a.d.fts_edittext);
    if (paramView1 != null) {
      paramView1.showVKB();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/emojisearch/ui/EmojiSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315068);
  }
  
  public final void a(final cry paramcry, final String paramString)
  {
    AppMethodBeat.i(315117);
    s.u(paramcry, "shareContent");
    Log.i(this.TAG, "onSearchShare " + paramcry.toJSON() + '}');
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramcry, paramString));
    AppMethodBeat.o(315117);
  }
  
  public final void biF(String paramString)
  {
    AppMethodBeat.i(315115);
    s.u(paramString, "id");
    if (this.psR == null) {
      this.psR = w.a(getContext(), (CharSequence)getContext().getString(a.g.loading_tips), true, 0, new a..ExternalSyntheticLambda0(this));
    }
    paramString = this.psR;
    if ((paramString != null) && (!paramString.isShowing())) {
      paramString.show();
    }
    AppMethodBeat.o(315115);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(315113);
    Util.hideVKB(this.plv);
    super.dismiss();
    AppMethodBeat.o(315113);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(315119);
    if (this.WqE)
    {
      Object localObject = this.plv;
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(a.d.title_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(a.g.emoji_search_title);
        }
      }
      localObject = this.plv;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(a.d.close_btn);
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).rotation(0.0F);
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
      localObject = this.WqG;
      if (localObject != null)
      {
        int i = com.tencent.mm.cd.a.ms(((c)localObject).getActivityContext());
        ((c)localObject).WqO.animate().translationX(i).setDuration(300L).start();
      }
      this.WqE = false;
      AppMethodBeat.o(315119);
      return;
    }
    dismiss();
    AppMethodBeat.o(315119);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(315110);
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
      paramBundle.setWindowAnimations(a.h.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(getContext()).inflate(a.e.emoji_search_dialog, null, false);
    s.s(paramBundle, "from(context).inflate(R.…arch_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle.findViewById(a.d.empty_area_view).setOnTouchListener(new a..ExternalSyntheticLambda4(this));
    paramBundle.findViewById(a.d.close_btn).setOnClickListener(new a..ExternalSyntheticLambda3(this));
    ((ImageView)paramBundle.findViewById(a.d.search_icon)).setOnClickListener(new a..ExternalSyntheticLambda2(paramBundle));
    ((TextView)paramBundle.findViewById(a.d.title_tv)).setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), com.tencent.mm.plugin.websearch.ui.a.b.GroupTitleTextSize) * com.tencent.mm.cd.a.jO(getContext()));
    this.WqF = new b(this, this.WqC, this.WqD, paramBundle);
    setOnDismissListener(new a..ExternalSyntheticLambda1(this));
    setCancelable(true);
    this.plv = paramBundle;
    AppMethodBeat.o(315110);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama, cry paramcry, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, amr paramamr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.a
 * JD-Core Version:    0.7.0.1
 */