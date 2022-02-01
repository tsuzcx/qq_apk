package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.SnsPublishProcessStruct;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/statistics/SnsPublishProcessReport;", "", "()V", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a QFO;
  private static boolean QFP;
  
  static
  {
    AppMethodBeat.i(306508);
    QFO = new a((byte)0);
    AppMethodBeat.o(306508);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/statistics/SnsPublishProcessReport$Companion;", "", "()V", "AT_CAMERA_PAGE", "", "AT_DELETE_RES", "AT_HOME_PAGE", "AT_NOTIFY_PAGE", "AT_PICKER_PAGE", "AT_POI_PAGE", "AT_PREVIEW_PAGE", "AT_PRIVATE_PAGE", "AT_RECORD_EIDT_PAGE", "FROM_PAGE_TIGER2022_LIVE", "FROM_PAGE_TIMELINE", "FROM_PAGE_USER", "MEDIA_SOURCE_CAMERA", "MEDIA_SOURCE_OTHER", "MEDIA_SOURCE_PHOTO", "SNS_PUBLISH_PROCESS", "", "SOURCE_TYPE_DRAFT", "", "SOURCE_TYPE_PHOTO", "SOURCE_TYPE_POPULARIZE", "SOURCE_TYPE_REEDIT", "SOURCE_TYPE_SHARE", "SOURCE_TYPE_TAKE_CAPTURE", "SOURCE_TYPE_TEXT", "SOURCE_TYPE_TIGER2022", "isDraft", "", "()Z", "setDraft", "(Z)V", "addTraceFromRequestCode", "", "requestCode", "addTraceFromUIAction", "doReport", "localId", "firstIntoEditPage", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "firstIntoEditPageVideo", "isCapture", "fromPage", "activity", "Landroid/app/Activity;", "fromTiger2022Live", "getCaptureCount", "getSecData", "Lcom/tencent/mm/plugin/sns/snstimeline/SnsPostCgiReportObj;", "id", "intoHomePage", "isCameraPic", "path", "reportNetPost", "snsPostCgiReportObj", "err", "setMediaSource", "paths", "", "Lcom/tencent/mm/plugin/sns/data/SnsUploadElment;", "setMediaSourceSight", "sourceType", "videoPath", "setSource", "shareType", "isPhoto", "isFromReEdit", "isManu", "isThirdApp", "isSecond", "isTiger2022", "testStaticKvStat", "updateWithSave", "obj", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(int paramInt1, f paramf, int paramInt2)
    {
      AppMethodBeat.i(306545);
      kotlin.g.b.s.u(paramf, "snsPostCgiReportObj");
      paramf.QCH = Util.append(paramf.QCH, String.valueOf(paramInt2), "#");
      paramf.QCG += 1;
      a(paramf);
      e.xfd.a("SnsPublishProcess", "opresult_", Integer.valueOf(6), com.tencent.mm.plugin.comm.b.c.xeS);
      aZm(String.valueOf(paramInt1));
      AppMethodBeat.o(306545);
    }
    
    public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
    {
      long l2 = 7L;
      AppMethodBeat.i(369892);
      long l1;
      if (paramBoolean6) {
        l1 = 10L;
      }
      for (;;)
      {
        e.xfd.f("SnsPublishProcess", "source_", Long.valueOf(l1));
        AppMethodBeat.o(369892);
        return;
        if (h.hij())
        {
          l1 = 4L;
        }
        else
        {
          l1 = l2;
          if (!paramBoolean5) {
            if (paramBoolean3)
            {
              l1 = 6L;
            }
            else if (paramBoolean1)
            {
              l1 = 1L;
            }
            else if (paramBoolean2)
            {
              l1 = 2L;
            }
            else if ((paramInt == 9) || (paramInt == 8))
            {
              l1 = 3L;
            }
            else if (paramInt == 14)
            {
              l1 = l2;
              if (!paramBoolean4) {}
            }
            else
            {
              l1 = 5L;
            }
          }
        }
      }
    }
    
    public static void a(f paramf)
    {
      AppMethodBeat.i(306558);
      kotlin.g.b.s.u(paramf, "obj");
      i.b(paramf);
      AppMethodBeat.o(306558);
    }
    
    public static boolean aZl(String paramString)
    {
      AppMethodBeat.i(306516);
      kotlin.g.b.s.u(paramString, "path");
      boolean bool = n.a((CharSequence)paramString, (CharSequence)"photoEdited_", false);
      AppMethodBeat.o(306516);
      return bool;
    }
    
    public static void aZm(String paramString)
    {
      AppMethodBeat.i(306537);
      Object localObject;
      if (paramString != null)
      {
        paramString = aZn(paramString);
        e.xfd.f("SnsPublishProcess", "cgiReconnectCnt", Integer.valueOf(paramString.QCG));
        if (!Util.isNullOrNil(paramString.QCH))
        {
          localObject = e.xfd;
          String str = paramString.QCH;
          kotlin.g.b.s.s(str, "snsPostCgiReportObj.cgiresult");
          ((e.a)localObject).f("SnsPublishProcess", "cgiresult", str);
        }
        e.xfd.f("SnsPublishProcess", "returnDuration", Integer.valueOf((int)(cn.bDv() - paramString.QCI)));
      }
      paramString = e.xfd;
      if (e.a.amq("SnsPublishProcess") == null)
      {
        paramString = e.xfd;
        paramString = ai.cz(SnsPublishProcessStruct.class).klu();
        kotlin.g.b.s.checkNotNull(paramString);
        e.a.gt("SnsPublishProcess", paramString);
        paramString = t.heR();
        localObject = e.xfd;
        kotlin.g.b.s.s(paramString, "sessionId");
        ((e.a)localObject).f("SnsPublishProcess", "sessionid_", paramString);
        localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("moment_sessionid_", paramString);
      }
      e.a.a(e.xfd, "SnsPublishProcess");
      AppMethodBeat.o(306537);
    }
    
    public static f aZn(String paramString)
    {
      AppMethodBeat.i(306553);
      kotlin.g.b.s.u(paramString, "id");
      f localf = (f)((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).getWithoutClearSync(16, paramString, f.class);
      if (localf == null)
      {
        localf = new f();
        localf.hHB = paramString;
        ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).updateWithSave(16, paramString, (com.tencent.mm.bx.a)localf, null);
      }
      for (paramString = localf;; paramString = localf)
      {
        AppMethodBeat.o(306553);
        return paramString;
      }
    }
    
    public static void bC(ArrayList<String> paramArrayList)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(306524);
      kotlin.g.b.s.u(paramArrayList, "imageList");
      e.a locala = e.xfd;
      if (!Util.isNullOrNil((List)paramArrayList))
      {
        Iterator localIterator = ((Iterable)paramArrayList).iterator();
        j = i;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a locala1 = h.QFO;
          if (!aZl(str)) {
            break label124;
          }
          i += 1;
        }
      }
      label124:
      for (;;)
      {
        break;
        locala.f("SnsPublishProcess", "firstEditPageShotMedia", Integer.valueOf(j));
        e.xfd.f("SnsPublishProcess", "firstEditPageMedia", Integer.valueOf(paramArrayList.size()));
        AppMethodBeat.o(306524);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      extends u
      implements kotlin.g.a.a<Object>
    {
      public a(List<? extends com.tencent.mm.plugin.sns.data.s> paramList)
      {
        super();
      }
      
      public final Object invoke()
      {
        AppMethodBeat.i(306500);
        Object localObject2 = new StringBuilder("");
        Object localObject1 = new StringBuilder("");
        int i = 0;
        Object localObject3 = ((Iterable)this.QFQ).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.mm.plugin.sns.data.s locals = (com.tencent.mm.plugin.sns.data.s)((Iterator)localObject3).next();
          if (!locals.Qol)
          {
            Object localObject4 = h.QFO;
            localObject4 = locals.path;
            kotlin.g.b.s.s(localObject4, "it.path");
            if (!h.a.aZl((String)localObject4)) {}
          }
          else
          {
            i += 1;
          }
          for (int j = 1;; j = 2)
          {
            if (!kotlin.g.b.s.p(((StringBuilder)localObject2).toString(), "")) {
              break label146;
            }
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject1).append(com.tencent.mm.b.g.getMD5(locals.path));
            break;
          }
          label146:
          ((StringBuilder)localObject2).append(kotlin.g.b.s.X("#", Integer.valueOf(j)));
          ((StringBuilder)localObject1).append(kotlin.g.b.s.X("#", com.tencent.mm.b.g.getMD5(locals.path)));
        }
        localObject3 = e.xfd;
        localObject2 = ((StringBuilder)localObject2).toString();
        kotlin.g.b.s.s(localObject2, "mediaSource.toString()");
        ((e.a)localObject3).f("SnsPublishProcess", "mediaSource_", localObject2);
        e.xfd.f("SnsPublishProcess", "endSessionShotMedia", Integer.valueOf(i));
        e.xfd.f("SnsPublishProcess", "endSessionMedia", Integer.valueOf(this.QFQ.size()));
        localObject1 = ((StringBuilder)localObject1).toString();
        kotlin.g.b.s.s(localObject1, "md5.toString()");
        AppMethodBeat.o(306500);
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.h
 * JD-Core Version:    0.7.0.1
 */