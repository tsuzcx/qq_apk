package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "finishBtn", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editData", "Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getEditData", "()Lcom/tencent/mm/protocal/protobuf/CompositionEditInfo;", "getFinishBtn", "()Landroid/view/View;", "setFinishBtn", "(Landroid/view/View;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEditInfo", "", "drawingRect", "Landroid/graphics/Rect;", "validRect", "", "editItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "chooseExportConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "previewRect", "fullscreenRect", "cropRect", "path", "", "musicPath", "enableAdaptiveBitrate", "", "exportVideo", "videoComposition", "enableVideoEnhancement", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "initLogic", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "saveThumbBitmap", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "Landroid/graphics/Bitmap;", "bitmap", "toString", "Lcom/tencent/mm/protocal/protobuf/OutputConfig;", "Companion", "plugin-vlog_release"})
public final class g
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a NEi;
  public RecordConfigProvider ALV;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private final act NkY;
  private Context context;
  private View sYa;
  
  static
  {
    AppMethodBeat.i(236005);
    NEi = new a((byte)0);
    AppMethodBeat.o(236005);
  }
  
  public g(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(236002);
    this.sYa = paramView;
    this.APl = paramd;
    this.context = this.sYa.getContext();
    this.NkY = new act();
    this.sYa.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229804);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.b.a(this.NEj.APl, d.c.HSj);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229804);
      }
    });
    AppMethodBeat.o(236002);
  }
  
  public final void a(Rect paramRect, float[] paramArrayOfFloat, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(235991);
    p.k(paramRect, "drawingRect");
    p.k(paramArrayOfFloat, "validRect");
    p.k(paramList, "editItems");
    this.NkY.Soq = new duz();
    Object localObject = this.NkY.Soq;
    p.j(localObject, "editData.drawingRect");
    i.a(paramRect, (duz)localObject);
    this.NkY.Sot = new duz();
    paramRect = new Rect((int)paramArrayOfFloat[0], (int)paramArrayOfFloat[1], (int)paramArrayOfFloat[2], (int)paramArrayOfFloat[3]);
    paramArrayOfFloat = this.NkY.Sot;
    p.j(paramArrayOfFloat, "editData.validRect");
    i.a(paramRect, paramArrayOfFloat);
    paramRect = this.NkY.Sor;
    paramList = (Iterable)paramList;
    paramArrayOfFloat = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
      jc localjc = new jc();
      localjc.dataType = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).Ibt.value;
      localjc.ROY = z.aN(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).fyG().toByteArray());
      paramArrayOfFloat.add(localjc);
    }
    paramRect.addAll((Collection)paramArrayOfFloat);
    AppMethodBeat.o(235991);
  }
  
  public final void a(final com.tencent.mm.videocomposition.j paramj, final Rect paramRect1, final Rect paramRect2, final Rect paramRect3, final boolean paramBoolean, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(235999);
    p.k(paramj, "videoComposition");
    p.k(paramRect1, "previewRect");
    p.k(paramRect2, "fullscreenRect");
    p.k(paramRect3, "cropRect");
    p.k(paramb, "callback");
    Object localObject1 = this.ALV;
    if (localObject1 != null)
    {
      Object localObject3 = ((RecordConfigProvider)localObject1).mfk;
      p.j(localObject3, "provider.videoParam");
      Object localObject4 = ((RecordConfigProvider)localObject1).HLg;
      p.j(localObject4, "provider.outputVideoPath");
      localObject1 = new acv();
      Object localObject2 = new VideoTransPara((VideoTransPara)localObject3);
      int i = ((VideoTransPara)localObject2).width;
      int j = (int)(i * (paramRect3.height() / paramRect3.width()));
      ((VideoTransPara)localObject2).width = i;
      ((VideoTransPara)localObject2).height = j;
      ((acv)localObject1).uVk = ((String)localObject4);
      localObject4 = new duz();
      i.a(paramRect1, (duz)localObject4);
      ((acv)localObject1).SoI = ((duz)localObject4);
      localObject4 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((acv)localObject1).BXA = com.tencent.mm.plugin.vlog.model.g.a.QC(paramRect2.width());
      localObject4 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((acv)localObject1).BXB = com.tencent.mm.plugin.vlog.model.g.a.QC(paramRect2.height());
      ((acv)localObject1).SoE = 1.0F;
      localObject4 = new dhd();
      Object localObject5 = new duz();
      i.a(paramRect2, (duz)localObject5);
      ((dhd)localObject4).Sro = ((duz)localObject5);
      localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((dhd)localObject4).targetWidth = com.tencent.mm.plugin.vlog.model.g.a.QC(i);
      localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((dhd)localObject4).targetHeight = com.tencent.mm.plugin.vlog.model.g.a.QC(paramRect2.height() * i / paramRect2.width());
      ((acv)localObject1).SoJ = ((dhd)localObject4);
      localObject4 = new dhd();
      localObject5 = new duz();
      i.a(paramRect3, (duz)localObject5);
      ((dhd)localObject4).Sro = ((duz)localObject5);
      localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((dhd)localObject4).targetWidth = com.tencent.mm.plugin.vlog.model.g.a.QC(i);
      localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      ((dhd)localObject4).targetHeight = com.tencent.mm.plugin.vlog.model.g.a.QC(i * paramRect3.height() / paramRect3.width());
      ((acv)localObject1).SoK = ((dhd)localObject4);
      if (paramRect2.height() == paramRect3.height()) {
        ((acv)localObject1).SoJ = ((acv)localObject1).SoK;
      }
      paramj.D(paramRect3);
      localObject4 = com.tencent.mm.plugin.vlog.model.g.Nlc;
      com.tencent.mm.plugin.vlog.model.g.a.a((VideoTransPara)localObject3, (acv)localObject1);
      localObject4 = (Iterable)paramj.MQY;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label502:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        if (((com.tencent.mm.videocomposition.b)localObject5).type == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label502;
          }
          ((Collection)localObject3).add(localObject5);
          break;
        }
      }
      label569:
      int k;
      if (((List)localObject3).size() == 1)
      {
        localObject3 = ((Iterable)paramj.MQY).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((com.tencent.mm.videocomposition.b)localObject4).type == 2)
          {
            i = 1;
            if (i == 0) {
              break label1521;
            }
            localObject3 = (com.tencent.mm.videocomposition.b)localObject4;
            localObject3 = MultiMediaVideoChecker.NmA.bfs(((com.tencent.mm.videocomposition.b)localObject3).path);
            if ((localObject3 != null) && (((MultiMediaVideoChecker.a)localObject3).width > 0) && (((MultiMediaVideoChecker.a)localObject3).height > 0) && (((MultiMediaVideoChecker.a)localObject3).cLa > 0.0F))
            {
              if ((((MultiMediaVideoChecker.a)localObject3).fSM != 0) && (((MultiMediaVideoChecker.a)localObject3).fSM != 180)) {
                break label1545;
              }
              i = ((MultiMediaVideoChecker.a)localObject3).width;
              label651:
              if (((acv)localObject1).SoJ.targetWidth > i)
              {
                localObject4 = ((acv)localObject1).SoJ;
                localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
                ((dhd)localObject4).targetWidth = com.tencent.mm.plugin.vlog.model.g.a.QC(i);
                localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
                ((dhd)localObject4).targetHeight = com.tencent.mm.plugin.vlog.model.g.a.QC((int)(1.0D * paramRect2.height() / paramRect2.width() * ((dhd)localObject4).targetWidth));
                Log.i("MicroMsg.TimelineEditorRemuxPlugin", "update fullScreenConfig size:[" + ((dhd)localObject4).targetWidth + ", " + ((dhd)localObject4).targetHeight + ']');
              }
              if (((acv)localObject1).SoK.targetWidth > i)
              {
                localObject4 = ((acv)localObject1).SoK;
                localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
                ((dhd)localObject4).targetWidth = com.tencent.mm.plugin.vlog.model.g.a.QC(i);
                localObject5 = com.tencent.mm.plugin.vlog.model.g.Nlc;
                ((dhd)localObject4).targetHeight = com.tencent.mm.plugin.vlog.model.g.a.QC((int)(1.0D * paramRect3.height() / paramRect3.width() * ((dhd)localObject4).targetWidth));
                Log.i("MicroMsg.TimelineEditorRemuxPlugin", "update cropConfig size:[" + ((dhd)localObject4).targetWidth + ", " + ((dhd)localObject4).targetHeight + ']');
              }
              if ((((MultiMediaVideoChecker.a)localObject3).fSM != 0) && (((MultiMediaVideoChecker.a)localObject3).fSM != 180)) {
                break label1555;
              }
              j = ((MultiMediaVideoChecker.a)localObject3).height;
              label909:
              Log.i("MicroMsg.TimelineEditorRemuxPlugin", "fullscreenRect:" + paramRect2 + ", videoParam.width:" + ((VideoTransPara)localObject2).width + ", heightLimit:" + j);
              if (i > j)
              {
                k = Math.min(j, ((VideoTransPara)localObject2).width);
                if (paramRect2.height() >= k) {
                  break label1565;
                }
                ((acv)localObject1).SoE = (k / ((acv)localObject1).SoJ.targetHeight);
                Log.i("MicroMsg.TimelineEditorRemuxPlugin", "[widescreen] update outputScale:" + ((acv)localObject1).SoE);
              }
              label1030:
              if (Util.isNullOrNil("")) {
                break label1678;
              }
              i = 1;
              label1042:
              if (i != 0)
              {
                if (((acv)localObject1).audioBitrate > ((MultiMediaVideoChecker.a)localObject3).audioBitrate) {
                  ((acv)localObject1).audioBitrate = ((MultiMediaVideoChecker.a)localObject3).audioBitrate;
                }
                if ((((acv)localObject1).audioSampleRate > ((MultiMediaVideoChecker.a)localObject3).audioSampleRate) && (((MultiMediaVideoChecker.a)localObject3).audioSampleRate > 1000)) {
                  ((acv)localObject1).audioSampleRate = ((MultiMediaVideoChecker.a)localObject3).audioSampleRate;
                }
              }
              ((acv)localObject1).fps = Math.min(((acv)localObject1).fps, (int)((MultiMediaVideoChecker.a)localObject3).cLa);
              ((acv)localObject1).audioChannelCount = Math.min(((MultiMediaVideoChecker.a)localObject3).audioChannelCount, 2);
            }
          }
        }
      }
      for (;;)
      {
        ((acv)localObject1).audioChannelCount = Math.min(((acv)localObject1).audioChannelCount, 2);
        Log.i("MicroMsg.TimelineEditorRemuxPlugin", "getExportConfig: fullTarget:[" + ((acv)localObject1).SoJ.targetWidth + ", " + ((acv)localObject1).SoJ.targetHeight + "] cropTarget:[" + ((acv)localObject1).SoK.targetWidth + ',' + ((acv)localObject1).SoK.targetHeight + ']' + " audio:" + ((acv)localObject1).audioChannelCount + ',' + ((acv)localObject1).audioBitrate + ',' + ((acv)localObject1).audioSampleRate + ", cropRect:" + paramRect3);
        localObject1 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.a(paramj, (acv)localObject1);
        ((acu)localObject1).NmV = paramBoolean;
        ((acu)localObject1).NkY = this.NkY;
        localObject2 = CaptureDataManager.HKJ;
        p.j(localObject2, "CaptureDataManager.INSTANCE");
        ((CaptureDataManager)localObject2).getExtData().putByteArray("video_composition", ((acu)localObject1).toByteArray());
        paramRect1 = (kotlin.g.a.b)new b(this, paramj, paramRect1, paramRect2, paramRect3, paramBoolean, paramb);
        paramRect2 = i.c((acu)localObject1);
        paramRect2.start();
        paramRect3 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramj);
        paramb = com.tencent.mm.plugin.vlog.model.local.a.Nol;
        paramRect3.a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
        paramRect3.aa((kotlin.g.a.b)paramRect2);
        paramb = paramj.igI();
        paramRect3.kH(paramb.getWidth(), paramb.getHeight());
        paramRect3.aG(paramj.getPlayStart(), paramj.gtw());
        paramb = new Rect();
        localObject2 = ((acu)localObject1).NkX.SoJ.Sro;
        p.j(localObject2, "compositionInfo.outputCo…fullScreenConfig.cropRect");
        i.a((duz)localObject2, paramb);
        paramRect3.x(paramb);
        paramRect3.d(((acu)localObject1).NkX.SoJ.targetWidth, (kotlin.g.a.b)new c(paramRect2, paramj, (acu)localObject1, paramRect1));
        AppMethodBeat.o(235999);
        return;
        i = 0;
        break label569;
        label1521:
        break;
        paramj = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
        AppMethodBeat.o(235999);
        throw paramj;
        label1545:
        i = ((MultiMediaVideoChecker.a)localObject3).height;
        break label651;
        label1555:
        j = ((MultiMediaVideoChecker.a)localObject3).width;
        break label909;
        label1565:
        localObject2 = ((acv)localObject1).SoJ;
        localObject4 = com.tencent.mm.plugin.vlog.model.g.Nlc;
        ((dhd)localObject2).targetHeight = com.tencent.mm.plugin.vlog.model.g.a.QC(k);
        localObject2 = ((acv)localObject1).SoJ;
        localObject4 = com.tencent.mm.plugin.vlog.model.g.Nlc;
        float f = k;
        ((dhd)localObject2).targetWidth = com.tencent.mm.plugin.vlog.model.g.a.QC((int)(i * f / j));
        Log.i("MicroMsg.TimelineEditorRemuxPlugin", "[widescreen] update fullScreenConfig size:[" + ((acv)localObject1).SoJ.targetWidth + ", " + ((acv)localObject1).SoJ.targetHeight + ']');
        break label1030;
        label1678:
        i = 0;
        break label1042;
        localObject3 = (Iterable)paramj.MQY;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label1773:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (((com.tencent.mm.videocomposition.b)localObject4).type == 2) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1773;
            }
            ((Collection)localObject2).add(localObject4);
            break;
          }
        }
        localObject2 = (Iterable)localObject2;
        if (!((Collection)localObject2).isEmpty())
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label1807:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mm.videocomposition.b)((Iterator)localObject2).next();
            localObject3 = MultiMediaVideoChecker.NmA.bfs(((com.tencent.mm.videocomposition.b)localObject3).path);
            if ((localObject3 != null) && (((MultiMediaVideoChecker.a)localObject3).audioChannelCount == 1))
            {
              i = 1;
              label1859:
              if (i == 0) {
                break label1885;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1893;
          }
          ((acv)localObject1).audioChannelCount = 1;
          break;
          i = 0;
          break label1859;
          label1885:
          break label1807;
        }
        label1893:
        ((acv)localObject1).audioChannelCount = 2;
      }
    }
    AppMethodBeat.o(235999);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin$exportVideo$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    b(g paramg, com.tencent.mm.videocomposition.j paramj, Rect paramRect1, Rect paramRect2, Rect paramRect3, boolean paramBoolean, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorRemuxPlugin$saveThumbBitmap$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    c(c paramc, com.tencent.mm.videocomposition.j paramj, acu paramacu, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.g
 * JD-Core Version:    0.7.0.1
 */