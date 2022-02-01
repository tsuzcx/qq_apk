package com.tencent.mm.plugin.sns.cover.edit;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mediabasic.data.MediaDurationInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.cover.edit.a.c;
import com.tencent.mm.plugin.sns.cover.edit.a.c.e;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/SnsCoverVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "cropPlugin", "Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverCropVideoPlugin;", "exportPlugin", "Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsExportPlugin;", "previewPlugin", "Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsCoverEffectPreviewPlugin;", "finishPageWithCancel", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverVideoEditPluginLayout
  extends AutoRegisterPluginLayout
{
  public static final SnsCoverVideoEditPluginLayout.a QkY;
  private final com.tencent.mm.plugin.recordvideo.plugin.a QkZ;
  private final c Qla;
  private final com.tencent.mm.plugin.sns.cover.edit.a.a Qlb;
  private final com.tencent.mm.plugin.sns.cover.edit.a.d Qlc;
  
  static
  {
    AppMethodBeat.i(307351);
    QkY = new SnsCoverVideoEditPluginLayout.a((byte)0);
    AppMethodBeat.o(307351);
  }
  
  public SnsCoverVideoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307342);
    LayoutInflater.from(paramContext).inflate(b.g.cover_video_edit_layout, (ViewGroup)this, true);
    paramContext = new com.tencent.mm.plugin.recordvideo.plugin.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, "close-plugin");
    paramContext.a(b.f.cover_back, a.c.NOj);
    paramAttributeSet = ah.aiuX;
    this.QkZ = ((com.tencent.mm.plugin.recordvideo.plugin.a)paramContext);
    this.Qla = new c((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    this.Qlb = new com.tencent.mm.plugin.sns.cover.edit.a.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    this.Qlc = new com.tencent.mm.plugin.sns.cover.edit.a.d((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this);
    new com.tencent.mm.plugin.recordvideo.plugin.b((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this, "finish-plugin").a(b.f.cover_finish, a.c.NOQ);
    AppMethodBeat.o(307342);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(307366);
    s.u(paramc, "status");
    s.X("statusChange :", paramc);
    h.jXD();
    switch (SnsCoverVideoEditPluginLayout.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(307366);
      return;
      paramc = getContext();
      if (paramc == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
        AppMethodBeat.o(307366);
        throw paramc;
      }
      ((MMRecordUI)paramc).gGB();
      AppMethodBeat.o(307366);
      return;
      this.QkZ.setVisibility(4);
      paramc = this.Qla;
      int k = paramc.heD().getWidth();
      int m = paramc.heD().getHeight();
      int j = com.tencent.mm.cd.a.fromDPToPix(paramc.getContext(), 20) + com.tencent.mm.cd.a.fromDPToPix(paramc.getContext(), 95) + com.tencent.mm.cd.a.fromDPToPix(paramc.getContext(), 12);
      int i = j;
      if (bf.bg(paramc.getContext())) {
        i = j + bf.bk(paramc.getContext());
      }
      j = m - i;
      if (paramc.heD().getBottom() < com.tencent.mm.plugin.mmsight.d.iQ(paramc.getContext()).y) {
        j = (int)((k - com.tencent.mm.cd.a.fromDPToPix(paramc.getContext(), 32) * 2) / (k / m));
      }
      float f1 = (int)(k / m * j) / k * com.tencent.mm.cd.a.ms(paramc.getContext()) / k;
      float f2 = j / m * com.tencent.mm.cd.a.ms(paramc.getContext()) / k;
      float f3 = -(Math.abs(i) / 2.0F);
      paramBundle = paramc.heD().animate().scaleX(f1).scaleY(f2).translationY(f3);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.setDuration(300L);
        if (paramBundle != null) {
          paramBundle.setListener((Animator.AnimatorListener)new c.e(paramc));
        }
      }
      AppMethodBeat.o(307366);
      return;
      this.QkZ.setVisibility(0);
      this.Qla.heD().animate().scaleX(1.0F).scaleY(1.0F).translationY(0.0F).setDuration(300L);
      AppMethodBeat.o(307366);
      return;
      this.Qla.onPause();
      AppMethodBeat.o(307366);
      return;
      this.Qla.onResume();
      AppMethodBeat.o(307366);
      return;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT");
        j = paramBundle.getInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT");
        paramc = this.Qla;
        paramBundle = paramc.heD().getPlayer();
        if (paramBundle != null) {
          paramBundle.bs(i, j);
        }
        paramc = paramc.heD().getPlayer();
        if (paramc != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.a(paramc, i, false, 6);
        }
        paramc = this.Qlc;
        long l1 = i;
        long l2 = j;
        if ((paramc.Qlx == null) || (paramc.Qly == null))
        {
          AppMethodBeat.o(307366);
          return;
        }
        paramc = paramc.Qlx;
        s.checkNotNull(paramc);
        paramc = (MediaSingleInfo)paramc.KOI.get(0);
        paramBundle = new MediaDurationInfo(l1, l2);
        s.u(paramBundle, "<set-?>");
        paramc.KOO = paramBundle;
        AppMethodBeat.o(307366);
        return;
        kotlinx.coroutines.j.a((aq)this, null, null, (m)new c(this, null), 3);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(SnsCoverVideoEditPluginLayout paramSnsCoverVideoEditPluginLayout, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(307339);
      paramObject = (kotlin.d.d)new c(this.Qld, paramd);
      AppMethodBeat.o(307339);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(307334);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(307334);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        SnsCoverVideoEditPluginLayout.a(this.Qld).onPause();
        paramObject = new com.tencent.mm.plugin.recordvideo.ui.a();
        localObject1 = this.Qld.getContext();
        s.s(localObject1, "context");
        paramObject.a((Context)localObject1, b.h.remux_loading_tips, (kotlin.g.a.a)SnsCoverVideoEditPluginLayout.c.a.Qle);
        localObject1 = SnsCoverVideoEditPluginLayout.b(this.Qld);
        localObject2 = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = ((com.tencent.mm.plugin.sns.cover.edit.a.d)localObject1).an((kotlin.d.d)localObject2);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(307334);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (com.tencent.mm.plugin.recordvideo.ui.a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (MediaResultInfo)localObject1;
      s.X("Export Result:", localObject1);
      h.jXD();
      paramObject.dismiss();
      CaptureDataManager.NHH.a(this.Qld.getContext(), -1, (MediaResultInfo)localObject1);
      com.tencent.mm.plugin.sns.statistics.j.QFS.QGL.jfr = 2;
      com.tencent.mm.plugin.sns.statistics.j.QFS.QGN.jfr = 2;
      paramObject = ah.aiuX;
      AppMethodBeat.o(307334);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.SnsCoverVideoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */