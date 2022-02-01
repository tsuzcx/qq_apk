package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a wWg;
  
  static
  {
    AppMethodBeat.i(39622);
    wWg = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final b a(nz paramnz, int paramInt)
  {
    AppMethodBeat.i(39621);
    p.h(paramnz, "list");
    paramnz = paramnz.FIZ;
    p.g(paramnz, "list.Msg");
    Object localObject = ((Iterable)paramnz).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramnz = (ny)((Iterator)localObject).next();
      if (paramnz.FIY == null) {
        break label228;
      }
      if (paramInt < paramnz.FIY.FGu.size() + i)
      {
        localObject = (mn)paramnz.FIY.FGu.get(paramInt - i);
        b localb = new b();
        localb.wWy = String.valueOf(paramnz.FIY.FGt.FFS);
        localb.coverImgUrl = ((mn)localObject).FFY;
        localb.wWv = ((mn)localObject).FFW;
        localb.wWw = ((mn)localObject).FGd;
        localb.type = ((mn)localObject).hCZ;
        localb.hbR = paramnz.FIT.FZg;
        localb.title = ((mn)localObject).Title;
        localb.wWx = ((mn)localObject).FFU;
        localb.wWz = String.valueOf(paramInt - i);
        AppMethodBeat.o(39621);
        return localb;
      }
      i = paramnz.FIY.FGu.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(39621);
      return null;
    }
  }
  
  public static final List<pb> a(pa parampa)
  {
    AppMethodBeat.i(39617);
    p.h(parampa, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    parampa = parampa.FKn;
    p.g(parampa, "menuInfo.button_list");
    parampa = ((Iterable)parampa).iterator();
    while (parampa.hasNext())
    {
      pb localpb = (pb)parampa.next();
      switch (localpb.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localpb.FKo;
        p.g(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((pb)localObject3).type)
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
          localObject2 = new pb();
          ((pb)localObject2).parseFrom(localpb.toByteArray());
          ((pb)localObject2).FKo.clear();
          ((pb)localObject2).FKo.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
        localArrayList.add(localpb);
      }
    }
    parampa = (List)localArrayList;
    AppMethodBeat.o(39617);
    return parampa;
  }
  
  public static void a(nz paramnz)
  {
    AppMethodBeat.i(169906);
    if (paramnz != null)
    {
      paramnz = paramnz.FIZ;
      if (paramnz != null)
      {
        paramnz = ((Iterable)paramnz).iterator();
        while (paramnz.hasNext())
        {
          Object localObject1 = (ny)paramnz.next();
          if (localObject1 != null)
          {
            localObject1 = ((ny)localObject1).FIY;
            if (localObject1 != null)
            {
              localObject1 = ((mo)localObject1).FGu;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  mn localmn = (mn)((Iterator)localObject1).next();
                  if ((localmn != null) && (localmn.FGs == 1) && (!bt.isNullOrNil(localmn.FFW)))
                  {
                    localObject2 = com.tencent.mm.plugin.brandservice.b.a.nWn;
                    localObject2 = localmn.FFW;
                    p.g(localObject2, "detail.ContentUrl");
                    if (localmn.hCU != 1) {
                      break label158;
                    }
                  }
                }
                label158:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.b.a.aD((String)localObject2, bool);
                  break label79;
                  break;
                }
              }
            }
          }
        }
        AppMethodBeat.o(169906);
        return;
      }
    }
    AppMethodBeat.o(169906);
  }
  
  private static String auQ(String paramString)
  {
    AppMethodBeat.i(194847);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ab(q.class);
    p.g(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((q)localObject).aFN();
    if (!i.fv((String)localObject)) {
      i.aYg((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + ai.ee(paramString);
    AppMethodBeat.o(194847);
    return paramString;
  }
  
  public static final oi auR(String paramString)
  {
    AppMethodBeat.i(39619);
    p.h(paramString, "userName");
    oi localoi = new oi();
    try
    {
      localoi.parseFrom(i.aY(auQ(paramString), 0, -1));
      AppMethodBeat.o(39619);
      return localoi;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.ProfileV2", "readFromFile ex=" + paramString.getMessage());
      }
    }
  }
  
  public static final void b(oi paramoi)
  {
    AppMethodBeat.i(39618);
    p.h(paramoi, "resp");
    try
    {
      Object localObject1 = paramoi.FJC.nDo;
      p.g(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new e(auQ((String)localObject1));
      if (((e)localObject1).exists()) {
        ((e)localObject1).delete();
      }
      localObject1 = ((e)localObject1).getAbsolutePath();
      Object localObject2 = paramoi.FJE;
      if (localObject2 != null)
      {
        localObject2 = ((nz)localObject2).FIZ;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (ny)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((ny)localObject3).FIY;
              if (localObject3 != null)
              {
                localObject3 = ((mo)localObject3).FGu;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    mn localmn = (mn)((Iterator)localObject3).next();
                    if (localmn.FGr != null) {
                      localmn.FGr = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      i.C((String)localObject1, paramoi.toByteArray());
    }
    catch (Exception paramoi)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(194848);
    p.h(paramString, "userName");
    try
    {
      paramString = new e(auQ(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
      AppMethodBeat.o(194848);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(194848);
    }
  }
  
  public static final int eP(List<? extends ny> paramList)
  {
    AppMethodBeat.i(39620);
    p.h(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((ny)paramList.next()).FIY;
      if (localObject != null)
      {
        localObject = ((mo)localObject).FGu;
        if (localObject == null) {}
      }
      for (int j = ((LinkedList)localObject).size();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    AppMethodBeat.o(39620);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a
 * JD-Core Version:    0.7.0.1
 */