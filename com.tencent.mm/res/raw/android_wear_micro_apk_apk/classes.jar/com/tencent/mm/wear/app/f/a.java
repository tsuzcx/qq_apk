package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.a.c;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;

public final class a
  extends com.tencent.mm.wear.app.g.a
{
  private String adT;
  private int aep;
  
  public a(int paramInt, String paramString)
  {
    this.adT = paramString;
    this.aep = paramInt;
  }
  
  protected final void execute()
  {
    if (this.aep == 11003) {
      d.oy();
    }
    MMApplication.getContext();
    String str = String.format("/wechat/%s/channel/%d/%d", new Object[] { "wear", Integer.valueOf(this.aep), Long.valueOf(System.currentTimeMillis()) });
    d.c("MicroMsg.ChannelTask", "%s", new Object[] { h.mO().mF().m(str, this.adT) });
  }
  
  protected final String getName()
  {
    return "ChannelTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.f.a
 * JD-Core Version:    0.7.0.1
 */