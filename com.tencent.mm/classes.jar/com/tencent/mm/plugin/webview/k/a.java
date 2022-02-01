package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import d.g.a.m;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"forEachIndexed", "", "Lcom/tencent/mm/json/JSONArray;", "block", "Lkotlin/Function2;", "", "htmlEncode", "", "kotlin.jvm.PlatformType", "map", "", "T", "toJsString", "webview-sdk_release"})
public final class a
{
  public static final <T> List<T> a(com.tencent.mm.ab.f paramf, m<? super Integer, ? super com.tencent.mm.ab.f, ? extends T> paramm)
  {
    AppMethodBeat.i(82768);
    k.h(paramf, "$this$map");
    k.h(paramm, "block");
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j = paramf.length();
    while (i < j)
    {
      localLinkedList.add(paramm.n(Integer.valueOf(i), paramf));
      i += 1;
    }
    paramf = (List)localLinkedList;
    AppMethodBeat.o(82768);
    return paramf;
  }
  
  public static final String aEe(String paramString)
  {
    AppMethodBeat.i(82770);
    k.h(paramString, "$this$toJsString");
    paramString = "'" + org.apache.commons.b.f.aXq(paramString) + '\'';
    AppMethodBeat.o(82770);
    return paramString;
  }
  
  public static final String htmlEncode(String paramString)
  {
    AppMethodBeat.i(82769);
    k.h(paramString, "$this$htmlEncode");
    paramString = p.encode(paramString, "UTF-8");
    AppMethodBeat.o(82769);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.a
 * JD-Core Version:    0.7.0.1
 */