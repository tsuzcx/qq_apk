package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$ResultState;", "", "(Ljava/lang/String;I)V", "RESULT_STATE_DOWNLOADING", "RESULT_STATE_ERROR", "RESULT_STATE_COMPLETE", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$a
{
  static
  {
    AppMethodBeat.i(311124);
    Qad = new a("RESULT_STATE_DOWNLOADING", 0);
    Qae = new a("RESULT_STATE_ERROR", 1);
    Qaf = new a("RESULT_STATE_COMPLETE", 2);
    Qag = new a[] { Qad, Qae, Qaf };
    AppMethodBeat.o(311124);
  }
  
  private a$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a.a
 * JD-Core Version:    0.7.0.1
 */