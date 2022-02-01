package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic;", "", "()V", "TAG", "", "value", "Lkotlin/Function0;", "", "downloadFileSuccessCallback", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "fileExist", "", "getFileExist", "()Z", "fileKeys", "", "[Ljava/lang/String;", "pagResInstance", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "startKey", "", "getStartKey", "()I", "checkRes", "getResParentPath", "init", "report", "key", "reportLoadFail", "reportLoadStart", "reportLoadSuccess", "unInit", "VLogPagRes32", "VLogPagRes64", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d NRK;
  private static final String[] NRL;
  private static final a NRM;
  private static final int NRN;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(279676);
    NRK = new d();
    TAG = "MicroMsg.VLogPagResLogic";
    NRL = new String[] { "libpag", "libvlog_pag" };
    int i;
    if (BuildInfo.IS_ARM64)
    {
      i = 40;
      NRN = i;
      if (!BuildInfo.IS_ARM64) {
        break label79;
      }
    }
    label79:
    for (a locala = (a)b.NRQ;; locala = (a)a.NRO)
    {
      NRM = locala;
      AppMethodBeat.o(279676);
      return;
      i = 60;
      break;
    }
  }
  
  public static void init()
  {
    AppMethodBeat.i(279658);
    y.ew(s.X(b.bms(), "pag_lib_64/"), true);
    y.ew(s.X(b.bms(), "pag_lib_32/"), true);
    AppMethodBeat.o(279658);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes32;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends a
  {
    public static final a NRO;
    private static final h NRP;
    
    static
    {
      AppMethodBeat.i(279660);
      NRO = new a();
      NRP = new h(60);
      AppMethodBeat.o(279660);
    }
    
    public final int gJq()
    {
      return 78;
    }
    
    public final String[] gJr()
    {
      AppMethodBeat.i(279675);
      String[] arrayOfString = d.gJE();
      AppMethodBeat.o(279675);
      return arrayOfString;
    }
    
    public final String gJs()
    {
      AppMethodBeat.i(279680);
      String str = s.X(b.bms(), "pag_lib_32/");
      AppMethodBeat.o(279680);
      return str;
    }
    
    public final String gJt()
    {
      return "pag_lib_32/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(279664);
      String str = s.X(d.aUw(), "32");
      AppMethodBeat.o(279664);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VLogPagResLogic$VLogPagRes64;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    private static final h NRP;
    public static final b NRQ;
    
    static
    {
      AppMethodBeat.i(279662);
      NRQ = new b();
      NRP = new h(40);
      AppMethodBeat.o(279662);
    }
    
    public final int gJq()
    {
      return 77;
    }
    
    public final String[] gJr()
    {
      AppMethodBeat.i(279678);
      String[] arrayOfString = d.gJE();
      AppMethodBeat.o(279678);
      return arrayOfString;
    }
    
    public final String gJs()
    {
      AppMethodBeat.i(279683);
      String str = s.X(b.bms(), "pag_lib_64/");
      AppMethodBeat.o(279683);
      return str;
    }
    
    public final String gJt()
    {
      return "pag_lib_64/";
    }
    
    public final String getTag()
    {
      AppMethodBeat.i(279667);
      String str = s.X(d.aUw(), "64");
      AppMethodBeat.o(279667);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.d
 * JD-Core Version:    0.7.0.1
 */