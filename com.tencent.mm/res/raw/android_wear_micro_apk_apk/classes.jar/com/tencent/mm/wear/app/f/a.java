package com.tencent.mm.wear.app.f;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.a.c;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;

public final class a
  extends com.tencent.mm.wear.app.g.a
{
  private int aaO;
  private String aas;
  
  public a(int paramInt, String paramString)
  {
    this.aas = paramString;
    this.aaO = paramInt;
  }
  
  protected final void execute()
  {
    if (this.aaO == 11003) {
      d.nK();
    }
    MMApplication.getContext();
    String str = String.format("/wechat/%s/channel/%d/%d", new Object[] { "wear", Integer.valueOf(this.aaO), Long.valueOf(System.currentTimeMillis()) });
    d.c("MicroMsg.ChannelTask", "%s", new Object[] { h.mb().lS().l(str, this.aas) });
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