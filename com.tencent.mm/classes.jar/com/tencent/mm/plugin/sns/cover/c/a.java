package com.tencent.mm.plugin.sns.cover.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nq;
import com.tencent.mm.plugin.sns.cover.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/report/SnsCoverPageReporter;", "Lcom/tencent/mm/plugin/sns/cover/api/ISnsCoverReporter;", "()V", "enterIsLiked", "", "snsCoverReport", "Lcom/tencent/mm/autogen/mmdata/rpt/SnsCoverReportStruct;", "addCoverInfo", "", "info", "", "addFinderInfo", "addImageInfo", "addVideoInfo", "markFirstFrameLoad", "markFirstPlay", "markFold", "markIsLocal", "local", "markLikeClick", "like", "(Ljava/lang/Boolean;)V", "markPageIn", "coverInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsCover;", "isTimeline", "markPageOut", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public nq Qml;
  public boolean Qmm;
  
  public final void DA(boolean paramBoolean)
  {
    nq localnq = this.Qml;
    if (localnq != null) {
      if (!paramBoolean) {
        break label21;
      }
    }
    label21:
    for (int i = 1;; i = -1)
    {
      localnq.jfD = i;
      return;
    }
  }
  
  public final void DB(boolean paramBoolean)
  {
    AppMethodBeat.i(307348);
    Object localObject = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    if (com.tencent.mm.plugin.sns.cover.b.a.hew())
    {
      localObject = this.Qml;
      if (localObject != null) {
        if (!paramBoolean) {
          break label71;
        }
      }
    }
    label71:
    for (int i = 1;; i = 2)
    {
      ((nq)localObject).imW = i;
      localObject = this.Qml;
      if (localObject != null) {
        ((nq)localObject).ioz = System.currentTimeMillis();
      }
      localObject = this.Qml;
      if (localObject != null) {
        ((nq)localObject).bMH();
      }
      AppMethodBeat.o(307348);
      return;
    }
  }
  
  public final void aWY(String paramString)
  {
    AppMethodBeat.i(307328);
    s.u(paramString, "info");
    nq localnq = this.Qml;
    if (localnq != null) {
      localnq.jfB = localnq.F("VideoInfo", n.m(paramString, ",", ";", false), true);
    }
    AppMethodBeat.o(307328);
  }
  
  public final void aWZ(String paramString)
  {
    AppMethodBeat.i(307330);
    s.u(paramString, "info");
    nq localnq = this.Qml;
    if (localnq != null) {
      localnq.jfC = localnq.F("FinderInfo", n.m(paramString, ",", ";", false), true);
    }
    AppMethodBeat.o(307330);
  }
  
  public final void aXa(String paramString)
  {
    AppMethodBeat.i(307322);
    s.u(paramString, "info");
    nq localnq = this.Qml;
    if (localnq != null) {
      localnq.jfA = localnq.F("ImageInfo", n.m(paramString, ",", ";", false), true);
    }
    AppMethodBeat.o(307322);
  }
  
  public final void hep()
  {
    AppMethodBeat.i(307341);
    nq localnq = this.Qml;
    if (localnq == null) {}
    for (long l = 0L;; l = localnq.jfK)
    {
      if (l <= 0L)
      {
        localnq = this.Qml;
        if (localnq != null) {
          localnq.jfK = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(307341);
      return;
    }
  }
  
  public final void heq()
  {
    AppMethodBeat.i(307344);
    nq localnq = this.Qml;
    if (localnq == null) {}
    for (long l = 0L;; l = localnq.ioy)
    {
      if (l <= 0L)
      {
        localnq = this.Qml;
        if (localnq != null) {
          localnq.ioy = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(307344);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.c.a
 * JD-Core Version:    0.7.0.1
 */