package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.proto.ab;
import com.tencent.mm.plugin.textstatus.proto.ac;
import com.tencent.mm.plugin.textstatus.proto.ad;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.plugin.textstatus.proto.af;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.plugin.textstatus.proto.ab;>;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getDesc", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconGroup;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusI18n;", "getIcon", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "iconId", "getValidPostAction", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconAction;", "checkShowType", "", "getValidShowAction", "", "isUseOriginal", "isValidPost", "isValidShow", "print", "printTextStatusIcon", "printTextStatusIconGroup", "plugin-textstatus_release"})
public final class j
{
  public static final ac a(ae paramae, String paramString)
  {
    AppMethodBeat.i(233028);
    p.k(paramae, "$this$getIcon");
    paramae = paramae.tse.iterator();
    while (paramae.hasNext())
    {
      ac localac = (ac)paramae.next();
      if (p.h(localac.MFB, paramString))
      {
        p.j(localac, "iconItem");
        if (a(localac) != null)
        {
          AppMethodBeat.o(233028);
          return localac;
        }
      }
    }
    AppMethodBeat.o(233028);
    return null;
  }
  
  public static final ad a(ac paramac)
  {
    AppMethodBeat.i(233030);
    p.k(paramac, "$this$getValidShowAction");
    paramac = paramac.pSC;
    p.j(paramac, "actions");
    paramac = is((List)paramac);
    AppMethodBeat.o(233030);
    return paramac;
  }
  
  public static final ad a(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(233029);
    p.k(paramac, "$this$getValidPostAction");
    if ((paramBoolean) && (paramac.CKC != 0))
    {
      AppMethodBeat.o(233029);
      return null;
    }
    paramac = paramac.pSC.iterator();
    while (paramac.hasNext())
    {
      ad localad = (ad)paramac.next();
      p.j(localad, "action");
      if (b(localad))
      {
        AppMethodBeat.o(233029);
        return localad;
      }
    }
    AppMethodBeat.o(233029);
    return null;
  }
  
  public static final String a(ae paramae)
  {
    AppMethodBeat.i(233048);
    p.k(paramae, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder("key:").append(paramae.key).append(" cid:").append(paramae.MFn).append(' ');
    LinkedList localLinkedList = paramae.MFG;
    p.j(localLinkedList, "icon_groups");
    localStringBuilder = localStringBuilder.append(it((List)localLinkedList)).append(' ');
    paramae = paramae.tse;
    p.j(paramae, "icons");
    paramae = iu((List)paramae);
    AppMethodBeat.o(233048);
    return paramae;
  }
  
  public static final boolean a(ad paramad)
  {
    AppMethodBeat.i(233027);
    p.k(paramad, "$this$isUseOriginal");
    if ((paramad.MFC & 1L) != 0L)
    {
      AppMethodBeat.o(233027);
      return true;
    }
    AppMethodBeat.o(233027);
    return false;
  }
  
  public static final String b(ac paramac)
  {
    AppMethodBeat.i(233043);
    p.k(paramac, "$this$getDesc");
    paramac = a(paramac);
    if (paramac != null)
    {
      paramac = paramac.MFD;
      if (paramac != null)
      {
        String str = bQ(paramac);
        paramac = str;
        if (str != null) {
          break label43;
        }
      }
    }
    paramac = "";
    label43:
    AppMethodBeat.o(233043);
    return paramac;
  }
  
  private static boolean b(ad paramad)
  {
    AppMethodBeat.i(233037);
    p.k(paramad, "$this$isValidPost");
    int j = i.ov(paramad.MFF, 0);
    int i;
    int k;
    if ((paramad.endTime <= 0L) || (paramad.endTime <= j))
    {
      i = 2147483647;
      k = cm.bfF();
      if (j <= k) {
        break label65;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(233037);
      return false;
      i = paramad.endTime;
      break;
      label65:
      if (i >= k)
      {
        paramad = (CharSequence)paramad.url;
        if ((paramad == null) || (n.ba(paramad))) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(233037);
          return true;
        }
      }
    }
  }
  
  public static final String bQ(LinkedList<ab> paramLinkedList)
  {
    AppMethodBeat.i(233045);
    p.k(paramLinkedList, "$this$getDesc");
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    Object localObject = "";
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<ab>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (ab)localIterator.next();
      if (p.h(((ab)localObject).MFA, "en"))
      {
        paramLinkedList = ((ab)localObject).text;
        p.j(paramLinkedList, "info.text");
      }
      if (p.h(((ab)localObject).MFA, str))
      {
        paramLinkedList = ((ab)localObject).text;
        AppMethodBeat.o(233045);
        return paramLinkedList;
      }
    }
    AppMethodBeat.o(233045);
    return paramLinkedList;
  }
  
  private static boolean c(ad paramad)
  {
    AppMethodBeat.i(233041);
    p.k(paramad, "$this$isValidShow");
    int i = i.ov(paramad.MFF, 0);
    int j = cm.bfF();
    if (i > j) {}
    for (;;)
    {
      AppMethodBeat.o(233041);
      return false;
      if (2147483647 >= j)
      {
        paramad = (CharSequence)paramad.url;
        if ((paramad == null) || (n.ba(paramad))) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(233041);
          return true;
        }
      }
    }
  }
  
  public static final ad is(List<? extends ad> paramList)
  {
    AppMethodBeat.i(233032);
    p.k(paramList, "$this$getValidShowAction");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ad localad = (ad)paramList.next();
      if (c(localad))
      {
        AppMethodBeat.o(233032);
        return localad;
      }
    }
    AppMethodBeat.o(233032);
    return null;
  }
  
  private static String it(List<? extends af> paramList)
  {
    AppMethodBeat.i(233051);
    p.k(paramList, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder("igroup:" + paramList.size() + ' ');
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      af localaf = (af)paramList.next();
      p.k(localaf, "$this$print");
      localStringBuilder.append("gid:" + localaf.MFH).append(" ");
    }
    paramList = localStringBuilder.toString();
    p.j(paramList, "sb.toString()");
    AppMethodBeat.o(233051);
    return paramList;
  }
  
  private static String iu(List<? extends ac> paramList)
  {
    AppMethodBeat.i(233054);
    p.k(paramList, "$this$print");
    StringBuilder localStringBuilder = new StringBuilder("icons:" + paramList.size() + ' ');
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ac localac = (ac)paramList.next();
      p.k(localac, "$this$print");
      localStringBuilder.append("id:" + localac.MFB + " st:" + localac.CKC).append(" ");
    }
    paramList = localStringBuilder.toString();
    p.j(paramList, "sb.toString()");
    AppMethodBeat.o(233054);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.j
 * JD-Core Version:    0.7.0.1
 */