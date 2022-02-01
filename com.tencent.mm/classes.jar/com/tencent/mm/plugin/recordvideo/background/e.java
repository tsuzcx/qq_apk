package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.ge;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "Lcom/tencent/mm/autogen/table/BaseVideoEditInfo;", "()V", "editorProtoData", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "getEditorProtoData", "()Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "setEditorProtoData", "(Lcom/tencent/mm/protocal/protobuf/EditorProtoData;)V", "fromChatting", "", "getFromChatting", "()Z", "setFromChatting", "(Z)V", "fromFav", "getFromFav", "setFromFav", "fromGame", "getFromGame", "setFromGame", "fromSns", "getFromSns", "setFromSns", "fromStory", "getFromStory", "setFromStory", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;)V", "value", "", "mixRetryTime", "getMixRetryTime", "()I", "setMixRetryTime", "(I)V", "", "taskId", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "checkMix", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "getReportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "Companion", "STATUS", "plugin-recordvideo_release"})
public final class e
  extends ge
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "VideoEditInfo";
  private static final c.a hlR;
  public static final e.a wmq;
  private cna wmo;
  private adp wmp;
  
  static
  {
    AppMethodBeat.i(75182);
    wmq = new e.a((byte)0);
    hlR = ge.Th();
    TABLE = "VideoEditInfo";
    INDEX_CREATE = ge.INDEX_CREATE;
    AppMethodBeat.o(75182);
  }
  
  public e()
  {
    AppMethodBeat.i(75181);
    this.wmo = new cna();
    this.wmp = new adp();
    AppMethodBeat.o(75181);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(75177);
    String str = this.field_taskId;
    k.g(str, "field_taskId");
    AppMethodBeat.o(75177);
    return str;
  }
  
  public final cna duh()
  {
    AppMethodBeat.i(75176);
    Object localObject1 = (a)new cna();
    Object localObject3 = this.field_location;
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (cna)localObject1;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new cna();
      }
      AppMethodBeat.o(75176);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final adp dui()
  {
    AppMethodBeat.i(75178);
    adp localadp = new adp();
    a locala = (a)localadp;
    byte[] arrayOfByte = this.field_baseItemData;
    try
    {
      locala.parseFrom(arrayOfByte);
      AppMethodBeat.o(75178);
      return localadp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { localException });
      }
    }
  }
  
  public final boolean duj()
  {
    return this.field_fromScene == 3;
  }
  
  public final afq duk()
  {
    AppMethodBeat.i(75180);
    Object localObject1 = (a)new afq();
    byte[] arrayOfByte = this.field_extraConfig;
    try
    {
      ((a)localObject1).parseFrom(arrayOfByte);
      localObject1 = (afq)localObject1;
      AppMethodBeat.o(75180);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
      }
    }
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75179);
    c.a locala = hlR;
    k.g(locala, "INFO");
    AppMethodBeat.o(75179);
    return locala;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
  public static final class b
  {
    private static final int OK = 2;
    private static final int wmr = 1;
    private static final int wms = 3;
    public static final b wmt;
    
    static
    {
      AppMethodBeat.i(75175);
      wmt = new b();
      wmr = 1;
      OK = 2;
      wms = 3;
      AppMethodBeat.o(75175);
    }
    
    public static int bsf()
    {
      return OK;
    }
    
    public static int duo()
    {
      return wmr;
    }
    
    public static int dup()
    {
      return wms;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.e
 * JD-Core Version:    0.7.0.1
 */