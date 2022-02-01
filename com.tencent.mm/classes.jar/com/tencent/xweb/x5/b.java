package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient;

public class b
  extends WebChromeClient
{
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(153832);
    View localView = super.getVideoLoadingProgressView();
    AppMethodBeat.o(153832);
    return localView;
  }
  
  public final void gho()
  {
    AppMethodBeat.i(153831);
    super.onHideCustomView();
    AppMethodBeat.o(153831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.b
 * JD-Core Version:    0.7.0.1
 */