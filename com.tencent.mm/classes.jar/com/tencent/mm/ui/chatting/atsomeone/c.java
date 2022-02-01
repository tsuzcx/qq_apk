package com.tencent.mm.ui.chatting.atsomeone;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroom", "", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setChatroomMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "memberList", "", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.mvvmlist.a.a<f>
{
  public static final c.a aenz;
  private final j DHI;
  private aj HuK;
  private final String hCy;
  private List<String> hSb;
  
  static
  {
    AppMethodBeat.i(254155);
    aenz = new c.a((byte)0);
    AppMethodBeat.o(254155);
  }
  
  public c(String paramString)
  {
    AppMethodBeat.i(254151);
    this.hCy = paramString;
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.aenA);
    AppMethodBeat.o(254151);
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<f>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<f> paramc)
  {
    AppMethodBeat.i(254173);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    q localq = new q();
    Object localObject = this.hSb;
    int j;
    int i;
    if ((localObject != null) && (paramc.offset < ((List)localObject).size()))
    {
      j = paramc.offset;
      if (((List)localObject).size() > paramc.offset + paramc.pageSize)
      {
        paramLifecycleScope.ABD = true;
        i = paramc.offset + paramc.pageSize;
        paramc = new ArrayList();
        if (j >= i) {}
      }
    }
    for (;;)
    {
      int k = j + 1;
      paramc.add(((List)localObject).get(j));
      if (k >= i)
      {
        localObject = com.tencent.mm.plugin.ac.b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
            {
              paramLifecycleScope.pUj.add(new f(0, (au)localObject, 2, this.HuK));
              continue;
              i = ((List)localObject).size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)localq);
        AppMethodBeat.o(254173);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return -1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(254163);
    this.HuK = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hCy);
    List localList = v.Il(this.hCy);
    if (localList == null) {
      localList = null;
    }
    for (;;)
    {
      this.hSb = localList;
      AppMethodBeat.o(254163);
      return;
      localList.remove(z.bAM());
      Object localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("MicroMsg.Mvvm.AtSomeoneDataSource").where((ISqlCondition)az.USERNAME.inString(localList));
      Object localObject3 = com.tencent.mm.plugin.ac.a.a.MnU;
      localObject3 = ((SelectSql.Builder)localObject1).orderBy(a.a.gsC()).build();
      localObject1 = new ArrayList();
      Object localObject4 = ((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB();
      if (localObject4 != null)
      {
        localObject3 = ((ISQLiteDatabase)localObject4).rawQuery(((SelectSql)localObject3).getSql(), ((SelectSql)localObject3).getParams());
        if (localObject3 != null)
        {
          localObject3 = (Closeable)localObject3;
          try
          {
            localObject4 = (Cursor)localObject3;
            while (((Cursor)localObject4).moveToNext()) {
              ((ArrayList)localObject1).add(((Cursor)localObject4).getString(0));
            }
            localThrowable.clear();
          }
          finally
          {
            try
            {
              AppMethodBeat.o(254163);
              throw localThrowable;
            }
            finally
            {
              kotlin.f.b.a((Closeable)localObject3, localThrowable);
              AppMethodBeat.o(254163);
            }
            localObject4 = ah.aiuX;
            kotlin.f.b.a((Closeable)localObject3, null);
          }
        }
      }
      localThrowable.addAll((Collection)localObject2);
      ah localah = ah.aiuX;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b aenA;
    
    static
    {
      AppMethodBeat.i(254137);
      aenA = new b();
      AppMethodBeat.o(254137);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.c
 * JD-Core Version:    0.7.0.1
 */