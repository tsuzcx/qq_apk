package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/PluginSecData;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/secdata/IPluginSecData;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getOnlyMemory", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "subType", "", "id", "(ILjava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithClear", "clazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;", "getWithClearSync", "(ILjava/lang/String;Ljava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithoutClear", "getWithoutClearSync", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "removeFromMemory", "removeFromStorage", "removeFromStorageSync", "", "updateOnlyMemory", "value", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "updateWithSave", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;)V", "expireTime", "", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;JLcom/tencent/mm/plugin/secdata/ISecReportDataCallback;)V", "updateWithSaveSync", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Z", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginSecData
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, g
{
  private final String TAG = "MicroMsg.SecData.PluginSecData";
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final <T extends com.tencent.mm.bx.a> T getOnlyMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(261502);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.PlH;
      paramString = (com.tencent.mm.bx.a)com.tencent.mm.plugin.secdata.a.c.gUz().get(paramString);
      AppMethodBeat.o(261502);
      return paramString;
    }
    AppMethodBeat.o(261502);
    return null;
  }
  
  public final <T extends com.tencent.mm.bx.a> void getWithClear(int paramInt, final String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(261528);
    if (paramString == null) {}
    for (paramString = null;; paramString = ah.aiuX)
    {
      if (paramString == null) {
        com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new b(parami));
      }
      AppMethodBeat.o(261528);
      return;
      com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new a(paramInt, paramString, this, paramClass, parami));
    }
  }
  
  public final <T extends com.tencent.mm.bx.a> T getWithClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(261560);
    Object localObject;
    com.tencent.mm.plugin.secdata.a.b localb;
    if (paramString != null)
    {
      localObject = com.tencent.mm.plugin.ac.a.MnH;
      localObject = (com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)a.a.bW(com.tencent.mm.plugin.secdata.a.a.class)).bV(com.tencent.mm.plugin.secdata.a.d.class);
      localb = ((com.tencent.mm.plugin.secdata.a.d)localObject).aVs(paramInt + '_' + paramString);
      if (localb != null) {
        if (paramClass == null) {
          paramString = null;
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.parseFrom(localb.field_data);
        label87:
        com.tencent.mm.plugin.ac.g.b((com.tencent.mm.plugin.ac.g)localObject, (IAutoDBItem)localb, false, false, 6);
        AppMethodBeat.o(261560);
        return paramString;
        paramString = (com.tencent.mm.bx.a)paramClass.newInstance();
        continue;
        AppMethodBeat.o(261560);
        return null;
        AppMethodBeat.o(261560);
        return null;
      }
      catch (Exception paramClass)
      {
        break label87;
      }
    }
  }
  
  public final <T extends com.tencent.mm.bx.a> void getWithoutClear(int paramInt, final String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(261535);
    Log.i(this.TAG, "getWithoutClear subType:" + paramInt + " id:" + paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = ah.aiuX)
    {
      if (paramString == null) {
        com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new d(parami));
      }
      AppMethodBeat.o(261535);
      return;
      com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new c(paramInt, paramString, this, paramClass, parami));
    }
  }
  
  public final <T extends com.tencent.mm.bx.a> T getWithoutClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(261565);
    Object localObject;
    if (paramString != null)
    {
      localObject = com.tencent.mm.plugin.ac.a.MnH;
      localObject = ((com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)a.a.bW(com.tencent.mm.plugin.secdata.a.a.class)).bV(com.tencent.mm.plugin.secdata.a.d.class)).aVs(paramInt + '_' + paramString);
      if (localObject != null) {
        if (paramClass == null) {
          paramString = null;
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.parseFrom(((com.tencent.mm.plugin.secdata.a.b)localObject).field_data);
        label83:
        AppMethodBeat.o(261565);
        return paramString;
        paramString = (com.tencent.mm.bx.a)paramClass.newInstance();
        continue;
        AppMethodBeat.o(261565);
        return null;
        AppMethodBeat.o(261565);
        return null;
      }
      catch (Exception paramClass)
      {
        break label83;
      }
    }
  }
  
  public final void installed() {}
  
  public final String name()
  {
    return "PluginSecData";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(261497);
    try
    {
      Object localObject = h.baE().ban().get(at.a.acYp, Integer.valueOf(0));
      String str = s.X(h.baE().cachePath, "secdata/");
      paramc = s.X(str, "SecData.db");
      if (!s.p(localObject, Integer.valueOf(2)))
      {
        Log.i(this.TAG, "diff version, delete old db;");
        y.ew(str, true);
      }
      localObject = com.tencent.mm.plugin.ac.a.MnH;
      if (((com.tencent.mm.plugin.secdata.a.a)a.a.bW(com.tencent.mm.plugin.secdata.a.a.class)).aPK(paramc)) {
        h.baE().ban().set(at.a.acYp, Integer.valueOf(2));
      }
      com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new PluginSecData.e(this));
      AppMethodBeat.o(261497);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramc, "create sec data db", new Object[0]);
      AppMethodBeat.o(261497);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(261490);
    com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.PlH;
    com.tencent.mm.plugin.secdata.a.c.clear();
    AppMethodBeat.o(261490);
  }
  
  public final void parallelsDependency() {}
  
  public final void removeFromMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(261520);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.PlH;
      com.tencent.mm.plugin.secdata.a.c.gUz().remove(paramString);
    }
    AppMethodBeat.o(261520);
  }
  
  public final <T extends com.tencent.mm.bx.a> void removeFromStorage(int paramInt, final String paramString, final i<T> parami)
  {
    AppMethodBeat.i(261578);
    if (paramString == null) {}
    for (paramString = null;; paramString = ah.aiuX)
    {
      if (paramString == null) {
        com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new g(parami));
      }
      AppMethodBeat.o(261578);
      return;
      com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new f(paramInt, paramString, parami));
    }
  }
  
  public final boolean removeFromStorageSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(261572);
    if (paramString != null)
    {
      a.a locala = com.tencent.mm.plugin.ac.a.MnH;
      if (((com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)a.a.bW(com.tencent.mm.plugin.secdata.a.a.class)).bV(com.tencent.mm.plugin.secdata.a.d.class)).aVt(paramInt + '_' + paramString) > 0)
      {
        AppMethodBeat.o(261572);
        return true;
      }
      AppMethodBeat.o(261572);
      return false;
    }
    AppMethodBeat.o(261572);
    return false;
  }
  
  public final <T extends com.tencent.mm.bx.a> void updateOnlyMemory(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(261512);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      Object localObject = com.tencent.mm.plugin.secdata.a.c.PlH;
      localObject = (Map)com.tencent.mm.plugin.secdata.a.c.gUz();
      if (paramT == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
        AppMethodBeat.o(261512);
        throw paramString;
      }
      ((Map)localObject).put(paramString, paramT);
    }
    AppMethodBeat.o(261512);
  }
  
  public final <T extends com.tencent.mm.bx.a> void updateWithSave(int paramInt, final String paramString, final T paramT, final long paramLong, i<T> parami)
  {
    AppMethodBeat.i(261550);
    if (paramString == null) {}
    for (paramString = null;; paramString = ah.aiuX)
    {
      if (paramString == null) {
        com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new i(parami, paramT));
      }
      AppMethodBeat.o(261550);
      return;
      com.tencent.mm.ae.d.e("SecDBTag", (kotlin.g.a.a)new h(paramInt, paramString, this, paramString, paramT, paramLong, parami));
    }
  }
  
  public final <T extends com.tencent.mm.bx.a> void updateWithSave(int paramInt, String paramString, T paramT, i<T> parami)
  {
    AppMethodBeat.i(261542);
    updateWithSave(paramInt, paramString, paramT, 259200000L, parami);
    AppMethodBeat.o(261542);
  }
  
  public final <T extends com.tencent.mm.bx.a> boolean updateWithSaveSync(int paramInt, String paramString, T paramT)
  {
    Object localObject1 = null;
    com.tencent.mm.plugin.secdata.a.b localb1 = null;
    AppMethodBeat.i(261556);
    if (paramString != null)
    {
      Object localObject2 = com.tencent.mm.plugin.ac.a.MnH;
      localObject2 = (com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)a.a.bW(com.tencent.mm.plugin.secdata.a.a.class)).bV(com.tencent.mm.plugin.secdata.a.d.class);
      String str = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.b localb2 = ((com.tencent.mm.plugin.secdata.a.d)localObject2).aVs(str);
      if (localb2 != null)
      {
        localb2.field_originId = paramString;
        localb2.field_type = paramInt;
        if (paramT == null) {}
        for (paramString = localb1;; paramString = paramT.toByteArray())
        {
          localb2.field_data = paramString;
          localb2.field_updateTime = cn.bDw();
          localb2.field_expireTime = (localb2.field_updateTime + 259200000L);
          if (com.tencent.mm.plugin.ac.g.b((com.tencent.mm.plugin.ac.g)localObject2, (IAutoDBItem)localb2) <= 0L) {
            break;
          }
          AppMethodBeat.o(261556);
          return true;
        }
        AppMethodBeat.o(261556);
        return false;
      }
      localb1 = new com.tencent.mm.plugin.secdata.a.b();
      localb1.field_id = str;
      localb1.field_originId = paramString;
      localb1.field_createTime = cn.bDw();
      localb1.field_updateTime = localb1.field_createTime;
      localb1.field_expireTime = (localb1.field_updateTime + 259200000L);
      localb1.field_type = paramInt;
      if (paramT == null) {}
      for (paramString = localObject1;; paramString = paramT.toByteArray())
      {
        localb1.field_data = paramString;
        boolean bool = com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)localObject2, (IAutoDBItem)localb1, false, false, 6);
        AppMethodBeat.o(261556);
        return bool;
      }
    }
    AppMethodBeat.o(261556);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(int paramInt, String paramString, PluginSecData paramPluginSecData, Class<T> paramClass, i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(int paramInt, String paramString, PluginSecData paramPluginSecData, Class<T> paramClass, i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(int paramInt, String paramString, i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(int paramInt, String paramString1, PluginSecData paramPluginSecData, String paramString2, T paramT, long paramLong, i<T> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(i<T> parami, T paramT)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.PluginSecData
 * JD-Core Version:    0.7.0.1
 */