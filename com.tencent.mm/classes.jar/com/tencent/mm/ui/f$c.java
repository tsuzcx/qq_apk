package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f$c
{
  public static final class a
  {
    public static final String VRV;
    
    static
    {
      AppMethodBeat.i(204109);
      VRV = "https://" + MMApplicationContext.getContext().getString(a.k.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=weishihb20/index";
      AppMethodBeat.o(204109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.c
 * JD-Core Version:    0.7.0.1
 */