package com.tencent.mm.plugin.sns.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/template/SnsTemplateExptConfig;", "", "()V", "TAG", "", "getPublishTemplateEntrance", "", "getPublishTemplateMediaNum", "", "getPublishTemplateMediaTotalDurationLimitSeconds", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QZO;
  
  static
  {
    AppMethodBeat.i(306332);
    QZO = new a();
    AppMethodBeat.o(306332);
  }
  
  public static int hlp()
  {
    AppMethodBeat.i(306327);
    int i = ((c)h.ax(c.class)).a(c.a.yMg, 20);
    Log.i("MicroMsg.SnsTemplateExptConfig", s.X("getPublishTemplateMediaNum: ", Integer.valueOf(i)));
    AppMethodBeat.o(306327);
    return i;
  }
  
  public static int hlq()
  {
    AppMethodBeat.i(306330);
    int i = ((c)h.ax(c.class)).a(c.a.yMh, 600);
    Log.i("MicroMsg.SnsTemplateExptConfig", s.X("getPublishTemplateMediaTotalDurationLimitSeconds: ", Integer.valueOf(i)));
    AppMethodBeat.o(306330);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.m.a
 * JD-Core Version:    0.7.0.1
 */