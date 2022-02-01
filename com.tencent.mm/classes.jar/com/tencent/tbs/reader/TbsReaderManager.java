package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderManager
{
  public static final String TAG = "TbsReaderManager";
  protected ITbsReader a = null;
  
  public ReaderMixerMode createReaderMode(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(192403);
    destroy();
    this.a = ReaderEngine.getInstance().createTbsReader(paramContext.getApplicationContext(), Integer.valueOf(3), paramITbsReaderCallback);
    paramContext = new ReaderMixerMode(paramContext, this.a);
    AppMethodBeat.o(192403);
    return paramContext;
  }
  
  public ReaderViewMode createReaderView(Context paramContext, ITbsReaderCallback paramITbsReaderCallback)
  {
    AppMethodBeat.i(53096);
    destroy();
    this.a = ReaderEngine.getInstance().createTbsReader(paramContext.getApplicationContext(), Integer.valueOf(1), paramITbsReaderCallback);
    paramContext = new ReaderViewMode(paramContext, this.a);
    AppMethodBeat.o(53096);
    return paramContext;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(53100);
    if (this.a != null) {
      this.a.destroy();
    }
    this.a = null;
    AppMethodBeat.o(53100);
  }
  
  public void doAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(53099);
    if (this.a != null) {
      this.a.doCommand(paramInteger, paramObject1, paramObject2);
    }
    AppMethodBeat.o(53099);
  }
  
  public ReaderPluginPreLoad getPluginPre(Context paramContext)
  {
    AppMethodBeat.i(53098);
    paramContext = new ReaderPluginPreLoad(paramContext, this.a);
    AppMethodBeat.o(53098);
    return paramContext;
  }
  
  public ITbsReader getTbsReader()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderManager
 * JD-Core Version:    0.7.0.1
 */