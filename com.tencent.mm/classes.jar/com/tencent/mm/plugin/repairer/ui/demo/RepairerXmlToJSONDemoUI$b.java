package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cs.l;
import com.tencent.mm.cs.l.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class RepairerXmlToJSONDemoUI$b
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  RepairerXmlToJSONDemoUI$b(String paramString, kotlin.d.d<? super b> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(278356);
    paramObject = (kotlin.d.d)new b(this.nhk, paramd);
    AppMethodBeat.o(278356);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(278348);
    Object localObject = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(278348);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    for (;;)
    {
      try
      {
        paramObject = l.agZu;
        paramObject = l.a.bFf(this.nhk);
        if (paramObject != null) {
          continue;
        }
        paramObject = "";
        localObject = am.aixg;
        localObject = String.format("xml_to_json_" + cn.bDw() + ".txt", Arrays.copyOf(new Object[0], 0));
        s.s(localObject, "java.lang.String.format(format, *args)");
        com.tencent.mm.plugin.repairer.a locala = (com.tencent.mm.plugin.repairer.a)h.az(com.tencent.mm.plugin.repairer.a.class);
        paramObject = paramObject.getBytes(kotlin.n.d.UTF_8);
        s.s(paramObject, "(this as java.lang.String).getBytes(charset)");
        locala.saveRepairerFile((String)localObject, paramObject, true);
      }
      catch (Exception paramObject)
      {
        Log.printErrStackTrace("MicroMsg.Repairer.RepairerXmlToJSONDemo", (Throwable)paramObject, "xml_to_json", new Object[0]);
        continue;
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(278348);
      return paramObject;
      paramObject = paramObject.toString();
      if (paramObject == null) {
        paramObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerXmlToJSONDemoUI.b
 * JD-Core Version:    0.7.0.1
 */