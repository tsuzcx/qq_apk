package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewLanguageCheckTask;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "checkRes", "", "getCheckRes", "()I", "setCheckRes", "(I)V", "ratio", "", "getRatio", "()D", "setRatio", "(D)V", "checkWordsNeedTransByCGI", "", "squeezedList", "", "onGetCheckResult", "Lkotlin/Function0;", "isNeedTrans", "sampleArray", "", "targetLanguage", "([Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "isStringLegal", "", "needCheckStr", "squeezeList", "clearedList", "cellMaxLength", "plugin-webview_release"})
public final class l
{
  public final Charset QAh = d.UTF_8;
  public double QAi;
  public int QAj = 1;
  private final String TAG = "MicroMsg.WebViewLanguageCheckTask";
  
  public static boolean bnn(String paramString)
  {
    AppMethodBeat.i(222510);
    int i = 0;
    while (i < 7)
    {
      String str = new String[] { "@", "＠", "¥", "©", "{{", "<%", "http" }[i];
      if (n.a((CharSequence)paramString, (CharSequence)str, true))
      {
        AppMethodBeat.o(222510);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(222510);
    return false;
  }
  
  public final void a(List<String> paramList, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(222537);
    if (paramList.size() > 1) {
      kotlin.a.j.a(paramList, (Comparator)new a());
    }
    if (((Collection)paramList).size() > 10) {
      paramList = paramList.subList(0, 10);
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localLinkedList.add((String)paramList.next());
      }
      this.QAj = new com.tencent.mm.plugin.webview.model.j().i(localLinkedList, LocaleUtil.getApplicationLanguage());
      if (this.QAj == 0) {}
      for (double d = 1.0D;; d = 0.0D)
      {
        this.QAi = d;
        Log.i(this.TAG, "check ratio = " + this.QAi);
        parama.invoke();
        AppMethodBeat.o(222537);
        return;
      }
    }
  }
  
  public final List<String> jc(List<String> paramList)
  {
    AppMethodBeat.i(222525);
    List localList = (List)new ArrayList();
    String str = "";
    Iterator localIterator = paramList.iterator();
    paramList = str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      Object localObject = this.QAh;
      if (str == null)
      {
        paramList = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(222525);
        throw paramList;
      }
      localObject = str.getBytes((Charset)localObject);
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      if (localObject.length > 100)
      {
        localList.add(str);
      }
      else
      {
        str = paramList + ' ' + str;
        paramList = this.QAh;
        if (str == null)
        {
          paramList = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(222525);
          throw paramList;
        }
        localObject = str.getBytes(paramList);
        p.j(localObject, "(this as java.lang.String).getBytes(charset)");
        paramList = str;
        if (localObject.length > 100)
        {
          localList.add(str);
          paramList = "";
        }
      }
    }
    if (((CharSequence)paramList).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localList.add(paramList);
      }
      AppMethodBeat.o(222525);
      return localList;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(249625);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((String)paramT2).length()), (Comparable)Integer.valueOf(((String)paramT1).length()));
      AppMethodBeat.o(249625);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.l
 * JD-Core Version:    0.7.0.1
 */