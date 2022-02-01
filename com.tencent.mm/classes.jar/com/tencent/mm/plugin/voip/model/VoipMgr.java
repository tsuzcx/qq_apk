package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ah;

public final class VoipMgr
  extends a
{
  static int UxL = 0;
  static int[] UxM = new int[2];
  
  public final void Gh(boolean paramBoolean)
  {
    throw null;
  }
  
  public final void Gl(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    Log.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(115001);
    throw null;
  }
  
  public final void Gm(boolean paramBoolean) {}
  
  public final boolean Gn(boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (SubCoreVoip.hVp().UBU)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    AppMethodBeat.o(115057);
    throw null;
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(293544);
    if (!((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zvd, true))
    {
      AppMethodBeat.o(293544);
      return;
    }
    AppMethodBeat.o(293544);
    throw null;
  }
  
  public final void VQ(int paramInt)
  {
    AppMethodBeat.i(115035);
    Log.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt))
    {
      AppMethodBeat.o(115035);
      throw null;
    }
    AppMethodBeat.o(115035);
  }
  
  public final void VR(int paramInt)
  {
    throw null;
  }
  
  public final void VS(int paramInt)
  {
    AppMethodBeat.i(115040);
    Log.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(115040);
    throw null;
  }
  
  public final void VT(int paramInt)
  {
    AppMethodBeat.i(115041);
    Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(115041);
    throw null;
  }
  
  public final void VW(int paramInt)
  {
    throw null;
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(293344);
    Log.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(293344);
    throw null;
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    Log.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    AppMethodBeat.o(115016);
    throw null;
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    new Object[3][0] = Integer.valueOf(paramInt);
    AppMethodBeat.o(115011);
    throw null;
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView) {}
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt) {}
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView) {}
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(115046);
    AppMethodBeat.o(115046);
    throw null;
  }
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115063);
    AppMethodBeat.o(115063);
    throw null;
  }
  
  public final void aDH(String paramString)
  {
    throw null;
  }
  
  public final void aF(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(293410);
    long l = System.currentTimeMillis();
    if ((Build.VERSION.SDK_INT < 29) || (AppForegroundDelegate.heY.eLx))
    {
      AppMethodBeat.o(293410);
      throw null;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "start channel ring, now:".concat(String.valueOf(l)));
    AppMethodBeat.o(293410);
    throw null;
  }
  
  public final boolean aL(kotlin.g.a.b<Boolean, ah> paramb)
  {
    AppMethodBeat.i(293403);
    Log.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    AppMethodBeat.o(293403);
    throw null;
  }
  
  public final void apT(int paramInt) {}
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    throw null;
  }
  
  public final void bn(boolean paramBoolean1, boolean paramBoolean2)
  {
    throw null;
  }
  
  public final void c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    AppMethodBeat.o(115036);
    throw null;
  }
  
  public final void dre()
  {
    AppMethodBeat.i(115061);
    AppMethodBeat.o(115061);
    throw null;
  }
  
  public final void fQN()
  {
    AppMethodBeat.i(293552);
    Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    AppMethodBeat.o(293552);
    throw null;
  }
  
  public final void fQO()
  {
    AppMethodBeat.i(115051);
    Log.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    AppMethodBeat.o(115051);
    throw null;
  }
  
  public final void fvW()
  {
    AppMethodBeat.i(115028);
    Log.i("MicroMsg.Voip.VoipMgr", "onReject");
    AppMethodBeat.o(115028);
    throw null;
  }
  
  public final void fwc() {}
  
  public final void fwd()
  {
    AppMethodBeat.i(115022);
    Log.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    AppMethodBeat.o(115022);
    throw null;
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(184052);
    AppMethodBeat.o(184052);
    throw null;
  }
  
  public final void fwj()
  {
    AppMethodBeat.i(115027);
    Log.i("MicroMsg.Voip.VoipMgr", "on accept");
    AppMethodBeat.o(115027);
    throw null;
  }
  
  public final void fwk()
  {
    AppMethodBeat.i(115031);
    Log.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    AppMethodBeat.o(115031);
    throw null;
  }
  
  public final void fwl()
  {
    AppMethodBeat.i(115033);
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    localObject = new Object[5];
    localObject[0] = Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId);
    localObject[1] = Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
    localObject[2] = Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC());
    AppMethodBeat.o(115033);
    throw null;
  }
  
  public final void fwm()
  {
    AppMethodBeat.i(115042);
    Log.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    AppMethodBeat.o(115042);
    throw null;
  }
  
  public final long fwn()
  {
    AppMethodBeat.i(115044);
    AppMethodBeat.o(115044);
    throw null;
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(293556);
    Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkCostMax");
    AppMethodBeat.o(293556);
    throw null;
  }
  
  public final void gG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293573);
    Log.i("MicroMsg.Voip.VoipMgr", "camera preview size applye is $width and $height");
    AppMethodBeat.o(293573);
  }
  
  public final int getState()
  {
    throw null;
  }
  
  public final String getUserName()
  {
    throw null;
  }
  
  public final boolean hVH()
  {
    AppMethodBeat.i(115003);
    AppMethodBeat.o(115003);
    throw null;
  }
  
  public final boolean hVI()
  {
    AppMethodBeat.i(115004);
    AppMethodBeat.o(115004);
    throw null;
  }
  
  public final boolean hVJ()
  {
    AppMethodBeat.i(115005);
    AppMethodBeat.o(115005);
    throw null;
  }
  
  public final boolean hVK()
  {
    AppMethodBeat.i(115006);
    AppMethodBeat.o(115006);
    throw null;
  }
  
  public final boolean hVL()
  {
    AppMethodBeat.i(115007);
    AppMethodBeat.o(115007);
    throw null;
  }
  
  public final boolean hVM()
  {
    AppMethodBeat.i(115008);
    AppMethodBeat.o(115008);
    throw null;
  }
  
  public final boolean hVN()
  {
    AppMethodBeat.i(115009);
    AppMethodBeat.o(115009);
    throw null;
  }
  
  public final boolean hVO()
  {
    AppMethodBeat.i(115010);
    AppMethodBeat.o(115010);
    throw null;
  }
  
  public final void hVP()
  {
    AppMethodBeat.i(115012);
    AppMethodBeat.o(115012);
    throw null;
  }
  
  public final void hVQ()
  {
    AppMethodBeat.i(115014);
    Log.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    new NetChangedBroadcastReceiver();
    AppMethodBeat.o(115014);
    throw null;
  }
  
  public final void hVU()
  {
    AppMethodBeat.i(115018);
    AppMethodBeat.o(115018);
    throw null;
  }
  
  public final void hVV() {}
  
  public final void hVW() {}
  
  public final void hVX() {}
  
  public final boolean hVZ()
  {
    AppMethodBeat.i(115020);
    if (SubCoreVoip.hVp().UBE.UvO.UyU.roomId == 0)
    {
      AppMethodBeat.o(115020);
      throw null;
    }
    AppMethodBeat.o(115020);
    throw null;
  }
  
  public final boolean hVh()
  {
    throw null;
  }
  
  public final boolean hVi()
  {
    throw null;
  }
  
  public final String hVj()
  {
    throw null;
  }
  
  public final long hVk()
  {
    throw null;
  }
  
  public final long hVl()
  {
    throw null;
  }
  
  public final int hVm()
  {
    throw null;
  }
  
  public final boolean hVn()
  {
    throw null;
  }
  
  public final void hWh()
  {
    throw null;
  }
  
  public final void hWi()
  {
    AppMethodBeat.i(115058);
    AppMethodBeat.o(115058);
    throw null;
  }
  
  public final void hWj()
  {
    AppMethodBeat.i(115059);
    AppMethodBeat.o(115059);
    throw null;
  }
  
  public final void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115039);
    Log.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(115039);
    throw null;
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
    AppMethodBeat.o(115032);
    throw null;
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
    AppMethodBeat.o(115026);
    throw null;
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    AppMethodBeat.o(115064);
    throw null;
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    AppMethodBeat.o(115038);
    throw null;
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(293526);
    new StringBuilder("setSpatiotemporalDenosing, isON: ").append(paramInt).append("，mVoipUI: ");
    AppMethodBeat.o(293526);
    throw null;
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    throw null;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    new StringBuilder("setVoipBeauty, isON: ").append(paramInt).append("，mVoipUI: ");
    AppMethodBeat.o(115037);
    throw null;
  }
  
  public final void vI(boolean paramBoolean)
  {
    AppMethodBeat.i(293516);
    Log.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    AppMethodBeat.o(293516);
    throw null;
  }
  
  public final void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(115050);
    Log.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    AppMethodBeat.o(115050);
    throw null;
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    AppMethodBeat.o(115002);
    throw null;
  }
  
  public class NetChangedBroadcastReceiver
    extends BroadcastReceiver
  {
    public NetChangedBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(114993);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (g.ibq())
        {
        }
        int k;
        do
        {
          do
          {
            do
            {
              do
              {
                AppMethodBeat.o(114993);
                return;
              } while (VoipMgr.hXx() == 5);
              j = VoipMgr.bPL()[1];
              if (VoipMgr.hXy() == 0) {
                VoipMgr.hXz();
              }
            } while (VoipMgr.hXy() == 0);
            k = VoipMgr.hXA() / VoipMgr.hXy();
            VoipMgr.hXz();
            m = VoipMgr.bPL()[0];
            Log.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.hXB());
            if (VoipMgr.hXu()) {}
            for (;;)
            {
              g.a(i, System.currentTimeMillis(), VoipMgr.hXx(), 5, j, m, k);
              VoipMgr.hXC();
              VoipMgr.hXD();
              VoipMgr.hXE();
              VoipMgr.hXF();
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.hXx() == 4);
          k = VoipMgr.bPL()[0];
          if (VoipMgr.hXy() == 0) {
            VoipMgr.hXz();
          }
        } while (VoipMgr.hXy() == 0);
        int m = VoipMgr.hXA() / VoipMgr.hXy();
        VoipMgr.hXz();
        int n = VoipMgr.bPL()[1];
        Log.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.hXB());
        if (VoipMgr.hXu()) {}
        for (i = j;; i = 1)
        {
          g.a(i, System.currentTimeMillis(), VoipMgr.hXx(), 4, k, n, m);
          VoipMgr.hXC();
          VoipMgr.hXD();
          VoipMgr.hXE();
          VoipMgr.hXF();
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (VoipMgr.hXG() == 0L))
      {
        System.currentTimeMillis();
        VoipMgr.hXH();
        AppMethodBeat.o(114993);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (VoipMgr.hXG() != 0L))
      {
        System.currentTimeMillis();
        VoipMgr.hXG();
        VoipMgr.hXI();
        VoipMgr.hXH();
      }
      AppMethodBeat.o(114993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */