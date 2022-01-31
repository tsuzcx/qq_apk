package com.tencent.mm.plugin.profile.ui.newbizinfo;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.as;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "username", "", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "pickAppMsg", "app_release"})
public final class c
{
  public static final c pEa;
  
  static
  {
    AppMethodBeat.i(154039);
    pEa = new c();
    AppMethodBeat.o(154039);
  }
  
  public static final lj Xj(String paramString)
  {
    AppMethodBeat.i(154036);
    j.q(paramString, "username");
    lj locallj = new lj();
    try
    {
      locallj.parseFrom(d.ccT().decodeBytes("reps_".concat(String.valueOf(paramString))));
      label39:
      AppMethodBeat.o(154036);
      return locallj;
    }
    catch (Exception paramString)
    {
      break label39;
    }
  }
  
  public static final b a(lg paramlg, int paramInt)
  {
    AppMethodBeat.i(154038);
    j.q(paramlg, "list");
    paramlg = paramlg.wzA;
    j.p(paramlg, "list.Msg");
    Object localObject = ((Iterable)paramlg).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramlg = (lf)((Iterator)localObject).next();
      if (paramlg.wzz == null) {
        break label228;
      }
      if (paramInt < paramlg.wzz.wxG.size() + i)
      {
        localObject = (kf)paramlg.wzz.wxG.get(paramInt - i);
        b localb = new b();
        localb.pEp = String.valueOf(paramlg.wzz.wxF.wxe);
        localb.hBL = ((kf)localObject).wxk;
        localb.pEm = ((kf)localObject).wxi;
        localb.pEn = ((kf)localObject).wxp;
        localb.type = ((kf)localObject).wqp;
        localb.oLs = paramlg.wzu.wMO;
        localb.title = ((kf)localObject).Title;
        localb.pEo = ((kf)localObject).wxg;
        localb.pEq = String.valueOf(paramInt - i);
        AppMethodBeat.o(154038);
        return localb;
      }
      i = paramlg.wzz.wxG.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(154038);
      return null;
    }
  }
  
  private static lj a(lj paramlj)
  {
    AppMethodBeat.i(154033);
    Object localObject1 = paramlj.wzJ;
    if (localObject1 != null)
    {
      localObject1 = ((lg)localObject1).wzA;
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (lf)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((lf)localObject2).wzz;
            if (localObject2 != null)
            {
              localObject2 = ((kg)localObject2).wxG;
              if (localObject2 != null)
              {
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  kf localkf = (kf)((Iterator)localObject2).next();
                  if (localkf.wxD != null) {
                    localkf.wxD = null;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(154033);
    return paramlj;
  }
  
  public static final List<lv> a(lu paramlu)
  {
    AppMethodBeat.i(154034);
    j.q(paramlu, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    paramlu = paramlu.wAp;
    j.p(paramlu, "menuInfo.button_list");
    paramlu = ((Iterable)paramlu).iterator();
    while (paramlu.hasNext())
    {
      lv locallv = (lv)paramlu.next();
      switch (locallv.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = locallv.wAq;
        j.p(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((lv)localObject3).type)
          {
          }
          for (i = 0; i != 0; i = 1)
          {
            ((Collection)localObject1).add(localObject3);
            break;
          }
        }
        localObject1 = (List)localObject1;
        if (!((Collection)localObject1).isEmpty()) {}
        for (int i = 1; i != 0; i = 0)
        {
          localObject2 = new lv();
          ((lv)localObject2).parseFrom(locallv.toByteArray());
          ((lv)localObject2).wAq.clear();
          ((lv)localObject2).wAq.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
        localArrayList.add(locallv);
      }
    }
    paramlu = (List)localArrayList;
    AppMethodBeat.o(154034);
    return paramlu;
  }
  
  public static final void b(lj paramlj)
  {
    AppMethodBeat.i(154035);
    j.q(paramlj, "resp");
    d.ccT().encode("reps_" + paramlj.wzH.jJA, a(paramlj).toByteArray());
    AppMethodBeat.o(154035);
  }
  
  public static final int cB(List<? extends lf> paramList)
  {
    AppMethodBeat.i(154037);
    j.q(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((lf)paramList.next()).wzz;
      if (localObject != null)
      {
        localObject = ((kg)localObject).wxG;
        if (localObject == null) {}
      }
      for (int j = ((LinkedList)localObject).size();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    AppMethodBeat.o(154037);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c
 * JD-Core Version:    0.7.0.1
 */