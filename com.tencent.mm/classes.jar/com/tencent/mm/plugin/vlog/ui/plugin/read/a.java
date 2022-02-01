package com.tencent.mm.plugin.vlog.ui.plugin.read;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.plugin.c.c;
import com.tencent.mm.plugin.vlog.ui.plugin.c.d;
import com.tencent.mm.plugin.vlog.ui.plugin.c.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.videocomposition.h;
import d.d.b.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.UUID;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bk;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "curEditData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "curTimeMs", "", "hideErrorRunnable", "Ljava/lang/Runnable;", "loading", "", "maxDurationMs", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "ttsCancelText", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTtsCancelText", "()Landroid/widget/TextView;", "ttsCancelText$delegate", "Lkotlin/Lazy;", "ttsFailedContainer", "getTtsFailedContainer", "ttsFailedContainer$delegate", "ttsLoadingContainer", "getTtsLoadingContainer", "ttsLoadingContainer$delegate", "ttsProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getTtsProcessBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "ttsProcessBar$delegate", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "applyTTS", "", "path", "", "durationMs", "cancel", "doNetRequest", "finderUserName", "inputText", "hideError", "hideLoading", "onFinish", "onProgress", "timeMs", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOrigin", "release", "showError", "showLoading", "textToSpeech", "data", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Companion", "plugin-vlog_release"})
public final class a
  implements com.tencent.mm.al.f, t, c.c, c.d
{
  public static int BRl;
  public static final a BRm;
  public int BRd;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.i BRe;
  private final d.f BRf;
  private final d.f BRg;
  private final d.f BRh;
  private final d.f BRi;
  private final Runnable BRj;
  private final d BRk;
  public boolean aWX;
  public ViewGroup gqv;
  private final VideoTransPara hvh;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  long xKY;
  private long xKZ;
  
  static
  {
    AppMethodBeat.i(196618);
    BRm = new a((byte)0);
    AppMethodBeat.o(196618);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196617);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    this.BRd = -1;
    this.BRf = d.g.O((d.g.a.a)new f(this));
    this.BRg = d.g.O((d.g.a.a)new g(this));
    this.BRh = d.g.O((d.g.a.a)new d(this));
    this.BRi = d.g.O((d.g.a.a)new e(this));
    this.BRj = ((Runnable)new b(this));
    LayoutInflater.from(this.gqv.getContext()).inflate(2131496453, this.gqv, true);
    this.gqv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196597);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!a.c(this.BRn)) {
          this.BRn.cM();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196597);
      }
    });
    ((MMProcessBar)this.BRg.getValue()).setIfVisibleRotate(true);
    ((TextView)this.BRh.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196598);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BRn;
        paramAnonymousView.BRd = -1;
        paramAnonymousView.hideLoading();
        paramAnonymousView.gqv.setVisibility(8);
        d.b.a(paramAnonymousView.sQE, d.c.xGk);
        d.b.a(paramAnonymousView.sQE, d.c.xFQ);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196598);
      }
    });
    paramViewGroup = com.tencent.mm.kernel.g.ajB();
    p.g(paramViewGroup, "MMKernel.network()");
    paramViewGroup.aiU().a(5207, (com.tencent.mm.al.f)this);
    this.BRk = new d();
    paramViewGroup = com.tencent.mm.modelcontrol.d.aGQ();
    p.g(paramViewGroup, "SubCoreVideoControl.getCore()");
    this.hvh = paramViewGroup.aGW();
    AppMethodBeat.o(196617);
  }
  
  public final void Bq(long paramLong)
  {
    this.xKZ = paramLong;
  }
  
  public final void a(v paramv, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(196616);
    if (paramv != null) {}
    for (paramLong = paramv.BGk.getDurationMs();; paramLong = 0L)
    {
      this.xKY = paramLong;
      AppMethodBeat.o(196616);
      return;
    }
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void cM()
  {
    AppMethodBeat.i(196613);
    ViewGroup localViewGroup = etM();
    p.g(localViewGroup, "ttsFailedContainer");
    localViewGroup.setVisibility(4);
    this.gqv.getHandler().removeCallbacks(this.BRj);
    this.gqv.setVisibility(8);
    d.b.a(this.sQE, d.c.xGk);
    d.b.a(this.sQE, d.c.xFQ);
    AppMethodBeat.o(196613);
  }
  
  public final ViewGroup etL()
  {
    AppMethodBeat.i(196610);
    ViewGroup localViewGroup = (ViewGroup)this.BRf.getValue();
    AppMethodBeat.o(196610);
    return localViewGroup;
  }
  
  public final ViewGroup etM()
  {
    AppMethodBeat.i(196611);
    ViewGroup localViewGroup = (ViewGroup)this.BRi.getValue();
    AppMethodBeat.o(196611);
    return localViewGroup;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(196612);
    this.aWX = false;
    ViewGroup localViewGroup = etL();
    p.g(localViewGroup, "ttsLoadingContainer");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(196612);
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
    AppMethodBeat.i(196619);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196619);
  }
  
  public final void onResume() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(196614);
    if (((paramn instanceof b)) && (((b)paramn).BRd == this.BRd))
    {
      hideLoading();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final String str1 = com.tencent.mm.plugin.sight.base.b.dPX() + '/' + UUID.randomUUID();
        final String str2 = str1 + ".wav";
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((b)paramn).BRs).append(", speech size:");
        paramString = ((b)paramn).BRr;
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.length);; paramString = null)
        {
          ad.i("MicroMsg.EditorReadPlugin", paramString + ", speech duration:" + ((b)paramn).bup + ", path:" + str1);
          com.tencent.mm.vfs.i.C(str1, ((b)paramn).BRr);
          kotlinx.coroutines.f.b((ah)bk.NII, (d.d.f)az.gvo(), (m)new c(this, str1, str2, paramn, null), 2);
          AppMethodBeat.o(196614);
          return;
        }
      }
      Toast.makeText(this.gqv.getContext(), (CharSequence)("tts error, input text:" + ((b)paramn).BRs + ", errType:" + paramInt1 + ", errCode:" + paramInt2), 0).show();
      ad.e("MicroMsg.EditorReadPlugin", "tts error, input text:" + ((b)paramn).BRs + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      paramString = etL();
      p.g(paramString, "ttsLoadingContainer");
      paramString.setVisibility(4);
      paramString = etM();
      p.g(paramString, "ttsFailedContainer");
      paramString.setVisibility(0);
      this.gqv.postDelayed(this.BRj, 2000L);
    }
    AppMethodBeat.o(196614);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196615);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(5207, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(196615);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/read/EditReadPlugin$Companion;", "", "()V", "BASE_REQ_ID", "", "HIDE_ERROR_TIMEOUT", "", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(196599);
      this.BRn.cM();
      AppMethodBeat.o(196599);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.ui.plugin.read.EditReadPlugin$onSceneEnd$1", f="EditReadPlugin.kt", gfL={162}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ah, d.d.d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    c(a parama, String paramString1, String paramString2, n paramn, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(196604);
      p.h(paramd, "completion");
      paramd = new c(this.BRn, str1, str2, paramn, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(196604);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(196603);
      paramObject = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196603);
        throw paramObject;
      case 0: 
        localObject1 = this.nWQ;
        localObject2 = (d.d.f)az.gvp();
        m localm = (m)new j(null)
        {
          int label;
          private ah nWQ;
          
          public final d.d.d<z> a(Object paramAnonymousObject, d.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(196601);
            p.h(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.BRq, paramAnonymousd);
            paramAnonymousd.nWQ = ((ah)paramAnonymousObject);
            AppMethodBeat.o(196601);
            return paramAnonymousd;
          }
          
          public final Object cQ(Object paramAnonymousObject)
          {
            AppMethodBeat.i(196600);
            paramAnonymousObject = d.d.a.a.MLc;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196600);
              throw paramAnonymousObject;
            }
            a.a(this.BRq.BRn);
            d.s(this.BRq.BRo, this.BRq.BRp, a.b(this.BRq.BRn).audioChannelCount, a.b(this.BRq.BRn).audioBitrate);
            paramAnonymousObject = z.MKo;
            AppMethodBeat.o(196600);
            return paramAnonymousObject;
          }
          
          public final Object p(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(196602);
            paramAnonymousObject1 = ((1)a(paramAnonymousObject1, (d.d.d)paramAnonymousObject2)).cQ(z.MKo);
            AppMethodBeat.o(196602);
            return paramAnonymousObject1;
          }
        };
        this.nWR = localObject1;
        this.label = 1;
        if (kotlinx.coroutines.g.a((d.d.f)localObject2, localm, this) == paramObject)
        {
          AppMethodBeat.o(196603);
          return paramObject;
        }
        break;
      }
      Object localObject2 = this.BRn;
      paramObject = str2;
      long l = ((b)paramn).bup;
      p.h(paramObject, "path");
      Object localObject1 = ((a)localObject2).BRe;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.i)localObject1).be(paramObject, l);
      }
      localObject1 = ((a)localObject2).BRe;
      paramObject = localObject1;
      if (!(localObject1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.a)) {
        paramObject = null;
      }
      paramObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramObject;
      if (paramObject != null) {}
      for (l = Math.min(paramObject.xNA.xPF.getTime(), ((a)localObject2).xKY);; l = 0L)
      {
        ((a)localObject2).gqv.setVisibility(8);
        d.b.a(((a)localObject2).sQE, d.c.xFQ);
        paramObject = ((a)localObject2).sQE;
        localObject1 = d.c.xGj;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("PARAM_1_LONG", l);
        paramObject.a((d.c)localObject1, (Bundle)localObject2);
        paramObject = z.MKo;
        AppMethodBeat.o(196603);
        return paramObject;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196605);
      paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(196605);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<TextView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "kotlin.jvm.PlatformType", "invoke"})
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