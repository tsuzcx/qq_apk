package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.sdk.platformtools.ai;
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
    Object localObject = a.ewn().aAd(this.username);
    dwr localdwr = new dwr();
    if (this.type == 1)
    {
      dwq localdwq = new dwq();
      localdwq.tlI = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localdwq.ncR = this.username;
      localdwq.ndW = this.nickname;
      localdwq.hkR = ai.getContext().getString(2131761707);
      localObject = com.tencent.mm.aj.c.a(this.username, false, -1, null);
      if (localObject != null) {
        localdwq.Gdx = new b(h.aq((Bitmap)localObject));
      }
      localdwr.ncM.add(localdwq);
    }
    try
    {
      a.ewt();
      r.a(20006, localdwr.toByteArray(), true);
      AppMethodBeat.o(30126);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(30126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.f
 * JD-Core Version:    0.7.0.1
 */