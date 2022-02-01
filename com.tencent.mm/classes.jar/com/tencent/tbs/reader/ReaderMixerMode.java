package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ReaderMixerMode
{
  public static final String TAG = "ReaderDialogMode";
  protected ITbsReader.IReaderCore a;
  protected Context b;
  
  public ReaderMixerMode(Context paramContext, ITbsReader paramITbsReader)
  {
    AppMethodBeat.i(190614);
    this.a = null;
    this.b = paramContext;
    if (paramITbsReader != null) {
      this.a = paramITbsReader.getReaderCore();
    }
    if (this.a != null) {
      this.a.init(paramContext);
    }
    AppMethodBeat.o(190614);
  }
  
  public void closeFile()
  {
    AppMethodBeat.i(190617);
    if (this.a != null) {
      this.a.closeFile();
    }
    AppMethodBeat.o(190617);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(190618);
    if (this.a != null) {
      this.a.destroy();
    }
    this.a = null;
    this.b = null;
    AppMethodBeat.o(190618);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190616);
    if (this.a != null) {
      this.a.onSizeChanged(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(190616);
  }
  
  public void onSizeChanged(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(190619);
    if (this.a != null) {
      this.a.onSizeChanged(paramInteger1, paramInteger2);
    }
    AppMethodBeat.o(190619);
  }
  
  public int openFile(Bundle paramBundle, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(190615);
    if ((this.a == null) || (paramBundle == null))
    {
      AppMethodBeat.o(190615);
      return -1;
    }
    int j = this.a.openFile(this.b, paramBundle, paramFrameLayout, null);
    int i = 1100;
    if (j != 0) {
      i = 1101;
    }
    ReaderEngine.getInstance().report(i, "openFile:".concat(String.valueOf(j)), null);
    AppMethodBeat.o(190615);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderMixerMode
 * JD-Core Version:    0.7.0.1
 */