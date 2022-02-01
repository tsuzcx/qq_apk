package com.tencent.mm.plugin.ringtone.k;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.a.b;
import com.tencent.mm.plugin.ringtone.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/setting/MultitalkSceneSetting;", "Lcom/tencent/mm/plugin/ringtone/setting/BaseSceneSetting;", "helper", "Lcom/tencent/mm/plugin/ringtone/PluginRingtone;", "(Lcom/tencent/mm/plugin/ringtone/PluginRingtone;)V", "responseScene", "", "scene", "", "bundle", "Landroid/os/Bundle;", "responseStart", "isOutCall", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a OEx;
  
  static
  {
    AppMethodBeat.i(273197);
    OEx = new b.a((byte)0);
    AppMethodBeat.o(273197);
  }
  
  public b(PluginRingtone paramPluginRingtone)
  {
    super(paramPluginRingtone);
    AppMethodBeat.i(273190);
    a(com.tencent.mm.plugin.ringtone.a.a.OBe);
    AppMethodBeat.o(273190);
  }
  
  protected final boolean u(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(273218);
    s.u(paramString, "scene");
    s.u(paramBundle, "bundle");
    label88:
    boolean bool1;
    boolean bool4;
    switch (paramString.hashCode())
    {
    default: 
    case -346633629: 
    case 109757538: 
      do
      {
        do
        {
          AppMethodBeat.o(273218);
          return true;
        } while (!paramString.equals("bad_net"));
        bool1 = ahz(paramBundle.getInt("streamType"));
        AppMethodBeat.o(273218);
        return bool1;
      } while (!paramString.equals("start"));
      bool4 = paramBundle.getBoolean("isOutCall");
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
        break label249;
      }
      AppMethodBeat.o(273218);
      return false;
      if (paramString.equals("end")) {
        break label88;
      }
      if ((goto 72) || (!paramString.equals("close"))) {
        break;
      }
      bool1 = gON();
      AppMethodBeat.o(273218);
      return bool1;
      if (!paramString.equals("pause")) {
        break;
      }
      bool1 = gOM();
      AppMethodBeat.o(273218);
      return bool1;
      bool1 = com.tencent.mm.k.b.aQT();
    }
    label249:
    gOL().updateRingtoneInfo(z.bAM(), bool4, 0L);
    boolean bool3;
    boolean bool5;
    int i;
    if (bool1) {
      if (c.gOk())
      {
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        paramString = com.tencent.mm.plugin.audio.d.b.uVo;
        if (com.tencent.mm.plugin.audio.d.b.cTX())
        {
          paramString = com.tencent.mm.plugin.audio.c.a.uVi;
          if (com.tencent.mm.plugin.audio.c.a.a.cTY())
          {
            bool3 = true;
            paramString = com.tencent.mm.plugin.audio.c.a.uVi;
            bool5 = com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ();
            Log.d("MicroMsg.MultitalkSceneSetting", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5) });
            paramString = c.OBr;
            if (!c.gOh()) {
              break label474;
            }
            if ((!bool3) && (!bool4) && (!bool5)) {
              break label466;
            }
            i = 0;
            bool1 = false;
            label369:
            gOL().setUpRingtoneInfo(a.b.OBg, i, true);
            gOL().updateRingtoneInfo(z.bAM(), bool4, 0L);
            if ((bool2) && (!bool4) && (!bool5) && (!bool3)) {
              gOL().startShake(true);
            }
            if (c.gOi())
            {
              if (bool4) {
                break label519;
              }
              i = 1;
              label436:
              gOL().setAudioMode(i);
            }
            gOL().startPlaySound(bool1);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273218);
      return true;
      bool3 = false;
      break;
      label466:
      i = 2;
      bool1 = true;
      break label369;
      label474:
      if ((!c.gOg()) && ((bool3) || (bool5)))
      {
        i = 0;
        bool1 = false;
        break label369;
      }
      if (bool4)
      {
        i = 0;
        bool1 = false;
        break label369;
      }
      i = 2;
      bool1 = true;
      break label369;
      label519:
      i = 3;
      break label436;
      paramString = com.tencent.mm.plugin.audio.c.a.uVi;
      paramString = com.tencent.mm.plugin.audio.d.b.uVo;
      if (com.tencent.mm.plugin.audio.d.b.cTX())
      {
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTY())
        {
          bool3 = true;
          label551:
          paramString = com.tencent.mm.plugin.audio.c.a.uVi;
          bool5 = com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ();
          Log.d("MicroMsg.MultitalkSceneSetting", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5) });
          if (!bool3) {
            break label743;
          }
          paramString = com.tencent.mm.plugin.audio.c.a.uVi;
          i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
          bool1 = false;
          label609:
          gOL().setUpRingtoneInfo(a.b.OBg, i, true);
          gOL().updateRingtoneInfo(z.bAM(), bool4, 0L);
          if (c.gOi()) {
            if (bool4) {
              break label822;
            }
          }
        }
      }
      label822:
      for (int j = 1;; j = 3)
      {
        gOL().setAudioMode(j);
        gOL().startPlaySound(bool1);
        if ((!bool5) && (!bool3)) {
          break label828;
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
        break label551;
        label743:
        if ((bool4) || (bool5))
        {
          i = 0;
          if (af.lXZ.lRC >= 0) {
            i = af.lXZ.lRC;
          }
          bool1 = false;
          break label609;
        }
        j = 2;
        paramString = com.tencent.mm.plugin.audio.c.a.uVi;
        paramString = com.tencent.mm.plugin.audio.d.b.uVo;
        i = j;
        if (!com.tencent.mm.plugin.audio.d.b.cTX())
        {
          i = j;
          if (af.lXZ.lRE >= 0) {
            i = af.lXZ.lRE;
          }
        }
        bool1 = true;
        break label609;
      }
      label828:
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
 * Qualified Name:     com.tencent.mm.plugin.ringtone.k.b
 * JD-Core Version:    0.7.0.1
 */