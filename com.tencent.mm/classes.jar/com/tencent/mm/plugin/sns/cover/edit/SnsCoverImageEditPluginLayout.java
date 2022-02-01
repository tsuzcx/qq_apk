package com.tencent.mm.plugin.sns.cover.edit;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.cover.edit.a.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/SnsCoverImageEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "", "previewPlugin", "Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverEffectImagePlugin;", "finishPageWithCancel", "", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverImageEditPluginLayout
  extends AutoRegisterPluginLayout
{
  public static final SnsCoverImageEditPluginLayout.a QkV;
  private final com.tencent.mm.plugin.sns.cover.edit.a.b QkW;
  private String path;
  
  static
  {
    AppMethodBeat.i(307350);
    QkV = new SnsCoverImageEditPluginLayout.a((byte)0);
    AppMethodBeat.o(307350);
  }
  
  public SnsCoverImageEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307338);
    LayoutInflater.from(paramContext).inflate(b.g.cover_image_edit_layout, (ViewGroup)this, true);
    new com.tencent.mm.plugin.recordvideo.plugin.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, "back-plugin").a(b.f.cover_back, a.c.NOj);
    new com.tencent.mm.plugin.recordvideo.plugin.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, "back-plugin").a(b.f.sns_cover_cancel, a.c.NOj);
    new com.tencent.mm.plugin.recordvideo.plugin.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, "finish-plugin").a(b.f.cover_finish, a.c.NOQ);
    this.QkW = new com.tencent.mm.plugin.sns.cover.edit.a.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    this.path = "";
    AppMethodBeat.o(307338);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(307355);
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    this.path = paramRecordConfigProvider.NIf;
    AppMethodBeat.o(307355);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(307361);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(307361);
      return;
      paramc = getContext();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(307361);
        throw paramc;
      }
      ((MMRecordUI)paramc).gGB();
      AppMethodBeat.o(307361);
      return;
      if (this.QkW.Qll)
      {
        AppMethodBeat.o(307361);
        return;
      }
      kotlinx.coroutines.j.a((kotlinx.coroutines.aq)this, null, null, (m)new c(this, null), 3);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<kotlinx.coroutines.aq, d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int aai;
    int label;
    
    c(SnsCoverImageEditPluginLayout paramSnsCoverImageEditPluginLayout, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(307374);
      paramObject = (d)new c(this.QkX, paramd);
      AppMethodBeat.o(307374);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool = false;
      int i = -1;
      AppMethodBeat.i(307370);
      Object localObject3 = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(307370);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (h.baE().ban().getInt(at.a.adgI, 0) == 1)
        {
          Log.i("MicroMsg.SnsCoverImageEditPluginLayout", "debug info,post source image");
          paramObject = new ArrayList();
          localObject2 = this.QkX;
          localObject1 = com.tencent.mm.plugin.mediabasic.data.a.KOB;
          localObject2 = SnsCoverImageEditPluginLayout.b((SnsCoverImageEditPluginLayout)localObject2);
          s.checkNotNull(localObject2);
          paramObject.add(new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject1, (String)localObject2));
          localObject1 = CaptureDataManager.NHH;
          localObject2 = this.QkX.getContext();
          if (paramObject.size() > 0) {
            bool = true;
          }
          ((CaptureDataManager)localObject1).a((Context)localObject2, -1, new MediaResultInfo(bool, paramObject));
          paramObject = ah.aiuX;
          AppMethodBeat.o(307370);
          return paramObject;
        }
        paramObject = CaptureDataManager.NHH;
        localObject2 = this.QkX.getContext();
        localObject1 = SnsCoverImageEditPluginLayout.a(this.QkX);
        d locald = (d)this;
        this.L$0 = paramObject;
        this.Uf = localObject2;
        this.aai = -1;
        this.label = 1;
        localObject1 = l.a((kotlin.d.f)bg.kCi(), (m)new b.d((com.tencent.mm.plugin.sns.cover.edit.a.b)localObject1, null), locald);
        if (localObject1 == localObject3)
        {
          AppMethodBeat.o(307370);
          return localObject3;
        }
        break;
      case 1: 
        i = this.aai;
        localObject2 = (Context)this.Uf;
        localObject3 = (CaptureDataManager)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject3;
      }
      for (;;)
      {
        paramObject.a((Context)localObject2, i, (MediaResultInfo)localObject1);
        com.tencent.mm.plugin.sns.statistics.j.QFS.QGL.jfr = 1;
        com.tencent.mm.plugin.sns.statistics.j.QFS.QGN.jfr = 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.SnsCoverImageEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */