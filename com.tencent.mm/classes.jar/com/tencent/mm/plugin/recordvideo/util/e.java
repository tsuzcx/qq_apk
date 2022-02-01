package com.tencent.mm.plugin.recordvideo.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFilePathUtil;", "", "()V", "getOrCreateTemDir", "", "biz", "getTmpFilePath", "getTmpFilePaths", "", "desc", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "Constants", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e Obp;
  
  static
  {
    AppMethodBeat.i(279590);
    Obp = new e();
    AppMethodBeat.o(279590);
  }
  
  public static String aTo(String paramString)
  {
    AppMethodBeat.i(279585);
    s.u(paramString, "biz");
    paramString = af.eC(paramString, true);
    if (!paramString.jKS()) {
      paramString.jKZ();
    }
    paramString = ah.v(paramString.mUri);
    s.s(paramString, "temDir.path");
    AppMethodBeat.o(279585);
    return paramString;
  }
  
  public static String getTmpFilePath(String paramString)
  {
    AppMethodBeat.i(279558);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = af.eC("media", true);
      paramString = paramString + File.separator + System.currentTimeMillis();
      AppMethodBeat.o(279558);
      return paramString;
    }
    paramString = af.eC(paramString, true);
    paramString = paramString + File.separator + System.currentTimeMillis();
    AppMethodBeat.o(279558);
    return paramString;
  }
  
  public static String[] l(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(279579);
    s.u(paramString, "biz");
    s.u(paramVarArgs, "desc");
    paramString = af.eC(paramString, true);
    long l = System.currentTimeMillis();
    int i = 0;
    String[] arrayOfString = new String[2];
    while (i < 2)
    {
      arrayOfString[i] = (paramString + File.separator + paramVarArgs[i] + '_' + l);
      i += 1;
    }
    AppMethodBeat.o(279579);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.e
 * JD-Core Version:    0.7.0.1
 */