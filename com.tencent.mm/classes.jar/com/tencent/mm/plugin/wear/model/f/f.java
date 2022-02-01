package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.sdk.platformtools.aj;
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
    Object localObject = a.egT().auM(this.username);
    dra localdra = new dra();
    if (this.type == 1)
    {
      dqz localdqz = new dqz();
      localdqz.sdO = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localdqz.mAQ = this.username;
      localdqz.mBV = this.nickname;
      localdqz.gKr = aj.getContext().getString(2131761707);
      localObject = com.tencent.mm.ak.c.a(this.username, false, -1, null);
      if (localObject != null) {
        localdqz.EGl = new b(h.ap((Bitmap)localObject));
      }
      localdra.mAL.add(localdqz);
    }
    try
    {
      a.egZ();
      r.a(20006, localdra.toByteArray(), true);
      AppMethodBeat.o(30126);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */