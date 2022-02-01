package com.tencent.mm.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aap.a;
import com.tencent.mm.f.a.ha;
import com.tencent.mm.f.a.ha.a;
import com.tencent.mm.f.a.ik;
import com.tencent.mm.f.a.ik.a;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.f.a.iy.a;
import com.tencent.mm.f.a.mm;
import com.tencent.mm.f.a.mm.a;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.f.a.nl.b;
import com.tencent.mm.f.a.u;
import com.tencent.mm.f.a.u.a;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;

public final class a
{
  private static ao ffy;
  
  public static boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204519);
    if (aAj())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(c.h.multitalk_in_toast), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      AppMethodBeat.o(204519);
      return true;
    }
    AppMethodBeat.o(204519);
    return false;
  }
  
  public static boolean aAj()
  {
    AppMethodBeat.i(150032);
    nl localnl = new nl();
    localnl.fLP.action = 1;
    EventCenter.instance.publish(localnl);
    boolean bool = localnl.fLQ.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean aAk()
  {
    AppMethodBeat.i(204525);
    aap localaap = new aap();
    EventCenter.instance.publish(localaap);
    boolean bool = localaap.fZK.fvo;
    AppMethodBeat.o(204525);
    return bool;
  }
  
  public static boolean aAl()
  {
    AppMethodBeat.i(204531);
    mm localmm = new mm();
    EventCenter.instance.publish(localmm);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localmm.fKB.isStart), Boolean.valueOf(localmm.fKB.fFE) });
    boolean bool = localmm.fKB.isStart;
    AppMethodBeat.o(204531);
    return bool;
  }
  
  public static boolean aAm()
  {
    AppMethodBeat.i(204545);
    u localu = new u();
    EventCenter.instance.publish(localu);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localu.fvn.fvp), Boolean.valueOf(localu.fvn.fvo) });
    if (localu.fvn.fvp) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
    }
    boolean bool = localu.fvn.fvp;
    AppMethodBeat.o(204545);
    return bool;
  }
  
  public static boolean aAn()
  {
    AppMethodBeat.i(204546);
    u localu = new u();
    EventCenter.instance.publish(localu);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsing isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localu.fvn.fvp), Boolean.valueOf(localu.fvn.fvo) });
    if (localu.fvn.fvo) {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
    }
    boolean bool = localu.fvn.fvo;
    AppMethodBeat.o(204546);
    return bool;
  }
  
  public static boolean aAo()
  {
    boolean bool = false;
    AppMethodBeat.i(204547);
    if ((q(null, false)) || (u(null, false))) {
      bool = true;
    }
    Log.i("MicroMsg.DeviceOccupy", "checkMutePlay=".concat(String.valueOf(bool)));
    AppMethodBeat.o(204547);
    return bool;
  }
  
  public static boolean aAp()
  {
    AppMethodBeat.i(204549);
    ik localik = new ik();
    EventCenter.instance.publish(localik);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLiveStatePlaying isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localik.fFD.isStart), Boolean.valueOf(localik.fFD.fFE) });
    if ((localik.fFD.isStart) && (!localik.fFD.fFE))
    {
      AppMethodBeat.o(204549);
      return true;
    }
    AppMethodBeat.o(204549);
    return false;
  }
  
  public static ao abL()
  {
    AppMethodBeat.i(150036);
    if (ffy == null) {
      ffy = com.tencent.mm.booter.a.aql();
    }
    ao localao = ffy;
    AppMethodBeat.o(150036);
    return localao;
  }
  
  public static boolean b(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204527);
    aap localaap = new aap();
    EventCenter.instance.publish(localaap);
    if (localaap.fZK.fvo)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      h.a(paramContext, "", s(paramContext, localaap.fZK.fZL), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      bool = localaap.fZK.fvo;
      AppMethodBeat.o(204527);
      return bool;
    }
    boolean bool = cx(paramContext);
    AppMethodBeat.o(204527);
    return bool;
  }
  
  public static boolean c(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204537);
    aap localaap = new aap();
    EventCenter.instance.publish(localaap);
    if (localaap.fZK.fvp)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", s(paramContext, localaap.fZK.fZL), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      bool = localaap.fZK.fvp;
      AppMethodBeat.o(204537);
      return bool;
    }
    if (u(paramContext, true))
    {
      AppMethodBeat.o(204537);
      return true;
    }
    boolean bool = cx(paramContext);
    AppMethodBeat.o(204537);
    return bool;
  }
  
  public static boolean cA(Context paramContext)
  {
    AppMethodBeat.i(204541);
    boolean bool = t(paramContext, true);
    AppMethodBeat.o(204541);
    return bool;
  }
  
  public static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(204543);
    u localu = new u();
    EventCenter.instance.publish(localu);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localu.fvn.fvp), Boolean.valueOf(localu.fvn.fvo) });
    if (localu.fvn.fvp)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", s(paramContext, localu.fvn.fvo), paramContext.getString(c.h.app_i_know), new a.6());
    }
    boolean bool = localu.fvn.fvp;
    AppMethodBeat.o(204543);
    return bool;
  }
  
  public static boolean cw(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (aAj())
    {
      Log.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(c.h.multitalk_in_toast), paramContext.getString(c.h.app_i_know), new a.1());
      AppMethodBeat.o(150031);
      return true;
    }
    AppMethodBeat.o(150031);
    return false;
  }
  
  public static boolean cx(Context paramContext)
  {
    AppMethodBeat.i(204529);
    mm localmm = new mm();
    EventCenter.instance.publish(localmm);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localmm.fKB.isStart), Boolean.valueOf(localmm.fKB.fFE) });
    boolean bool = localmm.fKB.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(c.h.live_open_new_tip_busy), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(204529);
    return bool;
  }
  
  public static boolean cy(Context paramContext)
  {
    AppMethodBeat.i(150034);
    aap localaap = new aap();
    EventCenter.instance.publish(localaap);
    if (localaap.fZK.fvp)
    {
      Log.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", s(paramContext, localaap.fZK.fZL), paramContext.getString(c.h.app_i_know), new a.5());
      bool = localaap.fZK.fvp;
      AppMethodBeat.o(150034);
      return bool;
    }
    if (q(paramContext, true))
    {
      AppMethodBeat.o(150034);
      return true;
    }
    if (u(paramContext, true))
    {
      AppMethodBeat.o(150034);
      return true;
    }
    boolean bool = cx(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean cz(Context paramContext)
  {
    AppMethodBeat.i(204540);
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if ((2 == paramContext.getCallState()) || (1 == paramContext.getCallState())) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(204540);
      return bool;
    }
  }
  
  public static boolean d(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204538);
    ha localha = new ha();
    EventCenter.instance.publish(localha);
    if (localha.fDC.fDD)
    {
      Log.i("MicroMsg.DeviceOccupy", "is Face page exist");
      h.a(paramContext, "", paramContext.getString(c.h.face_flash_page_exist), paramContext.getString(c.h.app_i_know), paramOnClickListener);
      boolean bool = localha.fDC.fDD;
      AppMethodBeat.o(204538);
      return bool;
    }
    AppMethodBeat.o(204538);
    return false;
  }
  
  public static boolean e(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(204544);
    u localu = new u();
    EventCenter.instance.publish(localu);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandVoiceUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localu.fvn.fvp), Boolean.valueOf(localu.fvn.fvo) });
    if (localu.fvn.fvp)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip voice using");
      h.a(paramContext, "", s(paramContext, localu.fvn.fvo), paramContext.getString(c.h.app_i_know), paramOnClickListener);
    }
    boolean bool = localu.fvn.fvp;
    AppMethodBeat.o(204544);
    return bool;
  }
  
  public static boolean p(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204523);
    Object localObject = new aap();
    EventCenter.instance.publish((IEvent)localObject);
    if (((aap)localObject).fZK.fvo)
    {
      Log.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      if (paramBoolean) {
        h.a(paramContext, "", s(paramContext, ((aap)localObject).fZK.fZL), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      paramBoolean = ((aap)localObject).fZK.fvo;
      AppMethodBeat.o(204523);
      return paramBoolean;
    }
    localObject = new ik();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((ik)localObject).fFD.isStart), Boolean.valueOf(((ik)localObject).fFD.fFE) });
    int i;
    if ((((ik)localObject).fFD.isStart) && (((ik)localObject).fFD.fFE))
    {
      i = 1;
      if ((i != 0) && (paramBoolean)) {
        if (!((ik)localObject).fFD.fFE) {
          break label233;
        }
      }
    }
    label233:
    for (localObject = paramContext.getString(c.h.finder_live_open_new_tip_anchor_busy);; localObject = paramContext.getString(c.h.finder_live_open_new_tip_visitor_busy))
    {
      w.makeText(paramContext, (CharSequence)localObject, 0).show();
      if (i == 0) {
        break label245;
      }
      AppMethodBeat.o(204523);
      return true;
      i = 0;
      break;
    }
    label245:
    localObject = new mm();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b isAudioMicing %s isVideoMicing %s", new Object[] { Boolean.valueOf(((mm)localObject).fKB.isStart), Boolean.valueOf(((mm)localObject).fKB.fFE), Boolean.valueOf(((mm)localObject).fKB.fKC), Boolean.valueOf(((mm)localObject).fKB.fKD) });
    if (((mm)localObject).fKB.fFE) {}
    for (boolean bool = ((mm)localObject).fKB.isStart;; bool = ((mm)localObject).fKB.fKD)
    {
      if ((bool) && (paramBoolean)) {
        h.a(paramContext, "", paramContext.getString(c.h.live_open_new_tip_busy), paramContext.getString(c.h.app_i_know), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(204523);
      return bool;
    }
  }
  
  public static boolean q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204533);
    Object localObject = new ik();
    EventCenter.instance.publish((IEvent)localObject);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((ik)localObject).fFD.isStart), Boolean.valueOf(((ik)localObject).fFD.fFE) });
    boolean bool = ((ik)localObject).fFD.isStart;
    if ((bool) && (paramBoolean)) {
      if (!((ik)localObject).fFD.fFE) {
        break label111;
      }
    }
    label111:
    for (localObject = paramContext.getString(c.h.finder_live_open_new_tip_anchor_busy);; localObject = paramContext.getString(c.h.finder_live_open_new_tip_visitor_busy))
    {
      w.makeText(paramContext, (CharSequence)localObject, 0).show();
      AppMethodBeat.o(204533);
      return bool;
    }
  }
  
  public static boolean r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204535);
    aap localaap = new aap();
    EventCenter.instance.publish(localaap);
    if ((localaap.fZK.fvp) && (paramBoolean)) {
      w.makeText(paramContext, s(paramContext, localaap.fZK.fZL), 0).show();
    }
    paramBoolean = localaap.fZK.fvp;
    AppMethodBeat.o(204535);
    return paramBoolean;
  }
  
  private static String s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150035);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(c.h.cannot_use_feature_bcz_camera_using);
      AppMethodBeat.o(150035);
      return paramContext;
    }
    paramContext = paramContext.getString(c.h.cannot_use_feature_bcz_voice_using);
    AppMethodBeat.o(150035);
    return paramContext;
  }
  
  public static boolean t(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204542);
    u localu = new u();
    EventCenter.instance.publish(localu);
    Log.i("MicroMsg.DeviceOccupy", "checkAppBrandCameraUsingAndShowToast isVoiceUsing:%b, isCameraUsing:%b", new Object[] { Boolean.valueOf(localu.fvn.fvp), Boolean.valueOf(localu.fvn.fvo) });
    if (localu.fvn.fvo)
    {
      Log.i("MicroMsg.DeviceOccupy", "app brand voip camera using");
      if (paramBoolean) {
        Toast.makeText(paramContext, s(paramContext, localu.fvn.fvo), 0).show();
      }
    }
    paramBoolean = localu.fvn.fvo;
    AppMethodBeat.o(204542);
    return paramBoolean;
  }
  
  public static boolean u(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(204548);
    iy localiy = new iy();
    EventCenter.instance.publish(localiy);
    Log.i("MicroMsg.DeviceOccupy", "checkFinderVideoState isExist %b ", new Object[] { Boolean.valueOf(localiy.fGg.fDD) });
    if ((localiy.fGg.fDD) && (paramBoolean) && (paramContext != null)) {
      w.makeText(paramContext, c.h.finder_mega_video_open_new_tip_busy, 0).show();
    }
    paramBoolean = localiy.fGg.fDD;
    AppMethodBeat.o(204548);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.q.a
 * JD-Core Version:    0.7.0.1
 */