package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/statistics/RecordConfigProviderHelper;", "", "()V", "TAG", "", "defaultVideoProviderConfig", "", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getEditRecordConfigProvider", "inputPath", "maxRecordTime", "", "getRecordVideoConfigProvider", "filePath", "thumbPath", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d QDv;
  
  static
  {
    AppMethodBeat.i(306507);
    QDv = new d();
    AppMethodBeat.o(306507);
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(306499);
    s.u(paramString1, "filePath");
    s.u(paramString2, "thumbPath");
    s.u(paramVideoTransPara, "videoParams");
    paramString1 = RecordConfigProvider.a(paramString1, paramString2, paramVideoTransPara, paramInt, 2);
    s.s(paramString1, "provider");
    s(paramString1);
    AppMethodBeat.o(306499);
    return paramString1;
  }
  
  public static void s(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(306505);
    paramRecordConfigProvider.scene = 2;
    b localb = b.QDt;
    b.r(paramRecordConfigProvider);
    AppMethodBeat.o(306505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.d
 * JD-Core Version:    0.7.0.1
 */