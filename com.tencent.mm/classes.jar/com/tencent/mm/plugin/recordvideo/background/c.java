package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.ha;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class c
  extends ha
{
  public static final a BKh;
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "VideoEditInfo";
  private static final IAutoDBItem.MAutoDBInfo iBg;
  private dlg BKf;
  private aio BKg;
  
  static
  {
    AppMethodBeat.i(75182);
    BKh = new a((byte)0);
    iBg = ha.ajs();
    TABLE = "VideoEditInfo";
    INDEX_CREATE = ha.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public c()
  {
    AppMethodBeat.i(75181);
    this.BKf = new dlg();
    this.BKg = new aio();
    AppMethodBeat.o(75181);
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    p.g(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final dlg eIH()
  {
    AppMethodBeat.i(75176);
    Object localObject1 = (a)new dlg();
    Object localObject3 = this.field_location;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (dlg)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new dlg();
      }
      AppMethodBeat.o(75176);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final aio eII()
  {
    AppMethodBeat.i(75178);
    aio localaio = new aio();
    a locala = (a)localaio;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localaio;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean eIJ()
  {
    return this.field_fromScene == 3;
  }
  
  public final ald eIK()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new ald();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (ald)localObject1;
      AppMethodBeat.o(75180);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(75179);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = iBg;
    p.g(localMAutoDBInfo, "INFO");
    AppMethodBeat.o(75179);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
  public static final class b
  {
    private static final int BKi = 1;
    private static final int BKj = 3;
    public static final b BKk;
    private static final int OK = 2;
    
    static
    {
      AppMethodBeat.i(75175);
      BKk = new b();
      BKi = 1;
      OK = 2;
      BKj = 3;
      AppMethodBeat.o(75175);
    }
    
    public static int bTk()
    {
      return OK;
    }
    
    public static int eIO()
    {
      return BKi;
    }
    
    public static int eIP()
    {
      return BKj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c
 * JD-Core Version:    0.7.0.1
 */