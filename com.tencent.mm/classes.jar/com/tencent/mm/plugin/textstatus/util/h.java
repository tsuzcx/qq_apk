package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.proto.ao;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.plugin.textstatus.proto.aq;
import com.tencent.mm.plugin.textstatus.proto.ar;
import com.tencent.mm.plugin.textstatus.proto.as;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.plugin.textstatus.proto.ao;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"getClusterDes", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "getDesc", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconGroup;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusI18n;", "getIcon", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconConfig;", "iconId", "getOtherClusterDes", "getValidPostAction", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconAction;", "checkShowType", "", "getValidShowAction", "", "isUseOriginal", "isValidAction", "beginTime", "", "endTime", "isValidPost", "isValidShow", "print", "printTextStatusIcon", "printTextStatusIconGroup", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final ap a(ar paramar, String paramString)
  {
    AppMethodBeat.i(290373);
    s.u(paramar, "<this>");
    paramar = paramar.wwD.iterator();
    while (paramar.hasNext())
    {
      ap localap = (ap)paramar.next();
      if (s.p(localap.ToD, paramString))
      {
        s.s(localap, "iconItem");
        if (a(localap) != null)
        {
          AppMethodBeat.o(290373);
          return localap;
        }
      }
    }
    AppMethodBeat.o(290373);
    return null;
  }
  
  public static final aq a(ap paramap)
  {
    AppMethodBeat.i(290386);
    s.u(paramap, "<this>");
    paramap = paramap.sXD;
    s.s(paramap, "actions");
    paramap = ly((List)paramap);
    AppMethodBeat.o(290386);
    return paramap;
  }
  
  public static final aq a(ap paramap, boolean paramBoolean)
  {
    AppMethodBeat.i(290379);
    s.u(paramap, "<this>");
    if ((paramBoolean) && (paramap.show_type != 0))
    {
      AppMethodBeat.o(290379);
      return null;
    }
    paramap = paramap.sXD.iterator();
    while (paramap.hasNext())
    {
      aq localaq = (aq)paramap.next();
      s.s(localaq, "action");
      if (b(localaq))
      {
        AppMethodBeat.o(290379);
        return localaq;
      }
    }
    AppMethodBeat.o(290379);
    return null;
  }
  
  public static final String a(ar paramar)
  {
    AppMethodBeat.i(290438);
    s.u(paramar, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("key:").append(paramar.key).append(" cid:").append(paramar.TpT).append(' ');
    LinkedList localLinkedList = paramar.TpU;
    s.s(localLinkedList, "icon_groups");
    localStringBuilder = localStringBuilder.append(lz((List)localLinkedList)).append(' ');
    paramar = paramar.wwD;
    s.s(paramar, "icons");
    paramar = lA((List)paramar);
    AppMethodBeat.o(290438);
    return paramar;
  }
  
  public static final boolean a(aq paramaq)
  {
    AppMethodBeat.i(290366);
    s.u(paramaq, "<this>");
    if ((paramaq.TpM & 1L) != 0L)
    {
      AppMethodBeat.o(290366);
      return true;
    }
    AppMethodBeat.o(290366);
    return false;
  }
  
  private static boolean a(aq paramaq, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(290415);
    s.u(paramaq, "<this>");
    int i = cn.getSyncServerTimeSecond();
    if (paramInt1 <= i) {
      if (i <= paramInt2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label78;
        }
        paramaq = (CharSequence)paramaq.url;
        if ((paramaq != null) && (!n.bp(paramaq))) {
          break label73;
        }
      }
    }
    label73:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        break label78;
      }
      AppMethodBeat.o(290415);
      return true;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break;
    }
    label78:
    AppMethodBeat.o(290415);
    return false;
  }
  
  public static final String b(ap paramap)
  {
    AppMethodBeat.i(290422);
    s.u(paramap, "<this>");
    paramap = a(paramap);
    if (paramap == null)
    {
      AppMethodBeat.o(290422);
      return "";
    }
    paramap = paramap.TpN;
    if (paramap == null)
    {
      AppMethodBeat.o(290422);
      return "";
    }
    paramap = ca(paramap);
    if (paramap == null)
    {
      AppMethodBeat.o(290422);
      return "";
    }
    AppMethodBeat.o(290422);
    return paramap;
  }
  
  private static boolean b(aq paramaq)
  {
    AppMethodBeat.i(290400);
    s.u(paramaq, "<this>");
    int j = k.qu(paramaq.TpP, 0);
    if ((paramaq.endTime <= 0L) || (paramaq.endTime <= j)) {}
    for (int i = 2147483647;; i = paramaq.endTime)
    {
      boolean bool = a(paramaq, j, i);
      AppMethodBeat.o(290400);
      return bool;
    }
  }
  
  private static boolean c(aq paramaq)
  {
    AppMethodBeat.i(290406);
    s.u(paramaq, "<this>");
    boolean bool = a(paramaq, k.qu(paramaq.TpP, 0), 2147483647);
    AppMethodBeat.o(290406);
    return bool;
  }
  
  public static final String ca(LinkedList<ao> paramLinkedList)
  {
    AppMethodBeat.i(290426);
    s.u(paramLinkedList, "<this>");
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    Object localObject = "";
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<ao>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (ao)localIterator.next();
      if (s.p(((ao)localObject).TpL, "en"))
      {
        paramLinkedList = ((ao)localObject).text;
        s.s(paramLinkedList, "info.text");
      }
      if (s.p(((ao)localObject).TpL, str))
      {
        paramLinkedList = ((ao)localObject).text;
        AppMethodBeat.o(290426);
        return paramLinkedList;
      }
    }
    AppMethodBeat.o(290426);
    return paramLinkedList;
  }
  
  private static String lA(List<? extends ap> paramList)
  {
    AppMethodBeat.i(290470);
    s.u(paramList, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("icons:" + paramList.size() + ' ');
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ap localap = (ap)paramList.next();
      s.u(localap, "<this>");
      localStringBuilder.append("id:" + localap.ToD + " st:" + localap.show_type).append(" ");
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(290470);
    return paramList;
  }
  
  public static final aq ly(List<? extends aq> paramList)
  {
    AppMethodBeat.i(290396);
    s.u(paramList, "<this>");
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      aq localaq = (aq)localIterator.next();
      if (c(localaq)) {
        if ((paramList == null) || (paramList.TpP < localaq.TpP)) {
          paramList = localaq;
        } else if (paramList.TpP == localaq.TpP) {
          if ((paramList.endTime == localaq.endTime) || (localaq.endTime == 0)) {
            paramList = localaq;
          } else if ((paramList.endTime != 0) && (paramList.endTime < localaq.endTime)) {
            paramList = localaq;
          }
        }
      }
    }
    AppMethodBeat.o(290396);
    return paramList;
  }
  
  private static String lz(List<? extends as> paramList)
  {
    AppMethodBeat.i(290447);
    s.u(paramList, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("igroup:" + paramList.size() + ' ');
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      as localas = (as)paramList.next();
      s.u(localas, "<this>");
      localStringBuilder.append(s.X("gid:", localas.TpV)).append(" ");
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(290447);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.h
 * JD-Core Version:    0.7.0.1
 */