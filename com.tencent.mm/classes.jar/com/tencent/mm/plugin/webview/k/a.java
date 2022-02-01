package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"forEachIndexed", "", "Lcom/tencent/mm/json/JSONArray;", "block", "Lkotlin/Function2;", "", "htmlEncode", "", "kotlin.jvm.PlatformType", "map", "", "T", "toJsString", "webview-sdk_release"})
public final class a
{
  public static final void a(com.tencent.mm.ab.f paramf, m<? super Integer, ? super com.tencent.mm.ab.f, z> paramm)
  {
    AppMethodBeat.i(214221);
    p.h(paramf, "$this$forEachIndexed");
    p.h(paramm, "block");
    int i = 0;
    int j = paramf.length();
    while (i < j)
    {
      paramm.p(Integer.valueOf(i), paramf);
      i += 1;
    }
    AppMethodBeat.o(214221);
  }
  
  public static final String aLc(String paramString)
  {
    AppMethodBeat.i(82770);
    p.h(paramString, "$this$toJsString");
    paramString = "'" + org.apache.commons.b.f.bfo(paramString) + '\'';
    AppMethodBeat.o(82770);
    return paramString;
  }
  
  public static final <T> List<T> b(com.tencent.mm.ab.f paramf, m<? super Integer, ? super com.tencent.mm.ab.f, ? extends T> paramm)
  {
    AppMethodBeat.i(82768);
    p.h(paramf, "$this$map");
    p.h(paramm, "block");
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j = paramf.length();
    while (i < j)
    {
      localLinkedList.add(paramm.p(Integer.valueOf(i), paramf));
      i += 1;
    }
    paramf = (List)localLinkedList;
    AppMethodBeat.o(82768);
    return paramf;
  }
  
  public static final String htmlEncode(String paramString)
  {
    AppMethodBeat.i(82769);
    p.h(paramString, "$this$htmlEncode");
    paramString = q.encode(paramString, "UTF-8");
    AppMethodBeat.o(82769);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.a
 * JD-Core Version:    0.7.0.1
 */