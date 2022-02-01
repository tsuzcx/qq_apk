package com.tencent.mm.plugin.voip.floatcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager;", "Lcom/tencent/mm/plugin/voip/floatcard/VoipBaseFloatCardManager;", "()V", "isVideoCall", "", "()Z", "setVideoCall", "(Z)V", "uiListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;", "getUiListener", "()Ljava/lang/ref/WeakReference;", "setUiListener", "(Ljava/lang/ref/WeakReference;)V", "videoView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "dismissCard", "", "quickHide", "releaseViewAndIntent", "getAccButtonDrawable", "", "getNotificationText", "hideCard", "initView", "intent", "Landroid/content/Intent;", "toUser", "", "isMultitalk", "onAccept", "onFling", "onFullscreen", "onReject", "showCard", "context", "Landroid/content/Context;", "roomKey", "", "quickShow", "switchToVoice", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private VoIPRenderTextureView UvF;
  public WeakReference<c> UvG;
  public boolean UvH;
  
  public b()
  {
    AppMethodBeat.i(292259);
    this.UvG = new WeakReference(null);
    AppMethodBeat.o(292259);
  }
  
  private static final void a(View paramView, Intent paramIntent, b paramb)
  {
    AppMethodBeat.i(292267);
    s.u(paramView, "$this_apply");
    s.u(paramIntent, "$intent");
    s.u(paramb, "this$0");
    Context localContext = paramView.getContext();
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, paramIntent.aYi(), "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager", "onAccept$lambda-4$lambda-3", "(Landroid/view/View;Landroid/content/Intent;Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager", "onAccept$lambda-4$lambda-3", "(Landroid/view/View;Landroid/content/Intent;Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramb.kw(paramView);
    AppMethodBeat.o(292267);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(292274);
    s.u(paramb, "this$0");
    paramb = (c)paramb.UvG.get();
    if (paramb != null) {
      paramb.Gn(true);
    }
    AppMethodBeat.o(292274);
  }
  
  private static final void a(VoIPRenderTextureView paramVoIPRenderTextureView, View paramView)
  {
    AppMethodBeat.i(292279);
    s.u(paramView, "$this_apply");
    ViewGroup.LayoutParams localLayoutParams = paramVoIPRenderTextureView.getLayoutParams();
    localLayoutParams.width = paramView.getWidth();
    localLayoutParams.height = paramView.getHeight();
    paramView = ah.aiuX;
    paramVoIPRenderTextureView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(292279);
  }
  
  private static final void b(View paramView, Intent paramIntent, b paramb)
  {
    AppMethodBeat.i(292271);
    s.u(paramIntent, "$intent");
    s.u(paramb, "this$0");
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      if (localContext != null)
      {
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, paramIntent.aYi(), "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager", "onFullscreen$lambda-5", "(Landroid/view/View;Landroid/content/Intent;Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager", "onFullscreen$lambda-5", "(Landroid/view/View;Landroid/content/Intent;Lcom/tencent/mm/plugin/voip/floatcard/VoipFloatCardManager;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      paramb.kw(paramView);
    }
    AppMethodBeat.o(292271);
  }
  
  public final void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292362);
    VoIPRenderTextureView localVoIPRenderTextureView = this.UvF;
    if (localVoIPRenderTextureView != null) {
      localVoIPRenderTextureView.release();
    }
    super.aB(paramBoolean1, paramBoolean2);
    this.UvF = null;
    ((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).markExitBusiness(".ui.voip.VoipFloatView");
    AppMethodBeat.o(292362);
  }
  
  protected final void bf(Intent paramIntent)
  {
    AppMethodBeat.i(292329);
    s.u(paramIntent, "intent");
    aB(false, false);
    View localView = this.RWj;
    if (localView != null) {
      com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda1(localView, paramIntent, this), 200L);
    }
    if (this.UvH)
    {
      paramIntent = (c)this.UvG.get();
      if (paramIntent != null) {
        paramIntent.hVK();
      }
      paramIntent = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.z(hVw(), 4, 2);
      AppMethodBeat.o(292329);
      return;
    }
    paramIntent = (c)this.UvG.get();
    if (paramIntent != null) {
      paramIntent.hVM();
    }
    paramIntent = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.z(hVw(), 4, 1);
    AppMethodBeat.o(292329);
  }
  
  protected final void bg(Intent paramIntent)
  {
    AppMethodBeat.i(292333);
    s.u(paramIntent, "intent");
    aB(false, false);
    View localView = this.RWj;
    com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda0(localView, paramIntent, this), 200L);
    if (this.UvH)
    {
      paramIntent = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.z(hVw(), 1, 2);
      AppMethodBeat.o(292333);
      return;
    }
    paramIntent = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.z(hVw(), 1, 1);
    AppMethodBeat.o(292333);
  }
  
  protected final void fvW()
  {
    AppMethodBeat.i(292320);
    if (this.UvH)
    {
      localObject = (c)this.UvG.get();
      if (localObject != null) {
        ((c)localObject).hVJ();
      }
      localObject = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.z(hVw(), 3, 2);
      AppMethodBeat.o(292320);
      return;
    }
    Object localObject = (c)this.UvG.get();
    if (localObject != null) {
      ((c)localObject).hVL();
    }
    localObject = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.z(hVw(), 3, 1);
    AppMethodBeat.o(292320);
  }
  
  protected final void g(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(292357);
    s.u(paramIntent, "intent");
    s.u(paramString, "toUser");
    super.g(paramIntent, paramString);
    paramIntent = this.RWj;
    if ((paramIntent != null) && (this.UvH))
    {
      paramString = (VoIPRenderTextureView)paramIntent.findViewById(b.d.notification_video_bg);
      paramString.setVisibility(0);
      c localc = (c)this.UvG.get();
      if (localc != null) {
        localc.a(paramString, 0);
      }
      paramString.idA();
      this.UvF = paramString;
      paramIntent.post(new b..ExternalSyntheticLambda3(paramString, paramIntent));
    }
    AppMethodBeat.o(292357);
  }
  
  protected final void gha()
  {
    AppMethodBeat.i(292337);
    com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda2(this), 200L);
    if (this.UvH)
    {
      locald = com.tencent.mm.plugin.voip.d.d.UGN;
      com.tencent.mm.plugin.voip.d.d.z(hVw(), 2, 2);
      AppMethodBeat.o(292337);
      return;
    }
    com.tencent.mm.plugin.voip.d.d locald = com.tencent.mm.plugin.voip.d.d.UGN;
    com.tencent.mm.plugin.voip.d.d.z(hVw(), 2, 1);
    AppMethodBeat.o(292337);
  }
  
  protected final void ghb()
  {
    AppMethodBeat.i(292341);
    Object localObject = this.UvF;
    if (localObject != null) {
      ((VoIPRenderTextureView)localObject).release();
    }
    super.ghb();
    localObject = (c)this.UvG.get();
    if (localObject != null) {
      ((c)localObject).Gn(false);
    }
    AppMethodBeat.o(292341);
  }
  
  protected final int ghc()
  {
    if (this.UvH) {
      return b.g.voip_invited_video_tip;
    }
    return b.g.voip_invited_audio_tip;
  }
  
  protected final int ghd()
  {
    if (this.UvH) {
      return b.c.accept_button_video_selector;
    }
    return b.c.accept_button_selector;
  }
  
  public final boolean hVA()
  {
    AppMethodBeat.i(292325);
    this.UvH = false;
    Object localObject = this.UvF;
    if (localObject != null) {
      ((VoIPRenderTextureView)localObject).release();
    }
    localObject = this.UvF;
    if (localObject != null) {
      ((VoIPRenderTextureView)localObject).setVisibility(8);
    }
    localObject = this.RWj;
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(b.d.notification_tip);
      int i = ghc();
      localTextView.setText(i);
      if (hVx() == null) {
        a(new a.b());
      }
      a.b localb = hVx();
      if (localb != null) {
        localb.hVz();
      }
      localb = hVx();
      if (localb != null)
      {
        s.s(localTextView, "it");
        String str = ((View)localObject).getResources().getString(i);
        s.s(str, "resources.getString(text)");
        localb.h(localTextView, str);
      }
      localObject = ((View)localObject).findViewById(b.d.notification_accept_call);
      ((View)localObject).setBackground(((View)localObject).getResources().getDrawable(ghd()));
    }
    AppMethodBeat.o(292325);
    return true;
  }
  
  public final void k(WeakReference<c> paramWeakReference)
  {
    AppMethodBeat.i(292316);
    s.u(paramWeakReference, "<set-?>");
    this.UvG = paramWeakReference;
    AppMethodBeat.o(292316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.floatcard.b
 * JD-Core Version:    0.7.0.1
 */