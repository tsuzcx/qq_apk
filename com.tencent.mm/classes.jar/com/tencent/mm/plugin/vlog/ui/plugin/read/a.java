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
import com.tencent.mm.ak.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.i;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.plugin.c.c;
import com.tencent.mm.plugin.vlog.ui.plugin.c.d;
import com.tencent.mm.plugin.vlog.ui.plugin.c.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.videocomposition.h;
import d.d.b.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.y.a;
import d.l;
import d.z;
import java.util.UUID;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"})
public final class a
  implements com.tencent.mm.ak.f, t, c.c, c.d
{
  private static int CiK;
  public static final a CiL;
  int CiC;
  public i CiD;
  private final d.f CiE;
  private final d.f CiF;
  private final d.f CiG;
  private final d.f CiH;
  private final Runnable CiI;
  private final d CiJ;
  public boolean aWX;
  public ViewGroup gsV;
  private final VideoTransPara hxV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  long yaU;
  private long yaV;
  
  static
  {
    AppMethodBeat.i(192079);
    CiL = new a((byte)0);
    AppMethodBeat.o(192079);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(192078);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    this.CiC = -1;
    this.CiE = d.g.O((d.g.a.a)new f(this));
    this.CiF = d.g.O((d.g.a.a)new g(this));
    this.CiG = d.g.O((d.g.a.a)new d(this));
    this.CiH = d.g.O((d.g.a.a)new e(this));
    this.CiI = ((Runnable)new b(this));
    LayoutInflater.from(this.gsV.getContext()).inflate(2131496453, this.gsV, true);
    this.gsV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192056);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!a.c(this.CiM)) {
          this.CiM.cM();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192056);
      }
    });
    ((MMProcessBar)this.CiF.getValue()).setIfVisibleRotate(true);
    ((TextView)this.CiG.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192057);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.CiM;
        paramAnonymousView.CiC = -1;
        paramAnonymousView.hideLoading();
        paramAnonymousView.gsV.setVisibility(8);
        d.b.a(paramAnonymousView.tbP, d.c.xWf);
        d.b.a(paramAnonymousView.tbP, d.c.xVL);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192057);
      }
    });
    paramViewGroup = com.tencent.mm.kernel.g.ajQ();
    p.g(paramViewGroup, "MMKernel.network()");
    paramViewGroup.ajj().a(5207, (com.tencent.mm.ak.f)this);
    this.CiJ = new d();
    paramViewGroup = com.tencent.mm.modelcontrol.d.aHh();
    p.g(paramViewGroup, "SubCoreVideoControl.getCore()");
    this.hxV = paramViewGroup.aHn();
    AppMethodBeat.o(192078);
  }
  
  public final void BO(long paramLong)
  {
    this.yaV = paramLong;
  }
  
  public final void a(v paramv, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(192077);
    if (paramv != null) {}
    for (paramLong = paramv.BXI.getDurationMs();; paramLong = 0L)
    {
      this.yaU = paramLong;
      AppMethodBeat.o(192077);
      return;
    }
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void cM()
  {
    AppMethodBeat.i(192073);
    ViewGroup localViewGroup = ext();
    p.g(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.gsV.getHandler().removeCallbacks(this.CiI);
    this.gsV.setVisibility(8);
    d.b.a(this.tbP, d.c.xWf);
    d.b.a(this.tbP, d.c.xVL);
    AppMethodBeat.o(192073);
  }
  
  public final void ckf()
  {
    AppMethodBeat.i(192072);
    Object localObject = exs();
    p.g(localObject, "ttsLoadingContainer");
    ((ViewGroup)localObject).setVisibility(4);
    localObject = ext();
    p.g(localObject, "ttsFailedContainer");
    ((ViewGroup)localObject).setVisibility(0);
    this.gsV.postDelayed(this.CiI, 2000L);
    localObject = com.tencent.mm.plugin.vlog.model.report.a.BZn;
    com.tencent.mm.plugin.vlog.model.report.a.report(112L);
    AppMethodBeat.o(192072);
  }
  
  public final ViewGroup exs()
  {
    AppMethodBeat.i(192069);
    ViewGroup localViewGroup = (ViewGroup)this.CiE.getValue();
    AppMethodBeat.o(192069);
    return localViewGroup;
  }
  
  public final ViewGroup ext()
  {
    AppMethodBeat.i(192070);
    ViewGroup localViewGroup = (ViewGroup)this.CiH.getValue();
    AppMethodBeat.o(192070);
    return localViewGroup;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(192071);
    this.aWX = false;
    ViewGroup localViewGroup = exs();
    p.g(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(192071);
  }
  
  public final void kt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192074);
    paramString1 = new b(paramString1, paramString2);
    int i = CiK;
    CiK = i + 1;
    this.CiC = i;
    paramString1.CiC = this.CiC;
    paramString2 = com.tencent.mm.kernel.g.ajQ();
    p.g(paramString2, "MMKernel.network()");
    paramString2.ajj().b((n)paramString1);
    AppMethodBeat.o(192074);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192080);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(192080);
  }
  
  public final void onResume() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(192075);
    if (((paramn instanceof b)) && (((b)paramn).CiC == this.CiC))
    {
      hideLoading();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final String str1 = com.tencent.mm.plugin.sight.base.b.dTu() + '/' + UUID.randomUUID();
        final String str2 = str1 + ".wav";
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((b)paramn).CiS).append(", speech size:");
        paramString = ((b)paramn).CiR;
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.length);; paramString = null)
        {
          ae.i("MicroMsg.EditorReadPlugin", paramString + ", speech duration:" + ((b)paramn).bup + ", path:" + str1);
          o.C(str1, ((b)paramn).CiR);
          kotlinx.coroutines.f.b((ah)bk.OfO, (d.d.f)az.gzQ(), (m)new c(this, str1, str2, paramn, null), 2);
          AppMethodBeat.o(192075);
          return;
        }
      }
      ae.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b)paramn).CiS + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      ckf();
    }
    AppMethodBeat.o(192075);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192076);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(5207, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(192076);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "REPORT_KEY_MULTI_VIDEO_EDIT_CLICK_READ", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_FAIL", "REPORT_KEY_MULTI_VIDEO_EDIT_READ_SUCCESS", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(192058);
      this.CiM.cM();
      AppMethodBeat.o(192058);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.read.EditReadPlugin$onSceneEnd$1", f="EditReadPlugin.kt", gkn={175}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ah, d.d.d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    
    c(a parama, String paramString1, String paramString2, n paramn, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(192063);
      p.h(paramd, "completion");
      paramd = new c(this.CiM, str1, str2, paramn, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(192063);
      return paramd;
    }
    
    public final Object cR(final Object paramObject)
    {
      AppMethodBeat.i(192062);
      Object localObject1 = d.d.a.a.Nif;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192062);
        throw paramObject;
      case 0: 
        localObject2 = this.ocz;
        paramObject = new y.a();
        paramObject.NiT = false;
        d.d.f localf = (d.d.f)az.gzR();
        m localm = (m)new j(paramObject)
        {
          int label;
          private ah ocz;
          
          public final d.d.d<z> a(Object paramAnonymousObject, d.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(192060);
            p.h(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.CiP, paramObject, paramAnonymousd);
            paramAnonymousd.ocz = ((ah)paramAnonymousObject);
            AppMethodBeat.o(192060);
            return paramAnonymousd;
          }
          
          public final Object cR(Object paramAnonymousObject)
          {
            AppMethodBeat.i(192059);
            paramAnonymousObject = d.d.a.a.Nif;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(192059);
              throw paramAnonymousObject;
            }
            paramAnonymousObject = paramObject;
            a.a(this.CiP.CiM);
            paramAnonymousObject.NiT = d.ag(this.CiP.CiN, this.CiP.CiO, a.b(this.CiP.CiM).audioChannelCount);
            paramAnonymousObject = z.Nhr;
            AppMethodBeat.o(192059);
            return paramAnonymousObject;
          }
          
          public final Object p(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(192061);
            paramAnonymousObject1 = ((1)a(paramAnonymousObject1, (d.d.d)paramAnonymousObject2)).cR(z.Nhr);
            AppMethodBeat.o(192061);
            return paramAnonymousObject1;
          }
        };
        this.ocA = localObject2;
        this.oqW = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.g.a(localf, localm, this) == localObject1)
        {
          AppMethodBeat.o(192062);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (y.a)this.oqW;
      }
      for (;;)
      {
        long l;
        if (paramObject.NiT)
        {
          localObject2 = this.CiM;
          paramObject = str2;
          l = ((b)paramn).bup;
          p.h(paramObject, "path");
          localObject1 = ((a)localObject2).CiD;
          if (localObject1 != null) {
            ((i)localObject1).bf(paramObject, l);
          }
          localObject1 = ((a)localObject2).CiD;
          paramObject = localObject1;
          if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a)) {
            paramObject = null;
          }
          paramObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramObject;
          if (paramObject != null)
          {
            l = Math.min(paramObject.ydt.yfy.getTime(), ((a)localObject2).yaU);
            ((a)localObject2).gsV.setVisibility(8);
            d.b.a(((a)localObject2).tbP, d.c.xVL);
            paramObject = ((a)localObject2).tbP;
            localObject1 = d.c.xWe;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("PARAM_1_LONG", l);
            paramObject.a((d.c)localObject1, (Bundle)localObject2);
            paramObject = com.tencent.mm.plugin.vlog.model.report.a.BZn;
            com.tencent.mm.plugin.vlog.model.report.a.report(111L);
          }
        }
        for (;;)
        {
          paramObject = z.Nhr;
          AppMethodBeat.o(192062);
          return paramObject;
          l = 0L;
          break;
          ae.e("MicroMsg.EditorReadPlugin", "tts remux error, input text:" + ((b)paramn).CiS);
          this.CiM.ckf();
        }
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(192064);
      paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(192064);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<TextView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<MMProcessBar>
  {
    g(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.a
 * JD-Core Version:    0.7.0.1
 */