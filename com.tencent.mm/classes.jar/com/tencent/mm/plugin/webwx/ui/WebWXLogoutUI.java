package com.tencent.mm.plugin.webwx.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.a;

@a(3)
public class WebWXLogoutUI
  extends LoginDeviceListUI
{
  public WebWXLogoutUI()
  {
    AppMethodBeat.i(30223);
    AppMethodBeat.o(30223);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI
 * JD-Core Version:    0.7.0.1
 */