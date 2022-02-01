package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AudioSessionDuplicate
{
  private static final String TAG = "AudioSessionDuplicate";
  private static TraeAudioSession _as;
  private static boolean _preDone;
  private static Condition _precon;
  private static ReentrantLock _prelock;
  private static String[] mDeviceList;
  private static int playoutDeviceType;
  private static boolean usingJava;
  
  static
  {
    AppMethodBeat.i(13661);
    _as = null;
    ReentrantLock localReentrantLock = new ReentrantLock();
    _prelock = localReentrantLock;
    _precon = localReentrantLock.newCondition();
    _preDone = false;
    usingJava = true;
    mDeviceList = null;
    playoutDeviceType = 0;
    AppMethodBeat.o(13661);
  }
  
  public static void DeleteAudioSessionDuplicate()
  {
    AppMethodBeat.i(13657);
    TXCLog.i("AudioSessionDuplicate", " DeleteAudioSessionDuplicate...");
    if (_as != null)
    {
      _as.voiceCallPostprocess();
      _as.release();
      _as = null;
    }
    AppMethodBeat.o(13657);
  }
  
  public static void NewAudioSessionDuplicate(Context paramContext)
  {
    AppMethodBeat.i(13659);
    TXCLog.i("AudioSessionDuplicate", " NewAudioSessionDuplicate...");
    if (_as == null) {
      _as = new TraeAudioSession(paramContext, new TraeAudioSession.ITraeAudioCallback()
      {
        public final void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public final void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public final void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
        
        public final void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public final void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13797);
          AudioSessionDuplicate.access$302(paramAnonymousArrayOfString);
          if (AudioSessionDuplicate.usingJava) {
            AudioSessionDuplicate.access$500(paramAnonymousString1);
          }
          AppMethodBeat.o(13797);
        }
        
        public final void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(13799);
          if (paramAnonymousInt == 0) {
            AudioSessionDuplicate.access$500(paramAnonymousString);
          }
          AppMethodBeat.o(13799);
        }
        
        public final void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public final void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13798);
          AudioSessionDuplicate.access$302(paramAnonymousArrayOfString);
          AppMethodBeat.o(13798);
        }
        
        public final void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public final void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public final void onServiceStateUpdate(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(13796);
          if (!paramAnonymousBoolean) {
            try
            {
              AudioSessionDuplicate._prelock.lock();
              AudioSessionDuplicate.access$102(true);
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "onServiceStateUpdate signalAll");
              }
              AudioSessionDuplicate._precon.signalAll();
              AudioSessionDuplicate._prelock.unlock();
              AppMethodBeat.o(13796);
              return;
            }
            catch (Exception localException) {}
          }
          AppMethodBeat.o(13796);
        }
        
        public final void onStreamTypeUpdate(int paramAnonymousInt) {}
        
        public final void onVoicecallPreprocessRes(int paramAnonymousInt)
        {
          AppMethodBeat.i(13800);
          try
          {
            AudioSessionDuplicate._prelock.lock();
            AudioSessionDuplicate.access$102(true);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
            }
            AudioSessionDuplicate._precon.signalAll();
            AudioSessionDuplicate._prelock.unlock();
            AppMethodBeat.o(13800);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(13800);
          }
        }
      });
    }
    AppMethodBeat.o(13659);
  }
  
  private static void onOutputChanage(String paramString)
  {
    AppMethodBeat.i(13658);
    TXCLog.i("AudioSessionDuplicate", "device: ".concat(String.valueOf(paramString)));
    if (paramString.equals("DEVICE_EARPHONE")) {
      playoutDeviceType = 1;
    }
    for (;;)
    {
      TXCAudioEngineJNI.nativeSetPlayoutDevice(playoutDeviceType);
      AppMethodBeat.o(13658);
      return;
      if (paramString.equals("DEVICE_SPEAKERPHONE")) {
        playoutDeviceType = 2;
      } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
        playoutDeviceType = 3;
      } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
        playoutDeviceType = 4;
      } else {
        playoutDeviceType = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioSessionDuplicate
 * JD-Core Version:    0.7.0.1
 */