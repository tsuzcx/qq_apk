package com.tencent.mm.r;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kv.a;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lt.b;
import com.tencent.mm.g.a.r;
import com.tencent.mm.g.a.r.a;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.model.ah;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

public final class a
{
  private static ah cKA;
  
  public static ah Lt()
  {
    AppMethodBeat.i(150036);
    if (cKA == null) {
      cKA = com.tencent.mm.booter.a.Uc();
    }
    ah localah = cKA;
    AppMethodBeat.o(150036);
    return localah;
  }
  
  public static boolean aaZ()
  {
    AppMethodBeat.i(150032);
    lt locallt = new lt();
    locallt.dnK.action = 1;
    com.tencent.mm.sdk.b.a.GpY.l(locallt);
    boolean bool = locallt.dnL.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean aba()
  {
    AppMethodBeat.i(192593);
    kv localkv = new kv();
    com.tencent.mm.sdk.b.a.GpY.l(localkv);
    ac.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localkv.dmF.isStart), Boolean.valueOf(localkv.dmF.dmG) });
    if ((localkv.dmF.isStart) && (localkv.dmF.dmG))
    {
      AppMethodBeat.o(192593);
      return true;
    }
    AppMethodBeat.o(192593);
    return false;
  }
  
  public static boolean abb()
  {
    AppMethodBeat.i(192596);
    r localr = new r();
    com.tencent.mm.sdk.b.a.GpY.l(localr);
    ac.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.cYW.cYY), Boolean.valueOf(localr.cYW.cYX) });
    if (localr.cYW.cYY) {
      ac.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localr.cYW.cYY;
    AppMethodBeat.o(192596);
    return bool;
  }
  
  public static boolean abc()
  {
    AppMethodBeat.i(192597);
    r localr = new r();
    com.tencent.mm.sdk.b.a.GpY.l(localr);
    ac.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.cYW.cYY), Boolean.valueOf(localr.cYW.cYX) });
    if (localr.cYW.cYX) {
      ac.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localr.cYW.cYX;
    AppMethodBeat.o(192597);
    return bool;
  }
  
  public static boolean cf(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (aaZ())
    {
      ac.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(2131761414), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(150031);
      return true;
    }
    AppMethodBeat.o(150031);
    return false;
  }
  
  public static boolean cg(Context paramContext)
  {
    AppMethodBeat.i(150033);
    xg localxg = new xg();
    com.tencent.mm.sdk.b.a.GpY.l(localxg);
    if (localxg.dzZ.cYX)
    {
      ac.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      h.a(paramContext, "", n(paramContext, localxg.dzZ.dAa), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = localxg.dzZ.cYX;
      AppMethodBeat.o(150033);
      return bool;
    }
    boolean bool = ch(paramContext);
    AppMethodBeat.o(150033);
    return bool;
  }
  
  public static boolean ch(Context paramContext)
  {
    AppMethodBeat.i(192592);
    kv localkv = new kv();
    com.tencent.mm.sdk.b.a.GpY.l(localkv);
    ac.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localkv.dmF.isStart), Boolean.valueOf(localkv.dmF.dmG) });
    boolean bool = localkv.dmF.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(2131766655), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(192592);
    return bool;
  }
  
  public static boolean ci(Context paramContext)
  {
    AppMethodBeat.i(150034);
    xg localxg = new xg();
    com.tencent.mm.sdk.b.a.GpY.l(localxg);
    if (localxg.dzZ.cYY)
    {
      ac.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", n(paramContext, localxg.dzZ.dAa), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = localxg.dzZ.cYY;
      AppMethodBeat.o(150034);
      return bool;
    }
    boolean bool = ch(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean cj(Context paramContext)
  {
    AppMethodBeat.i(192594);
    r localr = new r();
    com.tencent.mm.sdk.b.a.GpY.l(localr);
    ac.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.cYW.cYY), Boolean.valueOf(localr.cYW.cYX) });
    if (localr.cYW.cYX)
    {
      ac.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      Toast.makeText(paramContext, n(paramContext, localr.cYW.cYX), 0).show();
    }
    boolean bool = localr.cYW.cYX;
    AppMethodBeat.o(192594);
    return bool;
  }
  
  public static boolean ck(Context paramContext)
  {
    AppMethodBeat.i(192595);
    r localr = new r();
    com.tencent.mm.sdk.b.a.GpY.l(localr);
    ac.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.cYW.cYY), Boolean.valueOf(localr.cYW.cYX) });
    if (localr.cYW.cYY)
    {
      ac.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", n(paramContext, localr.cYW.cYX), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    boolean bool = localr.cYW.cYY;
    AppMethodBeat.o(192595);
    return bool;
  }
  
  private static String n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150035);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(2131756776);
      AppMethodBeat.o(150035);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756777);
    AppMethodBeat.o(150035);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */