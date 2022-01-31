package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

class TraeAudioManager$f$2
  extends Handler
{
  TraeAudioManager$f$2(TraeAudioManager.f paramf) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    label95:
    do
    {
      do
      {
        try
        {
          HashMap localHashMap = (HashMap)paramMessage.obj;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
            if (this.a.g)
            {
              str = "Y";
              QLog.w("TRAE", 2, str);
            }
          }
          else
          {
            if (paramMessage.what != 32772) {
              break label95;
            }
            this.a.a(localHashMap);
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              localObject = null;
              continue;
              String str = "N";
            }
            if (!this.a.g)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "******* disabled ,skip msg******");
              }
              paramMessage = new Intent();
              this.a.p.sendResBroadcast(paramMessage, (HashMap)localObject, 1);
              return;
            }
            switch (paramMessage.what)
            {
            default: 
              return;
            case 32773: 
              this.a.b();
              return;
            case 32774: 
              this.a.b((HashMap)localObject);
              return;
            case 32777: 
              this.a.p.InternalSessionIsDeviceChangabled((HashMap)localObject);
              return;
            case 32778: 
              this.a.p.InternalSessionGetConnectedDevice((HashMap)localObject);
              return;
            case 32779: 
              this.a.p.InternalSessionGetConnectingDevice((HashMap)localObject);
              return;
            case 32780: 
              this.a.c((HashMap)localObject);
              return;
            case 32781: 
              this.a.d((HashMap)localObject);
              return;
            case 32788: 
              paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
              if (paramMessage != null) {
                break label343;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
          return;
          this.a.p._streamType = paramMessage.intValue();
          this.a.b(paramMessage.intValue());
          return;
          this.a.e((HashMap)localObject);
          return;
          this.a.f((HashMap)localObject);
          return;
          this.a.g();
          return;
          this.a.a(this.a.p._streamType);
          return;
          this.a.g((HashMap)localObject);
          return;
          this.a.p.InternalSessionConnectDevice((HashMap)localObject);
          return;
          this.a.p.InternalSessionEarAction((HashMap)localObject);
          return;
          paramMessage = this.a.p._deviceConfigManager.f();
          localObject = this.a.p._deviceConfigManager.h();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramMessage);
          }
          if (TraeAudioManager.IsUpdateSceneFlag)
          {
            if ((TraeAudioManager.IsMusicScene) && (!this.a.p.IsBluetoothA2dpExisted))
            {
              this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.e("DEVICE_BLUETOOTHHEADSET"), null, true);
              return;
            }
            this.a.p.InternalConnectDevice(paramMessage, null, true);
            return;
          }
        }
        if (!paramMessage.equals(localObject))
        {
          this.a.p.InternalConnectDevice(paramMessage, null, false);
          return;
        }
        this.a.p.InternalNotifyDeviceListUpdate();
        return;
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      } while (this.a.p.InternalConnectDevice(paramMessage, null, false) == 0);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
      }
      this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
      return;
    } while (this.a.p.InternalConnectDevice(this.a.p.sessionConnectedDev, null, false) == 0);
    label343:
    paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.a.p.sessionConnectedDev + " connected fail,auto switch!");
    }
    this.a.p.InternalConnectDevice(this.a.p._deviceConfigManager.f(), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f.2
 * JD-Core Version:    0.7.0.1
 */