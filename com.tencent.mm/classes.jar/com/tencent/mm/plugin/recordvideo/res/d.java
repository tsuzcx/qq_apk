package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "get", "getResParentPath", "init", "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"})
public final class d
{
  private static final String TAG = "MicroMsg.VLogPagResLogic";
  private static final String[] xXp;
  private static final a xXq;
  private static final int xXr;
  public static final d xXs;
  
  static
  {
    AppMethodBeat.i(206680);
    xXs = new d();
    TAG = "MicroMsg.VLogPagResLogic";
    xXp = new String[] { "libpag", "libvlog_pag" };
    int i;
    if (j.hjx)
    {
      i = 40;
      xXr = i;
      if (!j.hjx) {
        break label79;
      }
    }
    label79:
    for (a locala = (a)b.xXv;; locala = (a)a.xXu)
    {
      xXq = locala;
      AppMethodBeat.o(206680);
      return;
      i = 60;
      break;
    }
  }
  
  public static void aHH()
  {
    AppMethodBeat.i(206679);
    xXq.aHH();
    AppMethodBeat.o(206679);
  }
  
  public static a dKy()
  {
    return xXq;
  }
  
  public static void init()
  {
    AppMethodBeat.i(206677);
    xXq.init();
    AppMethodBeat.o(206677);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(206678);
    xXq.hZz.dead();
    AppMethodBeat.o(206678);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class a
    extends a
  {
    private static final g xXt;
    public static final a xXu;
    
    static
    {
      AppMethodBeat.i(206672);
      xXu = new a();
      xXt = new g(60);
      AppMethodBeat.o(206672);
    }
    
    public final int dKk()
    {
      return 78;
    }
    
    public final String[] dKl()
    {
      AppMethodBeat.i(206670);
      Object localObject = d.xXs;
      localObject = d.dKA();
      AppMethodBeat.o(206670);
      return localObject;
    }
    
    public final String dKm()
    {
      AppMethodBeat.i(206671);
      String str = b.asc() + "pag_lib_32/";
      AppMethodBeat.o(206671);
      return str;
    }
    
    public final String dKn()
    {
      return "pag_lib_32/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(206669);
      Object localObject = new StringBuilder();
      d locald = d.xXs;
      localObject = d.dKz() + "32";
      AppMethodBeat.o(206669);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class b
    extends a
  {
    private static final g xXt;
    public static final b xXv;
    
    static
    {
      AppMethodBeat.i(206676);
      xXv = new b();
      xXt = new g(40);
      AppMethodBeat.o(206676);
    }
    
    public final int dKk()
    {
      return 77;
    }
    
    public final String[] dKl()
    {
      AppMethodBeat.i(206674);
      Object localObject = d.xXs;
      localObject = d.dKA();
      AppMethodBeat.o(206674);
      return localObject;
    }
    
    public final String dKm()
    {
      AppMethodBeat.i(206675);
      String str = b.asc() + "pag_lib_64/";
      AppMethodBeat.o(206675);
      return str;
    }
    
    public final String dKn()
    {
      return "pag_lib_64/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(206673);
      Object localObject = new StringBuilder();
      d locald = d.xXs;
      localObject = d.dKz() + "64";
      AppMethodBeat.o(206673);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.d
 * JD-Core Version:    0.7.0.1
 */