package com.tencent.mm.plugin.story.model.a;

import a.l;
import a.v;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
public final class i$b$a
  extends ak
{
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(109243);
    a.f.b.j.q(paramMessage, "msg");
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(109243);
      return;
    }
    if (this.sxp.mcO != null)
    {
      paramMessage = this.sxp.mcO;
      if (paramMessage == null) {
        a.f.b.j.ebi();
      }
      if (!paramMessage.isEmpty()) {}
    }
    else
    {
      paramMessage = this.sxp.sxo;
      localObject1 = paramMessage.rr.adn();
      if (localObject1 == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
        AppMethodBeat.o(109243);
        throw paramMessage;
      }
      localObject1 = (cib)localObject1;
      Object localObject2 = paramMessage.rr.adm();
      if (localObject2 == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
        AppMethodBeat.o(109243);
        throw paramMessage;
      }
      localObject2 = (cia)localObject2;
      byte[] arrayOfByte = ((cib)localObject1).wFR.getBuffer().toByteArray();
      arrayOfByte = com.tencent.mm.protocal.ab.j(((cia)localObject2).wFR.getBuffer().toByteArray(), arrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        com.tencent.mm.kernel.e locale = g.RL();
        a.f.b.j.p(locale, "MMKernel.storage()");
        locale.Ru().set(8195, bo.cg(arrayOfByte));
      }
      ((cia)localObject2).wFR.setBuffer(arrayOfByte);
      if ((((cib)localObject1).wBX & ((cia)localObject2).wFQ) == 0)
      {
        localObject1 = paramMessage.callback;
        if (localObject1 == null) {
          a.f.b.j.ays("callback");
        }
        ((f)localObject1).onSceneEnd(0, 0, "", (m)paramMessage);
        AppMethodBeat.o(109243);
        return;
      }
      localObject1 = paramMessage.dispatcher();
      a.f.b.j.p(localObject1, "dispatcher()");
      localObject2 = paramMessage.callback;
      if (localObject2 == null) {
        a.f.b.j.ays("callback");
      }
      paramMessage.doScene((com.tencent.mm.network.e)localObject1, (f)localObject2);
      AppMethodBeat.o(109243);
      return;
    }
    paramMessage = this.sxp.mcO;
    if (paramMessage == null) {
      a.f.b.j.ebi();
    }
    paramMessage = (ud)paramMessage.getFirst();
    com.tencent.mm.sdk.platformtools.ab.d(i.access$getTAG$cp(), "cmdId = " + paramMessage.wMC);
    Object localObject1 = this.sxp.mcO;
    if (localObject1 == null) {
      a.f.b.j.ebi();
    }
    ((LinkedList)localObject1).removeFirst();
    switch (paramMessage.wMC)
    {
    default: 
      sendEmptyMessage(0);
      AppMethodBeat.o(109243);
      return;
    case 1: 
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new i.b.a.a(this, paramMessage));
      AppMethodBeat.o(109243);
      return;
    case 2: 
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new i.b.a.b(this, paramMessage));
      AppMethodBeat.o(109243);
      return;
    case 3: 
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new i.b.a.c(this, paramMessage));
      AppMethodBeat.o(109243);
      return;
    }
    localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.coO().post((Runnable)new i.b.a.d(this, paramMessage));
    AppMethodBeat.o(109243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.i.b.a
 * JD-Core Version:    0.7.0.1
 */