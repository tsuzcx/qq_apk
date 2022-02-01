package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"})
public final class a
{
  public static final a Hes;
  
  static
  {
    AppMethodBeat.i(39622);
    Hes = new a();
    AppMethodBeat.o(39622);
  }
  
  public static final List<pw> a(pv parampv)
  {
    AppMethodBeat.i(39617);
    p.k(parampv, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    parampv = parampv.RYf;
    p.j(parampv, "menuInfo.button_list");
    parampv = ((Iterable)parampv).iterator();
    while (parampv.hasNext())
    {
      pw localpw = (pw)parampv.next();
      switch (localpw.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localpw.RYg;
        p.j(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((pw)localObject3).type)
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
          localObject2 = new pw();
          ((pw)localObject2).parseFrom(localpw.toByteArray());
          ((pw)localObject2).RYg.clear();
          ((pw)localObject2).RYg.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
      case 6: 
        localArrayList.add(localpw);
      }
    }
    parampv = (List)localArrayList;
    AppMethodBeat.o(39617);
    return parampv;
  }
  
  public static void a(op paramop)
  {
    AppMethodBeat.i(169906);
    if (paramop != null)
    {
      paramop = paramop.RWC;
      if (paramop != null)
      {
        paramop = ((Iterable)paramop).iterator();
        while (paramop.hasNext())
        {
          Object localObject1 = (oo)paramop.next();
          if (localObject1 != null)
          {
            localObject1 = ((oo)localObject1).RWB;
            if (localObject1 != null)
            {
              localObject1 = ((mz)localObject1).RTM;
              if (localObject1 != null)
              {
                localObject1 = ((Iterable)localObject1).iterator();
                label79:
                Object localObject2;
                while (((Iterator)localObject1).hasNext())
                {
                  my localmy = (my)((Iterator)localObject1).next();
                  if ((localmy != null) && (localmy.RTG == 1) && (!Util.isNullOrNil(localmy.RTk)))
                  {
                    localObject2 = b.svR;
                    localObject2 = localmy.RTk;
                    p.j(localObject2, "detail.ContentUrl");
                    if (localmy.lpq != 1) {
                      break label157;
                    }
                  }
                }
                label157:
                for (boolean bool = true;; bool = false)
                {
                  b.aJ((String)localObject2, bool);
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
  
  private static String aUV(String paramString)
  {
    AppMethodBeat.i(275999);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = h.ae(com.tencent.mm.ao.q.class);
    p.j(localObject, "MMKernel.service(IBizService::class.java)");
    localObject = ((com.tencent.mm.ao.q)localObject).bjl();
    if (!u.agG((String)localObject)) {
      u.bBD((String)localObject);
    }
    paramString = (String)localObject + "profile_resp_" + MD5Util.getMD5String(paramString);
    AppMethodBeat.o(275999);
    return paramString;
  }
  
  public static final pd aUW(String paramString)
  {
    AppMethodBeat.i(39619);
    p.k(paramString, "userName");
    pd localpd = new pd();
    try
    {
      paramString = u.aY(aUV(paramString), 0, -1);
      if (paramString != null) {
        localpd.parseFrom(paramString);
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
    return localpd;
  }
  
  public static final void b(pd parampd)
  {
    AppMethodBeat.i(39618);
    p.k(parampd, "resp");
    try
    {
      Object localObject1 = parampd.RXs.UserName;
      p.j(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new com.tencent.mm.vfs.q(aUV((String)localObject1));
      if (((com.tencent.mm.vfs.q)localObject1).ifE()) {
        ((com.tencent.mm.vfs.q)localObject1).cFq();
      }
      localObject1 = ((com.tencent.mm.vfs.q)localObject1).bOF();
      Object localObject2 = parampd.RXu;
      if (localObject2 != null)
      {
        localObject2 = ((op)localObject2).RWC;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (oo)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((oo)localObject3).RWB;
              if (localObject3 != null)
              {
                localObject3 = ((mz)localObject3).RTM;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    my localmy = (my)((Iterator)localObject3).next();
                    if (localmy.RTF != null) {
                      localmy.RTF = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      u.H((String)localObject1, parampd.toByteArray());
    }
    catch (Exception parampd)
    {
      AppMethodBeat.o(39618);
      return;
    }
    AppMethodBeat.o(39618);
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(276000);
    p.k(paramString, "userName");
    try
    {
      paramString = new com.tencent.mm.vfs.q(aUV(paramString));
      if (paramString.ifE()) {
        paramString.cFq();
      }
      AppMethodBeat.o(276000);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(276000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a
 * JD-Core Version:    0.7.0.1
 */