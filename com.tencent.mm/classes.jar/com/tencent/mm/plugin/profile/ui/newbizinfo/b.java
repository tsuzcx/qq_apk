package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ProfileV2;", "", "()V", "TAG", "", "profileCachePath", "kotlin.jvm.PlatformType", "getProfileCachePath", "()Ljava/lang/String;", "clear", "", "userName", "get", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "indexOf", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/MessageInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "index", "", "processServiceInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenuButton;", "menuInfo", "Lcom/tencent/mm/protocal/protobuf/BizServiceMenu;", "save", "resp", "sizeOf", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "updatePayStatus", "msgList", "pickAppMsg", "toFileName", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Ncd;
  
  static
  {
    AppMethodBeat.i(39622);
    Ncd = new b();
    AppMethodBeat.o(39622);
  }
  
  public static final List<rg> a(rf paramrf)
  {
    AppMethodBeat.i(39617);
    s.u(paramrf, "menuInfo");
    ArrayList localArrayList = new ArrayList();
    paramrf = paramrf.YWe;
    s.s(paramrf, "menuInfo.button_list");
    paramrf = ((Iterable)paramrf).iterator();
    while (paramrf.hasNext())
    {
      rg localrg = (rg)paramrf.next();
      switch (localrg.type)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        break;
      case 0: 
        Object localObject1 = localrg.YWf;
        s.s(localObject1, "button.sub_button_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          switch (((rg)localObject3).type)
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
          localObject2 = new rg();
          ((rg)localObject2).parseFrom(localrg.toByteArray());
          ((rg)localObject2).YWf.clear();
          ((rg)localObject2).YWf.addAll((Collection)localObject1);
          localArrayList.add(localObject2);
          break;
        }
      case 2: 
      case 5: 
      case 6: 
        localArrayList.add(localrg);
      }
    }
    paramrf = (List)localArrayList;
    AppMethodBeat.o(39617);
    return paramrf;
  }
  
  public static void a(py parampy)
  {
    AppMethodBeat.i(169906);
    if (parampy != null)
    {
      parampy = parampy.YUi;
      if (parampy != null)
      {
        Iterator localIterator1 = ((Iterable)parampy).iterator();
        while (localIterator1.hasNext())
        {
          parampy = (px)localIterator1.next();
          if (parampy != null)
          {
            parampy = parampy.YUh;
            if (parampy != null)
            {
              parampy = parampy.YRm;
              if (parampy != null)
              {
                Iterator localIterator2 = ((Iterable)parampy).iterator();
                label80:
                od localod;
                int i;
                if (localIterator2.hasNext())
                {
                  localod = (od)localIterator2.next();
                  if ((localod == null) || (localod.YRg != 1)) {
                    break label171;
                  }
                  i = 1;
                  label118:
                  if (i == 0) {
                    break label174;
                  }
                  if (localod != null) {
                    break label176;
                  }
                  parampy = null;
                  label129:
                  if (Util.isNullOrNil(parampy)) {
                    break label183;
                  }
                  parampy = com.tencent.mm.plugin.brandservice.model.b.vBC;
                  parampy = localod.YQK;
                  s.s(parampy, "detail.ContentUrl");
                  if (localod.nUt != 1) {
                    break label185;
                  }
                }
                label171:
                label174:
                label176:
                label183:
                label185:
                for (boolean bool = true;; bool = false)
                {
                  com.tencent.mm.plugin.brandservice.model.b.aV(parampy, bool);
                  break label80;
                  break;
                  i = 0;
                  break label118;
                  break label80;
                  parampy = localod.YQK;
                  break label129;
                  break label80;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(169906);
  }
  
  public static final void a(qm paramqm)
  {
    AppMethodBeat.i(39618);
    s.u(paramqm, "resp");
    Object localObject1;
    try
    {
      localObject1 = paramqm.YVl.UserName;
      s.s(localObject1, "resp.AccountInfo.UserName");
      localObject1 = new u(aSc((String)localObject1));
      if (((u)localObject1).jKS()) {
        ((u)localObject1).diJ();
      }
      localObject1 = ah.v(((u)localObject1).jKT());
      Object localObject2 = paramqm.YVn;
      if (localObject2 != null)
      {
        localObject2 = ((py)localObject2).YUi;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (px)((Iterator)localObject2).next();
            if (localObject3 != null)
            {
              localObject3 = ((px)localObject3).YUh;
              if (localObject3 != null)
              {
                localObject3 = ((oe)localObject3).YRm;
                if (localObject3 != null)
                {
                  localObject3 = ((Iterable)localObject3).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    od localod = (od)((Iterator)localObject3).next();
                    if (localod.YRf != null) {
                      localod.YRf = null;
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramqm = paramqm.toByteArray();
    }
    catch (Exception paramqm)
    {
      AppMethodBeat.o(39618);
      return;
    }
    y.f((String)localObject1, paramqm, paramqm.length);
    AppMethodBeat.o(39618);
  }
  
  private static String aSc(String paramString)
  {
    AppMethodBeat.i(305725);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = ((q)h.ax(q.class)).bGV();
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    paramString = str + "profile_resp_" + MD5Util.getMD5String(paramString);
    AppMethodBeat.o(305725);
    return paramString;
  }
  
  public static final qm aSd(String paramString)
  {
    AppMethodBeat.i(39619);
    s.u(paramString, "userName");
    qm localqm = new qm();
    try
    {
      paramString = y.bi(aSc(paramString), 0, -1);
      if (paramString != null) {
        localqm.parseFrom(paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProfileV2", s.X("readFromFile ex=", paramString.getMessage()));
      }
    }
    AppMethodBeat.o(39619);
    return localqm;
  }
  
  public static final void clear(String paramString)
  {
    AppMethodBeat.i(305739);
    s.u(paramString, "userName");
    try
    {
      paramString = new u(aSc(paramString));
      if (paramString.jKS()) {
        paramString.diJ();
      }
      AppMethodBeat.o(305739);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(305739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b
 * JD-Core Version:    0.7.0.1
 */