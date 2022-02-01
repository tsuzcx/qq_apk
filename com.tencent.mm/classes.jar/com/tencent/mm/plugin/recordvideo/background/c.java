package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.id;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS_", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends id
{
  private static final String[] INDEX_CREATE;
  public static final c.a NDN;
  private static final IAutoDBItem.MAutoDBInfo nVV;
  private static final String ptT;
  private enw NDO;
  private ami NDP;
  
  static
  {
    AppMethodBeat.i(75182);
    NDN = new c.a((byte)0);
    nVV = id.aJm();
    ptT = "VideoEditInfo";
    INDEX_CREATE = id.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public c()
  {
    AppMethodBeat.i(75181);
    this.NDO = new enw();
    this.NDP = new ami();
    AppMethodBeat.o(75181);
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    s.s(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final enw gGC()
  {
    AppMethodBeat.i(75176);
    Object localObject = (a)new enw();
    byte[] arrayOfByte = this.field_location;
    try
    {
      ((a)localObject).parseFrom(arrayOfByte);
      localObject = (enw)localObject;
      if (localObject == null)
      {
        localObject = new enw();
        AppMethodBeat.o(75176);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      enw localenw;
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        localenw = null;
      }
      AppMethodBeat.o(75176);
      return localenw;
    }
  }
  
  public final ami gGD()
  {
    AppMethodBeat.i(75178);
    ami localami = new ami();
    a locala = (a)localami;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localami;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean gGE()
  {
    return this.field_fromScene == 3;
  }
  
  public final apw gGF()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new apw();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (apw)localObject1;
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
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = nVV;
    s.s(localMAutoDBInfo, "INFO");
    AppMethodBeat.o(75179);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c
 * JD-Core Version:    0.7.0.1
 */