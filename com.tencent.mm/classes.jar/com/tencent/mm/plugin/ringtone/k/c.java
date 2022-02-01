package com.tencent.mm.plugin.ringtone.k;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/setting/VoIPSceneSetting;", "Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;", "helper", "Lcom/tencent/mm/plugin/ringtone/PluginRingtone;", "(Lcom/tencent/mm/plugin/ringtone/PluginRingtone;)V", "responseScene", "", "scene", "", "bundle", "Landroid/os/Bundle;", "responseStart", "name", "type", "", "isOutCall", "seekStartMs", "", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c.a OEy;
  
  static
  {
    AppMethodBeat.i(273198);
    OEy = new c.a((byte)0);
    AppMethodBeat.o(273198);
  }
  
  public c(PluginRingtone paramPluginRingtone)
  {
    super(paramPluginRingtone);
    AppMethodBeat.i(273191);
    a(com.tencent.mm.plugin.ringtone.a.a.OBd);
    AppMethodBeat.o(273191);
  }
  
  protected final boolean u(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(273221);
    s.u(paramString, "scene");
    s.u(paramBundle, "bundle");
    boolean bool1;
    int j;
    boolean bool4;
    long l;
    switch (paramString.hashCode())
    {
    default: 
    case -346633629: 
    case 109757538: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(273221);
            return false;
          } while (!paramString.equals("bad_net"));
          bool1 = ahA(paramBundle.getInt("streamType"));
          AppMethodBeat.o(273221);
          return bool1;
        } while (!paramString.equals("start"));
        paramString = paramBundle.getString("username");
      } while (paramString == null);
      j = paramBundle.getInt("isVideoCall");
      bool4 = paramBundle.getBoolean("isOutCall");
      l = paramBundle.getLong("seekStartMs");
      if (com.tencent.mm.compatible.util.d.rb(29)) {
        bool1 = com.tencent.mm.k.b.DH(com.tencent.mm.plugin.ringtone.d.aUv(""));
      }
      break;
    }
    for (boolean bool2 = com.tencent.mm.k.b.DI(com.tencent.mm.plugin.ringtone.d.aUv(""));; bool2 = com.tencent.mm.k.b.aQU())
    {
      if (bool4) {
        bool1 = true;
      }
      if ((bool1) || (bool2)) {
        break label293;
      }
      AppMethodBeat.o(273221);
      return false;
      if (!paramString.equals("end")) {
        break;
      }
      bool1 = ahz(paramBundle.getInt("streamType"));
      AppMethodBeat.o(273221);
      return bool1;
      if (!paramString.equals("close")) {
        break;
      }
      bool1 = gON();
      AppMethodBeat.o(273221);
      return bool1;
      if (!paramString.equals("pause")) {
        break;
      }
      bool1 = gOM();
      AppMethodBeat.o(273221);
      return bool1;
      bool1 = com.tencent.mm.k.b.aQT();
    }
    label293:
    gOL().updateRingtoneInfo(paramString, bool4, l);
    boolean bool3;
    boolean bool5;
    int i;
    if (bool1) {
      if (com.tencent.mm.plugin.ringtone.c.gOk())
      {
        paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
        paramBundle = com.tencent.mm.plugin.audio.d.b.uVo;
        if (com.tencent.mm.plugin.audio.d.b.cTX())
        {
          paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
          if (com.tencent.mm.plugin.audio.c.a.a.cTY())
          {
            bool3 = true;
            paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
            bool5 = com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ();
            Log.d("MicroMsg.VoIPSceneSetting", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5) });
            if ((com.tencent.mm.plugin.ringtone.c.gOg()) || ((!bool3) && (!bool5))) {
              break label499;
            }
            bool1 = false;
            i = 0;
            label403:
            gOL().setUpRingtoneInfo(a.b.OBg, i, true);
            gOL().updateRingtoneInfo(paramString, bool4, l);
            if (com.tencent.mm.plugin.ringtone.c.gOi())
            {
              if (bool4) {
                break label542;
              }
              i = 1;
              label440:
              gOL().setAudioMode(i);
            }
            gOL().startPlaySound(bool1);
            if ((bool2) && (!bool4) && (!bool5) && (!bool3)) {
              gOL().startShake(true);
            }
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273221);
      return true;
      bool3 = false;
      break;
      label499:
      if (bool4)
      {
        i = 0;
        if ((!bool5) && (j != 1) && (!bool3)) {}
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      bool1 = true;
      i = 2;
      break label403;
      label542:
      i = 3;
      break label440;
      paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
      paramBundle = com.tencent.mm.plugin.audio.d.b.uVo;
      if (com.tencent.mm.plugin.audio.d.b.cTX())
      {
        paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTY())
        {
          bool3 = true;
          label574:
          paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
          bool5 = com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ();
          Log.d("MicroMsg.VoIPSceneSetting", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5) });
          if (!bool3) {
            break label765;
          }
          paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
          i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
          bool1 = false;
          label632:
          gOL().setUpRingtoneInfo(a.b.OBg, i, true);
          gOL().updateRingtoneInfo(paramString, bool4, l);
          if (com.tencent.mm.plugin.ringtone.c.gOi()) {
            if (bool4) {
              break label879;
            }
          }
        }
      }
      label879:
      for (j = 1;; j = 3)
      {
        gOL().setAudioMode(j);
        gOL().startPlaySound(bool1);
        if ((!bool5) && (!bool3)) {
          break label885;
        }
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        int m = com.tencent.mm.plugin.audio.c.a.a.cTW().getStreamMaxVolume(i);
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        int k = com.tencent.mm.plugin.audio.c.a.a.cTW().getStreamVolume(i);
        j = k;
        if (k > m / 2) {
          j = m / 2;
        }
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        com.tencent.mm.plugin.audio.c.a.a.cTW().gi(i, j);
        break;
        bool3 = false;
        break label574;
        label765:
        if ((bool4) || (bool5))
        {
          i = 0;
          if (af.lXZ.lRC >= 0) {
            i = af.lXZ.lRC;
          }
          if ((bool5) || (j == 1))
          {
            bool1 = false;
            break label632;
          }
          i = 3;
          if (af.lXZ.lRz >= 0) {
            i = af.lXZ.lRz;
          }
          bool1 = true;
          break label632;
        }
        j = 2;
        paramBundle = com.tencent.mm.plugin.audio.c.a.uVi;
        paramBundle = com.tencent.mm.plugin.audio.d.b.uVo;
        i = j;
        if (!com.tencent.mm.plugin.audio.d.b.cTX())
        {
          i = j;
          if (af.lXZ.lRE >= 0) {
            i = af.lXZ.lRE;
          }
        }
        bool1 = true;
        break label632;
      }
      label885:
      if (bool4)
      {
        gOL().adjustVolume(0.6F, 0.6F);
      }
      else if (bool2)
      {
        gOL().startShake(true);
        continue;
        if ((bool2) && (!bool4)) {
          gOL().startShakeOnly();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.k.c
 * JD-Core Version:    0.7.0.1
 */