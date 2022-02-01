package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/util/VoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "isAllowToResponseMike", "", "isCheckBluetoothEnd", "isSystemPhoneRing", "()Z", "setSystemPhoneRing", "(Z)V", "mAudioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "mBTRecoverSpeakerOn", "mHSRecoverSpeakerOn", "mIgnoreBluetooth", "mIsMute", "mIsScreenOff", "", "mIsSpeakerOn", "mStateMachine", "Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "getMStateMachine", "()Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;", "setMStateMachine", "(Lcom/tencent/mm/plugin/voip/util/VoipStateMachine;)V", "mUIType", "value", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "mVoIPUi", "getMVoIPUi", "()Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "setMVoIPUi", "(Lcom/tencent/mm/plugin/voip/ui/IVoipUI;)V", "mVoicePlayDevice", "checkClean", "", "enableSpeaker", "speakerOn", "ignoreBluetooth", "getContext", "Landroid/content/Context;", "initParams", "isVideoCall", "onAudioDeviceStateChanged", "status", "playRingSound", "mIsVideoCall", "refreshBTStatus", "releaseAudioPlayingDevice", "requestAudioMute", "requestAudioPlayingDevice", "isSwitchVoice", "useLastedDevice", "requestRingPlayerDevice", "requestSpeakerOn", "responseScreenOn", "isScreenOn", "setSpeakerAfterBluetoothDisconnected", "startVoIPRing", "isOutCall", "stopVoIPRing", "switchVoicePlayDevice", "newDevice", "unInit", "Companion", "plugin-voip_release"})
public final class b
  extends e
{
  public static final b.a ztf;
  private com.tencent.mm.compatible.util.b cST;
  private boolean mIsMute;
  private int mUIType;
  public j zgP;
  private boolean zhI;
  public boolean zhU;
  private int zhd;
  private boolean zhf;
  public boolean zhg;
  private boolean zhh;
  private boolean zhy;
  private volatile com.tencent.mm.plugin.voip.ui.b ztd;
  public boolean zte;
  
  static
  {
    AppMethodBeat.i(192293);
    ztf = new b.a((byte)0);
    AppMethodBeat.o(192293);
  }
  
  public b()
  {
    AppMethodBeat.i(192292);
    this.zhd = 1;
    this.cST = new com.tencent.mm.compatible.util.b(aj.getContext());
    Object localObject = this.cST;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voip");
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    AppMethodBeat.o(192292);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(192276);
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.Oe("voip");
    AppMethodBeat.o(192276);
  }
  
  private final void Qz(int paramInt)
  {
    AppMethodBeat.i(192278);
    ad.m("MicroMsg.VoIP.VoIPAudioManager", "switchVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt) });
    this.zhd = paramInt;
    com.tencent.mm.plugin.voip.ui.b localb = this.ztd;
    if (localb != null)
    {
      localb.setVoicePlayDevice(this.zhd);
      AppMethodBeat.o(192278);
      return;
    }
    AppMethodBeat.o(192278);
  }
  
  private final void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192280);
    ad.m("MicroMsg.VoIP.VoIPAudioManager", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    boolean bool = paramBoolean1;
    if (!paramBoolean2)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      bool = paramBoolean1;
      if (com.tencent.mm.plugin.audio.d.a.bvC()) {
        bool = false;
      }
    }
    if (ae.fFx.fzm)
    {
      ae.fFx.dump();
      if (ae.fFx.fzn > 0) {
        com.tencent.mm.plugin.voip.c.dRQ().rr(bool);
      }
    }
    if ((ae.fFx.fzP >= 0) || (ae.fFx.fzQ >= 0)) {
      com.tencent.mm.plugin.voip.c.dRQ().rr(bool);
    }
    Object localObject = com.tencent.mm.plugin.voip.c.dRQ();
    k.g(localObject, "SubCoreVoip.getVoipService()");
    a(bool, ((u)localObject).aDs(), paramBoolean2);
    com.tencent.mm.plugin.voip.c.dRQ().rD(bool);
    this.zhh = bool;
    AppMethodBeat.o(192280);
  }
  
  private final Context getContext()
  {
    Object localObject2 = null;
    AppMethodBeat.i(192291);
    Object localObject1 = localObject2;
    if (this.ztd != null)
    {
      com.tencent.mm.plugin.voip.ui.b localb = this.ztd;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.dVM();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = aj.getContext();
    }
    AppMethodBeat.o(192291);
    return localObject2;
  }
  
  private final void rM(boolean paramBoolean)
  {
    AppMethodBeat.i(192279);
    ap(paramBoolean, this.zhI);
    AppMethodBeat.o(192279);
  }
  
  public static void rP(boolean paramBoolean)
  {
    AppMethodBeat.i(192284);
    com.tencent.mm.plugin.voip.c.dRQ().stopRing();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.dRQ().Qm(i);
      AppMethodBeat.o(192284);
      return;
    }
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(192285);
    Object localObject = this.cST;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvC())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(192285);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    if (a.a.bvB().bvw())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(192285);
      return;
    }
    boolean bool1;
    if (1 == this.zhd)
    {
      bool1 = true;
      if ((!paramBoolean1) || (this.zte)) {
        break label144;
      }
      b("voip", Integer.valueOf(2));
      paramBoolean1 = bool2;
    }
    for (;;)
    {
      ck(paramBoolean1);
      AppMethodBeat.o(192285);
      return;
      bool1 = false;
      break;
      label144:
      if (paramBoolean2)
      {
        b("voip", Integer.valueOf(1));
        paramBoolean1 = true;
      }
      else
      {
        b("voip", Integer.valueOf(this.zhd));
        paramBoolean1 = bool1;
      }
    }
  }
  
  public final void ar(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i = 0;
    AppMethodBeat.i(192287);
    if (!this.mpg)
    {
      ad.m("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing ignore bluetooth or not bt plug", new Object[0]);
      if (paramBoolean1) {}
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.dRQ().aD(i, paramBoolean2);
        AppMethodBeat.o(192287);
        return;
        i = 1;
      }
    }
    ad.i("MicroMsg.VoIP.VoIPAudioManager", "startVoIPRing but waitting the bt connected");
    this.mpf = ((d.g.a.b)new b(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(192287);
  }
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(192275);
    this.ztd = paramb;
    paramb = this.ztd;
    if (paramb != null) {
      paramb.setVoicePlayDevice(this.zhd);
    }
    paramb = this.ztd;
    if (paramb != null)
    {
      paramb.setMute(this.mIsMute);
      AppMethodBeat.o(192275);
      return;
    }
    AppMethodBeat.o(192275);
  }
  
  public final void cRA()
  {
    AppMethodBeat.i(192290);
    Oc("voip");
    com.tencent.mm.plugin.voip.c.dRQ().stopRing();
    AppMethodBeat.o(192290);
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(192281);
    Object localObject = this.cST;
    if (localObject != null) {
      ((com.tencent.mm.compatible.util.b)localObject).requestFocus();
    }
    super.ck(paramBoolean);
    if (bvy() != -1)
    {
      i = bvy();
      Qz(i);
      localObject = com.tencent.mm.plugin.voip.c.dRQ();
      k.g(localObject, "SubCoreVoip.getVoipService()");
      if (((u)localObject).cSx()) {
        break label124;
      }
      com.tencent.mm.plugin.voip.c.dRQ().rE(paramBoolean);
      label67:
      localObject = h.vKh;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      ((h)localObject).f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(i), Integer.valueOf(0) });
      AppMethodBeat.o(192281);
      return;
      i = this.zhd;
      break;
      label124:
      rM(paramBoolean);
      break label67;
    }
  }
  
  public final void dSC()
  {
    AppMethodBeat.i(192289);
    com.tencent.mm.compatible.util.b localb = this.cST;
    if (localb != null) {
      localb.XF();
    }
    com.tencent.mm.plugin.voip.c.dRQ().stopRing();
    bvv();
    AppMethodBeat.o(192289);
  }
  
  public final void dSr()
  {
    AppMethodBeat.i(192288);
    com.tencent.mm.plugin.voip.c.dRQ().stopRing();
    this.mpf = null;
    AppMethodBeat.o(192288);
  }
  
  public final void dWr()
  {
    AppMethodBeat.i(192286);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvE())
    {
      b("voip", Integer.valueOf(4));
      AppMethodBeat.o(192286);
      return;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    if (a.a.bvB().bvw())
    {
      b("voip", Integer.valueOf(3));
      AppMethodBeat.o(192286);
      return;
    }
    b("voip", Integer.valueOf(2));
    AppMethodBeat.o(192286);
  }
  
  public final void hL(int paramInt)
  {
    int j = 3;
    int i = 2;
    AppMethodBeat.i(192277);
    super.hL(paramInt);
    if ((this.mpd.isEmpty()) && ((paramInt != 9) || (paramInt != 8)))
    {
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "no situation need to respone this event ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(192277);
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
        AppMethodBeat.o(192277);
        return;
        this.zhy = false;
        localObject = this.zgP;
        if (localObject == null) {
          k.aPZ("mStateMachine");
        }
        if (!i.QM(((j)localObject).getState())) {
          if (1 != this.zhd) {
            break label233;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          this.zhg = bool1;
          localObject = com.tencent.mm.plugin.voip.c.dRQ();
          k.g(localObject, "SubCoreVoip.getVoipService()");
          a(false, ((u)localObject).aDs(), false);
          com.tencent.mm.plugin.voip.c.dRQ().rr(false);
          com.tencent.mm.plugin.voip.c.dRQ().rD(false);
          Qz(4);
          this.zhy = false;
          com.tencent.mm.plugin.voip.c.dRQ().nv(true);
          AppMethodBeat.o(192277);
          return;
        }
      } while (this.zhU);
      boolean bool2 = vQ(3);
      boolean bool3 = this.zhy;
      localObject = this.zgP;
      if (localObject == null) {
        k.aPZ("mStateMachine");
      }
      boolean bool4 = i.QM(((j)localObject).getState());
      localObject = com.tencent.mm.plugin.voip.c.dRQ();
      k.g(localObject, "SubCoreVoip.getVoipService()");
      boolean bool5 = ((u)localObject).cSx();
      boolean bool6 = this.zhg;
      if (2 == this.mUIType)
      {
        bool1 = true;
        ad.i("MicroMsg.VoIP.VoIPAudioManager", "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s, isHeadsetPlugged: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (!this.zhy)
        {
          localObject = this.zgP;
          if (localObject == null) {
            k.aPZ("mStateMachine");
          }
          if (!i.QM(((j)localObject).getState())) {
            break label531;
          }
          localObject = com.tencent.mm.plugin.voip.c.dRQ();
          k.g(localObject, "SubCoreVoip.getVoipService()");
          if ((!((u)localObject).cSx()) || (bool2)) {
            break label526;
          }
          paramInt = 1;
          this.zhd = paramInt;
          if (this.zhd != 1) {
            break label615;
          }
          ap(true, true);
          switch (this.zhd)
          {
          }
        }
      }
      for (;;)
      {
        Qz(this.zhd);
        this.zhy = true;
        com.tencent.mm.plugin.voip.c.dRQ().nv(false);
        this.zhI = true;
        AppMethodBeat.o(192277);
        return;
        bool1 = false;
        break;
        paramInt = 2;
        break label444;
        localObject = com.tencent.mm.plugin.voip.c.dRQ();
        k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cSx())
        {
          if (vQ(3)) {
            i = 3;
          }
          this.zhd = i;
          break label449;
        }
        if (((this.zhg) || (2 == this.mUIType)) && (!bool2)) {
          paramInt = 1;
        }
        for (;;)
        {
          this.zhd = paramInt;
          this.zhg = false;
          break;
          paramInt = j;
          if (!bool2) {
            paramInt = 2;
          }
        }
        rM(false);
        break label463;
        bvu();
        continue;
        hN(true);
      }
    case 9: 
      label233:
      bool1 = isBluetoothScoOn();
      label444:
      label449:
      label463:
      label615:
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "headset disconnected and  bluetooth: %s", new Object[] { Boolean.valueOf(bool1) });
      label526:
      label531:
      if (3 != this.zhd)
      {
        ad.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
        AppMethodBeat.o(192277);
        return;
      }
      localObject = this.zgP;
      if (localObject == null) {
        k.aPZ("mStateMachine");
      }
      if (i.QM(((j)localObject).getState())) {
        if (bool1)
        {
          i = 4;
          this.zhd = i;
          label727:
          if (this.zhd != 1) {
            break label1026;
          }
          ap(true, true);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.voip.c.dRQ().nv(false);
        Qz(this.zhd);
        AppMethodBeat.o(192277);
        return;
        localObject = com.tencent.mm.plugin.voip.c.dRQ();
        k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cSx()) {
          break;
        }
        Context localContext = getContext();
        localObject = getContext();
        if (localObject != null) {}
        for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
        {
          Toast.makeText(localContext, (CharSequence)localObject, 0).show();
          i = 1;
          break;
        }
        if (bool1)
        {
          if (1 == this.zhd) {}
          for (bool1 = true;; bool1 = false)
          {
            this.zhf = bool1;
            this.zhd = 4;
            break;
          }
        }
        localObject = com.tencent.mm.plugin.voip.c.dRQ();
        k.g(localObject, "SubCoreVoip.getVoipService()");
        if (!((u)localObject).cSx())
        {
          this.zhd = 2;
          break label727;
        }
        if ((this.zhf) || (2 == this.mUIType))
        {
          localContext = getContext();
          localObject = getContext();
          if (localObject != null) {}
          for (localObject = ((Context)localObject).getString(2131764937);; localObject = null)
          {
            Toast.makeText(localContext, (CharSequence)localObject, 0).show();
            i = 1;
            this.zhd = i;
            this.zhf = false;
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
        label1026:
        rM(false);
      }
    }
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    ad.i("MicroMsg.VoIP.VoIPAudioManager", "headset connected and bluetooth: %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.d.a.bvC()) });
    if (3 == this.zhd)
    {
      ad.i("MicroMsg.VoIP.VoIPAudioManager", "same status, no changed");
      AppMethodBeat.o(192277);
      return;
    }
    localObject = this.zgP;
    if (localObject == null) {
      k.aPZ("mStateMachine");
    }
    if (i.QM(((j)localObject).getState()))
    {
      this.zhd = 3;
      if (this.zhd != 1) {
        break label1184;
      }
      ap(true, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.c.dRQ().nv(true);
      Qz(this.zhd);
      break;
      if (1 == this.zhd) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zhf = bool1;
        this.zhd = 3;
        break;
      }
      label1184:
      ap(false, true);
    }
  }
  
  public final void rN(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(192282);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.voip.c.dRQ().dUB();
      com.tencent.mm.plugin.voip.c.dRQ().Qd(9);
      com.tencent.mm.plugin.voip.c.dRQ().rC(true);
    }
    for (;;)
    {
      this.mIsMute = paramBoolean;
      h localh = h.vKh;
      if (paramBoolean) {
        i = 2;
      }
      localh.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(i) });
      AppMethodBeat.o(192282);
      return;
      com.tencent.mm.plugin.voip.c.dRQ().dUC();
      com.tencent.mm.plugin.voip.c.dRQ().Qd(8);
      com.tencent.mm.plugin.voip.c.dRQ().rC(false);
    }
  }
  
  public final void rO(boolean paramBoolean)
  {
    AppMethodBeat.i(192283);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    int i;
    if (a.a.bvB().bvw()) {
      i = 3;
    }
    for (;;)
    {
      this.zhd = i;
      this.zhg = paramBoolean;
      AppMethodBeat.o(192283);
      return;
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      if (com.tencent.mm.plugin.audio.d.a.bvE()) {
        i = 4;
      } else if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    b(b paramb, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b
 * JD-Core Version:    0.7.0.1
 */