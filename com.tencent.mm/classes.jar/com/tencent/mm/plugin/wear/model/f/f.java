package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.d;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fjg;
import com.tencent.mm.protocal.protobuf.fjh;
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
  
  protected final void gOA()
  {
    AppMethodBeat.i(30126);
    Object localObject = a.gOr().bhQ(this.username);
    fjh localfjh = new fjh();
    if (this.type == 1)
    {
      fjg localfjg = new fjg();
      localfjg.CRP = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localfjg.UserName = this.username;
      localfjg.rWI = this.nickname;
      localfjg.lpy = MMApplicationContext.getContext().getString(R.l.eNx);
      localObject = d.a(this.username, false, -1, null);
      if (localObject != null) {
        localfjg.UIy = new b(h.aC((Bitmap)localObject));
      }
      localfjh.rVy.add(localfjg);
    }
    try
    {
      a.gOx();
      r.a(20006, localfjh.toByteArray(), true);
      AppMethodBeat.o(30126);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30126);
    }
  }
  
  public final String getName()
  {
    return "WearFriendCreateTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */