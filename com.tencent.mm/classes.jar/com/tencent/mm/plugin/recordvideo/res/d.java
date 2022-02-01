package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "get", "getResParentPath", "init", "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"})
public final class d
{
  private static final String TAG = "MicroMsg.VLogPagResLogic";
  private static final String[] xHu;
  private static final a xHv;
  private static final int xHw;
  public static final d xHx;
  
  static
  {
    AppMethodBeat.i(200419);
    xHx = new d();
    TAG = "MicroMsg.VLogPagResLogic";
    xHu = new String[] { "libpag", "libvlog_pag" };
    int i;
    if (i.hgJ)
    {
      i = 40;
      xHw = i;
      if (!i.hgJ) {
        break label79;
      }
    }
    label79:
    for (a locala = (a)b.xHA;; locala = (a)a.xHz)
    {
      xHv = locala;
      AppMethodBeat.o(200419);
      return;
      i = 60;
      break;
    }
  }
  
  public static void aHq()
  {
    AppMethodBeat.i(200418);
    xHv.aHq();
    AppMethodBeat.o(200418);
  }
  
  public static a dHh()
  {
    return xHv;
  }
  
  public static void init()
  {
    AppMethodBeat.i(200416);
    xHv.init();
    AppMethodBeat.o(200416);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(200417);
    xHv.hWH.dead();
    AppMethodBeat.o(200417);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class a
    extends a
  {
    private static final g xHy;
    public static final a xHz;
    
    static
    {
      AppMethodBeat.i(200411);
      xHz = new a();
      xHy = new g(60);
      AppMethodBeat.o(200411);
    }
    
    public final int dGT()
    {
      return 78;
    }
    
    public final String[] dGU()
    {
      AppMethodBeat.i(200409);
      Object localObject = d.xHx;
      localObject = d.dHj();
      AppMethodBeat.o(200409);
      return localObject;
    }
    
    public final String dGV()
    {
      AppMethodBeat.i(200410);
      String str = b.arN() + "pag_lib_32/";
      AppMethodBeat.o(200410);
      return str;
    }
    
    public final String dGW()
    {
      return "pag_lib_32/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(200408);
      Object localObject = new StringBuilder();
      d locald = d.xHx;
      localObject = d.dHi() + "32";
      AppMethodBeat.o(200408);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class b
    extends a
  {
    public static final b xHA;
    private static final g xHy;
    
    static
    {
      AppMethodBeat.i(200415);
      xHA = new b();
      xHy = new g(40);
      AppMethodBeat.o(200415);
    }
    
    public final int dGT()
    {
      return 77;
    }
    
    public final String[] dGU()
    {
      AppMethodBeat.i(200413);
      Object localObject = d.xHx;
      localObject = d.dHj();
      AppMethodBeat.o(200413);
      return localObject;
    }
    
    public final String dGV()
    {
      AppMethodBeat.i(200414);
      String str = b.arN() + "pag_lib_64/";
      AppMethodBeat.o(200414);
      return str;
    }
    
    public final String dGW()
    {
      return "pag_lib_64/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(200412);
      Object localObject = new StringBuilder();
      d locald = d.xHx;
      localObject = d.dHi() + "64";
      AppMethodBeat.o(200412);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.d
 * JD-Core Version:    0.7.0.1
 */