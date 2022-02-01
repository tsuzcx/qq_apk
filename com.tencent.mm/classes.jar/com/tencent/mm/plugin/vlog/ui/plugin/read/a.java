package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e.c;
import com.tencent.mm.plugin.vlog.ui.plugin.e.d;
import com.tencent.mm.plugin.vlog.ui.plugin.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.n;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"})
public final class a
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.recordvideo.plugin.t, e.c, e.d
{
  public static final a GLP;
  private static int wJJ;
  long CbW;
  private long CbX;
  com.tencent.mm.plugin.recordvideo.ui.editor.item.i GLJ;
  private final kotlin.f GLK;
  private final kotlin.f GLL;
  private final kotlin.f GLM;
  private final kotlin.f GLN;
  private final Runnable GLO;
  private boolean aWP;
  private final VideoTransPara irT;
  ViewGroup parent;
  int wJG;
  private final d wJI;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  
  static
  {
    AppMethodBeat.i(191804);
    GLP = new a((byte)0);
    AppMethodBeat.o(191804);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191803);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.wJG = -1;
    this.GLK = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.GLL = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.GLM = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.GLN = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.GLO = ((Runnable)new b(this));
    LayoutInflater.from(this.parent.getContext()).inflate(2131493897, this.parent, true);
    this.parent.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191779);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!a.c(this.GLQ)) {
          this.GLQ.cO();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191779);
      }
    });
    ((TextView)this.GLM.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191780);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.GLQ;
        paramAnonymousView.wJG = -1;
        paramAnonymousView.hideLoading();
        paramAnonymousView.parent.setVisibility(8);
        d.b.a(paramAnonymousView.wgr, d.c.BWP);
        d.b.a(paramAnonymousView.wgr, d.c.BWv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191780);
      }
    });
    paramViewGroup = com.tencent.mm.kernel.g.aAg();
    p.g(paramViewGroup, "MMKernel.network()");
    paramViewGroup.azz().a(5207, (com.tencent.mm.ak.i)this);
    this.wJI = new d();
    paramViewGroup = e.baZ();
    p.g(paramViewGroup, "SubCoreVideoControl.getCore()");
    this.irT = paramViewGroup.bbf();
    AppMethodBeat.o(191803);
  }
  
  private final ViewGroup fEe()
  {
    AppMethodBeat.i(191792);
    ViewGroup localViewGroup = (ViewGroup)this.GLK.getValue();
    AppMethodBeat.o(191792);
    return localViewGroup;
  }
  
  private final ViewGroup fEf()
  {
    AppMethodBeat.i(191793);
    ViewGroup localViewGroup = (ViewGroup)this.GLN.getValue();
    AppMethodBeat.o(191793);
    return localViewGroup;
  }
  
  private final void ll(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191799);
    paramString1 = new b(paramString1, paramString2);
    int i = wJJ;
    wJJ = i + 1;
    this.wJG = i;
    paramString1.wJG = this.wJG;
    paramString2 = com.tencent.mm.kernel.g.aAg();
    p.g(paramString2, "MMKernel.network()");
    paramString2.azz().b((com.tencent.mm.ak.q)paramString1);
    AppMethodBeat.o(191799);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(191795);
    this.aWP = true;
    ViewGroup localViewGroup = fEe();
    p.g(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(0);
    localViewGroup = fEf();
    p.g(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.parent.setVisibility(0);
    AppMethodBeat.o(191795);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(191794);
    p.h(parama, "data");
    String str;
    if ((parama instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.q))
    {
      str = String.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.q)parama).text);
      if ((parama instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.i)) {
        break label111;
      }
      parama = null;
    }
    label111:
    for (;;)
    {
      this.GLJ = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.i)parama);
      showLoading();
      parama = z.aUg();
      p.g(parama, "ConfigStorageLogic.getMyFinderUsername()");
      ll(parama, str);
      parama = com.tencent.mm.plugin.vlog.model.report.a.GBa;
      com.tencent.mm.plugin.vlog.model.report.a.report(110L);
      AppMethodBeat.o(191794);
      return;
      if ((parama instanceof o))
      {
        str = ((o)parama).text;
        break;
      }
      str = "";
      break;
    }
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(191802);
    if (paramac != null) {}
    for (paramLong = paramac.Gez.getDurationMs();; paramLong = 0L)
    {
      this.CbW = paramLong;
      AppMethodBeat.o(191802);
      return;
    }
  }
  
  public final void a(e.e parame) {}
  
  public final void aSs() {}
  
  public final void cIh()
  {
    AppMethodBeat.i(191797);
    Object localObject = fEe();
    p.g(localObject, "ttsLoadingContainer");
    ((ViewGroup)localObject).setVisibility(4);
    localObject = fEf();
    p.g(localObject, "ttsFailedContainer");
    ((ViewGroup)localObject).setVisibility(0);
    this.parent.postDelayed(this.GLO, 2000L);
    localObject = com.tencent.mm.plugin.vlog.model.report.a.GBa;
    com.tencent.mm.plugin.vlog.model.report.a.report(112L);
    AppMethodBeat.o(191797);
  }
  
  public final void cO()
  {
    AppMethodBeat.i(191798);
    ViewGroup localViewGroup = fEf();
    p.g(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.parent.getHandler().removeCallbacks(this.GLO);
    this.parent.setVisibility(8);
    d.b.a(this.wgr, d.c.BWP);
    d.b.a(this.wgr, d.c.BWv);
    AppMethodBeat.o(191798);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(191796);
    this.aWP = false;
    ViewGroup localViewGroup = fEe();
    p.g(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(191796);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onProgress(long paramLong)
  {
    this.CbX = paramLong;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191805);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191805);
  }
  
  public final void onResume() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(191800);
    if (((paramq instanceof b)) && (((b)paramq).wJG == this.wJG))
    {
      hideLoading();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final String str1 = com.tencent.mm.plugin.sight.base.b.eVt() + '/' + UUID.randomUUID();
        final String str2 = str1 + ".wav";
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((b)paramq).GLT).append(", speech size:");
        paramString = ((b)paramq).GLS;
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.length);; paramString = null)
        {
          Log.i("MicroMsg.EditorReadPlugin", paramString + ", speech duration:" + ((b)paramq).durationMs + ", path:" + str1);
          s.C(str1, ((b)paramq).GLS);
          kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMV(), (m)new c(this, str1, str2, paramq, null), 2);
          AppMethodBeat.o(191800);
          return;
        }
      }
      Log.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b)paramq).GLT + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      cIh();
    }
    AppMethodBeat.o(191800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191801);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(5207, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(191801);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "REPORT_KEY_MULTI_VIDEO_EDIT_CLICK_READ", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_FAIL", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_SUCCESS", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(191781);
      this.GLQ.cO();
      AppMethodBeat.o(191781);
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.read.EditReadPlugin$onSceneEnd$1", f="EditReadPlugin.kt", hxM={174}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    
    c(a parama, String paramString1, String paramString2, com.tencent.mm.ak.q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(191786);
      p.h(paramd, "completion");
      paramd = new c(this.GLQ, str1, str2, paramq, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(191786);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191787);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(191787);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(191785);
      Object localObject1 = kotlin.d.a.a.SXO;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191785);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject2 = this.p$;
        paramObject = new z.a();
        paramObject.SYB = false;
        kotlin.d.f localf = (kotlin.d.f)ba.hMW();
        m localm = (m)new j(paramObject, null)
        {
          int label;
          private ai p$;
          
          public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(191783);
            p.h(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.GLR, paramObject, paramAnonymousd);
            paramAnonymousd.p$ = ((ai)paramAnonymousObject);
            AppMethodBeat.o(191783);
            return paramAnonymousd;
          }
          
          public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(191784);
            paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.SXb);
            AppMethodBeat.o(191784);
            return paramAnonymousObject1;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(191782);
            kotlin.d.a.a locala = kotlin.d.a.a.SXO;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(191782);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = paramObject;
            a.a(this.GLR.GLQ);
            paramAnonymousObject.SYB = d.ak(this.GLR.wJM, this.GLR.wJN, a.b(this.GLR.GLQ).audioChannelCount);
            paramAnonymousObject = x.SXb;
            AppMethodBeat.o(191782);
            return paramAnonymousObject;
          }
        };
        this.L$0 = localObject2;
        this.pED = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.g.a(localf, localm, this) == localObject1)
        {
          AppMethodBeat.o(191785);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (z.a)this.pED;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      for (;;)
      {
        long l;
        if (paramObject.SYB)
        {
          localObject2 = this.GLQ;
          paramObject = str2;
          l = ((b)paramq).durationMs;
          p.h(paramObject, "path");
          localObject1 = ((a)localObject2).GLJ;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.i)localObject1).bh(paramObject, l);
          }
          localObject1 = ((a)localObject2).GLJ;
          paramObject = localObject1;
          if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a)) {
            paramObject = null;
          }
          paramObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramObject;
          if (paramObject != null)
          {
            l = Math.min(paramObject.Cev.Cgx.getTime(), ((a)localObject2).CbW);
            ((a)localObject2).parent.setVisibility(8);
            d.b.a(((a)localObject2).wgr, d.c.BWv);
            paramObject = ((a)localObject2).wgr;
            localObject1 = d.c.BWO;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("PARAM_1_LONG", l);
            paramObject.a((d.c)localObject1, (Bundle)localObject2);
            paramObject = com.tencent.mm.plugin.vlog.model.report.a.GBa;
            com.tencent.mm.plugin.vlog.model.report.a.report(111L);
          }
        }
        for (;;)
        {
          paramObject = x.SXb;
          AppMethodBeat.o(191785);
          return paramObject;
          l = 0L;
          break;
          Log.e("MicroMsg.EditorReadPlugin", "tts remux error, input text:" + ((b)paramq).GLT);
          this.GLQ.cIh();
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMProcessBar>
  {
    g(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.a
 * JD-Core Version:    0.7.0.1
 */