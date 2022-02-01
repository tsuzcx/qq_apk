package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class RepairerXmlToJSONDemoUI$d
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  RepairerXmlToJSONDemoUI$d(String paramString, kotlin.d.d<? super d> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(278378);
    paramObject = (kotlin.d.d)new d(this.nhk, paramd);
    AppMethodBeat.o(278378);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(278370);
    Object localObject1 = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(278370);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    Object localObject2;
    try
    {
      localObject1 = XmlParser.parseXml(this.nhk, "msg", null);
      s.s(localObject1, "attrs");
      paramObject = (Collection)new ArrayList(((Map)localObject1).size());
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramObject.add(((Map.Entry)localObject2).getKey() + '[' + ((Map.Entry)localObject2).getValue() + ']');
        continue;
        paramObject = ah.aiuX;
      }
    }
    catch (Exception paramObject)
    {
      Log.printErrStackTrace("MicroMsg.Repairer.RepairerXmlToJSONDemo", (Throwable)paramObject, "mm_xml_parser", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(278370);
      return paramObject;
      paramObject = p.a((Iterable)paramObject, (CharSequence)"\n", null, null, 0, null, null, 62);
      localObject1 = am.aixg;
      localObject1 = String.format("MMXmlParser_" + cn.bDw() + ".txt", Arrays.copyOf(new Object[0], 0));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localObject2 = (com.tencent.mm.plugin.repairer.a)h.az(com.tencent.mm.plugin.repairer.a.class);
      Charset localCharset = kotlin.n.d.UTF_8;
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(278370);
        throw paramObject;
      }
      paramObject = paramObject.getBytes(localCharset);
      s.s(paramObject, "(this as java.lang.String).getBytes(charset)");
      ((com.tencent.mm.plugin.repairer.a)localObject2).saveRepairerFile((String)localObject1, paramObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerXmlToJSONDemoUI.d
 * JD-Core Version:    0.7.0.1
 */