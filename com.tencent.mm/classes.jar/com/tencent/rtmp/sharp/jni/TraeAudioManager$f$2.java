package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

class TraeAudioManager$f$2
  extends Handler
{
  TraeAudioManager$f$2(TraeAudioManager.f paramf) {}
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(65659);
    Object localObject;
    try
    {
      HashMap localHashMap = (HashMap)paramMessage.obj;
      a.dUd();
      StringBuilder localStringBuilder = new StringBuilder("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
      if (this.a.g)
      {
        str = "Y";
        a.iP("TRAE", str);
        if (paramMessage.what != 32772) {
          break label102;
        }
        this.a.a(localHashMap);
        AppMethodBeat.o(65659);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
        continue;
        String str = "N";
      }
      label102:
      if (!this.a.g)
      {
        a.dUd();
        a.iP("TRAE", "******* disabled ,skip msg******");
        paramMessage = new Intent();
        this.a.p.sendResBroadcast(paramMessage, (HashMap)localObject, 1);
        AppMethodBeat.o(65659);
        return;
      }
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65659);
      return;
      this.a.c();
      AppMethodBeat.o(65659);
      return;
      this.a.b((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.p.InternalSessionIsDeviceChangabled((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.p.InternalSessionGetConnectedDevice((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.p.InternalSessionGetConnectingDevice((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.c((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.d((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
      if (paramMessage == null)
      {
        a.dUd();
        a.iO("TRAE", " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
        AppMethodBeat.o(65659);
        return;
      }
      this.a.p._streamType = paramMessage.intValue();
      this.a.b(paramMessage.intValue());
      AppMethodBeat.o(65659);
      return;
      this.a.e((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.f((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.h();
      AppMethodBeat.o(65659);
      return;
      this.a.a(this.a.p._streamType);
      AppMethodBeat.o(65659);
      return;
      this.a.g((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.p.InternalSessionConnectDevice((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      this.a.p.InternalSessionEarAction((HashMap)localObject);
      AppMethodBeat.o(65659);
      return;
      paramMessage = this.a.p._deviceConfigManager.f();
      localObject = this.a.p._deviceConfigManager.h();
      a.dUd();
      a.iP("TRAE", "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramMessage);
      if (TraeAudioManager.IsUpdateSceneFlag)
      {
        if ((TraeAudioManager.IsMusicScene) && (!this.a.p.IsBluetoothA2dpExisted))
        {
          this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.e("DEVICE_BLUETOOTHHEADSET"), null, true);
          AppMethodBeat.o(65659);
          return;
        }
        this.a.p.InternalConnectDevice(paramMessage, null, true);
        AppMethodBeat.o(65659);
        return;
      }
      if (!paramMessage.equals(localObject))
      {
        this.a.p.InternalConnectDevice(paramMessage, null, false);
        AppMethodBeat.o(65659);
        return;
      }
      this.a.p.InternalNotifyDeviceListUpdate();
      AppMethodBeat.o(65659);
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.a.p.InternalConnectDevice(paramMessage, null, false) != 0)
      {
        a.dUd();
        a.iP("TRAE", " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
        this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
        AppMethodBeat.o(65659);
        return;
        if (this.a.p.InternalConnectDevice(this.a.p.sessionConnectedDev, null, false) != 0)
        {
          paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
          a.dUd();
          a.iP("TRAE", " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
          this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.2
 * JD-Core Version:    0.7.0.1
 */