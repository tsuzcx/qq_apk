package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/PluginSecData;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/secdata/IPluginSecData;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "secDataDB", "Lcom/tencent/mm/plugin/secdata/model/SecDataDB;", "secReportDataInfoStorage", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getOnlyMemory", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "subType", "", "id", "(ILjava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithClear", "clazz", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;", "getWithClearSync", "(ILjava/lang/String;Ljava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getWithoutClear", "getWithoutClearSync", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "removeFromMemory", "removeFromStorage", "removeFromStorageSync", "", "updateOnlyMemory", "value", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "updateWithSave", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Lcom/tencent/mm/plugin/secdata/ISecReportDataCallback;)V", "updateWithSaveSync", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Z", "plugin-sec-data_release"})
public final class PluginSecData
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, g
{
  private com.tencent.mm.plugin.secdata.a.a CVZ;
  private com.tencent.mm.plugin.secdata.a.d CWa;
  private final String TAG = "MicroMsg.SecData.PluginSecData";
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final <T extends com.tencent.mm.bw.a> T getOnlyMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(219159);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.CWk;
      paramString = (com.tencent.mm.bw.a)com.tencent.mm.plugin.secdata.a.c.eSp().get(paramString);
      AppMethodBeat.o(219159);
      return paramString;
    }
    AppMethodBeat.o(219159);
    return null;
  }
  
  public final <T extends com.tencent.mm.bw.a> void getWithClear(final int paramInt, String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(219162);
    if (paramString != null)
    {
      com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new a(paramString, this, paramInt, paramClass, parami));
      AppMethodBeat.o(219162);
      return;
    }
    com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new b(parami));
    AppMethodBeat.o(219162);
  }
  
  public final <T extends com.tencent.mm.bw.a> T getWithClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    com.tencent.mm.bw.a locala = null;
    AppMethodBeat.i(219166);
    Object localObject;
    if (paramString != null)
    {
      localObject = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.d locald = this.CWa;
      if (locald != null)
      {
        localObject = locald.aMZ((String)localObject);
        if (localObject != null)
        {
          if (paramClass != null) {
            locala = (com.tencent.mm.bw.a)paramClass.newInstance();
          }
          if (locala == null) {}
        }
      }
    }
    try
    {
      locala.parseFrom(((com.tencent.mm.plugin.secdata.a.b)localObject).field_data);
      label91:
      paramClass = this.CWa;
      if (paramClass != null) {
        paramClass.aNa(paramString);
      }
      AppMethodBeat.o(219166);
      return locala;
      AppMethodBeat.o(219166);
      return null;
      AppMethodBeat.o(219166);
      return null;
    }
    catch (Exception paramClass)
    {
      break label91;
    }
  }
  
  public final <T extends com.tencent.mm.bw.a> void getWithoutClear(final int paramInt, String paramString, final Class<T> paramClass, final i<T> parami)
  {
    AppMethodBeat.i(219163);
    Log.i(this.TAG, "getWithoutClear subType:" + paramInt + " id:" + paramString);
    if (paramString != null)
    {
      com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new c(paramString, this, paramInt, paramClass, parami));
      AppMethodBeat.o(219163);
      return;
    }
    com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new d(parami));
    AppMethodBeat.o(219163);
  }
  
  public final <T extends com.tencent.mm.bw.a> T getWithoutClearSync(int paramInt, String paramString, Class<T> paramClass)
  {
    Object localObject1 = null;
    AppMethodBeat.i(219167);
    Object localObject2;
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      localObject2 = this.CWa;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.secdata.a.d)localObject2).aMZ(paramString);
        if (localObject2 != null)
        {
          paramString = localObject1;
          if (paramClass != null) {
            paramString = (com.tencent.mm.bw.a)paramClass.newInstance();
          }
          if (paramString == null) {}
        }
      }
    }
    try
    {
      paramString.parseFrom(((com.tencent.mm.plugin.secdata.a.b)localObject2).field_data);
      label89:
      AppMethodBeat.o(219167);
      return paramString;
      AppMethodBeat.o(219167);
      return null;
      AppMethodBeat.o(219167);
      return null;
    }
    catch (Exception paramClass)
    {
      break label89;
    }
  }
  
  public final void installed() {}
  
  public final String name()
  {
    return "PluginSecData";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(219158);
    try
    {
      paramc = com.tencent.mm.kernel.g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc = paramc.azQ().get(ar.a.Oio, Integer.valueOf(0));
      Object localObject = new StringBuilder();
      e locale = com.tencent.mm.kernel.g.aAh();
      p.g(locale, "MMKernel.storage()");
      localObject = locale.azM() + "secdata/";
      if ((p.j(paramc, Integer.valueOf(2)) ^ true))
      {
        Log.i(this.TAG, "diff version, delete old db;");
        s.deleteDir((String)localObject);
      }
      if (!s.YS((String)localObject)) {
        s.boN((String)localObject);
      }
      paramc = com.tencent.mm.kernel.g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc.azQ().set(ar.a.Oio, Integer.valueOf(2));
      paramc = new com.tencent.mm.plugin.secdata.a.a((String)localObject + "SecData.db");
      localObject = paramc.iFy;
      if (localObject != null)
      {
        localObject = new com.tencent.mm.plugin.secdata.a.d((h)localObject);
        com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new e((com.tencent.mm.plugin.secdata.a.d)localObject));
        this.CWa = ((com.tencent.mm.plugin.secdata.a.d)localObject);
      }
      this.CVZ = paramc;
      AppMethodBeat.o(219158);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramc, "create sec data db", new Object[0]);
      AppMethodBeat.o(219158);
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(219157);
    com.tencent.mm.plugin.secdata.a.a locala = this.CVZ;
    String str;
    if (locala != null)
    {
      str = locala.TAG;
      h localh = locala.iFy;
      localObject = locala.iFy;
      if (localObject == null) {
        break label161;
      }
      localObject = Boolean.valueOf(((h)localObject).isOpen());
      Log.w(str, "close db:%s isOpen:%b ", new Object[] { localh, localObject });
      if (locala.iFy != null)
      {
        localObject = locala.iFy;
        if ((localObject != null) && (((h)localObject).isOpen() == true))
        {
          str = locala.TAG;
          localObject = locala.iFy;
          if (localObject == null) {
            break label166;
          }
        }
      }
    }
    label161:
    label166:
    for (Object localObject = Boolean.valueOf(((h)localObject).inTransaction());; localObject = null)
    {
      Log.w(str, "close in trans :%b ", new Object[] { localObject });
      localObject = locala.iFy;
      if (localObject != null) {
        ((h)localObject).close();
      }
      locala.iFy = null;
      this.CWa = null;
      localObject = com.tencent.mm.plugin.secdata.a.c.CWk;
      com.tencent.mm.plugin.secdata.a.c.clear();
      AppMethodBeat.o(219157);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void parallelsDependency() {}
  
  public final void removeFromMemory(int paramInt, String paramString)
  {
    AppMethodBeat.i(219161);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.c localc = com.tencent.mm.plugin.secdata.a.c.CWk;
      com.tencent.mm.plugin.secdata.a.c.eSp().remove(paramString);
      AppMethodBeat.o(219161);
      return;
    }
    AppMethodBeat.o(219161);
  }
  
  public final <T extends com.tencent.mm.bw.a> void removeFromStorage(final int paramInt, String paramString, final i<T> parami)
  {
    AppMethodBeat.i(219169);
    if (paramString != null)
    {
      com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new f(paramString, this, paramInt, parami));
      AppMethodBeat.o(219169);
      return;
    }
    com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new g(parami));
    AppMethodBeat.o(219169);
  }
  
  public final boolean removeFromStorageSync(int paramInt, String paramString)
  {
    AppMethodBeat.i(219168);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      com.tencent.mm.plugin.secdata.a.d locald = this.CWa;
      if (locald != null) {}
      for (paramInt = locald.aNa(paramString); paramInt > 0; paramInt = 0)
      {
        AppMethodBeat.o(219168);
        return true;
      }
      AppMethodBeat.o(219168);
      return false;
    }
    AppMethodBeat.o(219168);
    return false;
  }
  
  public final <T extends com.tencent.mm.bw.a> void updateOnlyMemory(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(219160);
    if (paramString != null)
    {
      paramString = paramInt + '_' + paramString;
      Object localObject = com.tencent.mm.plugin.secdata.a.c.CWk;
      localObject = (Map)com.tencent.mm.plugin.secdata.a.c.eSp();
      if (paramT == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
        AppMethodBeat.o(219160);
        throw paramString;
      }
      ((Map)localObject).put(paramString, paramT);
      AppMethodBeat.o(219160);
      return;
    }
    AppMethodBeat.o(219160);
  }
  
  public final <T extends com.tencent.mm.bw.a> void updateWithSave(final int paramInt, final String paramString, final T paramT, final i<T> parami)
  {
    AppMethodBeat.i(219164);
    if (paramString != null)
    {
      com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new h(paramString, this, paramInt, paramString, paramT, parami));
      AppMethodBeat.o(219164);
      return;
    }
    com.tencent.mm.ac.d.c("SecDBTag", (kotlin.g.a.a)new i(parami, paramT));
    AppMethodBeat.o(219164);
  }
  
  public final <T extends com.tencent.mm.bw.a> boolean updateWithSaveSync(int paramInt, String paramString, T paramT)
  {
    AppMethodBeat.i(219165);
    if (paramString != null)
    {
      String str = paramInt + '_' + paramString;
      Object localObject = this.CWa;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.secdata.a.d)localObject).aMZ(str);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.secdata.a.b)localObject).field_originId = paramString;
          ((com.tencent.mm.plugin.secdata.a.b)localObject).field_type = paramInt;
          if (paramT != null)
          {
            paramString = paramT.toByteArray();
            ((com.tencent.mm.plugin.secdata.a.b)localObject).field_data = paramString;
            ((com.tencent.mm.plugin.secdata.a.b)localObject).field_updateTime = cl.aWA();
            ((com.tencent.mm.plugin.secdata.a.b)localObject).field_expireTime = (((com.tencent.mm.plugin.secdata.a.b)localObject).field_updateTime + 259200000L);
            paramString = this.CWa;
            if (paramString == null) {
              break label146;
            }
          }
          label146:
          for (l = paramString.b((com.tencent.mm.plugin.secdata.a.b)localObject);; l = 0L)
          {
            if (l <= 0L) {
              break label152;
            }
            AppMethodBeat.o(219165);
            return true;
            paramString = null;
            break;
          }
          label152:
          AppMethodBeat.o(219165);
          return false;
        }
      }
      PluginSecData localPluginSecData = (PluginSecData)this;
      localObject = new com.tencent.mm.plugin.secdata.a.b();
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_id = str;
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_originId = paramString;
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_createTime = cl.aWA();
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_updateTime = ((com.tencent.mm.plugin.secdata.a.b)localObject).field_createTime;
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_expireTime = (((com.tencent.mm.plugin.secdata.a.b)localObject).field_updateTime + 259200000L);
      ((com.tencent.mm.plugin.secdata.a.b)localObject).field_type = paramInt;
      if (paramT != null)
      {
        paramString = paramT.toByteArray();
        ((com.tencent.mm.plugin.secdata.a.b)localObject).field_data = paramString;
        paramString = localPluginSecData.CWa;
        if (paramString == null) {
          break label279;
        }
      }
      label279:
      for (long l = paramString.a((com.tencent.mm.plugin.secdata.a.b)localObject);; l = -1L)
      {
        if (l < 0L) {
          break label287;
        }
        AppMethodBeat.o(219165);
        return true;
        paramString = null;
        break;
      }
      label287:
      AppMethodBeat.o(219165);
      return false;
    }
    AppMethodBeat.o(219165);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(String paramString, PluginSecData paramPluginSecData, int paramInt, Class paramClass, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithClear$2$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(String paramString, PluginSecData paramPluginSecData, int paramInt, Class paramClass, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$getWithoutClear$2$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(com.tencent.mm.plugin.secdata.a.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(String paramString, PluginSecData paramPluginSecData, int paramInt, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$removeFromStorage$2$1"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$1$1"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(String paramString1, PluginSecData paramPluginSecData, int paramInt, String paramString2, com.tencent.mm.bw.a parama, i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "com/tencent/mm/plugin/secdata/PluginSecData$updateWithSave$2$1"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(i parami, com.tencent.mm.bw.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.PluginSecData
 * JD-Core Version:    0.7.0.1
 */