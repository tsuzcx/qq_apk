package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a BjZ;
  
  static
  {
    AppMethodBeat.i(39622);
    BjZ = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final b a(ov paramov, int paramInt)
  {
    AppMethodBeat.i(39621);
    p.h(paramov, "list");
    paramov = paramov.KVw;
    p.g(paramov, "list.Msg");
    Object localObject = ((Iterable)paramov).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramov = (ou)((Iterator)localObject).next();
      if (paramov.KVv == null) {
        break label228;
      }
      if (paramInt < paramov.KVv.KSK.size() + i)
      {
        localObject = (nh)paramov.KVv.KSK.get(paramInt - i);
        b localb = new b();
        localb.Bkr = String.valueOf(paramov.KVv.KSJ.KSf);
        localb.coverImgUrl = ((nh)localObject).KSl;
        localb.Bko = ((nh)localObject).KSj;
        localb.Bkp = ((nh)localObject).KSq;
        localb.type = ((nh)localObject).iAb;
        localb.hXs = paramov.KVq.LmE;
        localb.title = ((nh)localObject).Title;
        localb.Bkq = ((nh)localObject).KSh;
        localb.Bks = String.valueOf(paramInt - i);
        AppMethodBeat.o(39621);
        return localb;
      }
      i = paramov.KVv.KSK.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(39621);
      return null;
    }
  }
  
  public static final List<qa> a(pz parampz)
  {
    AppMethodBeat.i(39617);
    p.h(parampz, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    parampz = parampz.KWS;
    p.g(parampz, "menuInfo.button_list");
    parampz = ((Iterable)parampz).iterator();
    while (parampz.hasNext())
    {
      qa localqa = (qa)parampz.next();
      switch (localqa.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localqa.KWT;
        p.g(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((qa)localObject3).type)
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
          localObject2 = new qa();
          ((qa)localObject2).parseFrom(localqa.toByteArray());
          ((qa)localObject2).KWT.clear();
          ((qa)localObject2).KWT.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
      case 6: 
        localArrayList.add(localqa);
      }
    }
    parampz = (List)localArrayList;
    AppMethodBeat.o(39617);
    return parampz;
  }
  
  public static void a(ov paramov)
  {
    AppMethodBeat.i(169906);
    if (paramov != null)
    {
      paramov = paramov.KVw;
      if (paramov != null)
      {
        paramov = ((Iterable)paramov).iterator();
        while (paramov.hasNext())
        {
          Object localObject1 = (ou)paramov.next();
          if (localObject1 != null)
          {
            localObject1 = ((ou)localObject1).KVv;
            if (localObject1 != null)
            {
              localObject1 = ((ni)localObject1).KSK;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  nh localnh = (nh)((Iterator)localObject1).next();
                  if ((localnh != null) && (localnh.KSF == 1) && (!Util.isNullOrNil(localnh.KSj)))
                  {
                    localObject2 = com.tencent.mm.plugin.brandservice.b.a.pmT;
                    localObject2 = localnh.KSj;
                    p.g(localObject2, "detail.ContentUrl");
                    if (localnh.izV != 1) {
                      break label158;
                    }
                  }
                }
                label158:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.b.a.aH((String)localObject2, bool);
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
  
  private static String aKx(String paramString)
  {
    AppMethodBeat.i(230655);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.af(q.class);
    p.g(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((q)localObject).aZV();
    if (!s.YS((String)localObject)) {
      s.boN((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + MD5Util.getMD5String(paramString);
    AppMethodBeat.o(230655);
    return paramString;
  }
  
  public static final ph aKy(String paramString)
  {
    AppMethodBeat.i(39619);
    p.h(paramString, "userName");
    ph localph = new ph();
    try
    {
      paramString = s.aW(aKx(paramString), 0, -1);
      if (paramString != null) {
        localph.parseFrom(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProfileV2", "readFromFile ex=" + paramString.getMessage());
      }
    }
    AppMethodBeat.o(39619);
    return localph;
  }
  
  public static final void b(ph paramph)
  {
    AppMethodBeat.i(39618);
    p.h(paramph, "resp");
    try
    {
      Object localObject1 = paramph.KWe.UserName;
      p.g(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new o(aKx((String)localObject1));
      if (((o)localObject1).exists()) {
        ((o)localObject1).delete();
      }
      localObject1 = ((o)localObject1).getAbsolutePath();
      Object localObject2 = paramph.KWg;
      if (localObject2 != null)
      {
        localObject2 = ((ov)localObject2).KVw;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (ou)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((ou)localObject3).KVv;
              if (localObject3 != null)
              {
                localObject3 = ((ni)localObject3).KSK;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    nh localnh = (nh)((Iterator)localObject3).next();
                    if (localnh.KSE != null) {
                      localnh.KSE = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      s.C((String)localObject1, paramph.toByteArray());
    }
    catch (Exception paramph)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(230656);
    p.h(paramString, "userName");
    try
    {
      paramString = new o(aKx(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
      AppMethodBeat.o(230656);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(230656);
    }
  }
  
  public static final int fT(List<? extends ou> paramList)
  {
    AppMethodBeat.i(39620);
    p.h(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((ou)paramList.next()).KVv;
      if (localObject != null)
      {
        localObject = ((ni)localObject).KSK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a
 * JD-Core Version:    0.7.0.1
 */