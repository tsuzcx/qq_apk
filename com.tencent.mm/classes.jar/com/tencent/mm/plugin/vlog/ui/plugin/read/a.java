package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.vfs.y;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.am.h, d.c, d.d
{
  public static final a Umc;
  private static int Umn;
  long Umd;
  private int Ume;
  com.tencent.mm.plugin.recordvideo.ui.editor.item.j Umf;
  private long Umg;
  private final kotlin.j Umh;
  private final kotlin.j Umi;
  private final kotlin.j Umj;
  private final kotlin.j Umk;
  private final Runnable Uml;
  private final c Umm;
  private boolean loading;
  private final VideoTransPara nLH;
  ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(283015);
    Umc = new a((byte)0);
    AppMethodBeat.o(283015);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282945);
    this.parent = paramViewGroup;
    this.Ume = -1;
    this.Umh = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Umi = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Umj = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.Umk = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Uml = new a..ExternalSyntheticLambda2(this);
    LayoutInflater.from(this.parent.getContext()).inflate(a.g.editor_tts_panel, this.parent, true);
    this.parent.setOnClickListener(new a..ExternalSyntheticLambda1(this));
    ((TextView)this.Umj.getValue()).setOnClickListener(new a..ExternalSyntheticLambda0(this));
    com.tencent.mm.kernel.h.baD().mCm.a(5207, (com.tencent.mm.am.h)this);
    this.Umm = new c();
    this.nLH = e.bIg().bIn();
    AppMethodBeat.o(282945);
  }
  
  private void Xh()
  {
    AppMethodBeat.i(282968);
    hTT().setVisibility(4);
    this.parent.getHandler().removeCallbacks(this.Uml);
    this.parent.setVisibility(8);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NQh);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPQ);
    AppMethodBeat.o(282968);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(282981);
    kotlin.g.b.s.u(parama, "this$0");
    parama.Xh();
    AppMethodBeat.o(282981);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(282990);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    if (!parama.loading) {
      parama.Xh();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282990);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(282996);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.Ume = -1;
    parama.hideLoading();
    parama.parent.setVisibility(8);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NQh);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(parama.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPQ);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282996);
  }
  
  private final ViewGroup hTS()
  {
    AppMethodBeat.i(282950);
    ViewGroup localViewGroup = (ViewGroup)this.Umh.getValue();
    AppMethodBeat.o(282950);
    return localViewGroup;
  }
  
  private final ViewGroup hTT()
  {
    AppMethodBeat.i(282955);
    ViewGroup localViewGroup = (ViewGroup)this.Umk.getValue();
    AppMethodBeat.o(282955);
    return localViewGroup;
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(282965);
    this.loading = false;
    hTS().setVisibility(4);
    AppMethodBeat.o(282965);
  }
  
  private final void nt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282975);
    paramString1 = new b(paramString1, paramString2);
    int i = Umn;
    Umn = i + 1;
    this.Ume = i;
    paramString1.Ume = this.Ume;
    com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)paramString1, 0);
    AppMethodBeat.o(282975);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(282959);
    this.loading = true;
    hTS().setVisibility(0);
    hTT().setVisibility(4);
    this.parent.setVisibility(0);
    AppMethodBeat.o(282959);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(283034);
    kotlin.g.b.s.u(parama, "data");
    String str;
    if ((parama instanceof r))
    {
      str = String.valueOf(((r)parama).bba);
      if (!(parama instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.j)) {
        break label111;
      }
    }
    label111:
    for (parama = (com.tencent.mm.plugin.recordvideo.ui.editor.item.j)parama;; parama = null)
    {
      this.Umf = parama;
      showLoading();
      parama = z.bAW();
      kotlin.g.b.s.s(parama, "getMyFinderUsername()");
      nt(parama, str);
      parama = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.report(110L);
      AppMethodBeat.o(283034);
      return;
      if ((parama instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p))
      {
        str = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.p)parama).text;
        break;
      }
      str = "";
      break;
    }
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(283053);
    if (paramac == null) {}
    for (paramLong = 0L;; paramLong = paramac.Uaw.getDurationMs())
    {
      this.Umd = paramLong;
      AppMethodBeat.o(283053);
      return;
    }
  }
  
  public final void a(d.e parame) {}
  
  public final void dCu()
  {
    AppMethodBeat.i(283038);
    hTS().setVisibility(4);
    hTT().setVisibility(0);
    this.parent.postDelayed(this.Uml, 2000L);
    com.tencent.mm.plugin.vlog.model.report.a locala = com.tencent.mm.plugin.vlog.model.report.a.Uch;
    com.tencent.mm.plugin.vlog.model.report.a.report(112L);
    AppMethodBeat.o(283038);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(283047);
    if (((paramp instanceof b)) && (((b)paramp).Ume == this.Ume))
    {
      hideLoading();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final String str1 = com.tencent.mm.plugin.sight.base.c.gYp() + '/' + UUID.randomUUID();
        final String str2 = kotlin.g.b.s.X(str1, ".tts");
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((b)paramp).Umt).append(", speech size:");
        paramString = ((b)paramp).Umu;
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.length))
        {
          Log.i("MicroMsg.EditorReadPlugin", paramString + ", speech duration:" + ((b)paramp).durationMs + ", path:" + str1);
          paramString = ((b)paramp).Umu;
          y.f(str1, paramString, paramString.length);
          kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new b(this, str2, paramp, str1, null), 2);
          AppMethodBeat.o(283047);
          return;
        }
      }
      Log.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b)paramp).Umt + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      dCu();
    }
    AppMethodBeat.o(283047);
  }
  
  public final void qU(long paramLong)
  {
    this.Umg = paramLong;
  }
  
  public final void release()
  {
    AppMethodBeat.i(283048);
    com.tencent.mm.kernel.h.baD().mCm.b(5207, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(283048);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "REPORT_KEY_MULTI_VIDEO_EDIT_CLICK_READ", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_FAIL", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_SUCCESS", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(a parama, String paramString1, com.tencent.mm.am.p paramp, String paramString2, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(282937);
      paramObject = (kotlin.d.d)new b(this.Umo, str2, paramp, str1, paramd);
      AppMethodBeat.o(282937);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282931);
      Object localObject1 = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282931);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new ah.a();
        localObject2 = (f)bg.kCi();
        localObject3 = (m)new kotlin.d.b.a.k(paramObject, this.Umo)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(282932);
            paramAnonymousObject = (kotlin.d.d)new 1(this.Umr, this.Umo, this.Umq, this.Ump, paramAnonymousd);
            AppMethodBeat.o(282932);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(282928);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(282928);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.Umr;
            a.b(this.Umo);
            paramAnonymousObject.aiwY = c.aC(this.Umq, this.Ump, a.c(this.Umo).audioChannelCount);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(282928);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        if (l.a((f)localObject2, (m)localObject3, locald) == localObject1)
        {
          AppMethodBeat.o(282931);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (ah.a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      if (paramObject.aiwY)
      {
        localObject1 = this.Umo;
        paramObject = str2;
        l = ((b)paramp).durationMs;
        kotlin.g.b.s.u(paramObject, "path");
        localObject2 = ((a)localObject1).Umf;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.item.j)localObject2).bv(paramObject, l);
        }
        paramObject = ((a)localObject1).Umf;
        if ((paramObject instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a))
        {
          paramObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramObject;
          if (paramObject == null) {
            break label370;
          }
        }
      }
      label370:
      for (long l = Math.min(paramObject.NXR.NZL.getTime(), ((a)localObject1).Umd);; l = 0L)
      {
        ((a)localObject1).parent.setVisibility(8);
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(((com.tencent.mm.plugin.recordvideo.plugin.a)localObject1).GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPQ);
        paramObject = ((com.tencent.mm.plugin.recordvideo.plugin.a)localObject1).GrC;
        localObject1 = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NQg;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("PARAM_1_LONG", l);
        localObject3 = ah.aiuX;
        paramObject.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a.c)localObject1, (Bundle)localObject2);
        paramObject = com.tencent.mm.plugin.vlog.model.report.a.Uch;
        com.tencent.mm.plugin.vlog.model.report.a.report(111L);
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(282931);
          return paramObject;
          paramObject = null;
          break;
          Log.e("MicroMsg.EditorReadPlugin", kotlin.g.b.s.X("tts remux error, input text:", ((b)paramp).Umt));
          this.Umo.dCu();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<MMProcessBar>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.a
 * JD-Core Version:    0.7.0.1
 */