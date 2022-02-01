package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lx;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a vOV;
  
  static
  {
    AppMethodBeat.i(39622);
    vOV = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final b a(nd paramnd, int paramInt)
  {
    AppMethodBeat.i(39621);
    k.h(paramnd, "list");
    paramnd = paramnd.EcV;
    k.g(paramnd, "list.Msg");
    Object localObject = ((Iterable)paramnd).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramnd = (nc)((Iterator)localObject).next();
      if (paramnd.EcU == null) {
        break label228;
      }
      if (paramInt < paramnd.EcU.EaL.size() + i)
      {
        localObject = (ly)paramnd.EcU.EaL.get(paramInt - i);
        b localb = new b();
        localb.vPn = String.valueOf(paramnd.EcU.EaK.Eaj);
        localb.coverImgUrl = ((ly)localObject).Eap;
        localb.vPk = ((ly)localObject).Ean;
        localb.vPl = ((ly)localObject).Eau;
        localb.type = ((ly)localObject).hkQ;
        localb.gIh = paramnd.EcP.ErX;
        localb.title = ((ly)localObject).Title;
        localb.vPm = ((ly)localObject).Eal;
        localb.vPo = String.valueOf(paramInt - i);
        AppMethodBeat.o(39621);
        return localb;
      }
      i = paramnd.EcU.EaL.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(39621);
      return null;
    }
  }
  
  public static final List<nw> a(nv paramnv)
  {
    AppMethodBeat.i(39617);
    k.h(paramnv, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    paramnv = paramnv.EdO;
    k.g(paramnv, "menuInfo.button_list");
    paramnv = ((Iterable)paramnv).iterator();
    while (paramnv.hasNext())
    {
      nw localnw = (nw)paramnv.next();
      switch (localnw.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localnw.EdP;
        k.g(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((nw)localObject3).type)
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
          localObject2 = new nw();
          ((nw)localObject2).parseFrom(localnw.toByteArray());
          ((nw)localObject2).EdP.clear();
          ((nw)localObject2).EdP.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
        localArrayList.add(localnw);
      }
    }
    paramnv = (List)localArrayList;
    AppMethodBeat.o(39617);
    return paramnv;
  }
  
  public static void a(nd paramnd)
  {
    AppMethodBeat.i(169906);
    if (paramnd != null)
    {
      paramnd = paramnd.EcV;
      if (paramnd != null)
      {
        paramnd = ((Iterable)paramnd).iterator();
        while (paramnd.hasNext())
        {
          Object localObject1 = (nc)paramnd.next();
          if (localObject1 != null)
          {
            localObject1 = ((nc)localObject1).EcU;
            if (localObject1 != null)
            {
              localObject1 = ((lz)localObject1).EaL;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  ly locally = (ly)((Iterator)localObject1).next();
                  if ((locally != null) && (locally.EaJ == 1) && (!bs.isNullOrNil(locally.Ean)))
                  {
                    localObject2 = com.tencent.mm.plugin.brandservice.b.a.nuP;
                    localObject2 = locally.Ean;
                    k.g(localObject2, "detail.ContentUrl");
                    if (locally.hkL != 1) {
                      break label158;
                    }
                  }
                }
                label158:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.b.a.aB((String)localObject2, bool);
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
  
  private static String apK(String paramString)
  {
    AppMethodBeat.i(196992);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ab(p.class);
    k.g(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((p)localObject).aCK();
    if (!i.eA((String)localObject)) {
      i.aSh((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + ah.dg(paramString);
    AppMethodBeat.o(196992);
    return paramString;
  }
  
  public static final nl apL(String paramString)
  {
    AppMethodBeat.i(39619);
    k.h(paramString, "userName");
    nl localnl = new nl();
    try
    {
      localnl.parseFrom(i.aU(apK(paramString), 0, -1));
      AppMethodBeat.o(39619);
      return localnl;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.ProfileV2", "readFromFile ex=" + paramString.getMessage());
      }
    }
  }
  
  public static final void b(nl paramnl)
  {
    AppMethodBeat.i(39618);
    k.h(paramnl, "resp");
    try
    {
      Object localObject1 = paramnl.Edt.ncR;
      k.g(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new e(apK((String)localObject1));
      if (((e)localObject1).exists()) {
        ((e)localObject1).delete();
      }
      localObject1 = ((e)localObject1).getAbsolutePath();
      Object localObject2 = paramnl.Edv;
      if (localObject2 != null)
      {
        localObject2 = ((nd)localObject2).EcV;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (nc)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((nc)localObject3).EcU;
              if (localObject3 != null)
              {
                localObject3 = ((lz)localObject3).EaL;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    ly locally = (ly)((Iterator)localObject3).next();
                    if (locally.EaI != null) {
                      locally.EaI = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      i.B((String)localObject1, paramnl.toByteArray());
    }
    catch (Exception paramnl)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(196993);
    k.h(paramString, "userName");
    try
    {
      paramString = new e(apK(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
      AppMethodBeat.o(196993);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(196993);
    }
  }
  
  public static final int eC(List<? extends nc> paramList)
  {
    AppMethodBeat.i(39620);
    k.h(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((nc)paramList.next()).EcU;
      if (localObject != null)
      {
        localObject = ((lz)localObject).EaL;
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