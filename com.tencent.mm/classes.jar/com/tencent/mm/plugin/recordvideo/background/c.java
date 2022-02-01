package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.c.go;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class c
  extends go
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "VideoEditInfo";
  private static final com.tencent.mm.sdk.e.c.a hEe;
  public static final a xug;
  private csd xue;
  private afy xuf;
  
  static
  {
    AppMethodBeat.i(75182);
    xug = new a((byte)0);
    hEe = go.Vv();
    TABLE = "VideoEditInfo";
    INDEX_CREATE = go.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public c()
  {
    AppMethodBeat.i(75181);
    this.xue = new csd();
    this.xuf = new afy();
    AppMethodBeat.o(75181);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    p.g(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final csd dED()
  {
    AppMethodBeat.i(75176);
    Object localObject1 = (a)new csd();
    Object localObject3 = this.field_location;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (csd)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new csd();
      }
      AppMethodBeat.o(75176);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final afy dEE()
  {
    AppMethodBeat.i(75178);
    afy localafy = new afy();
    a locala = (a)localafy;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localafy;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean dEF()
  {
    return this.field_fromScene == 3;
  }
  
  public final aif dEG()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new aif();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (aif)localObject1;
      AppMethodBeat.o(75180);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(75179);
    com.tencent.mm.sdk.e.c.a locala = hEe;
    p.g(locala, "INFO");
    AppMethodBeat.o(75179);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
  public static final class b
  {
    private static final int OK = 2;
    private static final int xuh = 1;
    private static final int xui = 3;
    public static final b xuj;
    
    static
    {
      AppMethodBeat.i(75175);
      xuj = new b();
      xuh = 1;
      OK = 2;
      xui = 3;
      AppMethodBeat.o(75175);
    }
    
    public static int bwj()
    {
      return OK;
    }
    
    public static int dEK()
    {
      return xuh;
    }
    
    public static int dEL()
    {
      return xui;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c
 * JD-Core Version:    0.7.0.1
 */