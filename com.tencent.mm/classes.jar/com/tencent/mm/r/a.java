package com.tencent.mm.r;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.lf.a;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.md.b;
import com.tencent.mm.g.a.r;
import com.tencent.mm.g.a.r.a;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;

public final class a
{
  private static aj cWK;
  
  public static aj MW()
  {
    AppMethodBeat.i(150036);
    if (cWK == null) {
      cWK = com.tencent.mm.booter.a.WB();
    }
    aj localaj = cWK;
    AppMethodBeat.o(150036);
    return localaj;
  }
  
  public static boolean adO()
  {
    AppMethodBeat.i(150032);
    md localmd = new md();
    localmd.dAD.action = 1;
    com.tencent.mm.sdk.b.a.IvT.l(localmd);
    boolean bool = localmd.dAE.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean adP()
  {
    AppMethodBeat.i(218648);
    lf locallf = new lf();
    com.tencent.mm.sdk.b.a.IvT.l(locallf);
    ae.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(locallf.dzy.isStart), Boolean.valueOf(locallf.dzy.dzz) });
    if ((locallf.dzy.isStart) && (locallf.dzy.dzz))
    {
      AppMethodBeat.o(218648);
      return true;
    }
    AppMethodBeat.o(218648);
    return false;
  }
  
  public static boolean adQ()
  {
    AppMethodBeat.i(218652);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IvT.l(localr);
    ae.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dlq.dls), Boolean.valueOf(localr.dlq.dlr) });
    if (localr.dlq.dls) {
      ae.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localr.dlq.dls;
    AppMethodBeat.o(218652);
    return bool;
  }
  
  public static boolean adR()
  {
    AppMethodBeat.i(218653);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IvT.l(localr);
    ae.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dlq.dls), Boolean.valueOf(localr.dlq.dlr) });
    if (localr.dlq.dlr) {
      ae.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localr.dlq.dlr;
    AppMethodBeat.o(218653);
    return bool;
  }
  
  public static boolean cf(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (adO())
    {
      ae.i("MicroMsg.DeviceOccupy", "isMultiTalking");
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
    AppMethodBeat.i(218647);
    lf locallf = new lf();
    com.tencent.mm.sdk.b.a.IvT.l(locallf);
    ae.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(locallf.dzy.isStart), Boolean.valueOf(locallf.dzy.dzz) });
    boolean bool = locallf.dzy.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(2131766655), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(218647);
    return bool;
  }
  
  public static boolean ch(Context paramContext)
  {
    AppMethodBeat.i(150034);
    yg localyg = new yg();
    com.tencent.mm.sdk.b.a.IvT.l(localyg);
    if (localyg.dNC.dls)
    {
      ae.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", o(paramContext, localyg.dNC.dND), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      bool = localyg.dNC.dls;
      AppMethodBeat.o(150034);
      return bool;
    }
    boolean bool = cg(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean ci(Context paramContext)
  {
    AppMethodBeat.i(218649);
    boolean bool = p(paramContext, true);
    AppMethodBeat.o(218649);
    return bool;
  }
  
  public static boolean cj(Context paramContext)
  {
    AppMethodBeat.i(218651);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IvT.l(localr);
    ae.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dlq.dls), Boolean.valueOf(localr.dlq.dlr) });
    if (localr.dlq.dls)
    {
      ae.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", o(paramContext, localr.dlq.dlr), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    boolean bool = localr.dlq.dls;
    AppMethodBeat.o(218651);
    return bool;
  }
  
  public static boolean n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(218646);
    yg localyg = new yg();
    com.tencent.mm.sdk.b.a.IvT.l(localyg);
    if (localyg.dNC.dlr)
    {
      ae.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      if (paramBoolean) {
        h.a(paramContext, "", o(paramContext, localyg.dNC.dND), paramContext.getString(2131755792), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      paramBoolean = localyg.dNC.dlr;
      AppMethodBeat.o(218646);
      return paramBoolean;
    }
    paramBoolean = cg(paramContext);
    AppMethodBeat.o(218646);
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
    AppMethodBeat.i(218650);
    r localr = new r();
    com.tencent.mm.sdk.b.a.IvT.l(localr);
    ae.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localr.dlq.dls), Boolean.valueOf(localr.dlq.dlr) });
    if (localr.dlq.dlr)
    {
      ae.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      if (paramBoolean) {
        Toast.makeText(paramContext, o(paramContext, localr.dlq.dlr), 0).show();
      }
    }
    paramBoolean = localr.dlq.dlr;
    AppMethodBeat.o(218650);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */