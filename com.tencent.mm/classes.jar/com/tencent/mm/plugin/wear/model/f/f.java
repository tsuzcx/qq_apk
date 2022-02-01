package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.ecr;
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
    Object localObject = a.eKt().aFn(this.username);
    ecr localecr = new ecr();
    if (this.type == 1)
    {
      ecq localecq = new ecq();
      localecq.ukh = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localecq.nDo = this.username;
      localecq.nEt = this.nickname;
      localecq.hDa = aj.getContext().getString(2131761707);
      localObject = com.tencent.mm.ak.c.a(this.username, false, -1, null);
      if (localObject != null) {
        localecq.HOD = new b(h.as((Bitmap)localObject));
      }
      localecr.nDj.add(localecq);
    }
    try
    {
      a.eKz();
      r.a(20006, localecr.toByteArray(), true);
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