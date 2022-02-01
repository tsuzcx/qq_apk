package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ReaderViewMode
  extends FrameLayout
{
  public static final String TAG = "ReaderView";
  protected ITbsReader.IReaderCore a;
  
  public ReaderViewMode(Context paramContext, ITbsReader paramITbsReader)
  {
    super(paramContext);
    AppMethodBeat.i(53091);
    this.a = null;
    if (paramITbsReader != null) {
      this.a = paramITbsReader.getReaderCore();
    }
    if (this.a != null) {
      this.a.init(paramContext);
    }
    AppMethodBeat.o(53091);
  }
  
  public void closeFile()
  {
    AppMethodBeat.i(53093);
    if (this.a != null) {
      this.a.closeFile();
    }
    AppMethodBeat.o(53093);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(53094);
    if (this.a != null) {
      this.a.destroy();
    }
    this.a = null;
    AppMethodBeat.o(53094);
  }
  
  public void onSizeChanged(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(53095);
    if (this.a != null) {
      this.a.onSizeChanged(paramInteger1, paramInteger2);
    }
    AppMethodBeat.o(53095);
  }
  
  public int openFile(Bundle paramBundle)
  {
    AppMethodBeat.i(53092);
    if ((this.a == null) || (paramBundle == null))
    {
      AppMethodBeat.o(53092);
      return -1;
    }
    int j = this.a.openFile(getContext(), paramBundle, this, null);
    int i = 1100;
    if (j != 0) {
      i = 1101;
    }
    ReaderEngine.getInstance().report(i, "ViewOpenFile:".concat(String.valueOf(j)), null);
    AppMethodBeat.o(53092);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderViewMode
 * JD-Core Version:    0.7.0.1
 */