package com.tencent.mm.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.hx.a;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.a;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.mu.b;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.t.a;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.model.an;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

public final class a
{
  private static an dnl;
  
  public static an Xi()
  {
    AppMethodBeat.i(150036);
    if (dnl == null) {
      dnl = com.tencent.mm.booter.a.akp();
    }
    an localan = dnl;
    AppMethodBeat.o(150036);
    return localan;
  }
  
  public static boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223501);
    if (att())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(2131763269), paramContext.getString(2131755873), paramOnClickListener);
      AppMethodBeat.o(223501);
      return true;
    }
    AppMethodBeat.o(223501);
    return false;
  }
  
  public static boolean att()
  {
    AppMethodBeat.i(150032);
    mu localmu = new mu();
    localmu.dSs.action = 1;
    EventCenter.instance.publish(localmu);
    boolean bool = localmu.dSt.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean atu()
  {
    AppMethodBeat.i(223505);
    lv locallv = new lv();
    EventCenter.instance.publish(locallv);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(locallv.dRl.isStart), Boolean.valueOf(locallv.dRl.dMz) });
    boolean bool = locallv.dRl.isStart;
    AppMethodBeat.o(223505);
    return bool;
  }
  
  public static boolean atv()
  {
    AppMethodBeat.i(223507);
    zi localzi = new zi();
    EventCenter.instance.publish(localzi);
    boolean bool = localzi.efv.dCI;
    AppMethodBeat.o(223507);
    return bool;
  }
  
  public static boolean atw()
  {
    AppMethodBeat.i(223514);
    t localt = new t();
    EventCenter.instance.publish(localt);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localt.dCG.dCI), Boolean.valueOf(localt.dCG.dCH) });
    if (localt.dCG.dCI) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localt.dCG.dCI;
    AppMethodBeat.o(223514);
    return bool;
  }
  
  public static boolean atx()
  {
    AppMethodBeat.i(223515);
    t localt = new t();
    EventCenter.instance.publish(localt);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localt.dCG.dCI), Boolean.valueOf(localt.dCG.dCH) });
    if (localt.dCG.dCH) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localt.dCG.dCH;
    AppMethodBeat.o(223515);
    return bool;
  }
  
  public static boolean aty()
  {
    AppMethodBeat.i(223516);
    boolean bool = p(null, false);
    Log.i("MicroMsg.DeviceOccupy", "checkMutePlay:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(223516);
    return bool;
  }
  
  public static boolean b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223503);
    zi localzi = new zi();
    EventCenter.instance.publish(localzi);
    if (localzi.efv.dCH)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      h.a(paramContext, "", q(paramContext, localzi.efv.efw), paramContext.getString(2131755873), paramOnClickListener);
      bool = localzi.efv.dCH;
      AppMethodBeat.o(223503);
      return bool;
    }
    boolean bool = cB(paramContext);
    AppMethodBeat.o(223503);
    return bool;
  }
  
  public static boolean c(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223508);
    zi localzi = new zi();
    EventCenter.instance.publish(localzi);
    if (localzi.efv.dCI)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", q(paramContext, localzi.efv.efw), paramContext.getString(2131755873), paramOnClickListener);
      bool = localzi.efv.dCI;
      AppMethodBeat.o(223508);
      return bool;
    }
    boolean bool = cB(paramContext);
    AppMethodBeat.o(223508);
    return bool;
  }
  
  public static boolean cA(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (att())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(2131763269), paramContext.getString(2131755873), new a.1());
      AppMethodBeat.o(150031);
      return true;
    }
    AppMethodBeat.o(150031);
    return false;
  }
  
  public static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(223504);
    lv locallv = new lv();
    EventCenter.instance.publish(locallv);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(locallv.dRl.isStart), Boolean.valueOf(locallv.dRl.dMz) });
    boolean bool = locallv.dRl.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(2131762351), paramContext.getString(2131755873), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(223504);
    return bool;
  }
  
  public static boolean cC(Context paramContext)
  {
    AppMethodBeat.i(150034);
    zi localzi = new zi();
    EventCenter.instance.publish(localzi);
    if (localzi.efv.dCI)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", q(paramContext, localzi.efv.efw), paramContext.getString(2131755873), new a.5());
      bool = localzi.efv.dCI;
      AppMethodBeat.o(150034);
      return bool;
    }
    if (p(paramContext, true))
    {
      AppMethodBeat.o(150034);
      return true;
    }
    boolean bool = cB(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean cD(Context paramContext)
  {
    AppMethodBeat.i(223510);
    boolean bool = r(paramContext, true);
    AppMethodBeat.o(223510);
    return bool;
  }
  
  public static boolean cE(Context paramContext)
  {
    AppMethodBeat.i(223512);
    t localt = new t();
    EventCenter.instance.publish(localt);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localt.dCG.dCI), Boolean.valueOf(localt.dCG.dCH) });
    if (localt.dCG.dCI)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", q(paramContext, localt.dCG.dCH), paramContext.getString(2131755873), new a.6());
    }
    boolean bool = localt.dCG.dCI;
    AppMethodBeat.o(223512);
    return bool;
  }
  
  public static boolean d(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223509);
    gt localgt = new gt();
    EventCenter.instance.publish(localgt);
    if (localgt.dKN.dKO)
    {
      Log.i("MicroMsg.DeviceOccupy", "is Face page exist");
      h.a(paramContext, "", paramContext.getString(2131759054), paramContext.getString(2131755873), paramOnClickListener);
      boolean bool = localgt.dKN.dKO;
      AppMethodBeat.o(223509);
      return bool;
    }
    AppMethodBeat.o(223509);
    return false;
  }
  
  public static boolean e(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(223513);
    t localt = new t();
    EventCenter.instance.publish(localt);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localt.dCG.dCI), Boolean.valueOf(localt.dCG.dCH) });
    if (localt.dCG.dCI)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", q(paramContext, localt.dCG.dCH), paramContext.getString(2131755873), paramOnClickListener);
    }
    boolean bool = localt.dCG.dCI;
    AppMethodBeat.o(223513);
    return bool;
  }
  
  public static boolean o(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(223502);
    Object localObject = new zi();
    EventCenter.instance.publish((IEvent)localObject);
    if (((zi)localObject).efv.dCH)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      if (paramBoolean) {
        h.a(paramContext, "", q(paramContext, ((zi)localObject).efv.efw), paramContext.getString(2131755873), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      paramBoolean = ((zi)localObject).efv.dCH;
      AppMethodBeat.o(223502);
      return paramBoolean;
    }
    localObject = new hx();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((hx)localObject).dMy.isStart), Boolean.valueOf(((hx)localObject).dMy.dMz) });
    int i;
    if ((((hx)localObject).dMy.isStart) && (((hx)localObject).dMy.dMz))
    {
      i = 1;
      if ((i != 0) && (paramBoolean)) {
        if (!((hx)localObject).dMy.dMz) {
          break label227;
        }
      }
    }
    label227:
    for (localObject = paramContext.getString(2131760145);; localObject = paramContext.getString(2131760147))
    {
      u.makeText(paramContext, (CharSequence)localObject, 0).show();
      if (i == 0) {
        break label239;
      }
      AppMethodBeat.o(223502);
      return true;
      i = 0;
      break;
    }
    label239:
    localObject = new lv();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b isAudioMicing %s isVideoMicing %s", new Object[] { Boolean.valueOf(((lv)localObject).dRl.isStart), Boolean.valueOf(((lv)localObject).dRl.dMz), Boolean.valueOf(((lv)localObject).dRl.dRm), Boolean.valueOf(((lv)localObject).dRl.dRn) });
    if (((lv)localObject).dRl.dMz) {}
    for (boolean bool = ((lv)localObject).dRl.isStart;; bool = ((lv)localObject).dRl.dRn)
    {
      if ((bool) && (paramBoolean)) {
        h.a(paramContext, "", paramContext.getString(2131762351), paramContext.getString(2131755873), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(223502);
      return bool;
    }
  }
  
  public static boolean p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(223506);
    Object localObject = new hx();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((hx)localObject).dMy.isStart), Boolean.valueOf(((hx)localObject).dMy.dMz) });
    boolean bool = ((hx)localObject).dMy.isStart;
    if ((bool) && (paramBoolean)) {
      if (!((hx)localObject).dMy.dMz) {
        break label109;
      }
    }
    label109:
    for (localObject = paramContext.getString(2131760145);; localObject = paramContext.getString(2131760147))
    {
      u.makeText(paramContext, (CharSequence)localObject, 0).show();
      AppMethodBeat.o(223506);
      return bool;
    }
  }
  
  private static String q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150035);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(2131756939);
      AppMethodBeat.o(150035);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756941);
    AppMethodBeat.o(150035);
    return paramContext;
  }
  
  public static boolean r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(223511);
    t localt = new t();
    EventCenter.instance.publish(localt);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localt.dCG.dCI), Boolean.valueOf(localt.dCG.dCH) });
    if (localt.dCG.dCH)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      if (paramBoolean) {
        Toast.makeText(paramContext, q(paramContext, localt.dCG.dCH), 0).show();
      }
    }
    paramBoolean = localt.dCG.dCH;
    AppMethodBeat.o(223511);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.q.a
 * JD-Core Version:    0.7.0.1
 */