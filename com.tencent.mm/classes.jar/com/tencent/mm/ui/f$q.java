package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f$q
{
  public static final String VSC;
  
  static
  {
    AppMethodBeat.i(200535);
    VSC = "https://" + MMApplicationContext.getContext().getString(a.k.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
    AppMethodBeat.o(200535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.q
 * JD-Core Version:    0.7.0.1
 */