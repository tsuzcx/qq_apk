package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ReaderPluginPreLoad
{
  public static final String TAG = "ReaderPluginPreLoad";
  protected ITbsReader.IReaderPlugin a;
  
  public ReaderPluginPreLoad(Context paramContext, ITbsReader paramITbsReader)
  {
    AppMethodBeat.i(53088);
    this.a = null;
    if (paramITbsReader != null) {
      this.a = paramITbsReader.getReaderPlugin();
    }
    if (this.a != null) {
      this.a.initPlugin(paramContext);
    }
    AppMethodBeat.o(53088);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(53090);
    if (this.a != null) {
      this.a.destroy();
    }
    AppMethodBeat.o(53090);
  }
  
  public int downloadPlugin(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53089);
    int i = 0;
    if (this.a != null) {
      i = this.a.downloadPlugin(paramContext, paramString);
    }
    AppMethodBeat.o(53089);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderPluginPreLoad
 * JD-Core Version:    0.7.0.1
 */