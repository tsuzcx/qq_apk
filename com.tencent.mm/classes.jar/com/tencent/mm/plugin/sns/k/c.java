package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/statistics/RecordConfigProviderHelper;", "", "()V", "TAG", "", "defaultVideoProviderConfig", "", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getEditRecordConfigProvider", "inputPath", "maxRecordTime", "", "getRecordVideoConfigProvider", "filePath", "thumbPath", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-sns_release"})
public final class c
{
  public static final c KfL;
  
  static
  {
    AppMethodBeat.i(268338);
    KfL = new c();
    AppMethodBeat.o(268338);
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(268335);
    p.k(paramString1, "filePath");
    p.k(paramString2, "thumbPath");
    p.k(paramVideoTransPara, "videoParams");
    paramString1 = RecordConfigProvider.a(paramString1, paramString2, paramVideoTransPara, paramInt, 2);
    p.j(paramString1, "provider");
    m(paramString1);
    AppMethodBeat.o(268335);
    return paramString1;
  }
  
  public static void m(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(268336);
    paramRecordConfigProvider.scene = 2;
    b localb = b.KfK;
    b.l(paramRecordConfigProvider);
    AppMethodBeat.o(268336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.c
 * JD-Core Version:    0.7.0.1
 */