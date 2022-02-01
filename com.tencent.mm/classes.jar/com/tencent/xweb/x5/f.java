package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient;

public class f
  extends WebChromeClient
{
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(213179);
    View localView = super.getVideoLoadingProgressView();
    AppMethodBeat.o(213179);
    return localView;
  }
  
  public final void kiK()
  {
    AppMethodBeat.i(213174);
    super.onHideCustomView();
    AppMethodBeat.o(213174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.f
 * JD-Core Version:    0.7.0.1
 */