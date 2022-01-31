package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cn;
import com.tencent.tencentmap.mapsdk.a.dn;

public class kl
  extends Handler
{
  private final kx a;
  
  public kl(kx paramkx)
  {
    this.a = paramkx;
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(148965);
    super.handleMessage(paramMessage);
    if (this.a == null)
    {
      AppMethodBeat.o(148965);
      return;
    }
    cn localcn = this.a.s();
    if (localcn == null)
    {
      AppMethodBeat.o(148965);
      return;
    }
    if (this.a.q == null)
    {
      if (paramMessage.what != 0) {
        break label145;
      }
      this.a.J = false;
      this.a.K = true;
      this.a.onCameraChange(localcn);
    }
    for (;;)
    {
      if (this.a.r() != null) {
        this.a.r().e();
      }
      if (this.a.N() != null) {
        this.a.N().a(this.a.S(), this.a.b().e());
      }
      AppMethodBeat.o(148965);
      return;
      label145:
      if (paramMessage.what == 1)
      {
        this.a.J = true;
        if ((this.a.J) && (this.a.L == 0))
        {
          this.a.K = false;
          this.a.onCameraChangeFinished(localcn);
        }
        if ((this.a.k != null) && (this.a.H)) {
          this.a.k.a();
        }
        this.a.b().D();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kl
 * JD-Core Version:    0.7.0.1
 */