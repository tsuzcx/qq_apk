package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import java.util.ArrayList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "isAllowToResponseMike", "", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "getMStateMachine", "()Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "setMStateMachine", "(Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;)V", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "checkClean", "", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "onAudioDeviceStateChanged", "status", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "Companion", "plugin-voip_release"})
public final class c
  extends e
{
  public static final c.a CCG;
  private volatile com.tencent.mm.plugin.voip.ui.b CCE;
  public boolean CCF;
  public m CpZ;
  private boolean CqI;
  private boolean CqS;
  private int Cqn;
  private boolean Cqp;
  public boolean Cqq;
  private boolean Cqr;
  public boolean Cre;
  public boolean CvE;
  private com.tencent.mm.compatible.util.b dcI;
  private boolean mIsMute;
  private int mUIType;
  
  static
  {
    AppMethodBeat.i(210379);
    CCG = new c.a((byte)0);
    AppMethodBeat.o(210379);
  }
  
  public c()
  {
    AppMethodBeat.i(210378);
    this.Cqn = 1;
    this.dcI = new com.tencent.mm.compatible.util.b(ak.getContext());
    Object localObject = this.dcI;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    AppMethodBeat.o(210378);
  }
  
  private final void Vi(int paramInt)
  {
    AppMethodBeat.i(210363);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Cqn = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.CCE;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.Cqn);
      AppMethodBeat.o(210363);
      return;
    }
    AppMethodBeat.o(210363);
  }
  
  private final void ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210365);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.a.bHz()) {
        bool = false;
      }
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn)
    {
      com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYo > 0) {
        com.tencent.mm.plugin.voip.c.eys().ti(bool);
      }
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYR >= 0)) {
      com.tencent.mm.plugin.voip.c.eys().ti(bool);
    }
    Object localObject = com.tencent.mm.plugin.voip.c.eys();
    p.g(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).aNQ(), paramBoolean2);
    com.tencent.mm.plugin.voip.c.eys().tu(bool);
    this.Cqr = bool;
    AppMethodBeat.o(210365);
  }
  
  private final void eDc()
  {
    int i = 3;
    AppMethodBeat.i(210366);
    boolean bool2 = xs(3);
    boolean bool3 = this.CqI;
    Object localObject = this.CpZ;
    if (localObject == null) {
      p.bdF("mStateMachine");
    }
    boolean bool4 = l.Vv(((m)localObject).getState());
    localObject = com.tencent.mm.plugin.voip.c.eys();
    p.g(localObject, "SubCoreVoip.getVoipService()");
    boolean bool5 = ((u)localObject).cbt();
    boolean bool6 = this.Cqq;
    boolean bool1;
    if (2 == this.mUIType)
    {
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.CqI)
      {
        localObject = this.CpZ;
        if (localObject == null) {
          p.bdF("mStateMachine");
        }
        if (!l.Vv(((m)localObject).getState())) {
          break label265;
        }
        if (bool2) {
          break label260;
        }
        i = 1;
        label181:
        this.Cqn = i;
        if (this.Cqn != 1) {
          break label360;
        }
        ay(true, true);
        label200:
        switch (this.Cqn)
        {
        }
      }
    }
    for (;;)
    {
      Vi(this.Cqn);
      this.CqI = true;
      com.tencent.mm.plugin.voip.c.eys().oQ(false);
      AppMethodBeat.o(210366);
      return;
      bool1 = false;
      break;
      label260:
      i = 3;
      break label181;
      label265:
      localObject = com.tencent.mm.plugin.voip.c.eys();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (!((u)localObject).cbt())
      {
        if (xs(3)) {}
        for (;;)
        {
          this.Cqn = i;
          break;
          if (!this.CvE) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      if (((this.Cqq) || (2 == this.mUIType)) && (!bool2)) {
        i = 1;
      }
      for (;;)
      {
        this.Cqn = i;
        this.Cqq = false;
        break;
        if (!bool2) {
          i = 2;
        }
      }
      label360:
      tE(false);
      break label200;
      bHr();
      continue;
      is(true);
    }
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(210377);
    Object localObject1 = localObject2;
    if (this.CCE != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.CCE;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.eCq();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ak.getContext();
    }
    AppMethodBeat.o(210377);
    return localObject2;
  }
  
  private final void tE(boolean paramBoolean)
  {
    AppMethodBeat.i(210364);
    ay(paramBoolean, this.CqS);
    AppMethodBeat.o(210364);
  }
  
  public static void tG(boolean paramBoolean)
  {
    AppMethodBeat.i(210370);
    com.tencent.mm.plugin.voip.c.eys().stopRing();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.eys().UU(i);
      AppMethodBeat.o(210370);
      return;
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(210361);
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.Wy("voip");
    AppMethodBeat.o(210361);
  }
  
  public final void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210371);
    Object localObject = this.dcI;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHz())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      if (a.a.bHA())
      {
        b("voip", Integer.valueOf(4));
        tE(false);
        AppMethodBeat.o(210371);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    if (a.a.bHy().bHt())
    {
      b("voip", Integer.valueOf(3));
      tE(false);
      AppMethodBeat.o(210371);
      return;
    }
    boolean bool1;
    if (1 == this.Cqn)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.CCF)) {
        break label165;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      cn(paramBoolean1);
      AppMethodBeat.o(210371);
      return;
      bool1 = false;
      break;
      label165:
      if (paramBoolean2)
      {
        b("voip", Integer.valueOf(1));
        paramBoolean1 = true;
      }
      else
      {
        b("voip", Integer.valueOf(this.Cqn));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void aB(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = 0;
    AppMethodBeat.i(210373);
    if (!this.nwZ)
    {
      com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      if (paramBoolean1) {}
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.eys().aT(i, paramBoolean2);
        if (this.Cqn != 4) {
          break;
        }
        eDc();
        AppMethodBeat.o(210373);
        return;
        i = 1;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    this.nwY = ((d.g.a.b)new b(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(210373);
  }
  
  public final void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210369);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    int i;
    if (a.a.bHy().bHt()) {
      i = 3;
    }
    for (;;)
    {
      this.Cqn = i;
      this.CvE = paramBoolean2;
      this.Cqq = paramBoolean1;
      AppMethodBeat.o(210369);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      if (com.tencent.mm.plugin.audio.d.a.bHC())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nxo;
        if (a.a.bHA())
        {
          i = 4;
          continue;
        }
      }
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(210360);
    this.CCE = paramb;
    paramb = this.CCE;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.Cqn);
    }
    paramb = this.CCE;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(210360);
      return;
    }
    AppMethodBeat.o(210360);
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(210367);
    Object localObject = this.dcI;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.cn(paramBoolean);
    if (bHv() != -1)
    {
      i = bHv();
      Vi(i);
      localObject = com.tencent.mm.plugin.voip.c.eys();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).cbt()) {
        break label124;
      }
      com.tencent.mm.plugin.voip.c.eys().tv(paramBoolean);
      label67:
      localObject = g.yxI;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      ((g)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(210367);
      return;
      i = this.Cqn;
      break;
      label124:
      tE(paramBoolean);
      break label67;
    }
  }
  
  public final void drG()
  {
    AppMethodBeat.i(210376);
    Wv("voip");
    com.tencent.mm.plugin.voip.c.eys().stopRing();
    AppMethodBeat.o(210376);
  }
  
  public final void eDd()
  {
    AppMethodBeat.i(210372);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHC())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(210372);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    if (a.a.bHy().bHt())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(210372);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(210372);
  }
  
  public final void eyU()
  {
    AppMethodBeat.i(210374);
    com.tencent.mm.plugin.voip.c.eys().stopRing();
    this.nwY = null;
    AppMethodBeat.o(210374);
  }
  
  public final void ezg()
  {
    AppMethodBeat.i(210375);
    com.tencent.mm.compatible.util.b localb = this.dcI;
    if (localb != null) {
      localb.abn();
    }
    com.tencent.mm.plugin.voip.c.eys().stopRing();
    bHs();
    AppMethodBeat.o(210375);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(210362);
    super.hE(paramInt);
    if ((this.nwW.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(210362);
      return;
    }
    boolean bool;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
    case 2: 
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      do
      {
        AppMethodBeat.o(210362);
        return;
        this.CqI = false;
        localObject = this.CpZ;
        if (localObject == null) {
          p.bdF("mStateMachine");
        }
        if (!l.Vv(((m)localObject).getState())) {
          if (1 != this.Cqn) {
            break label221;
          }
        }
        for (bool = true;; bool = false)
        {
          this.Cqq = bool;
          localObject = com.tencent.mm.plugin.voip.c.eys();
          p.g(localObject, "SubCoreVoip.getVoipService()");
          a(false, ((u)localObject).aNQ(), false);
          com.tencent.mm.plugin.voip.c.eys().ti(false);
          com.tencent.mm.plugin.voip.c.eys().tu(false);
          Vi(4);
          this.CqI = false;
          com.tencent.mm.plugin.voip.c.eys().oQ(true);
          AppMethodBeat.o(210362);
          return;
        }
      } while (this.Cre);
      eDc();
      this.CqS = true;
      AppMethodBeat.o(210362);
      return;
    case 9: 
      label221:
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      bool = com.tencent.mm.plugin.audio.d.a.bHC();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool) });
      if (3 != this.Cqn)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(210362);
        return;
      }
      localObject = this.CpZ;
      if (localObject == null) {
        p.bdF("mStateMachine");
      }
      if (l.Vv(((m)localObject).getState())) {
        if (bool)
        {
          b("voip", Integer.valueOf(4));
          paramInt = 4;
          this.Cqn = paramInt;
          label346:
          if (this.Cqn != 1) {
            break label649;
          }
          ay(true, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.eys().oQ(false);
        Vi(this.Cqn);
        AppMethodBeat.o(210362);
        return;
        localObject = com.tencent.mm.plugin.voip.c.eys();
        p.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cbt())
        {
          if (!this.CvE)
          {
            paramInt = 1;
            break;
          }
          paramInt = 2;
          break;
        }
        Context localContext = getContext();
        localObject = getContext();
        if (localObject != null) {}
        for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          paramInt = 1;
          break;
        }
        if (bool)
        {
          if (1 == this.Cqn) {}
          for (bool = true;; bool = false)
          {
            this.Cqp = bool;
            this.Cqn = 4;
            b("voip", Integer.valueOf(4));
            break;
          }
        }
        localObject = com.tencent.mm.plugin.voip.c.eys();
        p.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cbt())
        {
          if (!this.CvE) {
            break label346;
          }
          break label346;
        }
        if ((this.Cqp) || (2 == this.mUIType))
        {
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 1;
            this.Cqn = paramInt;
            this.Cqp = false;
            break;
          }
        }
        localContext = getContext();
        localObject = getContext();
        if (localObject != null) {}
        for (localObject = ((Context)localObject).getString(2131764936);; localObject = null)
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          paramInt = 2;
          break;
        }
        label649:
        tE(false);
      }
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.a.bHC()) });
    if (3 == this.Cqn)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
      AppMethodBeat.o(210362);
      return;
    }
    localObject = this.CpZ;
    if (localObject == null) {
      p.bdF("mStateMachine");
    }
    if (l.Vv(((m)localObject).getState()))
    {
      this.Cqn = 3;
      if (this.Cqn != 1) {
        break label799;
      }
      ay(true, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.c.eys().oQ(true);
      Vi(this.Cqn);
      break;
      if (1 == this.Cqn) {}
      for (bool = true;; bool = false)
      {
        this.Cqp = bool;
        this.Cqn = 3;
        break;
      }
      label799:
      ay(false, true);
    }
  }
  
  public final void tF(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(210368);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.voip.c.eys().eBf();
      com.tencent.mm.plugin.voip.c.eys().UL(9);
      com.tencent.mm.plugin.voip.c.eys().tt(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      g localg = g.yxI;
      if (paramBoolean) {
        i = 2;
      }
      localg.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(210368);
      return;
      com.tencent.mm.plugin.voip.c.eys().eBg();
      com.tencent.mm.plugin.voip.c.eys().UL(8);
      com.tencent.mm.plugin.voip.c.eys().tt(false);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b
  {
    b(c paramc, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.c
 * JD-Core Version:    0.7.0.1
 */