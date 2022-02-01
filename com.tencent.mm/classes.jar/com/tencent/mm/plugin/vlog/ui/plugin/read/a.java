package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.vfs.u;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.vlog.ui.plugin.d.c, d.d
{
  private static int Nzq;
  public static final a Nzr;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  long Nzg;
  int Nzh;
  com.tencent.mm.plugin.recordvideo.ui.editor.item.j Nzi;
  private long Nzj;
  private final kotlin.f Nzk;
  private final kotlin.f Nzl;
  private final kotlin.f Nzm;
  private final kotlin.f Nzn;
  private final Runnable Nzo;
  private final d Nzp;
  private boolean aGh;
  private final VideoTransPara lgX;
  ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(243501);
    Nzr = new a((byte)0);
    AppMethodBeat.o(243501);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(243500);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.Nzh = -1;
    this.Nzk = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.Nzl = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.Nzm = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Nzn = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Nzo = ((Runnable)new b(this));
    LayoutInflater.from(this.parent.getContext()).inflate(com.tencent.mm.plugin.vlog.a.g.editor_tts_panel, this.parent, true);
    this.parent.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(237627);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!a.c(this.Nzs)) {
          this.Nzs.xK();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(237627);
      }
    });
    ((TextView)this.Nzm.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(228919);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.Nzs;
        paramAnonymousView.Nzh = -1;
        paramAnonymousView.hideLoading();
        paramAnonymousView.parent.setVisibility(8);
        d.b.a(paramAnonymousView.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTB);
        d.b.a(paramAnonymousView.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTk);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228919);
      }
    });
    paramViewGroup = h.aHF();
    kotlin.g.b.p.j(paramViewGroup, "MMKernel.network()");
    paramViewGroup.aGY().a(5207, (com.tencent.mm.an.i)this);
    this.Nzp = new d();
    paramViewGroup = e.bkp();
    kotlin.g.b.p.j(paramViewGroup, "SubCoreVideoControl.getCore()");
    this.lgX = paramViewGroup.bkv();
    AppMethodBeat.o(243500);
  }
  
  private final ViewGroup gwd()
  {
    AppMethodBeat.i(243481);
    ViewGroup localViewGroup = (ViewGroup)this.Nzk.getValue();
    AppMethodBeat.o(243481);
    return localViewGroup;
  }
  
  private final ViewGroup gwe()
  {
    AppMethodBeat.i(243483);
    ViewGroup localViewGroup = (ViewGroup)this.Nzn.getValue();
    AppMethodBeat.o(243483);
    return localViewGroup;
  }
  
  private final void lJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243495);
    paramString1 = new b(paramString1, paramString2);
    int i = Nzq;
    Nzq = i + 1;
    this.Nzh = i;
    paramString1.Nzh = this.Nzh;
    paramString2 = h.aHF();
    kotlin.g.b.p.j(paramString2, "MMKernel.network()");
    paramString2.aGY().b((com.tencent.mm.an.q)paramString1);
    AppMethodBeat.o(243495);
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(243486);
    this.aGh = true;
    ViewGroup localViewGroup = gwd();
    kotlin.g.b.p.j(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(0);
    localViewGroup = gwe();
    kotlin.g.b.p.j(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.parent.setVisibility(0);
    AppMethodBeat.o(243486);
  }
  
  public final void LX(long paramLong)
  {
    this.Nzj = paramLong;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a parama)
  {
    AppMethodBeat.i(243485);
    kotlin.g.b.p.k(parama, "data");
    String str;
    if ((parama instanceof r))
    {
      str = String.valueOf(((r)parama).LV);
      if ((parama instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.j)) {
        break label111;
      }
      parama = null;
    }
    label111:
    for (;;)
    {
      this.Nzi = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.j)parama);
      showLoading();
      parama = z.bdh();
      kotlin.g.b.p.j(parama, "ConfigStorageLogic.getMyFinderUsername()");
      lJ(parama, str);
      parama = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
      com.tencent.mm.plugin.vlog.model.report.a.report(110L);
      AppMethodBeat.o(243485);
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
    AppMethodBeat.i(243499);
    if (paramac != null) {}
    for (paramLong = paramac.NmT.getDurationMs();; paramLong = 0L)
    {
      this.Nzg = paramLong;
      AppMethodBeat.o(243499);
      return;
    }
  }
  
  public final void a(d.e parame) {}
  
  public final void cWO()
  {
    AppMethodBeat.i(243490);
    Object localObject = gwd();
    kotlin.g.b.p.j(localObject, "ttsLoadingContainer");
    ((ViewGroup)localObject).setVisibility(4);
    localObject = gwe();
    kotlin.g.b.p.j(localObject, "ttsFailedContainer");
    ((ViewGroup)localObject).setVisibility(0);
    this.parent.postDelayed(this.Nzo, 2000L);
    localObject = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
    com.tencent.mm.plugin.vlog.model.report.a.report(112L);
    AppMethodBeat.o(243490);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(243488);
    this.aGh = false;
    ViewGroup localViewGroup = gwd();
    kotlin.g.b.p.j(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(243488);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(243496);
    if (((paramq instanceof b)) && (((b)paramq).Nzh == this.Nzh))
    {
      hideLoading();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final aa.f localf = new aa.f();
        localf.aaBC = (com.tencent.mm.plugin.sight.base.c.fIw() + '/' + UUID.randomUUID());
        final String str = (String)localf.aaBC + ".tts";
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((b)paramq).Nzy).append(", speech size:");
        paramString = ((b)paramq).Nzx;
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.length);; paramString = null)
        {
          Log.i("MicroMsg.EditorReadPlugin", paramString + ", speech duration:" + ((b)paramq).durationMs + ", path:" + (String)localf.aaBC);
          u.H((String)localf.aaBC, ((b)paramq).Nzx);
          kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRr(), (m)new c(this, localf, str, paramq, null), 2);
          AppMethodBeat.o(243496);
          return;
        }
      }
      Log.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b)paramq).Nzy + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      cWO();
    }
    AppMethodBeat.o(243496);
  }
  
  public final void release()
  {
    AppMethodBeat.i(243497);
    com.tencent.mm.kernel.c localc = h.aHF();
    kotlin.g.b.p.j(localc, "MMKernel.network()");
    localc.aGY().b(5207, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(243497);
  }
  
  public final void xK()
  {
    AppMethodBeat.i(243493);
    ViewGroup localViewGroup = gwe();
    kotlin.g.b.p.j(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.parent.getHandler().removeCallbacks(this.Nzo);
    this.parent.setVisibility(8);
    d.b.a(this.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTB);
    d.b.a(this.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTk);
    AppMethodBeat.o(243493);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "REPORT_KEY_MULTI_VIDEO_EDIT_CLICK_READ", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_FAIL", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_SUCCESS", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(234103);
      this.Nzs.xK();
      AppMethodBeat.o(234103);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    c(a parama, aa.f paramf, String paramString, com.tencent.mm.an.q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(230189);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new c(this.Nzs, localf, str, paramq, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(230189);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(230192);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(230192);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(230186);
      Object localObject1 = kotlin.d.a.a.aaAA;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(230186);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject2 = this.p$;
        paramObject = new aa.a();
        paramObject.aaBx = false;
        kotlin.d.f localf = (kotlin.d.f)bc.iRs();
        m localm = (m)new kotlin.d.b.a.j(paramObject, null)
        {
          int label;
          private ak p$;
          
          public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(242693);
            kotlin.g.b.p.k(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.Nzv, paramObject, paramAnonymousd);
            paramAnonymousd.p$ = ((ak)paramAnonymousObject);
            AppMethodBeat.o(242693);
            return paramAnonymousd;
          }
          
          public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(242694);
            paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.aazN);
            AppMethodBeat.o(242694);
            return paramAnonymousObject1;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(242692);
            kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(242692);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = paramObject;
            a.a(this.Nzv.Nzs);
            paramAnonymousObject.aaBx = d.ar((String)this.Nzv.Nzt.aaBC, this.Nzv.Nzu, a.b(this.Nzv.Nzs).audioChannelCount);
            paramAnonymousObject = x.aazN;
            AppMethodBeat.o(242692);
            return paramAnonymousObject;
          }
        };
        this.L$0 = localObject2;
        this.oDA = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.i.a(localf, localm, this) == localObject1)
        {
          AppMethodBeat.o(230186);
          return localObject1;
        }
        break;
      case 1: 
        localObject1 = (aa.a)this.oDA;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject1;
      }
      for (;;)
      {
        long l;
        if (paramObject.aaBx)
        {
          localObject2 = this.Nzs;
          paramObject = str;
          l = ((b)paramq).durationMs;
          kotlin.g.b.p.k(paramObject, "path");
          localObject1 = ((a)localObject2).Nzi;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.j)localObject1).bj(paramObject, l);
          }
          localObject1 = ((a)localObject2).Nzi;
          paramObject = localObject1;
          if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a)) {
            paramObject = null;
          }
          paramObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramObject;
          if (paramObject != null)
          {
            l = Math.min(paramObject.Ibr.Ido.getTime(), ((a)localObject2).Nzg);
            ((a)localObject2).parent.setVisibility(8);
            d.b.a(((a)localObject2).APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTk);
            paramObject = ((a)localObject2).APl;
            localObject1 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTA;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("PARAM_1_LONG", l);
            paramObject.a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject1, (Bundle)localObject2);
            paramObject = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
            com.tencent.mm.plugin.vlog.model.report.a.report(111L);
          }
        }
        for (;;)
        {
          paramObject = x.aazN;
          AppMethodBeat.o(230186);
          return paramObject;
          l = 0L;
          break;
          Log.e("MicroMsg.EditorReadPlugin", "tts remux error, input text:" + ((b)paramq).Nzy);
          this.Nzs.cWO();
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.a
 * JD-Core Version:    0.7.0.1
 */