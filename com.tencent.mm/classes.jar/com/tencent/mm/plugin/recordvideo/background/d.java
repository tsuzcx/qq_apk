package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.c.ga;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class d
  extends ga
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "VideoEditInfo";
  private static final c.a gLr;
  public static final a vdA;
  private chx vdy;
  private acq vdz;
  
  static
  {
    AppMethodBeat.i(75182);
    vdA = new a((byte)0);
    gLr = ga.So();
    TABLE = "VideoEditInfo";
    INDEX_CREATE = ga.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public d()
  {
    AppMethodBeat.i(75181);
    this.vdy = new chx();
    this.vdz = new acq();
    AppMethodBeat.o(75181);
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    k.g(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final acq dgA()
  {
    AppMethodBeat.i(75178);
    acq localacq = new acq();
    a locala = (a)localacq;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localacq;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean dgB()
  {
    return this.field_fromScene == 3;
  }
  
  public final aer dgC()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new aer();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (aer)localObject1;
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
  
  public final chx dgz()
  {
    AppMethodBeat.i(75176);
    Object localObject1 = (a)new chx();
    Object localObject3 = this.field_location;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (chx)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new chx();
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
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75179);
    c.a locala = gLr;
    k.g(locala, "INFO");
    AppMethodBeat.o(75179);
    return locala;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.d
 * JD-Core Version:    0.7.0.1
 */