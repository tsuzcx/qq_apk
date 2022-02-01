package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "getResParentPath", "init", "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"})
public final class d
{
  private static final String[] BYg;
  private static final a BYh;
  private static final int BYi;
  public static final d BYj;
  private static final String TAG = "MicroMsg.VLogPagResLogic";
  
  static
  {
    AppMethodBeat.i(237490);
    BYj = new d();
    TAG = "MicroMsg.VLogPagResLogic";
    BYg = new String[] { "libpag", "libvlog_pag" };
    int i;
    if (BuildInfo.IS_ARM64)
    {
      i = 40;
      BYi = i;
      if (!BuildInfo.IS_ARM64) {
        break label79;
      }
    }
    label79:
    for (a locala = (a)b.BYm;; locala = (a)a.BYl)
    {
      BYh = locala;
      AppMethodBeat.o(237490);
      return;
      i = 60;
      break;
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(237489);
    s.deleteDir(b.aKC() + "pag_lib_64/");
    s.deleteDir(b.aKC() + "pag_lib_32/");
    AppMethodBeat.o(237489);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class a
    extends a
  {
    private static final h BYk;
    public static final a BYl;
    
    static
    {
      AppMethodBeat.i(237484);
      BYl = new a();
      BYk = new h(60);
      AppMethodBeat.o(237484);
    }
    
    public final int eLi()
    {
      return 78;
    }
    
    public final String[] eLj()
    {
      AppMethodBeat.i(237482);
      Object localObject = d.BYj;
      localObject = d.eLx();
      AppMethodBeat.o(237482);
      return localObject;
    }
    
    public final String eLk()
    {
      AppMethodBeat.i(237483);
      String str = b.aKC() + "pag_lib_32/";
      AppMethodBeat.o(237483);
      return str;
    }
    
    public final String eLl()
    {
      return "pag_lib_32/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(237481);
      Object localObject = new StringBuilder();
      d locald = d.BYj;
      localObject = d.eLw() + "32";
      AppMethodBeat.o(237481);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
  public static final class b
    extends a
  {
    private static final h BYk;
    public static final b BYm;
    
    static
    {
      AppMethodBeat.i(237488);
      BYm = new b();
      BYk = new h(40);
      AppMethodBeat.o(237488);
    }
    
    public final int eLi()
    {
      return 77;
    }
    
    public final String[] eLj()
    {
      AppMethodBeat.i(237486);
      Object localObject = d.BYj;
      localObject = d.eLx();
      AppMethodBeat.o(237486);
      return localObject;
    }
    
    public final String eLk()
    {
      AppMethodBeat.i(237487);
      String str = b.aKC() + "pag_lib_64/";
      AppMethodBeat.o(237487);
      return str;
    }
    
    public final String eLl()
    {
      return "pag_lib_64/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(237485);
      Object localObject = new StringBuilder();
      d locald = d.BYj;
      localObject = d.eLw() + "64";
      AppMethodBeat.o(237485);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.d
 * JD-Core Version:    0.7.0.1
 */