package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.f;
import com.tencent.mm.plugin.vlog.model.f.a;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "finishBtn", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getFinishBtn", "()Landroid/view/View;", "setFinishBtn", "(Landroid/view/View;)V", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "chooseExportConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewRect", "fullscreenRect", "cropRect", "path", "", "musicPath", "enableAdaptiveBitrate", "", "exportVideo", "videoComposition", "editId", "enableVideoEnhancement", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "initLogic", "loadCurrentPage", "model", "saveThumbBitmap", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "bitmap", "toString", "Lcom/tencent/mm/protocal/protobuf/OutputConfig;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final g.a UqD;
  public com.tencent.mm.plugin.recordvideo.activity.a Fiu;
  public com.tencent.mm.media.widget.camerarecordview.b.b NKf;
  private final afa TYC;
  private Context context;
  public RecordConfigProvider oaV;
  private View wcv;
  
  static
  {
    AppMethodBeat.i(282324);
    UqD = new g.a((byte)0);
    AppMethodBeat.o(282324);
  }
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282277);
    this.wcv = paramView;
    this.context = this.wcv.getContext();
    this.TYC = new afa();
    float f;
    if ((this.wcv instanceof TextView))
    {
      paramView = com.tencent.mm.plugin.vlog.util.a.UsM;
      paramView = this.context;
      s.s(paramView, "context");
      f = com.tencent.mm.plugin.vlog.util.a.g(paramView, 14.0F);
      paramView = this.wcv;
      if (!(paramView instanceof TextView)) {
        break label129;
      }
    }
    label129:
    for (paramView = (TextView)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.setTextSize(1, f);
      }
      this.wcv.setOnClickListener(new g..ExternalSyntheticLambda0(parama));
      AppMethodBeat.o(282277);
      return;
    }
  }
  
  private static final void a(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    AppMethodBeat.i(282288);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$status");
    a.b.a(parama, a.c.NOP);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282288);
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(282343);
    s.u(paramRect, "drawingRect");
    s.u(paramArrayOfFloat, "validRect");
    s.u(paramList, "editItems");
    this.TYC.Znc = new enx();
    Object localObject = this.TYC.Znc;
    s.s(localObject, "editData.drawingRect");
    h.a(paramRect, (enx)localObject);
    this.TYC.Znf = new enx();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.TYC.Znf;
    s.s(paramArrayOfFloat, "editData.validRect");
    h.a(paramRect, paramArrayOfFloat);
    paramRect = this.TYC.Znd;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(p.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      jy localjy = new jy();
      localjy.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).NXP.value;
      localjy.YMl = w.aN(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).gKs().toByteArray());
      paramArrayOfFloat.add(localjy);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(282343);
  }
  
  public final void a(j paramj, String paramString, Rect paramRect1, Rect paramRect2, final Rect paramRect3, boolean paramBoolean, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(282382);
    s.u(paramj, "videoComposition");
    s.u(paramString, "editId");
    s.u(paramRect1, "previewRect");
    s.u(paramRect2, "fullscreenRect");
    s.u(paramRect3, "cropRect");
    s.u(paramb, "callback");
    Object localObject1 = this.oaV;
    Object localObject2;
    int i;
    int j;
    label525:
    label588:
    int k;
    if (localObject1 != null)
    {
      Object localObject3 = ((RecordConfigProvider)localObject1).oXZ;
      s.s(localObject3, "provider.videoParam");
      Object localObject4 = ((RecordConfigProvider)localObject1).NIe;
      s.s(localObject4, "provider.outputVideoPath");
      localObject1 = new afc();
      localObject2 = new VideoTransPara((VideoTransPara)localObject3);
      i = ((VideoTransPara)localObject2).width;
      j = (int)(i * (paramRect3.height() / paramRect3.width()));
      ((VideoTransPara)localObject2).width = i;
      ((VideoTransPara)localObject2).height = j;
      ((afc)localObject1).outputPath = ((String)localObject4);
      localObject4 = new enx();
      h.a(paramRect1, (enx)localObject4);
      paramRect1 = ah.aiuX;
      ((afc)localObject1).Znu = ((enx)localObject4);
      paramRect1 = f.TYz;
      ((afc)localObject1).HJN = f.a.TM(paramRect2.width());
      paramRect1 = f.TYz;
      ((afc)localObject1).HJO = f.a.TM(paramRect2.height());
      ((afc)localObject1).Znq = 1.0F;
      paramRect1 = new dzm();
      localObject4 = new enx();
      h.a(paramRect2, (enx)localObject4);
      ah localah = ah.aiuX;
      paramRect1.Zqq = ((enx)localObject4);
      localObject4 = f.TYz;
      paramRect1.nxO = f.a.TM(i);
      localObject4 = f.TYz;
      paramRect1.nxP = f.a.TM(paramRect2.height() * i / paramRect2.width());
      localObject4 = ah.aiuX;
      ((afc)localObject1).Znv = paramRect1;
      paramRect1 = new dzm();
      localObject4 = new enx();
      h.a(paramRect3, (enx)localObject4);
      localah = ah.aiuX;
      paramRect1.Zqq = ((enx)localObject4);
      localObject4 = f.TYz;
      paramRect1.nxO = f.a.TM(i);
      localObject4 = f.TYz;
      paramRect1.nxP = f.a.TM(i * paramRect3.height() / paramRect3.width());
      localObject4 = ah.aiuX;
      ((afc)localObject1).Znw = paramRect1;
      if (paramRect2.height() == paramRect3.height()) {
        ((afc)localObject1).Znv = ((afc)localObject1).Znw;
      }
      paramj.L(paramRect3);
      paramRect1 = f.TYz;
      f.a.a((VideoTransPara)localObject3, (afc)localObject1);
      localObject3 = (Iterable)paramj.TDz;
      paramRect1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if (((com.tencent.mm.videocomposition.b)localObject4).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label525;
          }
          paramRect1.add(localObject4);
          break;
        }
      }
      if (((List)paramRect1).size() != 1) {
        break label1640;
      }
      paramRect1 = ((Iterable)paramj.TDz).iterator();
      if (!paramRect1.hasNext()) {
        break label1481;
      }
      localObject3 = paramRect1.next();
      if (((com.tencent.mm.videocomposition.b)localObject3).type != 2) {
        break label1475;
      }
      i = 1;
      if (i == 0) {
        break label1479;
      }
      paramRect1 = (com.tencent.mm.videocomposition.b)localObject3;
      paramRect1 = MultiMediaVideoChecker.ObB.aTG(paramRect1.path);
      if ((paramRect1 != null) && (paramRect1.width > 0) && (paramRect1.height > 0) && (paramRect1.eGw > 0.0F))
      {
        if ((paramRect1.hYK != 0) && (paramRect1.hYK != 180)) {
          break label1503;
        }
        i = paramRect1.width;
        label660:
        if (((afc)localObject1).Znv.nxO > i)
        {
          localObject3 = ((afc)localObject1).Znv;
          localObject4 = f.TYz;
          ((dzm)localObject3).nxO = f.a.TM(i);
          localObject4 = f.TYz;
          ((dzm)localObject3).nxP = f.a.TM((int)(1.0D * paramRect2.height() / paramRect2.width() * ((dzm)localObject3).nxO));
          Log.i("MicroMsg.TimelineEditorRemuxPlugin", "update fullScreenConfig size:[" + ((dzm)localObject3).nxO + ", " + ((dzm)localObject3).nxP + ']');
        }
        if (((afc)localObject1).Znw.nxO > i)
        {
          localObject3 = ((afc)localObject1).Znw;
          localObject4 = f.TYz;
          ((dzm)localObject3).nxO = f.a.TM(i);
          localObject4 = f.TYz;
          ((dzm)localObject3).nxP = f.a.TM((int)(1.0D * paramRect3.height() / paramRect3.width() * ((dzm)localObject3).nxO));
          Log.i("MicroMsg.TimelineEditorRemuxPlugin", "update cropConfig size:[" + ((dzm)localObject3).nxO + ", " + ((dzm)localObject3).nxP + ']');
        }
        if ((paramRect1.hYK != 0) && (paramRect1.hYK != 180)) {
          break label1512;
        }
        j = paramRect1.height;
        label917:
        Log.i("MicroMsg.TimelineEditorRemuxPlugin", "fullscreenRect:" + paramRect2 + ", videoParam.width:" + ((VideoTransPara)localObject2).width + ", heightLimit:" + j);
        if (i > j)
        {
          k = Math.min(j, ((VideoTransPara)localObject2).width);
          if (paramRect2.height() >= k) {
            break label1521;
          }
          ((afc)localObject1).Znq = (k / ((afc)localObject1).Znv.nxP);
          Log.i("MicroMsg.TimelineEditorRemuxPlugin", s.X("[widescreen] update outputScale:", Float.valueOf(((afc)localObject1).Znq)));
        }
        label1033:
        if (Util.isNullOrNil("")) {
          break label1634;
        }
        i = 1;
        label1045:
        if (i != 0)
        {
          if (((afc)localObject1).audioBitrate > paramRect1.audioBitrate) {
            ((afc)localObject1).audioBitrate = paramRect1.audioBitrate;
          }
          if ((((afc)localObject1).audioSampleRate > paramRect1.audioSampleRate) && (paramRect1.audioSampleRate > 1000)) {
            ((afc)localObject1).audioSampleRate = paramRect1.audioSampleRate;
          }
        }
        ((afc)localObject1).fps = Math.min(((afc)localObject1).fps, (int)paramRect1.eGw);
        ((afc)localObject1).audioChannelCount = Math.min(paramRect1.audioChannelCount, 2);
      }
    }
    for (;;)
    {
      ((afc)localObject1).audioChannelCount = Math.min(((afc)localObject1).audioChannelCount, 2);
      Log.i("MicroMsg.TimelineEditorRemuxPlugin", "getExportConfig: fullTarget:[" + ((afc)localObject1).Znv.nxO + ", " + ((afc)localObject1).Znv.nxP + "] cropTarget:[" + ((afc)localObject1).Znw.nxO + ',' + ((afc)localObject1).Znw.nxP + "] audio:" + ((afc)localObject1).audioChannelCount + ',' + ((afc)localObject1).audioBitrate + ',' + ((afc)localObject1).audioSampleRate + ", cropRect:" + paramRect3);
      paramRect1 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.a(paramj, (afc)localObject1);
      paramRect1.editId = paramString;
      paramRect1.Uay = paramBoolean;
      paramRect1.TYC = this.TYC;
      CaptureDataManager.NHH.rnY.putByteArray("video_composition", paramRect1.toByteArray());
      paramString = (kotlin.g.a.b)new b(paramb, this, paramRect3);
      paramRect2 = h.e(paramRect1);
      paramRect2.start();
      paramRect3 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramj);
      paramb = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      paramRect3.a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
      paramRect3.aK((kotlin.g.a.b)paramRect2);
      paramb = paramj.jLW();
      paramRect3.mu(paramb.getWidth(), paramb.getHeight());
      paramRect3.bs(paramj.getPlayStart(), paramj.hQW());
      paramj = new Rect();
      h.a(paramRect1.TYB.Znv.Zqq, paramj);
      paramRect3.F(paramj);
      paramRect3.e(paramRect1.TYB.Znv.nxO, (kotlin.g.a.b)new g.c(paramRect2, paramString));
      AppMethodBeat.o(282382);
      return;
      label1475:
      i = 0;
      break label588;
      label1479:
      break;
      label1481:
      paramj = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
      AppMethodBeat.o(282382);
      throw paramj;
      label1503:
      i = paramRect1.height;
      break label660;
      label1512:
      j = paramRect1.width;
      break label917;
      label1521:
      paramRect2 = ((afc)localObject1).Znv;
      localObject2 = f.TYz;
      paramRect2.nxP = f.a.TM(k);
      paramRect2 = ((afc)localObject1).Znv;
      localObject2 = f.TYz;
      float f = k;
      paramRect2.nxO = f.a.TM((int)(i * f / j));
      Log.i("MicroMsg.TimelineEditorRemuxPlugin", "[widescreen] update fullScreenConfig size:[" + ((afc)localObject1).Znv.nxO + ", " + ((afc)localObject1).Znv.nxP + ']');
      break label1033;
      label1634:
      i = 0;
      break label1045;
      label1640:
      paramRect2 = (Iterable)paramj.TDz;
      paramRect1 = (Collection)new ArrayList();
      paramRect2 = paramRect2.iterator();
      label1727:
      while (paramRect2.hasNext())
      {
        localObject2 = paramRect2.next();
        if (((com.tencent.mm.videocomposition.b)localObject2).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1727;
          }
          paramRect1.add(localObject2);
          break;
        }
      }
      paramRect1 = (Iterable)paramRect1;
      label1806:
      if (!((Collection)paramRect1).isEmpty())
      {
        paramRect1 = paramRect1.iterator();
        label1756:
        if (paramRect1.hasNext())
        {
          paramRect2 = (com.tencent.mm.videocomposition.b)paramRect1.next();
          paramRect2 = MultiMediaVideoChecker.ObB.aTG(paramRect2.path);
          if ((paramRect2 != null) && (paramRect2.audioChannelCount == 1))
          {
            i = 1;
            if (i == 0) {
              break label1832;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1840;
        }
        ((afc)localObject1).audioChannelCount = 1;
        break;
        i = 0;
        break label1806;
        label1832:
        break label1756;
      }
      label1840:
      ((afc)localObject1).audioChannelCount = 2;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(kotlin.g.a.b<? super Boolean, ah> paramb, g paramg, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.g
 * JD-Core Version:    0.7.0.1
 */