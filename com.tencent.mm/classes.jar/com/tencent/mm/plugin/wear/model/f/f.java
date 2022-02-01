package com.tencent.mm.plugin.wear.model.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eeh;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.sdk.platformtools.ak;
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
    Object localObject = a.eOb().aGH(this.username);
    eei localeei = new eei();
    if (this.type == 1)
    {
      eeh localeeh = new eeh();
      localeeh.uvE = ((com.tencent.mm.plugin.wear.model.f)localObject).id;
      localeeh.nIJ = this.username;
      localeeh.nJO = this.nickname;
      localeeh.hFS = ak.getContext().getString(2131761707);
      localObject = com.tencent.mm.aj.c.a(this.username, false, -1, null);
      if (localObject != null) {
        localeeh.IiK = new b(h.at((Bitmap)localObject));
      }
      localeei.nIE.add(localeeh);
    }
    try
    {
      a.eOh();
      r.a(20006, localeei.toByteArray(), true);
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