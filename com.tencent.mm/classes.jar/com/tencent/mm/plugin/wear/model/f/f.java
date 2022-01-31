package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cji;
import com.tencent.mm.protocal.c.cjj;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.LinkedList;

public final class f
  extends c
{
  private String nickname;
  private int type;
  private String username;
  
  public f(String paramString1, String paramString2, int paramInt)
  {
    this.username = paramString1;
    this.nickname = paramString2;
    this.type = paramInt;
  }
  
  public final String getName()
  {
    return "WearFriendCreateTask";
  }
  
  protected final void send()
  {
    Object localObject = a.bYL().qRw.Re(this.username);
    cjj localcjj = new cjj();
    if (this.type == 1)
    {
      cji localcji = new cji();
      localcji.kWl = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localcji.hPY = this.username;
      localcji.hRf = this.nickname;
      localcji.kVs = ae.getContext().getString(R.l.notification_receive_new_friend);
      localObject = com.tencent.mm.ag.b.a(this.username, false, -1);
      if (localObject != null) {
        localcji.tXh = new com.tencent.mm.bv.b(h.P((Bitmap)localObject));
      }
      localcjj.hPT.add(localcji);
    }
    try
    {
      a.bYL();
      r.b(20006, localcjj.toByteArray(), true);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */