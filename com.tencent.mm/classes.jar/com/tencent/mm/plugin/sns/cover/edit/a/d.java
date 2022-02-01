package com.tencent.mm.plugin.sns.cover.edit.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.b.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mediabasic.data.MediaDurationInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaErrorInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo;
import com.tencent.mm.plugin.mediabasic.data.MediaResultInfo.a;
import com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.d<-Lcom.tencent.mm.plugin.mediabasic.data.MediaResultInfo;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/plugin/SnsExportPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "remuxInputData", "Lcom/tencent/mm/plugin/mediabasic/data/MediaInputInfo;", "remuxOutputData", "Lcom/tencent/mm/plugin/mediabasic/data/MediaOutputInfo;", "exportVideo", "Lcom/tencent/mm/plugin/mediabasic/data/MediaResultInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLogic", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setTimeCropRange", "startMs", "", "endMs", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public com.tencent.mm.plugin.mediabasic.data.b Qlx;
  public com.tencent.mm.plugin.mediabasic.data.c Qly;
  
  public d(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(307375);
    AppMethodBeat.o(307375);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(307379);
    s.u(paramRecordConfigProvider, "configProvider");
    super.a(paramRecordConfigProvider);
    Object localObject1 = com.tencent.mm.plugin.mediabasic.data.a.KOz;
    Object localObject2 = paramRecordConfigProvider.NId;
    s.s(localObject2, "configProvider.inputVideoPath");
    this.Qlx = new com.tencent.mm.plugin.mediabasic.data.b(p.al(new MediaSingleInfo[] { new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject1, (String)localObject2) }), (byte)0);
    localObject1 = com.tencent.mm.plugin.mediabasic.data.a.KOz;
    localObject2 = paramRecordConfigProvider.NIe;
    s.s(localObject2, "configProvider.outputVideoPath");
    localObject1 = new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject1, (String)localObject2);
    localObject2 = com.tencent.mm.plugin.mediabasic.data.a.KOC;
    String str = paramRecordConfigProvider.thumbPath;
    s.s(str, "configProvider.thumbPath");
    localObject2 = new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject2, str);
    paramRecordConfigProvider = paramRecordConfigProvider.oXZ;
    s.s(paramRecordConfigProvider, "configProvider.videoParam");
    this.Qly = new com.tencent.mm.plugin.mediabasic.data.c(paramRecordConfigProvider, p.al(new MediaSingleInfo[] { localObject1, localObject2 }), (byte)0);
    AppMethodBeat.o(307379);
  }
  
  public final Object an(kotlin.d.d<? super MediaResultInfo> paramd)
  {
    boolean bool = false;
    AppMethodBeat.i(307395);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    Object localObject4;
    for (paramd = (kotlin.d.d<? super MediaResultInfo>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      localObject4 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(307395);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this.Qly;
    if (localObject1 != null)
    {
      localObject2 = new com.tencent.mm.ca.b.d();
      ((com.tencent.mm.ca.b.d)localObject2).a((com.tencent.mm.ca.b.b)new e()).a((com.tencent.mm.ca.b.b)new com.tencent.mm.ca.b.c());
      Object localObject3 = this.Qlx;
      s.checkNotNull(localObject3);
      paramd.L$0 = this;
      paramd.Uf = localObject1;
      paramd.label = 1;
      localObject3 = com.tencent.mm.ca.b.a.a((com.tencent.mm.ca.b.a)localObject2, (com.tencent.mm.plugin.mediabasic.data.b)localObject3, (com.tencent.mm.plugin.mediabasic.data.c)localObject1, paramd);
      localObject2 = localObject3;
      paramd = (kotlin.d.d<? super MediaResultInfo>)localObject1;
      localObject1 = this;
      if (localObject3 == localObject4)
      {
        AppMethodBeat.o(307395);
        return localObject4;
        localObject1 = (com.tencent.mm.plugin.mediabasic.data.c)paramd.Uf;
        localObject3 = (d)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
        paramd = (kotlin.d.d<? super MediaResultInfo>)localObject1;
        localObject1 = localObject3;
      }
      localObject2 = (MediaErrorInfo)localObject2;
      localObject3 = new ArrayList();
      int i;
      if (y.ZC(paramd.getVideoPath()))
      {
        localObject4 = com.tencent.mm.plugin.mediabasic.data.a.KOz;
        Object localObject5 = paramd.getVideoPath();
        s.checkNotNull(localObject5);
        ((ArrayList)localObject3).add(new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject4, (String)localObject5, new MediaDurationInfo(paramd.getDuration())));
        localObject4 = com.tencent.mm.plugin.mmsight.d.Pf(paramd.getVideoPath());
        if (localObject4 != null)
        {
          localObject5 = f.Obq;
          localObject1 = ((d)localObject1).Qly;
          if (localObject1 != null) {
            break label479;
          }
          i = 0;
        }
      }
      for (;;)
      {
        localObject1 = f.j((Bitmap)localObject4, i);
        BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, Bitmap.CompressFormat.JPEG, paramd.bud(), false);
        localObject4 = com.tencent.mm.plugin.mediabasic.data.a.KOC;
        paramd = paramd.bud();
        s.checkNotNull(paramd);
        ((ArrayList)localObject3).add(new MediaSingleInfo((com.tencent.mm.plugin.mediabasic.data.a)localObject4, paramd));
        paramd = com.tencent.mm.plugin.sns.cover.edit.b.a.QlA;
        paramd = com.tencent.mm.plugin.sns.cover.edit.b.a.aJ((Bitmap)localObject1);
        ((ArrayList)localObject3).add(new MediaSingleInfo(com.tencent.mm.plugin.mediabasic.data.a.KOB, paramd));
        if (((MediaErrorInfo)localObject2).KOG == com.tencent.mm.plugin.mediabasic.data.d.KOQ) {
          bool = true;
        }
        paramd = new MediaResultInfo(bool, (ArrayList)localObject3);
        AppMethodBeat.o(307395);
        return paramd;
        label479:
        localObject1 = ((com.tencent.mm.plugin.mediabasic.data.c)localObject1).nLH;
        if (localObject1 == null) {
          i = 0;
        } else {
          i = ((VideoTransPara)localObject1).oCa;
        }
      }
    }
    paramd = MediaResultInfo.KOL;
    paramd = MediaResultInfo.a.gaG();
    AppMethodBeat.o(307395);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(307377);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Qlz.an((kotlin.d.d)this);
      AppMethodBeat.o(307377);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.a.d
 * JD-Core Version:    0.7.0.1
 */