package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "getResParentPath", "init", "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"})
public final class d
{
  private static final String[] HUU;
  private static final a HUV;
  private static final int HUW;
  public static final d HUX;
  private static final String TAG = "MicroMsg.VLogPagResLogic";
  
  static
  {
    AppMethodBeat.i(217480);
    HUX = new d();
    TAG = "MicroMsg.VLogPagResLogic";
    HUU = new String[] { "libpag", "libvlog_pag" };
    int i;
    if (BuildInfo.IS_ARM64)
    {
      i = 40;
      HUW = i;
      if (!BuildInfo.IS_ARM64) {
        break label79;
      }
    }
    label79:
    for (a locala = (a)b.HVa;; locala = (a)a.HUZ)
    {
      HUV = locala;
      AppMethodBeat.o(217480);
      return;
      i = 60;
      break;
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(217476);
    u.deleteDir(b.aSE() + "pag_lib_64/");
    u.deleteDir(b.aSE() + "pag_lib_32/");
    AppMethodBeat.o(217476);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class a
    extends a
  {
    private static final h HUY;
    public static final a HUZ;
    
    static
    {
      AppMethodBeat.i(219327);
      HUZ = new a();
      HUY = new h(60);
      AppMethodBeat.o(219327);
    }
    
    public final int fxB()
    {
      return 78;
    }
    
    public final String[] fxC()
    {
      AppMethodBeat.i(219324);
      Object localObject = d.HUX;
      localObject = d.fxQ();
      AppMethodBeat.o(219324);
      return localObject;
    }
    
    public final String fxD()
    {
      AppMethodBeat.i(219326);
      String str = b.aSE() + "pag_lib_32/";
      AppMethodBeat.o(219326);
      return str;
    }
    
    public final String fxE()
    {
      return "pag_lib_32/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(219322);
      Object localObject = new StringBuilder();
      d locald = d.HUX;
      localObject = d.fxP() + "32";
      AppMethodBeat.o(219322);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class b
    extends a
  {
    private static final h HUY;
    public static final b HVa;
    
    static
    {
      AppMethodBeat.i(218450);
      HVa = new b();
      HUY = new h(40);
      AppMethodBeat.o(218450);
    }
    
    public final int fxB()
    {
      return 77;
    }
    
    public final String[] fxC()
    {
      AppMethodBeat.i(218441);
      Object localObject = d.HUX;
      localObject = d.fxQ();
      AppMethodBeat.o(218441);
      return localObject;
    }
    
    public final String fxD()
    {
      AppMethodBeat.i(218443);
      String str = b.aSE() + "pag_lib_64/";
      AppMethodBeat.o(218443);
      return str;
    }
    
    public final String fxE()
    {
      return "pag_lib_64/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(218439);
      Object localObject = new StringBuilder();
      d locald = d.HUX;
      localObject = d.fxP() + "64";
      AppMethodBeat.o(218439);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.d
 * JD-Core Version:    0.7.0.1
 */