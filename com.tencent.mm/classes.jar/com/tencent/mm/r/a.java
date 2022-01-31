package com.tencent.mm.r;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.h.a.jw;
import com.tencent.mm.h.a.jw.b;
import com.tencent.mm.h.a.tc;
import com.tencent.mm.h.a.tc.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  private static ad bxA;
  
  public static boolean Bv()
  {
    jw localjw = new jw();
    localjw.bSp.action = 1;
    com.tencent.mm.sdk.b.a.udP.m(localjw);
    return localjw.bSq.bSr;
  }
  
  public static boolean bi(Context paramContext)
  {
    boolean bool = false;
    if (Bv())
    {
      y.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      Toast.makeText(paramContext, a.h.multitalk_in_toast, 0).show();
      bool = true;
    }
    return bool;
  }
  
  public static boolean bj(Context paramContext)
  {
    tc localtc = new tc();
    com.tencent.mm.sdk.b.a.udP.m(localtc);
    if (localtc.ccF.ccH)
    {
      y.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      Toast.makeText(paramContext, j(paramContext, localtc.ccF.ccG), 0).show();
    }
    return localtc.ccF.ccH;
  }
  
  public static boolean bk(Context paramContext)
  {
    tc localtc = new tc();
    com.tencent.mm.sdk.b.a.udP.m(localtc);
    if (localtc.ccF.ccI)
    {
      y.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      Toast.makeText(paramContext, j(paramContext, localtc.ccF.ccG), 0).show();
    }
    return localtc.ccF.ccI;
  }
  
  private static String j(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramContext.getString(a.h.cannot_use_feature_bcz_camera_using);
    }
    return paramContext.getString(a.h.cannot_use_feature_bcz_voice_using);
  }
  
  public static ad tu()
  {
    if (bxA == null) {
      bxA = com.tencent.mm.booter.a.vR();
    }
    return bxA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */