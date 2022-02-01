package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.gp;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class c
  extends gp
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "VideoEditInfo";
  private static final com.tencent.mm.sdk.e.c.a hGW;
  public static final c.a xKd;
  private csx xKb;
  private agh xKc;
  
  static
  {
    AppMethodBeat.i(75182);
    xKd = new c.a((byte)0);
    hGW = gp.VD();
    TABLE = "VideoEditInfo";
    INDEX_CREATE = gp.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public c()
  {
    AppMethodBeat.i(75181);
    this.xKb = new csx();
    this.xKc = new agh();
    AppMethodBeat.o(75181);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    p.g(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final csx dHU()
  {
    AppMethodBeat.i(75176);
    Object localObject1 = (a)new csx();
    Object localObject3 = this.field_location;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (csx)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new csx();
      }
      AppMethodBeat.o(75176);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final agh dHV()
  {
    AppMethodBeat.i(75178);
    agh localagh = new agh();
    a locala = (a)localagh;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localagh;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean dHW()
  {
    return this.field_fromScene == 3;
  }
  
  public final aip dHX()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new aip();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (aip)localObject1;
      AppMethodBeat.o(75180);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(75179);
    com.tencent.mm.sdk.e.c.a locala = hGW;
    p.g(locala, "INFO");
    AppMethodBeat.o(75179);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c
 * JD-Core Version:    0.7.0.1
 */