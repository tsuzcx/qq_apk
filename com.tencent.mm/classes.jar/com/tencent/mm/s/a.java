package com.tencent.mm.s;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.a;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.mc.b;
import com.tencent.mm.g.a.r;
import com.tencent.mm.g.a.r.a;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

public final class a
{
  private static ai cVN;
  
  public static ai Nb()
  {
    AppMethodBeat.i(150036);
    if (cVN == null) {
      cVN = com.tencent.mm.booter.a.Wt();
    }
    ai localai = cVN;
    AppMethodBeat.o(150036);
    return localai;
  }
  
  public static boolean adC()
  {
    AppMethodBeat.i(150032);
    mc localmc = new mc();
    localmc.dzy.action = 1;
    com.tencent.mm.sdk.b.a.IbL.l(localmc);
    boolean bool = localmc.dzz.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean adD()
  {
    AppMethodBeat.i(195198);
    le localle = new le();
    com.tencent.mm.sdk.b.a.IbL.l(localle);
    ad.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localle.dyt.isStart), Boolean.valueOf(localle.dyt.dyu) });
    if ((localle.dyt.isStart) && (localle.dyt.dyu))
    {
      AppMethodBeat.o(195198);
      return true;
    }
    AppMethodBeat.o(195198);
    return false;
  }
  
  public static boolean adE()
  {
    AppMethodBeat.i(195202);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IbL.l(localr);
    ad.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dko.dkq), Boolean.valueOf(localr.dko.dkp) });
    if (localr.dko.dkq) {
      ad.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localr.dko.dkq;
    AppMethodBeat.o(195202);
    return bool;
  }
  
  public static boolean adF()
  {
    AppMethodBeat.i(195203);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IbL.l(localr);
    ad.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dko.dkq), Boolean.valueOf(localr.dko.dkp) });
    if (localr.dko.dkp) {
      ad.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localr.dko.dkp;
    AppMethodBeat.o(195203);
    return bool;
  }
  
  public static boolean cd(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (adC())
    {
      ad.i("MicroMsg.DeviceOccupy", "isMultiTalking");
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
  
  public static boolean ce(Context paramContext)
  {
    AppMethodBeat.i(195197);
    le localle = new le();
    com.tencent.mm.sdk.b.a.IbL.l(localle);
    ad.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localle.dyt.isStart), Boolean.valueOf(localle.dyt.dyu) });
    boolean bool = localle.dyt.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(2131766655), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(195197);
    return bool;
  }
  
  public static boolean cf(Context paramContext)
  {
    AppMethodBeat.i(150034);
    ya localya = new ya();
    com.tencent.mm.sdk.b.a.IbL.l(localya);
    if (localya.dMm.dkq)
    {
      ad.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", o(paramContext, localya.dMm.dMn), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = localya.dMm.dkq;
      AppMethodBeat.o(150034);
      return bool;
    }
    boolean bool = ce(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean cg(Context paramContext)
  {
    AppMethodBeat.i(195199);
    boolean bool = p(paramContext, true);
    AppMethodBeat.o(195199);
    return bool;
  }
  
  public static boolean ch(Context paramContext)
  {
    AppMethodBeat.i(195201);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IbL.l(localr);
    ad.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dko.dkq), Boolean.valueOf(localr.dko.dkp) });
    if (localr.dko.dkq)
    {
      ad.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", o(paramContext, localr.dko.dkp), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    boolean bool = localr.dko.dkq;
    AppMethodBeat.o(195201);
    return bool;
  }
  
  public static boolean n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(195196);
    ya localya = new ya();
    com.tencent.mm.sdk.b.a.IbL.l(localya);
    if (localya.dMm.dkp)
    {
      ad.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      if (paramBoolean) {
        h.a(paramContext, "", o(paramContext, localya.dMm.dMn), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      paramBoolean = localya.dMm.dkp;
      AppMethodBeat.o(195196);
      return paramBoolean;
    }
    paramBoolean = ce(paramContext);
    AppMethodBeat.o(195196);
    return paramBoolean;
  }
  
  private static String o(Context paramContext, boolean paramBoolean)
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
  
  public static boolean p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(195200);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IbL.l(localr);
    ad.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dko.dkq), Boolean.valueOf(localr.dko.dkp) });
    if (localr.dko.dkp)
    {
      ad.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      if (paramBoolean) {
        Toast.makeText(paramContext, o(paramContext, localr.dko.dkp), 0).show();
      }
    }
    paramBoolean = localr.dko.dkp;
    AppMethodBeat.o(195200);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */