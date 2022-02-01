package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bx.b;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.gfu;
import com.tencent.mm.protocal.protobuf.gfv;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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
    AppMethodBeat.i(30126);
    Object localObject = a.inG().bhz(this.username);
    gfv localgfv = new gfv();
    if (this.type == 1)
    {
      gfu localgfu = new gfu();
      localgfu.IMf = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localgfu.UserName = this.username;
      localgfu.vhX = this.nickname;
      localgfu.nUB = MMApplicationContext.getContext().getString(R.l.gPK);
      localObject = d.a(this.username, false, -1, null);
      if (localObject != null) {
        localgfu.accH = new b(h.aU((Bitmap)localObject));
      }
      localgfv.vgO.add(localgfu);
    }
    try
    {
      a.inM();
      r.a(20006, localgfv.toByteArray(), true);
      AppMethodBeat.o(30126);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */