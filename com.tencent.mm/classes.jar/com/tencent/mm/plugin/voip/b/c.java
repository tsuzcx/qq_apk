package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "isAllowToResponseMike", "", "isCheckBluetoothEnd", "isOutCall", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "getMStateMachine", "()Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "setMStateMachine", "(Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;)V", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "checkClean", "", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "onAudioDeviceStateChanged", "status", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "Companion", "plugin-voip_release"})
public final class c
  extends e
{
  public static final c.a ALW;
  public boolean AAE;
  private boolean AAh;
  private boolean AAr;
  public boolean AFd;
  private volatile com.tencent.mm.plugin.voip.ui.b ALU;
  public boolean ALV;
  private int AzM;
  private boolean AzO;
  public boolean AzP;
  private boolean AzQ;
  public k Azy;
  private com.tencent.mm.compatible.util.b cQq;
  private boolean mIsMute;
  private int mUIType;
  
  static
  {
    AppMethodBeat.i(208641);
    ALW = new c.a((byte)0);
    AppMethodBeat.o(208641);
  }
  
  public c()
  {
    AppMethodBeat.i(208640);
    this.AzM = 1;
    this.cQq = new com.tencent.mm.compatible.util.b(ai.getContext());
    Object localObject = this.cQq;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    AppMethodBeat.o(208640);
  }
  
  private final void SI(int paramInt)
  {
    AppMethodBeat.i(208626);
    ac.m("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt) });
    this.AzM = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.ALU;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.AzM);
      AppMethodBeat.o(208626);
      return;
    }
    AppMethodBeat.o(208626);
  }
  
  private final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208628);
    ac.m("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.a.bCy()) {
        bool = false;
      }
    }
    if (ae.fJe.fCT)
    {
      ae.fJe.dump();
      if (ae.fJe.fCU > 0) {
        com.tencent.mm.plugin.voip.c.ehb().ss(bool);
      }
    }
    if ((ae.fJe.fDw >= 0) || (ae.fJe.fDx >= 0)) {
      com.tencent.mm.plugin.voip.c.ehb().ss(bool);
    }
    Object localObject = com.tencent.mm.plugin.voip.c.ehb();
    d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).aKj(), paramBoolean2);
    com.tencent.mm.plugin.voip.c.ehb().sE(bool);
    this.AzQ = bool;
    AppMethodBeat.o(208628);
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(208639);
    Object localObject1 = localObject2;
    if (this.ALU != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.ALU;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.ekX();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ai.getContext();
    }
    AppMethodBeat.o(208639);
    return localObject2;
  }
  
  private final void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(208627);
    at(paramBoolean, this.AAr);
    AppMethodBeat.o(208627);
  }
  
  public static void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(208632);
    com.tencent.mm.plugin.voip.c.ehb().stopRing();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.ehb().Sv(i);
      AppMethodBeat.o(208632);
      return;
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(208624);
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.So("voip");
    AppMethodBeat.o(208624);
  }
  
  public final void aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210533);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    int i;
    if (a.a.bCx().bCs()) {
      i = 3;
    }
    for (;;)
    {
      this.AzM = i;
      this.AFd = paramBoolean2;
      this.AzP = paramBoolean1;
      AppMethodBeat.o(210533);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      if (com.tencent.mm.plugin.audio.d.a.bCA()) {
        i = 4;
      } else if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208633);
    Object localObject = this.cQq;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCy())
    {
      b("voip", Integer.valueOf(4));
      sN(false);
      AppMethodBeat.o(208633);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    if (a.a.bCx().bCs())
    {
      b("voip", Integer.valueOf(3));
      sN(false);
      AppMethodBeat.o(208633);
      return;
    }
    boolean bool1;
    if (1 == this.AzM)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.ALV)) {
        break label154;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      cm(paramBoolean1);
      AppMethodBeat.o(208633);
      return;
      bool1 = false;
      break;
      label154:
      if (paramBoolean2)
      {
        b("voip", Integer.valueOf(1));
        paramBoolean1 = true;
      }
      else
      {
        b("voip", Integer.valueOf(this.AzM));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void av(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = 0;
    AppMethodBeat.i(208635);
    if (!this.mRh)
    {
      ac.m("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      if (paramBoolean1) {}
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.ehb().aH(i, paramBoolean2);
        AppMethodBeat.o(208635);
        return;
        i = 1;
      }
    }
    ac.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    this.mRg = ((d.g.a.b)new b(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(208635);
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(208623);
    this.ALU = paramb;
    paramb = this.ALU;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.AzM);
    }
    paramb = this.ALU;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(208623);
      return;
    }
    AppMethodBeat.o(208623);
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(208629);
    Object localObject = this.cQq;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.cm(paramBoolean);
    if (bCu() != -1)
    {
      i = bCu();
      SI(i);
      localObject = com.tencent.mm.plugin.voip.c.ehb();
      d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).bVB()) {
        break label124;
      }
      com.tencent.mm.plugin.voip.c.ehb().sF(paramBoolean);
      label67:
      localObject = h.wUl;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      ((h)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(208629);
      return;
      i = this.AzM;
      break;
      label124:
      sN(paramBoolean);
      break label67;
    }
  }
  
  public final void dfk()
  {
    AppMethodBeat.i(208638);
    Sl("voip");
    com.tencent.mm.plugin.voip.c.ehb().stopRing();
    AppMethodBeat.o(208638);
  }
  
  public final void ehD()
  {
    AppMethodBeat.i(208636);
    com.tencent.mm.plugin.voip.c.ehb().stopRing();
    this.mRg = null;
    AppMethodBeat.o(208636);
  }
  
  public final void ehO()
  {
    AppMethodBeat.i(208637);
    com.tencent.mm.compatible.util.b localb = this.cQq;
    if (localb != null) {
      localb.YC();
    }
    com.tencent.mm.plugin.voip.c.ehb().stopRing();
    bCr();
    AppMethodBeat.o(208637);
  }
  
  public final void elJ()
  {
    AppMethodBeat.i(208634);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCA())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(208634);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    if (a.a.bCx().bCs())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(208634);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(208634);
  }
  
  public final void hv(int paramInt)
  {
    int i = 2;
    int j = 3;
    AppMethodBeat.i(208625);
    super.hv(paramInt);
    if ((this.mRe.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      ac.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(208625);
      return;
    }
    boolean bool1;
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
        AppMethodBeat.o(208625);
        return;
        this.AAh = false;
        localObject = this.Azy;
        if (localObject == null) {
          d.g.b.k.aVY("mStateMachine");
        }
        if (!j.SV(((k)localObject).getState())) {
          if (1 != this.AzM) {
            break label233;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          this.AzP = bool1;
          localObject = com.tencent.mm.plugin.voip.c.ehb();
          d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
          a(false, ((u)localObject).aKj(), false);
          com.tencent.mm.plugin.voip.c.ehb().ss(false);
          com.tencent.mm.plugin.voip.c.ehb().sE(false);
          SI(4);
          this.AAh = false;
          com.tencent.mm.plugin.voip.c.ehb().op(true);
          AppMethodBeat.o(208625);
          return;
        }
      } while (this.AAE);
      boolean bool2 = wH(3);
      boolean bool3 = this.AAh;
      localObject = this.Azy;
      if (localObject == null) {
        d.g.b.k.aVY("mStateMachine");
      }
      boolean bool4 = j.SV(((k)localObject).getState());
      localObject = com.tencent.mm.plugin.voip.c.ehb();
      d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
      boolean bool5 = ((u)localObject).bVB();
      boolean bool6 = this.AzP;
      if (2 == this.mUIType)
      {
        bool1 = true;
        ac.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!this.AAh)
        {
          localObject = this.Azy;
          if (localObject == null) {
            d.g.b.k.aVY("mStateMachine");
          }
          if (!j.SV(((k)localObject).getState())) {
            break label511;
          }
          if (bool2) {
            break label506;
          }
          paramInt = 1;
          this.AzM = paramInt;
          if (this.AzM != 1) {
            break label612;
          }
          at(true, true);
          switch (this.AzM)
          {
          }
        }
      }
      for (;;)
      {
        SI(this.AzM);
        this.AAh = true;
        com.tencent.mm.plugin.voip.c.ehb().op(false);
        this.AAr = true;
        AppMethodBeat.o(208625);
        return;
        bool1 = false;
        break;
        paramInt = 3;
        break label424;
        localObject = com.tencent.mm.plugin.voip.c.ehb();
        d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).bVB())
        {
          if (wH(3)) {
            paramInt = j;
          }
          for (;;)
          {
            this.AzM = paramInt;
            break;
            if (!this.AFd) {
              paramInt = 1;
            } else {
              paramInt = 2;
            }
          }
        }
        if (((this.AzP) || (2 == this.mUIType)) && (!bool2)) {
          paramInt = 1;
        }
        for (;;)
        {
          this.AzM = paramInt;
          this.AzP = false;
          break;
          paramInt = j;
          if (!bool2) {
            paramInt = 2;
          }
        }
        sN(false);
        break label443;
        bCq();
        continue;
        il(true);
      }
    case 9: 
      label233:
      label506:
      label511:
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      label424:
      label443:
      label612:
      bool1 = com.tencent.mm.plugin.audio.d.a.bCA();
      ac.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool1) });
      if (3 != this.AzM)
      {
        ac.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(208625);
        return;
      }
      localObject = this.Azy;
      if (localObject == null) {
        d.g.b.k.aVY("mStateMachine");
      }
      if (j.SV(((k)localObject).getState())) {
        if (bool1)
        {
          b("voip", Integer.valueOf(4));
          paramInt = 4;
          this.AzM = paramInt;
          label739:
          if (this.AzM != 1) {
            break label1065;
          }
          at(true, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.ehb().op(false);
        SI(this.AzM);
        AppMethodBeat.o(208625);
        return;
        localObject = com.tencent.mm.plugin.voip.c.ehb();
        d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).bVB())
        {
          paramInt = i;
          if (this.AFd) {
            break;
          }
          paramInt = 1;
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
        if (bool1)
        {
          if (1 == this.AzM) {}
          for (bool1 = true;; bool1 = false)
          {
            this.AzO = bool1;
            this.AzM = 4;
            b("voip", Integer.valueOf(4));
            break;
          }
        }
        localObject = com.tencent.mm.plugin.voip.c.ehb();
        d.g.b.k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).bVB())
        {
          if (!this.AFd) {
            break label739;
          }
          break label739;
        }
        if ((this.AzO) || (2 == this.mUIType))
        {
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            i = 1;
            this.AzM = i;
            this.AzO = false;
            break;
          }
        }
        localContext = getContext();
        localObject = getContext();
        if (localObject != null) {}
        for (localObject = ((Context)localObject).getString(2131764936);; localObject = null)
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          break;
        }
        label1065:
        sN(false);
      }
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    ac.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.a.bCA()) });
    if (3 == this.AzM)
    {
      ac.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
      AppMethodBeat.o(208625);
      return;
    }
    localObject = this.Azy;
    if (localObject == null) {
      d.g.b.k.aVY("mStateMachine");
    }
    if (j.SV(((k)localObject).getState()))
    {
      this.AzM = 3;
      if (this.AzM != 1) {
        break label1223;
      }
      at(true, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.c.ehb().op(true);
      SI(this.AzM);
      break;
      if (1 == this.AzM) {}
      for (bool1 = true;; bool1 = false)
      {
        this.AzO = bool1;
        this.AzM = 3;
        break;
      }
      label1223:
      at(false, true);
    }
  }
  
  public final void sO(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(208630);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.voip.c.ehb().ejN();
      com.tencent.mm.plugin.voip.c.ehb().Sm(9);
      com.tencent.mm.plugin.voip.c.ehb().sD(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      h localh = h.wUl;
      if (paramBoolean) {
        i = 2;
      }
      localh.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(208630);
      return;
      com.tencent.mm.plugin.voip.c.ehb().ejO();
      com.tencent.mm.plugin.voip.c.ehb().Sm(8);
      com.tencent.mm.plugin.voip.c.ehb().sD(false);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
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