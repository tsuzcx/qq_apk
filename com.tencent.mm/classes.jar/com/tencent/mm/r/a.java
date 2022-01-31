package com.tencent.mm.r;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.b;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.model.ae;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  private static ae bZC;
  
  public static ae BY()
  {
    AppMethodBeat.i(77700);
    if (bZC == null) {
      bZC = com.tencent.mm.booter.a.Ia();
    }
    ae localae = bZC;
    AppMethodBeat.o(77700);
    return localae;
  }
  
  public static boolean Ok()
  {
    AppMethodBeat.i(77696);
    kf localkf = new kf();
    localkf.czQ.action = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localkf);
    boolean bool = localkf.czR.isStart;
    AppMethodBeat.o(77696);
    return bool;
  }
  
  public static boolean bM(Context paramContext)
  {
    AppMethodBeat.i(77695);
    if (Ok())
    {
      ab.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      Toast.makeText(paramContext, 2131301680, 0).show();
      AppMethodBeat.o(77695);
      return true;
    }
    AppMethodBeat.o(77695);
    return false;
  }
  
  public static boolean bN(Context paramContext)
  {
    AppMethodBeat.i(77697);
    uw localuw = new uw();
    com.tencent.mm.sdk.b.a.ymk.l(localuw);
    if (localuw.cLo.cLq)
    {
      ab.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      Toast.makeText(paramContext, m(paramContext, localuw.cLo.cLp), 0).show();
    }
    boolean bool = localuw.cLo.cLq;
    AppMethodBeat.o(77697);
    return bool;
  }
  
  public static boolean bO(Context paramContext)
  {
    AppMethodBeat.i(77698);
    uw localuw = new uw();
    com.tencent.mm.sdk.b.a.ymk.l(localuw);
    if (localuw.cLo.cLr)
    {
      ab.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      Toast.makeText(paramContext, m(paramContext, localuw.cLo.cLp), 0).show();
    }
    boolean bool = localuw.cLo.cLr;
    AppMethodBeat.o(77698);
    return bool;
  }
  
  private static String m(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(77699);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(2131297844);
      AppMethodBeat.o(77699);
      return paramContext;
    }
    paramContext = paramContext.getString(2131297845);
    AppMethodBeat.o(77699);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */