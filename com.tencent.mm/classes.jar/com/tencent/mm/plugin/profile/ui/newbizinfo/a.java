package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a uGe;
  
  static
  {
    AppMethodBeat.i(39622);
    uGe = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final com.tencent.mm.plugin.profile.ui.newbizinfo.b.b a(mw parammw, int paramInt)
  {
    AppMethodBeat.i(39621);
    k.h(parammw, "list");
    parammw = parammw.CKt;
    k.g(parammw, "list.Msg");
    Object localObject = ((Iterable)parammw).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      parammw = (mv)((Iterator)localObject).next();
      if (parammw.CKs == null) {
        break label228;
      }
      if (paramInt < parammw.CKs.CIj.size() + i)
      {
        localObject = (lr)parammw.CKs.CIj.get(paramInt - i);
        com.tencent.mm.plugin.profile.ui.newbizinfo.b.b localb = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.b();
        localb.uGw = String.valueOf(parammw.CKs.CIi.CHH);
        localb.coverImgUrl = ((lr)localObject).CHN;
        localb.uGt = ((lr)localObject).CHL;
        localb.uGu = ((lr)localObject).CHS;
        localb.type = ((lr)localObject).gKq;
        localb.tGD = parammw.CKn.CZk;
        localb.title = ((lr)localObject).Title;
        localb.uGv = ((lr)localObject).CHJ;
        localb.uGx = String.valueOf(paramInt - i);
        AppMethodBeat.o(39621);
        return localb;
      }
      i = parammw.CKs.CIj.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(39621);
      return null;
    }
  }
  
  public static final List<np> a(no paramno)
  {
    AppMethodBeat.i(39617);
    k.h(paramno, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    paramno = paramno.CLm;
    k.g(paramno, "menuInfo.button_list");
    paramno = ((Iterable)paramno).iterator();
    while (paramno.hasNext())
    {
      np localnp = (np)paramno.next();
      switch (localnp.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localnp.CLn;
        k.g(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((np)localObject3).type)
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
          localObject2 = new np();
          ((np)localObject2).parseFrom(localnp.toByteArray());
          ((np)localObject2).CLn.clear();
          ((np)localObject2).CLn.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
        localArrayList.add(localnp);
      }
    }
    paramno = (List)localArrayList;
    AppMethodBeat.o(39617);
    return paramno;
  }
  
  public static void a(mw parammw)
  {
    AppMethodBeat.i(169906);
    if (parammw != null)
    {
      parammw = parammw.CKt;
      if (parammw != null)
      {
        parammw = ((Iterable)parammw).iterator();
        while (parammw.hasNext())
        {
          Object localObject1 = (mv)parammw.next();
          if (localObject1 != null)
          {
            localObject1 = ((mv)localObject1).CKs;
            if (localObject1 != null)
            {
              localObject1 = ((ls)localObject1).CIj;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  lr locallr = (lr)((Iterator)localObject1).next();
                  if ((locallr != null) && (locallr.CIh == 1) && (!bt.isNullOrNil(locallr.CHL)))
                  {
                    localObject2 = com.tencent.mm.plugin.brandservice.b.b.mSC;
                    localObject2 = locallr.CHL;
                    k.g(localObject2, "detail.ContentUrl");
                    if (locallr.gKl != 1) {
                      break label158;
                    }
                  }
                }
                label158:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.b.b.aA((String)localObject2, bool);
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
  
  private static String akL(String paramString)
  {
    AppMethodBeat.i(191871);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ab(p.class);
    k.g(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((p)localObject).avS();
    if (!i.eK((String)localObject)) {
      i.aMF((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + ai.du(paramString);
    AppMethodBeat.o(191871);
    return paramString;
  }
  
  public static final ne akM(String paramString)
  {
    AppMethodBeat.i(39619);
    k.h(paramString, "userName");
    ne localne = new ne();
    try
    {
      localne.parseFrom(i.aR(akL(paramString), 0, -1));
      AppMethodBeat.o(39619);
      return localne;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.ProfileV2", "readFromFile ex=" + paramString.getMessage());
      }
    }
  }
  
  public static final void b(ne paramne)
  {
    AppMethodBeat.i(39618);
    k.h(paramne, "resp");
    try
    {
      Object localObject1 = paramne.CKR.mAQ;
      k.g(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new e(akL((String)localObject1));
      if (((e)localObject1).exists()) {
        ((e)localObject1).delete();
      }
      localObject1 = ((e)localObject1).getAbsolutePath();
      Object localObject2 = paramne.CKT;
      if (localObject2 != null)
      {
        localObject2 = ((mw)localObject2).CKt;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (mv)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((mv)localObject3).CKs;
              if (localObject3 != null)
              {
                localObject3 = ((ls)localObject3).CIj;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    lr locallr = (lr)((Iterator)localObject3).next();
                    if (locallr.CIg != null) {
                      locallr.CIg = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      i.B((String)localObject1, paramne.toByteArray());
    }
    catch (Exception paramne)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(191872);
    k.h(paramString, "userName");
    try
    {
      paramString = new e(akL(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
      AppMethodBeat.o(191872);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(191872);
    }
  }
  
  public static final int ey(List<? extends mv> paramList)
  {
    AppMethodBeat.i(39620);
    k.h(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((mv)paramList.next()).CKs;
      if (localObject != null)
      {
        localObject = ((ls)localObject).CIj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a
 * JD-Core Version:    0.7.0.1
 */