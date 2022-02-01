package com.tencent.thumbplayer.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.e;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo;
import com.tencent.thumbplayer.f.a;
import java.lang.ref.WeakReference;

final class b$a
  extends Handler
{
  private WeakReference<b> vvs;
  
  public b$a(b paramb1, Looper paramLooper, b paramb2)
  {
    super(paramLooper);
    AppMethodBeat.i(228757);
    this.vvs = new WeakReference(paramb2);
    AppMethodBeat.o(228757);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(228760);
    if ((b)this.vvs.get() == null)
    {
      this.ahFY.ahDA.error("mWeakRef is null");
      AppMethodBeat.o(228760);
      return;
    }
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      this.ahFY.ahDA.bGf("message :" + paramMessage.what + "  not recognition");
      AppMethodBeat.o(228760);
      return;
    case 1: 
      paramMessage = (b.b)paramMessage.obj;
      switch (paramMessage.ahFZ)
      {
      default: 
        this.ahFY.ahFQ.a(com.tencent.thumbplayer.a.b.b.b.aHD(paramMessage.ahFZ), paramMessage.hDx, paramMessage.errorCode, Long.valueOf(paramMessage.ahDx));
        AppMethodBeat.o(228760);
        return;
      case 1: 
        this.ahFY.ahFQ.Qz();
        AppMethodBeat.o(228760);
        return;
      }
      this.ahFY.ahFQ.dEH();
      AppMethodBeat.o(228760);
      return;
    case 2: 
      paramMessage = (b.d)paramMessage.obj;
      switch (paramMessage.infoType)
      {
      default: 
        localObject = this.ahFY;
        i = paramMessage.infoType;
        j = com.tencent.thumbplayer.a.b.b.b.aHD(i);
        if (j < 0)
        {
          ((b)localObject).ahDA.bGf("msgType:" + i + ", cannot convert to thumbPlayer Info");
          AppMethodBeat.o(228760);
          return;
        }
        break;
      case 250: 
        localObject = this.ahFY;
        l1 = paramMessage.lParam1;
        l2 = paramMessage.ahGa;
        ((b)localObject).ahFQ.bN(l1, l2);
        AppMethodBeat.o(228760);
        return;
      case 154: 
        this.ahFY.ahFQ.onCompletion();
        AppMethodBeat.o(228760);
        return;
      }
      long l1 = paramMessage.lParam1;
      long l2 = paramMessage.ahGa;
      switch (j)
      {
      }
      for (;;)
      {
        ((b)localObject).ahFQ.a(j, l1, l2, null);
        AppMethodBeat.o(228760);
        return;
        l1 = c.aHy((int)paramMessage.lParam1);
      }
    case 3: 
      b.e locale = (b.e)paramMessage.obj;
      b localb;
      switch (locale.infoType)
      {
      default: 
        localb = this.ahFY;
        i = locale.infoType;
        j = com.tencent.thumbplayer.a.b.b.b.aHD(i);
        if (j < 0)
        {
          localb.ahDA.bGf("msgType:" + i + ", cannot convert to thumbPlayer Info");
          AppMethodBeat.o(228760);
          return;
        }
        break;
      case 502: 
        if (!(locale.ahGb instanceof String)) {
          break label635;
        }
        this.ahFY.ahFS.subtitleData = ((String)locale.ahGb);
        this.ahFY.ahFQ.a(this.ahFY.ahFS);
        AppMethodBeat.o(228760);
        return;
      }
      localObject = locale.ahGb;
      paramMessage = (Message)localObject;
      switch (j)
      {
      default: 
        paramMessage = (Message)localObject;
      }
      for (;;)
      {
        localb.ahFQ.a(j, 0L, 0L, paramMessage);
        label635:
        AppMethodBeat.o(228760);
        return;
        paramMessage = (Message)localObject;
        if (locale.ahGb != null)
        {
          paramMessage = c.a((ITPNativePlayerMessageCallback.VideoCropInfo)locale.ahGb);
          continue;
          paramMessage = (Message)localObject;
          if (locale.ahGb != null)
          {
            paramMessage = c.a((ITPNativePlayerMessageCallback.MediaCodecInfo)locale.ahGb);
            continue;
            paramMessage = (Message)localObject;
            if (locale.ahGb != null) {
              paramMessage = c.a((ITPNativePlayerMessageCallback.VideoSeiInfo)locale.ahGb);
            }
          }
        }
      }
    }
    paramMessage = (b.c)paramMessage.obj;
    int i = paramMessage.msgType;
    int j = paramMessage.errorCode;
    this.ahFY.ahFQ.a(com.tencent.thumbplayer.a.b.b.b.aHC(i), j, 0L, 0L);
    AppMethodBeat.o(228760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */