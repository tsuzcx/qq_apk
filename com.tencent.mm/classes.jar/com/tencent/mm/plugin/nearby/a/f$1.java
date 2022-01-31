package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ji.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.z;

final class f$1
  extends c<ji>
{
  f$1(f paramf)
  {
    AppMethodBeat.i(55374);
    this.__eventId = ji.class.getName().hashCode();
    AppMethodBeat.o(55374);
  }
  
  private static boolean a(ji paramji)
  {
    int i = 3;
    AppMethodBeat.i(55375);
    Object localObject = paramji.cyM.cyN;
    paramji = paramji.cyM.cmQ;
    if ((((bf.b)localObject).fmL != null) && (((bf.b)localObject).scene == 1))
    {
      g.RL().Ru().set(73729, Integer.valueOf(1));
      bf localbf = new bf();
      localbf.field_content = paramji.field_content;
      localbf.field_createtime = bo.aox();
      localbf.field_imgpath = "";
      localbf.field_sayhicontent = ah.getContext().getString(2131301782);
      localbf.field_sayhiuser = paramji.field_talker;
      localbf.field_scene = 18;
      if (paramji.field_status > 3) {
        i = paramji.field_status;
      }
      localbf.field_status = i;
      localbf.field_svrid = paramji.field_msgSvrId;
      localbf.field_talker = paramji.field_talker;
      localbf.field_type = 34;
      localbf.field_isSend = 0;
      localbf.field_sayhiencryptuser = paramji.field_talker;
      localbf.field_ticket = ((bf.b)localObject).fmL;
      g.RJ().QQ();
      ((bg)((j)g.E(j.class)).bPN()).a(localbf);
      localObject = new jh();
      ((jh)localObject).cyK.cyL = paramji.field_talker;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    }
    AppMethodBeat.o(55375);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f.1
 * JD-Core Version:    0.7.0.1
 */