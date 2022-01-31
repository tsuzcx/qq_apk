package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.na;
import com.tencent.tencentmap.mapsdk.maps.a.ne;
import com.tencent.tencentmap.mapsdk.maps.a.nf;
import com.tencent.tencentmap.mapsdk.maps.a.ng;

class bg$1
  extends Handler
{
  bg$1(bg parambg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(149841);
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramMessage = (nf)paramMessage.obj;
      if (paramMessage.a == 0)
      {
        if (bg.a(this.a) != null)
        {
          bg.a(this.a).a(paramMessage.b, paramMessage.c);
          AppMethodBeat.o(149841);
        }
      }
      else if (paramMessage.a == 1)
      {
        if (bg.b(this.a) != null)
        {
          bg.b(this.a).a(paramMessage.d, paramMessage.e);
          bg.b(this.a).g();
          AppMethodBeat.o(149841);
        }
      }
      else if ((paramMessage.a == 3) && (ka.f == 1))
      {
        if (TextUtils.equals("wechat", "wechat"))
        {
          AppMethodBeat.o(149841);
          return;
        }
        if (bg.c(this.a) == null)
        {
          AppMethodBeat.o(149841);
          return;
        }
        if (bg.d(this.a) == null)
        {
          bg.a(this.a, new na(bg.c(this.a).getContext().getApplicationContext()));
          bg.d(this.a).a(bg.e(this.a));
        }
        bg.d(this.a).a(bg.c(this.a));
      }
    }
    AppMethodBeat.o(149841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bg.1
 * JD-Core Version:    0.7.0.1
 */