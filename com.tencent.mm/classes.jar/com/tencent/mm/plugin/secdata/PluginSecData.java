package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.p.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/PluginSecData;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/secdata/IPluginSecData;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getOnlyMemory", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "subType", "", "id", "(ILjava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithClear", "clazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;", "getWithClearSync", "(ILjava/lang/String;Ljava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithoutClear", "getWithoutClearSync", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "removeFromMemory", "removeFromStorage", "removeFromStorageSync", "", "updateOnlyMemory", "value", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "updateWithSave", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;)V", "updateWithSaveSync", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Z", "plugin-sec-data_release"})
public final class PluginSecData
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, g
{
  private final String TAG = "MicroMsg.SecData.PluginSecData";
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final <T extends com.tencent.mm.cd.a> T getOnlyMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(198164);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.JbR;
      paramString = (com.tencent.mm.cd.a)com.tencent.mm.plugin.secdata.a.c.fFr().get(paramString);
      AppMethodBeat.o(198164);
      return paramString;
    }
    AppMethodBeat.o(198164);
    return null;
  }
  
  public final <T extends com.tencent.mm.cd.a> void getWithClear(final int paramInt, String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(198172);
    if (paramString != null)
    {
      com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new a(paramString, this, paramInt, paramClass, parami));
      AppMethodBeat.o(198172);
      return;
    }
    com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new b(parami));
    AppMethodBeat.o(198172);
  }
  
  public final <T extends com.tencent.mm.cd.a> T getWithClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(198184);
    Object localObject;
    com.tencent.mm.plugin.secdata.a.b localb;
    if (paramString != null)
    {
      localObject = com.tencent.mm.plugin.p.d.EiT;
      localObject = (com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)d.a.bj(com.tencent.mm.plugin.secdata.a.a.class)).bi(com.tencent.mm.plugin.secdata.a.d.class);
      localb = ((com.tencent.mm.plugin.secdata.a.d)localObject).aXJ(paramInt + '_' + paramString);
      if (localb != null) {
        if (paramClass != null) {
          paramString = (com.tencent.mm.cd.a)paramClass.newInstance();
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.parseFrom(localb.field_data);
        label93:
        com.tencent.mm.plugin.p.h.b((com.tencent.mm.plugin.p.h)localObject, (IAutoDBItem)localb, false, false, 6);
        AppMethodBeat.o(198184);
        return paramString;
        paramString = null;
        continue;
        AppMethodBeat.o(198184);
        return null;
        AppMethodBeat.o(198184);
        return null;
      }
      catch (Exception paramClass)
      {
        break label93;
      }
    }
  }
  
  public final <T extends com.tencent.mm.cd.a> void getWithoutClear(final int paramInt, String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(198177);
    Log.i(this.TAG, "getWithoutClear subType:" + paramInt + " id:" + paramString);
    if (paramString != null)
    {
      com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new c(paramString, this, paramInt, paramClass, parami));
      AppMethodBeat.o(198177);
      return;
    }
    com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new d(parami));
    AppMethodBeat.o(198177);
  }
  
  public final <T extends com.tencent.mm.cd.a> T getWithoutClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(198187);
    Object localObject;
    if (paramString != null)
    {
      localObject = com.tencent.mm.plugin.p.d.EiT;
      localObject = ((com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)d.a.bj(com.tencent.mm.plugin.secdata.a.a.class)).bi(com.tencent.mm.plugin.secdata.a.d.class)).aXJ(paramInt + '_' + paramString);
      if (localObject != null) {
        if (paramClass != null) {
          paramString = (com.tencent.mm.cd.a)paramClass.newInstance();
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {}
      try
      {
        paramString.parseFrom(((com.tencent.mm.plugin.secdata.a.b)localObject).field_data);
        label89:
        AppMethodBeat.o(198187);
        return paramString;
        paramString = null;
        continue;
        AppMethodBeat.o(198187);
        return null;
        AppMethodBeat.o(198187);
        return null;
      }
      catch (Exception paramClass)
      {
        break label89;
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
    AppMethodBeat.i(198162);
    try
    {
      paramc = com.tencent.mm.kernel.h.aHG();
      p.j(paramc, "MMKernel.storage()");
      paramc = paramc.aHp().get(ar.a.VwE, Integer.valueOf(0));
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHl() + "secdata/";
      localObject1 = (String)localObject2 + "SecData.db";
      if ((p.h(paramc, Integer.valueOf(2)) ^ true))
      {
        Log.i(this.TAG, "diff version, delete old db;");
        u.deleteDir((String)localObject2);
      }
      paramc = com.tencent.mm.plugin.p.d.EiT;
      if (((com.tencent.mm.plugin.secdata.a.a)d.a.bj(com.tencent.mm.plugin.secdata.a.a.class)).aNf((String)localObject1))
      {
        paramc = com.tencent.mm.kernel.h.aHG();
        p.j(paramc, "MMKernel.storage()");
        paramc.aHp().set(ar.a.VwE, Integer.valueOf(2));
      }
      com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new e(this));
      AppMethodBeat.o(198162);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramc, "create sec data db", new Object[0]);
      AppMethodBeat.o(198162);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(198156);
    com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.JbR;
    com.tencent.mm.plugin.secdata.a.c.clear();
    AppMethodBeat.o(198156);
  }
  
  public final void parallelsDependency() {}
  
  public final void removeFromMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(198169);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.JbR;
      com.tencent.mm.plugin.secdata.a.c.fFr().remove(paramString);
      AppMethodBeat.o(198169);
      return;
    }
    AppMethodBeat.o(198169);
  }
  
  public final <T extends com.tencent.mm.cd.a> void removeFromStorage(final int paramInt, String paramString, final i<T> parami)
  {
    AppMethodBeat.i(198190);
    if (paramString != null)
    {
      com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new f(paramString, paramInt, parami));
      AppMethodBeat.o(198190);
      return;
    }
    com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new g(parami));
    AppMethodBeat.o(198190);
  }
  
  public final boolean removeFromStorageSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(198189);
    if (paramString != null)
    {
      d.a locala = com.tencent.mm.plugin.p.d.EiT;
      if (((com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)d.a.bj(com.tencent.mm.plugin.secdata.a.a.class)).bi(com.tencent.mm.plugin.secdata.a.d.class)).aXK(paramInt + '_' + paramString) > 0)
      {
        AppMethodBeat.o(198189);
        return true;
      }
      AppMethodBeat.o(198189);
      return false;
    }
    AppMethodBeat.o(198189);
    return false;
  }
  
  public final <T extends com.tencent.mm.cd.a> void updateOnlyMemory(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(198168);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      Object localObject = com.tencent.mm.plugin.secdata.a.c.JbR;
      localObject = (Map)com.tencent.mm.plugin.secdata.a.c.fFr();
      if (paramT == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
        AppMethodBeat.o(198168);
        throw paramString;
      }
      ((Map)localObject).put(paramString, paramT);
      AppMethodBeat.o(198168);
      return;
    }
    AppMethodBeat.o(198168);
  }
  
  public final <T extends com.tencent.mm.cd.a> void updateWithSave(final int paramInt, final String paramString, final T paramT, final i<T> parami)
  {
    AppMethodBeat.i(198179);
    if (paramString != null)
    {
      com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new h(paramString, this, paramInt, paramString, paramT, parami));
      AppMethodBeat.o(198179);
      return;
    }
    com.tencent.mm.ae.d.c("SecDBTag", (kotlin.g.a.a)new i(parami, paramT));
    AppMethodBeat.o(198179);
  }
  
  public final <T extends com.tencent.mm.cd.a> boolean updateWithSaveSync(int paramInt, String paramString, T paramT)
  {
    Object localObject1 = null;
    com.tencent.mm.plugin.secdata.a.b localb1 = null;
    AppMethodBeat.i(198182);
    if (paramString != null)
    {
      Object localObject2 = com.tencent.mm.plugin.p.d.EiT;
      localObject2 = (com.tencent.mm.plugin.secdata.a.d)((com.tencent.mm.plugin.secdata.a.a)d.a.bj(com.tencent.mm.plugin.secdata.a.a.class)).bi(com.tencent.mm.plugin.secdata.a.d.class);
      String str = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.b localb2 = ((com.tencent.mm.plugin.secdata.a.d)localObject2).aXJ(str);
      if (localb2 != null)
      {
        localb2.field_originId = paramString;
        localb2.field_type = paramInt;
        paramString = localb1;
        if (paramT != null) {
          paramString = paramT.toByteArray();
        }
        localb2.field_data = paramString;
        localb2.field_updateTime = cm.bfE();
        localb2.field_expireTime = (localb2.field_updateTime + 259200000L);
        if (com.tencent.mm.plugin.p.h.b((com.tencent.mm.plugin.p.h)localObject2, (IAutoDBItem)localb2) > 0L)
        {
          AppMethodBeat.o(198182);
          return true;
        }
        AppMethodBeat.o(198182);
        return false;
      }
      localb1 = new com.tencent.mm.plugin.secdata.a.b();
      localb1.field_id = str;
      localb1.field_originId = paramString;
      localb1.field_createTime = cm.bfE();
      localb1.field_updateTime = localb1.field_createTime;
      localb1.field_expireTime = (localb1.field_updateTime + 259200000L);
      localb1.field_type = paramInt;
      paramString = localObject1;
      if (paramT != null) {
        paramString = paramT.toByteArray();
      }
      localb1.field_data = paramString;
      boolean bool = com.tencent.mm.plugin.p.h.a((com.tencent.mm.plugin.p.h)localObject2, (IAutoDBItem)localb1, false, false, 6);
      AppMethodBeat.o(198182);
      return bool;
    }
    AppMethodBeat.o(198182);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(String paramString, PluginSecData paramPluginSecData, int paramInt, Class paramClass, i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$2$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(String paramString, PluginSecData paramPluginSecData, int paramInt, Class paramClass, i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$2$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(PluginSecData paramPluginSecData)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(String paramString, int paramInt, i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$2$1"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(String paramString1, PluginSecData paramPluginSecData, int paramInt, String paramString2, com.tencent.mm.cd.a parama, i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$2$1"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(i parami, com.tencent.mm.cd.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.PluginSecData
 * JD-Core Version:    0.7.0.1
 */