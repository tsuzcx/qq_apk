package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a xlX;
  
  static
  {
    AppMethodBeat.i(39622);
    xlX = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final b a(ob paramob, int paramInt)
  {
    AppMethodBeat.i(39621);
    p.h(paramob, "list");
    paramob = paramob.Gby;
    p.g(paramob, "list.Msg");
    Object localObject = ((Iterable)paramob).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      paramob = (oa)((Iterator)localObject).next();
      if (paramob.Gbx == null) {
        break label228;
      }
      if (paramInt < paramob.Gbx.FYQ.size() + i)
      {
        localObject = (mp)paramob.Gbx.FYQ.get(paramInt - i);
        b localb = new b();
        localb.xmp = String.valueOf(paramob.Gbx.FYP.FYo);
        localb.coverImgUrl = ((mp)localObject).FYu;
        localb.xmm = ((mp)localObject).FYs;
        localb.xmn = ((mp)localObject).FYz;
        localb.type = ((mp)localObject).hFR;
        localb.heF = paramob.Gbs.GrG;
        localb.title = ((mp)localObject).Title;
        localb.xmo = ((mp)localObject).FYq;
        localb.xmq = String.valueOf(paramInt - i);
        AppMethodBeat.o(39621);
        return localb;
      }
      i = paramob.Gbx.FYQ.size() + i;
    }
    label228:
    for (;;)
    {
      break;
      AppMethodBeat.o(39621);
      return null;
    }
  }
  
  public static final List<pd> a(pc parampc)
  {
    AppMethodBeat.i(39617);
    p.h(parampc, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    parampc = parampc.GcM;
    p.g(parampc, "menuInfo.button_list");
    parampc = ((Iterable)parampc).iterator();
    while (parampc.hasNext())
    {
      pd localpd = (pd)parampc.next();
      switch (localpd.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localpd.GcN;
        p.g(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((pd)localObject3).type)
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
          localObject2 = new pd();
          ((pd)localObject2).parseFrom(localpd.toByteArray());
          ((pd)localObject2).GcN.clear();
          ((pd)localObject2).GcN.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
      case 6: 
        localArrayList.add(localpd);
      }
    }
    parampc = (List)localArrayList;
    AppMethodBeat.o(39617);
    return parampc;
  }
  
  public static void a(ob paramob)
  {
    AppMethodBeat.i(169906);
    if (paramob != null)
    {
      paramob = paramob.Gby;
      if (paramob != null)
      {
        paramob = ((Iterable)paramob).iterator();
        while (paramob.hasNext())
        {
          Object localObject1 = (oa)paramob.next();
          if (localObject1 != null)
          {
            localObject1 = ((oa)localObject1).Gbx;
            if (localObject1 != null)
            {
              localObject1 = ((mq)localObject1).FYQ;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  mp localmp = (mp)((Iterator)localObject1).next();
                  if ((localmp != null) && (localmp.FYO == 1) && (!bu.isNullOrNil(localmp.FYs)))
                  {
                    localObject2 = com.tencent.mm.plugin.brandservice.b.a.obW;
                    localObject2 = localmp.FYs;
                    p.g(localObject2, "detail.ContentUrl");
                    if (localmp.hFM != 1) {
                      break label158;
                    }
                  }
                }
                label158:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.b.a.aF((String)localObject2, bool);
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
  
  private static String awf(String paramString)
  {
    AppMethodBeat.i(188251);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ab(q.class);
    p.g(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((q)localObject).aGd();
    if (!o.fB((String)localObject)) {
      o.aZI((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + aj.ej(paramString);
    AppMethodBeat.o(188251);
    return paramString;
  }
  
  public static final ok awg(String paramString)
  {
    AppMethodBeat.i(39619);
    p.h(paramString, "userName");
    ok localok = new ok();
    try
    {
      paramString = o.bb(awf(paramString), 0, -1);
      if (paramString != null) {
        localok.parseFrom(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.ProfileV2", "readFromFile ex=" + paramString.getMessage());
      }
    }
    AppMethodBeat.o(39619);
    return localok;
  }
  
  public static final void b(ok paramok)
  {
    AppMethodBeat.i(39618);
    p.h(paramok, "resp");
    try
    {
      Object localObject1 = paramok.Gcb.nIJ;
      p.g(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new k(awf((String)localObject1));
      if (((k)localObject1).exists()) {
        ((k)localObject1).delete();
      }
      localObject1 = ((k)localObject1).getAbsolutePath();
      Object localObject2 = paramok.Gcd;
      if (localObject2 != null)
      {
        localObject2 = ((ob)localObject2).Gby;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (oa)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((oa)localObject3).Gbx;
              if (localObject3 != null)
              {
                localObject3 = ((mq)localObject3).FYQ;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    mp localmp = (mp)((Iterator)localObject3).next();
                    if (localmp.FYN != null) {
                      localmp.FYN = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      o.C((String)localObject1, paramok.toByteArray());
    }
    catch (Exception paramok)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(188252);
    p.h(paramString, "userName");
    try
    {
      paramString = new k(awf(paramString));
      if (paramString.exists()) {
        paramString.delete();
      }
      AppMethodBeat.o(188252);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(188252);
    }
  }
  
  public static final int eX(List<? extends oa> paramList)
  {
    AppMethodBeat.i(39620);
    p.h(paramList, "list");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      Object localObject = ((oa)paramList.next()).Gbx;
      if (localObject != null)
      {
        localObject = ((mq)localObject).FYQ;
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