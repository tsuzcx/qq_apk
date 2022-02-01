package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtAllDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroom", "", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "memberList", "", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a.a<f>
{
  public static final a.a aeny;
  private final String hCy;
  private List<String> hSb;
  
  static
  {
    AppMethodBeat.i(254149);
    aeny = new a.a((byte)0);
    AppMethodBeat.o(254149);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(254146);
    this.hCy = paramString;
    AppMethodBeat.o(254146);
  }
  
  public final g<d<f>> a(LifecycleScope paramLifecycleScope, c<f> paramc)
  {
    AppMethodBeat.i(254166);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new d(paramc);
    q localq = new q();
    List localList = this.hSb;
    int j;
    int i;
    if ((localList != null) && (paramc.offset < localList.size()))
    {
      j = paramc.offset;
      if (localList.size() <= paramc.offset + paramc.pageSize) {
        break label198;
      }
      i = paramc.offset + paramc.pageSize;
      if (j >= i) {}
    }
    for (;;)
    {
      int k = j + 1;
      if (s.p((String)localList.get(j), "notify@all"))
      {
        paramc = paramLifecycleScope.pUj;
        au localau = new au();
        localau.setUsername("notify@all");
        ah localah = ah.aiuX;
        paramc.add(new f(-1, localau, 0));
      }
      if (k >= i)
      {
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = k.a((kotlinx.coroutines.a.f)localq);
        AppMethodBeat.o(254166);
        return paramLifecycleScope;
        label198:
        i = localList.size();
        break;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(254158);
    Object localObject = ((b)h.ax(b.class)).bzK().Ju(this.hCy);
    if ((localObject != null) && ((((aj)localObject).Jf(z.bAM())) || (((aj)localObject).bvK(z.bAM()))))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add("notify@all");
      ah localah = ah.aiuX;
      this.hSb = ((List)localObject);
    }
    AppMethodBeat.o(254158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.a
 * JD-Core Version:    0.7.0.1
 */