package com.tencent.mm.wexnet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetConstants;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a agWj;
  
  static
  {
    AppMethodBeat.i(231537);
    agWj = new a((byte)0);
    AppMethodBeat.o(231537);
  }
  
  public static final String jPI()
  {
    AppMethodBeat.i(231529);
    String str = a.jPI();
    AppMethodBeat.o(231529);
    return str;
  }
  
  public static final String jPJ()
  {
    AppMethodBeat.i(231533);
    String str = a.jPJ();
    AppMethodBeat.o(231533);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetConstants$Companion;", "", "()V", "ARM64_V8A_LIB_XNET_SO_MD5", "", "ARMEABI_V7A_LIB_XNET_SO_MD5", "DIR_NAME_XNET_LIB", "DIR_NAME_XNET_LIB_DEBUG", "getArchitectureXNetLibMD5", "getDebugTmpXNetLibPath", "getDebugXNetLibPath", "getXNetLibPath", "getXNetSoResType", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String jPI()
    {
      AppMethodBeat.i(231578);
      String str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + File.separator + "XNetLibDebug";
      AppMethodBeat.o(231578);
      return str;
    }
    
    public static String jPJ()
    {
      AppMethodBeat.i(231586);
      String str = com.tencent.mm.loader.i.b.bmt() + File.separator + "Xnet" + File.separator + "lib" + File.separator + "debug" + File.separator;
      AppMethodBeat.o(231586);
      return str;
    }
    
    public static String jPK()
    {
      AppMethodBeat.i(231572);
      String str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + File.separator + "XNetLib";
      AppMethodBeat.o(231572);
      return str;
    }
    
    public static String jPL()
    {
      if (BuildInfo.IS_ARM64) {
        return "83122b639ddd6a8534e0ebe993108795";
      }
      return "19552203c840a8c5d0ed777b6603916c";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wexnet.b
 * JD-Core Version:    0.7.0.1
 */