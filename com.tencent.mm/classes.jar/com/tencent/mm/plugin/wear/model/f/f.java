package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.sdk.platformtools.ah;
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
    AppMethodBeat.i(26444);
    Object localObject = a.cYy().uGE.agb(this.username);
    cww localcww = new cww();
    if (this.type == 1)
    {
      cwv localcwv = new cwv();
      localcwv.nuk = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localcwv.jJA = this.username;
      localcwv.jKG = this.nickname;
      localcwv.ntu = ah.getContext().getString(2131301945);
      localObject = com.tencent.mm.ah.b.b(this.username, false, -1);
      if (localObject != null) {
        localcwv.yeB = new com.tencent.mm.bv.b(h.ad((Bitmap)localObject));
      }
      localcww.jJv.add(localcwv);
    }
    try
    {
      a.cYy();
      r.a(20006, localcww.toByteArray(), true);
      AppMethodBeat.o(26444);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(26444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */