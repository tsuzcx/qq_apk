package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewLanguageCheckTask;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "checkRes", "", "getCheckRes", "()I", "setCheckRes", "(I)V", "ratio", "", "getRatio", "()D", "setRatio", "(D)V", "checkWordsNeedTransByCGI", "", "squeezedList", "", "onGetCheckResult", "Lkotlin/Function0;", "isNeedTrans", "sampleArray", "", "targetLanguage", "([Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "isStringLegal", "", "needCheckStr", "squeezeList", "clearedList", "cellMaxLength", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  private final String TAG = "MicroMsg.WebViewLanguageCheckTask";
  public final Charset Xto = d.UTF_8;
  public double Xtp;
  public int Xtq = 1;
  
  public static boolean bmZ(String paramString)
  {
    AppMethodBeat.i(295697);
    int i = 0;
    while (i < 7)
    {
      String str = new String[] { "@", "＠", "¥", "©", "{{", "<%", "http" }[i];
      if (n.a((CharSequence)paramString, (CharSequence)str, true))
      {
        AppMethodBeat.o(295697);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(295697);
    return false;
  }
  
  public final void b(List<String> paramList, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(295716);
    if (paramList.size() > 1) {
      kotlin.a.p.a(paramList, (Comparator)new a());
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
      this.Xtq = new j().h(localLinkedList, LocaleUtil.getApplicationLanguage());
      if (this.Xtq == 0) {}
      for (double d = 1.0D;; d = 0.0D)
      {
        this.Xtp = d;
        Log.i(this.TAG, s.X("check ratio = ", Double.valueOf(this.Xtp)));
        parama.invoke();
        AppMethodBeat.o(295716);
        return;
      }
    }
  }
  
  public final List<String> ml(List<String> paramList)
  {
    AppMethodBeat.i(295706);
    List localList = (List)new ArrayList();
    String str = "";
    Iterator localIterator = paramList.iterator();
    paramList = str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      Object localObject = this.Xto;
      if (str == null)
      {
        paramList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(295706);
        throw paramList;
      }
      localObject = str.getBytes((Charset)localObject);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      if (localObject.length > 100)
      {
        localList.add(str);
      }
      else
      {
        str = paramList + ' ' + str;
        paramList = this.Xto;
        if (str == null)
        {
          paramList = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(295706);
          throw paramList;
        }
        localObject = str.getBytes(paramList);
        s.s(localObject, "(this as java.lang.String).getBytes(charset)");
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
      AppMethodBeat.o(295706);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(295739);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((String)paramT2).length()), (Comparable)Integer.valueOf(((String)paramT1).length()));
      AppMethodBeat.o(295739);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.p
 * JD-Core Version:    0.7.0.1
 */