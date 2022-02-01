package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.g.b.q;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "isAllowToResponseMike", "", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "getMStateMachine", "()Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "setMStateMachine", "(Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;)V", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "checkClean", "", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "onAudioDeviceStateChanged", "status", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "Companion", "plugin-voip_release"})
public final class c
  extends e
{
  public static final c.a Clb;
  private int BYM;
  private boolean BYO;
  public boolean BYP;
  private boolean BYQ;
  public m BYy;
  public boolean BZD;
  private boolean BZh;
  private boolean BZr;
  public boolean Ced;
  private volatile com.tencent.mm.plugin.voip.ui.b CkZ;
  public boolean Cla;
  private com.tencent.mm.compatible.util.b dbG;
  private boolean mIsMute;
  private int mUIType;
  
  static
  {
    AppMethodBeat.i(215958);
    Clb = new c.a((byte)0);
    AppMethodBeat.o(215958);
  }
  
  public c()
  {
    AppMethodBeat.i(215957);
    this.BYM = 1;
    this.dbG = new com.tencent.mm.compatible.util.b(aj.getContext());
    Object localObject = this.dbG;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    AppMethodBeat.o(215957);
  }
  
  private final void UB(int paramInt)
  {
    AppMethodBeat.i(215942);
    ad.m("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt) });
    this.BYM = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.CkZ;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.BYM);
      AppMethodBeat.o(215942);
      return;
    }
    AppMethodBeat.o(215942);
  }
  
  private final void az(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215944);
    ad.m("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.a.bGD()) {
        bool = false;
      }
    }
    if (ae.gcF.fWh)
    {
      ae.gcF.dump();
      if (ae.gcF.fWi > 0) {
        com.tencent.mm.plugin.voip.c.euM().tb(bool);
      }
    }
    if ((ae.gcF.fWK >= 0) || (ae.gcF.fWL >= 0)) {
      com.tencent.mm.plugin.voip.c.euM().tb(bool);
    }
    Object localObject = com.tencent.mm.plugin.voip.c.euM();
    p.g(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).aNs(), paramBoolean2);
    com.tencent.mm.plugin.voip.c.euM().tn(bool);
    this.BYQ = bool;
    AppMethodBeat.o(215944);
  }
  
  private final void ezu()
  {
    int i = 3;
    AppMethodBeat.i(215945);
    boolean bool2 = xn(3);
    boolean bool3 = this.BZh;
    Object localObject = this.BYy;
    if (localObject == null) {
      p.bcb("mStateMachine");
    }
    boolean bool4 = l.UO(((m)localObject).getState());
    localObject = com.tencent.mm.plugin.voip.c.euM();
    p.g(localObject, "SubCoreVoip.getVoipService()");
    boolean bool5 = ((u)localObject).cae();
    boolean bool6 = this.BYP;
    boolean bool1;
    if (2 == this.mUIType)
    {
      bool1 = true;
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!this.BZh)
      {
        localObject = this.BYy;
        if (localObject == null) {
          p.bcb("mStateMachine");
        }
        if (!l.UO(((m)localObject).getState())) {
          break label265;
        }
        if (bool2) {
          break label260;
        }
        i = 1;
        label181:
        this.BYM = i;
        if (this.BYM != 1) {
          break label360;
        }
        az(true, true);
        label200:
        switch (this.BYM)
        {
        }
      }
    }
    for (;;)
    {
      UB(this.BYM);
      this.BZh = true;
      com.tencent.mm.plugin.voip.c.euM().oJ(false);
      AppMethodBeat.o(215945);
      return;
      bool1 = false;
      break;
      label260:
      i = 3;
      break label181;
      label265:
      localObject = com.tencent.mm.plugin.voip.c.euM();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (!((u)localObject).cae())
      {
        if (xn(3)) {}
        for (;;)
        {
          this.BYM = i;
          break;
          if (!this.Ced) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      if (((this.BYP) || (2 == this.mUIType)) && (!bool2)) {
        i = 1;
      }
      for (;;)
      {
        this.BYM = i;
        this.BYP = false;
        break;
        if (!bool2) {
          i = 2;
        }
      }
      label360:
      tx(false);
      break label200;
      bGv();
      continue;
      iu(true);
    }
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(215956);
    Object localObject1 = localObject2;
    if (this.CkZ != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.CkZ;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.eyI();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aj.getContext();
    }
    AppMethodBeat.o(215956);
    return localObject2;
  }
  
  private final void tx(boolean paramBoolean)
  {
    AppMethodBeat.i(215943);
    az(paramBoolean, this.BZr);
    AppMethodBeat.o(215943);
  }
  
  public static void tz(boolean paramBoolean)
  {
    AppMethodBeat.i(215949);
    com.tencent.mm.plugin.voip.c.euM().stopRing();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.euM().Un(i);
      AppMethodBeat.o(215949);
      return;
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(215940);
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.VM("voip");
    AppMethodBeat.o(215940);
  }
  
  public final void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215948);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    int i;
    if (a.a.bGC().bGx()) {
      i = 3;
    }
    for (;;)
    {
      this.BYM = i;
      this.Ced = paramBoolean2;
      this.BYP = paramBoolean1;
      AppMethodBeat.o(215948);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      if (com.tencent.mm.plugin.audio.d.a.bGG())
      {
        localObject = com.tencent.mm.plugin.audio.c.a.nrV;
        if (a.a.bGE())
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
  
  public final void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(215950);
    Object localObject = this.dbG;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGD())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      if (a.a.bGE())
      {
        b("voip", Integer.valueOf(4));
        tx(false);
        AppMethodBeat.o(215950);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    if (a.a.bGC().bGx())
    {
      b("voip", Integer.valueOf(3));
      tx(false);
      AppMethodBeat.o(215950);
      return;
    }
    boolean bool1;
    if (1 == this.BYM)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.Cla)) {
        break label165;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      cn(paramBoolean1);
      AppMethodBeat.o(215950);
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
        b("voip", Integer.valueOf(this.BYM));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void aC(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = 0;
    AppMethodBeat.i(215952);
    if (!this.nrG)
    {
      ad.m("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      if (paramBoolean1) {}
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.euM().aN(i, paramBoolean2);
        if (this.BYM != 4) {
          break;
        }
        ezu();
        AppMethodBeat.o(215952);
        return;
        i = 1;
      }
    }
    ad.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    this.nrF = ((d.g.a.b)new b(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(215952);
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(215939);
    this.CkZ = paramb;
    paramb = this.CkZ;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.BYM);
    }
    paramb = this.CkZ;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(215939);
      return;
    }
    AppMethodBeat.o(215939);
  }
  
  public final void cn(boolean paramBoolean)
  {
    AppMethodBeat.i(215946);
    Object localObject = this.dbG;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.cn(paramBoolean);
    if (bGz() != -1)
    {
      i = bGz();
      UB(i);
      localObject = com.tencent.mm.plugin.voip.c.euM();
      p.g(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).cae()) {
        break label124;
      }
      com.tencent.mm.plugin.voip.c.euM().to(paramBoolean);
      label67:
      localObject = g.yhR;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      ((g)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(215946);
      return;
      i = this.BYM;
      break;
      label124:
      tx(paramBoolean);
      break label67;
    }
  }
  
  public final void doI()
  {
    AppMethodBeat.i(215955);
    VJ("voip");
    com.tencent.mm.plugin.voip.c.euM().stopRing();
    AppMethodBeat.o(215955);
  }
  
  public final void evn()
  {
    AppMethodBeat.i(215953);
    com.tencent.mm.plugin.voip.c.euM().stopRing();
    this.nrF = null;
    AppMethodBeat.o(215953);
  }
  
  public final void evz()
  {
    AppMethodBeat.i(215954);
    com.tencent.mm.compatible.util.b localb = this.dbG;
    if (localb != null) {
      localb.abe();
    }
    com.tencent.mm.plugin.voip.c.euM().stopRing();
    bGw();
    AppMethodBeat.o(215954);
  }
  
  public final void ezv()
  {
    AppMethodBeat.i(215951);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGG())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(215951);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    if (a.a.bGC().bGx())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(215951);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(215951);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(215941);
    super.hC(paramInt);
    if ((this.nrD.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(215941);
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
        AppMethodBeat.o(215941);
        return;
        this.BZh = false;
        localObject = this.BYy;
        if (localObject == null) {
          p.bcb("mStateMachine");
        }
        if (!l.UO(((m)localObject).getState())) {
          if (1 != this.BYM) {
            break label221;
          }
        }
        for (bool = true;; bool = false)
        {
          this.BYP = bool;
          localObject = com.tencent.mm.plugin.voip.c.euM();
          p.g(localObject, "SubCoreVoip.getVoipService()");
          a(false, ((u)localObject).aNs(), false);
          com.tencent.mm.plugin.voip.c.euM().tb(false);
          com.tencent.mm.plugin.voip.c.euM().tn(false);
          UB(4);
          this.BZh = false;
          com.tencent.mm.plugin.voip.c.euM().oJ(true);
          AppMethodBeat.o(215941);
          return;
        }
      } while (this.BZD);
      ezu();
      this.BZr = true;
      AppMethodBeat.o(215941);
      return;
    case 9: 
      label221:
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      bool = com.tencent.mm.plugin.audio.d.a.bGG();
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool) });
      if (3 != this.BYM)
      {
        ad.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(215941);
        return;
      }
      localObject = this.BYy;
      if (localObject == null) {
        p.bcb("mStateMachine");
      }
      if (l.UO(((m)localObject).getState())) {
        if (bool)
        {
          b("voip", Integer.valueOf(4));
          paramInt = 4;
          this.BYM = paramInt;
          label346:
          if (this.BYM != 1) {
            break label649;
          }
          az(true, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.euM().oJ(false);
        UB(this.BYM);
        AppMethodBeat.o(215941);
        return;
        localObject = com.tencent.mm.plugin.voip.c.euM();
        p.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cae())
        {
          if (!this.Ced)
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
          if (1 == this.BYM) {}
          for (bool = true;; bool = false)
          {
            this.BYO = bool;
            this.BYM = 4;
            b("voip", Integer.valueOf(4));
            break;
          }
        }
        localObject = com.tencent.mm.plugin.voip.c.euM();
        p.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cae())
        {
          if (!this.Ced) {
            break label346;
          }
          break label346;
        }
        if ((this.BYO) || (2 == this.mUIType))
        {
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            paramInt = 1;
            this.BYM = paramInt;
            this.BYO = false;
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
        tx(false);
      }
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    ad.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.a.bGG()) });
    if (3 == this.BYM)
    {
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
      AppMethodBeat.o(215941);
      return;
    }
    localObject = this.BYy;
    if (localObject == null) {
      p.bcb("mStateMachine");
    }
    if (l.UO(((m)localObject).getState()))
    {
      this.BYM = 3;
      if (this.BYM != 1) {
        break label799;
      }
      az(true, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.c.euM().oJ(true);
      UB(this.BYM);
      break;
      if (1 == this.BYM) {}
      for (bool = true;; bool = false)
      {
        this.BYO = bool;
        this.BYM = 3;
        break;
      }
      label799:
      az(false, true);
    }
  }
  
  public final void ty(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(215947);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.voip.c.euM().exy();
      com.tencent.mm.plugin.voip.c.euM().Ue(9);
      com.tencent.mm.plugin.voip.c.euM().tm(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      g localg = g.yhR;
      if (paramBoolean) {
        i = 2;
      }
      localg.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(215947);
      return;
      com.tencent.mm.plugin.voip.c.euM().exz();
      com.tencent.mm.plugin.voip.c.euM().Ue(8);
      com.tencent.mm.plugin.voip.c.euM().tm(false);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.c
 * JD-Core Version:    0.7.0.1
 */